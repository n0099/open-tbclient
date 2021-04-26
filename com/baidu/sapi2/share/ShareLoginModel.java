package com.baidu.sapi2.share;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.ShareModelCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class ShareLoginModel {
    public static ShareLoginModel instance;

    public static ShareLoginModel getInstance() {
        if (instance == null) {
            synchronized (ShareLoginModel.class) {
                if (instance == null) {
                    instance = new ShareLoginModel();
                }
            }
        }
        return instance;
    }

    public void getShareModels(long j, ShareModelCallback shareModelCallback) {
        if (j <= 0) {
            throw new IllegalArgumentException("must timeoutMills > 0");
        }
        if (shareModelCallback == null) {
            return;
        }
        if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_SHARE_V3_EXTERNAL_RECOVERY).isMeetGray()) {
            shareModelCallback.onReceiveShareModels(getV2ShareModelList(null));
            return;
        }
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (sapiConfiguration == null) {
            Log.d(ShareUtils.TAG, "getShareModels config is null");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else if (!SapiUtils.isOnline(sapiConfiguration.context)) {
            Log.d(ShareUtils.TAG, "getShareModels environment is not online");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else if (sapiConfiguration.loginShareStrategy() == LoginShareStrategy.DISABLED) {
            Log.d(ShareUtils.TAG, "getShareModels config loginShareStrategy is not DISABLED");
            shareModelCallback.onReceiveShareModels(new ArrayList(0));
        } else {
            ShareUtils.getShareModels(j, sapiConfiguration.context, sapiConfiguration.tpl, shareModelCallback);
        }
    }

    public List<ShareStorage.StorageModel> getV2ShareModelList(String str) {
        Log.d(ShareUtils.TAG, "build version is " + Build.VERSION.SDK_INT);
        SapiStatUtil.statLoadLogin("product_line_call");
        List<ShareStorage.StorageModel> shareStorageModel = ShareUtils.getShareStorageModel();
        if (shareStorageModel != null && shareStorageModel.size() > 0) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new PassNameValuePair("extrajson", str));
            }
            SapiStatUtil.statShareV2Open(shareStorageModel, "product_line_call", arrayList);
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(shareStorageModel != null ? shareStorageModel.size() : 0);
        hashMap.put("shareModels", sb.toString());
        StatService.onEventAutoStat(ShareStatKey.CHECK_SHARE_V2_LOGIN_AVAILABLE, hashMap);
        return shareStorageModel;
    }
}
