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
        /* renamed from: w */
        public Slot createFromParcel(Parcel parcel) {
            return new Slot(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: ge */
        public Slot[] newArray(int i) {
            return new Slot[i];
        }
    };
    private long bxm;
    private JSONObject bxn;
    private float bxo;
    private String mCategory;
    private long mStart;

    public Slot(String str, long j, JSONObject jSONObject) {
        this.mStart = 0L;
        this.bxm = 0L;
        this.mStart = j;
        this.mCategory = str;
        this.bxn = jSONObject;
    }

    protected Slot(Parcel parcel) {
        this.mStart = 0L;
        this.bxm = 0L;
        this.mStart = parcel.readLong();
        this.bxm = parcel.readLong();
        this.mCategory = parcel.readString();
        this.bxo = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mStart);
        parcel.writeLong(this.bxm);
        parcel.writeString(this.mCategory);
        parcel.writeFloat(this.bxo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void O(long j) {
        if (j > 0 && j > this.mStart) {
            this.bxm = j;
            this.bxo = (((float) (this.bxm - this.mStart)) / 1000.0f) + this.bxo;
        }
    }

    public void aR(JSONObject jSONObject) {
        this.bxn = jSONObject;
    }

    public boolean Yo() {
        return this.mStart > 0;
    }

    public boolean Yp() {
        return this.bxm > 0;
    }

    public void clean() {
        this.mStart = 0L;
        this.bxm = 0L;
    }

    public JSONObject Yq() {
        JSONObject jSONObject;
        JSONException e;
        if (TextUtils.isEmpty(this.mCategory) || this.bxo <= 0.0f) {
            return null;
        }
        String format = String.format("%.3f", Float.valueOf(this.bxo));
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            jSONObject = null;
            e = e2;
        }
        try {
            jSONObject.put("id", this.mCategory);
            jSONObject.put("d", format);
            if (this.bxn != null) {
                jSONObject.put(Config.LAUNCH_INFO, this.bxn);
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
