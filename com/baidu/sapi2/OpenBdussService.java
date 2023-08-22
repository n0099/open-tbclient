package com.baidu.sapi2;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.OpenBdussResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class OpenBdussService extends AbstractService implements NoProguard {
    public Context context;

    public OpenBdussService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
        this.context = sapiConfiguration.context;
    }

    public int getBdussState() {
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String cookieBduss = SapiUtils.getCookieBduss();
        if (currentAccount == null && TextUtils.isEmpty(cookieBduss)) {
            return 1;
        }
        if (currentAccount == null && !TextUtils.isEmpty(cookieBduss)) {
            return 2;
        }
        if (currentAccount != null && TextUtils.isEmpty(cookieBduss)) {
            return 3;
        }
        if (currentAccount != null && !cookieBduss.equals(currentAccount.bduss)) {
            return 4;
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00de A[LOOP:1: B:32:0x00d6->B:34:0x00de, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getOpenBduss(final GetOpenBdussDTO getOpenBdussDTO, final GetOpenBdussCallback getOpenBdussCallback) {
        Map<String, String> map;
        HttpHashMapWrap httpHashMapWrap;
        List<String> list;
        boolean z;
        SapiUtils.notNull(getOpenBdussCallback, "GetOpenBdussCallback can't be null");
        SapiUtils.notNull(getOpenBdussDTO, "GetOpenBdussDTO can't be null");
        SapiUtils.notEmpty(getOpenBdussDTO.clientId, "GetOpenBdussDTO.clientId can't empty");
        final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            OpenBdussResult openBdussResult = new OpenBdussResult();
            openBdussResult.setResultCode(-901);
            getOpenBdussCallback.onFailure(openBdussResult);
            return;
        }
        final OpenBdussResult fromJson = OpenBdussResult.fromJson(SapiContext.getInstance().getDecryptStr(SapiContext.KEY_OPEN_BDUSS_INFO));
        if (fromJson != null && fromJson.getResultCode() == 0) {
            if (SecurityUtil.md5((currentAccount.bduss + getOpenBdussDTO.clientId).getBytes(), false).equals(fromJson.flag)) {
                Iterator<String> it = getOpenBdussDTO.targetTplList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!fromJson.tplStokenMap.containsKey(it.next())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    fromJson.flag = "";
                    getOpenBdussCallback.onSuccess(fromJson);
                    return;
                }
                httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.put("client_id", getOpenBdussDTO.clientId);
                httpHashMapWrap.put("bduss", currentAccount.bduss);
                httpHashMapWrap.put("ptoken", currentAccount.ptoken);
                httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_OPEN_BDUSS));
                list = getOpenBdussDTO.targetTplList;
                if (list != null && list.size() > 0) {
                    String str = getOpenBdussDTO.targetTplList.get(0);
                    for (int i = 1; i < getOpenBdussDTO.targetTplList.size(); i++) {
                        str = str + "|" + getOpenBdussDTO.targetTplList.get(i);
                    }
                    httpHashMapWrap.put("tpl_list", str);
                }
                new HttpClientWrap().post(SapiEnv.GET_OPEN_BDUSS, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.OpenBdussService.1
                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFailure(Throwable th, int i2, String str2) {
                        OpenBdussResult openBdussResult2 = new OpenBdussResult();
                        openBdussResult2.setResultCode(i2);
                        getOpenBdussCallback.onFailure(openBdussResult2);
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFinish() {
                        getOpenBdussCallback.onFinish();
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onStart() {
                        getOpenBdussCallback.onStart();
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onSuccess(int i2, String str2) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (!TextUtils.isEmpty(jSONObject.optString("uid"))) {
                                jSONObject.put("bduss", currentAccount.bduss);
                            }
                            jSONObject.put("flag", SecurityUtil.md5((currentAccount.bduss + getOpenBdussDTO.clientId).getBytes(), false));
                            jSONObject.put("displayname", currentAccount.displayname);
                            OpenBdussResult fromJson2 = OpenBdussResult.fromJson(jSONObject.toString());
                            if (fromJson2 != null && fromJson2.getResultCode() == 0) {
                                OpenBdussResult openBdussResult2 = fromJson;
                                if (openBdussResult2 != null && openBdussResult2.tplStokenMap.size() > 0) {
                                    fromJson2.tplStokenMap.putAll(fromJson.tplStokenMap);
                                }
                                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, fromJson2.toJson().toString());
                                fromJson2.flag = "";
                                getOpenBdussCallback.onSuccess(fromJson2);
                                return;
                            }
                            getOpenBdussCallback.onFailure(fromJson2);
                        } catch (Exception e) {
                            Log.e(e);
                            OpenBdussResult openBdussResult3 = new OpenBdussResult();
                            openBdussResult3.setResultCode(-202);
                            getOpenBdussCallback.onFailure(openBdussResult3);
                        }
                    }
                });
            }
        }
        SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
        if (fromJson != null && (map = fromJson.tplStokenMap) != null) {
            map.clear();
        }
        httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("client_id", getOpenBdussDTO.clientId);
        httpHashMapWrap.put("bduss", currentAccount.bduss);
        httpHashMapWrap.put("ptoken", currentAccount.ptoken);
        httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_OPEN_BDUSS));
        list = getOpenBdussDTO.targetTplList;
        if (list != null) {
            String str2 = getOpenBdussDTO.targetTplList.get(0);
            while (i < getOpenBdussDTO.targetTplList.size()) {
            }
            httpHashMapWrap.put("tpl_list", str2);
        }
        new HttpClientWrap().post(SapiEnv.GET_OPEN_BDUSS, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.OpenBdussService.1
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i2, String str22) {
                OpenBdussResult openBdussResult2 = new OpenBdussResult();
                openBdussResult2.setResultCode(i2);
                getOpenBdussCallback.onFailure(openBdussResult2);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                getOpenBdussCallback.onFinish();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                getOpenBdussCallback.onStart();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i2, String str22) {
                try {
                    JSONObject jSONObject = new JSONObject(str22);
                    if (!TextUtils.isEmpty(jSONObject.optString("uid"))) {
                        jSONObject.put("bduss", currentAccount.bduss);
                    }
                    jSONObject.put("flag", SecurityUtil.md5((currentAccount.bduss + getOpenBdussDTO.clientId).getBytes(), false));
                    jSONObject.put("displayname", currentAccount.displayname);
                    OpenBdussResult fromJson2 = OpenBdussResult.fromJson(jSONObject.toString());
                    if (fromJson2 != null && fromJson2.getResultCode() == 0) {
                        OpenBdussResult openBdussResult2 = fromJson;
                        if (openBdussResult2 != null && openBdussResult2.tplStokenMap.size() > 0) {
                            fromJson2.tplStokenMap.putAll(fromJson.tplStokenMap);
                        }
                        SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, fromJson2.toJson().toString());
                        fromJson2.flag = "";
                        getOpenBdussCallback.onSuccess(fromJson2);
                        return;
                    }
                    getOpenBdussCallback.onFailure(fromJson2);
                } catch (Exception e) {
                    Log.e(e);
                    OpenBdussResult openBdussResult3 = new OpenBdussResult();
                    openBdussResult3.setResultCode(-202);
                    getOpenBdussCallback.onFailure(openBdussResult3);
                }
            }
        });
    }

    public void logout() {
        ThreadPoolService.getInstance().run(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.OpenBdussService.2
            @Override // java.lang.Runnable
            public void run() {
                SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
                try {
                    ArrayList arrayList = new ArrayList();
                    for (String str : SapiContext.getInstance().getOpenBdussDomains()) {
                        arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str, SapiUtils.buildBDUSSCookie(str, "OPENBDUSS", "")));
                    }
                    SapiUtils.syncCookies(OpenBdussService.this.context, arrayList);
                } catch (Throwable th) {
                    Log.e(th);
                }
            }
        }));
    }
}
