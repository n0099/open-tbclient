package a.a.a.d.a;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ac implements bv {
    @Override // a.a.a.d.a.bv
    public void a(Context context, File file) {
        Object b2 = shuoy.b(context.getClassLoader(), "pathList");
        Object b3 = shuoy.b(b2, "nativeLibraryDirectories");
        if (b3 instanceof File[]) {
            shuoy.a(b2, "nativeLibraryDirectories", shuoy.a(File.class, (File[]) b3, file));
        } else {
            ((ArrayList) b3).add(file);
        }
    }

    @Override // a.a.a.d.a.bv
    public boolean b(Context context, File file) {
        Object b2 = shuoy.b(shuoy.b(context.getClassLoader(), "pathList"), "nativeLibraryDirectories");
        return b2 instanceof File[] ? shuoy.a((File[]) b2, file) : ((ArrayList) b2).contains(file);
    }
}
