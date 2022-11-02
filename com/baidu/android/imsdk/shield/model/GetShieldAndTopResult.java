package com.baidu.android.imsdk.shield.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class GetShieldAndTopResult extends HttpHelper.ResponseResult implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator<GetShieldAndTopResult> CREATOR;
    public static final String TAG = "GetShieldAndTopResult";
    public transient /* synthetic */ FieldHolder $fh;
    public int mChatType;
    public int mCommodityStatus;
    public long mContacter;
    public int mDisturbStatus;
    public long mDisturbTime;
    public int mGraphicStatus;
    public int mMarkTop;
    public long mMarkTopTime;
    public int mShield;
    public long mShieldTime;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-675209594, "Lcom/baidu/android/imsdk/shield/model/GetShieldAndTopResult;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-675209594, "Lcom/baidu/android/imsdk/shield/model/GetShieldAndTopResult;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<GetShieldAndTopResult>() { // from class: com.baidu.android.imsdk.shield.model.GetShieldAndTopResult.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GetShieldAndTopResult createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new GetShieldAndTopResult(parcel);
                }
                return (GetShieldAndTopResult) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GetShieldAndTopResult[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new GetShieldAndTopResult[i];
                }
                return (GetShieldAndTopResult[]) invokeI.objValue;
            }
        };
    }

    public GetShieldAndTopResult() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public int getChatType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mChatType;
        }
        return invokeV.intValue;
    }

    public int getCommodityStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCommodityStatus;
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

    public int getDisturbStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mDisturbStatus;
        }
        return invokeV.intValue;
    }

    public long getDisturbTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mDisturbTime;
        }
        return invokeV.longValue;
    }

    public int getGraphicStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mGraphicStatus;
        }
        return invokeV.intValue;
    }

    public int getMarkTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mMarkTop;
        }
        return invokeV.intValue;
    }

    public long getMarkTopTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mMarkTopTime;
        }
        return invokeV.longValue;
    }

    public int getShield() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mShield;
        }
        return invokeV.intValue;
    }

    public long getShieldTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mShieldTime;
        }
        return invokeV.longValue;
    }

    public GetShieldAndTopResult(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mErrorCode = parcel.readInt();
        this.mErrorMsg = parcel.readString();
        this.mMarkTop = parcel.readInt();
        this.mMarkTopTime = parcel.readLong();
        this.mShield = parcel.readInt();
        this.mShieldTime = parcel.readLong();
        this.mContacter = parcel.readLong();
        this.mChatType = parcel.readInt();
        this.mDisturbStatus = parcel.readInt();
        this.mDisturbTime = parcel.readLong();
        this.mGraphicStatus = parcel.readInt();
        this.mCommodityStatus = parcel.readInt();
    }

    public void setChatType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mChatType = i;
        }
    }

    public void setCommodityStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mCommodityStatus = i;
        }
    }

    public void setContacter(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.mContacter = j;
        }
    }

    public void setDisturbStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mDisturbStatus = i;
        }
    }

    public void setDisturbTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.mDisturbTime = j;
        }
    }

    public void setGraphicStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mGraphicStatus = i;
        }
    }

    public void setMarkTop(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mMarkTop = i;
        }
    }

    public void setMarkTopTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.mMarkTopTime = j;
        }
    }

    public void setShield(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.mShield = i;
        }
    }

    public void setShieldTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.mShieldTime = j;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, parcel, i) == null) {
            parcel.writeInt(this.mErrorCode);
            parcel.writeString(this.mErrorMsg);
            parcel.writeInt(this.mMarkTop);
            parcel.writeLong(this.mMarkTopTime);
            parcel.writeInt(this.mShield);
            parcel.writeLong(this.mShieldTime);
            parcel.writeLong(this.mContacter);
            parcel.writeInt(this.mChatType);
            parcel.writeInt(this.mDisturbStatus);
            parcel.writeLong(this.mDisturbTime);
            parcel.writeInt(this.mGraphicStatus);
            parcel.writeInt(this.mCommodityStatus);
        }
    }
}
