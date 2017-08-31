package com.baidu.adp.plugin.install;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class PluginInstallTask extends OrmObject {
    protected String BX;
    protected boolean Cy;
    protected long Cz;
    protected String apkFilePath;

    public long iQ() {
        return Math.max(Math.min(this.Cz * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
