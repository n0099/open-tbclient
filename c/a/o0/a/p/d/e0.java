package c.a.o0.a.p.d;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public interface e0 {

    /* loaded from: classes.dex */
    public interface a {
        void onResult(String str);
    }

    void a(HashMap<String, String> hashMap, File file, a aVar, String str);

    void b(Context context, String str, String str2, String str3);

    void c(HashMap<String, String> hashMap, File file, a aVar);

    void d(Bitmap bitmap, HashMap<String, String> hashMap, File[] fileArr, a aVar);
}
