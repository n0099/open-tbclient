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
/* loaded from: classes5.dex */
public class BdBaseViewPagerContainerHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30321b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30322c;

    /* renamed from: d  reason: collision with root package name */
    public IndicatorView f30323d;

    /* renamed from: e  reason: collision with root package name */
    public View f30324e;

    /* renamed from: f  reason: collision with root package name */
    public BdBaseViewPager f30325f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdBaseViewPagerContainerHolder(View view, Context context) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30321b = null;
        this.f30322c = null;
        this.f30323d = null;
        this.f30324e = null;
        this.f30325f = null;
        this.a = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f0920a3);
        this.f30321b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091f80);
        this.f30322c = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09144e);
        this.f30323d = (IndicatorView) view.findViewById(R.id.obfuscated_res_0x7f091e45);
        this.f30324e = view.findViewById(R.id.obfuscated_res_0x7f0903c2);
        this.f30325f = (BdBaseViewPager) view.findViewById(R.id.obfuscated_res_0x7f09033a);
    }
}
