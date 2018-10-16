package com.baidu.searchbox.ng.ai.apps.env;

import android.content.Context;
import android.support.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.env.Purger;
import com.baidu.searchbox.ng.ai.apps.preload.AiAppsPreloadManager;
import com.baidu.searchbox.ng.ai.apps.swancore.preset.PresetSwanCoreUpdater;
/* loaded from: classes2.dex */
public final class AiAppEnv implements Purger.Holder {
    private static final boolean DEBUG = false;
    public static final String TAG = "AiAppEnv";
    private boolean mFlagInited;
    private Purger mPurger;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Holder {
        static final AiAppEnv sInstance = new AiAppEnv();

        private Holder() {
        }
    }

    private AiAppEnv() {
        this.mFlagInited = false;
        this.mPurger = new Purger(this);
        PresetSwanCoreUpdater.getInstance().updateSwanCoreAsync(null);
    }

    public static AiAppEnv get() {
        return Holder.sInstance;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.env.ContextProvider
    @NonNull
    public Context requireContext() {
        return AppRuntime.getAppContext();
    }

    public void initIfNecessary() {
        if (!this.mFlagInited) {
            synchronized (this) {
                if (!this.mFlagInited) {
                    onInit();
                    this.mFlagInited = true;
                }
            }
        }
    }

    public Purger getPurger() {
        return this.mPurger;
    }

    private void onInit() {
        AiAppsPreloadManager.preloadAiAppsZygoteProcess(requireContext());
    }
}
