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
import com.baidu.swan.facade.provider.processor.ProcessorInfo;
import d.a.l0.a.k;
import d.a.l0.e.n.a.a;
import d.a.l0.e.n.b.c;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class SwanContentProvider extends ContentProvider {
    public static final int PER_USER_RANGE = 100000;
    public static final String TAG = "SwanContentProvider";
    public static final boolean DEBUG = k.f46875a;
    public static final String AUTHORITY = AppRuntime.getAppContext().getPackageName() + ".provider";
    public static UriMatcher sUriMatcher = new UriMatcher(-1);
    public static HashSet<String> sAccreditedSet = new HashSet<>();

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                sUriMatcher.addURI(AUTHORITY, processorInfo.getPath(), processorInfo.getMatcherCode());
            }
        }
    }

    private boolean checkPermission() {
        boolean z = true;
        if (isSameApp(Process.myUid(), Binder.getCallingUid())) {
            return true;
        }
        String callingPackage = getCallingPackage();
        if (sAccreditedSet.contains(callingPackage)) {
            return true;
        }
        String a2 = c.a(callingPackage);
        Set<String> a3 = d.a.l0.d.g.c.e().a();
        z = (a3 == null || !a3.contains(a2)) ? false : false;
        if (z) {
            sAccreditedSet.add(callingPackage);
        }
        return z;
    }

    private boolean checkReadPermission() {
        return checkPermission();
    }

    private boolean checkWritePermission() {
        return checkPermission();
    }

    private a getProcessor(int i2) {
        Class<? extends a> processorClass = ProcessorInfo.getProcessorClass(i2);
        if (processorClass != null) {
            try {
                return processorClass.newInstance();
            } catch (IllegalAccessException | InstantiationException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    public static boolean isSameApp(int i2, int i3) {
        return i2 % 100000 == i3 % 100000;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        a processor;
        if (!checkWritePermission() || (processor = getProcessor(sUriMatcher.match(uri))) == null) {
            return 0;
        }
        return processor.a(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        a processor;
        if (!checkWritePermission() || (processor = getProcessor(sUriMatcher.match(uri))) == null) {
            return null;
        }
        return processor.b(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        a processor;
        if (!checkReadPermission() || (processor = getProcessor(sUriMatcher.match(uri))) == null) {
            return null;
        }
        return processor.c(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        a processor;
        if (!checkWritePermission() || (processor = getProcessor(sUriMatcher.match(uri))) == null) {
            return 0;
        }
        return processor.d(uri, contentValues, str, strArr);
    }
}
