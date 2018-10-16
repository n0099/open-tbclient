package com.baidu.searchbox.ng.ai.apps.screenshot;

import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
/* loaded from: classes2.dex */
public final class AiAppsScreenshot {
    private static final boolean DEBUG = false;
    private static final String EVENT_NAME = "onUserCaptureScreen";
    private static final String TAG = "AiAppsScreenshot";
    private static IAiAppScreenshotCallback sCallback;

    static {
        SystemScreenshotManager.registerScreenshotObserver(AiAppsRuntime.getAppContext());
    }

    public static void registerScreenshotEvent() {
        if (sCallback == null) {
            sCallback = new IAiAppScreenshotCallback() { // from class: com.baidu.searchbox.ng.ai.apps.screenshot.AiAppsScreenshot.1
                @Override // com.baidu.searchbox.ng.ai.apps.screenshot.IAiAppScreenshotCallback
                public void onScreenshot(SystemScreenshotManager.ScreenshotEvent screenshotEvent) {
                    AiAppsScreenshot.dispatchCaptureScreenEvent();
                }
            };
        }
        SystemScreenshotManager.registerCallback(sCallback);
    }

    public static void unRegisterScreenshotEvent() {
        if (sCallback != null) {
            SystemScreenshotManager.unRegisterCallback(sCallback);
            sCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dispatchCaptureScreenEvent() {
        AiAppsController.getInstance().sendJSMessage(new AiAppsCommonMessage(EVENT_NAME));
    }
}
