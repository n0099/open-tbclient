package a.a.a.c.a;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a implements b {
    @Override // a.a.a.c.a.b
    public void a(Context context, File file) {
        Object b = c.b(context.getClassLoader(), "pathList");
        Object b2 = c.b(b, "nativeLibraryDirectories");
        if (b2 instanceof File[]) {
            c.a(b, "nativeLibraryDirectories", c.a(File.class, (File[]) b2, file));
        } else {
            ((ArrayList) b2).add(file);
        }
    }

    @Override // a.a.a.c.a.b
    public boolean d(Context context, File file) {
        Object b = c.b(c.b(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
        return b instanceof File[] ? c.b((File[]) b, file) : ((ArrayList) b).contains(file);
    }
}
