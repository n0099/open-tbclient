package com.baidu.swan.apps.api.module.e;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.res.widget.b.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hC(String str) {
        if (DEBUG) {
            Log.d("Api-ToastApi", "handle: " + str);
        }
        if (TU()) {
            com.baidu.swan.apps.console.c.e("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-ToastApi does not supported when app is invisible.");
        }
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-ToastApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ToastApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
        String optString = jSONObject.optString("type", "1");
        final int aj = aj(jSONObject);
        final String optString2 = jSONObject.optString("message");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("Api-ToastApi", "message is null");
            return new com.baidu.swan.apps.api.c.b(202, "message is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("mask");
        String optString3 = jSONObject.optString("image", "-1");
        final Drawable a = a(getContext(), optString3, aoG);
        if (DEBUG) {
            Log.e("Api-ToastApi", "imagepath = " + optString3);
        }
        if (!TextUtils.equals(optString3, "-1") && a == null && TextUtils.equals(optString, "2")) {
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
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.1
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(h.this.getContext(), optString2, aj, optBoolean);
                    }
                });
                break;
            case 1:
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.a(h.this.getContext(), optString2, aj, a, optBoolean);
                    }
                });
                break;
            case 2:
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.c(h.this.getContext(), optString2, aj, optBoolean);
                    }
                });
                break;
            case 3:
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(h.this.getContext(), optString2, aj, optString5, optString4);
                    }
                });
                break;
            default:
                Ug();
                return new com.baidu.swan.apps.api.c.b(302, "the toast type is unknown");
        }
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b Uf() {
        if (DEBUG) {
            Log.d("Api-ToastApi", "handle");
        }
        if (com.baidu.swan.apps.runtime.e.aoG() == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.res.widget.b.d.cancelToast();
            }
        });
        return new com.baidu.swan.apps.api.c.b(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, @NonNull String str, int i, @NonNull String str2, final String str3) {
        com.baidu.swan.apps.res.widget.b.d.ce(context).g(str).h(str2).gI(i).b(new d.a() { // from class: com.baidu.swan.apps.api.module.e.h.6
            @Override // com.baidu.swan.apps.res.widget.b.d.a
            public void onToastClick() {
                if (!TextUtils.isEmpty(str3)) {
                    h.this.a(str3, new com.baidu.swan.apps.api.c.b(0));
                }
            }
        }).showClickableToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, str).gI(i).fb(z).gE(2).showToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, @NonNull String str, int i, Drawable drawable, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, H(str, 14)).d(drawable).gI(i).fb(z).showHighlightToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, H(str, 14)).gI(i).fb(z).showHighLoadingToast();
    }

    private void Ug() {
        if (DEBUG) {
            Log.w("Api-ToastApi", "the toast type is unknown");
        }
    }

    public static int aj(JSONObject jSONObject) {
        int hD = hD(jSONObject.optString("time")) / 1000;
        if (hD <= 0) {
            return 2;
        }
        return hD;
    }

    public static String H(String str, int i) {
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

    private static int hD(String str) {
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
        ExifInterface hE = hE(str);
        if (hE == null) {
            if (DEBUG) {
                Log.e("Api-ToastApi", "exifInterface is null");
                return null;
            }
            return null;
        }
        int intValue = Integer.valueOf(hE.getAttribute(android.support.media.ExifInterface.TAG_IMAGE_WIDTH)).intValue();
        int intValue2 = Integer.valueOf(hE.getAttribute(android.support.media.ExifInterface.TAG_IMAGE_LENGTH)).intValue();
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

    private static ExifInterface hE(String str) {
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
