package com.baidu.idl.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/* loaded from: classes8.dex */
public class HttpClient {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public HttpClient() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String post(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            HttpPost httpPost = new HttpPost(str);
            try {
                httpPost.setEntity(new StringEntity(str2));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            new ArrayList().add(new BasicNameValuePair("data", str2));
            try {
                HttpResponse execute = new DefaultHttpClient().execute(httpPost);
                StuLogEx.v("HttpClient", " httpResponse.getStatusLine().getStatusCode()  : " + execute.getStatusLine().getStatusCode());
                if (execute.getStatusLine().getStatusCode() == 200) {
                    return EntityUtils.toString(execute.getEntity());
                }
                return null;
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                return null;
            } catch (ClientProtocolException e4) {
                e4.printStackTrace();
                return null;
            } catch (IOException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
