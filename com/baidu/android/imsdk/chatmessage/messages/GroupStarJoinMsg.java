package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GroupStarJoinMsg extends NotifyMsg implements Parcelable, NoProGuard {
    public static final Parcelable.Creator<GroupStarJoinMsg> CREATOR = new Parcelable.Creator<GroupStarJoinMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.GroupStarJoinMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupStarJoinMsg createFromParcel(Parcel parcel) {
            return new GroupStarJoinMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupStarJoinMsg[] newArray(int i2) {
            return new GroupStarJoinMsg[i2];
        }
    };
    public int groupnum;
    public ArrayList<String> memPushoutBuids;
    public ArrayList<String> memberbuid;

    public GroupStarJoinMsg() {
        setMsgType(1002);
    }

    public int getGroupnum() {
        return this.groupnum;
    }

    public ArrayList<String> getMemberBuid() {
        return this.memberbuid;
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
            JSONArray jSONArray = jSONObject.getJSONArray("member");
            this.memberbuid = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.memberbuid.add(String.valueOf(jSONArray.getLong(i2)));
            }
            if (jSONObject.has("del_member")) {
                this.memPushoutBuids = new ArrayList<>();
                JSONArray jSONArray2 = jSONObject.getJSONArray("del_member");
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    this.memPushoutBuids.add(String.valueOf(jSONArray2.getLong(i3)));
                }
            }
            return true;
        } catch (JSONException e2) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e2);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.groupnum);
        parcel.writeList(this.memberbuid);
        parcel.writeList(this.memPushoutBuids);
    }

    public GroupStarJoinMsg(Parcel parcel) {
        super(parcel);
        this.groupnum = parcel.readInt();
        ArrayList<String> arrayList = new ArrayList<>();
        this.memberbuid = arrayList;
        parcel.readList(arrayList, String.class.getClassLoader());
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.memPushoutBuids = arrayList2;
        parcel.readList(arrayList2, String.class.getClassLoader());
    }
}
