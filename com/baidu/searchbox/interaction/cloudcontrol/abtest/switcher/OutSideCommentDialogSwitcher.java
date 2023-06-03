package com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher;

import com.baidu.searchbox.interaction.cloudcontrol.abtest.InteractionAbTestSwitcher;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0006\u0010\u0005\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"OUTSIDE_COMMENT_DIALOG_SWITCH", "", "outSideCommentDialogSwitcher", "Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "", "getOutSideCommentDialogSwitcher", "()Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "lib-interaction-cloudcontrol_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "OutSideCommentDialogSwitcher")
/* loaded from: classes3.dex */
public final class OutSideCommentDialogSwitcher {
    public static final String OUTSIDE_COMMENT_DIALOG_SWITCH = "feed_comment_outside_dialog_switch";
    public static final InteractionAbTestSwitcher<Boolean> outSideCommentDialogSwitcher = new InteractionAbTestSwitcher<>(OUTSIDE_COMMENT_DIALOG_SWITCH, Boolean.FALSE);

    public static final InteractionAbTestSwitcher<Boolean> getOutSideCommentDialogSwitcher() {
        return outSideCommentDialogSwitcher;
    }

    /* renamed from: getOutSideCommentDialogSwitcher  reason: collision with other method in class */
    public static final boolean m94getOutSideCommentDialogSwitcher() {
        return outSideCommentDialogSwitcher.getSwitcherValue().booleanValue();
    }
}
