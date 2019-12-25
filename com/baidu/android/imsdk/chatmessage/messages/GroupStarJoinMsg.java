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
        public GroupStarJoinMsg[] newArray(int i) {
            return new GroupStarJoinMsg[i];
        }
    };
    private int groupnum;
    private ArrayList<String> memPushoutBuids;
    private ArrayList<String> memberbuid;

    public GroupStarJoinMsg() {
        setMsgType(1002);
    }

    public GroupStarJoinMsg(Parcel parcel) {
        super(parcel);
        this.groupnum = parcel.readInt();
        this.memberbuid = new ArrayList<>();
        parcel.readList(this.memberbuid, String.class.getClassLoader());
        this.memPushoutBuids = new ArrayList<>();
        parcel.readList(this.memPushoutBuids, String.class.getClassLoader());
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.NotifyMsg, com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.groupnum);
        parcel.writeList(this.memberbuid);
        parcel.writeList(this.memPushoutBuids);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getMsgContent());
            this.groupnum = jSONObject.optInt("group_num");
            JSONArray jSONArray = jSONObject.getJSONArray("member");
            this.memberbuid = new ArrayList<>();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.memberbuid.add(String.valueOf(jSONArray.getLong(i)));
            }
            if (jSONObject.has("del_member")) {
                this.memPushoutBuids = new ArrayList<>();
                JSONArray jSONArray2 = jSONObject.getJSONArray("del_member");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    this.memPushoutBuids.add(String.valueOf(jSONArray2.getLong(i2)));
                }
            }
            return true;
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "parseJsonString", e);
            return false;
        }
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
}
