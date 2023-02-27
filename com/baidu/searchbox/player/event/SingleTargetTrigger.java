package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes2.dex */
public abstract class SingleTargetTrigger implements IEventTrigger {
    public IMessenger mIMessenger;

    @PublicMethod(version = "11.24.0.0")
    public void release() {
        this.mIMessenger = null;
    }

    @PublicMethod(version = "11.24.0.0")
    public void setMessenger(@NonNull IMessenger iMessenger) {
        this.mIMessenger = iMessenger;
    }

    @Override // com.baidu.searchbox.player.event.IEventTrigger
    @PublicMethod(version = "11.24.0.0")
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        IMessenger iMessenger = this.mIMessenger;
        if (iMessenger == null) {
            return;
        }
        iMessenger.notifyEvent(videoEvent);
    }
}
