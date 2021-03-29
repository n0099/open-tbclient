package com.baidu.down.utils;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes.dex */
public class UriHelper {
    public static final boolean DEBUG = false;
    public static final String TAG = "UriHelper";
    public Uri mUriObj;
    public String mUri = "";
    public UriQuery mUriQueryObj = null;

    public UriHelper(String str) {
        this.mUriObj = null;
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            this.mUriObj = parse;
            init(parse);
            return;
        }
        throw new NullPointerException("uri is null");
    }

    public static String getDecodedValue(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException | Exception unused) {
            return str;
        }
    }

    private void init(Uri uri) {
        this.mUriQueryObj = new UriQuery(uri.getEncodedQuery());
        String uri2 = uri.toString();
        this.mUri = uri2;
        int indexOf = uri2.indexOf("?");
        if (indexOf > 0) {
            this.mUri = this.mUri.substring(0, indexOf);
        }
    }

    public void addParameterReplaceIfExist(String str, String str2) {
        this.mUriQueryObj.addParam(str, str2);
    }

    public void addWholeParameterReplaceIfExist(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("=");
        if (split.length == 2) {
            this.mUriQueryObj.addParam(split[0], split[1]);
        }
    }

    public String getParameter(String str) {
        return this.mUriQueryObj.getParameter(str);
    }

    public String getQuery() {
        return this.mUriQueryObj.getQuery();
    }

    public String getServerUri() {
        return this.mUri;
    }

    public void removeParameter(String str) {
        this.mUriQueryObj.removeParam(str);
    }

    public String toString() {
        String str = this.mUri;
        if (TextUtils.isEmpty(this.mUriQueryObj.getQuery())) {
            return str;
        }
        return str + "?" + this.mUriQueryObj.getQuery();
    }

    public UriHelper(Uri uri) {
        this.mUriObj = null;
        if (uri != null) {
            this.mUriObj = uri;
            init(uri);
            return;
        }
        throw new NullPointerException("uri is null");
    }
}
