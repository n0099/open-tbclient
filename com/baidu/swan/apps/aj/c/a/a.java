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
    private static volatile a bqP;
    private BluetoothAdapter bqQ;
    private BluetoothLeScanner bqR;
    private boolean bqS;
    private boolean bqT;
    private ScanCallback bqU;
    private BluetoothAdapter.LeScanCallback bqV;
    private long bqW;
    private Map<String, com.baidu.swan.apps.aj.c.b.a> bqX;
    private Map<String, com.baidu.swan.apps.aj.c.b.a> bqY;
    private Map<com.baidu.swan.apps.aj.c.b.a, BluetoothGatt> bqZ;
    private com.baidu.swan.apps.aj.c.a bra;
    private BroadcastReceiver brc;
    private Context mContext;
    private Handler mHandler;
    private boolean sM;
    private static final boolean DEBUG = b.DEBUG;
    private static int brb = 1;

    @SuppressLint({"MissingPermission"})
    private boolean Tl() {
        if (!this.sM || this.bqQ == null) {
            return false;
        }
        return this.bqQ.isEnabled();
    }

    @TargetApi(21)
    private ScanCallback a(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.bqU;
        }
        this.bqU = new ScanCallback() { // from class: com.baidu.swan.apps.aj.c.a.a.1
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
        return this.bqU;
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
                    aVar.brf = scanResult.getRssi();
                    aVar.brg = a(scanResult);
                    aVar.brh = scanResult.getScanRecord().getServiceUuids();
                    aVar.bri = scanResult.getScanRecord().getDeviceName();
                    aVar.brj = scanResult.getScanRecord().getServiceData();
                    aVar.brk = scanResult.getDevice();
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
            byte[] fm = com.baidu.swan.apps.aj.c.c.a.fm(keyAt);
            int length2 = fm.length;
            byte[] bArr = new byte[length + length2];
            System.arraycopy(fm, 0, bArr, 0, length2);
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
            if (aVar == null || aVar.brk == null || TextUtils.isEmpty(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result --- wrong deviceData");
                }
            } else if (!z && this.bqX != null && this.bqX.containsKey(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result -- duplicate");
                }
            } else if (this.bqY != null) {
                this.bqY.put(aVar.deviceId, aVar);
            }
        }
        if (System.currentTimeMillis() - this.bqW < i) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- illegal interval, interval : " + i);
            }
        } else if (this.bqY == null || this.bqY.size() == 0) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- none report device");
            }
        } else {
            this.bqW = System.currentTimeMillis();
            JSONObject v = v(0, "ok");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, com.baidu.swan.apps.aj.c.b.a> entry : this.bqY.entrySet()) {
                if ((entry.getValue() instanceof com.baidu.swan.apps.aj.c.b.a) && (entry.getKey() instanceof String)) {
                    com.baidu.swan.apps.aj.c.b.a value = entry.getValue();
                    jSONArray.put(value.toJson());
                    String key = entry.getKey();
                    this.bqY.remove(key);
                    if (this.bqX == null) {
                        this.bqX = new ConcurrentHashMap();
                    }
                    this.bqX.put(key, value);
                }
            }
            try {
                v.put("devices", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.i("bluetooth", "report discovery result -- result : " + v.toString());
            if (this.bra != null) {
                this.bra.f(this.bra.bqO, v);
            }
        }
    }

    private BluetoothAdapter.LeScanCallback b(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.bqV;
        }
        this.bqV = new BluetoothAdapter.LeScanCallback() { // from class: com.baidu.swan.apps.aj.c.a.a.2
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                if (a.DEBUG) {
                    Log.d("BluetoothManager", "start discovery -- get one result");
                }
                a.this.a(bluetoothDevice, i2, bArr, z2, i);
            }
        };
        return this.bqV;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject Tm() {
        if (!this.sM) {
            c.w("bluetooth", "stop discovery -- is not open");
            return v(10000, "not init");
        } else if (!Tl()) {
            c.w("bluetooth", "stop discovery -- is not available");
            return v(10001, "not available");
        } else if (!this.bqT) {
            c.w("bluetooth", "stop discovery -- is not discovery");
            return v(0, "ok");
        } else {
            if (com.baidu.swan.apps.an.a.hasLollipop()) {
                if (this.bqR != null) {
                    c.i("bluetooth", "stop discovery -- stop success");
                    if (this.bqT) {
                        this.bqT = false;
                        To();
                    }
                    this.bqR.stopScan(a(false, true, 0));
                    return v(0, "ok");
                }
            } else if (this.bqQ != null) {
                c.i("bluetooth", "stop discovery -- stop success");
                if (this.bqT) {
                    this.bqT = false;
                    To();
                }
                this.bqQ.stopLeScan(b(false, true, 0));
                return v(0, "ok");
            }
            return v(10008, "system error");
        }
    }

    private void Tn() {
        if (this.bqS) {
            this.bqS = false;
            this.mContext.unregisterReceiver(this.brc);
        }
    }

    private void To() {
        if (this.sM && this.bra != null) {
            JSONObject v = v(0, "ok");
            try {
                v.put("available", Tl());
                v.put("discovering", this.bqT);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("BluetoothManager", "report state change msg --- result : " + v.toString());
            }
            this.bra.f(this.bra.bqN, v);
        }
    }

    private JSONObject v(int i, String str) {
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
        if (bqP != null) {
            bqP.GD();
        }
    }

    @RequiresApi(api = 21)
    private void GD() {
        if (this.bqT) {
            Tm();
        }
        if (this.bqS) {
            Tn();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.bqQ = null;
        this.bqR = null;
        this.bqU = null;
        this.bqV = null;
        this.bqX = null;
        this.bqY = null;
        this.bqZ = null;
        this.sM = false;
        this.bqT = false;
        bqP = null;
    }
}
