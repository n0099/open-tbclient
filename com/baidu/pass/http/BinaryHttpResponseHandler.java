package com.baidu.pass.http;

import android.os.Looper;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class BinaryHttpResponseHandler extends HttpResponseHandler implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    public String[] f9742a;

    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        this.f9742a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    public void a(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (hashMap != null && hashMap.get("Content-Type") != null) {
            String str = hashMap.get("Content-Type");
            String[] strArr = this.f9742a;
            int length = strArr.length;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (strArr[i2].equalsIgnoreCase(str)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                b(new HttpErrorException(i, "Content-Type not allowed!"), null);
                return;
            } else {
                onSuccess(i, bArr);
                return;
            }
        }
        b(new HttpErrorException(i, "None or more than one Content-Type Header found!"), null);
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    public void c(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.executCallbackInChildThread) {
            a(i, hashMap, bArr);
        } else {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), hashMap, bArr}));
        }
    }

    public void onSuccess(int i, byte[] bArr) {
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr) {
        this(looper, strArr, false);
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr, boolean z) {
        super(looper);
        this.f9742a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
        this.f9742a = strArr;
        this.executCallbackInChildThread = z;
    }
}
