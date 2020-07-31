package com.baidu.android.util.io;

import android.text.TextUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.apache.commons.codec.binary4util.Base64;
/* loaded from: classes10.dex */
public class DataUri {
    private static final boolean DEBUG = false;
    private static final String TAG = "DataUri";
    private final byte[] mData;
    private final String mMimeType;

    public DataUri(String str, byte[] bArr) {
        this.mMimeType = str;
        this.mData = bArr;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public byte[] getData() {
        return this.mData;
    }

    public static DataUri parseDataUri(String str) {
        int indexOf;
        DataUri dataUri;
        String str2;
        byte[] bArr;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("data:") || (indexOf = str.indexOf(44)) == -1) {
            return null;
        }
        String substring = str.substring("data:".length(), indexOf);
        String substring2 = str.substring(indexOf + 1);
        String[] split = substring.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        if (split.length == 2 && "base64".equalsIgnoreCase(split[1])) {
            try {
                str2 = URLDecoder.decode(split[0], "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                str2 = null;
            }
            if (str2 == null) {
                str2 = split[0];
            }
            try {
                bArr = Base64.decodeBase64(substring2);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                bArr = null;
            }
            if (bArr != null) {
                dataUri = new DataUri(str2, bArr);
                return dataUri;
            }
        }
        dataUri = null;
        return dataUri;
    }
}
