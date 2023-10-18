package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IBasicCPUData;
import com.baidu.mobads.sdk.internal.ad;
import com.baidu.mobads.sdk.internal.an;
import com.baidu.mobads.sdk.internal.ap;
import com.baidu.mobads.sdk.internal.aq;
import com.baidu.mobads.sdk.internal.ar;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.w;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class NativeCPUAdData implements IBasicCPUData, Observer {
    public static /* synthetic */ Interceptable $ic;
    public static final String CLASS_NAME;
    public transient /* synthetic */ FieldHolder $fh;
    public final ClassLoader classLoader;
    public IBasicCPUData.CpuNativeStatusCB mCpuNativeStatusCBListener;
    public final Context mCtx;
    public Object mInstance;
    public final HashMap<String, Object> mSettings;
    public aq remoteUtils;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1229699848, "Lcom/baidu/mobads/sdk/api/NativeCPUAdData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1229699848, "Lcom/baidu/mobads/sdk/api/NativeCPUAdData;");
                return;
            }
        }
        CLASS_NAME = w.l;
    }

    private String getAdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.remoteUtils.c(this.mInstance, "getAdid", new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void cancelAppDownload() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.mCtx != null && isNeedDownloadApp()) {
            ap.a(this.mCtx.getApplicationContext()).b(getAppPackageName());
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getActionType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getActionType", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getAdHeight", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAdLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getAdLogoUrl", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAdWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getAdWidth", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getPackageName", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPermissionUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.remoteUtils.c(this.mInstance, "getAppPermissionUrl", new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPrivacyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.remoteUtils.c(this.mInstance, "getAppPrivacyUrl", new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppPublisher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.remoteUtils.c(this.mInstance, "getAppPublisher", new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.remoteUtils.c(this.mInstance, "getAppVersion", new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getAttribute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getAttribute", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getAuthor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getAuthor", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBaiduLogoUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getBaiduLogoUrl", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getBrandName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getBrandName", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getCatId", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getChannelName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getCatName", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getCommentCounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getCommentCounts", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<Integer> getContentAttributesList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getContentAttributesList", new Object[0]);
            if (b instanceof List) {
                return (List) b;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getContentClickUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getContentClickUrl", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getCtime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getCtime", new Object[0]);
            if (b instanceof Long) {
                return ((Long) b).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getDesc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getContent", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONArray getDislikeReasons() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return (JSONArray) this.remoteUtils.b(this.mInstance, "getDislikeReasons", new Object[0]);
        }
        return (JSONArray) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDownloadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, ap.e, new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getDuration", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public JSONObject getExtra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return (JSONObject) this.remoteUtils.b(this.mInstance, "getExtra", new Object[0]);
        }
        return (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public long getHotId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getHotId", new Object[0]);
            if (b instanceof Long) {
                return ((Long) b).longValue();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getHotWord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.remoteUtils.c(this.mInstance, "getHotWord", new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getIconUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getAvatar", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.remoteUtils.c(this.mInstance, "getImage", new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getImageUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getImageList", new Object[0]);
            if (b instanceof List) {
                return (List) b;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.remoteUtils.c(this.mInstance, "getLabel", new Object[0]);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPlayCounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getPlayCounts", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getPresentationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getPresentationType", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getReadCounts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getReadCounts", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public double getScore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getScore", new Object[0]);
            if (b instanceof Double) {
                return ((Double) b).doubleValue();
            }
            return 0.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public List<String> getSmallImageUrls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getSmallImageList", new Object[0]);
            if (b instanceof List) {
                return (List) b;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getStyleTypeCpu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getStyleTypeCpu", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getThumbHeight", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getThumbUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getThumbUrl", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public int getThumbWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getThumbWidth", new Object[0]);
            if (!(b instanceof Integer)) {
                return 0;
            }
            return ((Integer) b).intValue();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getTitle", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getType", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getUpdateTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getUpdateTime", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public String getVUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "getVUrl", new Object[0]);
            if (b instanceof String) {
                return (String) b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isAutoplay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "isAutoplay", new Object[0]);
            if (!(b instanceof Boolean)) {
                return false;
            }
            return ((Boolean) b).booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isCanGoLp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "isCanGoLp", new Object[0]);
            if (!(b instanceof Boolean)) {
                return false;
            }
            return ((Boolean) b).booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isNeedDownloadApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return ((Boolean) this.remoteUtils.b(this.mInstance, "isDownloadApp", new Object[0])).booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public boolean isTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            Object b = this.remoteUtils.b(this.mInstance, "isTop", new Object[0]);
            if (!(b instanceof Boolean)) {
                return false;
            }
            return ((Boolean) b).booleanValue();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void pauseAppDownload() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && this.mCtx != null && isNeedDownloadApp()) {
            ap.a(this.mCtx.getApplicationContext()).a(getAppPackageName());
        }
    }

    public NativeCPUAdData(Context context, Object obj, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, obj, hashMap};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCtx = context;
        this.mInstance = obj;
        this.mSettings = hashMap;
        this.remoteUtils = aq.a(context, CLASS_NAME);
        this.classLoader = bq.a(context);
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleDislikeClick(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048623, this, view2, i) == null) {
            this.remoteUtils.a(this.mInstance, "handleDislikeClick", view2, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCanClickView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2) == null) {
            HashMap<String, Object> hashMap = this.mSettings;
            if (hashMap != null) {
                this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
            }
            if (view2 instanceof CpuVideoView) {
                this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
            } else if (view2 instanceof TextView) {
                this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
            }
            this.remoteUtils.a(this.mInstance, "handleCanClickView", view2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleCreativeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view2) == null) {
            HashMap<String, Object> hashMap = this.mSettings;
            if (hashMap != null) {
                this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
            }
            if (view2 instanceof CpuVideoView) {
                this.remoteUtils.a(this.mInstance, "handClickVideo", 1, 0);
            } else if (view2 instanceof TextView) {
                this.remoteUtils.a(this.mInstance, "handClickVideo", 2, 0);
            }
            this.remoteUtils.a(this.mInstance, "handleCreativeView", view2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void clickHotItem(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            this.remoteUtils.a(this.mInstance, "clickHotItem", view2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void markDislike(String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, strArr) == null) {
            this.remoteUtils.a(this.mInstance, "markDislike", strArr);
        }
    }

    public void monitorVisibleTime(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, view2) == null) {
            HashMap<String, Object> hashMap = this.mSettings;
            if (hashMap != null) {
                this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
            }
            this.remoteUtils.a(this.mInstance, "monitorVisibleTime", view2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void onImpression(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, view2) == null) {
            HashMap<String, Object> hashMap = this.mSettings;
            if (hashMap != null) {
                this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
            }
            this.remoteUtils.a(this.mInstance, "onImpression", view2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void handleClick(View view2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, view2, objArr) == null) {
            HashMap<String, Object> hashMap = this.mSettings;
            if (hashMap != null) {
                this.remoteUtils.a(this.mInstance, "setConfigParams", hashMap);
            }
            long j = 0;
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Long)) {
                j = ((Long) objArr[0]).longValue();
            }
            if (view2 instanceof CpuVideoView) {
                this.remoteUtils.a(this.mInstance, "handClickVideo", 1, Long.valueOf(j));
            } else if (view2 instanceof TextView) {
                this.remoteUtils.a(this.mInstance, "handClickVideo", 2, Long.valueOf(j));
            }
            this.remoteUtils.a(this.mInstance, "handleClick", view2);
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void registerViewForInteraction(View view2, List<View> list, List<View> list2, IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048632, this, view2, list, list2, cpuNativeStatusCB) == null) {
            setStatusListener(cpuNativeStatusCB);
            onImpression(view2);
            monitorVisibleTime(view2);
            if (list != null && list.size() > 0) {
                for (View view3 : list) {
                    if (view3 != null) {
                        view3.setOnClickListener(new View.OnClickListener(this, view3) { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NativeCPUAdData this$0;
                            public final /* synthetic */ View val$clickView;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, view3};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$clickView = view3;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view4) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null && interceptable2.invokeL(1048576, this, view4) != null) {
                                    return;
                                }
                                this.this$0.handleCanClickView(view4);
                                this.val$clickView.setClickable(false);
                                this.val$clickView.postDelayed(new Runnable(this) { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        View view5;
                                        Interceptable interceptable3 = $ic;
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (view5 = this.this$1.val$clickView) != null) {
                                            view5.setClickable(true);
                                        }
                                    }
                                }, 1000L);
                            }
                        });
                    }
                }
            }
            if (list2 != null && list2.size() > 0) {
                for (View view4 : list2) {
                    if (view4 != null) {
                        view4.setOnClickListener(new View.OnClickListener(this, view4, list) { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ NativeCPUAdData this$0;
                            public final /* synthetic */ List val$clickViews;
                            public final /* synthetic */ View val$creativeView;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, view4, list};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                                this.val$creativeView = view4;
                                this.val$clickViews = list;
                            }

                            @Override // android.view.View.OnClickListener
                            public void onClick(View view5) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view5) == null) {
                                    this.this$0.handleCreativeView(view5);
                                    this.val$creativeView.setClickable(false);
                                    this.val$creativeView.postDelayed(new Runnable(this) { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.2.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;
                                        public final /* synthetic */ AnonymousClass2 this$1;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i = newInitContext.flag;
                                                if ((i & 1) != 0) {
                                                    int i2 = i & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.this$1 = this;
                                        }

                                        @Override // java.lang.Runnable
                                        public void run() {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                AnonymousClass2 anonymousClass2 = this.this$1;
                                                if (anonymousClass2.val$clickViews != null) {
                                                    anonymousClass2.val$creativeView.setClickable(true);
                                                }
                                            }
                                        }
                                    }, 1000L);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.IBasicCPUData
    public void setStatusListener(IBasicCPUData.CpuNativeStatusCB cpuNativeStatusCB) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, cpuNativeStatusCB) == null) {
            this.mCpuNativeStatusCBListener = cpuNativeStatusCB;
            try {
                this.remoteUtils.a(this.mInstance, "setStatusListener", Proxy.newProxyInstance(this.classLoader, new Class[]{ar.a(w.m, this.classLoader)}, new InvocationHandler(this, cpuNativeStatusCB) { // from class: com.baidu.mobads.sdk.api.NativeCPUAdData.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NativeCPUAdData this$0;
                    public final /* synthetic */ IBasicCPUData.CpuNativeStatusCB val$cpuNativeStatusCBListener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, cpuNativeStatusCB};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$cpuNativeStatusCBListener = cpuNativeStatusCB;
                    }

                    @Override // java.lang.reflect.InvocationHandler
                    public Object invoke(Object obj, Method method, Object[] objArr) {
                        InterceptResult invokeLLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLLL = interceptable2.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                            av.a h = av.h("NativeCPUAdData");
                            h.c("invoke: " + method.getName());
                            if (this.val$cpuNativeStatusCBListener == null) {
                                return null;
                            }
                            String name = method.getName();
                            if ("onAdDownloadWindowShow".equals(name)) {
                                this.val$cpuNativeStatusCBListener.onAdDownloadWindowShow();
                            } else if ("onPermissionShow".equals(name)) {
                                this.val$cpuNativeStatusCBListener.onPermissionShow();
                            } else if ("onPermissionClose".equals(name)) {
                                this.val$cpuNativeStatusCBListener.onPermissionClose();
                            } else if ("onPrivacyClick".equals(name)) {
                                this.val$cpuNativeStatusCBListener.onPrivacyClick();
                            } else if ("onPrivacyLpClose".equals(name)) {
                                this.val$cpuNativeStatusCBListener.onPrivacyLpClose();
                            } else if ("onNotifyPerformance".equals(name)) {
                                if (objArr != null && objArr.length >= 1 && (objArr[0] instanceof String)) {
                                    this.val$cpuNativeStatusCBListener.onNotifyPerformance((String) objArr[0]);
                                }
                            } else if ("startRouter".equals(name)) {
                                an.a((Context) objArr[0], (String) objArr[1]);
                            }
                            return null;
                        }
                        return invokeLLL.objValue;
                    }
                }));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048634, this, observable, obj) == null) && (observable instanceof ad) && this.mCpuNativeStatusCBListener != null && isNeedDownloadApp() && (obj instanceof IOAdEvent)) {
            IOAdEvent iOAdEvent = (IOAdEvent) obj;
            String message = iOAdEvent.getMessage();
            Map<String, Object> data = iOAdEvent.getData();
            if (data != null) {
                Object obj2 = data.get("adid");
                if ((obj2 instanceof String) && ((String) obj2).equals(getAdid())) {
                    this.mCpuNativeStatusCBListener.onAdStatusChanged(message, getDownloadStatus());
                }
            }
        }
    }
}
