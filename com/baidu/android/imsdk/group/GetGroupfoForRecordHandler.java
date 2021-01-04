package com.baidu.android.imsdk.group;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.shield.IGetShieldAndTopListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GetGroupfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public GetGroupfoForRecordHandler(Context context) {
        super(context);
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(final long j, final CallBack callBack) {
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
        LogUtils.d("GetGroupfoForRecordHandler", "STAR Recordhandler get groupinfo " + j);
        GroupManagerImpl.getInstance(this.mContext).getGroupsInfo(1, arrayList, new BIMValueCallBack<ArrayList<GroupInfo>>() { // from class: com.baidu.android.imsdk.group.GetGroupfoForRecordHandler.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i, String str, final ArrayList<GroupInfo> arrayList2) {
                if (i == 0) {
                    GetGroupfoForRecordHandler.this.deleteUUid();
                    if (arrayList2.size() != 0) {
                        ShieldAndTopManager.getInstance(GetGroupfoForRecordHandler.this.mContext).getSingleContacterSetting(j, 3, new IGetShieldAndTopListener() { // from class: com.baidu.android.imsdk.group.GetGroupfoForRecordHandler.1.1
                            @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                            public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                                if (getShieldAndTopResult.getErrorCode() == 0 && arrayList2.get(0) != null) {
                                    GroupInfoDAOImpl.updateGroupMarkTop(GetGroupfoForRecordHandler.this.mContext, Long.parseLong(((GroupInfo) arrayList2.get(0)).getGroupId()), getShieldAndTopResult.getMarkTop(), getShieldAndTopResult.getMarkTopTime());
                                }
                                callBack.onSuccess(3, 1, arrayList2.get(0));
                            }
                        });
                        return;
                    }
                    LogUtils.e(" ", "STAR Recordhandler get groupinfo size is 0");
                    callBack.onError(3, 1, 0L);
                }
            }
        });
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        if (obj != null && (obj instanceof GroupInfo)) {
            LogUtils.d("GetGroupfoForRecordHandler", "RECORDSESSION updatechatrecord " + obj.toString());
            GroupInfo groupInfo = (GroupInfo) obj;
            updateChatRecord(chatObject, groupInfo.getGroupName(), groupInfo.getType() == 2 ? 4 : i, "", 0, "", "", 0, groupInfo.getMarkTop(), groupInfo.getMarkTopTime(), 0, 0L, "", "", "");
        }
    }
}
