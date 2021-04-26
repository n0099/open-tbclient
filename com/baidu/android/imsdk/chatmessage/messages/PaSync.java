package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
/* loaded from: classes.dex */
public class PaSync extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<PaSync> CREATOR = new Parcelable.Creator<PaSync>() { // from class: com.baidu.android.imsdk.chatmessage.messages.PaSync.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PaSync createFromParcel(Parcel parcel) {
            return new PaSync(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PaSync[] newArray(int i2) {
            return new PaSync[i2];
        }
    };

    public PaSync() {
    }

    public String constructJsonString(Object obj) throws JSONException, ClassCastException {
        return null;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        return true;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
    }

    public PaSync(Parcel parcel) {
        super(parcel);
    }
}
