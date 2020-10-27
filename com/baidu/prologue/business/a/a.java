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
/* loaded from: classes19.dex */
public class a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.cbs.get().Zu();
    private RelativeLayout cce;
    private ImageView ccf;
    private com.baidu.prologue.b.a ccg;
    private FrameLayout cch;
    private String cci;
    private InterfaceC0307a ccj;
    private boolean cck = false;
    private boolean ccl = false;
    private View ccm;
    private b ccn;
    private boolean cco;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0307a {
        void jr(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0307a interfaceC0307a, final a.InterfaceC0305a interfaceC0305a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.cck = false;
            interfaceC0305a.gO(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.ccg.a(bVar);
        this.ccg.a(new a.InterfaceC0305a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0305a
            public void gO(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0305a.gO(i);
            }
        });
        this.ccg.a(c.b(file, str));
        this.ccn = bVar;
        this.ccj = interfaceC0307a;
        this.cco = z;
        this.cci = str2;
        if (TextUtils.equals(str2, "1")) {
            I("1", false);
        } else if (TextUtils.equals(this.cci, "0")) {
            I("0", false);
        } else {
            I("-1", false);
        }
        this.ccl = false;
        this.cck = true;
    }

    public void prepare() {
        if (this.cck) {
            if (this.ccl) {
                this.ccn.onPrepared();
            } else if (this.ccg != null) {
                this.ccg.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.ccg != null) {
            this.ccg.pause();
        }
    }

    public void play() {
        if (this.ccg != null) {
            this.ccg.start();
        }
    }

    public boolean aad() {
        return this.ccg != null && this.ccg.aad();
    }

    public View aae() {
        return this.ccm;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.ccm = this.mRootView.findViewById(b.C0306b.video_splash_clickable);
        this.cch = (FrameLayout) this.mRootView.findViewById(b.C0306b.video_splash_view_fl);
        this.cce = (RelativeLayout) this.mRootView.findViewById(b.C0306b.video_splash_voice_click);
        e.a(this.cce, SplashStyleRecorder.SplashElements.VOICE, this.cco);
        this.ccf = (ImageView) this.mRootView.findViewById(b.C0306b.iv_video_splash_voice);
        this.cce.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.I(TextUtils.equals(a.this.cci, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.ccg = new com.baidu.prologue.b.a(this.mActivity);
        this.ccg.A(this.cch);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, boolean z) {
        if (this.cce != null && this.ccf != null && this.ccg != null) {
            this.cci = str;
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
                    this.cce.setVisibility(8);
                    this.ccg.setMute(true);
                    return;
                case 1:
                    this.cce.setVisibility(0);
                    this.ccf.setImageResource(b.a.splash_video_mute);
                    this.ccg.setMute(true);
                    if (this.ccj != null && z) {
                        this.ccj.jr("0");
                        return;
                    }
                    return;
                case 2:
                    this.cce.setVisibility(0);
                    this.ccf.setImageResource(b.a.splash_video_unmute);
                    this.ccg.setMute(false);
                    if (this.ccj != null && z) {
                        this.ccj.jr("1");
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
        if (this.ccg != null) {
            this.ccg.release();
            this.ccg = null;
        }
    }
}
