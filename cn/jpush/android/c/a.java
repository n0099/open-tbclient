package cn.jpush.android.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.d.f;
import com.baidu.ar.audio.AudioParams;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    private static volatile a b;
    private Map<Byte, b> a = new HashMap();

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private b a(long j) {
        for (Map.Entry<Byte, b> entry : this.a.entrySet()) {
            if (entry.getValue().c == j) {
                return entry.getValue();
            }
        }
        return null;
    }

    private synchronized void a(Context context, b bVar) {
        cn.jiguang.api.e.b(context, cn.jpush.android.a.a, 10000, bVar.d);
    }

    public final void a(Context context, long j) {
        b a = a(j);
        f.b("PluginPlatformRidUpdate", "onUpdateRidSuccess rid:" + j + " ,pluginPlatformRegIDBean:" + String.valueOf(a));
        if (a != null) {
            cn.jpush.android.b.a(context, a.a, a.b);
            cn.jpush.android.b.b(context, (int) a.a, true);
            this.a.remove(Byte.valueOf(a.a));
        }
    }

    public final void a(Context context, long j, int i) {
        b a = a(j);
        f.b("PluginPlatformRidUpdate", "onUpdateRidFailed rid:" + j + ",errorCode:" + i + " ,pluginPlatformRegIDBean:" + String.valueOf(a));
        if (a != null) {
            if (a.e >= 3) {
                this.a.remove(Byte.valueOf(a.a));
                return;
            }
            a.e++;
            a(context, a);
        }
    }

    public final synchronized void a(Context context, Bundle bundle) {
        byte byteValue = bundle.getByte("plugin.platform.type", (byte) 0).byteValue();
        if (byteValue != 0 && cn.jiguang.api.e.bz()) {
            String string = bundle.getString("plugin.platform.regid ");
            if (!this.a.containsKey(Byte.valueOf(byteValue)) || !TextUtils.equals(this.a.get(Byte.valueOf(byteValue)).b, string)) {
                long by = cn.jiguang.api.e.by();
                long uid = cn.jiguang.api.e.getUid();
                int sid = cn.jiguang.api.e.getSid();
                cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
                bVar.l(0);
                bVar.k(1);
                bVar.k(27);
                bVar.h(by);
                bVar.g(sid);
                bVar.h(uid);
                bVar.f(TextUtils.isEmpty(string) ? new byte[0] : string.getBytes());
                bVar.k(byteValue);
                bVar.l(bVar.current(), 0);
                b bVar2 = new b(this, byteValue, string, by, bVar.toByteArray());
                this.a.put(Byte.valueOf(byteValue), bVar2);
                a(context, bVar2);
            }
        }
    }

    public final void b(Context context, long j) {
        b a = a(j);
        f.b("PluginPlatformRidUpdate", "onUpdateRidTimeout rid:" + j + " ,pluginPlatformRegIDBean:" + String.valueOf(a));
        if (a != null) {
            if (a.e >= 3) {
                this.a.remove(Byte.valueOf(a.a));
                return;
            }
            a.e++;
            a(context, a);
        }
    }
}
