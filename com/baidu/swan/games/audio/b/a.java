package com.baidu.swan.games.audio.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.swan.games.audio.f;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a efs;
    private HashMap<String, ArrayList<InterfaceC0529a>> eft = new HashMap<>();
    final ExecutorService efu = Executors.newCachedThreadPool();
    private Object mLock = new Object();
    private String efv = f.aXE() + f.aXF();

    /* renamed from: com.baidu.swan.games.audio.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0529a {
        void aXI();

        void lb(String str);
    }

    private a() {
    }

    public static a aXJ() {
        if (efs == null) {
            synchronized (a.class) {
                if (efs == null) {
                    efs = new a();
                }
            }
        }
        return efs;
    }

    public void a(final JsArrayBuffer jsArrayBuffer, final InterfaceC0529a interfaceC0529a) {
        this.efu.execute(new Runnable() { // from class: com.baidu.swan.games.audio.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                String N = a.this.N(jsArrayBuffer.buffer());
                File file = new File(N);
                if (!file.exists()) {
                    if (!a.this.a(N, interfaceC0529a)) {
                        a.this.i(N, jsArrayBuffer.buffer());
                    }
                } else if (!file.isDirectory()) {
                    interfaceC0529a.lb(N);
                } else {
                    interfaceC0529a.aXI();
                }
            }
        });
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x00bb */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    public void i(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file = new File(this.efv);
        if (!file.exists()) {
            file.mkdirs();
        }
        ?? r1 = ".bdsave";
        File file2 = new File(str + ".bdsave");
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    File file3 = new File(str);
                    if (file3.exists() && !file3.isDirectory()) {
                        file3.delete();
                    }
                    if (file2.renameTo(file3)) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename success path = " + str);
                        }
                        ve(str);
                    } else {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        ve(null);
                    }
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    ve(null);
                    com.baidu.swan.c.d.closeSafely(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.d.closeSafely(r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            com.baidu.swan.c.d.closeSafely(r1);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, InterfaceC0529a interfaceC0529a) {
        boolean z;
        ArrayList<InterfaceC0529a> arrayList;
        synchronized (this.mLock) {
            ArrayList<InterfaceC0529a> arrayList2 = this.eft.get(str);
            z = true;
            if (arrayList2 == null) {
                arrayList = new ArrayList<>();
                this.eft.put(str, arrayList);
                z = false;
            } else {
                arrayList = arrayList2;
            }
            arrayList.add(interfaceC0529a);
        }
        return z;
    }

    private void ve(String str) {
        synchronized (this.mLock) {
            ArrayList<InterfaceC0529a> arrayList = this.eft.get(str);
            if (arrayList != null) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<InterfaceC0529a> it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC0529a next = it.next();
                    if (!isEmpty) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.lb(str);
                    } else {
                        next.aXI();
                    }
                }
                this.eft.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N(byte[] bArr) {
        String M = f.M(bArr);
        StringBuilder append = new StringBuilder().append(this.efv).append(bArr.length);
        if (TextUtils.isEmpty(M)) {
            M = "";
        }
        return append.append(M).toString();
    }
}
