package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class BdBaseViewPagerContainerHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f13661a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13662b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13663c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f13664d;

    /* renamed from: e  reason: collision with root package name */
    public View f13665e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f13666f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f13662b = null;
        this.f13663c = null;
        this.f13664d = null;
        this.f13665e = null;
        this.f13666f = null;
        this.f13661a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f13662b = (TextView) view.findViewById(R.id.theme_title);
        this.f13663c = (TextView) view.findViewById(R.id.more_textview);
        this.f13664d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f13665e = view.findViewById(R.id.bottom_divider_line);
        this.f13666f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
