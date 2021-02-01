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
/* loaded from: classes3.dex */
public class SwanContentProvider extends ContentProvider {
    private static final boolean DEBUG = b.DEBUG;
    private static final String dVG = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher dVH = new UriMatcher(-1);
    private static HashSet<String> dVI = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                dVH.addURI(dVG, processorInfo.getPath(), processorInfo.getMatcherCode());
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
        a kG;
        if (aQq() && (kG = kG(dVH.match(uri))) != null) {
            return kG.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a kG;
        if (!aQr() || (kG = kG(dVH.match(uri))) == null) {
            return null;
        }
        return kG.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a kG;
        if (!aQr() || (kG = kG(dVH.match(uri))) == null) {
            return 0;
        }
        return kG.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a kG;
        if (!aQr() || (kG = kG(dVH.match(uri))) == null) {
            return 0;
        }
        return kG.update(uri, contentValues, str, strArr);
    }

    private a kG(int i) {
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

    private boolean aQq() {
        return checkPermission();
    }

    private boolean aQr() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!as(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!dVI.contains(callingPackage)) {
                String uR = c.uR(callingPackage);
                Set<String> aQi = com.baidu.swan.config.c.c.aQh().aQi();
                z = (aQi == null || !aQi.contains(uR)) ? false : false;
                if (z) {
                    dVI.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean as(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
