package com.baidu.searchbox.v8engine.net;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.NotProguard;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;
@NotProguard
/* loaded from: classes2.dex */
public class NetRequestParam implements IHeaderMap {
    public static final byte DATA_TYPE_JSON = 1;
    public static final byte DATA_TYPE_STRING = 0;
    public static final byte METHOD_CONNECT = 7;
    public static final byte METHOD_DELETE = 5;
    public static final byte METHOD_GET = 1;
    public static final byte METHOD_HEAD = 2;
    public static final byte METHOD_OPTIONS = 0;
    public static final byte METHOD_POST = 3;
    public static final byte METHOD_PUT = 4;
    public static final byte METHOD_TRACE = 6;
    public static final byte METHOD_UNKNOWN = 8;
    public static final byte RESPONSE_TYPE_ARRAY_BUFFER = 1;
    public static final byte RESPONSE_TYPE_TEXT = 0;
    public static final String TAG = "NetRequestParam";
    public Object mData;
    public byte mDataType;
    public boolean mDirty;
    public HeaderMap mHeaderMap;
    public JsObject mJsObject;
    public byte mMethod;
    public long mNativePtr;
    public NetRequestCallback mNetRequestCallback;
    public Observer mNetRequestObserver;
    public byte mResponseType;
    public String mUrl;

    /* loaded from: classes2.dex */
    public static class Builder {
        public NetRequestParam mNetRequestParam = new NetRequestParam(0);

        public NetRequestParam build() {
            return this.mNetRequestParam;
        }

        public Builder setData(String str) {
            this.mNetRequestParam.mData = str;
            return this;
        }

        public Builder setDataType(byte b2) {
            this.mNetRequestParam.mDataType = b2;
            return this;
        }

        public Builder setHeaderMap(Map<String, String> map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.mNetRequestParam.mHeaderMap.addHeader(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMethod(byte b2) {
            this.mNetRequestParam.mMethod = b2;
            return this;
        }

        public Builder setNetRequestCallback(NetRequestCallback netRequestCallback) {
            this.mNetRequestParam.mNetRequestCallback = netRequestCallback;
            return this;
        }

        public Builder setResponseType(byte b2) {
            this.mNetRequestParam.mResponseType = b2;
            return this;
        }

        public Builder setUrl(String str) {
            this.mNetRequestParam.mUrl = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class HeaderMap implements IHeaderMap {
        public Map<String, String> mMap = new HashMap();
        public long mNativePtr;

        public HeaderMap(long j) {
            this.mNativePtr = 0L;
            this.mNativePtr = j;
        }

        private native void nativeAddHeader(long j, String str, String str2);

        private native String nativeGetHeaderValue(long j, String str);

        private native String[] nativeGetTransformedHeaderMap(long j);

        private native boolean nativeHasHeader(long j, String str);

        private native void nativeRemoveHeader(long j, String str);

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public void addHeader(String str, String str2) {
            this.mMap.put(str, str2);
            long j = this.mNativePtr;
            if (j != 0) {
                nativeAddHeader(j, str, str2);
            }
        }

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public String getHeaderValue(String str) {
            String str2 = this.mMap.get(str);
            if (str2 != null) {
                return str2;
            }
            long j = this.mNativePtr;
            if (j != 0) {
                return nativeGetHeaderValue(j, str);
            }
            return null;
        }

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public Map<String, String> getTransformedHeaderMap() {
            return NetRequestParam.stringPairToMap(nativeGetTransformedHeaderMap(this.mNativePtr));
        }

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public boolean hasHeader(String str) {
            if (this.mMap.get(str) != null) {
                return true;
            }
            long j = this.mNativePtr;
            if (j != 0) {
                return nativeHasHeader(j, str);
            }
            return false;
        }

        @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
        public void removeHeader(String str) {
            this.mMap.remove(str);
            long j = this.mNativePtr;
            if (j != 0) {
                nativeRemoveHeader(j, str);
            }
        }
    }

    public static String buildUrlWithJsonStringQuery(String str, String str2) {
        return a.a(str, str2);
    }

    public static String buildUrlWithStringArrayQuery(String str, String[] strArr) {
        return a.a(str, strArr);
    }

    private void clearDirty() {
        this.mDirty = false;
    }

    public static String encodeQuery(String str) {
        return a.c(str);
    }

    private Map<String, String> getJavaHeaderMap() {
        return this.mHeaderMap.mMap;
    }

    private String[] getJavaHeaderMapStringPairs() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.mHeaderMap.mMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                arrayList.add(str);
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private boolean isDirty() {
        return this.mDirty;
    }

    private native Object nativeGetData(long j);

    private native void nativeSetData(long j, String str);

    private native void nativeSetDataType(long j, byte b2);

    private native void nativeSetMethod(long j, byte b2);

    private native void nativeSetResponseType(long j, byte b2);

    private native void nativeSetUrl(long j, String str);

    private void setDirty(boolean z) {
        this.mDirty = z;
    }

    public static Map<String, String> stringPairToMap(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            int i3 = i2 + 1;
            if (i3 < strArr.length) {
                hashMap.put(strArr[i2], strArr[i3]);
            }
        }
        return hashMap;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public void addHeader(String str, String str2) {
        this.mDirty = true;
        this.mHeaderMap.addHeader(str, str2);
    }

    public Object getData() {
        Object obj = this.mData;
        if (obj != null) {
            return obj;
        }
        long j = this.mNativePtr;
        if (j != 0) {
            this.mData = nativeGetData(j);
        }
        return this.mData;
    }

    public byte getDataType() {
        return this.mDataType;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public String getHeaderValue(String str) {
        return this.mHeaderMap.getHeaderValue(str);
    }

    public JsObject getJsObject() {
        return this.mJsObject;
    }

    public byte getMethod() {
        return this.mMethod;
    }

    public NetRequestCallback getNetRequestCallback() {
        return this.mNetRequestCallback;
    }

    public byte getResponseType() {
        return this.mResponseType;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public Map<String, String> getTransformedHeaderMap() {
        return this.mHeaderMap.getTransformedHeaderMap();
    }

    public String getUrl() {
        return this.mUrl;
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public boolean hasHeader(String str) {
        return this.mHeaderMap.hasHeader(str);
    }

    @Override // com.baidu.searchbox.v8engine.net.IHeaderMap
    public void removeHeader(String str) {
        this.mDirty = true;
        this.mHeaderMap.removeHeader(str);
    }

    public NetRequestParam setData(String str) {
        this.mDirty = true;
        this.mData = str;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetData(j, str);
        }
        return this;
    }

    public NetRequestParam setDataType(byte b2) {
        this.mDirty = true;
        this.mDataType = b2;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetDataType(j, b2);
        }
        return this;
    }

    public void setJsObject(JsObject jsObject) {
        this.mJsObject = jsObject;
    }

    public NetRequestParam setMethod(byte b2) {
        this.mDirty = true;
        this.mMethod = b2;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetMethod(j, b2);
        }
        return this;
    }

    public void setNetRequestCallback(NetRequestCallback netRequestCallback) {
        this.mNetRequestCallback = netRequestCallback;
    }

    public NetRequestParam setResponseType(byte b2) {
        this.mDirty = true;
        this.mResponseType = b2;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetResponseType(j, b2);
        }
        return this;
    }

    public NetRequestParam setUrl(String str) {
        this.mDirty = true;
        this.mUrl = str;
        long j = this.mNativePtr;
        if (j != 0) {
            nativeSetUrl(j, str);
        }
        return this;
    }

    public NetRequestParam(long j) {
        this.mNativePtr = j;
        this.mHeaderMap = new HeaderMap(j);
    }

    public static String encodeQuery(String[] strArr) {
        return a.a(strArr);
    }

    public NetRequestParam(long j, JsObject jsObject) {
        this(j);
        this.mJsObject = jsObject;
    }
}
