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
/* loaded from: classes20.dex */
public class SwanContentProvider extends ContentProvider {
    private static final boolean DEBUG = b.DEBUG;
    private static final String dhC = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher dhD = new UriMatcher(-1);
    private static HashSet<String> dhE = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                dhD.addURI(dhC, processorInfo.getPath(), processorInfo.getMatcherCode());
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
        a kE;
        if (aHl() && (kE = kE(dhD.match(uri))) != null) {
            return kE.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a kE;
        if (!aHm() || (kE = kE(dhD.match(uri))) == null) {
            return null;
        }
        return kE.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a kE;
        if (!aHm() || (kE = kE(dhD.match(uri))) == null) {
            return 0;
        }
        return kE.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a kE;
        if (!aHm() || (kE = kE(dhD.match(uri))) == null) {
            return 0;
        }
        return kE.update(uri, contentValues, str, strArr);
    }

    private a kE(int i) {
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

    private boolean aHl() {
        return checkPermission();
    }

    private boolean aHm() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!aw(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!dhE.contains(callingPackage)) {
                String tw = c.tw(callingPackage);
                Set<String> aHd = com.baidu.swan.config.c.c.aHc().aHd();
                z = (aHd == null || !aHd.contains(tw)) ? false : false;
                if (z) {
                    dhE.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean aw(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
