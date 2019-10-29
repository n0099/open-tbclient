package com.baidu.swan.apps.scheme.actions.d;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends z {
    public e(j jVar) {
        super(jVar, "/swan/showToast");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params == null || params.size() == 0) {
            com.baidu.swan.apps.console.c.e("ShowToastAction", "hasMmap for params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String str = params.get("params");
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.e("ShowToastAction", "the key params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type", "1");
            final int aA = aA(jSONObject);
            final String optString2 = jSONObject.optString("message");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                com.baidu.swan.apps.console.c.e("ShowToastAction", "message is null");
                return false;
            }
            final boolean optBoolean = jSONObject.optBoolean("mask");
            String optString3 = jSONObject.optString("image", LivenessStat.TYPE_STRING_DEFAULT);
            final Drawable a = a(context, optString3, bVar);
            if (DEBUG) {
                Log.e("ShowToastAction", "imagepath = " + optString3);
            }
            String str2 = (!TextUtils.equals(optString3, LivenessStat.TYPE_STRING_DEFAULT) && a == null && TextUtils.equals(optString, "2")) ? "1" : optString;
            char c = 65535;
            switch (str2.hashCode()) {
                case 49:
                    if (str2.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str2.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str2.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.d.e.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(context, callbackHandler, unitedSchemeEntity, optString2, aA, optBoolean);
                        }
                    });
                    break;
                case 1:
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.d.e.2
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(context, callbackHandler, unitedSchemeEntity, optString2, aA, a, optBoolean);
                        }
                    });
                    break;
                case 2:
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.d.e.3
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.b(context, callbackHandler, unitedSchemeEntity, optString2, aA, optBoolean);
                        }
                    });
                    break;
                default:
                    l(unitedSchemeEntity);
                    return false;
            }
            return true;
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("ShowToastAction", "json exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
    }

    private int aA(JSONObject jSONObject) {
        int hG = hG(jSONObject.optString("time")) / 1000;
        if (hG <= 0) {
            return 2;
        }
        return hG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, str).eF(i).cF(z).eB(2).QN();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, Drawable drawable, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, E(str, 14)).b(drawable).eF(i).cF(z).QQ();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, @NonNull String str, int i, boolean z) {
        com.baidu.swan.apps.res.widget.b.d.a(context, E(str, 14)).eF(i).cF(z).QR();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    private void l(UnitedSchemeEntity unitedSchemeEntity) {
        if (DEBUG) {
            Log.w("ShowToastAction", "the toast type is unknown");
        }
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
    }

    private String E(String str, int i) {
        char[] charArray;
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.trim().toCharArray()) {
            if (c >= 161) {
                i2 += 2;
                if (i2 > i) {
                    break;
                }
                stringBuffer.append(c);
            } else {
                i2++;
                if (i2 > i) {
                    break;
                }
                stringBuffer.append(c);
            }
        }
        if (i2 > i) {
            stringBuffer.append(StringHelper.STRING_MORE);
        }
        return stringBuffer.toString();
    }

    private int hG(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private Drawable a(Context context, String str, com.baidu.swan.apps.ae.b bVar) {
        BitmapDrawable bitmapDrawable;
        if (TextUtils.isEmpty(str) || bVar == null || context == null) {
            return null;
        }
        if (DEBUG) {
            Log.e("ShowToastAction", "imagePath = " + str);
        }
        ExifInterface hJ = hJ(str);
        if (hJ == null) {
            if (DEBUG) {
                Log.e("ShowToastAction", "exifInterface is null");
                return null;
            }
            return null;
        }
        int intValue = Integer.valueOf(hJ.getAttribute("ImageWidth")).intValue();
        int intValue2 = Integer.valueOf(hJ.getAttribute("ImageLength")).intValue();
        if (DEBUG) {
            Log.e("ShowToastAction", "width = " + intValue + "， height = " + intValue2);
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            if (DEBUG) {
                Log.e("ShowToastAction", "image file not exists");
                return null;
            }
            return null;
        }
        try {
            bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            if (DEBUG) {
                Log.e("ShowToastAction", "FileNotFoundException");
                e.printStackTrace();
            }
            bitmapDrawable = null;
        }
        return bitmapDrawable;
    }

    private ExifInterface hJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ExifInterface(str);
        } catch (IOException e) {
            return null;
        }
    }
}
