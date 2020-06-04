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
/* loaded from: classes11.dex */
public class SwanContentProvider extends ContentProvider {
    private static final boolean DEBUG = b.DEBUG;
    private static final String cPg = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher cPh = new UriMatcher(-1);
    private static HashSet<String> cPi = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                cPh.addURI(cPg, processorInfo.getPath(), processorInfo.getMatcherCode());
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
        a hX;
        if (avm() && (hX = hX(cPh.match(uri))) != null) {
            return hX.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a hX;
        if (!avn() || (hX = hX(cPh.match(uri))) == null) {
            return null;
        }
        return hX.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a hX;
        if (!avn() || (hX = hX(cPh.match(uri))) == null) {
            return 0;
        }
        return hX.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a hX;
        if (!avn() || (hX = hX(cPh.match(uri))) == null) {
            return 0;
        }
        return hX.update(uri, contentValues, str, strArr);
    }

    private a hX(int i) {
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

    private boolean avm() {
        return checkPermission();
    }

    private boolean avn() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!ao(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!cPi.contains(callingPackage)) {
                String qm = c.qm(callingPackage);
                Set<String> ava = com.baidu.swan.config.c.c.auZ().ava();
                z = (ava == null || !ava.contains(qm)) ? false : false;
                if (z) {
                    cPi.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean ao(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
