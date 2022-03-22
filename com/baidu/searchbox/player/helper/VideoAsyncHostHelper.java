package com.baidu.searchbox.player.helper;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class VideoAsyncHostHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_VIDEO_MPD_HOST = "key_video_mpd_hosts";
    public static final String SP_FILE_NAME = "com.baidu.searchbox_bdvideoplayer";
    public static volatile ArrayList<String> sVideoHostWhiteList;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-175533705, "Lcom/baidu/searchbox/player/helper/VideoAsyncHostHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-175533705, "Lcom/baidu/searchbox/player/helper/VideoAsyncHostHelper;");
                return;
            }
        }
        sVideoHostWhiteList = new ArrayList<>();
    }

    public VideoAsyncHostHelper() {
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

    public static synchronized boolean isVideoUrlNeedAsyncRequest(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (VideoAsyncHostHelper.class) {
                if (str == null) {
                    return false;
                }
                if (sVideoHostWhiteList.isEmpty()) {
                    updateVideoHostWhiteList();
                }
                Iterator<String> it = sVideoHostWhiteList.iterator();
                while (it.hasNext()) {
                    if (str.contains(it.next())) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void setHostConfig(String str) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, str) == null) || (sharedPreferences = BDPlayerConfig.getAppContext().getSharedPreferences(SP_FILE_NAME, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(KEY_VIDEO_MPD_HOST, str).apply();
    }

    public static void updateVideoHostWhiteList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            String string = BDPlayerConfig.getAppContext().getSharedPreferences(SP_FILE_NAME, 0).getString(KEY_VIDEO_MPD_HOST, "");
            try {
                sVideoHostWhiteList.clear();
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    sVideoHostWhiteList.add(jSONArray.opt(i).toString());
                }
            } catch (Exception e2) {
                if (BDPlayerConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
