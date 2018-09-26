package cn.jiguang.a.a.b;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class h {
    private Context b;
    private JSONArray c;
    private WifiManager kg;

    public h(Context context) {
        this.b = null;
        this.kg = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.b = context;
    }

    private List<i> a(JSONArray jSONArray) {
        ArrayList arrayList;
        i iVar;
        int i;
        if (d()) {
            WifiInfo connectionInfo = this.kg.getConnectionInfo();
            i iVar2 = connectionInfo != null ? new i(this, connectionInfo.getBSSID(), connectionInfo.getRssi(), connectionInfo.getSSID()) : null;
            ArrayList arrayList2 = new ArrayList();
            if (iVar2 != null) {
                JSONObject a = iVar2.a();
                a.put("tag", "connect");
                jSONArray.put(a);
            }
            List<ScanResult> scanResults = Build.VERSION.SDK_INT < 23 ? this.kg.getScanResults() : (this.b == null || !cn.jiguang.g.a.a(this.b, "android.permission.ACCESS_COARSE_LOCATION")) ? null : this.kg.getScanResults();
            if (scanResults != null && scanResults.size() > 0) {
                int i2 = SapiErrorCode.NETWORK_FAILED;
                i iVar3 = null;
                for (ScanResult scanResult : scanResults) {
                    i iVar4 = new i(this, scanResult);
                    if (iVar2 != null && !iVar2.equals(iVar4)) {
                        arrayList2.add(iVar4);
                        if (!iVar4.c.equals(iVar2.c) && iVar4.b > i2) {
                            i = iVar4.b;
                            iVar = iVar4;
                            iVar3 = iVar;
                            i2 = i;
                        }
                    }
                    iVar = iVar3;
                    i = i2;
                    iVar3 = iVar;
                    i2 = i;
                }
                Collections.sort(arrayList2);
                int i3 = 10;
                if (iVar3 != null) {
                    JSONObject a2 = iVar3.a();
                    a2.put("tag", "strongest");
                    jSONArray.put(a2);
                    arrayList2.remove(iVar3);
                    i3 = 9;
                }
                if (iVar2 != null) {
                    arrayList2.remove(iVar2);
                    i3--;
                }
                if (arrayList2.size() > i3) {
                    List subList = arrayList2.subList(0, i3);
                    arrayList = new ArrayList();
                    arrayList.addAll(subList);
                    return arrayList;
                }
            }
            arrayList = arrayList2;
            return arrayList;
        }
        return null;
    }

    private boolean d() {
        try {
            return this.kg.isWifiEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public final void a() {
        this.c = null;
    }

    public final void b() {
        if (cn.jiguang.g.a.a(this.b, "android.permission.ACCESS_WIFI_STATE")) {
            Context context = this.b;
            if (((cn.jiguang.g.a.a(context, "android.permission.ACCESS_COARSE_LOCATION") && cn.jiguang.g.a.a(context, "android.permission.ACCESS_WIFI_STATE") && cn.jiguang.g.a.a(context, "android.permission.CHANGE_WIFI_STATE") && cn.jiguang.g.a.a(context, "android.permission.ACCESS_FINE_LOCATION")) || cn.jiguang.g.a.ar(this.b)) && this.kg.isWifiEnabled()) {
                JSONArray jSONArray = new JSONArray();
                try {
                    List<i> a = a(jSONArray);
                    if (a != null) {
                        a.size();
                    }
                    if (a != null) {
                        for (i iVar : a) {
                            jSONArray.put(iVar.a());
                        }
                    }
                } catch (Throwable th) {
                }
                this.c = jSONArray;
            }
        }
    }

    public final JSONArray c() {
        return this.c;
    }
}
