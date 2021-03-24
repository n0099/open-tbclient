package com.baidu.down.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.common.util.CommonParam;
/* loaded from: classes2.dex */
public class IdentityManager {
    public static final boolean DEBUG = false;
    public static final String TAG = "IdentityManager";
    public static IdentityManager sIdentityManager;
    public Context mContext;
    public String mCuid;
    public String mEncodeCuid;

    public IdentityManager(Context context) {
        init(context);
    }

    public static synchronized IdentityManager getInstance(Context context) {
        IdentityManager identityManager;
        synchronized (IdentityManager.class) {
            if (sIdentityManager == null) {
                sIdentityManager = new IdentityManager(context);
            }
            identityManager = sIdentityManager;
        }
        return identityManager;
    }

    public String getEncodedUid() {
        if (!TextUtils.isEmpty(this.mEncodeCuid)) {
            return this.mEncodeCuid;
        }
        String encodedValue = Utils.getEncodedValue(getUid());
        if (!TextUtils.isEmpty(encodedValue)) {
            byte[] encode = Base64.encode(encodedValue.getBytes(), 0);
            if (encode != null) {
                this.mEncodeCuid = Utils.getEncodedValue(new String(encode));
            }
        } else {
            this.mEncodeCuid = "";
        }
        return this.mEncodeCuid;
    }

    public String getUid() {
        if (!TextUtils.isEmpty(this.mCuid)) {
            return this.mCuid;
        }
        String string = DownPrefUtils.getString(this.mContext, "uid_v3", "");
        if (TextUtils.isEmpty(string)) {
            try {
                string = CommonParam.getCUID(this.mContext);
            } catch (Exception unused) {
            }
            DownPrefUtils.setString(this.mContext, "uid_v3", string);
        }
        return string;
    }

    public void init(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public String processCommonParams(String str) {
        UriHelper uriHelper = new UriHelper(str);
        uriHelper.addParameterReplaceIfExist("from", "as");
        uriHelper.addParameterReplaceIfExist("sdk_ver", Constants.SDK_VER);
        uriHelper.addParameterReplaceIfExist("uid", getInstance(this.mContext).getEncodedUid());
        uriHelper.addParameterReplaceIfExist("network", Utils.getWifiOr2gOr3G(this.mContext));
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);
            uriHelper.addParameterReplaceIfExist("ver", packageInfo.versionCode + "");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        return uriHelper.toString();
    }
}
