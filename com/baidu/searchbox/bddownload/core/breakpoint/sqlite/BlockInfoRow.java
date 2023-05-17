package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.database.Cursor;
import com.baidu.searchbox.bddownload.core.breakpoint.BlockInfo;
/* loaded from: classes3.dex */
public class BlockInfoRow {
    public final int breakpointId;
    public final long contentLength;
    public final long currentOffset;
    public final long startOffset;

    public BlockInfoRow(Cursor cursor) {
        this.breakpointId = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.HOST_ID));
        this.startOffset = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.START_OFFSET));
        this.contentLength = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.CONTENT_LENGTH));
        this.currentOffset = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.CURRENT_OFFSET));
    }

    public int getBreakpointId() {
        return this.breakpointId;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getCurrentOffset() {
        return this.currentOffset;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public BlockInfo toInfo() {
        return new BlockInfo(this.startOffset, this.contentLength, this.currentOffset);
    }
}
