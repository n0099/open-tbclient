package com.baidu.swan.game.ad;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
/* loaded from: classes14.dex */
public class a {
    private TextView dUA;
    private Button dUB;
    private boolean dUC;
    private String dUD;
    private a.InterfaceC0502a dUE;
    private a.d dUF;
    private InterfaceC0501a dUG;
    private boolean dUH;
    private View.OnClickListener dUI;
    private View.OnClickListener dUJ;
    private AdElementInfo dUs;
    private LinearLayout dUt;
    private AdImageVIew dUu;
    private AdImageVIew dUv;
    private RelativeLayout dUw;
    private RelativeLayout dUx;
    private RelativeLayout dUy;
    private TextView dUz;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0501a {
        void aQG();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dUI = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dUE != null) {
                    a.this.dUE.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dUJ = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dUF != null) {
                    a.this.dUF.aV(view);
                }
            }
        };
        this.mContext = context;
        this.dUs = adElementInfo;
        this.dUD = str;
        this.dUC = com.baidu.swan.games.utils.c.aYs().aYt();
        this.dUH = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dUI = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dUE != null) {
                    a.this.dUE.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dUJ = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dUF != null) {
                    a.this.dUF.aV(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0501a interfaceC0501a) {
        this.dUG = interfaceC0501a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dUt = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dUx = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dUu = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dUs != null) {
            this.dUu.setImageUrl(this.dUs.aRx());
        }
        this.dUv = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dUv.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dUw = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dUy = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dUz = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dUA = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dUs != null) {
            this.dUz.setText(this.dUs.getTitle());
            this.dUA.setText(this.dUs.getAppName());
        }
        this.dUB = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dUB.setVisibility(8);
        if (this.dUs != null && this.dUs.getActionType() == 1) {
            this.dUB.setVisibility(0);
            this.dUB.setText(resources.getString(c.g.see_detail));
        }
        if (this.dUs != null && this.dUs.getActionType() == 2) {
            this.dUB.setVisibility(0);
            this.dUB.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dUs == null) {
            this.dUx.setVisibility(8);
            this.dUw.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dUx.setVisibility(0);
        this.dUw.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dUH) {
            this.dUB.setOnClickListener(this.dUJ);
            this.dUt.setOnClickListener(this.dUJ);
        } else {
            this.dUB.setOnClickListener(this.dUI);
            this.dUt.setOnClickListener(this.dUI);
        }
        this.mConvertView.setVisibility(4);
        if (this.dUC) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.k(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aYs().dq(a.this.dUD, "" + System.currentTimeMillis());
                    if (a.this.dUG != null) {
                        a.this.dUG.aQG();
                    }
                    com.baidu.swan.games.view.a.b.dr(a.this.dUH ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void kG(int i) {
        this.mContentWidth = ah.O(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dXI);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dUt.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXJ);
        this.dUx.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dXU), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXV));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dUv.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dUw.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dXP);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXK);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dUz.setLayoutParams(layoutParams2);
        this.dUz.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXM));
        this.dUz.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXL), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXO));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXN);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dUy.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXS);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dXT * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dXQ), -1);
        layoutParams4.addRule(9);
        this.dUA.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dUA.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dXR), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dUB.setTextSize(0, i6);
        this.dUB.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dXW);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i7, i7);
            layoutParams6.addRule(10);
            layoutParams6.addRule(11);
            this.mCloseBtn.setLayoutParams(layoutParams6);
        }
    }

    public void show() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 4) {
            this.mConvertView.setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
            this.mConvertView.setVisibility(0);
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aYs().aYx());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.k(this.mHideRunnable);
    }

    public void a(a.InterfaceC0502a interfaceC0502a) {
        this.dUE = interfaceC0502a;
    }

    public void a(a.d dVar) {
        this.dUF = dVar;
    }
}
