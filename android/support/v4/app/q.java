package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class q implements Parcelable.Creator {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public FragmentManagerState createFromParcel(Parcel parcel) {
        return new FragmentManagerState(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public FragmentManagerState[] newArray(int i) {
        return new FragmentManagerState[i];
    }
}
