package com.baidu.android.nebula.cmd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
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
    }

    public String a(String str) {
        return (String) a.get(str);
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
