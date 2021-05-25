package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f12176e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f12177f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12178g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12179h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f12180i;
    public HeadImageView j;
    public TextView k;
    public SmartApp l;
    public String m;
    public String n;
    public String o;

    /* loaded from: classes3.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                return;
            }
            AppletsCellView.this.f12180i.setDefaultBgResource(R.drawable.pic_share_default_applets);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            AppletsCellView.this.f12180i.setDefaultBgResource(R.drawable.pic_share_default_applets);
        }
    }

    public AppletsCellView(Context context) {
        super(context);
        this.f12176e = 3;
        b(context);
    }

    public final void b(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.applets_cell_layout, (ViewGroup) this, true);
        this.f12177f = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.f12178g = (TextView) findViewById(R.id.applets_app_name);
        this.f12179h = (TextView) findViewById(R.id.applets_app_content);
        this.f12180i = (TbImageView) findViewById(R.id.applets_app_img);
        this.j = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.k = (TextView) findViewById(R.id.applets_app_type_name);
        this.f12177f.setIsRound(true);
        this.f12177f.setIsPreDrawBorder(true);
        this.f12177f.setDrawBorder(true);
        this.f12177f.setBorderWidth(l.g(context, R.dimen.tbds1));
        this.f12177f.setDefaultResource(R.color.CAM_X0205);
        this.f12177f.setRadius(l.g(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.f12180i.getLayoutParams();
        layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.f12180i.setLayoutParams(layoutParams);
        this.f12180i.setConrers(15);
        setOnClickListener(this);
        this.j.setIsRound(true);
        this.j.setDrawBorder(false);
        c();
    }

    public void c() {
        this.f12176e = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.f12177f.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
        this.f12177f.setIsNight(this.f12176e == 1);
        SkinManager.setViewTextColor(this.f12178g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f12179h, R.color.CAM_X0105);
        this.f12180i.setIsNight(this.f12176e == 1);
        this.j.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.j.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
        this.j.setIsNight(this.f12176e == 1);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp = this.l;
        if (smartApp == null) {
            return;
        }
        if (!d.a.n0.u.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (StringUtils.isNull(this.l.h5_url)) {
                return;
            }
            d.a.m0.l.a.l(getContext(), this.l.h5_url);
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", this.n).param("tid", this.o).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", this.l.name).param("obj_id", this.l.swan_app_id.longValue()).param("obj_source", this.m).param("obj_param1", this.l.is_game.intValue()));
    }

    public void setData(SmartApp smartApp) {
        if (smartApp == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.l = smartApp;
        this.f12177f.V(smartApp.avatar, 10, false);
        this.f12178g.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.f12179h.setVisibility(8);
        } else {
            this.f12179h.setVisibility(0);
            this.f12179h.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.f12180i.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.f12180i.setEvent(new a());
        this.f12180i.V(smartApp.pic, 10, false);
    }

    public void setForumId(String str) {
        this.n = str;
    }

    public void setFrom(String str) {
        this.m = str;
    }

    public void setThreadId(String str) {
        this.o = str;
    }

    public AppletsCellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12176e = 3;
        b(context);
    }

    public AppletsCellView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f12176e = 3;
        b(context);
    }
}
