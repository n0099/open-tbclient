package a.a.a.c.a;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a implements b {
    @Override // a.a.a.c.a.b
    public void a(Context context, File file) {
        Object c = c.c(context.getClassLoader(), "pathList");
        Object c2 = c.c(c, "nativeLibraryDirectories");
        if (c2 instanceof File[]) {
            c.a(c, "nativeLibraryDirectories", c.a(File.class, (File[]) c2, file));
        } else {
            ((ArrayList) c2).add(file);
        }
    }

    @Override // a.a.a.c.a.b
    public boolean d(Context context, File file) {
        Object c = c.c(c.c(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
        return c instanceof File[] ? c.a((File[]) c, file) : ((ArrayList) c).contains(file);
    }
}
