package com.baidu.android.util.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.SoundPool;
import android.util.SparseIntArray;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SoundPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long LOAD_SOUND_MILLIS = 100;
    public static final int MAX_STREAMS = 5;
    public static final String TAG = "SoundPlayer";
    public static SoundPlayer sSoundPlayer;
    public transient /* synthetic */ FieldHolder $fh;
    public SoundPool mSoundPool;
    public SparseIntArray mSoundPoolCache;

    public SoundPlayer() {
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
        this.mSoundPool = new SoundPool(5, 3, 0);
        this.mSoundPoolCache = new SparseIntArray();
    }

    public static void release() {
        SoundPlayer soundPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (soundPlayer = sSoundPlayer) == null) {
            return;
        }
        int size = soundPlayer.mSoundPoolCache.size();
        for (int i2 = 0; i2 < size; i2++) {
            SoundPlayer soundPlayer2 = sSoundPlayer;
            soundPlayer2.mSoundPool.unload(soundPlayer2.mSoundPoolCache.valueAt(i2));
        }
        sSoundPlayer.mSoundPool.release();
        SoundPlayer soundPlayer3 = sSoundPlayer;
        soundPlayer3.mSoundPool = null;
        soundPlayer3.mSoundPoolCache.clear();
        sSoundPlayer.mSoundPoolCache = null;
        sSoundPlayer = null;
    }

    @SuppressLint({"NewApi"})
    public void play(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            if (sSoundPlayer == null) {
                sSoundPlayer = new SoundPlayer();
            }
            int i3 = sSoundPlayer.mSoundPoolCache.get(i2);
            if (i3 == 0) {
                int load = sSoundPlayer.mSoundPool.load(context, i2, 1);
                sSoundPlayer.mSoundPoolCache.put(i2, load);
                sSoundPlayer.mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener(this, load) { // from class: com.baidu.android.util.media.SoundPlayer.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SoundPlayer this$0;
                    public final /* synthetic */ int val$soundId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Integer.valueOf(load)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$soundId = load;
                    }

                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public void onLoadComplete(SoundPool soundPool, int i4, int i5) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLII(1048576, this, soundPool, i4, i5) == null) && i5 == 0 && this.val$soundId == i4) {
                            try {
                                SoundPlayer.sSoundPlayer.mSoundPool.play(this.val$soundId, 1.0f, 1.0f, 5, 0, 1.0f);
                            } catch (NullPointerException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            sSoundPlayer.mSoundPool.play(i3, 1.0f, 1.0f, 5, 0, 1.0f);
        }
    }
}
