package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean AK;
    protected long AM;
    protected String Aj;
    protected String apkFilePath;

    public long ir() {
        return Math.max(Math.min(this.AM * 80, 240000L), 60000L);
    }
}
