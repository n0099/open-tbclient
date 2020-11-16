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
/* loaded from: classes14.dex */
public class a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.cft.get().abk();
    private RelativeLayout cgf;
    private ImageView cgg;
    private com.baidu.prologue.b.a cgh;
    private FrameLayout cgi;
    private String cgj;
    private InterfaceC0317a cgk;
    private boolean cgl = false;
    private boolean cgm = false;
    private View cgn;
    private b cgo;
    private boolean cgp;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0317a {
        void jy(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0317a interfaceC0317a, final a.InterfaceC0315a interfaceC0315a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.cgl = false;
            interfaceC0315a.gU(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.cgh.a(bVar);
        this.cgh.a(new a.InterfaceC0315a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0315a
            public void gU(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0315a.gU(i);
            }
        });
        this.cgh.a(c.b(file, str));
        this.cgo = bVar;
        this.cgk = interfaceC0317a;
        this.cgp = z;
        this.cgj = str2;
        if (TextUtils.equals(str2, "1")) {
            I("1", false);
        } else if (TextUtils.equals(this.cgj, "0")) {
            I("0", false);
        } else {
            I("-1", false);
        }
        this.cgm = false;
        this.cgl = true;
    }

    public void prepare() {
        if (this.cgl) {
            if (this.cgm) {
                this.cgo.onPrepared();
            } else if (this.cgh != null) {
                this.cgh.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.cgh != null) {
            this.cgh.pause();
        }
    }

    public void play() {
        if (this.cgh != null) {
            this.cgh.start();
        }
    }

    public boolean abT() {
        return this.cgh != null && this.cgh.abT();
    }

    public View abU() {
        return this.cgn;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.cgn = this.mRootView.findViewById(b.C0316b.video_splash_clickable);
        this.cgi = (FrameLayout) this.mRootView.findViewById(b.C0316b.video_splash_view_fl);
        this.cgf = (RelativeLayout) this.mRootView.findViewById(b.C0316b.video_splash_voice_click);
        e.a(this.cgf, SplashStyleRecorder.SplashElements.VOICE, this.cgp);
        this.cgg = (ImageView) this.mRootView.findViewById(b.C0316b.iv_video_splash_voice);
        this.cgf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.I(TextUtils.equals(a.this.cgj, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.cgh = new com.baidu.prologue.b.a(this.mActivity);
        this.cgh.y(this.cgi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, boolean z) {
        if (this.cgf != null && this.cgg != null && this.cgh != null) {
            this.cgj = str;
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
                    this.cgf.setVisibility(8);
                    this.cgh.setMute(true);
                    return;
                case 1:
                    this.cgf.setVisibility(0);
                    this.cgg.setImageResource(b.a.splash_video_mute);
                    this.cgh.setMute(true);
                    if (this.cgk != null && z) {
                        this.cgk.jy("0");
                        return;
                    }
                    return;
                case 2:
                    this.cgf.setVisibility(0);
                    this.cgg.setImageResource(b.a.splash_video_unmute);
                    this.cgh.setMute(false);
                    if (this.cgk != null && z) {
                        this.cgk.jy("1");
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
        if (this.cgh != null) {
            this.cgh.release();
            this.cgh = null;
        }
    }
}
