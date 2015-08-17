package com.baidu.searchbox.plugin.api;
/* loaded from: classes.dex */
public final class CardPluginManager {

    /* loaded from: classes.dex */
    public interface OnPluginAddCardsListener {
        public static final int FAILED = 1;
        public static final int SUCCESS = 0;

        void onResult(int i);
    }
}
