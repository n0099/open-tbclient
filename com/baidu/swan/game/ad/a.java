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
/* loaded from: classes3.dex */
public class a {
    private AdElementInfo dZe;
    private LinearLayout dZf;
    private AdImageVIew dZg;
    private AdImageVIew dZh;
    private RelativeLayout dZi;
    private RelativeLayout dZj;
    private RelativeLayout dZk;
    private TextView dZl;
    private TextView dZm;
    private Button dZn;
    private boolean dZo;
    private String dZp;
    private a.InterfaceC0519a dZq;
    private a.d dZr;
    private InterfaceC0518a dZs;
    private boolean dZt;
    private View.OnClickListener dZu;
    private View.OnClickListener dZv;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0518a {
        void aUz();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dZu = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dZq != null) {
                    a.this.dZq.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dZv = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dZr != null) {
                    a.this.dZr.aV(view);
                }
            }
        };
        this.mContext = context;
        this.dZe = adElementInfo;
        this.dZp = str;
        this.dZo = com.baidu.swan.games.utils.c.bcl().bcm();
        this.dZt = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dZu = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dZq != null) {
                    a.this.dZq.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dZv = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dZr != null) {
                    a.this.dZr.aV(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0518a interfaceC0518a) {
        this.dZs = interfaceC0518a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dZf = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dZj = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dZg = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dZe != null) {
            this.dZg.setImageUrl(this.dZe.aVq());
        }
        this.dZh = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dZh.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dZi = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dZk = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dZl = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dZm = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dZe != null) {
            this.dZl.setText(this.dZe.getTitle());
            this.dZm.setText(this.dZe.getAppName());
        }
        this.dZn = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dZn.setVisibility(8);
        if (this.dZe != null && this.dZe.getActionType() == 1) {
            this.dZn.setVisibility(0);
            this.dZn.setText(resources.getString(c.g.see_detail));
        }
        if (this.dZe != null && this.dZe.getActionType() == 2) {
            this.dZn.setVisibility(0);
            this.dZn.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dZe == null) {
            this.dZj.setVisibility(8);
            this.dZi.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dZj.setVisibility(0);
        this.dZi.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dZt) {
            this.dZn.setOnClickListener(this.dZv);
            this.dZf.setOnClickListener(this.dZv);
        } else {
            this.dZn.setOnClickListener(this.dZu);
            this.dZf.setOnClickListener(this.dZu);
        }
        this.mConvertView.setVisibility(4);
        if (this.dZo) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.k(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.bcl().dr(a.this.dZp, "" + System.currentTimeMillis());
                    if (a.this.dZs != null) {
                        a.this.dZs.aUz();
                    }
                    com.baidu.swan.games.view.a.b.ds(a.this.dZt ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void mm(int i) {
        this.mContentWidth = ah.O(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.ecu);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dZf.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecv);
        this.dZj.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.ecG), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecH));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dZh.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dZi.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.ecB);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecw);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dZl.setLayoutParams(layoutParams2);
        this.dZl.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecy));
        this.dZl.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecx), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecA));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecz);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dZk.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecE);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.ecF * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.ecC), -1);
        layoutParams4.addRule(9);
        this.dZm.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dZm.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.ecD), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dZn.setTextSize(0, i6);
        this.dZn.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ecI);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.bcl().bcq());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.k(this.mHideRunnable);
    }

    public void a(a.InterfaceC0519a interfaceC0519a) {
        this.dZq = interfaceC0519a;
    }

    public void a(a.d dVar) {
        this.dZr = dVar;
    }
}
