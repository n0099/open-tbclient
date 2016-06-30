package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected String apkFilePath;
    protected boolean tF;
    protected long tG;
    protected String tc;

    public long hb() {
        return Math.max(Math.min(this.tG * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
