package cn.jiguang.d.b;

import android.content.Context;
import java.io.File;
/* loaded from: classes3.dex */
final class c implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File filesDir = this.a.getFilesDir();
        if (filesDir != null) {
            File file = new File(filesDir, ".servicesaveFile");
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }
}
