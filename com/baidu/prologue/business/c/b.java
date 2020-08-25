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
/* loaded from: classes9.dex */
public abstract class b<T extends com.baidu.prologue.business.b.a> implements View.OnClickListener, View.OnTouchListener, a {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;
    private String bLB;
    private ImageView bLm;
    private ImageView bLn;
    private RelativeLayout bLo;
    private TextView bLp;
    private View bLq;
    private TextView bLr;
    private TextView bLs;
    private long bLt;
    private LinearLayout bLu;
    private long bLy;
    private Context mContext;
    private LayoutInflater mInflater;
    ViewGroup mRootView = null;
    private View bLc = null;
    private T bLl = null;
    private String labelName = "广告";
    private String bLv = "";
    boolean bLe = false;
    private boolean bLw = true;
    private boolean bLx = true;
    private long bLz = 0;
    boolean bLA = false;
    protected Handler mUiHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.prologue.business.c.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (b.DEBUG) {
                        g.bKk.d("SplashAbsBaseViewBuilder", "quit count");
                    }
                    b.this.bLl.ry();
                    b.this.VM();
                    return;
                case 1:
                    b.this.VP();
                    if (b.DEBUG) {
                        g.bKk.d("SplashAbsBaseViewBuilder", "update countdown");
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
        this.bLl = t;
        if (this.bLl != null) {
            this.bLl.a(this);
        }
        return this;
    }

    public b<T> dh(boolean z) {
        this.bLe = z;
        return this;
    }

    /* renamed from: if  reason: not valid java name */
    public b<T> m31if(String str) {
        this.bLv = str;
        return this;
    }

    public b<T> gb(int i) {
        this.bLy = i;
        return this;
    }

    public b<T> ig(String str) {
        this.labelName = str;
        return this;
    }

    public b<T> ih(String str) {
        this.bLB = str;
        return this;
    }

    public b<T> di(boolean z) {
        this.bLA = z;
        return this;
    }

    public long VI() {
        return System.currentTimeMillis() - this.bLz;
    }

    public long VJ() {
        return this.bLt;
    }

    public T VK() {
        return this.bLl;
    }

    @SuppressLint({"ResourceType"})
    public void build() {
        int Vc;
        ViewGroup.LayoutParams layoutParams;
        this.mRootView = (ViewGroup) this.mInflater.inflate(getLayoutId(), (ViewGroup) null, false);
        VH();
        this.bLc = VE();
        if (this.bLc != null) {
            this.bLc.setOnTouchListener(this);
        } else {
            g.bKk.e("SplashAbsBaseViewBuilder", "Splash Ad didn't set up clickable view!");
        }
        this.bLo = (RelativeLayout) this.mRootView.findViewById(b.C0279b.image_logo_view);
        this.bLn = (ImageView) this.mRootView.findViewById(b.C0279b.image_logo_img);
        if (this.bLe) {
            if (this.bLo != null && (layoutParams = this.bLo.getLayoutParams()) != null) {
                layoutParams.height = 0;
            }
            this.bLm = (ImageView) this.mRootView.findViewById(b.C0279b.image_small_logo_img);
            if (this.bLm != null && (TextUtils.equals(this.bLv, "0") || TextUtils.equals(this.bLv, "1"))) {
                this.bLm.setVisibility(0);
                ImageView imageView = this.bLm;
                if (TextUtils.equals(this.bLv, "0")) {
                    Vc = com.baidu.prologue.a.b.a.bKi.get().Vd();
                } else {
                    Vc = com.baidu.prologue.a.b.a.bKi.get().Vc();
                }
                imageView.setImageResource(Vc);
                e.a(this.bLm, SplashStyleRecorder.SplashElements.LOGO, this.bLe);
            }
        } else {
            this.bLn.setImageResource(com.baidu.prologue.a.b.a.bKi.get().Ve());
        }
        VL();
        onAdShow();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            int[] iArr = {0, 0};
            iArr[1] = (int) motionEvent.getRawY();
            iArr[0] = (int) motionEvent.getRawX();
            this.bLl.id(com.baidu.prologue.business.b.Vj().a(this.mRootView, iArr));
            VM();
        }
        return true;
    }

    protected void VL() {
        VO();
        if (!TextUtils.isEmpty(this.labelName)) {
            this.bLp = (TextView) this.mRootView.findViewById(b.C0279b.splash_ad_label);
            e.a(this.bLp, SplashStyleRecorder.SplashElements.LABEL, this.bLe);
            this.bLp.setText(this.labelName);
            this.bLp.setVisibility(0);
        }
    }

    protected void onAdShow() {
        this.bLl.onAdShow();
    }

    public void VM() {
        VN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void VN() {
        if (this.mUiHandler != null) {
            this.mUiHandler.removeCallbacksAndMessages(null);
        }
    }

    protected void VO() {
        this.bLr = (TextView) this.mRootView.findViewById(b.C0279b.splash_ad_btn_skip);
        this.bLs = (TextView) this.mRootView.findViewById(b.C0279b.splash_ad_countdown);
        this.bLu = (LinearLayout) this.mRootView.findViewById(b.C0279b.splash_countdown_skip);
        this.bLq = this.mRootView.findViewById(b.C0279b.splash_countdown_skip_click);
        e.a(this.bLq, SplashStyleRecorder.SplashElements.SKIP, this.bLe);
        if (this.bLy <= 0) {
            if ("splash_image".equals(this.bLB)) {
                this.bLy = 3L;
            } else {
                this.bLy = 5L;
            }
        }
        this.bLt = this.bLy * 1000;
        if (this.bLw) {
            this.bLu.setVisibility(0);
            this.bLs.setVisibility(0);
            this.bLu.setOnClickListener(this);
            this.bLz = System.currentTimeMillis();
            this.bLs.setText(String.format("%02d", Long.valueOf(this.bLt / 1000)));
            this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
        } else {
            this.mUiHandler.sendEmptyMessageDelayed(0, this.bLt);
        }
        if (this.bLx) {
            this.bLu.setVisibility(0);
            this.bLr.setVisibility(0);
            this.bLu.setOnClickListener(this);
        }
    }

    public View getRootView() {
        if (this.mRootView == null) {
            build();
        }
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VP() {
        if (this.bLs != null) {
            long currentTimeMillis = this.bLt - (System.currentTimeMillis() - this.bLz);
            if (currentTimeMillis > 0) {
                this.bLs.setText(String.format("%02d", Long.valueOf((currentTimeMillis / 1000) + 1)));
                this.mUiHandler.sendEmptyMessageDelayed(1, 250L);
            } else {
                this.mUiHandler.sendEmptyMessage(0);
            }
            this.bLs.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bLu) {
            this.bLl.Vn();
            VM();
        }
    }
}
