package com.baidu.card.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.e.e.p.l;
import c.a.p0.s.f0.n.b;
import c.a.p0.s.q.c2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ExtraLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f38528e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38529f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f38530g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f38531h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f38532i;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ExtraLayout f38533e;

        public a(ExtraLayout extraLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extraLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38533e = extraLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f38533e.f38531h == null) {
                return;
            }
            this.f38533e.f38531h.onClick(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtraLayout(Context context) {
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
        this.f38532i = new a(this);
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.card_home_page_extra_item, (ViewGroup) this, true);
            TextView textView = (TextView) inflate.findViewById(R.id.extra_text);
            this.f38529f = textView;
            textView.setCompoundDrawablePadding(l.g(context, R.dimen.tbds10));
            this.f38530g = (TextView) inflate.findViewById(R.id.extra_tag);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) inflate.findViewById(R.id.extra_btn);
            this.f38528e = tBSpecificationBtn;
            tBSpecificationBtn.setOnClickListener(this.f38532i);
            b bVar = new b();
            bVar.q(R.color.CAM_X0302);
            this.f38528e.setConfig(bVar);
            this.f38528e.setText(getResources().getString(R.string.download_just_now));
        }
    }

    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f38529f, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f38530g, R.color.CAM_X0109);
            this.f38528e.changeSkinType(i2);
        }
    }

    public void setData(c.a.p0.s.q.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c2 threadData = aVar.getThreadData();
            boolean z2 = true;
            if (!TextUtils.isEmpty(threadData.B2)) {
                this.f38529f.setVisibility(0);
                this.f38529f.setText(threadData.B2);
                this.f38529f.setOnClickListener(null);
                z = true;
            } else {
                this.f38529f.setVisibility(8);
                z = false;
            }
            if (!TextUtils.isEmpty(threadData.C2)) {
                this.f38530g.setVisibility(0);
                this.f38530g.setText(threadData.C2);
                this.f38530g.setOnClickListener(null);
                z = true;
            } else {
                this.f38530g.setVisibility(8);
            }
            if (!TextUtils.isEmpty(threadData.D2)) {
                this.f38528e.setVisibility(0);
                this.f38528e.setText(threadData.D2);
            } else {
                this.f38528e.setVisibility(4);
                z2 = z;
            }
            setVisibility(z2 ? 0 : 8);
        }
    }

    public void setOnAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.f38531h = onClickListener;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtraLayout(Context context, AttributeSet attributeSet) {
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
        this.f38532i = new a(this);
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtraLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f38532i = new a(this);
        b(context);
    }
}
