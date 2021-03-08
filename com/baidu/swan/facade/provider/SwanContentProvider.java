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
    private static final String dXh = AppRuntime.getAppContext().getPackageName() + ".provider";
    private static UriMatcher dXi = new UriMatcher(-1);
    private static HashSet<String> dXj = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                dXi.addURI(dXh, processorInfo.getPath(), processorInfo.getMatcherCode());
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
        a kH;
        if (aQt() && (kH = kH(dXi.match(uri))) != null) {
            return kH.query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a kH;
        if (!aQu() || (kH = kH(dXi.match(uri))) == null) {
            return null;
        }
        return kH.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a kH;
        if (!aQu() || (kH = kH(dXi.match(uri))) == null) {
            return 0;
        }
        return kH.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a kH;
        if (!aQu() || (kH = kH(dXi.match(uri))) == null) {
            return 0;
        }
        return kH.update(uri, contentValues, str, strArr);
    }

    private a kH(int i) {
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

    private boolean aQt() {
        return checkPermission();
    }

    private boolean aQu() {
        return checkPermission();
    }

    private boolean checkPermission() {
        boolean z = true;
        if (!as(Process.myUid(), Binder.getCallingUid())) {
            String callingPackage = getCallingPackage();
            if (!dXj.contains(callingPackage)) {
                String uY = c.uY(callingPackage);
                Set<String> aQl = com.baidu.swan.config.c.c.aQk().aQl();
                z = (aQl == null || !aQl.contains(uY)) ? false : false;
                if (z) {
                    dXj.add(callingPackage);
                }
            }
        }
        return z;
    }

    private static boolean as(int i, int i2) {
        return i % 100000 == i2 % 100000;
    }
}
