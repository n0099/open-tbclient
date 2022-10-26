package androidx.media2.session;

import androidx.core.util.ObjectsCompat;
import androidx.media2.common.Rating;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ThumbRating implements Rating {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsRated;
    public boolean mThumbUp;

    public ThumbRating() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsRated = false;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ObjectsCompat.hash(Boolean.valueOf(this.mIsRated), Boolean.valueOf(this.mThumbUp));
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.common.Rating
    public boolean isRated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mIsRated;
        }
        return invokeV.booleanValue;
    }

    public boolean isThumbUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mThumbUp;
        }
        return invokeV.booleanValue;
    }

    public ThumbRating(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mThumbUp = z;
        this.mIsRated = true;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof ThumbRating)) {
                return false;
            }
            ThumbRating thumbRating = (ThumbRating) obj;
            if (this.mThumbUp != thumbRating.mThumbUp || this.mIsRated != thumbRating.mIsRated) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ThumbRating: ");
            if (this.mIsRated) {
                str = "isThumbUp=" + this.mThumbUp;
            } else {
                str = "unrated";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
