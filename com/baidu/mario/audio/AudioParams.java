package com.baidu.mario.audio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@NotProguard
/* loaded from: classes2.dex */
public class AudioParams {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 32768;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 1;
    public static final int DEFAULT_BUFFER_FRAME_COUNT = 32;
    public static final int DEFAULT_CHANNEL_CONFIG = 16;
    public static final int DEFAULT_FRAME_SIZE = 1024;
    public static final int DEFAULT_SAMPLE_RATE = 16000;
    public static final int SAMPLES_PER_FRAME = 1024;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAudioBufferSize;
    public int mAudioFormat;
    public int mAudioSource;
    public int mChannelConfig;
    public int mFrameBufferCount;
    public int mFrameSize;
    public int mSampleRate;

    public AudioParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAudioSource = 1;
        this.mSampleRate = 16000;
        this.mChannelConfig = 16;
        this.mAudioFormat = 2;
        this.mFrameSize = 1024;
        this.mFrameBufferCount = 32;
        this.mAudioBufferSize = 32768;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof AudioParams)) {
                AudioParams audioParams = (AudioParams) obj;
                return this.mAudioSource == audioParams.mAudioSource && this.mSampleRate == audioParams.getSampleRate() && this.mChannelConfig == audioParams.getChannelConfig() && this.mAudioFormat == audioParams.getAudioFormat() && this.mFrameSize == audioParams.getFrameSize();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int getAudioBufferSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mAudioBufferSize : invokeV.intValue;
    }

    public int getAudioFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAudioFormat : invokeV.intValue;
    }

    public int getAudioSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mAudioSource : invokeV.intValue;
    }

    public int getChannelConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mChannelConfig : invokeV.intValue;
    }

    public int getFrameBufferCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mFrameBufferCount : invokeV.intValue;
    }

    public int getFrameSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mFrameSize : invokeV.intValue;
    }

    public int getSampleRate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSampleRate : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ((((((((this.mAudioSource + 31) * 31) + this.mSampleRate) * 31) + this.mChannelConfig) * 31) + this.mAudioFormat) * 31) + this.mFrameSize : invokeV.intValue;
    }

    public void setAudioBufferSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mAudioBufferSize = i;
        }
    }

    public void setAudioFormat(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.mAudioFormat = i;
        }
    }

    public void setAudioSource(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.mAudioSource = i;
        }
    }

    public void setChannelConfig(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mChannelConfig = i;
        }
    }

    public void setFrameBufferCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.mFrameBufferCount = i;
        }
    }

    public void setFrameSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mFrameSize = i;
        }
    }

    public void setSampleRate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mSampleRate = i;
        }
    }
}
