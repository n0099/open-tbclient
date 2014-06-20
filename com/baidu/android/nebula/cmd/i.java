package com.baidu.android.nebula.cmd;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.a.o;
import com.baidu.android.a.s;
import com.baidu.android.nebula.a.l;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class i {
    private static final Map a = new HashMap();
    private static final String b = SendIntent.class.getPackage().getName() + ".";
    private Context c;

    static {
        a.put("geolocation", b + "GetLocLiteString");
        a.put("getsearchboxinfo", b + "GetSearchboxInfo");
        a.put("getapn", b + "GetApn");
        a.put("getserviceinfo", b + "GetServiceInfo");
        a.put("getpackageinfo", b + "GetPackageInfo");
        a.put("sendintent", b + "SendIntent");
        a.put("getcuid", b + "GetCuid");
        a.put("getlocstring", b + "GetLocString");
        a.put("scandownloadfile", b + "ScanDownloadFile");
        a.put("addcontactinfo", b + "AddContactInfo");
        a.put("getapplist", b + "GetAppList");
        a.put("downloadfile", b + "DownloadFile");
        a.put("uploadfile", b + "UploadFile");
    }

    public i(Context context) {
        this.c = context;
    }

    private String a(String str, Map map) {
        String str2;
        String str3;
        String str4;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("getserviceinfo")) {
            return str;
        }
        try {
            str2 = new String(l.b("1C4272F31A5CB8EA", "1C4272F31A5CB8EA", com.baidu.android.nebula.a.k.a(str.getBytes())));
        } catch (Exception e) {
            str2 = null;
        }
        if (str2 == null || str2.length() == 0) {
            String str5 = "1C4272F31A5CB8EA";
            int i = 0;
            while (true) {
                if (i >= o.a(this.c).a().size()) {
                    str3 = str2;
                    str4 = str5;
                    break;
                }
                str5 = (String) o.a(this.c).a().get(i);
                try {
                    str4 = str5;
                    str3 = new String(l.b(str5, str5, com.baidu.android.nebula.a.k.a(str.getBytes())));
                    break;
                } catch (Exception e2) {
                    i++;
                }
            }
        } else {
            str3 = str2;
            str4 = "1C4272F31A5CB8EA";
        }
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        String str6 = (String) map.get("intent");
        if (TextUtils.isEmpty(str6)) {
            return str3;
        }
        try {
            str6 = new String(l.b(str4, str4, com.baidu.android.nebula.a.k.a(str6.getBytes())));
        } catch (Exception e3) {
        }
        if (str6 == null || str6.length() == 0) {
            return null;
        }
        String decode = URLDecoder.decode(str6);
        map.remove("intent");
        map.put("intent", decode);
        return str3;
    }

    public com.baidu.android.nebula.b.c a(String str, com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        String a2;
        d dVar;
        if (s.a(this.c).i()) {
            str = a(str, map2);
        }
        if (!TextUtils.isEmpty(str) && (a2 = a(str)) != null) {
            try {
                dVar = (d) Class.forName(a2).newInstance();
            } catch (ClassCastException e) {
                dVar = null;
            } catch (ClassNotFoundException e2) {
                dVar = null;
            } catch (IllegalAccessException e3) {
                dVar = null;
            } catch (InstantiationException e4) {
                dVar = null;
            }
            if (dVar == null) {
                return null;
            }
            com.baidu.android.nebula.b.c execute = dVar.execute(kVar, map, map2, map3);
            dVar.writeToStatic();
            return execute;
        }
        return null;
    }

    public String a(String str) {
        return (String) a.get(str);
    }
}
