package cn.jiguang.a.a.b;

import android.net.wifi.ScanResult;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class i implements Comparable<i> {
    public final String a;
    public final int b;
    public final String c;
    final /* synthetic */ h kN;

    public i(h hVar, ScanResult scanResult) {
        this.kN = hVar;
        this.a = scanResult.BSSID;
        this.b = scanResult.level;
        this.c = cn.jiguang.g.i.c(scanResult.SSID);
    }

    public i(h hVar, String str, int i, String str2) {
        this.kN = hVar;
        this.a = str;
        this.b = i;
        this.c = cn.jiguang.g.i.c(str2);
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mac_address", this.a);
            jSONObject.put("signal_strength", this.b);
            jSONObject.put("ssid", this.c);
            jSONObject.put("age", 0);
            jSONObject.put("itime", cn.jiguang.d.a.a.bG());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(i iVar) {
        return iVar.b - this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.c != null && this.c.equals(iVar.c) && this.a != null && this.a.equals(iVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() ^ this.a.hashCode();
    }

    public final String toString() {
        return "WifiInfo{bssid='" + this.a + "', dBm=" + this.b + ", ssid='" + this.c + "'}";
    }
}
