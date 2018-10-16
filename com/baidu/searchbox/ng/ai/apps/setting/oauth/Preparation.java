package com.baidu.searchbox.ng.ai.apps.setting.oauth;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
/* loaded from: classes2.dex */
public abstract class Preparation {
    private Exception mException;
    private OAuthTask mHost;

    protected abstract boolean onPrepare() throws Exception;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Exception getException() {
        return this.mException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Preparation setHost(OAuthTask oAuthTask) {
        this.mHost = oAuthTask;
        return this;
    }

    protected OAuthTask getHost() {
        return this.mHost;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOk() {
        return this.mException == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Preparation prepare() {
        AsyncTask.execute(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (Preparation.this.onPrepare()) {
                        Preparation.this.notifyReady();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Preparation.this.notifyReady(e);
                }
            }
        });
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyReady() {
        notifyReady(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyReady(@Nullable Exception exc) {
        this.mException = exc;
        OAuthUtils.postToMain(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation.2
            @Override // java.lang.Runnable
            public void run() {
                Preparation.this.mHost.onPreparationReady(Preparation.this);
            }
        });
    }
}
