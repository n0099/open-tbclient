package com.baidu.android.bdutil.cuid.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.util.Base64Encoder;
/* loaded from: classes.dex */
public final class AppCuidHelper {
    public static final boolean DEBUG = false;
    public static final String TAG = "AppCuidHelper";
    public String mEnUid;
    public String mUid;
    public volatile String mUidFromGalaxy;

    /* loaded from: classes.dex */
    public static class Singleton {
        public static final AppCuidHelper INSTANCE = new AppCuidHelper();
    }

    private String generateUID(Context context) {
        return CommonParam.getCUID(context);
    }

    public static final AppCuidHelper getInstance() {
        return Singleton.INSTANCE;
    }

    private synchronized String getUid() {
        if (AppRuntime.getAppContext() == null) {
            return null;
        }
        if (TextUtils.isEmpty(this.mUidFromGalaxy)) {
            this.mUidFromGalaxy = generateUID(AppRuntime.getAppContext());
        }
        return this.mUidFromGalaxy;
    }

    private void initUid() {
        this.mUid = getUid();
        this.mEnUid = new String(Base64Encoder.B64Encode(this.mUid.getBytes()));
    }

    public String getmEnUid() {
        if (TextUtils.isEmpty(this.mEnUid)) {
            initUid();
        }
        return this.mEnUid;
    }

    public String getmUid() {
        if (TextUtils.isEmpty(this.mUid)) {
            initUid();
        }
        return this.mUid;
    }

    public AppCuidHelper() {
        initUid();
    }
}
