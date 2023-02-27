package com.baidu.searchbox.process.ipc.delegate;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.agent.Agent;
/* loaded from: classes2.dex */
public abstract class Delegation<AgentT extends Agent> {
    @NonNull
    public AgentT mAgent;
    public final Bundle mParams = new Bundle();
    public final Bundle mResult = new Bundle();

    @NonNull
    public AgentT getAgent() {
        return this.mAgent;
    }

    public boolean isLegal() {
        if (this.mAgent != null) {
            return true;
        }
        return false;
    }

    public void setAgent(AgentT agentt) {
        this.mAgent = agentt;
    }
}
