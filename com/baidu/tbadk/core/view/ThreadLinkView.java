package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bi;
import com.baidu.tieba.l25;
import com.baidu.tieba.om6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            this.a = context;
            View inflate = LayoutInflater.from(context).inflate(R.layout.link_thread_item, (ViewGroup) this, true);
            this.f = (ViewGroup) inflate.findViewById(R.id.root_layout);
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.link_thread_head_img);
            this.b = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_card_url_n);
            this.c = (TextView) inflate.findViewById(R.id.link_thread_title);
            this.d = (TextView) inflate.findViewById(R.id.link_thread_abstract);
            this.e = (TextView) inflate.findViewById(R.id.link_thread_url);
            this.g = inflate.findViewById(R.id.link_thread_content);
            this.b.setLongIconSupport(false);
            this.b.setGifIconSupport(false);
            this.b.setRadius(BdUtilHelper.getDimens(context, R.dimen.tbds10));
            this.b.setConrers(5);
            d(inflate);
        }
    }

    public final void d(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && this.f != null && this.b != null) {
            int equipmentWidth = (((BdUtilHelper.getEquipmentWidth(this.a) - (BdUtilHelper.getDimens(this.a, R.dimen.tbds44) * 2)) - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds26) * 2)) - (BdUtilHelper.getDimens(getContext(), R.dimen.tbds10) * 4)) / 5;
            ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
            layoutParams.height = equipmentWidth;
            this.f.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.b.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = equipmentWidth;
            this.b.setLayoutParams(layoutParams2);
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
            om6.l(this.c, str, R.color.CAM_X0107, R.color.CAM_X0109);
            om6.l(this.e, str, R.color.CAM_X0107, R.color.CAM_X0109);
            om6.l(this.d, str, R.color.CAM_X0107, R.color.CAM_X0109);
        }
    }

    public void setTag(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.h = bdUniqueId;
        }
    }

    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            if (threadData != null && threadData.getLinkThreadData() != null && !bi.isEmpty(threadData.getLinkThreadData().e())) {
                l25 linkThreadData = threadData.getLinkThreadData();
                if (!linkThreadData.f() && linkThreadData.c() != l25.g) {
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
                    this.b.reset();
                } else {
                    this.e.setVisibility(8);
                    String d = linkThreadData.d();
                    String a = linkThreadData.a();
                    if (!bi.isEmpty(d)) {
                        this.c.setText(d);
                        this.c.setVisibility(0);
                        this.d.setVisibility(8);
                    } else {
                        this.c.setVisibility(8);
                        if (!bi.isEmpty(a)) {
                            this.d.setText(a);
                            this.d.setVisibility(0);
                        } else {
                            this.d.setVisibility(4);
                        }
                    }
                    if (!bi.isEmpty(linkThreadData.b())) {
                        this.b.startLoad(linkThreadData.b(), 10, false);
                    } else {
                        this.b.reset();
                    }
                }
                c(threadData.getId());
                return;
            }
            setVisibility(8);
        }
    }
}
