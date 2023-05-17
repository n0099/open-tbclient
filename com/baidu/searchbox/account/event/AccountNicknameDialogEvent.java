package com.baidu.searchbox.account.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/account/event/AccountNicknameDialogEvent;", "", "eventType", "", "(I)V", "mEventType", "getMEventType", "()I", "setMEventType", "Companion", "lib-account-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AccountNicknameDialogEvent {
    public static final Companion Companion = new Companion(null);
    public static final int EVENT_DISMISS = 2;
    public static final int EVENT_OPEN = 1;
    public int mEventType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/account/event/AccountNicknameDialogEvent$Companion;", "", "()V", "EVENT_DISMISS", "", "EVENT_OPEN", "lib-account-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public AccountNicknameDialogEvent(int i) {
        this.mEventType = i;
    }

    public final void setMEventType(int i) {
        this.mEventType = i;
    }

    public final int getMEventType() {
        return this.mEventType;
    }
}
