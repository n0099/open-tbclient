package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean AM;
    protected long AN;
    protected String Ak;
    protected String apkFilePath;

    public long ir() {
        return Math.max(Math.min(this.AN * 80, 240000L), 60000L);
    }
}
