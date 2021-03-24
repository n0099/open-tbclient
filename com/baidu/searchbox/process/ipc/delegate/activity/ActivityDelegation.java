package com.baidu.searchbox.process.ipc.delegate.activity;

import com.baidu.searchbox.process.ipc.agent.activity.ProcessDelegateBaseActivity;
import com.baidu.searchbox.process.ipc.delegate.Delegation;
/* loaded from: classes3.dex */
public abstract class ActivityDelegation extends Delegation<ProcessDelegateBaseActivity> {
    public void exec() {
        if (onExec()) {
            finish();
        }
    }

    public void finish() {
        getAgent().exit();
    }

    public int getScreenOrientation() {
        return 1;
    }

    public void onAgentDestroy() {
    }

    public void onAttachedToWindow() {
    }

    public abstract boolean onExec();

    public void onSelfFinish() {
    }
}
