package com.baidu.adp.lib.stats;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class c extends d {
    private String p;

    public c(Context context, Handler handler, String str) {
        super(context, handler, str);
        this.d = 50;
        a((String) null);
    }

    @Override // com.baidu.adp.lib.stats.d
    public final void a(boolean z) {
        if (this.j != null) {
            if (z || j()) {
                this.j.removeMessages(1);
                this.j.sendMessage(this.j.obtainMessage(1));
            }
        }
    }

    @Override // com.baidu.adp.lib.stats.d
    public final void b(boolean z) {
        if (this.j != null) {
            if (!this.b || this.f) {
                if (m()) {
                    this.j.removeMessages(4);
                    this.j.sendMessage(this.j.obtainMessage(4));
                } else if (z && System.currentTimeMillis() - g() >= g.a().e()) {
                    this.j.removeMessages(4);
                    this.j.sendMessage(this.j.obtainMessage(4));
                }
            }
        }
    }

    @Override // com.baidu.adp.lib.stats.d
    public final void a(String str) {
        this.l = str;
        if (TextUtils.isEmpty(str)) {
            this.p = String.valueOf(this.k) + File.separator + g + "err";
        } else {
            this.p = String.valueOf(this.k) + File.separator + str + g + "err";
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.stats.d
    public final void a() {
        if (this.e <= 5) {
            if (this.i > 0) {
                File file = new File(this.p);
                if (a(file)) {
                    FileOutputStream a = o.a(file, true);
                    try {
                        if (a != 0) {
                            try {
                                a.write(this.h.toString().getBytes("utf-8"));
                                l();
                            } catch (Exception e) {
                                this.e++;
                                com.baidu.adp.lib.util.f.a(getClass(), "refreshFile", e);
                                try {
                                    a.close();
                                    a = a;
                                } catch (IOException e2) {
                                    Class<?> cls = getClass();
                                    com.baidu.adp.lib.util.f.a(cls, "refreshFile", e2);
                                    a = cls;
                                }
                            }
                        } else {
                            this.e++;
                        }
                    } finally {
                        try {
                            a.close();
                        } catch (IOException e3) {
                            com.baidu.adp.lib.util.f.a(getClass(), "refreshFile", e3);
                        }
                    }
                } else {
                    return;
                }
            }
            b(false);
        }
    }

    private boolean a(File file) {
        if (file != null && file.length() >= 307200) {
            try {
                return file.delete();
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.a(getClass(), "checkFileTooBig", e);
                return false;
            }
        }
        return true;
    }

    private boolean m() {
        if (this.i > this.d) {
            return true;
        }
        try {
            File file = new File(this.p);
            if (file.exists()) {
                if (file.length() > 102400) {
                    return true;
                }
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.a(getClass(), "shouldUpload", e);
        }
        return false;
    }

    @Override // com.baidu.adp.lib.stats.d
    public final ArrayList<String> b() {
        try {
            if (new File(this.p).exists()) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(this.p);
                return arrayList;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.a(getClass(), "getLogFiles", e);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.d
    public final String c() {
        return "omp";
    }

    @Override // com.baidu.adp.lib.stats.d
    public final void b(String str) {
        try {
            new File(str).delete();
            this.n = System.currentTimeMillis();
            k.a().c(this.n, this.l);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.a(getClass(), "uploadSucc", e);
        }
    }

    @Override // com.baidu.adp.lib.stats.d
    public final boolean d() {
        return this.e > 5;
    }

    public final void e() {
        try {
            l();
            new File(this.p).delete();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.a(getClass(), "clearLogs", e);
        }
    }
}
