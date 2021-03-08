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
    private AdElementInfo dXZ;
    private LinearLayout dYa;
    private AdImageVIew dYb;
    private AdImageVIew dYc;
    private RelativeLayout dYd;
    private RelativeLayout dYe;
    private RelativeLayout dYf;
    private TextView dYg;
    private TextView dYh;
    private Button dYi;
    private boolean dYj;
    private String dYk;
    private a.InterfaceC0505a dYl;
    private a.d dYm;
    private InterfaceC0504a dYn;
    private boolean dYo;
    private View.OnClickListener dYp;
    private View.OnClickListener dYq;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0504a {
        void aRc();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dYp = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dYl != null) {
                    a.this.dYl.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dYq = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dYm != null) {
                    a.this.dYm.aR(view);
                }
            }
        };
        this.mContext = context;
        this.dXZ = adElementInfo;
        this.dYk = str;
        this.dYj = com.baidu.swan.games.utils.c.aYH().aYI();
        this.dYo = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dYp = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dYl != null) {
                    a.this.dYl.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dYq = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dYm != null) {
                    a.this.dYm.aR(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0504a interfaceC0504a) {
        this.dYn = interfaceC0504a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dYa = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dYe = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dYb = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dXZ != null) {
            this.dYb.setImageUrl(this.dXZ.aRQ());
        }
        this.dYc = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dYc.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dYd = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dYf = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dYg = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dYh = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dXZ != null) {
            this.dYg.setText(this.dXZ.getTitle());
            this.dYh.setText(this.dXZ.getAppName());
        }
        this.dYi = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dYi.setVisibility(8);
        if (this.dXZ != null && this.dXZ.getActionType() == 1) {
            this.dYi.setVisibility(0);
            this.dYi.setText(resources.getString(c.g.see_detail));
        }
        if (this.dXZ != null && this.dXZ.getActionType() == 2) {
            this.dYi.setVisibility(0);
            this.dYi.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dXZ == null) {
            this.dYe.setVisibility(8);
            this.dYd.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dYe.setVisibility(0);
        this.dYd.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dYo) {
            this.dYi.setOnClickListener(this.dYq);
            this.dYa.setOnClickListener(this.dYq);
        } else {
            this.dYi.setOnClickListener(this.dYp);
            this.dYa.setOnClickListener(this.dYp);
        }
        this.mConvertView.setVisibility(4);
        if (this.dYj) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.i(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aYH().dk(a.this.dYk, "" + System.currentTimeMillis());
                    if (a.this.dYn != null) {
                        a.this.dYn.aRc();
                    }
                    com.baidu.swan.games.view.a.b.dl(a.this.dYo ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void kK(int i) {
        this.mContentWidth = ah.T(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.ebq);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dYa.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebr);
        this.dYe.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.ebC), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebD));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dYc.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dYd.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.ebx);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebs);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dYg.setLayoutParams(layoutParams2);
        this.dYg.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebu));
        this.dYg.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebt), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebw));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebv);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dYf.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebA);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.ebB * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.eby), -1);
        layoutParams4.addRule(9);
        this.dYh.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dYh.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.ebz), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dYi.setTextSize(0, i6);
        this.dYi.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.ebE);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aYH().aYM());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.i(this.mHideRunnable);
    }

    public void a(a.InterfaceC0505a interfaceC0505a) {
        this.dYl = interfaceC0505a;
    }

    public void a(a.d dVar) {
        this.dYm = dVar;
    }
}
