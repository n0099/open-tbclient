package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
/* loaded from: classes.dex */
public class GetPaInfoForSessionHandler extends GetChatObjectInfoForRecordHandler {
    public GetChatObjectInfoForRecordHandler mChatObjectHandler;
    public int mNextTask;

    public GetPaInfoForSessionHandler(Context context) {
        super(context);
        this.mChatObjectHandler = null;
        this.mNextTask = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackChatType(int i, PaInfo paInfo, CallBack callBack) {
        deleteUUid();
        int i2 = 17;
        if (i == 1) {
            i2 = 1;
        } else if (i == 5) {
            i2 = 5;
        } else if (i == 7) {
            i2 = 7;
        } else if (i == 19) {
            i2 = 19;
        } else if (i == 23) {
            i2 = 23;
        } else if (i == 29) {
            i2 = 29;
        } else if (i == 100) {
            i2 = 100;
        } else if (i == 16) {
            i2 = 16;
        } else if (i != 17) {
            switch (i) {
                case 25:
                    i2 = 25;
                    break;
                case 26:
                    i2 = 26;
                    break;
                case 27:
                    i2 = 27;
                    break;
                default:
                    i2 = -1;
                    break;
            }
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
    public void getChatObjectInfo(long j, final CallBack callBack) {
        PaInfo paInfo = PaManagerImpl.getInstance(this.mContext).getPaInfo(j);
        if (paInfo == null) {
            int i = this.mNextTask;
            if (i != -1) {
                GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(this.mContext, 0, j, i);
                this.mChatObjectHandler = getChatObjectInfoForRecordHandler;
                if (getChatObjectInfoForRecordHandler.getChatObjectInfoSync(this.mContext, j, callBack)) {
                    return;
                }
                PaManager.getPaInfo(this.mContext, j, new IGetPaInfoListener() { // from class: com.baidu.android.imsdk.pubaccount.GetPaInfoForSessionHandler.1
                    @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                    public void onGetPaInfoResult(int i2, String str, PaInfo paInfo2) {
                        if (i2 == 0) {
                            LogUtils.d("GetPaInfoForSessionHandler", "painfo=" + paInfo2.toString());
                            GetPaInfoForSessionHandler.this.callBackChatType(paInfo2.getSubtype(), paInfo2, callBack);
                        }
                    }
                });
                return;
            }
            return;
        }
        callBackChatType(paInfo.getSubtype(), paInfo, callBack);
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler;
        if (obj == null) {
            return;
        }
        if (!(obj instanceof PaInfo) && (getChatObjectInfoForRecordHandler = this.mChatObjectHandler) != null) {
            getChatObjectInfoForRecordHandler.updateChatRecord(chatObject, i, i2, obj);
            return;
        }
        PaInfo paInfo = (PaInfo) obj;
        if (TextUtils.isEmpty(paInfo.getNickName()) || paInfo.getPaId() <= 0) {
            return;
        }
        chatObject.setPaid(paInfo.getPaId());
        updateChatRecord(chatObject, paInfo.getNickName(), i, paInfo.getAvatar(), paInfo.getClassType(), paInfo.getClassTitle(), paInfo.getClassavatar(), paInfo.getClassshow(), paInfo.getMarkTop(), paInfo.getMarkTopTime(), paInfo.getShield(), paInfo.getShieldTime(), paInfo.getVipId(), paInfo.getVPortrait(), paInfo.getIdentity());
    }
}
