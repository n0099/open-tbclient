package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FansGroupInviteMsg extends NormalMsg {
    public static final Parcelable.Creator<FansGroupInviteMsg> CREATOR = new Parcelable.Creator<FansGroupInviteMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.FansGroupInviteMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FansGroupInviteMsg createFromParcel(Parcel parcel) {
            return new FansGroupInviteMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FansGroupInviteMsg[] newArray(int i2) {
            return new FansGroupInviteMsg[i2];
        }
    };
    public static final String TAG = "FansGroupInviteMsg";
    public String mDesc;
    public long mGroupId;
    public String mImgUrl;
    public long mInvitor;
    public String mTitle;

    public FansGroupInviteMsg() {
        setMsgType(39);
    }

    public String getDesc() {
        return this.mDesc;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public long getInvitor() {
        return this.mInvitor;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[链接] 邀请你加入群聊";
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (!TextUtils.isEmpty(jsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                this.mGroupId = jSONObject.optLong("group_id");
                this.mInvitor = jSONObject.optLong("invitor");
                return true;
            } catch (JSONException e2) {
                LogUtils.e("TextMsg", "parse json err!", e2);
            }
        }
        return false;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public void setImgUrl(String str) {
        this.mImgUrl = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeLong(this.mGroupId);
        parcel.writeLong(this.mInvitor);
    }

    public FansGroupInviteMsg(Parcel parcel) {
        super(parcel);
        this.mGroupId = parcel.readLong();
        this.mInvitor = parcel.readLong();
    }
}
