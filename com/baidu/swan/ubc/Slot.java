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
        /* renamed from: fr */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long bpF;
    private JSONObject bpG;
    private float bpH;
    private String mCategory;
    private long mStart;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.bpF = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.bpG = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.bpF = 0L;
        this.mStart = parcel.readLong();
        this.bpF = parcel.readLong();
        this.mCategory = parcel.readString();
        this.bpH = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.bpF);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.bpH);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void C(long j) {
        if (j > 0 && j > this.mStart) {
            this.bpF = j;
            this.bpH = (((float) (this.bpF - this.mStart)) / 1000.0f) + this.bpH;
        }
    }

    public void aF(JSONObject jSONObject) {
        this.bpG = jSONObject;
    }

    public boolean Tp() {
        return this.mStart > 0;
    }

    public boolean Tq() {
        return this.bpF > 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.bpF = 0L;
    }

    public JSONObject Tr() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.bpH <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.bpH));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.bpG != null) {
                jSONObject.put("info", this.bpG);
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
