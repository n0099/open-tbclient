package com.baidu.searchbox.floating.event;

import com.baidu.searchbox.player.event.LayerEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/floating/event/FloatingLayerEvent;", "Lcom/baidu/searchbox/player/event/LayerEvent;", "action", "", "(Ljava/lang/String;)V", "Companion", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FloatingLayerEvent extends LayerEvent {
    public static final String ACTION_FLOATING_GESTURE = "action_floating_gesture";
    public static final String ACTION_FLOATING_LAST_BUTTON_CLICKABLE = "action_floating_last_button_clickable";
    public static final String ACTION_FLOATING_NEXT_BUTTON_CLICKABLE = "action_floating_next_button_clickable";
    public static final String ACTION_FLOATING_SINGLE_TAP_CONFIRMED = "action_floating_click";
    public static final Companion Companion = new Companion(null);
    public static final int KEY_FLOATING_BUTTON_CLICKABLE = 2;
    public static final int KEY_FLOATING_GESTURE = 1;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/floating/event/FloatingLayerEvent$Companion;", "", "()V", "ACTION_FLOATING_GESTURE", "", "ACTION_FLOATING_LAST_BUTTON_CLICKABLE", "ACTION_FLOATING_NEXT_BUTTON_CLICKABLE", "ACTION_FLOATING_SINGLE_TAP_CONFIRMED", "KEY_FLOATING_BUTTON_CLICKABLE", "", "KEY_FLOATING_GESTURE", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatingLayerEvent(String action) {
        super(action);
        Intrinsics.checkNotNullParameter(action, "action");
    }
}
