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
/* loaded from: classes4.dex */
public class BdBaseViewPagerContainerHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f12766a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f12767b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f12768c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f12769d;

    /* renamed from: e  reason: collision with root package name */
    public View f12770e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f12771f;

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
        this.f12767b = null;
        this.f12768c = null;
        this.f12769d = null;
        this.f12770e = null;
        this.f12771f = null;
        this.f12766a = (RelativeLayout) view.findViewById(R.id.top_area);
        this.f12767b = (TextView) view.findViewById(R.id.theme_title);
        this.f12768c = (TextView) view.findViewById(R.id.more_textview);
        this.f12769d = (IndicatorView) view.findViewById(R.id.tab_indicator);
        this.f12770e = view.findViewById(R.id.bottom_divider_line);
        this.f12771f = (BdBaseViewPager) view.findViewById(R.id.bd_base_view_pager);
    }
}
