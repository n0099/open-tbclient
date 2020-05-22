package com.baidu.swan.apps.adaptation.a;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface f {
    boolean a(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler);

    boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull com.baidu.swan.apps.adlanding.download.a.a aVar);

    boolean h(Context context, JSONObject jSONObject);

    /* loaded from: classes11.dex */
    public static class a implements f {
        private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
        private static final String TAG = a.class.getSimpleName();

        @Override // com.baidu.swan.apps.adaptation.a.f
        public boolean h(Context context, JSONObject jSONObject) {
            return i(context, jSONObject);
        }

        @Override // com.baidu.swan.apps.adaptation.a.f
        public boolean a(@NonNull Context context, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull JSONObject jSONObject, @NonNull CallbackHandler callbackHandler) {
            return i(context, jSONObject);
        }

        @Override // com.baidu.swan.apps.adaptation.a.f
        public boolean a(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull com.baidu.swan.apps.adlanding.download.a.a aVar) {
            return i(context, jSONObject);
        }

        private boolean i(final Context context, JSONObject jSONObject) {
            final String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), "download url is empty");
                return false;
            }
            com.baidu.swan.apps.ad.a.a("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, new com.baidu.swan.apps.ad.b() { // from class: com.baidu.swan.apps.adaptation.a.f.a.1
                @Override // com.baidu.swan.apps.ad.b
                public void gY(String str) {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(optString));
                    request.setDestinationInExternalPublicDir("", optString.substring(optString.lastIndexOf("/") + 1));
                    DownloadManager downloadManager = (DownloadManager) AppRuntime.getAppContext().getSystemService("download");
                    if (downloadManager != null) {
                        downloadManager.enqueue(request);
                        com.baidu.swan.apps.aq.d.startActivitySafely(context, new Intent("android.intent.action.VIEW_DOWNLOADS"));
                    }
                }

                @Override // com.baidu.swan.apps.ad.b
                public void M(int i, String str) {
                    if (a.DEBUG) {
                        Log.d(a.TAG, "onAuthorizedFailed,  errorCode: " + i + " errorMsg: " + str);
                    }
                }
            });
            return true;
        }
    }
}
