package com.baidu.adp.framework.cmdRouter;

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
public class ClassUtils {
    public static Set<String> getFileNameByPackageName(Application application, final String str) throws PackageManager.NameNotFoundException, InterruptedException {
        final HashSet hashSet = new HashSet();
        List<String> sourcePaths = getSourcePaths(application);
        final CountDownLatch countDownLatch = new CountDownLatch(sourcePaths.size());
        ThreadPoolExecutor newDefaultPoolExecutor = DefaultPoolExecutor.newDefaultPoolExecutor(sourcePaths.size());
        for (final String str2 : sourcePaths) {
            newDefaultPoolExecutor.execute(new Runnable() { // from class: com.baidu.adp.framework.cmdRouter.ClassUtils.1
                /* JADX WARN: Removed duplicated region for block: B:40:0x0053 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    Throwable th;
                    DexFile dexFile;
                    IOException e2;
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
                            } catch (IOException e3) {
                                e2 = e3;
                                e2.printStackTrace();
                                if (dexFile != null) {
                                    try {
                                        dexFile.close();
                                    } catch (IOException e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        countDownLatch.countDown();
                                    }
                                }
                                countDownLatch.countDown();
                            }
                            try {
                                dexFile.close();
                            } catch (IOException e5) {
                                e = e5;
                                e.printStackTrace();
                                countDownLatch.countDown();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (0 != 0) {
                                try {
                                    dexFile2.close();
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                }
                            }
                            countDownLatch.countDown();
                            throw th;
                        }
                    } catch (IOException e7) {
                        dexFile = null;
                        e2 = e7;
                    } catch (Throwable th3) {
                        th = th3;
                        if (0 != 0) {
                        }
                        countDownLatch.countDown();
                        throw th;
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        return hashSet;
    }

    public static List<String> getSourcePaths(Context context) throws PackageManager.NameNotFoundException {
        String[] strArr;
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        if (Build.VERSION.SDK_INT >= 21 && (strArr = applicationInfo.splitSourceDirs) != null) {
            arrayList.addAll(Arrays.asList(strArr));
        }
        return arrayList;
    }
}
