package com.baidu.prologue.business.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.prologue.b;
import com.baidu.prologue.b.a;
import com.baidu.prologue.b.b;
import com.baidu.prologue.b.c;
import com.baidu.prologue.business.c.e;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import java.io.File;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bMm.get().VD();
    private RelativeLayout bMY;
    private ImageView bMZ;
    private com.baidu.prologue.b.a bNa;
    private FrameLayout bNb;
    private String bNc;
    private InterfaceC0278a bNd;
    private boolean bNe = false;
    private boolean bNf = false;
    private View bNg;
    private b bNh;
    private boolean bNi;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0278a {
        void iw(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0278a interfaceC0278a, final a.InterfaceC0276a interfaceC0276a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bNe = false;
            interfaceC0276a.gj(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bNa.a(bVar);
        this.bNa.a(new a.InterfaceC0276a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0276a
            public void gj(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0276a.gj(i);
            }
        });
        this.bNa.a(c.b(file, str));
        this.bNh = bVar;
        this.bNd = interfaceC0278a;
        this.bNi = z;
        this.bNc = str2;
        if (TextUtils.equals(str2, "1")) {
            D("1", false);
        } else if (TextUtils.equals(this.bNc, "0")) {
            D("0", false);
        } else {
            D("-1", false);
        }
        this.bNf = false;
        this.bNe = true;
    }

    public void prepare() {
        if (this.bNe) {
            if (this.bNf) {
                this.bNh.onPrepared();
            } else if (this.bNa != null) {
                this.bNa.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.bNa != null) {
            this.bNa.pause();
        }
    }

    public void play() {
        if (this.bNa != null) {
            this.bNa.start();
        }
    }

    public boolean Wm() {
        return this.bNa != null && this.bNa.Wm();
    }

    public View Wn() {
        return this.bNg;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bNg = this.mRootView.findViewById(b.C0277b.video_splash_clickable);
        this.bNb = (FrameLayout) this.mRootView.findViewById(b.C0277b.video_splash_view_fl);
        this.bMY = (RelativeLayout) this.mRootView.findViewById(b.C0277b.video_splash_voice_click);
        e.a(this.bMY, SplashStyleRecorder.SplashElements.VOICE, this.bNi);
        this.bMZ = (ImageView) this.mRootView.findViewById(b.C0277b.iv_video_splash_voice);
        this.bMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.D(TextUtils.equals(a.this.bNc, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.bNa = new com.baidu.prologue.b.a(this.mActivity);
        this.bNa.x(this.bNb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str, boolean z) {
        if (this.bMY != null && this.bMZ != null && this.bNa != null) {
            this.bNc = str;
            char c = 65535;
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c = 1;
                        break;
                    }
                    break;
                case 49:
                    if (str.equals("1")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1444:
                    if (str.equals("-1")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.bMY.setVisibility(8);
                    this.bNa.setMute(true);
                    return;
                case 1:
                    this.bMY.setVisibility(0);
                    this.bMZ.setImageResource(b.a.splash_video_mute);
                    this.bNa.setMute(true);
                    if (this.bNd != null && z) {
                        this.bNd.iw("0");
                        return;
                    }
                    return;
                case 2:
                    this.bMY.setVisibility(0);
                    this.bMZ.setImageResource(b.a.splash_video_unmute);
                    this.bNa.setMute(false);
                    if (this.bNd != null && z) {
                        this.bNd.iw("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View tG() {
        return this.mRootView;
    }

    public void release() {
        if (this.bNa != null) {
            this.bNa.release();
            this.bNa = null;
        }
    }
}
