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
/* loaded from: classes6.dex */
public class a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.brQ.get().Lr();
    private RelativeLayout bsC;
    private ImageView bsD;
    private com.baidu.prologue.b.a bsE;
    private FrameLayout bsF;
    private String bsG;
    private InterfaceC0195a bsH;
    private boolean bsI = false;
    private boolean bsJ = false;
    private View bsK;
    private b bsL;
    private boolean bsM;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0195a {
        void fQ(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        Mc();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0195a interfaceC0195a, final a.InterfaceC0193a interfaceC0193a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bsI = false;
            interfaceC0193a.dL(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bsE.a(bVar);
        this.bsE.a(new a.InterfaceC0193a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0193a
            public void dL(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0193a.dL(i);
            }
        });
        this.bsE.a(c.b(file, str));
        this.bsL = bVar;
        this.bsH = interfaceC0195a;
        this.bsM = z;
        this.bsG = str2;
        if (TextUtils.equals(str2, "1")) {
            s("1", false);
        } else if (TextUtils.equals(this.bsG, "0")) {
            s("0", false);
        } else {
            s("-1", false);
        }
        this.bsJ = false;
        this.bsI = true;
    }

    public void prepare() {
        if (this.bsI) {
            if (this.bsJ) {
                this.bsL.onPrepared();
            } else {
                this.bsE.prepareAsync();
            }
        }
    }

    public void pause() {
        this.bsE.pause();
    }

    public void play() {
        this.bsE.start();
    }

    public boolean Ma() {
        return this.bsE.Ma();
    }

    public View Mb() {
        return this.bsK;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bsK = this.mRootView.findViewById(b.C0194b.video_splash_clickable);
        this.bsF = (FrameLayout) this.mRootView.findViewById(b.C0194b.video_splash_view_fl);
        this.bsC = (RelativeLayout) this.mRootView.findViewById(b.C0194b.video_splash_voice_click);
        e.a(this.bsC, SplashStyleRecorder.SplashElements.VOICE, this.bsM);
        this.bsD = (ImageView) this.mRootView.findViewById(b.C0194b.iv_video_splash_voice);
        this.bsC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.s(TextUtils.equals(a.this.bsG, "0") ? "1" : "0", true);
            }
        });
    }

    private void Mc() {
        this.bsE = new com.baidu.prologue.b.a(this.mActivity);
        this.bsE.m(this.bsF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z) {
        if (this.bsC != null && this.bsD != null && this.bsE != null) {
            this.bsG = str;
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
                    this.bsC.setVisibility(8);
                    this.bsE.setMute(true);
                    return;
                case 1:
                    this.bsC.setVisibility(0);
                    this.bsD.setImageResource(b.a.splash_video_mute);
                    this.bsE.setMute(true);
                    if (this.bsH != null && z) {
                        this.bsH.fQ("0");
                        return;
                    }
                    return;
                case 2:
                    this.bsC.setVisibility(0);
                    this.bsD.setImageResource(b.a.splash_video_unmute);
                    this.bsE.setMute(false);
                    if (this.bsH != null && z) {
                        this.bsH.fQ("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View rq() {
        return this.mRootView;
    }

    public void release() {
        if (this.bsE != null) {
            this.bsE.release();
            this.bsE = null;
        }
    }
}
