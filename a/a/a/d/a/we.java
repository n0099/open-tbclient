package a.a.a.d.a;

import android.content.Context;
import dalvik.system.DexFile;
import java.io.File;
/* loaded from: classes.dex */
public class we implements bv {
    public Class a() {
        try {
            return Class.forName("dalvik.system.DexPathList$Element");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public Object a(Class cls, File file) {
        return shuoy.a((Class<?>) cls, (Class<?>[]) new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class}, new Object[]{file, Boolean.TRUE, null, null});
    }

    @Override // a.a.a.d.a.bv
    public void a(Context context, File file) {
        Object b2 = shuoy.b(context.getClassLoader(), "pathList");
        Class a2 = a();
        if (a2 != null) {
            Object[] objArr = (Object[]) shuoy.b(b2, "nativeLibraryPathElements");
            Object a3 = a(a2, file);
            if (objArr == null || a3 == null) {
                return;
            }
            shuoy.a(b2, "nativeLibraryPathElements", shuoy.a(a2, objArr, a3));
        }
    }

    @Override // a.a.a.d.a.bv
    public boolean b(Context context, File file) {
        Object b2 = shuoy.b(context.getClassLoader(), "pathList");
        if (a() != null) {
            for (Object obj : (Object[]) shuoy.b(b2, "nativeLibraryPathElements")) {
                if (obj.toString().contains(file.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
