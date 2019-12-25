package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes2.dex */
public abstract class NormalMsg extends ChatMsg implements Parcelable, NoProGuard {
    public NormalMsg() {
    }

    public NormalMsg(Parcel parcel) {
        super(parcel);
    }
}
