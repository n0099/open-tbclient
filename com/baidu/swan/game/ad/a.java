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
/* loaded from: classes10.dex */
public class a {
    private RelativeLayout dkA;
    private RelativeLayout dkB;
    private RelativeLayout dkC;
    private TextView dkD;
    private TextView dkE;
    private Button dkF;
    private boolean dkG;
    private String dkH;
    private a.InterfaceC0473a dkI;
    private a.d dkJ;
    private InterfaceC0472a dkK;
    private boolean dkL;
    private View.OnClickListener dkM;
    private View.OnClickListener dkN;
    private AdElementInfo dkw;
    private LinearLayout dkx;
    private AdImageVIew dky;
    private AdImageVIew dkz;
    private ImageView mCloseBtn;
    private int mContentHeight;
    private int mContentWidth;
    public Context mContext;
    private View mConvertView;
    private Runnable mHideRunnable;

    /* renamed from: com.baidu.swan.game.ad.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0472a {
        void aIF();
    }

    public a(Context context, AdElementInfo adElementInfo, String str, boolean z) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dkM = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dkI != null) {
                    a.this.dkI.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dkN = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dkJ != null) {
                    a.this.dkJ.aE(view);
                }
            }
        };
        this.mContext = context;
        this.dkw = adElementInfo;
        this.dkH = str;
        this.dkG = com.baidu.swan.games.utils.c.aQr().aQs();
        this.dkL = z;
        initView();
    }

    public a(Context context) {
        this.mHideRunnable = new Runnable() { // from class: com.baidu.swan.game.ad.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.hide();
            }
        };
        this.dkM = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dkI != null) {
                    a.this.dkI.a(CommandType.BANNER_VIEW, null);
                }
            }
        };
        this.dkN = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dkJ != null) {
                    a.this.dkJ.aE(view);
                }
            }
        };
        this.mContext = context;
        initView();
    }

    public void a(InterfaceC0472a interfaceC0472a) {
        this.dkK = interfaceC0472a;
    }

    private void initView() {
        Resources resources = this.mContext.getResources();
        this.mConvertView = LayoutInflater.from(this.mContext).inflate(c.f.ng_game_banner_ad, (ViewGroup) null);
        this.dkx = (LinearLayout) this.mConvertView.findViewById(c.e.banner_view);
        this.dkB = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_left);
        this.dky = (AdImageVIew) this.mConvertView.findViewById(c.e.banner_w_pic);
        if (this.dkw != null) {
            this.dky.setImageUrl(this.dkw.aJw());
        }
        this.dkz = (AdImageVIew) this.mConvertView.findViewById(c.e.ad_text);
        this.dkz.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.dkA = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_ad_right);
        this.dkC = (RelativeLayout) this.mConvertView.findViewById(c.e.banner_right_bottom);
        this.dkD = (TextView) this.mConvertView.findViewById(c.e.banner_title);
        this.dkE = (TextView) this.mConvertView.findViewById(c.e.banner_app_name);
        if (this.dkw != null) {
            this.dkD.setText(this.dkw.getTitle());
            this.dkE.setText(this.dkw.getAppName());
        }
        this.dkF = (Button) this.mConvertView.findViewById(c.e.banner_ad_act);
        this.dkF.setVisibility(8);
        if (this.dkw != null && this.dkw.getActionType() == 1) {
            this.dkF.setVisibility(0);
            this.dkF.setText(resources.getString(c.g.see_detail));
        }
        if (this.dkw != null && this.dkw.getActionType() == 2) {
            this.dkF.setVisibility(0);
            this.dkF.setText(resources.getString(c.g.down_immediately));
        }
        if (this.dkw == null) {
            this.dkB.setVisibility(8);
            this.dkA.setVisibility(8);
            this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(0);
            return;
        }
        this.dkB.setVisibility(0);
        this.dkA.setVisibility(0);
        this.mConvertView.findViewById(c.e.no_ad_tips).setVisibility(8);
        if (this.dkL) {
            this.dkF.setOnClickListener(this.dkN);
            this.dkx.setOnClickListener(this.dkN);
        } else {
            this.dkF.setOnClickListener(this.dkM);
            this.dkx.setOnClickListener(this.dkM);
        }
        this.mConvertView.setVisibility(4);
        if (this.dkG) {
            this.mCloseBtn = (ImageView) this.mConvertView.findViewById(c.e.close_ad_btn);
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.game.ad.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ak.l(a.this.mHideRunnable);
                    com.baidu.swan.games.utils.c.aQr().da(a.this.dkH, "" + System.currentTimeMillis());
                    if (a.this.dkK != null) {
                        a.this.dkK.aIF();
                    }
                    com.baidu.swan.games.view.a.b.db(a.this.dkL ? "gdtbanner" : "banner", "close");
                }
            });
        }
    }

    public View getConvertView() {
        return this.mConvertView;
    }

    public void kS(int i) {
        this.mContentWidth = ah.H(i);
        this.mContentHeight = (int) (this.mContentWidth / com.baidu.swan.game.ad.d.d.dnN);
        this.mConvertView.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        this.dkx.setLayoutParams(new RelativeLayout.LayoutParams(this.mContentWidth, this.mContentHeight));
        int i2 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dnO);
        this.dkB.setLayoutParams(new LinearLayout.LayoutParams(i2, this.mContentHeight));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.d.d.dnZ), (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.doa));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.dkz.setLayoutParams(layoutParams);
        int i3 = this.mContentWidth - i2;
        this.dkA.setLayoutParams(new LinearLayout.LayoutParams(i3, this.mContentHeight));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.d.d.dnU);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dnP);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.dkD.setLayoutParams(layoutParams2);
        this.dkD.setTextSize(0, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dnR));
        this.dkD.setLineSpacing((int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dnQ), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dnT));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dnS);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.dkC.setLayoutParams(layoutParams3);
        int i5 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dnX);
        int i6 = (int) (com.baidu.swan.game.ad.d.d.dnY * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dnV), -1);
        layoutParams4.addRule(9);
        this.dkE.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.dkE.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.d.d.dnW), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.dkF.setTextSize(0, i6);
        this.dkF.setLayoutParams(layoutParams5);
        if (this.mCloseBtn != null) {
            int i7 = (int) (this.mContentHeight * com.baidu.swan.game.ad.d.d.dob);
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
            ak.c(this.mHideRunnable, com.baidu.swan.games.utils.c.aQr().aQw());
        }
    }

    public void hide() {
        if (this.mConvertView != null && this.mConvertView.getVisibility() == 0) {
            this.mConvertView.setVisibility(4);
        }
        ak.l(this.mHideRunnable);
    }

    public void a(a.InterfaceC0473a interfaceC0473a) {
        this.dkI = interfaceC0473a;
    }

    public void a(a.d dVar) {
        this.dkJ = dVar;
    }
}
