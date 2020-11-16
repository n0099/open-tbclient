package com.baidu.pass.http;

import android.os.Looper;
import com.baidu.android.util.media.MimeType;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class BinaryHttpResponseHandler extends HttpResponseHandler implements com.baidu.pass.a {

    /* renamed from: a  reason: collision with root package name */
    private String[] f2785a;

    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        this.f2785a = new String[]{MimeType.Image.PNG, MimeType.Image.JPEG, MimeType.Image.JPG, "image/gif"};
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    void a(int i, HashMap<String, String> hashMap, byte[] bArr) {
        boolean z;
        if (hashMap != null && hashMap.get("Content-Type") != null) {
            String str = hashMap.get("Content-Type");
            String[] strArr = this.f2785a;
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = false;
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
    void c(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.executCallbackInChildThread) {
            a(i, hashMap, bArr);
        } else {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), hashMap, bArr}));
        }
    }

    protected void onSuccess(int i, byte[] bArr) {
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr) {
        this(looper, strArr, false);
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr, boolean z) {
        super(looper);
        this.f2785a = new String[]{MimeType.Image.PNG, MimeType.Image.JPEG, MimeType.Image.JPG, "image/gif"};
        this.f2785a = strArr;
        this.executCallbackInChildThread = z;
    }
}
