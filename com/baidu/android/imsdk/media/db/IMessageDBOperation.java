package com.baidu.android.imsdk.media.db;

import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public interface IMessageDBOperation {
    int delMsgs(int i, long j, long[] jArr);

    int deleteAllMsgs(ChatObject chatObject, int i);

    int deleteChatMsg(ChatMsg chatMsg);

    ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3, boolean z);

    ArrayList<ChatMsg> fetchMsg(ChatObject chatObject, long j, long j2, long j3, boolean z, String str);

    ArrayList<ChatMsg> fetchMsgExcludeTypes(ChatObject chatObject, long j, long j2, List<Integer> list);

    ChatMsg getChatMsg(String str, String[] strArr);

    ChatMsg getChatMsg(String str, String[] strArr, String str2, String str3, String str4, String str5);

    long getMaxMsgid();

    ChatMsg getMsg(int i, long j, long j2);

    long insertMsg(ChatMsg chatMsg);

    boolean isMsgExist(ChatMsg chatMsg);

    long replaceChatMsgList(List<ChatMsg> list);

    int setAllMsgRead(int i, long j, long j2);

    int setMsgRead(int i, long j, long j2);

    int updateMsgStatus(ChatMsg chatMsg);
}
