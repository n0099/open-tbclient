package com.baidu.swan.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class SwanTaskDeadEvent implements Parcelable {
    public static final Parcelable.Creator<SwanTaskDeadEvent> CREATOR = new a();
    public static final char SEPARATOR = '#';
    public String appId;
    @Nullable
    public SparseArray<String[]> historyCache;
    public String pageScheme;
    public ArrayList<Integer> stackList;
    public int taskId;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<SwanTaskDeadEvent> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SwanTaskDeadEvent createFromParcel(Parcel parcel) {
            return new SwanTaskDeadEvent(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SwanTaskDeadEvent[] newArray(int i) {
            return new SwanTaskDeadEvent[i];
        }
    }

    public SwanTaskDeadEvent(String str, int i, String str2, ArrayList<Integer> arrayList) {
        this.appId = str;
        this.taskId = i;
        this.pageScheme = str2;
        this.stackList = arrayList;
    }

    @Nullable
    public static SwanTaskDeadEvent f(@Nullable String[] strArr) {
        String[] split;
        if (strArr == null || strArr.length != 3) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (strArr[2] != null) {
            for (String str : strArr[2].split(String.valueOf((char) SEPARATOR))) {
                if (str != null && TextUtils.isDigitsOnly(str)) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
        }
        return new SwanTaskDeadEvent(strArr[0], -1, strArr[1], arrayList);
    }

    @Nullable
    public String a() {
        return this.appId;
    }

    @Nullable
    public SparseArray<SwanTaskDeadEvent> b() {
        if (this.historyCache == null) {
            return null;
        }
        SparseArray<SwanTaskDeadEvent> sparseArray = new SparseArray<>();
        for (int i = 0; i < this.historyCache.size(); i++) {
            sparseArray.put(this.historyCache.keyAt(i), f(this.historyCache.valueAt(i)));
        }
        return sparseArray;
    }

    public String c() {
        return this.pageScheme;
    }

    public ArrayList<Integer> d() {
        return this.stackList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.taskId;
    }

    public void g(@Nullable SparseArray<SwanTaskDeadEvent> sparseArray) {
        SparseArray<String[]> sparseArray2 = new SparseArray<>();
        if (sparseArray != null) {
            for (int i = 0; i < sparseArray.size(); i++) {
                if (sparseArray.valueAt(i) != null) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i).h());
                }
            }
        }
        this.historyCache = sparseArray2;
    }

    @NonNull
    public final String[] h() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arrayList = this.stackList;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.stackList.get(i));
                if (i < size - 1) {
                    sb.append(SEPARATOR);
                }
            }
        }
        return new String[]{a(), c(), sb.toString()};
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.taskId);
        parcel.writeString(this.pageScheme);
        parcel.writeList(this.stackList);
        parcel.writeSparseArray(this.historyCache);
    }

    public SwanTaskDeadEvent(Parcel parcel) {
        this.appId = parcel.readString();
        this.taskId = parcel.readInt();
        this.pageScheme = parcel.readString();
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.stackList = arrayList;
        parcel.readList(arrayList, Integer.class.getClassLoader());
        this.historyCache = parcel.readSparseArray(String[].class.getClassLoader());
    }
}
