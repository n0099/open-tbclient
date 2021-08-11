package com.baidu.poly.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d0.e;
import c.a.d0.f;
import c.a.d0.g;
import c.a.d0.k.d.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f44145e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44146f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44147g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f44148h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC1687a f44149i;

    /* renamed from: com.baidu.poly.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC1687a {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(o oVar, InterfaceC1687a interfaceC1687a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, oVar, interfaceC1687a) == null) {
            String displayName = oVar.getDisplayName();
            String S = oVar.S();
            String icon = oVar.getIcon();
            int P = oVar.P();
            int N = oVar.N();
            b.c().b(this.f44145e, icon);
            this.f44146f.setText(displayName);
            if (P == 1) {
                this.f44148h.setImageResource(e.channel_checked);
            } else {
                this.f44148h.setImageResource(e.unchecked);
            }
            if (1 == N) {
                this.f44149i = interfaceC1687a;
            } else {
                this.f44145e.setAlpha(0.4f);
                this.f44146f.setAlpha(0.4f);
                this.f44147g.setAlpha(0.4f);
                this.f44148h.setVisibility(8);
            }
            if (!TextUtils.isEmpty(S)) {
                String M = oVar.M();
                if (!TextUtils.isEmpty(M)) {
                    try {
                        this.f44147g.setTextColor(Color.parseColor(M));
                    } catch (Exception unused) {
                    }
                }
                this.f44147g.setText(S);
                return;
            }
            this.f44147g.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f44146f.getLayoutParams();
            layoutParams.addRule(15);
            layoutParams.topMargin = 0;
            this.f44146f.setLayoutParams(layoutParams);
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(g.view_channel_list_item, (ViewGroup) this, true);
            this.f44145e = (ImageView) findViewById(f.channel_icon_view);
            this.f44146f = (TextView) findViewById(f.channel_name_view);
            this.f44147g = (TextView) findViewById(f.channel_desc_view);
            this.f44148h = (ImageView) findViewById(f.channel_select_view);
            setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC1687a interfaceC1687a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) || (interfaceC1687a = this.f44149i) == null) {
            return;
        }
        interfaceC1687a.a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i2) {
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
        b(context);
    }
}
