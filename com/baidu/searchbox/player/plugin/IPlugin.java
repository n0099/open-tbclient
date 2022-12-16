package com.baidu.searchbox.player.plugin;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes3.dex */
public interface IPlugin extends INeuron {
    void onPluginEventNotify(@NonNull VideoEvent videoEvent);

    void onPluginRelease();
}
