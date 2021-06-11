package com.baidu.apollon.imagemanager;

import android.content.Context;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.FileCopyUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final long f3792a = 52428800;

    /* renamed from: b  reason: collision with root package name */
    public final InterfaceC0062a f3793b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3794c;

    /* renamed from: d  reason: collision with root package name */
    public File f3795d;

    /* renamed from: e  reason: collision with root package name */
    public long f3796e;

    /* renamed from: com.baidu.apollon.imagemanager.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        List<File> a(File file);
    }

    public a(Context context, String str, InterfaceC0062a interfaceC0062a) {
        this(context, str, "", interfaceC0062a);
    }

    public static synchronized void a(File file) {
        synchronized (a.class) {
            if (file == null) {
                return;
            }
            if (!file.isDirectory()) {
                if (file.exists()) {
                    file.delete();
                }
                file.mkdirs();
                try {
                    Thread.sleep(300L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void b() {
        if (this.f3796e < 0) {
            this.f3796e = 52428800 - c();
        }
    }

    private long c() {
        File[] listFiles = this.f3795d.listFiles();
        long j = 0;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                j += file.length();
            }
        }
        return j;
    }

    public a(Context context, String str, String str2, InterfaceC0062a interfaceC0062a) {
        this.f3796e = Long.MIN_VALUE;
        this.f3794c = str2;
        if (CheckUtils.isExternalStorageWriteable(context)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                this.f3795d = new File(externalFilesDir, str);
            } else {
                this.f3795d = new File(context.getCacheDir(), str);
            }
        } else {
            this.f3795d = new File(context.getCacheDir(), str);
        }
        if (!this.f3795d.exists()) {
            this.f3795d.mkdirs();
        }
        this.f3793b = interfaceC0062a;
    }

    private String b(String str) {
        return String.valueOf(str.hashCode()) + this.f3794c;
    }

    public static void a(byte[] bArr, File file) {
        try {
            FileCopyUtils.copy(bArr, file);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, byte[] bArr) {
        InterfaceC0062a interfaceC0062a;
        List<File> a2;
        File a3 = a(str);
        a(a3.getParentFile());
        a(bArr, a3);
        b();
        long length = this.f3796e - a(str).length();
        if (length < 0 && (interfaceC0062a = this.f3793b) != null && (a2 = interfaceC0062a.a(this.f3795d)) != null) {
            for (File file : a2) {
                length += file.length();
                file.delete();
            }
        }
        this.f3796e = length;
    }

    public File a(String str) {
        File file = new File(this.f3795d, b(str));
        if (file.exists()) {
            file.setLastModified(System.currentTimeMillis());
        }
        return file;
    }

    public void a() {
        File[] listFiles = this.f3795d.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            file.delete();
        }
    }
}
