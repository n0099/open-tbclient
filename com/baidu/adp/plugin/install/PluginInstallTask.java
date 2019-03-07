package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String Jz;
    protected boolean Ka;
    protected long Kb;
    protected String apkFilePath;

    public long mz() {
        return Math.max(Math.min(this.Kb * 80, 240000L), 60000L);
    }
}
