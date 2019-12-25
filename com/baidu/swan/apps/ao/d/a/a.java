package com.baidu.swan.apps.ao.d.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    private static volatile a bRS;
    private boolean bRN;
    private BluetoothAdapter bRT;
    private BluetoothLeScanner bRU;
    private boolean bRV;
    private ScanCallback bRW;
    private BluetoothAdapter.LeScanCallback bRX;
    private long bRY;
    private Map<String, com.baidu.swan.apps.ao.d.b.a> bRZ;
    private Map<String, com.baidu.swan.apps.ao.d.b.a> bSa;
    private Map<com.baidu.swan.apps.ao.d.b.a, BluetoothGatt> bSb;
    private com.baidu.swan.apps.ao.d.a bSc;
    private BroadcastReceiver bSe;
    private Context mContext;
    private Handler mHandler;
    private boolean vd;
    private static final boolean DEBUG = b.DEBUG;
    private static int bSd = 1;

    @SuppressLint({"MissingPermission"})
    private boolean ada() {
        if (!this.vd || this.bRT == null) {
            return false;
        }
        return this.bRT.isEnabled();
    }

    @TargetApi(21)
    private ScanCallback a(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.bRW;
        }
        this.bRW = new ScanCallback() { // from class: com.baidu.swan.apps.ao.d.a.a.1
            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int i2, ScanResult scanResult) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(scanResult);
                if (a.DEBUG) {
                    Log.d("BluetoothManager", "start discovery --- has lollipop -- get one result");
                }
                a.this.a(arrayList, z2, i);
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onBatchScanResults(List<ScanResult> list) {
                if (list != null && list.size() > 0) {
                    if (a.DEBUG) {
                        Log.d("BluetoothManager", "start discovery --- has lollipop -- get results");
                    }
                    a.this.a(list, z2, i);
                }
            }
        };
        return this.bRW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    @TargetApi(21)
    public void a(List<ScanResult> list, boolean z, int i) {
        if (list != null) {
            if (DEBUG) {
                Log.d("BluetoothManager", "discovery result -- start handle");
            }
            ArrayList arrayList = new ArrayList();
            for (ScanResult scanResult : list) {
                if (scanResult != null && scanResult.getScanRecord() != null && scanResult.getDevice() != null) {
                    com.baidu.swan.apps.ao.d.b.a aVar = new com.baidu.swan.apps.ao.d.b.a();
                    aVar.name = scanResult.getDevice().getName();
                    aVar.deviceId = scanResult.getDevice().getAddress();
                    aVar.bSh = scanResult.getRssi();
                    aVar.bSi = a(scanResult);
                    aVar.bSj = scanResult.getScanRecord().getServiceUuids();
                    aVar.bSk = scanResult.getScanRecord().getDeviceName();
                    aVar.bSl = scanResult.getScanRecord().getServiceData();
                    aVar.bSm = scanResult.getDevice();
                    if (DEBUG) {
                        Log.d("BluetoothManager", "discovery result " + aVar.toJson().toString());
                    }
                    arrayList.add(aVar);
                }
            }
            if (DEBUG) {
                Log.d("BluetoothManager", "discovery result -- stop handle");
            }
            b(arrayList, z, i);
        }
    }

    @TargetApi(21)
    private List<byte[]> a(ScanResult scanResult) {
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
            byte[] gC = com.baidu.swan.apps.ao.d.c.a.gC(keyAt);
            int length2 = gC.length;
            byte[] bArr = new byte[length + length2];
            System.arraycopy(gC, 0, bArr, 0, length2);
            System.arraycopy(valueAt, 0, bArr, length2, length);
            arrayList.add(bArr);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluetoothDevice bluetoothDevice, int i, byte[] bArr, boolean z, int i2) {
        if (bluetoothDevice != null && bArr != null) {
            if (DEBUG) {
                Log.d("BluetoothManager", "start discovery -- handle result");
            }
            com.baidu.swan.apps.ao.d.b.a a = com.baidu.swan.apps.ao.d.c.a.a(bluetoothDevice, i, bArr);
            if (a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(a);
                b(arrayList, z, i2);
            }
        }
    }

    private void b(List<com.baidu.swan.apps.ao.d.b.a> list, boolean z, int i) {
        if (list == null) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- devices is null");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("BluetoothManager", "report discovery result -- start");
        }
        for (com.baidu.swan.apps.ao.d.b.a aVar : list) {
            if (aVar == null || aVar.bSm == null || TextUtils.isEmpty(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result --- wrong deviceData");
                }
            } else if (!z && this.bRZ != null && this.bRZ.containsKey(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result -- duplicate");
                }
            } else if (this.bSa != null) {
                this.bSa.put(aVar.deviceId, aVar);
            }
        }
        if (System.currentTimeMillis() - this.bRY < i) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- illegal interval, interval : " + i);
            }
        } else if (this.bSa == null || this.bSa.size() == 0) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- none report device");
            }
        } else {
            this.bRY = System.currentTimeMillis();
            JSONObject y = y(0, "ok");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, com.baidu.swan.apps.ao.d.b.a> entry : this.bSa.entrySet()) {
                if ((entry.getValue() instanceof com.baidu.swan.apps.ao.d.b.a) && (entry.getKey() instanceof String)) {
                    com.baidu.swan.apps.ao.d.b.a value = entry.getValue();
                    jSONArray.put(value.toJson());
                    String key = entry.getKey();
                    this.bSa.remove(key);
                    if (this.bRZ == null) {
                        this.bRZ = new ConcurrentHashMap();
                    }
                    this.bRZ.put(key, value);
                }
            }
            try {
                y.put("devices", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.i("bluetooth", "report discovery result -- result : " + y.toString());
            if (this.bSc != null) {
                this.bSc.d(this.bSc.bRR, y);
            }
        }
    }

    private BluetoothAdapter.LeScanCallback b(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.bRX;
        }
        this.bRX = new BluetoothAdapter.LeScanCallback() { // from class: com.baidu.swan.apps.ao.d.a.a.2
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                if (a.DEBUG) {
                    Log.d("BluetoothManager", "start discovery -- get one result");
                }
                a.this.a(bluetoothDevice, i2, bArr, z2, i);
            }
        };
        return this.bRX;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject adb() {
        if (!this.vd) {
            c.w("bluetooth", "stop discovery -- is not open");
            return y(10000, "not init");
        } else if (!ada()) {
            c.w("bluetooth", "stop discovery -- is not available");
            return y(10001, "not available");
        } else if (!this.bRV) {
            c.w("bluetooth", "stop discovery -- is not discovery");
            return y(0, "ok");
        } else {
            if (com.baidu.swan.apps.as.a.hasLollipop()) {
                if (this.bRU != null) {
                    c.i("bluetooth", "stop discovery -- stop success");
                    if (this.bRV) {
                        this.bRV = false;
                        add();
                    }
                    this.bRU.stopScan(a(false, true, 0));
                    return y(0, "ok");
                }
            } else if (this.bRT != null) {
                c.i("bluetooth", "stop discovery -- stop success");
                if (this.bRV) {
                    this.bRV = false;
                    add();
                }
                this.bRT.stopLeScan(b(false, true, 0));
                return y(0, "ok");
            }
            return y(10008, "system error");
        }
    }

    private void adc() {
        if (this.bRN) {
            this.bRN = false;
            this.mContext.unregisterReceiver(this.bSe);
        }
    }

    private void add() {
        if (this.vd && this.bSc != null) {
            JSONObject y = y(0, "ok");
            try {
                y.put("available", ada());
                y.put("discovering", this.bRV);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("BluetoothManager", "report state change msg --- result : " + y.toString());
            }
            this.bSc.d(this.bSc.bRQ, y);
        }
    }

    private JSONObject y(int i, String str) {
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
        if (bRS != null) {
            bRS.Nf();
        }
    }

    @RequiresApi(api = 21)
    private void Nf() {
        if (this.bRV) {
            adb();
        }
        if (this.bRN) {
            adc();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.bRT = null;
        this.bRU = null;
        this.bRW = null;
        this.bRX = null;
        this.bRZ = null;
        this.bSa = null;
        this.bSb = null;
        this.vd = false;
        this.bRV = false;
        bRS = null;
    }
}
