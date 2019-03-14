package com.baidu.swan.apps.media.d.a;

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
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.io.File;
import java.net.URI;
import org.json.JSONObject;
import rx.d;
import rx.functions.f;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/saveVideoToPhotosAlbum");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        final File file;
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (c == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal params");
            return false;
        }
        String optString = c.optString("filePath");
        try {
            File file2 = null;
            if ("bdfile".equalsIgnoreCase(URI.create(optString).getScheme())) {
                String aC = com.baidu.swan.apps.storage.b.aC(optString, bVar.id);
                if (!TextUtils.isEmpty(aC)) {
                    file2 = new File(aC);
                }
                file = file2;
            } else {
                String a = com.baidu.swan.apps.storage.b.a(optString, bVar, bVar.getVersion());
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
            final String optString2 = c.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                bVar.Jb().a((Activity) context, "mapp_images", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.media.d.a.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.c.a
                    /* renamed from: b */
                    public void D(Boolean bool) {
                        if (bool.booleanValue()) {
                            a.this.a(context, file, callbackHandler, optString2);
                        } else {
                            callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(200301, "Permission denied").toString());
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull final Context context, @NonNull File file, @NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        if (file == null) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "can not save to album : " + file).toString());
        } else {
            d.bn(file).d(new f<File, File>() { // from class: com.baidu.swan.apps.media.d.a.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.f
                /* renamed from: z */
                public File call(File file2) {
                    String gX = com.baidu.swan.apps.storage.b.gX(com.baidu.swan.apps.ae.b.Ji());
                    if (!TextUtils.isEmpty(gX) && file2.getPath().startsWith(gX)) {
                        return a.this.e(context, file2);
                    }
                    return null;
                }
            }).b(Schedulers.io()).a(rx.a.b.a.cDU()).c(new rx.functions.b<File>() { // from class: com.baidu.swan.apps.media.d.a.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                /* renamed from: y */
                public void call(File file2) {
                    if (file2 == null) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "output file create fail").toString());
                        return;
                    }
                    Uri fromFile = Uri.fromFile(file2);
                    a.this.g(context, file2.getPath(), -1L);
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
    public void g(Context context, String str, long j) {
        if (fd(str)) {
            long x = x(j);
            ContentValues i = i(str, x);
            i.put("datetaken", Long.valueOf(x));
            i.put("mime_type", fc(str));
            context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, i);
        }
    }

    private ContentValues i(String str, long j) {
        ContentValues contentValues = new ContentValues();
        File file = new File(str);
        long x = x(j);
        contentValues.put("title", file.getName());
        contentValues.put("_display_name", file.getName());
        contentValues.put("date_modified", Long.valueOf(x));
        contentValues.put("date_added", Long.valueOf(x));
        contentValues.put("_data", file.getAbsolutePath());
        contentValues.put("_size", Long.valueOf(file.length()));
        return contentValues;
    }

    private String fc(String str) {
        String lowerCase = str.toLowerCase();
        if (!lowerCase.endsWith("mp4") && !lowerCase.endsWith("mpeg4") && lowerCase.endsWith("3gp")) {
            return "video/3gp";
        }
        return "video/mp4";
    }

    private long x(long j) {
        if (j <= 0) {
            return System.currentTimeMillis();
        }
        return j;
    }

    private boolean fd(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File e(Context context, @NonNull File file) {
        File bR = bR(context);
        if (bR == null) {
            return null;
        }
        File file2 = new File(bR, file.getName());
        if (com.baidu.swan.c.b.e(file, file2) <= 0) {
            file2 = null;
        }
        return file2;
    }

    public static File bR(Context context) {
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
