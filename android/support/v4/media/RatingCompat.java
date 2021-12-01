package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<RatingCompat> CREATOR;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    public static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    public static final String TAG = "Rating";
    public transient /* synthetic */ FieldHolder $fh;
    public Object mRatingObj;
    public final int mRatingStyle;
    public final float mRatingValue;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface Style {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1288175020, "Landroid/support/v4/media/RatingCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1288175020, "Landroid/support/v4/media/RatingCompat;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RatingCompat createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new RatingCompat(parcel.readInt(), parcel.readFloat()) : (RatingCompat) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RatingCompat[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new RatingCompat[i2] : (RatingCompat[]) invokeI.objValue;
            }
        };
    }

    public RatingCompat(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRatingStyle = i2;
        this.mRatingValue = f2;
    }

    public static RatingCompat fromRating(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            RatingCompat ratingCompat = null;
            if (obj != null && Build.VERSION.SDK_INT >= 19) {
                Rating rating = (Rating) obj;
                int ratingStyle = rating.getRatingStyle();
                if (rating.isRated()) {
                    switch (ratingStyle) {
                        case 1:
                            ratingCompat = newHeartRating(rating.hasHeart());
                            break;
                        case 2:
                            ratingCompat = newThumbRating(rating.isThumbUp());
                            break;
                        case 3:
                        case 4:
                        case 5:
                            ratingCompat = newStarRating(ratingStyle, rating.getStarRating());
                            break;
                        case 6:
                            ratingCompat = newPercentageRating(rating.getPercentRating());
                            break;
                        default:
                            return null;
                    }
                } else {
                    ratingCompat = newUnratedRating(ratingStyle);
                }
                ratingCompat.mRatingObj = obj;
            }
            return ratingCompat;
        }
        return (RatingCompat) invokeL.objValue;
    }

    public static RatingCompat newHeartRating(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            return new RatingCompat(1, z ? 1.0f : 0.0f);
        }
        return (RatingCompat) invokeZ.objValue;
    }

    public static RatingCompat newPercentageRating(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TRACKBALL, null, f2)) == null) {
            if (f2 < 0.0f || f2 > 100.0f) {
                return null;
            }
            return new RatingCompat(6, f2);
        }
        return (RatingCompat) invokeF.objValue;
    }

    public static RatingCompat newStarRating(int i2, float f2) {
        InterceptResult invokeCommon;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            if (i2 == 3) {
                f3 = 3.0f;
            } else if (i2 == 4) {
                f3 = 4.0f;
            } else if (i2 != 5) {
                String str = "Invalid rating style (" + i2 + ") for a star rating";
                return null;
            } else {
                f3 = 5.0f;
            }
            if (f2 < 0.0f || f2 > f3) {
                return null;
            }
            return new RatingCompat(i2, f2);
        }
        return (RatingCompat) invokeCommon.objValue;
    }

    public static RatingCompat newThumbRating(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65542, null, z)) == null) {
            return new RatingCompat(2, z ? 1.0f : 0.0f);
        }
        return (RatingCompat) invokeZ.objValue;
    }

    public static RatingCompat newUnratedRating(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return new RatingCompat(i2, -1.0f);
                default:
                    return null;
            }
        }
        return (RatingCompat) invokeI.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRatingStyle : invokeV.intValue;
    }

    public float getPercentRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.mRatingStyle == 6 && isRated()) {
                return this.mRatingValue;
            }
            return -1.0f;
        }
        return invokeV.floatValue;
    }

    public Object getRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mRatingObj == null && Build.VERSION.SDK_INT >= 19) {
                if (isRated()) {
                    int i2 = this.mRatingStyle;
                    switch (i2) {
                        case 1:
                            this.mRatingObj = Rating.newHeartRating(hasHeart());
                            break;
                        case 2:
                            this.mRatingObj = Rating.newThumbRating(isThumbUp());
                            break;
                        case 3:
                        case 4:
                        case 5:
                            this.mRatingObj = Rating.newStarRating(i2, getStarRating());
                            break;
                        case 6:
                            this.mRatingObj = Rating.newPercentageRating(getPercentRating());
                            break;
                        default:
                            return null;
                    }
                } else {
                    this.mRatingObj = Rating.newUnratedRating(this.mRatingStyle);
                }
            }
            return this.mRatingObj;
        }
        return invokeV.objValue;
    }

    public int getRatingStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRatingStyle : invokeV.intValue;
    }

    public float getStarRating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.mRatingStyle;
            if ((i2 == 3 || i2 == 4 || i2 == 5) && isRated()) {
                return this.mRatingValue;
            }
            return -1.0f;
        }
        return invokeV.floatValue;
    }

    public boolean hasHeart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRatingStyle == 1 && this.mRatingValue == 1.0f : invokeV.booleanValue;
    }

    public boolean isRated() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mRatingValue >= 0.0f : invokeV.booleanValue;
    }

    public boolean isThumbUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mRatingStyle == 2 && this.mRatingValue == 1.0f : invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Rating:style=");
            sb.append(this.mRatingStyle);
            sb.append(" rating=");
            float f2 = this.mRatingValue;
            sb.append(f2 < 0.0f ? "unrated" : String.valueOf(f2));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, parcel, i2) == null) {
            parcel.writeInt(this.mRatingStyle);
            parcel.writeFloat(this.mRatingValue);
        }
    }
}
