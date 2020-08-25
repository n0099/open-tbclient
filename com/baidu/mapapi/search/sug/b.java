package com.baidu.mapapi.search.sug;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.sug.SuggestionResult;
/* loaded from: classes20.dex */
final class b implements Parcelable.Creator<SuggestionResult.SuggestionInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public SuggestionResult.SuggestionInfo createFromParcel(Parcel parcel) {
        return new SuggestionResult.SuggestionInfo(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public SuggestionResult.SuggestionInfo[] newArray(int i) {
        return new SuggestionResult.SuggestionInfo[i];
    }
}
