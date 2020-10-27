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
    private AdElementInfo dEZ;
    private LinearLayout dFa;
    private AdImageVIew dFb;
    private AdImageVIew dFc;
    private RelativeLayout dFd;
    private RelativeLayout dFe;
    private RelativeLayout dFf;
    private TextView dFg;
    private TextView dFh;
    private Button dFi;
    private boolean dFj;
    private String dFk;
    private a.InterfaceC0504a dFl;
    private a.d dFm;
    private InterfaceC0503a dFn;
    private boolean dFo;
    private View.OnClickListener dFp;
    private View.OnClickListener dFq;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0503a {
        void aNi();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dFp = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dFl != null) {
                    a.this.dFl.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dFq = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dFm != null) {
                    a.this.dFm.aG(view);
                }
            }
        };
        this.mContext = context;
        this.dEZ = adElementInfo;
        this.dFk = str;
        this.dFj = com.baidu.swan.games.utils.c.aUU().aUV();
        this.dFo = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dFp = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dFl != null) {
                    a.this.dFl.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dFq = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dFm != null) {
                    a.this.dFm.aG(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0503a interfaceC0503a) {
        this.dFn = interfaceC0503a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dFa = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dFe = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dFb = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dEZ != null) {
            this.dFb.setImageUrl(this.dEZ.aNZ());
        }
        this.dFc = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dFc.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dFd = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dFf = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dFg = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dFh = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dEZ != null) {
            this.dFg.setText(this.dEZ.getTitle());
            this.dFh.setText(this.dEZ.getAppName());
        }
        this.dFi = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dFi.setVisibility(8);
        if (this.dEZ != null && this.dEZ.getActionType() == 1) {
            this.dFi.setVisibility(0);
            this.dFi.setText(resources.getString(c.g.see_detail));
        }
        if (this.dEZ != null && this.dEZ.getActionType() == 2) {
            this.dFi.setVisibility(0);
            this.dFi.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dEZ == null) {
            this.dFe.setVisibility(8);
            this.dFd.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dFe.setVisibility(0);
        this.dFd.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dFo) {
            this.dFi.setOnClickListener(this.dFq);
            this.dFa.setOnClickListener(this.dFq);
        } else {
            this.dFi.setOnClickListener(this.dFp);
            this.dFa.setOnClickListener(this.dFp);
        }
        this.mConvertView.setVisibility(4);
        if (this.dFj) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.l(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aUU().dm(a.this.dFk, "" + System.currentTimeMillis());
                    if (a.this.dFn != null) {
                        a.this.dFn.aNi();
                    }
                    com.baidu.swan.games.view.a.b.dn(a.this.dFo ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void lA(int i) {
        this.mContentWidth = ah.L(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dIp);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dFa.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dIq);
        this.dFe.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dIB), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dIC));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dFc.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dFd.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dIw);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dIr);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dFg.setLayoutParams(layoutParams2);
        this.dFg.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dIt));
        this.dFg.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dIs), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dIv));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dIu);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dFf.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dIz);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dIA * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dIx), -1);
        layoutParams4.addRule(9);
        this.dFh.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dFh.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dIy), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dFi.setTextSize(0, i6);
        this.dFi.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dID);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aUU().aUZ());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.l(this.mHideRunnable);
    }

    public void a(a.InterfaceC0504a interfaceC0504a) {
        this.dFl = interfaceC0504a;
    }

    public void a(a.d dVar) {
        this.dFm = dVar;
    }
}
