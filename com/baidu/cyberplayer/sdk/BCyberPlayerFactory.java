package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.internal.CyberPlayerEngineManager;
import com.baidu.cyberplayer.sdk.internal.GlobalConstants;
import com.baidu.cyberplayer.sdk.internal.IProxyFactoryBridge;
import com.baidu.cyberplayer.sdk.internal.IVideoViewBridge;
import com.baidu.cyberplayer.sdk.internal.IVideoViewControllerBridge;
import com.baidu.cyberplayer.sdk.internal.LogUtils;
import com.baidu.cyberplayer.sdk.internal.ReflectUtils;
import com.baidu.cyberplayer.sdk.internal.ReflectUtilsCyberPlayer;
/* loaded from: classes.dex */
public class BCyberPlayerFactory {

    /* renamed from: a  reason: collision with root package name */
    private static Context f880a = null;

    /* renamed from: a  reason: collision with other field name */
    private static IProxyFactoryBridge f0a = null;

    public static String getSdkVersion() {
        return GlobalConstants.INNER_VERSION;
    }

    public static void init(Context context) {
        LogUtils.w("BCyberPlayerFactory", "sdk version: " + getSdkVersion(), new Object[0]);
        f880a = context.getApplicationContext();
    }

    public static BEngineManager createEngineManager() {
        return CyberPlayerEngineManager.getInstance(f880a);
    }

    public static IProxyFactoryBridge getProxyFactory() {
        if (f0a == null) {
            f0a = (IProxyFactoryBridge) ReflectUtils.invokeStaticWithResult(ReflectUtilsCyberPlayer.loadClass("com.baidu.cyberplayer.engine.ProxyFactory"), "getInstance", null, null, null);
        }
        return f0a;
    }

    public static void resetProxyFactory() {
        f0a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IVideoViewBridge a(Context context, BVideoView bVideoView) {
        return getProxyFactory().createVideoViewProxy(context, bVideoView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IVideoViewBridge a(Context context, AttributeSet attributeSet, BVideoView bVideoView) {
        return getProxyFactory().createVideoViewProxy(context, attributeSet, bVideoView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IVideoViewBridge a(Context context, AttributeSet attributeSet, int i, BVideoView bVideoView) {
        return getProxyFactory().createVideoViewProxy(context, attributeSet, i, bVideoView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IVideoViewControllerBridge a(Context context, BMediaController bMediaController) {
        return getProxyFactory().createVideoViewControllerProxy(context, bMediaController);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IVideoViewControllerBridge a(Context context, AttributeSet attributeSet, BMediaController bMediaController) {
        return getProxyFactory().createVideoViewControllerProxy(context, attributeSet, bMediaController);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IVideoViewControllerBridge a(Context context, AttributeSet attributeSet, int i, BMediaController bMediaController) {
        return getProxyFactory().createVideoViewControllerProxy(context, attributeSet, i, bMediaController);
    }
}
