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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.bSV.get().XA();
    private RelativeLayout bTH;
    private ImageView bTI;
    private com.baidu.prologue.b.a bTJ;
    private FrameLayout bTK;
    private String bTL;
    private InterfaceC0293a bTM;
    private boolean bTN = false;
    private boolean bTO = false;
    private View bTP;
    private b bTQ;
    private boolean bTR;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0293a {
        void iY(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0293a interfaceC0293a, final a.InterfaceC0291a interfaceC0291a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.bTN = false;
            interfaceC0291a.gD(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.bTJ.a(bVar);
        this.bTJ.a(new a.InterfaceC0291a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0291a
            public void gD(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0291a.gD(i);
            }
        });
        this.bTJ.a(c.b(file, str));
        this.bTQ = bVar;
        this.bTM = interfaceC0293a;
        this.bTR = z;
        this.bTL = str2;
        if (TextUtils.equals(str2, "1")) {
            G("1", false);
        } else if (TextUtils.equals(this.bTL, "0")) {
            G("0", false);
        } else {
            G("-1", false);
        }
        this.bTO = false;
        this.bTN = true;
    }

    public void prepare() {
        if (this.bTN) {
            if (this.bTO) {
                this.bTQ.onPrepared();
            } else if (this.bTJ != null) {
                this.bTJ.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.bTJ != null) {
            this.bTJ.pause();
        }
    }

    public void play() {
        if (this.bTJ != null) {
            this.bTJ.start();
        }
    }

    public boolean Yj() {
        return this.bTJ != null && this.bTJ.Yj();
    }

    public View Yk() {
        return this.bTP;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.bTP = this.mRootView.findViewById(b.C0292b.video_splash_clickable);
        this.bTK = (FrameLayout) this.mRootView.findViewById(b.C0292b.video_splash_view_fl);
        this.bTH = (RelativeLayout) this.mRootView.findViewById(b.C0292b.video_splash_voice_click);
        e.a(this.bTH, SplashStyleRecorder.SplashElements.VOICE, this.bTR);
        this.bTI = (ImageView) this.mRootView.findViewById(b.C0292b.iv_video_splash_voice);
        this.bTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.G(TextUtils.equals(a.this.bTL, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.bTJ = new com.baidu.prologue.b.a(this.mActivity);
        this.bTJ.z(this.bTK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, boolean z) {
        if (this.bTH != null && this.bTI != null && this.bTJ != null) {
            this.bTL = str;
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
                    this.bTH.setVisibility(8);
                    this.bTJ.setMute(true);
                    return;
                case 1:
                    this.bTH.setVisibility(0);
                    this.bTI.setImageResource(b.a.splash_video_mute);
                    this.bTJ.setMute(true);
                    if (this.bTM != null && z) {
                        this.bTM.iY("0");
                        return;
                    }
                    return;
                case 2:
                    this.bTH.setVisibility(0);
                    this.bTI.setImageResource(b.a.splash_video_unmute);
                    this.bTJ.setMute(false);
                    if (this.bTM != null && z) {
                        this.bTM.iY("1");
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
        if (this.bTJ != null) {
            this.bTJ.release();
            this.bTJ = null;
        }
    }
}
