package com.baidu.adp.lib.stats;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.DateFormat;
import cn.jingling.lib.file.ImageFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a extends e {
    private String p;
    private String q;
    private String r;
    private String s;

    public a(Context context, Handler handler, String str) {
        super(context, handler, str + File.separator + "dbg");
        this.q = null;
        this.r = null;
        this.s = "yyyyMMddkkmmss";
        this.a = false;
        this.b = true;
        this.c = false;
        this.d = 500;
        this.r = str + File.separator + "dbgbak";
        com.baidu.adp.lib.g.b.f(this.r);
        a((String) null);
    }

    @Override // com.baidu.adp.lib.stats.e
    public void a(boolean z) {
        if (this.j != null) {
            if (z || i()) {
                this.j.sendMessage(this.j.obtainMessage(2));
            }
        }
    }

    @Override // com.baidu.adp.lib.stats.e
    public void a(String str) {
        this.l = str;
        if (TextUtils.isEmpty(str)) {
            this.q = "dbg" + g;
        } else {
            this.q = str + g;
        }
        this.p = null;
    }

    @Override // com.baidu.adp.lib.stats.e
    public void a() {
        if (this.e <= 5) {
            if (this.i > 0) {
                FileOutputStream a = s.a(l(), true);
                if (a != null) {
                    try {
                        try {
                            a.write(this.h.toString().getBytes("utf-8"));
                            k();
                        } catch (Exception e) {
                            this.e++;
                            com.baidu.adp.lib.g.e.a(getClass(), "refreshFile", e);
                            try {
                                a.close();
                            } catch (IOException e2) {
                                com.baidu.adp.lib.g.e.a(getClass(), "refreshFile", e2);
                            }
                            d(this.k);
                        }
                    } finally {
                        try {
                            a.close();
                        } catch (IOException e3) {
                            com.baidu.adp.lib.g.e.a(getClass(), "refreshFile", e3);
                        }
                        d(this.k);
                    }
                } else {
                    this.e++;
                }
            }
            c(false);
        }
    }

    public boolean b(boolean z) {
        if ((!this.b || this.f) && !TextUtils.isEmpty(this.p)) {
            if (this.i > this.d) {
                return true;
            }
            try {
                File file = new File(this.p);
                if (file.exists()) {
                    if (z || file.length() > 102400) {
                        this.p = null;
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.a(getClass(), "shouldUpload", e);
                return false;
            }
        }
        return false;
    }

    @Override // com.baidu.adp.lib.stats.e
    public ArrayList<String> b() {
        ArrayList<String> arrayList = null;
        File[] listFiles = new File(this.k).listFiles();
        if (listFiles != null) {
            arrayList = new ArrayList<>();
            for (File file : listFiles) {
                if (file.isFile()) {
                    String name = file.getName();
                    if (name.contains(".log") && name.startsWith(this.q)) {
                        arrayList.add(file.getAbsolutePath());
                    }
                }
            }
        }
        return arrayList;
    }

    private String l() {
        if (this.p == null) {
            this.p = this.k + File.separator + this.q + "-" + DateFormat.format(this.s, System.currentTimeMillis()).toString() + ".log";
        }
        return this.p;
    }

    private void d(String str) {
        if (com.baidu.adp.lib.g.b.a(str, true) > ImageFile.MIN_SD_CARD_SPACE) {
            a(str, 1048576L);
        }
    }

    private void a(String str, long j) {
        try {
            File[] listFiles = new File(str).listFiles();
            if (listFiles != null && listFiles.length != 0) {
                Arrays.sort(listFiles, new c(this));
                long j2 = 0;
                for (File file : listFiles) {
                    if (file.isFile()) {
                        long a = com.baidu.adp.lib.g.b.a(file);
                        if (a(file)) {
                            j2 += a;
                            if (j2 >= j && j > 0) {
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(getClass(), "deleteFiles", e);
        }
    }

    private boolean a(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(getClass(), "deleteFiles", e);
            return false;
        }
    }

    @Override // com.baidu.adp.lib.stats.e
    public void c(boolean z) {
        if (this.j != null && b(z)) {
            this.j.sendMessage(this.j.obtainMessage(5));
        }
    }

    @Override // com.baidu.adp.lib.stats.e
    public String c() {
        return "omp";
    }

    @Override // com.baidu.adp.lib.stats.e
    public void b(String str) {
        try {
            File file = new File(str);
            file.renameTo(new File(this.r + File.separator + file.getName()));
            this.n = System.currentTimeMillis();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(getClass(), "uploadSucc", e);
        }
        d(this.r);
    }

    @Override // com.baidu.adp.lib.stats.e
    public boolean d() {
        return this.e > 5;
    }
}
