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
import c.a.o0.s.q.c2;
import c.a.o0.s.q.r0;
import c.a.p0.a0.m;
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
    public Context f47622e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f47623f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47624g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47625h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47626i;

    /* renamed from: j  reason: collision with root package name */
    public ViewGroup f47627j;
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
            this.f47622e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
            this.f47627j = (ViewGroup) inflate.findViewById(R.id.root_layout);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
            this.f47623f = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.f47624g = (TextView) inflate.findViewById(R.id.link_thread_title);
            this.f47625h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
            this.f47626i = (TextView) inflate.findViewById(R.id.link_thread_url);
            this.k = inflate.findViewById(R.id.link_thread_content);
            this.f47623f.setLongIconSupport(false);
            this.f47623f.setGifIconSupport(false);
            this.f47623f.setRadius(l.g(context, R.dimen.tbds10));
            this.f47623f.setConrers(5);
            b(inflate);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.f47627j == null || this.f47623f == null) {
            return;
        }
        int k = (((l.k(this.f47622e) - (l.g(this.f47622e, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.f47627j.getLayoutParams();
        layoutParams.height = k;
        this.f47627j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f47623f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f47623f.setLayoutParams(layoutParams2);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.f47623f, R.drawable.shape_link_thread_head_bg);
        }
    }

    public void refreshTextView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            m.l(this.f47624g, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f47626i, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f47625h, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public void setData(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, c2Var) == null) {
            if (c2Var != null && c2Var.z0() != null && !k.isEmpty(c2Var.z0().e())) {
                r0 z0 = c2Var.z0();
                if (!z0.f() && z0.c() != r0.f14022g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.f47623f.setPageId(this.l);
                if (z0.f()) {
                    this.f47626i.setVisibility(0);
                    this.f47624g.setVisibility(8);
                    this.f47625h.setVisibility(8);
                    this.f47626i.setText(z0.e());
                    this.f47623f.reset();
                } else {
                    this.f47626i.setVisibility(8);
                    String d2 = z0.d();
                    String a2 = z0.a();
                    if (!k.isEmpty(d2)) {
                        this.f47624g.setText(d2);
                        this.f47624g.setVisibility(0);
                        this.f47625h.setVisibility(8);
                    } else {
                        this.f47624g.setVisibility(8);
                        if (!k.isEmpty(a2)) {
                            this.f47625h.setText(a2);
                            this.f47625h.setVisibility(0);
                        } else {
                            this.f47625h.setVisibility(4);
                        }
                    }
                    if (!k.isEmpty(z0.b())) {
                        this.f47623f.startLoad(z0.b(), 10, false);
                    } else {
                        this.f47623f.reset();
                    }
                }
                refreshTextView(c2Var.f0());
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
