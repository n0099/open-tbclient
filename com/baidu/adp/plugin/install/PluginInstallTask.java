package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected boolean EE;
    protected long EF;
    protected String Ed;
    protected String apkFilePath;

    public long iY() {
        return Math.max(Math.min(this.EF * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
