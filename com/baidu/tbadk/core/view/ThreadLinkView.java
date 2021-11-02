package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.r0;
import b.a.r0.b0.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ThreadLinkView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f45439e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f45440f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45441g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45442h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f45443i;
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
            this.f45439e = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
            this.j = (ViewGroup) inflate.findViewById(R.id.root_layout);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
            this.f45440f = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.f45441g = (TextView) inflate.findViewById(R.id.link_thread_title);
            this.f45442h = (TextView) inflate.findViewById(R.id.link_thread_abstract);
            this.f45443i = (TextView) inflate.findViewById(R.id.link_thread_url);
            this.k = inflate.findViewById(R.id.link_thread_content);
            this.f45440f.setLongIconSupport(false);
            this.f45440f.setGifIconSupport(false);
            this.f45440f.setRadius(l.g(context, R.dimen.tbds10));
            this.f45440f.setConrers(5);
            b(inflate);
        }
    }

    public final void b(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || this.j == null || this.f45440f == null) {
            return;
        }
        int k = (((l.k(this.f45439e) - (l.g(this.f45439e, R.dimen.tbds44) * 2)) - (l.g(getContext(), R.dimen.tbds26) * 2)) - (l.g(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.j.getLayoutParams();
        layoutParams.height = k;
        this.j.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f45440f.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.f45440f.setLayoutParams(layoutParams2);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.f45440f, R.drawable.shape_link_thread_head_bg);
        }
    }

    public void refreshTextView(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            m.l(this.f45441g, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f45443i, str, R.color.CAM_X0107, R.color.CAM_X0109);
            m.l(this.f45442h, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public void setData(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, d2Var) == null) {
            if (d2Var != null && d2Var.B0() != null && !k.isEmpty(d2Var.B0().e())) {
                r0 B0 = d2Var.B0();
                if (!B0.f() && B0.c() != r0.f13428g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.f45440f.setPageId(this.l);
                if (B0.f()) {
                    this.f45443i.setVisibility(0);
                    this.f45441g.setVisibility(8);
                    this.f45442h.setVisibility(8);
                    this.f45443i.setText(B0.e());
                    this.f45440f.reset();
                } else {
                    this.f45443i.setVisibility(8);
                    String d2 = B0.d();
                    String a2 = B0.a();
                    if (!k.isEmpty(d2)) {
                        this.f45441g.setText(d2);
                        this.f45441g.setVisibility(0);
                        this.f45442h.setVisibility(8);
                    } else {
                        this.f45441g.setVisibility(8);
                        if (!k.isEmpty(a2)) {
                            this.f45442h.setText(a2);
                            this.f45442h.setVisibility(0);
                        } else {
                            this.f45442h.setVisibility(4);
                        }
                    }
                    if (!k.isEmpty(B0.b())) {
                        this.f45440f.startLoad(B0.b(), 10, false);
                    } else {
                        this.f45440f.reset();
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
