package com.baidu.live.tbadk.core.util;
/* loaded from: classes6.dex */
public class ImageLogStruct {
    public int num = 0;
    public int failnum = 0;
    public long time = 0;
    public long downloadSize = 0;
    public int slownum = 0;

    public void reset() {
        this.num = 0;
        this.failnum = 0;
        this.time = 0L;
        this.downloadSize = 0L;
        this.slownum = 0;
    }
}
