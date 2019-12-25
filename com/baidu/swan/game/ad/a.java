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
/* loaded from: classes9.dex */
public class a {
    private AdElementInfo cbX;
    private LinearLayout cbY;
    private AdImageVIew cbZ;
    private AdImageVIew cca;
    private RelativeLayout ccb;
    private RelativeLayout ccc;
    private RelativeLayout ccd;
    private TextView cce;
    private TextView ccf;
    private Button ccg;
    private boolean cch;
    private String cci;
    private a.c ccj;
    private InterfaceC0314a cck;
    private View.OnClickListener ccl;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0314a {
        void aho();
    }

    public a(Context context, AdElementInfo adElementInfo, String str) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.ccl = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ccj != null) {
                    a.this.ccj.kQ();
                }
            }
        };
        this.mContext = context;
        this.cbX = adElementInfo;
        this.cci = str;
        this.cch = com.baidu.swan.games.utils.c.anm().ann();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.ccl = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ccj != null) {
                    a.this.ccj.kQ();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0314a interfaceC0314a) {
        this.cck = interfaceC0314a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cbY = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.ccc = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cbZ = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cbX != null) {
            this.cbZ.setImageUrl(this.cbX.getPictureUrl());
        }
        this.cca = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cca.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.ccb = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.ccd = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cce = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.ccf = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cbX != null) {
            this.cce.setText(this.cbX.getTitle());
            this.ccf.setText(this.cbX.getAppName());
        }
        this.ccg = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.ccg.setVisibility(8);
        if (this.cbX != null && this.cbX.getActionType() == 1) {
            this.ccg.setVisibility(0);
            this.ccg.setText(resources.getString(c.g.see_detail));
        }
        if (this.cbX != null && this.cbX.getActionType() == 2) {
            this.ccg.setVisibility(0);
            this.ccg.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cbX == null) {
            this.ccc.setVisibility(8);
            this.ccb.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.ccc.setVisibility(0);
        this.ccb.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.ccg.setOnClickListener(this.ccl);
        this.cbY.setOnClickListener(this.ccl);
        this.mConvertView.setVisibility(4);
        if (this.cch) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ai.k(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.anm().bM(a.this.cci, "" + System.currentTimeMillis());
                    if (a.this.cck != null) {
                        a.this.cck.aho();
                    }
                    com.baidu.swan.games.view.a.b.bN("banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void hk(int i) {
        this.mContentWidth = af.T(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.cdO);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cbY.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cdP);
        this.ccc.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.cea), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ceb));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cca.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.ccb.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.cdV);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cdQ);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cce.setLayoutParams(layoutParams2);
        this.cce.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cdS));
        this.cce.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cdR), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cdU));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cdT);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.ccd.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cdY);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.cdZ * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cdW), -1);
        layoutParams4.addRule(9);
        this.ccf.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.ccf.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cdX), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.ccg.setTextSize(0, i6);
        this.ccg.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cec);
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
            ai.b(this.mHideRunnable, com.baidu.swan.games.utils.c.anm().anr());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ai.k(this.mHideRunnable);
    }

    public void a(a.c cVar) {
        this.ccj = cVar;
    }
}
