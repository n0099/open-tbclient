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
    private static final boolean DEBUG = com.baidu.prologue.a.b.a.ctd.get().agp();
    private RelativeLayout ctS;
    private ImageView ctT;
    private com.baidu.prologue.b.a ctU;
    private FrameLayout ctV;
    private String ctW;
    private InterfaceC0328a ctX;
    private boolean ctY = false;
    private boolean ctZ = false;
    private View cua;
    private b cub;
    private boolean cuc;
    private Activity mActivity;
    private View mRootView;

    /* renamed from: com.baidu.prologue.business.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0328a {
        void ka(String str);
    }

    public a(Activity activity) {
        this.mActivity = activity;
        initView();
        initPlayer();
    }

    public void a(File file, String str, b bVar, String str2, InterfaceC0328a interfaceC0328a, final a.InterfaceC0326a interfaceC0326a, boolean z) {
        if (file == null || !file.exists() || !file.isFile()) {
            this.ctY = false;
            interfaceC0326a.hr(4);
            return;
        }
        if (DEBUG) {
            Log.d("SplashVideoDecoration", "begin setupPlayer!");
        }
        this.ctU.a(bVar);
        this.ctU.a(new a.InterfaceC0326a() { // from class: com.baidu.prologue.business.a.a.1
            @Override // com.baidu.prologue.b.a.InterfaceC0326a
            public void hr(int i) {
                if (a.DEBUG) {
                    throw new IllegalStateException("MediaPlayer set video file Error!");
                }
                interfaceC0326a.hr(i);
            }
        });
        this.ctU.a(c.c(file, str));
        this.cub = bVar;
        this.ctX = interfaceC0328a;
        this.cuc = z;
        this.ctW = str2;
        if (TextUtils.equals(str2, "1")) {
            J("1", false);
        } else if (TextUtils.equals(this.ctW, "0")) {
            J("0", false);
        } else {
            J("-1", false);
        }
        this.ctZ = false;
        this.ctY = true;
    }

    public void prepare() {
        if (this.ctY) {
            if (this.ctZ) {
                this.cub.onPrepared();
            } else if (this.ctU != null) {
                this.ctU.prepareAsync();
            }
        }
    }

    public void pause() {
        if (this.ctU != null) {
            this.ctU.pause();
        }
    }

    public void play() {
        if (this.ctU != null) {
            this.ctU.start();
        }
    }

    public boolean agY() {
        return this.ctU != null && this.ctU.agY();
    }

    public View agZ() {
        return this.cua;
    }

    @SuppressLint({"InflateParams"})
    private void initView() {
        this.mRootView = LayoutInflater.from(this.mActivity).inflate(b.c.splash_ad_video_decoration, (ViewGroup) null);
        this.cua = this.mRootView.findViewById(b.C0327b.video_splash_clickable);
        this.ctV = (FrameLayout) this.mRootView.findViewById(b.C0327b.video_splash_view_fl);
        this.ctS = (RelativeLayout) this.mRootView.findViewById(b.C0327b.video_splash_voice_click);
        e.a(this.ctS, SplashStyleRecorder.SplashElements.VOICE, this.cuc);
        this.ctT = (ImageView) this.mRootView.findViewById(b.C0327b.iv_video_splash_voice);
        this.ctS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.prologue.business.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.J(TextUtils.equals(a.this.ctW, "0") ? "1" : "0", true);
            }
        });
    }

    private void initPlayer() {
        this.ctU = new com.baidu.prologue.b.a(this.mActivity);
        this.ctU.B(this.ctV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, boolean z) {
        if (this.ctS != null && this.ctT != null && this.ctU != null) {
            this.ctW = str;
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
                    this.ctS.setVisibility(8);
                    this.ctU.setMute(true);
                    return;
                case 1:
                    this.ctS.setVisibility(0);
                    this.ctT.setImageResource(b.a.splash_video_mute);
                    this.ctU.setMute(true);
                    if (this.ctX != null && z) {
                        this.ctX.ka("0");
                        return;
                    }
                    return;
                case 2:
                    this.ctS.setVisibility(0);
                    this.ctT.setImageResource(b.a.splash_video_unmute);
                    this.ctU.setMute(false);
                    if (this.ctX != null && z) {
                        this.ctX.ka("1");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public View th() {
        return this.mRootView;
    }

    public void release() {
        if (this.ctU != null) {
            this.ctU.release();
            this.ctU = null;
        }
    }
}
