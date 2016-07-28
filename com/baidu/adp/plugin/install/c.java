package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected String apkFilePath;
    protected String tG;
    protected boolean uh;
    protected long ui;

    public long ha() {
        return Math.max(Math.min(this.ui * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
