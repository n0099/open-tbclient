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
    private LinearLayout cFA;
    private AdImageVIew cFB;
    private AdImageVIew cFC;
    private RelativeLayout cFD;
    private RelativeLayout cFE;
    private RelativeLayout cFF;
    private TextView cFG;
    private TextView cFH;
    private Button cFI;
    private boolean cFJ;
    private String cFK;
    private a.c cFL;
    private InterfaceC0356a cFM;
    private View.OnClickListener cFN;
    private AdElementInfo cFz;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0356a {
        void asj();
    }

    public a(Context context, AdElementInfo adElementInfo, String str) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cFN = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cFL != null) {
                    a.this.cFL.pK();
                }
            }
        };
        this.mContext = context;
        this.cFz = adElementInfo;
        this.cFK = str;
        this.cFJ = com.baidu.swan.games.utils.c.ayk().ayl();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cFN = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cFL != null) {
                    a.this.cFL.pK();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0356a interfaceC0356a) {
        this.cFM = interfaceC0356a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cFA = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cFE = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cFB = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cFz != null) {
            this.cFB.setImageUrl(this.cFz.asz());
        }
        this.cFC = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cFC.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.cFD = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.cFF = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cFG = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.cFH = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cFz != null) {
            this.cFG.setText(this.cFz.getTitle());
            this.cFH.setText(this.cFz.getAppName());
        }
        this.cFI = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cFI.setVisibility(8);
        if (this.cFz != null && this.cFz.getActionType() == 1) {
            this.cFI.setVisibility(0);
            this.cFI.setText(resources.getString(c.g.see_detail));
        }
        if (this.cFz != null && this.cFz.getActionType() == 2) {
            this.cFI.setVisibility(0);
            this.cFI.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cFz == null) {
            this.cFE.setVisibility(8);
            this.cFD.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cFE.setVisibility(0);
        this.cFD.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.cFI.setOnClickListener(this.cFN);
        this.cFA.setOnClickListener(this.cFN);
        this.mConvertView.setVisibility(4);
        if (this.cFJ) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ai.n(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.ayk().cg(a.this.cFK, "" + System.currentTimeMillis());
                    if (a.this.cFM != null) {
                        a.this.cFM.asj();
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
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.cHn);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cFA.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHo);
        this.cFE.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.cHz), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHA));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cFC.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.cFD.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.cHu);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHp);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cFG.setLayoutParams(layoutParams2);
        this.cFG.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHr));
        this.cFG.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHq), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHt));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHs);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.cFF.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHx);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.cHy * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cHv), -1);
        layoutParams4.addRule(9);
        this.cFH.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.cFH.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cHw), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cFI.setTextSize(0, i6);
        this.cFI.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cHB);
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
        this.cFL = cVar;
    }
}
