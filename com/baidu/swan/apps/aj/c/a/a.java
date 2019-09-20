package com.baidu.swan.apps.aj.c.a;

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
/* loaded from: classes2.dex */
public class a {
    private static volatile a aXM;
    private boolean FB;
    private BluetoothAdapter aXN;
    private BluetoothLeScanner aXO;
    private boolean aXP;
    private boolean aXQ;
    private ScanCallback aXR;
    private BluetoothAdapter.LeScanCallback aXS;
    private long aXT;
    private Map<String, com.baidu.swan.apps.aj.c.b.a> aXU;
    private Map<String, com.baidu.swan.apps.aj.c.b.a> aXV;
    private Map<com.baidu.swan.apps.aj.c.b.a, BluetoothGatt> aXW;
    private com.baidu.swan.apps.aj.c.a aXX;
    private BroadcastReceiver aXZ;
    private Context mContext;
    private Handler mHandler;
    private static final boolean DEBUG = b.DEBUG;
    private static int aXY = 1;

    @SuppressLint({"MissingPermission"})
    private boolean Ov() {
        if (!this.FB || this.aXN == null) {
            return false;
        }
        return this.aXN.isEnabled();
    }

    @TargetApi(21)
    private ScanCallback a(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aXR;
        }
        this.aXR = new ScanCallback() { // from class: com.baidu.swan.apps.aj.c.a.a.1
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
        return this.aXR;
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
                    com.baidu.swan.apps.aj.c.b.a aVar = new com.baidu.swan.apps.aj.c.b.a();
                    aVar.name = scanResult.getDevice().getName();
                    aVar.deviceId = scanResult.getDevice().getAddress();
                    aVar.aYd = scanResult.getRssi();
                    aVar.aYe = a(scanResult);
                    aVar.aYf = scanResult.getScanRecord().getServiceUuids();
                    aVar.aYg = scanResult.getScanRecord().getDeviceName();
                    aVar.aYh = scanResult.getScanRecord().getServiceData();
                    aVar.aYi = scanResult.getDevice();
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
            byte[] er = com.baidu.swan.apps.aj.c.c.a.er(keyAt);
            int length2 = er.length;
            byte[] bArr = new byte[length + length2];
            System.arraycopy(er, 0, bArr, 0, length2);
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
            com.baidu.swan.apps.aj.c.b.a a = com.baidu.swan.apps.aj.c.c.a.a(bluetoothDevice, i, bArr);
            if (a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(a);
                b(arrayList, z, i2);
            }
        }
    }

    private void b(List<com.baidu.swan.apps.aj.c.b.a> list, boolean z, int i) {
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
        for (com.baidu.swan.apps.aj.c.b.a aVar : list) {
            if (aVar == null || aVar.aYi == null || TextUtils.isEmpty(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result --- wrong deviceData");
                }
            } else if (!z && this.aXU != null && this.aXU.containsKey(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result -- duplicate");
                }
            } else if (this.aXV != null) {
                this.aXV.put(aVar.deviceId, aVar);
            }
        }
        if (System.currentTimeMillis() - this.aXT < i) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- illegal interval, interval : " + i);
            }
        } else if (this.aXV == null || this.aXV.size() == 0) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- none report device");
            }
        } else {
            this.aXT = System.currentTimeMillis();
            JSONObject r = r(0, "ok");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, com.baidu.swan.apps.aj.c.b.a> entry : this.aXV.entrySet()) {
                if ((entry.getValue() instanceof com.baidu.swan.apps.aj.c.b.a) && (entry.getKey() instanceof String)) {
                    com.baidu.swan.apps.aj.c.b.a value = entry.getValue();
                    jSONArray.put(value.toJson());
                    String key = entry.getKey();
                    this.aXV.remove(key);
                    if (this.aXU == null) {
                        this.aXU = new ConcurrentHashMap();
                    }
                    this.aXU.put(key, value);
                }
            }
            try {
                r.put("devices", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.i("bluetooth", "report discovery result -- result : " + r.toString());
            if (this.aXX != null) {
                this.aXX.f(this.aXX.aXL, r);
            }
        }
    }

    private BluetoothAdapter.LeScanCallback b(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aXS;
        }
        this.aXS = new BluetoothAdapter.LeScanCallback() { // from class: com.baidu.swan.apps.aj.c.a.a.2
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                if (a.DEBUG) {
                    Log.d("BluetoothManager", "start discovery -- get one result");
                }
                a.this.a(bluetoothDevice, i2, bArr, z2, i);
            }
        };
        return this.aXS;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject Ow() {
        if (!this.FB) {
            c.w("bluetooth", "stop discovery -- is not open");
            return r(10000, "not init");
        } else if (!Ov()) {
            c.w("bluetooth", "stop discovery -- is not available");
            return r(10001, "not available");
        } else if (!this.aXQ) {
            c.w("bluetooth", "stop discovery -- is not discovery");
            return r(0, "ok");
        } else {
            if (com.baidu.swan.apps.an.a.hasLollipop()) {
                if (this.aXO != null) {
                    c.i("bluetooth", "stop discovery -- stop success");
                    if (this.aXQ) {
                        this.aXQ = false;
                        Oy();
                    }
                    this.aXO.stopScan(a(false, true, 0));
                    return r(0, "ok");
                }
            } else if (this.aXN != null) {
                c.i("bluetooth", "stop discovery -- stop success");
                if (this.aXQ) {
                    this.aXQ = false;
                    Oy();
                }
                this.aXN.stopLeScan(b(false, true, 0));
                return r(0, "ok");
            }
            return r(10008, "system error");
        }
    }

    private void Ox() {
        if (this.aXP) {
            this.aXP = false;
            this.mContext.unregisterReceiver(this.aXZ);
        }
    }

    private void Oy() {
        if (this.FB && this.aXX != null) {
            JSONObject r = r(0, "ok");
            try {
                r.put("available", Ov());
                r.put("discovering", this.aXQ);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("BluetoothManager", "report state change msg --- result : " + r.toString());
            }
            this.aXX.f(this.aXX.aXK, r);
        }
    }

    private JSONObject r(int i, String str) {
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
        if (aXM != null) {
            aXM.BJ();
        }
    }

    @RequiresApi(api = 21)
    private void BJ() {
        if (this.aXQ) {
            Ow();
        }
        if (this.aXP) {
            Ox();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.aXN = null;
        this.aXO = null;
        this.aXR = null;
        this.aXS = null;
        this.aXU = null;
        this.aXV = null;
        this.aXW = null;
        this.FB = false;
        this.aXQ = false;
        aXM = null;
    }
}
