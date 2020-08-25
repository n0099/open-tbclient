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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bKi.get().UU();
    private RelativeLayout bKU;
    private ImageView bKV;
    private com.baidu.prologue.b.a bKW;
    private FrameLayout bKX;
    private String bKY;
    private InterfaceC0280a bKZ;
    private boolean bLa = false;
    private boolean bLb = false;
    private View bLc;
    private b bLd;
    private boolean bLe;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0280a {
        void ic(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0280a interfaceC0280a, final a.InterfaceC0278a interfaceC0278a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bLa = false;
            interfaceC0278a.ga(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bKW.a(bVar);
        this.bKW.a(new a.InterfaceC0278a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0278a
            public void ga(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0278a.ga(i);
            }
        });
        this.bKW.a(c.b(file, str));
        this.bLd = bVar;
        this.bKZ = interfaceC0280a;
        this.bLe = z;
        this.bKY = str2;
        if (TextUtils.equals(str2, "1")) {
            D("1", false);
        } else if (TextUtils.equals(this.bKY, "0")) {
            D("0", false);
        } else {
            D("-1", false);
        }
        this.bLb = false;
        this.bLa = true;
    }

    public void prepare() {
        if (this.bLa) {
            if (this.bLb) {
                this.bLd.onPrepared();
            } else if (this.bKW != null) {
                this.bKW.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.bKW != null) {
            this.bKW.pause();
        }
    }

    public void play() {
        if (this.bKW != null) {
            this.bKW.start();
        }
    }

    public boolean VD() {
        return this.bKW != null && this.bKW.VD();
    }

    public View VE() {
        return this.bLc;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bLc = this.mRootView.findViewById(b.C0279b.video_splash_clickable);
        this.bKX = (FrameLayout) this.mRootView.findViewById(b.C0279b.video_splash_view_fl);
        this.bKU = (RelativeLayout) this.mRootView.findViewById(b.C0279b.video_splash_voice_click);
        e.a(this.bKU, SplashStyleRecorder.SplashElements.VOICE, this.bLe);
        this.bKV = (ImageView) this.mRootView.findViewById(b.C0279b.iv_video_splash_voice);
        this.bKU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.D(TextUtils.equals(a.this.bKY, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.bKW = new com.baidu.prologue.b.a(this.mActivity);
        this.bKW.u(this.bKX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str, boolean z) {
        if (this.bKU != null && this.bKV != null && this.bKW != null) {
            this.bKY = str;
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
                    this.bKU.setVisibility(8);
                    this.bKW.setMute(true);
                    return;
                case 1:
                    this.bKU.setVisibility(0);
                    this.bKV.setImageResource(b.a.splash_video_mute);
                    this.bKW.setMute(true);
                    if (this.bKZ != null && z) {
                        this.bKZ.ic("0");
                        return;
                    }
                    return;
                case 2:
                    this.bKU.setVisibility(0);
                    this.bKV.setImageResource(b.a.splash_video_unmute);
                    this.bKW.setMute(false);
                    if (this.bKZ != null && z) {
                        this.bKZ.ic("1");
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
        if (this.bKW != null) {
            this.bKW.release();
            this.bKW = null;
        }
    }
}
