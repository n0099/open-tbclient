package com.baidu.tbadk.core.account.helper;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.PersonPrivateData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class UserPrivateHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STAT_FRIENDS_OPEN = 2;
    public static final int STAT_TOTAL_HIDE = 3;
    public static final int STAT_TOTAL_OPEN = 1;
    public static final int TYPE_PRIVATE_FRIEND = 5;
    public static final int TYPE_PRIVATE_GROUP = 3;
    public static final int TYPE_PRIVATE_LIKE = 2;
    public static final int TYPE_PRIVATE_POST = 4;
    public static HashMap<String, Integer> privateSettings;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1785458311, "Lcom/baidu/tbadk/core/account/helper/UserPrivateHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1785458311, "Lcom/baidu/tbadk/core/account/helper/UserPrivateHelper;");
                return;
            }
        }
        privateSettings = new HashMap<>();
    }

    public UserPrivateHelper() {
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

    public static int getMyPrivateStat(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            String str = TbadkCoreApplication.getCurrentAccount() + "@" + i;
            if (privateSettings.containsKey(str)) {
                return privateSettings.get(str).intValue();
            }
            privateSettings.put(str, 1);
            return 1;
        }
        return invokeI.intValue;
    }

    public static void init(PersonPrivateData personPrivateData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, personPrivateData) != null) || personPrivateData == null) {
            return;
        }
        String str = TbadkCoreApplication.getCurrentAccount() + "@2";
        int O = personPrivateData.O();
        if (!privateSettings.containsKey(str)) {
            privateSettings.put(str, Integer.valueOf(O));
        }
    }

    public static void setMyPrivateStat(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, null, i, i2) == null) {
            privateSettings.put(TbadkCoreApplication.getCurrentAccount() + "@" + i, Integer.valueOf(i2));
        }
    }
}
