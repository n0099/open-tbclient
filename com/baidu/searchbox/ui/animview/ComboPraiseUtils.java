package com.baidu.searchbox.ui.animview;

import com.baidu.searchbox.ui.animview.praise.ioc.ComboPraiseRuntime;
import com.baidu.searchbox.ui.animview.praise.ioc.PraisePerformanceStrategyRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/ui/animview/ComboPraiseUtils;", "", "()V", "getPraiseSwitch", "", "isPraisePerformanceStrategyEnable", "lib-praise_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ComboPraiseUtils {
    public static final ComboPraiseUtils INSTANCE = new ComboPraiseUtils();

    @JvmStatic
    public static final boolean getPraiseSwitch() {
        return ComboPraiseRuntime.getContext().getPraiseSwitchState();
    }

    @JvmStatic
    public static final boolean isPraisePerformanceStrategyEnable() {
        return PraisePerformanceStrategyRuntime.getContext().isEnable();
    }
}
