package com.baidu.sapi2.a;

import android.os.Message;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;
/* loaded from: classes.dex */
public class g extends i {
    private static String[] a = {"image/jpeg", "image/png"};

    public g() {
    }

    public g(String[] strArr) {
        this();
        a = strArr;
    }

    public void a(byte[] bArr) {
    }

    public void a(int i, byte[] bArr) {
        a(bArr);
    }

    protected void b(int i, byte[] bArr) {
        b(b(0, new Object[]{Integer.valueOf(i), bArr}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.a.i
    public void a(Throwable th, byte[] bArr) {
        b(b(1, new Object[]{th, bArr}));
    }

    protected void c(int i, byte[] bArr) {
        a(i, bArr);
    }

    protected void a(Throwable th) {
        onFailure(th, "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.a.i
    public void a(Message message) {
        switch (message.what) {
            case 0:
                Object[] objArr = (Object[]) message.obj;
                c(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                return;
            case 1:
                Object[] objArr2 = (Object[]) message.obj;
                if (objArr2[0] instanceof Throwable) {
                    a((Throwable) objArr2[0]);
                    return;
                } else {
                    a(new Exception("Unknow error"));
                    return;
                }
            default:
                super.a(message);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.baidu.sapi2.a.i
    public void a(HttpResponse httpResponse) {
        byte[] bArr = null;
        boolean z = false;
        StatusLine statusLine = httpResponse.getStatusLine();
        Header[] headers = httpResponse.getHeaders("Content-Type");
        if (headers.length != 1) {
            a((Throwable) new HttpResponseException(statusLine.getStatusCode(), "None, or more than one, Content-Type Header found!"), (byte[]) null);
            return;
        }
        Header header = headers[0];
        for (String str : a) {
            if (str.equals(header.getValue())) {
                z = true;
            }
        }
        if (!z) {
            a((Throwable) new HttpResponseException(statusLine.getStatusCode(), "Content-Type not allowed!"), (byte[]) null);
            return;
        }
        try {
            HttpEntity entity = httpResponse.getEntity();
            bArr = EntityUtils.toByteArray(entity != null ? new BufferedHttpEntity(entity) : null);
        } catch (IOException e) {
            a(e, (byte[]) null);
        }
        if (statusLine.getStatusCode() >= 300) {
            a((Throwable) new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), bArr);
        } else {
            b(statusLine.getStatusCode(), bArr);
        }
    }
}
