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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.qi;
import com.baidu.tieba.ri;
import com.baidu.tieba.uz5;
import com.baidu.tieba.zp4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ThreadLinkView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public TbImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public ViewGroup f;
    public View g;
    public BdUniqueId h;

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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d050f, (ViewGroup) this, true);
            this.f = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091c2b);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091303);
            this.b = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.c = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091305);
            this.d = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091300);
            this.e = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091306);
            this.g = inflate.findViewById(R.id.obfuscated_res_0x7f091301);
            this.b.setLongIconSupport(false);
            this.b.setGifIconSupport(false);
            this.b.setRadius(ri.f(context, R.dimen.tbds10));
            this.b.setConrers(5);
            d(inflate);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.b, R.drawable.shape_link_thread_head_bg);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            uz5.l(this.c, str, R.color.CAM_X0107, R.color.CAM_X0109);
            uz5.l(this.e, str, R.color.CAM_X0107, R.color.CAM_X0109);
            uz5.l(this.d, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public final void d(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.f == null || this.b == null) {
            return;
        }
        int k = (((ri.k(this.a) - (ri.f(this.a, R.dimen.tbds44) * 2)) - (ri.f(getContext(), R.dimen.tbds26) * 2)) - (ri.f(getContext(), R.dimen.tbds10) * 4)) / 5;
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        layoutParams.height = k;
        this.f.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
        layoutParams2.width = k;
        layoutParams2.height = k;
        this.b.setLayoutParams(layoutParams2);
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            if (threadData != null && threadData.getLinkThreadData() != null && !qi.isEmpty(threadData.getLinkThreadData().e())) {
                zp4 linkThreadData = threadData.getLinkThreadData();
                if (!linkThreadData.f() && linkThreadData.c() != zp4.g) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                this.b.setPageId(this.h);
                if (linkThreadData.f()) {
                    this.e.setVisibility(0);
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    this.e.setText(linkThreadData.e());
                    this.b.F();
                } else {
                    this.e.setVisibility(8);
                    String d = linkThreadData.d();
                    String a = linkThreadData.a();
                    if (!qi.isEmpty(d)) {
                        this.c.setText(d);
                        this.c.setVisibility(0);
                        this.d.setVisibility(8);
                    } else {
                        this.c.setVisibility(8);
                        if (!qi.isEmpty(a)) {
                            this.d.setText(a);
                            this.d.setVisibility(0);
                        } else {
                            this.d.setVisibility(4);
                        }
                    }
                    if (!qi.isEmpty(linkThreadData.b())) {
                        this.b.K(linkThreadData.b(), 10, false);
                    } else {
                        this.b.F();
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
            this.h = bdUniqueId;
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
