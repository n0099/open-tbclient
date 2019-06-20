package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean HJ;
    protected long HK;
    protected String Hi;
    protected String apkFilePath;

    public long lt() {
        return Math.max(Math.min(this.HK * 80, 240000L), 60000L);
    }
}
