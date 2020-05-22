package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class SwanTaskDeadEvent implements Parcelable {
    public static final Parcelable.Creator<SwanTaskDeadEvent> CREATOR = new Parcelable.Creator<SwanTaskDeadEvent>() { // from class: com.baidu.swan.apps.model.SwanTaskDeadEvent.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: v */
        public SwanTaskDeadEvent createFromParcel(Parcel parcel) {
            return new SwanTaskDeadEvent(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: fT */
        public SwanTaskDeadEvent[] newArray(int i) {
            return new SwanTaskDeadEvent[i];
        }
    };
    private static final char SEPARATOR = '#';
    private String appId;
    @Nullable
    private SparseArray<String[]> historyCache;
    private String pageScheme;
    private ArrayList<Integer> stackList;
    private int taskId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.taskId);
        parcel.writeString(this.pageScheme);
        parcel.writeList(this.stackList);
        parcel.writeSparseArray(this.historyCache);
    }

    public SwanTaskDeadEvent(String str, int i, String str2, ArrayList<Integer> arrayList) {
        this.appId = str;
        this.taskId = i;
        this.pageScheme = str2;
        this.stackList = arrayList;
    }

    protected SwanTaskDeadEvent(Parcel parcel) {
        this.appId = parcel.readString();
        this.taskId = parcel.readInt();
        this.pageScheme = parcel.readString();
        this.stackList = new ArrayList<>();
        parcel.readList(this.stackList, Integer.class.getClassLoader());
        this.historyCache = parcel.readSparseArray(String[].class.getClassLoader());
    }

    @Nullable
    public String getAppId() {
        return this.appId;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public String ajT() {
        return this.pageScheme;
    }

    public ArrayList<Integer> ajU() {
        return this.stackList;
    }

    @Nullable
    public SparseArray<SwanTaskDeadEvent> ajV() {
        if (this.historyCache == null) {
            return null;
        }
        SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.historyCache.size()) {
                return sparseArray;
            }
            sparseArray.put(this.historyCache.keyAt(i2), r(this.historyCache.valueAt(i2)));
            i = i2 + 1;
        }
    }

    public void a(@Nullable SparseArray<SwanTaskDeadEvent> sparseArray) {
        SparseArray<String[]> sparseArray2 = new SparseArray<>();
        if (sparseArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= sparseArray.size()) {
                    break;
                }
                if (sparseArray.valueAt(i2) != null) {
                    sparseArray2.put(sparseArray.keyAt(i2), sparseArray.valueAt(i2).ajW());
                }
                i = i2 + 1;
            }
        }
        this.historyCache = sparseArray2;
    }

    @NonNull
    private String[] ajW() {
        StringBuilder sb = new StringBuilder();
        if (this.stackList != null) {
            int size = this.stackList.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.stackList.get(i));
                if (i < size - 1) {
                    sb.append('#');
                }
            }
        }
        return new String[]{getAppId(), ajT(), sb.toString()};
    }

    @Nullable
    private static SwanTaskDeadEvent r(@Nullable String[] strArr) {
        String[] split;
        if (strArr == null || strArr.length != 3) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (strArr[2] != null) {
            for (String str : strArr[2].split(String.valueOf('#'))) {
                if (str != null && TextUtils.isDigitsOnly(str)) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
        }
        return new SwanTaskDeadEvent(strArr[0], -1, strArr[1], arrayList);
    }
}
