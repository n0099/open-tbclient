package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class y extends ab {
    public y(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/saveImageToPhotosAlbum");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("SaveImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e("SaveImage", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        }
        String optString = b.optString("filePath");
        try {
            final File a = a(eVar, optString, URI.create(optString));
            if (a == null || !a.exists() || !a.isFile()) {
                com.baidu.swan.apps.console.c.e("SaveImage", "can not find such file");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + a);
                return false;
            }
            final String optString2 = b.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                com.baidu.swan.apps.console.c.e("SaveImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            eVar.akX().b(context, "mapp_images", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.y.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void E(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.console.c.i("SaveImage", "Permission denied");
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString2);
                        return;
                    }
                    com.baidu.swan.apps.as.m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.y.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            y.this.a(context, a, unitedSchemeEntity, callbackHandler, optString2);
                        }
                    }, "SaveImageAction");
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            com.baidu.swan.apps.console.c.e("SaveImage", "Illegal file_path");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final Context context, final File file, @NonNull final UnitedSchemeEntity unitedSchemeEntity, @NonNull final CallbackHandler callbackHandler, final String str) {
        com.baidu.swan.apps.af.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.scheme.actions.y.2
            @Override // com.baidu.swan.apps.af.b
            public void gQ(String str2) {
                boolean e = y.this.e(context, file);
                int i = e ? 0 : 1001;
                String str3 = e ? "save success" : "can not save to album : " + file;
                com.baidu.swan.apps.console.c.i("SaveImage", str3);
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, str3).toString());
            }

            @Override // com.baidu.swan.apps.af.b
            public void M(int i, String str2) {
                com.baidu.swan.apps.console.c.i("SaveImage", str2 + "");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str2).toString(), str);
            }
        });
    }

    private File a(com.baidu.swan.apps.runtime.e eVar, String str, URI uri) {
        String nt;
        com.baidu.swan.apps.storage.b.c aer = com.baidu.swan.apps.y.f.aeK().aer();
        if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
            nt = aer.nu(str);
        } else if (com.baidu.swan.apps.ah.a.a.k(eVar.Ow())) {
            nt = aer.nl(str);
        } else {
            nt = aer.nt(str);
        }
        if (TextUtils.isEmpty(nt)) {
            return null;
        }
        return new File(nt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(Context context, File file) {
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
        if (decodeFile == null) {
            return false;
        }
        decodeFile.recycle();
        File file2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), y(file));
        if (!file.exists() || com.baidu.swan.d.c.copyFile(file, file2) == 0) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file2));
        context.sendBroadcast(intent);
        return true;
    }

    private String y(File file) {
        String su = com.baidu.swan.d.c.su(file.getPath());
        String valueOf = String.valueOf(System.currentTimeMillis());
        return TextUtils.isEmpty(su) ? valueOf : valueOf + "." + su;
    }
}
