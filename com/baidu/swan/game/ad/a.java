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
/* loaded from: classes14.dex */
public class a {
    private AdElementInfo dwC;
    private LinearLayout dwD;
    private AdImageVIew dwE;
    private AdImageVIew dwF;
    private RelativeLayout dwG;
    private RelativeLayout dwH;
    private RelativeLayout dwI;
    private TextView dwJ;
    private TextView dwK;
    private Button dwL;
    private boolean dwM;
    private String dwN;
    private a.InterfaceC0490a dwO;
    private a.d dwP;
    private InterfaceC0489a dwQ;
    private boolean dwR;
    private View.OnClickListener dwS;
    private View.OnClickListener dwT;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0489a {
        void aLo();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dwS = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dwO != null) {
                    a.this.dwO.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dwT = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dwP != null) {
                    a.this.dwP.aF(view);
                }
            }
        };
        this.mContext = context;
        this.dwC = adElementInfo;
        this.dwN = str;
        this.dwM = com.baidu.swan.games.utils.c.aTa().aTb();
        this.dwR = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dwS = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dwO != null) {
                    a.this.dwO.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dwT = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dwP != null) {
                    a.this.dwP.aF(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0489a interfaceC0489a) {
        this.dwQ = interfaceC0489a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dwD = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dwH = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dwE = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dwC != null) {
            this.dwE.setImageUrl(this.dwC.aMf());
        }
        this.dwF = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dwF.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dwG = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dwI = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dwJ = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dwK = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dwC != null) {
            this.dwJ.setText(this.dwC.getTitle());
            this.dwK.setText(this.dwC.getAppName());
        }
        this.dwL = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dwL.setVisibility(8);
        if (this.dwC != null && this.dwC.getActionType() == 1) {
            this.dwL.setVisibility(0);
            this.dwL.setText(resources.getString(c.g.see_detail));
        }
        if (this.dwC != null && this.dwC.getActionType() == 2) {
            this.dwL.setVisibility(0);
            this.dwL.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dwC == null) {
            this.dwH.setVisibility(8);
            this.dwG.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dwH.setVisibility(0);
        this.dwG.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dwR) {
            this.dwL.setOnClickListener(this.dwT);
            this.dwD.setOnClickListener(this.dwT);
        } else {
            this.dwL.setOnClickListener(this.dwS);
            this.dwD.setOnClickListener(this.dwS);
        }
        this.mConvertView.setVisibility(4);
        if (this.dwM) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.l(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aTa().df(a.this.dwN, "" + System.currentTimeMillis());
                    if (a.this.dwQ != null) {
                        a.this.dwQ.aLo();
                    }
                    com.baidu.swan.games.view.a.b.dg(a.this.dwR ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void lp(int i) {
        this.mContentWidth = ah.J(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dzS);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dwD.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dzT);
        this.dwH.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dAe), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dAf));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dwF.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dwG.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dzZ);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dzU);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dwJ.setLayoutParams(layoutParams2);
        this.dwJ.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dzW));
        this.dwJ.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dzV), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dzY));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dzX);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dwI.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dAc);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dAd * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dAa), -1);
        layoutParams4.addRule(9);
        this.dwK.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dwK.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dAb), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dwL.setTextSize(0, i6);
        this.dwL.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dAg);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aTa().aTf());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.l(this.mHideRunnable);
    }

    public void a(a.InterfaceC0490a interfaceC0490a) {
        this.dwO = interfaceC0490a;
    }

    public void a(a.d dVar) {
        this.dwP = dVar;
    }
}
