package com.baidu.apollon.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BasicStoreTools {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String STAT_LAST_SENDDATA = "stat__lastdata";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3921b = "stat_strategy";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3922c = "last_evt_id";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f3923a;

    /* renamed from: com.baidu.apollon.statistics.BasicStoreTools$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final BasicStoreTools f3924a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-336915580, "Lcom/baidu/apollon/statistics/BasicStoreTools$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-336915580, "Lcom/baidu/apollon/statistics/BasicStoreTools$a;");
                    return;
                }
            }
            f3924a = new BasicStoreTools(null);
        }

        public a() {
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
    }

    public /* synthetic */ BasicStoreTools(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BasicStoreTools getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f3924a : (BasicStoreTools) invokeV.objValue;
    }

    public String getLastData(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) ? context.getSharedPreferences("Stat_SDK_SendRem", 0).getString(STAT_LAST_SENDDATA, "") : (String) invokeL.objValue;
    }

    public long getLastEvtId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Stat_SDK_SendRem", 0);
            try {
                return sharedPreferences.getLong(f3922c, 0L);
            } catch (ClassCastException unused) {
                return sharedPreferences.getInt(f3922c, 0);
            }
        }
        return invokeL.longValue;
    }

    public String getStrategy(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? context.getSharedPreferences("Stat_SDK_SendRem", 0).getString(f3921b, "") : (String) invokeL.objValue;
    }

    public void setLastData(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
            edit.putString(STAT_LAST_SENDDATA, str);
            edit.commit();
        }
    }

    public void setLastEvtId(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, context, j) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
            edit.putLong(f3922c, j);
            edit.commit();
        }
    }

    public void setStrategy(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, str) == null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("Stat_SDK_SendRem", 0).edit();
            edit.putString(f3921b, str);
            edit.commit();
        }
    }

    public BasicStoreTools() {
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
        this.f3923a = "Stat_SDK_SendRem";
    }
}
