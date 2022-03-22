package cn.com.chinatelecom.gateway.lib.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, str, str2)) == null) {
            String str3 = "";
            BufferedReader bufferedReader = null;
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestProperty(BOSTokenRequest.ACCEPT, "*/*");
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.addRequestProperty("Accept-Charset", "UTF-8");
                    if (TextUtils.isEmpty(str2)) {
                        httpURLConnection.connect();
                    } else {
                        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(httpURLConnection.getOutputStream()));
                        dataOutputStream.write(str2.getBytes("UTF-8"));
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    }
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            StringBuilder sb = new StringBuilder();
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    sb.append(readLine);
                                    sb.append("\n");
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader2;
                                    try {
                                        th.printStackTrace();
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        return str3;
                                    } catch (Throwable th3) {
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                                throw th3;
                                            }
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        throw th3;
                                    }
                                }
                            }
                            str3 = sb.toString();
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        inputStream = null;
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return str3;
        }
        return (String) invokeLLL.objValue;
    }
}
