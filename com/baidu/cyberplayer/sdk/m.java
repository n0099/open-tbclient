package com.baidu.cyberplayer.sdk;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.cyberplayer.sdk.p;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.cyberplayer.sdk.statistics.UbcSessionUploader;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m extends PlayerProvider implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public boolean A;
    public p B;
    public boolean C;
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
    public float z = -1.0f;

    private boolean b(int i) {
        return i == -10002 || i == -10001 || i == -38;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void changeProxyDynamic(String str, boolean z) {
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
    public void getMediaRuntimeInfo(CyberPlayerManager.OnMediaRuntimeInfoListener onMediaRuntimeInfoListener) {
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public String getPlayerConfigOptions() {
        return "";
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isRemotePlayer() {
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stepToNextFrame() {
    }

    public m() {
        boolean z = false;
        this.C = false;
        boolean a = CyberCfgManager.getInstance().a("enable_mp_record_state", false);
        boolean a2 = CyberCfgManager.getInstance().a("enable_mp_state_forbid", false);
        this.A = (a || a2) ? true : true;
        p pVar = new p(a, a2);
        this.B = pVar;
        pVar.a(p.a.IDLE);
        this.C = CyberPlayerManager.isAppInDebugMode();
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
        e();
        CyberLog.i("MediaPlayerImpl", "isAppInDebugMode:" + CyberPlayerManager.isAppInDebugMode());
    }

    private void j() {
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.a;
        if (hVar != null && !hVar.a()) {
            if (this.l > 0 || this.t) {
                this.a.a(this);
                this.a.b(this);
                this.a.a(this, DpStatConstants.SERVER_TYPE_DUPLAYER_MONITOR);
                String a = this.a.a(DpStatConstants.SERVER_TYPE_DUPLAYER_MONITOR);
                UbcSessionUploader.getInstance().upload(a, "ubc", i());
                if (CyberCfgManager.getInstance().getCfgBoolValue("gray_release_sole_ubcid", false) && this.a.d() && this.a.e()) {
                    UbcSessionUploader.getInstance().upload(a, "ubc", -1004);
                }
            }
            this.a.b();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void pause() {
        int i;
        CyberLog.i("MediaPlayerImpl", DownloadStatisticConstants.UBC_TYPE_PAUSE);
        if (this.b != null && ((i = this.x) == 4 || i == 3 || i == 5)) {
            if (a(f())) {
                p.a a = this.B.a();
                this.B.a(p.a.PAUSED);
                this.x = 4;
                try {
                    this.b.pause();
                } catch (IllegalStateException e) {
                    a(e, -10002, a);
                } catch (Exception unused) {
                }
                if (this.n > 0 && this.q == 0) {
                    this.q = System.currentTimeMillis();
                }
            }
        } else {
            CyberLog.i("MediaPlayerImpl", "no need do pause in state:" + this.x);
        }
        this.y = 4;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void start() {
        CyberLog.i("MediaPlayerImpl", "start");
        if (h() && a(f())) {
            this.x = 3;
            try {
                this.b.start();
            } catch (IllegalStateException e) {
                a(e, -10002, this.B.a());
            }
            this.B.a(p.a.STARTED);
            if (Math.abs(this.z - (-1.0f)) > 1.0E-6d) {
                setSpeed(this.z);
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

    private void a(IllegalStateException illegalStateException, int i, p.a aVar) throws IllegalStateException {
        if (!this.C) {
            onError(this.b, i, aVar.ordinal());
            return;
        }
        illegalStateException.printStackTrace();
        throw new IllegalStateException("Error Call in State " + aVar.toString());
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onVideoSizeChanged");
        CyberPlayerManager.OnVideoSizeChangedListener onVideoSizeChangedListener = this.g;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2, 1, 1);
        }
    }

    private boolean a(String str) {
        p pVar = this.B;
        if (pVar != null) {
            return pVar.a(str);
        }
        return true;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onCompletion");
        this.x = 5;
        this.y = 5;
        p pVar = this.B;
        if (pVar != null) {
            pVar.a(p.a.PLAYBACK_COMPLETE);
        }
        CyberPlayerManager.OnCompletionListener onCompletionListener = this.d;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
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

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j) {
        seekTo(j, 3);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDisplay(SurfaceHolder surfaceHolder) {
        CyberLog.i("MediaPlayerImpl", "setDisplay");
        if (this.b != null && a(f())) {
            try {
                this.b.setDisplay(surfaceHolder);
            } catch (IllegalStateException e) {
                a(e, -10000, this.B.a());
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setLooping(boolean z) {
        if (this.b != null && a(f())) {
            this.b.setLooping(z);
            this.a.a(DpStatConstants.SESSION_TYPE_PLAY_COMMON, DpStatConstants.KEY_IS_LOOP_PLAYED, z ? 1 : 0);
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
    public void setSurface(Surface surface) {
        CyberLog.i("MediaPlayerImpl", "setSurface");
        if (this.b != null && a(f())) {
            try {
                this.b.setSurface(surface);
            } catch (IllegalStateException e) {
                a(e, -10000, this.B.a());
            } catch (Exception unused) {
            }
        }
    }

    private void e() {
        this.l = -1L;
        this.m = 0;
        this.n = -1L;
        this.p = 0L;
        this.r = -1L;
        this.t = false;
        this.z = -1.0f;
    }

    private String f() {
        if (!this.A) {
            return "";
        }
        return new Exception().getStackTrace()[1].getMethodName();
    }

    private boolean g() {
        if (this.b != null && a(f())) {
            return this.b.isPlaying();
        }
        return false;
    }

    private boolean h() {
        int i;
        if (this.b != null && (i = this.x) != -1 && i != 0 && i != 1) {
            return true;
        }
        return false;
    }

    private int i() {
        if (!this.a.d()) {
            return -1005;
        }
        if (this.a.c()) {
            return -1009;
        }
        return -1007;
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

    public boolean d() {
        return this.k;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPositionSync() {
        return getCurrentPosition();
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
        int i = this.x;
        if (i == 1 || i == -1 || this.b == null || !a(f())) {
            return 0;
        }
        try {
            return this.b.getVideoHeight();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getVideoWidth() {
        int i = this.x;
        if (i == 1 || i == -1 || this.b == null || !a(f())) {
            return 0;
        }
        try {
            return this.b.getVideoWidth();
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isLooping() {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null && mediaPlayer.isLooping()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public boolean isPlaying() {
        if (h() && this.x == 3) {
            return true;
        }
        return false;
    }

    public void a(int i) {
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.a;
        if (hVar != null && !hVar.a()) {
            if (this.l > 0 || this.t) {
                this.a.a(this);
                this.a.b(this);
                this.a.a(DpStatConstants.SESSION_TYPE_MEDIA_DATA_UTILIZATION_RATE, "upload_download_data_n", i);
                this.a.a(this, DpStatConstants.SERVER_TYPE_DUPLAYER_OTHER_DATA);
                UbcSessionUploader.getInstance().upload(this.a.a(DpStatConstants.SERVER_TYPE_DUPLAYER_OTHER_DATA), "ubc", -1008);
            }
            this.a.b();
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        CyberLog.i("MediaPlayerImpl", "onPrepared");
        this.x = 2;
        p pVar = this.B;
        if (pVar != null) {
            pVar.a(p.a.PREPARED);
        }
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

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str) {
        CyberLog.d("MediaPlayerImpl", "setDataSource:" + str);
        if (this.b != null && a(f())) {
            String defaultUrlStringFromMPD = MPDParser.getDefaultUrlStringFromMPD(str);
            this.o = defaultUrlStringFromMPD;
            try {
                this.b.setDataSource(defaultUrlStringFromMPD);
            } catch (IOException unused) {
                onError(this.b, -1004, -1004);
            } catch (IllegalStateException e) {
                a(e, -10001, this.B.a());
            } catch (Exception unused2) {
            }
            this.B.a(p.a.INITIALIZED);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setSpeed(float f) {
        if (f >= 0.0f && f <= 4.0f && this.b != null && Build.VERSION.SDK_INT >= 23) {
            try {
                if ((g() || isPlaying()) && a(f())) {
                    CyberLog.i("MediaPlayerImpl", "setSpeed to " + f);
                    this.b.setPlaybackParams(this.b.getPlaybackParams().setSpeed(f));
                    this.z = -1.0f;
                    return;
                }
                this.z = f;
            } catch (IllegalStateException unused) {
                CyberLog.e("MediaPlayerImpl", "setSpeed IllegalStateException error");
            } catch (Exception unused2) {
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public int getCurrentPosition() {
        if (this.b != null) {
            long j = this.u;
            if (j > -1) {
                return (int) j;
            }
            int i = this.x;
            if (i != 0 && i != 1 && i != 2 && i != -1 && a(f())) {
                try {
                    return this.b.getCurrentPosition();
                } catch (IllegalStateException unused) {
                    CyberLog.e("MediaPlayerImpl", "getCurrentPosition IllegalStateException error");
                }
            }
        }
        return 0;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void reset() {
        CyberLog.i("MediaPlayerImpl", "reset");
        j();
        this.v = -1L;
        this.u = -1L;
        this.x = 0;
        this.y = 0;
        e();
        if (this.b != null && a(f())) {
            this.B.a(p.a.IDLE);
            try {
                this.b.reset();
            } catch (IllegalStateException unused) {
                CyberLog.e("MediaPlayerImpl", "reset IllegalStateException error");
            }
        }
        com.baidu.cyberplayer.sdk.statistics.h hVar = this.a;
        if (hVar != null) {
            hVar.b();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void stop() {
        CyberLog.i("MediaPlayerImpl", "stop");
        if (this.b != null && a(f())) {
            p.a a = this.B.a();
            this.B.a(p.a.STOPPED);
            this.v = -1L;
            this.x = 0;
            this.y = 0;
            this.z = -1.0f;
            try {
                this.b.stop();
            } catch (IllegalStateException e) {
                a(e, -10002, a);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void muteOrUnmuteAudio(boolean z) {
        float f;
        this.k = z;
        CyberLog.i("MediaPlayerImpl", "muteOrUnmuteAudio flag:" + z);
        CyberLog.y("MediaPlayerImpl", "muteOrUnmuteAudio flag:" + z);
        if (this.b == null) {
            return;
        }
        if (this.k) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        this.b.setVolume(f, f);
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(FileDescriptor fileDescriptor) {
        if (this.b != null && a(f())) {
            this.o = fileDescriptor.toString();
            try {
                this.b.setDataSource(fileDescriptor);
            } catch (IOException unused) {
                onError(this.b, -1004, -1004);
            } catch (IllegalStateException e) {
                a(e, -10001, this.B.a());
            } catch (Exception unused2) {
            }
            this.B.a(p.a.INITIALIZED);
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        CyberPlayerManager.OnBufferingUpdateListener onBufferingUpdateListener = this.e;
        if (onBufferingUpdateListener != null) {
            onBufferingUpdateListener.onBufferingUpdate(i);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setVolume(float f, float f2) {
        if (this.b != null && a(f())) {
            this.b.setVolume(f, f2);
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
    public void switchMediaSource(int i, CyberPlayerManager.MediaSourceSwitchMode mediaSourceSwitchMode) {
        CyberPlayerManager.OnMediaSourceChangedListener onMediaSourceChangedListener = this.j;
        if (onMediaSourceChangedListener != null) {
            if (mediaSourceSwitchMode == CyberPlayerManager.MediaSourceSwitchMode.MEDIASOURCE_SWITCH_ABR_MODE) {
                onMediaSourceChangedListener.onMediaSourceChanged(0, i, null);
            } else {
                onMediaSourceChangedListener.onMediaSourceChanged(-100, i, null);
            }
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        boolean z;
        String str;
        CyberLog.e("MediaPlayerImpl", "onError: (" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + SmallTailInfo.EMOTION_SUFFIX);
        int i3 = this.x;
        p.a aVar = p.a.IDLE;
        if (CyberCfgManager.getInstance().a("drop_mediaplay_stop_error", true) && this.x == 0 && this.y == 0) {
            z = true;
        } else {
            z = false;
        }
        this.x = -1;
        this.y = -1;
        p pVar = this.B;
        if (pVar != null) {
            aVar = pVar.a();
            this.B.a(p.a.ERROR);
        }
        if (z) {
            return false;
        }
        if (this.B != null) {
            if (b(i)) {
                CyberLog.e("MediaPlayerImpl", "Invalid Operation Err, current state:" + aVar.toString());
                this.a.a(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_STATE_TRACE, this.B.b());
            }
            str = StringUtil.ARRAY_ELEMENT_SEPARATOR + aVar.toString();
        } else {
            str = "";
        }
        if (CyberCfgManager.getInstance().a("java_error_code_mapping", true)) {
            i = CyberErrorMapper.getInstance().mapErrNo(i);
        } else {
            this.a.a(DpStatConstants.SESSION_TYPE_ERROR, DpStatConstants.KEY_NEW_ERROR_CODE, CyberErrorMapper.getInstance().mapErrNo(i));
        }
        this.a.a(DpStatConstants.SESSION_TYPE_ERROR, "error_code", i);
        this.a.a(DpStatConstants.SESSION_TYPE_ERROR, "sub_code", i2);
        this.a.a(DpStatConstants.SESSION_TYPE_ERROR, "time", System.currentTimeMillis());
        this.a.a(DpStatConstants.SESSION_TYPE_ERROR, "detail", "mediaplay error(" + i + "," + i2 + "), state(" + i3 + str + SmallTailInfo.EMOTION_SUFFIX);
        CyberPlayerManager.OnErrorListener onErrorListener = this.h;
        if (onErrorListener != null && onErrorListener.onError(i, i2, null)) {
            return true;
        }
        return false;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        CyberLog.i("MediaPlayerImpl", "onInfo: " + i);
        if (i == 3) {
            i = 904;
            this.a.a(DpStatConstants.SESSION_TYPE_FIRST_SCREEN, DpStatConstants.KEY_FIRST_DISPLAY, (System.currentTimeMillis() - this.n) + this.m);
        }
        CyberPlayerManager.OnInfoListener onInfoListener = this.i;
        if (onInfoListener != null && onInfoListener.onInfo(i, i2, null)) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void prepareAsync() {
        CyberLog.i("MediaPlayerImpl", "prepareAsync");
        if (this.b != null && a(f())) {
            p.a a = this.B.a();
            this.B.a(p.a.PREPARING);
            this.x = 1;
            if (this.l == -1) {
                this.l = System.currentTimeMillis();
            }
            try {
                this.b.prepareAsync();
            } catch (IllegalStateException e) {
                a(e, -10002, a);
            } catch (Exception e2) {
                if (e2 instanceof IOException) {
                    onError(this.b, -1004, -1004);
                }
            }
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void release() {
        CyberLog.i("MediaPlayerImpl", "release");
        j();
        if (this.b != null) {
            this.v = -1L;
            this.B.a(p.a.END);
            this.B = null;
            this.t = false;
            this.x = 0;
            this.y = 0;
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
            this.j = null;
            this.b.release();
            this.b = null;
            this.z = -1.0f;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void seekTo(long j, int i) {
        CyberLog.i("MediaPlayerImpl", "seekTo");
        if (h()) {
            if (a(f())) {
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.b.seekTo((int) j, i);
                    } else {
                        this.b.seekTo((int) j);
                    }
                } catch (IllegalStateException e) {
                    a(e, -10002, this.B.a());
                } catch (Exception unused) {
                }
            }
        } else {
            this.v = j;
            this.w = i;
        }
        this.u = j;
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void sendCommand(int i, int i2, long j, String str) {
        switch (i) {
            case 1001:
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.a.a(DpStatConstants.SESSION_TYPE_STAGE_INFO, next, jSONObject.getString(next));
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
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
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str);
                        Iterator<String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            this.a.a(i2, next2, jSONObject2.getString(next2));
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri) {
        CyberLog.d("MediaPlayerImpl", "setDataSource uri:" + uri);
        Uri defaultUrlFromMPD = MPDParser.getDefaultUrlFromMPD(uri);
        if (this.b != null && a(f())) {
            this.o = defaultUrlFromMPD.toString();
            try {
                this.b.setDataSource(context, defaultUrlFromMPD);
            } catch (IOException unused) {
                onError(this.b, -1004, -1004);
            } catch (IllegalStateException e) {
                a(e, -10001, this.B.a());
            } catch (Exception unused2) {
            }
            this.B.a(p.a.INITIALIZED);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        CyberLog.d("MediaPlayerImpl", "setDataSource uri:" + uri);
        Uri defaultUrlFromMPD = MPDParser.getDefaultUrlFromMPD(uri);
        if (this.b != null && a(f())) {
            this.o = defaultUrlFromMPD.toString();
            try {
                this.b.setDataSource(context, defaultUrlFromMPD, map);
            } catch (IOException unused) {
                onError(this.b, -1004, -1004);
            } catch (IllegalStateException e) {
                a(e, -10001, this.B.a());
            } catch (Exception unused2) {
            }
            this.B.a(p.a.INITIALIZED);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.PlayerProvider
    public void setDataSource(String str, Map<String, String> map) {
        CyberLog.d("MediaPlayerImpl", "setDataSource:" + str);
        if (this.b != null && a(f())) {
            String defaultUrlStringFromMPD = MPDParser.getDefaultUrlStringFromMPD(str);
            this.o = defaultUrlStringFromMPD;
            try {
                this.b.setDataSource(defaultUrlStringFromMPD);
            } catch (IOException unused) {
                onError(this.b, -1004, -1004);
            } catch (IllegalStateException e) {
                a(e, -10001, this.B.a());
            } catch (Exception unused2) {
            }
            this.B.a(p.a.INITIALIZED);
        }
    }
}
