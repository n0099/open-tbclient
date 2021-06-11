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
    public RelativeLayout f12602a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12603b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12604c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f12605d;

    /* renamed from: e  reason: collision with root package name */
    public View f12606e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f12607f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f12603b = null;
        this.f12604c = null;
        this.f12605d = null;
        this.f12606e = null;
        this.f12607f = null;
        this.f12602a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f12603b = (TextView) view.findViewById(R.id.theme_title);
        this.f12604c = (TextView) view.findViewById(R.id.more_textview);
        this.f12605d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f12606e = view.findViewById(R.id.bottom_divider_line);
        this.f12607f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
