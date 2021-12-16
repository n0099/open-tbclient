package com.baidu.searchbox.bddownload.core.file;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes10.dex */
public interface DownloadOutputStream {

    /* loaded from: classes10.dex */
    public interface Factory {
        DownloadOutputStream create(Context context, Uri uri, int i2) throws FileNotFoundException;

        DownloadOutputStream create(Context context, File file, int i2) throws FileNotFoundException;

        boolean supportSeek();
    }

    void close() throws IOException;

    void flushAndSync() throws IOException;

    void seek(long j2) throws IOException;

    void setLength(long j2) throws IOException;

    void write(byte[] bArr, int i2, int i3) throws IOException;
}
