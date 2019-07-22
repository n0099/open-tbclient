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
    private static final boolean DEBUG = b.DEBUG;
    private static int aXA = 1;
    private static volatile a aXo;
    private boolean FB;
    private BroadcastReceiver aXB;
    private BluetoothAdapter aXp;
    private BluetoothLeScanner aXq;
    private boolean aXr;
    private boolean aXs;
    private ScanCallback aXt;
    private BluetoothAdapter.LeScanCallback aXu;
    private long aXv;
    private Map<String, com.baidu.swan.apps.aj.c.b.a> aXw;
    private Map<String, com.baidu.swan.apps.aj.c.b.a> aXx;
    private Map<com.baidu.swan.apps.aj.c.b.a, BluetoothGatt> aXy;
    private com.baidu.swan.apps.aj.c.a aXz;
    private Context mContext;
    private Handler mHandler;

    @SuppressLint({"MissingPermission"})
    private boolean Or() {
        if (!this.FB || this.aXp == null) {
            return false;
        }
        return this.aXp.isEnabled();
    }

    @TargetApi(21)
    private ScanCallback a(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aXt;
        }
        this.aXt = new ScanCallback() { // from class: com.baidu.swan.apps.aj.c.a.a.1
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
        return this.aXt;
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
                    aVar.aXF = scanResult.getRssi();
                    aVar.aXG = a(scanResult);
                    aVar.aXH = scanResult.getScanRecord().getServiceUuids();
                    aVar.aXI = scanResult.getScanRecord().getDeviceName();
                    aVar.aXJ = scanResult.getScanRecord().getServiceData();
                    aVar.aXK = scanResult.getDevice();
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
            byte[] eq = com.baidu.swan.apps.aj.c.c.a.eq(keyAt);
            int length2 = eq.length;
            byte[] bArr = new byte[length + length2];
            System.arraycopy(eq, 0, bArr, 0, length2);
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
            if (aVar == null || aVar.aXK == null || TextUtils.isEmpty(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result --- wrong deviceData");
                }
            } else if (!z && this.aXw != null && this.aXw.containsKey(aVar.deviceId)) {
                if (DEBUG) {
                    Log.d("BluetoothManager", "report discovery result -- duplicate");
                }
            } else if (this.aXx != null) {
                this.aXx.put(aVar.deviceId, aVar);
            }
        }
        if (System.currentTimeMillis() - this.aXv < i) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- illegal interval, interval : " + i);
            }
        } else if (this.aXx == null || this.aXx.size() == 0) {
            if (DEBUG) {
                Log.d("BluetoothManager", "report discovery result -- none report device");
            }
        } else {
            this.aXv = System.currentTimeMillis();
            JSONObject r = r(0, "ok");
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, com.baidu.swan.apps.aj.c.b.a> entry : this.aXx.entrySet()) {
                if ((entry.getValue() instanceof com.baidu.swan.apps.aj.c.b.a) && (entry.getKey() instanceof String)) {
                    com.baidu.swan.apps.aj.c.b.a value = entry.getValue();
                    jSONArray.put(value.toJson());
                    String key = entry.getKey();
                    this.aXx.remove(key);
                    if (this.aXw == null) {
                        this.aXw = new ConcurrentHashMap();
                    }
                    this.aXw.put(key, value);
                }
            }
            try {
                r.put("devices", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c.i("bluetooth", "report discovery result -- result : " + r.toString());
            if (this.aXz != null) {
                this.aXz.f(this.aXz.aXn, r);
            }
        }
    }

    private BluetoothAdapter.LeScanCallback b(boolean z, final boolean z2, final int i) {
        if (!z) {
            return this.aXu;
        }
        this.aXu = new BluetoothAdapter.LeScanCallback() { // from class: com.baidu.swan.apps.aj.c.a.a.2
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
                if (a.DEBUG) {
                    Log.d("BluetoothManager", "start discovery -- get one result");
                }
                a.this.a(bluetoothDevice, i2, bArr, z2, i);
            }
        };
        return this.aXu;
    }

    @RequiresApi(api = 21)
    @SuppressLint({"MissingPermission"})
    public JSONObject Os() {
        if (!this.FB) {
            c.w("bluetooth", "stop discovery -- is not open");
            return r(10000, "not init");
        } else if (!Or()) {
            c.w("bluetooth", "stop discovery -- is not available");
            return r(10001, "not available");
        } else if (!this.aXs) {
            c.w("bluetooth", "stop discovery -- is not discovery");
            return r(0, "ok");
        } else {
            if (com.baidu.swan.apps.an.a.hasLollipop()) {
                if (this.aXq != null) {
                    c.i("bluetooth", "stop discovery -- stop success");
                    if (this.aXs) {
                        this.aXs = false;
                        Ou();
                    }
                    this.aXq.stopScan(a(false, true, 0));
                    return r(0, "ok");
                }
            } else if (this.aXp != null) {
                c.i("bluetooth", "stop discovery -- stop success");
                if (this.aXs) {
                    this.aXs = false;
                    Ou();
                }
                this.aXp.stopLeScan(b(false, true, 0));
                return r(0, "ok");
            }
            return r(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL, "system error");
        }
    }

    private void Ot() {
        if (this.aXr) {
            this.aXr = false;
            this.mContext.unregisterReceiver(this.aXB);
        }
    }

    private void Ou() {
        if (this.FB && this.aXz != null) {
            JSONObject r = r(0, "ok");
            try {
                r.put("available", Or());
                r.put("discovering", this.aXs);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (DEBUG) {
                Log.d("BluetoothManager", "report state change msg --- result : " + r.toString());
            }
            this.aXz.f(this.aXz.aXm, r);
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
        if (aXo != null) {
            aXo.BF();
        }
    }

    @RequiresApi(api = 21)
    private void BF() {
        if (this.aXs) {
            Os();
        }
        if (this.aXr) {
            Ot();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.mContext = null;
        this.aXp = null;
        this.aXq = null;
        this.aXt = null;
        this.aXu = null;
        this.aXw = null;
        this.aXx = null;
        this.aXy = null;
        this.FB = false;
        this.aXs = false;
        aXo = null;
    }
}
