package com.baidu.sofire.ac;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Pair;
import java.util.Map;
/* loaded from: classes2.dex */
public interface FI {
    byte[] ad(byte[] bArr, byte[] bArr2);

    byte[] ae(byte[] bArr, byte[] bArr2);

    boolean chh(Context context, String str);

    void cm(String str, String str2, String str3, Callback callback, Class[] clsArr, Object... objArr);

    Pair cmsi(int i, String str, Class[] clsArr, Object... objArr);

    boolean cp(Context context);

    Context gct();

    SharedPreferences getCustomMutiProcessSharedPreferences(Context context, String str);

    Pair getDeviceInfoCallback();

    SharedPreferences getPlatformPrivateSharedPreferences(Context context);

    SharedPreferences getPlatformSharedSharedPreferences(Context context);

    String gm(String str, String str2);

    Map gpd();

    String gs(String str);

    String gta(Context context);

    String gzd(Context context);

    String p(String str);

    void r(String str, IntentFilter intentFilter, String str2, String str3);

    byte[] rd(byte[] bArr, byte[] bArr2);

    byte[] re(byte[] bArr, byte[] bArr2);

    void rf(Context context);

    void s(int i, boolean z);

    void sp(String str, boolean z);

    void sse(Context context, String str, Map map, boolean z);

    void sser(Context context, String str, Map map);

    void u(String str);

    void ur(String str, IntentFilter intentFilter, String str2, String str3);
}
