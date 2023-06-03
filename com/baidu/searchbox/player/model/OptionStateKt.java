package com.baidu.searchbox.player.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002¨\u0006\u0006"}, d2 = {"isEnable", "", "Lcom/baidu/searchbox/player/model/OptionState;", "isSpecified", "stringValue", "", "bdvideoplayer-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OptionStateKt {
    public static final boolean isEnable(OptionState optionState) {
        if (optionState == OptionState.ENABLE) {
            return true;
        }
        return false;
    }

    public static final boolean isSpecified(OptionState optionState) {
        if (optionState != OptionState.UNSPECIFIED) {
            return true;
        }
        return false;
    }

    public static final String stringValue(OptionState optionState) {
        Intrinsics.checkNotNullParameter(optionState, "<this>");
        return String.valueOf(optionState.getValue());
    }
}
