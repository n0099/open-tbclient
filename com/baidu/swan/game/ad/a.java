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
    private RelativeLayout diA;
    private TextView diB;
    private TextView diC;
    private Button diD;
    private boolean diE;
    private String diF;
    private a.InterfaceC0478a diG;
    private a.d diH;
    private InterfaceC0477a diI;
    private boolean diJ;
    private View.OnClickListener diK;
    private View.OnClickListener diL;
    private AdElementInfo diu;
    private LinearLayout div;
    private AdImageVIew diw;
    private AdImageVIew dix;
    private RelativeLayout diy;
    private RelativeLayout diz;
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
        this.diK = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diG != null) {
                    a.this.diG.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.diL = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diH != null) {
                    a.this.diH.aC(view);
                }
            }
        };
        this.mContext = context;
        this.diu = adElementInfo;
        this.diF = str;
        this.diE = com.baidu.swan.games.utils.c.aPG().aPH();
        this.diJ = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.diK = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diG != null) {
                    a.this.diG.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.diL = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.diH != null) {
                    a.this.diH.aC(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0477a interfaceC0477a) {
        this.diI = interfaceC0477a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.div = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.diz = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.diw = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.diu != null) {
            this.diw.setImageUrl(this.diu.aIL());
        }
        this.dix = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dix.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.diy = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.diA = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.diB = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.diC = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.diu != null) {
            this.diB.setText(this.diu.getTitle());
            this.diC.setText(this.diu.getAppName());
        }
        this.diD = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.diD.setVisibility(8);
        if (this.diu != null && this.diu.getActionType() == 1) {
            this.diD.setVisibility(0);
            this.diD.setText(resources.getString(c.g.see_detail));
        }
        if (this.diu != null && this.diu.getActionType() == 2) {
            this.diD.setVisibility(0);
            this.diD.setText(resources.getString(c.g.down_immediately));
        }
        if (this.diu == null) {
            this.diz.setVisibility(8);
            this.diy.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.diz.setVisibility(0);
        this.diy.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.diJ) {
            this.diD.setOnClickListener(this.diL);
            this.div.setOnClickListener(this.diL);
        } else {
            this.diD.setOnClickListener(this.diK);
            this.div.setOnClickListener(this.diK);
        }
        this.mConvertView.setVisibility(4);
        if (this.diE) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.l(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aPG().da(a.this.diF, "" + System.currentTimeMillis());
                    if (a.this.diI != null) {
                        a.this.diI.aHU();
                    }
                    com.baidu.swan.games.view.a.b.db(a.this.diJ ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void kH(int i) {
        this.mContentWidth = ah.H(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dlL);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.div.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlM);
        this.diz.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dlX), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlY));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dix.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.diy.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dlS);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlN);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.diB.setLayoutParams(layoutParams2);
        this.diB.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlP));
        this.diB.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlO), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlR));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlQ);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.diA.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlV);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dlW * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dlT), -1);
        layoutParams4.addRule(9);
        this.diC.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.diC.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dlU), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.diD.setTextSize(0, i6);
        this.diD.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dlZ);
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
        this.diG = interfaceC0478a;
    }

    public void a(a.d dVar) {
        this.diH = dVar;
    }
}
