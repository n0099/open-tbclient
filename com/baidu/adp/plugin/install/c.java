package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected String Cx;
    protected boolean Cy;
    protected long Cz;
    protected String pkgName;

    public long lp() {
        return Math.max(Math.min(this.Cz * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
