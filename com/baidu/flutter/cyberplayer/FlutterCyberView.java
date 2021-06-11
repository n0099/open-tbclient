package com.baidu.flutter.cyberplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.cyberplayer.sdk.CyberVideoView;
/* loaded from: classes2.dex */
public class FlutterCyberView extends CyberVideoView {
    public Context J;
    public PowerManager.WakeLock K;
    public boolean L;
    public String M;
    public CyberPlayerManager.OnPreparedListener N;
    public CyberPlayerManager.OnCompletionListener O;
    public CyberPlayerManager.OnSeekCompleteListener P;
    public CyberPlayerManager.OnErrorListener Q;
    public CyberPlayerManager.OnInfoListener R;
    public CyberPlayerManager.OnPreparedListener S;
    public CyberPlayerManager.OnCompletionListener T;
    public CyberPlayerManager.OnErrorListener U;
    public CyberPlayerManager.OnSeekCompleteListener V;
    public CyberPlayerManager.OnInfoListener W;

    /* loaded from: classes2.dex */
    public class a implements CyberPlayerManager.OnPreparedListener {
        public a() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            int a2;
            if (FlutterCyberView.this.N != null) {
                FlutterCyberView.this.N.onPrepared();
            }
            if (!FlutterCyberView.this.L || (a2 = d.a.o.a.d.b().a(FlutterCyberView.this.M)) <= 0) {
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
            d.a.o.a.d.b().c(FlutterCyberView.this.M);
            if (FlutterCyberView.this.getCyberPlayer().isLooping() || FlutterCyberView.this.O == null) {
                return;
            }
            FlutterCyberView.this.O.onCompletion();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements CyberPlayerManager.OnErrorListener {
        public c() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            if (FlutterCyberView.this.getCurrentPosition() > 0 && FlutterCyberView.this.s()) {
                d.a.o.a.d.b().d(FlutterCyberView.this.M, FlutterCyberView.this.getCurrentPosition());
            }
            if (FlutterCyberView.this.Q != null) {
                FlutterCyberView.this.Q.onError(i2, i3, obj);
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
            if (FlutterCyberView.this.P != null) {
                FlutterCyberView.this.P.onSeekComplete();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements CyberPlayerManager.OnInfoListener {
        public e() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            if (FlutterCyberView.this.R != null) {
                FlutterCyberView.this.R.onInfo(i2, i3, obj);
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
        this.S = new a();
        this.T = new b();
        this.U = new c();
        this.V = new d();
        this.W = new e();
        r(context);
    }

    public String getOriginUrl() {
        return this.M;
    }

    @SuppressLint({"InvalidWakeLockTag"})
    public final void r(Context context) {
        this.J = context;
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(536870922, "FlutterVideoView_WakeLock");
                this.K = newWakeLock;
                newWakeLock.setReferenceCounted(false);
            }
        } catch (Exception unused) {
        }
        super.setOnPreparedListener(this.S);
        super.setOnCompletionListener(this.T);
        super.setOnErrorListener(this.U);
        super.setOnSeekCompleteListener(this.V);
        super.setOnInfoListener(this.W);
    }

    public final boolean s() {
        return getCyberPlayer() != null && getCyberPlayer().getDuration() >= getCyberPlayer().getCurrentPosition();
    }

    public void setContinuePlayEnable(boolean z) {
        this.L = z;
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
        this.M = str;
        super.setVideoPath(str);
    }

    @Override // com.baidu.cyberplayer.sdk.CyberVideoView, com.baidu.cyberplayer.sdk.ICyberVideoView
    public void stopPlayback() {
        if (isPlaying() && s()) {
            d.a.o.a.d.b().d(this.M, getCurrentPositionSync());
        }
        try {
            if (this.K != null && this.K.isHeld()) {
                this.K.release();
            }
        } catch (Exception unused) {
        }
        super.stopPlayback();
    }

    public void t() {
        stopPlayback();
    }
}
