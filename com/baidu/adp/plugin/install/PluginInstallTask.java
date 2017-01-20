package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String apkFilePath;
    protected String vK;
    protected boolean wl;
    protected long wm;

    public long hT() {
        return Math.max(Math.min(this.wm * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
