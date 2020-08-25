package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected long RA;
    protected boolean Rz;
    protected String apkFilePath;
    protected String pkgName;

    public long getTimeout() {
        return Math.max(Math.min(this.RA * 80, 240000L), 60000L);
    }
}
