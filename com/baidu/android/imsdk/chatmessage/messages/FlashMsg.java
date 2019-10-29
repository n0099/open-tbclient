package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes6.dex */
public abstract class FlashMsg extends ChatMsg implements Parcelable, NoProGuard {
    public FlashMsg() {
        setCategory(3);
    }

    public FlashMsg(Parcel parcel) {
        super(parcel);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return null;
    }
}
