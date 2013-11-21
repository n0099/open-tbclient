package com.baidu.android.defense.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.common.net.ProxyHttpClient;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected Context f621a;
    protected b b;
    protected String c;
    private int d = 2;
    private int e = 0;
    private boolean f = false;

    public d(Context context, b bVar) {
        this.f621a = context.getApplicationContext();
        this.b = bVar;
    }

    private boolean a(InputStream inputStream) {
        if (com.baidu.android.systemmonitor.d.c.c() <= this.b.c * Util.BYTE_OF_MB) {
            return false;
        }
        this.c = e();
        if (TextUtils.isEmpty(this.c)) {
            return false;
        }
        File file = new File(this.c);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[LVBuffer.LENGTH_ALLOC_PER_NEW];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException e) {
            }
            fileOutputStream.close();
            return true;
        } catch (IOException e2) {
            return false;
        }
    }

    private void b() {
        boolean c;
        if (this.b == null || TextUtils.isEmpty(this.b.f619a) || TextUtils.isEmpty(this.b.b) || !ConnectManager.isNetworkConnected(this.f621a)) {
            return;
        }
        do {
            c = c();
            if (this.f) {
                d();
            }
            if (this.d <= 0) {
                break;
            }
        } while (this.f);
        if (c) {
            a();
        }
    }

    private boolean c() {
        InputStream content;
        boolean z = false;
        ProxyHttpClient proxyHttpClient = new ProxyHttpClient(this.f621a);
        try {
            HttpResponse execute = proxyHttpClient.execute(new HttpGet(this.b.f619a));
            if (execute.getStatusLine().getStatusCode() == 200 && (content = execute.getEntity().getContent()) != null && a(content)) {
                z = true;
            }
            this.e = 0;
            this.f = false;
        } catch (IOException e) {
            this.f = true;
        } catch (Exception e2) {
            this.f = false;
        } finally {
            proxyHttpClient.close();
        }
        return z;
    }

    private void d() {
        this.e++;
        if (this.e >= this.d) {
            this.f = false;
            return;
        }
        try {
            Thread.sleep((this.e + 1) * 30);
        } catch (InterruptedException e) {
        }
    }

    private String e() {
        String str = this.b.f619a;
        String substring = str.substring(str.lastIndexOf("/"));
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        String str2 = absolutePath + this.b.b;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        return str2 + substring;
    }

    protected void a() {
    }

    @Override // java.lang.Runnable
    public void run() {
        b();
    }
}
