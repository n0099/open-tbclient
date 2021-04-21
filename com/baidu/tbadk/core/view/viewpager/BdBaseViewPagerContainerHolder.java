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
    public RelativeLayout f13330a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13331b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13332c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f13333d;

    /* renamed from: e  reason: collision with root package name */
    public View f13334e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f13335f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f13331b = null;
        this.f13332c = null;
        this.f13333d = null;
        this.f13334e = null;
        this.f13335f = null;
        this.f13330a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f13331b = (TextView) view.findViewById(R.id.theme_title);
        this.f13332c = (TextView) view.findViewById(R.id.more_textview);
        this.f13333d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f13334e = view.findViewById(R.id.bottom_divider_line);
        this.f13335f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
