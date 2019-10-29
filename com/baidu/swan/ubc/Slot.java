package com.baidu.swan.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Slot implements Parcelable {
    public static final Parcelable.Creator<Slot> CREATOR = new Parcelable.Creator<Slot>() { // from class: com.baidu.swan.ubc.Slot.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: E */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gZ */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long bPT;
    private JSONObject bPU;
    private float bPV;
    private String mCategory;
    private long mStart;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.bPT = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.bPU = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.bPT = 0L;
        this.mStart = parcel.readLong();
        this.bPT = parcel.readLong();
        this.mCategory = parcel.readString();
        this.bPV = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.bPT);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.bPV);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void ah(long j) {
        if (j > 0 && j > this.mStart) {
            this.bPT = j;
            this.bPV = (((float) (this.bPT - this.mStart)) / 1000.0f) + this.bPV;
        }
    }

    public void bp(JSONObject jSONObject) {
        this.bPU = jSONObject;
    }

    public boolean ade() {
        return this.mStart > 0;
    }

    public boolean adf() {
        return this.bPT > 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.bPT = 0L;
    }

    public JSONObject adg() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.bPV <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.bPV));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.bPU != null) {
                jSONObject.put(Config.LAUNCH_INFO, this.bPU);
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
