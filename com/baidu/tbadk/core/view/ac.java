package com.baidu.tbadk.core.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.view.PagerSlidingTabStrip;
/* loaded from: classes.dex */
class ac implements Parcelable.Creator<PagerSlidingTabStrip.SavedState> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: f */
    public PagerSlidingTabStrip.SavedState createFromParcel(Parcel parcel) {
        return new PagerSlidingTabStrip.SavedState(parcel, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: df */
    public PagerSlidingTabStrip.SavedState[] newArray(int i) {
        return new PagerSlidingTabStrip.SavedState[i];
    }
}
