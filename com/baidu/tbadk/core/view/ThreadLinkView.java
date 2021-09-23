package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.r0;
import c.a.r0.a0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ThreadLinkView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f47949e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f47950f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47951g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47952h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47953i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f47954j;
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
            this.f47949e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
            this.f47954j = (ViewGroup) inflate.findViewById(R.id.root_layout);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
            this.f47950f = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.f47951g = (TextView) inflate.findViewById(R.id.link_thread_title);
            this.f47952h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
            this.f47953i = (TextView) inflate.findViewById(R.id.link_thread_url);
            this.k = inflate.findViewById(R.id.link_thread_content);
            this.f47950f.setLongIconSupport(false);
            this.f47950f.setGifIconSupport(false);
            this.f47950f.setRadius(l.g(context, R.dimen.tbds10));
            this.f47950f.setConrers(5);
            b(inflate);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f47954j == null || this.f47950f == null) {
            return;
        }
        int k = (((l.k(this.f47949e) - (l.g(this.f47949e, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.f47954j.getLayoutParams();
        layoutParams.height = k;
        this.f47954j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f47950f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f47950f.setLayoutParams(layoutParams2);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.f47950f, R.drawable.shape_link_thread_head_bg);
        }
    }

    public void refreshTextView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            m.l(this.f47951g, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f47953i, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f47952h, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) {
            if (d2Var != null && d2Var.B0() != null && !k.isEmpty(d2Var.B0().e())) {
                r0 B0 = d2Var.B0();
                if (!B0.f() && B0.c() != r0.f14291g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.f47950f.setPageId(this.l);
                if (B0.f()) {
                    this.f47953i.setVisibility(0);
                    this.f47951g.setVisibility(8);
                    this.f47952h.setVisibility(8);
                    this.f47953i.setText(B0.e());
                    this.f47950f.reset();
                } else {
                    this.f47953i.setVisibility(8);
                    String d2 = B0.d();
                    String a2 = B0.a();
                    if (!k.isEmpty(d2)) {
                        this.f47951g.setText(d2);
                        this.f47951g.setVisibility(0);
                        this.f47952h.setVisibility(8);
                    } else {
                        this.f47951g.setVisibility(8);
                        if (!k.isEmpty(a2)) {
                            this.f47952h.setText(a2);
                            this.f47952h.setVisibility(0);
                        } else {
                            this.f47952h.setVisibility(4);
                        }
                    }
                    if (!k.isEmpty(B0.b())) {
                        this.f47950f.startLoad(B0.b(), 10, false);
                    } else {
                        this.f47950f.reset();
                    }
                }
                refreshTextView(d2Var.f0());
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
