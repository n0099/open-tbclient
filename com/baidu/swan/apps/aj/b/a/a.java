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
    private static volatile a aTJ;
    private boolean HK;
    private BluetoothAdapter aTK;
    private BluetoothLeScanner aTL;
    private boolean aTM;
    private boolean aTN;
    private ScanCallback aTO;
    private BluetoothAdapter.LeScanCallback aTP;
    private long aTQ;
    private Map<String, com.baidu.swan.apps.aj.b.b.a> aTR;
    private Map<String, com.baidu.swan.apps.aj.b.b.a> aTS;
    private Map<com.baidu.swan.apps.aj.b.b.a, BluetoothGatt> aTT;
    private com.baidu.swan.apps.aj.b.a aTU;
    private BroadcastReceiver aTW;
    private Context mContext;
    private Handler mHandler;
    private static final boolean DEBUG = b.DEBUG;
    private static int aTV = 1;

    @SuppressLint({"MissingPermission"})
    private boolean Lf() {
        if (!this.HK || this.aTK == null) {
            return false;
        }
        return this.aTK.isEnabled();
    }

    @TargetApi(21)
    private ScanCallback a(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aTO;
        }
        this.aTO = new ScanCallback() { // from class: com.baidu.swan.apps.aj.b.a.a.1
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
        return this.aTO;
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
                    aVar.aUa = scanResult.getRssi();
                    aVar.aUb = a(scanResult);
                    aVar.aUc = scanResult.getScanRecord().getServiceUuids();
                    aVar.aUd = scanResult.getScanRecord().getDeviceName();
                    aVar.aUe = scanResult.getScanRecord().getServiceData();
                    aVar.aUf = scanResult.getDevice();
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
            byte[] ed = com.baidu.swan.apps.aj.b.c.a.ed(keyAt);
            int length2 = ed.length;
            byte[] bArr = new byte[length + length2];
            System.arraycopy(ed, 0, bArr, 0, length2);
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
            if (aVar == null || aVar.aUf == null || TextUtils.isEmpty(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result --- wrong deviceData");
                }
            } else if (!z && this.aTR != null && this.aTR.containsKey(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result -- duplicate");
                }
            } else if (this.aTS != null) {
                this.aTS.put(aVar.deviceId, aVar);
            }
        }
        if (System.currentTimeMillis() - this.aTQ < i) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- illegal interval, interval : " + i);
            }
        } else if (this.aTS == null || this.aTS.size() == 0) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- none report device");
            }
        } else {
            this.aTQ = System.currentTimeMillis();
            JSONObject q = q(0, "ok");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, com.baidu.swan.apps.aj.b.b.a> entry : this.aTS.entrySet()) {
                if ((entry.getValue() instanceof com.baidu.swan.apps.aj.b.b.a) && (entry.getKey() instanceof String)) {
                    com.baidu.swan.apps.aj.b.b.a value = entry.getValue();
                    jSONArray.put(value.toJson());
                    String key = entry.getKey();
                    this.aTS.remove(key);
                    if (this.aTR == null) {
                        this.aTR = new ConcurrentHashMap();
                    }
                    this.aTR.put(key, value);
                }
            }
            try {
                q.put("devices", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.i("bluetooth", "report discovery result -- result : " + q.toString());
            if (this.aTU != null) {
                this.aTU.f(this.aTU.aTI, q);
            }
        }
    }

    private BluetoothAdapter.LeScanCallback b(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aTP;
        }
        this.aTP = new BluetoothAdapter.LeScanCallback() { // from class: com.baidu.swan.apps.aj.b.a.a.2
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                if (a.DEBUG) {
                    Log.d("BluetoothManager", "start discovery -- get one result");
                }
                a.this.a(bluetoothDevice, i2, bArr, z2, i);
            }
        };
        return this.aTP;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject Lg() {
        if (!this.HK) {
            c.w("bluetooth", "stop discovery -- is not open");
            return q(10000, "not init");
        } else if (!Lf()) {
            c.w("bluetooth", "stop discovery -- is not available");
            return q(10001, "not available");
        } else if (!this.aTN) {
            c.w("bluetooth", "stop discovery -- is not discovery");
            return q(0, "ok");
        } else {
            if (com.baidu.swan.apps.an.a.hasLollipop()) {
                if (this.aTL != null) {
                    c.i("bluetooth", "stop discovery -- stop success");
                    if (this.aTN) {
                        this.aTN = false;
                        Li();
                    }
                    this.aTL.stopScan(a(false, true, 0));
                    return q(0, "ok");
                }
            } else if (this.aTK != null) {
                c.i("bluetooth", "stop discovery -- stop success");
                if (this.aTN) {
                    this.aTN = false;
                    Li();
                }
                this.aTK.stopLeScan(b(false, true, 0));
                return q(0, "ok");
            }
            return q(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL, "system error");
        }
    }

    private void Lh() {
        if (this.aTM) {
            this.aTM = false;
            this.mContext.unregisterReceiver(this.aTW);
        }
    }

    private void Li() {
        if (this.HK && this.aTU != null) {
            JSONObject q = q(0, "ok");
            try {
                q.put("available", Lf());
                q.put("discovering", this.aTN);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("BluetoothManager", "report state change msg --- result : " + q.toString());
            }
            this.aTU.f(this.aTU.aTH, q);
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
        if (aTJ != null) {
            aTJ.zP();
        }
    }

    @RequiresApi(api = 21)
    private void zP() {
        if (this.aTN) {
            Lg();
        }
        if (this.aTM) {
            Lh();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.aTK = null;
        this.aTL = null;
        this.aTO = null;
        this.aTP = null;
        this.aTR = null;
        this.aTS = null;
        this.aTT = null;
        this.HK = false;
        this.aTN = false;
        aTJ = null;
    }
}
