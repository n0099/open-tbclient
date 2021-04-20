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
    public RelativeLayout f13322a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13323b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13324c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f13325d;

    /* renamed from: e  reason: collision with root package name */
    public View f13326e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f13327f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f13323b = null;
        this.f13324c = null;
        this.f13325d = null;
        this.f13326e = null;
        this.f13327f = null;
        this.f13322a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f13323b = (TextView) view.findViewById(R.id.theme_title);
        this.f13324c = (TextView) view.findViewById(R.id.more_textview);
        this.f13325d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f13326e = view.findViewById(R.id.bottom_divider_line);
        this.f13327f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
