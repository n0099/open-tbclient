package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes5.dex */
public class RealTimeAudioMsg extends RealTimeMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<RealTimeAudioMsg> CREATOR = new Parcelable.Creator<RealTimeAudioMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.RealTimeAudioMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeAudioMsg createFromParcel(Parcel parcel) {
            return new RealTimeAudioMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RealTimeAudioMsg[] newArray(int i) {
            return new RealTimeAudioMsg[i];
        }
    };

    public RealTimeAudioMsg() {
        setMsgType(5);
    }

    private RealTimeAudioMsg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[实时语音]";
    }
}
