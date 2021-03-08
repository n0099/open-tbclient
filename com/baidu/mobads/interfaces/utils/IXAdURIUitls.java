package com.baidu.mobads.interfaces.utils;

import android.net.Uri;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes4.dex */
public interface IXAdURIUitls {
    String addParameter(String str, String str2, String str3);

    String addParameters(String str, HashMap<String, String> hashMap);

    void closeHttpURLConnection(HttpURLConnection httpURLConnection);

    String encodeUrl(String str);

    HashMap<String, String> getAllQueryParameters(String str);

    String getFileName(String str);

    String getFixedString(String str);

    HttpURLConnection getHttpURLConnection(URL url);

    Set<String> getQueryParameterNames(Uri uri);

    String getQueryString(String str);

    String getRequestAdUrl(String str, HashMap<String, String> hashMap);

    Boolean isHttpProtocol(String str);

    Boolean isHttpsProtocol(String str);

    Boolean isMessageProtocol(String str);

    void pintHttpInNewThread(String str);

    String replaceURLWithSupportProtocol(String str);
}
