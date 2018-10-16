package com.baidu.b.a.b.c;

import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public interface c<T> {
    String getChannelId();

    String getChannelName();

    Map<String, String> getCommonParams();

    Map<String, String> getExtParams();

    Map<String, String> getHeaderParams();

    JSONArray getUploadParam();

    Map<String, String> getUrlParams();
}
