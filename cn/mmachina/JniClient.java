package cn.mmachina;

import android.content.Context;
import com.tencent.ams.a.b.a;
/* loaded from: classes15.dex */
public class JniClient {

    /* renamed from: a  reason: collision with root package name */
    public static int f1126a = 1;

    static {
        try {
            System.loadLibrary("MMANDKSignature");
        } catch (Throwable th) {
            a.a("JniClientQQ", "load mma so error.", th);
        }
    }

    public static native String MDString(String str, Context context, String str2);
}
