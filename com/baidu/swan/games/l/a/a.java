package com.baidu.swan.games.l.a;

import android.util.Base64;
import com.baidu.swan.d.d;
/* loaded from: classes9.dex */
public class a implements com.baidu.swan.games.l.b.a {
    @Override // com.baidu.swan.games.l.b.a
    public byte[] h(String str, byte[] bArr) {
        if (str != null && bArr != null) {
            char c = 65535;
            switch (str.hashCode()) {
                case 76158:
                    if (str.equals("MD5")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1952093519:
                    if (str.equals("BASE64")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return d.toMd5(bArr, false).getBytes();
                case 1:
                    return Base64.encode(bArr, 2);
                default:
                    return bArr;
            }
        }
        return bArr;
    }
}
