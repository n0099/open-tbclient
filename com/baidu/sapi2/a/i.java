package com.baidu.sapi2.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;
/* loaded from: classes.dex */
public class i {
    protected static final int h = 0;
    protected static final int i = 1;
    protected static final int j = 2;
    protected static final int k = 3;
    private Handler a;

    public i() {
        if (Looper.myLooper() != null) {
            this.a = new a();
        }
    }

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            i.this.a(message);
        }
    }

    public void onStart() {
    }

    public void onFinish() {
    }

    public void onSuccess(String str) {
    }

    public void onSuccess(int i2, String str) {
        onSuccess(str);
    }

    public void onFailure(Throwable th) {
    }

    public void onFailure(Throwable th, String str) {
        onFailure(th);
    }

    protected void a(int i2, String str) {
        b(b(0, new Object[]{Integer.valueOf(i2), str}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Throwable th, String str) {
        b(b(1, new Object[]{th, str}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Throwable th, byte[] bArr) {
        b(b(1, new Object[]{th, bArr}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        b(b(2, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        b(b(3, (Object) null));
    }

    protected void b(int i2, String str) {
        if (str != null && str.startsWith("\ufeff")) {
            str = str.substring(1);
        }
        onSuccess(i2, str);
    }

    protected void a(Throwable th, String str) {
        onFailure(th, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                b(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                return;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                a((Throwable) objArr2[0], (String) objArr2[1]);
                return;
            case 2:
                onStart();
                return;
            case 3:
                onFinish();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Message message) {
        if (this.a != null) {
            this.a.sendMessage(message);
        } else {
            a(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message b(int i2, Object obj) {
        if (this.a != null) {
            return this.a.obtainMessage(i2, obj);
        }
        Message obtain = Message.obtain();
        obtain.what = i2;
        obtain.obj = obj;
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(HttpResponse httpResponse) {
        String str = null;
        StatusLine statusLine = httpResponse.getStatusLine();
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                str = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
            }
        } catch (IOException e) {
            b(e, (String) null);
        }
        if (statusLine.getStatusCode() >= 300) {
            b((Throwable) new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), str);
        } else {
            a(statusLine.getStatusCode(), str);
        }
    }
}
