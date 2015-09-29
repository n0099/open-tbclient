package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected String Cw;
    protected boolean Cx;
    protected long Cy;
    protected String pkgName;

    public long lo() {
        return Math.max(Math.min(this.Cy * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
