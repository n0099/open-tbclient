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
    private static volatile a ecN;
    private HashMap<String, ArrayList<InterfaceC0509a>> ecO = new HashMap<>();
    final ExecutorService ecP = Executors.newCachedThreadPool();
    private Object mLock = new Object();
    private String ecQ = f.aTX() + f.aTY();

    /* renamed from: com.baidu.swan.games.audio.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0509a {
        void aUb();

        void ki(String str);
    }

    private a() {
    }

    public static a aUc() {
        if (ecN == null) {
            synchronized (a.class) {
                if (ecN == null) {
                    ecN = new a();
                }
            }
        }
        return ecN;
    }

    public void a(final JsArrayBuffer jsArrayBuffer, final InterfaceC0509a interfaceC0509a) {
        this.ecP.execute(new Runnable() { // from class: com.baidu.swan.games.audio.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                String L = a.this.L(jsArrayBuffer.buffer());
                File file = new File(L);
                if (!file.exists()) {
                    if (!a.this.a(L, interfaceC0509a)) {
                        a.this.i(L, jsArrayBuffer.buffer());
                    }
                } else if (!file.isDirectory()) {
                    interfaceC0509a.ki(L);
                } else {
                    interfaceC0509a.aUb();
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
        File file = new File(this.ecQ);
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
                        um(str);
                    } else {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "buffer load rename error path = " + str);
                        }
                        file2.delete();
                        um(null);
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
                    um(null);
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
    public boolean a(String str, InterfaceC0509a interfaceC0509a) {
        boolean z;
        ArrayList<InterfaceC0509a> arrayList;
        synchronized (this.mLock) {
            ArrayList<InterfaceC0509a> arrayList2 = this.ecO.get(str);
            z = true;
            if (arrayList2 == null) {
                arrayList = new ArrayList<>();
                this.ecO.put(str, arrayList);
                z = false;
            } else {
                arrayList = arrayList2;
            }
            arrayList.add(interfaceC0509a);
        }
        return z;
    }

    private void um(String str) {
        synchronized (this.mLock) {
            ArrayList<InterfaceC0509a> arrayList = this.ecO.get(str);
            if (arrayList != null) {
                boolean isEmpty = TextUtils.isEmpty(str);
                Iterator<InterfaceC0509a> it = arrayList.iterator();
                while (it.hasNext()) {
                    InterfaceC0509a next = it.next();
                    if (!isEmpty) {
                        if (DEBUG) {
                            Log.e("AudioBufferManager", "save success path: " + str);
                        }
                        next.ki(str);
                    } else {
                        next.aUb();
                    }
                }
                this.ecO.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String L(byte[] bArr) {
        String K = f.K(bArr);
        StringBuilder append = new StringBuilder().append(this.ecQ).append(bArr.length);
        if (TextUtils.isEmpty(K)) {
            K = "";
        }
        return append.append(K).toString();
    }
}
