package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.ChatMsgManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatuser.db.IMUserManager;
import com.baidu.android.imsdk.chatuser.request.IMGetMemberListRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class UpdateChatSessionNickNameTask implements Runnable {
    private Context mContext;

    public UpdateChatSessionNickNameTask(Context context) {
        this.mContext = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        arrayList.add(0);
        ArrayList<ChatSession> chatRecords = ChatMsgManager.getChatRecords(this.mContext, arrayList);
        if (chatRecords != null) {
            Iterator<ChatSession> it = chatRecords.iterator();
            while (it.hasNext()) {
                long contacter = it.next().getContacter();
                long buidByUK = IMUserManager.getInstance(this.mContext).getBuidByUK(contacter);
                if (contacter > -1 && buidByUK > -1 && !hashMap.keySet().contains(buidByUK + "")) {
                    hashMap.put(buidByUK + "", Long.valueOf(contacter));
                }
            }
            if (hashMap != null && hashMap.size() > 0) {
                IMGetMemberListRequest iMGetMemberListRequest = new IMGetMemberListRequest(this.mContext, hashMap, true);
                HttpHelper.executor(this.mContext, iMGetMemberListRequest, iMGetMemberListRequest);
            }
        }
    }
}
