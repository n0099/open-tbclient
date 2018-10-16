package com.baidu.searchbox.ng.ai.apps.event.message;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.searchbox.ng.ai.apps.event.JSEventDispatcher;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class AiAppsCommonMessage extends AiAppsBaseMessage {
    protected final Map<String, String> mParams;

    public AiAppsCommonMessage(@NonNull String str) {
        this(str, null);
    }

    public AiAppsCommonMessage(@NonNull String str, @Nullable Map<String, String> map) {
        this.mParams = new HashMap();
        this.mEventName = str;
        if (map != null) {
            this.mParams.putAll(map);
        }
    }

    @Override // com.baidu.searchbox.ng.ai.apps.event.message.AiAppsBaseMessage
    public String genSetDataStatement(String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            sb.append(JSEventDispatcher.genJSVarKeyValue(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }
}
