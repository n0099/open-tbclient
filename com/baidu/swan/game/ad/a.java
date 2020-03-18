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
    private AdElementInfo cgB;
    private LinearLayout cgC;
    private AdImageVIew cgD;
    private AdImageVIew cgE;
    private RelativeLayout cgF;
    private RelativeLayout cgG;
    private RelativeLayout cgH;
    private TextView cgI;
    private TextView cgJ;
    private Button cgK;
    private boolean cgL;
    private String cgM;
    private a.c cgN;
    private InterfaceC0326a cgO;
    private View.OnClickListener cgP;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0326a {
        void aka();
    }

    public a(Context context, AdElementInfo adElementInfo, String str) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cgP = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cgN != null) {
                    a.this.cgN.lg();
                }
            }
        };
        this.mContext = context;
        this.cgB = adElementInfo;
        this.cgM = str;
        this.cgL = com.baidu.swan.games.utils.c.apY().apZ();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cgP = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cgN != null) {
                    a.this.cgN.lg();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0326a interfaceC0326a) {
        this.cgO = interfaceC0326a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cgC = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cgG = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cgD = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cgB != null) {
            this.cgD.setImageUrl(this.cgB.getPictureUrl());
        }
        this.cgE = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cgE.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.cgF = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.cgH = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cgI = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.cgJ = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cgB != null) {
            this.cgI.setText(this.cgB.getTitle());
            this.cgJ.setText(this.cgB.getAppName());
        }
        this.cgK = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cgK.setVisibility(8);
        if (this.cgB != null && this.cgB.getActionType() == 1) {
            this.cgK.setVisibility(0);
            this.cgK.setText(resources.getString(c.g.see_detail));
        }
        if (this.cgB != null && this.cgB.getActionType() == 2) {
            this.cgK.setVisibility(0);
            this.cgK.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cgB == null) {
            this.cgG.setVisibility(8);
            this.cgF.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cgG.setVisibility(0);
        this.cgF.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.cgK.setOnClickListener(this.cgP);
        this.cgC.setOnClickListener(this.cgP);
        this.mConvertView.setVisibility(4);
        if (this.cgL) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ai.k(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.apY().bV(a.this.cgM, "" + System.currentTimeMillis());
                    if (a.this.cgO != null) {
                        a.this.cgO.aka();
                    }
                    com.baidu.swan.games.view.a.b.bW("banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void hB(int i) {
        this.mContentWidth = af.S(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.cis);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cgC.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cit);
        this.cgG.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.ciE), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciF));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cgE.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.cgF.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.ciz);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciu);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cgI.setLayoutParams(layoutParams2);
        this.cgI.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciw));
        this.cgI.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.civ), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciy));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cix);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.cgH.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciC);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.ciD * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.ciA), -1);
        layoutParams4.addRule(9);
        this.cgJ.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.cgJ.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.ciB), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cgK.setTextSize(0, i6);
        this.cgK.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ciG);
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
            ai.b(this.mHideRunnable, com.baidu.swan.games.utils.c.apY().aqd());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ai.k(this.mHideRunnable);
    }

    public void a(a.c cVar) {
        this.cgN = cVar;
    }
}
