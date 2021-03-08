package com.baidu.swan.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class Slot implements Parcelable {
    public static final Parcelable.Creator<Slot> CREATOR = new Parcelable.Creator<Slot>() { // from class: com.baidu.swan.ubc.Slot.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: L */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: mp */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private static final int DEFAULT_VALUE = 0;
    private String mCategory;
    private float mDuration;
    private long mEnd;
    private JSONObject mOption;
    private long mStart;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.mEnd = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.mOption = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.mEnd = 0L;
        this.mStart = parcel.readLong();
        this.mEnd = parcel.readLong();
        this.mCategory = parcel.readString();
        this.mDuration = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.mEnd);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.mDuration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void setEnd(long j) {
        if (j > 0 && j > this.mStart) {
            this.mEnd = j;
            this.mDuration = (((float) (this.mEnd - this.mStart)) / 1000.0f) + this.mDuration;
        }
    }

    public void dj(JSONObject jSONObject) {
        this.mOption = jSONObject;
    }

    public boolean bfo() {
        return this.mStart > 0;
    }

    public boolean bfp() {
        return this.mEnd > 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.mEnd = 0L;
    }

    public JSONObject bfq() {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(this.mCategory) || this.mDuration <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.mDuration));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
            jSONObject = null;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.mOption != null) {
                jSONObject.put("info", this.mOption);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e2) {
            e = e2;
            e.printStackTrace();
            return jSONObject;
        }
    }
}
