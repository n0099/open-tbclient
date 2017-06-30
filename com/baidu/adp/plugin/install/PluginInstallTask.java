package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String CC;
    protected boolean Dd;
    protected long De;
    protected String apkFilePath;

    public long iQ() {
        return Math.max(Math.min(this.De * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
