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
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.TPRunnable;
import com.baidu.sapi2.utils.ThreadPoolService;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class OpenBdussService extends AbstractService {
    private Context context;

    public OpenBdussService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
        this.context = sapiConfiguration.context;
    }

    public void getOpenBduss(final GetOpenBdussDTO getOpenBdussDTO, final GetOpenBdussCallback getOpenBdussCallback) {
        boolean z;
        int i = 1;
        SapiUtils.notNull(getOpenBdussCallback, "GetOpenBdussCallback can't be null");
        SapiUtils.notNull(getOpenBdussDTO, "GetOpenBdussDTO can't be null");
        SapiUtils.notEmpty(getOpenBdussDTO.clientId, "GetOpenBdussDTO.clientId can't empty");
        ServiceManager.getInstance().getIsAccountManager();
        final SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (currentAccount == null) {
            OpenBdussResult openBdussResult = new OpenBdussResult();
            openBdussResult.setResultCode(OpenBdussResult.ERROR_CODE_NOT_LOGIN);
            getOpenBdussCallback.onFailure(openBdussResult);
            return;
        }
        final OpenBdussResult fromJson = OpenBdussResult.fromJson(SapiContext.getInstance().getDecryptStr(SapiContext.KEY_OPEN_BDUSS_INFO));
        if (fromJson != null && fromJson.getResultCode() == 0 && SecurityUtil.md5((currentAccount.bduss + getOpenBdussDTO.clientId).getBytes(), false).equals(fromJson.flag)) {
            Iterator<String> it = getOpenBdussDTO.targetTplList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!fromJson.tplStokenMap.containsKey(it.next())) {
                    z = false;
                    break;
                }
            }
            if (z) {
                fromJson.flag = "";
                getOpenBdussCallback.onSuccess(fromJson);
                return;
            }
        } else {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, "");
            if (fromJson != null && fromJson.tplStokenMap != null) {
                fromJson.tplStokenMap.clear();
            }
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("client_id", getOpenBdussDTO.clientId);
        httpHashMapWrap.put("bduss", currentAccount.bduss);
        httpHashMapWrap.put("ptoken", currentAccount.ptoken);
        httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, SapiDeviceInfo.getDeviceInfo(com.baidu.sapi2.utils.h.J));
        if (getOpenBdussDTO.targetTplList != null && getOpenBdussDTO.targetTplList.size() > 0) {
            String str = getOpenBdussDTO.targetTplList.get(0);
            while (i < getOpenBdussDTO.targetTplList.size()) {
                String str2 = str + "|" + getOpenBdussDTO.targetTplList.get(i);
                i++;
                str = str2;
            }
            httpHashMapWrap.put("tpl_list", str);
        }
        new HttpClientWrap().post(com.baidu.sapi2.utils.h.J, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.OpenBdussService.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                getOpenBdussCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i2, String str3) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if (!TextUtils.isEmpty(jSONObject.optString("uid"))) {
                        jSONObject.put("bduss", currentAccount.bduss);
                    }
                    jSONObject.put(FrsActivityConfig.FLAG, SecurityUtil.md5((currentAccount.bduss + getOpenBdussDTO.clientId).getBytes(), false));
                    jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, currentAccount.displayname);
                    OpenBdussResult fromJson2 = OpenBdussResult.fromJson(jSONObject.toString());
                    if (fromJson2 == null || fromJson2.getResultCode() != 0) {
                        getOpenBdussCallback.onFailure(fromJson2);
                        return;
                    }
                    if (fromJson != null && fromJson.tplStokenMap.size() > 0) {
                        fromJson2.tplStokenMap.putAll(fromJson.tplStokenMap);
                    }
                    SapiContext.getInstance().putEncryptStr(SapiContext.KEY_OPEN_BDUSS_INFO, fromJson2.toJson().toString());
                    fromJson2.flag = "";
                    getOpenBdussCallback.onSuccess(fromJson2);
                } catch (Exception e) {
                    Log.e(e);
                    OpenBdussResult openBdussResult2 = new OpenBdussResult();
                    openBdussResult2.setResultCode(-202);
                    getOpenBdussCallback.onFailure(openBdussResult2);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i2, String str3) {
                OpenBdussResult openBdussResult2 = new OpenBdussResult();
                openBdussResult2.setResultCode(i2);
                getOpenBdussCallback.onFailure(openBdussResult2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                getOpenBdussCallback.onFinish();
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
        if (!cookieBduss.equals(currentAccount.bduss)) {
            return 4;
        }
        return 0;
    }
}
