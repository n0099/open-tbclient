package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean JP;
    protected long JQ;
    protected String Jp;
    protected String apkFilePath;

    public long mx() {
        return Math.max(Math.min(this.JQ * 80, 240000L), 60000L);
    }
}
