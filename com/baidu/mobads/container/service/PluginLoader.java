package com.baidu.mobads.container.service;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.baidu.mobads.cid.DeviceId;
import com.baidu.mobads.container.remote.location.LocationDexLoader;
import com.baidu.mobads.container.remote.tdid.XSecurityDexLoader;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class PluginLoader {
    public static final String TAG = "PluginLoader";
    public static String mCuid = "";
    public static String mNcuid = "";
    public static String mTdid = "";
    public static String mZid = "";

    public static String getCuidFromGalaxy(Context context) {
        if (!TextUtils.isEmpty(mCuid)) {
            return mCuid;
        }
        String trustChainCUID = DeviceId.getTrustChainCUID(context);
        mCuid = trustChainCUID;
        return trustChainCUID;
    }

    public static String getLocation(Context context, String str) {
        return new LocationDexLoader(context, str).getLocString();
    }

    public static String getNCuidFrom27jar(Context context) {
        if (TextUtils.isEmpty(mNcuid) && context != null) {
            String trustChainCUID = DeviceId.getTrustChainCUID(context);
            if (TextUtils.isEmpty(trustChainCUID)) {
                mNcuid = "dt_" + DeviceId.getSelfCUID(context);
            } else {
                mNcuid = "t_" + trustChainCUID;
            }
            return mNcuid;
        }
        return mNcuid;
    }

    public static boolean getSslExemption(SslErrorHandler sslErrorHandler) {
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
            return true;
        }
        return false;
    }

    public static String getTdid(Context context) {
        if (!TextUtils.isEmpty(mTdid)) {
            return mTdid;
        }
        JSONObject securityInfo = XSecurityDexLoader.getInstance().getSecurityInfo(context);
        if (securityInfo != null) {
            mTdid = securityInfo.optString("tdid");
        }
        return mTdid;
    }

    public static String getZid(Context context) {
        if (!TextUtils.isEmpty(mZid)) {
            return mZid;
        }
        JSONObject securityInfo = XSecurityDexLoader.getInstance().getSecurityInfo(context);
        if (securityInfo != null) {
            mZid = securityInfo.optString("zid");
        }
        return mZid;
    }
}
