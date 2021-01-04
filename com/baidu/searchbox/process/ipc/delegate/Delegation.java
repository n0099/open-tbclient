package com.baidu.searchbox.process.ipc.delegate;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.agent.Agent;
/* loaded from: classes5.dex */
public abstract class Delegation<AgentT extends Agent> {
    @NonNull
    AgentT mAgent;
    public final Bundle mParams = new Bundle();
    public final Bundle mResult = new Bundle();

    public boolean isLegal() {
        return this.mAgent != null;
    }

    public void setAgent(AgentT agentt) {
        this.mAgent = agentt;
    }

    @NonNull
    public AgentT getAgent() {
        return this.mAgent;
    }
}
