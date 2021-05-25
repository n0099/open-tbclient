package com.baidu.android.imsdk.group.request;

import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public abstract class FansGroupBaseHttpRequest extends GroupBaseHttpRequest {
    public String getCommonParams() throws NoSuchAlgorithmException {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long appid = AccountManager.getAppid(this.mContext);
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        return "&appid=" + appid + "&source=0&cuid=" + Utility.getDeviceId(this.mContext) + "&app_version=" + AccountManagerImpl.getInstance(this.mContext).getAppVersion() + "&sdk_version=" + IMConfigInternal.getInstance().getSDKVersionValue(this.mContext) + "&timestamp=" + currentTimeMillis + "&sign=" + getMd5("" + currentTimeMillis + bduss + appid);
    }

    @Override // com.baidu.android.imsdk.group.request.GroupBaseHttpRequest, com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/2.0/im/groupchatv1";
    }
}
