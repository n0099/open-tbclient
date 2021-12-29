package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.s0.s.q.d2;
import c.a.s0.s.q.r0;
import c.a.t0.g0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class ThreadLinkView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f41984e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f41985f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f41986g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f41987h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f41988i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f41989j;

    /* renamed from: k  reason: collision with root package name */
    public View f41990k;
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
            this.f41984e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
            this.f41989j = (ViewGroup) inflate.findViewById(R.id.root_layout);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
            this.f41985f = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.f41986g = (TextView) inflate.findViewById(R.id.link_thread_title);
            this.f41987h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
            this.f41988i = (TextView) inflate.findViewById(R.id.link_thread_url);
            this.f41990k = inflate.findViewById(R.id.link_thread_content);
            this.f41985f.setLongIconSupport(false);
            this.f41985f.setGifIconSupport(false);
            this.f41985f.setRadius(n.f(context, R.dimen.tbds10));
            this.f41985f.setConrers(5);
            b(inflate);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f41989j == null || this.f41985f == null) {
            return;
        }
        int k2 = (((n.k(this.f41984e) - (n.f(this.f41984e, R.dimen.tbds44) * 2)) - (n.f(getContext(), R.dimen.tbds26) * 2)) - (n.f(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.f41989j.getLayoutParams();
        layoutParams.height = k2;
        this.f41989j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f41985f.getLayoutParams();
        layoutParams2.width = k2;
        layoutParams2.height = k2;
        this.f41985f.setLayoutParams(layoutParams2);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.f41990k, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.f41985f, R.drawable.shape_link_thread_head_bg);
        }
    }

    public void refreshTextView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            m.l(this.f41986g, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f41988i, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f41987h, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) {
            if (d2Var != null && d2Var.C0() != null && !c.a.d.f.p.m.isEmpty(d2Var.C0().e())) {
                r0 C0 = d2Var.C0();
                if (!C0.f() && C0.c() != r0.f13793g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.f41985f.setPageId(this.l);
                if (C0.f()) {
                    this.f41988i.setVisibility(0);
                    this.f41986g.setVisibility(8);
                    this.f41987h.setVisibility(8);
                    this.f41988i.setText(C0.e());
                    this.f41985f.reset();
                } else {
                    this.f41988i.setVisibility(8);
                    String d2 = C0.d();
                    String a = C0.a();
                    if (!c.a.d.f.p.m.isEmpty(d2)) {
                        this.f41986g.setText(d2);
                        this.f41986g.setVisibility(0);
                        this.f41987h.setVisibility(8);
                    } else {
                        this.f41986g.setVisibility(8);
                        if (!c.a.d.f.p.m.isEmpty(a)) {
                            this.f41987h.setText(a);
                            this.f41987h.setVisibility(0);
                        } else {
                            this.f41987h.setVisibility(4);
                        }
                    }
                    if (!c.a.d.f.p.m.isEmpty(C0.b())) {
                        this.f41985f.startLoad(C0.b(), 10, false);
                    } else {
                        this.f41985f.reset();
                    }
                }
                refreshTextView(d2Var.g0());
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
