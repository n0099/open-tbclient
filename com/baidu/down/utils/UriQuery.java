package com.baidu.down.utils;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class UriQuery {
    public static final boolean DEBUG = false;
    public static final String TAG = "UriQuery";
    public String mQuery;
    public HashMap<String, String> mParams = new HashMap<>();
    public boolean mBackupQueryDirty = false;
    public String mBackupQuery = null;
    public HashMap<String, String> mEncodedValuesCache = new HashMap<>();

    public UriQuery(String str) {
        this.mQuery = "";
        this.mQuery = str;
        parseQuery();
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

    private void parseQuery() {
        if (TextUtils.isEmpty(this.mQuery)) {
            return;
        }
        String[] split = this.mQuery.split("&");
        for (int i = 0; i < split.length; i++) {
            int indexOf = split[i].indexOf("=");
            if (indexOf >= 0) {
                this.mParams.put(UriHelper.getDecodedValue(split[i].substring(0, indexOf)), UriHelper.getDecodedValue(split[i].substring(indexOf + 1)));
            } else {
                this.mParams.put(UriHelper.getDecodedValue(split[i]), "");
            }
        }
        this.mBackupQueryDirty = true;
    }

    public void addParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mParams.put(str, str2);
        this.mBackupQueryDirty = true;
    }

    public String getParameter(String str) {
        return this.mParams.get(str);
    }

    public String getQuery() {
        if (!this.mBackupQueryDirty) {
            return this.mBackupQuery;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.mParams.keySet()) {
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(getEncodedValue(this.mParams.get(str)));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        this.mBackupQueryDirty = false;
        this.mBackupQuery = stringBuffer2;
        return stringBuffer2;
    }

    public void removeParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mParams.remove(str);
        this.mBackupQueryDirty = true;
    }
}
