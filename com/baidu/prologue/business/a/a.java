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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bEI.get().OY();
    private boolean bFA = false;
    private boolean bFB = false;
    private View bFC;
    private b bFD;
    private boolean bFE;
    private RelativeLayout bFu;
    private ImageView bFv;
    private com.baidu.prologue.b.a bFw;
    private FrameLayout bFx;
    private String bFy;
    private InterfaceC0259a bFz;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0259a {
        void gI(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        PJ();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0259a interfaceC0259a, final a.InterfaceC0257a interfaceC0257a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bFA = false;
            interfaceC0257a.ee(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bFw.a(bVar);
        this.bFw.a(new a.InterfaceC0257a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0257a
            public void ee(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0257a.ee(i);
            }
        });
        this.bFw.a(c.b(file, str));
        this.bFD = bVar;
        this.bFz = interfaceC0259a;
        this.bFE = z;
        this.bFy = str2;
        if (TextUtils.equals(str2, "1")) {
            y("1", false);
        } else if (TextUtils.equals(this.bFy, "0")) {
            y("0", false);
        } else {
            y("-1", false);
        }
        this.bFB = false;
        this.bFA = true;
    }

    public void prepare() {
        if (this.bFA) {
            if (this.bFB) {
                this.bFD.onPrepared();
            } else if (this.bFw != null) {
                this.bFw.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.bFw != null) {
            this.bFw.pause();
        }
    }

    public void play() {
        if (this.bFw != null) {
            this.bFw.start();
        }
    }

    public boolean PH() {
        return this.bFw != null && this.bFw.PH();
    }

    public View PI() {
        return this.bFC;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bFC = this.mRootView.findViewById(b.C0258b.video_splash_clickable);
        this.bFx = (FrameLayout) this.mRootView.findViewById(b.C0258b.video_splash_view_fl);
        this.bFu = (RelativeLayout) this.mRootView.findViewById(b.C0258b.video_splash_voice_click);
        e.a(this.bFu, SplashStyleRecorder.SplashElements.VOICE, this.bFE);
        this.bFv = (ImageView) this.mRootView.findViewById(b.C0258b.iv_video_splash_voice);
        this.bFu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.y(TextUtils.equals(a.this.bFy, "0") ? "1" : "0", true);
            }
        });
    }

    private void PJ() {
        this.bFw = new com.baidu.prologue.b.a(this.mActivity);
        this.bFw.t(this.bFx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        if (this.bFu != null && this.bFv != null && this.bFw != null) {
            this.bFy = str;
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
                    this.bFu.setVisibility(8);
                    this.bFw.setMute(true);
                    return;
                case 1:
                    this.bFu.setVisibility(0);
                    this.bFv.setImageResource(b.a.splash_video_mute);
                    this.bFw.setMute(true);
                    if (this.bFz != null && z) {
                        this.bFz.gI("0");
                        return;
                    }
                    return;
                case 2:
                    this.bFu.setVisibility(0);
                    this.bFv.setImageResource(b.a.splash_video_unmute);
                    this.bFw.setMute(false);
                    if (this.bFz != null && z) {
                        this.bFz.gI("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View rQ() {
        return this.mRootView;
    }

    public void release() {
        if (this.bFw != null) {
            this.bFw.release();
            this.bFw = null;
        }
    }
}
