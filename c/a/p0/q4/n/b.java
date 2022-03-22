package c.a.p0.q4.n;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import c.a.v0.r.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.editvideo.player.VideoPlayData;
import com.baidu.ugc.editvideo.record.source.AMediaPlayer;
import com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends AMediaPlayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public C1344b f17820b;

    /* renamed from: c  reason: collision with root package name */
    public final SimpleExoPlayer f17821c;

    /* renamed from: d  reason: collision with root package name */
    public IMediaPlayer.OnSpeedChangeListener f17822d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17823e;

    /* renamed from: f  reason: collision with root package name */
    public int f17824f;

    /* renamed from: g  reason: collision with root package name */
    public String f17825g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f17826h;
    public MediaSource i;
    public DefaultDataSourceFactory j;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = "QMExoMP@" + Integer.toHexString(hashCode());
        this.a = context.getApplicationContext();
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        this.f17821c = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(context, null), new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(defaultBandwidthMeter)), new DefaultLoadControl());
        C1344b c1344b = new C1344b(this, null);
        this.f17820b = c1344b;
        this.f17821c.addListener(c1344b);
        this.f17821c.addVideoListener(this.f17820b);
        this.f17821c.setPlayWhenReady(false);
        this.f17826h = new Handler(Looper.getMainLooper());
        String userAgent = Util.getUserAgent(this.a, "ExoMediaPlayer");
        this.f17825g = userAgent;
        this.j = new DefaultDataSourceFactory(this.a, userAgent, defaultBandwidthMeter);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.f17821c;
            if (simpleExoPlayer == null) {
                return 0L;
            }
            Timeline currentTimeline = simpleExoPlayer.getCurrentTimeline();
            int currentWindowIndex = this.f17821c.getCurrentWindowIndex();
            long currentPosition = this.f17821c.getCurrentPosition();
            Timeline.Window window = new Timeline.Window();
            if (currentTimeline != null) {
                for (int i = 0; i < currentTimeline.getWindowCount(); i++) {
                    long durationMs = currentTimeline.getWindow(i, window).getDurationMs();
                    if (i < currentWindowIndex) {
                        currentPosition += durationMs;
                    }
                }
            }
            return currentPosition;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getDuration() {
        InterceptResult invokeV;
        SimpleExoPlayer simpleExoPlayer;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f17823e && (simpleExoPlayer = this.f17821c) != null) {
                Timeline currentTimeline = simpleExoPlayer.getCurrentTimeline();
                this.f17821c.getCurrentWindowIndex();
                this.f17821c.getCurrentPosition();
                Timeline.Window window = new Timeline.Window();
                if (currentTimeline != null) {
                    j = 0;
                    for (int i = 0; i < currentTimeline.getWindowCount(); i++) {
                        j += currentTimeline.getWindow(i, window).getDurationMs();
                    }
                } else {
                    j = 0;
                }
                return j == 0 ? this.f17824f : j;
            }
            return this.f17824f;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.f17821c;
            if (simpleExoPlayer != null) {
                return simpleExoPlayer.getPlaybackParameters().speed;
            }
            return 1.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.AMediaPlayer, com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public int getPlaybackState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17821c.getPlaybackState() : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public float getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.f17821c;
            if (simpleExoPlayer != null) {
                return simpleExoPlayer.getVolume();
            }
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public boolean isEnd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getCurrentPosition() >= getDuration() - 200 && getPlaybackState() == 4 : invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public boolean isPlayable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int playbackState = this.f17821c.getPlaybackState();
            return (playbackState == 1 || playbackState == 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        SimpleExoPlayer simpleExoPlayer;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? isPlayable() && (simpleExoPlayer = this.f17821c) != null && simpleExoPlayer.getPlaybackState() != 4 && this.f17821c.getPlayWhenReady() : invokeV.booleanValue;
    }

    public final MediaSource o(Uri uri, String str) {
        InterceptResult invokeLL;
        int inferContentType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                inferContentType = Util.inferContentType(uri);
            } else {
                inferContentType = Util.inferContentType("." + str);
            }
            if (inferContentType != 0) {
                if (inferContentType != 1) {
                    if (inferContentType != 2) {
                        if (inferContentType == 3) {
                            return new ExtractorMediaSource(uri, this.j, new DefaultExtractorsFactory(), this.f17826h, null);
                        }
                        throw new IllegalStateException("Unsupported type: " + inferContentType);
                    }
                    return new HlsMediaSource(uri, this.j, this.f17826h, null);
                }
                return new SsMediaSource(uri, new DefaultDataSourceFactory(this.a, this.f17825g), new DefaultSsChunkSource.Factory(this.j), this.f17826h, (AdaptiveMediaSourceEventListener) null);
            }
            return new DashMediaSource(uri, new DefaultDataSourceFactory(this.a, this.f17825g), new DefaultDashChunkSource.Factory(this.j), this.f17826h, (AdaptiveMediaSourceEventListener) null);
        }
        return (MediaSource) invokeLL.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void pause() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f17823e) {
            SimpleExoPlayer simpleExoPlayer = this.f17821c;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlayWhenReady(false);
            }
            notifyOnPlayStateChange(2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void prepareAsync() throws IllegalStateException {
        C1344b c1344b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f17823e || this.i == null || (c1344b = this.f17820b) == null || c1344b.a) {
            return;
        }
        this.f17821c.prepare(this.i);
        this.f17820b.a = true;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f17823e = false;
            this.i = null;
            C1344b c1344b = this.f17820b;
            if (c1344b != null) {
                c1344b.a = false;
            }
            this.f17824f = 0;
            this.f17821c.release();
            C1344b c1344b2 = this.f17820b;
            if (c1344b2 != null) {
                this.f17821c.removeVideoListener(c1344b2);
                this.f17821c.removeListener(this.f17820b);
            }
            this.f17820b = null;
            releaseListeners();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.i = null;
            this.f17823e = false;
            C1344b c1344b = this.f17820b;
            if (c1344b != null) {
                c1344b.a = false;
            }
            this.f17824f = 0;
            SimpleExoPlayer simpleExoPlayer = this.f17821c;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.stop();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void seekTo(long j) throws IllegalStateException {
        SimpleExoPlayer simpleExoPlayer;
        int currentWindowIndex;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j) == null) && this.f17823e && (simpleExoPlayer = this.f17821c) != null) {
            Timeline currentTimeline = simpleExoPlayer.getCurrentTimeline();
            if (!currentTimeline.isEmpty()) {
                int windowCount = currentTimeline.getWindowCount();
                currentWindowIndex = 0;
                while (true) {
                    long durationMs = currentTimeline.getWindow(currentWindowIndex, new Timeline.Window()).getDurationMs();
                    if (j < durationMs) {
                        break;
                    } else if (currentWindowIndex == windowCount - 1) {
                        j = durationMs;
                        break;
                    } else {
                        j -= durationMs;
                        currentWindowIndex++;
                    }
                }
            } else {
                currentWindowIndex = this.f17821c.getCurrentWindowIndex();
            }
            this.f17821c.seekTo(currentWindowIndex, j);
            C1344b c1344b = this.f17820b;
            if (c1344b != null) {
                c1344b.f17827b = true;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void seekToForce(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            seekTo(j);
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setAudioDataSource(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f17823e = false;
            this.f17824f = 0;
            int size = list.size();
            MediaSource[] mediaSourceArr = new MediaSource[size];
            int i = 0;
            for (int i2 = 0; i2 < list.size() && i2 < size; i2++) {
                AudioPlayData audioPlayData = list.get(i2);
                int i3 = audioPlayData.realDuration;
                audioPlayData.offset = i;
                int i4 = audioPlayData.end - audioPlayData.start;
                i += i4;
                this.f17824f += i4;
                MediaSource o = o(Uri.parse(audioPlayData.audioPath), "");
                int i5 = audioPlayData.start;
                if (i5 < 0) {
                    i5 = 0;
                }
                int i6 = audioPlayData.end;
                if (i6 <= i3) {
                    i3 = i6;
                }
                mediaSourceArr[i2] = new ClippingMediaSource(o, i5 * 1000, i3 * 1000);
            }
            this.i = new ConcatenatingMediaSource(mediaSourceArr);
            setPlaybackState(IMediaPlayer.STATE_GOT_SOURCE);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.AMediaPlayer, com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            setDataSource(null, Uri.parse(Uri.encode(str)), null);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        SimpleExoPlayer simpleExoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, surfaceHolder) == null) || (simpleExoPlayer = this.f17821c) == null) {
            return;
        }
        simpleExoPlayer.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnSpeedChangeListener(IMediaPlayer.OnSpeedChangeListener onSpeedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onSpeedChangeListener) == null) {
            this.f17822d = onSpeedChangeListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean setPlaybackSpeed(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048597, this, f2)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.f17821c;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlaybackParameters(new PlaybackParameters(f2, 1.0f));
                return true;
            }
            return true;
        }
        return invokeF.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setSurface(Surface surface) {
        SimpleExoPlayer simpleExoPlayer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, surface) == null) || (simpleExoPlayer = this.f17821c) == null) {
            return;
        }
        simpleExoPlayer.setVideoSurface(surface);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f17821c.setVolume(f2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void start() throws IllegalStateException {
        SimpleExoPlayer simpleExoPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.f17823e && (simpleExoPlayer = this.f17821c) != null) {
            if (simpleExoPlayer.getPlaybackState() == 4) {
                seekTo(0L);
            } else {
                this.f17821c.setPlayWhenReady(true);
            }
            notifyOnPlayStateChange(1);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void stop() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.i = null;
            this.f17823e = false;
            C1344b c1344b = this.f17820b;
            if (c1344b != null) {
                c1344b.a = false;
            }
            SimpleExoPlayer simpleExoPlayer = this.f17821c;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.stop();
            }
            notifyOnPlayStateChange(2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.AMediaPlayer, com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, context, uri, map) == null) {
            this.f17823e = false;
            super.setDataSource(context, uri, map);
            this.i = o(uri, "");
            setPlaybackState(IMediaPlayer.STATE_GOT_SOURCE);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(uri.getPath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            this.f17824f = g.c(extractMetadata, 0);
        }
    }

    /* renamed from: c.a.p0.q4.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1344b extends Player.DefaultEventListener implements SimpleExoPlayer.VideoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f17827b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17828c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f17829d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f17830e;

        public C1344b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17830e = bVar;
            this.a = false;
            this.f17827b = false;
            this.f17828c = false;
            this.f17829d = false;
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, playbackParameters) == null) || this.f17830e.f17822d == null || playbackParameters == null) {
                return;
            }
            this.f17830e.f17822d.onSpeedChange(playbackParameters.speed);
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exoPlaybackException) == null) {
                this.f17830e.notifyOnError(1, 1, exoPlaybackException);
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                this.f17830e.setPlaybackState(i);
                if (this.f17828c && (i == 3 || i == 4)) {
                    this.f17828c = false;
                    b bVar = this.f17830e;
                    bVar.notifyOnInfo(702, bVar.f17821c.getBufferedPercentage());
                }
                if (this.a && i == 3) {
                    this.a = false;
                    this.f17830e.f17823e = true;
                    this.f17830e.notifyOnPrepared();
                }
                if (this.f17827b && i == 3) {
                    this.f17827b = false;
                    this.f17830e.notifyOnSeekComplete();
                }
                if (i == 2) {
                    b bVar2 = this.f17830e;
                    bVar2.notifyOnInfo(701, bVar2.f17821c.getBufferedPercentage());
                    this.f17828c = true;
                } else if (i != 3) {
                    if (i == 4 && !this.f17829d) {
                        this.f17829d = true;
                        if (!this.f17830e.isLooping()) {
                            this.f17830e.notifyOnPlayStateChange(2);
                            this.f17830e.notifyOnCompletion();
                            return;
                        }
                        this.f17830e.seekTo(0L);
                        this.f17830e.notifyOnLooping();
                    }
                } else {
                    this.f17829d = false;
                }
            }
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onRenderedFirstFrame() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f17830e.notifyOnInfo(3, 0);
            }
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)}) == null) {
                this.f17830e.notifyOnVideoSizeChanged(i, i2, i3, f2);
            }
        }

        public /* synthetic */ C1344b(b bVar, a aVar) {
            this(bVar);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(List<VideoPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.f17823e = false;
            this.f17824f = 0;
            MediaSource[] mediaSourceArr = new MediaSource[list.size()];
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                VideoPlayData videoPlayData = list.get(i2);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(videoPlayData.videoPath);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(9);
                mediaMetadataRetriever.release();
                int c2 = g.c(extractMetadata, 0);
                int c3 = g.c(extractMetadata2, 0);
                int c4 = g.c(extractMetadata3, 0);
                int c5 = g.c(extractMetadata4, 0);
                videoPlayData.rotation = c2;
                videoPlayData.width = c3;
                videoPlayData.height = c4;
                videoPlayData.offset = i;
                int i3 = videoPlayData.end - videoPlayData.start;
                i += i3;
                this.f17824f += i3;
                MediaSource o = o(Uri.parse(videoPlayData.videoPath), "");
                int i4 = videoPlayData.start;
                if (i4 < 0) {
                    i4 = 0;
                }
                int i5 = videoPlayData.end;
                if (i5 <= c5) {
                    c5 = i5;
                }
                mediaSourceArr[i2] = new ClippingMediaSource(o, i4 * 1000, c5 * 1000);
            }
            this.i = new ConcatenatingMediaSource(mediaSourceArr);
            setPlaybackState(IMediaPlayer.STATE_GOT_SOURCE);
        }
    }
}
