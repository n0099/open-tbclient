package com.baidu.searchbox.ui.animview.praise.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes4.dex */
public final class PraiseUBCRuntime {
    @Inject(force = false)
    public static IPraiseUBCContext getContext() {
        return new IPraiseUBCContext() { // from class: com.baidu.searchbox.ui.animview.praise.ioc.PraiseUBCRuntime.1
            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IPraiseUBCContext
            public void beginFlow(String str) {
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IPraiseUBCContext
            public void endFlowWithDuration(String str, String str2) {
            }

            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IPraiseUBCContext
            public void onEvent(String str, String str2) {
            }
        };
    }
}
