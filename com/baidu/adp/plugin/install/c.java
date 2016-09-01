package com.baidu.adp.plugin.install;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.lib.a.b.a.a.i {
    protected String apkFilePath;
    protected String vT;
    protected boolean wu;
    protected long wv;

    public long hV() {
        return Math.max(Math.min(this.wv * 80, 240000L), (long) TbConfig.USE_TIME_INTERVAL);
    }
}
