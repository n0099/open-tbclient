package com.baidu.swan.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Slot implements Parcelable {
    public static final Parcelable.Creator<Slot> CREATOR = new Parcelable.Creator<Slot>() { // from class: com.baidu.swan.ubc.Slot.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: t */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fq */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long bpI;
    private JSONObject bpJ;
    private float bpK;
    private String mCategory;
    private long mStart;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.bpI = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.bpJ = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.bpI = 0L;
        this.mStart = parcel.readLong();
        this.bpI = parcel.readLong();
        this.mCategory = parcel.readString();
        this.bpK = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.bpI);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.bpK);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void C(long j) {
        if (j > 0 && j > this.mStart) {
            this.bpI = j;
            this.bpK = (((float) (this.bpI - this.mStart)) / 1000.0f) + this.bpK;
        }
    }

    public void aF(JSONObject jSONObject) {
        this.bpJ = jSONObject;
    }

    public boolean Tn() {
        return this.mStart > 0;
    }

    public boolean To() {
        return this.bpI > 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.bpI = 0L;
    }

    public JSONObject Tp() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.bpK <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.bpK));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.bpJ != null) {
                jSONObject.put("info", this.bpJ);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e3) {
            e = e3;
            e.printStackTrace();
            return jSONObject;
        }
    }
}
