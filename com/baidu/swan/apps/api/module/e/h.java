package com.baidu.swan.apps.api.module.e;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.res.widget.b.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ly(String str) {
        if (DEBUG) {
            Log.d("Api-ToastApi", "handle: " + str);
        }
        if (ank()) {
            com.baidu.swan.apps.console.c.e("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-ToastApi does not supported when app is invisible.");
        }
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-ToastApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ToastApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        String optString = jSONObject.optString("type", "1");
        final int aQ = aQ(jSONObject);
        final String optString2 = jSONObject.optString("message");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("Api-ToastApi", "message is null");
            return new com.baidu.swan.apps.api.c.b(202, "message is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("mask");
        String optString3 = jSONObject.optString("image", "-1");
        final Drawable a2 = a(getContext(), optString3, aMl);
        if (DEBUG) {
            Log.e("Api-ToastApi", "imagepath = " + optString3);
        }
        if (!TextUtils.equals(optString3, "-1") && a2 == null && TextUtils.equals(optString, "2")) {
            optString = "1";
        }
        final String optString4 = jSONObject.optString("cb");
        final String optString5 = jSONObject.optString("buttonText");
        char c = 65535;
        switch (optString.hashCode()) {
            case 49:
                if (optString.equals("1")) {
                    c = 0;
                    break;
                }
                break;
            case 50:
                if (optString.equals("2")) {
                    c = 1;
                    break;
                }
                break;
            case 51:
                if (optString.equals("3")) {
                    c = 2;
                    break;
                }
                break;
            case 52:
                if (optString.equals("4")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(h.this.getContext(), optString2, aQ, optBoolean);
                    }
                });
                break;
            case 1:
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.a(h.this.getContext(), optString2, aQ, a2, optBoolean);
                    }
                });
                break;
            case 2:
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.c(h.this.getContext(), optString2, aQ, optBoolean);
                    }
                });
                break;
            case 3:
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(h.this.getContext(), optString2, aQ, optString5, optString4);
                    }
                });
                break;
            default:
                anw();
                return new com.baidu.swan.apps.api.c.b(302, "the toast type is unknown");
        }
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b anv() {
        if (DEBUG) {
            Log.d("Api-ToastApi", "handle");
        }
        if (com.baidu.swan.apps.runtime.e.aMl() == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.res.widget.b.d.cancelToast();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, @NonNull String str, int i, @NonNull String str2, final String str3) {
        com.baidu.swan.apps.res.widget.b.d.m32do(context).h(str).i(str2).kM(i).b(new d.a() { // from class: com.baidu.swan.apps.api.module.e.h.6
            @Override // com.baidu.swan.apps.res.widget.b.d.a
            public void ajM() {
                if (!TextUtils.isEmpty(str3)) {
                    h.this.a(str3, new com.baidu.swan.apps.api.c.b(0));
                }
            }
        }).aLX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, str).kM(i).he(z).kI(2).aLS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, @NonNull String str, int i, Drawable drawable, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, N(str, 14)).i(drawable).kM(i).he(z).aLV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, N(str, 14)).kM(i).he(z).aLW();
    }

    private void anw() {
        if (DEBUG) {
            Log.w("Api-ToastApi", "the toast type is unknown");
        }
    }

    public static int aQ(JSONObject jSONObject) {
        int lz = lz(jSONObject.optString("time")) / 1000;
        if (lz <= 0) {
            return 2;
        }
        return lz;
    }

    public static String N(String str, int i) {
        return b(str, i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
        r8.append(com.baidu.live.tbadk.core.util.StringHelper.STRING_MORE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String b(String str, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.trim().toCharArray();
        int i2 = z ? i : i - 2;
        int i3 = z ? i : i - 1;
        int length = charArray.length;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 < length) {
                char c = charArray[i4];
                int i6 = c > 161 ? 2 : 1;
                if (i6 + i5 == i && i4 == length - 1) {
                    stringBuffer.append(c);
                    break;
                } else if ((i6 != 2 || i5 < i2) && (i6 != 1 || i5 < i3)) {
                    i5 += i6;
                    stringBuffer.append(c);
                    i4++;
                }
            } else {
                break;
            }
        }
        return stringBuffer.toString();
    }

    private static int lz(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static Drawable a(Context context, String str, com.baidu.swan.apps.runtime.e eVar) {
        BitmapDrawable bitmapDrawable;
        if (TextUtils.isEmpty(str) || eVar == null || context == null) {
            return null;
        }
        if (DEBUG) {
            Log.e("Api-ToastApi", "imagePath = " + str);
        }
        ExifInterface lA = lA(str);
        if (lA == null) {
            if (DEBUG) {
                Log.e("Api-ToastApi", "exifInterface is null");
                return null;
            }
            return null;
        }
        int intValue = Integer.valueOf(lA.getAttribute("ImageWidth")).intValue();
        int intValue2 = Integer.valueOf(lA.getAttribute("ImageLength")).intValue();
        if (DEBUG) {
            Log.e("Api-ToastApi", "width = " + intValue + "， height = " + intValue2);
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            if (DEBUG) {
                Log.e("Api-ToastApi", "image file not exists");
                return null;
            }
            return null;
        }
        try {
            bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            if (DEBUG) {
                Log.e("Api-ToastApi", "FileNotFoundException");
                e.printStackTrace();
            }
            bitmapDrawable = null;
        }
        return bitmapDrawable;
    }

    private static ExifInterface lA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ExifInterface(str);
        } catch (Exception e) {
            return null;
        }
    }
}
