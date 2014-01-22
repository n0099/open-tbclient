package com.baidu.adp.lib.stats;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class f extends e {
    private String p;

    public f(Context context, Handler handler, String str) {
        super(context, handler, str);
        this.a = true;
        this.b = false;
        this.c = true;
        this.d = 10;
        a((String) null);
    }

    @Override // com.baidu.adp.lib.stats.e
    public void a(boolean z) {
        if (this.j != null) {
            if (z || i()) {
                this.j.sendMessage(this.j.obtainMessage(3));
            }
        }
    }

    @Override // com.baidu.adp.lib.stats.e
    public void c(boolean z) {
        if (this.j != null && b(z)) {
            this.j.sendMessage(this.j.obtainMessage(6));
        }
    }

    @Override // com.baidu.adp.lib.stats.e
    public void a(String str) {
        this.l = str;
        if (TextUtils.isEmpty(str)) {
            this.p = this.k + File.separator + g + "stat";
        } else {
            this.p = this.k + File.separator + str + g + "stat";
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.io.FileOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.lib.stats.e
    public void a() {
        if (this.e <= 5) {
            if (this.i > 0) {
                File file = new File(this.p);
                if (a(file)) {
                    FileOutputStream a = s.a(file, true);
                    try {
                        if (a != 0) {
                            try {
                                a.write(this.h.toString().getBytes("utf-8"));
                                k();
                            } catch (Exception e) {
                                this.e++;
                                com.baidu.adp.lib.g.e.a(getClass(), "refreshFile", e);
                                try {
                                    a.close();
                                    a = a;
                                } catch (IOException e2) {
                                    Class<?> cls = getClass();
                                    com.baidu.adp.lib.g.e.a(cls, "refreshFile", e2);
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
                            com.baidu.adp.lib.g.e.a(getClass(), "refreshFile", e3);
                        }
                    }
                } else {
                    return;
                }
            }
            c(false);
        }
    }

    public boolean b(boolean z) {
        if (!this.b || this.f) {
            if (this.i > this.d) {
                return true;
            }
            try {
                File file = new File(this.p);
                if (file.exists()) {
                    if (!z) {
                        if (file.length() <= 102400) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.a(getClass(), "shouldUpload", e);
                return false;
            }
        }
        return false;
    }

    private boolean a(File file) {
        if (file != null && file.length() >= 307200) {
            try {
                return file.delete();
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.a(getClass(), "checkFileTooBig", e);
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.adp.lib.stats.e
    public ArrayList<String> b() {
        try {
            if (new File(this.p).exists()) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(this.p);
                return arrayList;
            }
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(getClass(), "getLogFiles", e);
        }
        return null;
    }

    @Override // com.baidu.adp.lib.stats.e
    public String c() {
        return "stat";
    }

    @Override // com.baidu.adp.lib.stats.e
    public void b(String str) {
        try {
            new File(str).delete();
            this.n = System.currentTimeMillis();
        } catch (Exception e) {
            com.baidu.adp.lib.g.e.a(getClass(), "uploadSucc", e);
        }
    }

    @Override // com.baidu.adp.lib.stats.e
    public boolean d() {
        return this.e > 5;
    }

    @Override // com.baidu.adp.lib.stats.e
    public ArrayList<String> a(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            HashMap hashMap = new HashMap();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                t tVar = new t();
                tVar.a(it.next());
                String b = tVar.b("op_key");
                if (b != null && !TextUtils.isEmpty(b)) {
                    if (hashMap.containsKey(b)) {
                        t tVar2 = (t) hashMap.get(b);
                        String b2 = tVar2.b("co");
                        String b3 = tVar.b("co");
                        if (tVar2 != null) {
                            try {
                                tVar2.a("co", Integer.parseInt(b3) + Integer.parseInt(b2));
                            } catch (Exception e) {
                                com.baidu.adp.lib.g.e.a(getClass(), "filter", e);
                            }
                        }
                    } else {
                        hashMap.put(b, tVar);
                    }
                }
            }
            try {
                ArrayList<String> arrayList2 = new ArrayList<>();
                for (Map.Entry entry : hashMap.entrySet()) {
                    arrayList2.add(((t) entry.getValue()).toString());
                }
                return arrayList2;
            } catch (Exception e2) {
                com.baidu.adp.lib.g.e.a(getClass(), "filter", e2);
                return arrayList;
            }
        }
        return arrayList;
    }
}
