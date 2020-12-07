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
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class k extends PlayerProvider implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.cyberplayer.sdk.statistics.h f1396a;
    private CyberPlayerManager.OnPreparedListener c;
    private CyberPlayerManager.OnCompletionListener d;
    private CyberPlayerManager.OnBufferingUpdateListener e;
    private CyberPlayerManager.OnSeekCompleteListener f;
    private CyberPlayerManager.OnVideoSizeChangedListener g;
    private CyberPlayerManager.OnErrorListener h;
    private CyberPlayerManager.OnInfoListener i;
    private boolean j;
    private long k;
    private int l;
    private long m;
    private String n;
    private long o;
    private long p;
    private long q;
    private int r;
    private boolean s;
    private long t = -1;
    private long u = -1;
    private int v = 0;
    private int w = 0;
    private MediaPlayer b = new MediaPlayer();

    public k() {
        this.b.setOnPreparedListener(this);
        this.b.setOnCompletionListener(this);
        this.b.setOnBufferingUpdateListener(this);
        this.b.setOnSeekCompleteListener(this);
        this.b.setOnVideoSizeChangedListener(this);
        this.b.setOnErrorListener(this);
        this.b.setOnInfoListener(this);
        this.f1396a = new com.baidu.cyberplayer.sdk.statistics.h();
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
        return (this.b == null || this.v == -1 || this.v == 0 || this.v == 1) ? false : true;
    }

    private void e() {
        if (this.f1396a == null || this.f1396a.b()) {
            return;
        }
        if (this.s) {
            this.f1396a.a(this);
            this.f1396a.b(this);
            this.f1396a.c(this);
        }
        this.f1396a.c();
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
        if (this.b != null) {
            if (this.t > -1) {
                return (int) this.t;
            }
            if (this.v == 0 || this.v == 1 || this.v == 2) {
                return 0;
            }
            try {
                return this.b.getCurrentPosition();
            } catch (IllegalStateException e) {
                CyberLog.e("MediaPlayerImpl", "getCurrentPosition IllegalStateException error");
                return 0;
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
            if (this.b != null) {
                return this.b.getVideoHeight();
            }
            return 0;
        } catch (Exception e) {
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
        } catch (Exception e) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        return this.b != null && this.b.isLooping();
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
        if (this.b == null) {
            return;
        }
        float f = this.j ? 0.0f : 1.0f;
        this.b.setVolume(f, f);
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (this.e != null) {
            this.e.onBufferingUpdate(i);
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onCompletion");
        this.v = 5;
        this.w = 5;
        if (this.d != null) {
            this.d.onCompletion();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onError");
        this.v = -1;
        this.w = -1;
        this.f1396a.a(DpStatConstants.SESSION_TYPE_ERROR, "error_code", DpStatConstants.MEDIA_ERROR_MEDIA_PLAYER);
        this.f1396a.a(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_SUB_CODE, i2);
        this.f1396a.a(DpStatConstants.SESSION_TYPE_ERROR, "time", System.currentTimeMillis());
        this.f1396a.a(DpStatConstants.SESSION_TYPE_ERROR, "detail", i);
        return this.h != null && this.h.onError(i, i2, null);
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onInfo");
        if (i == 3) {
            i = CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL;
            this.f1396a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, (System.currentTimeMillis() - this.m) + this.l);
        }
        return this.i != null && this.i.onInfo(i, i2, null);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onPrepared");
        this.v = 2;
        if (this.b != null) {
            this.r = this.b.getDuration();
        }
        if (this.c != null) {
            this.c.onPrepared();
        }
        this.l = Math.round((float) (System.currentTimeMillis() - this.k));
        this.f1396a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_PREPARED, this.l);
        if (this.u > 0) {
            seekTo(this.u);
        }
        this.u = -1L;
        if (this.w == 3) {
            start();
        }
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        this.t = -1L;
        if (this.f != null) {
            this.f.onSeekComplete();
        }
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onVideoSizeChanged");
        if (this.g != null) {
            this.g.onVideoSizeChanged(i, i2, 1, 1);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        CyberLog.i("MediaPlayerImpl", "pause");
        if (d()) {
            this.v = 4;
            this.b.pause();
            if (this.m > 0 && this.p == 0) {
                this.p = System.currentTimeMillis();
            }
        }
        this.w = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        CyberLog.i("MediaPlayerImpl", "prepareAsync");
        if (this.b != null) {
            this.v = 1;
            if (this.k == -1) {
                this.k = System.currentTimeMillis();
            }
            try {
                this.b.prepareAsync();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                onError(this.b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        CyberLog.i("MediaPlayerImpl", "release");
        e();
        if (this.b != null) {
            this.u = -1L;
            this.s = false;
            this.v = 0;
            this.w = 0;
            this.b.setOnPreparedListener(null);
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
            this.b.release();
            this.b = null;
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
        if (this.b != null) {
            try {
                this.b.reset();
            } catch (IllegalStateException e) {
                CyberLog.e("MediaPlayerImpl", "reset IllegalStateException error");
            }
        }
        if (this.f1396a != null) {
            this.f1396a.c();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        CyberLog.i("MediaPlayerImpl", "seekTo");
        if (this.b != null) {
            if (d()) {
                this.b.seekTo((int) j);
            } else {
                this.u = j;
            }
            this.t = j;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        switch (i) {
            case 1001:
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.f1396a.a(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            case 1002:
                int round = Math.round((float) (j - this.m)) + this.l;
                CyberLog.i("MediaPlayerImpl", "sendCommand COMMAND_ON_FIRST_FRAME_DRAWED firstFrameCostTime:" + round);
                this.f1396a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, round);
                if (this.i != null) {
                    this.i.onInfo(CyberPlayerManager.MEDIA_INFO_FIRST_DISP_INTERVAL, round, null);
                    return;
                }
                return;
            case 1003:
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        this.f1396a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, next2, jSONObject2.getString(next2));
                    }
                    return;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        if (this.b != null) {
            this.n = uri.toString();
            try {
                this.b.setDataSource(context, uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        if (this.b != null) {
            this.n = uri.toString();
            try {
                this.b.setDataSource(context, uri, map);
            } catch (IOException e) {
                e.printStackTrace();
                onError(this.b, -1004, -1004);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                onError(this.b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        CyberLog.i("MediaPlayerImpl", "setDataSource 4");
        if (this.b != null) {
            this.n = fileDescriptor.toString();
            try {
                this.b.setDataSource(fileDescriptor);
            } catch (IOException e) {
                e.printStackTrace();
                onError(this.b, -1004, -1004);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                onError(this.b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        if (this.b != null) {
            this.n = str;
            try {
                this.b.setDataSource(str);
            } catch (IOException e) {
                e.printStackTrace();
                onError(this.b, -1004, -1004);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                onError(this.b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        if (this.b != null) {
            this.n = str;
            try {
                this.b.setDataSource(str);
            } catch (Exception e) {
                e.printStackTrace();
                onError(this.b, -1004, -1004);
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        CyberLog.i("MediaPlayerImpl", "setDisplay");
        if (this.b != null) {
            this.b.setDisplay(surfaceHolder);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        if (this.b != null) {
            this.b.setLooping(z);
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
        if (this.b != null) {
            this.b.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        if (f < 0.0f || f > 4.0f || this.b == null || Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            boolean isPlaying = this.b.isPlaying();
            this.b.setPlaybackParams(this.b.getPlaybackParams().setSpeed(f));
            if (isPlaying || !this.b.isPlaying()) {
                return;
            }
            pause();
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSurface(Surface surface) {
        CyberLog.i("MediaPlayerImpl", "setSurface");
        if (this.b != null) {
            this.b.setSurface(surface);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        if (this.b != null) {
            this.b.setVolume(f, f2);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setWakeMode(Context context, int i) {
        if (this.b != null) {
            this.b.setWakeMode(context, i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        CyberLog.i("MediaPlayerImpl", "start");
        if (d()) {
            this.v = 3;
            try {
                this.b.start();
            } catch (IllegalStateException e) {
                e.printStackTrace();
                onError(this.b, -1004, -1004);
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
        CyberLog.i("MediaPlayerImpl", "stop");
        if (this.b != null) {
            this.u = -1L;
            this.v = 0;
            this.w = 0;
            this.b.stop();
        }
    }
}
