package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.o0.r.r.q0;
import c.a.p0.h0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ThreadLinkView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f30162b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f30163c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f30164d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30165e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f30166f;

    /* renamed from: g  reason: collision with root package name */
    public View f30167g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f30168h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadLinkView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a(context);
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04fb, (ViewGroup) this, true);
            this.f30166f = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091ae5);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091270);
            this.f30162b = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.f30163c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091272);
            this.f30164d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09126d);
            this.f30165e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091273);
            this.f30167g = inflate.findViewById(R.id.obfuscated_res_0x7f09126e);
            this.f30162b.setLongIconSupport(false);
            this.f30162b.setGifIconSupport(false);
            this.f30162b.setRadius(n.f(context, R.dimen.tbds10));
            this.f30162b.setConrers(5);
            d(inflate);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f30167g, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.f30162b, R.drawable.shape_link_thread_head_bg);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            m.l(this.f30163c, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f30165e, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f30164d, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.f30166f == null || this.f30162b == null) {
            return;
        }
        int k = (((n.k(this.a) - (n.f(this.a, R.dimen.tbds44) * 2)) - (n.f(getContext(), R.dimen.tbds26) * 2)) - (n.f(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.f30166f.getLayoutParams();
        layoutParams.height = k;
        this.f30166f.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f30162b.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f30162b.setLayoutParams(layoutParams2);
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            if (threadData != null && threadData.getLinkThreadData() != null && !c.a.d.f.p.m.isEmpty(threadData.getLinkThreadData().e())) {
                q0 linkThreadData = threadData.getLinkThreadData();
                if (!linkThreadData.f() && linkThreadData.c() != q0.f10930g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.f30162b.setPageId(this.f30168h);
                if (linkThreadData.f()) {
                    this.f30165e.setVisibility(0);
                    this.f30163c.setVisibility(8);
                    this.f30164d.setVisibility(8);
                    this.f30165e.setText(linkThreadData.e());
                    this.f30162b.F();
                } else {
                    this.f30165e.setVisibility(8);
                    String d2 = linkThreadData.d();
                    String a = linkThreadData.a();
                    if (!c.a.d.f.p.m.isEmpty(d2)) {
                        this.f30163c.setText(d2);
                        this.f30163c.setVisibility(0);
                        this.f30164d.setVisibility(8);
                    } else {
                        this.f30163c.setVisibility(8);
                        if (!c.a.d.f.p.m.isEmpty(a)) {
                            this.f30164d.setText(a);
                            this.f30164d.setVisibility(0);
                        } else {
                            this.f30164d.setVisibility(4);
                        }
                    }
                    if (!c.a.d.f.p.m.isEmpty(linkThreadData.b())) {
                        this.f30162b.J(linkThreadData.b(), 10, false);
                    } else {
                        this.f30162b.F();
                    }
                }
                c(threadData.getId());
                return;
            }
            setVisibility(8);
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.f30168h = bdUniqueId;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadLinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadLinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a(context);
    }
}
