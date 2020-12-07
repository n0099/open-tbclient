package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean Th;
    protected long Ti;
    protected String apkFilePath;
    protected String pkgName;

    public long pm() {
        return Math.max(Math.min(this.Ti * 80, 240000L), 60000L);
    }
}
