package com.baidu.platform.comapi.walknavi.d.a.d.a;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes5.dex */
public class c {

    /* loaded from: classes5.dex */
    public interface a {
        boolean a();
    }

    /* loaded from: classes5.dex */
    public interface b extends a, InterfaceC0070c {
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.d.a.d.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0070c {
        void a(long j, long j2);
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void a(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = com.baidu.platform.comapi.walknavi.d.a.d.a.a.d(file);
            a(inputStream, fileOutputStream);
        } finally {
            a(fileOutputStream);
        }
    }

    public static void a(InputStream inputStream, File file, long j, InterfaceC0070c interfaceC0070c) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = com.baidu.platform.comapi.walknavi.d.a.d.a.a.d(file);
            a(inputStream, fileOutputStream, j, interfaceC0070c);
        } finally {
            a(fileOutputStream);
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, long j, InterfaceC0070c interfaceC0070c) throws IOException {
        a(inputStream, outputStream, j, (b) new d(interfaceC0070c));
    }

    public static void a(InputStream inputStream, OutputStream outputStream, long j, b bVar) throws IOException {
        byte[] bArr = new byte[1024];
        long j2 = 0;
        do {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j2 += read;
                if (bVar != null) {
                    bVar.a(j2, j);
                }
            } else {
                return;
            }
        } while (!bVar.a());
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
