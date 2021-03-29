package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class SmartMsg extends NormalMsg {
    public static final Parcelable.Creator<SmartMsg> CREATOR = new Parcelable.Creator<SmartMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.SmartMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SmartMsg createFromParcel(Parcel parcel) {
            return new SmartMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SmartMsg[] newArray(int i) {
            return new SmartMsg[i];
        }
    };
    public Commodity[] mCommodity;
    public String mDetailurl;
    public String mFirstColor;
    public String mFirstName;
    public String mIcon;
    public String mImageDetail;
    public String mKeywords;
    public String mName;
    public String mRemarkColor;
    public String mRemarkName;
    public String mShema;
    public String mTitle;
    public long mTopicId;
    public String mTopicName;
    public String mValuationTxt;
    public String mValuationUrl;

    /* loaded from: classes.dex */
    public static class Commodity implements Parcelable, NoProGuard {
        public static final Parcelable.Creator<Commodity> CREATOR = new Parcelable.Creator<Commodity>() { // from class: com.baidu.android.imsdk.chatmessage.messages.SmartMsg.Commodity.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Commodity createFromParcel(Parcel parcel) {
                return new Commodity(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Commodity[] newArray(int i) {
                return new Commodity[i];
            }
        };
        public String mColor;
        public String mName;
        public String mValue;

        public Commodity() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getColor() {
            return this.mColor;
        }

        public String getName() {
            return this.mName;
        }

        public String getValue() {
            return this.mValue;
        }

        public void setColor(String str) {
            this.mColor = str;
        }

        public void setName(String str) {
            this.mName = str;
        }

        public void setValue(String str) {
            this.mValue = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mName);
            parcel.writeString(this.mValue);
            parcel.writeString(this.mColor);
        }

        public Commodity(Parcel parcel) {
            this.mName = parcel.readString();
            this.mValue = parcel.readString();
            this.mColor = parcel.readString();
        }
    }

    public SmartMsg() {
        setMsgType(21);
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Commodity[] getCommodity() {
        return this.mCommodity;
    }

    public String getDetail() {
        return this.mDetailurl;
    }

    public String getFirstColor() {
        return this.mFirstColor;
    }

    public String getFirstName() {
        return this.mFirstName;
    }

    public String getIcon() {
        return this.mIcon;
    }

    public String getImageDetail() {
        return this.mImageDetail;
    }

    public String getKeywords() {
        return this.mKeywords;
    }

    public String getName() {
        return this.mName;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return !TextUtils.isEmpty(this.mTitle) ? this.mTitle : "";
    }

    public String getRemarkColor() {
        return this.mRemarkColor;
    }

    public String getRemarkName() {
        return this.mRemarkName;
    }

    public String getSchema() {
        return this.mShema;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public long getTopicId() {
        return this.mTopicId;
    }

    public String getTopicName() {
        return this.mTopicName;
    }

    public String getValuationTxt() {
        return this.mValuationTxt;
    }

    public String getValuationUrl() {
        return this.mValuationUrl;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        try {
            JSONObject jSONObject = new JSONObject(getJsonContent());
            String optString = jSONObject.optString("title");
            this.mTitle = optString;
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            this.mName = jSONObject.optString("name");
            this.mIcon = jSONObject.optString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
            this.mDetailurl = jSONObject.optString("detail_url");
            this.mShema = jSONObject.optString("schema");
            JSONObject optJSONObject = jSONObject.optJSONObject(Config.TRACE_VISIT_FIRST);
            if (optJSONObject != null) {
                this.mFirstName = optJSONObject.optString("value");
                this.mFirstColor = optJSONObject.optString("color");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("remark");
            if (optJSONObject2 != null) {
                this.mRemarkName = optJSONObject2.optString("value");
                this.mRemarkColor = optJSONObject2.optString("color");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
            if (optJSONArray != null) {
                this.mKeywords = optJSONArray.toString();
                int length = optJSONArray.length();
                if (length > 0) {
                    this.mCommodity = new Commodity[length];
                }
                LogUtils.d("TempletMsg", "size is " + length);
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Commodity commodity = new Commodity();
                    commodity.setName(jSONObject2.getString("name"));
                    commodity.setValue(jSONObject2.optString("value", ""));
                    commodity.setColor(jSONObject2.optString("color", "#000000"));
                    this.mCommodity[i] = commodity;
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("image");
            if (optJSONObject3 != null) {
                this.mImageDetail = optJSONObject3.toString();
            }
            this.mValuationUrl = jSONObject.optString("operation_url");
            this.mValuationTxt = jSONObject.optString("operation_name");
            this.mTopicId = jSONObject.optLong("topic_id");
            this.mTopicName = jSONObject.optString(IntentConfig.TOPIC_NAME);
            return true;
        } catch (JSONException e2) {
            LogUtils.e("SmartMsg", "parseJsonString JSONException", e2);
            return false;
        }
    }

    public void setIcon(String str) {
        this.mIcon = str;
    }

    public boolean setJsonContent(String str, String str2, String str3, String str4, String str5, Commodity[] commodityArr, String str6) {
        if (TextUtils.isEmpty(str) || str2 == null || str4 == null) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("title", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("value", str2);
            jSONObject2.put("color", str3);
            jSONObject.put(Config.TRACE_VISIT_FIRST, jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("value", str4);
            jSONObject3.put("color", str5);
            jSONObject.put("remark", jSONObject3);
            if (commodityArr != null && commodityArr.length > 0) {
                for (Commodity commodity : commodityArr) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("name", commodity.getName());
                    jSONObject4.put("color", commodity.getColor());
                    jSONObject4.put("value", commodity.getValue());
                    jSONArray.put(jSONObject4);
                }
            }
            jSONObject.put("keywords", jSONArray);
            jSONObject.put("detail_url", str6);
            return setMsgContent(jSONObject.toString());
        } catch (Exception unused) {
            LogUtils.e("SmartMsg", "content error!");
            return false;
        }
    }

    public void setTopicId(long j) {
        this.mTopicId = j;
    }

    public void setTopicName(String str) {
        this.mTopicName = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mName);
        parcel.writeString(this.mIcon);
        parcel.writeString(this.mDetailurl);
        parcel.writeString(this.mShema);
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mFirstColor);
        parcel.writeString(this.mRemarkName);
        parcel.writeString(this.mRemarkColor);
        Commodity[] commodityArr = this.mCommodity;
        int length = commodityArr != null ? commodityArr.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeTypedArray(this.mCommodity, i);
        }
        parcel.writeString(this.mValuationUrl);
        parcel.writeString(this.mValuationTxt);
        parcel.writeLong(this.mTopicId);
        parcel.writeString(this.mTopicName);
    }

    public SmartMsg(Parcel parcel) {
        super(parcel);
        this.mTitle = parcel.readString();
        this.mName = parcel.readString();
        this.mIcon = parcel.readString();
        this.mDetailurl = parcel.readString();
        this.mShema = parcel.readString();
        this.mFirstName = parcel.readString();
        this.mFirstColor = parcel.readString();
        this.mRemarkName = parcel.readString();
        this.mRemarkColor = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            Commodity[] commodityArr = new Commodity[readInt];
            this.mCommodity = commodityArr;
            parcel.readTypedArray(commodityArr, Commodity.CREATOR);
        }
        this.mValuationUrl = parcel.readString();
        this.mValuationTxt = parcel.readString();
        this.mTopicId = parcel.readLong();
        this.mTopicName = parcel.readString();
    }
}
