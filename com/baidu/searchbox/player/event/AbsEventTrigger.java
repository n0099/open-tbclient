package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.message.IMessenger;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public abstract class AbsEventTrigger implements IEventTrigger {
    public ArrayList<IMessenger> mNotifyList = new ArrayList<>();

    @PublicMethod
    public void clear() {
        this.mNotifyList.clear();
    }

    @PublicMethod
    public void register(@NonNull IMessenger iMessenger) {
        this.mNotifyList.add(iMessenger);
    }

    @Override // com.baidu.searchbox.player.event.IEventTrigger
    @PublicMethod
    public void triggerEvent(@NonNull VideoEvent videoEvent) {
        int size = this.mNotifyList.size();
        for (int i = 0; i < size; i++) {
            IMessenger iMessenger = this.mNotifyList.get(i);
            if (i == 0) {
                iMessenger.notifyEvent(videoEvent);
            } else {
                iMessenger.notifyEvent(VideoEvent.copy(videoEvent));
            }
        }
    }

    @PublicMethod
    public void unregister(@NonNull IMessenger iMessenger) {
        this.mNotifyList.remove(iMessenger);
    }
}
