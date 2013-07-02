package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.cyberplayer.sdk.BMediaController;
import com.baidu.cyberplayer.sdk.BVideoView;
/* loaded from: classes.dex */
public interface IProxyFactoryBridge {
    ICyberPlayerEngineInitBridge createCyberPlayerEngineInitProxy();

    ICyberPlayerEngineVersionBridge createCyberPlayerEngineVersionProxy();

    IVideoViewControllerBridge createVideoViewControllerProxy(Context context, AttributeSet attributeSet, int i, BMediaController bMediaController);

    IVideoViewControllerBridge createVideoViewControllerProxy(Context context, AttributeSet attributeSet, BMediaController bMediaController);

    IVideoViewControllerBridge createVideoViewControllerProxy(Context context, BMediaController bMediaController);

    IVideoViewBridge createVideoViewProxy(Context context, AttributeSet attributeSet, int i, BVideoView bVideoView);

    IVideoViewBridge createVideoViewProxy(Context context, AttributeSet attributeSet, BVideoView bVideoView);

    IVideoViewBridge createVideoViewProxy(Context context, BVideoView bVideoView);
}
