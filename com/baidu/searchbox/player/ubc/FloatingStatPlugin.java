package com.baidu.searchbox.player.ubc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.player.event.StatisticsEvent;
import com.baidu.searchbox.player.event.VideoEvent;
import com.baidu.searchbox.player.plugin.AbsPlugin;
import com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
/* loaded from: classes11.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUBCContent = new BDVideoPlayerUbcContent.Builder().buildEmpty();
    }

    private void onFloatingClick(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bDVideoPlayerUbcContent) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "click");
                jSONObject.put("value", "enter");
                UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onFloatingDismiss(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, bDVideoPlayerUbcContent) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "click");
                jSONObject.put("value", IntentConfig.CLOSE);
                UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onFloatingScale(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, bDVideoPlayerUbcContent, bool) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "click");
                jSONObject.put("value", bool.booleanValue() ? "enlarge" : "reduce");
                UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onFloatingShow(@NonNull BDVideoPlayerUbcContent bDVideoPlayerUbcContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, bDVideoPlayerUbcContent) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "show");
                UBC_MANAGER.onEvent(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING, BDVideoPlayerUbcHelper.getUbcContent(bDVideoPlayerUbcContent, jSONObject));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void updateScaleAndPosition(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65542, this, str, i2, i3) == null) {
            try {
                JSONObject extStatisticsLog = this.mUBCContent.getExtStatisticsLog();
                extStatisticsLog.put("size", str);
                extStatisticsLog.put("pos", i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.searchbox.player.interfaces.INeuron
    @Nullable
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{6} : (int[]) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.player.plugin.AbsPlugin, com.baidu.searchbox.player.interfaces.INeuron
    public void onVideoEventNotify(@NonNull VideoEvent videoEvent) {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoEvent) == null) {
            super.onVideoEventNotify(videoEvent);
            String action = videoEvent.getAction();
            switch (action.hashCode()) {
                case -2127352417:
                    if (action.equals(StatisticsEvent.ACTION_UPDATE_CONTENT)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -21330261:
                    if (action.equals(StatisticsEvent.ACTION_FLOATING_CLICK)) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -6829459:
                    if (action.equals(StatisticsEvent.ACTION_FLOATING_SCALE)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 415426938:
                    if (action.equals(StatisticsEvent.ACTION_FLOATING_SHOW)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1787606765:
                    if (action.equals(StatisticsEvent.ACTION_FLOATING_DISMISS)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                this.mUBCContent = (BDVideoPlayerUbcContent) videoEvent.getExtra(13);
            } else if (c2 == 1) {
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                onFloatingShow(this.mUBCContent);
                this.mFlow = UBC_MANAGER.beginFlow(VideoPlayerUbcConstants.UBC_VIDEO_FLOATING_DURATION);
            } else if (c2 != 2) {
                if (c2 == 3) {
                    updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                    onFloatingScale(this.mUBCContent, Boolean.valueOf(videoEvent.getBooleanExtra(10)));
                } else if (c2 != 4) {
                } else {
                    updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                    onFloatingClick(this.mUBCContent);
                }
            } else {
                updateScaleAndPosition(videoEvent.getStringExtra(9), videoEvent.getIntExtra(11), videoEvent.getIntExtra(12));
                onFloatingDismiss(this.mUBCContent);
                String ubcContent = BDVideoPlayerUbcHelper.getUbcContent(this.mUBCContent.getExtStatisticsLog(), this.mUBCContent, (JSONObject) null);
                Flow flow = this.mFlow;
                if (flow != null) {
                    UBC_MANAGER.flowSetValueWithDuration(flow, ubcContent);
                    UBC_MANAGER.flowEnd(this.mFlow);
                    this.mFlow = null;
                }
            }
        }
    }
}
