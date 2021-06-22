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
    public RelativeLayout f12684a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12685b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12686c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f12687d;

    /* renamed from: e  reason: collision with root package name */
    public View f12688e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f12689f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f12685b = null;
        this.f12686c = null;
        this.f12687d = null;
        this.f12688e = null;
        this.f12689f = null;
        this.f12684a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f12685b = (TextView) view.findViewById(R.id.theme_title);
        this.f12686c = (TextView) view.findViewById(R.id.more_textview);
        this.f12687d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f12688e = view.findViewById(R.id.bottom_divider_line);
        this.f12689f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
