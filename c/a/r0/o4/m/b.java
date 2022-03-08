package c.a.r0.o4.m;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.core.view.InputDeviceCompat;
import c.a.y0.r.g;
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
    public C1291b f20575b;

    /* renamed from: c  reason: collision with root package name */
    public final SimpleExoPlayer f20576c;

    /* renamed from: d  reason: collision with root package name */
    public IMediaPlayer.OnSpeedChangeListener f20577d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f20578e;

    /* renamed from: f  reason: collision with root package name */
    public int f20579f;

    /* renamed from: g  reason: collision with root package name */
    public String f20580g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f20581h;

    /* renamed from: i  reason: collision with root package name */
    public MediaSource f20582i;

    /* renamed from: j  reason: collision with root package name */
    public DefaultDataSourceFactory f20583j;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        String str = "QMExoMP@" + Integer.toHexString(hashCode());
        this.a = context.getApplicationContext();
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        this.f20576c = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(context, null), new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(defaultBandwidthMeter)), new DefaultLoadControl());
        C1291b c1291b = new C1291b(this, null);
        this.f20575b = c1291b;
        this.f20576c.addListener(c1291b);
        this.f20576c.addVideoListener(this.f20575b);
        this.f20576c.setPlayWhenReady(false);
        this.f20581h = new Handler(Looper.getMainLooper());
        String userAgent = Util.getUserAgent(this.a, "ExoMediaPlayer");
        this.f20580g = userAgent;
        this.f20583j = new DefaultDataSourceFactory(this.a, userAgent, defaultBandwidthMeter);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.f20576c;
            if (simpleExoPlayer == null) {
                return 0L;
            }
            Timeline currentTimeline = simpleExoPlayer.getCurrentTimeline();
            int currentWindowIndex = this.f20576c.getCurrentWindowIndex();
            long currentPosition = this.f20576c.getCurrentPosition();
            Timeline.Window window = new Timeline.Window();
            if (currentTimeline != null) {
                for (int i2 = 0; i2 < currentTimeline.getWindowCount(); i2++) {
                    long durationMs = currentTimeline.getWindow(i2, window).getDurationMs();
                    if (i2 < currentWindowIndex) {
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
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f20578e && (simpleExoPlayer = this.f20576c) != null) {
                Timeline currentTimeline = simpleExoPlayer.getCurrentTimeline();
                this.f20576c.getCurrentWindowIndex();
                this.f20576c.getCurrentPosition();
                Timeline.Window window = new Timeline.Window();
                if (currentTimeline != null) {
                    j2 = 0;
                    for (int i2 = 0; i2 < currentTimeline.getWindowCount(); i2++) {
                        j2 += currentTimeline.getWindow(i2, window).getDurationMs();
                    }
                } else {
                    j2 = 0;
                }
                return j2 == 0 ? this.f20579f : j2;
            }
            return this.f20579f;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public float getPlaybackSpeed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.f20576c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f20576c.getPlaybackState() : invokeV.intValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public float getVolume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.f20576c;
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
            int playbackState = this.f20576c.getPlaybackState();
            return (playbackState == 1 || playbackState == 2) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean isPlaying() {
        InterceptResult invokeV;
        SimpleExoPlayer simpleExoPlayer;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? isPlayable() && (simpleExoPlayer = this.f20576c) != null && simpleExoPlayer.getPlaybackState() != 4 && this.f20576c.getPlayWhenReady() : invokeV.booleanValue;
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
                            return new ExtractorMediaSource(uri, this.f20583j, new DefaultExtractorsFactory(), this.f20581h, null);
                        }
                        throw new IllegalStateException("Unsupported type: " + inferContentType);
                    }
                    return new HlsMediaSource(uri, this.f20583j, this.f20581h, null);
                }
                return new SsMediaSource(uri, new DefaultDataSourceFactory(this.a, this.f20580g), new DefaultSsChunkSource.Factory(this.f20583j), this.f20581h, (AdaptiveMediaSourceEventListener) null);
            }
            return new DashMediaSource(uri, new DefaultDataSourceFactory(this.a, this.f20580g), new DefaultDashChunkSource.Factory(this.f20583j), this.f20581h, (AdaptiveMediaSourceEventListener) null);
        }
        return (MediaSource) invokeLL.objValue;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void pause() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.f20578e) {
            SimpleExoPlayer simpleExoPlayer = this.f20576c;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlayWhenReady(false);
            }
            notifyOnPlayStateChange(2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void prepareAsync() throws IllegalStateException {
        C1291b c1291b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.f20578e || this.f20582i == null || (c1291b = this.f20575b) == null || c1291b.f20584e) {
            return;
        }
        this.f20576c.prepare(this.f20582i);
        this.f20575b.f20584e = true;
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f20578e = false;
            this.f20582i = null;
            C1291b c1291b = this.f20575b;
            if (c1291b != null) {
                c1291b.f20584e = false;
            }
            this.f20579f = 0;
            this.f20576c.release();
            C1291b c1291b2 = this.f20575b;
            if (c1291b2 != null) {
                this.f20576c.removeVideoListener(c1291b2);
                this.f20576c.removeListener(this.f20575b);
            }
            this.f20575b = null;
            releaseListeners();
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f20582i = null;
            this.f20578e = false;
            C1291b c1291b = this.f20575b;
            if (c1291b != null) {
                c1291b.f20584e = false;
            }
            this.f20579f = 0;
            SimpleExoPlayer simpleExoPlayer = this.f20576c;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.stop();
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void seekTo(long j2) throws IllegalStateException {
        SimpleExoPlayer simpleExoPlayer;
        int currentWindowIndex;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) && this.f20578e && (simpleExoPlayer = this.f20576c) != null) {
            Timeline currentTimeline = simpleExoPlayer.getCurrentTimeline();
            if (!currentTimeline.isEmpty()) {
                int windowCount = currentTimeline.getWindowCount();
                currentWindowIndex = 0;
                while (true) {
                    long durationMs = currentTimeline.getWindow(currentWindowIndex, new Timeline.Window()).getDurationMs();
                    if (j2 < durationMs) {
                        break;
                    } else if (currentWindowIndex == windowCount - 1) {
                        j2 = durationMs;
                        break;
                    } else {
                        j2 -= durationMs;
                        currentWindowIndex++;
                    }
                }
            } else {
                currentWindowIndex = this.f20576c.getCurrentWindowIndex();
            }
            this.f20576c.seekTo(currentWindowIndex, j2);
            C1291b c1291b = this.f20575b;
            if (c1291b != null) {
                c1291b.f20585f = true;
            }
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void seekToForce(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            seekTo(j2);
        }
    }

    @Override // com.baidu.ugc.editvideo.player.IPlayer
    public void setAudioDataSource(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f20578e = false;
            this.f20579f = 0;
            int size = list.size();
            MediaSource[] mediaSourceArr = new MediaSource[size];
            int i2 = 0;
            for (int i3 = 0; i3 < list.size() && i3 < size; i3++) {
                AudioPlayData audioPlayData = list.get(i3);
                int i4 = audioPlayData.realDuration;
                audioPlayData.offset = i2;
                int i5 = audioPlayData.end - audioPlayData.start;
                i2 += i5;
                this.f20579f += i5;
                MediaSource o = o(Uri.parse(audioPlayData.audioPath), "");
                int i6 = audioPlayData.start;
                if (i6 < 0) {
                    i6 = 0;
                }
                int i7 = audioPlayData.end;
                if (i7 <= i4) {
                    i4 = i7;
                }
                mediaSourceArr[i3] = new ClippingMediaSource(o, i6 * 1000, i4 * 1000);
            }
            this.f20582i = new ConcatenatingMediaSource(mediaSourceArr);
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
        if (!(interceptable == null || interceptable.invokeL(1048595, this, surfaceHolder) == null) || (simpleExoPlayer = this.f20576c) == null) {
            return;
        }
        simpleExoPlayer.setVideoSurfaceHolder(surfaceHolder);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer
    public void setOnSpeedChangeListener(IMediaPlayer.OnSpeedChangeListener onSpeedChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onSpeedChangeListener) == null) {
            this.f20577d = onSpeedChangeListener;
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public boolean setPlaybackSpeed(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048597, this, f2)) == null) {
            SimpleExoPlayer simpleExoPlayer = this.f20576c;
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
        if (!(interceptable == null || interceptable.invokeL(1048598, this, surface) == null) || (simpleExoPlayer = this.f20576c) == null) {
            return;
        }
        simpleExoPlayer.setVideoSurface(surface);
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setVolume(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f20576c.setVolume(f2);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void start() throws IllegalStateException {
        SimpleExoPlayer simpleExoPlayer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.f20578e && (simpleExoPlayer = this.f20576c) != null) {
            if (simpleExoPlayer.getPlaybackState() == 4) {
                seekTo(0L);
            } else {
                this.f20576c.setPlayWhenReady(true);
            }
            notifyOnPlayStateChange(1);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void stop() throws IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.f20582i = null;
            this.f20578e = false;
            C1291b c1291b = this.f20575b;
            if (c1291b != null) {
                c1291b.f20584e = false;
            }
            SimpleExoPlayer simpleExoPlayer = this.f20576c;
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
            this.f20578e = false;
            super.setDataSource(context, uri, map);
            this.f20582i = o(uri, "");
            setPlaybackState(IMediaPlayer.STATE_GOT_SOURCE);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(uri.getPath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            mediaMetadataRetriever.release();
            this.f20579f = g.c(extractMetadata, 0);
        }
    }

    /* renamed from: c.a.r0.o4.m.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1291b extends Player.DefaultEventListener implements SimpleExoPlayer.VideoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20584e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f20585f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f20586g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f20587h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f20588i;

        public C1291b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20588i = bVar;
            this.f20584e = false;
            this.f20585f = false;
            this.f20586g = false;
            this.f20587h = false;
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, playbackParameters) == null) || this.f20588i.f20577d == null || playbackParameters == null) {
                return;
            }
            this.f20588i.f20577d.onSpeedChange(playbackParameters.speed);
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exoPlaybackException) == null) {
                this.f20588i.notifyOnError(1, 1, exoPlaybackException);
            }
        }

        @Override // com.google.android.exoplayer2.Player.DefaultEventListener, com.google.android.exoplayer2.Player.EventListener
        public void onPlayerStateChanged(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
                this.f20588i.setPlaybackState(i2);
                if (this.f20586g && (i2 == 3 || i2 == 4)) {
                    this.f20586g = false;
                    b bVar = this.f20588i;
                    bVar.notifyOnInfo(702, bVar.f20576c.getBufferedPercentage());
                }
                if (this.f20584e && i2 == 3) {
                    this.f20584e = false;
                    this.f20588i.f20578e = true;
                    this.f20588i.notifyOnPrepared();
                }
                if (this.f20585f && i2 == 3) {
                    this.f20585f = false;
                    this.f20588i.notifyOnSeekComplete();
                }
                if (i2 == 2) {
                    b bVar2 = this.f20588i;
                    bVar2.notifyOnInfo(701, bVar2.f20576c.getBufferedPercentage());
                    this.f20586g = true;
                } else if (i2 != 3) {
                    if (i2 == 4 && !this.f20587h) {
                        this.f20587h = true;
                        if (!this.f20588i.isLooping()) {
                            this.f20588i.notifyOnPlayStateChange(2);
                            this.f20588i.notifyOnCompletion();
                            return;
                        }
                        this.f20588i.seekTo(0L);
                        this.f20588i.notifyOnLooping();
                    }
                } else {
                    this.f20587h = false;
                }
            }
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onRenderedFirstFrame() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f20588i.notifyOnInfo(3, 0);
            }
        }

        @Override // com.google.android.exoplayer2.SimpleExoPlayer.VideoListener
        public void onVideoSizeChanged(int i2, int i3, int i4, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)}) == null) {
                this.f20588i.notifyOnVideoSizeChanged(i2, i3, i4, f2);
            }
        }

        public /* synthetic */ C1291b(b bVar, a aVar) {
            this(bVar);
        }
    }

    @Override // com.baidu.ugc.editvideo.record.source.multimedia.exo.ijk.IMediaPlayer, com.baidu.ugc.editvideo.player.IPlayer
    public void setDataSource(List<VideoPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            this.f20578e = false;
            this.f20579f = 0;
            MediaSource[] mediaSourceArr = new MediaSource[list.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                VideoPlayData videoPlayData = list.get(i3);
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
                videoPlayData.offset = i2;
                int i4 = videoPlayData.end - videoPlayData.start;
                i2 += i4;
                this.f20579f += i4;
                MediaSource o = o(Uri.parse(videoPlayData.videoPath), "");
                int i5 = videoPlayData.start;
                if (i5 < 0) {
                    i5 = 0;
                }
                int i6 = videoPlayData.end;
                if (i6 <= c5) {
                    c5 = i6;
                }
                mediaSourceArr[i3] = new ClippingMediaSource(o, i5 * 1000, c5 * 1000);
            }
            this.f20582i = new ConcatenatingMediaSource(mediaSourceArr);
            setPlaybackState(IMediaPlayer.STATE_GOT_SOURCE);
        }
    }
}
