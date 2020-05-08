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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.brU.get().Lq();
    private RelativeLayout bsG;
    private ImageView bsH;
    private com.baidu.prologue.b.a bsI;
    private FrameLayout bsJ;
    private String bsK;
    private InterfaceC0217a bsL;
    private boolean bsM = false;
    private boolean bsN = false;
    private View bsO;
    private b bsP;
    private boolean bsQ;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0217a {
        void fQ(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        Mb();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0217a interfaceC0217a, final a.InterfaceC0215a interfaceC0215a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bsM = false;
            interfaceC0215a.dL(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bsI.a(bVar);
        this.bsI.a(new a.InterfaceC0215a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0215a
            public void dL(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0215a.dL(i);
            }
        });
        this.bsI.a(c.b(file, str));
        this.bsP = bVar;
        this.bsL = interfaceC0217a;
        this.bsQ = z;
        this.bsK = str2;
        if (TextUtils.equals(str2, "1")) {
            s("1", false);
        } else if (TextUtils.equals(this.bsK, "0")) {
            s("0", false);
        } else {
            s("-1", false);
        }
        this.bsN = false;
        this.bsM = true;
    }

    public void prepare() {
        if (this.bsM) {
            if (this.bsN) {
                this.bsP.onPrepared();
            } else {
                this.bsI.prepareAsync();
            }
        }
    }

    public void pause() {
        this.bsI.pause();
    }

    public void play() {
        this.bsI.start();
    }

    public boolean LZ() {
        return this.bsI.LZ();
    }

    public View Ma() {
        return this.bsO;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bsO = this.mRootView.findViewById(b.C0216b.video_splash_clickable);
        this.bsJ = (FrameLayout) this.mRootView.findViewById(b.C0216b.video_splash_view_fl);
        this.bsG = (RelativeLayout) this.mRootView.findViewById(b.C0216b.video_splash_voice_click);
        e.a(this.bsG, SplashStyleRecorder.SplashElements.VOICE, this.bsQ);
        this.bsH = (ImageView) this.mRootView.findViewById(b.C0216b.iv_video_splash_voice);
        this.bsG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.s(TextUtils.equals(a.this.bsK, "0") ? "1" : "0", true);
            }
        });
    }

    private void Mb() {
        this.bsI = new com.baidu.prologue.b.a(this.mActivity);
        this.bsI.m(this.bsJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, boolean z) {
        if (this.bsG != null && this.bsH != null && this.bsI != null) {
            this.bsK = str;
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
                    this.bsG.setVisibility(8);
                    this.bsI.setMute(true);
                    return;
                case 1:
                    this.bsG.setVisibility(0);
                    this.bsH.setImageResource(b.a.splash_video_mute);
                    this.bsI.setMute(true);
                    if (this.bsL != null && z) {
                        this.bsL.fQ("0");
                        return;
                    }
                    return;
                case 2:
                    this.bsG.setVisibility(0);
                    this.bsH.setImageResource(b.a.splash_video_unmute);
                    this.bsI.setMute(false);
                    if (this.bsL != null && z) {
                        this.bsL.fQ("1");
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
        if (this.bsI != null) {
            this.bsI.release();
            this.bsI = null;
        }
    }
}
