package com.baidu.pass.main.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class FaceSec {
    public static final String TAG = "FaceSec";
    public byte[] value;

    private native String decrypt(String str);

    private native String encrypt(String str);

    private native int init(AssetManager assetManager);

    private native String sec(Context context, byte[] bArr);

    public String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return decrypt(str);
    }

    public String e(Context context, byte[] bArr) {
        return sec(context, bArr);
    }

    public String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return encrypt(str);
    }

    public int i(Context context) {
        if (context != null) {
            try {
                int init = init(context.getAssets());
                if (init == 0) {
                    return init;
                }
                throw new RuntimeException("face sdk init sec error");
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }
}
