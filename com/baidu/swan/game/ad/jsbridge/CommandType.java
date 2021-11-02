package com.baidu.swan.game.ad.jsbridge;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class CommandType {
    public static final /* synthetic */ CommandType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CommandType ACTION_URL;
    public static final CommandType BANNER_VIEW;
    public static final CommandType GET_APP_STATUS;
    public static final CommandType GET_CONFS;
    public static final CommandType GET_DOWNLOAD_STATUS;
    public static final CommandType INSTALL_APP;
    public static final CommandType OPEN_APP;
    public static final CommandType PAUSE_DOWNLOAD;
    public static final CommandType PRINT_LOG;
    public static final CommandType UNSPECIFIED;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mJavascriptString;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(671681236, "Lcom/baidu/swan/game/ad/jsbridge/CommandType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(671681236, "Lcom/baidu/swan/game/ad/jsbridge/CommandType;");
                return;
            }
        }
        ACTION_URL = new CommandType("ACTION_URL", 0, "setActionUrl");
        GET_CONFS = new CommandType("GET_CONFS", 1, "getConfs");
        PRINT_LOG = new CommandType("PRINT_LOG", 2, "printLog");
        PAUSE_DOWNLOAD = new CommandType("PAUSE_DOWNLOAD", 3, "pauseDownload");
        GET_DOWNLOAD_STATUS = new CommandType("GET_DOWNLOAD_STATUS", 4, "getDownloadStatus");
        INSTALL_APP = new CommandType("INSTALL_APP", 5, "installApp");
        GET_APP_STATUS = new CommandType("GET_APP_STATUS", 6, "getAppStatus");
        OPEN_APP = new CommandType("OPEN_APP", 7, "openApp");
        BANNER_VIEW = new CommandType("BANNER_VIEW", 8, "banner");
        CommandType commandType = new CommandType("UNSPECIFIED", 9, "");
        UNSPECIFIED = commandType;
        $VALUES = new CommandType[]{ACTION_URL, GET_CONFS, PRINT_LOG, PAUSE_DOWNLOAD, GET_DOWNLOAD_STATUS, INSTALL_APP, GET_APP_STATUS, OPEN_APP, BANNER_VIEW, commandType};
    }

    public CommandType(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJavascriptString = str2;
    }

    public static CommandType fromJavascriptString(String str) {
        InterceptResult invokeL;
        CommandType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            for (CommandType commandType : values()) {
                if (commandType.mJavascriptString.equals(str)) {
                    return commandType;
                }
            }
            return UNSPECIFIED;
        }
        return (CommandType) invokeL.objValue;
    }

    public static CommandType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (CommandType) Enum.valueOf(CommandType.class, str) : (CommandType) invokeL.objValue;
    }

    public static CommandType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (CommandType[]) $VALUES.clone() : (CommandType[]) invokeV.objValue;
    }

    public String toJavascriptString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mJavascriptString : (String) invokeV.objValue;
    }
}
