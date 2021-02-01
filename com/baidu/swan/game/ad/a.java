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
/* loaded from: classes5.dex */
public class a {
    private AdImageVIew dWA;
    private AdImageVIew dWB;
    private RelativeLayout dWC;
    private RelativeLayout dWD;
    private RelativeLayout dWE;
    private TextView dWF;
    private TextView dWG;
    private Button dWH;
    private boolean dWI;
    private String dWJ;
    private a.InterfaceC0499a dWK;
    private a.d dWL;
    private InterfaceC0498a dWM;
    private boolean dWN;
    private View.OnClickListener dWO;
    private View.OnClickListener dWP;
    private AdElementInfo dWy;
    private LinearLayout dWz;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0498a {
        void aQZ();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dWO = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dWK != null) {
                    a.this.dWK.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dWP = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dWL != null) {
                    a.this.dWL.aR(view);
                }
            }
        };
        this.mContext = context;
        this.dWy = adElementInfo;
        this.dWJ = str;
        this.dWI = com.baidu.swan.games.utils.c.aYE().aYF();
        this.dWN = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dWO = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dWK != null) {
                    a.this.dWK.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dWP = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dWL != null) {
                    a.this.dWL.aR(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0498a interfaceC0498a) {
        this.dWM = interfaceC0498a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dWz = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dWD = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dWA = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dWy != null) {
            this.dWA.setImageUrl(this.dWy.aRN());
        }
        this.dWB = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dWB.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dWC = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dWE = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dWF = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dWG = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dWy != null) {
            this.dWF.setText(this.dWy.getTitle());
            this.dWG.setText(this.dWy.getAppName());
        }
        this.dWH = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dWH.setVisibility(8);
        if (this.dWy != null && this.dWy.getActionType() == 1) {
            this.dWH.setVisibility(0);
            this.dWH.setText(resources.getString(c.g.see_detail));
        }
        if (this.dWy != null && this.dWy.getActionType() == 2) {
            this.dWH.setVisibility(0);
            this.dWH.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dWy == null) {
            this.dWD.setVisibility(8);
            this.dWC.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dWD.setVisibility(0);
        this.dWC.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dWN) {
            this.dWH.setOnClickListener(this.dWP);
            this.dWz.setOnClickListener(this.dWP);
        } else {
            this.dWH.setOnClickListener(this.dWO);
            this.dWz.setOnClickListener(this.dWO);
        }
        this.mConvertView.setVisibility(4);
        if (this.dWI) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.j(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aYE().dk(a.this.dWJ, "" + System.currentTimeMillis());
                    if (a.this.dWM != null) {
                        a.this.dWM.aQZ();
                    }
                    com.baidu.swan.games.view.a.b.dl(a.this.dWN ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void kJ(int i) {
        this.mContentWidth = ah.P(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dZO);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dWz.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dZP);
        this.dWD.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.eaa), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.eab));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dWB.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dWC.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dZV);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dZQ);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dWF.setLayoutParams(layoutParams2);
        this.dWF.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dZS));
        this.dWF.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dZR), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dZU));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dZT);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dWE.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dZY);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dZZ * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dZW), -1);
        layoutParams4.addRule(9);
        this.dWG.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dWG.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dZX), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dWH.setTextSize(0, i6);
        this.dWH.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.eac);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aYE().aYJ());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.j(this.mHideRunnable);
    }

    public void a(a.InterfaceC0499a interfaceC0499a) {
        this.dWK = interfaceC0499a;
    }

    public void a(a.d dVar) {
        this.dWL = dVar;
    }
}
