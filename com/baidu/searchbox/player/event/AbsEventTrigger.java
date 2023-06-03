package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.message.IMessenger;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class AbsEventTrigger implements IEventTrigger {
    public final ArrayList<IMessenger> mMessengers = new ArrayList<>();

    public void clear() {
        this.mMessengers.clear();
    }

    public void bindMessenger(@NonNull IMessenger iMessenger) {
        if (!this.mMessengers.contains(iMessenger)) {
            this.mMessengers.add(iMessenger);
        }
    }

    @Override // com.baidu.searchbox.player.event.IEventTrigger
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        int size = this.mMessengers.size();
        for (int i = 0; i < size; i++) {
            IMessenger iMessenger = this.mMessengers.get(i);
            if (i == 0) {
                iMessenger.notifyEvent(videoEvent);
            } else {
                iMessenger.notifyEvent(VideoEvent.copy(videoEvent));
            }
        }
    }

    public void unbindMessenger(@NonNull IMessenger iMessenger) {
        this.mMessengers.remove(iMessenger);
    }
}
