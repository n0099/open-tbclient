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
    private LinearLayout cUA;
    private AdImageVIew cUB;
    private AdImageVIew cUC;
    private RelativeLayout cUD;
    private RelativeLayout cUE;
    private RelativeLayout cUF;
    private TextView cUG;
    private TextView cUH;
    private Button cUI;
    private boolean cUJ;
    private String cUK;
    private a.c cUL;
    private InterfaceC0423a cUM;
    private View.OnClickListener cUN;
    private AdElementInfo cUz;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0423a {
        void awW();
    }

    public a(Context context, AdElementInfo adElementInfo, String str) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cUN = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cUL != null) {
                    a.this.cUL.qh();
                }
            }
        };
        this.mContext = context;
        this.cUz = adElementInfo;
        this.cUK = str;
        this.cUJ = com.baidu.swan.games.utils.c.aDi().aDj();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cUN = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cUL != null) {
                    a.this.cUL.qh();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0423a interfaceC0423a) {
        this.cUM = interfaceC0423a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cUA = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cUE = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cUB = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cUz != null) {
            this.cUB.setImageUrl(this.cUz.axl());
        }
        this.cUC = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cUC.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.cUD = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.cUF = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cUG = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.cUH = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cUz != null) {
            this.cUG.setText(this.cUz.getTitle());
            this.cUH.setText(this.cUz.getAppName());
        }
        this.cUI = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cUI.setVisibility(8);
        if (this.cUz != null && this.cUz.getActionType() == 1) {
            this.cUI.setVisibility(0);
            this.cUI.setText(resources.getString(c.g.see_detail));
        }
        if (this.cUz != null && this.cUz.getActionType() == 2) {
            this.cUI.setVisibility(0);
            this.cUI.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cUz == null) {
            this.cUE.setVisibility(8);
            this.cUD.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cUE.setVisibility(0);
        this.cUD.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.cUI.setOnClickListener(this.cUN);
        this.cUA.setOnClickListener(this.cUN);
        this.mConvertView.setVisibility(4);
        if (this.cUJ) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    aj.o(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aDi().cD(a.this.cUK, "" + System.currentTimeMillis());
                    if (a.this.cUM != null) {
                        a.this.cUM.awW();
                    }
                    com.baidu.swan.games.view.a.b.cE("banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void im(int i) {
        this.mContentWidth = ag.D(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.cWn);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cUA.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWo);
        this.cUE.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.cWz), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWA));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cUC.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.cUD.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.cWu);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWp);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cUG.setLayoutParams(layoutParams2);
        this.cUG.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWr));
        this.cUG.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWq), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWt));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWs);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.cUF.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWx);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.cWy * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cWv), -1);
        layoutParams4.addRule(9);
        this.cUH.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.cUH.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cWw), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cUI.setTextSize(0, i6);
        this.cUI.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cWB);
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
            aj.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aDi().aDn());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        aj.o(this.mHideRunnable);
    }

    public void a(a.c cVar) {
        this.cUL = cVar;
    }
}
