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
    private static volatile a cJr;
    private HashMap<String, ArrayList<InterfaceC0360a>> cJs = new HashMap<>();
    final ExecutorService cJt = Executors.newCachedThreadPool();
    private Object mLock = new Object();
    private String cJu = f.atM() + f.atN();

    /* renamed from: com.baidu.swan.games.audio.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0360a {
        void atQ();

        void gt(String str);
    }

    private a() {
    }

    public static a atR() {
        if (cJr == null) {
            synchronized (a.class) {
                if (cJr == null) {
                    cJr = new a();
                }
            }
        }
        return cJr;
    }

    public void a(final JsArrayBuffer jsArrayBuffer, final InterfaceC0360a interfaceC0360a) {
        this.cJt.execute(new Runnable() { // from class: com.baidu.swan.games.audio.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                String E = a.this.E(jsArrayBuffer.buffer());
                File file = new File(E);
                if (!file.exists()) {
                    if (!a.this.a(E, interfaceC0360a)) {
                        a.this.g(E, jsArrayBuffer.buffer());
                    }
                } else if (!file.isDirectory()) {
                    interfaceC0360a.gt(E);
                } else {
                    interfaceC0360a.atQ();
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
        File file = new File(this.cJu);
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
                        oj(str);
                    } else {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        oj(null);
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
                    oj(null);
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
    public boolean a(String str, InterfaceC0360a interfaceC0360a) {
        ArrayList<InterfaceC0360a> arrayList;
        boolean z;
        synchronized (this.mLock) {
            ArrayList<InterfaceC0360a> arrayList2 = this.cJs.get(str);
            if (arrayList2 != null) {
                arrayList = arrayList2;
                z = true;
            } else {
                arrayList = new ArrayList<>();
                this.cJs.put(str, arrayList);
                z = false;
            }
            arrayList.add(interfaceC0360a);
        }
        return z;
    }

    private void oj(String str) {
        synchronized (this.mLock) {
            ArrayList<InterfaceC0360a> arrayList = this.cJs.get(str);
            if (arrayList != null) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<InterfaceC0360a> it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC0360a next = it.next();
                    if (!isEmpty) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.gt(str);
                    } else {
                        next.atQ();
                    }
                }
                this.cJs.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String E(byte[] bArr) {
        String D = f.D(bArr);
        StringBuilder append = new StringBuilder().append(this.cJu).append(bArr.length);
        if (TextUtils.isEmpty(D)) {
            D = "";
        }
        return append.append(D).toString();
    }
}
