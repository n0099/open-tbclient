package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String apkFilePath;
    protected boolean uH;
    protected long uI;
    protected String ud;

    public long ib() {
        return Math.max(Math.min(this.uI * 80, 240000L), 60000L);
    }
}
