package com.baidu.android.nebula.b;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class l implements f {
    final /* synthetic */ h a;
    private final p b;
    private final OutputStream c;
    private InputStream d;
    private int e;
    private int f;
    private String g;
    private k h;
    private Map i;
    private Map j;
    private r k;
    private String l;

    public l(h hVar, p pVar, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
        this.a = hVar;
        this.b = pVar;
        this.d = inputStream;
        this.c = outputStream;
        String str = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
        this.j = new HashMap();
        this.j.put("remote-addr", str);
        this.j.put("http-client-ip", str);
    }

    private int a(ByteBuffer byteBuffer, int i) {
        while (i < byteBuffer.limit()) {
            if (byteBuffer.get(i) == 13) {
                i++;
                if (byteBuffer.get(i) == 10) {
                    i++;
                    if (byteBuffer.get(i) == 13) {
                        i++;
                        if (byteBuffer.get(i) == 10) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
        return i + 1;
    }

    private int a(byte[] bArr, int i) {
        for (int i2 = 0; i2 + 3 < i; i2++) {
            if (bArr[i2] == 13 && bArr[i2 + 1] == 10 && bArr[i2 + 2] == 13 && bArr[i2 + 3] == 10) {
                return i2 + 4;
            }
        }
        return 0;
    }

    private String a(ByteBuffer byteBuffer, int i, int i2) {
        FileOutputStream fileOutputStream;
        String str = "";
        if (i2 > 0) {
            try {
                s a = this.b.a();
                ByteBuffer duplicate = byteBuffer.duplicate();
                fileOutputStream = new FileOutputStream(a.b());
                try {
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        duplicate.position(i).limit(i + i2);
                        channel.write(duplicate.slice());
                        str = a.b();
                        h.b(fileOutputStream);
                    } catch (Exception e) {
                        e = e;
                        System.err.println("Error: " + e.getMessage());
                        h.b(fileOutputStream);
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    h.b(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                h.b(fileOutputStream);
                throw th;
            }
        }
        return str;
    }

    private void a(BufferedReader bufferedReader, Map map, Map map2, Map map3) {
        String a;
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(readLine);
            if (!stringTokenizer.hasMoreTokens()) {
                throw new o(u.BAD_REQUEST, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
            }
            map.put("method", stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                throw new o(u.BAD_REQUEST, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
            }
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(63);
            if (indexOf >= 0) {
                a(nextToken.substring(indexOf + 1), map2);
                a = this.a.a(nextToken.substring(0, indexOf));
            } else {
                a = this.a.a(nextToken);
            }
            if (stringTokenizer.hasMoreTokens()) {
                String readLine2 = bufferedReader.readLine();
                while (readLine2 != null && readLine2.trim().length() > 0) {
                    int indexOf2 = readLine2.indexOf(58);
                    if (indexOf2 >= 0) {
                        map3.put(readLine2.substring(0, indexOf2).trim().toLowerCase(Locale.US), readLine2.substring(indexOf2 + 1).trim());
                    }
                    readLine2 = bufferedReader.readLine();
                }
            }
            map.put("uri", a);
        } catch (IOException e) {
            throw new o(u.INTERNAL_ERROR, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
        }
    }

    private void a(String str, ByteBuffer byteBuffer, BufferedReader bufferedReader, Map map, Map map2) {
        try {
            int[] a = a(byteBuffer, str.getBytes());
            int i = 1;
            String readLine = bufferedReader.readLine();
            while (readLine != null) {
                if (!readLine.contains(str)) {
                    throw new o(u.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
                }
                int i2 = i + 1;
                HashMap hashMap = new HashMap();
                String readLine2 = bufferedReader.readLine();
                while (readLine2 != null && readLine2.trim().length() > 0) {
                    int indexOf = readLine2.indexOf(58);
                    if (indexOf != -1) {
                        hashMap.put(readLine2.substring(0, indexOf).trim().toLowerCase(Locale.US), readLine2.substring(indexOf + 1).trim());
                    }
                    readLine2 = bufferedReader.readLine();
                }
                if (readLine2 != null) {
                    String str2 = (String) hashMap.get("content-disposition");
                    if (str2 == null) {
                        throw new o(u.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(str2, "; ");
                    HashMap hashMap2 = new HashMap();
                    while (stringTokenizer.hasMoreTokens()) {
                        String nextToken = stringTokenizer.nextToken();
                        int indexOf2 = nextToken.indexOf(61);
                        if (indexOf2 != -1) {
                            hashMap2.put(nextToken.substring(0, indexOf2).trim().toLowerCase(Locale.US), nextToken.substring(indexOf2 + 1).trim());
                        }
                    }
                    String str3 = (String) hashMap2.get("name");
                    String substring = str3.substring(1, str3.length() - 1);
                    String str4 = "";
                    if (hashMap.get("content-type") != null) {
                        if (i2 <= a.length) {
                            int a2 = a(byteBuffer, a[i2 - 2]);
                            map2.put(substring, a(byteBuffer, a2, (a[i2 - 1] - a2) - 4));
                            String str5 = (String) hashMap2.get("filename");
                            str4 = str5.substring(1, str5.length() - 1);
                            do {
                                readLine2 = bufferedReader.readLine();
                                if (readLine2 == null) {
                                    break;
                                }
                            } while (!readLine2.contains(str));
                        } else {
                            throw new o(u.INTERNAL_ERROR, "Error processing request");
                        }
                    } else {
                        while (readLine2 != null && !readLine2.contains(str)) {
                            readLine2 = bufferedReader.readLine();
                            if (readLine2 != null) {
                                int indexOf3 = readLine2.indexOf(str);
                                str4 = indexOf3 == -1 ? str4 + readLine2 : str4 + readLine2.substring(0, indexOf3 - 2);
                            }
                        }
                    }
                    String str6 = str4;
                    readLine = readLine2;
                    map.put(substring, str6);
                } else {
                    readLine = readLine2;
                }
                i = i2;
            }
        } catch (IOException e) {
            throw new o(u.INTERNAL_ERROR, "SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
        }
    }

    private void a(String str, Map map) {
        if (str == null) {
            this.l = "";
            return;
        }
        this.l = str;
        StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf(61);
            if (indexOf >= 0) {
                map.put(this.a.a(nextToken.substring(0, indexOf)).trim(), this.a.a(nextToken.substring(indexOf + 1)));
            } else {
                map.put(this.a.a(nextToken).trim(), "");
            }
        }
    }

    private int[] a(ByteBuffer byteBuffer, byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        while (i < byteBuffer.limit()) {
            if (byteBuffer.get(i) == bArr[i3]) {
                if (i3 == 0) {
                    i2 = i;
                }
                i3++;
                if (i3 == bArr.length) {
                    arrayList.add(Integer.valueOf(i2));
                    i2 = -1;
                    i3 = 0;
                }
            } else {
                i -= i3;
                i2 = -1;
                i3 = 0;
            }
            i++;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        return iArr;
    }

    private RandomAccessFile g() {
        try {
            return new RandomAccessFile(this.b.a().b(), "rw");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override // com.baidu.android.nebula.b.f
    public final Map a() {
        return this.i;
    }

    @Override // com.baidu.android.nebula.b.f
    public void a(Map map) {
        BufferedReader bufferedReader;
        RandomAccessFile g;
        MappedByteBuffer map2;
        RandomAccessFile randomAccessFile = null;
        StringTokenizer stringTokenizer = null;
        try {
            g = g();
            try {
                long parseInt = this.j.containsKey("content-length") ? Integer.parseInt((String) this.j.get("content-length")) : this.e < this.f ? this.f - this.e : 0L;
                byte[] bArr = new byte[512];
                while (this.f >= 0 && parseInt > 0) {
                    this.f = this.d.read(bArr, 0, 512);
                    parseInt -= this.f;
                    if (this.f > 0) {
                        g.write(bArr, 0, this.f);
                    }
                }
                map2 = g.getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, g.length());
                g.seek(0L);
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(g.getFD())));
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                randomAccessFile = g;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            if (k.POST.equals(this.h)) {
                String str = "";
                String str2 = (String) this.j.get("content-type");
                if (str2 != null) {
                    stringTokenizer = new StringTokenizer(str2, ",; ");
                    if (stringTokenizer.hasMoreTokens()) {
                        str = stringTokenizer.nextToken();
                    }
                }
                if (!"multipart/form-data".equalsIgnoreCase(str)) {
                    String str3 = "";
                    char[] cArr = new char[512];
                    for (int read = bufferedReader.read(cArr); read >= 0 && !str3.endsWith(IOUtils.LINE_SEPARATOR_WINDOWS); read = bufferedReader.read(cArr)) {
                        str3 = str3 + String.valueOf(cArr, 0, read);
                    }
                    a(str3.trim(), this.i);
                } else if (!stringTokenizer.hasMoreTokens()) {
                    throw new o(u.BAD_REQUEST, "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
                } else {
                    String substring = str2.substring("boundary=".length() + str2.indexOf("boundary="), str2.length());
                    if (substring.startsWith("\"") && substring.endsWith("\"")) {
                        substring = substring.substring(1, substring.length() - 1);
                    }
                    a(substring, map2, bufferedReader, this.i, map);
                }
            } else if (k.PUT.equals(this.h)) {
                map.put("content", a(map2, 0, map2.limit()));
            }
            h.b(g);
            h.b(bufferedReader);
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = g;
            h.b(randomAccessFile);
            h.b(bufferedReader);
            throw th;
        }
    }

    @Override // com.baidu.android.nebula.b.f
    public final Map b() {
        return this.j;
    }

    @Override // com.baidu.android.nebula.b.f
    public final String c() {
        return this.g;
    }

    @Override // com.baidu.android.nebula.b.f
    public String d() {
        return this.l;
    }

    @Override // com.baidu.android.nebula.b.f
    public final k e() {
        return this.h;
    }

    public void f() {
        try {
            try {
                try {
                    byte[] bArr = new byte[8192];
                    this.e = 0;
                    this.f = 0;
                    try {
                        int read = this.d.read(bArr, 0, 8192);
                        if (read == -1) {
                            h.b(this.d);
                            h.b(this.c);
                            throw new SocketException("NanoHttpd Shutdown");
                        }
                        while (read > 0) {
                            this.f = read + this.f;
                            this.e = a(bArr, this.f);
                            if (this.e > 0) {
                                break;
                            }
                            read = this.d.read(bArr, this.f, 8192 - this.f);
                        }
                        if (this.e < this.f) {
                            this.d = new SequenceInputStream(new ByteArrayInputStream(bArr, this.e, this.f - this.e), this.d);
                        }
                        this.i = new HashMap();
                        if (this.j == null) {
                            this.j = new HashMap();
                        }
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.f)));
                        HashMap hashMap = new HashMap();
                        a(bufferedReader, hashMap, this.i, this.j);
                        this.h = k.a((String) hashMap.get("method"));
                        if (this.h == null) {
                            throw new o(u.BAD_REQUEST, "BAD REQUEST: Syntax error.");
                        }
                        this.g = (String) hashMap.get("uri");
                        this.k = new r(this.a, this.j);
                        c a = this.a.a(this);
                        if (a == null) {
                            throw new o(u.INTERNAL_ERROR, "SERVER INTERNAL ERROR: Serve() returned a null response.");
                        }
                        this.k.a(a);
                        a.a(this.h);
                        a.a(this.c);
                        this.b.b();
                    } catch (Exception e) {
                        h.b(this.d);
                        h.b(this.c);
                        throw new SocketException("NanoHttpd Shutdown");
                    }
                } catch (Throwable th) {
                    this.b.b();
                    throw th;
                }
            } catch (o e2) {
                new c(e2.a(), "text/plain", e2.getMessage()).a(this.c);
                h.b(this.c);
                this.b.b();
            } catch (SocketException e3) {
                throw e3;
            }
        } catch (SocketTimeoutException e4) {
            throw e4;
        } catch (IOException e5) {
            new c(u.INTERNAL_ERROR, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e5.getMessage()).a(this.c);
            h.b(this.c);
            this.b.b();
        }
    }
}
