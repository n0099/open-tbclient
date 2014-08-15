package com.baidu.tbadk.core.account;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ba;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class n {
    public static AccountLoginHelper.OurToken a(AccountLoginHelper.OurToken ourToken) {
        AccountLoginHelper.OurToken ourToken2;
        String[] a;
        if (ourToken == null) {
            return null;
        }
        try {
            a = a();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (a != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK));
            arrayList.add(new BasicNameValuePair("tpl", "tb"));
            arrayList.add(new BasicNameValuePair("appid", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK));
            arrayList.add(new BasicNameValuePair("clientip", b()));
            arrayList.add(new BasicNameValuePair("cert_id", a[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SapiAccountManager.SESSION_BDUSS, ourToken.mBduss);
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, ourToken.mPtoken);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkApplication.m252getInst().getApp()));
            jSONObject.put("clientid", TbadkApplication.m252getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new b().a(a[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", a(arrayList, "6e93e7659ae637845c7f83abee68a740")));
            ae aeVar = new ae("http://passport.baidu.com/v2/sapi/bdusslogin");
            aeVar.a().a().d = false;
            aeVar.a().a().c = false;
            aeVar.a(arrayList);
            aeVar.a().a().a().d = true;
            aeVar.a().a().a().f = false;
            String h = aeVar.h();
            if (aeVar.a().b().b() && !ba.c(h)) {
                JSONObject jSONObject2 = new JSONObject(h);
                if ("0".equals(jSONObject2.optString("errno"))) {
                    ourToken2 = new AccountLoginHelper.OurToken();
                    ourToken2.mBduss = jSONObject2.optString(SapiAccountManager.SESSION_BDUSS);
                    ourToken2.mPtoken = jSONObject2.optString(SapiAccountManager.SESSION_PTOKEN);
                    ourToken2.mUsername = jSONObject2.optString("uname");
                    return ourToken2;
                }
            }
            ourToken2 = null;
            return ourToken2;
        }
        return null;
    }

    private static String[] a() {
        try {
            ae aeVar = new ae("http://passport.baidu.com/sslcrypt/get_last_cert");
            aeVar.a().a().d = false;
            aeVar.a().a().c = false;
            JSONObject jSONObject = new JSONObject(new String(aeVar.g()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String b() {
        if (com.baidu.adp.lib.network.willdelete.h.a()) {
            return UtilHelper.getWifiMac(TbadkApplication.m252getInst().getApp());
        }
        return UtilHelper.getGprsIpAddress();
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
                BdLog.e(e.getMessage());
            }
            stringBuffer.append("&");
        }
        stringBuffer.append("sign_key=" + str);
        return ab.a(stringBuffer.toString());
    }
}
