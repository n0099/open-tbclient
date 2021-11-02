package com.baidu.pass.face.platform.common;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.FaceEnvironment;
import com.baidu.pass.face.platform.FaceStatusNewEnum;
import com.baidu.pass.face.platform.utils.SoundPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class SoundPoolHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "SoundPoolHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public volatile boolean mIsEnableSound;
    public volatile boolean mIsPlaying;
    public volatile long mPlayDuration;
    public HashMap<Integer, Long> mPlayDurationMap;
    public FaceStatusNewEnum mPlaySoundStatusNewEnum;
    public volatile long mPlayTime;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1338435668, "Lcom/baidu/pass/face/platform/common/SoundPoolHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1338435668, "Lcom/baidu/pass/face/platform/common/SoundPoolHelper;");
        }
    }

    public SoundPoolHelper(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPlayDuration = 0L;
        this.mPlayTime = 0L;
        this.mIsPlaying = false;
        this.mIsEnableSound = true;
        this.mPlayDurationMap = new HashMap<>();
        this.mContext = context;
    }

    private long getSoundDuration(int i2) {
        InterceptResult invokeI;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(65538, this, i2)) != null) {
            return invokeI.longValue;
        }
        if (this.mPlayDurationMap.containsKey(Integer.valueOf(i2))) {
            return this.mPlayDurationMap.get(Integer.valueOf(i2)).longValue();
        }
        System.currentTimeMillis();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i2));
            j = Long.valueOf(mediaMetadataRetriever.extractMetadata(9)).longValue() + 0;
            try {
                this.mPlayDurationMap.put(Integer.valueOf(i2), Long.valueOf(j));
                return j;
            } catch (IllegalArgumentException e2) {
                e = e2;
                e.printStackTrace();
                return j;
            } catch (IllegalStateException e3) {
                e = e3;
                e.printStackTrace();
                return j;
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                return j;
            }
        } catch (IllegalArgumentException e5) {
            e = e5;
            j = 600;
        } catch (IllegalStateException e6) {
            e = e6;
            j = 600;
        } catch (Exception e7) {
            e = e7;
            j = 600;
        }
    }

    public boolean getEnableSound() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIsEnableSound : invokeV.booleanValue;
    }

    public long getPlayDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mPlayDuration : invokeV.longValue;
    }

    public boolean playSound(FaceStatusNewEnum faceStatusNewEnum) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, faceStatusNewEnum)) == null) {
            if (!this.mIsEnableSound) {
                SoundPlayer.release();
            }
            this.mIsPlaying = System.currentTimeMillis() - SoundPlayer.playTime < this.mPlayDuration;
            if (this.mIsPlaying || (this.mPlaySoundStatusNewEnum == faceStatusNewEnum && System.currentTimeMillis() - this.mPlayTime < FaceEnvironment.TIME_TIPS_REPEAT)) {
                return false;
            }
            this.mIsPlaying = true;
            this.mPlaySoundStatusNewEnum = faceStatusNewEnum;
            this.mPlayDuration = 0L;
            this.mPlayTime = System.currentTimeMillis();
            int soundId = FaceEnvironment.getSoundId(faceStatusNewEnum);
            if (soundId > 0) {
                this.mPlayDuration = getSoundDuration(soundId);
                SoundPlayer.playTime = System.currentTimeMillis();
                if (this.mIsEnableSound) {
                    SoundPlayer.play(this.mContext, soundId);
                }
            }
            return this.mIsPlaying;
        }
        return invokeL.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SoundPlayer.release();
            this.mPlayDuration = 0L;
            this.mPlayTime = 0L;
            this.mContext = null;
        }
    }

    public void setEnableSound(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.mIsEnableSound = z;
        }
    }
}
