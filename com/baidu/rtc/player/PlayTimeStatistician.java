package com.baidu.rtc.player;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.webrtc.Logging;
/* loaded from: classes5.dex */
public class PlayTimeStatistician {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Map<PlayStep, Long> STEPS_MAP;
    public static final String TAG = "TimeStatistician";
    public transient /* synthetic */ FieldHolder $fh;
    public long mEndTime;
    public long mStartTime;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class PlayStep {
        public static final /* synthetic */ PlayStep[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PlayStep PLAY_ADD_STREAM;
        public static final PlayStep PLAY_ERROR;
        public static final PlayStep PLAY_FIRST_FRAME_RENDERED;
        public static final PlayStep PLAY_ICE_CONNECTED;
        public static final PlayStep PLAY_LIBRARY_LOADED;
        public static final PlayStep PLAY_LOCAL_SDP_SET;
        public static final PlayStep PLAY_REMOTE_SDP_ACQUIRED;
        public static final PlayStep PLAY_STARTED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(998971888, "Lcom/baidu/rtc/player/PlayTimeStatistician$PlayStep;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(998971888, "Lcom/baidu/rtc/player/PlayTimeStatistician$PlayStep;");
                    return;
                }
            }
            PLAY_LIBRARY_LOADED = new PlayStep("PLAY_LIBRARY_LOADED", 0, 0);
            PLAY_STARTED = new PlayStep("PLAY_STARTED", 1, 1);
            PLAY_LOCAL_SDP_SET = new PlayStep("PLAY_LOCAL_SDP_SET", 2, 2);
            PLAY_REMOTE_SDP_ACQUIRED = new PlayStep("PLAY_REMOTE_SDP_ACQUIRED", 3, 3);
            PLAY_ICE_CONNECTED = new PlayStep("PLAY_ICE_CONNECTED", 4, 4);
            PLAY_ADD_STREAM = new PlayStep("PLAY_ADD_STREAM", 5, 5);
            PLAY_FIRST_FRAME_RENDERED = new PlayStep("PLAY_FIRST_FRAME_RENDERED", 6, 6);
            PlayStep playStep = new PlayStep("PLAY_ERROR", 7, 7);
            PLAY_ERROR = playStep;
            $VALUES = new PlayStep[]{PLAY_LIBRARY_LOADED, PLAY_STARTED, PLAY_LOCAL_SDP_SET, PLAY_REMOTE_SDP_ACQUIRED, PLAY_ICE_CONNECTED, PLAY_ADD_STREAM, PLAY_FIRST_FRAME_RENDERED, playStep};
        }

        public PlayStep(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static PlayStep valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (PlayStep) Enum.valueOf(PlayStep.class, str) : (PlayStep) invokeL.objValue;
        }

        public static PlayStep[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (PlayStep[]) $VALUES.clone() : (PlayStep[]) invokeV.objValue;
        }

        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1203127938, "Lcom/baidu/rtc/player/PlayTimeStatistician;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1203127938, "Lcom/baidu/rtc/player/PlayTimeStatistician;");
                return;
            }
        }
        TreeMap treeMap = new TreeMap(new Comparator<PlayStep>() { // from class: com.baidu.rtc.player.PlayTimeStatistician.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(PlayStep playStep, PlayStep playStep2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, playStep, playStep2)) == null) {
                    if (playStep.value == playStep2.value) {
                        return 0;
                    }
                    return playStep.value > playStep2.value ? 1 : -1;
                }
                return invokeLL.intValue;
            }
        });
        STEPS_MAP = treeMap;
        treeMap.put(PlayStep.PLAY_LIBRARY_LOADED, new Long(-1L));
        STEPS_MAP.put(PlayStep.PLAY_STARTED, new Long(-1L));
        STEPS_MAP.put(PlayStep.PLAY_LOCAL_SDP_SET, new Long(-1L));
        STEPS_MAP.put(PlayStep.PLAY_REMOTE_SDP_ACQUIRED, new Long(-1L));
        STEPS_MAP.put(PlayStep.PLAY_ICE_CONNECTED, new Long(-1L));
        STEPS_MAP.put(PlayStep.PLAY_ADD_STREAM, new Long(-1L));
        STEPS_MAP.put(PlayStep.PLAY_FIRST_FRAME_RENDERED, new Long(-1L));
        STEPS_MAP.put(PlayStep.PLAY_ERROR, new Long(-1L));
    }

    public PlayTimeStatistician() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public long getEndTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mEndTime : invokeV.longValue;
    }

    public long getStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mStartTime : invokeV.longValue;
    }

    public long getStepTargetTime(PlayStep playStep, PlayStep playStep2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, playStep, playStep2)) == null) ? STEPS_MAP.get(playStep).longValue() - STEPS_MAP.get(playStep2).longValue() : invokeLL.longValue;
    }

    public long getStepTime(PlayStep playStep) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, playStep)) == null) ? STEPS_MAP.get(playStep).longValue() : invokeL.longValue;
    }

    public Map<PlayStep, Long> getTimeStepsMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? STEPS_MAP : (Map) invokeV.objValue;
    }

    public void setStartTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mStartTime = System.currentTimeMillis();
            for (Map.Entry<PlayStep, Long> entry : STEPS_MAP.entrySet()) {
                entry.setValue(new Long(-1L));
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "TimeStatistician{ startTime=" + this.mStartTime + " timeStepsMap=" + STEPS_MAP.toString() + " endTime=" + this.mEndTime + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public void updateStepTime(PlayStep playStep) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, playStep) == null) {
            STEPS_MAP.put(playStep, Long.valueOf(System.currentTimeMillis() - this.mStartTime));
            if (playStep == PlayStep.PLAY_ERROR || playStep == PlayStep.PLAY_FIRST_FRAME_RENDERED) {
                this.mEndTime = System.currentTimeMillis();
            }
            Logging.d(TAG, "Play step " + playStep + " total expend " + STEPS_MAP.get(playStep));
        }
    }
}
