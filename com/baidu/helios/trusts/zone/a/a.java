package com.baidu.helios.trusts.zone.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.helios.common.b.a.c;
import com.baidu.helios.common.b.a.d;
import com.baidu.helios.common.b.a.f;
import com.baidu.helios.common.c.a;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.helios.trusts.zone.verifier.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    private static final String[] ayY = {"f0fb772cce0da4ed791213b800defea286494ab98d00e1101cbf78a35e70ec4b"};
    private a.C0141a ayV;
    private ZipFile ayW;
    private PackageManager ayX;
    private String k;
    private Context l;

    /* renamed from: com.baidu.helios.trusts.zone.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static class C0151a {

        /* renamed from: a  reason: collision with root package name */
        public long f2518a;

        C0151a() {
        }

        public static C0151a a(a aVar) {
            try {
                String a2 = aVar.a("info");
                if (!TextUtils.isEmpty(a2)) {
                    JSONObject jSONObject = new JSONObject(a2);
                    C0151a c0151a = new C0151a();
                    c0151a.f2518a = jSONObject.getLong("version");
                    return c0151a;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private InputStream b(String str) {
        try {
            return this.ayW.getInputStream(new ZipEntry(str));
        } catch (Exception e) {
            throw new TrustSubject.ConfigNotFoundException(e);
        }
    }

    private File h() {
        return this.ayV.getFile("c.dat");
    }

    public long a() {
        try {
            Bundle bundle = this.ayX.getPackageInfo(this.k, 128).applicationInfo.metaData;
            if (bundle != null) {
                String string = bundle.getString("com.baidu.helios.tc.qver");
                if (!TextUtils.isEmpty(string) && string.startsWith("v")) {
                    return Long.valueOf(string.substring(1)).longValue();
                }
            }
        } catch (Throwable th) {
        }
        return -1L;
    }

    public String a(String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = b(str);
                return d.d(inputStream, "UTF-8");
            } catch (IOException e) {
                throw new TrustSubject.ConfigNotFoundException(e);
            }
        } finally {
            c.c(inputStream);
        }
    }

    public void a(String str, Context context, a.C0141a c0141a) {
        this.k = str;
        this.l = context;
        this.ayV = c0141a;
        this.ayX = context.getPackageManager();
    }

    public int b() {
        File file;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        File file2;
        FileOutputStream fileOutputStream2;
        try {
            AssetManager assets = this.l.createPackageContext(this.k, 0).getAssets();
            this.ayV.zg();
            File h = h();
            try {
                h.delete();
                file = File.createTempFile("cfg", ".cfgtmp", h.getParentFile());
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        inputStream = assets.open("com.baidu.helios/c.dat");
                        try {
                            try {
                                d.a(inputStream, fileOutputStream, 16384);
                                X509Certificate[][] x509CertificateArr = null;
                                try {
                                    X509Certificate[][] n = b.n(file);
                                    if (n.length == 0) {
                                        c.c(inputStream);
                                        c.c(fileOutputStream);
                                        if (file != null) {
                                            try {
                                                file.delete();
                                            } catch (Exception e) {
                                            }
                                        }
                                        return 3;
                                    }
                                    HashSet hashSet = new HashSet();
                                    for (X509Certificate[] x509CertificateArr2 : n) {
                                        if (x509CertificateArr2 != null) {
                                            for (X509Certificate x509Certificate : x509CertificateArr2) {
                                                if (x509Certificate != null) {
                                                    hashSet.add(f.A(x509Certificate.getSignature()));
                                                }
                                            }
                                        }
                                    }
                                    HashSet hashSet2 = new HashSet();
                                    Collections.addAll(hashSet2, ayY);
                                    if (!hashSet2.equals(hashSet)) {
                                        c.c(inputStream);
                                        c.c(fileOutputStream);
                                        if (file != null) {
                                            try {
                                                file.delete();
                                            } catch (Exception e2) {
                                            }
                                        }
                                        return 3;
                                    }
                                    file.renameTo(h);
                                    c.c(inputStream);
                                    c.c(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    return 0;
                                } catch (Exception e4) {
                                    c.c(inputStream);
                                    c.c(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception e5) {
                                        }
                                    }
                                    return 3;
                                }
                            } catch (Throwable th) {
                                th = th;
                                c.c(inputStream);
                                c.c(fileOutputStream);
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception e6) {
                                    }
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException e7) {
                            file2 = file;
                            fileOutputStream2 = fileOutputStream;
                            c.c(inputStream);
                            c.c(fileOutputStream2);
                            if (file2 != null) {
                                try {
                                    file2.delete();
                                    return 5;
                                } catch (Exception e8) {
                                    return 5;
                                }
                            }
                            return 5;
                        } catch (IOException e9) {
                            c.c(inputStream);
                            c.c(fileOutputStream);
                            if (file != null) {
                                try {
                                    file.delete();
                                    return 2;
                                } catch (Exception e10) {
                                    return 2;
                                }
                            }
                            return 2;
                        } catch (Exception e11) {
                            c.c(inputStream);
                            c.c(fileOutputStream);
                            if (file != null) {
                                try {
                                    file.delete();
                                    return 4;
                                } catch (Exception e12) {
                                    return 4;
                                }
                            }
                            return 4;
                        }
                    } catch (FileNotFoundException e13) {
                        file2 = file;
                        fileOutputStream2 = fileOutputStream;
                        inputStream = null;
                    } catch (IOException e14) {
                        inputStream = null;
                    } catch (Exception e15) {
                        inputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                } catch (FileNotFoundException e16) {
                    file2 = file;
                    fileOutputStream2 = null;
                    inputStream = null;
                } catch (IOException e17) {
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Exception e18) {
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    inputStream = null;
                }
            } catch (FileNotFoundException e19) {
                file2 = null;
                fileOutputStream2 = null;
                inputStream = null;
            } catch (IOException e20) {
                file = null;
                fileOutputStream = null;
                inputStream = null;
            } catch (Exception e21) {
                file = null;
                fileOutputStream = null;
                inputStream = null;
            } catch (Throwable th4) {
                th = th4;
                file = null;
                fileOutputStream = null;
                inputStream = null;
            }
        } catch (Exception e22) {
            return 1;
        }
    }

    public boolean c() {
        return h().delete();
    }

    public boolean d() {
        File[] listFiles = this.ayV.zh().listFiles(new FilenameFilter() { // from class: com.baidu.helios.trusts.zone.a.a.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".cfgtmp");
            }
        });
        if (listFiles != null) {
            boolean z = false;
            for (File file : listFiles) {
                file.delete();
                z = true;
            }
            return z;
        }
        return false;
    }

    public boolean e() {
        if (this.ayW != null) {
            return true;
        }
        File h = h();
        if (h.exists()) {
            try {
                this.ayW = new ZipFile(h);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean f() {
        if (this.ayW != null) {
            c.a(this.ayW);
            this.ayW = null;
            return true;
        }
        return false;
    }

    public long g() {
        C0151a a2 = C0151a.a(this);
        if (a2 != null) {
            return a2.f2518a;
        }
        return 0L;
    }
}
