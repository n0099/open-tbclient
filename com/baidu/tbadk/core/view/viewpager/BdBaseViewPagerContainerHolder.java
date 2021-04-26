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
    public RelativeLayout f13296a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f13297b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f13298c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f13299d;

    /* renamed from: e  reason: collision with root package name */
    public View f13300e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f13301f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f13297b = null;
        this.f13298c = null;
        this.f13299d = null;
        this.f13300e = null;
        this.f13301f = null;
        this.f13296a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f13297b = (TextView) view.findViewById(R.id.theme_title);
        this.f13298c = (TextView) view.findViewById(R.id.more_textview);
        this.f13299d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f13300e = view.findViewById(R.id.bottom_divider_line);
        this.f13301f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
