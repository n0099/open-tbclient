package com.baidu.swan.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Slot implements Parcelable {
    public static final Parcelable.Creator<Slot> CREATOR = new a();
    public static final int DEFAULT_VALUE = 0;
    public String mCategory;
    public float mDuration;
    public long mEnd;
    public JSONObject mOption;
    public long mStart;

    /* loaded from: classes3.dex */
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

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.mEnd = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.mOption = jSONObject;
    }

    public void a() {
        this.mStart = 0L;
        this.mEnd = 0L;
    }

    public JSONObject b() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        if (TextUtils.isEmpty(this.mCategory)) {
            return null;
        }
        float f2 = this.mDuration;
        if (f2 > 0.0f) {
            String format = String.format("%.3f", Float.valueOf(f2));
            try {
                jSONObject = new JSONObject();
            } catch (JSONException e2) {
                e = e2;
            }
            try {
                jSONObject.put("id", this.mCategory);
                jSONObject.put("d", format);
                if (this.mOption != null) {
                    jSONObject.put("info", this.mOption);
                }
                return jSONObject;
            } catch (JSONException e3) {
                e = e3;
                jSONObject2 = jSONObject;
                e.printStackTrace();
                return jSONObject2;
            }
        }
        return null;
    }

    public boolean c() {
        return this.mStart > 0;
    }

    public boolean d() {
        return this.mEnd > 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(long j) {
        if (j > 0) {
            long j2 = this.mStart;
            if (j > j2) {
                this.mEnd = j;
                this.mDuration += ((float) (j - j2)) / 1000.0f;
            }
        }
    }

    public void f(JSONObject jSONObject) {
        this.mOption = jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.mEnd);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.mDuration);
    }

    public Slot(Parcel parcel) {
        this.mStart = 0L;
        this.mEnd = 0L;
        this.mStart = parcel.readLong();
        this.mEnd = parcel.readLong();
        this.mCategory = parcel.readString();
        this.mDuration = parcel.readFloat();
    }
}
