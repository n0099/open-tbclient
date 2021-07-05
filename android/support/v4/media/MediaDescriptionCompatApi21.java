package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.RequiresApi;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RequiresApi(21)
/* loaded from: classes.dex */
public class MediaDescriptionCompatApi21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Builder() {
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

        public static Object build(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) ? ((MediaDescription.Builder) obj).build() : invokeL.objValue;
        }

        public static Object newInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new MediaDescription.Builder() : invokeV.objValue;
        }

        public static void setDescription(Object obj, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, obj, charSequence) == null) {
                ((MediaDescription.Builder) obj).setDescription(charSequence);
            }
        }

        public static void setExtras(Object obj, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65540, null, obj, bundle) == null) {
                ((MediaDescription.Builder) obj).setExtras(bundle);
            }
        }

        public static void setIconBitmap(Object obj, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, bitmap) == null) {
                ((MediaDescription.Builder) obj).setIconBitmap(bitmap);
            }
        }

        public static void setIconUri(Object obj, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, uri) == null) {
                ((MediaDescription.Builder) obj).setIconUri(uri);
            }
        }

        public static void setMediaId(Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65543, null, obj, str) == null) {
                ((MediaDescription.Builder) obj).setMediaId(str);
            }
        }

        public static void setSubtitle(Object obj, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65544, null, obj, charSequence) == null) {
                ((MediaDescription.Builder) obj).setSubtitle(charSequence);
            }
        }

        public static void setTitle(Object obj, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65545, null, obj, charSequence) == null) {
                ((MediaDescription.Builder) obj).setTitle(charSequence);
            }
        }
    }

    public MediaDescriptionCompatApi21() {
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

    public static Object fromParcel(Parcel parcel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, parcel)) == null) ? MediaDescription.CREATOR.createFromParcel(parcel) : invokeL.objValue;
    }

    public static CharSequence getDescription(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) ? ((MediaDescription) obj).getDescription() : (CharSequence) invokeL.objValue;
    }

    public static Bundle getExtras(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? ((MediaDescription) obj).getExtras() : (Bundle) invokeL.objValue;
    }

    public static Bitmap getIconBitmap(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, obj)) == null) ? ((MediaDescription) obj).getIconBitmap() : (Bitmap) invokeL.objValue;
    }

    public static Uri getIconUri(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, obj)) == null) ? ((MediaDescription) obj).getIconUri() : (Uri) invokeL.objValue;
    }

    public static String getMediaId(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj)) == null) ? ((MediaDescription) obj).getMediaId() : (String) invokeL.objValue;
    }

    public static CharSequence getSubtitle(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? ((MediaDescription) obj).getSubtitle() : (CharSequence) invokeL.objValue;
    }

    public static CharSequence getTitle(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, obj)) == null) ? ((MediaDescription) obj).getTitle() : (CharSequence) invokeL.objValue;
    }

    public static void writeToParcel(Object obj, Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65545, null, obj, parcel, i2) == null) {
            ((MediaDescription) obj).writeToParcel(parcel, i2);
        }
    }
}
