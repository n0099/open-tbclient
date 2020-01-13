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
/* loaded from: classes10.dex */
public class a {
    private AdElementInfo ccj;
    private LinearLayout cck;
    private AdImageVIew ccl;
    private AdImageVIew ccm;
    private RelativeLayout ccn;
    private RelativeLayout cco;
    private RelativeLayout ccp;
    private TextView ccq;
    private TextView ccr;
    private Button cct;
    private boolean ccu;
    private String ccv;
    private a.c ccw;
    private InterfaceC0316a ccx;
    private View.OnClickListener ccy;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0316a {
        void ahH();
    }

    public a(Context context, AdElementInfo adElementInfo, String str) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.ccy = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ccw != null) {
                    a.this.ccw.kR();
                }
            }
        };
        this.mContext = context;
        this.ccj = adElementInfo;
        this.ccv = str;
        this.ccu = com.baidu.swan.games.utils.c.anF().anG();
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.ccy = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ccw != null) {
                    a.this.ccw.kR();
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0316a interfaceC0316a) {
        this.ccx = interfaceC0316a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cck = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cco = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.ccl = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.ccj != null) {
            this.ccl.setImageUrl(this.ccj.getPictureUrl());
        }
        this.ccm = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.ccm.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.ccn = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.ccp = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.ccq = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.ccr = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.ccj != null) {
            this.ccq.setText(this.ccj.getTitle());
            this.ccr.setText(this.ccj.getAppName());
        }
        this.cct = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cct.setVisibility(8);
        if (this.ccj != null && this.ccj.getActionType() == 1) {
            this.cct.setVisibility(0);
            this.cct.setText(resources.getString(c.g.see_detail));
        }
        if (this.ccj != null && this.ccj.getActionType() == 2) {
            this.cct.setVisibility(0);
            this.cct.setText(resources.getString(c.g.down_immediately));
        }
        if (this.ccj == null) {
            this.cco.setVisibility(8);
            this.ccn.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cco.setVisibility(0);
        this.ccn.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        this.cct.setOnClickListener(this.ccy);
        this.cck.setOnClickListener(this.ccy);
        this.mConvertView.setVisibility(4);
        if (this.ccu) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ai.k(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.anF().bN(a.this.ccv, "" + System.currentTimeMillis());
                    if (a.this.ccx != null) {
                        a.this.ccx.ahH();
                    }
                    com.baidu.swan.games.view.a.b.bO("banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void hk(int i) {
        this.mContentWidth = af.S(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.e.d.ceb);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cck.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cec);
        this.cco.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.cen), (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ceo));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.ccm.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.ccn.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.cei);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ced);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.ccq.setLayoutParams(layoutParams2);
        this.ccq.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cef));
        this.ccq.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cee), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ceh));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.ceg);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.ccp.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cel);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.cem * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cej), -1);
        layoutParams4.addRule(9);
        this.ccr.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.ccr.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.cek), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cct.setTextSize(0, i6);
        this.cct.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.e.d.cep);
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
            ai.b(this.mHideRunnable, com.baidu.swan.games.utils.c.anF().anK());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ai.k(this.mHideRunnable);
    }

    public void a(a.c cVar) {
        this.ccw = cVar;
    }
}
