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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dWv;
    private HashMap<String, ArrayList<InterfaceC0536a>> dWw = new HashMap<>();
    final ExecutorService dWx = Executors.newCachedThreadPool();
    private Object mLock = new Object();
    private String dWy = f.aVk() + f.aVl();

    /* renamed from: com.baidu.swan.games.audio.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0536a {
        void aVo();

        void li(String str);
    }

    private a() {
    }

    public static a aVp() {
        if (dWv == null) {
            synchronized (a.class) {
                if (dWv == null) {
                    dWv = new a();
                }
            }
        }
        return dWv;
    }

    public void a(final JsArrayBuffer jsArrayBuffer, final InterfaceC0536a interfaceC0536a) {
        this.dWx.execute(new Runnable() { // from class: com.baidu.swan.games.audio.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                String Q = a.this.Q(jsArrayBuffer.buffer());
                File file = new File(Q);
                if (!file.exists()) {
                    if (!a.this.a(Q, interfaceC0536a)) {
                        a.this.g(Q, jsArrayBuffer.buffer());
                    }
                } else if (!file.isDirectory()) {
                    interfaceC0536a.li(Q);
                } else {
                    interfaceC0536a.aVo();
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
        File file = new File(this.dWy);
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
                        vf(str);
                    } else {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        vf(null);
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
                    vf(null);
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
    public boolean a(String str, InterfaceC0536a interfaceC0536a) {
        ArrayList<InterfaceC0536a> arrayList;
        boolean z;
        synchronized (this.mLock) {
            ArrayList<InterfaceC0536a> arrayList2 = this.dWw.get(str);
            if (arrayList2 != null) {
                arrayList = arrayList2;
                z = true;
            } else {
                arrayList = new ArrayList<>();
                this.dWw.put(str, arrayList);
                z = false;
            }
            arrayList.add(interfaceC0536a);
        }
        return z;
    }

    private void vf(String str) {
        synchronized (this.mLock) {
            ArrayList<InterfaceC0536a> arrayList = this.dWw.get(str);
            if (arrayList != null) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<InterfaceC0536a> it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC0536a next = it.next();
                    if (!isEmpty) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.li(str);
                    } else {
                        next.aVo();
                    }
                }
                this.dWw.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Q(byte[] bArr) {
        String P = f.P(bArr);
        StringBuilder append = new StringBuilder().append(this.dWy).append(bArr.length);
        if (TextUtils.isEmpty(P)) {
            P = "";
        }
        return append.append(P).toString();
    }
}
