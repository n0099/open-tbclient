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
    public RelativeLayout f12632a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12633b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12634c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f12635d;

    /* renamed from: e  reason: collision with root package name */
    public View f12636e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f12637f;

    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        this.f12633b = null;
        this.f12634c = null;
        this.f12635d = null;
        this.f12636e = null;
        this.f12637f = null;
        this.f12632a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f12633b = (TextView) view.findViewById(R.id.theme_title);
        this.f12634c = (TextView) view.findViewById(R.id.more_textview);
        this.f12635d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f12636e = view.findViewById(R.id.bottom_divider_line);
        this.f12637f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
