package com.baidu.android.nebula.cmd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f656a = new HashMap();
    private static final String b = GeoLocation.class.getPackage().getName() + ".";

    static {
        f656a.put("geolocation", b + "GeoLocation");
        f656a.put("getsearchboxinfo", b + "GetSearchboxInfo");
        f656a.put("getapn", b + "GetApn");
        f656a.put("getserviceinfo", b + "GetServiceInfo");
        f656a.put("getpackageinfo", b + "GetPackageInfo");
        f656a.put("sendintent", b + "SendIntent");
        f656a.put("getcuid", b + "GetCuid");
        f656a.put("getlocstring", b + "GetLocString");
        f656a.put("scandownloadfile", b + "ScanDownloadFile");
    }

    public String a(String str) {
        return (String) f656a.get(str);
    }

    public void a(String str, com.baidu.android.nebula.b.a aVar, com.baidu.android.nebula.b.b bVar) {
        e eVar;
        String a2 = a(str);
        if (a2 == null) {
            return;
        }
        try {
            eVar = (e) Class.forName(a2).newInstance();
        } catch (ClassCastException e) {
            eVar = null;
        } catch (ClassNotFoundException e2) {
            eVar = null;
        } catch (IllegalAccessException e3) {
            eVar = null;
        } catch (InstantiationException e4) {
            eVar = null;
        }
        if (eVar != null) {
            eVar.execute(aVar, bVar);
        }
    }
}
