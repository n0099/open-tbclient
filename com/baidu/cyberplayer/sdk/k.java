package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class k extends PlayerProvider implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cyberplayer.sdk.statistics.h f37955a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f37956b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f37957c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f37958d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f37959e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f37960f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f37961g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f37962h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f37963i;
    public CyberPlayerManager.OnMediaSourceChangedListener j;
    public boolean k;
    public long l;
    public int m;
    public long n;
    public String o;
    public long p;
    public long q;
    public long r;
    public int s;
    public boolean t;
    public long u;
    public long v;
    public int w;
    public int x;
    public int y;

    public k() {
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
        this.u = -1L;
        this.v = -1L;
        this.w = 3;
        this.x = 0;
        this.y = 0;
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f37956b = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        this.f37956b.setOnCompletionListener(this);
        this.f37956b.setOnBufferingUpdateListener(this);
        this.f37956b.setOnSeekCompleteListener(this);
        this.f37956b.setOnVideoSizeChangedListener(this);
        this.f37956b.setOnErrorListener(this);
        this.f37956b.setOnInfoListener(this);
        this.f37955a = new com.baidu.cyberplayer.sdk.statistics.h();
        d();
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.l = -1L;
            this.m = 0;
            this.n = -1L;
            this.p = 0L;
            this.r = -1L;
            this.t = false;
        }
    }

    private boolean e() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? (this.f37956b == null || (i2 = this.x) == -1 || i2 == 0 || i2 == 1) ? false : true : invokeV.booleanValue;
    }

    private void f() {
        com.baidu.cyberplayer.sdk.statistics.h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || (hVar = this.f37955a) == null || hVar.b()) {
            return;
        }
        if (this.l > 0 || this.t) {
            this.f37955a.a(this);
            this.f37955a.b(this);
            this.f37955a.c(this);
        }
        this.f37955a.c();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.n : invokeV.longValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.t : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MediaPlayer mediaPlayer = this.f37956b;
            if (mediaPlayer != null) {
                long j = this.u;
                if (j > -1) {
                    return (int) j;
                }
                int i2 = this.x;
                if (i2 != 0 && i2 != 1 && i2 != 2) {
                    try {
                        return mediaPlayer.getCurrentPosition();
                    } catch (IllegalStateException unused) {
                        CyberLog.e("MediaPlayerImpl", "getCurrentPosition IllegalStateException error");
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f37956b != null) {
                return this.s;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.n > 0) {
                if (this.q > 0) {
                    this.p += System.currentTimeMillis() - this.q;
                }
                this.r = (System.currentTimeMillis() - this.n) - this.p;
            }
            return this.r;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                if (this.f37956b != null) {
                    return this.f37956b.getVideoHeight();
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                if (this.f37956b != null) {
                    return this.f37956b.getVideoWidth();
                }
                return 0;
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            MediaPlayer mediaPlayer = this.f37956b;
            return mediaPlayer != null && mediaPlayer.isLooping();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? e() && this.x == 3 : invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.k = z;
            CyberLog.i("MediaPlayerImpl", "muteOrUnmuteAudio flag:" + z);
            if (this.f37956b == null) {
                return;
            }
            float f2 = this.k ? 0.0f : 1.0f;
            this.f37956b.setVolume(f2, f2);
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048592, this, mediaPlayer, i2) == null) || (onBufferingUpdateListener = this.f37959e) == null) {
            return;
        }
        onBufferingUpdateListener.onBufferingUpdate(i2);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mediaPlayer) == null) {
            CyberLog.i("MediaPlayerImpl", "onCompletion");
            this.x = 5;
            this.y = 5;
            CyberPlayerManager.OnCompletionListener onCompletionListener = this.f37958d;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048594, this, mediaPlayer, i2, i3)) == null) {
            CyberLog.i("MediaPlayerImpl", "onError");
            boolean z = CyberCfgManager.getInstance().a("drop_mediaplay_stop_error", true) && this.x == 0 && this.y == 0;
            this.x = -1;
            this.y = -1;
            if (z) {
                return false;
            }
            this.f37955a.a(DpStatConstants.SESSION_TYPE_ERROR, "error_code", i2);
            this.f37955a.a(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_SUB_CODE, i3);
            this.f37955a.a(DpStatConstants.SESSION_TYPE_ERROR, "time", System.currentTimeMillis());
            com.baidu.cyberplayer.sdk.statistics.h hVar = this.f37955a;
            hVar.a(DpStatConstants.SESSION_TYPE_ERROR, "detail", "mediaplay error(" + i2 + "," + i3);
            CyberPlayerManager.OnErrorListener onErrorListener = this.f37962h;
            return onErrorListener != null && onErrorListener.onError(i2, i3, null);
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, mediaPlayer, i2, i3)) == null) {
            CyberLog.i("MediaPlayerImpl", "onInfo");
            if (i2 == 3) {
                i2 = 904;
                this.f37955a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, (System.currentTimeMillis() - this.n) + this.m);
            }
            CyberPlayerManager.OnInfoListener onInfoListener = this.f37963i;
            return onInfoListener != null && onInfoListener.onInfo(i2, i3, null);
        }
        return invokeLII.booleanValue;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, mediaPlayer) == null) {
            CyberLog.i("MediaPlayerImpl", "onPrepared");
            this.x = 2;
            MediaPlayer mediaPlayer2 = this.f37956b;
            if (mediaPlayer2 != null) {
                this.s = mediaPlayer2.getDuration();
            }
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.f37957c;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
            int round = Math.round((float) (System.currentTimeMillis() - this.l));
            this.m = round;
            this.f37955a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_PREPARED, round);
            long j = this.v;
            if (j > 0) {
                seekTo(j, this.w);
            }
            this.v = -1L;
            if (this.y == 3) {
                start();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, mediaPlayer) == null) {
            this.u = -1L;
            CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.f37960f;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete();
            }
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048598, this, mediaPlayer, i2, i3) == null) {
            CyberLog.i("MediaPlayerImpl", "onVideoSizeChanged");
            CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.f37961g;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, 1, 1);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            CyberLog.i("MediaPlayerImpl", "pause");
            if (e()) {
                this.x = 4;
                try {
                    this.f37956b.pause();
                } catch (Exception unused) {
                    onError(this.f37956b, -10002, -10002);
                }
                if (this.n > 0 && this.q == 0) {
                    this.q = System.currentTimeMillis();
                }
            }
            this.y = 4;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            CyberLog.i("MediaPlayerImpl", "prepareAsync");
            if (this.f37956b != null) {
                this.x = 1;
                if (this.l == -1) {
                    this.l = System.currentTimeMillis();
                }
                try {
                    this.f37956b.prepareAsync();
                } catch (IllegalStateException unused) {
                    onError(this.f37956b, -10002, -10002);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            CyberLog.i("MediaPlayerImpl", "release");
            f();
            MediaPlayer mediaPlayer = this.f37956b;
            if (mediaPlayer != null) {
                this.v = -1L;
                this.t = false;
                this.x = 0;
                this.y = 0;
                mediaPlayer.setOnPreparedListener(null);
                this.f37956b.setOnCompletionListener(null);
                this.f37956b.setOnBufferingUpdateListener(null);
                this.f37956b.setOnSeekCompleteListener(null);
                this.f37956b.setOnVideoSizeChangedListener(null);
                this.f37956b.setOnErrorListener(null);
                this.f37956b.setOnInfoListener(null);
                this.f37957c = null;
                this.f37958d = null;
                this.f37959e = null;
                this.f37960f = null;
                this.f37961g = null;
                this.f37962h = null;
                this.f37963i = null;
                this.j = null;
                this.f37956b.release();
                this.f37956b = null;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            CyberLog.i("MediaPlayerImpl", "reset");
            f();
            this.v = -1L;
            this.u = -1L;
            this.x = 0;
            this.y = 0;
            d();
            MediaPlayer mediaPlayer = this.f37956b;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.reset();
                } catch (IllegalStateException unused) {
                    CyberLog.e("MediaPlayerImpl", "reset IllegalStateException error");
                }
            }
            com.baidu.cyberplayer.sdk.statistics.h hVar = this.f37955a;
            if (hVar != null) {
                hVar.c();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            seekTo(j, 3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            CyberLog.i("MediaPlayerImpl", "seekTo");
            if (this.f37956b != null) {
                if (e()) {
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            this.f37956b.seekTo((int) j, i2);
                        } else {
                            this.f37956b.seekTo((int) j);
                        }
                    } catch (Exception unused) {
                        onError(this.f37956b, -10002, -10002);
                    }
                } else {
                    this.v = j;
                    this.w = i2;
                }
                this.u = j;
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i2, int i3, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str}) == null) {
            try {
                switch (i2) {
                    case 1001:
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject(str);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f37955a.a(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                        }
                        return;
                    case 1002:
                        int round = Math.round((float) (j - this.n)) + this.m;
                        CyberLog.i("MediaPlayerImpl", "sendCommand COMMAND_ON_FIRST_FRAME_DRAWED firstFrameCostTime:" + round);
                        this.f37955a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, round);
                        CyberPlayerManager.OnInfoListener onInfoListener = this.f37963i;
                        if (onInfoListener != null) {
                            onInfoListener.onInfo(904, round, null);
                            return;
                        }
                        return;
                    case 1003:
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject(str);
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            this.f37955a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, next2, jSONObject2.getString(next2));
                        }
                        return;
                    default:
                        return;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, context, uri) == null) || this.f37956b == null) {
            return;
        }
        this.o = uri.toString();
        try {
            this.f37956b.setDataSource(context, uri);
        } catch (Exception unused) {
            onError(this.f37956b, -10001, -10001);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048607, this, context, uri, map) == null) || this.f37956b == null) {
            return;
        }
        this.o = uri.toString();
        try {
            this.f37956b.setDataSource(context, uri, map);
        } catch (Exception unused) {
            onError(this.f37956b, -10001, -10001);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, fileDescriptor) == null) {
            CyberLog.i("MediaPlayerImpl", "setDataSource 4");
            if (this.f37956b != null) {
                this.o = fileDescriptor.toString();
                try {
                    this.f37956b.setDataSource(fileDescriptor);
                } catch (Exception unused) {
                    onError(this.f37956b, -10001, -10001);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, str) == null) || (mediaPlayer = this.f37956b) == null) {
            return;
        }
        this.o = str;
        try {
            mediaPlayer.setDataSource(str);
        } catch (Exception unused) {
            onError(this.f37956b, -10001, -10001);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048610, this, str, map) == null) || (mediaPlayer = this.f37956b) == null) {
            return;
        }
        this.o = str;
        try {
            mediaPlayer.setDataSource(str);
        } catch (Exception unused) {
            onError(this.f37956b, -10001, -10001);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, surfaceHolder) == null) {
            CyberLog.i("MediaPlayerImpl", "setDisplay");
            MediaPlayer mediaPlayer = this.f37956b;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setDisplay(surfaceHolder);
                } catch (Exception unused) {
                    onError(this.f37956b, -10000, -10000);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || (mediaPlayer = this.f37956b) == null) {
            return;
        }
        mediaPlayer.setLooping(z);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, onBufferingUpdateListener) == null) {
            this.f37959e = onBufferingUpdateListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, onCompletionListener) == null) {
            this.f37958d = onCompletionListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, onErrorListener) == null) {
            this.f37962h = onErrorListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, onInfoListener) == null) {
            this.f37963i = onInfoListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, onMediaSourceChangedListener) == null) {
            this.j = onMediaSourceChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, onPreparedListener) == null) {
            this.f37957c = onPreparedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, onSeekCompleteListener) == null) {
            this.f37960f = onSeekCompleteListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onVideoSizeChangedListener) == null) {
            this.f37961g = onVideoSizeChangedListener;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048621, this, z) == null) || (mediaPlayer = this.f37956b) == null) {
            return;
        }
        mediaPlayer.setScreenOnWhilePlaying(z);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048622, this, f2) == null) || f2 < 0.0f || f2 > 4.0f || (mediaPlayer = this.f37956b) == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            boolean isPlaying = mediaPlayer.isPlaying();
            this.f37956b.setPlaybackParams(this.f37956b.getPlaybackParams().setSpeed(f2));
            if (isPlaying || !this.f37956b.isPlaying()) {
                return;
            }
            pause();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, surface) == null) {
            CyberLog.i("MediaPlayerImpl", "setSurface");
            MediaPlayer mediaPlayer = this.f37956b;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setSurface(surface);
                } catch (Exception unused) {
                    onError(this.f37956b, -10000, -10000);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) || (mediaPlayer = this.f37956b) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i2) {
        MediaPlayer mediaPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048625, this, context, i2) == null) || (mediaPlayer = this.f37956b) == null) {
            return;
        }
        mediaPlayer.setWakeMode(context, i2);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            CyberLog.i("MediaPlayerImpl", "start");
            if (e()) {
                this.x = 3;
                try {
                    this.f37956b.start();
                } catch (IllegalStateException unused) {
                    onError(this.f37956b, -10002, -10002);
                }
                if (this.n == -1) {
                    this.n = System.currentTimeMillis();
                    this.q = 0L;
                }
                if (this.q > 0) {
                    this.p += System.currentTimeMillis() - this.q;
                    this.q = 0L;
                }
            }
            this.t = true;
            this.y = 3;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            CyberLog.i("MediaPlayerImpl", IntentConfig.STOP);
            MediaPlayer mediaPlayer = this.f37956b;
            if (mediaPlayer != null) {
                this.v = -1L;
                this.x = 0;
                this.y = 0;
                try {
                    mediaPlayer.stop();
                } catch (Exception unused) {
                    onError(this.f37956b, -10002, -10002);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i2) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i2) == null) || (onMediaSourceChangedListener = this.j) == null) {
            return;
        }
        onMediaSourceChangedListener.onMediaSourceChanged(-100, i2, null);
    }
}
