package com.baidu.swan.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private static String bxT;

    private static String ci(Context context) {
        return V(context, "channels/tnconfig.ini");
    }

    public static String YF() {
        if (TextUtils.isEmpty(bxT)) {
            bxT = cj(AppRuntime.getAppContext());
        }
        return bxT;
    }

    private static String cj(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(HTTP.IDENTITY_CODING, 0);
        String string = sharedPreferences.getString("lasttn", "");
        String ci = ci(context);
        if ((TextUtils.equals(string, ci) ? false : true) || TextUtils.isEmpty(string)) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("lasttn", ci);
            edit.commit();
            return ci;
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String V(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e) {
            inputStream = null;
        } catch (Throwable th2) {
            inputStream = null;
            th = th2;
        }
        if (inputStream != null) {
            try {
                str2 = e.k(inputStream);
                a.c(inputStream);
            } catch (IOException e2) {
                a.c(inputStream);
                if (!TextUtils.isEmpty(str2)) {
                }
            } catch (Throwable th3) {
                th = th3;
                a.c(inputStream);
                throw th;
            }
            return !TextUtils.isEmpty(str2) ? "1023091a" : str2;
        }
        a.c(inputStream);
        return null;
    }
}
