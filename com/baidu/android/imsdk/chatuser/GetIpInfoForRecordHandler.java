package com.baidu.android.imsdk.chatuser;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class GetIpInfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public GetIpInfoForRecordHandler(Context context) {
        super(context);
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j, final CallBack callBack) {
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j));
        ChatUserManagerImpl.getInstance(this.mContext).getUserIp(0, arrayList, new IGetUserIpListener() { // from class: com.baidu.android.imsdk.chatuser.GetIpInfoForRecordHandler.1
            @Override // com.baidu.android.imsdk.chatuser.IGetUserIpListener
            public void onGetUserIpResult(int i, String str, ArrayList<Long> arrayList2, ArrayList<IpInfo> arrayList3) {
                if (i == 0 && arrayList2 != null && arrayList2.size() == 1 && arrayList3 != null && arrayList3.size() != 0) {
                    long longValue = arrayList2.get(0).longValue();
                    GetIpInfoForRecordHandler.this.deleteUUid();
                    if (i == 0) {
                        callBack.onSuccess(10, 0, arrayList3.get(0));
                    } else {
                        callBack.onError(10, 0, longValue);
                    }
                }
            }
        });
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        if (obj != null && (obj instanceof IpInfo)) {
            updateChatRecord(chatObject, Utility.createAnonyMousUserName((IpInfo) obj), 0, "", 0, "", "", 0, 0, 0L);
        }
    }
}
