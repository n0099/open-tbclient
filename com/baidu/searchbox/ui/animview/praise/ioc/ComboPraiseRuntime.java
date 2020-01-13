package com.baidu.searchbox.ui.animview.praise.ioc;

import android.content.Context;
/* loaded from: classes5.dex */
public final class ComboPraiseRuntime {
    public static IComboPraiseContext getContext() {
        return new IComboPraiseContext() { // from class: com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime.1
            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext
            public void notifyPraiseAnimationEvent(Context context, String str, String str2) {
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IComboPraiseContext
            public boolean getPraiseSwitchState() {
                return false;
            }
        };
    }
}
