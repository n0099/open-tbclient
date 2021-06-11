package a.a.a.a.y;

import android.content.SharedPreferences;
import android.util.Base64;
import com.fun.ad.sdk.FunAdSdk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final SharedPreferences f1368a = FunAdSdk.getAppContext().getSharedPreferences("fun_ad_sdk", 0);

    public static int a() {
        return f1368a.getInt("key_rpt_fai_c", 0);
    }

    public static void a(String str, int i2) {
        f1368a.edit().putInt(str, i2).apply();
    }

    public static int b() {
        return f1368a.getInt("key_rpt_req_c", 0);
    }

    public static int c() {
        return f1368a.getInt("key_rpt_suc_c", 0);
    }

    public static void d() {
        synchronized ("key_rpt_req_c") {
            a("key_rpt_req_c", b() + 1);
        }
    }

    public static int a(String str) {
        return f1368a.getInt("key_sid_c_pre_" + str, 0);
    }

    public static void a(long j, int i2, int i3, a.a.a.a.v.a aVar) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeInt(aVar.f1349a);
            aVar.a(objectOutputStream);
            objectOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            bArr = null;
        }
        String encodeToString = bArr != null ? Base64.encodeToString(bArr, 0) : null;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(encodeToString == null ? -1 : encodeToString.length());
        d.c("sspsUTF len:%d", objArr);
        f1368a.edit().putLong("key_config_v", j).putInt("key_config_interval", i2).putInt("key_V", i3).putString("key_adcfg", encodeToString).apply();
    }

    public static void a(int i2, int i3, int i4, int i5) {
        synchronized ("key_rpt_req_c") {
            int b2 = b();
            int c2 = c();
            int i6 = f1368a.getInt("key_rpt_mis_c", 0);
            f1368a.edit().putInt("key_rpt_req_c", b2 - i2).putInt("key_rpt_fai_c", a() - i3).putInt("key_rpt_suc_c", c2 - i4).putInt("key_rpt_mis_c", i6 - i5).apply();
        }
    }
}
