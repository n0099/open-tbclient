package com.baidu.android.imsdk.internal;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.Map;
/* loaded from: classes3.dex */
public class DefaultConfig implements IIMConfig {
    public static final String TOKEN_SEPARATOR = ".";
    private boolean mRootComplete = true;

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public ChatObject parseTokenToChatObject(Context context, String str) {
        String[] tokens = getTokens(str, 3);
        try {
            if (tokens.length == 3) {
                return new ChatObject(context, Integer.parseInt(tokens[0]), Long.parseLong(tokens[1]), -1L, Integer.parseInt(tokens[2]));
            }
        } catch (Exception e) {
            new IMTrack.CrashBuilder(context).exception(Log.getStackTraceString(e)).build();
            LogUtils.e("CRMConfig", "parseTokenToChatObject", e);
        }
        return null;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getToken(ChatObject chatObject) {
        if (chatObject == null) {
            return null;
        }
        return chatObject.getCategory() + "." + chatObject.getContacter() + "." + chatObject.getType();
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public boolean isMsgTypeSupported(int i) {
        return true;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public Map<String, Object> getOtherParameters(Context context, ChatMsg chatMsg) {
        return null;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public int getHeartBeatType() {
        return 0;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public void setRootComplete(boolean z) {
        this.mRootComplete = z;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public boolean getRootComplete() {
        return this.mRootComplete;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getPaidCondition(String str, String str2, long j) {
        return str;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getSubscribeSrcApp() {
        return "";
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getSubscribeRefApp() {
        return "";
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getBduss(Context context) {
        return AccountManagerImpl.getInstance(context).getToken();
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public String getProductLineName() {
        return "main";
    }

    public static String[] getTokens(String str, int i) {
        String[] split = str.split("\\.");
        if (split == null || split.length != i) {
            return new String[0];
        }
        return split;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public boolean isNeedPaid() {
        return false;
    }

    @Override // com.baidu.android.imsdk.internal.IIMConfig
    public boolean isCategorySupported() {
        return false;
    }
}
