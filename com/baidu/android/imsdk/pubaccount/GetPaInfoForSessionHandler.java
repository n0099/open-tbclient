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
/* loaded from: classes8.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public void callBackChatType(int i2, PaInfo paInfo, CallBack callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65538, this, i2, paInfo, callBack) == null) {
            deleteUUid();
            int i3 = 17;
            if (i2 == 1) {
                i3 = 1;
            } else if (i2 == 5) {
                i3 = 5;
            } else if (i2 == 7) {
                i3 = 7;
            } else if (i2 == 19) {
                i3 = 19;
            } else if (i2 == 23) {
                i3 = 23;
            } else if (i2 == 29) {
                i3 = 29;
            } else if (i2 == 100) {
                i3 = 100;
            } else if (i2 == 16) {
                i3 = 16;
            } else if (i2 != 17) {
                switch (i2) {
                    case 25:
                        i3 = 25;
                        break;
                    case 26:
                        i3 = 26;
                        break;
                    case 27:
                        i3 = 27;
                        break;
                    default:
                        i3 = -1;
                        break;
                }
            }
            if (i3 != -1 || !Utility.availableNotificationPaType(i2)) {
                i2 = i3;
            }
            if (i2 != -1) {
                callBack.onSuccess(i2, 0, paInfo);
            } else {
                LogUtils.d("GetPaInfoForSessionHandler", "pa type as default -1");
            }
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void getChatObjectInfo(long j2, CallBack callBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, callBack) == null) {
            PaInfo paInfo = PaManagerImpl.getInstance(this.mContext).getPaInfo(j2);
            if (paInfo == null) {
                int i2 = this.mNextTask;
                if (i2 != -1) {
                    GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler = (GetChatObjectInfoForRecordHandler) GetChatObjectInfoForRecordManager.newInstance(this.mContext, 0, j2, i2);
                    this.mChatObjectHandler = getChatObjectInfoForRecordHandler;
                    if (getChatObjectInfoForRecordHandler.getChatObjectInfoSync(this.mContext, j2, callBack)) {
                        return;
                    }
                    PaManager.getPaInfo(this.mContext, j2, new IGetPaInfoListener(this, callBack) { // from class: com.baidu.android.imsdk.pubaccount.GetPaInfoForSessionHandler.1
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
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$callBack = callBack;
                        }

                        @Override // com.baidu.android.imsdk.pubaccount.IGetPaInfoListener
                        public void onGetPaInfoResult(int i3, String str, PaInfo paInfo2) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeILL(1048576, this, i3, str, paInfo2) == null) && i3 == 0) {
                                LogUtils.d("GetPaInfoForSessionHandler", "painfo=" + paInfo2.toString());
                                this.this$0.callBackChatType(paInfo2.getSubtype(), paInfo2, this.val$callBack);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            callBackChatType(paInfo.getSubtype(), paInfo, callBack);
        }
    }

    @Override // com.baidu.android.imsdk.GetChatObjectInfoForRecordHandler
    public void updateChatRecord(ChatObject chatObject, int i2, int i3, Object obj) {
        GetChatObjectInfoForRecordHandler getChatObjectInfoForRecordHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{chatObject, Integer.valueOf(i2), Integer.valueOf(i3), obj}) == null) || obj == null) {
            return;
        }
        if (!(obj instanceof PaInfo) && (getChatObjectInfoForRecordHandler = this.mChatObjectHandler) != null) {
            getChatObjectInfoForRecordHandler.updateChatRecord(chatObject, i2, i3, obj);
            return;
        }
        PaInfo paInfo = (PaInfo) obj;
        if (TextUtils.isEmpty(paInfo.getNickName()) || paInfo.getPaId() <= 0) {
            return;
        }
        chatObject.setPaid(paInfo.getPaId());
        updateChatRecord(chatObject, paInfo.getNickName(), i2, paInfo.getAvatar(), paInfo.getClassType(), paInfo.getClassTitle(), paInfo.getClassavatar(), paInfo.getClassshow(), paInfo.getMarkTop(), paInfo.getMarkTopTime(), paInfo.getShield(), paInfo.getShieldTime(), paInfo.getVipId(), paInfo.getVPortrait(), paInfo.getIdentity());
    }
}
