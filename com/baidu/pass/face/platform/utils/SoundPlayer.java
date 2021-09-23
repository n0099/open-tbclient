package com.baidu.pass.face.platform.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class SoundPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final long LOAD_SOUND_MILLIS = 100;
    public static final int MAX_STREAMS = 5;
    public static final String TAG = "SoundPlayer";
    public static long playTime;
    public static SoundPlayer sSoundPlayer;
    public transient /* synthetic */ FieldHolder $fh;
    public SoundPool mSoundPool;
    public SparseIntArray mSoundPoolCache;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1486818435, "Lcom/baidu/pass/face/platform/utils/SoundPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1486818435, "Lcom/baidu/pass/face/platform/utils/SoundPlayer;");
        }
    }

    public SoundPlayer() {
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
        this.mSoundPool = new SoundPool(5, 3, 0);
        this.mSoundPoolCache = new SparseIntArray();
        playTime = 0L;
    }

    @SuppressLint({"NewApi"})
    public static void play(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i2) == null) {
            if (sSoundPlayer == null) {
                sSoundPlayer = new SoundPlayer();
            }
            try {
                int i3 = sSoundPlayer.mSoundPoolCache.get(i2);
                if (i3 == 0) {
                    int load = sSoundPlayer.mSoundPool.load(context, i2, 1);
                    sSoundPlayer.mSoundPoolCache.put(i2, load);
                    if (APIUtils.hasFroyo()) {
                        sSoundPlayer.mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener(load) { // from class: com.baidu.pass.face.platform.utils.SoundPlayer.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int val$soundId;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {Integer.valueOf(load)};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i4 = newInitContext.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.val$soundId = load;
                            }

                            @Override // android.media.SoundPool.OnLoadCompleteListener
                            public final void onLoadComplete(SoundPool soundPool, int i4, int i5) {
                                Interceptable interceptable2 = $ic;
                                if ((interceptable2 == null || interceptable2.invokeLII(1048576, this, soundPool, i4, i5) == null) && i5 == 0 && this.val$soundId == i4) {
                                    try {
                                        SoundPlayer.playTime = System.currentTimeMillis();
                                        SoundPlayer.sSoundPlayer.mSoundPool.play(this.val$soundId, 1.0f, 1.0f, 5, 0, 1.0f);
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        });
                        return;
                    }
                    try {
                        Thread.currentThread().join(100L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    playTime = System.currentTimeMillis();
                    sSoundPlayer.mSoundPool.play(load, 1.0f, 1.0f, 5, 0, 1.0f);
                    return;
                }
                try {
                    sSoundPlayer.mSoundPool.play(i3, 1.0f, 1.0f, 5, 0, 1.0f);
                    return;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            e4.printStackTrace();
        }
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            try {
                if (sSoundPlayer != null) {
                    int size = sSoundPlayer.mSoundPoolCache.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        sSoundPlayer.mSoundPool.unload(sSoundPlayer.mSoundPoolCache.valueAt(i2));
                    }
                    sSoundPlayer.mSoundPool.release();
                    sSoundPlayer.mSoundPool = null;
                    sSoundPlayer.mSoundPoolCache.clear();
                    sSoundPlayer.mSoundPoolCache = null;
                    sSoundPlayer = null;
                }
                playTime = 0L;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
