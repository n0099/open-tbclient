package com.baidu.cloudsdk.common.http;

import android.text.TextUtils;
import com.baidu.cloudsdk.common.util.Utils;
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
/* loaded from: classes.dex */
public class RequestParams {
    protected static final String ENCODING = "UTF-8";
    protected HashMap mParams;
    protected HashMap mParamsWithArray;

    public RequestParams() {
        this.mParams = new HashMap();
        this.mParamsWithArray = new HashMap();
    }

    public RequestParams(String str, String str2) {
        this();
        put(str, str2);
    }

    public RequestParams(Map map) {
        this();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                put((String) entry.getKey(), (String) entry.getValue());
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

    private List a() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry entry : this.mParams.entrySet()) {
            linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        for (Map.Entry entry2 : this.mParamsWithArray.entrySet()) {
            String str = (String) entry2.getKey();
            Iterator it = ((ArrayList) entry2.getValue()).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!TextUtils.isEmpty(str2)) {
                    linkedList.add(new BasicNameValuePair(str, str2));
                }
            }
        }
        return linkedList;
    }

    public HttpEntity getHttpEntity() {
        try {
            return new UrlEncodedFormEntity(a(), ENCODING);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public final String getQueryString() {
        return URLEncodedUtils.format(a(), ENCODING);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : this.mParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append((String) entry.getKey()).append("=").append((String) entry.getValue());
        }
        for (Map.Entry entry2 : this.mParamsWithArray.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            boolean z = true;
            String str = (String) entry2.getKey();
            Iterator it = ((ArrayList) entry2.getValue()).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!TextUtils.isEmpty(str2)) {
                    if (!z) {
                        sb.append("&");
                    }
                    z = false;
                    sb.append(str).append("=").append(str2);
                }
            }
        }
        return sb;
    }

    public void put(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.mParams.put(str, str2);
    }

    public void put(String str, ArrayList arrayList) {
        if (TextUtils.isEmpty(str) || Utils.isEmpty(arrayList)) {
            return;
        }
        this.mParamsWithArray.put(str, arrayList);
    }

    public void remove(String str) {
        if (str != null) {
            this.mParams.remove(str);
            this.mParamsWithArray.remove(str);
        }
    }

    public final String toString() {
        return getStringBuilder().toString();
    }
}
