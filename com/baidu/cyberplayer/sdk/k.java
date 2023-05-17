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
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class k extends PlayerProvider implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public com.baidu.cyberplayer.sdk.statistics.h a;
    public MediaPlayer b;
    public CyberPlayerManager.OnPreparedListener c;
    public CyberPlayerManager.OnCompletionListener d;
    public CyberPlayerManager.OnBufferingUpdateListener e;
    public CyberPlayerManager.OnSeekCompleteListener f;
    public CyberPlayerManager.OnVideoSizeChangedListener g;
    public CyberPlayerManager.OnErrorListener h;
    public CyberPlayerManager.OnInfoListener i;
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
        this.b = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        this.b.setOnCompletionListener(this);
        this.b.setOnBufferingUpdateListener(this);
        this.b.setOnSeekCompleteListener(this);
        this.b.setOnVideoSizeChangedListener(this);
        this.b.setOnErrorListener(this);
        this.b.setOnInfoListener(this);
        this.a = new com.baidu.cyberplayer.sdk.statistics.h();
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
        int i;
        return (this.b == null || (i = this.x) == -1 || i == 0 || i == 1) ? false : true;
    }

    private void f() {
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.a;
        if (hVar == null || hVar.b()) {
            return;
        }
        if (this.l > 0 || this.t) {
            this.a.a(this);
            this.a.b(this);
            this.a.c(this);
        }
        this.a.c();
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
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            long j = this.u;
            if (j > -1) {
                return (int) j;
            }
            int i = this.x;
            if (i != 0 && i != 1 && i != 2) {
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
        if (this.b != null) {
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
            if (this.b != null) {
                return this.b.getVideoHeight();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        try {
            if (this.b != null) {
                return this.b.getVideoWidth();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        MediaPlayer mediaPlayer = this.b;
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
        if (this.b == null) {
            return;
        }
        float f = this.k ? 0.0f : 1.0f;
        this.b.setVolume(f, f);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.e;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onCompletion");
        this.x = 5;
        this.y = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.d;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onError");
        boolean z = CyberCfgManager.getInstance().a("drop_mediaplay_stop_error", true) && this.x == 0 && this.y == 0;
        this.x = -1;
        this.y = -1;
        if (z) {
            return false;
        }
        this.a.a(DpStatConstants.SESSION_TYPE_ERROR, "error_code", i);
        this.a.a(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_SUB_CODE, i2);
        this.a.a(DpStatConstants.SESSION_TYPE_ERROR, "time", System.currentTimeMillis());
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.a;
        hVar.a(DpStatConstants.SESSION_TYPE_ERROR, "detail", "mediaplay error(" + i + "," + i2);
        CyberPlayerManager.OnErrorListener onErrorListener = this.h;
        return onErrorListener != null && onErrorListener.onError(i, i2, null);
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onInfo");
        if (i == 3) {
            i = 904;
            this.a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, (System.currentTimeMillis() - this.n) + this.m);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.i;
        return onInfoListener != null && onInfoListener.onInfo(i, i2, null);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onPrepared");
        this.x = 2;
        MediaPlayer mediaPlayer2 = this.b;
        if (mediaPlayer2 != null) {
            this.s = mediaPlayer2.getDuration();
        }
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.c;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int round = Math.round((float) (System.currentTimeMillis() - this.l));
        this.m = round;
        this.a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_PREPARED, round);
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
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.f;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onVideoSizeChanged");
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.g;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, 1, 1);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        CyberLog.i("MediaPlayerImpl", "pause");
        if (e()) {
            this.x = 4;
            try {
                this.b.pause();
            } catch (Exception unused) {
                onError(this.b, -10002, -10002);
            }
            if (this.n > 0 && this.q == 0) {
                this.q = System.currentTimeMillis();
            }
        }
        this.y = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        MediaPlayer mediaPlayer;
        int i;
        CyberLog.i("MediaPlayerImpl", "prepareAsync");
        if (this.b != null) {
            this.x = 1;
            if (this.l == -1) {
                this.l = System.currentTimeMillis();
            }
            try {
                this.b.prepareAsync();
            } catch (IllegalStateException unused) {
                mediaPlayer = this.b;
                i = -10002;
                onError(mediaPlayer, i, i);
            } catch (Exception e) {
                if (e instanceof IOException) {
                    mediaPlayer = this.b;
                    i = -1004;
                    onError(mediaPlayer, i, i);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        CyberLog.i("MediaPlayerImpl", "release");
        f();
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            this.v = -1L;
            this.t = false;
            this.x = 0;
            this.y = 0;
            mediaPlayer.setOnPreparedListener(null);
            this.b.setOnCompletionListener(null);
            this.b.setOnBufferingUpdateListener(null);
            this.b.setOnSeekCompleteListener(null);
            this.b.setOnVideoSizeChangedListener(null);
            this.b.setOnErrorListener(null);
            this.b.setOnInfoListener(null);
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.b.release();
            this.b = null;
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
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
            } catch (IllegalStateException unused) {
                CyberLog.e("MediaPlayerImpl", "reset IllegalStateException error");
            }
        }
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.a;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        CyberLog.i("MediaPlayerImpl", "seekTo");
        if (this.b != null) {
            if (e()) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.b.seekTo((int) j, i);
                    } else {
                        this.b.seekTo((int) j);
                    }
                } catch (Exception unused) {
                    onError(this.b, -10002, -10002);
                }
            } else {
                this.v = j;
                this.w = i;
            }
            this.u = j;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        try {
            switch (i) {
                case 1001:
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.a.a(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                    }
                    return;
                case 1002:
                    int round = Math.round((float) (j - this.n)) + this.m;
                    CyberLog.i("MediaPlayerImpl", "sendCommand COMMAND_ON_FIRST_FRAME_DRAWED firstFrameCostTime:" + round);
                    this.a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, round);
                    CyberPlayerManager.OnInfoListener onInfoListener = this.i;
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
                        this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, next2, jSONObject2.getString(next2));
                    }
                    return;
                default:
                    return;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        CyberLog.d("MediaPlayerImpl", "setDataSource uri:" + uri);
        Uri defaultUrlFromMPD = MPDParser.getDefaultUrlFromMPD(uri);
        if (this.b != null) {
            this.o = defaultUrlFromMPD.toString();
            try {
                this.b.setDataSource(context, defaultUrlFromMPD);
            } catch (Exception unused) {
                onError(this.b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        CyberLog.d("MediaPlayerImpl", "setDataSource uri:" + uri);
        Uri defaultUrlFromMPD = MPDParser.getDefaultUrlFromMPD(uri);
        if (this.b != null) {
            this.o = defaultUrlFromMPD.toString();
            try {
                this.b.setDataSource(context, defaultUrlFromMPD, map);
            } catch (Exception unused) {
                onError(this.b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.b != null) {
            this.o = fileDescriptor.toString();
            try {
                this.b.setDataSource(fileDescriptor);
            } catch (Exception unused) {
                onError(this.b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        CyberLog.d("MediaPlayerImpl", "setDataSource:" + str);
        if (this.b != null) {
            String defaultUrlStringFromMPD = MPDParser.getDefaultUrlStringFromMPD(str);
            this.o = defaultUrlStringFromMPD;
            try {
                this.b.setDataSource(defaultUrlStringFromMPD);
            } catch (Exception unused) {
                onError(this.b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        CyberLog.d("MediaPlayerImpl", "setDataSource:" + str);
        if (this.b != null) {
            String defaultUrlStringFromMPD = MPDParser.getDefaultUrlStringFromMPD(str);
            this.o = defaultUrlStringFromMPD;
            try {
                this.b.setDataSource(defaultUrlStringFromMPD);
            } catch (Exception unused) {
                onError(this.b, -10001, -10001);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        CyberLog.i("MediaPlayerImpl", "setDisplay");
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setDisplay(surfaceHolder);
            } catch (Exception unused) {
                onError(this.b, -10000, -10000);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.e = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.d = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.h = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.i = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnMediaSourceChangedListener(CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener) {
        this.j = onMediaSourceChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.c = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.g = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        MediaPlayer mediaPlayer;
        if (f < 0.0f || f > 4.0f || (mediaPlayer = this.b) == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            boolean isPlaying = mediaPlayer.isPlaying();
            this.b.setPlaybackParams(this.b.getPlaybackParams().setSpeed(f));
            if (isPlaying || !this.b.isPlaying()) {
                return;
            }
            pause();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        CyberLog.i("MediaPlayerImpl", "setSurface");
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setSurface(surface);
            } catch (Exception unused) {
                onError(this.b, -10000, -10000);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setWakeMode(context, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        CyberLog.i("MediaPlayerImpl", "start");
        if (e()) {
            this.x = 3;
            try {
                this.b.start();
            } catch (IllegalStateException unused) {
                onError(this.b, -10002, -10002);
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
        CyberLog.i("MediaPlayerImpl", "stop");
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            this.v = -1L;
            this.x = 0;
            this.y = 0;
            try {
                mediaPlayer.stop();
            } catch (Exception unused) {
                onError(this.b, -10002, -10002);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void switchMediaSource(int i) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.j;
        if (onMediaSourceChangedListener != null) {
            onMediaSourceChangedListener.onMediaSourceChanged(i == -1 ? 0 : -100, i, null);
        }
    }
}
