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
    private AdElementInfo cFF;
    private LinearLayout cFG;
    private AdImageVIew cFH;
    private AdImageVIew cFI;
    private RelativeLayout cFJ;
    private RelativeLayout cFK;
    private RelativeLayout cFL;
    private TextView cFM;
    private TextView cFN;
    private Button cFO;
    private boolean cFP;
    private String cFQ;
    private a.c cFR;
    private InterfaceC0377a cFS;
    private View.OnClickListener cFT;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0377a {
        void asi();
    }

    public a(Context context, AdElementInfo adElementInfo, String str) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cFT = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cFR != null) {
                    a.this.cFR.pK();
                }
            }
        };
        this.mContext = context;
        this.cFF = adElementInfo;
        this.cFQ = str;
        this.cFP = com.baidu.swan.games.utils.c.ayk().ayl();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cFT = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cFR != null) {
                    a.this.cFR.pK();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0377a interfaceC0377a) {
        this.cFS = interfaceC0377a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cFG = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cFK = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cFH = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cFF != null) {
            this.cFH.setImageUrl(this.cFF.asy());
        }
        this.cFI = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cFI.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.cFJ = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.cFL = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cFM = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.cFN = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cFF != null) {
            this.cFM.setText(this.cFF.getTitle());
            this.cFN.setText(this.cFF.getAppName());
        }
        this.cFO = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cFO.setVisibility(8);
        if (this.cFF != null && this.cFF.getActionType() == 1) {
            this.cFO.setVisibility(0);
            this.cFO.setText(resources.getString(c.g.see_detail));
        }
        if (this.cFF != null && this.cFF.getActionType() == 2) {
            this.cFO.setVisibility(0);
            this.cFO.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cFF == null) {
            this.cFK.setVisibility(8);
            this.cFJ.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cFK.setVisibility(0);
        this.cFJ.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.cFO.setOnClickListener(this.cFT);
        this.cFG.setOnClickListener(this.cFT);
        this.mConvertView.setVisibility(4);
        if (this.cFP) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ai.n(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.ayk().cg(a.this.cFQ, "" + System.currentTimeMillis());
                    if (a.this.cFS != null) {
                        a.this.cFS.asi();
                    }
                    com.baidu.swan.games.view.a.b.ch("banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void hI(int i) {
        this.mContentWidth = af.C(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.cHt);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cFG.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHu);
        this.cFK.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.cHF), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHG));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cFI.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.cFJ.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.cHA);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHv);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cFM.setLayoutParams(layoutParams2);
        this.cFM.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHx));
        this.cFM.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHw), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHz));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHy);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.cFL.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHD);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.cHE * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cHB), -1);
        layoutParams4.addRule(9);
        this.cFN.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.cFN.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cHC), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cFO.setTextSize(0, i6);
        this.cFO.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHH);
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
            ai.c(this.mHideRunnable, com.baidu.swan.games.utils.c.ayk().ayp());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ai.n(this.mHideRunnable);
    }

    public void a(a.c cVar) {
        this.cFR = cVar;
    }
}
