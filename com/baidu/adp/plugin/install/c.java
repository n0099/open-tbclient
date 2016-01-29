package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected boolean Dg;
    protected long Dh;
    protected String apkFilePath;
    protected String pkgName;

    public long kX() {
        return Math.max(Math.min(this.Dh * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
