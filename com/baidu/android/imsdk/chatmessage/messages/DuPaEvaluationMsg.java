package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class DuPaEvaluationMsg extends ChatMsg {
    public static final Parcelable.Creator<DuPaEvaluationMsg> CREATOR = new Parcelable.Creator<DuPaEvaluationMsg>() { // from class: com.baidu.android.imsdk.chatmessage.messages.DuPaEvaluationMsg.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DuPaEvaluationMsg createFromParcel(Parcel parcel) {
            return new DuPaEvaluationMsg(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DuPaEvaluationMsg[] newArray(int i) {
            return new DuPaEvaluationMsg[i];
        }
    };
    private static final String TAG = "DuPaEvaluationMsg";
    private String mCallbackKey;
    private List<EvaluationItem> mItems;
    private String mText;

    public DuPaEvaluationMsg() {
        this.mItems = new ArrayList();
        setMsgType(33);
    }

    public DuPaEvaluationMsg(String str) {
        this();
        this.mCallbackKey = str;
        setMsgContent(getEvaluationContentJson());
    }

    private DuPaEvaluationMsg(Parcel parcel) {
        super(parcel);
        this.mItems = new ArrayList();
        this.mText = parcel.readString();
        this.mItems = parcel.createTypedArrayList(EvaluationItem.CREATOR);
        this.mCallbackKey = parcel.readString();
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    protected boolean parseJsonString() {
        String jsonContent = getJsonContent();
        if (TextUtils.isEmpty(jsonContent)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(jsonContent);
            this.mText = jSONObject.optString("text");
            this.mItems.clear();
            JSONArray optJSONArray = jSONObject.optJSONArray("evaluations");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    this.mItems.add(new EvaluationItem(jSONObject2.optString("title"), jSONObject2.optString("callback_key")));
                }
            }
            return true;
        } catch (JSONException e) {
            LogUtils.e(TAG, "parse json err!", e);
            return false;
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        return this.mText;
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public List<EvaluationItem> getEvaluationItems() {
        return this.mItems;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mText);
        parcel.writeTypedList(this.mItems);
        parcel.writeString(this.mCallbackKey);
    }

    private String getEvaluationContentJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("callback_key", this.mCallbackKey);
        } catch (JSONException e) {
            LogUtils.e(LogUtils.TAG, "getManualContentJson :", e);
        }
        return jSONObject.toString();
    }

    /* loaded from: classes18.dex */
    public static class EvaluationItem implements Parcelable {
        public static final Parcelable.Creator<EvaluationItem> CREATOR = new Parcelable.Creator<EvaluationItem>() { // from class: com.baidu.android.imsdk.chatmessage.messages.DuPaEvaluationMsg.EvaluationItem.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EvaluationItem createFromParcel(Parcel parcel) {
                return new EvaluationItem(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public EvaluationItem[] newArray(int i) {
                return new EvaluationItem[i];
            }
        };
        public String mCallbackKey;
        public String mTitle;

        public EvaluationItem() {
        }

        public EvaluationItem(String str, String str2) {
            this.mTitle = str;
            this.mCallbackKey = str2;
        }

        public EvaluationItem(Parcel parcel) {
            this.mTitle = parcel.readString();
            this.mCallbackKey = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mCallbackKey);
        }
    }
}
