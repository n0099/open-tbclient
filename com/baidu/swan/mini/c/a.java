package com.baidu.swan.mini.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.ac;
import com.baidu.swan.mini.e.c;
import com.baidu.swan.pms.b.b.d;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final ConcurrentHashMap<Integer, CopyOnWriteArrayList<c.a>> dkM = new ConcurrentHashMap<>();

    public static void a(@NonNull final com.baidu.swan.pms.b.a aVar, @NonNull c.a aVar2) {
        File b;
        final int a = a(aVar);
        if (DEBUG) {
            Log.d("Mini-Pm", "==========开始获取mini小程序包 " + a + " ========== pkg: " + aVar.abS());
        }
        if (dkM.containsKey(Integer.valueOf(a))) {
            if (DEBUG) {
                Log.d("Mini-Pm", "==========重复获取 hash: " + a + " ========== pkg: " + aVar);
            }
            a(a, aVar2);
            return;
        }
        a(a, aVar2);
        if (!aVar.aaF()) {
            a(a, new com.baidu.swan.pms.b.b.b(1010, "参数错误 " + aVar), "");
            return;
        }
        final String appId = aVar.getAppId();
        final String bundleId = aVar.getBundleId();
        final int versionCode = aVar.getVersionCode();
        com.baidu.swan.pms.b.a cL = com.baidu.swan.pms.database.a.aFV().cL(appId, bundleId);
        if (cL != null && cL.getVersionCode() >= versionCode && (b = b.b(cL)) != null && b.exists()) {
            if (DEBUG) {
                Log.d("Mini-Pm", "==========获取mini小程序成功(同步本地有包) " + a + " ========== pkg: " + aVar.abS() + " local pkg: " + cL.abS());
            }
            a(a, new com.baidu.swan.pms.b.b.b(0, "成功：本地有包"), b.getPath());
            return;
        }
        d.aGe().a(new com.baidu.swan.pms.b.b.a(aVar.getDownloadUrl(), aVar.getSize(), aVar.getMd5(), new com.baidu.swan.pms.b.b() { // from class: com.baidu.swan.mini.c.a.1
            @Override // com.baidu.swan.pms.b.b
            public void a(@NonNull com.baidu.swan.pms.b.b.b bVar) {
                String str = bVar.filePath;
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.swan.e.d.deleteFile(str);
                }
                a.a(a, bVar, "");
            }

            @Override // com.baidu.swan.pms.b.b
            public void b(@NonNull com.baidu.swan.pms.b.b.b bVar) {
                String str = bVar.filePath;
                if (TextUtils.isEmpty(str)) {
                    a.a(a, new com.baidu.swan.pms.b.b.b(1013, "file path is empty"), "");
                    return;
                }
                File file = new File(str);
                if (!file.exists()) {
                    a.a(a, new com.baidu.swan.pms.b.b.b(1013, "文件不存在: " + str), "");
                } else if (!ac.e(file, aVar.getSign())) {
                    com.baidu.swan.e.d.deleteFile(str);
                    a.a(a, new com.baidu.swan.pms.b.b.b(1001, "签名校验失败"), "");
                } else {
                    com.baidu.swan.pms.b.b.b a2 = b.a(aVar, str);
                    if (!a2.isSuccess()) {
                        com.baidu.swan.e.d.deleteFile(str);
                        a.a(a, a2, "");
                        return;
                    }
                    com.baidu.swan.e.d.deleteFile(str);
                    if (!com.baidu.swan.pms.database.a.aFV().d(aVar)) {
                        a.a(a, new com.baidu.swan.pms.b.b.b(1012, "db insert fail"), "");
                        return;
                    }
                    if (a.DEBUG) {
                        Log.d("Mini-Pm", "==========获取mini小程序成功(异步) " + a + " ========== pkg: " + aVar.abS());
                    }
                    a.a(a, bVar, b.S(appId, bundleId, String.valueOf(versionCode)).getPath());
                }
            }
        }));
    }

    private static void a(int i, @NonNull c.a aVar) {
        CopyOnWriteArrayList<c.a> copyOnWriteArrayList = dkM.get(Integer.valueOf(i));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        if (DEBUG) {
            Log.d("Mini-Pm", "addCallback: " + i);
        }
        copyOnWriteArrayList.add(aVar);
        dkM.put(Integer.valueOf(i), copyOnWriteArrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, @NonNull com.baidu.swan.pms.b.b.b bVar, String str) {
        if (DEBUG) {
            if (!bVar.isSuccess()) {
                Log.d("Mini-Pm", "==========获取mini小程序失败 " + i + " ========== " + bVar.msg);
            }
            Log.d("Mini-Pm", bVar.toString());
        }
        CopyOnWriteArrayList<c.a> remove = dkM.remove(Integer.valueOf(i));
        if (remove == null || remove.isEmpty()) {
            if (DEBUG) {
                Log.d("Mini-Pm", "notifyCallbacks: callbacks is empty");
                return;
            }
            return;
        }
        int size = remove.size();
        for (int i2 = 0; i2 < size; i2++) {
            c.a aVar = remove.get(i2);
            if (DEBUG) {
                Log.d("Mini-Pm", "notifyCallbacks: " + i);
            }
            if (bVar.isSuccess()) {
                if (TextUtils.isEmpty(str)) {
                    aVar.onFailed(1013, "成功回调中传了空路径");
                } else {
                    aVar.onSuccess(str);
                }
            } else {
                aVar.onFailed(bVar.statusCode, bVar.msg);
            }
        }
    }

    private static int a(@NonNull com.baidu.swan.pms.b.a aVar) {
        return (aVar.getAppId() + aVar.getBundleId() + aVar.getVersionCode() + aVar.getDownloadUrl() + aVar.getMd5()).hashCode();
    }
}
