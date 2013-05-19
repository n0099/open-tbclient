package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class r implements Parcelable.Creator {
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
