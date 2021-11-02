package com.baidu.rtc.record;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class MediaEncodeParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AAC_SAMPLES_PER_FRAME = 1024;
    public static final int AUDIO_BIT_RATE = 65536;
    public static final int AUDIO_CHANNEL = 1;
    public static final int AUDIO_FRAME_SIZE = 10240;
    public static final String AUDIO_MIME_TYPE = "audio/mp4a-latm";
    public static final int AUDIO_SAMPLE_RATE = 48000;
    public static final int OUTPUT_FORMAT = 0;
    public static final long OUTPUT_TOTAL_MS = 0;
    public static final int VIDEO_BIT_RATE = 2097152;
    public static final int VIDEO_FRAME_RATE = 30;
    public static final int VIDEO_HEIGHT = 1280;
    public static final int VIDEO_I_FRAME_INTERVAL = 5;
    public static final String VIDEO_MIME_TYPE = "video/avc";
    public static final int VIDEO_WIDTH = 720;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAudioBitrate;
    public int mAudioChannel;
    public String mAudioCodec;
    public int mAudioFrameSize;
    public boolean mAudioIncluded;
    public int mAudioSampleRate;
    public int mOutputFormat;
    public long mOutputTotalMs;
    public int mVideoBitrate;
    public String mVideoCodec;
    public int mVideoFrameRate;
    public int mVideoHeight;
    public int mVideoIFrameInterval;
    public boolean mVideoIncluded;
    public int mVideoWidth;

    public MediaEncodeParams() {
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
        this.mOutputFormat = 0;
        this.mOutputTotalMs = 0L;
        this.mVideoIncluded = true;
        this.mVideoWidth = 720;
        this.mVideoHeight = 1280;
        this.mVideoCodec = "video/avc";
        this.mVideoBitrate = 2097152;
        this.mVideoFrameRate = 30;
        this.mVideoIFrameInterval = 5;
        this.mAudioIncluded = true;
        this.mAudioCodec = "audio/mp4a-latm";
        this.mAudioChannel = 1;
        this.mAudioBitrate = 65536;
        this.mAudioSampleRate = AUDIO_SAMPLE_RATE;
        this.mAudioFrameSize = 10240;
    }

    public int getAudioBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAudioBitrate : invokeV.intValue;
    }

    public int getAudioChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAudioChannel : invokeV.intValue;
    }

    public String getAudioCodec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAudioCodec : (String) invokeV.objValue;
    }

    public int getAudioFrameSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAudioFrameSize : invokeV.intValue;
    }

    public int getAudioSampleRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mAudioSampleRate : invokeV.intValue;
    }

    public int getOutputFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mOutputFormat : invokeV.intValue;
    }

    public long getOutputTotalMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mOutputTotalMs : invokeV.longValue;
    }

    public int getVideoBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mVideoBitrate : invokeV.intValue;
    }

    public String getVideoCodec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mVideoCodec : (String) invokeV.objValue;
    }

    public int getVideoFrameRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mVideoFrameRate : invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mVideoHeight : invokeV.intValue;
    }

    public int getVideoIFrameInterval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mVideoIFrameInterval : invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mVideoWidth : invokeV.intValue;
    }

    public boolean isAudioIncluded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mAudioIncluded : invokeV.booleanValue;
    }

    public boolean isVideoIncluded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mVideoIncluded : invokeV.booleanValue;
    }

    public void setAudioBitrate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.mAudioBitrate = i2;
        }
    }

    public void setAudioChannel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.mAudioChannel = i2;
        }
    }

    public void setAudioCodec(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.mAudioCodec = str;
        }
    }

    public void setAudioFrameSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.mAudioFrameSize = i2;
        }
    }

    public void setAudioIncluded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mAudioIncluded = z;
        }
    }

    public void setAudioSampleRate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.mAudioSampleRate = i2;
        }
    }

    public void setOutputFormat(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.mOutputFormat = i2;
        }
    }

    public void setOutputTotalMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.mOutputTotalMs = j;
        }
    }

    public void setVideoBitrate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.mVideoBitrate = i2;
        }
    }

    public void setVideoCodec(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.mVideoCodec = str;
        }
    }

    public void setVideoFrameRate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.mVideoFrameRate = i2;
        }
    }

    public void setVideoHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.mVideoHeight = i2;
        }
    }

    public void setVideoIFrameInterval(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.mVideoIFrameInterval = i2;
        }
    }

    public void setVideoIncluded(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mVideoIncluded = z;
        }
    }

    public void setVideoWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.mVideoWidth = i2;
        }
    }
}
