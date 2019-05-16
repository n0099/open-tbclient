package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean HK;
    protected long HL;
    protected String Hj;
    protected String apkFilePath;

    public long lt() {
        return Math.max(Math.min(this.HL * 80, 240000L), 60000L);
    }
}
