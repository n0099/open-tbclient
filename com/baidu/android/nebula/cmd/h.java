package com.baidu.android.nebula.cmd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class h {
    private static final Map a = new HashMap();
    private static final String b = GeoLocation.class.getPackage().getName() + ".";

    static {
        a.put("geolocation", b + "GeoLocation");
        a.put("getsearchboxinfo", b + "GetSearchboxInfo");
        a.put("getapn", b + "GetApn");
        a.put("getserviceinfo", b + "GetServiceInfo");
        a.put("getpackageinfo", b + "GetPackageInfo");
        a.put("sendintent", b + "SendIntent");
        a.put("getcuid", b + "GetCuid");
        a.put("getlocstring", b + "GetLocString");
        a.put("scandownloadfile", b + "ScanDownloadFile");
    }

    public String a(String str) {
        return (String) a.get(str);
    }

    public void a(String str, com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
        n nVar;
        String a2 = a(str);
        if (a2 == null) {
            return;
        }
        try {
            nVar = (n) Class.forName(a2).newInstance();
        } catch (ClassCastException e) {
            nVar = null;
        } catch (ClassNotFoundException e2) {
            nVar = null;
        } catch (IllegalAccessException e3) {
            nVar = null;
        } catch (InstantiationException e4) {
            nVar = null;
        }
        if (nVar != null) {
            nVar.execute(dVar, aVar);
            nVar.writeToStatic();
        }
    }
}
