package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.u0.a4.g;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class BdBaseViewPagerContainerHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View divilerLine;
    public IndicatorView mIndicatorView;
    public TextView mMoreView;
    public BdBaseViewPager mViewPager;
    public int skinType;
    public TextView title;
    public RelativeLayout topArea;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.skinType = 3;
        this.title = null;
        this.mMoreView = null;
        this.mIndicatorView = null;
        this.divilerLine = null;
        this.mViewPager = null;
        this.topArea = (RelativeLayout) view.findViewById(g.top_area);
        this.title = (TextView) view.findViewById(g.theme_title);
        this.mMoreView = (TextView) view.findViewById(g.more_textview);
        this.mIndicatorView = (IndicatorView) view.findViewById(g.tab_indicator);
        this.divilerLine = view.findViewById(g.bottom_divider_line);
        this.mViewPager = (BdBaseViewPager) view.findViewById(g.bd_base_view_pager);
    }
}
