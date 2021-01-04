package com.baidu.swan.facade.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
import com.baidu.swan.facade.provider.a.c;
import com.baidu.swan.facade.provider.processor.ProcessorInfo;
import com.baidu.swan.facade.provider.processor.a;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class SwanContentProvider extends ContentProvider {
    private static final boolean DEBUG = b.DEBUG;
    private static final String dYm = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher dYn = new UriMatcher(-1);
    private static HashSet<String> dYo = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                dYn.addURI(dYm, processorInfo.getPath(), processorInfo.getMatcherCode());
            }
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        a mj;
        if (aTQ() && (mj = mj(dYn.match(uri))) != null) {
            return mj.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a mj;
        if (!aTR() || (mj = mj(dYn.match(uri))) == null) {
            return null;
        }
        return mj.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a mj;
        if (!aTR() || (mj = mj(dYn.match(uri))) == null) {
            return 0;
        }
        return mj.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a mj;
        if (!aTR() || (mj = mj(dYn.match(uri))) == null) {
            return 0;
        }
        return mj.update(uri, contentValues, str, strArr);
    }

    private a mj(int i) {
        Class<? extends a> processorClass = ProcessorInfo.getProcessorClass(i);
        if (processorClass != null) {
            try {
                return processorClass.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private boolean aTQ() {
        return checkPermission();
    }

    private boolean aTR() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!av(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!dYo.contains(callingPackage)) {
                String vJ = c.vJ(callingPackage);
                Set<String> aTI = com.baidu.swan.config.c.c.aTH().aTI();
                z = (aTI == null || !aTI.contains(vJ)) ? false : false;
                if (z) {
                    dYo.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean av(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
