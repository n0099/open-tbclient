package com.baidu.searchbox.bddownload.core.breakpoint.sqllite;

import android.database.Cursor;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import java.io.File;
/* loaded from: classes2.dex */
public class BreakpointInfoRow {
    public final boolean chunked;
    public final String etag;
    public final String filename;
    public final int id;
    public final String parentPath;
    public final boolean taskOnlyProvidedParentPath;
    public final String url;

    public BreakpointInfoRow(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.url = cursor.getString(cursor.getColumnIndex("url"));
        this.etag = cursor.getString(cursor.getColumnIndex("etag"));
        this.parentPath = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.PARENT_PATH));
        this.filename = cursor.getString(cursor.getColumnIndex("filename"));
        this.taskOnlyProvidedParentPath = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH)) == 1;
        this.chunked = cursor.getInt(cursor.getColumnIndex("chunked")) == 1;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getFilename() {
        return this.filename;
    }

    public int getId() {
        return this.id;
    }

    public String getParentPath() {
        return this.parentPath;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isTaskOnlyProvidedParentPath() {
        return this.taskOnlyProvidedParentPath;
    }

    public BreakpointInfo toInfo() {
        BreakpointInfo breakpointInfo = new BreakpointInfo(this.id, this.url, new File(this.parentPath), this.filename, this.taskOnlyProvidedParentPath);
        breakpointInfo.setEtag(this.etag);
        breakpointInfo.setChunked(this.chunked);
        return breakpointInfo;
    }
}
