package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GroupStarMasterUpdateMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupStarMasterUpdateMsg> CREATOR = new Parcelable.Creator<GroupStarMasterUpdateMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupStarMasterUpdateMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupStarMasterUpdateMsg createFromParcel(Parcel parcel) {
            return new GroupStarMasterUpdateMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupStarMasterUpdateMsg[] newArray(int i) {
            return new GroupStarMasterUpdateMsg[i];
        }
    };
    public int groupnum;
    public ArrayList<String> memAddedBuids;
    public ArrayList<String> memPushoutBuids;

    public GroupStarMasterUpdateMsg() {
        setMsgType(1008);
    }

    public ArrayList<String> getAddedMemberBuids() {
        return this.memAddedBuids;
    }

    public int getGroupnum() {
        return this.groupnum;
    }

    public ArrayList<String> getPushoutBuid() {
        return this.memPushoutBuids;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return "你收到了一条系统消息";
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.groupnum = jSONObject.optInt("group_num");
            if (jSONObject.has("del_member")) {
                this.memPushoutBuids = new ArrayList<>();
                JSONArray jSONArray = jSONObject.getJSONArray("del_member");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.memPushoutBuids.add(String.valueOf(jSONArray.getLong(i)));
                }
            }
            if (jSONObject.has("admins")) {
                this.memAddedBuids = new ArrayList<>();
                JSONArray jSONArray2 = jSONObject.getJSONArray("admins");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.memAddedBuids.add(String.valueOf(jSONArray2.getLong(i2)));
                }
            }
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.groupnum);
        parcel.writeList(this.memAddedBuids);
        parcel.writeList(this.memPushoutBuids);
    }

    public GroupStarMasterUpdateMsg(Parcel parcel) {
        super(parcel);
        this.groupnum = parcel.readInt();
        ArrayList<String> arrayList = new ArrayList<>();
        this.memAddedBuids = arrayList;
        parcel.readList(arrayList, String.class.getClassLoader());
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.memPushoutBuids = arrayList2;
        parcel.readList(arrayList2, String.class.getClassLoader());
    }
}
