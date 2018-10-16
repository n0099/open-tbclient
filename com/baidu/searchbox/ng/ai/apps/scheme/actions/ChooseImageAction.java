package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ChooseImageAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/chooseImage";
    private static final String CHOOSE_IMG_PREFIX = "aiapp_choose_img_";
    private static final int COMPRESS_QUALITY = 20;
    private static final int COUNT_MAX = 9;
    private static final String KEY_CB = "cb";
    private static final String KEY_COUNT = "count";
    private static final String KEY_PARAMS = "params";
    private static final String KEY_SIZE_TYPE = "sizeType";
    private static final String MODULE_TAG = "chooseImage";
    private static final int STATUS_CANCEL_CHOOSE = 1002;
    private static final String TYPE_COMPRESSED = "compressed";
    private static final String TYPE_ORIGINAL = "original";
    private String mCallback;
    private int mCount;
    private String mSizeType;

    /* loaded from: classes2.dex */
    public interface OnImageChooseResultCallback {
        void onResult(boolean z, String str, List<String> list);
    }

    public ChooseImageAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "illegal aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        JSONObject parseString = AiAppJSONUtils.parseString(unitedSchemeEntity.getParam("params"));
        this.mCallback = parseString.optString("cb");
        if (TextUtils.isEmpty(this.mCallback)) {
            AiAppsLog.e(MODULE_TAG, "empty cb");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        try {
            this.mCount = Integer.parseInt(parseString.optString("count"));
            if (this.mCount < 1 || this.mCount > 9) {
                this.mCount = 9;
            }
        } catch (NumberFormatException e) {
            AiAppsLog.e(MODULE_TAG, "count format error");
            this.mCount = 9;
        }
        this.mSizeType = getSizeType(parseString.optJSONArray(KEY_SIZE_TYPE));
        AiAppsLog.i(MODULE_TAG, "mSizeType:" + this.mSizeType);
        AiAppsRuntime.getImageRuntime().chooseImage(context, this.mCount, new OnImageChooseResultCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.ChooseImageAction.1
            @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.ChooseImageAction.OnImageChooseResultCallback
            public void onResult(boolean z, String str, List<String> list) {
                if (!z) {
                    AiAppsLog.i(ChooseImageAction.MODULE_TAG, str);
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1002, str).toString(), ChooseImageAction.this.mCallback);
                } else if (list != null && list.size() > 0) {
                    if (TextUtils.equals(ChooseImageAction.this.mSizeType, "compressed")) {
                        ChooseImageAction.this.handleCompress(unitedSchemeEntity, callbackHandler, aiApp, (ArrayList) list);
                    } else {
                        ChooseImageAction.this.copyFileToTemp(unitedSchemeEntity, callbackHandler, aiApp, (ArrayList) list);
                    }
                } else {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 1001);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    private String getSizeType(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "compressed";
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (TextUtils.equals("compressed", jSONArray.optString(i))) {
                return "compressed";
            }
        }
        return TYPE_ORIGINAL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyFileToTemp(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, ArrayList<String> arrayList) {
        AiAppsLog.i(MODULE_TAG, "拷贝文件到temp");
        ArrayList<File> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            File tempImgFile = getTempImgFile(aiApp, file.getName());
            if (tempImgFile != null && tempImgFile.exists() && AiAppsFileUtils.copyFile(file, tempImgFile) != 0) {
                arrayList2.add(tempImgFile);
            }
        }
        chooseImgFinish(unitedSchemeEntity, callbackHandler, aiApp, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCompress(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, ArrayList<String> arrayList) {
        AiAppsLog.i(MODULE_TAG, "开始压缩图片");
        ArrayList<File> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            File file = new File(it.next());
            File tempImgFile = getTempImgFile(aiApp, file.getName());
            if (compressImg(file, tempImgFile, 20)) {
                arrayList2.add(tempImgFile);
            }
        }
        chooseImgFinish(unitedSchemeEntity, callbackHandler, aiApp, arrayList2);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x003a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x003c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x0016 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    private boolean compressImg(File file, File file2, int i) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        AiAppsLog.i(MODULE_TAG, "压缩图片");
        String absolutePath = file.getAbsolutePath();
        Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath);
        if (decodeFile != null) {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        decodeFile.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                        AiAppsFileUtils.closeSafely(fileOutputStream);
                        z = true;
                        absolutePath = fileOutputStream;
                    } catch (FileNotFoundException e) {
                        AiAppsLog.e(MODULE_TAG, "压缩图片失败");
                        AiAppsFileUtils.closeSafely(fileOutputStream);
                        absolutePath = fileOutputStream;
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    AiAppsFileUtils.closeSafely(absolutePath);
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                absolutePath = 0;
                AiAppsFileUtils.closeSafely(absolutePath);
                throw th;
            }
        }
        return z;
    }

    private void chooseImgFinish(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, ArrayList<File> arrayList) {
        AiAppsLog.i(MODULE_TAG, "回传图片选择结果");
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParamsWithEncode(wrapParams(arrayList, aiApp), 0).toString(), this.mCallback);
    }

    private JSONObject wrapParams(ArrayList<File> arrayList, AiApp aiApp) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray();
            Iterator<File> it = arrayList.iterator();
            while (it.hasNext()) {
                File next = it.next();
                if (next != null) {
                    String path2Scheme = StorageUtil.path2Scheme(next.getAbsolutePath(), aiApp.id);
                    jSONArray.put(path2Scheme);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("path", path2Scheme);
                    jSONObject2.put(ChooseVideoAction.CB_KEY_SIZE, next.length());
                    jSONArray2.put(jSONObject2);
                }
            }
            jSONObject.put("tempFilePaths", jSONArray);
            jSONObject.put("tempFiles", jSONArray2);
        } catch (JSONException e) {
            AiAppsLog.e(MODULE_TAG, "wrapParams failed");
            e.printStackTrace();
        }
        return jSONObject;
    }

    private File getTempImgFile(AiApp aiApp, String str) {
        AiAppsLog.i(MODULE_TAG, "获取temp路径");
        String str2 = CHOOSE_IMG_PREFIX + System.currentTimeMillis() + BaseRequestAction.SPLITE + str;
        String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(aiApp.id);
        File file = null;
        if (!TextUtils.isEmpty(aiappTmpDirectory)) {
            File file2 = new File(aiappTmpDirectory);
            if (file2.exists()) {
                file = new File(file2, str2);
            } else if (file2.mkdirs()) {
                file = new File(file2, str2);
            }
            if (file != null && !file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
}
