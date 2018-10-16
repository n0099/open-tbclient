package com.baidu.cloudsdk.common.http;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes6.dex */
public class RequestParams {
    protected static final String ENCODING = "UTF-8";
    protected HashMap<String, String> mParams;
    protected HashMap<String, ArrayList<String>> mParamsWithArray;

    public RequestParams() {
        this.mParams = new HashMap<>();
        this.mParamsWithArray = new HashMap<>();
    }

    public RequestParams(String str, String str2) {
        this();
        put(str, str2);
    }

    public RequestParams(Map<String, String> map) {
        this();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public RequestParams(Object... objArr) {
        this();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < length; i += 2) {
            if (objArr[i] != null && objArr[i + 1] != null) {
                put(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
            }
        }
    }

    public void put(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mParams.put(str, str2);
        }
    }

    public void put(String str, ArrayList<String> arrayList) {
        if (!TextUtils.isEmpty(str) && arrayList != null && arrayList.size() > 0) {
            this.mParamsWithArray.put(str, arrayList);
        }
    }

    public void remove(String str) {
        if (str != null) {
            this.mParams.remove(str);
            this.mParamsWithArray.remove(str);
        }
    }

    public HttpEntity getHttpEntity() {
        try {
            return new UrlEncodedFormEntity(getParamsList(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public final String getQueryString() {
        return URLEncodedUtils.format(getParamsList(), "UTF-8");
    }

    public final String toString() {
        return getStringBuilder().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(entry.getKey()).append(ETAG.EQUAL).append(entry.getValue());
        }
        for (Map.Entry<String, ArrayList<String>> entry2 : this.mParamsWithArray.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            boolean z = true;
            String key = entry2.getKey();
            Iterator<String> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    if (!z) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    z = false;
                    sb.append(key).append(ETAG.EQUAL).append(next);
                }
            }
        }
        return sb;
    }

    private List<BasicNameValuePair> getParamsList() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<String, ArrayList<String>> entry2 : this.mParamsWithArray.entrySet()) {
            String key = entry2.getKey();
            Iterator<String> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    linkedList.add(new BasicNameValuePair(key, next));
                }
            }
        }
        return linkedList;
    }
}
