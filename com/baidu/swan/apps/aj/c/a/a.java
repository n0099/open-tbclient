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
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
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
    private static volatile a aWE;
    private boolean Fv;
    private BluetoothAdapter aWF;
    private BluetoothLeScanner aWG;
    private boolean aWH;
    private boolean aWI;
    private ScanCallback aWJ;
    private BluetoothAdapter.LeScanCallback aWK;
    private long aWL;
    private Map<String, com.baidu.swan.apps.aj.c.b.a> aWM;
    private Map<String, com.baidu.swan.apps.aj.c.b.a> aWN;
    private Map<com.baidu.swan.apps.aj.c.b.a, BluetoothGatt> aWO;
    private com.baidu.swan.apps.aj.c.a aWP;
    private BroadcastReceiver aWR;
    private Context mContext;
    private Handler mHandler;
    private static final boolean DEBUG = b.DEBUG;
    private static int aWQ = 1;

    @SuppressLint({"MissingPermission"})
    private boolean NC() {
        if (!this.Fv || this.aWF == null) {
            return false;
        }
        return this.aWF.isEnabled();
    }

    @TargetApi(21)
    private ScanCallback a(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aWJ;
        }
        this.aWJ = new ScanCallback() { // from class: com.baidu.swan.apps.aj.c.a.a.1
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
        return this.aWJ;
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
                    aVar.aWV = scanResult.getRssi();
                    aVar.aWW = a(scanResult);
                    aVar.aWX = scanResult.getScanRecord().getServiceUuids();
                    aVar.aWY = scanResult.getScanRecord().getDeviceName();
                    aVar.aWZ = scanResult.getScanRecord().getServiceData();
                    aVar.aXa = scanResult.getDevice();
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
            byte[] en = com.baidu.swan.apps.aj.c.c.a.en(keyAt);
            int length2 = en.length;
            byte[] bArr = new byte[length + length2];
            System.arraycopy(en, 0, bArr, 0, length2);
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
            if (aVar == null || aVar.aXa == null || TextUtils.isEmpty(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result --- wrong deviceData");
                }
            } else if (!z && this.aWM != null && this.aWM.containsKey(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result -- duplicate");
                }
            } else if (this.aWN != null) {
                this.aWN.put(aVar.deviceId, aVar);
            }
        }
        if (System.currentTimeMillis() - this.aWL < i) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- illegal interval, interval : " + i);
            }
        } else if (this.aWN == null || this.aWN.size() == 0) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- none report device");
            }
        } else {
            this.aWL = System.currentTimeMillis();
            JSONObject r = r(0, "ok");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, com.baidu.swan.apps.aj.c.b.a> entry : this.aWN.entrySet()) {
                if ((entry.getValue() instanceof com.baidu.swan.apps.aj.c.b.a) && (entry.getKey() instanceof String)) {
                    com.baidu.swan.apps.aj.c.b.a value = entry.getValue();
                    jSONArray.put(value.toJson());
                    String key = entry.getKey();
                    this.aWN.remove(key);
                    if (this.aWM == null) {
                        this.aWM = new ConcurrentHashMap();
                    }
                    this.aWM.put(key, value);
                }
            }
            try {
                r.put("devices", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.i("bluetooth", "report discovery result -- result : " + r.toString());
            if (this.aWP != null) {
                this.aWP.f(this.aWP.aWD, r);
            }
        }
    }

    private BluetoothAdapter.LeScanCallback b(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aWK;
        }
        this.aWK = new BluetoothAdapter.LeScanCallback() { // from class: com.baidu.swan.apps.aj.c.a.a.2
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                if (a.DEBUG) {
                    Log.d("BluetoothManager", "start discovery -- get one result");
                }
                a.this.a(bluetoothDevice, i2, bArr, z2, i);
            }
        };
        return this.aWK;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject ND() {
        if (!this.Fv) {
            c.w("bluetooth", "stop discovery -- is not open");
            return r(10000, "not init");
        } else if (!NC()) {
            c.w("bluetooth", "stop discovery -- is not available");
            return r(10001, "not available");
        } else if (!this.aWI) {
            c.w("bluetooth", "stop discovery -- is not discovery");
            return r(0, "ok");
        } else {
            if (com.baidu.swan.apps.an.a.hasLollipop()) {
                if (this.aWG != null) {
                    c.i("bluetooth", "stop discovery -- stop success");
                    if (this.aWI) {
                        this.aWI = false;
                        NF();
                    }
                    this.aWG.stopScan(a(false, true, 0));
                    return r(0, "ok");
                }
            } else if (this.aWF != null) {
                c.i("bluetooth", "stop discovery -- stop success");
                if (this.aWI) {
                    this.aWI = false;
                    NF();
                }
                this.aWF.stopLeScan(b(false, true, 0));
                return r(0, "ok");
            }
            return r(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL, "system error");
        }
    }

    private void NE() {
        if (this.aWH) {
            this.aWH = false;
            this.mContext.unregisterReceiver(this.aWR);
        }
    }

    private void NF() {
        if (this.Fv && this.aWP != null) {
            JSONObject r = r(0, "ok");
            try {
                r.put("available", NC());
                r.put("discovering", this.aWI);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("BluetoothManager", "report state change msg --- result : " + r.toString());
            }
            this.aWP.f(this.aWP.aWC, r);
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
        if (aWE != null) {
            aWE.AX();
        }
    }

    @RequiresApi(api = 21)
    private void AX() {
        if (this.aWI) {
            ND();
        }
        if (this.aWH) {
            NE();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.aWF = null;
        this.aWG = null;
        this.aWJ = null;
        this.aWK = null;
        this.aWM = null;
        this.aWN = null;
        this.aWO = null;
        this.Fv = false;
        this.aWI = false;
        aWE = null;
    }
}
