package com.baidu.tbadk.core.util;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class LoginPostStatisticHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOCATE_FRS = 2;
    public static final int LOCATE_HOME = 3;
    public static final int LOCATE_PB = 1;
    public static final int PARAM_LOGIN_POST_STATISTIC = 3;
    public static final int SOURCE_STEP_CALL_LOGIN = 1;
    public static final int SOURCE_STEP_CLICK_POST = 3;
    public static final int SOURCE_STEP_LOGIN_SUCCESS = 2;
    public static final int SOURCE_STEP_POST_SUCCESS = 4;
    public static final int TYPE_DIALOG = 1;
    public static final int TYPE_FULL_PAGE = 2;
    public static StatisticData loginSuccessStatistic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class StatisticData implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<StatisticData> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int locate;
        public int type;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2026397200, "Lcom/baidu/tbadk/core/util/LoginPostStatisticHelper$StatisticData;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2026397200, "Lcom/baidu/tbadk/core/util/LoginPostStatisticHelper$StatisticData;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator<StatisticData>() { // from class: com.baidu.tbadk.core.util.LoginPostStatisticHelper.StatisticData.1
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
                public StatisticData createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new StatisticData(parcel) : (StatisticData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public StatisticData[] newArray(int i2) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new StatisticData[i2] : (StatisticData[]) invokeI.objValue;
                }
            };
        }

        public StatisticData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
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

        public void readFromParcel(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel) == null) {
                this.locate = parcel.readInt();
                this.type = parcel.readInt();
            }
        }

        public StatisticData setLocate(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                this.locate = i2;
                return this;
            }
            return (StatisticData) invokeI.objValue;
        }

        public StatisticData setType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                this.type = i2;
                return this;
            }
            return (StatisticData) invokeI.objValue;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i2) == null) {
                parcel.writeInt(this.locate);
                parcel.writeInt(this.type);
            }
        }

        public StatisticData(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.locate = parcel.readInt();
            this.type = parcel.readInt();
        }
    }

    public LoginPostStatisticHelper() {
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

    public static StatisticData newStatisticData(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            StatisticData statisticData = new StatisticData();
            statisticData.locate = i2;
            return statisticData;
        }
        return (StatisticData) invokeI.objValue;
    }

    public static void statisticClickPost(StatisticData statisticData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, statisticData) == null) || loginSuccessStatistic == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_source", 3).param("obj_locate", statisticData.locate).param("obj_type", statisticData.type));
    }

    public static void statisticGoToLogin(StatisticData statisticData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, statisticData) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_source", 1).param("obj_locate", statisticData.locate).param("obj_type", statisticData.type));
        }
    }

    public static void statisticLoginSuccess(StatisticData statisticData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, statisticData) == null) {
            loginSuccessStatistic = statisticData;
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_source", 2).param("obj_locate", statisticData.locate).param("obj_type", statisticData.type));
        }
    }

    public static void statisticPostSuccess(StatisticData statisticData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, statisticData) == null) || loginSuccessStatistic == null) {
            return;
        }
        loginSuccessStatistic = null;
        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_source", 4).param("obj_locate", statisticData.locate).param("obj_type", statisticData.type));
    }
}
