package com.baidu.searchbox.player.plugin;

import androidx.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class PluginManager {
    public final BDVideoPlayer mPlayer;
    public final ArrayList<AbsPlugin> mPlugins = new ArrayList<>();

    public PluginManager(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mPlayer = bDVideoPlayer;
    }

    @PublicMethod
    public void addPlugin(AbsPlugin absPlugin) {
        absPlugin.attachMessenger(getPlayer().getMessenger());
        absPlugin.attachManager(this);
        this.mPlugins.add(absPlugin);
    }

    @PublicMethod
    public void removePlugin(AbsPlugin absPlugin) {
        absPlugin.detachMessenger();
        absPlugin.detachManager();
        this.mPlugins.remove(absPlugin);
    }

    @NonNull
    @PublicMethod
    public BDVideoPlayer getPlayer() {
        return this.mPlayer;
    }

    @PublicMethod
    public void release() {
        Iterator<AbsPlugin> it = this.mPlugins.iterator();
        while (it.hasNext()) {
            AbsPlugin next = it.next();
            next.detachManager();
            next.detachMessenger();
            next.onPluginRelease();
        }
        this.mPlugins.clear();
    }
}
