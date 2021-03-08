package com.baidu.swan.apps.impl.nalib.encrypt;

import androidx.annotation.Keep;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.games.utils.so.SoLoader;
@Keep
/* loaded from: classes8.dex */
public class EncryptConstant {
    public static native String getPartRecommendAesIv();

    public static native String getPartRecommendAesKey();

    static {
        SoLoader.load(AppRuntime.getAppContext(), "swan-native-lib");
    }
}
