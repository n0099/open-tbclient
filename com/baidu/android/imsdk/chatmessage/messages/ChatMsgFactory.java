package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
/* loaded from: classes.dex */
public class ChatMsgFactory {

    /* loaded from: classes.dex */
    public static class SingletonHolder {
        public static final ChatMsgFactory INSTANCE = new ChatMsgFactory();
    }

    public static synchronized ChatMsgFactory getInstance() {
        ChatMsgFactory chatMsgFactory;
        synchronized (ChatMsgFactory.class) {
            chatMsgFactory = SingletonHolder.INSTANCE;
        }
        return chatMsgFactory;
    }

    public ChatMsg newChatMsg(Context context, int i2, int i3, int i4) {
        if (i2 != 0 && i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return newMsgInstanceByCmd(context, i4);
            }
            if (i2 != 4 && i2 != 6) {
                return null;
            }
        }
        return newMsgInstanceByType(context, i3);
    }

    public ChatMsg newMsgInstanceByCmd(Context context, int i2) {
        NotifyCustomerMsg notifyCustomerMsg;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 50) {
                    if (i2 == 60) {
                        notifyCustomerMsg = new NotifyCustomerMsg(60);
                    } else if (i2 != 62) {
                        switch (i2) {
                            case 20:
                                return new PaSync();
                            case 21:
                                return new MessageSyncMsg();
                            case 22:
                                return new DialogSyncMsg();
                            case 23:
                                return new UserSettingPaCmdMsg();
                            default:
                                return null;
                        }
                    } else {
                        notifyCustomerMsg = new NotifyCustomerMsg(62);
                    }
                    return notifyCustomerMsg;
                }
                return new DeviceLoginMsg();
            }
            return new ConfirmFriendMsg();
        }
        return new AddFriendMsg();
    }

    public ChatMsg newMsgInstanceByType(Context context, int i2) {
        if (IMConfigInternal.getInstance().getIMConfig(context).isMsgTypeSupported(i2)) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 12) {
                                if (i2 != 13) {
                                    if (i2 != 32) {
                                        if (i2 != 33) {
                                            if (i2 != 35) {
                                                if (i2 != 36) {
                                                    if (i2 != 100) {
                                                        if (i2 != 101) {
                                                            switch (i2) {
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
                                                                    switch (i2) {
                                                                        case 16:
                                                                            return new RedPackMsg();
                                                                        case 18:
                                                                            return new HtmlMsg();
                                                                        case 80:
                                                                            return new GalleryMsg();
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
                                                                        case 2001:
                                                                            return new AlertMsg();
                                                                        case 2010:
                                                                            return new RedNotifyMsg();
                                                                        case IMConstants.IM_MSG_TYPE_SHIELD_ME /* 2012 */:
                                                                            return new ShieldMsg();
                                                                        case IMConstants.IM_MSG_TYPE_UNSUBSCRIBE_ME_SEND_FAIL /* 2014 */:
                                                                            return new UnSubscribeMsg();
                                                                        default:
                                                                            switch (i2) {
                                                                                case 20:
                                                                                    return new ConfigMsg();
                                                                                case 21:
                                                                                    return new SmartMsg();
                                                                                case 22:
                                                                                    return new SchemaMsg();
                                                                                default:
                                                                                    switch (i2) {
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
                                                                                            switch (i2) {
                                                                                                case 38:
                                                                                                    return new BrandMsg();
                                                                                                case 39:
                                                                                                    return new FansGroupInviteMsg();
                                                                                                case 40:
                                                                                                    return new FansGroupAtMsg();
                                                                                                case 41:
                                                                                                    return new FansGroupCardMsg();
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
        return new UnSupportedMsg();
    }
}
