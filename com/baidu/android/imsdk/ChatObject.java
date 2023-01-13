package com.baidu.android.imsdk;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class ChatObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_PAID = -1;
    public static final int DEFAULT_TYPE = -1;
    public static final int MMD_TYPE = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBusinessType;
    public int mCategory;
    public long mContacter;
    public Context mContext;
    public long mPaid;
    public long mTimeInterval;
    public int mType;

    public ChatObject(Context context, int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPaid = -1L;
        this.mType = -1;
        this.mBusinessType = -1;
        this.mTimeInterval = 0L;
        this.mContext = context;
        this.mCategory = i;
        this.mContacter = j;
    }

    public ChatObject(Context context, int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPaid = -1L;
        this.mType = -1;
        this.mBusinessType = -1;
        this.mTimeInterval = 0L;
        this.mContext = context;
        this.mCategory = i;
        this.mContacter = j;
        this.mTimeInterval = j2;
    }

    public ChatObject(Context context, int i, long j, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mPaid = -1L;
        this.mType = -1;
        this.mBusinessType = -1;
        this.mTimeInterval = 0L;
        this.mContext = context;
        this.mCategory = i;
        this.mContacter = j;
        this.mPaid = j2;
        this.mType = i2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChatObject)) {
                return false;
            }
            ChatObject chatObject = (ChatObject) obj;
            if (this.mCategory != chatObject.mCategory || this.mContacter != chatObject.mContacter || this.mPaid != chatObject.mPaid || this.mType != chatObject.mType) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int getBusinessType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBusinessType;
        }
        return invokeV.intValue;
    }

    public int getCategory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCategory;
        }
        return invokeV.intValue;
    }

    public long getContacter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mContacter;
        }
        return invokeV.longValue;
    }

    public long getPaid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPaid;
        }
        return invokeV.longValue;
    }

    public long getTimeInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mTimeInterval;
        }
        return invokeV.longValue;
    }

    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return IMConfigInternal.getInstance().getIMConfig(this.mContext).getToken(this);
        }
        return (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mType;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ((((((this.mCategory + 31) * 31) + ((int) this.mContacter)) * 31) + ((int) this.mPaid)) * 31) + this.mType;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return getToken();
        }
        return (String) invokeV.objValue;
    }

    public void setBusinessType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mBusinessType = i;
        }
    }

    public void setPaid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.mPaid = j;
        }
    }

    public ChatObject setType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            this.mType = i;
            return this;
        }
        return (ChatObject) invokeI.objValue;
    }
}
