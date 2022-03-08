package com.baidu.searchbox.player.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.searchbox.player.remote.BDRemotePlayerService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class DumediaUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_INSTALL_TYPE = 31;
    public transient /* synthetic */ FieldHolder $fh;

    public DumediaUtils() {
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

    @NonNull
    public static String getCyberSDKVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? "7.31.71.29" : (String) invokeV.objValue;
    }

    public static int getPlayQualityScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? getPlayQualityScore(852, 480) : invokeV.intValue;
    }

    @PublicMethod
    public static void initCyber() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            initCyber("", true);
        }
    }

    public static void preResolveHosts(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, list) == null) {
            CyberPlayerManager.preResolveHosts(list);
        }
    }

    public String getCyberNativeVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? CyberPlayerManager.getCoreVersion() : (String) invokeV.objValue;
    }

    public static int getPlayQualityScore(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            return CyberPlayerManager.getDevicePlayQualityScore(MimeTypes.VIDEO_H265, 0, i2, i3, null);
        }
        return invokeII.intValue;
    }

    @PublicMethod
    public static void initCyber(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            initCyber(str, true);
        }
    }

    @PublicMethod
    public static void initCyber(@NonNull String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, null, str, z) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(CyberPlayerManager.INSTALL_OPT_CRASHPAD_INSTALL_TYPE, "2");
            try {
                initCyber(str, z, 31, hashMap, null, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @PublicMethod
    public static void initCyber(@NonNull String str, boolean z, int i2, Map<String, String> map, CyberPlayerManager.InstallListener installListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), map, installListener}) == null) {
            try {
                initCyber("", z, i2, map, installListener, null);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @PublicMethod(version = "12.8.0.0")
    public static void initCyber(@NonNull String str, boolean z, int i2, Map<String, String> map, CyberPlayerManager.InstallListener installListener, @Nullable CyberPlayerManager.GetNetHandleListener getNetHandleListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i2), map, installListener, getNetHandleListener}) == null) || CyberPlayerManager.isCoreLoaded(i2)) {
            return;
        }
        try {
            CyberPlayerManager.install(BDPlayerConfig.getAppContext(), str, (String) null, i2, z ? BDRemotePlayerService.class : null, map, installListener);
            if (getNetHandleListener != null) {
                CyberPlayerManager.setNetHandleListener(getNetHandleListener);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
