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
public final class StarRating implements Rating {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float RATING_NOT_RATED = -1.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public int mMaxStars;
    public float mStarRating;

    public StarRating() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public int getMaxStars() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mMaxStars;
        }
        return invokeV.intValue;
    }

    public float getStarRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mStarRating;
        }
        return invokeV.floatValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ObjectsCompat.hash(Integer.valueOf(this.mMaxStars), Float.valueOf(this.mStarRating));
        }
        return invokeV.intValue;
    }

    @Override // androidx.media2.common.Rating
    public boolean isRated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mStarRating >= 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public StarRating(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i > 0) {
            this.mMaxStars = i;
            this.mStarRating = -1.0f;
            return;
        }
        throw new IllegalArgumentException("maxStars should be a positive integer");
    }

    public StarRating(int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Float.valueOf(f)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (i > 0) {
            if (f >= 0.0f && f <= i) {
                this.mMaxStars = i;
                this.mStarRating = f;
                return;
            }
            throw new IllegalArgumentException("starRating is out of range [0, maxStars]");
        }
        throw new IllegalArgumentException("maxStars should be a positive integer");
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (!(obj instanceof StarRating)) {
                return false;
            }
            StarRating starRating = (StarRating) obj;
            if (this.mMaxStars != starRating.mMaxStars || this.mStarRating != starRating.mStarRating) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("StarRating: maxStars=");
            sb.append(this.mMaxStars);
            if (isRated()) {
                str = ", starRating=" + this.mStarRating;
            } else {
                str = ", unrated";
            }
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
