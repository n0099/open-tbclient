package com.baidu.android.imsdk.chatmessage.messages;

import android.content.Context;
import com.baidu.android.imsdk.internal.IMConfigInternal;
/* loaded from: classes2.dex */
public class ChatMsgFactory {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class SingletonHolder {
        static final ChatMsgFactory INSTANCE = new ChatMsgFactory();

        private SingletonHolder() {
        }
    }

    public static synchronized ChatMsgFactory getInstance() {
        ChatMsgFactory chatMsgFactory;
        synchronized (ChatMsgFactory.class) {
            chatMsgFactory = SingletonHolder.INSTANCE;
        }
        return chatMsgFactory;
    }

    public ChatMsg newChatMsg(Context context, int i, int i2, int i3) {
        switch (i) {
            case 0:
            case 1:
            case 4:
            case 6:
                return newMsgInstanceByType(context, i2);
            case 2:
            case 3:
                return newMsgInstanceByCmd(context, i3);
            case 5:
            default:
                return null;
        }
    }

    protected ChatMsg newMsgInstanceByType(Context context, int i) {
        if (!IMConfigInternal.getInstance().getIMConfig(context).isMsgTypeSupported(i)) {
            return new UnSupportedMsg();
        }
        switch (i) {
            case 0:
                return new TextMsg();
            case 1:
                return new ImageMsg();
            case 2:
                return new AudioMsg();
            case 3:
                return new VideoMsg();
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
            case 12:
                return new TempletMsg();
            case 13:
                return new CouponMsg();
            case 16:
                return new RedPackMsg();
            case 18:
                return new HtmlMsg();
            case 20:
                return new ConfigMsg();
            case 21:
                return new SmartMsg();
            case 22:
                return new SchemaMsg();
            case 24:
                return new InterActiveMsg();
            case 32:
                return new DuPaBManualMsg();
            case 33:
                return new DuPaEvaluationMsg();
            case 80:
                return new GalleryMsg();
            case 100:
                return new CustomMsg();
            case 101:
                return new BDMapCustomMsg();
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
            case 2001:
                return new AlertMsg();
            case 2010:
                return new RedNotifyMsg();
            default:
                return null;
        }
    }

    protected ChatMsg newMsgInstanceByCmd(Context context, int i) {
        switch (i) {
            case 0:
                return new AddFriendMsg();
            case 1:
                return new ConfirmFriendMsg();
            case 20:
                return new PaSync();
            case 21:
                return new MessageSyncMsg();
            case 22:
                return new DialogSyncMsg();
            case 23:
                return new UserSettingPaCmdMsg();
            case 50:
                return new DeviceLoginMsg();
            case 60:
                return new NotifyCustomerMsg(60);
            case 62:
                return new NotifyCustomerMsg(62);
            default:
                return null;
        }
    }
}
