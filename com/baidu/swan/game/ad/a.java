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
    private AdElementInfo dQh;
    private LinearLayout dQi;
    private AdImageVIew dQj;
    private AdImageVIew dQk;
    private RelativeLayout dQl;
    private RelativeLayout dQm;
    private RelativeLayout dQn;
    private TextView dQo;
    private TextView dQp;
    private Button dQq;
    private boolean dQr;
    private String dQs;
    private a.InterfaceC0526a dQt;
    private a.d dQu;
    private InterfaceC0525a dQv;
    private boolean dQw;
    private View.OnClickListener dQx;
    private View.OnClickListener dQy;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0525a {
        void aSf();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dQx = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dQt != null) {
                    a.this.dQt.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dQy = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dQu != null) {
                    a.this.dQu.aM(view);
                }
            }
        };
        this.mContext = context;
        this.dQh = adElementInfo;
        this.dQs = str;
        this.dQr = com.baidu.swan.games.utils.c.aZR().aZS();
        this.dQw = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dQx = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dQt != null) {
                    a.this.dQt.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dQy = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dQu != null) {
                    a.this.dQu.aM(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0525a interfaceC0525a) {
        this.dQv = interfaceC0525a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dQi = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dQm = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dQj = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dQh != null) {
            this.dQj.setImageUrl(this.dQh.aSW());
        }
        this.dQk = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dQk.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dQl = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dQn = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dQo = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dQp = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dQh != null) {
            this.dQo.setText(this.dQh.getTitle());
            this.dQp.setText(this.dQh.getAppName());
        }
        this.dQq = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dQq.setVisibility(8);
        if (this.dQh != null && this.dQh.getActionType() == 1) {
            this.dQq.setVisibility(0);
            this.dQq.setText(resources.getString(c.g.see_detail));
        }
        if (this.dQh != null && this.dQh.getActionType() == 2) {
            this.dQq.setVisibility(0);
            this.dQq.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dQh == null) {
            this.dQm.setVisibility(8);
            this.dQl.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dQm.setVisibility(0);
        this.dQl.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dQw) {
            this.dQq.setOnClickListener(this.dQy);
            this.dQi.setOnClickListener(this.dQy);
        } else {
            this.dQq.setOnClickListener(this.dQx);
            this.dQi.setOnClickListener(this.dQx);
        }
        this.mConvertView.setVisibility(4);
        if (this.dQr) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.l(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aZR().ds(a.this.dQs, "" + System.currentTimeMillis());
                    if (a.this.dQv != null) {
                        a.this.dQv.aSf();
                    }
                    com.baidu.swan.games.view.a.b.dt(a.this.dQw ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void me(int i) {
        this.mContentWidth = ah.M(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dTx);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dQi.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTy);
        this.dQm.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dTJ), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTK));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dQk.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dQl.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dTE);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTz);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dQo.setLayoutParams(layoutParams2);
        this.dQo.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTB));
        this.dQo.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTA), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTD));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTC);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dQn.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTH);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dTI * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dTF), -1);
        layoutParams4.addRule(9);
        this.dQp.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dQp.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dTG), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dQq.setTextSize(0, i6);
        this.dQq.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dTL);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aZR().aZW());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.l(this.mHideRunnable);
    }

    public void a(a.InterfaceC0526a interfaceC0526a) {
        this.dQt = interfaceC0526a;
    }

    public void a(a.d dVar) {
        this.dQu = dVar;
    }
}
