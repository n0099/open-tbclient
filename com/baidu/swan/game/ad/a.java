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
    private AdElementInfo dKR;
    private LinearLayout dKS;
    private AdImageVIew dKT;
    private AdImageVIew dKU;
    private RelativeLayout dKV;
    private RelativeLayout dKW;
    private RelativeLayout dKX;
    private TextView dKY;
    private TextView dKZ;
    private Button dLa;
    private boolean dLb;
    private String dLc;
    private a.InterfaceC0516a dLd;
    private a.d dLe;
    private InterfaceC0515a dLf;
    private boolean dLg;
    private View.OnClickListener dLh;
    private View.OnClickListener dLi;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0515a {
        void aPI();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dLh = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dLd != null) {
                    a.this.dLd.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dLi = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dLe != null) {
                    a.this.dLe.aK(view);
                }
            }
        };
        this.mContext = context;
        this.dKR = adElementInfo;
        this.dLc = str;
        this.dLb = com.baidu.swan.games.utils.c.aXu().aXv();
        this.dLg = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dLh = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dLd != null) {
                    a.this.dLd.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dLi = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dLe != null) {
                    a.this.dLe.aK(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0515a interfaceC0515a) {
        this.dLf = interfaceC0515a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dKS = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dKW = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dKT = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dKR != null) {
            this.dKT.setImageUrl(this.dKR.aQz());
        }
        this.dKU = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dKU.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dKV = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dKX = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dKY = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dKZ = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dKR != null) {
            this.dKY.setText(this.dKR.getTitle());
            this.dKZ.setText(this.dKR.getAppName());
        }
        this.dLa = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dLa.setVisibility(8);
        if (this.dKR != null && this.dKR.getActionType() == 1) {
            this.dLa.setVisibility(0);
            this.dLa.setText(resources.getString(c.g.see_detail));
        }
        if (this.dKR != null && this.dKR.getActionType() == 2) {
            this.dLa.setVisibility(0);
            this.dLa.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dKR == null) {
            this.dKW.setVisibility(8);
            this.dKV.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dKW.setVisibility(0);
        this.dKV.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dLg) {
            this.dLa.setOnClickListener(this.dLi);
            this.dKS.setOnClickListener(this.dLi);
        } else {
            this.dLa.setOnClickListener(this.dLh);
            this.dKS.setOnClickListener(this.dLh);
        }
        this.mConvertView.setVisibility(4);
        if (this.dLb) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.l(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aXu().dm(a.this.dLc, "" + System.currentTimeMillis());
                    if (a.this.dLf != null) {
                        a.this.dLf.aPI();
                    }
                    com.baidu.swan.games.view.a.b.dn(a.this.dLg ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void lK(int i) {
        this.mContentWidth = ah.N(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dOh);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dKS.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOi);
        this.dKW.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dOt), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOu));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dKU.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dKV.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dOo);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOj);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dKY.setLayoutParams(layoutParams2);
        this.dKY.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOl));
        this.dKY.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOk), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOn));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOm);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dKX.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOr);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dOs * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dOp), -1);
        layoutParams4.addRule(9);
        this.dKZ.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dKZ.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dOq), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dLa.setTextSize(0, i6);
        this.dLa.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dOv);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aXu().aXz());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.l(this.mHideRunnable);
    }

    public void a(a.InterfaceC0516a interfaceC0516a) {
        this.dLd = interfaceC0516a;
    }

    public void a(a.d dVar) {
        this.dLe = dVar;
    }
}
