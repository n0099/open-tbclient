package com.baidu.down.utils;

import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class UriQuery {
    private static final boolean DEBUG = false;
    private static final String TAG = UriQuery.class.getSimpleName();
    private String mQuery;
    private HashMap<String, String> mParams = new HashMap<>();
    private boolean mBackupQueryDirty = false;
    private String mBackupQuery = null;
    private HashMap<String, String> mEncodedValuesCache = new HashMap<>();

    public UriQuery(String str) {
        this.mQuery = "";
        this.mQuery = str;
        parseQuery();
    }

    private void parseQuery() {
        if (!TextUtils.isEmpty(this.mQuery)) {
            String[] split = this.mQuery.split(ETAG.ITEM_SEPARATOR);
            for (int i = 0; i < split.length; i++) {
                int indexOf = split[i].indexOf(ETAG.EQUAL);
                if (indexOf >= 0) {
                    this.mParams.put(UriHelper.getDecodedValue(split[i].substring(0, indexOf)), UriHelper.getDecodedValue(split[i].substring(indexOf + 1)));
                } else {
                    this.mParams.put(UriHelper.getDecodedValue(split[i]), "");
                }
            }
            this.mBackupQueryDirty = true;
        }
    }

    public String getParameter(String str) {
        return this.mParams.get(str);
    }

    public void addParam(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.mParams.put(str, str2);
            this.mBackupQueryDirty = true;
        }
    }

    public void removeParam(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mParams.remove(str);
            this.mBackupQueryDirty = true;
        }
    }

    public String getQuery() {
        if (!this.mBackupQueryDirty) {
            return this.mBackupQuery;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.mParams.keySet()) {
            stringBuffer.append(str).append(ETAG.EQUAL).append(getEncodedValue(this.mParams.get(str))).append(ETAG.ITEM_SEPARATOR);
        }
        String stringBuffer2 = stringBuffer.toString();
        this.mBackupQueryDirty = false;
        this.mBackupQuery = stringBuffer2;
        return stringBuffer2;
    }

    private String getEncodedValue(String str) {
        String str2 = this.mEncodedValuesCache.get(str);
        if (str2 == null) {
            String encodedValue = Utils.getEncodedValue(str);
            this.mEncodedValuesCache.put(str, encodedValue);
            return encodedValue;
        }
        return str2;
    }
}
