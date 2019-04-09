package com.baidu.swan.apps.aj.b.a;

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
    private static volatile a aTN;
    private boolean HK;
    private BluetoothAdapter aTO;
    private BluetoothLeScanner aTP;
    private boolean aTQ;
    private boolean aTR;
    private ScanCallback aTS;
    private BluetoothAdapter.LeScanCallback aTT;
    private long aTU;
    private Map<String, com.baidu.swan.apps.aj.b.b.a> aTV;
    private Map<String, com.baidu.swan.apps.aj.b.b.a> aTW;
    private Map<com.baidu.swan.apps.aj.b.b.a, BluetoothGatt> aTX;
    private com.baidu.swan.apps.aj.b.a aTY;
    private BroadcastReceiver aUa;
    private Context mContext;
    private Handler mHandler;
    private static final boolean DEBUG = b.DEBUG;
    private static int aTZ = 1;

    @SuppressLint({"MissingPermission"})
    private boolean Ld() {
        if (!this.HK || this.aTO == null) {
            return false;
        }
        return this.aTO.isEnabled();
    }

    @TargetApi(21)
    private ScanCallback a(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aTS;
        }
        this.aTS = new ScanCallback() { // from class: com.baidu.swan.apps.aj.b.a.a.1
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
        return this.aTS;
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
                    com.baidu.swan.apps.aj.b.b.a aVar = new com.baidu.swan.apps.aj.b.b.a();
                    aVar.name = scanResult.getDevice().getName();
                    aVar.deviceId = scanResult.getDevice().getAddress();
                    aVar.aUe = scanResult.getRssi();
                    aVar.aUf = a(scanResult);
                    aVar.aUg = scanResult.getScanRecord().getServiceUuids();
                    aVar.aUh = scanResult.getScanRecord().getDeviceName();
                    aVar.aUi = scanResult.getScanRecord().getServiceData();
                    aVar.aUj = scanResult.getDevice();
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
            byte[] ec = com.baidu.swan.apps.aj.b.c.a.ec(keyAt);
            int length2 = ec.length;
            byte[] bArr = new byte[length + length2];
            System.arraycopy(ec, 0, bArr, 0, length2);
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
            com.baidu.swan.apps.aj.b.b.a a = com.baidu.swan.apps.aj.b.c.a.a(bluetoothDevice, i, bArr);
            if (a != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(a);
                b(arrayList, z, i2);
            }
        }
    }

    private void b(List<com.baidu.swan.apps.aj.b.b.a> list, boolean z, int i) {
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
        for (com.baidu.swan.apps.aj.b.b.a aVar : list) {
            if (aVar == null || aVar.aUj == null || TextUtils.isEmpty(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result --- wrong deviceData");
                }
            } else if (!z && this.aTV != null && this.aTV.containsKey(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result -- duplicate");
                }
            } else if (this.aTW != null) {
                this.aTW.put(aVar.deviceId, aVar);
            }
        }
        if (System.currentTimeMillis() - this.aTU < i) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- illegal interval, interval : " + i);
            }
        } else if (this.aTW == null || this.aTW.size() == 0) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- none report device");
            }
        } else {
            this.aTU = System.currentTimeMillis();
            JSONObject q = q(0, "ok");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, com.baidu.swan.apps.aj.b.b.a> entry : this.aTW.entrySet()) {
                if ((entry.getValue() instanceof com.baidu.swan.apps.aj.b.b.a) && (entry.getKey() instanceof String)) {
                    com.baidu.swan.apps.aj.b.b.a value = entry.getValue();
                    jSONArray.put(value.toJson());
                    String key = entry.getKey();
                    this.aTW.remove(key);
                    if (this.aTV == null) {
                        this.aTV = new ConcurrentHashMap();
                    }
                    this.aTV.put(key, value);
                }
            }
            try {
                q.put("devices", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.i("bluetooth", "report discovery result -- result : " + q.toString());
            if (this.aTY != null) {
                this.aTY.f(this.aTY.aTM, q);
            }
        }
    }

    private BluetoothAdapter.LeScanCallback b(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aTT;
        }
        this.aTT = new BluetoothAdapter.LeScanCallback() { // from class: com.baidu.swan.apps.aj.b.a.a.2
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                if (a.DEBUG) {
                    Log.d("BluetoothManager", "start discovery -- get one result");
                }
                a.this.a(bluetoothDevice, i2, bArr, z2, i);
            }
        };
        return this.aTT;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject Le() {
        if (!this.HK) {
            c.w("bluetooth", "stop discovery -- is not open");
            return q(10000, "not init");
        } else if (!Ld()) {
            c.w("bluetooth", "stop discovery -- is not available");
            return q(10001, "not available");
        } else if (!this.aTR) {
            c.w("bluetooth", "stop discovery -- is not discovery");
            return q(0, "ok");
        } else {
            if (com.baidu.swan.apps.an.a.hasLollipop()) {
                if (this.aTP != null) {
                    c.i("bluetooth", "stop discovery -- stop success");
                    if (this.aTR) {
                        this.aTR = false;
                        Lg();
                    }
                    this.aTP.stopScan(a(false, true, 0));
                    return q(0, "ok");
                }
            } else if (this.aTO != null) {
                c.i("bluetooth", "stop discovery -- stop success");
                if (this.aTR) {
                    this.aTR = false;
                    Lg();
                }
                this.aTO.stopLeScan(b(false, true, 0));
                return q(0, "ok");
            }
            return q(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL, "system error");
        }
    }

    private void Lf() {
        if (this.aTQ) {
            this.aTQ = false;
            this.mContext.unregisterReceiver(this.aUa);
        }
    }

    private void Lg() {
        if (this.HK && this.aTY != null) {
            JSONObject q = q(0, "ok");
            try {
                q.put("available", Ld());
                q.put("discovering", this.aTR);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("BluetoothManager", "report state change msg --- result : " + q.toString());
            }
            this.aTY.f(this.aTY.aTL, q);
        }
    }

    private JSONObject q(int i, String str) {
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
        if (aTN != null) {
            aTN.zO();
        }
    }

    @RequiresApi(api = 21)
    private void zO() {
        if (this.aTR) {
            Le();
        }
        if (this.aTQ) {
            Lf();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.aTO = null;
        this.aTP = null;
        this.aTS = null;
        this.aTT = null;
        this.aTV = null;
        this.aTW = null;
        this.aTX = null;
        this.HK = false;
        this.aTR = false;
        aTN = null;
    }
}
