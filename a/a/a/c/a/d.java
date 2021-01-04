package a.a.a.c.a;

import java.io.File;
/* loaded from: classes10.dex */
public class d extends f {
    @Override // a.a.a.c.a.f
    public Class a() {
        try {
            return Class.forName("dalvik.system.DexPathList$NativeLibraryElement");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // a.a.a.c.a.f
    public Object a(Class cls, File file) {
        return c.a((Class<?>) cls, (Class<?>[]) new Class[]{File.class}, new Object[]{file});
    }
}
