package com.baidu.tbadk.core.account;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.u;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.az;
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
        String[] jD;
        if (ourToken == null) {
            return null;
        }
        try {
            jD = jD();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (jD != null) {
            ArrayList<BasicNameValuePair> arrayList = new ArrayList<>();
            arrayList.add(new BasicNameValuePair("crypttype", "1"));
            arrayList.add(new BasicNameValuePair("tpl", TbConfig.PassConfig.TPL));
            arrayList.add(new BasicNameValuePair("appid", "1"));
            arrayList.add(new BasicNameValuePair("clientip", jE()));
            arrayList.add(new BasicNameValuePair("cert_id", jD[0]));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SapiAccountManager.SESSION_BDUSS, ourToken.mBduss);
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, ourToken.mPtoken);
            jSONObject.put("cuid", DeviceId.getDeviceID(TbadkApplication.m251getInst().getApp()));
            jSONObject.put("clientid", TbadkApplication.m251getInst().getImei());
            arrayList.add(new BasicNameValuePair("userinfo", new b().z(jD[1], jSONObject.toString())));
            arrayList.add(new BasicNameValuePair("sig", a(arrayList, TbConfig.PassConfig.ENC_KEY)));
            ac acVar = new ac(TbConfig.PassConfig.LOGIN_BDUSS_URL);
            acVar.mc().na().mIsNeedAddCommenParam = false;
            acVar.mc().na().mIsUseCurrentBDUSS = false;
            acVar.h(arrayList);
            acVar.mc().na().nd().Gm = true;
            acVar.mc().na().nd().mIsBaiduServer = false;
            String lA = acVar.lA();
            if (acVar.mc().nb().jq() && !az.aA(lA)) {
                JSONObject jSONObject2 = new JSONObject(lA);
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

    private static String[] jD() {
        try {
            ac acVar = new ac(TbConfig.PassConfig.GET_CERT_URL);
            acVar.mc().na().mIsNeedAddCommenParam = false;
            acVar.mc().na().mIsUseCurrentBDUSS = false;
            JSONObject jSONObject = new JSONObject(new String(acVar.lB()));
            return new String[]{jSONObject.optString("cert_id"), jSONObject.optString("cert")};
        } catch (Exception e) {
            return null;
        }
    }

    private static String jE() {
        if (com.baidu.adp.lib.util.j.fi()) {
            return UtilHelper.getWifiMac(TbadkApplication.m251getInst().getApp());
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
        return u.aE(stringBuffer.toString());
    }
}
