package com.baidu.swan.apps.media.b.a;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.media.MimeType;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes11.dex */
public class a extends aa {
    public a(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/saveVideoToPhotosAlbum");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final File file;
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.TU()) {
            if (DEBUG) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
                return false;
            }
            String optString = b.optString("filePath");
            try {
                File file2 = null;
                if ("bdfile".equalsIgnoreCase(URI.create(optString).getScheme())) {
                    String bT = com.baidu.swan.apps.storage.b.bT(optString, eVar.id);
                    if (!TextUtils.isEmpty(bT)) {
                        file2 = new File(bT);
                    }
                    file = file2;
                } else {
                    String a = com.baidu.swan.apps.storage.b.a(optString, eVar, eVar.getVersion());
                    if (TextUtils.isEmpty(a)) {
                        file = null;
                    } else {
                        file = new File(a);
                    }
                }
                if (file == null || !file.exists() || !file.isFile()) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "can not find such file : " + file);
                    return false;
                }
                final String optString2 = b.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                } else if (!(context instanceof Activity)) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                    return false;
                } else {
                    eVar.aoR().b(context, "mapp_images", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.media.b.a.a.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.aq.e.b
                        /* renamed from: a */
                        public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                            if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                                a.this.a(context, file, unitedSchemeEntity, callbackHandler, optString2);
                            } else {
                                com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString2);
                            }
                        }
                    });
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
            } catch (Exception e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "Illegal file_path : " + optString);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final Context context, @NonNull final File file, @NonNull final UnitedSchemeEntity unitedSchemeEntity, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        com.baidu.swan.apps.ad.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.media.b.a.a.2
            @Override // com.baidu.swan.apps.ad.b
            public void gY(String str2) {
                if (a.DEBUG) {
                    Log.d("SwanAppAction", str2 + "");
                }
                a.this.a(context, file, callbackHandler, str);
            }

            @Override // com.baidu.swan.apps.ad.b
            public void M(int i, String str2) {
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10005, str2).toString(), str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final Context context, @NonNull File file, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        if (file == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
        } else {
            rx.d.bR(file).d(new rx.functions.f<File, File>() { // from class: com.baidu.swan.apps.media.b.a.a.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: A */
                public File call(File file2) {
                    String oO = com.baidu.swan.apps.storage.b.oO(com.baidu.swan.apps.runtime.e.aoH());
                    if (!TextUtils.isEmpty(oO) && file2.getPath().startsWith(oO)) {
                        return a.this.d(context, file2);
                    }
                    return null;
                }
            }).d(Schedulers.io()).c(rx.a.b.a.dPJ()).c(new rx.functions.b<File>() { // from class: com.baidu.swan.apps.media.b.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                /* renamed from: z */
                public void call(File file2) {
                    if (file2 == null) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "output file create fail").toString());
                        return;
                    }
                    Uri fromFile = Uri.fromFile(file2);
                    a.this.c(context, file2.getPath(), -1L);
                    context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
                    if (a.DEBUG) {
                        Log.i("SaveVideoAction", "saveToAlbum : file = " + file2);
                    }
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context, String str, long j) {
        if (checkFile(str)) {
            long bd = bd(j);
            ContentValues k = k(str, bd);
            k.put("datetaken", Long.valueOf(bd));
            k.put("mime_type", getVideoMimeType(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, k);
        }
    }

    private ContentValues k(String str, long j) {
        ContentValues contentValues = new ContentValues();
        File file = new File(str);
        long bd = bd(j);
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("date_modified", Long.valueOf(bd));
        contentValues.put("date_added", Long.valueOf(bd));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    private String getVideoMimeType(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith("mp4") || lowerCase.endsWith("mpeg4")) {
            return MimeType.Video.MP4;
        }
        if (lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return MimeType.Video.MP4;
    }

    private long bd(long j) {
        if (j <= 0) {
            return System.currentTimeMillis();
        }
        return j;
    }

    private boolean checkFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File d(Context context, @NonNull File file) {
        File ca = ca(context);
        if (ca == null) {
            return null;
        }
        File file2 = new File(ca, file.getName());
        if (com.baidu.swan.e.d.copyFile(file, file2) <= 0) {
            file2 = null;
        }
        return file2;
    }

    public static File ca(Context context) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath());
        if (file.exists()) {
            String str = "Video";
            if (!new File(file, "Video").exists() && new File(file, "video").exists()) {
                str = "video";
            }
            File file2 = new File(file, str);
            if ((file2.exists() || file2.mkdirs()) && file2.canWrite()) {
                return file2;
            }
        }
        File file3 = new File(Environment.getExternalStorageDirectory().getPath() + File.separator + "baidu" + File.separator + "searchbox" + File.separator + "Video");
        if (!file3.exists() && !file3.mkdirs()) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                File file4 = new File(externalFilesDir.getPath() + File.separator + "Video");
                if (file4.exists() || file4.mkdirs()) {
                    return file4;
                }
            }
            File file5 = new File(context.getFilesDir().getPath() + File.separator + "Video");
            if (file5.exists() || file5.mkdirs()) {
                return file5;
            }
            return null;
        }
        return file3;
    }
}
