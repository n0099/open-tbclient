package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.message.IMessenger;
import java.util.ArrayList;
/* loaded from: classes2.dex */
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
        for (int i2 = 0; i2 < size; i2++) {
            IMessenger iMessenger = this.mNotifyList.get(i2);
            if (i2 == 0) {
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
