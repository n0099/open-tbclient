package com.baidu.adp.framework.a;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import dalvik.system.DexFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class a {
    private static List<String> getSourcePaths(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        if (Build.VERSION.SDK_INT >= 21 && applicationInfo.splitSourceDirs != null) {
            arrayList.addAll(Arrays.asList(applicationInfo.splitSourceDirs));
        }
        return arrayList;
    }

    public static Set<String> a(Application application, final String str) throws PackageManager.NameNotFoundException, InterruptedException {
        final HashSet hashSet = new HashSet();
        List<String> sourcePaths = getSourcePaths(application);
        final CountDownLatch countDownLatch = new CountDownLatch(sourcePaths.size());
        ThreadPoolExecutor Q = c.Q(sourcePaths.size());
        for (final String str2 : sourcePaths) {
            Q.execute(new Runnable() { // from class: com.baidu.adp.framework.a.a.1
                /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [78=4] */
                /* JADX WARN: Removed duplicated region for block: B:41:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    DexFile dexFile;
                    DexFile dexFile2 = null;
                    try {
                        try {
                            dexFile = new DexFile(str2);
                            try {
                                Enumeration<String> entries = dexFile.entries();
                                while (entries.hasMoreElements()) {
                                    String nextElement = entries.nextElement();
                                    if (!TextUtils.isEmpty(nextElement) && nextElement.startsWith(str)) {
                                        hashSet.add(nextElement);
                                    }
                                }
                                if (dexFile != null) {
                                    try {
                                        dexFile.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                countDownLatch.countDown();
                            } catch (IOException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (dexFile != null) {
                                    try {
                                        dexFile.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                countDownLatch.countDown();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (0 != 0) {
                                try {
                                    dexFile2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            countDownLatch.countDown();
                            throw th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        dexFile = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (0 != 0) {
                        }
                        countDownLatch.countDown();
                        throw th;
                    }
                }
            });
        }
        countDownLatch.await();
        return hashSet;
    }
}
