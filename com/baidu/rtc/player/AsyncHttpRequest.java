package com.baidu.rtc.player;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.player.AsyncHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Scanner;
/* loaded from: classes2.dex */
public class AsyncHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HTTP_REQUEST_TIMEOUT_MS = 5000;
    public static final String TAG = "AsyncHttpRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public String contentType;
    public final AsyncHttpEvents events;
    public final String message;
    public final String method;
    public final String url;

    /* loaded from: classes2.dex */
    public interface AsyncHttpEvents {
        void onHttpComplete(String str);

        void onHttpError(String str);
    }

    public AsyncHttpRequest(String str, String str2, String str3, String str4, AsyncHttpEvents asyncHttpEvents) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4, asyncHttpEvents};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.method = str;
        this.url = str2;
        this.message = str3;
        this.events = asyncHttpEvents;
        this.contentType = str4;
    }

    public static String drainStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            Scanner useDelimiter = new Scanner(inputStream, "UTF-8").useDelimiter("\\A");
            if (useDelimiter.hasNext()) {
                return useDelimiter.next();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public void setContentType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.contentType = str;
        }
    }

    public void request() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            new Thread(new Runnable() { // from class: com.baidu.tieba.fl1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AsyncHttpRequest.this.sendHttpMessage();
                    }
                }
            }).start();
        }
    }

    public void sendHttpMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
                byte[] bArr = new byte[0];
                if (this.message != null) {
                    bArr = this.message.getBytes("UTF-8");
                }
                httpURLConnection.setRequestMethod(this.method);
                httpURLConnection.setUseCaches(false);
                boolean z = true;
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (this.method.equals("POST")) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                } else {
                    z = false;
                }
                if (this.contentType == null) {
                    httpURLConnection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");
                } else {
                    httpURLConnection.setRequestProperty("Content-Type", this.contentType);
                }
                httpURLConnection.setRequestProperty("Accept", "application/json");
                if (z && bArr.length > 0) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr, 0, bArr.length);
                    outputStream.close();
                    Log.d("AsyncHttpRequest", this.message);
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 200) {
                    AsyncHttpEvents asyncHttpEvents = this.events;
                    asyncHttpEvents.onHttpError("Non-200 response to " + this.method + " code " + responseCode + " to URL: " + this.url + ZeusCrashHandler.NAME_SEPERATOR + httpURLConnection.getHeaderField((String) null));
                    httpURLConnection.disconnect();
                    return;
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                String drainStream = drainStream(inputStream);
                inputStream.close();
                httpURLConnection.disconnect();
                this.events.onHttpComplete(drainStream);
            } catch (SocketTimeoutException unused) {
                AsyncHttpEvents asyncHttpEvents2 = this.events;
                asyncHttpEvents2.onHttpError("HTTP " + this.method + " to " + this.url + " timeout");
            } catch (IOException e) {
                AsyncHttpEvents asyncHttpEvents3 = this.events;
                asyncHttpEvents3.onHttpError("HTTP " + this.method + " to " + this.url + " error: " + e.getMessage());
            }
        }
    }
}
