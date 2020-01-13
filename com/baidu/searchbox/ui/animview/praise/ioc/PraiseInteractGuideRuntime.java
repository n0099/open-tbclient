package com.baidu.searchbox.ui.animview.praise.ioc;

import android.content.Context;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
/* loaded from: classes5.dex */
public final class PraiseInteractGuideRuntime {
    public static IPraiseInteractGuideContext getContext() {
        return new IPraiseInteractGuideContext() { // from class: com.baidu.searchbox.ui.animview.praise.ioc.PraiseInteractGuideRuntime.1
            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IPraiseInteractGuideContext
            public void guideLuckMoney(Context context, String str, String str2, String str3, ComboPraiseManager.NotifyPraiseAnimCallBack notifyPraiseAnimCallBack) {
            }
        };
    }
}
