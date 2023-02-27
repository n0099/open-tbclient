package com.baidu.pass.ecommerce.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.sapi2.NoProguard;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
/* loaded from: classes2.dex */
public class MapObject implements NoProguard, Parcelable {
    public static final Parcelable.Creator<MapObject> CREATOR = new Parcelable.Creator<MapObject>() { // from class: com.baidu.pass.ecommerce.common.MapObject.1
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapObject createFromParcel(Parcel parcel) {
            return new MapObject(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MapObject[] newArray(int i) {
            return new MapObject[i];
        }
    };
    public HashMap<String, Object> nameValuePairs;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MapObject() {
        this.nameValuePairs = new LinkedHashMap();
    }

    public Iterator<String> keyIterator() {
        return this.nameValuePairs.keySet().iterator();
    }

    public MapObject(Parcel parcel) {
        this.nameValuePairs = parcel.readHashMap(Object.class.getClassLoader());
    }

    public int getIntValue(String str) {
        return ((Integer) this.nameValuePairs.get(str)).intValue();
    }

    public Object getObjValue(String str) {
        return this.nameValuePairs.get(str);
    }

    public String getStrValue(String str) {
        return (String) this.nameValuePairs.get(str);
    }

    public void putValue(String str, Object obj) {
        this.nameValuePairs.put(str, obj);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.nameValuePairs);
    }

    public String toString() {
        Set<String> keySet = this.nameValuePairs.keySet();
        StringBuilder sb = new StringBuilder();
        for (String str : keySet) {
            sb.append(str);
            sb.append("=");
            sb.append(getObjValue(str));
            sb.append(",");
        }
        return "MapObject{" + sb.toString() + '}';
    }
}
