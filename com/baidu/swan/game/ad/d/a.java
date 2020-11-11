package com.baidu.swan.game.ad.d;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
/* loaded from: classes14.dex */
public class a {
    private static final byte[] dOe = {48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};
    private static final byte[] dOf = new byte[128];

    static {
        for (int i = 0; i < dOe.length; i++) {
            dOf[dOe[i]] = (byte) i;
        }
    }

    public String encode(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
            str = str + "$";
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[(bytes.length / 3) * 4];
        int i2 = 0;
        while (i2 < bytes.length) {
            bArr[i] = dOe[(bytes[i2] & 252) >> 2];
            bArr[i + 1] = dOe[((bytes[i2] & 3) << 4) + ((bytes[i2 + 1] & 240) >> 4)];
            bArr[i + 2] = dOe[((bytes[i2 + 1] & 15) << 2) + ((bytes[i2 + 2] & 192) >> 6)];
            bArr[i + 3] = dOe[bytes[i2 + 2] & 63];
            i2 += 3;
            i += 4;
        }
        return new String(bArr);
    }
}
