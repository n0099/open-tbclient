package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ChatMsgFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final ChatMsgFactory INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2016518485, "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsgFactory$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2016518485, "Lcom/baidu/android/imsdk/chatmessage/messages/ChatMsgFactory$SingletonHolder;");
                    return;
                }
            }
            INSTANCE = new ChatMsgFactory();
        }

        public SingletonHolder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public ChatMsgFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized ChatMsgFactory getInstance() {
        InterceptResult invokeV;
        ChatMsgFactory chatMsgFactory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ChatMsgFactory.class) {
                chatMsgFactory = SingletonHolder.INSTANCE;
            }
            return chatMsgFactory;
        }
        return (ChatMsgFactory) invokeV.objValue;
    }

    public ChatMsg newChatMsg(Context context, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048576, this, context, i, i2, i3)) == null) {
            if (i != 0 && i != 1) {
                if (i != 2 && i != 3) {
                    if (i != 4 && i != 6 && i != 9) {
                        return null;
                    }
                } else {
                    return newMsgInstanceByCmd(context, i3);
                }
            }
            return newMsgInstanceByType(context, i2);
        }
        return (ChatMsg) invokeLIII.objValue;
    }

    public ChatMsg newMsgInstanceByCmd(Context context, int i) {
        InterceptResult invokeLI;
        NotifyCustomerMsg notifyCustomerMsg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 26) {
                        if (i != 50) {
                            if (i != 60) {
                                if (i != 62) {
                                    switch (i) {
                                        case 20:
                                            return new PaSync();
                                        case 21:
                                            return new MessageSyncMsg();
                                        case 22:
                                            return new DialogSyncMsg();
                                        case 23:
                                            return new UserSettingPaCmdMsg();
                                        case 24:
                                            return new MessageClueUpateMsg();
                                        default:
                                            return null;
                                    }
                                }
                                notifyCustomerMsg = new NotifyCustomerMsg(62);
                            } else {
                                notifyCustomerMsg = new NotifyCustomerMsg(60);
                            }
                            return notifyCustomerMsg;
                        }
                        return new DeviceLoginMsg();
                    }
                    return new NotifyReplyUpdateMsg();
                }
                return new ConfirmFriendMsg();
            }
            return new AddFriendMsg();
        }
        return (ChatMsg) invokeLI.objValue;
    }

    public ChatMsg newMsgInstanceByType(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, context, i)) == null) {
            if (!IMConfigInternal.getInstance().getIMConfig(context).isMsgTypeSupported(i)) {
                return new UnSupportedMsg();
            }
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 12) {
                                if (i != 13) {
                                    if (i != 32) {
                                        if (i != 33) {
                                            if (i != 35) {
                                                if (i != 36) {
                                                    if (i != 100) {
                                                        if (i != 101) {
                                                            switch (i) {
                                                                case 5:
                                                                    return new RealTimeAudioMsg();
                                                                case 6:
                                                                    return new RealTimeVideoMsg();
                                                                case 7:
                                                                    return new LocationMsg();
                                                                case 8:
                                                                    return new SignleGraphicTextMsg();
                                                                case 9:
                                                                    return new MultiGraphicTextMsg();
                                                                default:
                                                                    switch (i) {
                                                                        case 18:
                                                                            return new HtmlMsg();
                                                                        case 60:
                                                                            return new GroupCouponMsg();
                                                                        case 80:
                                                                            return new GalleryMsg();
                                                                        case 82:
                                                                            return new AudioTextMsg();
                                                                        case 84:
                                                                            return new TextImageMsg();
                                                                        case 1001:
                                                                            return new GroupMemberAddMsg();
                                                                        case 1002:
                                                                            return new GroupMemberJoinMsg();
                                                                        case 1003:
                                                                            return new GroupMemberQuitMsg();
                                                                        case 1004:
                                                                            return new GroupMemberDelMsg();
                                                                        case 1005:
                                                                            return new GroupInfoChangeMsg();
                                                                        case 1006:
                                                                            return new GroupBroadcastMsg();
                                                                        case 1007:
                                                                            return new GroupStarJoinMsg();
                                                                        case 1008:
                                                                            return new GroupStarMasterUpdateMsg();
                                                                        case 1009:
                                                                            return new GroupStarAlertMsg();
                                                                        case 1010:
                                                                            return new GroupStarAlertMsg();
                                                                        case 1011:
                                                                            return new GroupStarAlertMsg();
                                                                        case 1012:
                                                                            return new GroupMemberNameChangeMsg();
                                                                        case 1013:
                                                                            return new GroupDisbandMsg();
                                                                        case 1014:
                                                                            return new FansInfoUpdateMsg();
                                                                        case 1015:
                                                                            return new FansSetAdminMsg();
                                                                        case 1016:
                                                                            return new GroupMessageDeleteMsg();
                                                                        case 1017:
                                                                            return new FansSetOwnerMsg();
                                                                        case 1018:
                                                                            return new FansGroupCancelAdminMsg();
                                                                        case 1019:
                                                                            return new GroupBannedMsg();
                                                                        case 1020:
                                                                            return new GroupUnbannedMsg();
                                                                        case 1021:
                                                                            return new GroupJoinApplyMsg();
                                                                        case 1022:
                                                                            return new GroupJoinApplyPassedMsg();
                                                                        case 1023:
                                                                            return new GroupJoinApplyRejectedMsg();
                                                                        case 1024:
                                                                            return new GroupJoinAuditOpenMsg();
                                                                        case 1025:
                                                                            return new GroupJoinAuditCloseMsg();
                                                                        case 1026:
                                                                            return new GroupSettingNoticeMsg();
                                                                        case 1027:
                                                                            return new GroupClearNoticeMsg();
                                                                        case 1028:
                                                                            return new SetGroupWelcomeMsg();
                                                                        case 1029:
                                                                            return new SetGroupWelcomeDisplayScopeMsg();
                                                                        case 2001:
                                                                            return new AlertMsg();
                                                                        case 2012:
                                                                            return new ShieldMsg();
                                                                        case 2014:
                                                                            return new UnSubscribeMsg();
                                                                        case 5001:
                                                                            return new GroupReplyUpdateMsg();
                                                                        default:
                                                                            switch (i) {
                                                                                case 20:
                                                                                    return new ConfigMsg();
                                                                                case 21:
                                                                                    return new SmartMsg();
                                                                                case 22:
                                                                                    return new SchemaMsg();
                                                                                default:
                                                                                    switch (i) {
                                                                                        case 24:
                                                                                            return new InterActiveMsg();
                                                                                        case 25:
                                                                                            return new ProductMsg();
                                                                                        case 26:
                                                                                            return new ConsultCouponMsg();
                                                                                        case 27:
                                                                                            return new PassMsg();
                                                                                        case 28:
                                                                                            return new PassSaveMsg();
                                                                                        case 29:
                                                                                            return new GoodsMsg();
                                                                                        case 30:
                                                                                            return new BonusMsg();
                                                                                        default:
                                                                                            switch (i) {
                                                                                                case 38:
                                                                                                    return new BrandMsg();
                                                                                                case 39:
                                                                                                    return new FansGroupInviteMsg();
                                                                                                case 40:
                                                                                                    return new FansGroupAtMsg();
                                                                                                case 41:
                                                                                                    return new FansGroupCardMsg();
                                                                                                case 42:
                                                                                                    return new AdvisoryBigPicMsg();
                                                                                                case 43:
                                                                                                    return new AdvisoryMultiPicMsg();
                                                                                                case 44:
                                                                                                    return new AdvisoryVideoAudioMsg();
                                                                                                case 45:
                                                                                                    return new AdvisoryServiceEndMsg();
                                                                                                case 46:
                                                                                                    return new AdvisoryWaitConfirmMsg();
                                                                                                case 47:
                                                                                                    return new AdvisoryCallHistoryMsg();
                                                                                                case 48:
                                                                                                    return new GfhCommonMsg();
                                                                                                case 49:
                                                                                                    return new GfhPaymentMsg();
                                                                                                case 50:
                                                                                                    return new GfhImgTxtMsg();
                                                                                                case 51:
                                                                                                    return new LiveCardMsg();
                                                                                                case 52:
                                                                                                    return new AdvisoryRecommendServiceMsg();
                                                                                                case 53:
                                                                                                    return new AdvisoryExtensionMsg();
                                                                                                case 54:
                                                                                                    return new GroupRecommendMsg();
                                                                                                case 55:
                                                                                                    return new NetDiskFileMsg();
                                                                                                case 56:
                                                                                                    return new AdvisoryQuestionMsg();
                                                                                                case 57:
                                                                                                    return new ImportantMsg();
                                                                                                case 58:
                                                                                                    return new ClueCardMsg();
                                                                                                default:
                                                                                                    return null;
                                                                                            }
                                                                                    }
                                                                            }
                                                                    }
                                                            }
                                                        }
                                                        return new BDMapCustomMsg();
                                                    }
                                                    return new CustomMsg();
                                                }
                                                return new SettingRemindMsg();
                                            }
                                            return new BonusNoImgMsg();
                                        }
                                        return new DuPaEvaluationMsg();
                                    }
                                    return new DuPaBManualMsg();
                                }
                                return new CouponMsg();
                            }
                            return new TempletMsg();
                        }
                        return new VideoMsg();
                    }
                    return new AudioMsg();
                }
                return new ImageMsg();
            }
            return new TextMsg();
        }
        return (ChatMsg) invokeLI.objValue;
    }
}
