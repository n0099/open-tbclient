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
import android.support.v4.content.FileProvider;
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
/* loaded from: classes11.dex */
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
            eVar.aoR().b(context, "mapp_images", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.scheme.actions.y.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.console.c.i("SaveImage", "Permission denied");
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString2);
                        return;
                    }
                    com.baidu.swan.apps.aq.n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.y.1.1
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
        com.baidu.swan.apps.ad.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.scheme.actions.y.2
            @Override // com.baidu.swan.apps.ad.b
            public void gY(String str2) {
                boolean e = com.baidu.swan.apps.aq.b.ata() ? y.this.e(context, file) : y.this.f(context, file);
                int i = e ? 0 : 1001;
                String str3 = e ? "save success" : "can not save to album : " + file;
                com.baidu.swan.apps.console.c.i("SaveImage", str3);
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, str3).toString());
            }

            @Override // com.baidu.swan.apps.ad.b
            public void M(int i, String str2) {
                com.baidu.swan.apps.console.c.i("SaveImage", str2 + "");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str2).toString(), str);
            }
        });
    }

    private File a(com.baidu.swan.apps.runtime.e eVar, String str, URI uri) {
        String oZ;
        com.baidu.swan.apps.storage.b.c ahB = com.baidu.swan.apps.w.f.ahV().ahB();
        if ("bdfile".equalsIgnoreCase(uri.getScheme())) {
            oZ = ahB.pa(str);
        } else if (com.baidu.swan.apps.af.a.a.m(eVar.QJ())) {
            oZ = ahB.oP(str);
        } else {
            oZ = ahB.oZ(str);
        }
        if (TextUtils.isEmpty(oZ)) {
            return null;
        }
        return new File(oZ);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [280=4] */
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
                        com.baidu.swan.e.d.closeSafely(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.e.d.closeSafely(cursor);
                    throw th;
                }
            } else {
                string = null;
            }
            com.baidu.swan.e.d.closeSafely(cursor);
            return string;
        } catch (SQLException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.swan.e.d.closeSafely(cursor);
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
        com.baidu.swan.e.d.ensureDirectoryExist(externalStoragePublicDirectory);
        File file2 = new File(externalStoragePublicDirectory, C(file));
        if (com.baidu.swan.e.d.copyFile(file, file2) != 0) {
            g(context, file2);
            return true;
        }
        return false;
    }

    private String C(File file) {
        String tY = com.baidu.swan.e.d.tY(file.getPath());
        String valueOf = String.valueOf(System.currentTimeMillis());
        return TextUtils.isEmpty(tY) ? valueOf : valueOf + "." + tY;
    }

    private void g(Context context, File file) {
        Uri fromFile;
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        if (com.baidu.swan.apps.aq.b.hasNougat()) {
            fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".swan.fileprovider", file);
            intent.setFlags(1);
        } else {
            fromFile = Uri.fromFile(file);
        }
        intent.setData(fromFile);
        context.sendBroadcast(intent);
    }
}
