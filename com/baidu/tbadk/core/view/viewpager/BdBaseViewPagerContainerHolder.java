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
    public RelativeLayout f12540a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12541b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12542c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f12543d;

    /* renamed from: e  reason: collision with root package name */
    public View f12544e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f12545f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f12541b = null;
        this.f12542c = null;
        this.f12543d = null;
        this.f12544e = null;
        this.f12545f = null;
        this.f12540a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f12541b = (TextView) view.findViewById(R.id.theme_title);
        this.f12542c = (TextView) view.findViewById(R.id.more_textview);
        this.f12543d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f12544e = view.findViewById(R.id.bottom_divider_line);
        this.f12545f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
