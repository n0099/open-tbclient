package aegon.chrome.base;

import aegon.chrome.base.annotations.CalledByNative;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class UnguessableToken implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<UnguessableToken> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final long mHigh;
    public final long mLow;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2002985768, "Laegon/chrome/base/UnguessableToken;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2002985768, "Laegon/chrome/base/UnguessableToken;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<UnguessableToken>() { // from class: aegon.chrome.base.UnguessableToken.1
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

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARN: Type inference failed for: r1v0, types: [aegon.chrome.base.UnguessableToken, java.lang.Object] */
            @Override // android.os.Parcelable.Creator
            public UnguessableToken createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    long readLong = parcel.readLong();
                    long readLong2 = parcel.readLong();
                    if (readLong == 0 || readLong2 == 0) {
                        return null;
                    }
                    return new UnguessableToken(readLong, readLong2);
                }
                return invokeL.objValue;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
            /* JADX WARN: Type inference failed for: r1v1, types: [aegon.chrome.base.UnguessableToken[], java.lang.Object[]] */
            @Override // android.os.Parcelable.Creator
            public UnguessableToken[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new UnguessableToken[i2] : (Object[]) invokeI.objValue;
            }
        };
    }

    public UnguessableToken(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHigh = j;
        this.mLow = j2;
    }

    @CalledByNative
    public static UnguessableToken create(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? new UnguessableToken(j, j2) : (UnguessableToken) invokeCommon.objValue;
    }

    @CalledByNative
    private UnguessableToken parcelAndUnparcelForTesting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            Parcel obtain = Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            UnguessableToken createFromParcel = CREATOR.createFromParcel(obtain);
            obtain.recycle();
            return createFromParcel;
        }
        return (UnguessableToken) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @CalledByNative
    public long getHighForSerialization() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mHigh : invokeV.longValue;
    }

    @CalledByNative
    public long getLowForSerialization() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLow : invokeV.longValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, parcel, i2) == null) {
            parcel.writeLong(this.mHigh);
            parcel.writeLong(this.mLow);
        }
    }
}
