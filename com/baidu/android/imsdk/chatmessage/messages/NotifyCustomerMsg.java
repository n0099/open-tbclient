package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class NotifyCustomerMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<NotifyCustomerMsg> CREATOR = new Parcelable.Creator<NotifyCustomerMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.NotifyCustomerMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotifyCustomerMsg createFromParcel(Parcel parcel) {
            return new NotifyCustomerMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotifyCustomerMsg[] newArray(int i) {
            return new NotifyCustomerMsg[i];
        }
    };
    public long csuid;
    public String text;

    public NotifyCustomerMsg(int i) {
        this.csuid = -1L;
        this.text = "";
        setNotifyCmd(i);
    }

    public long getCsUid() {
        return this.csuid;
    }

    public String getText() {
        return this.text;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            this.csuid = jSONObject.getInt("cs_uid");
            this.text = jSONObject.getString("text");
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    public void setText(String str) {
        this.text = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.csuid);
        parcel.writeString(this.text);
    }

    public NotifyCustomerMsg(Parcel parcel) {
        super(parcel);
        this.csuid = -1L;
        this.text = "";
        this.csuid = parcel.readLong();
        this.text = parcel.readString();
    }
}
