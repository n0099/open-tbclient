package com.baidu.android.bdutil.cuid.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.CommonParam;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.util.Base64Encoder;
/* loaded from: classes4.dex */
final class AppCuidHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "AppCuidHelper";
    private String mEnUid;
    private String mUid;
    private volatile String mUidFromGalaxy;

    /* loaded from: classes4.dex */
    private static class Singleton {
        private static final AppCuidHelper INSTANCE = new AppCuidHelper();

        private Singleton() {
        }
    }

    private AppCuidHelper() {
        initUid();
    }

    public static final AppCuidHelper getInstance() {
        return Singleton.INSTANCE;
    }

    public String getmUid() {
        if (TextUtils.isEmpty(this.mUid)) {
            initUid();
        }
        return this.mUid;
    }

    public String getmEnUid() {
        if (TextUtils.isEmpty(this.mEnUid)) {
            initUid();
        }
        return this.mEnUid;
    }

    private void initUid() {
        this.mUid = getUid();
        this.mEnUid = new String(Base64Encoder.B64Encode(this.mUid.getBytes()));
    }

    private synchronized String getUid() {
        String str;
        if (AppRuntime.getAppContext() == null) {
            str = null;
        } else {
            if (TextUtils.isEmpty(this.mUidFromGalaxy)) {
                this.mUidFromGalaxy = generateUID(AppRuntime.getAppContext());
            }
            str = this.mUidFromGalaxy;
        }
        return str;
    }

    private String generateUID(Context context) {
        return CommonParam.getCUID(context);
    }
}
