package com.baidu.android.nebula.cmd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f542a = new HashMap();
    private static final String b = GeoLocation.class.getPackage().getName() + ".";

    static {
        f542a.put("geolocation", b + "GeoLocation");
        f542a.put("getsearchboxinfo", b + "GetSearchboxInfo");
        f542a.put("getapn", b + "GetApn");
        f542a.put("getserviceinfo", b + "GetServiceInfo");
        f542a.put("getpackageinfo", b + "GetPackageInfo");
        f542a.put("sendintent", b + "SendIntent");
        f542a.put("getcuid", b + "GetCuid");
        f542a.put("getlocstring", b + "GetLocString");
        f542a.put("scandownloadfile", b + "ScanDownloadFile");
    }

    public String a(String str) {
        return (String) f542a.get(str);
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
