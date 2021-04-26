package com.baidu.android.imsdk.box;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.util.io.FileUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class BoxConfig extends DefaultConfig {
    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public int getHeartBeatType() {
        return 1;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public Map<String, Object> getOtherParameters(Context context, ChatMsg chatMsg) {
        HashMap hashMap = new HashMap();
        if (chatMsg != null && chatMsg.isZhida()) {
            hashMap.put("tpl", Integer.valueOf(Constants.getTplZhida(context)));
        }
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public String getProductLineName() {
        return FileUtils.SEARCHBOX_FOLDER;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public String getSubscribeRefApp() {
        return FileUtils.SEARCHBOX_FOLDER;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public String getSubscribeSrcApp() {
        return FileUtils.SEARCHBOX_FOLDER;
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public String getToken(ChatObject chatObject) {
        if (chatObject == null) {
            return null;
        }
        return chatObject.getCategory() + "." + chatObject.getContacter() + "." + chatObject.getType();
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public boolean isMsgTypeSupported(int i2) {
        return BIMManager.isSupportMsgType(i2);
    }

    @Override // com.baidu.android.imsdk.internal.DefaultConfig, com.baidu.android.imsdk.internal.IIMConfig
    public ChatObject parseTokenToChatObject(Context context, String str) {
        String[] tokens = DefaultConfig.getTokens(str, 3);
        try {
            if (tokens.length == 3) {
                return new ChatObject(context, Integer.parseInt(tokens[0]), Long.parseLong(tokens[1]), -1L, Integer.parseInt(tokens[2]));
            }
            return null;
        } catch (Exception e2) {
            LogUtils.e("BoxConfig", "parseTokenToChatObject", e2);
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e2)).build();
            return null;
        }
    }
}
