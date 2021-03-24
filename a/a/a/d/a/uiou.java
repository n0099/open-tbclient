package a.a.a.d.a;

import android.content.Context;
import dalvik.system.PathClassLoader;
import java.io.File;
/* loaded from: classes.dex */
public class uiou implements bv {
    @Override // a.a.a.d.a.bv
    public void a(Context context, File file) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        String[] strArr = (String[]) shuoy.b(pathClassLoader, "mLibPaths");
        if (strArr != null) {
            shuoy.a(pathClassLoader, "mLibPaths", shuoy.a(String.class, strArr, file.getAbsolutePath()));
        }
    }

    @Override // a.a.a.d.a.bv
    public boolean b(Context context, File file) {
        return shuoy.a((String[]) shuoy.b((PathClassLoader) context.getClassLoader(), "mLibPaths"), file.getAbsolutePath());
    }
}
