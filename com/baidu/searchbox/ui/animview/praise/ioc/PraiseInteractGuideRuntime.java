package com.baidu.searchbox.ui.animview.praise.ioc;

import android.content.Context;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.ui.animview.praise.ComboPraiseManager;
@Autowired
/* loaded from: classes4.dex */
public final class PraiseInteractGuideRuntime {
    @Inject(force = false)
    public static IPraiseInteractGuideContext getContext() {
        return new IPraiseInteractGuideContext() { // from class: com.baidu.searchbox.ui.animview.praise.ioc.PraiseInteractGuideRuntime.1
            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IPraiseInteractGuideContext
            public void guideLuckMoney(Context context, String str, String str2, String str3, ComboPraiseManager.NotifyPraiseAnimCallBack notifyPraiseAnimCallBack) {
            }
        };
    }
}
