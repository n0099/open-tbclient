package com.baidu.android.imsdk.pubaccount;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.CallBack;
import com.baidu.android.imsdk.ChatObject;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler;
import com.baidu.android.imsdk.GetChatObjectInfoForRecordManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class GetPaInfoForSessionHandler extends GetChatObjectInfoForRecordHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public GetChatObjectInfoForRecordHandler mChatObjectHandler;
    public int mNextTask;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPaInfoForSessionHandler(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mChatObjectHandler = null;
        this.mNextTask = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackChatType(int i, PaInfo paInfo, CallBack callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, this, i, paInfo, callBack) == null) {
            deleteUUid();
            int i2 = 17;
            if (i != 1) {
                if (i != 5) {
                    if (i != 7) {
                        if (i != 19) {
                            if (i != 23) {
                                if (i != 29) {
                                    if (i != 100) {
                                        if (i != 16) {
                                            if (i != 17) {
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
                                        } else {
                                            i2 = 16;
                                        }
                                    } else {
                                        i2 = 100;
                                    }
                                } else {
                                    i2 = 29;
                                }
                            } else {
                                i2 = 23;
                            }
                        } else {
                            i2 = 19;
                        }
                    } else {
                        i2 = 7;
                    }
                } else {
                    i2 = 5;
                }
            } else {
                i2 = 1;
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
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j, CallBack callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j, callBack) == null) {
            PaInfo paInfo = PaManagerImpl.getInstance(this.mContext).getPaInfo(j);
            if (paInfo == null) {
                int i = this.mNextTask;
                if (i != -1) {
                    GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(this.mContext, 0, j, i);
                    this.mChatObjectHandler = getChatObjectInfoForRecordHandler;
                    if (!getChatObjectInfoForRecordHandler.getChatObjectInfoSync(this.mContext, j, callBack)) {
                        PaManager.getPaInfo(this.mContext, j, new IGetPaInfoListener(this, callBack) { // from class: com.baidu.android.imsdk.pubaccount.GetPaInfoForSessionHandler.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ GetPaInfoForSessionHandler this$0;
                            public final /* synthetic */ CallBack val$callBack;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, callBack};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$callBack = callBack;
                            }

                            @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                            public void onGetPaInfoResult(int i2, String str, PaInfo paInfo2) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, paInfo2) == null) && i2 == 0) {
                                    LogUtils.d("GetPaInfoForSessionHandler", "painfo=" + paInfo2.toString());
                                    this.this$0.callBackChatType(paInfo2.getSubtype(), paInfo2, this.val$callBack);
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
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i, int i2, Object obj) {
        GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{chatObject, Integer.valueOf(i), Integer.valueOf(i2), obj}) != null) || obj == null) {
            return;
        }
        if (!(obj instanceof PaInfo) && (getChatObjectInfoForRecordHandler = this.mChatObjectHandler) != null) {
            getChatObjectInfoForRecordHandler.updateChatRecord(chatObject, i, i2, obj);
            return;
        }
        PaInfo paInfo = (PaInfo) obj;
        if (!TextUtils.isEmpty(paInfo.getNickName()) && paInfo.getPaId() > 0) {
            chatObject.setPaid(paInfo.getPaId());
            updateChatRecord(chatObject, paInfo.getNickName(), i, paInfo.getAvatar(), paInfo.getClassType(), paInfo.getClassTitle(), paInfo.getClassavatar(), paInfo.getClassshow(), paInfo.getMarkTop(), paInfo.getMarkTopTime(), paInfo.getShield(), paInfo.getShieldTime(), paInfo.getVipId(), paInfo.getVPortrait(), paInfo.getIdentity());
        }
    }
}
