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
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a ckl;
    private HashMap<String, ArrayList<InterfaceC0330a>> ckm = new HashMap<>();
    final ExecutorService ckn = Executors.newCachedThreadPool();
    private Object mLock = new Object();
    private String cko = f.alv() + f.alw();

    /* renamed from: com.baidu.swan.games.audio.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0330a {
        void alz();

        void success(String str);
    }

    private a() {
    }

    public static a alA() {
        if (ckl == null) {
            synchronized (a.class) {
                if (ckl == null) {
                    ckl = new a();
                }
            }
        }
        return ckl;
    }

    public void a(final JsArrayBuffer jsArrayBuffer, final InterfaceC0330a interfaceC0330a) {
        this.ckn.execute(new Runnable() { // from class: com.baidu.swan.games.audio.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                String C = a.this.C(jsArrayBuffer.buffer());
                File file = new File(C);
                if (!file.exists()) {
                    if (!a.this.a(C, interfaceC0330a)) {
                        a.this.g(C, jsArrayBuffer.buffer());
                    }
                } else if (!file.isDirectory()) {
                    interfaceC0330a.success(C);
                } else {
                    interfaceC0330a.alz();
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
    public void g(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file = new File(this.cko);
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
                        mW(str);
                    } else {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        mW(null);
                    }
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    mW(null);
                    com.baidu.swan.d.c.closeSafely(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.d.c.closeSafely(r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            com.baidu.swan.d.c.closeSafely(r1);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, InterfaceC0330a interfaceC0330a) {
        ArrayList<InterfaceC0330a> arrayList;
        boolean z;
        synchronized (this.mLock) {
            ArrayList<InterfaceC0330a> arrayList2 = this.ckm.get(str);
            if (arrayList2 != null) {
                arrayList = arrayList2;
                z = true;
            } else {
                arrayList = new ArrayList<>();
                this.ckm.put(str, arrayList);
                z = false;
            }
            arrayList.add(interfaceC0330a);
        }
        return z;
    }

    private void mW(String str) {
        synchronized (this.mLock) {
            ArrayList<InterfaceC0330a> arrayList = this.ckm.get(str);
            if (arrayList != null) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<InterfaceC0330a> it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC0330a next = it.next();
                    if (!isEmpty) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.success(str);
                    } else {
                        next.alz();
                    }
                }
                this.ckm.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String C(byte[] bArr) {
        String B = f.B(bArr);
        StringBuilder append = new StringBuilder().append(this.cko).append(bArr.length);
        if (TextUtils.isEmpty(B)) {
            B = "";
        }
        return append.append(B).toString();
    }
}
