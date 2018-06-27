package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean GW;
    protected long GX;
    protected String Gs;
    protected String apkFilePath;

    public long lf() {
        return Math.max(Math.min(this.GX * 80, 240000L), 60000L);
    }
}
