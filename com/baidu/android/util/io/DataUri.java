package com.baidu.android.util.io;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;
import org.apache.commons.codec.binary4util.Base64;
@Deprecated
/* loaded from: classes2.dex */
public class DataUri {
    public static final boolean DEBUG = false;
    public static final String TAG = "DataUri";
    public final byte[] mData;
    public final String mMimeType;

    public DataUri(String str, byte[] bArr) {
        this.mMimeType = str;
        this.mData = bArr;
    }

    public static DataUri parseDataUri(String str) {
        int indexOf;
        String str2;
        byte[] bArr;
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith(WebGLImageLoader.DATA_URL) || (indexOf = str.indexOf(44)) == -1) {
            return null;
        }
        String substring = str.substring(5, indexOf);
        String substring2 = str.substring(indexOf + 1);
        String[] split = substring.split(";");
        if (split.length == 2 && "base64".equalsIgnoreCase(split[1])) {
            try {
                str2 = URLDecoder.decode(split[0], "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                str2 = null;
            }
            if (str2 == null) {
                str2 = split[0];
            }
            try {
                bArr = Base64.decodeBase64(substring2);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                bArr = null;
            }
            if (bArr != null) {
                return new DataUri(str2, bArr);
            }
            return null;
        }
        return null;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getMimeType() {
        return this.mMimeType;
    }
}
