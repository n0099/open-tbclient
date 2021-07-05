package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.q0;
import d.a.s0.a0.m;
/* loaded from: classes4.dex */
public class ThreadLinkView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f12577e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f12578f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12579g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f12580h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12581i;
    public ViewGroup j;
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
            this.f12577e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
            this.j = (ViewGroup) inflate.findViewById(R.id.root_layout);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
            this.f12578f = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.f12579g = (TextView) inflate.findViewById(R.id.link_thread_title);
            this.f12580h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
            this.f12581i = (TextView) inflate.findViewById(R.id.link_thread_url);
            this.k = inflate.findViewById(R.id.link_thread_content);
            this.f12578f.setLongIconSupport(false);
            this.f12578f.setGifIconSupport(false);
            this.f12578f.setRadius(l.g(context, R.dimen.tbds10));
            this.f12578f.setConrers(5);
            d(inflate);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.f12578f, R.drawable.shape_link_thread_head_bg);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            m.l(this.f12579g, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f12581i, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f12580h, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public final void d(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || this.j == null || this.f12578f == null) {
            return;
        }
        int k = (((l.k(this.f12577e) - (l.g(this.f12577e, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = k;
        this.j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f12578f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f12578f.setLayoutParams(layoutParams2);
    }

    public void setData(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) {
            if (b2Var != null && b2Var.w0() != null && !k.isEmpty(b2Var.w0().e())) {
                q0 w0 = b2Var.w0();
                if (!w0.f() && w0.c() != q0.f56030g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.f12578f.setPageId(this.l);
                if (w0.f()) {
                    this.f12581i.setVisibility(0);
                    this.f12579g.setVisibility(8);
                    this.f12580h.setVisibility(8);
                    this.f12581i.setText(w0.e());
                    this.f12578f.I();
                } else {
                    this.f12581i.setVisibility(8);
                    String d2 = w0.d();
                    String a2 = w0.a();
                    if (!k.isEmpty(d2)) {
                        this.f12579g.setText(d2);
                        this.f12579g.setVisibility(0);
                        this.f12580h.setVisibility(8);
                    } else {
                        this.f12579g.setVisibility(8);
                        if (!k.isEmpty(a2)) {
                            this.f12580h.setText(a2);
                            this.f12580h.setVisibility(0);
                        } else {
                            this.f12580h.setVisibility(4);
                        }
                    }
                    if (!k.isEmpty(w0.b())) {
                        this.f12578f.M(w0.b(), 10, false);
                    } else {
                        this.f12578f.I();
                    }
                }
                c(b2Var.c0());
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
