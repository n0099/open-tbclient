package androidx.appcompat.widget;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class RtlSpacingHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UNDEFINED = Integer.MIN_VALUE;
    public transient /* synthetic */ FieldHolder $fh;
    public int mEnd;
    public int mExplicitLeft;
    public int mExplicitRight;
    public boolean mIsRelative;
    public boolean mIsRtl;
    public int mLeft;
    public int mRight;
    public int mStart;

    public RtlSpacingHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLeft = 0;
        this.mRight = 0;
        this.mStart = Integer.MIN_VALUE;
        this.mEnd = Integer.MIN_VALUE;
        this.mExplicitLeft = 0;
        this.mExplicitRight = 0;
        this.mIsRtl = false;
        this.mIsRelative = false;
    }

    public int getEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIsRtl ? this.mLeft : this.mRight : invokeV.intValue;
    }

    public int getLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLeft : invokeV.intValue;
    }

    public int getRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRight : invokeV.intValue;
    }

    public int getStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsRtl ? this.mRight : this.mLeft : invokeV.intValue;
    }

    public void setAbsolute(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            this.mIsRelative = false;
            if (i2 != Integer.MIN_VALUE) {
                this.mExplicitLeft = i2;
                this.mLeft = i2;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.mExplicitRight = i3;
                this.mRight = i3;
            }
        }
    }

    public void setDirection(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || z == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z;
        if (!this.mIsRelative) {
            this.mLeft = this.mExplicitLeft;
            this.mRight = this.mExplicitRight;
        } else if (z) {
            int i2 = this.mEnd;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.mExplicitLeft;
            }
            this.mLeft = i2;
            int i3 = this.mStart;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.mExplicitRight;
            }
            this.mRight = i3;
        } else {
            int i4 = this.mStart;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.mExplicitLeft;
            }
            this.mLeft = i4;
            int i5 = this.mEnd;
            if (i5 == Integer.MIN_VALUE) {
                i5 = this.mExplicitRight;
            }
            this.mRight = i5;
        }
    }

    public void setRelative(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            this.mStart = i2;
            this.mEnd = i3;
            this.mIsRelative = true;
            if (this.mIsRtl) {
                if (i3 != Integer.MIN_VALUE) {
                    this.mLeft = i3;
                }
                if (i2 != Integer.MIN_VALUE) {
                    this.mRight = i2;
                    return;
                }
                return;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.mLeft = i2;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.mRight = i3;
            }
        }
    }
}
