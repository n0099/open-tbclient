package com.baidu.swan.apps.scheme.actions.l;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.storage.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends aa {
    private String mName;

    public a(j jVar) {
        super(jVar, "/swanAPI/getScreenshot");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            c.e("Screenshot", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        this.mName = v.parseString(unitedSchemeEntity.getParam("params")).optString("name");
        if (TextUtils.isEmpty(this.mName)) {
            c.e("Screenshot", "invalid params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        c(unitedSchemeEntity, callbackHandler, eVar);
        return true;
    }

    private void c(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, @NonNull final e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.l.a.1
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap aRE = ah.aRE();
                if (aRE == null) {
                    a.this.d(unitedSchemeEntity, callbackHandler, "can't get screenshot");
                } else {
                    p.a(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.l.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.a(aRE, unitedSchemeEntity, callbackHandler, eVar);
                        }
                    }, "savescreenshot");
                }
            }
        });
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00f8 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x00fa */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x0079 */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.graphics.Bitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(@NonNull Bitmap bitmap, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull e eVar) {
        FileOutputStream fileOutputStream;
        String tU = b.tU(eVar.id);
        if (tU != null) {
            String str = tU + File.separator + StatisticConstants.SCREENSHOT;
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                file.delete();
                if (!file.mkdir()) {
                    d(unitedSchemeEntity, callbackHandler, "mkdir fail");
                    return;
                }
            }
            ?? r1 = ".png";
            String sb = new StringBuilder().append(str).append(File.separator).append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())).append(this.mName).append(".png").toString();
            try {
                try {
                    fileOutputStream = new FileOutputStream(sb);
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        c.i("Screenshot", "save screenshot to " + sb);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a(true, b.cH(sb, eVar.id), "success"), 0));
                        r1 = fileOutputStream;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                r1 = fileOutputStream;
                            } catch (IOException e) {
                                e.printStackTrace();
                                d(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                                r1 = fileOutputStream;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        d(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                        r1 = fileOutputStream;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                r1 = fileOutputStream;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                d(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                                r1 = fileOutputStream;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            d(unitedSchemeEntity, callbackHandler, "save screenshot fail");
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                r1 = 0;
                if (r1 != 0) {
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        c.e("Screenshot", str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a(false, null, str), 0));
    }

    private JSONObject a(boolean z, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.mName);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("message", str2);
            }
            if (z) {
                jSONObject.put("path", str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
