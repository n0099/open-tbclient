package com.baidu.adp.framework.cmdRouter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.multidex.MultiDex;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import d.b.c.e.p.l;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
/* loaded from: classes.dex */
public class MultiDexHelper {
    public static final String AUTO_SUFFIX = "UrlCollectorImpl";
    public static final String EXTRACTED_NAME_EXT = ".classes";
    public static final String EXTRACTED_SUFFIX = ".zip";
    public static final String KEY_DEX_NUMBER = "dex.number";
    public static final String PREFS_FILE = "multidex.version";
    public static final String PUSH_SDK_PREFIX = "com.baidu.android.pushservice";
    public static final String SUFFIX = "Static";
    public static final String SECONDARY_FOLDER_NAME = MultiDex.CODE_CACHE_NAME + File.separator + "secondary-dexes";
    public static StaticLoadAsyncTask task = null;

    /* loaded from: classes.dex */
    public static class StaticLoadAsyncTask extends BdAsyncTask<List<String>, Integer, String> {
        public boolean finished = false;
        public String loading = "";
        public List<String> mPath;

        public StaticLoadAsyncTask(List<String> list) {
            this.mPath = list;
        }

        public boolean loadingClass(String str) {
            return (str == null || !str.equals(this.loading) || this.finished) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(List<String>... listArr) throws IOException {
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
                            Log.e("MultiLoadHelper", nextElement + l.B());
                        }
                    }
                } catch (IOException unused) {
                    throw new IOException("Error at loading dex file '" + str + "'");
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((StaticLoadAsyncTask) str);
            this.finished = true;
        }
    }

    public static List<String> getAllClasses(Context context) throws PackageManager.NameNotFoundException, IOException {
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

    public static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public static List<String> getSourcePaths(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        File file2 = new File(applicationInfo.dataDir, SECONDARY_FOLDER_NAME);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + ".classes";
        int i = getMultiDexPreferences(context).getInt("dex.number", 1);
        for (int i2 = 2; i2 <= i; i2++) {
            File file3 = new File(file2, str + i2 + ".zip");
            if (file3.isFile()) {
                arrayList.add(file3.getAbsolutePath());
            } else {
                throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
            }
        }
        return arrayList;
    }

    public static void loadClass(Context context) throws PackageManager.NameNotFoundException, IOException {
        StaticLoadAsyncTask staticLoadAsyncTask = new StaticLoadAsyncTask(getSourcePaths(context));
        task = staticLoadAsyncTask;
        staticLoadAsyncTask.execute(new List[0]);
    }

    public static void loadStaticClass(Context context) throws PackageManager.NameNotFoundException, IOException {
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
