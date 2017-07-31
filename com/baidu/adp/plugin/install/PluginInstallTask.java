package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean EC;
    protected long ED;
    protected String Eb;
    protected String apkFilePath;

    public long iY() {
        return Math.max(Math.min(this.ED * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
