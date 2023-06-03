package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.message.IMessenger;
/* loaded from: classes4.dex */
public abstract class SingleTargetTrigger implements IEventTrigger {
    public IMessenger mIMessenger;

    public void release() {
        this.mIMessenger = null;
    }

    public void setMessenger(@NonNull IMessenger iMessenger) {
        this.mIMessenger = iMessenger;
    }

    @Override // com.baidu.searchbox.player.event.IEventTrigger
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        IMessenger iMessenger = this.mIMessenger;
        if (iMessenger == null) {
            return;
        }
        iMessenger.notifyEvent(videoEvent);
    }
}
