package com.baidu.searchbox.ui.animview.praise.ioc;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
@Autowired
/* loaded from: classes4.dex */
public class PraisePerformanceStrategyRuntime {
    @Inject(force = false)
    public static IPerformanceStrategyPraiseContext getContext() {
        return new IPerformanceStrategyPraiseContext() { // from class: com.baidu.searchbox.ui.animview.praise.ioc.PraisePerformanceStrategyRuntime.1
            @Override // com.baidu.searchbox.ui.animview.praise.ioc.IPerformanceStrategyPraiseContext
            public boolean isEnable() {
                return true;
            }
        };
    }
}
