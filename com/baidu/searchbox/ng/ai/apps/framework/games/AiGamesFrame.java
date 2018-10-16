package com.baidu.searchbox.ng.ai.apps.framework.games;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import com.baidu.searchbox.ng.ai.apps.AiAppsActivity;
import com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
/* loaded from: classes2.dex */
public class AiGamesFrame extends AiAppsBaseFrame {
    public AiGamesFrame(AiAppsActivity aiAppsActivity) {
        super(aiAppsActivity);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    public void onNewIntent(Intent intent) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.framework.AiAppsBaseFrame
    @NonNull
    protected AiAppsMessengerClient.OnHandleMessageCallback getMessageCallback() {
        return new AiAppsMessengerClient.OnHandleMessageCallback() { // from class: com.baidu.searchbox.ng.ai.apps.framework.games.AiGamesFrame.1
            @Override // com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient.OnHandleMessageCallback
            public boolean onHandleMessage(Message message) {
                return false;
            }
        };
    }
}
