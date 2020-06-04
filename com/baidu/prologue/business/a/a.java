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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bzx.get().ND();
    private RelativeLayout bAj;
    private ImageView bAk;
    private com.baidu.prologue.b.a bAl;
    private FrameLayout bAm;
    private String bAn;
    private InterfaceC0250a bAo;
    private boolean bAp = false;
    private boolean bAq = false;
    private View bAr;
    private b bAs;
    private boolean bAt;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0250a {
        void gC(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        Oo();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0250a interfaceC0250a, final a.InterfaceC0248a interfaceC0248a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bAp = false;
            interfaceC0248a.dT(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bAl.a(bVar);
        this.bAl.a(new a.InterfaceC0248a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0248a
            public void dT(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0248a.dT(i);
            }
        });
        this.bAl.a(c.b(file, str));
        this.bAs = bVar;
        this.bAo = interfaceC0250a;
        this.bAt = z;
        this.bAn = str2;
        if (TextUtils.equals(str2, "1")) {
            w("1", false);
        } else if (TextUtils.equals(this.bAn, "0")) {
            w("0", false);
        } else {
            w("-1", false);
        }
        this.bAq = false;
        this.bAp = true;
    }

    public void prepare() {
        if (this.bAp) {
            if (this.bAq) {
                this.bAs.onPrepared();
            } else if (this.bAl != null) {
                this.bAl.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.bAl != null) {
            this.bAl.pause();
        }
    }

    public void play() {
        if (this.bAl != null) {
            this.bAl.start();
        }
    }

    public boolean Om() {
        return this.bAl != null && this.bAl.Om();
    }

    public View On() {
        return this.bAr;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bAr = this.mRootView.findViewById(b.C0249b.video_splash_clickable);
        this.bAm = (FrameLayout) this.mRootView.findViewById(b.C0249b.video_splash_view_fl);
        this.bAj = (RelativeLayout) this.mRootView.findViewById(b.C0249b.video_splash_voice_click);
        e.a(this.bAj, SplashStyleRecorder.SplashElements.VOICE, this.bAt);
        this.bAk = (ImageView) this.mRootView.findViewById(b.C0249b.iv_video_splash_voice);
        this.bAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.w(TextUtils.equals(a.this.bAn, "0") ? "1" : "0", true);
            }
        });
    }

    private void Oo() {
        this.bAl = new com.baidu.prologue.b.a(this.mActivity);
        this.bAl.q(this.bAm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z) {
        if (this.bAj != null && this.bAk != null && this.bAl != null) {
            this.bAn = str;
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
                    this.bAj.setVisibility(8);
                    this.bAl.setMute(true);
                    return;
                case 1:
                    this.bAj.setVisibility(0);
                    this.bAk.setImageResource(b.a.splash_video_mute);
                    this.bAl.setMute(true);
                    if (this.bAo != null && z) {
                        this.bAo.gC("0");
                        return;
                    }
                    return;
                case 2:
                    this.bAj.setVisibility(0);
                    this.bAk.setImageResource(b.a.splash_video_unmute);
                    this.bAl.setMute(false);
                    if (this.bAo != null && z) {
                        this.bAo.gC("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View rx() {
        return this.mRootView;
    }

    public void release() {
        if (this.bAl != null) {
            this.bAl.release();
            this.bAl = null;
        }
    }
}
