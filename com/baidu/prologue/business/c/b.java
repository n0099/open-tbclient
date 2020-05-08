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
import com.baidu.prologue.a.c.f;
import com.baidu.prologue.b;
import com.baidu.prologue.business.b.a;
import com.baidu.prologue.business.data.SplashStyleRecorder;
/* loaded from: classes6.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private ImageView bsX;
    private ImageView bsY;
    private RelativeLayout bsZ;
    private TextView bta;
    private View btb;
    private TextView btc;
    private TextView btd;
    private long bte;
    private LinearLayout btf;
    private long btj;
    private String btm;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bsO = null;
    private T bsW = null;
    private String labelName = "广告";
    private String btg = "";
    boolean bsQ = false;
    private boolean bth = true;
    private boolean bti = true;
    private long btk = 0;
    boolean btl = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        f.brW.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bsW.pB();
                    b.this.Mj();
                    return;
                case 1:
                    b.this.Mm();
                    if (b.DEBUG) {
                        f.brW.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.bsW = t;
        if (this.bsW != null) {
            this.bsW.a(this);
        }
        return this;
    }

    public b<T> cG(boolean z) {
        this.bsQ = z;
        return this;
    }

    public b<T> fT(String str) {
        this.btg = str;
        return this;
    }

    public b<T> dM(int i) {
        this.btj = i;
        return this;
    }

    public b<T> fU(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> fV(String str) {
        this.btm = str;
        return this;
    }

    public b<T> cH(boolean z) {
        this.btl = z;
        return this;
    }

    public long Mf() {
        return System.currentTimeMillis() - this.btk;
    }

    public long Mg() {
        return this.bte;
    }

    public T Mh() {
        return this.bsW;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int Ly;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Me();
        this.bsO = Ma();
        if (this.bsO != null) {
            this.bsO.setOnTouchListener(this);
        } else {
            f.brW.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bsZ = (RelativeLayout) this.mRootView.findViewById(b.C0216b.image_logo_view);
        this.bsY = (ImageView) this.mRootView.findViewById(b.C0216b.image_logo_img);
        if (this.bsQ) {
            if (this.bsZ != null && (layoutParams = this.bsZ.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bsX = (ImageView) this.mRootView.findViewById(b.C0216b.image_small_logo_img);
            if (this.bsX != null && (TextUtils.equals(this.btg, "0") || TextUtils.equals(this.btg, "1"))) {
                this.bsX.setVisibility(0);
                ImageView imageView = this.bsX;
                if (TextUtils.equals(this.btg, "0")) {
                    Ly = com.baidu.prologue.a.b.a.brU.get().Lz();
                } else {
                    Ly = com.baidu.prologue.a.b.a.brU.get().Ly();
                }
                imageView.setImageResource(Ly);
                e.a(this.bsX, SplashStyleRecorder.SplashElements.LOGO, this.bsQ);
            }
        } else {
            this.bsY.setImageResource(com.baidu.prologue.a.b.a.brU.get().LA());
        }
        Mi();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bsW.fR(com.baidu.prologue.business.b.LF().a(this.mRootView, iArr));
            Mj();
        }
        return true;
    }

    protected void Mi() {
        Ml();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bta = (TextView) this.mRootView.findViewById(b.C0216b.splash_ad_label);
            e.a(this.bta, SplashStyleRecorder.SplashElements.LABEL, this.bsQ);
            this.bta.setText(this.labelName);
            this.bta.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bsW.onAdShow();
    }

    public void Mj() {
        Mk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Mk() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void Ml() {
        this.btc = (TextView) this.mRootView.findViewById(b.C0216b.splash_ad_btn_skip);
        this.btd = (TextView) this.mRootView.findViewById(b.C0216b.splash_ad_countdown);
        this.btf = (LinearLayout) this.mRootView.findViewById(b.C0216b.splash_countdown_skip);
        this.btb = this.mRootView.findViewById(b.C0216b.splash_countdown_skip_click);
        e.a(this.btb, SplashStyleRecorder.SplashElements.SKIP, this.bsQ);
        if (this.btj <= 0) {
            if ("splash_image".equals(this.btm)) {
                this.btj = 3L;
            } else {
                this.btj = 5L;
            }
        }
        this.bte = this.btj * 1000;
        if (this.bth) {
            this.btf.setVisibility(0);
            this.btd.setVisibility(0);
            this.btf.setOnClickListener(this);
            this.btk = System.currentTimeMillis();
            this.btd.setText(String.format("%02d", Long.valueOf(this.bte / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bte);
        }
        if (this.bti) {
            this.btf.setVisibility(0);
            this.btc.setVisibility(0);
            this.btf.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mm() {
        if (this.btd != null) {
            long currentTimeMillis = this.bte - (System.currentTimeMillis() - this.btk);
            if (currentTimeMillis > 0) {
                this.btd.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.btd.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btf) {
            this.bsW.LJ();
            Mj();
        }
    }
}
