package com.baidu.searchbox.bddownload.core.file;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.file.DownloadOutputStream;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
/* loaded from: classes3.dex */
public class DownloadUriOutputStream implements DownloadOutputStream {
    @NonNull
    public final FileChannel channel;
    @NonNull
    public final FileOutputStream fos;
    @NonNull
    public final BufferedOutputStream out;
    @NonNull
    public final ParcelFileDescriptor pdf;

    public DownloadUriOutputStream(Context context, Uri uri, int i) throws FileNotFoundException {
        ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
        if (openFileDescriptor != null) {
            this.pdf = openFileDescriptor;
            FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
            this.fos = fileOutputStream;
            this.channel = fileOutputStream.getChannel();
            this.out = new BufferedOutputStream(this.fos, i);
            return;
        }
        throw new FileNotFoundException("result of " + uri + " is null!");
    }

    /* loaded from: classes3.dex */
    public static class Factory implements DownloadOutputStream.Factory {
        @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream.Factory
        public boolean supportSeek() {
            return true;
        }

        @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream.Factory
        public DownloadOutputStream create(Context context, Uri uri, int i) throws FileNotFoundException {
            return new DownloadUriOutputStream(context, uri, i);
        }

        @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream.Factory
        public DownloadOutputStream create(Context context, File file, int i) throws FileNotFoundException {
            return new DownloadUriOutputStream(context, Uri.fromFile(file), i);
        }
    }

    public DownloadUriOutputStream(@NonNull FileChannel fileChannel, @NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull FileOutputStream fileOutputStream, @NonNull BufferedOutputStream bufferedOutputStream) {
        this.channel = fileChannel;
        this.pdf = parcelFileDescriptor;
        this.fos = fileOutputStream;
        this.out = bufferedOutputStream;
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void close() throws IOException {
        this.out.close();
        this.fos.close();
        this.pdf.close();
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void flushAndSync() throws IOException {
        this.out.flush();
        this.pdf.getFileDescriptor().sync();
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void seek(long j) throws IOException {
        this.channel.position(j);
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void setLength(long j) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                Os.posix_fallocate(this.pdf.getFileDescriptor(), 0L, j);
                return;
            } catch (Throwable th) {
                if (th instanceof ErrnoException) {
                    int i = th.errno;
                    if (i == OsConstants.ENOSYS || i == OsConstants.ENOTSUP) {
                        Util.w("DownloadUriOutputStream", "fallocate() not supported; falling back to ftruncate()");
                        try {
                            Os.ftruncate(this.pdf.getFileDescriptor(), j);
                            return;
                        } catch (Throwable th2) {
                            Util.w("DownloadUriOutputStream", "It can't pre-allocate length(" + j + ") on the sdk version(" + Build.VERSION.SDK_INT + "), because of " + th2);
                            return;
                        }
                    }
                    return;
                }
                Util.w("DownloadUriOutputStream", "It can't pre-allocate length(" + j + ") on the sdk version(" + Build.VERSION.SDK_INT + "), because of " + th);
                return;
            }
        }
        Util.w("DownloadUriOutputStream", "It can't pre-allocate length(" + j + ") on the sdk version(" + Build.VERSION.SDK_INT + SmallTailInfo.EMOTION_SUFFIX);
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }
}
