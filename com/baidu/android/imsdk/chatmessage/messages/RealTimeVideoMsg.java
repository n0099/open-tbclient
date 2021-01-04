package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes4.dex */
public class RealTimeVideoMsg extends RealTimeMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<RealTimeVideoMsg> CREATOR = new Parcelable.Creator<RealTimeVideoMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.RealTimeVideoMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeVideoMsg createFromParcel(Parcel parcel) {
            return new RealTimeVideoMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeVideoMsg[] newArray(int i) {
            return new RealTimeVideoMsg[i];
        }
    };

    public RealTimeVideoMsg() {
        setMsgType(3);
    }

    private RealTimeVideoMsg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[实时视频]";
    }
}
