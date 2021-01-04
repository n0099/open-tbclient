package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes5.dex */
public class UnguessableToken implements Parcelable {
    public static final Parcelable.Creator<UnguessableToken> CREATOR = new Parcelable.Creator<UnguessableToken>() { // from class: aegon.chrome.base.UnguessableToken.1
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public UnguessableToken createFromParcel(Parcel parcel) {
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            if (readLong == 0 || readLong2 == 0) {
                return null;
            }
            return new UnguessableToken(readLong, readLong2);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public UnguessableToken[] newArray(int i) {
            return new UnguessableToken[i];
        }
    };
    public final long mHigh;
    public final long mLow;

    public UnguessableToken(long j, long j2) {
        this.mHigh = j;
        this.mLow = j2;
    }

    @CalledByNative
    public static UnguessableToken create(long j, long j2) {
        return new UnguessableToken(j, j2);
    }

    @CalledByNative
    private UnguessableToken parcelAndUnparcelForTesting() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        UnguessableToken createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @CalledByNative
    public long getHighForSerialization() {
        return this.mHigh;
    }

    @CalledByNative
    public long getLowForSerialization() {
        return this.mLow;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mHigh);
        parcel.writeLong(this.mLow);
    }
}
