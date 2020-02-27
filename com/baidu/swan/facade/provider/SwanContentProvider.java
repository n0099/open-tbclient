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
    private static final String cfF = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher cfG = new UriMatcher(-1);
    private static HashSet<String> cfH = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                cfG.addURI(cfF, processorInfo.getPath(), processorInfo.getMatcherCode());
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
        a hx;
        if (ajr() && (hx = hx(cfG.match(uri))) != null) {
            return hx.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a hx;
        if (!ajs() || (hx = hx(cfG.match(uri))) == null) {
            return null;
        }
        return hx.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a hx;
        if (!ajs() || (hx = hx(cfG.match(uri))) == null) {
            return 0;
        }
        return hx.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a hx;
        if (!ajs() || (hx = hx(cfG.match(uri))) == null) {
            return 0;
        }
        return hx.update(uri, contentValues, str, strArr);
    }

    private a hx(int i) {
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

    private boolean ajr() {
        return checkPermission();
    }

    private boolean ajs() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!al(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!cfH.contains(callingPackage)) {
                String nA = c.nA(callingPackage);
                Set<String> aje = com.baidu.swan.config.c.c.ajc().aje();
                z = (aje == null || !aje.contains(nA)) ? false : false;
                if (z) {
                    cfH.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean al(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
