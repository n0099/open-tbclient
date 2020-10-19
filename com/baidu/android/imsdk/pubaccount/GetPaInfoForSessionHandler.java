package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes5.dex */
public class GetPaInfoForSessionHandler extends GetChatObjectInfoForRecordHandler {
    private GetChatObjectInfoForRecordHandler mChatObjectHandler;
    int mNextTask;

    public GetPaInfoForSessionHandler(Context context) {
        super(context);
        this.mChatObjectHandler = null;
        this.mNextTask = 1;
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j, final CallBack callBack) {
        PaInfo paInfo = PaManagerImpl.getInstance(this.mContext).getPaInfo(j);
        if (paInfo == null) {
            if (this.mNextTask != -1) {
                this.mChatObjectHandler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(this.mContext, 0, j, this.mNextTask);
                if (!this.mChatObjectHandler.getChatObjectInfoSync(this.mContext, j, callBack)) {
                    PaManager.getPaInfo(this.mContext, j, new IGetPaInfoListener() { // from class: com.baidu.android.imsdk.pubaccount.GetPaInfoForSessionHandler.1
                        @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                        public void onGetPaInfoResult(int i, String str, PaInfo paInfo2) {
                            if (i == 0) {
                                LogUtils.d("GetPaInfoForSessionHandler", "painfo=" + paInfo2.toString());
                                GetPaInfoForSessionHandler.this.callBackChatType(paInfo2.getSubtype(), paInfo2, callBack);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        callBackChatType(paInfo.getSubtype(), paInfo, callBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackChatType(int i, PaInfo paInfo, CallBack callBack) {
        int i2;
        deleteUUid();
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 5:
                i2 = 5;
                break;
            case 7:
                i2 = 7;
                break;
            case 16:
                i2 = 16;
                break;
            case 17:
                i2 = 17;
                break;
            case 19:
                i2 = 19;
                break;
            case 23:
                i2 = 23;
                break;
            case 25:
                i2 = 25;
                break;
            case 26:
                i2 = 26;
                break;
            case 27:
                i2 = 27;
                break;
            case 29:
                i2 = 29;
                break;
            case 100:
                i2 = 100;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1 || !Utility.availableNotificationPaType(i)) {
            i = i2;
        }
        if (i != -1) {
            callBack.onSuccess(i, 0, paInfo);
        } else {
            LogUtils.d("GetPaInfoForSessionHandler", "pa type as default -1");
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        if (obj != null) {
            if (!(obj instanceof PaInfo) && this.mChatObjectHandler != null) {
                this.mChatObjectHandler.updateChatRecord(chatObject, i, i2, obj);
                return;
            }
            PaInfo paInfo = (PaInfo) obj;
            if (!TextUtils.isEmpty(paInfo.getNickName()) && paInfo.getPaId() > 0) {
                chatObject.setPaid(paInfo.getPaId());
                updateChatRecord(chatObject, paInfo.getNickName(), i, paInfo.getAvatar(), paInfo.getClassType(), paInfo.getClassTitle(), paInfo.getClassavatar(), paInfo.getClassshow(), paInfo.getMarkTop(), paInfo.getMarkTopTime(), paInfo.getShield(), paInfo.getShieldTime(), paInfo.getVipId(), paInfo.getVPortrait(), paInfo.getIdentity());
            }
        }
    }
}
