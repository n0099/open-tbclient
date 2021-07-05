package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public IconCompatParcelizer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static IconCompat read(VersionedParcel versionedParcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, versionedParcel)) == null) {
            IconCompat iconCompat = new IconCompat();
            iconCompat.mType = versionedParcel.readInt(iconCompat.mType, 1);
            iconCompat.mData = versionedParcel.readByteArray(iconCompat.mData, 2);
            iconCompat.mParcelable = versionedParcel.readParcelable(iconCompat.mParcelable, 3);
            iconCompat.mInt1 = versionedParcel.readInt(iconCompat.mInt1, 4);
            iconCompat.mInt2 = versionedParcel.readInt(iconCompat.mInt2, 5);
            iconCompat.mTintList = (ColorStateList) versionedParcel.readParcelable(iconCompat.mTintList, 6);
            iconCompat.mTintModeStr = versionedParcel.readString(iconCompat.mTintModeStr, 7);
            iconCompat.onPostParceling();
            return iconCompat;
        }
        return (IconCompat) invokeL.objValue;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, iconCompat, versionedParcel) == null) {
            versionedParcel.setSerializationFlags(true, true);
            iconCompat.onPreParceling(versionedParcel.isStream());
            int i2 = iconCompat.mType;
            if (-1 != i2) {
                versionedParcel.writeInt(i2, 1);
            }
            byte[] bArr = iconCompat.mData;
            if (bArr != null) {
                versionedParcel.writeByteArray(bArr, 2);
            }
            Parcelable parcelable = iconCompat.mParcelable;
            if (parcelable != null) {
                versionedParcel.writeParcelable(parcelable, 3);
            }
            int i3 = iconCompat.mInt1;
            if (i3 != 0) {
                versionedParcel.writeInt(i3, 4);
            }
            int i4 = iconCompat.mInt2;
            if (i4 != 0) {
                versionedParcel.writeInt(i4, 5);
            }
            ColorStateList colorStateList = iconCompat.mTintList;
            if (colorStateList != null) {
                versionedParcel.writeParcelable(colorStateList, 6);
            }
            String str = iconCompat.mTintModeStr;
            if (str != null) {
                versionedParcel.writeString(str, 7);
            }
        }
    }
}
