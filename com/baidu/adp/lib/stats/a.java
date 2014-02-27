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
import org.apache.commons.io.FileUtils;
/* loaded from: classes.dex */
public final class a extends d {
    private String p;
    private String q;
    private String r;
    private String s;

    public a(Context context, Handler handler, String str) {
        super(context, handler, String.valueOf(str) + File.separator + "dbg");
        this.q = null;
        this.r = null;
        this.s = "yyyyMMddkkmmss";
        this.d = 500;
        this.r = String.valueOf(str) + File.separator + "dbgbak";
        com.baidu.adp.lib.util.b.d(this.r);
        a((String) null);
    }

    @Override // com.baidu.adp.lib.stats.d
    public final void a(boolean z) {
        if (this.j != null) {
            if (z || j()) {
                this.j.removeMessages(2);
                this.j.sendMessage(this.j.obtainMessage(2));
            }
        }
    }

    @Override // com.baidu.adp.lib.stats.d
    public final void a(String str) {
        this.l = str;
        if (TextUtils.isEmpty(str)) {
            this.q = "dbg" + g;
        } else {
            this.q = String.valueOf(str) + g;
        }
        this.p = null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0050 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v21, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v22, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.stats.d
    public final void a() {
        Class<?> cls;
        if (this.e <= 5) {
            if (this.i > 0) {
                if (this.p == null) {
                    this.p = String.valueOf(this.k) + File.separator + this.q + "-" + DateFormat.format(this.s, System.currentTimeMillis()).toString() + ".log";
                }
                FileOutputStream a = o.a(this.p, true);
                try {
                    if (a != 0) {
                        try {
                            a.write(this.h.toString().getBytes("utf-8"));
                            l();
                        } catch (Exception e) {
                            this.e++;
                            com.baidu.adp.lib.util.e.a(getClass(), "refreshFile", e);
                            try {
                                a.close();
                                cls = a;
                            } catch (IOException e2) {
                                Class<?> cls2 = getClass();
                                com.baidu.adp.lib.util.e.a(cls2, "refreshFile", e2);
                                cls = cls2;
                            }
                            d(this.k);
                            a = cls;
                        }
                    } else {
                        this.e++;
                    }
                } finally {
                    try {
                        a.close();
                    } catch (IOException e3) {
                        com.baidu.adp.lib.util.e.a(getClass(), "refreshFile", e3);
                    }
                    d(this.k);
                }
            }
            b(false);
        }
    }

    private boolean m() {
        if (this.i > this.d) {
            return true;
        }
        if (TextUtils.isEmpty(this.p)) {
            return false;
        }
        try {
            File file = new File(this.p);
            if (file.exists() && file.length() > 102400) {
                this.p = null;
                return true;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a(getClass(), "shouldUpload", e);
        }
        return false;
    }

    @Override // com.baidu.adp.lib.stats.d
    public final ArrayList<String> b() {
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

    private void d(String str) {
        if (com.baidu.adp.lib.util.b.a(str, true) > ImageFile.MIN_SD_CARD_SPACE) {
            try {
                File[] listFiles = new File(str).listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    return;
                }
                Arrays.sort(listFiles, new b(this, (byte) 0));
                long j = 0;
                for (File file : listFiles) {
                    if (file.isFile()) {
                        long a = com.baidu.adp.lib.util.b.a(file);
                        if (a(file)) {
                            j += a;
                            if (j >= FileUtils.ONE_MB && FileUtils.ONE_MB > 0) {
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.a(getClass(), "deleteFiles", e);
            }
        }
    }

    private boolean a(File file) {
        try {
            return file.delete();
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a(getClass(), "deleteFiles", e);
            return false;
        }
    }

    @Override // com.baidu.adp.lib.stats.d
    public final void b(boolean z) {
        if (this.j != null) {
            if (!this.b || this.f) {
                if (m()) {
                    this.j.sendMessage(this.j.obtainMessage(5));
                } else if (z && System.currentTimeMillis() - g() >= g.a().d()) {
                    this.j.removeMessages(5);
                    this.j.sendMessage(this.j.obtainMessage(5));
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.stats.d
    public final String c() {
        return "omp";
    }

    @Override // com.baidu.adp.lib.stats.d
    public final void b(String str) {
        try {
            File file = new File(str);
            file.renameTo(new File(String.valueOf(this.r) + File.separator + file.getName()));
            this.n = System.currentTimeMillis();
            k.a().b(this.n, this.l);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a(getClass(), "uploadSucc", e);
        }
        d(this.r);
    }

    @Override // com.baidu.adp.lib.stats.d
    public final boolean d() {
        return this.e > 5;
    }

    public final void e() {
        try {
            l();
            File[] listFiles = new File(this.k).listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    file.renameTo(new File(String.valueOf(this.r) + File.separator + file.getName()));
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.a(getClass(), "clearLogs", e);
        }
    }
}
