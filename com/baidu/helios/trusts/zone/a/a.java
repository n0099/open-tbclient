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
/* loaded from: classes10.dex */
public class a {
    private static final String[] atk = {"f0fb772cce0da4ed791213b800defea286494ab98d00e1101cbf78a35e70ec4b"};
    private a.C0141a ath;
    private ZipFile ati;
    private PackageManager atj;
    private String k;
    private Context l;

    /* renamed from: com.baidu.helios.trusts.zone.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    static class C0151a {
        public long a;

        C0151a() {
        }

        public static C0151a a(a aVar) {
            try {
                String a = aVar.a("info");
                if (!TextUtils.isEmpty(a)) {
                    JSONObject jSONObject = new JSONObject(a);
                    C0151a c0151a = new C0151a();
                    c0151a.a = jSONObject.getLong("version");
                    return c0151a;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private InputStream ef(String str) {
        try {
            return this.ati.getInputStream(new ZipEntry(str));
        } catch (Exception e) {
            throw new TrustSubject.ConfigNotFoundException(e);
        }
    }

    private File vc() {
        return this.ath.getFile("c.dat");
    }

    public long a() {
        try {
            Bundle bundle = this.atj.getPackageInfo(this.k, 128).applicationInfo.metaData;
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
                inputStream = ef(str);
                return d.d(inputStream, "UTF-8");
            } catch (IOException e) {
                throw new TrustSubject.ConfigNotFoundException(e);
            }
        } finally {
            c.b(inputStream);
        }
    }

    public void a(String str, Context context, a.C0141a c0141a) {
        this.k = str;
        this.l = context;
        this.ath = c0141a;
        this.atj = context.getPackageManager();
    }

    public int b() {
        File file;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        Throwable th;
        File file2;
        FileOutputStream fileOutputStream2;
        InputStream inputStream2;
        try {
            AssetManager assets = this.l.createPackageContext(this.k, 0).getAssets();
            this.ath.uL();
            File vc = vc();
            try {
                vc.delete();
                file = File.createTempFile("cfg", ".cfgtmp", vc.getParentFile());
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        inputStream = assets.open("com.baidu.helios/c.dat");
                        try {
                            try {
                                d.a(inputStream, fileOutputStream, 16384);
                                X509Certificate[][] x509CertificateArr = null;
                                try {
                                    X509Certificate[][] l = b.l(file);
                                    if (l.length == 0) {
                                        c.b(inputStream);
                                        c.b(fileOutputStream);
                                        if (file != null) {
                                            try {
                                                file.delete();
                                            } catch (Exception e) {
                                            }
                                        }
                                        return 3;
                                    }
                                    HashSet hashSet = new HashSet();
                                    for (X509Certificate[] x509CertificateArr2 : l) {
                                        if (x509CertificateArr2 != null) {
                                            for (X509Certificate x509Certificate : x509CertificateArr2) {
                                                if (x509Certificate != null) {
                                                    hashSet.add(f.B(x509Certificate.getSignature()));
                                                }
                                            }
                                        }
                                    }
                                    HashSet hashSet2 = new HashSet();
                                    Collections.addAll(hashSet2, atk);
                                    if (!hashSet2.equals(hashSet)) {
                                        c.b(inputStream);
                                        c.b(fileOutputStream);
                                        if (file != null) {
                                            try {
                                                file.delete();
                                            } catch (Exception e2) {
                                            }
                                        }
                                        return 3;
                                    }
                                    file.renameTo(vc);
                                    c.b(inputStream);
                                    c.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    return 0;
                                } catch (Exception e4) {
                                    c.b(inputStream);
                                    c.b(fileOutputStream);
                                    if (file != null) {
                                        try {
                                            file.delete();
                                        } catch (Exception e5) {
                                        }
                                    }
                                    return 3;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                c.b(inputStream);
                                c.b(fileOutputStream);
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
                            inputStream2 = inputStream;
                            c.b(inputStream2);
                            c.b(fileOutputStream2);
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
                            c.b(inputStream);
                            c.b(fileOutputStream);
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
                            c.b(inputStream);
                            c.b(fileOutputStream);
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
                        inputStream2 = null;
                    } catch (IOException e14) {
                        inputStream = null;
                    } catch (Exception e15) {
                        inputStream = null;
                    } catch (Throwable th3) {
                        inputStream = null;
                        th = th3;
                    }
                } catch (FileNotFoundException e16) {
                    file2 = file;
                    fileOutputStream2 = null;
                    inputStream2 = null;
                } catch (IOException e17) {
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Exception e18) {
                    fileOutputStream = null;
                    inputStream = null;
                } catch (Throwable th4) {
                    fileOutputStream = null;
                    inputStream = null;
                    th = th4;
                }
            } catch (FileNotFoundException e19) {
                file2 = null;
                fileOutputStream2 = null;
                inputStream2 = null;
            } catch (IOException e20) {
                file = null;
                fileOutputStream = null;
                inputStream = null;
            } catch (Exception e21) {
                file = null;
                fileOutputStream = null;
                inputStream = null;
            } catch (Throwable th5) {
                file = null;
                fileOutputStream = null;
                inputStream = null;
                th = th5;
            }
        } catch (Exception e22) {
            return 1;
        }
    }

    public boolean c() {
        return vc().delete();
    }

    public boolean d() {
        boolean z = false;
        File[] listFiles = this.ath.uM().listFiles(new FilenameFilter() { // from class: com.baidu.helios.trusts.zone.a.a.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return str.endsWith(".cfgtmp");
            }
        });
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (i < length) {
                listFiles[i].delete();
                i++;
                z = true;
            }
        }
        return z;
    }

    public boolean e() {
        if (this.ati != null) {
            return true;
        }
        File vc = vc();
        if (vc.exists()) {
            try {
                this.ati = new ZipFile(vc);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean f() {
        if (this.ati != null) {
            c.a(this.ati);
            this.ati = null;
            return true;
        }
        return false;
    }

    public long g() {
        C0151a a = C0151a.a(this);
        if (a != null) {
            return a.a;
        }
        return 0L;
    }
}
