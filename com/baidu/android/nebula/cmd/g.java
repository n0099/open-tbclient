package com.baidu.android.nebula.cmd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f549a = new HashMap();
    private static final String b = GeoLocation.class.getPackage().getName() + ".";

    static {
        f549a.put("geolocation", b + "GeoLocation");
        f549a.put("getsearchboxinfo", b + "GetSearchboxInfo");
        f549a.put("getapn", b + "GetApn");
        f549a.put("getserviceinfo", b + "GetServiceInfo");
        f549a.put("getpackageinfo", b + "GetPackageInfo");
        f549a.put("sendintent", b + "SendIntent");
        f549a.put("getcuid", b + "GetCuid");
        f549a.put("getlocstring", b + "GetLocString");
        f549a.put("scandownloadfile", b + "ScanDownloadFile");
    }

    public String a(String str) {
        return (String) f549a.get(str);
    }

    public void a(String str, com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        k kVar;
        String a2 = a(str);
        if (a2 == null) {
            return;
        }
        try {
            kVar = (k) Class.forName(a2).newInstance();
        } catch (ClassCastException e) {
            kVar = null;
        } catch (ClassNotFoundException e2) {
            kVar = null;
        } catch (IllegalAccessException e3) {
            kVar = null;
        } catch (InstantiationException e4) {
            kVar = null;
        }
        if (kVar != null) {
            kVar.execute(dVar, aVar);
        }
    }
}
