package com.baidu.searchbox.interaction.cloudcontrol.debug;

import com.baidu.searchbox.debug.annotation.DebugInfoProvider;
import com.baidu.searchbox.debug.data.DebugDataGroupProvider;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher.BarrageOptimizeSwitcher;
import com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher.CommentInputBoxSwitcher;
import com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher.OutSideCommentDialogSwitcher;
import com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher.PraiseResourceLoadSwitcher;
import com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher.RewardUpdateSwitcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/interaction/cloudcontrol/debug/InteractionDebugProvider;", "Lcom/baidu/searchbox/debug/data/DebugDataGroupProvider;", "()V", "getChildItemList", "", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "getGroupName", "", "lib-interaction-cloudcontrol_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@DebugInfoProvider(enable = false, type = "Debug_Fetures")
/* loaded from: classes4.dex */
public final class InteractionDebugProvider extends DebugDataGroupProvider {
    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public String getGroupName() {
        return InteractionDebugProviderKt.GROUP_NAME;
    }

    @Override // com.baidu.searchbox.debug.data.DebugDataGroupProvider
    public List<DebugItemInfo> getChildItemList() {
        return CollectionsKt__CollectionsKt.mutableListOf(InteractionRadioGroupIteminfoKt.getItemInfo("打赏面板优化实验", RewardUpdateSwitcher.getRewardUpdateSwitcher().generateDebugSelectedKey(), RewardUpdateSwitcher.getRewardUpdateSwitcher().getKey(), RewardUpdateSwitcher.getRewardUpdateSwitcher().getDefaultValue(), new Pair("分支0：线上效果", Boolean.FALSE), new Pair("分支1：打赏面板优化", Boolean.TRUE)), InteractionRadioGroupIteminfoKt.getItemInfo("外露输入框实验", OutSideCommentDialogSwitcher.getOutSideCommentDialogSwitcher().generateDebugSelectedKey(), OutSideCommentDialogSwitcher.getOutSideCommentDialogSwitcher().getKey(), OutSideCommentDialogSwitcher.getOutSideCommentDialogSwitcher().getDefaultValue(), new Pair("分支0：线上效果", Boolean.FALSE), new Pair("分支1：外露输入框", Boolean.TRUE)), InteractionRadioGroupIteminfoKt.getItemInfo("竖屏评论输入框", CommentInputBoxSwitcher.getVerticalCommentInputSwitch().generateDebugSelectedKey(), CommentInputBoxSwitcher.getVerticalCommentInputSwitch().getKey(), CommentInputBoxSwitcher.getVerticalCommentInputSwitch().getDefaultValue(), new Pair("不出", 0), new Pair("emoji", 1), new Pair("热词", 2), new Pair("全部", 3)), InteractionRadioGroupIteminfoKt.getItemInfo("竖屏弹幕输入框", CommentInputBoxSwitcher.getVerticalDanmakuInputSwitch().generateDebugSelectedKey(), CommentInputBoxSwitcher.getVerticalDanmakuInputSwitch().getKey(), CommentInputBoxSwitcher.getVerticalDanmakuInputSwitch().getDefaultValue(), new Pair("不出", 0), new Pair("emoji", 1), new Pair("热词", 2), new Pair("全部", 3)), InteractionRadioGroupIteminfoKt.getItemInfo("横屏评论输入框", CommentInputBoxSwitcher.getHorizontalCommentInputSwitch().generateDebugSelectedKey(), CommentInputBoxSwitcher.getHorizontalCommentInputSwitch().getKey(), CommentInputBoxSwitcher.getHorizontalCommentInputSwitch().getDefaultValue(), new Pair("emoji", 0), new Pair("热词", 1)), InteractionRadioGroupIteminfoKt.getItemInfo("横屏弹幕输入框", CommentInputBoxSwitcher.getHorizontalDanmakuInputSwitch().generateDebugSelectedKey(), CommentInputBoxSwitcher.getHorizontalDanmakuInputSwitch().getKey(), CommentInputBoxSwitcher.getHorizontalDanmakuInputSwitch().getDefaultValue(), new Pair("emoji", 0), new Pair("热词", 1)), InteractionRadioGroupIteminfoKt.getItemInfo("弹幕/评论输入框新样式", CommentInputBoxSwitcher.getCommentInputNewStyleSwitch().generateDebugSelectedKey(), CommentInputBoxSwitcher.getCommentInputNewStyleSwitch().getKey(), CommentInputBoxSwitcher.getCommentInputNewStyleSwitch().getDefaultValue(), new Pair("旧样式", Boolean.FALSE), new Pair("新样式", Boolean.TRUE)), InteractionRadioGroupIteminfoKt.getItemInfo("点赞资源加载优化实验", PraiseResourceLoadSwitcher.getPraiseResourceLoadSwitcher().generateDebugSelectedKey(), PraiseResourceLoadSwitcher.getPraiseResourceLoadSwitcher().getKey(), PraiseResourceLoadSwitcher.getPraiseResourceLoadSwitcher().getDefaultValue(), new Pair("开", Boolean.TRUE), new Pair("关", Boolean.FALSE)), InteractionRadioGroupIteminfoKt.getItemInfo("弹幕体验优化实验", BarrageOptimizeSwitcher.getBarrageOptimizeSwitcher().generateDebugSelectedKey(), BarrageOptimizeSwitcher.getBarrageOptimizeSwitcher().getKey(), BarrageOptimizeSwitcher.getBarrageOptimizeSwitcher().getDefaultValue(), new Pair("分支0：线上效果", Boolean.FALSE), new Pair("分支1：优化效果", Boolean.TRUE)));
    }
}
