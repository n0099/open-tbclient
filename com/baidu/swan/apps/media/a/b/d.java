package com.baidu.swan.apps.media.a.b;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.UIMsg;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.w.e;
import java.io.File;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static com.baidu.swan.apps.media.a.b.c aVA;

    /* loaded from: classes2.dex */
    public static class a {
        public b aVE;
        public c aVF;
        public String info;
        public Uri uri;
    }

    /* loaded from: classes2.dex */
    public static class c {
        public String aVJ;
        public long aVK;
        public long aVL;
        String aVM;
        public long duration;
        long id;
        public long size;
    }

    public static boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, JSONObject jSONObject) {
        b af = b.af(jSONObject);
        if (af.sourceType == 2) {
            a(context, unitedSchemeEntity, callbackHandler, bVar, af);
            return true;
        }
        c(context, unitedSchemeEntity, callbackHandler, bVar, af);
        return true;
    }

    private static void a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar, final b bVar2) {
        if (com.baidu.swan.apps.camera.a.CE().aO(context)) {
            b(context, unitedSchemeEntity, callbackHandler, bVar, bVar2);
        } else {
            e.LE().a(1, new String[]{"android.permission.CAMERA"}, new a.InterfaceC0152a() { // from class: com.baidu.swan.apps.media.a.b.d.1
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0152a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z = false;
                    if (i != 1) {
                        UnitedSchemeUtility.safeCallback(CallbackHandler.this, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION, "system camera not authorized").toString(), bVar2.callback);
                        return;
                    }
                    int length = iArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            z = true;
                            break;
                        } else if (iArr[i2] == -1) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (z) {
                        d.b(context, unitedSchemeEntity, CallbackHandler.this, bVar, bVar2);
                    } else {
                        UnitedSchemeUtility.safeCallback(CallbackHandler.this, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION, "system camera not authorized").toString(), bVar2.callback);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar, final b bVar2) {
        final Uri fromFile;
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
        if (resultDispatcher != null) {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            final File b2 = b(bVar);
            if (com.baidu.swan.apps.an.a.hasNougat()) {
                fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", b2);
                intent.setFlags(3);
            } else {
                fromFile = Uri.fromFile(b2);
            }
            intent.putExtra("output", fromFile);
            intent.putExtra("android.intent.extra.durationLimit", bVar2.aVI);
            intent.putExtra("android.intent.extra.videoQuality", 1);
            if (TextUtils.equals(bVar2.aVH, "front") && Me()) {
                if (com.baidu.swan.apps.an.a.TY()) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                    intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                    intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                } else {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                }
            }
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.media.a.b.d.2
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                    if (i == 0 || intent2 == null) {
                        d.a(CallbackHandler.this, bVar2.callback);
                        return true;
                    } else if (intent2 != null) {
                        a aVar = new a();
                        if (fromFile != null && fromFile.equals(intent2.getData())) {
                            aVar.uri = Uri.fromFile(b2);
                        }
                        aVar.aVE = bVar2;
                        d.a(context, unitedSchemeEntity, CallbackHandler.this, bVar, aVar);
                        return true;
                    } else {
                        return true;
                    }
                }
            });
            resultDispatcher.startActivityForResult(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(CallbackHandler callbackHandler, String str) {
        String jSONObject = UnitedSchemeUtility.wrapCallbackParams(new JSONObject(), 1002, "Cancel").toString();
        if (callbackHandler != null) {
            callbackHandler.handleSchemeDispatchCallback(str, jSONObject);
        }
    }

    private static boolean Me() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (1 == cameraInfo.facing) {
                return true;
            }
        }
        return false;
    }

    private static File b(@NonNull com.baidu.swan.apps.ae.b bVar) {
        File file = new File(com.baidu.swan.apps.storage.b.ik(bVar.id) + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4");
        com.baidu.swan.c.a.n(file);
        return file;
    }

    private static void c(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar, final b bVar2) {
        ActivityResultDispatcher resultDispatcher;
        if ((context instanceof ActivityResultDispatcherHolder) && (resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher()) != null) {
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.media.a.b.d.3
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
                    if (intent != null) {
                        a aVar = new a();
                        aVar.uri = intent.getData();
                        aVar.aVE = b.this;
                        d.a(context, unitedSchemeEntity, callbackHandler, bVar, aVar);
                        return true;
                    } else if (i == 0) {
                        d.a(callbackHandler, b.this.callback);
                        return true;
                    } else {
                        return true;
                    }
                }
            });
            resultDispatcher.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Video.Media.EXTERNAL_CONTENT_URI));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, @NonNull a aVar) {
        if (DEBUG) {
            Log.i("VideoPickHelper", "consumePickAction:" + aVar.uri);
        }
        if (aVar.uri != null) {
            if (aVA == null || aVA.getStatus() == AsyncTask.Status.FINISHED) {
                aVA = new com.baidu.swan.apps.media.a.b.c(context, unitedSchemeEntity, callbackHandler);
                aVA.execute(aVar);
            } else if (DEBUG) {
                Log.w("VideoPickHelper", "Pick task is running !!");
            }
        } else if (DEBUG) {
            Log.w("VideoPickHelper", "Pick task not find uri !!");
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public String callback;
        public int sourceType = 3;
        public boolean aVG = true;
        public String aVH = "back";
        public int aVI = 60;

        public static b af(JSONObject jSONObject) {
            b bVar = new b();
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    int i = 0;
                    for (int i2 = 0; i2 < length; i2++) {
                        String optString = optJSONArray.optString(i2);
                        char c = 65535;
                        switch (optString.hashCode()) {
                            case -1367751899:
                                if (optString.equals("camera")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 92896879:
                                if (optString.equals("album")) {
                                    c = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                i |= 1;
                                break;
                            case 1:
                                i |= 2;
                                break;
                        }
                    }
                    bVar.sourceType = i;
                }
                bVar.aVG = jSONObject.optBoolean("compressed", true);
                int optInt = jSONObject.optInt("maxDuration", 60);
                if (optInt > 60) {
                    optInt = 60;
                }
                bVar.aVI = optInt;
                bVar.aVH = jSONObject.optString("camera");
                bVar.callback = jSONObject.optString("cb");
            }
            return bVar;
        }
    }
}
