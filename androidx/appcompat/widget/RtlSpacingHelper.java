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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mIsRtl) {
                return this.mLeft;
            }
            return this.mRight;
        }
        return invokeV.intValue;
    }

    public int getLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mLeft;
        }
        return invokeV.intValue;
    }

    public int getRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRight;
        }
        return invokeV.intValue;
    }

    public int getStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mIsRtl) {
                return this.mRight;
            }
            return this.mLeft;
        }
        return invokeV.intValue;
    }

    public void setAbsolute(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            this.mIsRelative = false;
            if (i != Integer.MIN_VALUE) {
                this.mExplicitLeft = i;
                this.mLeft = i;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.mExplicitRight = i2;
                this.mRight = i2;
            }
        }
    }

    public void setRelative(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            this.mStart = i;
            this.mEnd = i2;
            this.mIsRelative = true;
            if (this.mIsRtl) {
                if (i2 != Integer.MIN_VALUE) {
                    this.mLeft = i2;
                }
                if (i != Integer.MIN_VALUE) {
                    this.mRight = i;
                    return;
                }
                return;
            }
            if (i != Integer.MIN_VALUE) {
                this.mLeft = i;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.mRight = i2;
            }
        }
    }

    public void setDirection(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || z == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z;
        if (this.mIsRelative) {
            if (z) {
                int i = this.mEnd;
                if (i == Integer.MIN_VALUE) {
                    i = this.mExplicitLeft;
                }
                this.mLeft = i;
                int i2 = this.mStart;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.mExplicitRight;
                }
                this.mRight = i2;
                return;
            }
            int i3 = this.mStart;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.mExplicitLeft;
            }
            this.mLeft = i3;
            int i4 = this.mEnd;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.mExplicitRight;
            }
            this.mRight = i4;
            return;
        }
        this.mLeft = this.mExplicitLeft;
        this.mRight = this.mExplicitRight;
    }
}
