package com.baidu.searchbox.ng.ai.apps.scheme.actions.screenshot;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.storage.StorageUtil;
import com.baidu.searchbox.ng.ai.apps.util.AiAppExecutorUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppJSONUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUIUtils;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ScreenshotAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getScreenshot";
    private static final String DIR_NAME = "screenshot";
    private static final String ERR_CANT_GET_SCREENSHOT = "can't get screenshot";
    private static final String ERR_MKDIR_FAIL = "mkdir fail";
    private static final String ERR_SAVE_FAIL = "save screenshot fail";
    private static final String KEY_FILE_PATH = "path";
    private static final String KEY_NAME = "name";
    private static final String MODULE_TAG = "Screenshot";
    private String mName;

    public ScreenshotAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "illegal aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        this.mName = AiAppJSONUtils.parseString(unitedSchemeEntity.getParam("params")).optString("name");
        if (TextUtils.isEmpty(this.mName)) {
            AiAppsLog.e(MODULE_TAG, "invalid params");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        getScreenshot(unitedSchemeEntity, callbackHandler, aiApp);
        return true;
    }

    private void getScreenshot(final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, @NonNull final AiApp aiApp) {
        AiAppsUtils.runOnUiThread(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.screenshot.ScreenshotAction.1
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap screenshot = AiAppsUIUtils.getScreenshot();
                if (screenshot == null) {
                    ScreenshotAction.this.notifyExecuteFail(unitedSchemeEntity, callbackHandler, ScreenshotAction.ERR_CANT_GET_SCREENSHOT);
                } else {
                    AiAppExecutorUtils.postOnIO(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.screenshot.ScreenshotAction.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ScreenshotAction.this.saveScreenshot(screenshot, unitedSchemeEntity, callbackHandler, aiApp);
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
    public void saveScreenshot(@NonNull Bitmap bitmap, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, @NonNull AiApp aiApp) {
        FileOutputStream fileOutputStream;
        String aiappTmpDirectory = StorageUtil.getAiappTmpDirectory(aiApp.id);
        if (aiappTmpDirectory != null) {
            String str = aiappTmpDirectory + File.separator + DIR_NAME;
            File file = new File(str);
            if (!file.exists() || !file.isDirectory()) {
                file.delete();
                if (!file.mkdir()) {
                    notifyExecuteFail(unitedSchemeEntity, callbackHandler, ERR_MKDIR_FAIL);
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
                        AiAppsLog.d(MODULE_TAG, "save screenshot to " + sb);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(createResult(true, StorageUtil.path2Scheme(sb, aiApp.id), "success"), 0));
                        r1 = fileOutputStream;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                r1 = fileOutputStream;
                            } catch (IOException e) {
                                e.printStackTrace();
                                notifyExecuteFail(unitedSchemeEntity, callbackHandler, ERR_SAVE_FAIL);
                                r1 = fileOutputStream;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        e.printStackTrace();
                        notifyExecuteFail(unitedSchemeEntity, callbackHandler, ERR_SAVE_FAIL);
                        r1 = fileOutputStream;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                r1 = fileOutputStream;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                notifyExecuteFail(unitedSchemeEntity, callbackHandler, ERR_SAVE_FAIL);
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
                            notifyExecuteFail(unitedSchemeEntity, callbackHandler, ERR_SAVE_FAIL);
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
    public void notifyExecuteFail(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        AiAppsLog.e(MODULE_TAG, str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(createResult(false, null, str), 0));
    }

    private JSONObject createResult(boolean z, String str, String str2) {
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
