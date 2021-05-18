package com.baidu.swan.apps.impl.nalib.encrypt;

import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.so.SoLoader;
@Keep
/* loaded from: classes2.dex */
public class EncryptConstant {
    static {
        SoLoader.load(AppRuntime.getAppContext(), "swan-native-lib");
    }

    public static native String getPartRecommendAesIv();

    public static native String getPartRecommendAesKey();
}
