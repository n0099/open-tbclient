package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean CB;
    protected long CC;
    protected String Ca;
    protected String apkFilePath;

    public long iP() {
        return Math.max(Math.min(this.CC * 80, 240000L), 60000L);
    }
}
