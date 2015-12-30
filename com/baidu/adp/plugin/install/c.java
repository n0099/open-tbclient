package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected boolean CW;
    protected long CX;
    protected String apkFilePath;
    protected String pkgName;

    public long kN() {
        return Math.max(Math.min(this.CX * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
