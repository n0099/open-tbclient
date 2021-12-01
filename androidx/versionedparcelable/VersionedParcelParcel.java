package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.reflect.Method;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class VersionedParcelParcel extends VersionedParcel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "VersionedParcelParcel";
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurrentField;
    public final int mEnd;
    public int mFieldId;
    public int mNextRead;
    public final int mOffset;
    public final Parcel mParcel;
    public final SparseIntArray mPositionLookup;
    public final String mPrefix;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VersionedParcelParcel(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Parcel) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), (String) objArr2[3], (ArrayMap) objArr2[4], (ArrayMap) objArr2[5], (ArrayMap) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (i2 = this.mCurrentField) < 0) {
            return;
        }
        int i3 = this.mPositionLookup.get(i2);
        int dataPosition = this.mParcel.dataPosition();
        this.mParcel.setDataPosition(i3);
        this.mParcel.writeInt(dataPosition - i3);
        this.mParcel.setDataPosition(dataPosition);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Parcel parcel = this.mParcel;
            int dataPosition = parcel.dataPosition();
            int i2 = this.mNextRead;
            if (i2 == this.mOffset) {
                i2 = this.mEnd;
            }
            int i3 = i2;
            return new VersionedParcelParcel(parcel, dataPosition, i3, this.mPrefix + GlideException.IndentedAppendable.INDENT, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
        }
        return (VersionedParcel) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mParcel.readInt() != 0 : invokeV.booleanValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mParcel.readBundle(VersionedParcelParcel.class.getClassLoader()) : (Bundle) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int readInt = this.mParcel.readInt();
            if (readInt < 0) {
                return null;
            }
            byte[] bArr = new byte[readInt];
            this.mParcel.readByteArray(bArr);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel) : (CharSequence) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mParcel.readDouble() : invokeV.doubleValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            while (this.mNextRead < this.mEnd) {
                int i3 = this.mFieldId;
                if (i3 == i2) {
                    return true;
                }
                if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                    return false;
                }
                this.mParcel.setDataPosition(this.mNextRead);
                int readInt = this.mParcel.readInt();
                this.mFieldId = this.mParcel.readInt();
                this.mNextRead += readInt;
            }
            return this.mFieldId == i2;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mParcel.readFloat() : invokeV.floatValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mParcel.readInt() : invokeV.intValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mParcel.readLong() : invokeV.longValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (T) this.mParcel.readParcelable(VersionedParcelParcel.class.getClassLoader()) : (T) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mParcel.readString() : (String) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mParcel.readStrongBinder() : (IBinder) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            closeField();
            this.mCurrentField = i2;
            this.mPositionLookup.put(i2, this.mParcel.dataPosition());
            writeInt(0);
            writeInt(i2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mParcel.writeInt(z ? 1 : 0);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            this.mParcel.writeBundle(bundle);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bArr) == null) {
            if (bArr != null) {
                this.mParcel.writeInt(bArr.length);
                this.mParcel.writeByteArray(bArr);
                return;
            }
            this.mParcel.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, charSequence) == null) {
            TextUtils.writeToParcel(charSequence, this.mParcel, 0);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.mParcel.writeDouble(d2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.mParcel.writeFloat(f2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.mParcel.writeInt(i2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j2) == null) {
            this.mParcel.writeLong(j2);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, parcelable) == null) {
            this.mParcel.writeParcelable(parcelable, 0);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mParcel.writeString(str);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, iBinder) == null) {
            this.mParcel.writeStrongBinder(iBinder);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, iInterface) == null) {
            this.mParcel.writeStrongInterface(iInterface);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VersionedParcelParcel(Parcel parcel, int i2, int i3, String str, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel, Integer.valueOf(i2), Integer.valueOf(i3), str, arrayMap, arrayMap2, arrayMap3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ArrayMap) objArr2[0], (ArrayMap) objArr2[1], (ArrayMap) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mNextRead = 0;
        this.mFieldId = -1;
        this.mParcel = parcel;
        this.mOffset = i2;
        this.mEnd = i3;
        this.mNextRead = i2;
        this.mPrefix = str;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048594, this, bArr, i2, i3) == null) {
            if (bArr != null) {
                this.mParcel.writeInt(bArr.length);
                this.mParcel.writeByteArray(bArr, i2, i3);
                return;
            }
            this.mParcel.writeInt(-1);
        }
    }
}
