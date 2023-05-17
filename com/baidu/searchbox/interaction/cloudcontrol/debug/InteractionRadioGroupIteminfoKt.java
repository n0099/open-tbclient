package com.baidu.searchbox.interaction.cloudcontrol.debug;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.searchbox.debug.data.CustomItemInfo;
import com.baidu.searchbox.debug.data.DebugItemInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a]\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u0002H\u00022*\u0010\b\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\n0\t\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002H\u00020\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"getItemInfo", "Lcom/baidu/searchbox/debug/data/DebugItemInfo;", ExifInterface.GPS_DIRECTION_TRUE, "switchDebugTitle", "", "switchDebugKey", "debugBranchKey", "defaultValue", "otherModel", "", "Lkotlin/Pair;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Lkotlin/Pair;)Lcom/baidu/searchbox/debug/data/DebugItemInfo;", "lib-interaction-cloudcontrol_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InteractionRadioGroupIteminfoKt {
    public static final <T> DebugItemInfo getItemInfo(String switchDebugTitle, String switchDebugKey, String debugBranchKey, T t, Pair<String, ? extends T>... otherModel) {
        Intrinsics.checkNotNullParameter(switchDebugTitle, "switchDebugTitle");
        Intrinsics.checkNotNullParameter(switchDebugKey, "switchDebugKey");
        Intrinsics.checkNotNullParameter(debugBranchKey, "debugBranchKey");
        Intrinsics.checkNotNullParameter(otherModel, "otherModel");
        return new CustomItemInfo(new InteractionRadioGroupIteminfoKt$getItemInfo$1(switchDebugTitle, switchDebugKey, debugBranchKey, t, otherModel));
    }
}
