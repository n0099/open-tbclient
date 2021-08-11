package com.baidu.searchbox.player.kernel;

import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class TextureVideoKernel extends AbsVideoCyber {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TextureVideoKernel";
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurrentVideoHeight;
    public int mCurrentVideoWidth;
    public Surface mSurface;
    public TextureView mTextureView;
    public HashMap<String, String> options;

    public TextureVideoKernel(@NonNull TextureView textureView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {textureView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mCurrentVideoWidth = 0;
        this.mCurrentVideoHeight = 0;
        this.mTextureView = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener(this) { // from class: com.baidu.searchbox.player.kernel.TextureVideoKernel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TextureVideoKernel this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeLII(1048576, this, surfaceTexture, i4, i5) == null) || surfaceTexture == null) {
                    return;
                }
                this.this$0.mSurface = new Surface(surfaceTexture);
                TextureVideoKernel textureVideoKernel = this.this$0;
                textureVideoKernel.mPlayer.setSurface(textureVideoKernel.mSurface);
                BdVideoLog.d("TextureVideoKernel", "surfaceView created");
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, surfaceTexture)) == null) {
                    BdVideoLog.d("TextureVideoKernel", "surfaceView destroyed");
                    return false;
                }
                return invokeL.booleanValue;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLII(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture, i4, i5) == null) {
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, surfaceTexture) == null) {
                }
            }
        });
    }

    private void prepareInternal() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.mHeader.size() > 0) {
                setVideoURI(Uri.parse(this.mVideoUrl), this.mHeader);
            } else {
                setVideoURI(Uri.parse(this.mVideoUrl), null);
            }
        }
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            BdVideoLog.d("TextureVideoKernel", "reset");
            this.mPlayer.reset();
        }
    }

    private void setVideoURI(Uri uri, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, uri, hashMap) == null) {
            BdVideoLog.d("TextureVideoKernel", "setVideoURI");
            try {
                initPlayer();
                if (this.options != null) {
                    this.options = null;
                    for (Map.Entry<String, String> entry : this.options.entrySet()) {
                        this.mPlayer.setOption(entry.getKey(), entry.getValue());
                    }
                }
                if (this.mTextureView != null) {
                    this.mCurrentVideoWidth = 0;
                    this.mCurrentVideoHeight = 0;
                    SurfaceTexture surfaceTexture = this.mTextureView.getSurfaceTexture();
                    if (surfaceTexture != null) {
                        Surface surface = new Surface(surfaceTexture);
                        this.mSurface = surface;
                        this.mPlayer.setSurface(surface);
                    }
                }
                this.mPlayer.setDataSource(BDPlayerConfig.getAppContext(), uri, hashMap);
                this.mPlayer.setScreenOnWhilePlaying(true);
                this.mPlayer.prepareAsync();
            } catch (Exception e2) {
                e2.printStackTrace();
                onError(-111, 0, null);
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void changePlayUrl(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    @NonNull
    public View getBVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTextureView : (View) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCurrentVideoHeight : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCurrentVideoWidth : invokeV.intValue;
    }

    public void onError(int i2, int i3, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, obj) == null) {
            BdVideoLog.d("TextureVideoKernel", "onError what " + i2 + " extra " + i3 + " obj " + obj);
            stop();
            this.mKernelStatus.stateChangeNotify(PlayerStatus.ERROR);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onPrepared();
            int i2 = this.mStorePosition;
            if (i2 > 2) {
                this.mPlayer.seekTo(i2 - 2);
                this.mStorePosition = -1;
            }
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void play(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            super.play(str);
            if (!TextUtils.equals(this.mPreparingUrl, str)) {
                this.mPlayer.stop();
                prepareInternal();
            }
            if (!AbsVideoKernel.PRELOAD_PREFIX.equals(this.mVideoUrl)) {
                this.mPlayer.start();
            }
            this.mStorePosition = -1;
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel
    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.searchbox.player.kernel.AbsVideoKernel, com.baidu.searchbox.player.pool.IPoolItem
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? "TextureVideoKernel".equals(str) : invokeL.booleanValue;
    }
}
