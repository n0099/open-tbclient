package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
final class k implements Parcelable.Creator<BackStackState> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BackStackState createFromParcel(Parcel parcel) {
        return new BackStackState(parcel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public BackStackState[] newArray(int i) {
        return new BackStackState[i];
    }
}
