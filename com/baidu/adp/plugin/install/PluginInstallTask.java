package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String CY;
    protected long DA;
    protected boolean Dz;
    protected String apkFilePath;

    public long iN() {
        return Math.max(Math.min(this.DA * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
