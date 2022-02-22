package com.baidu.adp.framework.cmdRouter;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes10.dex */
public class ClassUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ClassUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Set<String> getFileNameByPackageName(Application application, String str) throws PackageManager.NameNotFoundException, InterruptedException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, application, str)) == null) {
            HashSet hashSet = new HashSet();
            List<String> sourcePaths = getSourcePaths(application);
            CountDownLatch countDownLatch = new CountDownLatch(sourcePaths.size());
            ThreadPoolExecutor newDefaultPoolExecutor = DefaultPoolExecutor.newDefaultPoolExecutor(sourcePaths.size());
            for (String str2 : sourcePaths) {
                newDefaultPoolExecutor.execute(new Runnable(str2, str, hashSet, countDownLatch) { // from class: com.baidu.adp.framework.cmdRouter.ClassUtils.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Set val$classNames;
                    public final /* synthetic */ CountDownLatch val$countDownLatch;
                    public final /* synthetic */ String val$packageName;
                    public final /* synthetic */ String val$path;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {str2, str, hashSet, countDownLatch};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$path = str2;
                        this.val$packageName = str;
                        this.val$classNames = hashSet;
                        this.val$countDownLatch = countDownLatch;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:51:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        Throwable th;
                        DexFile dexFile;
                        IOException e2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            DexFile dexFile2 = null;
                            try {
                                try {
                                    dexFile = new DexFile(this.val$path);
                                    try {
                                        Enumeration<String> entries = dexFile.entries();
                                        while (entries.hasMoreElements()) {
                                            String nextElement = entries.nextElement();
                                            if (!TextUtils.isEmpty(nextElement) && nextElement.startsWith(this.val$packageName)) {
                                                this.val$classNames.add(nextElement);
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
                                                this.val$countDownLatch.countDown();
                                            }
                                        }
                                        this.val$countDownLatch.countDown();
                                    }
                                    try {
                                        dexFile.close();
                                    } catch (IOException e5) {
                                        e = e5;
                                        e.printStackTrace();
                                        this.val$countDownLatch.countDown();
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
                                    this.val$countDownLatch.countDown();
                                    throw th;
                                }
                            } catch (IOException e7) {
                                dexFile = null;
                                e2 = e7;
                            } catch (Throwable th3) {
                                th = th3;
                                if (0 != 0) {
                                }
                                this.val$countDownLatch.countDown();
                                throw th;
                            }
                            this.val$countDownLatch.countDown();
                        }
                    }
                });
            }
            countDownLatch.await();
            return hashSet;
        }
        return (Set) invokeLL.objValue;
    }

    public static List<String> getSourcePaths(Context context) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(applicationInfo.sourceDir);
            if (Build.VERSION.SDK_INT >= 21 && (strArr = applicationInfo.splitSourceDirs) != null) {
                arrayList.addAll(Arrays.asList(strArr));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
