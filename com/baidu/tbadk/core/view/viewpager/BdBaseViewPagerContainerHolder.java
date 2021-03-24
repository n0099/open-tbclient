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
    public RelativeLayout f13660a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13661b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13662c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f13663d;

    /* renamed from: e  reason: collision with root package name */
    public View f13664e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f13665f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f13661b = null;
        this.f13662c = null;
        this.f13663d = null;
        this.f13664e = null;
        this.f13665f = null;
        this.f13660a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f13661b = (TextView) view.findViewById(R.id.theme_title);
        this.f13662c = (TextView) view.findViewById(R.id.more_textview);
        this.f13663d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f13664e = view.findViewById(R.id.bottom_divider_line);
        this.f13665f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
