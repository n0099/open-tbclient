package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.q0.r.r.e2;
import c.a.q0.r.r.r0;
import c.a.r0.f0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
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

    /* renamed from: e  reason: collision with root package name */
    public Context f39190e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f39191f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f39192g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f39193h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f39194i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f39195j;
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
            this.f39190e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
            this.f39195j = (ViewGroup) inflate.findViewById(R.id.root_layout);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
            this.f39191f = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.f39192g = (TextView) inflate.findViewById(R.id.link_thread_title);
            this.f39193h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
            this.f39194i = (TextView) inflate.findViewById(R.id.link_thread_url);
            this.k = inflate.findViewById(R.id.link_thread_content);
            this.f39191f.setLongIconSupport(false);
            this.f39191f.setGifIconSupport(false);
            this.f39191f.setRadius(n.f(context, R.dimen.tbds10));
            this.f39191f.setConrers(5);
            b(inflate);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f39195j == null || this.f39191f == null) {
            return;
        }
        int k = (((n.k(this.f39190e) - (n.f(this.f39190e, R.dimen.tbds44) * 2)) - (n.f(getContext(), R.dimen.tbds26) * 2)) - (n.f(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.f39195j.getLayoutParams();
        layoutParams.height = k;
        this.f39195j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f39191f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f39191f.setLayoutParams(layoutParams2);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.f39191f, R.drawable.shape_link_thread_head_bg);
        }
    }

    public void refreshTextView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            m.l(this.f39192g, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f39194i, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f39193h, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public void setData(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, e2Var) == null) {
            if (e2Var != null && e2Var.D0() != null && !c.a.d.f.p.m.isEmpty(e2Var.D0().e())) {
                r0 D0 = e2Var.D0();
                if (!D0.f() && D0.c() != r0.f13362g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.f39191f.setPageId(this.l);
                if (D0.f()) {
                    this.f39194i.setVisibility(0);
                    this.f39192g.setVisibility(8);
                    this.f39193h.setVisibility(8);
                    this.f39194i.setText(D0.e());
                    this.f39191f.reset();
                } else {
                    this.f39194i.setVisibility(8);
                    String d2 = D0.d();
                    String a = D0.a();
                    if (!c.a.d.f.p.m.isEmpty(d2)) {
                        this.f39192g.setText(d2);
                        this.f39192g.setVisibility(0);
                        this.f39193h.setVisibility(8);
                    } else {
                        this.f39192g.setVisibility(8);
                        if (!c.a.d.f.p.m.isEmpty(a)) {
                            this.f39193h.setText(a);
                            this.f39193h.setVisibility(0);
                        } else {
                            this.f39193h.setVisibility(4);
                        }
                    }
                    if (!c.a.d.f.p.m.isEmpty(D0.b())) {
                        this.f39191f.startLoad(D0.b(), 10, false);
                    } else {
                        this.f39191f.reset();
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
