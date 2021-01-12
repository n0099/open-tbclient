package a.a.a.c.a;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a implements b {
    @Override // a.a.a.c.a.b
    public void a(Context context, File file) {
        Object b2 = c.b(context.getClassLoader(), "pathList");
        Object b3 = c.b(b2, "nativeLibraryDirectories");
        if (b3 instanceof File[]) {
            c.a(b2, "nativeLibraryDirectories", c.a(File.class, (File[]) b3, file));
        } else {
            ((ArrayList) b3).add(file);
        }
    }

    @Override // a.a.a.c.a.b
    public boolean d(Context context, File file) {
        Object b2 = c.b(c.b(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
        return b2 instanceof File[] ? c.b((File[]) b2, file) : ((ArrayList) b2).contains(file);
    }
}
