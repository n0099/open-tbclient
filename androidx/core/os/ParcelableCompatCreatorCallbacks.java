package androidx.core.os;

import android.os.Parcel;
@Deprecated
/* loaded from: classes.dex */
public interface ParcelableCompatCreatorCallbacks {
    Object createFromParcel(Parcel parcel, ClassLoader classLoader);

    Object[] newArray(int i);
}
