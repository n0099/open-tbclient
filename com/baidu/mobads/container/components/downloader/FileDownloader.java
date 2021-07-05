package com.baidu.mobads.container.components.downloader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.components.downloader.IDownloader;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
/* loaded from: classes3.dex */
public class FileDownloader extends Observable implements Runnable, IDownloader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BLOCK_SIZE = 10240;
    public static final int BUFFER_SIZE = 10240;
    public static final String TAG = "OAdSimpleFileDownloader";
    public static final String TEMP_SUFFIX = ".tmp";
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] mByteArray;
    public int mDownloaded;
    public String mFileName;
    public int mFileSize;
    public String mOutputFolder;
    public int mProgress;
    public IDownloader.DownloadStatus mState;
    public URL mURL;
    public boolean saveFileAndMemory;

    public FileDownloader(URL url, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.saveFileAndMemory = false;
        this.mURL = url;
        this.mOutputFolder = str;
        this.saveFileAndMemory = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.mFileName = str2;
        } else {
            String file = url.getFile();
            this.mFileName = file.substring(file.lastIndexOf(47) + 1);
        }
        this.mFileSize = -1;
        this.mState = IDownloader.DownloadStatus.DOWNLOADING;
        this.mDownloaded = 0;
        this.mProgress = 0;
    }

    private void error() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            setState(IDownloader.DownloadStatus.ERROR);
        }
    }

    private HttpURLConnection openConnectionCheckRedirects(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, this, httpURLConnection)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField("Location"));
                this.mURL = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    private boolean renameFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            try {
                File file = new File(str);
                File file2 = new File(str2);
                if (file.exists()) {
                    return file.renameTo(file2);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void beforeCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            renameFile(this.mOutputFolder + this.mFileName + ".tmp", this.mOutputFolder + this.mFileName);
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void download() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TaskScheduler.getInstance().submit(this);
        }
    }

    public void downloaded(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.mDownloaded += i2;
            stateChanged();
        }
    }

    public byte[] getByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mByteArray : (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public int getFileSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFileSize : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public long getFileSizeLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mFileSize : invokeV.longValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getOutputPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mOutputFolder + this.mFileName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public float getProgress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? Math.abs((this.mDownloaded / this.mFileSize) * 100.0f) : invokeV.floatValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public IDownloader.DownloadStatus getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mState : (IDownloader.DownloadStatus) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public String getTargetURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public String getURL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mURL.toString() : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public boolean isDownloadOnlyWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public boolean isPausedManually() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void removeObservers() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    @Deprecated
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0139 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ByteArrayOutputStream byteArrayOutputStream;
        HttpURLConnection httpURLConnection;
        Throwable th;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection2;
        int responseCode;
        BufferedOutputStream bufferedOutputStream;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            BufferedOutputStream bufferedOutputStream2 = null;
            bufferedOutputStream2 = null;
            bufferedOutputStream2 = null;
            bufferedOutputStream2 = null;
            bufferedOutputStream2 = null;
            bufferedOutputStream2 = null;
            try {
                try {
                    httpURLConnection2 = (HttpURLConnection) this.mURL.openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(10000);
                        httpURLConnection2.setInstanceFollowRedirects(true);
                        httpURLConnection2.connect();
                        responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode == 302 || responseCode == 301) {
                            httpURLConnection2.setInstanceFollowRedirects(false);
                            httpURLConnection2 = openConnectionCheckRedirects(httpURLConnection2);
                            responseCode = httpURLConnection2.getResponseCode();
                        }
                    } catch (Exception unused) {
                        bufferedInputStream = null;
                        httpURLConnection = httpURLConnection2;
                        byteArrayOutputStream = null;
                    } catch (Throwable th2) {
                        httpURLConnection = httpURLConnection2;
                        th = th2;
                        byteArrayOutputStream = null;
                        bufferedInputStream = null;
                    }
                } catch (Exception unused2) {
                    return;
                }
            } catch (Exception unused3) {
                byteArrayOutputStream = null;
                bufferedInputStream = null;
                httpURLConnection = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                httpURLConnection = null;
                th = th3;
                bufferedInputStream = null;
            }
            if (responseCode / 100 != 2) {
                error();
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                        return;
                    } catch (Exception unused4) {
                        return;
                    }
                }
                return;
            }
            int contentLength = httpURLConnection2.getContentLength();
            if (contentLength > 0) {
                this.mFileSize = contentLength;
            }
            File file = new File(this.mOutputFolder);
            if (!file.exists()) {
                file.mkdirs();
            }
            bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(getOutputPath() + ".tmp"));
            } catch (Exception unused5) {
                httpURLConnection = httpURLConnection2;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                byteArrayOutputStream = null;
            }
            try {
                byte[] bArr = new byte[10240];
                ByteArrayOutputStream byteArrayOutputStream2 = this.saveFileAndMemory ? new ByteArrayOutputStream() : null;
                int i2 = 0;
                while (this.mState == IDownloader.DownloadStatus.DOWNLOADING && (read = bufferedInputStream.read(bArr, 0, 10240)) != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.write(bArr, 0, read);
                    }
                    i2 += read;
                    downloaded(read, i2 / this.mFileSize);
                }
                bufferedOutputStream.flush();
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.flush();
                }
                if (this.mState == IDownloader.DownloadStatus.DOWNLOADING) {
                    beforeCompleted();
                    setState(IDownloader.DownloadStatus.COMPLETED);
                } else {
                    IDownloader.DownloadStatus downloadStatus = IDownloader.DownloadStatus.ERROR;
                }
                try {
                    bufferedOutputStream.close();
                } catch (Exception unused6) {
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused7) {
                    }
                }
                try {
                    bufferedInputStream.close();
                } catch (Exception unused8) {
                }
            } catch (Exception unused9) {
                HttpURLConnection httpURLConnection3 = httpURLConnection2;
                byteArrayOutputStream = null;
                bufferedOutputStream2 = bufferedOutputStream;
                httpURLConnection = httpURLConnection3;
                try {
                    error();
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception unused10) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused11) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused12) {
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return;
                } catch (Throwable th5) {
                    th = th5;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception unused13) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused14) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception unused15) {
                        }
                    }
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused16) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                HttpURLConnection httpURLConnection4 = httpURLConnection2;
                byteArrayOutputStream = null;
                bufferedOutputStream2 = bufferedOutputStream;
                httpURLConnection = httpURLConnection4;
                if (bufferedOutputStream2 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                if (bufferedInputStream != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void setDownloadOnlyWifi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void setPausedManually(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public void setState(IDownloader.DownloadStatus downloadStatus) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, downloadStatus) == null) {
            this.mState = downloadStatus;
            stateChanged();
        }
    }

    @Override // com.baidu.mobads.container.components.downloader.IDownloader
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            setState(IDownloader.DownloadStatus.DOWNLOADING);
            download();
        }
    }

    public void stateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            setChanged();
            notifyObservers();
        }
    }
}
