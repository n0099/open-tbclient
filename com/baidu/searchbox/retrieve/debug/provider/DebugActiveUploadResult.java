package com.baidu.searchbox.retrieve.debug.provider;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult;
import org.json.JSONObject;
@Service
/* loaded from: classes4.dex */
public class DebugActiveUploadResult implements IActiveUploadResult {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String SOURCE = "test";
    public static final String TAG = "FetchLogDebug";

    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult
    public String getSource() {
        return SOURCE;
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult
    public void onFailure(final String str, JSONObject jSONObject) {
        if (DEBUG) {
            Log.d(TAG, "msg: " + str);
            Log.d(TAG, "extInfo: " + jSONObject.toString());
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult.2
                @Override // java.lang.Runnable
                public void run() {
                    Context appContext = AppRuntime.getAppContext();
                    Toast.makeText(appContext, "主动上传失败 " + str, 1).show();
                }
            });
        }
    }

    @Override // com.baidu.searchbox.retrieve.inter.upload.IActiveUploadResult
    public void onSuccess(String str, JSONObject jSONObject) {
        if (DEBUG) {
            Log.d(TAG, "msg: " + str);
            Log.d(TAG, "extInfo: " + jSONObject.toString());
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(AppRuntime.getAppContext(), "主动上传成功 ", 1).show();
            }
        });
    }
}
