package com.baidu.swan.ubc;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tieba.br4;
import com.baidu.tieba.el1;
import com.baidu.tieba.ir4;
import com.baidu.tieba.kr4;
import com.baidu.tieba.or4;
import com.baidu.tieba.vr4;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes4.dex */
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
    public ir4 mUbcContext;
    public boolean mValid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Flow() {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = br4.g();
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    public int getHandle() {
        return this.mHandle;
    }

    public String getId() {
        return this.mId;
    }

    public int getOption() {
        return this.mOption;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public boolean getValid() {
        return this.mValid;
    }

    public boolean isSampled() {
        return this.mIsSampled;
    }

    /* loaded from: classes4.dex */
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

    public Flow(Parcel parcel) {
        boolean z;
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = br4.g();
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mValid = z;
        this.mIsSampled = parcel.readByte() != 0;
        this.mSlotMaps = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public /* synthetic */ Flow(Parcel parcel, a aVar) {
        this(parcel);
    }

    public final void startSlot(String str, JSONObject jSONObject) {
        if (this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.mSlotMaps.get(str);
            if (slot == null) {
                this.mSlotMaps.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.setOption(jSONObject);
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

    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = br4.g();
        this.mId = str;
        this.mHandle = i;
        this.mOption = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    public final void addEvent(String str) {
        addEvent(str, null);
    }

    public final void endSlot(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.mSlotMaps.get(str)) != null && slot.isBegin()) {
            slot.setEnd(System.currentTimeMillis());
            slot.clean();
        }
    }

    public void setSampled(boolean z) {
        this.mIsSampled = z;
    }

    public void setValid(boolean z) {
        this.mValid = z;
    }

    public void setValue(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        setValue(jSONObject.toString());
    }

    public final void addEvent(String str, String str2) {
        if (!this.mValid) {
            return;
        }
        if (el1.g()) {
            if (vr4.a()) {
                kr4.f().m(this.mId, str, this.mHandle, str2, this.mOption);
            }
            ir4 ir4Var = this.mUbcContext;
            if (ir4Var != null && !this.mIsSampled) {
                ir4Var.g(this.mId, str, this.mHandle, str2, this.mOption);
                return;
            }
            return;
        }
        try {
            br4.f().flowAddEvent(this, str, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void addEvent(String str, String str2, long j) {
        if (!this.mValid) {
            return;
        }
        if (el1.g()) {
            if (vr4.a()) {
                kr4.f().n(this.mId, str, this.mHandle, str2, j, this.mOption);
            }
            ir4 ir4Var = this.mUbcContext;
            if (ir4Var != null && !this.mIsSampled) {
                ir4Var.n(this.mId, str, this.mHandle, str2, j, this.mOption);
                return;
            }
            return;
        }
        try {
            br4.f().flowAddEventWithTime(this, str, str2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void cancel() {
        if (!this.mValid) {
            return;
        }
        if (el1.g()) {
            if (vr4.a()) {
                kr4.f().c(this.mId, this.mHandle);
            }
            ir4 ir4Var = this.mUbcContext;
            if (ir4Var != null && !this.mIsSampled) {
                ir4Var.f(this.mId, this.mHandle);
                return;
            }
            return;
        }
        try {
            br4.f().flowCancel(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void end() {
        if (!this.mValid) {
            return;
        }
        if (el1.g()) {
            JSONArray jSONArray = new JSONArray();
            HashMap<String, Slot> hashMap = this.mSlotMaps;
            if (hashMap != null && (r1 = hashMap.entrySet().iterator()) != null) {
                for (Map.Entry<String, Slot> entry : hashMap.entrySet()) {
                    Slot value = entry.getValue();
                    if (value.isBegin() && !value.isEnded()) {
                        value.setEnd(System.currentTimeMillis());
                    }
                    JSONObject jSONObject = entry.getValue().getJSONObject();
                    if (jSONObject != null) {
                        jSONArray.put(jSONObject);
                    }
                }
            }
            if (vr4.a()) {
                kr4.f().e(this.mId, this.mHandle, jSONArray);
            }
            ir4 ir4Var = this.mUbcContext;
            if (ir4Var != null && !this.mIsSampled) {
                ir4Var.e(this.mId, this.mHandle, jSONArray);
                return;
            }
            return;
        }
        try {
            br4.f().flowEnd(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public final void setValue(String str) {
        if (!this.mValid) {
            return;
        }
        if (el1.g()) {
            if (vr4.a()) {
                kr4.f().p(this.mId, this.mHandle, str);
            }
            ir4 ir4Var = this.mUbcContext;
            if (ir4Var != null && !this.mIsSampled) {
                ir4Var.i(this.mId, this.mHandle, str);
                return;
            }
            return;
        }
        try {
            br4.f().flowSetValue(this, or4.b(str));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setValueWithDuration(String str) {
        if (!this.mValid) {
            return;
        }
        if (el1.g()) {
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
                    jSONObject.put(SpeedStatsUtils.UBC_KEY_OPTION, jSONObject2.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (vr4.a()) {
                kr4.f().p(this.mId, this.mHandle, jSONObject.toString());
            }
            ir4 ir4Var = this.mUbcContext;
            if (ir4Var != null && !this.mIsSampled) {
                ir4Var.i(this.mId, this.mHandle, jSONObject.toString());
                return;
            }
            return;
        }
        try {
            br4.f().flowSetValueWithDuration(this, or4.b(str));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
