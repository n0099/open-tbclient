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
import com.baidu.tieba.st3;
import com.baidu.tieba.sv3;
import com.baidu.tieba.wp1;
import com.baidu.tieba.yv3;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class SwanContentProvider extends ContentProvider {
    public static final boolean a = wp1.a;
    public static final String b = AppRuntime.getAppContext().getPackageName() + ".provider";
    public static UriMatcher c = new UriMatcher(-1);
    public static HashSet<String> d = new HashSet<>();

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    static {
        ProcessorInfo[] values;
        for (ProcessorInfo processorInfo : ProcessorInfo.values()) {
            if (processorInfo != null) {
                c.addURI(b, processorInfo.getPath(), processorInfo.getMatcherCode());
            }
        }
    }

    public final boolean b() {
        return a();
    }

    public final boolean c() {
        return a();
    }

    public static boolean e(int i, int i2) {
        if (i % 100000 == i2 % 100000) {
            return true;
        }
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        sv3 d2;
        if (!c() || (d2 = d(c.match(uri))) == null) {
            return null;
        }
        return d2.insert(uri, contentValues);
    }

    public final boolean a() {
        boolean z = true;
        if (e(Process.myUid(), Binder.getCallingUid())) {
            return true;
        }
        String callingPackage = getCallingPackage();
        if (d.contains(callingPackage)) {
            return true;
        }
        String a2 = yv3.a(callingPackage);
        Set<String> a3 = st3.e().a();
        z = (a3 == null || !a3.contains(a2)) ? false : false;
        if (z) {
            d.add(callingPackage);
        }
        return z;
    }

    public final sv3 d(int i) {
        Class<? extends sv3> processorClass = ProcessorInfo.getProcessorClass(i);
        if (processorClass != null) {
            try {
                return processorClass.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                if (a) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        sv3 d2;
        if (!c() || (d2 = d(c.match(uri))) == null) {
            return 0;
        }
        return d2.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        sv3 d2;
        if (!b() || (d2 = d(c.match(uri))) == null) {
            return null;
        }
        return d2.query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        sv3 d2;
        if (!c() || (d2 = d(c.match(uri))) == null) {
            return 0;
        }
        return d2.update(uri, contentValues, str, strArr);
    }
}
