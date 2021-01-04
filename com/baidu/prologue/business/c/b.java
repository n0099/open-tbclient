package com.baidu.prologue.business.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.prologue.a.c.g;
import com.baidu.prologue.b;
import com.baidu.prologue.business.b.a;
import com.baidu.prologue.business.data.SplashStyleRecorder;
/* loaded from: classes5.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.ctc;
    private String cuB;
    private ImageView cuk;
    private ImageView cul;
    private RelativeLayout cum;
    private TextView cun;
    private View cuo;
    private TextView cup;
    private TextView cuq;
    private long cus;
    private LinearLayout cuu;
    private long cuy;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View cua = null;
    private T cuj = null;
    private String labelName = "广告";
    private String cuv = "";
    boolean cuc = false;
    private boolean cuw = true;
    private boolean cux = true;
    private long cuz = 0;
    boolean cuA = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.ctf.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.cuj.rg();
                    b.this.ahf();
                    return;
                case 1:
                    b.this.ahi();
                    if (b.DEBUG) {
                        g.ctf.d("SplashAbsBaseViewBuilder", "update countdown");
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.mContext = null;
        this.mInflater = null;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public b<T> a(T t) {
        this.cuj = t;
        if (this.cuj != null) {
            this.cuj.a(this);
        }
        return this;
    }

    public b<T> ej(boolean z) {
        this.cuc = z;
        return this;
    }

    public b<T> kc(String str) {
        this.cuv = str;
        return this;
    }

    public b<T> hs(int i) {
        this.cuy = i;
        return this;
    }

    public b<T> kd(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> ke(String str) {
        this.cuB = str;
        return this;
    }

    public b<T> ek(boolean z) {
        this.cuA = z;
        return this;
    }

    public long ahb() {
        return System.currentTimeMillis() - this.cuz;
    }

    public long ahc() {
        return this.cus;
    }

    public T ahd() {
        return this.cuj;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int agw;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        abn();
        this.cua = agY();
        if (this.cua != null) {
            this.cua.setOnTouchListener(this);
        } else {
            g.ctf.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.cum = (RelativeLayout) this.mRootView.findViewById(b.C0327b.image_logo_view);
        this.cul = (ImageView) this.mRootView.findViewById(b.C0327b.image_logo_img);
        if (this.cuc) {
            if (this.cum != null && (layoutParams = this.cum.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.cuk = (ImageView) this.mRootView.findViewById(b.C0327b.image_small_logo_img);
            if (this.cuk != null && (TextUtils.equals(this.cuv, "0") || TextUtils.equals(this.cuv, "1"))) {
                this.cuk.setVisibility(0);
                ImageView imageView = this.cuk;
                if (TextUtils.equals(this.cuv, "0")) {
                    agw = com.baidu.prologue.a.b.a.ctd.get().agx();
                } else {
                    agw = com.baidu.prologue.a.b.a.ctd.get().agw();
                }
                imageView.setImageResource(agw);
                e.a(this.cuk, SplashStyleRecorder.SplashElements.LOGO, this.cuc);
            }
        } else {
            this.cul.setImageResource(com.baidu.prologue.a.b.a.ctd.get().agy());
        }
        ahe();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.cuj.onAdClick(com.baidu.prologue.business.b.agD().a(this.mRootView, iArr));
            ahf();
        }
        return true;
    }

    protected void ahe() {
        ahh();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.cun = (TextView) this.mRootView.findViewById(b.C0327b.splash_ad_label);
            e.a(this.cun, SplashStyleRecorder.SplashElements.LABEL, this.cuc);
            this.cun.setText(this.labelName);
            this.cun.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.cuj.onAdShow();
    }

    public void ahf() {
        ahg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ahg() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void ahh() {
        this.cup = (TextView) this.mRootView.findViewById(b.C0327b.splash_ad_btn_skip);
        this.cuq = (TextView) this.mRootView.findViewById(b.C0327b.splash_ad_countdown);
        this.cuu = (LinearLayout) this.mRootView.findViewById(b.C0327b.splash_countdown_skip);
        this.cuo = this.mRootView.findViewById(b.C0327b.splash_countdown_skip_click);
        e.a(this.cuo, SplashStyleRecorder.SplashElements.SKIP, this.cuc);
        if (this.cuy <= 0) {
            if ("splash_image".equals(this.cuB)) {
                this.cuy = 3L;
            } else {
                this.cuy = 5L;
            }
        }
        this.cus = this.cuy * 1000;
        if (this.cuw) {
            this.cuu.setVisibility(0);
            this.cuq.setVisibility(0);
            this.cuu.setOnClickListener(this);
            this.cuz = System.currentTimeMillis();
            this.cuq.setText(String.format("%02d", Long.valueOf(this.cus / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.cus);
        }
        if (this.cux) {
            this.cuu.setVisibility(0);
            this.cup.setVisibility(0);
            this.cuu.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahi() {
        if (this.cuq != null) {
            long currentTimeMillis = this.cus - (System.currentTimeMillis() - this.cuz);
            if (currentTimeMillis > 0) {
                this.cuq.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.cuq.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cuu) {
            this.cuj.agH();
            ahf();
        }
    }
}
