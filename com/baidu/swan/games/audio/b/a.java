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
    private static volatile a cYO;
    private HashMap<String, ArrayList<InterfaceC0427a>> cYP = new HashMap<>();
    final ExecutorService cYQ = Executors.newCachedThreadPool();
    private Object mLock = new Object();
    private String cYR = f.ayF() + f.ayG();

    /* renamed from: com.baidu.swan.games.audio.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0427a {
        void ayJ();

        void ho(String str);
    }

    private a() {
    }

    public static a ayK() {
        if (cYO == null) {
            synchronized (a.class) {
                if (cYO == null) {
                    cYO = new a();
                }
            }
        }
        return cYO;
    }

    public void a(final JsArrayBuffer jsArrayBuffer, final InterfaceC0427a interfaceC0427a) {
        this.cYQ.execute(new Runnable() { // from class: com.baidu.swan.games.audio.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                String N = a.this.N(jsArrayBuffer.buffer());
                File file = new File(N);
                if (!file.exists()) {
                    if (!a.this.a(N, interfaceC0427a)) {
                        a.this.g(N, jsArrayBuffer.buffer());
                    }
                } else if (!file.isDirectory()) {
                    interfaceC0427a.ho(N);
                } else {
                    interfaceC0427a.ayJ();
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
        File file = new File(this.cYR);
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
                        pZ(str);
                    } else {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        pZ(null);
                    }
                    com.baidu.swan.e.d.closeSafely(fileOutputStream);
                } catch (Exception e) {
                    e = e;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    if (file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    pZ(null);
                    com.baidu.swan.e.d.closeSafely(fileOutputStream);
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.e.d.closeSafely(r1);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            com.baidu.swan.e.d.closeSafely(r1);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, InterfaceC0427a interfaceC0427a) {
        ArrayList<InterfaceC0427a> arrayList;
        boolean z;
        synchronized (this.mLock) {
            ArrayList<InterfaceC0427a> arrayList2 = this.cYP.get(str);
            if (arrayList2 != null) {
                arrayList = arrayList2;
                z = true;
            } else {
                arrayList = new ArrayList<>();
                this.cYP.put(str, arrayList);
                z = false;
            }
            arrayList.add(interfaceC0427a);
        }
        return z;
    }

    private void pZ(String str) {
        synchronized (this.mLock) {
            ArrayList<InterfaceC0427a> arrayList = this.cYP.get(str);
            if (arrayList != null) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<InterfaceC0427a> it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC0427a next = it.next();
                    if (!isEmpty) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.ho(str);
                    } else {
                        next.ayJ();
                    }
                }
                this.cYP.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N(byte[] bArr) {
        String M = f.M(bArr);
        StringBuilder append = new StringBuilder().append(this.cYR).append(bArr.length);
        if (TextUtils.isEmpty(M)) {
            M = "";
        }
        return append.append(M).toString();
    }
}
