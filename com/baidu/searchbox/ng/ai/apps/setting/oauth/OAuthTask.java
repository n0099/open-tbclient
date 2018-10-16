package com.baidu.searchbox.ng.ai.apps.setting.oauth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class OAuthTask<ResultDataT> implements OAuthErrorCode {
    public static final boolean DEBUG = false;
    public final TaskResult<ResultDataT> mResult = new TaskResult<>();
    private final Set<TypedCallback<TaskResult<ResultDataT>>> mCallbacks = new HashSet();
    private final LinkedList<Preparation> mPreparations = new LinkedList<>();
    private boolean mFlagInitialPrepared = false;
    private boolean mFlagFinalPrepared = false;

    protected abstract void onExec();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ResultDataT parse(JSONObject jSONObject) throws JSONException;

    private void initialPrepare() {
        new Preparation() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask.1
            @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
            protected boolean onPrepare() throws Exception {
                if (!OAuthTask.this.onInitialPrepare()) {
                    throw new OAuthException("initialPrepare failed", 10001);
                }
                return true;
            }
        }.setHost(this).prepare();
        this.mFlagInitialPrepared = true;
    }

    private void finalPrepare() {
        new Preparation() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask.2
            @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.Preparation
            protected boolean onPrepare() throws Exception {
                if (!OAuthTask.this.onFinalPrepare()) {
                    throw new OAuthException("finalPrepare failed", 10001);
                }
                return true;
            }
        }.setHost(this).prepare();
        this.mFlagFinalPrepared = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onInitialPrepare() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean onFinalPrepare() {
        return true;
    }

    public OAuthTask<ResultDataT> regCallback(TypedCallback<TaskResult<ResultDataT>> typedCallback) {
        if (this.mResult.mStatus.isCallbackAvailable()) {
            this.mCallbacks.add(typedCallback);
        }
        return this;
    }

    private void notifyCallbacks() {
        for (final TypedCallback<TaskResult<ResultDataT>> typedCallback : this.mCallbacks) {
            OAuthUtils.postToMain(new Runnable() { // from class: com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask.3
                @Override // java.lang.Runnable
                public void run() {
                    if (typedCallback != null) {
                        typedCallback.onCallback(OAuthTask.this.mResult);
                    }
                }
            });
        }
    }

    @NonNull
    public OAuthTask call() {
        if (TaskState.INIT == getStatus()) {
            updateStatus(TaskState.CALLING);
            prepare();
        }
        return this;
    }

    public TaskState getStatus() {
        return this.mResult.mStatus;
    }

    public OAuthTask offerPreparation(@NonNull Preparation preparation) {
        preparation.setHost(this);
        this.mPreparations.offer(preparation);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onPreparationReady(Preparation preparation) {
        if (preparation.isOk()) {
            prepare();
        } else {
            finish(preparation.getException());
        }
    }

    private void prepare() {
        if (TaskState.CALLING.equals(getStatus())) {
            if (!this.mFlagInitialPrepared) {
                initialPrepare();
            } else if (!this.mPreparations.isEmpty()) {
                this.mPreparations.poll().prepare();
            } else if (!this.mFlagFinalPrepared) {
                finalPrepare();
            } else {
                exec();
            }
        }
    }

    private synchronized void exec() {
        onExec();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateResultData(ResultDataT resultdatat) {
        this.mResult.mData = resultdatat;
    }

    private void updateStatus(TaskState taskState) {
        this.mResult.mStatus = taskState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        finish(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish(@Nullable Exception exc) {
        if (exc instanceof OAuthException) {
            this.mResult.mException = (OAuthException) exc;
        } else if (exc != null) {
            this.mResult.mException = new OAuthException(exc, 11001);
        }
        if (!this.mResult.isOk()) {
        }
        updateStatus(TaskState.FINISHED);
        OAuthUtils.log(toString(), false);
        notifyCallbacks();
        this.mCallbacks.clear();
    }
}
