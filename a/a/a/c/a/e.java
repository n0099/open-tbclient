package a.a.a.c.a;

import android.content.Context;
import dalvik.system.PathClassLoader;
import java.io.File;
/* loaded from: classes9.dex */
public class e implements b {
    @Override // a.a.a.c.a.b
    public void a(Context context, File file) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        String[] strArr = (String[]) c.c(pathClassLoader, "mLibPaths");
        if (strArr != null) {
            c.a(pathClassLoader, "mLibPaths", c.a(String.class, strArr, file.getAbsolutePath()));
        }
    }

    @Override // a.a.a.c.a.b
    public boolean d(Context context, File file) {
        return c.a((String[]) c.c((PathClassLoader) context.getClassLoader(), "mLibPaths"), file.getAbsolutePath());
    }
}
