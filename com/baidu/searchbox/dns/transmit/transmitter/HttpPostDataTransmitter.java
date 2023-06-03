package com.baidu.searchbox.dns.transmit.transmitter;

import android.text.TextUtils;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.dns.transmit.transmitter.exception.RetryException;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
/* loaded from: classes3.dex */
public abstract class HttpPostDataTransmitter<T> extends HttpDataTransmitter<T> {
    public static final String TAG = "HttpPostDataTransmitter";

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void postHandleConnection(HttpURLConnection httpURLConnection) throws RetryException {
        DataOutputStream dataOutputStream;
        String buildParametersString = buildParametersString(getParameters());
        if (!TextUtils.isEmpty(buildParametersString)) {
            DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
            try {
                dataOutputStream.write(buildParametersString.getBytes("utf-8"));
                dataOutputStream.flush();
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException unused2) {
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

    @Override // com.baidu.searchbox.dns.transmit.transmitter.HttpDataTransmitter
    public void processExtraConnection(HttpURLConnection httpURLConnection) throws ProtocolException {
        super.processExtraConnection(httpURLConnection);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
    }
}
