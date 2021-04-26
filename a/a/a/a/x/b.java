package a.a.a.a.x;

import android.content.SharedPreferences;
import android.util.Base64;
import com.fun.ad.sdk.FunAdSdk;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final SharedPreferences f1360a = FunAdSdk.getAppContext().getSharedPreferences("fun_ad_sdk", 0);

    public static int a(String str) {
        return f1360a.getInt("key_sid_c_pre_" + str, 0);
    }

    public static void a(long j, int i2, int i3, a.a.a.a.u.a aVar) {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeInt(aVar.f1341a);
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
        f1360a.edit().putLong("key_config_v", j).putInt("key_config_interval", i2).putInt("key_V", i3).putString("key_adcfg", encodeToString).apply();
    }
}
