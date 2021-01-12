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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a eaG;
    private HashMap<String, ArrayList<InterfaceC0512a>> eaH = new HashMap<>();
    final ExecutorService eaI = Executors.newCachedThreadPool();
    private Object mLock = new Object();
    private String eaJ = f.aTL() + f.aTM();

    /* renamed from: com.baidu.swan.games.audio.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0512a {
        void aTP();

        void jQ(String str);
    }

    private a() {
    }

    public static a aTQ() {
        if (eaG == null) {
            synchronized (a.class) {
                if (eaG == null) {
                    eaG = new a();
                }
            }
        }
        return eaG;
    }

    public void a(final JsArrayBuffer jsArrayBuffer, final InterfaceC0512a interfaceC0512a) {
        this.eaI.execute(new Runnable() { // from class: com.baidu.swan.games.audio.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                String M = a.this.M(jsArrayBuffer.buffer());
                File file = new File(M);
                if (!file.exists()) {
                    if (!a.this.a(M, interfaceC0512a)) {
                        a.this.i(M, jsArrayBuffer.buffer());
                    }
                } else if (!file.isDirectory()) {
                    interfaceC0512a.jQ(M);
                } else {
                    interfaceC0512a.aTP();
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
        File file = new File(this.eaJ);
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
                        tT(str);
                    } else {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        tT(null);
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
                    tT(null);
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
    public boolean a(String str, InterfaceC0512a interfaceC0512a) {
        boolean z;
        ArrayList<InterfaceC0512a> arrayList;
        synchronized (this.mLock) {
            ArrayList<InterfaceC0512a> arrayList2 = this.eaH.get(str);
            z = true;
            if (arrayList2 == null) {
                arrayList = new ArrayList<>();
                this.eaH.put(str, arrayList);
                z = false;
            } else {
                arrayList = arrayList2;
            }
            arrayList.add(interfaceC0512a);
        }
        return z;
    }

    private void tT(String str) {
        synchronized (this.mLock) {
            ArrayList<InterfaceC0512a> arrayList = this.eaH.get(str);
            if (arrayList != null) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<InterfaceC0512a> it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC0512a next = it.next();
                    if (!isEmpty) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.jQ(str);
                    } else {
                        next.aTP();
                    }
                }
                this.eaH.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String M(byte[] bArr) {
        String L = f.L(bArr);
        StringBuilder append = new StringBuilder().append(this.eaJ).append(bArr.length);
        if (TextUtils.isEmpty(L)) {
            L = "";
        }
        return append.append(L).toString();
    }
}
