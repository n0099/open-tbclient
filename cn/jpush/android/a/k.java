package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.service.ServiceInterface;
import com.baidu.ar.audio.AudioParams;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
/* loaded from: classes3.dex */
public final class k {
    public static long a(Context context, long j, cn.jiguang.api.h hVar) {
        String readLine;
        cn.jpush.a.b bVar = (cn.jpush.a.b) hVar;
        int a = bVar.a();
        long b = bVar.b();
        long longValue = bVar.getRid().longValue();
        long uid = cn.jiguang.api.e.getUid();
        int sid = cn.jiguang.api.e.getSid();
        cn.jiguang.api.a.b bVar2 = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        bVar2.C(0);
        bVar2.B(1);
        bVar2.B(4);
        bVar2.j(longValue);
        bVar2.i(sid);
        bVar2.j(uid);
        bVar2.C(0);
        bVar2.B((byte) a);
        bVar2.j(b);
        bVar2.l(bVar2.current(), 0);
        cn.jiguang.api.e.a(cn.jpush.android.a.e, cn.jpush.android.a.a, 4, bVar2.toByteArray());
        long b2 = bVar.b();
        int a2 = bVar.a();
        String c = bVar.c();
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c));
        try {
            String readLine2 = lineNumberReader.readLine();
            if (readLine2 != null && (readLine = lineNumberReader.readLine()) != null) {
                int length = readLine2.length() + readLine.length() + 2;
                String substring = c.length() > length + 1 ? c.substring(length) : "";
                switch (a2) {
                    case 0:
                    case 2:
                        try {
                            cn.jpush.android.d.k kVar = new cn.jpush.android.d.k("PushMessageProcessor", "Time to process received msg.");
                            if (!TextUtils.isEmpty(readLine2) && !TextUtils.isEmpty(readLine) && !TextUtils.isEmpty(substring)) {
                                a(context, readLine2, readLine, substring, b2, (byte) 0);
                            }
                            kVar.a();
                            break;
                        } catch (Exception e) {
                            break;
                        }
                        break;
                    case 20:
                        return n.a(context, substring, 0, -1L);
                    default:
                        cn.jiguang.api.e.A(a2);
                        break;
                }
                return hVar.getRid().longValue();
            }
            return -1L;
        } catch (IOException e2) {
            return -1L;
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 long)] */
    public static void a(Context context, String str, String str2, String str3, long j, byte b) {
        cn.jpush.android.data.a a = i.a(context, str3, str, str2, new StringBuilder().append(j).toString());
        if (a == null || cn.jpush.android.d.g.a(context, new cn.jpush.android.data.c(a))) {
            return;
        }
        a.e = b;
        char c = 0;
        if (str2 == null || !str2.equalsIgnoreCase("7fef6a7d76c782b1f0eda446b2c6c40a")) {
            c = a.f ? a.b == 4 ? (char) 3 : (char) 1 : (char) 2;
        } else {
            i.a(context, a);
        }
        new StringBuilder().append(j);
        if ((c & 2) != 0 && (!TextUtils.isEmpty(a.j) || !TextUtils.isEmpty(a.n))) {
            cn.jpush.android.d.a.a(context, a);
        }
        if ((c & 1) == 0 || ServiceInterface.d(context) || !cn.jpush.android.d.a.c(context)) {
            return;
        }
        a.i = true;
        i.a(context, a);
    }
}
