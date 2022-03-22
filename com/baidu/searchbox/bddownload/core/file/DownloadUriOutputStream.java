package com.baidu.searchbox.bddownload.core.file;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.file.DownloadOutputStream;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
/* loaded from: classes4.dex */
public class DownloadUriOutputStream implements DownloadOutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final FileChannel channel;
    @NonNull
    public final FileOutputStream fos;
    @NonNull
    public final BufferedOutputStream out;
    @NonNull
    public final ParcelFileDescriptor pdf;

    /* loaded from: classes4.dex */
    public static class Factory implements DownloadOutputStream.Factory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Factory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream.Factory
        public DownloadOutputStream create(Context context, File file, int i) throws FileNotFoundException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, file, i)) == null) ? new DownloadUriOutputStream(context, Uri.fromFile(file), i) : (DownloadOutputStream) invokeLLI.objValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream.Factory
        public boolean supportSeek() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream.Factory
        public DownloadOutputStream create(Context context, Uri uri, int i) throws FileNotFoundException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, context, uri, i)) == null) ? new DownloadUriOutputStream(context, uri, i) : (DownloadOutputStream) invokeLLI.objValue;
        }
    }

    public DownloadUriOutputStream(Context context, Uri uri, int i) throws FileNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, uri, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.out.close();
            this.fos.close();
            this.pdf.close();
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void flushAndSync() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.out.flush();
            this.pdf.getFileDescriptor().sync();
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void seek(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.channel.position(j);
        }
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void setLength(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
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
    }

    @Override // com.baidu.searchbox.bddownload.core.file.DownloadOutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, bArr, i, i2) == null) {
            this.out.write(bArr, i, i2);
        }
    }

    public DownloadUriOutputStream(@NonNull FileChannel fileChannel, @NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull FileOutputStream fileOutputStream, @NonNull BufferedOutputStream bufferedOutputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fileChannel, parcelFileDescriptor, fileOutputStream, bufferedOutputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.channel = fileChannel;
        this.pdf = parcelFileDescriptor;
        this.fos = fileOutputStream;
        this.out = bufferedOutputStream;
    }
}
