package com.baidu.android.imsdk.utils;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class MsgUtility {
    public static JSONArray listToJsonArray(List<Long> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                jSONArray.put(list.get(i));
            }
        }
        return jSONArray;
    }

    public static boolean isNotice(ChatMsg chatMsg) {
        if (2 == chatMsg.getCategory() || -1 == chatMsg.getMsgType()) {
            return true;
        }
        return (chatMsg.getMsgType() > 1000 && chatMsg.getMsgType() < 1013) || chatMsg.getMsgType() == 2001 || chatMsg.getMsgType() == 2010 || chatMsg.getMsgType() == 22;
    }
}
