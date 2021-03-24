package a.a.a.d.a;

import java.io.File;
/* loaded from: classes.dex */
public class trw extends we {
    @Override // a.a.a.d.a.we
    public Class a() {
        try {
            return Class.forName("dalvik.system.DexPathList$NativeLibraryElement");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // a.a.a.d.a.we
    public Object a(Class cls, File file) {
        return shuoy.a((Class<?>) cls, (Class<?>[]) new Class[]{File.class}, new Object[]{file});
    }
}
