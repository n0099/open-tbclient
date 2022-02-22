package c.a.u0.g2.c;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.d1.w0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements AppInfoService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public Application getApplication() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TbadkCoreApplication.getInst() : (Application) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    @NonNull
    public String getCloudControlUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getCuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TbadkCoreApplication.getInst().getCuidGalaxy2() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getFFmpegPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (StringUtils.isNull(TbadkCoreApplication.getInst().getLibcyberffmpeg()) || StringUtils.isNull(TbadkCoreApplication.getInst().getLibssl()) || StringUtils.isNull(TbadkCoreApplication.getInst().getLibcrypto())) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("libcyber-ffmpeg", TbadkCoreApplication.getInst().getLibcyberffmpeg());
                jSONObject.put("libcyber-ffmpeg_version", TbadkCoreApplication.getInst().getmLibcyberVersion());
                jSONObject.put("libssl", TbadkCoreApplication.getInst().getLibssl());
                jSONObject.put("libssl_version", TbadkCoreApplication.getInst().getmLibcyberVersion());
                jSONObject.put("libcrypto", TbadkCoreApplication.getInst().getLibcrypto());
                jSONObject.put("libcrypto_version", TbadkCoreApplication.getInst().getmLibcyberVersion());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getImAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? String.valueOf((long) Constants.APPID_TIEBA) : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getLiveAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "tieba" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "com.baidu.tieba" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "" : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public float getStaticDeviceScore(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            return -1.0f;
        }
        return invokeL.floatValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getUA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return w0.b() + " (Baidu; P1 " + Build.VERSION.RELEASE + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return TbadkCoreApplication.getInst().getVersionCode() + "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? TbConfig.getVersion() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? TbadkCoreApplication.getInst().getZid() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? AppConfig.isDebug() : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.live.interfaces.service.AppInfoService
    public boolean isNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
