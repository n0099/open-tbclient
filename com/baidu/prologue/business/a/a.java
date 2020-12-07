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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.clZ.get().aes();
    private RelativeLayout cmM;
    private ImageView cmN;
    private com.baidu.prologue.b.a cmO;
    private FrameLayout cmP;
    private String cmQ;
    private InterfaceC0328a cmR;
    private boolean cmS = false;
    private boolean cmT = false;
    private View cmU;
    private b cmV;
    private boolean cmW;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0328a {
        void kf(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0328a interfaceC0328a, final a.InterfaceC0326a interfaceC0326a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.cmS = false;
            interfaceC0326a.hs(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.cmO.a(bVar);
        this.cmO.a(new a.InterfaceC0326a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0326a
            public void hs(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0326a.hs(i);
            }
        });
        this.cmO.a(c.b(file, str));
        this.cmV = bVar;
        this.cmR = interfaceC0328a;
        this.cmW = z;
        this.cmQ = str2;
        if (TextUtils.equals(str2, "1")) {
            J("1", false);
        } else if (TextUtils.equals(this.cmQ, "0")) {
            J("0", false);
        } else {
            J("-1", false);
        }
        this.cmT = false;
        this.cmS = true;
    }

    public void prepare() {
        if (this.cmS) {
            if (this.cmT) {
                this.cmV.onPrepared();
            } else if (this.cmO != null) {
                this.cmO.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.cmO != null) {
            this.cmO.pause();
        }
    }

    public void play() {
        if (this.cmO != null) {
            this.cmO.start();
        }
    }

    public boolean afb() {
        return this.cmO != null && this.cmO.afb();
    }

    public View afc() {
        return this.cmU;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.cmU = this.mRootView.findViewById(b.C0327b.video_splash_clickable);
        this.cmP = (FrameLayout) this.mRootView.findViewById(b.C0327b.video_splash_view_fl);
        this.cmM = (RelativeLayout) this.mRootView.findViewById(b.C0327b.video_splash_voice_click);
        e.a(this.cmM, SplashStyleRecorder.SplashElements.VOICE, this.cmW);
        this.cmN = (ImageView) this.mRootView.findViewById(b.C0327b.iv_video_splash_voice);
        this.cmM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.J(TextUtils.equals(a.this.cmQ, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.cmO = new com.baidu.prologue.b.a(this.mActivity);
        this.cmO.y(this.cmP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, boolean z) {
        if (this.cmM != null && this.cmN != null && this.cmO != null) {
            this.cmQ = str;
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
                    this.cmM.setVisibility(8);
                    this.cmO.setMute(true);
                    return;
                case 1:
                    this.cmM.setVisibility(0);
                    this.cmN.setImageResource(b.a.splash_video_mute);
                    this.cmO.setMute(true);
                    if (this.cmR != null && z) {
                        this.cmR.kf("0");
                        return;
                    }
                    return;
                case 2:
                    this.cmM.setVisibility(0);
                    this.cmN.setImageResource(b.a.splash_video_unmute);
                    this.cmO.setMute(false);
                    if (this.cmR != null && z) {
                        this.cmR.kf("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View tJ() {
        return this.mRootView;
    }

    public void release() {
        if (this.cmO != null) {
            this.cmO.release();
            this.cmO = null;
        }
    }
}
