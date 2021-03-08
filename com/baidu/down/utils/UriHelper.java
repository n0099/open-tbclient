package com.baidu.down.utils;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
/* loaded from: classes6.dex */
public class UriHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = UriHelper.class.getSimpleName();
    private Uri mUriObj;
    private String mUri = "";
    private UriQuery mUriQueryObj = null;

    public UriHelper(String str) {
        this.mUriObj = null;
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("uri is null");
        }
        this.mUriObj = Uri.parse(str);
        init(this.mUriObj);
    }

    public UriHelper(Uri uri) {
        this.mUriObj = null;
        if (uri == null) {
            throw new NullPointerException("uri is null");
        }
        this.mUriObj = uri;
        init(uri);
    }

    private void init(Uri uri) {
        this.mUriQueryObj = new UriQuery(uri.getEncodedQuery());
        this.mUri = uri.toString();
        int indexOf = this.mUri.indexOf("?");
        if (indexOf > 0) {
            this.mUri = this.mUri.substring(0, indexOf);
        }
    }

    public String getServerUri() {
        return this.mUri;
    }

    public String getQuery() {
        return this.mUriQueryObj.getQuery();
    }

    public String getParameter(String str) {
        return this.mUriQueryObj.getParameter(str);
    }

    public void addParameterReplaceIfExist(String str, String str2) {
        this.mUriQueryObj.addParam(str, str2);
    }

    public void addWholeParameterReplaceIfExist(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("=");
            if (split.length == 2) {
                this.mUriQueryObj.addParam(split[0], split[1]);
            }
        }
    }

    public void removeParameter(String str) {
        this.mUriQueryObj.removeParam(str);
    }

    public static String getDecodedValue(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        } catch (Exception e2) {
            return str;
        }
    }

    public String toString() {
        String str = this.mUri;
        if (!TextUtils.isEmpty(this.mUriQueryObj.getQuery())) {
            return str + "?" + this.mUriQueryObj.getQuery();
        }
        return str;
    }
}
