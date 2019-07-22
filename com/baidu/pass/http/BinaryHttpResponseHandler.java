package com.baidu.pass.http;

import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class BinaryHttpResponseHandler extends HttpResponseHandler {
    private String[] a;

    public BinaryHttpResponseHandler(Looper looper) {
        super(looper);
        this.a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr) {
        this(looper, strArr, false);
    }

    public BinaryHttpResponseHandler(Looper looper, String[] strArr, boolean z) {
        super(looper);
        this.a = new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"};
        this.a = strArr;
        this.executCallbackInChildThread = z;
    }

    protected void onSuccess(int i, byte[] bArr) {
    }

    @Override // com.baidu.pass.http.HttpResponseHandler
    void a(int i, HashMap<String, String> hashMap, byte[] bArr) {
        if (this.executCallbackInChildThread) {
            c(i, hashMap, bArr);
        } else {
            sendMessage(obtainMessage(0, new Object[]{Integer.valueOf(i), hashMap, bArr}));
        }
    }

    void a(int i, Map<String, List<String>> map, byte[] bArr) {
        boolean z;
        List<String> arrayList = map != null ? map.get("Content-Type") : new ArrayList<>();
        if (arrayList.size() != 1) {
            a(new HttpErrorException(i, "None or more than one Content-Type Header found!"), null);
            return;
        }
        String str = arrayList.get(0);
        String[] strArr = this.a;
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
            a(new HttpErrorException(i, "Content-Type not allowed!"), null);
        } else {
            onSuccess(i, bArr);
        }
    }
}
