package com.baidu.searchbox.player.plugin;

import android.support.annotation.NonNull;
import com.baidu.searchbox.player.BDVideoPlayer;
import com.baidu.searchbox.player.annotation.PublicMethod;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes15.dex */
public class PluginManager {
    private BDVideoPlayer mPlayer;
    private ArrayList<AbsPlugin> mPlugins = new ArrayList<>();

    public PluginManager(@NonNull BDVideoPlayer bDVideoPlayer) {
        this.mPlayer = bDVideoPlayer;
    }

    @PublicMethod
    public void addPlugin(AbsPlugin absPlugin) {
        absPlugin.attachManager(this);
        this.mPlugins.add(absPlugin);
    }

    @PublicMethod
    public void removePlugin(AbsPlugin absPlugin) {
        absPlugin.detachManager();
        this.mPlugins.remove(absPlugin);
    }

    @PublicMethod
    @NonNull
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
