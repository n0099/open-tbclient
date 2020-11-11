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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.che.get().abT();
    private RelativeLayout chQ;
    private ImageView chR;
    private com.baidu.prologue.b.a chS;
    private FrameLayout chT;
    private String chU;
    private InterfaceC0319a chV;
    private boolean chW = false;
    private boolean chX = false;
    private View chY;
    private b chZ;
    private boolean cia;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0319a {
        void jE(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0319a interfaceC0319a, final a.InterfaceC0317a interfaceC0317a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.chW = false;
            interfaceC0317a.gY(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.chS.a(bVar);
        this.chS.a(new a.InterfaceC0317a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0317a
            public void gY(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0317a.gY(i);
            }
        });
        this.chS.a(c.b(file, str));
        this.chZ = bVar;
        this.chV = interfaceC0319a;
        this.cia = z;
        this.chU = str2;
        if (TextUtils.equals(str2, "1")) {
            I("1", false);
        } else if (TextUtils.equals(this.chU, "0")) {
            I("0", false);
        } else {
            I("-1", false);
        }
        this.chX = false;
        this.chW = true;
    }

    public void prepare() {
        if (this.chW) {
            if (this.chX) {
                this.chZ.onPrepared();
            } else if (this.chS != null) {
                this.chS.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.chS != null) {
            this.chS.pause();
        }
    }

    public void play() {
        if (this.chS != null) {
            this.chS.start();
        }
    }

    public boolean acC() {
        return this.chS != null && this.chS.acC();
    }

    public View acD() {
        return this.chY;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.chY = this.mRootView.findViewById(b.C0318b.video_splash_clickable);
        this.chT = (FrameLayout) this.mRootView.findViewById(b.C0318b.video_splash_view_fl);
        this.chQ = (RelativeLayout) this.mRootView.findViewById(b.C0318b.video_splash_voice_click);
        e.a(this.chQ, SplashStyleRecorder.SplashElements.VOICE, this.cia);
        this.chR = (ImageView) this.mRootView.findViewById(b.C0318b.iv_video_splash_voice);
        this.chQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.I(TextUtils.equals(a.this.chU, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.chS = new com.baidu.prologue.b.a(this.mActivity);
        this.chS.C(this.chT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, boolean z) {
        if (this.chQ != null && this.chR != null && this.chS != null) {
            this.chU = str;
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
                    this.chQ.setVisibility(8);
                    this.chS.setMute(true);
                    return;
                case 1:
                    this.chQ.setVisibility(0);
                    this.chR.setImageResource(b.a.splash_video_mute);
                    this.chS.setMute(true);
                    if (this.chV != null && z) {
                        this.chV.jE("0");
                        return;
                    }
                    return;
                case 2:
                    this.chQ.setVisibility(0);
                    this.chR.setImageResource(b.a.splash_video_unmute);
                    this.chS.setMute(false);
                    if (this.chV != null && z) {
                        this.chV.jE("1");
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
        if (this.chS != null) {
            this.chS.release();
            this.chS = null;
        }
    }
}
