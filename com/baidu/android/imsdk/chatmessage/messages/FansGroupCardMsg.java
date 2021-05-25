package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.utils.LogUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FansGroupCardMsg extends NormalMsg {
    public static final Parcelable.Creator<FansGroupCardMsg> CREATOR = new Parcelable.Creator<FansGroupCardMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.FansGroupCardMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FansGroupCardMsg createFromParcel(Parcel parcel) {
            return new FansGroupCardMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FansGroupCardMsg[] newArray(int i2) {
            return new FansGroupCardMsg[i2];
        }
    };
    public static final String TAG = "FansGroupCardMsg";
    public long mGroupId;
    public String mGroupImage;
    public String mGroupName;
    public int mSize;

    public FansGroupCardMsg() {
        setMsgType(41);
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public String getGroupImage() {
        return this.mGroupImage;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public int getGroupSize() {
        return this.mSize;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "[群名片]";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (!TextUtils.isEmpty(jsonContent)) {
            try {
                JSONObject jSONObject = new JSONObject(jsonContent);
                this.mGroupId = jSONObject.getLong("group_id");
                this.mGroupName = jSONObject.optString("group_name");
                this.mSize = jSONObject.optInt(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_SIZE);
                this.mGroupImage = jSONObject.optString("group_image");
                return true;
            } catch (JSONException e2) {
                LogUtils.e(TAG, "parse json err!", e2);
            }
        }
        return false;
    }

    public void setGroupImage(String str) {
        this.mGroupImage = str;
    }

    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    public void setGroupSize(int i2) {
        this.mSize = i2;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeLong(this.mGroupId);
        parcel.writeString(this.mGroupName);
        parcel.writeInt(this.mSize);
        parcel.writeString(this.mGroupImage);
    }

    public FansGroupCardMsg(Parcel parcel) {
        super(parcel);
        this.mGroupId = parcel.readLong();
        this.mGroupName = parcel.readString();
        this.mSize = parcel.readInt();
        this.mGroupImage = parcel.readString();
    }
}
