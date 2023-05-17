package com.baidu.searchbox.interaction.cloudcontrol.ccs;

import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\t\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"ACTION", "", "DEFAULT_VERSION", "DOUBLE_LIST_SWITCH", "DOUBLE_LIST_SWITCH_CLOSE", "DOUBLE_LIST_SWITCH_OPEN", "KEY_INTERACTION_DOUBLE_LIST_SWITCH", "KEY_INTERACTION_VERSION", "MODULE", "getInteractionPrivacySwitch", "", "lib-interaction-cloudcontrol_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "InteractionPrivacySwitch")
/* loaded from: classes3.dex */
public final class InteractionPrivacySwitch {
    public static final String ACTION = "hudong_privacy";
    public static final String DEFAULT_VERSION = "0";
    public static final String DOUBLE_LIST_SWITCH = "double_list_switch";
    public static final String DOUBLE_LIST_SWITCH_CLOSE = "0";
    public static final String DOUBLE_LIST_SWITCH_OPEN = "1";
    public static final String KEY_INTERACTION_DOUBLE_LIST_SWITCH = "key_interaction_double_list_switch";
    public static final String KEY_INTERACTION_VERSION = "key_interaction_version";
    public static final String MODULE = "interaction";

    public static final boolean getInteractionPrivacySwitch() {
        return Intrinsics.areEqual(DefaultSharedPrefsWrapper.getInstance().getString(KEY_INTERACTION_DOUBLE_LIST_SWITCH, "0"), "1");
    }
}
