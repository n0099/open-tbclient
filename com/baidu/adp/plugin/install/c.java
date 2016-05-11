package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected String apkFilePath;
    protected String pkgName;
    protected boolean tD;
    protected long tE;

    public long gZ() {
        return Math.max(Math.min(this.tE * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
