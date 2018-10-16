package cn.jpush.android.api;

import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlavePool;
/* loaded from: classes3.dex */
public final class e {
    private static int b = 400;
    private static int c = AiAppsSlavePool.PRELOAD_NEXT_DELAY_MS;
    public static cn.jpush.android.e.a.e a = null;

    public static void a(WindowManager windowManager, WebView webView, ImageButton imageButton) {
        windowManager.removeView(webView);
        windowManager.removeView(imageButton);
    }
}
