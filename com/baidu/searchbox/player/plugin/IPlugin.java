package com.baidu.searchbox.player.plugin;

import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.interfaces.INeuron;
/* loaded from: classes2.dex */
public interface IPlugin extends INeuron {
    void onPluginEventNotify(VideoEvent videoEvent);

    void onPluginRelease();
}
