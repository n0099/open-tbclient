package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String Cz;
    protected boolean Da;
    protected long Db;
    protected String apkFilePath;

    public long iR() {
        return Math.max(Math.min(this.Db * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
