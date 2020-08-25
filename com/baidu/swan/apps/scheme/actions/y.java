package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class y extends aa {
    public y(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/saveImageToPhotosAlbum");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
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
            eVar.azU().b(context, "mapp_images", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.y.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void I(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.console.c.i("SaveImage", "Permission denied");
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString2);
                        return;
                    }
                    com.baidu.swan.apps.ap.p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.y.1.1
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
        com.baidu.swan.apps.ab.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.scheme.actions.y.2
            @Override // com.baidu.swan.apps.ab.b
            public void iF(String str2) {
                boolean e = com.baidu.swan.apps.ap.c.aEs() ? y.this.e(context, file) : y.this.f(context, file);
                int i = e ? 0 : 1001;
                String str3 = e ? "save success" : "can not save to album : " + file;
                com.baidu.swan.apps.console.c.i("SaveImage", str3);
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, str3).toString());
            }

            @Override // com.baidu.swan.apps.ab.b
            public void N(int i, String str2) {
                com.baidu.swan.apps.console.c.i("SaveImage", str2 + "");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str2).toString(), str);
            }
        });
    }

    private File a(com.baidu.swan.apps.runtime.e eVar, String str, URI uri) {
        String rS;
        com.baidu.swan.apps.storage.b.c arE = com.baidu.swan.apps.v.f.arY().arE();
        if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
            rS = arE.rT(str);
        } else if (com.baidu.swan.apps.ad.a.a.j(eVar.XZ())) {
            rS = arE.rI(str);
        } else {
            rS = arE.rS(str);
        }
        if (TextUtils.isEmpty(rS)) {
            return null;
        }
        return new File(rS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(Context context, File file) {
        String str = null;
        try {
            str = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
        } catch (FileNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            String a = a(Uri.parse(str), context);
            if (!TextUtils.isEmpty(a)) {
                g(context, new File(a));
            }
        }
        if (DEBUG) {
            Log.i("SaveImageAction", "saveToAlbum : file = " + file);
            Log.i("SaveImageAction", "saveToAlbum : image = " + str);
        }
        com.baidu.swan.apps.console.c.i("SaveImage", "save success");
        return !TextUtils.isEmpty(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [277=4] */
    private static String a(Uri uri, Context context) {
        Cursor cursor;
        String string;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                        cursor.moveToFirst();
                        string = cursor.getString(columnIndexOrThrow);
                    } catch (SQLException e) {
                        e = e;
                        if (DEBUG) {
                            e.printStackTrace();
                        }
                        com.baidu.swan.c.d.closeSafely(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.d.closeSafely(cursor);
                    throw th;
                }
            } else {
                string = null;
            }
            com.baidu.swan.c.d.closeSafely(cursor);
            return string;
        } catch (SQLException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.swan.c.d.closeSafely(cursor);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(Context context, File file) {
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath());
        if (decodeFile == null) {
            return false;
        }
        decodeFile.recycle();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        com.baidu.swan.c.d.ensureDirectoryExist(externalStoragePublicDirectory);
        File file2 = new File(externalStoragePublicDirectory, G(file));
        if (com.baidu.swan.c.d.copyFile(file, file2) != 0) {
            g(context, file2);
            return true;
        }
        return false;
    }

    private String G(File file) {
        String xu = com.baidu.swan.c.d.xu(file.getPath());
        String valueOf = String.valueOf(System.currentTimeMillis());
        return TextUtils.isEmpty(xu) ? valueOf : valueOf + "." + xu;
    }

    private void g(Context context, File file) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.fromFile(file));
        context.sendBroadcast(intent);
    }
}
