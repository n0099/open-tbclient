package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.widget.Toast;
import com.baidu.searchbox.ng.ai.apps.R;
import com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.swancore.debug.DebugSwanCoreControl;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import java.io.File;
/* loaded from: classes2.dex */
public class DebugSwanCoreAction extends AiAppAction {
    private static final String ACTION_NAME = "/swan/debugSwanCore";
    private static final boolean DEBUG = false;
    private static final String PARAM_DOWNLOAD_URL_KEY = "downloadurl";

    public DebugSwanCoreAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    /* renamed from: com.baidu.searchbox.ng.ai.apps.scheme.actions.DebugSwanCoreAction$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements AiAppsBundleHelper.InternalUseDownloadCb {
        AnonymousClass1() {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper.InternalUseDownloadCb
        public void onProgressChanged(int i) {
        }

        @Override // com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper.InternalUseDownloadCb
        public void onSuccess() {
            File downloadTargetFilePath = DebugSwanCoreControl.getDownloadTargetFilePath();
            File debugDirFile = DebugSwanCoreControl.getDebugDirFile();
            if (downloadTargetFilePath.exists() && AiAppsFileUtils.unzipFile(downloadTargetFilePath.getPath(), debugDirFile.getPath())) {
                Toast.makeText(AiAppsRuntime.getAppContext(), R.string.aiapps_debug_swan_core_download_success, 1).show();
            } else {
                Toast.makeText(AiAppsRuntime.getAppContext(), R.string.aiapps_debug_swan_core_download_failed, 1).show();
            }
        }

        @Override // com.baidu.searchbox.ng.ai.apps.install.AiAppsBundleHelper.InternalUseDownloadCb
        public void onFailed() {
            Toast.makeText(AiAppsRuntime.getAppContext(), R.string.aiapps_debug_swan_core_download_failed, 1).show();
        }
    }
}
