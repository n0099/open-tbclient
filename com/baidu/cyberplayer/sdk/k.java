package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.FileDescriptor;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k extends PlayerProvider implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cyberplayer.sdk.statistics.h f4890a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f4891b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f4892c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f4893d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f4894e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f4895f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f4896g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f4897h;

    /* renamed from: i  reason: collision with root package name */
    public CyberPlayerManager.OnInfoListener f4898i;
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
    public long u = -1;
    public long v = -1;
    public int w = 3;
    public int x = 0;
    public int y = 0;

    public k() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f4891b = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        this.f4891b.setOnCompletionListener(this);
        this.f4891b.setOnBufferingUpdateListener(this);
        this.f4891b.setOnSeekCompleteListener(this);
        this.f4891b.setOnVideoSizeChangedListener(this);
        this.f4891b.setOnErrorListener(this);
        this.f4891b.setOnInfoListener(this);
        this.f4890a = new com.baidu.cyberplayer.sdk.statistics.h();
        d();
    }

    private void d() {
        this.l = -1L;
        this.m = 0;
        this.n = -1L;
        this.p = 0L;
        this.r = -1L;
        this.t = false;
    }

    private boolean e() {
        int i2;
        return (this.f4891b == null || (i2 = this.x) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    private void f() {
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.f4890a;
        if (hVar == null || hVar.b()) {
            return;
        }
        if (this.l > 0 || this.t) {
            this.f4890a.a(this);
            this.f4890a.b(this);
            this.f4890a.c(this);
        }
        this.f4890a.c();
    }

    public String a() {
        return this.o;
    }

    public long b() {
        return this.n;
    }

    public boolean c() {
        return this.t;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f4891b;
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

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        return getCurrentPosition();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDecodeMode() {
        return 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getDownloadSpeed() {
        return 0L;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getDuration() {
        if (this.f4891b != null) {
            return this.s;
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (this.n > 0) {
            if (this.q > 0) {
                this.p += System.currentTimeMillis() - this.q;
            }
            this.r = (System.currentTimeMillis() - this.n) - this.p;
        }
        return this.r;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        try {
            if (this.f4891b != null) {
                return this.f4891b.getVideoHeight();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        try {
            if (this.f4891b != null) {
                return this.f4891b.getVideoWidth();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        MediaPlayer mediaPlayer = this.f4891b;
        return mediaPlayer != null && mediaPlayer.isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        return e() && this.x == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        this.k = z;
        CyberLog.i("MediaPlayerImpl", "muteOrUnmuteAudio flag:" + z);
        if (this.f4891b == null) {
            return;
        }
        float f2 = this.k ? 0.0f : 1.0f;
        this.f4891b.setVolume(f2, f2);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.f4894e;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i2);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onCompletion");
        this.x = 5;
        this.y = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.f4893d;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        CyberLog.i("MediaPlayerImpl", "onError");
        boolean z = CyberCfgManager.getInstance().a("drop_mediaplay_stop_error", true) && this.x == 0 && this.y == 0;
        this.x = -1;
        this.y = -1;
        if (z) {
            return false;
        }
        this.f4890a.a(DpStatConstants.SESSION_TYPE_ERROR, "error_code", i2);
        this.f4890a.a(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_SUB_CODE, i3);
        this.f4890a.a(DpStatConstants.SESSION_TYPE_ERROR, "time", System.currentTimeMillis());
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.f4890a;
        hVar.a(DpStatConstants.SESSION_TYPE_ERROR, "detail", "mediaplay error(" + i2 + "," + i3);
        CyberPlayerManager.OnErrorListener onErrorListener = this.f4897h;
        return onErrorListener != null && onErrorListener.onError(i2, i3, null);
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        CyberLog.i("MediaPlayerImpl", "onInfo");
        if (i2 == 3) {
            i2 = 904;
            this.f4890a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, (System.currentTimeMillis() - this.n) + this.m);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.f4898i;
        return onInfoListener != null && onInfoListener.onInfo(i2, i3, null);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onPrepared");
        this.x = 2;
        MediaPlayer mediaPlayer2 = this.f4891b;
        if (mediaPlayer2 != null) {
            this.s = mediaPlayer2.getDuration();
        }
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.f4892c;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int round = Math.round((float) (System.currentTimeMillis() - this.l));
        this.m = round;
        this.f4890a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_PREPARED, round);
        long j = this.v;
        if (j > 0) {
            seekTo(j, this.w);
        }
        this.v = -1L;
        if (this.y == 3) {
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.u = -1L;
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.f4895f;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        CyberLog.i("MediaPlayerImpl", "onVideoSizeChanged");
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.f4896g;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i2, i3, 1, 1);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        CyberLog.i("MediaPlayerImpl", "pause");
        if (e()) {
            this.x = 4;
            try {
                this.f4891b.pause();
            } catch (Exception unused) {
                onError(this.f4891b, -10002, -10002);
            }
            if (this.n > 0 && this.q == 0) {
                this.q = System.currentTimeMillis();
            }
        }
        this.y = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        CyberLog.i("MediaPlayerImpl", "prepareAsync");
        if (this.f4891b != null) {
            this.x = 1;
            if (this.l == -1) {
                this.l = System.currentTimeMillis();
            }
            try {
                this.f4891b.prepareAsync();
            } catch (IllegalStateException unused) {
                onError(this.f4891b, -10002, -10002);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        CyberLog.i("MediaPlayerImpl", "release");
        f();
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            this.v = -1L;
            this.t = false;
            this.x = 0;
            this.y = 0;
            mediaPlayer.setOnPreparedListener(null);
            this.f4891b.setOnCompletionListener(null);
            this.f4891b.setOnBufferingUpdateListener(null);
            this.f4891b.setOnSeekCompleteListener(null);
            this.f4891b.setOnVideoSizeChangedListener(null);
            this.f4891b.setOnErrorListener(null);
            this.f4891b.setOnInfoListener(null);
            this.f4892c = null;
            this.f4893d = null;
            this.f4894e = null;
            this.f4895f = null;
            this.f4896g = null;
            this.f4897h = null;
            this.f4898i = null;
            this.j = null;
            this.f4891b.release();
            this.f4891b = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        CyberLog.i("MediaPlayerImpl", "reset");
        f();
        this.v = -1L;
        this.u = -1L;
        this.x = 0;
        this.y = 0;
        d();
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
            } catch (IllegalStateException unused) {
                CyberLog.e("MediaPlayerImpl", "reset IllegalStateException error");
            }
        }
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.f4890a;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i2) {
        CyberLog.i("MediaPlayerImpl", "seekTo");
        if (this.f4891b != null) {
            if (e()) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.f4891b.seekTo((int) j, i2);
                    } else {
                        this.f4891b.seekTo((int) j);
                    }
                } catch (Exception unused) {
                    onError(this.f4891b, -10002, -10002);
                }
            } else {
                this.v = j;
                this.w = i2;
            }
            this.u = j;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i2, int i3, long j, String str) {
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
                        this.f4890a.a(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                    }
                    return;
                case 1002:
                    int round = Math.round((float) (j - this.n)) + this.m;
                    CyberLog.i("MediaPlayerImpl", "sendCommand COMMAND_ON_FIRST_FRAME_DRAWED firstFrameCostTime:" + round);
                    this.f4890a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, round);
                    CyberPlayerManager.OnInfoListener onInfoListener = this.f4898i;
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
                        this.f4890a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, next2, jSONObject2.getString(next2));
                    }
                    return;
                default:
                    return;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.f4891b != null) {
            this.o = uri.toString();
            try {
                this.f4891b.setDataSource(context, uri);
            } catch (Exception unused) {
                onError(this.f4891b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.f4891b != null) {
            this.o = uri.toString();
            try {
                this.f4891b.setDataSource(context, uri, map);
            } catch (Exception unused) {
                onError(this.f4891b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        CyberLog.i("MediaPlayerImpl", "setDataSource 4");
        if (this.f4891b != null) {
            this.o = fileDescriptor.toString();
            try {
                this.f4891b.setDataSource(fileDescriptor);
            } catch (Exception unused) {
                onError(this.f4891b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            this.o = str;
            try {
                mediaPlayer.setDataSource(str);
            } catch (Exception unused) {
                onError(this.f4891b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            this.o = str;
            try {
                mediaPlayer.setDataSource(str);
            } catch (Exception unused) {
                onError(this.f4891b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        CyberLog.i("MediaPlayerImpl", "setDisplay");
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDisplay(surfaceHolder);
            } catch (Exception unused) {
                onError(this.f4891b, -10000, -10000);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f4894e = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f4893d = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f4897h = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.f4898i = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.j = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f4892c = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f4895f = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f4896g = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        MediaPlayer mediaPlayer;
        if (f2 < 0.0f || f2 > 4.0f || (mediaPlayer = this.f4891b) == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            boolean isPlaying = mediaPlayer.isPlaying();
            this.f4891b.setPlaybackParams(this.f4891b.getPlaybackParams().setSpeed(f2));
            if (isPlaying || !this.f4891b.isPlaying()) {
                return;
            }
            pause();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        CyberLog.i("MediaPlayerImpl", "setSurface");
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setSurface(surface);
            } catch (Exception unused) {
                onError(this.f4891b, -10000, -10000);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i2) {
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            mediaPlayer.setWakeMode(context, i2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        CyberLog.i("MediaPlayerImpl", IntentConfig.START);
        if (e()) {
            this.x = 3;
            try {
                this.f4891b.start();
            } catch (IllegalStateException unused) {
                onError(this.f4891b, -10002, -10002);
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

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        CyberLog.i("MediaPlayerImpl", IntentConfig.STOP);
        MediaPlayer mediaPlayer = this.f4891b;
        if (mediaPlayer != null) {
            this.v = -1L;
            this.x = 0;
            this.y = 0;
            try {
                mediaPlayer.stop();
            } catch (Exception unused) {
                onError(this.f4891b, -10002, -10002);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i2) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.j;
        if (onMediaSourceChangedListener != null) {
            onMediaSourceChangedListener.onMediaSourceChanged(-100, i2, null);
        }
    }
}
