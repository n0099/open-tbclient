package com.baidu.graph.sdk.framework;

import android.graphics.Bitmap;
import com.baidu.graph.sdk.framework.bdbox.IBDBoxPluginInvoker;
import com.baidu.graph.sdk.ui.IFragmentCallback;
/* loaded from: classes3.dex */
public interface IExtFragmentCallback extends IFragmentCallback {

    /* loaded from: classes3.dex */
    public interface BottomBarClickListener {

        /* loaded from: classes3.dex */
        public enum BottomButton {
            back
        }

        void click(BottomButton bottomButton);
    }

    /* loaded from: classes3.dex */
    public enum ExtEvent {
        Click_Button,
        Log
    }

    boolean bottomBarVisibility(int i, BottomBarClickListener bottomBarClickListener);

    String commonParams(String str);

    void extEventListener(ExtEvent extEvent, String... strArr);

    Bitmap getPreviewBitmap();

    IBDBoxPluginInvoker pluginInvokerProxy();

    void setPreviewBitmap(Bitmap bitmap);
}
