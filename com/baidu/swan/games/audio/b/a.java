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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dCQ;
    private HashMap<String, ArrayList<InterfaceC0500a>> dCR = new HashMap<>();
    final ExecutorService dCS = Executors.newCachedThreadPool();
    private Object mLock = new Object();
    private String dCT = f.aOt() + f.aOu();

    /* renamed from: com.baidu.swan.games.audio.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0500a {
        void aOx();

        void jZ(String str);
    }

    private a() {
    }

    public static a aOy() {
        if (dCQ == null) {
            synchronized (a.class) {
                if (dCQ == null) {
                    dCQ = new a();
                }
            }
        }
        return dCQ;
    }

    public void a(final JsArrayBuffer jsArrayBuffer, final InterfaceC0500a interfaceC0500a) {
        this.dCS.execute(new Runnable() { // from class: com.baidu.swan.games.audio.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                String O = a.this.O(jsArrayBuffer.buffer());
                File file = new File(O);
                if (!file.exists()) {
                    if (!a.this.a(O, interfaceC0500a)) {
                        a.this.g(O, jsArrayBuffer.buffer());
                    }
                } else if (!file.isDirectory()) {
                    interfaceC0500a.jZ(O);
                } else {
                    interfaceC0500a.aOx();
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
        File file = new File(this.dCT);
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
                        tW(str);
                    } else {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        tW(null);
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
                    tW(null);
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
    public boolean a(String str, InterfaceC0500a interfaceC0500a) {
        ArrayList<InterfaceC0500a> arrayList;
        boolean z;
        synchronized (this.mLock) {
            ArrayList<InterfaceC0500a> arrayList2 = this.dCR.get(str);
            if (arrayList2 != null) {
                arrayList = arrayList2;
                z = true;
            } else {
                arrayList = new ArrayList<>();
                this.dCR.put(str, arrayList);
                z = false;
            }
            arrayList.add(interfaceC0500a);
        }
        return z;
    }

    private void tW(String str) {
        synchronized (this.mLock) {
            ArrayList<InterfaceC0500a> arrayList = this.dCR.get(str);
            if (arrayList != null) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<InterfaceC0500a> it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC0500a next = it.next();
                    if (!isEmpty) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.jZ(str);
                    } else {
                        next.aOx();
                    }
                }
                this.dCR.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String O(byte[] bArr) {
        String N = f.N(bArr);
        StringBuilder append = new StringBuilder().append(this.dCT).append(bArr.length);
        if (TextUtils.isEmpty(N)) {
            N = "";
        }
        return append.append(N).toString();
    }
}
