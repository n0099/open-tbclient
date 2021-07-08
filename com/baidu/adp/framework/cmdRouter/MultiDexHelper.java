package com.baidu.adp.framework.cmdRouter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.multidex.MultiDex;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
/* loaded from: classes.dex */
public class MultiDexHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTO_SUFFIX = "UrlCollectorImpl";
    public static final String EXTRACTED_NAME_EXT = ".classes";
    public static final String EXTRACTED_SUFFIX = ".zip";
    public static final String KEY_DEX_NUMBER = "dex.number";
    public static final String PREFS_FILE = "multidex.version";
    public static final String PUSH_SDK_PREFIX = "com.baidu.android.pushservice";
    public static final String SECONDARY_FOLDER_NAME;
    public static final String SUFFIX = "Static";
    public static StaticLoadAsyncTask task;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class StaticLoadAsyncTask extends BdAsyncTask<List<String>, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean finished;
        public String loading;
        public List<String> mPath;

        public StaticLoadAsyncTask(List<String> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.finished = false;
            this.loading = "";
            this.mPath = list;
        }

        public boolean loadingClass(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? (str == null || !str.equals(this.loading) || this.finished) ? false : true : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(List<String>... listArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listArr)) == null) {
                Looper.prepare();
                for (String str : this.mPath) {
                    try {
                        Enumeration<String> entries = (str.endsWith(".zip") ? DexFile.loadDex(str, str + ".tmp", 0) : new DexFile(str)).entries();
                        while (entries.hasMoreElements()) {
                            String nextElement = entries.nextElement();
                            if (nextElement.endsWith(MultiDexHelper.SUFFIX)) {
                                this.loading = nextElement;
                                Class.forName(nextElement);
                                this.loading = "";
                                Log.e("MultiLoadHelper", nextElement + l.C());
                            }
                        }
                    } catch (IOException unused) {
                        throw new IOException("Error at loading dex file '" + str + "'");
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((StaticLoadAsyncTask) str);
                this.finished = true;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-403940542, "Lcom/baidu/adp/framework/cmdRouter/MultiDexHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-403940542, "Lcom/baidu/adp/framework/cmdRouter/MultiDexHelper;");
                return;
            }
        }
        SECONDARY_FOLDER_NAME = MultiDex.CODE_CACHE_NAME + File.separator + "secondary-dexes";
        task = null;
    }

    public MultiDexHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static List<String> getAllClasses(Context context) throws PackageManager.NameNotFoundException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : getSourcePaths(context)) {
                try {
                    Enumeration<String> entries = (str.endsWith(".zip") ? DexFile.loadDex(str, str + ".tmp", 0) : new DexFile(str)).entries();
                    while (entries.hasMoreElements()) {
                        arrayList.add(entries.nextElement());
                    }
                } catch (IOException unused) {
                    throw new IOException("Error at loading dex file '" + str + "'");
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static SharedPreferences getMultiDexPreferences(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static List<String> getSourcePaths(Context context) throws PackageManager.NameNotFoundException, IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            File file = new File(applicationInfo.sourceDir);
            File file2 = new File(applicationInfo.dataDir, SECONDARY_FOLDER_NAME);
            ArrayList arrayList = new ArrayList();
            arrayList.add(applicationInfo.sourceDir);
            String str = file.getName() + ".classes";
            int i2 = getMultiDexPreferences(context).getInt("dex.number", 1);
            for (int i3 = 2; i3 <= i2; i3++) {
                File file3 = new File(file2, str + i3 + ".zip");
                if (file3.isFile()) {
                    arrayList.add(file3.getAbsolutePath());
                } else {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void loadClass(Context context) throws PackageManager.NameNotFoundException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            StaticLoadAsyncTask staticLoadAsyncTask = new StaticLoadAsyncTask(getSourcePaths(context));
            task = staticLoadAsyncTask;
            staticLoadAsyncTask.execute(new List[0]);
        }
    }

    public static void loadStaticClass(Context context) throws PackageManager.NameNotFoundException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            for (String str : getSourcePaths(context)) {
                try {
                    Enumeration<String> entries = (str.endsWith(".zip") ? DexFile.loadDex(str, str + ".tmp", 0) : new DexFile(str)).entries();
                    while (entries.hasMoreElements()) {
                        String nextElement = entries.nextElement();
                        if (nextElement.endsWith(SUFFIX)) {
                            Class.forName(nextElement);
                            Log.e("MultiLoadHelper", nextElement);
                        }
                        if (nextElement.startsWith(PUSH_SDK_PREFIX)) {
                            Class.forName(nextElement);
                            Log.e("MultiLoadHelper", "push sdk = " + nextElement);
                        }
                    }
                } catch (IOException unused) {
                    throw new IOException("Error at loading dex file '" + str + "'");
                }
            }
        }
    }
}
