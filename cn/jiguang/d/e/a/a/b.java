package cn.jiguang.d.e.a.a;

import com.baidu.ar.audio.AudioParams;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b {
    public static byte[] a(int i, long j, byte[] bArr) {
        cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        bVar.writeByteArray(bArr);
        bVar.b(i, 12);
        if (j != 0) {
            bVar.c(j, 16);
        }
        return bVar.toByteArray();
    }

    public static byte[] a(long j, int i, long j2, String str, long[] jArr) {
        cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        bVar.l(0);
        bVar.k(0);
        bVar.k(30);
        bVar.h(j);
        bVar.g(i);
        bVar.h(j2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            if (jArr != null) {
                jSONArray.put(j2);
                for (long j3 : jArr) {
                    jSONArray.put(j3);
                }
            }
            jSONObject.put("uids", jSONArray);
            bVar.f(jSONObject.toString().getBytes());
            bVar.l(bVar.current(), 0);
            return bVar.toByteArray();
        } catch (Throwable th) {
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        byte[] a = cn.jiguang.d.h.a.a.a(bArr, i);
        if (a == null || a.length <= 0) {
            cn.jiguang.e.c.c("CorePackage", "totalRegBuf length :0");
            return null;
        }
        return a;
    }

    public static byte[] b(long j, int i, long j2, String str, long[] jArr) {
        cn.jiguang.api.a.b bVar = new cn.jiguang.api.a.b(AudioParams.DEFAULT_AUDIO_BUFFER_SIZE);
        bVar.l(0);
        bVar.k(0);
        bVar.k(32);
        bVar.h(j);
        bVar.g(i);
        bVar.h(j2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", str);
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 <= 0; i2++) {
                jSONArray.put(jArr[0]);
            }
            jSONObject.put("uids", jSONArray);
            bVar.f(jSONObject.toString().getBytes());
            bVar.l(bVar.current(), 0);
            return bVar.toByteArray();
        } catch (Throwable th) {
            return null;
        }
    }
}
