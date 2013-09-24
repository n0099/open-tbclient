package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class aa implements Parcelable.Creator<FragmentState> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public FragmentState createFromParcel(Parcel parcel) {
        return new FragmentState(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public FragmentState[] newArray(int i) {
        return new FragmentState[i];
    }
}
