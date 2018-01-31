package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String apR;
    protected String apkFilePath;
    protected boolean aqs;
    protected long aqt;

    public long qm() {
        return Math.max(Math.min(this.aqt * 80, 240000L), 60000L);
    }
}
