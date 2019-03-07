package com.baidu.swan.ubc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ubc.UBC;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Flow implements Parcelable {
    private k bpq;
    private int mHandle;
    private String mId;
    private int mOption;
    private HashMap<String, Slot> mSlotMaps;
    private long mStartTime;
    private boolean mValid;
    private static final boolean DEBUG = g.DEBUG;
    public static final Parcelable.Creator<Flow> CREATOR = new Parcelable.Creator<Flow>() { // from class: com.baidu.swan.ubc.Flow.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fp */
        public Flow[] newArray(int i) {
            return new Flow[i];
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: s */
        public Flow createFromParcel(Parcel parcel) {
            return new Flow(parcel);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow() {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.bpq = r.Ts();
        this.mId = "";
        this.mHandle = -1;
        this.mOption = 0;
        this.mStartTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Flow(String str, int i, int i2) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.bpq = r.Ts();
        this.mId = str;
        this.mHandle = i;
        this.mOption = i2;
        this.mStartTime = System.currentTimeMillis();
    }

    private Flow(Parcel parcel) {
        this.mValid = true;
        this.mSlotMaps = new HashMap<>();
        this.bpq = r.Ts();
        this.mId = parcel.readString();
        this.mHandle = parcel.readInt();
        this.mOption = parcel.readInt();
        this.mStartTime = parcel.readLong();
        this.mValid = parcel.readByte() != 0;
        this.mSlotMaps = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public final void addEvent(String str, String str2) {
        if (DEBUG) {
            Log.d(com.baidu.ubc.Flow.TAG, " flow addEvent, mId:" + this.mId + " handle" + this.mHandle + " eventId:" + str + " value:" + str2 + " mValid:" + this.mValid);
        }
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
                if (com.baidu.swan.b.c.TE()) {
                    m.Tk().a(this.mId, str, this.mHandle, str2, this.mOption);
                }
                if (this.bpq != null) {
                    this.bpq.a(this.mId, str, this.mHandle, str2, this.mOption);
                    return;
                }
                return;
            }
            try {
                r.Tm().flowAddEvent(this, str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void addEvent(String str, String str2, long j) {
        if (DEBUG) {
            Log.d(com.baidu.ubc.Flow.TAG, " flow addEvent, mId:" + this.mId + " handle" + this.mHandle + " eventId:" + str + " value:" + str2 + " mValid:" + this.mValid);
        }
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
                if (com.baidu.swan.b.c.TE()) {
                    m.Tk().a(this.mId, str, this.mHandle, str2, j, this.mOption);
                }
                if (this.bpq != null) {
                    this.bpq.a(this.mId, str, this.mHandle, str2, j, this.mOption);
                    return;
                }
                return;
            }
            try {
                r.Tm().flowAddEventWithTime(this, str, str2, j);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void setValue(String str) {
        if (DEBUG) {
            Log.d(com.baidu.ubc.Flow.TAG, " flow setValue, mId:" + this.mId + " handle" + this.mHandle + " value:" + str + " mValid:" + this.mValid);
        }
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
                if (com.baidu.swan.b.c.TE()) {
                    m.Tk().c(this.mId, this.mHandle, str);
                }
                if (this.bpq != null) {
                    this.bpq.c(this.mId, this.mHandle, str);
                    return;
                }
                return;
            }
            try {
                r.Tm().flowSetValue(this, q.jR(str));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setValueWithDuration(String str) {
        if (DEBUG) {
            Log.d(com.baidu.ubc.Flow.TAG, " flow setValueWithDuration, mId:" + this.mId + " handle: " + this.mHandle + " value:" + str + " mValid:" + this.mValid);
        }
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    float currentTimeMillis = ((float) (System.currentTimeMillis() - this.mStartTime)) / 1000.0f;
                    jSONObject.put(UBC.CONTENT_KEY_DURATION, String.format(Locale.ENGLISH, "%.3f", Float.valueOf(currentTimeMillis >= 0.0f ? currentTimeMillis : 0.0f)));
                    if (!TextUtils.isEmpty(str)) {
                        JSONObject jSONObject2 = new JSONObject(str);
                        if (jSONObject2.has("appInfo")) {
                            jSONObject.putOpt("appInfo", jSONObject2.optJSONObject("appInfo"));
                            jSONObject2.remove("appInfo");
                        }
                        jSONObject.put("option", jSONObject2.toString());
                    }
                    if (DEBUG) {
                        Log.d(com.baidu.ubc.Flow.TAG, " flow setValueWithDuration, mId:" + this.mId + ", duration: " + jSONObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (com.baidu.swan.b.c.TE()) {
                    m.Tk().c(this.mId, this.mHandle, jSONObject.toString());
                }
                if (this.bpq != null) {
                    this.bpq.c(this.mId, this.mHandle, jSONObject.toString());
                    return;
                }
                return;
            }
            try {
                r.Tm().flowSetValueWithDuration(this, q.jR(str));
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void end() {
        if (DEBUG) {
            Log.d(com.baidu.ubc.Flow.TAG, "end flow, mId:" + this.mId + " handle" + this.mHandle + " mValid:" + this.mValid);
        }
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
                JSONArray jSONArray = new JSONArray();
                if (this.mSlotMaps != null && (r3 = this.mSlotMaps.entrySet().iterator()) != null) {
                    for (Map.Entry<String, Slot> entry : this.mSlotMaps.entrySet()) {
                        Slot value = entry.getValue();
                        if (value.Tp() && !value.Tq()) {
                            value.C(System.currentTimeMillis());
                        }
                        JSONObject Tr = entry.getValue().Tr();
                        if (Tr != null) {
                            jSONArray.put(Tr);
                        }
                    }
                }
                if (com.baidu.swan.b.c.TE()) {
                    m.Tk().a(this.mId, this.mHandle, jSONArray);
                }
                if (this.bpq != null) {
                    this.bpq.a(this.mId, this.mHandle, jSONArray);
                    return;
                }
                return;
            }
            try {
                r.Tm().flowEnd(this);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public final void cancel() {
        if (DEBUG) {
            Log.d(com.baidu.ubc.Flow.TAG, "cancel flow, mId:" + this.mId + " handle" + this.mHandle + " mValid:" + this.mValid);
        }
        if (this.mValid) {
            if (com.baidu.pyramid.runtime.multiprocess.a.tR()) {
                if (com.baidu.swan.b.c.TE()) {
                    m.Tk().y(this.mId, this.mHandle);
                }
                if (this.bpq != null) {
                    this.bpq.y(this.mId, this.mHandle);
                    return;
                }
                return;
            }
            try {
                r.Tm().flowCancel(this);
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
            slot.aF(jSONObject);
        }
    }

    public final void endSlot(String str) {
        Slot slot;
        if (this.mValid && !TextUtils.isEmpty(str) && (slot = this.mSlotMaps.get(str)) != null && slot.Tp()) {
            slot.C(System.currentTimeMillis());
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
