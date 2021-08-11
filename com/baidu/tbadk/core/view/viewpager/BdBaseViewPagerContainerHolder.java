package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
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
        this.topArea = (RelativeLayout) view.findViewById(R.id.top_area);
        this.title = (TextView) view.findViewById(R.id.theme_title);
        this.mMoreView = (TextView) view.findViewById(R.id.more_textview);
        this.mIndicatorView = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.divilerLine = view.findViewById(R.id.bottom_divider_line);
        this.mViewPager = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
