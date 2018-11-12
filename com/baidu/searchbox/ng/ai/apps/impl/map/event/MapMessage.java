package com.baidu.searchbox.ng.ai.apps.impl.map.event;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.event.message.AiAppsCommonMessage;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class MapMessage extends AiAppsCommonMessage {
    public static final String EVENT_DATA = "data";
    public static final String EVENT_NAME = "map";
    public static final String EVENT_TYPE = "vtype";
    public static final String WEB_VIEW_ID = "wvID";

    private MapMessage() {
        super("map");
    }

    private MapMessage(@Nullable Map<String, String> map) {
        super("map", map);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void sendMessage() {
        AiAppsController.getInstance().sendJSMessage(this);
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private HashMap<String, String> params = new HashMap<>();

        Builder() {
        }

        public MapMessage build() {
            return new MapMessage(this.params);
        }

        public Builder put(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                this.params.put(str, str2);
            }
            return this;
        }
    }
}
