package com.baidu.searchbox.dns.transmit.transmitter;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.dns.transmit.transmitter.exception.RetryException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
/* loaded from: classes2.dex */
public abstract class HttpPostDataTransmitter<T> extends HttpDataTransmitter<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HttpPostDataTransmitter";
    public transient /* synthetic */ FieldHolder $fh;

    public HttpPostDataTransmitter() {
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

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void postHandleConnection(HttpURLConnection httpURLConnection) throws RetryException {
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, httpURLConnection) == null) {
            String buildParametersString = buildParametersString(getParameters());
            if (!TextUtils.isEmpty(buildParametersString)) {
                DataOutputStream dataOutputStream2 = null;
                try {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    } catch (IOException unused) {
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    dataOutputStream.write(buildParametersString.getBytes(IMAudioTransRequest.CHARSET));
                    dataOutputStream.flush();
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException unused2) {
                    dataOutputStream2 = dataOutputStream;
                    throw new RetryException(ExceptionMessage.WRITE_CONTENT_FAIL);
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream2 = dataOutputStream;
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void processExtraConnection(HttpURLConnection httpURLConnection) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpURLConnection) == null) {
            super.processExtraConnection(httpURLConnection);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
        }
    }
}
