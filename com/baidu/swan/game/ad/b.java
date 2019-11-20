package com.baidu.swan.game.ad;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.b.a;
import com.baidu.swan.game.ad.component.AdImageVIew;
/* loaded from: classes2.dex */
public class b {
    public Context a;
    private com.baidu.swan.game.ad.a.a bvS;
    private AdImageVIew bvT;
    private AdImageVIew bvU;
    private Button bvV;
    private a.c bvW;
    private View c;
    private LinearLayout d;
    private int e;
    private int f;
    private RelativeLayout i;
    private RelativeLayout j;
    private RelativeLayout k;
    private TextView l;
    private TextView m;
    private View.OnClickListener p = new View.OnClickListener() { // from class: com.baidu.swan.game.ad.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.bvW != null) {
                b.this.bvW.b();
            }
        }
    };

    public b(Context context, com.baidu.swan.game.ad.a.a aVar) {
        this.a = context;
        this.bvS = aVar;
        d();
    }

    private void d() {
        Resources resources = this.a.getResources();
        this.c = LayoutInflater.from(this.a).inflate(a.e.ng_game_banner_ad, (ViewGroup) null);
        this.d = (LinearLayout) this.c.findViewById(a.d.banner_view);
        this.j = (RelativeLayout) this.c.findViewById(a.d.banner_ad_left);
        this.bvT = (AdImageVIew) this.c.findViewById(a.d.banner_w_pic);
        this.bvT.setImageUrl(this.bvS.c());
        this.bvU = (AdImageVIew) this.c.findViewById(a.d.ad_text);
        this.bvU.setImageUrl("https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png");
        this.i = (RelativeLayout) this.c.findViewById(a.d.banner_ad_right);
        this.k = (RelativeLayout) this.c.findViewById(a.d.banner_right_bottom);
        this.l = (TextView) this.c.findViewById(a.d.banner_title);
        this.l.setText(this.bvS.a());
        this.m = (TextView) this.c.findViewById(a.d.banner_app_name);
        this.m.setText(this.bvS.h());
        this.bvV = (Button) this.c.findViewById(a.d.banner_ad_act);
        if (this.bvS.g() == 1) {
            this.bvV.setText(resources.getString(a.f.see_detail));
        }
        if (this.bvS.g() == 2) {
            this.bvV.setText(resources.getString(a.f.down_immediately));
        }
        this.bvV.setOnClickListener(this.p);
        this.d.setOnClickListener(this.p);
        this.c.setVisibility(4);
    }

    public View a() {
        return this.c;
    }

    public void a(int i) {
        this.e = z.S(i);
        this.f = (int) (this.e / com.baidu.swan.game.ad.e.d.a);
        this.c.setLayoutParams(new RelativeLayout.LayoutParams(this.e, this.f));
        this.d.setLayoutParams(new RelativeLayout.LayoutParams(this.e, this.f));
        int i2 = (int) (this.f * com.baidu.swan.game.ad.e.d.b);
        this.j.setLayoutParams(new LinearLayout.LayoutParams(i2, this.f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i2 * com.baidu.swan.game.ad.e.d.m), (int) (this.f * com.baidu.swan.game.ad.e.d.n));
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        layoutParams.setMarginStart(0);
        this.bvU.setLayoutParams(layoutParams);
        int i3 = this.e - i2;
        this.i.setLayoutParams(new LinearLayout.LayoutParams(i3, this.f));
        int i4 = (int) (i3 * com.baidu.swan.game.ad.e.d.h);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(9);
        layoutParams2.topMargin = (int) (this.f * com.baidu.swan.game.ad.e.d.c);
        layoutParams2.leftMargin = i4;
        layoutParams2.rightMargin = i4;
        this.l.setLayoutParams(layoutParams2);
        this.l.setTextSize(0, (int) (this.f * com.baidu.swan.game.ad.e.d.e));
        this.l.setLineSpacing((int) (this.f * com.baidu.swan.game.ad.e.d.d), 1.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) (this.f * com.baidu.swan.game.ad.e.d.g));
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = (int) (this.f * com.baidu.swan.game.ad.e.d.f);
        layoutParams3.leftMargin = i4;
        layoutParams3.rightMargin = i4;
        this.k.setLayoutParams(layoutParams3);
        int i5 = (int) (this.f * com.baidu.swan.game.ad.e.d.k);
        int i6 = (int) (com.baidu.swan.game.ad.e.d.l * i5);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.i), -1);
        layoutParams4.addRule(9);
        this.m.setTextSize(0, i6);
        layoutParams4.addRule(15);
        this.m.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (i3 * com.baidu.swan.game.ad.e.d.j), i5);
        layoutParams5.addRule(12);
        layoutParams5.addRule(11);
        this.bvV.setTextSize(0, i6);
        this.bvV.setLayoutParams(layoutParams5);
    }

    public void b() {
        if (this.c != null && this.c.getVisibility() == 4) {
            this.c.setAnimation(AnimationUtils.loadAnimation(this.a, a.C0239a.ng_game_ad_open));
            this.c.setVisibility(0);
        }
    }

    public void c() {
        if (this.c != null && this.c.getVisibility() == 0) {
            this.c.setVisibility(4);
        }
    }

    public void a(a.c cVar) {
        this.bvW = cVar;
    }
}
