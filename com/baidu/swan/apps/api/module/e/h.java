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
/* loaded from: classes8.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kM(String str) {
        if (DEBUG) {
            Log.d("Api-ToastApi", "handle: " + str);
        }
        if (ajS()) {
            com.baidu.swan.apps.console.c.e("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
            return new com.baidu.swan.apps.api.c.b(1001, "Api-ToastApi does not supported when app is invisible.");
        }
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "SwanApp is null");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-ToastApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-ToastApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bh.second;
        String optString = jSONObject.optString("type", "1");
        final int aP = aP(jSONObject);
        final String optString2 = jSONObject.optString("message");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("Api-ToastApi", "message is null");
            return new com.baidu.swan.apps.api.c.b(202, "message is null");
        }
        final boolean optBoolean = jSONObject.optBoolean("mask");
        String optString3 = jSONObject.optString("image", "-1");
        final Drawable a2 = a(getContext(), optString3, aIO);
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
                        h.this.b(h.this.getContext(), optString2, aP, optBoolean);
                    }
                });
                break;
            case 1:
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.2
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.a(h.this.getContext(), optString2, aP, a2, optBoolean);
                    }
                });
                break;
            case 2:
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.c(h.this.getContext(), optString2, aP, optBoolean);
                    }
                });
                break;
            case 3:
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.api.module.e.h.4
                    @Override // java.lang.Runnable
                    public void run() {
                        h.this.b(h.this.getContext(), optString2, aP, optString5, optString4);
                    }
                });
                break;
            default:
                ake();
                return new com.baidu.swan.apps.api.c.b(302, "the toast type is unknown");
        }
        return new com.baidu.swan.apps.api.c.b(0);
    }

    public com.baidu.swan.apps.api.c.b akd() {
        if (DEBUG) {
            Log.d("Api-ToastApi", "handle");
        }
        if (com.baidu.swan.apps.runtime.e.aIO() == null) {
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
        com.baidu.swan.apps.res.widget.b.d.dl(context).h(str).i(str2).jk(i).b(new d.a() { // from class: com.baidu.swan.apps.api.module.e.h.6
            @Override // com.baidu.swan.apps.res.widget.b.d.a
            public void agu() {
                if (!TextUtils.isEmpty(str3)) {
                    h.this.a(str3, new com.baidu.swan.apps.api.c.b(0));
                }
            }
        }).aIA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, str).jk(i).hc(z).jg(2).aIv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, @NonNull String str, int i, Drawable drawable, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, Q(str, 14)).i(drawable).jk(i).hc(z).aIy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, Q(str, 14)).jk(i).hc(z).aIz();
    }

    private void ake() {
        if (DEBUG) {
            Log.w("Api-ToastApi", "the toast type is unknown");
        }
    }

    public static int aP(JSONObject jSONObject) {
        int kN = kN(jSONObject.optString("time")) / 1000;
        if (kN <= 0) {
            return 2;
        }
        return kN;
    }

    public static String Q(String str, int i) {
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

    private static int kN(String str) {
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
        ExifInterface kO = kO(str);
        if (kO == null) {
            if (DEBUG) {
                Log.e("Api-ToastApi", "exifInterface is null");
                return null;
            }
            return null;
        }
        int intValue = Integer.valueOf(kO.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_WIDTH)).intValue();
        int intValue2 = Integer.valueOf(kO.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_IMAGE_LENGTH)).intValue();
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

    private static ExifInterface kO(String str) {
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
