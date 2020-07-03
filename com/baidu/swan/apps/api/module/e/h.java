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

    public com.baidu.swan.apps.api.c.b hK(String str) {
        if (DEBUG) {
            Log.d("Api-ToastApi", "handle: " + str);
        }
        if (Va()) {
            com.baidu.swan.apps.console.c.e("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-ToastApi does not supported when app is invisible.");
        }
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-ToastApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ToastApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aR.second;
        String optString = jSONObject.optString("type", "1");
        final int aq = aq(jSONObject);
        final String optString2 = jSONObject.optString("message");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("Api-ToastApi", "message is null");
            return new com.baidu.swan.apps.api.c.b(202, "message is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("mask");
        String optString3 = jSONObject.optString("image", "-1");
        final Drawable a = a(getContext(), optString3, apN);
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
                        h.this.b(h.this.getContext(), optString2, aq, optBoolean);
                    }
                });
                break;
            case 1:
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.a(h.this.getContext(), optString2, aq, a, optBoolean);
                    }
                });
                break;
            case 2:
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.c(h.this.getContext(), optString2, aq, optBoolean);
                    }
                });
                break;
            case 3:
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(h.this.getContext(), optString2, aq, optString5, optString4);
                    }
                });
                break;
            default:
                Vm();
                return new com.baidu.swan.apps.api.c.b(302, "the toast type is unknown");
        }
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b Vl() {
        if (DEBUG) {
            Log.d("Api-ToastApi", "handle");
        }
        if (com.baidu.swan.apps.runtime.e.apN() == null) {
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
        com.baidu.swan.apps.res.widget.b.d.cf(context).g(str).h(str2).gT(i).b(new d.a() { // from class: com.baidu.swan.apps.api.module.e.h.6
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
        com.baidu.swan.apps.res.widget.b.d.a(context, str).gT(i).fg(z).gP(2).showToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, @NonNull String str, int i, Drawable drawable, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, H(str, 14)).d(drawable).gT(i).fg(z).showHighlightToast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, H(str, 14)).gT(i).fg(z).showHighLoadingToast();
    }

    private void Vm() {
        if (DEBUG) {
            Log.w("Api-ToastApi", "the toast type is unknown");
        }
    }

    public static int aq(JSONObject jSONObject) {
        int hL = hL(jSONObject.optString("time")) / 1000;
        if (hL <= 0) {
            return 2;
        }
        return hL;
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

    private static int hL(String str) {
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
        ExifInterface hM = hM(str);
        if (hM == null) {
            if (DEBUG) {
                Log.e("Api-ToastApi", "exifInterface is null");
                return null;
            }
            return null;
        }
        int intValue = Integer.valueOf(hM.getAttribute(android.support.media.ExifInterface.TAG_IMAGE_WIDTH)).intValue();
        int intValue2 = Integer.valueOf(hM.getAttribute(android.support.media.ExifInterface.TAG_IMAGE_LENGTH)).intValue();
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

    private static ExifInterface hM(String str) {
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
