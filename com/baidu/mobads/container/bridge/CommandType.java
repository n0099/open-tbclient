package com.baidu.mobads.container.bridge;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public class CommandType {
    public static final /* synthetic */ CommandType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CommandType CLOSE;
    public static final CommandType CONFIRM;
    public static final CommandType CREATE_CALENDAR_EVENT;
    public static final CommandType DOWNLOAD_PERMISSION_CLICK;
    public static final CommandType DOWNLOAD_PRIVACY_CLICK;
    public static final CommandType EXPAND;
    public static final CommandType GET_ACTIVE_TYPE;
    public static final CommandType GET_ADVIEW_STATE;
    public static final CommandType GET_APP_STATUS;
    public static final CommandType GET_CONFS;
    public static final CommandType GET_CURRENT_APP;
    public static final CommandType GET_DOWNLOAD_STATUS;
    public static final CommandType GET_ID_FROME_NATIVE;
    public static final CommandType GET_INSTALLED;
    public static final CommandType GET_RECENT_ALL;
    public static final CommandType GET_RECENT_DIFF;
    public static final CommandType GET_SYS_INSTALLED;
    public static final CommandType GET_VERSION_CODE_BY_PKG;
    public static final CommandType GET_WIFI_SCANS;
    public static final CommandType HANDLE_PLAY_CLICK;
    public static final CommandType INSTALL_APP;
    public static final CommandType ON_AD_FALED;
    public static final CommandType ON_AD_PLAY_END;
    public static final CommandType ON_AD_SHOW;
    public static final CommandType ON_AD_SWITCH;
    public static final CommandType ON_INITED;
    public static final CommandType ON_INTERSTITIAL_PRELOAD_END;
    public static final CommandType OPEN;
    public static final CommandType OPEN_APP;
    public static final CommandType PAUSE_DOWNLOAD;
    public static final CommandType PLAY_GAME;
    public static final CommandType PLAY_VIDEO;
    public static final CommandType PLAY_VIDEO_FOR_INTERSTITIAL;
    public static final CommandType PRINT_LOG;
    public static final CommandType RESIZE;
    public static final CommandType SET_ACTION_URL;
    public static final CommandType SET_APP_TIP;
    public static final CommandType SET_ORIENTATION_PROPERTIES;
    public static final CommandType SET_VISIBILITY;
    public static final CommandType STORE_PICTURE;
    public static final CommandType UNSPECIFIED;
    public static final CommandType USE_CUSTOM_CLOSE;
    public transient /* synthetic */ FieldHolder $fh;
    public final String mJavascriptString;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2040224253, "Lcom/baidu/mobads/container/bridge/CommandType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2040224253, "Lcom/baidu/mobads/container/bridge/CommandType;");
                return;
            }
        }
        DOWNLOAD_PERMISSION_CLICK = new CommandType("DOWNLOAD_PERMISSION_CLICK", 0, "setPermissionActionUrl");
        DOWNLOAD_PRIVACY_CLICK = new CommandType("DOWNLOAD_PRIVACY_CLICK", 1, "setPrivacyActionUrl");
        HANDLE_PLAY_CLICK = new CommandType("HANDLE_PLAY_CLICK", 2, "handlePlayClick");
        GET_ID_FROME_NATIVE = new CommandType("GET_ID_FROME_NATIVE", 3, "getIdFromNative");
        SET_ACTION_URL = new CommandType("SET_ACTION_URL", 4, "setActionUrl") { // from class: com.baidu.mobads.container.bridge.CommandType.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        GET_CONFS = new CommandType("GET_CONFS", 5, "getConfs");
        ON_INITED = new CommandType("ON_INITED", 6, "onInited");
        GET_ADVIEW_STATE = new CommandType("GET_ADVIEW_STATE", 7, "getAdViewState");
        PRINT_LOG = new CommandType("PRINT_LOG", 8, "printLog");
        SET_APP_TIP = new CommandType("SET_APP_TIP", 9, "setAppTip");
        PAUSE_DOWNLOAD = new CommandType("PAUSE_DOWNLOAD", 10, "pauseDownload");
        GET_DOWNLOAD_STATUS = new CommandType("GET_DOWNLOAD_STATUS", 11, "getDownloadStatus");
        INSTALL_APP = new CommandType("INSTALL_APP", 12, "installApp") { // from class: com.baidu.mobads.container.bridge.CommandType.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        GET_APP_STATUS = new CommandType("GET_APP_STATUS", 13, "getAppStatus");
        OPEN_APP = new CommandType("OPEN_APP", 14, "openApp") { // from class: com.baidu.mobads.container.bridge.CommandType.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        GET_WIFI_SCANS = new CommandType("GET_WIFI_SCANS", 15, "getWifiScans");
        GET_VERSION_CODE_BY_PKG = new CommandType("GET_VERSION_CODE_BY_PKG", 16, "getVersionCodeByPkg");
        GET_INSTALLED = new CommandType("GET_INSTALLED", 17, "getInstalled");
        GET_RECENT_DIFF = new CommandType("GET_RECENT_DIFF", 18, "getRecentDiff");
        GET_RECENT_ALL = new CommandType("GET_RECENT_ALL", 19, "getRecentAll");
        GET_CURRENT_APP = new CommandType("GET_CURRENT_APP", 20, "getCurrentApp");
        GET_SYS_INSTALLED = new CommandType("GET_SYS_INSTALLED", 21, "getSysInstalled");
        CONFIRM = new CommandType("CONFIRM", 22, "confirm") { // from class: com.baidu.mobads.container.bridge.CommandType.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        ON_AD_FALED = new CommandType("ON_AD_FALED", 23, "onAdFailed");
        ON_AD_SHOW = new CommandType("ON_AD_SHOW", 24, "onAdShow");
        ON_AD_SWITCH = new CommandType("ON_AD_SWITCH", 25, "onAdSwitch");
        SET_VISIBILITY = new CommandType("SET_VISIBILITY", 26, "setVisibility");
        GET_ACTIVE_TYPE = new CommandType("GET_ACTIVE_TYPE", 27, "getActiveType");
        ON_INTERSTITIAL_PRELOAD_END = new CommandType("ON_INTERSTITIAL_PRELOAD_END", 28, "onInterstitialPreloadEnd");
        ON_AD_PLAY_END = new CommandType("ON_AD_PLAY_END", 29, "onAdPlayEnd");
        PLAY_VIDEO_FOR_INTERSTITIAL = new CommandType("PLAY_VIDEO_FOR_INTERSTITIAL", 30, "playVideoForInterstitial");
        CLOSE = new CommandType("CLOSE", 31, IntentConfig.CLOSE);
        EXPAND = new CommandType("EXPAND", 32, "expand") { // from class: com.baidu.mobads.container.bridge.CommandType.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) ? placementType == PlacementType.INLINE : invokeL.booleanValue;
            }
        };
        USE_CUSTOM_CLOSE = new CommandType("USE_CUSTOM_CLOSE", 33, "useCustomClose");
        OPEN = new CommandType("OPEN", 34, "open") { // from class: com.baidu.mobads.container.bridge.CommandType.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        RESIZE = new CommandType("RESIZE", 35, "resize") { // from class: com.baidu.mobads.container.bridge.CommandType.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        SET_ORIENTATION_PROPERTIES = new CommandType("SET_ORIENTATION_PROPERTIES", 36, "setOrientationProperties");
        PLAY_VIDEO = new CommandType("PLAY_VIDEO", 37, "playVideo") { // from class: com.baidu.mobads.container.bridge.CommandType.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) ? placementType == PlacementType.INLINE : invokeL.booleanValue;
            }
        };
        STORE_PICTURE = new CommandType("STORE_PICTURE", 38, "storePicture") { // from class: com.baidu.mobads.container.bridge.CommandType.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        CREATE_CALENDAR_EVENT = new CommandType("CREATE_CALENDAR_EVENT", 39, "createCalendarEvent") { // from class: com.baidu.mobads.container.bridge.CommandType.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        PLAY_GAME = new CommandType("PLAY_GAME", 40, "playGame") { // from class: com.baidu.mobads.container.bridge.CommandType.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r10, r11, r12);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r10, Integer.valueOf(r11), r12};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.baidu.mobads.container.bridge.CommandType
            public boolean requiresClick(PlacementType placementType) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, placementType)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }
        };
        CommandType commandType = new CommandType("UNSPECIFIED", 41, "");
        UNSPECIFIED = commandType;
        $VALUES = new CommandType[]{DOWNLOAD_PERMISSION_CLICK, DOWNLOAD_PRIVACY_CLICK, HANDLE_PLAY_CLICK, GET_ID_FROME_NATIVE, SET_ACTION_URL, GET_CONFS, ON_INITED, GET_ADVIEW_STATE, PRINT_LOG, SET_APP_TIP, PAUSE_DOWNLOAD, GET_DOWNLOAD_STATUS, INSTALL_APP, GET_APP_STATUS, OPEN_APP, GET_WIFI_SCANS, GET_VERSION_CODE_BY_PKG, GET_INSTALLED, GET_RECENT_DIFF, GET_RECENT_ALL, GET_CURRENT_APP, GET_SYS_INSTALLED, CONFIRM, ON_AD_FALED, ON_AD_SHOW, ON_AD_SWITCH, SET_VISIBILITY, GET_ACTIVE_TYPE, ON_INTERSTITIAL_PRELOAD_END, ON_AD_PLAY_END, PLAY_VIDEO_FOR_INTERSTITIAL, CLOSE, EXPAND, USE_CUSTOM_CLOSE, OPEN, RESIZE, SET_ORIENTATION_PROPERTIES, PLAY_VIDEO, STORE_PICTURE, CREATE_CALENDAR_EVENT, PLAY_GAME, commandType};
    }

    public static CommandType fromJavascriptString(String str) {
        InterceptResult invokeL;
        CommandType[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (CommandType) Enum.valueOf(CommandType.class, str) : (CommandType) invokeL.objValue;
    }

    public static CommandType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (CommandType[]) $VALUES.clone() : (CommandType[]) invokeV.objValue;
    }

    public boolean requiresClick(PlacementType placementType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, placementType)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public String toJavascriptString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mJavascriptString : (String) invokeV.objValue;
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
}
