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
/* loaded from: classes2.dex */
public class Flow implements Parcelable {
    public static final Parcelable.Creator<Flow> CREATOR = new Parcelable.Creator<Flow>() { // from class: com.baidu.swan.ubc.Flow.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: gW */
        public Flow[] newArray(int i) {
            return new Flow[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: D */
        public Flow createFromParcel(Parcel parcel) {
            return new Flow(parcel);
        }
    };
    private k bOL;
    private int mHandle;
    private String mId;
    private int mOption;
    private HashMap<String, Slot> mSlotMaps;
    private long mStartTime;
    private boolean mValid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow() {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.bOL = s.adf();
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.bOL = s.adf();
        this.mId = str;
        this.mHandle = i;
        this.mOption = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    private Flow(Parcel parcel) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.bOL = s.adf();
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.mSlotMaps = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public final void addEvent(String str, String str2) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
                if (com.baidu.swan.b.d.adr()) {
                    m.acQ().a(this.mId, str, this.mHandle, str2, this.mOption);
                }
                if (this.bOL != null) {
                    this.bOL.a(this.mId, str, this.mHandle, str2, this.mOption);
                    return;
                }
                return;
            }
            try {
                s.acV().flowAddEvent(this, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void addEvent(String str, String str2, long j) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
                if (com.baidu.swan.b.d.adr()) {
                    m.acQ().a(this.mId, str, this.mHandle, str2, j, this.mOption);
                }
                if (this.bOL != null) {
                    this.bOL.a(this.mId, str, this.mHandle, str2, j, this.mOption);
                    return;
                }
                return;
            }
            try {
                s.acV().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setValue(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
                if (com.baidu.swan.b.d.adr()) {
                    m.acQ().e(this.mId, this.mHandle, str);
                }
                if (this.bOL != null) {
                    this.bOL.e(this.mId, this.mHandle, str);
                    return;
                }
                return;
            }
            try {
                s.acV().flowSetValue(this, r.lC(str));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setValueWithDuration(String str) {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
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
                if (com.baidu.swan.b.d.adr()) {
                    m.acQ().e(this.mId, this.mHandle, jSONObject.toString());
                }
                if (this.bOL != null) {
                    this.bOL.e(this.mId, this.mHandle, jSONObject.toString());
                    return;
                }
                return;
            }
            try {
                s.acV().flowSetValueWithDuration(this, r.lC(str));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void end() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
                JSONArray jSONArray = new JSONArray();
                if (this.mSlotMaps != null && (r3 = this.mSlotMaps.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : this.mSlotMaps.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.adc() && !value.add()) {
                            value.ag(System.currentTimeMillis());
                        }
                        JSONObject ade = entry.getValue().ade();
                        if (ade != null) {
                            jSONArray.put(ade);
                        }
                    }
                }
                if (com.baidu.swan.b.d.adr()) {
                    m.acQ().a(this.mId, this.mHandle, jSONArray);
                }
                if (this.bOL != null) {
                    this.bOL.a(this.mId, this.mHandle, jSONArray);
                    return;
                }
                return;
            }
            try {
                s.acV().flowEnd(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void cancel() {
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.Aa()) {
                if (com.baidu.swan.b.d.adr()) {
                    m.acQ().t(this.mId, this.mHandle);
                }
                if (this.bOL != null) {
                    this.bOL.t(this.mId, this.mHandle);
                    return;
                }
                return;
            }
            try {
                s.acV().flowCancel(this);
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
            slot.bq(jSONObject);
        }
    }

    public final void endSlot(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.mSlotMaps.get(str)) != null && slot.adc()) {
            slot.ag(System.currentTimeMillis());
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

    public long getStartTime() {
        return this.mStartTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValid(boolean z) {
        this.mValid = z;
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
        parcel.writeMap(this.mSlotMaps);
    }
}
