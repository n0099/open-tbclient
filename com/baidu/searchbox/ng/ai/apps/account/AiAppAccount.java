package com.baidu.searchbox.ng.ai.apps.account;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.Ability;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.runtime.AiAppComponent;
import com.baidu.searchbox.ng.ai.apps.util.task.Task;
import com.baidu.searchbox.ng.ai.apps.util.task.TaskQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class AiAppAccount extends AiAppComponent implements Ability {
    private final TaskQueue mTaskQueue;

    public AiAppAccount(AiApp aiApp) {
        super(aiApp);
        this.mTaskQueue = new TaskQueue();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean available() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean enable() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public void disable() {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.runtime.Ability
    public boolean enabled() {
        return true;
    }

    private void login(LoginTask loginTask) {
        this.mTaskQueue.offer(loginTask);
    }

    public void login(final Activity activity, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        login(new LoginTask(onAiAppLoginResultListener) { // from class: com.baidu.searchbox.ng.ai.apps.account.AiAppAccount.1
            @Override // com.baidu.searchbox.ng.ai.apps.account.AiAppAccount.LoginTask
            protected void perform(OnAiAppLoginResultListener onAiAppLoginResultListener2) {
                AiAppsRuntime.getAiAppAccountRuntime().login(activity, onAiAppLoginResultListener2);
            }
        });
    }

    public void login(final Activity activity, final String str, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        login(new LoginTask(onAiAppLoginResultListener) { // from class: com.baidu.searchbox.ng.ai.apps.account.AiAppAccount.2
            @Override // com.baidu.searchbox.ng.ai.apps.account.AiAppAccount.LoginTask
            protected void perform(OnAiAppLoginResultListener onAiAppLoginResultListener2) {
                AiAppsRuntime.getAiAppAccountRuntime().login(activity, str, onAiAppLoginResultListener2);
            }
        });
    }

    public void thirdLogin(final Activity activity, final int i, final String str, OnAiAppLoginResultListener onAiAppLoginResultListener) {
        login(new LoginTask(onAiAppLoginResultListener) { // from class: com.baidu.searchbox.ng.ai.apps.account.AiAppAccount.3
            @Override // com.baidu.searchbox.ng.ai.apps.account.AiAppAccount.LoginTask
            protected void perform(OnAiAppLoginResultListener onAiAppLoginResultListener2) {
                AiAppsRuntime.getAiAppAccountRuntime().thirdLogin(activity, i, str, onAiAppLoginResultListener2);
            }
        });
    }

    public boolean isLogin(Context context) {
        return AiAppsRuntime.getAiAppAccountRuntime().isLogin(context);
    }

    public String getBduss(Context context) {
        return AiAppsRuntime.getAiAppAccountRuntime().getBduss(context);
    }

    public String getSession(Context context, String str) {
        return getSession(context, str, "");
    }

    public String getSession(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return getSessions(context, hashMap).get(str);
    }

    public Map<String, String> getSessions(Context context, @NonNull Set<String> set) {
        HashMap hashMap = new HashMap();
        for (String str : set) {
            hashMap.put(str, "");
        }
        return getSessions(context, hashMap);
    }

    public Map<String, String> getSessions(Context context, @NonNull Map<String, String> map) {
        return AiAppsRuntime.getAiAppAccountRuntime().getSessions(context, map);
    }

    @NonNull
    public Bundle getUserInfo(Context context, String str) {
        return AiAppsRuntime.getAiAppAccountRuntime().getUserInfo(context, str);
    }

    /* loaded from: classes2.dex */
    private abstract class LoginTask extends Task implements OnAiAppLoginResultListener {
        private final OnAiAppLoginResultListener wrappedListener;

        protected abstract void perform(OnAiAppLoginResultListener onAiAppLoginResultListener);

        private LoginTask(OnAiAppLoginResultListener onAiAppLoginResultListener) {
            this.wrappedListener = onAiAppLoginResultListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            perform(this);
        }

        @Override // com.baidu.searchbox.ng.ai.apps.account.OnAiAppLoginResultListener
        public void onResult(int i) {
            if (this.wrappedListener != null) {
                this.wrappedListener.onResult(i);
            }
            finish();
        }
    }

    public synchronized void clear() {
        this.mTaskQueue.clear();
    }
}
