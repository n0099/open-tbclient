package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes4.dex */
final class a implements Parcelable.Creator<SuggestionResult> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public SuggestionResult createFromParcel(Parcel parcel) {
        return new SuggestionResult(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public SuggestionResult[] newArray(int i) {
        return new SuggestionResult[i];
    }
}
