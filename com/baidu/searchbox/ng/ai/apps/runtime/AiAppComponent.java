package com.baidu.searchbox.ng.ai.apps.runtime;

import android.content.ContextWrapper;
/* loaded from: classes2.dex */
public abstract class AiAppComponent extends ContextWrapper implements AiAppProvider {
    public AiAppComponent(AiApp aiApp) {
        super(aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.AiAppProvider
    public AiApp requireAiApp() {
        return (AiApp) getBaseContext();
    }

    public void onDestory() {
    }
}
