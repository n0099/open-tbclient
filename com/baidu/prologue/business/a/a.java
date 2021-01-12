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
/* loaded from: classes5.dex */
public class a {
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.cop.get().acv();
    private RelativeLayout cpb;
    private ImageView cpc;
    private com.baidu.prologue.b.a cpd;
    private FrameLayout cpe;
    private String cpf;
    private InterfaceC0311a cpg;
    private boolean cph = false;
    private boolean cpi = false;
    private View cpj;
    private b cpk;
    private boolean cpl;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0311a {
        void iP(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0311a interfaceC0311a, final a.InterfaceC0309a interfaceC0309a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.cph = false;
            interfaceC0309a.fK(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.cpd.a(bVar);
        this.cpd.a(new a.InterfaceC0309a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0309a
            public void fK(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0309a.fK(i);
            }
        });
        this.cpd.a(c.c(file, str));
        this.cpk = bVar;
        this.cpg = interfaceC0311a;
        this.cpl = z;
        this.cpf = str2;
        if (TextUtils.equals(str2, "1")) {
            J("1", false);
        } else if (TextUtils.equals(this.cpf, "0")) {
            J("0", false);
        } else {
            J("-1", false);
        }
        this.cpi = false;
        this.cph = true;
    }

    public void prepare() {
        if (this.cph) {
            if (this.cpi) {
                this.cpk.onPrepared();
            } else if (this.cpd != null) {
                this.cpd.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.cpd != null) {
            this.cpd.pause();
        }
    }

    public void play() {
        if (this.cpd != null) {
            this.cpd.start();
        }
    }

    public boolean ade() {
        return this.cpd != null && this.cpd.ade();
    }

    public View adf() {
        return this.cpj;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.cpj = this.mRootView.findViewById(b.C0310b.video_splash_clickable);
        this.cpe = (FrameLayout) this.mRootView.findViewById(b.C0310b.video_splash_view_fl);
        this.cpb = (RelativeLayout) this.mRootView.findViewById(b.C0310b.video_splash_voice_click);
        e.a(this.cpb, SplashStyleRecorder.SplashElements.VOICE, this.cpl);
        this.cpc = (ImageView) this.mRootView.findViewById(b.C0310b.iv_video_splash_voice);
        this.cpb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.J(TextUtils.equals(a.this.cpf, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.cpd = new com.baidu.prologue.b.a(this.mActivity);
        this.cpd.B(this.cpe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, boolean z) {
        if (this.cpb != null && this.cpc != null && this.cpd != null) {
            this.cpf = str;
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
                    this.cpb.setVisibility(8);
                    this.cpd.setMute(true);
                    return;
                case 1:
                    this.cpb.setVisibility(0);
                    this.cpc.setImageResource(b.a.splash_video_mute);
                    this.cpd.setMute(true);
                    if (this.cpg != null && z) {
                        this.cpg.iP("0");
                        return;
                    }
                    return;
                case 2:
                    this.cpb.setVisibility(0);
                    this.cpc.setImageResource(b.a.splash_video_unmute);
                    this.cpd.setMute(false);
                    if (this.cpg != null && z) {
                        this.cpg.iP("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View sW() {
        return this.mRootView;
    }

    public void release() {
        if (this.cpd != null) {
            this.cpd.release();
            this.cpd = null;
        }
    }
}
