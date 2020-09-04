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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bKm.get().UU();
    private RelativeLayout bKY;
    private ImageView bKZ;
    private com.baidu.prologue.b.a bLa;
    private FrameLayout bLb;
    private String bLc;
    private InterfaceC0280a bLd;
    private boolean bLe = false;
    private boolean bLf = false;
    private View bLg;
    private b bLh;
    private boolean bLi;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0280a {
        void id(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0280a interfaceC0280a, final a.InterfaceC0278a interfaceC0278a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bLe = false;
            interfaceC0278a.ga(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bLa.a(bVar);
        this.bLa.a(new a.InterfaceC0278a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0278a
            public void ga(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0278a.ga(i);
            }
        });
        this.bLa.a(c.b(file, str));
        this.bLh = bVar;
        this.bLd = interfaceC0280a;
        this.bLi = z;
        this.bLc = str2;
        if (TextUtils.equals(str2, "1")) {
            D("1", false);
        } else if (TextUtils.equals(this.bLc, "0")) {
            D("0", false);
        } else {
            D("-1", false);
        }
        this.bLf = false;
        this.bLe = true;
    }

    public void prepare() {
        if (this.bLe) {
            if (this.bLf) {
                this.bLh.onPrepared();
            } else if (this.bLa != null) {
                this.bLa.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.bLa != null) {
            this.bLa.pause();
        }
    }

    public void play() {
        if (this.bLa != null) {
            this.bLa.start();
        }
    }

    public boolean VD() {
        return this.bLa != null && this.bLa.VD();
    }

    public View VE() {
        return this.bLg;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bLg = this.mRootView.findViewById(b.C0279b.video_splash_clickable);
        this.bLb = (FrameLayout) this.mRootView.findViewById(b.C0279b.video_splash_view_fl);
        this.bKY = (RelativeLayout) this.mRootView.findViewById(b.C0279b.video_splash_voice_click);
        e.a(this.bKY, SplashStyleRecorder.SplashElements.VOICE, this.bLi);
        this.bKZ = (ImageView) this.mRootView.findViewById(b.C0279b.iv_video_splash_voice);
        this.bKY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.D(TextUtils.equals(a.this.bLc, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.bLa = new com.baidu.prologue.b.a(this.mActivity);
        this.bLa.u(this.bLb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str, boolean z) {
        if (this.bKY != null && this.bKZ != null && this.bLa != null) {
            this.bLc = str;
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
                    this.bKY.setVisibility(8);
                    this.bLa.setMute(true);
                    return;
                case 1:
                    this.bKY.setVisibility(0);
                    this.bKZ.setImageResource(b.a.splash_video_mute);
                    this.bLa.setMute(true);
                    if (this.bLd != null && z) {
                        this.bLd.id("0");
                        return;
                    }
                    return;
                case 2:
                    this.bKY.setVisibility(0);
                    this.bKZ.setImageResource(b.a.splash_video_unmute);
                    this.bLa.setMute(false);
                    if (this.bLd != null && z) {
                        this.bLd.id("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View tB() {
        return this.mRootView;
    }

    public void release() {
        if (this.bLa != null) {
            this.bLa.release();
            this.bLa = null;
        }
    }
}
