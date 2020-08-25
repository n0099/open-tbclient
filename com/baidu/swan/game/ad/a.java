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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
/* loaded from: classes19.dex */
public class a {
    private boolean diA;
    private String diB;
    private a.InterfaceC0478a diC;
    private a.d diD;
    private InterfaceC0477a diE;
    private boolean diF;
    private View.OnClickListener diG;
    private View.OnClickListener diH;
    private AdElementInfo dio;
    private LinearLayout dip;
    private AdImageVIew diq;
    private AdImageVIew dit;
    private RelativeLayout diu;
    private RelativeLayout div;
    private RelativeLayout diw;
    private TextView dix;
    private TextView diy;
    private Button diz;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC0477a {
        void aHU();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.diG = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diC != null) {
                    a.this.diC.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.diH = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diD != null) {
                    a.this.diD.aC(view);
                }
            }
        };
        this.mContext = context;
        this.dio = adElementInfo;
        this.diB = str;
        this.diA = com.baidu.swan.games.utils.c.aPG().aPH();
        this.diF = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.diG = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diC != null) {
                    a.this.diC.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.diH = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diD != null) {
                    a.this.diD.aC(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0477a interfaceC0477a) {
        this.diE = interfaceC0477a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dip = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.div = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.diq = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dio != null) {
            this.diq.setImageUrl(this.dio.aIL());
        }
        this.dit = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dit.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.diu = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.diw = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dix = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.diy = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dio != null) {
            this.dix.setText(this.dio.getTitle());
            this.diy.setText(this.dio.getAppName());
        }
        this.diz = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.diz.setVisibility(8);
        if (this.dio != null && this.dio.getActionType() == 1) {
            this.diz.setVisibility(0);
            this.diz.setText(resources.getString(c.g.see_detail));
        }
        if (this.dio != null && this.dio.getActionType() == 2) {
            this.diz.setVisibility(0);
            this.diz.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dio == null) {
            this.div.setVisibility(8);
            this.diu.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.div.setVisibility(0);
        this.diu.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.diF) {
            this.diz.setOnClickListener(this.diH);
            this.dip.setOnClickListener(this.diH);
        } else {
            this.diz.setOnClickListener(this.diG);
            this.dip.setOnClickListener(this.diG);
        }
        this.mConvertView.setVisibility(4);
        if (this.diA) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.l(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aPG().da(a.this.diB, "" + System.currentTimeMillis());
                    if (a.this.diE != null) {
                        a.this.diE.aHU();
                    }
                    com.baidu.swan.games.view.a.b.db(a.this.diF ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void kH(int i) {
        this.mContentWidth = ah.H(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dlH);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dip.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlI);
        this.div.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dlT), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlU));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dit.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.diu.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dlO);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlJ);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dix.setLayoutParams(layoutParams2);
        this.dix.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlL));
        this.dix.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlK), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlN));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlM);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.diw.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlR);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dlS * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dlP), -1);
        layoutParams4.addRule(9);
        this.diy.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.diy.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dlQ), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.diz.setTextSize(0, i6);
        this.diz.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlV);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aPG().aPL());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.l(this.mHideRunnable);
    }

    public void a(a.InterfaceC0478a interfaceC0478a) {
        this.diC = interfaceC0478a;
    }

    public void a(a.d dVar) {
        this.diD = dVar;
    }
}
