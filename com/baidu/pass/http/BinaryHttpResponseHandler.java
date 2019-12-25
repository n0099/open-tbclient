package com.baidu.pass.http;

import android.os.Looper;
import android.util.Log;
import com.baidu.android.util.media.MimeType;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class BinaryHttpResponseHandler extends HttpResponseHandler {
    private String[] a;

    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        this.a = new String[]{MimeType.Image.PNG, MimeType.Image.JPEG, "image/jpg", "image/gif"};
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr) {
        this(looper, strArr, false);
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr, boolean z) {
        super(looper);
        this.a = new String[]{MimeType.Image.PNG, MimeType.Image.JPEG, "image/jpg", "image/gif"};
        this.a = strArr;
        this.executCallbackInChildThread = z;
    }

    protected void onSuccess(int i, byte[] bArr) {
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    void a(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.executCallbackInChildThread) {
            b(i, hashMap, bArr);
        } else {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), hashMap, bArr}));
        }
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    void b(int i, HashMap<String, String> hashMap, byte[] bArr) {
        boolean z;
        Log.i("dragon", "in handleSuccessMessage");
        if (hashMap == null || hashMap.get("Content-Type") == null) {
            a(new HttpErrorException(i, "None or more than one Content-Type Header found!"), null);
            return;
        }
        String str = hashMap.get("Content-Type");
        Log.i("dragon", "Content-Type = " + str);
        String[] strArr = this.a;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (!strArr[i2].equalsIgnoreCase(str)) {
                i2++;
            } else {
                z = true;
                break;
            }
        }
        if (!z) {
            a(new HttpErrorException(i, "Content-Type not allowed!"), null);
        } else {
            onSuccess(i, bArr);
        }
    }
}
