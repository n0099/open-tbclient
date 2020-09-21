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
/* loaded from: classes10.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private long bNC;
    private String bNF;
    private ImageView bNq;
    private ImageView bNr;
    private RelativeLayout bNs;
    private TextView bNt;
    private View bNu;
    private TextView bNv;
    private TextView bNw;
    private long bNx;
    private LinearLayout bNy;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bNg = null;
    private T bNp = null;
    private String labelName = "广告";
    private String bNz = "";
    boolean bNi = false;
    private boolean bNA = true;
    private boolean bNB = true;
    private long bND = 0;
    boolean bNE = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.bMo.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bNp.rD();
                    b.this.Wv();
                    return;
                case 1:
                    b.this.Wy();
                    if (b.DEBUG) {
                        g.bMo.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.bNp = t;
        if (this.bNp != null) {
            this.bNp.a(this);
        }
        return this;
    }

    public b<T> dg(boolean z) {
        this.bNi = z;
        return this;
    }

    public b<T> iz(String str) {
        this.bNz = str;
        return this;
    }

    public b<T> gk(int i) {
        this.bNC = i;
        return this;
    }

    public b<T> iA(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> iB(String str) {
        this.bNF = str;
        return this;
    }

    public b<T> dh(boolean z) {
        this.bNE = z;
        return this;
    }

    public long Wr() {
        return System.currentTimeMillis() - this.bND;
    }

    public long Ws() {
        return this.bNx;
    }

    public T Wt() {
        return this.bNp;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int VL;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        Wq();
        this.bNg = Wn();
        if (this.bNg != null) {
            this.bNg.setOnTouchListener(this);
        } else {
            g.bMo.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bNs = (RelativeLayout) this.mRootView.findViewById(b.C0277b.image_logo_view);
        this.bNr = (ImageView) this.mRootView.findViewById(b.C0277b.image_logo_img);
        if (this.bNi) {
            if (this.bNs != null && (layoutParams = this.bNs.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bNq = (ImageView) this.mRootView.findViewById(b.C0277b.image_small_logo_img);
            if (this.bNq != null && (TextUtils.equals(this.bNz, "0") || TextUtils.equals(this.bNz, "1"))) {
                this.bNq.setVisibility(0);
                ImageView imageView = this.bNq;
                if (TextUtils.equals(this.bNz, "0")) {
                    VL = com.baidu.prologue.a.b.a.bMm.get().VM();
                } else {
                    VL = com.baidu.prologue.a.b.a.bMm.get().VL();
                }
                imageView.setImageResource(VL);
                e.a(this.bNq, SplashStyleRecorder.SplashElements.LOGO, this.bNi);
            }
        } else {
            this.bNr.setImageResource(com.baidu.prologue.a.b.a.bMm.get().VN());
        }
        Wu();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bNp.ix(com.baidu.prologue.business.b.VS().a(this.mRootView, iArr));
            Wv();
        }
        return true;
    }

    protected void Wu() {
        Wx();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bNt = (TextView) this.mRootView.findViewById(b.C0277b.splash_ad_label);
            e.a(this.bNt, SplashStyleRecorder.SplashElements.LABEL, this.bNi);
            this.bNt.setText(this.labelName);
            this.bNt.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bNp.onAdShow();
    }

    public void Wv() {
        Ww();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ww() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void Wx() {
        this.bNv = (TextView) this.mRootView.findViewById(b.C0277b.splash_ad_btn_skip);
        this.bNw = (TextView) this.mRootView.findViewById(b.C0277b.splash_ad_countdown);
        this.bNy = (LinearLayout) this.mRootView.findViewById(b.C0277b.splash_countdown_skip);
        this.bNu = this.mRootView.findViewById(b.C0277b.splash_countdown_skip_click);
        e.a(this.bNu, SplashStyleRecorder.SplashElements.SKIP, this.bNi);
        if (this.bNC <= 0) {
            if ("splash_image".equals(this.bNF)) {
                this.bNC = 3L;
            } else {
                this.bNC = 5L;
            }
        }
        this.bNx = this.bNC * 1000;
        if (this.bNA) {
            this.bNy.setVisibility(0);
            this.bNw.setVisibility(0);
            this.bNy.setOnClickListener(this);
            this.bND = System.currentTimeMillis();
            this.bNw.setText(String.format("%02d", Long.valueOf(this.bNx / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bNx);
        }
        if (this.bNB) {
            this.bNy.setVisibility(0);
            this.bNv.setVisibility(0);
            this.bNy.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wy() {
        if (this.bNw != null) {
            long currentTimeMillis = this.bNx - (System.currentTimeMillis() - this.bND);
            if (currentTimeMillis > 0) {
                this.bNw.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.bNw.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bNy) {
            this.bNp.VW();
            Wv();
        }
    }
}
