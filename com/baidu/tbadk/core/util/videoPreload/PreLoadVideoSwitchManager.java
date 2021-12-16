package com.baidu.tbadk.core.util.videoPreload;

import android.text.TextUtils;
import c.a.d.f.p.k;
import c.a.r0.s.g0.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.switchs.VideoPreLoadSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class PreLoadVideoSwitchManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_PRE_LOAD_SIZE = 512000;
    public static final int MAX_PRE_LOAD_NUM = 3;
    public static final int MAX_SEARCH_RANGE_NUM = 10;
    public static PreLoadVideoSwitchManager sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isWifi;
    public int mMaxNum;
    public int mSize;

    public PreLoadVideoSwitchManager() {
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
        this.mMaxNum = 3;
        this.isWifi = true;
        this.mSize = 0;
        VideoPreLoadLog.log("PreLoadVideoSwitchManager init ");
        try {
            parseJson(b.j().p("video_sync_switch_json", ""));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static PreLoadVideoSwitchManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                synchronized (PreLoadVideoSwitchManager.class) {
                    if (sInstance == null) {
                        sInstance = new PreLoadVideoSwitchManager();
                    }
                }
            }
            return sInstance;
        }
        return (PreLoadVideoSwitchManager) invokeV.objValue;
    }

    private void parseJson(String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        this.mMaxNum = jSONObject.optInt("num", 3);
        this.isWifi = jSONObject.optInt("is_wifi", 1) == 1;
        this.mSize = jSONObject.optInt("size", 512000);
        VideoPreLoadLog.log("PreLoadVideoSwitchManager parseJson:   num: " + this.mMaxNum + " size: " + this.mSize + " isWifi " + this.isWifi);
    }

    public int getMaxPreLoadNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mMaxNum : invokeV.intValue;
    }

    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.mSize;
            if (i2 == 0) {
                return 512000;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (VideoPreLoadSwitch.isOn()) {
                return !this.isWifi || k.H();
            }
            VideoPreLoadLog.log("PreLoadVideoSwitchManager isOpen switch close ");
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSyncSwitchJson(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            VideoPreLoadLog.log("PreLoadVideoSwitchManager setSyncSwitchJson: " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                parseJson(str);
                b.j().x("video_sync_switch_json", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
