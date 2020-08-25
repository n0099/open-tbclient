package com.baidu.live.tbadk.album;

import java.io.Serializable;
/* loaded from: classes7.dex */
public abstract class MediaFileInfo implements Serializable {
    public static final int TYPE_ADD = 2;
    public static final int TYPE_IMAGE = 0;
    public static final int TYPE_VIDEO = 1;
    public static final int TYPE_VIEW_COUNT = 3;
    private long sortTime;

    public abstract int getType();

    public long getSortTime() {
        return this.sortTime;
    }

    public void setSortTime(long j) {
        this.sortTime = j;
    }
}
