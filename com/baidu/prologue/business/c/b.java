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
    private ImageView bsT;
    private ImageView bsU;
    private RelativeLayout bsV;
    private TextView bsW;
    private View bsX;
    private TextView bsY;
    private TextView bsZ;
    private long bta;
    private LinearLayout btb;
    private long btf;
    private String bti;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bsK = null;
    private T bsS = null;
    private String labelName = "广告";
    private String btc = "";
    boolean bsM = false;
    private boolean btd = true;
    private boolean bte = true;
    private long btg = 0;
    boolean bth = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        f.brS.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bsS.pB();
                    b.this.Mk();
                    return;
                case 1:
                    b.this.Mn();
                    if (b.DEBUG) {
                        f.brS.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.bsS = t;
        if (this.bsS != null) {
            this.bsS.a(this);
        }
        return this;
    }

    public b<T> cG(boolean z) {
        this.bsM = z;
        return this;
    }

    public b<T> fT(String str) {
        this.btc = str;
        return this;
    }

    public b<T> dM(int i) {
        this.btf = i;
        return this;
    }

    public b<T> fU(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> fV(String str) {
        this.bti = str;
        return this;
    }

    public b<T> cH(boolean z) {
        this.bth = z;
        return this;
    }

    public long Mg() {
        return System.currentTimeMillis() - this.btg;
    }

    public long Mh() {
        return this.bta;
    }

    public T Mi() {
        return this.bsS;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int Lz;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Mf();
        this.bsK = Mb();
        if (this.bsK != null) {
            this.bsK.setOnTouchListener(this);
        } else {
            f.brS.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bsV = (RelativeLayout) this.mRootView.findViewById(b.C0194b.image_logo_view);
        this.bsU = (ImageView) this.mRootView.findViewById(b.C0194b.image_logo_img);
        if (this.bsM) {
            if (this.bsV != null && (layoutParams = this.bsV.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bsT = (ImageView) this.mRootView.findViewById(b.C0194b.image_small_logo_img);
            if (this.bsT != null && (TextUtils.equals(this.btc, "0") || TextUtils.equals(this.btc, "1"))) {
                this.bsT.setVisibility(0);
                ImageView imageView = this.bsT;
                if (TextUtils.equals(this.btc, "0")) {
                    Lz = com.baidu.prologue.a.b.a.brQ.get().LA();
                } else {
                    Lz = com.baidu.prologue.a.b.a.brQ.get().Lz();
                }
                imageView.setImageResource(Lz);
                e.a(this.bsT, SplashStyleRecorder.SplashElements.LOGO, this.bsM);
            }
        } else {
            this.bsU.setImageResource(com.baidu.prologue.a.b.a.brQ.get().LB());
        }
        Mj();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bsS.fR(com.baidu.prologue.business.b.LG().a(this.mRootView, iArr));
            Mk();
        }
        return true;
    }

    protected void Mj() {
        Mm();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bsW = (TextView) this.mRootView.findViewById(b.C0194b.splash_ad_label);
            e.a(this.bsW, SplashStyleRecorder.SplashElements.LABEL, this.bsM);
            this.bsW.setText(this.labelName);
            this.bsW.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bsS.onAdShow();
    }

    public void Mk() {
        Ml();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ml() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void Mm() {
        this.bsY = (TextView) this.mRootView.findViewById(b.C0194b.splash_ad_btn_skip);
        this.bsZ = (TextView) this.mRootView.findViewById(b.C0194b.splash_ad_countdown);
        this.btb = (LinearLayout) this.mRootView.findViewById(b.C0194b.splash_countdown_skip);
        this.bsX = this.mRootView.findViewById(b.C0194b.splash_countdown_skip_click);
        e.a(this.bsX, SplashStyleRecorder.SplashElements.SKIP, this.bsM);
        if (this.btf <= 0) {
            if ("splash_image".equals(this.bti)) {
                this.btf = 3L;
            } else {
                this.btf = 5L;
            }
        }
        this.bta = this.btf * 1000;
        if (this.btd) {
            this.btb.setVisibility(0);
            this.bsZ.setVisibility(0);
            this.btb.setOnClickListener(this);
            this.btg = System.currentTimeMillis();
            this.bsZ.setText(String.format("%02d", Long.valueOf(this.bta / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bta);
        }
        if (this.bte) {
            this.btb.setVisibility(0);
            this.bsY.setVisibility(0);
            this.btb.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mn() {
        if (this.bsZ != null) {
            long currentTimeMillis = this.bta - (System.currentTimeMillis() - this.btg);
            if (currentTimeMillis > 0) {
                this.bsZ.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.bsZ.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.btb) {
            this.bsS.LK();
            Mk();
        }
    }
}
