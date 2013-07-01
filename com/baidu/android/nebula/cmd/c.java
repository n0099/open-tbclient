package com.baidu.android.nebula.cmd;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f281a = new HashMap();
    private static final String b = GeoLocation.class.getPackage().getName() + ".";

    static {
        f281a.put("geolocation", b + "GeoLocation");
        f281a.put("getsearchboxinfo", b + "GetSearchboxInfo");
        f281a.put("getapn", b + "GetApn");
        f281a.put("getserviceinfo", b + "GetServiceInfo");
        f281a.put("getpackageinfo", b + "GetPackageInfo");
        f281a.put("sendintent", b + "SendIntent");
        f281a.put("getcuid", b + "GetCuid");
        f281a.put("getlocstring", b + "GetLocString");
    }

    public String a(String str) {
        return (String) f281a.get(str);
    }

    public void a(String str, com.baidu.android.nebula.a.d dVar, com.baidu.android.nebula.a.a aVar) {
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
            eVar.execute(dVar, aVar);
        }
    }
}
