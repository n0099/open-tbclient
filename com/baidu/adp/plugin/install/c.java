package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected String Cv;
    protected boolean Cw;
    protected long Cx;
    protected String pkgName;

    public long ln() {
        return Math.max(Math.min(this.Cx * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
