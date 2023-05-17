package com.baidu.searchbox.launch;

import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface IDyeConfig {
    public static final IDyeConfig EMPTY = new IDyeConfig() { // from class: com.baidu.searchbox.launch.IDyeConfig.1
        @Override // com.baidu.searchbox.launch.IDyeConfig
        public String getDyeConfig() {
            return null;
        }
    };
    public static final String LOG_TAG = "IDyeConfig";

    String getDyeConfig();

    /* loaded from: classes3.dex */
    public static final class Impl {
        public static IDyeConfig sHomeSearch = SmartLaunchRuntime.getDyeConfig();

        @NonNull
        public static IDyeConfig get() {
            if (sHomeSearch == null) {
                sHomeSearch = IDyeConfig.EMPTY;
            }
            return sHomeSearch;
        }
    }
}
