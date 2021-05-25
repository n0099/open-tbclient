package com.baidu.android.imsdk.group;

import android.content.Context;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.group.db.GroupInfoDAOImpl;
import com.baidu.android.imsdk.shield.IGetShieldAndTopListener;
import com.baidu.android.imsdk.shield.ShieldAndTopManager;
import com.baidu.android.imsdk.shield.model.GetShieldAndTopResult;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class GetFansGroupInfoForRecordHandler extends GetChatObjectInfoForRecordHandler {
    public static final String TAG = "GetFansGroupInfoForRecordHandler";

    public GetFansGroupInfoForRecordHandler(Context context) {
        super(context);
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(final long j, final CallBack callBack) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(String.valueOf(j));
        LogUtils.d(TAG, "getChatObjectInfo " + j);
        GroupManagerImpl.getInstance(this.mContext).getFansGroupInfo(arrayList, true, new BIMValueCallBack<ArrayList<GroupInfo>>() { // from class: com.baidu.android.imsdk.group.GetFansGroupInfoForRecordHandler.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.android.imsdk.group.BIMValueCallBack
            public void onResult(int i2, String str, final ArrayList<GroupInfo> arrayList2) {
                if (i2 == 0) {
                    GetFansGroupInfoForRecordHandler.this.deleteUUid();
                    if (arrayList2.size() != 0) {
                        ShieldAndTopManager.getInstance(GetFansGroupInfoForRecordHandler.this.mContext).getSingleContacterSetting(j, 57, new IGetShieldAndTopListener() { // from class: com.baidu.android.imsdk.group.GetFansGroupInfoForRecordHandler.1.1
                            @Override // com.baidu.android.imsdk.shield.IGetShieldAndTopListener
                            public void onResult(GetShieldAndTopResult getShieldAndTopResult) {
                                if (getShieldAndTopResult.getErrorCode() == 0 && arrayList2.get(0) != null) {
                                    GroupInfo groupInfo = (GroupInfo) arrayList2.get(0);
                                    groupInfo.setMarkTop(getShieldAndTopResult.getMarkTop());
                                    groupInfo.setMarkTopTime(getShieldAndTopResult.getMarkTopTime());
                                    GroupInfoDAOImpl.updateGroupMarkTop(GetFansGroupInfoForRecordHandler.this.mContext, Utility.getLongByString(groupInfo.getGroupId(), 0L), getShieldAndTopResult.getMarkTop(), getShieldAndTopResult.getMarkTopTime());
                                }
                                callBack.onSuccess(57, 1, arrayList2.get(0));
                            }
                        });
                        return;
                    }
                    LogUtils.e(GetFansGroupInfoForRecordHandler.TAG, "getChatObjectInfo get groupinfo size is 0");
                    callBack.onError(57, 1, 0L);
                }
            }
        });
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i2, int i3, Object obj) {
        if (obj instanceof GroupInfo) {
            LogUtils.d(TAG, "updateChatRecord " + obj.toString());
            GroupInfo groupInfo = (GroupInfo) obj;
            updateChatRecord(chatObject, groupInfo.getGroupName(), i2, groupInfo.getHeadUrl(), 0, "", "", 0, groupInfo.getMarkTop(), groupInfo.getMarkTopTime(), 0, 0L, "", "", "");
        }
    }
}
