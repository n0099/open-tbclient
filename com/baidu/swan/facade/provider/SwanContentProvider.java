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
    private static final String dEi = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher dEj = new UriMatcher(-1);
    private static HashSet<String> dEk = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                dEj.addURI(dEi, processorInfo.getPath(), processorInfo.getMatcherCode());
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
        a lx;
        if (aMy() && (lx = lx(dEj.match(uri))) != null) {
            return lx.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a lx;
        if (!aMz() || (lx = lx(dEj.match(uri))) == null) {
            return null;
        }
        return lx.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a lx;
        if (!aMz() || (lx = lx(dEj.match(uri))) == null) {
            return 0;
        }
        return lx.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a lx;
        if (!aMz() || (lx = lx(dEj.match(uri))) == null) {
            return 0;
        }
        return lx.update(uri, contentValues, str, strArr);
    }

    private a lx(int i) {
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

    private boolean aMy() {
        return checkPermission();
    }

    private boolean aMz() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!aw(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!dEk.contains(callingPackage)) {
                String uU = c.uU(callingPackage);
                Set<String> aMq = com.baidu.swan.config.c.c.aMp().aMq();
                z = (aMq == null || !aMq.contains(uU)) ? false : false;
                if (z) {
                    dEk.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean aw(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
