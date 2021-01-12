package a.a.a.c.a;

import android.content.Context;
import dalvik.system.DexFile;
import java.io.File;
/* loaded from: classes9.dex */
public class f implements b {
    public Class a() {
        try {
            return Class.forName("dalvik.system.DexPathList$Element");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object a(Class cls, File file) {
        return c.a((Class<?>) cls, (Class<?>[]) new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class}, new Object[]{file, true, null, null});
    }

    @Override // a.a.a.c.a.b
    public void a(Context context, File file) {
        Object b2 = c.b(context.getClassLoader(), "pathList");
        Class a2 = a();
        if (a2 != null) {
            Object[] objArr = (Object[]) c.b(b2, "nativeLibraryPathElements");
            Object a3 = a(a2, file);
            if (objArr == null || a3 == null) {
                return;
            }
            c.a(b2, "nativeLibraryPathElements", c.a(a2, objArr, a3));
        }
    }

    @Override // a.a.a.c.a.b
    public boolean d(Context context, File file) {
        Object b2 = c.b(context.getClassLoader(), "pathList");
        if (a() != null) {
            for (Object obj : (Object[]) c.b(b2, "nativeLibraryPathElements")) {
                if (obj.toString().contains(file.toString())) {
                    return true;
                }
            }
        }
        return false;
    }
}
