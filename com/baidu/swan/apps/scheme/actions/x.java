package com.baidu.swan.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x extends z {
    public x(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/saveImageToPhotosAlbum");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        String a;
        final File file;
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("SaveImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            com.baidu.swan.apps.console.c.e("SaveImage", "illegal params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        }
        String optString = c.optString("filePath");
        try {
            File file2 = null;
            if ("bdfile".equalsIgnoreCase(URI.create(optString).getScheme())) {
                String aE = com.baidu.swan.apps.storage.b.aE(optString, bVar.id);
                if (!TextUtils.isEmpty(aE)) {
                    file2 = new File(aE);
                }
                file = file2;
            } else {
                if (com.baidu.swan.apps.ac.a.a.l(bVar.vP())) {
                    a = com.baidu.swan.apps.storage.b.hH(optString);
                } else {
                    a = com.baidu.swan.apps.storage.b.a(optString, bVar, bVar.getVersion());
                }
                if (TextUtils.isEmpty(a)) {
                    file = null;
                } else {
                    file = new File(a);
                }
            }
            if (file == null || !file.exists() || !file.isFile()) {
                com.baidu.swan.apps.console.c.e("SaveImage", "can not find such file");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                return false;
            }
            final String optString2 = c.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                com.baidu.swan.apps.console.c.e("SaveImage", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                com.baidu.swan.apps.console.c.e("SaveImage", "the context is not an activity");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                bVar.Ml().a((Activity) context, "mapp_images", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.x.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: b */
                    public void D(Boolean bool) {
                        if (!bool.booleanValue()) {
                            com.baidu.swan.apps.console.c.i("SaveImage", "Permission denied");
                            callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(200301, "Permission denied").toString());
                            return;
                        }
                        com.baidu.swan.apps.an.j.a(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.x.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (TextUtils.isEmpty(x.this.e(context, file))) {
                                    com.baidu.swan.apps.console.c.e("SaveImage", "can not save to album");
                                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
                                    return;
                                }
                                com.baidu.swan.apps.console.c.i("SaveImage", "save success");
                                callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                            }
                        }, "SaveImageAction");
                    }
                });
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
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
    public String e(Context context, File file) {
        try {
            String insertImage = MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getPath(), file.getName(), "by aiapp");
            if (!TextUtils.isEmpty(insertImage)) {
                String a = a(Uri.parse(insertImage), context);
                if (!TextUtils.isEmpty(a)) {
                    File file2 = new File(a);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(file2));
                    context.sendBroadcast(intent);
                }
            }
            if (DEBUG) {
                Log.i("SaveImageAction", "saveToAlbum : file = " + file);
                Log.i("SaveImageAction", "saveToAlbum : image = " + insertImage);
            }
            com.baidu.swan.apps.console.c.i("SaveImage", "save success");
            return insertImage;
        } catch (FileNotFoundException e) {
            if (DEBUG) {
                e.printStackTrace();
                Log.i("SaveImageAction", "saveToAlbum : Exception = " + e);
            }
            com.baidu.swan.apps.console.c.e("SaveImage", "save failed:" + e.getMessage());
            return null;
        }
    }

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
                        com.baidu.swan.c.a.c(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.swan.c.a.c(cursor);
                    throw th;
                }
            } else {
                string = null;
            }
            com.baidu.swan.c.a.c(cursor);
            return string;
        } catch (SQLException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.swan.c.a.c(cursor);
            throw th;
        }
    }
}
