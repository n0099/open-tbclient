package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String apI;
    protected String apkFilePath;
    protected boolean aqj;
    protected long aqk;

    public long qm() {
        return Math.max(Math.min(this.aqk * 80, 240000L), 60000L);
    }
}
