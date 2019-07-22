package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean HV;
    protected long HW;
    protected String Ht;
    protected String apkFilePath;

    public long lJ() {
        return Math.max(Math.min(this.HW * 80, 240000L), 60000L);
    }
}
