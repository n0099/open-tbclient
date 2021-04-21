package com.baidu.swan.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.searchbox.live.interfaces.DI;
import d.b.h0.n.e;
import d.b.h0.n.l;
import d.b.h0.n.n;
import d.b.h0.n.r;
import d.b.h0.o.d;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class Flow implements Parcelable {
    public static final Parcelable.Creator<Flow> CREATOR = new a();
    public static final boolean DEBUG = false;
    public static final int INVALID_HANDLE = -1;
    public static final String TAG = "UBCFlow";
    public int mHandle;
    public String mId;
    public boolean mIsSampled;
    public int mOption;
    public HashMap<String, Slot> mSlotMaps;
    public long mStartTime;
    public l mUbcContext;
    public boolean mValid;

    /* loaded from: classes3.dex */
    public static class a implements Parcelable.Creator<Flow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Flow createFromParcel(Parcel parcel) {
            return new Flow(parcel, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Flow[] newArray(int i) {
            return new Flow[i];
        }
    }

    public /* synthetic */ Flow(Parcel parcel, a aVar) {
        this(parcel);
    }

    public final void a(String str, String str2) {
        if (this.mValid) {
            if (d.b.c0.b.a.a.g()) {
                if (d.a()) {
                    n.k().q(this.mId, str, this.mHandle, str2, this.mOption);
                }
                l lVar = this.mUbcContext;
                if (lVar == null || this.mIsSampled) {
                    return;
                }
                lVar.f(this.mId, str, this.mHandle, str2, this.mOption);
                return;
            }
            try {
                e.f().flowAddEvent(this, str, str2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void b(String str, String str2, long j) {
        if (this.mValid) {
            if (d.b.c0.b.a.a.g()) {
                if (d.a()) {
                    n.k().r(this.mId, str, this.mHandle, str2, j, this.mOption);
                }
                l lVar = this.mUbcContext;
                if (lVar == null || this.mIsSampled) {
                    return;
                }
                lVar.m(this.mId, str, this.mHandle, str2, j, this.mOption);
                return;
            }
            try {
                e.f().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void c() {
        if (this.mValid) {
            if (d.b.c0.b.a.a.g()) {
                if (d.a()) {
                    n.k().h(this.mId, this.mHandle);
                }
                l lVar = this.mUbcContext;
                if (lVar == null || this.mIsSampled) {
                    return;
                }
                lVar.e(this.mId, this.mHandle);
                return;
            }
            try {
                e.f().flowCancel(this);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void d() {
        if (this.mValid) {
            if (d.b.c0.b.a.a.g()) {
                JSONArray jSONArray = new JSONArray();
                HashMap<String, Slot> hashMap = this.mSlotMaps;
                if (hashMap != null && (r1 = hashMap.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : hashMap.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.c() && !value.d()) {
                            value.e(System.currentTimeMillis());
                        }
                        JSONObject b2 = entry.getValue().b();
                        if (b2 != null) {
                            jSONArray.put(b2);
                        }
                    }
                }
                if (d.a()) {
                    n.k().j(this.mId, this.mHandle, jSONArray);
                }
                l lVar = this.mUbcContext;
                if (lVar == null || this.mIsSampled) {
                    return;
                }
                lVar.d(this.mId, this.mHandle, jSONArray);
                return;
            }
            try {
                e.f().flowEnd(this);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.mSlotMaps.get(str)) != null && slot.c()) {
            slot.e(System.currentTimeMillis());
            slot.a();
        }
    }

    public int f() {
        return this.mHandle;
    }

    public String g() {
        return this.mId;
    }

    public int h() {
        return this.mOption;
    }

    public long i() {
        return this.mStartTime;
    }

    public boolean j() {
        return this.mValid;
    }

    public boolean k() {
        return this.mIsSampled;
    }

    public void l(boolean z) {
        this.mIsSampled = z;
    }

    public void m(boolean z) {
        this.mValid = z;
    }

    public final void n(String str) {
        if (this.mValid) {
            if (d.b.c0.b.a.a.g()) {
                if (d.a()) {
                    n.k().t(this.mId, this.mHandle, str);
                }
                l lVar = this.mUbcContext;
                if (lVar == null || this.mIsSampled) {
                    return;
                }
                lVar.k(this.mId, this.mHandle, str);
                return;
            }
            try {
                e.f().flowSetValue(this, r.b(str));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void o(String str) {
        if (this.mValid) {
            if (d.b.c0.b.a.a.g()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - this.mStartTime)) / 1000.0f;
                    if (currentTimeMillis < 0.0f) {
                        currentTimeMillis = 0.0f;
                    }
                    jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis)));
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2.has(DI.APP_INFO_NAME)) {
                            jSONObject.putOpt(DI.APP_INFO_NAME, jSONObject2.optJSONObject(DI.APP_INFO_NAME));
                            jSONObject2.remove(DI.APP_INFO_NAME);
                        }
                        jSONObject.put("option", jSONObject2.toString());
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (d.a()) {
                    n.k().t(this.mId, this.mHandle, jSONObject.toString());
                }
                l lVar = this.mUbcContext;
                if (lVar == null || this.mIsSampled) {
                    return;
                }
                lVar.k(this.mId, this.mHandle, jSONObject.toString());
                return;
            }
            try {
                e.f().flowSetValueWithDuration(this, r.b(str));
            } catch (RemoteException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void p(String str, JSONObject jSONObject) {
        if (this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.mSlotMaps.get(str);
            if (slot == null) {
                this.mSlotMaps.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.f(jSONObject);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mHandle);
        parcel.writeInt(this.mOption);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte(this.mValid ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mIsSampled ? (byte) 1 : (byte) 0);
        parcel.writeMap(this.mSlotMaps);
    }

    public Flow() {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = e.g();
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = e.g();
        this.mId = str;
        this.mHandle = i;
        this.mOption = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    public Flow(Parcel parcel) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = e.g();
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.mIsSampled = parcel.readByte() != 0;
        this.mSlotMaps = parcel.readHashMap(HashMap.class.getClassLoader());
    }
}
