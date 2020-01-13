package com.baidu.searchbox.ugc.view;

import android.view.View;
import com.baidu.searchbox.NoProGuard;
/* loaded from: classes12.dex */
public interface IUgcPublishPanel extends NoProGuard {

    /* loaded from: classes12.dex */
    public interface IPluginProvider extends NoProGuard {
        int getDialogStyle();

        void onPublish();
    }

    View getView();

    void hideInputPanel();

    boolean isInputEdited();

    void onCreate();

    void onDestroy();

    void onResume();

    void onStop();

    void publish(String str);

    void setEmojiVisibility(boolean z);

    void setPluginProvider(IPluginProvider iPluginProvider);
}
