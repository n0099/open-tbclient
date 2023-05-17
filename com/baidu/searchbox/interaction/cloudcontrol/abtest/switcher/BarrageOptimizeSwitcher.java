package com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher;

import com.baidu.searchbox.interaction.cloudcontrol.abtest.InteractionAbTestSwitcher;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0006\u0010\u0007\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"BARRAGE_OPTIMIZE_SWITCHER", "", "barrageOptimizeSwitcher", "Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "", "getBarrageOptimizeSwitcher", "()Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "getBarrageOptimizeSwitch", "lib-interaction-cloudcontrol_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "BarrageOptimizeSwitcher")
/* loaded from: classes3.dex */
public final class BarrageOptimizeSwitcher {
    public static final String BARRAGE_OPTIMIZE_SWITCHER = "feed_video_barrage_optimize";
    public static final InteractionAbTestSwitcher<Boolean> barrageOptimizeSwitcher = new InteractionAbTestSwitcher<>(BARRAGE_OPTIMIZE_SWITCHER, Boolean.FALSE);

    public static final boolean getBarrageOptimizeSwitch() {
        return barrageOptimizeSwitcher.getSwitcherValue().booleanValue();
    }

    public static final InteractionAbTestSwitcher<Boolean> getBarrageOptimizeSwitcher() {
        return barrageOptimizeSwitcher;
    }
}
