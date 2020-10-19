package com.baidu.searchbox.process.ipc.delegate.activity;

import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.searchbox.process.ipc.delegate.Delegation;
/* loaded from: classes12.dex */
public abstract class ActivityDelegation extends Delegation<ProcessDelegateBaseActivity> {
    protected abstract boolean onExec();

    public void exec() {
        if (onExec()) {
            finish();
        }
    }

    public void onAgentDestroy() {
    }

    public int getScreenOrientation() {
        return 1;
    }

    public void onAttachedToWindow() {
    }

    public void onSelfFinish() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finish() {
        getAgent().exit();
    }
}
