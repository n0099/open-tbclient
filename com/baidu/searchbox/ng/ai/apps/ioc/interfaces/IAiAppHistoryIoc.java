package com.baidu.searchbox.ng.ai.apps.ioc.interfaces;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.GetSwanHistoryAction;
/* loaded from: classes2.dex */
public interface IAiAppHistoryIoc {
    void getSwanHistory(GetSwanHistoryAction.OnSwanHistoryListener onSwanHistoryListener);

    boolean removeSwanHistory(String str, boolean z);

    void saveAiAppInHistory(Context context, AiApp aiApp);
}
