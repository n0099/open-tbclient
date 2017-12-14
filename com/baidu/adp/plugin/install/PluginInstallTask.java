package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String BJ;
    protected boolean Ck;
    protected long Cl;
    protected String apkFilePath;

    public long iM() {
        return Math.max(Math.min(this.Cl * 80, 240000L), 60000L);
    }
}
