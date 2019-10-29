package com.baidu.swan.game.ad.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.baidu.swan.game.ad.a.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: v */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fO */
        public b[] newArray(int i) {
            return new b[i];
        }
    };
    private int a;
    private String b;
    private String c;
    private ArrayList<a> d;

    public b(String str) {
        this.a = 0;
        this.d = new ArrayList<>();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("ad");
                if (jSONArray != null) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            this.d.add(new a(jSONArray.getJSONObject(i)));
                        } catch (Exception e) {
                            this.d = new ArrayList<>();
                        }
                    }
                }
                this.a = jSONObject.optInt("n", 0);
                this.b = jSONObject.optString("req_id");
                this.c = jSONObject.optString("error_code", "");
            } catch (Exception e2) {
                this.d = new ArrayList<>();
            }
        }
    }

    protected b(Parcel parcel) {
        this.a = 0;
        this.d = new ArrayList<>();
        this.a = parcel.readInt();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public a VB() {
        if (this.d.size() > 0) {
            return this.d.get(0);
        }
        return null;
    }

    public String b() {
        return this.c;
    }

    public ArrayList<a> c() {
        return this.d;
    }
}
