package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String apkFilePath;
    protected String pkgName;
    protected boolean wK;
    protected long wL;

    public long getTimeout() {
        return Math.max(Math.min(this.wL * 80, 240000L), 60000L);
    }
}
