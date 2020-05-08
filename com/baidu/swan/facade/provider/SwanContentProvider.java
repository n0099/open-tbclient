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
    private static final String cEW = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher cEX = new UriMatcher(-1);
    private static HashSet<String> cEY = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                cEX.addURI(cEW, processorInfo.getPath(), processorInfo.getMatcherCode());
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
        a hE;
        if (arD() && (hE = hE(cEX.match(uri))) != null) {
            return hE.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a hE;
        if (!arE() || (hE = hE(cEX.match(uri))) == null) {
            return null;
        }
        return hE.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a hE;
        if (!arE() || (hE = hE(cEX.match(uri))) == null) {
            return 0;
        }
        return hE.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a hE;
        if (!arE() || (hE = hE(cEX.match(uri))) == null) {
            return 0;
        }
        return hE.update(uri, contentValues, str, strArr);
    }

    private a hE(int i) {
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

    private boolean arD() {
        return checkPermission();
    }

    private boolean arE() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!ao(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!cEY.contains(callingPackage)) {
                String oO = c.oO(callingPackage);
                Set<String> arq = com.baidu.swan.config.c.c.aro().arq();
                z = (arq == null || !arq.contains(oO)) ? false : false;
                if (z) {
                    cEY.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean ao(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
