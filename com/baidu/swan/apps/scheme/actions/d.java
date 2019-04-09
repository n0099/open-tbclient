package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ab.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends y {
    private String aPm;
    private String aPn;
    private String mCallback;
    private int mCount;

    /* loaded from: classes2.dex */
    public interface a {
        void g(ArrayList<String> arrayList);

        void gD(String str);
    }

    public d(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/chooseImage");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null || bVar.getActivity() == null) {
            com.baidu.swan.apps.console.c.e("chooseImage", "illegal swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        JSONObject dm = com.baidu.swan.apps.an.n.dm(unitedSchemeEntity.getParam("params"));
        this.mCallback = dm.optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            com.baidu.swan.apps.console.c.e("chooseImage", "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            this.mCount = Integer.parseInt(dm.optString(Config.TRACE_VISIT_RECENT_COUNT));
            if (this.mCount < 1 || this.mCount > 9) {
                this.mCount = 9;
            }
        } catch (NumberFormatException e) {
            com.baidu.swan.apps.console.c.e("chooseImage", "count format error");
            this.mCount = 9;
        }
        this.aPm = m(dm.optJSONArray("sizeType"));
        this.aPn = n(dm.optJSONArray("sourceType"));
        com.baidu.swan.apps.console.c.i("chooseImage", "sizeType: " + this.aPm + ",sourceType: " + this.aPn);
        if (TextUtils.equals(this.aPn, "album")) {
            com.baidu.swan.apps.u.a.CL().a(context, this.mCount, new a() { // from class: com.baidu.swan.apps.scheme.actions.d.1
                @Override // com.baidu.swan.apps.scheme.actions.d.a
                public void g(ArrayList<String> arrayList) {
                    if (arrayList != null && arrayList.size() > 0) {
                        if (TextUtils.equals(d.this.aPm, "compressed")) {
                            d.this.b(unitedSchemeEntity, callbackHandler, bVar, arrayList);
                            return;
                        } else {
                            d.this.a(unitedSchemeEntity, callbackHandler, bVar, arrayList);
                            return;
                        }
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
                }

                @Override // com.baidu.swan.apps.scheme.actions.d.a
                public void gD(String str) {
                    com.baidu.swan.apps.console.c.i("chooseImage", str);
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), d.this.mCallback);
                }
            });
        } else {
            bVar.IZ().a(bVar.getActivity(), "mapp_camera", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.swan.apps.scheme.actions.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    if (bool.booleanValue()) {
                        d.this.o(context, unitedSchemeEntity, callbackHandler, bVar);
                        return;
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, (int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_ACTION);
                    com.baidu.swan.apps.console.c.e("chooseImage", "camera authorize failure");
                }
            });
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        com.baidu.swan.apps.console.c.i("chooseImage", "handleAuthorized start");
        if (com.baidu.swan.apps.camera.a.wm().bt(context)) {
            p(context, unitedSchemeEntity, callbackHandler, bVar);
        } else {
            com.baidu.swan.apps.w.e.Ea().a(1, new String[]{"android.permission.CAMERA"}, new a.InterfaceC0108a() { // from class: com.baidu.swan.apps.scheme.actions.d.3
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0108a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z = false;
                    if (i != 1) {
                        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION, "system camera not authorized").toString(), d.this.mCallback);
                        com.baidu.swan.apps.console.c.e("chooseImage", "handleAuthorized end, failure");
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
                        d.this.p(context, unitedSchemeEntity, callbackHandler, bVar);
                        return;
                    }
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams((int) UIMsg.f_FUN.FUN_ID_VOICE_SCH_OPTION, "system camera not authorized").toString(), d.this.mCallback);
                    com.baidu.swan.apps.console.c.e("chooseImage", "user want not authorize");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.ae.b bVar) {
        Uri fromFile;
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) context).getResultDispatcher();
        if (resultDispatcher != null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                final File c = c(bVar);
                if (c == null || !c.exists()) {
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "error create file").toString(), this.mCallback);
                    return;
                }
                if (com.baidu.swan.apps.an.a.hasNougat()) {
                    fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", c);
                    intent.setFlags(3);
                } else {
                    fromFile = Uri.fromFile(c);
                }
                intent.putExtra("output", fromFile);
                resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.scheme.actions.d.4
                    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                    public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                        if (i == -1) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(c.getAbsolutePath());
                            if (TextUtils.equals(d.this.aPm, "compressed")) {
                                d.this.b(unitedSchemeEntity, callbackHandler, bVar, arrayList);
                                return true;
                            }
                            d.this.a(unitedSchemeEntity, callbackHandler, bVar, arrayList);
                            return true;
                        } else if (i == 0) {
                            com.baidu.swan.apps.console.c.i("chooseImage", "Failed to select image: user cancel operation");
                            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, "用户取消操作").toString(), d.this.mCallback);
                            return true;
                        } else {
                            return true;
                        }
                    }
                });
                resultDispatcher.startActivityForResult(intent);
            }
        }
    }

    private static File c(@NonNull com.baidu.swan.apps.ae.b bVar) {
        File file = new File(com.baidu.swan.apps.storage.b.gY(bVar.id) + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg");
        com.baidu.swan.c.b.C(file);
        return file;
    }

    private String m(JSONArray jSONArray) {
        boolean z = true;
        if (jSONArray == null || jSONArray.length() != 1 || !TextUtils.equals("original", jSONArray.optString(0))) {
            z = false;
        }
        return z ? "original" : "compressed";
    }

    private String n(JSONArray jSONArray) {
        boolean z = true;
        if (jSONArray == null || jSONArray.length() != 1 || !TextUtils.equals("camera", jSONArray.optString(0))) {
            z = false;
        }
        return z ? "camera" : "album";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, ArrayList<String> arrayList) {
        com.baidu.swan.apps.console.c.i("chooseImage", "拷贝文件到temp");
        ArrayList<File> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            File b = b(bVar, file.getName());
            if (b != null && b.exists() && com.baidu.swan.c.b.e(file, b) != 0) {
                arrayList2.add(b);
            }
        }
        c(unitedSchemeEntity, callbackHandler, bVar, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, ArrayList<String> arrayList) {
        com.baidu.swan.apps.console.c.i("chooseImage", "开始压缩图片");
        ArrayList<File> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            File b = b(bVar, file.getName());
            if (a(file, b, 20)) {
                arrayList2.add(b);
            }
        }
        c(unitedSchemeEntity, callbackHandler, bVar, arrayList2);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0041 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    private boolean a(File file, File file2, int i) {
        FileOutputStream fileOutputStream;
        ?? r2 = "压缩图片";
        com.baidu.swan.apps.console.c.i("chooseImage", "压缩图片");
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile == null) {
            return false;
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    decodeFile.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    com.baidu.swan.c.b.c(fileOutputStream);
                    return true;
                } catch (FileNotFoundException e) {
                    e = e;
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                    com.baidu.swan.apps.console.c.e("chooseImage", "压缩图片失败");
                    com.baidu.swan.c.b.c(fileOutputStream);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                com.baidu.swan.c.b.c(r2);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            com.baidu.swan.c.b.c(r2);
            throw th;
        }
    }

    private void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, ArrayList<File> arrayList) {
        com.baidu.swan.apps.console.c.i("chooseImage", "回传图片选择结果");
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(a(arrayList, bVar), 0).toString(), this.mCallback);
    }

    private JSONObject a(ArrayList<File> arrayList, com.baidu.swan.apps.ae.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next != null) {
                    String ka = com.baidu.swan.c.b.ka(next.getAbsolutePath());
                    String aD = com.baidu.swan.apps.storage.b.aD(next.getAbsolutePath(), bVar.id);
                    jSONArray.put(aD + "." + ka);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("path", aD);
                    jSONObject2.put("size", next.length());
                    jSONArray2.put(jSONObject2);
                }
            }
            jSONObject.put("tempFilePaths", jSONArray);
            jSONObject.put("tempFiles", jSONArray2);
        } catch (JSONException e) {
            com.baidu.swan.apps.console.c.e("chooseImage", "wrapParams failed");
            e.printStackTrace();
        }
        if (DEBUG) {
            Log.e("SwanAppAction", jSONObject.toString());
        }
        return jSONObject;
    }

    private File b(com.baidu.swan.apps.ae.b bVar, String str) {
        com.baidu.swan.apps.console.c.i("chooseImage", "获取temp路径");
        String str2 = "aiapp_choose_img_" + System.currentTimeMillis() + "_" + str;
        String gY = com.baidu.swan.apps.storage.b.gY(bVar.id);
        File file = null;
        if (!TextUtils.isEmpty(gY)) {
            File file2 = new File(gY);
            if (file2.exists()) {
                file = new File(file2, str2);
            } else if (file2.mkdirs()) {
                file = new File(file2, str2);
            }
            if (file != null && !file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (DEBUG && file != null) {
            Log.e("SwanAppAction", "temp图片路径:" + file.getAbsolutePath());
        }
        return file;
    }
}
