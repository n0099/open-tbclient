package com.baidu.android.imsdk.group;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class GetGroupfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public GetGroupfoForRecordHandler(Context context) {
        super(context);
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j, final CallBack callBack) {
        if (IMConfigInternal.getInstance().getProductLine(this.mContext) == 4) {
            deleteUUid();
            if (callBack != null) {
                GroupInfo groupInfo = new GroupInfo(String.valueOf(j));
                groupInfo.setDescription("no");
                groupInfo.setGroupName("no");
                groupInfo.setType(3);
                callBack.onSuccess(3, 1, groupInfo);
                return;
            }
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(String.valueOf(j));
        LogUtils.d(HanziToPinyin.Token.SEPARATOR, "STAR Recordhandler get groupinfo " + j);
        GroupManagerImpl.getInstance(this.mContext).getGroupsInfo(1, arrayList, new BIMValueCallBack<ArrayList<GroupInfo>>() { // from class: com.baidu.android.imsdk.group.GetGroupfoForRecordHandler.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i, String str, ArrayList<GroupInfo> arrayList2) {
                if (i == 0) {
                    GetGroupfoForRecordHandler.this.deleteUUid();
                    if (arrayList2.size() == 0) {
                        LogUtils.e(HanziToPinyin.Token.SEPARATOR, "STAR Recordhandler get groupinfo size is 0");
                        callBack.onError(3, 1, 0L);
                        return;
                    }
                    callBack.onSuccess(3, 1, arrayList2.get(0));
                }
            }
        });
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        if (obj != null && (obj instanceof GroupInfo)) {
            LogUtils.d(HanziToPinyin.Token.SEPARATOR, "RECORDSESSION updatechatrecord " + obj.toString());
            GroupInfo groupInfo = (GroupInfo) obj;
            updateChatRecord(chatObject, groupInfo.getGroupName(), groupInfo.getType() == 2 ? 4 : i, "", 0, "", "", 0, 0, 0L);
        }
    }
}
