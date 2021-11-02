package b.a.x0.k.f;

import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.x0.k.e.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
/* loaded from: classes6.dex */
public class f implements b.a.x0.k.e.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f29670e;

    /* renamed from: f  reason: collision with root package name */
    public final g.a f29671f;

    /* renamed from: g  reason: collision with root package name */
    public volatile int f29672g;

    /* renamed from: h  reason: collision with root package name */
    public volatile long f29673h;

    public f(String str, g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29670e = str;
        this.f29671f = aVar;
    }

    public final void a() throws DownloadException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!isCanceled()) {
                if (isPaused()) {
                    throw new DownloadException(106, "Connection Paused!");
                }
                return;
            }
            throw new DownloadException(107, "Connection Canceled!");
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0064 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() throws DownloadException {
        IOException e2;
        ProtocolException e3;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
            return;
        }
        this.f29673h = System.currentTimeMillis();
        try {
            URL url = new URL(this.f29670e);
            ?? r2 = 0;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(4000);
                        httpURLConnection.setReadTimeout(4000);
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setRequestProperty("Range", "bytes=0-");
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            d(httpURLConnection, false);
                        } else if (responseCode == 206) {
                            d(httpURLConnection, true);
                        } else {
                            throw new DownloadException(108, "UnSupported response code:" + responseCode);
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (ProtocolException e4) {
                        e3 = e4;
                        throw new DownloadException(108, "Protocol error", e3);
                    } catch (IOException e5) {
                        e2 = e5;
                        throw new DownloadException(108, "IO error", e2);
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = url;
                    if (r2 != 0) {
                        r2.disconnect();
                    }
                    throw th;
                }
            } catch (ProtocolException e6) {
                e3 = e6;
            } catch (IOException e7) {
                e2 = e7;
            } catch (Throwable th2) {
                th = th2;
                if (r2 != 0) {
                }
                throw th;
            }
        } catch (MalformedURLException e8) {
            throw new DownloadException(108, "Bad url.", e8);
        }
    }

    public final void c(DownloadException downloadException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadException) == null) {
            switch (downloadException.getErrorCode()) {
                case 106:
                    synchronized (this.f29671f) {
                        this.f29672g = 106;
                        this.f29671f.onConnectPaused();
                    }
                    return;
                case 107:
                    synchronized (this.f29671f) {
                        this.f29672g = 107;
                        this.f29671f.onConnectCanceled();
                    }
                    return;
                case 108:
                    synchronized (this.f29671f) {
                        this.f29672g = 108;
                        this.f29671f.b(downloadException);
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown state");
            }
        }
    }

    @Override // b.a.x0.k.e.g
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f29672g = 107;
        }
    }

    public final void d(HttpURLConnection httpURLConnection, boolean z) throws DownloadException {
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, httpURLConnection, z) == null) {
            String headerField = httpURLConnection.getHeaderField("Content-Length");
            if (!TextUtils.isEmpty(headerField) && !headerField.equals("0") && !headerField.equals("-1")) {
                contentLength = Long.parseLong(headerField);
            } else {
                contentLength = httpURLConnection.getContentLength();
            }
            if (contentLength <= 0) {
                String headerField2 = httpURLConnection.getHeaderField("Ohc-File-Size");
                if (!TextUtils.isEmpty(headerField2) && !headerField2.equals("0") && !headerField2.equals("-1")) {
                    contentLength = Long.parseLong(headerField2);
                } else {
                    contentLength = httpURLConnection.getContentLength();
                }
                if (contentLength <= 0) {
                    throw new DownloadException(108, "length <= 0");
                }
            }
            a();
            this.f29672g = 103;
            this.f29671f.onConnected(System.currentTimeMillis() - this.f29673h, contentLength, z);
        }
    }

    @Override // b.a.x0.k.e.g
    public boolean isCanceled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29672g == 107 : invokeV.booleanValue;
    }

    @Override // b.a.x0.k.e.g
    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29672g == 106 : invokeV.booleanValue;
    }

    @Override // b.a.x0.k.e.g
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f29672g = 106;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Process.setThreadPriority(10);
            this.f29672g = 102;
            this.f29671f.onConnecting();
            try {
                b();
            } catch (DownloadException e2) {
                c(e2);
            }
        }
    }
}
