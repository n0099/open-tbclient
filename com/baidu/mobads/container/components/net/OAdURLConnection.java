package com.baidu.mobads.container.components.net;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.executor.BaseTask;
import com.baidu.mobads.container.executor.TaskScheduler;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.AdURIUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class OAdURLConnection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";
    public static final int LOADER_PRIORITY_HIGH = 1;
    public static final int LOADER_PRIORITY_NORMAL = 2;
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String TAG = "URLConnection";
    public transient /* synthetic */ FieldHolder $fh;
    public RemoteXAdLogger mAdLogger;
    public OnAdRequestListener mAdRequestListener;
    public int mConnectTimeOut;
    public String mContentType;
    public HttpURLConnection mHttpURLConnection;
    public OnImageRequestListener mImageRequestListener;
    public int mPriority;
    public int mReadTimeOut;
    public String mRequestMethod;
    public String mRequestUrl;
    public Uri.Builder mUriBuilder;
    public boolean mUseCaches;
    public String mUserAgent;

    /* loaded from: classes5.dex */
    public class LoadUrlRunnable extends BaseTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OAdURLConnection this$0;

        public LoadUrlRunnable(OAdURLConnection oAdURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oAdURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = oAdURLConnection;
        }

        @Override // com.baidu.mobads.container.executor.BaseTask
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.this$0.request();
                this.this$0.connect();
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface OnAdRequestListener {
        void onFail(String str, int i2);

        void onSuccess(String str, String str2);
    }

    /* loaded from: classes5.dex */
    public interface OnImageRequestListener {
        void onFail(String str, int i2);

        void onSuccess(InputStream inputStream, String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OAdURLConnection(int i2, String str) {
        this(i2, str, "GET");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public void connect() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                try {
                    this.mHttpURLConnection.connect();
                    RemoteXAdLogger remoteXAdLogger = this.mAdLogger;
                    remoteXAdLogger.d(TAG, this.mHttpURLConnection.getRequestMethod() + " connect code :" + this.mHttpURLConnection.getResponseCode());
                    int responseCode = this.mHttpURLConnection.getResponseCode();
                    if (responseCode == 302 || responseCode == 301) {
                        this.mHttpURLConnection.setInstanceFollowRedirects(false);
                        HttpURLConnection openConnectionCheckRedirects = openConnectionCheckRedirects(this.mHttpURLConnection);
                        this.mHttpURLConnection = openConnectionCheckRedirects;
                        responseCode = openConnectionCheckRedirects.getResponseCode();
                    }
                    if (responseCode / 100 != 2) {
                        if (this.mAdRequestListener != null) {
                            this.mAdRequestListener.onFail(this.mHttpURLConnection.getResponseMessage(), responseCode);
                        }
                        if (this.mImageRequestListener != null) {
                            this.mImageRequestListener.onFail(this.mHttpURLConnection.getResponseMessage(), responseCode);
                        }
                    } else {
                        String fixedString = AdURIUtils.getFixedString(this.mRequestUrl);
                        if (this.mAdRequestListener != null) {
                            this.mAdRequestListener.onSuccess(getReadContent(), fixedString);
                        }
                        if (this.mImageRequestListener != null) {
                            this.mImageRequestListener.onSuccess(this.mHttpURLConnection.getInputStream(), fixedString);
                        }
                    }
                    httpURLConnection = this.mHttpURLConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                } catch (Exception e2) {
                    if (this.mAdRequestListener != null) {
                        OnAdRequestListener onAdRequestListener = this.mAdRequestListener;
                        onAdRequestListener.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                    }
                    if (this.mImageRequestListener != null) {
                        OnImageRequestListener onImageRequestListener = this.mImageRequestListener;
                        onImageRequestListener.onFail("Net Connect RuntimeError: " + e2.toString(), 0);
                    }
                    httpURLConnection = this.mHttpURLConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                HttpURLConnection httpURLConnection2 = this.mHttpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        }
    }

    private HttpURLConnection openConnectionCheckRedirects(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, httpURLConnection)) != null) {
            return (HttpURLConnection) invokeL.objValue;
        }
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField("Location")).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
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

    private void postDataToOutputStream(String str, HttpURLConnection httpURLConnection) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, this, str, httpURLConnection) != null) {
            return;
        }
        BufferedWriter bufferedWriter = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                try {
                    bufferedWriter2.write(str);
                    bufferedWriter2.flush();
                    bufferedWriter2.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void request() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || TextUtils.isEmpty(this.mRequestUrl)) {
            return;
        }
        try {
            HttpURLConnection httpURLConnection = AdURIUtils.getHttpURLConnection(new URL(this.mRequestUrl));
            this.mHttpURLConnection = httpURLConnection;
            httpURLConnection.setConnectTimeout(this.mConnectTimeOut);
            this.mHttpURLConnection.setReadTimeout(this.mReadTimeOut);
            if (Integer.parseInt(Build.VERSION.SDK) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.mHttpURLConnection.setRequestMethod(this.mRequestMethod);
            this.mHttpURLConnection.setUseCaches(this.mUseCaches);
            if (!TextUtils.isEmpty(this.mUserAgent)) {
                this.mHttpURLConnection.setRequestProperty("User-Agent", this.mUserAgent);
            }
            this.mHttpURLConnection.setRequestProperty("Content-type", this.mContentType);
            this.mHttpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, "keep-alive");
            this.mHttpURLConnection.setRequestProperty("Cache-Control", "no-cache");
            if (this.mRequestMethod.equals("POST")) {
                this.mHttpURLConnection.setDoInput(true);
                this.mHttpURLConnection.setDoOutput(true);
                if (this.mUriBuilder != null) {
                    postDataToOutputStream(this.mUriBuilder.build().getEncodedQuery(), this.mHttpURLConnection);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            OnAdRequestListener onAdRequestListener = this.mAdRequestListener;
            if (onAdRequestListener != null) {
                onAdRequestListener.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
            OnImageRequestListener onImageRequestListener = this.mImageRequestListener;
            if (onImageRequestListener != null) {
                onImageRequestListener.onFail("Net Create RuntimeError: " + e2.toString(), 0);
            }
        } catch (Throwable th) {
            OnAdRequestListener onAdRequestListener2 = this.mAdRequestListener;
            if (onAdRequestListener2 != null) {
                onAdRequestListener2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
            OnImageRequestListener onImageRequestListener2 = this.mImageRequestListener;
            if (onImageRequestListener2 != null) {
                onImageRequestListener2.onFail("Net Create RuntimeError: " + th.toString(), 0);
            }
        }
    }

    public void addAdRequestListener(OnAdRequestListener onAdRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onAdRequestListener) == null) {
            this.mAdRequestListener = onAdRequestListener;
        }
    }

    public void addImageRequestListener(OnImageRequestListener onImageRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onImageRequestListener) == null) {
            this.mImageRequestListener = onImageRequestListener;
        }
    }

    public void asynLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                if (this.mPriority == 1) {
                    TaskScheduler.getInstance().submit(new LoadUrlRunnable(this), 1);
                } else {
                    TaskScheduler.getInstance().submit(new LoadUrlRunnable(this), 2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void closeInputStream() {
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (httpURLConnection = this.mHttpURLConnection) == null) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e2) {
            e2.toString();
        }
    }

    public String getReadContent() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            InputStream inputStream = null;
            try {
                inputStream = this.mHttpURLConnection.getInputStream();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[128];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toString();
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        return (String) invokeV.objValue;
    }

    public void setConnectTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.mConnectTimeOut = i2;
        }
    }

    public void setContentType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.mContentType = str;
        }
    }

    public void setReadTimeout(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.mReadTimeOut = i2;
        }
    }

    public void setRequestProperty(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, map) == null) || this.mHttpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.mHttpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public void setUriBuilder(Uri.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, builder) == null) {
            this.mUriBuilder = builder;
        }
    }

    public String synLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            request();
            HttpURLConnection httpURLConnection = this.mHttpURLConnection;
            if (httpURLConnection != null) {
                try {
                    if (httpURLConnection.getResponseCode() / 100 != 2) {
                        HttpURLConnection httpURLConnection2 = this.mHttpURLConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        return null;
                    }
                    String readContent = getReadContent();
                    HttpURLConnection httpURLConnection3 = this.mHttpURLConnection;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    return readContent;
                } catch (Throwable unused) {
                    HttpURLConnection httpURLConnection4 = this.mHttpURLConnection;
                    if (httpURLConnection4 != null) {
                        httpURLConnection4.disconnect();
                    }
                }
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public OAdURLConnection(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.mAdRequestListener = null;
        this.mImageRequestListener = null;
        this.mContentType = "text/plain";
        this.mConnectTimeOut = 10000;
        this.mReadTimeOut = 10000;
        this.mUseCaches = false;
        this.mUriBuilder = null;
        this.mPriority = i2;
        this.mRequestUrl = str;
        this.mRequestMethod = str2;
    }
}
