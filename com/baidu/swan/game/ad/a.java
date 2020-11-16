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
/* loaded from: classes12.dex */
public class a {
    private View.OnClickListener dJA;
    private AdElementInfo dJj;
    private LinearLayout dJk;
    private AdImageVIew dJl;
    private AdImageVIew dJm;
    private RelativeLayout dJn;
    private RelativeLayout dJo;
    private RelativeLayout dJp;
    private TextView dJq;
    private TextView dJr;
    private Button dJs;
    private boolean dJt;
    private String dJu;
    private a.InterfaceC0514a dJv;
    private a.d dJw;
    private InterfaceC0513a dJx;
    private boolean dJy;
    private View.OnClickListener dJz;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC0513a {
        void aPa();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dJz = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dJv != null) {
                    a.this.dJv.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dJA = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dJw != null) {
                    a.this.dJw.aK(view);
                }
            }
        };
        this.mContext = context;
        this.dJj = adElementInfo;
        this.dJu = str;
        this.dJt = com.baidu.swan.games.utils.c.aWM().aWN();
        this.dJy = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dJz = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dJv != null) {
                    a.this.dJv.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dJA = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dJw != null) {
                    a.this.dJw.aK(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0513a interfaceC0513a) {
        this.dJx = interfaceC0513a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dJk = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dJo = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dJl = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dJj != null) {
            this.dJl.setImageUrl(this.dJj.aPR());
        }
        this.dJm = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dJm.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dJn = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dJp = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dJq = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dJr = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dJj != null) {
            this.dJq.setText(this.dJj.getTitle());
            this.dJr.setText(this.dJj.getAppName());
        }
        this.dJs = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dJs.setVisibility(8);
        if (this.dJj != null && this.dJj.getActionType() == 1) {
            this.dJs.setVisibility(0);
            this.dJs.setText(resources.getString(c.g.see_detail));
        }
        if (this.dJj != null && this.dJj.getActionType() == 2) {
            this.dJs.setVisibility(0);
            this.dJs.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dJj == null) {
            this.dJo.setVisibility(8);
            this.dJn.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dJo.setVisibility(0);
        this.dJn.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dJy) {
            this.dJs.setOnClickListener(this.dJA);
            this.dJk.setOnClickListener(this.dJA);
        } else {
            this.dJs.setOnClickListener(this.dJz);
            this.dJk.setOnClickListener(this.dJz);
        }
        this.mConvertView.setVisibility(4);
        if (this.dJt) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.l(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aWM().dl(a.this.dJu, "" + System.currentTimeMillis());
                    if (a.this.dJx != null) {
                        a.this.dJx.aPa();
                    }
                    com.baidu.swan.games.view.a.b.dm(a.this.dJy ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void lG(int i) {
        this.mContentWidth = ah.M(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dMz);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dJk.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dMA);
        this.dJo.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dML), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dMM));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dJm.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dJn.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dMG);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dMB);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dJq.setLayoutParams(layoutParams2);
        this.dJq.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dMD));
        this.dJq.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dMC), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dMF));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dME);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dJp.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dMJ);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dMK * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dMH), -1);
        layoutParams4.addRule(9);
        this.dJr.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dJr.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dMI), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dJs.setTextSize(0, i6);
        this.dJs.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dMN);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aWM().aWR());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.l(this.mHideRunnable);
    }

    public void a(a.InterfaceC0514a interfaceC0514a) {
        this.dJv = interfaceC0514a;
    }

    public void a(a.d dVar) {
        this.dJw = dVar;
    }
}
