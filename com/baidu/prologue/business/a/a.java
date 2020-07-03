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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bEl.get().OJ();
    private RelativeLayout bEX;
    private ImageView bEY;
    private com.baidu.prologue.b.a bEZ;
    private FrameLayout bFa;
    private String bFb;
    private InterfaceC0256a bFc;
    private boolean bFd = false;
    private boolean bFe = false;
    private View bFf;
    private b bFg;
    private boolean bFh;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0256a {
        void gK(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        Pu();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0256a interfaceC0256a, final a.InterfaceC0254a interfaceC0254a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bFd = false;
            interfaceC0254a.ee(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bEZ.a(bVar);
        this.bEZ.a(new a.InterfaceC0254a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0254a
            public void ee(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0254a.ee(i);
            }
        });
        this.bEZ.a(c.b(file, str));
        this.bFg = bVar;
        this.bFc = interfaceC0256a;
        this.bFh = z;
        this.bFb = str2;
        if (TextUtils.equals(str2, "1")) {
            y("1", false);
        } else if (TextUtils.equals(this.bFb, "0")) {
            y("0", false);
        } else {
            y("-1", false);
        }
        this.bFe = false;
        this.bFd = true;
    }

    public void prepare() {
        if (this.bFd) {
            if (this.bFe) {
                this.bFg.onPrepared();
            } else if (this.bEZ != null) {
                this.bEZ.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.bEZ != null) {
            this.bEZ.pause();
        }
    }

    public void play() {
        if (this.bEZ != null) {
            this.bEZ.start();
        }
    }

    public boolean Ps() {
        return this.bEZ != null && this.bEZ.Ps();
    }

    public View Pt() {
        return this.bFf;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bFf = this.mRootView.findViewById(b.C0255b.video_splash_clickable);
        this.bFa = (FrameLayout) this.mRootView.findViewById(b.C0255b.video_splash_view_fl);
        this.bEX = (RelativeLayout) this.mRootView.findViewById(b.C0255b.video_splash_voice_click);
        e.a(this.bEX, SplashStyleRecorder.SplashElements.VOICE, this.bFh);
        this.bEY = (ImageView) this.mRootView.findViewById(b.C0255b.iv_video_splash_voice);
        this.bEX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.y(TextUtils.equals(a.this.bFb, "0") ? "1" : "0", true);
            }
        });
    }

    private void Pu() {
        this.bEZ = new com.baidu.prologue.b.a(this.mActivity);
        this.bEZ.s(this.bFa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, boolean z) {
        if (this.bEX != null && this.bEY != null && this.bEZ != null) {
            this.bFb = str;
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
                    this.bEX.setVisibility(8);
                    this.bEZ.setMute(true);
                    return;
                case 1:
                    this.bEX.setVisibility(0);
                    this.bEY.setImageResource(b.a.splash_video_mute);
                    this.bEZ.setMute(true);
                    if (this.bFc != null && z) {
                        this.bFc.gK("0");
                        return;
                    }
                    return;
                case 2:
                    this.bEX.setVisibility(0);
                    this.bEY.setImageResource(b.a.splash_video_unmute);
                    this.bEZ.setMute(false);
                    if (this.bFc != null && z) {
                        this.bFc.gK("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View rO() {
        return this.mRootView;
    }

    public void release() {
        if (this.bEZ != null) {
            this.bEZ.release();
            this.bEZ = null;
        }
    }
}
