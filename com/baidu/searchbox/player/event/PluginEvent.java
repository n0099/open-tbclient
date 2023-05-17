package com.baidu.searchbox.player.event;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes3.dex */
public class PluginEvent extends VideoEvent {
    @PublicMethod(version = "12.8.0.0")
    public static VideoEvent obtainEvent(@NonNull String str, int i) {
        VideoEvent obtain = VideoEvent.obtain(str, 7);
        obtain.setTargetType(1);
        obtain.setPriority(i);
        return obtain;
    }

    @Override // com.baidu.searchbox.player.event.VideoEvent
    public boolean filter(@NonNull INeuron iNeuron) {
        if (1 != iNeuron.getType()) {
            return true;
        }
        return false;
    }
}
