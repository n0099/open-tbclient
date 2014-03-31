package com.baidu.tbadk.core.a;

import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.bc;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class x {
    public static n a(n nVar) {
        n nVar2;
        String[] a;
        if (nVar == null) {
            return null;
        }
        try {
            a = a();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(e.getMessage());
        }
        if (a != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", "tb"));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", com.baidu.adp.lib.network.willdelete.h.a() ? UtilHelper.f(TbadkApplication.j().b()) : UtilHelper.b()));
            arrayList.add(new BasicNameValuePair("cert_id", a[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bduss", nVar.a);
            jSONObject.put("ptoken", nVar.b);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkApplication.j().b()));
            jSONObject.put("clientid", TbadkApplication.j().C());
            arrayList.add(new BasicNameValuePair("userinfo", new p().a(a[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", a(arrayList, "6e93e7659ae637845c7f83abee68a740")));
            ak akVar = new ak("http://passport.baidu.com/v2/sapi/bdusslogin");
            akVar.a().a().d = false;
            akVar.a().a().c = false;
            akVar.a(arrayList);
            akVar.a().a().a().d = true;
            akVar.a().a().a().f = false;
            String i = akVar.i();
            if (akVar.a().b().b() && !bc.c(i)) {
                JSONObject jSONObject2 = new JSONObject(i);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    nVar2 = new n();
                    nVar2.a = jSONObject2.optString("bduss");
                    nVar2.b = jSONObject2.optString("ptoken");
                    nVar2.c = jSONObject2.optString("uname");
                    return nVar2;
                }
            }
            nVar2 = null;
            return nVar2;
        }
        return null;
    }

    private static String[] a() {
        try {
            ak akVar = new ak("http://passport.baidu.com/sslcrypt/get_last_cert");
            akVar.a().a().d = false;
            akVar.a().a().c = false;
            JSONObject jSONObject = new JSONObject(new String(akVar.h()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String a(ArrayList<BasicNameValuePair> arrayList, String str) {
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(arrayList.get(i).getName());
            hashMap.put(arrayList.get(i).getName(), arrayList.get(i).getValue());
        }
        Collections.sort(arrayList2);
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            stringBuffer.append(str2);
            stringBuffer.append("=");
            try {
                String str3 = (String) hashMap.get(str2);
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append(URLEncoder.encode(str3, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                com.baidu.adp.lib.util.f.b(e.getMessage());
            }
            stringBuffer.append("&");
        }
        stringBuffer.append("sign_key=" + str);
        return ah.a(stringBuffer.toString());
    }
}
