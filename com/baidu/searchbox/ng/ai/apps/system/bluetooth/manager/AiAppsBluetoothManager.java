package com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelUuid;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.baidu.ar.util.APIUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.BluetoothStatusCallback;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.model.BluetoothDeviceData;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.AiAppsBluetoothConstants;
import com.baidu.searchbox.ng.ai.apps.system.bluetooth.utils.BluetoothUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppsBluetoothManager implements IBluetoothManager {
    private static final boolean DEBUG = false;
    private static final String EXECUTE_NAME = "start scan bluetooth in ai apps";
    private static final String KEY_AVAILABLE = "available";
    private static final String KEY_DISCOVERING = "discovering";
    private static final String KEY_ERROR_CODE = "errCode";
    private static final String KEY_ERROR_MSG = "errMsg";
    private static final String MODULE_TAG = "bluetooth";
    private static int MSG_TIME_OUT = 1;
    private static final String TAG = "BluetoothManager";
    private static volatile AiAppsBluetoothManager instance;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeScanner mBluetoothLeScanner;
    private BluetoothStatusCallback mBluetoothStatusCallback;
    private Map<BluetoothDeviceData, BluetoothGatt> mConnectDevices;
    private Context mContext;
    private Map<String, BluetoothDeviceData> mHasReportDevices;
    private boolean mIsDiscovery;
    private boolean mIsOpen;
    private boolean mIsRegistered;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private Map<String, BluetoothDeviceData> mNotReportDevices;
    private ScanCallback mScanCallback;
    private long mLastReportDeviceFoundTime = 0;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BluetoothGatt bluetoothGatt;
            if (message.what == AiAppsBluetoothManager.MSG_TIME_OUT && AiAppsBluetoothManager.this.isAdapterAvailable() && AiAppsBluetoothManager.this.mBluetoothStatusCallback != null && (bluetoothGatt = (BluetoothGatt) message.obj) != null) {
                bluetoothGatt.disconnect();
                bluetoothGatt.close();
                AiAppsBluetoothManager.this.mBluetoothStatusCallback.dispatchCallback(AiAppsBluetoothManager.this.mBluetoothStatusCallback.createBLEConnectionCallback, AiAppsBluetoothManager.this.createCallBackMsg(10003, AiAppsBluetoothConstants.ERROR_CONNECTION_FAIL));
            }
        }
    };
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() { // from class: com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action == "android.bluetooth.adapter.action.STATE_CHANGED") {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
                if (intExtra == 12) {
                    AiAppsLog.i(AiAppsBluetoothManager.MODULE_TAG, "broadcast -- adapter state on");
                    AiAppsBluetoothManager.this.reportStateChangeMsg();
                } else if (intExtra == 10) {
                    AiAppsLog.i(AiAppsBluetoothManager.MODULE_TAG, "broadcast -- adapter state off");
                    if (AiAppsBluetoothManager.this.mIsDiscovery) {
                        AiAppsBluetoothManager.this.mIsDiscovery = false;
                    }
                    AiAppsBluetoothManager.this.reportStateChangeMsg();
                }
            }
        }
    };

    private AiAppsBluetoothManager() {
    }

    public static AiAppsBluetoothManager getInstance() {
        if (instance == null) {
            synchronized (AiAppsBluetoothManager.class) {
                if (instance == null) {
                    instance = new AiAppsBluetoothManager();
                }
            }
        }
        return instance;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject openBluetoothAdapter(Context context, BluetoothStatusCallback bluetoothStatusCallback) {
        if (context == null) {
            realRelease();
            return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
        }
        this.mContext = context;
        this.mBluetoothStatusCallback = bluetoothStatusCallback;
        if (!this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            AiAppsLog.w(MODULE_TAG, "openAdapter --  context == null");
            realRelease();
            return createCallBackMsg(10001, AiAppsBluetoothConstants.ERROR_NOT_AVAILABLE);
        }
        if (this.mBluetoothAdapter == null) {
            this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        if (this.mBluetoothAdapter == null || !this.mBluetoothAdapter.isEnabled()) {
            AiAppsLog.w(MODULE_TAG, "openAdapter -- adapter not available");
            if (this.mBluetoothAdapter == null) {
                realRelease();
            }
            return createCallBackMsg(10001, AiAppsBluetoothConstants.ERROR_NOT_AVAILABLE);
        } else if (this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "openAdapter -- hasOpen");
            return createCallBackMsg(0, "ok");
        } else {
            this.mHasReportDevices = new ConcurrentHashMap();
            this.mNotReportDevices = new ConcurrentHashMap();
            this.mConnectDevices = new ConcurrentHashMap();
            registerBluetoothActionReceiver();
            this.mIsOpen = true;
            AiAppsLog.i(MODULE_TAG, "openAdapter -- open success");
            return createCallBackMsg(0, "ok");
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    @RequiresApi(api = 21)
    public JSONObject closeBluetoothAdapter() {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "closeAdapter -- is not open");
            return createCallBackMsg(0, "ok");
        }
        unRegisterBluetoothActionReceiver();
        JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
        realRelease();
        AiAppsLog.i(MODULE_TAG, "closeAdapter --- close success");
        return createCallBackMsg;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public JSONObject getBluetoothAdapterState() {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "getAdapterState -- is not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        }
        JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
        try {
            createCallBackMsg.putOpt(KEY_DISCOVERING, Boolean.valueOf(this.mIsDiscovery));
            createCallBackMsg.putOpt(KEY_AVAILABLE, Boolean.valueOf(isAdapterAvailable()));
            return createCallBackMsg;
        } catch (JSONException e) {
            return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public boolean isAdapterAvailable() {
        if (!this.mIsOpen || this.mBluetoothAdapter == null) {
            return false;
        }
        return this.mBluetoothAdapter.isEnabled();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    @RequiresApi(api = 21)
    public JSONObject startBluetoothDevicesDiscovery(UUID[] uuidArr, boolean z, int i) {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "start discovery -- is not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        } else if (!isAdapterAvailable()) {
            AiAppsLog.w(MODULE_TAG, "start discovery -- adapter not available");
            return createCallBackMsg(10001, AiAppsBluetoothConstants.ERROR_NOT_AVAILABLE);
        } else {
            if (this.mIsDiscovery) {
                stopBluetoothDevicesDiscovery();
            }
            AiAppsLog.i(MODULE_TAG, "start discovery -- success");
            if (APIUtils.hasLollipop()) {
                return startScanBleHasLollipop(uuidArr, z, i);
            }
            return startScanBle(uuidArr, z, i);
        }
    }

    @TargetApi(21)
    private JSONObject startScanBleHasLollipop(UUID[] uuidArr, final boolean z, final int i) {
        if (!isAdapterAvailable()) {
            return createCallBackMsg(10001, AiAppsBluetoothConstants.ERROR_NOT_AVAILABLE);
        }
        if (!this.mIsDiscovery) {
            this.mIsDiscovery = true;
            reportStateChangeMsg();
        }
        this.mBluetoothLeScanner = this.mBluetoothAdapter.getBluetoothLeScanner();
        if (uuidArr != null && uuidArr.length > 0) {
            final ArrayList arrayList = new ArrayList();
            for (UUID uuid : uuidArr) {
                arrayList.add(new ScanFilter.Builder().setServiceUuid(new ParcelUuid(uuid)).build());
            }
            startDiscoveryOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager.3
                @Override // java.lang.Runnable
                @SuppressLint({"MissingPermission"})
                public void run() {
                    AiAppsBluetoothManager.this.mBluetoothLeScanner.startScan(arrayList, new ScanSettings.Builder().build(), AiAppsBluetoothManager.this.getScanCallback(true, z, i));
                }
            });
            return createCallBackMsg(0, "ok");
        }
        startDiscoveryOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager.4
            @Override // java.lang.Runnable
            @SuppressLint({"MissingPermission"})
            public void run() {
                AiAppsBluetoothManager.this.mBluetoothLeScanner.startScan(AiAppsBluetoothManager.this.getScanCallback(true, z, i));
            }
        });
        return createCallBackMsg(0, "ok");
    }

    private void startDiscoveryOnIO(Runnable runnable) {
        AiAppExecutorUtils.postOnIO(runnable, EXECUTE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    public ScanCallback getScanCallback(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.mScanCallback;
        }
        this.mScanCallback = new ScanCallback() { // from class: com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager.5
            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int i2, ScanResult scanResult) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(scanResult);
                AiAppsBluetoothManager.this.handleScanResultHasLollipop(arrayList, z2, i);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> list) {
                if (list != null && list.size() > 0) {
                    AiAppsBluetoothManager.this.handleScanResultHasLollipop(list, z2, i);
                }
            }
        };
        return this.mScanCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    @TargetApi(21)
    public void handleScanResultHasLollipop(List<ScanResult> list, boolean z, int i) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (ScanResult scanResult : list) {
                if (scanResult != null && scanResult.getScanRecord() != null && scanResult.getDevice() != null) {
                    BluetoothDeviceData bluetoothDeviceData = new BluetoothDeviceData();
                    bluetoothDeviceData.name = scanResult.getDevice().getName();
                    bluetoothDeviceData.deviceId = scanResult.getDevice().getAddress();
                    bluetoothDeviceData.rssi = scanResult.getRssi();
                    bluetoothDeviceData.manufacturerSpecificData = getManufactureList(scanResult);
                    bluetoothDeviceData.serviceUuids = scanResult.getScanRecord().getServiceUuids();
                    bluetoothDeviceData.localName = scanResult.getScanRecord().getDeviceName();
                    bluetoothDeviceData.serviceData = scanResult.getScanRecord().getServiceData();
                    bluetoothDeviceData.device = scanResult.getDevice();
                    arrayList.add(bluetoothDeviceData);
                }
            }
            reportScanResult(arrayList, z, i);
        }
    }

    @TargetApi(21)
    private List<byte[]> getManufactureList(ScanResult scanResult) {
        if (scanResult == null || scanResult.getScanRecord() == null) {
            return null;
        }
        SparseArray<byte[]> manufacturerSpecificData = scanResult.getScanRecord().getManufacturerSpecificData();
        ArrayList arrayList = new ArrayList();
        int size = manufacturerSpecificData.size();
        for (int i = 0; i < size; i++) {
            byte[] valueAt = manufacturerSpecificData.valueAt(i);
            int keyAt = manufacturerSpecificData.keyAt(i);
            int length = valueAt.length;
            byte[] intToBytes = BluetoothUtils.intToBytes(keyAt);
            int length2 = intToBytes.length;
            byte[] bArr = new byte[length + length2];
            System.arraycopy(intToBytes, 0, bArr, 0, length2);
            System.arraycopy(valueAt, 0, bArr, length2, length);
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private JSONObject startScanBle(final UUID[] uuidArr, final boolean z, final int i) {
        if (!isAdapterAvailable()) {
            return createCallBackMsg(10001, AiAppsBluetoothConstants.ERROR_NOT_AVAILABLE);
        }
        if (!this.mIsDiscovery) {
            this.mIsDiscovery = true;
            reportStateChangeMsg();
        }
        startDiscoveryOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager.6
            @Override // java.lang.Runnable
            @SuppressLint({"MissingPermission"})
            public void run() {
                AiAppsBluetoothManager.this.mBluetoothAdapter.startLeScan(uuidArr, AiAppsBluetoothManager.this.getLeScanCallback(true, z, i));
            }
        });
        return createCallBackMsg(0, "ok");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScanResult(BluetoothDevice bluetoothDevice, int i, byte[] bArr, boolean z, int i2) {
        BluetoothDeviceData createDeviceData;
        if (bluetoothDevice != null && bArr != null && (createDeviceData = BluetoothUtils.createDeviceData(bluetoothDevice, i, bArr)) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(createDeviceData);
            reportScanResult(arrayList, z, i2);
        }
    }

    private void reportScanResult(List<BluetoothDeviceData> list, boolean z, int i) {
        if (list != null) {
            for (BluetoothDeviceData bluetoothDeviceData : list) {
                if (bluetoothDeviceData != null && bluetoothDeviceData.device != null && !TextUtils.isEmpty(bluetoothDeviceData.deviceId) && (z || this.mHasReportDevices == null || !this.mHasReportDevices.containsKey(bluetoothDeviceData.deviceId))) {
                    if (this.mNotReportDevices != null) {
                        this.mNotReportDevices.put(bluetoothDeviceData.deviceId, bluetoothDeviceData);
                    }
                }
            }
            if (System.currentTimeMillis() - this.mLastReportDeviceFoundTime >= i && this.mNotReportDevices != null && this.mNotReportDevices.size() != 0) {
                this.mLastReportDeviceFoundTime = System.currentTimeMillis();
                JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, BluetoothDeviceData> entry : this.mNotReportDevices.entrySet()) {
                    if ((entry.getValue() instanceof BluetoothDeviceData) && (entry.getKey() instanceof String)) {
                        BluetoothDeviceData value = entry.getValue();
                        jSONArray.put(value.toJson());
                        String key = entry.getKey();
                        this.mNotReportDevices.remove(key);
                        if (this.mHasReportDevices == null) {
                            this.mHasReportDevices = new ConcurrentHashMap();
                        }
                        this.mHasReportDevices.put(key, value);
                    }
                }
                try {
                    createCallBackMsg.put(AiAppsBluetoothConstants.GET_FOUND_DEVICES_KEY, jSONArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                AiAppsLog.i(MODULE_TAG, "report discovery result -- result : " + createCallBackMsg.toString());
                if (this.mBluetoothStatusCallback != null) {
                    this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.deviceFoundCallback, createCallBackMsg);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BluetoothAdapter.LeScanCallback getLeScanCallback(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.mLeScanCallback;
        }
        this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager.7
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                AiAppsBluetoothManager.this.handleScanResult(bluetoothDevice, i2, bArr, z2, i);
            }
        };
        return this.mLeScanCallback;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject stopBluetoothDevicesDiscovery() {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "stop discovery -- is not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        } else if (!isAdapterAvailable()) {
            AiAppsLog.w(MODULE_TAG, "stop discovery -- is not available");
            return createCallBackMsg(10001, AiAppsBluetoothConstants.ERROR_NOT_AVAILABLE);
        } else if (!this.mIsDiscovery) {
            AiAppsLog.w(MODULE_TAG, "stop discovery -- is not discovery");
            return createCallBackMsg(0, "ok");
        } else {
            if (APIUtils.hasLollipop()) {
                if (this.mBluetoothLeScanner != null) {
                    AiAppsLog.i(MODULE_TAG, "stop discovery -- stop success");
                    if (this.mIsDiscovery) {
                        this.mIsDiscovery = false;
                        reportStateChangeMsg();
                    }
                    this.mBluetoothLeScanner.stopScan(getScanCallback(false, true, 0));
                    return createCallBackMsg(0, "ok");
                }
            } else if (this.mBluetoothAdapter != null) {
                AiAppsLog.i(MODULE_TAG, "stop discovery -- stop success");
                if (this.mIsDiscovery) {
                    this.mIsDiscovery = false;
                    reportStateChangeMsg();
                }
                this.mBluetoothAdapter.stopLeScan(getLeScanCallback(false, true, 0));
                return createCallBackMsg(0, "ok");
            }
            return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public JSONObject getBluetoothDevices() {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "get Devices -- is not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        }
        JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
        if (this.mHasReportDevices != null && (createCallBackMsg = addDeviceJson(createCallBackMsg, this.mHasReportDevices)) == null) {
            return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
        }
        if (this.mNotReportDevices != null && (createCallBackMsg = addDeviceJson(createCallBackMsg, this.mNotReportDevices)) == null) {
            return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
        }
        AiAppsLog.i(MODULE_TAG, "get Devices -- result : " + createCallBackMsg.toString());
        return createCallBackMsg;
    }

    private JSONObject addDeviceJson(JSONObject jSONObject, Map<String, BluetoothDeviceData> map) {
        JSONArray jSONArray;
        try {
            if (!jSONObject.has(AiAppsBluetoothConstants.GET_FOUND_DEVICES_KEY)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = jSONObject.getJSONArray(AiAppsBluetoothConstants.GET_FOUND_DEVICES_KEY);
            }
            if (map == null) {
                jSONObject.put(AiAppsBluetoothConstants.GET_FOUND_DEVICES_KEY, jSONArray);
                return jSONObject;
            }
            for (Map.Entry<String, BluetoothDeviceData> entry : map.entrySet()) {
                if (entry.getValue() instanceof BluetoothDeviceData) {
                    jSONArray.put(entry.getValue().toJson());
                }
            }
            jSONObject.put(AiAppsBluetoothConstants.GET_FOUND_DEVICES_KEY, jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public JSONObject getConnectedBluetoothDevices(UUID[] uuidArr) {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "get connected ble -- not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        } else if (this.mConnectDevices == null) {
            AiAppsLog.w(MODULE_TAG, "get connected ble -- connect device is null");
            return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
        } else {
            JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
            try {
                JSONArray jSONArray = new JSONArray();
                if (this.mConnectDevices == null) {
                    createCallBackMsg.put(AiAppsBluetoothConstants.KEY_SERVICES, jSONArray);
                    return createCallBackMsg;
                }
                for (BluetoothDeviceData bluetoothDeviceData : this.mConnectDevices.keySet()) {
                    if (bluetoothDeviceData instanceof BluetoothDeviceData) {
                        BluetoothDeviceData bluetoothDeviceData2 = bluetoothDeviceData;
                        if (bluetoothDeviceData2.isRightDevice(uuidArr)) {
                            jSONArray.put(bluetoothDeviceData2.toSimpleJson());
                        }
                    }
                }
                createCallBackMsg.put(AiAppsBluetoothConstants.GET_FOUND_DEVICES_KEY, jSONArray);
                AiAppsLog.i(MODULE_TAG, "get connected ble -- result : " + createCallBackMsg.toString());
                return createCallBackMsg;
            } catch (JSONException e) {
                return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public void createBLEConnection(final String str, long j) {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "create ble connection -- not open");
            if (this.mBluetoothStatusCallback != null) {
                this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.createBLEConnectionCallback, createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT));
            }
        } else if (this.mContext == null) {
            if (this.mBluetoothStatusCallback != null) {
                this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.createBLEConnectionCallback, createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT));
            }
        } else {
            final BluetoothDeviceData bluetoothDeviceData = null;
            if (this.mHasReportDevices != null) {
                bluetoothDeviceData = this.mHasReportDevices.get(str);
            }
            if (bluetoothDeviceData == null && this.mNotReportDevices != null) {
                bluetoothDeviceData = this.mNotReportDevices.get(str);
            }
            if (bluetoothDeviceData == null) {
                if (this.mBluetoothStatusCallback != null) {
                    this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.createBLEConnectionCallback, createCallBackMsg(10003, AiAppsBluetoothConstants.ERROR_CONNECTION_FAIL));
                    return;
                }
                return;
            }
            handleTimeout(bluetoothDeviceData.device.connectGatt(this.mContext, true, new BluetoothGattCallback() { // from class: com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.AiAppsBluetoothManager.8
                @Override // android.bluetooth.BluetoothGattCallback
                public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                    if (bluetoothGatt != null && bluetoothGatt.getDevice() != null) {
                        if (i2 == 2) {
                            bluetoothGatt.discoverServices();
                            AiAppsLog.i(AiAppsBluetoothManager.MODULE_TAG, "onConnectionStateChange -- connected");
                        } else if (i2 == 0) {
                            if (AiAppsBluetoothManager.this.mConnectDevices != null && AiAppsBluetoothManager.this.mConnectDevices.containsKey(bluetoothDeviceData)) {
                                AiAppsBluetoothManager.this.mConnectDevices.remove(bluetoothDeviceData);
                            }
                            AiAppsLog.i(AiAppsBluetoothManager.MODULE_TAG, "onConnectionStateChange -- disconnected");
                            AiAppsBluetoothManager.this.reportConnectionStateChangeMsg(str, false);
                        }
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                    if (i == 0) {
                        if (AiAppsBluetoothManager.this.mConnectDevices != null) {
                            AiAppsBluetoothManager.this.mConnectDevices.put(bluetoothDeviceData, bluetoothGatt);
                        }
                        if (bluetoothGatt != null) {
                            AiAppsBluetoothManager.this.mHandler.removeMessages(AiAppsBluetoothManager.MSG_TIME_OUT, bluetoothGatt);
                        }
                        if (AiAppsBluetoothManager.this.mBluetoothStatusCallback != null && AiAppsBluetoothManager.this.mIsOpen) {
                            AiAppsLog.i(AiAppsBluetoothManager.MODULE_TAG, "onConnectionStateChange -- connected");
                            AiAppsBluetoothManager.this.reportConnectionStateChangeMsg(str, true);
                            AiAppsBluetoothManager.this.mBluetoothStatusCallback.dispatchCallback(AiAppsBluetoothManager.this.mBluetoothStatusCallback.createBLEConnectionCallback, AiAppsBluetoothManager.this.createCallBackMsg(0, "ok"));
                        }
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                    if (i == 0) {
                        AiAppsLog.i(AiAppsBluetoothManager.MODULE_TAG, "on characteristic read -- connected");
                        AiAppsBluetoothManager.this.handleCharacteristicValueChange(bluetoothGatt, bluetoothGattCharacteristic);
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                    if (i == 0) {
                        if (AiAppsBluetoothManager.this.mBluetoothStatusCallback != null) {
                            AiAppsBluetoothManager.this.mBluetoothStatusCallback.dispatchCallback(AiAppsBluetoothManager.this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, AiAppsBluetoothManager.this.createCallBackMsg(0, "ok"));
                        }
                    } else if (AiAppsBluetoothManager.this.mBluetoothStatusCallback != null) {
                        AiAppsBluetoothManager.this.mBluetoothStatusCallback.dispatchCallback(AiAppsBluetoothManager.this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, AiAppsBluetoothManager.this.createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR));
                    }
                }

                @Override // android.bluetooth.BluetoothGattCallback
                public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                    AiAppsLog.i(AiAppsBluetoothManager.MODULE_TAG, "on characteristic change");
                    AiAppsBluetoothManager.this.handleCharacteristicValueChange(bluetoothGatt, bluetoothGattCharacteristic);
                }
            }), j);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public JSONObject closeBLEConnection(String str) {
        BluetoothDeviceData bluetoothDeviceData = null;
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "close connection --- not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        } else if (this.mConnectDevices == null) {
            AiAppsLog.w(MODULE_TAG, "close connection --- none connect devices");
            return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
        } else {
            Iterator<BluetoothDeviceData> it = this.mConnectDevices.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BluetoothDeviceData next = it.next();
                if (next instanceof BluetoothDeviceData) {
                    BluetoothDeviceData bluetoothDeviceData2 = next;
                    if (TextUtils.equals(bluetoothDeviceData2.deviceId, str)) {
                        bluetoothDeviceData = bluetoothDeviceData2;
                        break;
                    }
                }
            }
            if (bluetoothDeviceData == null) {
                AiAppsLog.w(MODULE_TAG, "close connection --- can't find device");
                return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
            }
            BluetoothGatt bluetoothGatt = this.mConnectDevices.get(bluetoothDeviceData);
            if (bluetoothGatt == null) {
                this.mConnectDevices.remove(bluetoothDeviceData);
                AiAppsLog.w(MODULE_TAG, "close connection --- none gatt");
                return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
            }
            AiAppsLog.i(MODULE_TAG, "close connection --- success");
            bluetoothGatt.close();
            this.mConnectDevices.remove(bluetoothDeviceData);
            return createCallBackMsg(0, "ok");
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public JSONObject getBLEDeviceServices(String str) {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "get ble services --- not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        } else if (this.mConnectDevices == null) {
            AiAppsLog.w(MODULE_TAG, "get ble services --- none connect devices");
            return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
        } else {
            BluetoothDeviceData deviceDataByDeviceId = getDeviceDataByDeviceId(str);
            if (deviceDataByDeviceId == null) {
                return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
            }
            BluetoothGatt bluetoothGatt = this.mConnectDevices.get(deviceDataByDeviceId);
            if (bluetoothGatt == null) {
                this.mConnectDevices.remove(deviceDataByDeviceId);
                AiAppsLog.w(MODULE_TAG, "get ble services --- none gatt");
                return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
            }
            JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
            try {
                JSONArray jSONArray = new JSONArray();
                List<ParcelUuid> list = deviceDataByDeviceId.serviceUuids;
                if (list != null) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        JSONObject jSONObject = new JSONObject();
                        ParcelUuid parcelUuid = list.get(i);
                        if (parcelUuid != null) {
                            jSONObject.putOpt("uuid", parcelUuid.toString());
                            jSONObject.putOpt(AiAppsBluetoothConstants.KEY_IS_PRIMARY, true);
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                List<BluetoothGattService> services = bluetoothGatt.getServices();
                if (services != null) {
                    int size2 = services.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        JSONObject jSONObject2 = new JSONObject();
                        BluetoothGattService bluetoothGattService = services.get(i2);
                        if (bluetoothGattService != null && bluetoothGattService.getUuid() != null) {
                            jSONObject2.putOpt("uuid", bluetoothGattService.getUuid().toString());
                            jSONObject2.putOpt(AiAppsBluetoothConstants.KEY_IS_PRIMARY, false);
                            jSONArray.put(jSONObject2);
                        }
                    }
                }
                createCallBackMsg.put(AiAppsBluetoothConstants.KEY_SERVICES, jSONArray);
                AiAppsLog.i(MODULE_TAG, "get ble services --- success , result :" + createCallBackMsg.toString());
                return createCallBackMsg;
            } catch (JSONException e) {
                return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public JSONObject getBLEDeviceCharacteristics(String str, String str2) {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "get characteristics --- not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        } else if (this.mConnectDevices == null) {
            AiAppsLog.w(MODULE_TAG, "get characteristics --- no connect devices");
            return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
        } else {
            BluetoothDeviceData deviceDataByDeviceId = getDeviceDataByDeviceId(str);
            if (deviceDataByDeviceId == null) {
                AiAppsLog.w(MODULE_TAG, "get characteristics --- no device data");
                return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
            }
            BluetoothGatt bluetoothGatt = this.mConnectDevices.get(deviceDataByDeviceId);
            if (bluetoothGatt == null) {
                this.mConnectDevices.remove(deviceDataByDeviceId);
                AiAppsLog.w(MODULE_TAG, "get characteristics --- no gatt");
                return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
            }
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str2));
            if (service == null) {
                AiAppsLog.w(MODULE_TAG, "get characteristics --- no services");
                return createCallBackMsg(10004, AiAppsBluetoothConstants.ERROR_NO_SERVICE);
            }
            JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
            try {
                JSONArray jSONArray = new JSONArray();
                List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
                if (characteristics != null) {
                    int size = characteristics.size();
                    for (int i = 0; i < size; i++) {
                        JSONObject jSONObject = new JSONObject();
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristics.get(i);
                        if (bluetoothGattCharacteristic != null) {
                            UUID uuid = bluetoothGattCharacteristic.getUuid();
                            if (uuid != null) {
                                jSONObject.putOpt("uuid", uuid.toString());
                            }
                            jSONObject.putOpt(AiAppsBluetoothConstants.KEY_PROPERTIES, createPropertyArray(bluetoothGattCharacteristic));
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                createCallBackMsg.put(AiAppsBluetoothConstants.KEY_CHARACTERISTICS, jSONArray);
                return createCallBackMsg;
            } catch (JSONException e) {
                return createCallBackMsg(AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR_CODE, AiAppsBluetoothConstants.ERROR_SYSTEM_ERROR);
            }
        }
    }

    private JSONArray createPropertyArray(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        JSONArray jSONArray = new JSONArray();
        if (bluetoothGattCharacteristic == null) {
            return jSONArray;
        }
        int properties = bluetoothGattCharacteristic.getProperties();
        boolean z = (properties & 2) == 2;
        boolean z2 = (properties & 4) == 4 || (properties & 8) == 8;
        boolean z3 = (properties & 16) == 16;
        boolean z4 = (properties & 32) == 32;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(AiAppsBluetoothConstants.KEY_CHARACTERISTICS_READ, Boolean.valueOf(z));
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("write", Boolean.valueOf(z2));
            jSONArray.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt(AiAppsBluetoothConstants.KEY_CHARACTERISTICS_NOTIFY, Boolean.valueOf(z3));
            jSONArray.put(jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.putOpt(AiAppsBluetoothConstants.KEY_CHARACTERISTICS_INDICATE, Boolean.valueOf(z4));
            jSONArray.put(jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONArray;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public JSONObject readBLECharacteristicValue(String str, String str2, String str3) {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "read characteristics --- not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        } else if (this.mConnectDevices == null) {
            AiAppsLog.w(MODULE_TAG, "read characteristics --- no connect devices");
            return createCallBackMsg(10006, AiAppsBluetoothConstants.ERROR_NO_CONNECTION);
        } else {
            BluetoothDeviceData deviceDataByDeviceId = getDeviceDataByDeviceId(str);
            if (deviceDataByDeviceId == null) {
                AiAppsLog.w(MODULE_TAG, "read characteristics --- no device data");
                return createCallBackMsg(10006, AiAppsBluetoothConstants.ERROR_NO_CONNECTION);
            }
            BluetoothGatt bluetoothGatt = this.mConnectDevices.get(deviceDataByDeviceId);
            if (bluetoothGatt == null) {
                this.mConnectDevices.remove(deviceDataByDeviceId);
                AiAppsLog.w(MODULE_TAG, "read characteristics --- no gatt");
                return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
            }
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str2));
            if (service == null) {
                AiAppsLog.w(MODULE_TAG, "read characteristics --- no service");
                return createCallBackMsg(10004, AiAppsBluetoothConstants.ERROR_NO_SERVICE);
            }
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(str3));
            if (characteristic == null) {
                AiAppsLog.w(MODULE_TAG, "read characteristics --- no characteristic");
                return createCallBackMsg(10005, AiAppsBluetoothConstants.ERROR_NO_CHARACTERISTIC);
            }
            if (!((characteristic.getProperties() & 2) == 2)) {
                AiAppsLog.w(MODULE_TAG, "read characteristics --- can't read");
                return createCallBackMsg(AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT_CODE, AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT);
            }
            AiAppsLog.i(MODULE_TAG, "read characteristics --- read success");
            bluetoothGatt.readCharacteristic(characteristic);
            return createCallBackMsg(0, "ok");
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public void writeBLECharacteristicValue(String str, String str2, String str3, byte[] bArr) {
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "write characteristics --- not open");
            if (this.mBluetoothStatusCallback != null) {
                this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT));
            }
        } else if (this.mConnectDevices == null) {
            AiAppsLog.w(MODULE_TAG, "write characteristics --- no connect devices");
            if (this.mBluetoothStatusCallback != null) {
                this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, createCallBackMsg(10006, AiAppsBluetoothConstants.ERROR_NO_CONNECTION));
            }
        } else {
            BluetoothDeviceData deviceDataByDeviceId = getDeviceDataByDeviceId(str);
            if (deviceDataByDeviceId == null) {
                AiAppsLog.w(MODULE_TAG, "write characteristics --- no device data");
                if (this.mBluetoothStatusCallback != null) {
                    this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, createCallBackMsg(10006, AiAppsBluetoothConstants.ERROR_NO_CONNECTION));
                    return;
                }
                return;
            }
            BluetoothGatt bluetoothGatt = this.mConnectDevices.get(deviceDataByDeviceId);
            if (bluetoothGatt == null) {
                this.mConnectDevices.remove(deviceDataByDeviceId);
                AiAppsLog.w(MODULE_TAG, "write characteristics --- no gatt");
                if (this.mBluetoothStatusCallback != null) {
                    this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE));
                    return;
                }
                return;
            }
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str2));
            if (service == null) {
                AiAppsLog.w(MODULE_TAG, "write characteristics --- no service");
                if (this.mBluetoothStatusCallback != null) {
                    this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, createCallBackMsg(10004, AiAppsBluetoothConstants.ERROR_NO_SERVICE));
                    return;
                }
                return;
            }
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(str3));
            if (characteristic == null) {
                AiAppsLog.w(MODULE_TAG, "write characteristics --- no characteristic");
                if (this.mBluetoothStatusCallback != null) {
                    this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, createCallBackMsg(10005, AiAppsBluetoothConstants.ERROR_NO_CHARACTERISTIC));
                    return;
                }
                return;
            }
            int properties = characteristic.getProperties();
            if (!((properties & 4) == 4 || (properties & 8) == 8)) {
                AiAppsLog.w(MODULE_TAG, "write characteristics --- can't write");
                if (this.mBluetoothStatusCallback != null) {
                    this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, createCallBackMsg(AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT_CODE, AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT));
                    return;
                }
                return;
            }
            characteristic.setValue(bArr);
            bluetoothGatt.writeCharacteristic(characteristic);
            AiAppsLog.i(MODULE_TAG, "write characteristics --- write success");
            if (this.mBluetoothStatusCallback != null) {
                this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback, createCallBackMsg(0, "ok"));
            }
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.system.bluetooth.manager.IBluetoothManager
    public JSONObject notifyBLECharacteristicValueChange(String str, String str2, String str3, boolean z) {
        byte[] bArr;
        if (!this.mIsOpen) {
            AiAppsLog.w(MODULE_TAG, "notify characteristics --- not open");
            return createCallBackMsg(10000, AiAppsBluetoothConstants.ERROR_NOT_INIT);
        } else if (this.mConnectDevices == null) {
            AiAppsLog.w(MODULE_TAG, "notify characteristics --- no connect devices");
            return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
        } else {
            BluetoothDeviceData deviceDataByDeviceId = getDeviceDataByDeviceId(str);
            if (deviceDataByDeviceId == null) {
                AiAppsLog.w(MODULE_TAG, "notify characteristics --- no device data");
                return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
            }
            BluetoothGatt bluetoothGatt = this.mConnectDevices.get(deviceDataByDeviceId);
            if (bluetoothGatt == null) {
                this.mConnectDevices.remove(deviceDataByDeviceId);
                AiAppsLog.w(MODULE_TAG, "notify characteristics --- no gatt");
                return createCallBackMsg(10002, AiAppsBluetoothConstants.ERROR_NO_DEVICE);
            }
            BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str2));
            if (service == null) {
                AiAppsLog.w(MODULE_TAG, "notify characteristics --- no service");
                return createCallBackMsg(10004, AiAppsBluetoothConstants.ERROR_NO_SERVICE);
            }
            BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(str3));
            if (characteristic == null) {
                AiAppsLog.w(MODULE_TAG, "notify characteristics --- no characteristic");
                return createCallBackMsg(10005, AiAppsBluetoothConstants.ERROR_NO_CHARACTERISTIC);
            }
            int properties = characteristic.getProperties();
            boolean z2 = (properties & 16) == 16;
            boolean z3 = (properties & 32) == 32;
            if (!z2 && !z3) {
                AiAppsLog.w(MODULE_TAG, "notify characteristics --- can't notify");
                return createCallBackMsg(AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT_CODE, AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT);
            } else if (bluetoothGatt.setCharacteristicNotification(characteristic, z)) {
                List<BluetoothGattDescriptor> descriptors = characteristic.getDescriptors();
                if (descriptors != null && descriptors.size() > 0) {
                    if (z) {
                        bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                    } else {
                        bArr = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
                    }
                    for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                        bluetoothGattDescriptor.setValue(bArr);
                        bluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                    }
                }
                AiAppsLog.i(MODULE_TAG, "notify characteristics --- success");
                return createCallBackMsg(0, "ok");
            } else {
                AiAppsLog.i(MODULE_TAG, "notify characteristics --- fail");
                return createCallBackMsg(AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT_CODE, AiAppsBluetoothConstants.ERROR_PROPERTY_NOT_SUPPORT);
            }
        }
    }

    private void registerBluetoothActionReceiver() {
        if (!this.mIsRegistered && this.mContext != null) {
            this.mIsRegistered = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            this.mContext.registerReceiver(this.mBroadcastReceiver, intentFilter);
        }
    }

    private void unRegisterBluetoothActionReceiver() {
        if (this.mIsRegistered) {
            this.mIsRegistered = false;
            this.mContext.unregisterReceiver(this.mBroadcastReceiver);
        }
    }

    private void handleTimeout(BluetoothGatt bluetoothGatt, long j) {
        if (bluetoothGatt != null && j > 0) {
            Message obtain = Message.obtain();
            obtain.what = MSG_TIME_OUT;
            obtain.obj = bluetoothGatt;
            this.mHandler.sendMessageDelayed(obtain, j);
        }
    }

    public void setDeviceFoundCallback(String str) {
        if (this.mBluetoothStatusCallback != null && !TextUtils.isEmpty(str)) {
            this.mBluetoothStatusCallback.deviceFoundCallback = str;
        }
    }

    public void setConnectionStateChangeCallback(String str) {
        if (this.mBluetoothStatusCallback != null && !TextUtils.isEmpty(str)) {
            this.mBluetoothStatusCallback.connectionStateChangeCallback = str;
        }
    }

    public void setCreateConnectionCallback(String str) {
        if (this.mBluetoothStatusCallback != null && !TextUtils.isEmpty(str)) {
            this.mBluetoothStatusCallback.createBLEConnectionCallback = str;
        }
    }

    public void setCharacteristicChangeCallback(String str) {
        if (this.mBluetoothStatusCallback != null && !TextUtils.isEmpty(str)) {
            this.mBluetoothStatusCallback.characteristicValueChangeCallback = str;
        }
    }

    public void setWriteBLECharacteristicValue(String str) {
        if (this.mBluetoothStatusCallback != null && !TextUtils.isEmpty(str)) {
            this.mBluetoothStatusCallback.writeBLECharacteristicValueCallback = str;
        }
    }

    private BluetoothDeviceData getDeviceDataByDeviceId(String str) {
        BluetoothDeviceData bluetoothDeviceData;
        if (this.mConnectDevices == null) {
            return null;
        }
        Iterator<BluetoothDeviceData> it = this.mConnectDevices.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                bluetoothDeviceData = null;
                break;
            }
            BluetoothDeviceData next = it.next();
            if (next instanceof BluetoothDeviceData) {
                bluetoothDeviceData = next;
                if (TextUtils.equals(bluetoothDeviceData.deviceId, str)) {
                    break;
                }
            }
        }
        return bluetoothDeviceData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportStateChangeMsg() {
        if (this.mIsOpen && this.mBluetoothStatusCallback != null) {
            JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
            try {
                createCallBackMsg.put(KEY_AVAILABLE, isAdapterAvailable());
                createCallBackMsg.put(KEY_DISCOVERING, this.mIsDiscovery);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.stateChangeCallback, createCallBackMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCharacteristicValueChange(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGatt != null && bluetoothGattCharacteristic != null) {
            try {
                String encodeToString = Base64.encodeToString(bluetoothGattCharacteristic.getValue(), 2);
                if (!TextUtils.isEmpty(encodeToString)) {
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    if (bluetoothGattCharacteristic.getUuid() != null) {
                        str = bluetoothGattCharacteristic.getUuid().toString();
                    }
                    BluetoothGattService service = bluetoothGattCharacteristic.getService();
                    if (service != null && service.getUuid() != null) {
                        str2 = service.getUuid().toString();
                    }
                    BluetoothDevice device = bluetoothGatt.getDevice();
                    if (device != null) {
                        str3 = device.getAddress();
                    }
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                        reportCharacteristicValueChangeMsg(str3, str2, str, encodeToString);
                    }
                }
            } catch (AssertionError e) {
            }
        }
    }

    private void reportCharacteristicValueChangeMsg(String str, String str2, String str3, String str4) {
        if (this.mIsOpen && this.mBluetoothStatusCallback != null) {
            JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
            try {
                createCallBackMsg.put("deviceId", str);
                createCallBackMsg.put(AiAppsBluetoothConstants.KEY_SERVICE_ID, str2);
                createCallBackMsg.put(AiAppsBluetoothConstants.KEY_CHARACTERISTIC_ID, str3);
                createCallBackMsg.put("value", str4);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.characteristicValueChangeCallback, createCallBackMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportConnectionStateChangeMsg(String str, boolean z) {
        if (this.mIsOpen && this.mBluetoothStatusCallback != null) {
            JSONObject createCallBackMsg = createCallBackMsg(0, "ok");
            try {
                createCallBackMsg.put("deviceId", str);
                createCallBackMsg.put(AiAppsBluetoothConstants.KEY_CONNECTED, z);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mBluetoothStatusCallback.dispatchCallback(this.mBluetoothStatusCallback.connectionStateChangeCallback, createCallBackMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject createCallBackMsg(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject.put("errCode", i);
                jSONObject.put("errMsg", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    @RequiresApi(api = 21)
    public static void release() {
        if (instance != null) {
            instance.realRelease();
        }
    }

    @RequiresApi(api = 21)
    private void realRelease() {
        if (this.mIsDiscovery) {
            stopBluetoothDevicesDiscovery();
        }
        if (this.mIsRegistered) {
            unRegisterBluetoothActionReceiver();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.mBluetoothAdapter = null;
        this.mBluetoothLeScanner = null;
        this.mScanCallback = null;
        this.mLeScanCallback = null;
        this.mHasReportDevices = null;
        this.mNotReportDevices = null;
        this.mConnectDevices = null;
        this.mIsOpen = false;
        this.mIsDiscovery = false;
        instance = null;
    }
}
