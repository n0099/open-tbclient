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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes11.dex */
public class a {
    private String cgA;
    private a.c cgB;
    private InterfaceC0326a cgC;
    private View.OnClickListener cgD;
    private AdElementInfo cgp;
    private LinearLayout cgq;
    private AdImageVIew cgr;
    private AdImageVIew cgs;
    private RelativeLayout cgt;
    private RelativeLayout cgu;
    private RelativeLayout cgv;
    private TextView cgw;
    private TextView cgx;
    private Button cgy;
    private boolean cgz;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0326a {
        void ajX();
    }

    public a(Context context, AdElementInfo adElementInfo, String str) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cgD = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cgB != null) {
                    a.this.cgB.lg();
                }
            }
        };
        this.mContext = context;
        this.cgp = adElementInfo;
        this.cgA = str;
        this.cgz = com.baidu.swan.games.utils.c.apV().apW();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cgD = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cgB != null) {
                    a.this.cgB.lg();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0326a interfaceC0326a) {
        this.cgC = interfaceC0326a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cgq = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cgu = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cgr = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cgp != null) {
            this.cgr.setImageUrl(this.cgp.getPictureUrl());
        }
        this.cgs = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cgs.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.cgt = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.cgv = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cgw = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.cgx = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cgp != null) {
            this.cgw.setText(this.cgp.getTitle());
            this.cgx.setText(this.cgp.getAppName());
        }
        this.cgy = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cgy.setVisibility(8);
        if (this.cgp != null && this.cgp.getActionType() == 1) {
            this.cgy.setVisibility(0);
            this.cgy.setText(resources.getString(c.g.see_detail));
        }
        if (this.cgp != null && this.cgp.getActionType() == 2) {
            this.cgy.setVisibility(0);
            this.cgy.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cgp == null) {
            this.cgu.setVisibility(8);
            this.cgt.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cgu.setVisibility(0);
        this.cgt.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.cgy.setOnClickListener(this.cgD);
        this.cgq.setOnClickListener(this.cgD);
        this.mConvertView.setVisibility(4);
        if (this.cgz) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ai.k(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.apV().bW(a.this.cgA, "" + System.currentTimeMillis());
                    if (a.this.cgC != null) {
                        a.this.cgC.ajX();
                    }
                    com.baidu.swan.games.view.a.b.bX("banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void hB(int i) {
        this.mContentWidth = af.S(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.cig);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cgq.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cih);
        this.cgu.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.cis), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cit));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cgs.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.cgt.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.cin);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cii);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cgw.setLayoutParams(layoutParams2);
        this.cgw.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cik));
        this.cgw.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cij), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cim));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cil);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.cgv.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciq);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.cir * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cio), -1);
        layoutParams4.addRule(9);
        this.cgx.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.cgx.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cip), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cgy.setTextSize(0, i6);
        this.cgy.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciu);
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
            ai.b(this.mHideRunnable, com.baidu.swan.games.utils.c.apV().aqa());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ai.k(this.mHideRunnable);
    }

    public void a(a.c cVar) {
        this.cgB = cVar;
    }
}
