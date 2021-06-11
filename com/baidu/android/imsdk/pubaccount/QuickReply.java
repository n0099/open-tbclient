package com.baidu.android.imsdk.pubaccount;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.messages.DuPaBManualMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class QuickReply implements Parcelable {
    public static final Parcelable.Creator<QuickReply> CREATOR = new Parcelable.Creator<QuickReply>() { // from class: com.baidu.android.imsdk.pubaccount.QuickReply.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuickReply createFromParcel(Parcel parcel) {
            return new QuickReply(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QuickReply[] newArray(int i2) {
            return new QuickReply[i2];
        }
    };
    public static final int MENU_TYPE = 1;
    public static final String TAG = "QuickReply";
    public ArrayList<ReplyContent> mButtonList;
    public String mMenuName;
    public long mPaId;
    public String mPaName;
    public long mRefreshTime;
    public long mStatus;
    public long mTimeStamp;
    public long mType;
    public long mVersionId;

    /* loaded from: classes.dex */
    public static class Act implements Parcelable {
        public static final Parcelable.Creator<Act> CREATOR = new Parcelable.Creator<Act>() { // from class: com.baidu.android.imsdk.pubaccount.QuickReply.Act.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Act createFromParcel(Parcel parcel) {
                return new Act(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Act[] newArray(int i2) {
                return new Act[i2];
            }
        };
        public String mCallBackKey;
        public int mIsCallBack;
        public int mType;
        public String mValue;

        public Act() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCallBackKey() {
            return this.mCallBackKey;
        }

        public int getType() {
            return this.mType;
        }

        public String getValue() {
            return this.mValue;
        }

        public int isCallBack() {
            return this.mIsCallBack;
        }

        public void setCallBack(int i2) {
            this.mIsCallBack = i2;
        }

        public void setCallBackKey(String str) {
            this.mCallBackKey = str;
        }

        public void setType(int i2) {
            this.mType = i2;
        }

        public void setValue(String str) {
            this.mValue = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.mType);
            parcel.writeString(this.mValue);
            parcel.writeInt(this.mIsCallBack);
            parcel.writeString(this.mCallBackKey);
        }

        public Act(Parcel parcel) {
            this.mType = parcel.readInt();
            this.mValue = parcel.readString();
            this.mIsCallBack = parcel.readInt();
            this.mCallBackKey = parcel.readString();
        }
    }

    /* loaded from: classes.dex */
    public static class ReplyContent implements Parcelable {
        public static final Parcelable.Creator<ReplyContent> CREATOR = new Parcelable.Creator<ReplyContent>() { // from class: com.baidu.android.imsdk.pubaccount.QuickReply.ReplyContent.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ReplyContent createFromParcel(Parcel parcel) {
                return new ReplyContent(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ReplyContent[] newArray(int i2) {
                return new ReplyContent[i2];
            }
        };
        public Act mAct;
        public String mName;

        public ReplyContent() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Act getAct() {
            return this.mAct;
        }

        public String getName() {
            return this.mName;
        }

        public void setAct(Act act) {
            this.mAct = act;
        }

        public void setName(String str) {
            this.mName = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.mName);
            parcel.writeParcelable(this.mAct, i2);
        }

        public ReplyContent(Parcel parcel) {
            this.mName = parcel.readString();
            this.mAct = (Act) parcel.readParcelable(Act.class.getClassLoader());
        }
    }

    public QuickReply() {
    }

    public static QuickReply createQuickReply(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QuickReply quickReply = new QuickReply();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("custom_menu");
            quickReply.setType(jSONObject.optInt("type"));
            quickReply.setVersionId(jSONObject.getLong("version_id"));
            quickReply.setPaId(jSONObject.getLong("pa_uid"));
            quickReply.setStatus(jSONObject.getLong("status"));
            quickReply.setTimeStamp(jSONObject.getLong("ts"));
            quickReply.setRefreshTime(jSONObject.getLong("menu_refresh_ts"));
            quickReply.setMenuName(jSONObject.getString("name"));
            quickReply.setPaName(jSONObject.optString("src"));
            JSONArray jSONArray = jSONObject.getJSONArray("button_list");
            ArrayList<ReplyContent> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                ReplyContent replyContent = new ReplyContent();
                replyContent.setName(jSONObject2.getString("name"));
                if (jSONObject2.has("act")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("act");
                    Act act = new Act();
                    act.setType(jSONObject3.getInt("act_type"));
                    act.setValue(jSONObject3.getString("value"));
                    act.setCallBack(jSONObject3.getInt("is_callback"));
                    act.setCallBackKey(jSONObject3.getString(DuPaBManualMsg.B_CALLBACK_KEY));
                    replyContent.setAct(act);
                }
                arrayList.add(replyContent);
            }
            quickReply.setButtonList(arrayList);
            return quickReply;
        } catch (JSONException e2) {
            LogUtils.e(TAG, "create quickReply error " + e2.getMessage());
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ArrayList<ReplyContent> getButtonList() {
        return this.mButtonList;
    }

    public String getMenuName() {
        return this.mMenuName;
    }

    public long getPaId() {
        return this.mPaId;
    }

    public String getPaName() {
        return this.mPaName;
    }

    public long getRefreshTime() {
        return this.mRefreshTime;
    }

    public long getStatus() {
        return this.mStatus;
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public long getType() {
        return this.mType;
    }

    public long getVersionId() {
        return this.mVersionId;
    }

    public void setButtonList(ArrayList<ReplyContent> arrayList) {
        this.mButtonList = arrayList;
    }

    public void setMenuName(String str) {
        this.mMenuName = str;
    }

    public void setPaId(long j) {
        this.mPaId = j;
    }

    public void setPaName(String str) {
        this.mPaName = str;
    }

    public void setRefreshTime(long j) {
        this.mRefreshTime = j;
    }

    public void setStatus(long j) {
        this.mStatus = j;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public void setType(long j) {
        this.mType = j;
    }

    public void setVersionId(long j) {
        this.mVersionId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.mType);
        parcel.writeLong(this.mVersionId);
        parcel.writeLong(this.mPaId);
        parcel.writeLong(this.mStatus);
        parcel.writeLong(this.mTimeStamp);
        parcel.writeLong(this.mRefreshTime);
        parcel.writeString(this.mMenuName);
        parcel.writeString(this.mPaName);
        parcel.writeTypedList(this.mButtonList);
    }

    public QuickReply(Parcel parcel) {
        this.mType = parcel.readLong();
        this.mVersionId = parcel.readLong();
        this.mPaId = parcel.readLong();
        this.mStatus = parcel.readLong();
        this.mTimeStamp = parcel.readLong();
        this.mRefreshTime = parcel.readLong();
        this.mMenuName = parcel.readString();
        this.mPaName = parcel.readString();
        this.mButtonList = parcel.createTypedArrayList(ReplyContent.CREATOR);
    }
}
