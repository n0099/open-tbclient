package com.baidu.searchbox.player.ubc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class FloatingStatPlugin extends AbsPlugin {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALUE = "value";
    public static final UBCManager UBC_MANAGER;
    public static final String VALUE_CLICK = "click";
    public static final String VALUE_SHOW = "show";
    public transient /* synthetic */ FieldHolder $fh;
    public Flow mFlow;
    public BDVideoPlayerUbcContent mUBCContent;

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{6} : (int[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-82625887, "Lcom/baidu/searchbox/player/ubc/FloatingStatPlugin;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-82625887, "Lcom/baidu/searchbox/player/ubc/FloatingStatPlugin;");
                return;
            }
        }
        UBC_MANAGER = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
    }

    public FloatingStatPlugin() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    }

    private void onFloatingClick(BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bDVideoPlayerUbcContent) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "click");
                jSONObject.put("value", "enter");
                UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void onFloatingDismiss(BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bDVideoPlayerUbcContent) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "click");
                jSONObject.put("value", "close");
                UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void onFloatingScale(BDVideoPlayerUbcContent bDVideoPlayerUbcContent, Boolean bool) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bDVideoPlayerUbcContent, bool) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "click");
                if (bool.booleanValue()) {
                    str = "enlarge";
                } else {
                    str = "reduce";
                }
                jSONObject.put("value", str);
                UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void onFloatingShow(BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, bDVideoPlayerUbcContent) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "show");
                UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateScaleAndPosition(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65542, this, str, i, i2) == null) {
            try {
                JSONObject extStatisticsLog = this.mUBCContent.getExtStatisticsLog();
                extStatisticsLog.put("size", str);
                extStatisticsLog.put("pos", i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(VideoEvent videoEvent) {
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoEvent) == null) {
            super.onVideoEventNotify(videoEvent);
            String action = videoEvent.getAction();
            switch (action.hashCode()) {
                case -2127352417:
                    if (action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -21330261:
                    if (action.equals(StatisticsEvent.ACTION_FLOATING_CLICK)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -6829459:
                    if (action.equals(StatisticsEvent.ACTION_FLOATING_SCALE)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 415426938:
                    if (action.equals(StatisticsEvent.ACTION_FLOATING_SHOW)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1787606765:
                    if (action.equals(StatisticsEvent.ACTION_FLOATING_DISMISS)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            if (c == 4) {
                                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                                onFloatingClick(this.mUBCContent);
                                return;
                            }
                            return;
                        }
                        updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                        onFloatingScale(this.mUBCContent, Boolean.valueOf(videoEvent.getBooleanExtra(10)));
                        return;
                    }
                    updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                    onFloatingDismiss(this.mUBCContent);
                    String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(this.mUBCContent.getExtStatisticsLog(), this.mUBCContent, (JSONObject) null);
                    Flow flow = this.mFlow;
                    if (flow != null) {
                        UBC_MANAGER.flowSetValueWithDuration(flow, ubcContent);
                        UBC_MANAGER.flowEnd(this.mFlow);
                        this.mFlow = null;
                        return;
                    }
                    return;
                }
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                onFloatingShow(this.mUBCContent);
                this.mFlow = UBC_MANAGER.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING_DURATION);
                return;
            }
            this.mUBCContent = (BDVideoPlayerUbcContent) videoEvent.getExtra(13);
        }
    }
}
