package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class k extends PlayerProvider implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.cyberplayer.sdk.statistics.h f4966a;

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f4967b;

    /* renamed from: c  reason: collision with root package name */
    public CyberPlayerManager.OnPreparedListener f4968c;

    /* renamed from: d  reason: collision with root package name */
    public CyberPlayerManager.OnCompletionListener f4969d;

    /* renamed from: e  reason: collision with root package name */
    public CyberPlayerManager.OnBufferingUpdateListener f4970e;

    /* renamed from: f  reason: collision with root package name */
    public CyberPlayerManager.OnSeekCompleteListener f4971f;

    /* renamed from: g  reason: collision with root package name */
    public CyberPlayerManager.OnVideoSizeChangedListener f4972g;

    /* renamed from: h  reason: collision with root package name */
    public CyberPlayerManager.OnErrorListener f4973h;
    public CyberPlayerManager.OnInfoListener i;
    public boolean j;
    public long k;
    public int l;
    public long m;
    public String n;
    public long o;
    public long p;
    public long q;
    public int r;
    public boolean s;
    public long t = -1;
    public long u = -1;
    public int v = 0;
    public int w = 0;

    public k() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.f4967b = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        this.f4967b.setOnCompletionListener(this);
        this.f4967b.setOnBufferingUpdateListener(this);
        this.f4967b.setOnSeekCompleteListener(this);
        this.f4967b.setOnVideoSizeChangedListener(this);
        this.f4967b.setOnErrorListener(this);
        this.f4967b.setOnInfoListener(this);
        this.f4966a = new com.baidu.cyberplayer.sdk.statistics.h();
        c();
    }

    private void c() {
        this.k = -1L;
        this.l = 0;
        this.m = -1L;
        this.o = 0L;
        this.q = -1L;
        this.s = false;
    }

    private boolean d() {
        int i;
        return (this.f4967b == null || (i = this.v) == -1 || i == 0 || i == 1) ? false : true;
    }

    private void e() {
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.f4966a;
        if (hVar == null || hVar.b()) {
            return;
        }
        if (this.s) {
            this.f4966a.a(this);
            this.f4966a.b(this);
            this.f4966a.c(this);
        }
        this.f4966a.c();
    }

    public String a() {
        return this.n;
    }

    public long b() {
        return this.m;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            long j = this.t;
            if (j > -1) {
                return (int) j;
            }
            int i = this.v;
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
        if (this.f4967b != null) {
            return this.r;
        }
        return -1;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public long getPlayedTime() {
        if (this.m > 0) {
            if (this.p > 0) {
                this.o += System.currentTimeMillis() - this.p;
            }
            this.q = (System.currentTimeMillis() - this.m) - this.o;
        }
        return this.q;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoHeight() {
        try {
            if (this.f4967b != null) {
                return this.f4967b.getVideoHeight();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        try {
            if (this.f4967b != null) {
                return this.f4967b.getVideoWidth();
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        MediaPlayer mediaPlayer = this.f4967b;
        return mediaPlayer != null && mediaPlayer.isLooping();
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        return d() && this.v == 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        this.j = z;
        CyberLog.i("MediaPlayerImpl", "muteOrUnmuteAudio flag:" + z);
        if (this.f4967b == null) {
            return;
        }
        float f2 = this.j ? 0.0f : 1.0f;
        this.f4967b.setVolume(f2, f2);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.f4970e;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onCompletion");
        this.v = 5;
        this.w = 5;
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.f4969d;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onError");
        this.v = -1;
        this.w = -1;
        this.f4966a.a(DpStatConstants.SESSION_TYPE_ERROR, "error_code", -10000);
        this.f4966a.a(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_SUB_CODE, i2);
        this.f4966a.a(DpStatConstants.SESSION_TYPE_ERROR, "time", System.currentTimeMillis());
        this.f4966a.a(DpStatConstants.SESSION_TYPE_ERROR, "detail", i);
        CyberPlayerManager.OnErrorListener onErrorListener = this.f4973h;
        return onErrorListener != null && onErrorListener.onError(i, i2, null);
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onInfo");
        if (i == 3) {
            i = 904;
            this.f4966a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, (System.currentTimeMillis() - this.m) + this.l);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.i;
        return onInfoListener != null && onInfoListener.onInfo(i, i2, null);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onPrepared");
        this.v = 2;
        MediaPlayer mediaPlayer2 = this.f4967b;
        if (mediaPlayer2 != null) {
            this.r = mediaPlayer2.getDuration();
        }
        CyberPlayerManager.OnPreparedListener onPreparedListener = this.f4968c;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
        int round = Math.round((float) (System.currentTimeMillis() - this.k));
        this.l = round;
        this.f4966a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_PREPARED, round);
        long j = this.u;
        if (j > 0) {
            seekTo(j);
        }
        this.u = -1L;
        if (this.w == 3) {
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.t = -1L;
        CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener = this.f4971f;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onVideoSizeChanged");
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.f4972g;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, 1, 1);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        CyberLog.i("MediaPlayerImpl", "pause");
        if (d()) {
            this.v = 4;
            this.f4967b.pause();
            if (this.m > 0 && this.p == 0) {
                this.p = System.currentTimeMillis();
            }
        }
        this.w = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        CyberLog.i("MediaPlayerImpl", "prepareAsync");
        if (this.f4967b != null) {
            this.v = 1;
            if (this.k == -1) {
                this.k = System.currentTimeMillis();
            }
            try {
                this.f4967b.prepareAsync();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        CyberLog.i("MediaPlayerImpl", "release");
        e();
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            this.u = -1L;
            this.s = false;
            this.v = 0;
            this.w = 0;
            mediaPlayer.setOnPreparedListener(null);
            this.f4967b.setOnCompletionListener(null);
            this.f4967b.setOnBufferingUpdateListener(null);
            this.f4967b.setOnSeekCompleteListener(null);
            this.f4967b.setOnVideoSizeChangedListener(null);
            this.f4967b.setOnErrorListener(null);
            this.f4967b.setOnInfoListener(null);
            this.f4968c = null;
            this.f4969d = null;
            this.f4970e = null;
            this.f4971f = null;
            this.f4972g = null;
            this.f4973h = null;
            this.i = null;
            this.f4967b.release();
            this.f4967b = null;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        CyberLog.i("MediaPlayerImpl", "reset");
        e();
        this.u = -1L;
        this.t = -1L;
        this.v = 0;
        this.w = 0;
        c();
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.reset();
            } catch (IllegalStateException unused) {
                CyberLog.e("MediaPlayerImpl", "reset IllegalStateException error");
            }
        }
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.f4966a;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        CyberLog.i("MediaPlayerImpl", "seekTo");
        if (this.f4967b != null) {
            if (d()) {
                this.f4967b.seekTo((int) j);
            } else {
                this.u = j;
            }
            this.t = j;
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
                        this.f4966a.a(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                    }
                    return;
                case 1002:
                    int round = Math.round((float) (j - this.m)) + this.l;
                    CyberLog.i("MediaPlayerImpl", "sendCommand COMMAND_ON_FIRST_FRAME_DRAWED firstFrameCostTime:" + round);
                    this.f4966a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, round);
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
                        this.f4966a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, next2, jSONObject2.getString(next2));
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
        if (this.f4967b != null) {
            this.n = uri.toString();
            try {
                this.f4967b.setDataSource(context, uri);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.f4967b != null) {
            this.n = uri.toString();
            try {
                this.f4967b.setDataSource(context, uri, map);
            } catch (IOException e2) {
                e2.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        CyberLog.i("MediaPlayerImpl", "setDataSource 4");
        if (this.f4967b != null) {
            this.n = fileDescriptor.toString();
            try {
                this.f4967b.setDataSource(fileDescriptor);
            } catch (IOException e2) {
                e2.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            this.n = str;
            try {
                mediaPlayer.setDataSource(str);
            } catch (IOException e2) {
                e2.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            this.n = str;
            try {
                mediaPlayer.setDataSource(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        CyberLog.i("MediaPlayerImpl", "setDisplay");
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            mediaPlayer.setDisplay(surfaceHolder);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnBufferingUpdateListener(CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.f4970e = onBufferingUpdateListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnCompletionListener(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        this.f4969d = onCompletionListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnErrorListener(CyberPlayerManager.OnErrorListener onErrorListener) {
        this.f4973h = onErrorListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnInfoListener(CyberPlayerManager.OnInfoListener onInfoListener) {
        this.i = onInfoListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnPreparedListener(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        this.f4968c = onPreparedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnSeekCompleteListener(CyberPlayerManager.OnSeekCompleteListener onSeekCompleteListener) {
        this.f4971f = onSeekCompleteListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setOnVideoSizeChangedListener(CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f4972g = onVideoSizeChangedListener;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setScreenOnWhilePlaying(boolean z) {
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f2) {
        MediaPlayer mediaPlayer;
        if (f2 < 0.0f || f2 > 4.0f || (mediaPlayer = this.f4967b) == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            boolean isPlaying = mediaPlayer.isPlaying();
            this.f4967b.setPlaybackParams(this.f4967b.getPlaybackParams().setSpeed(f2));
            if (isPlaying || !this.f4967b.isPlaying()) {
                return;
            }
            pause();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        CyberLog.i("MediaPlayerImpl", "setSurface");
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f3);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            mediaPlayer.setWakeMode(context, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        CyberLog.i("MediaPlayerImpl", IntentConfig.START);
        if (d()) {
            this.v = 3;
            try {
                this.f4967b.start();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                onError(this.f4967b, -1004, -1004);
            }
            if (this.m == -1) {
                this.m = System.currentTimeMillis();
                this.p = 0L;
            }
            if (this.p > 0) {
                this.o += System.currentTimeMillis() - this.p;
                this.p = 0L;
            }
        }
        this.s = true;
        this.w = 3;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        CyberLog.i("MediaPlayerImpl", IntentConfig.STOP);
        MediaPlayer mediaPlayer = this.f4967b;
        if (mediaPlayer != null) {
            this.u = -1L;
            this.v = 0;
            this.w = 0;
            mediaPlayer.stop();
        }
    }
}
