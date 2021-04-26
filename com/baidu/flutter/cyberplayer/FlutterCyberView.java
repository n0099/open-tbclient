package com.baidu.flutter.cyberplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
/* loaded from: classes2.dex */
public class FlutterCyberView extends CyberVideoView {
    public Context H;
    public PowerManager.WakeLock I;
    public boolean J;
    public String K;
    public CyberPlayerManager.OnPreparedListener L;
    public CyberPlayerManager.OnCompletionListener M;
    public CyberPlayerManager.OnSeekCompleteListener N;
    public CyberPlayerManager.OnErrorListener O;
    public CyberPlayerManager.OnInfoListener P;
    public CyberPlayerManager.OnPreparedListener Q;
    public CyberPlayerManager.OnCompletionListener R;
    public CyberPlayerManager.OnErrorListener S;
    public CyberPlayerManager.OnSeekCompleteListener T;
    public CyberPlayerManager.OnInfoListener U;

    /* loaded from: classes2.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            int a2;
            if (FlutterCyberView.this.L != null) {
                FlutterCyberView.this.L.onPrepared();
            }
            if (!FlutterCyberView.this.J || (a2 = d.a.o.a.d.b().a(FlutterCyberView.this.K)) <= 0) {
                return;
            }
            FlutterCyberView.this.seekTo(a2);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CyberPlayerManager.OnCompletionListener {
        public b() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            d.a.o.a.d.b().c(FlutterCyberView.this.K);
            if (FlutterCyberView.this.getCyberPlayer().isLooping() || FlutterCyberView.this.M == null) {
                return;
            }
            FlutterCyberView.this.M.onCompletion();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public c() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            if (FlutterCyberView.this.getCurrentPosition() > 0 && FlutterCyberView.this.s()) {
                d.a.o.a.d.b().d(FlutterCyberView.this.K, FlutterCyberView.this.getCurrentPosition());
            }
            if (FlutterCyberView.this.O != null) {
                FlutterCyberView.this.O.onError(i2, i3, obj);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements CyberPlayerManager.OnSeekCompleteListener {
        public d() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            if (FlutterCyberView.this.N != null) {
                FlutterCyberView.this.N.onSeekComplete();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements CyberPlayerManager.OnInfoListener {
        public e() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (FlutterCyberView.this.P != null) {
                FlutterCyberView.this.P.onInfo(i2, i3, obj);
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public interface f {
    }

    public FlutterCyberView(Context context) {
        super(context, 1);
        this.Q = new a();
        this.R = new b();
        this.S = new c();
        this.T = new d();
        this.U = new e();
        r(context);
    }

    public String getOriginUrl() {
        return this.K;
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public final void r(Context context) {
        this.H = context;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "FlutterVideoView_WakeLock");
                this.I = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
        } catch (Exception unused) {
        }
        super.setOnPreparedListener(this.Q);
        super.setOnCompletionListener(this.R);
        super.setOnErrorListener(this.S);
        super.setOnSeekCompleteListener(this.T);
        super.setOnInfoListener(this.U);
    }

    public final boolean s() {
        return getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition();
    }

    public void setContinuePlayEnable(boolean z) {
        this.J = z;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void setLooping(boolean z) {
        getCyberPlayer().setLooping(z);
    }

    public void setOnSurfaceDestroyedListener(f fVar) {
    }

    public void setVideoDuration(int i2) {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView
    public void setVideoPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.K = str;
        super.setVideoPath(str);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (isPlaying() && s()) {
            d.a.o.a.d.b().d(this.K, getCurrentPositionSync());
        }
        try {
            if (this.I != null && this.I.isHeld()) {
                this.I.release();
            }
        } catch (Exception unused) {
        }
        super.stopPlayback();
    }

    public void t() {
        stopPlayback();
    }
}
