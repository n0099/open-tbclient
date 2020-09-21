package com.baidu.adp.framework.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.l;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static final String SECONDARY_FOLDER_NAME = "code_cache" + File.separator + "secondary-dexes";
    public static a IR = null;

    private static SharedPreferences getMultiDexPreferences(Context context) {
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

    public static void loadStaticClass(Context context) throws PackageManager.NameNotFoundException, IOException {
        DexFile dexFile;
        for (String str : getSourcePaths(context)) {
            try {
                if (str.endsWith(".zip")) {
                    dexFile = DexFile.loadDex(str, str + ".tmp", 0);
                } else {
                    dexFile = new DexFile(str);
                }
                Enumeration<String> entries = dexFile.entries();
                while (entries.hasMoreElements()) {
                    String nextElement = entries.nextElement();
                    if (nextElement.endsWith("Static")) {
                        Class.forName(nextElement);
                        Log.e("MultiLoadHelper", nextElement);
                    }
                }
            } catch (IOException e) {
                throw new IOException("Error at loading dex file '" + str + "'");
            }
        }
    }

    public static void J(Context context) throws PackageManager.NameNotFoundException, IOException {
        IR = new a(getSourcePaths(context));
        IR.execute(new List[0]);
    }

    /* loaded from: classes.dex */
    public static class a extends BdAsyncTask<List<String>, Integer, String> {
        public List<String> IS;
        public boolean finished = false;
        public String IT = "";

        public a(List<String> list) {
            this.IS = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public String doInBackground(List<String>... listArr) throws IOException {
            DexFile dexFile;
            Looper.prepare();
            for (String str : this.IS) {
                try {
                    if (str.endsWith(".zip")) {
                        dexFile = DexFile.loadDex(str, str + ".tmp", 0);
                    } else {
                        dexFile = new DexFile(str);
                    }
                    Enumeration<String> entries = dexFile.entries();
                    while (entries.hasMoreElements()) {
                        String nextElement = entries.nextElement();
                        if (nextElement.endsWith("Static")) {
                            this.IT = nextElement;
                            Class.forName(nextElement);
                            this.IT = "";
                            Log.e("MultiLoadHelper", nextElement + l.isMainThread());
                        }
                    }
                } catch (IOException e) {
                    throw new IOException("Error at loading dex file '" + str + "'");
                }
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            this.finished = true;
        }

        public boolean bu(String str) {
            return (str == null || !str.equals(this.IT) || this.finished) ? false : true;
        }
    }
}
