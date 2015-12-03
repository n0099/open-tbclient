package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected boolean CE;
    protected long CF;
    protected String apkFilePath;
    protected String pkgName;

    public long lq() {
        return Math.max(Math.min(this.CF * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
