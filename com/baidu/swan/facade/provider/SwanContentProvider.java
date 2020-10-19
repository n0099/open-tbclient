package com.baidu.swan.facade.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.b;
import com.baidu.swan.facade.provider.a.c;
import com.baidu.swan.facade.provider.processor.ProcessorInfo;
import com.baidu.swan.facade.provider.processor.a;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes16.dex */
public class SwanContentProvider extends ContentProvider {
    private static final boolean DEBUG = b.DEBUG;
    private static final String dvL = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher dvM = new UriMatcher(-1);
    private static HashSet<String> dvN = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                dvM.addURI(dvL, processorInfo.getPath(), processorInfo.getMatcherCode());
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
        a lm;
        if (aKE() && (lm = lm(dvM.match(uri))) != null) {
            return lm.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a lm;
        if (!aKF() || (lm = lm(dvM.match(uri))) == null) {
            return null;
        }
        return lm.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a lm;
        if (!aKF() || (lm = lm(dvM.match(uri))) == null) {
            return 0;
        }
        return lm.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a lm;
        if (!aKF() || (lm = lm(dvM.match(uri))) == null) {
            return 0;
        }
        return lm.update(uri, contentValues, str, strArr);
    }

    private a lm(int i) {
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

    private boolean aKE() {
        return checkPermission();
    }

    private boolean aKF() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!av(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!dvN.contains(callingPackage)) {
                String uB = c.uB(callingPackage);
                Set<String> aKw = com.baidu.swan.config.c.c.aKv().aKw();
                z = (aKw == null || !aKw.contains(uB)) ? false : false;
                if (z) {
                    dvN.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean av(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
