package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
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

    public ChatMsg newChatMsg(Context context, int i, int i2, int i3) {
        if (i != 0 && i != 1) {
            if (i == 2 || i == 3) {
                return newMsgInstanceByCmd(context, i3);
            }
            if (i != 4 && i != 6) {
                return null;
            }
        }
        return newMsgInstanceByType(context, i2);
    }

    public ChatMsg newMsgInstanceByCmd(Context context, int i) {
        NotifyCustomerMsg notifyCustomerMsg;
        if (i != 0) {
            if (i != 1) {
                if (i != 50) {
                    if (i == 60) {
                        notifyCustomerMsg = new NotifyCustomerMsg(60);
                    } else if (i != 62) {
                        switch (i) {
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

    public ChatMsg newMsgInstanceByType(Context context, int i) {
        if (IMConfigInternal.getInstance().getIMConfig(context).isMsgTypeSupported(i)) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 12) {
                                if (i != 13) {
                                    if (i != 16) {
                                        if (i != 18) {
                                            if (i != 80) {
                                                if (i != 2001) {
                                                    if (i != 2010) {
                                                        if (i != 2012) {
                                                            if (i != 2014) {
                                                                if (i != 32) {
                                                                    if (i != 33) {
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
                                                                                                            default:
                                                                                                                return null;
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                }
                                                                            }
                                                                            return new BDMapCustomMsg();
                                                                        }
                                                                        return new CustomMsg();
                                                                    }
                                                                    return new DuPaEvaluationMsg();
                                                                }
                                                                return new DuPaBManualMsg();
                                                            }
                                                            return new UnSubscribeMsg();
                                                        }
                                                        return new ShieldMsg();
                                                    }
                                                    return new RedNotifyMsg();
                                                }
                                                return new AlertMsg();
                                            }
                                            return new GalleryMsg();
                                        }
                                        return new HtmlMsg();
                                    }
                                    return new RedPackMsg();
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
