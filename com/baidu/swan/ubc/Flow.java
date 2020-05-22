package com.baidu.swan.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class Flow implements Parcelable {
    public static final Parcelable.Creator<Flow> CREATOR = new Parcelable.Creator<Flow>() { // from class: com.baidu.swan.ubc.Flow.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: jx */
        public Flow[] newArray(int i) {
            return new Flow[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: G */
        public Flow createFromParcel(Parcel parcel) {
            return new Flow(parcel);
        }
    };
    private static final boolean DEBUG = false;
    private static final int INVALID_HANDLE = -1;
    public static final String TAG = "UBCFlow";
    private int mHandle;
    private String mId;
    private boolean mIsSampled;
    private int mOption;
    private HashMap<String, Slot> mSlotMaps;
    private long mStartTime;
    private l mUbcContext;
    private boolean mValid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow() {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = e.aIh();
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = e.aIh();
        this.mId = str;
        this.mHandle = i;
        this.mOption = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    private Flow(Parcel parcel) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.mUbcContext = e.aIh();
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.mIsSampled = parcel.readByte() != 0;
        this.mSlotMaps = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public final void addEvent(String str, String str2) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                if (com.baidu.swan.d.d.aJb()) {
                    n.aID().a(this.mId, str, this.mHandle, str2, this.mOption);
                }
                if (this.mUbcContext != null && !this.mIsSampled) {
                    this.mUbcContext.a(this.mId, str, this.mHandle, str2, this.mOption);
                    return;
                }
                return;
            }
            try {
                e.aIi().flowAddEvent(this, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void addEvent(String str, String str2, long j) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                if (com.baidu.swan.d.d.aJb()) {
                    n.aID().a(this.mId, str, this.mHandle, str2, j, this.mOption);
                }
                if (this.mUbcContext != null && !this.mIsSampled) {
                    this.mUbcContext.a(this.mId, str, this.mHandle, str2, j, this.mOption);
                    return;
                }
                return;
            }
            try {
                e.aIi().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setValue(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                if (com.baidu.swan.d.d.aJb()) {
                    n.aID().f(this.mId, this.mHandle, str);
                }
                if (this.mUbcContext != null && !this.mIsSampled) {
                    this.mUbcContext.f(this.mId, this.mHandle, str);
                    return;
                }
                return;
            }
            try {
                e.aIi().flowSetValue(this, s.tS(str));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setValueWithDuration(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - this.mStartTime)) / 1000.0f;
                    jSONObject.put("duration", String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis >= 0.0f ? currentTimeMillis : 0.0f)));
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2.has("appInfo")) {
                            jSONObject.putOpt("appInfo", jSONObject2.optJSONObject("appInfo"));
                            jSONObject2.remove("appInfo");
                        }
                        jSONObject.put("option", jSONObject2.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (com.baidu.swan.d.d.aJb()) {
                    n.aID().f(this.mId, this.mHandle, jSONObject.toString());
                }
                if (this.mUbcContext != null && !this.mIsSampled) {
                    this.mUbcContext.f(this.mId, this.mHandle, jSONObject.toString());
                    return;
                }
                return;
            }
            try {
                e.aIi().flowSetValueWithDuration(this, s.tS(str));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void end() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                JSONArray jSONArray = new JSONArray();
                if (this.mSlotMaps != null && (r3 = this.mSlotMaps.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : this.mSlotMaps.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.aIN() && !value.aIO()) {
                            value.setEnd(System.currentTimeMillis());
                        }
                        JSONObject aIP = entry.getValue().aIP();
                        if (aIP != null) {
                            jSONArray.put(aIP);
                        }
                    }
                }
                if (com.baidu.swan.d.d.aJb()) {
                    n.aID().a(this.mId, this.mHandle, jSONArray);
                }
                if (this.mUbcContext != null && !this.mIsSampled) {
                    this.mUbcContext.a(this.mId, this.mHandle, jSONArray);
                    return;
                }
                return;
            }
            try {
                e.aIi().flowEnd(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void cancel() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.OS()) {
                if (com.baidu.swan.d.d.aJb()) {
                    n.aID().G(this.mId, this.mHandle);
                }
                if (this.mUbcContext != null && !this.mIsSampled) {
                    this.mUbcContext.G(this.mId, this.mHandle);
                    return;
                }
                return;
            }
            try {
                e.aIi().flowCancel(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void startSlot(String str, JSONObject jSONObject) {
        if (this.mValid && !TextUtils.isEmpty(str)) {
            Slot slot = this.mSlotMaps.get(str);
            if (slot == null) {
                this.mSlotMaps.put(str, new Slot(str, System.currentTimeMillis(), jSONObject));
                return;
            }
            slot.cu(jSONObject);
        }
    }

    public final void endSlot(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.mSlotMaps.get(str)) != null && slot.aIN()) {
            slot.setEnd(System.currentTimeMillis());
            slot.clean();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getId() {
        return this.mId;
    }

    public int getHandle() {
        return this.mHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOption() {
        return this.mOption;
    }

    public boolean getValid() {
        return this.mValid;
    }

    public boolean aIz() {
        return this.mIsSampled;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValid(boolean z) {
        this.mValid = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void go(boolean z) {
        this.mIsSampled = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mHandle);
        parcel.writeInt(this.mOption);
        parcel.writeLong(this.mStartTime);
        parcel.writeByte((byte) (this.mValid ? 1 : 0));
        parcel.writeByte((byte) (this.mIsSampled ? 1 : 0));
        parcel.writeMap(this.mSlotMaps);
    }
}
