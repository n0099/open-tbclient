package com.baidu.searchbox.interaction.cloudcontrol.abtest.switcher;

import com.baidu.searchbox.interaction.cloudcontrol.abtest.InteractionAbTestSwitcher;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0006\u0010\u0017\u001a\u00020\u0001\u001a\u0006\u0010\u0018\u001a\u00020\u0001\u001a\u0006\u0010\u0019\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\f¨\u0006\u001a"}, d2 = {"COMMENT_INPUT_BOX_SHOW_ALL", "", "COMMENT_INPUT_BOX_SHOW_EMOJI", "COMMENT_INPUT_BOX_SHOW_NONE", "COMMENT_INPUT_BOX_SHOW_QUICK", "COMMENT_INPUT_NEW_STYLE_DEF_VAL", "", "COMMENT_LANDSCAPE_INPUT_SHOW_EMOJI", "COMMENT_LANDSCAPE_INPUT_SHOW_QUICK", "commentInputNewStyleSwitch", "Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "getCommentInputNewStyleSwitch", "()Lcom/baidu/searchbox/interaction/cloudcontrol/abtest/InteractionAbTestSwitcher;", "horizontalCommentInputSwitch", "getHorizontalCommentInputSwitch", "horizontalDanmakuInputSwitch", "getHorizontalDanmakuInputSwitch", "verticalCommentInputSwitch", "getVerticalCommentInputSwitch", "verticalDanmakuInputSwitch", "getVerticalDanmakuInputSwitch", "getHorizontalCommentType", "getHorizontalDanmakuType", "getVerticalCommentType", "getVerticalDanmakuType", "isNewStyleCommentInput", "lib-interaction-cloudcontrol_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "CommentInputBoxSwitcher")
/* loaded from: classes4.dex */
public final class CommentInputBoxSwitcher {
    public static final int COMMENT_INPUT_BOX_SHOW_ALL = 3;
    public static final int COMMENT_INPUT_BOX_SHOW_EMOJI = 1;
    public static final int COMMENT_INPUT_BOX_SHOW_NONE = 0;
    public static final int COMMENT_INPUT_BOX_SHOW_QUICK = 2;
    public static final boolean COMMENT_INPUT_NEW_STYLE_DEF_VAL = false;
    public static final int COMMENT_LANDSCAPE_INPUT_SHOW_EMOJI = 0;
    public static final int COMMENT_LANDSCAPE_INPUT_SHOW_QUICK = 1;
    public static final InteractionAbTestSwitcher<Integer> verticalCommentInputSwitch = new InteractionAbTestSwitcher<>("feed_vertical_comments", 1);
    public static final InteractionAbTestSwitcher<Integer> verticalDanmakuInputSwitch = new InteractionAbTestSwitcher<>("feed_vertical_bullet_comments", 1);
    public static final InteractionAbTestSwitcher<Integer> horizontalCommentInputSwitch = new InteractionAbTestSwitcher<>("feed_hori_comments", 0);
    public static final InteractionAbTestSwitcher<Integer> horizontalDanmakuInputSwitch = new InteractionAbTestSwitcher<>("feed_hori_bullet_comments", 0);
    public static final InteractionAbTestSwitcher<Boolean> commentInputNewStyleSwitch = new InteractionAbTestSwitcher<>("feed_fapingmianban_v2", Boolean.FALSE);

    public static final InteractionAbTestSwitcher<Boolean> getCommentInputNewStyleSwitch() {
        return commentInputNewStyleSwitch;
    }

    public static final InteractionAbTestSwitcher<Integer> getHorizontalCommentInputSwitch() {
        return horizontalCommentInputSwitch;
    }

    public static final int getHorizontalCommentType() {
        return horizontalCommentInputSwitch.getSwitcherValue().intValue();
    }

    public static final InteractionAbTestSwitcher<Integer> getHorizontalDanmakuInputSwitch() {
        return horizontalDanmakuInputSwitch;
    }

    public static final int getHorizontalDanmakuType() {
        return horizontalDanmakuInputSwitch.getSwitcherValue().intValue();
    }

    public static final InteractionAbTestSwitcher<Integer> getVerticalCommentInputSwitch() {
        return verticalCommentInputSwitch;
    }

    public static final int getVerticalCommentType() {
        return verticalCommentInputSwitch.getSwitcherValue().intValue();
    }

    public static final InteractionAbTestSwitcher<Integer> getVerticalDanmakuInputSwitch() {
        return verticalDanmakuInputSwitch;
    }

    public static final int getVerticalDanmakuType() {
        return verticalDanmakuInputSwitch.getSwitcherValue().intValue();
    }

    public static final boolean isNewStyleCommentInput() {
        return commentInputNewStyleSwitch.getSwitcherValue().booleanValue();
    }
}
