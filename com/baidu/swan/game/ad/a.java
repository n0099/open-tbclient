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
    private boolean cgA;
    private String cgB;
    private a.c cgC;
    private InterfaceC0326a cgD;
    private View.OnClickListener cgE;
    private AdElementInfo cgq;
    private LinearLayout cgr;
    private AdImageVIew cgs;
    private AdImageVIew cgt;
    private RelativeLayout cgu;
    private RelativeLayout cgv;
    private RelativeLayout cgw;
    private TextView cgx;
    private TextView cgy;
    private Button cgz;
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
        this.cgE = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cgC != null) {
                    a.this.cgC.lg();
                }
            }
        };
        this.mContext = context;
        this.cgq = adElementInfo;
        this.cgB = str;
        this.cgA = com.baidu.swan.games.utils.c.apV().apW();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cgE = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cgC != null) {
                    a.this.cgC.lg();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0326a interfaceC0326a) {
        this.cgD = interfaceC0326a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cgr = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cgv = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cgs = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cgq != null) {
            this.cgs.setImageUrl(this.cgq.getPictureUrl());
        }
        this.cgt = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cgt.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.cgu = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.cgw = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cgx = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.cgy = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cgq != null) {
            this.cgx.setText(this.cgq.getTitle());
            this.cgy.setText(this.cgq.getAppName());
        }
        this.cgz = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cgz.setVisibility(8);
        if (this.cgq != null && this.cgq.getActionType() == 1) {
            this.cgz.setVisibility(0);
            this.cgz.setText(resources.getString(c.g.see_detail));
        }
        if (this.cgq != null && this.cgq.getActionType() == 2) {
            this.cgz.setVisibility(0);
            this.cgz.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cgq == null) {
            this.cgv.setVisibility(8);
            this.cgu.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cgv.setVisibility(0);
        this.cgu.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.cgz.setOnClickListener(this.cgE);
        this.cgr.setOnClickListener(this.cgE);
        this.mConvertView.setVisibility(4);
        if (this.cgA) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ai.k(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.apV().bW(a.this.cgB, "" + System.currentTimeMillis());
                    if (a.this.cgD != null) {
                        a.this.cgD.ajX();
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
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.cih);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cgr.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cii);
        this.cgv.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.cit), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciu));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cgt.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.cgu.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.cio);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cij);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cgx.setLayoutParams(layoutParams2);
        this.cgx.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cil));
        this.cgx.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cik), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cin));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cim);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.cgw.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cir);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.cis * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cip), -1);
        layoutParams4.addRule(9);
        this.cgy.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.cgy.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.ciq), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cgz.setTextSize(0, i6);
        this.cgz.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.civ);
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
        this.cgC = cVar;
    }
}
