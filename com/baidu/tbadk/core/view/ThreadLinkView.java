package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.t0.s.r.e2;
import c.a.t0.s.r.r0;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.h;
import c.a.u0.g0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ThreadLinkView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f40784e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f40785f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f40786g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f40787h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f40788i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f40789j;
    public View k;
    public BdUniqueId l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadLinkView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.f40784e = context;
            View inflate = LayoutInflater.from(context).inflate(h.link_thread_item, (ViewGroup) this, true);
            this.f40789j = (ViewGroup) inflate.findViewById(g.root_layout);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(g.link_thread_head_img);
            this.f40785f = tbImageView;
            tbImageView.setDefaultBgResource(f.icon_card_url_n);
            this.f40786g = (TextView) inflate.findViewById(g.link_thread_title);
            this.f40787h = (TextView) inflate.findViewById(g.link_thread_abstract);
            this.f40788i = (TextView) inflate.findViewById(g.link_thread_url);
            this.k = inflate.findViewById(g.link_thread_content);
            this.f40785f.setLongIconSupport(false);
            this.f40785f.setGifIconSupport(false);
            this.f40785f.setRadius(n.f(context, e.tbds10));
            this.f40785f.setConrers(5);
            b(inflate);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f40789j == null || this.f40785f == null) {
            return;
        }
        int k = (((n.k(this.f40784e) - (n.f(this.f40784e, e.tbds44) * 2)) - (n.f(getContext(), e.tbds26) * 2)) - (n.f(getContext(), e.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.f40789j.getLayoutParams();
        layoutParams.height = k;
        this.f40789j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f40785f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f40785f.setLayoutParams(layoutParams2);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.k, d.CAM_X0205);
            SkinManager.setBackgroundResource(this.f40785f, f.shape_link_thread_head_bg);
        }
    }

    public void refreshTextView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            m.l(this.f40786g, str, d.CAM_X0107, d.CAM_X0109);
            m.l(this.f40788i, str, d.CAM_X0107, d.CAM_X0109);
            m.l(this.f40787h, str, d.CAM_X0107, d.CAM_X0109);
        }
    }

    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) {
            if (e2Var != null && e2Var.D0() != null && !c.a.d.f.p.m.isEmpty(e2Var.D0().e())) {
                r0 D0 = e2Var.D0();
                if (!D0.f() && D0.c() != r0.f13946g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.f40785f.setPageId(this.l);
                if (D0.f()) {
                    this.f40788i.setVisibility(0);
                    this.f40786g.setVisibility(8);
                    this.f40787h.setVisibility(8);
                    this.f40788i.setText(D0.e());
                    this.f40785f.reset();
                } else {
                    this.f40788i.setVisibility(8);
                    String d2 = D0.d();
                    String a = D0.a();
                    if (!c.a.d.f.p.m.isEmpty(d2)) {
                        this.f40786g.setText(d2);
                        this.f40786g.setVisibility(0);
                        this.f40787h.setVisibility(8);
                    } else {
                        this.f40786g.setVisibility(8);
                        if (!c.a.d.f.p.m.isEmpty(a)) {
                            this.f40787h.setText(a);
                            this.f40787h.setVisibility(0);
                        } else {
                            this.f40787h.setVisibility(4);
                        }
                    }
                    if (!c.a.d.f.p.m.isEmpty(D0.b())) {
                        this.f40785f.startLoad(D0.b(), 10, false);
                    } else {
                        this.f40785f.reset();
                    }
                }
                refreshTextView(e2Var.h0());
                return;
            }
            setVisibility(8);
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.l = bdUniqueId;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
    public ThreadLinkView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
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
