package com.baidu.android.nebula.cmd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f665a = new HashMap();
    private static final String b = GeoLocation.class.getPackage().getName() + ".";

    static {
        f665a.put("geolocation", b + "GeoLocation");
        f665a.put("getsearchboxinfo", b + "GetSearchboxInfo");
        f665a.put("getapn", b + "GetApn");
        f665a.put("getserviceinfo", b + "GetServiceInfo");
        f665a.put("getpackageinfo", b + "GetPackageInfo");
        f665a.put("sendintent", b + "SendIntent");
        f665a.put("getcuid", b + "GetCuid");
        f665a.put("getlocstring", b + "GetLocString");
        f665a.put("scandownloadfile", b + "ScanDownloadFile");
    }

    public String a(String str) {
        return (String) f665a.get(str);
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
