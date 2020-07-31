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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
/* loaded from: classes9.dex */
public class a {
    private AdElementInfo cZc;
    private LinearLayout cZd;
    private AdImageVIew cZe;
    private AdImageVIew cZf;
    private RelativeLayout cZg;
    private RelativeLayout cZh;
    private RelativeLayout cZi;
    private TextView cZj;
    private TextView cZk;
    private Button cZl;
    private boolean cZm;
    private String cZn;
    private a.InterfaceC0431a cZo;
    private a.d cZp;
    private InterfaceC0430a cZq;
    private boolean cZr;
    private View.OnClickListener cZs;
    private View.OnClickListener cZt;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0430a {
        void azK();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cZs = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cZo != null) {
                    a.this.cZo.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.cZt = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cZp != null) {
                    a.this.cZp.aA(view);
                }
            }
        };
        this.mContext = context;
        this.cZc = adElementInfo;
        this.cZn = str;
        this.cZm = com.baidu.swan.games.utils.c.aGP().aGQ();
        this.cZr = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.cZs = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cZo != null) {
                    a.this.cZo.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.cZt = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cZp != null) {
                    a.this.cZp.aA(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0430a interfaceC0430a) {
        this.cZq = interfaceC0430a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.cZd = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.cZh = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.cZe = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.cZc != null) {
            this.cZe.setImageUrl(this.cZc.aAb());
        }
        this.cZf = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.cZf.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.cZg = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.cZi = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.cZj = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.cZk = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.cZc != null) {
            this.cZj.setText(this.cZc.getTitle());
            this.cZk.setText(this.cZc.getAppName());
        }
        this.cZl = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.cZl.setVisibility(8);
        if (this.cZc != null && this.cZc.getActionType() == 1) {
            this.cZl.setVisibility(0);
            this.cZl.setText(resources.getString(c.g.see_detail));
        }
        if (this.cZc != null && this.cZc.getActionType() == 2) {
            this.cZl.setVisibility(0);
            this.cZl.setText(resources.getString(c.g.down_immediately));
        }
        if (this.cZc == null) {
            this.cZh.setVisibility(8);
            this.cZg.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.cZh.setVisibility(0);
        this.cZg.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.cZr) {
            this.cZl.setOnClickListener(this.cZt);
            this.cZd.setOnClickListener(this.cZt);
        } else {
            this.cZl.setOnClickListener(this.cZs);
            this.cZd.setOnClickListener(this.cZs);
        }
        this.mConvertView.setVisibility(4);
        if (this.cZm) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    al.o(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aGP().cG(a.this.cZn, "" + System.currentTimeMillis());
                    if (a.this.cZq != null) {
                        a.this.cZq.azK();
                    }
                    com.baidu.swan.games.view.a.b.cH(a.this.cZr ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void iA(int i) {
        this.mContentWidth = ai.D(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dbv);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.cZd.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dbw);
        this.cZh.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dbH), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dbI));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.cZf.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.cZg.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dbC);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dbx);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.cZj.setLayoutParams(layoutParams2);
        this.cZj.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dbz));
        this.cZj.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dby), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dbB));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dbA);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.cZi.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dbF);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dbG * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dbD), -1);
        layoutParams4.addRule(9);
        this.cZk.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.cZk.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dbE), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.cZl.setTextSize(0, i6);
        this.cZl.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dbJ);
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
            al.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aGP().aGU());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        al.o(this.mHideRunnable);
    }

    public void a(a.InterfaceC0431a interfaceC0431a) {
        this.cZo = interfaceC0431a;
    }

    public void a(a.d dVar) {
        this.cZp = dVar;
    }
}
