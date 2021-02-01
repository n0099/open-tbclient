package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes4.dex */
public abstract class SingleTargetTrigger implements IEventTrigger {
    protected IMessenger mIMessenger;

    @PublicMethod(version = "11.24.0.0")
    public void setMessenger(@NonNull IMessenger iMessenger) {
        this.mIMessenger = iMessenger;
    }

    @PublicMethod(version = "11.24.0.0")
    public void release() {
        this.mIMessenger = null;
    }

    @Override // com.baidu.searchbox.player.event.IEventTrigger
    @PublicMethod(version = "11.24.0.0")
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        if (this.mIMessenger != null) {
            this.mIMessenger.notifyEvent(videoEvent);
        }
    }
}
