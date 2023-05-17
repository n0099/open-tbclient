package com.baidu.swan.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class Slot implements Parcelable {
    public static final Parcelable.Creator<Slot> CREATOR = new a();
    public static final int DEFAULT_VALUE = 0;
    public String mCategory;
    public float mDuration;
    public long mEnd;
    public JSONObject mOption;
    public long mStart;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.mEnd = 0L;
    }

    public boolean isBegin() {
        if (this.mStart > 0) {
            return true;
        }
        return false;
    }

    public boolean isEnded() {
        if (this.mEnd > 0) {
            return true;
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<Slot> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    }

    public Slot(Parcel parcel) {
        this.mStart = 0L;
        this.mEnd = 0L;
        this.mStart = parcel.readLong();
        this.mEnd = parcel.readLong();
        this.mCategory = parcel.readString();
        this.mDuration = parcel.readFloat();
    }

    public void setCategory(String str) {
        this.mCategory = str;
    }

    public void setEnd(long j) {
        if (j > 0) {
            long j2 = this.mStart;
            if (j > j2) {
                this.mEnd = j;
                this.mDuration += ((float) (j - j2)) / 1000.0f;
            }
        }
    }

    public void setOption(JSONObject jSONObject) {
        this.mOption = jSONObject;
    }

    public void setStart(long j) {
        this.mStart = j;
        this.mEnd = 0L;
    }

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.mEnd = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.mOption = jSONObject;
    }

    public JSONObject getJSONObject() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (TextUtils.isEmpty(this.mCategory)) {
            return null;
        }
        float f = this.mDuration;
        if (f <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(f));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e) {
            e = e;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.mOption != null) {
                jSONObject.put("info", this.mOption);
            }
            return jSONObject;
        } catch (JSONException e2) {
            e = e2;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.mEnd);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.mDuration);
    }
}
