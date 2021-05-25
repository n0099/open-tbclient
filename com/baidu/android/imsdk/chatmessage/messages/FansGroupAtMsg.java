package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class FansGroupAtMsg extends NormalMsg {
    public static final Parcelable.Creator<FansGroupAtMsg> CREATOR = new Parcelable.Creator<FansGroupAtMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FansGroupAtMsg createFromParcel(Parcel parcel) {
            return new FansGroupAtMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FansGroupAtMsg[] newArray(int i2) {
            return new FansGroupAtMsg[i2];
        }
    };
    public static final String TAG = "FansGroupAtMsg";
    public ArrayList<AtData> mAtDataList;
    public String mText;

    /* loaded from: classes.dex */
    public static class AtData implements Parcelable, NoProGuard {
        public static final Parcelable.Creator<AtData> CREATOR = new Parcelable.Creator<AtData>() { // from class: com.baidu.android.imsdk.chatmessage.messages.FansGroupAtMsg.AtData.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AtData createFromParcel(Parcel parcel) {
                return new AtData(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AtData[] newArray(int i2) {
                return new AtData[i2];
            }
        };
        public String mAtText;
        public String mAtType;
        public String mAtUser;

        public AtData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getText() {
            return this.mAtText;
        }

        public String getType() {
            return this.mAtType;
        }

        public String getUser() {
            return this.mAtUser;
        }

        public void setText(String str) {
            this.mAtText = str;
        }

        public void setType(String str) {
            this.mAtType = str;
        }

        public void setUser(String str) {
            this.mAtUser = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.mAtType);
            parcel.writeString(this.mAtUser);
            parcel.writeString(this.mAtText);
        }

        public AtData(Parcel parcel) {
            this.mAtType = parcel.readString();
            this.mAtUser = parcel.readString();
            this.mAtText = parcel.readString();
        }
    }

    public FansGroupAtMsg() {
        this.mText = "";
        setMsgType(40);
        setCategory(1);
        setChatType(57);
    }

    public ArrayList<AtData> getDataList() {
        return this.mAtDataList;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return this.mText;
    }

    public String getText() {
        return this.mText;
    }

    public boolean isGroupAtUserById(String str) {
        ArrayList<AtData> arrayList;
        if (!isMsgRead() && (arrayList = this.mAtDataList) != null && arrayList.size() != 0 && !TextUtils.isEmpty(str)) {
            Iterator<AtData> it = this.mAtDataList.iterator();
            while (it.hasNext()) {
                AtData next = it.next();
                String type = next.getType();
                String user = next.getUser();
                LogUtils.d(TAG, "userId: " + str + ", atData_user: " + user);
                if (TextUtils.equals(type, IMConstants.AT_DATA_TYPE_GROUP_ALL)) {
                    return true;
                }
                if (TextUtils.equals(type, IMConstants.AT_DATA_TYPE_USER) && TextUtils.equals(user, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonContent);
            this.mText = jSONObject.optString("text");
            JSONArray optJSONArray = jSONObject.optJSONArray("at_data");
            int length = optJSONArray.length();
            if (length > 0) {
                this.mAtDataList = new ArrayList<>(length);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    String optString = jSONObject2.optString("at_type", "");
                    String optString2 = jSONObject2.optString("at_user", "");
                    String optString3 = jSONObject2.optString("text", "");
                    AtData atData = new AtData();
                    atData.setType(optString);
                    atData.setUser(optString2);
                    atData.setText(optString3);
                    this.mAtDataList.add(atData);
                    LogUtils.d(TAG, "at data " + i2 + " type: " + optString + ", user: " + optString2 + ", text: " + optString3);
                }
            }
            return true;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "parse json err!", e2);
            return false;
        }
    }

    public void setDataList(ArrayList<AtData> arrayList) {
        this.mAtDataList = arrayList;
    }

    public boolean setJsonContent(String str, ArrayList<AtData> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("text", str);
            JSONArray jSONArray = new JSONArray();
            if (arrayList.size() > 0) {
                Iterator<AtData> it = arrayList.iterator();
                while (it.hasNext()) {
                    AtData next = it.next();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("at_type", next.getType());
                    jSONObject2.put("at_user", next.getUser());
                    jSONObject2.put("text", next.getText());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("at_data", jSONArray);
            return setMsgContent(jSONObject.toString());
        } catch (Exception unused) {
            LogUtils.e(TAG, "content error!");
            return false;
        }
    }

    public void setText(String str) {
        this.mText = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.mText);
        ArrayList<AtData> arrayList = this.mAtDataList;
        int size = arrayList != null ? arrayList.size() : 0;
        parcel.writeInt(size);
        if (size > 0) {
            parcel.writeTypedList(this.mAtDataList);
        }
    }

    public FansGroupAtMsg(Parcel parcel) {
        super(parcel);
        this.mText = "";
        this.mText = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            ArrayList<AtData> arrayList = new ArrayList<>(readInt);
            this.mAtDataList = arrayList;
            parcel.readTypedList(arrayList, AtData.CREATOR);
        }
    }
}
