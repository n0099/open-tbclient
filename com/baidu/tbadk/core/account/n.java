package com.baidu.tbadk.core.account;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.z;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.bf;
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
        String[] mg;
        if (ourToken == null) {
            return null;
        }
        try {
            mg = mg();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (mg != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", mh()));
            arrayList.add(new BasicNameValuePair("cert_id", mg[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SapiAccountManager.SESSION_BDUSS, ourToken.mBduss);
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, ourToken.mPtoken);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkCoreApplication.m255getInst().getApp()));
            jSONObject.put("clientid", TbadkCoreApplication.m255getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new b().N(mg[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", a(arrayList, TbConfig.PassConfig.ENC_KEY)));
            ad adVar = new ad(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            adVar.oS().pZ().mIsNeedAddCommenParam = false;
            adVar.oS().pZ().mIsUseCurrentBDUSS = false;
            adVar.r(arrayList);
            adVar.oS().pZ().qc().KN = true;
            adVar.oS().pZ().qc().mIsBaiduServer = false;
            String or = adVar.or();
            if (adVar.oS().qa().lT() && !bf.isEmpty(or)) {
                JSONObject jSONObject2 = new JSONObject(or);
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

    private static String[] mg() {
        try {
            ad adVar = new ad(TbConfig.PassConfig.GET_CERT_URL);
            adVar.oS().pZ().mIsNeedAddCommenParam = false;
            adVar.oS().pZ().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(adVar.os()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String mh() {
        if (com.baidu.adp.lib.util.i.fg()) {
            return UtilHelper.getWifiMac(TbadkCoreApplication.m255getInst().getApp());
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
        return z.toMd5(stringBuffer.toString());
    }
}
