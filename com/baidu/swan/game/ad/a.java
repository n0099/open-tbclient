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
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes11.dex */
public class a {
    private AdElementInfo cPP;
    private LinearLayout cPQ;
    private AdImageVIew cPR;
    private AdImageVIew cPS;
    private RelativeLayout cPT;
    private RelativeLayout cPU;
    private RelativeLayout cPV;
    private TextView cPW;
    private TextView cPX;
    private Button cPY;
    private boolean cPZ;
    private String cQa;
    private a.c cQb;
    private InterfaceC0417a cQc;
    private View.OnClickListener cQd;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0417a {
        void avQ();
    }

    public a(Context context, AdElementInfo adElementInfo, String str) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cQd = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cQb != null) {
                    a.this.cQb.pQ();
                }
            }
        };
        this.mContext = context;
        this.cPP = adElementInfo;
        this.cQa = str;
        this.cPZ = com.baidu.swan.games.utils.c.aCc().aCd();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cQd = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cQb != null) {
                    a.this.cQb.pQ();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0417a interfaceC0417a) {
        this.cQc = interfaceC0417a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cPQ = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cPU = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cPR = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cPP != null) {
            this.cPR.setImageUrl(this.cPP.awf());
        }
        this.cPS = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cPS.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.cPT = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.cPV = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cPW = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.cPX = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cPP != null) {
            this.cPW.setText(this.cPP.getTitle());
            this.cPX.setText(this.cPP.getAppName());
        }
        this.cPY = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cPY.setVisibility(8);
        if (this.cPP != null && this.cPP.getActionType() == 1) {
            this.cPY.setVisibility(0);
            this.cPY.setText(resources.getString(c.g.see_detail));
        }
        if (this.cPP != null && this.cPP.getActionType() == 2) {
            this.cPY.setVisibility(0);
            this.cPY.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cPP == null) {
            this.cPU.setVisibility(8);
            this.cPT.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cPU.setVisibility(0);
        this.cPT.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.cPY.setOnClickListener(this.cQd);
        this.cPQ.setOnClickListener(this.cQd);
        this.mConvertView.setVisibility(4);
        if (this.cPZ) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aj.o(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aCc().cB(a.this.cQa, "" + System.currentTimeMillis());
                    if (a.this.cQc != null) {
                        a.this.cQc.avQ();
                    }
                    com.baidu.swan.games.view.a.b.cC("banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void hZ(int i) {
        this.mContentWidth = ag.B(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.cRD);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cPQ.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRE);
        this.cPU.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.cRP), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRQ));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cPS.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.cPT.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.cRK);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRF);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cPW.setLayoutParams(layoutParams2);
        this.cPW.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRH));
        this.cPW.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRG), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRJ));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRI);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.cPV.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRN);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.cRO * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cRL), -1);
        layoutParams4.addRule(9);
        this.cPX.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.cPX.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cRM), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cPY.setTextSize(0, i6);
        this.cPY.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cRR);
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
            aj.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aCc().aCh());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        aj.o(this.mHideRunnable);
    }

    public void a(a.c cVar) {
        this.cQb = cVar;
    }
}
