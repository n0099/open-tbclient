package com.baidu.searchbox.bddownload.core.breakpoint;

import androidx.annotation.IntRange;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public class BlockInfo {
    @IntRange(from = 0)
    public final long contentLength;
    public final AtomicLong currentOffset;
    @IntRange(from = 0)
    public final long startOffset;

    public BlockInfo(long j, long j2) {
        this(j, j2, 0L);
    }

    public BlockInfo(long j, long j2, @IntRange(from = 0) long j3) {
        if (j >= 0 && ((j2 >= 0 || j2 == -1) && j3 >= 0)) {
            this.startOffset = j;
            this.contentLength = j2;
            this.currentOffset = new AtomicLong(j3);
            return;
        }
        throw new IllegalArgumentException();
    }

    public BlockInfo copy() {
        return new BlockInfo(this.startOffset, this.contentLength, this.currentOffset.get());
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getCurrentOffset() {
        return this.currentOffset.get();
    }

    public long getRangeLeft() {
        return this.startOffset + this.currentOffset.get();
    }

    public long getRangeRight() {
        return (this.startOffset + this.contentLength) - 1;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public void resetBlock() {
        this.currentOffset.set(0L);
    }

    public String toString() {
        return PreferencesUtil.LEFT_MOUNT + this.startOffset + StringUtil.ARRAY_ELEMENT_SEPARATOR + getRangeRight() + ")-current:" + this.currentOffset;
    }

    public void increaseCurrentOffset(@IntRange(from = 1) long j) {
        this.currentOffset.addAndGet(j);
    }
}
