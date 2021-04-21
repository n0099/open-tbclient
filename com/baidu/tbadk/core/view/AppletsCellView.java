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
import d.b.c.e.p.l;
import tbclient.SmartApp;
/* loaded from: classes3.dex */
public class AppletsCellView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f13004e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f13005f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13006g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13007h;
    public TbImageView i;
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
            AppletsCellView.this.i.setDefaultBgResource(R.drawable.pic_share_default_applets);
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            AppletsCellView.this.i.setDefaultBgResource(R.drawable.pic_share_default_applets);
        }
    }

    public AppletsCellView(Context context) {
        super(context);
        this.f13004e = 3;
        b(context);
    }

    public final void b(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.applets_cell_layout, (ViewGroup) this, true);
        this.f13005f = (HeadImageView) findViewById(R.id.applets_app_icon);
        this.f13006g = (TextView) findViewById(R.id.applets_app_name);
        this.f13007h = (TextView) findViewById(R.id.applets_app_content);
        this.i = (TbImageView) findViewById(R.id.applets_app_img);
        this.j = (HeadImageView) findViewById(R.id.applets_app_type_icon);
        this.k = (TextView) findViewById(R.id.applets_app_type_name);
        this.f13005f.setIsRound(true);
        this.f13005f.setIsPreDrawBorder(true);
        this.f13005f.setDrawBorder(true);
        this.f13005f.setBorderWidth(l.g(context, R.dimen.tbds1));
        this.f13005f.setDefaultResource(R.color.CAM_X0205);
        this.f13005f.setRadius(l.g(context, R.dimen.ds70));
        ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
        layoutParams.height = ((l.k(getContext()) - l.g(getContext(), R.dimen.tbds130)) * 9) / 16;
        this.i.setLayoutParams(layoutParams);
        this.i.setConrers(15);
        setOnClickListener(this);
        this.j.setIsRound(true);
        this.j.setDrawBorder(false);
        c();
    }

    public void c() {
        this.f13004e = TbadkCoreApplication.getInst().getSkinType();
        SkinManager.setBackgroundResource(this, R.drawable.applets_cell_bg);
        this.f13005f.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
        this.f13005f.setIsNight(this.f13004e == 1);
        SkinManager.setViewTextColor(this.f13006g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f13007h, R.color.CAM_X0105);
        this.i.setIsNight(this.f13004e == 1);
        this.j.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_avatar_smallapp_tie));
        this.j.setBorderColor(SkinManager.getColor(R.color.CAM_X0201));
        this.j.setIsNight(this.f13004e == 1);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0109);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SmartApp smartApp = this.l;
        if (smartApp == null) {
            return;
        }
        if (!d.b.j0.s.a.b(smartApp.id, smartApp.link, "1191003900000000", smartApp.is_game)) {
            if (StringUtils.isNull(this.l.h5_url)) {
                return;
            }
            d.b.i0.l.a.l(getContext(), this.l.h5_url);
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
        this.f13005f.W(smartApp.avatar, 10, false);
        this.f13006g.setText(smartApp.name);
        if (StringUtils.isNull(smartApp._abstract, true)) {
            this.f13007h.setVisibility(8);
        } else {
            this.f13007h.setVisibility(0);
            this.f13007h.setText(smartApp._abstract);
        }
        if (StringUtils.isNull(smartApp.pic, true)) {
            this.i.setDefaultBgResource(R.drawable.pic_share_default_applets);
            return;
        }
        this.i.setEvent(new a());
        this.i.W(smartApp.pic, 10, false);
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
        this.f13004e = 3;
        b(context);
    }

    public AppletsCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13004e = 3;
        b(context);
    }
}
