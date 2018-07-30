package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean GR;
    protected long GU;
    protected String Gq;
    protected String apkFilePath;

    public long lh() {
        return Math.max(Math.min(this.GU * 80, 240000L), 60000L);
    }
}
