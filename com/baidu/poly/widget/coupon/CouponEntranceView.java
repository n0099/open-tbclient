package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d0.c;
import d.a.d0.f;
import d.a.d0.g;
import d.a.d0.k.d.b;
import d.a.d0.p.a.a;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CouponEntranceView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f9473e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9474f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9475g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9476h;

    /* renamed from: i  reason: collision with root package name */
    public View f9477i;
    public a j;
    public a.C0585a k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CouponEntranceView(Context context) {
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

    public final String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? new DecimalFormat("0.00").format((j * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.j = aVar;
            d();
        }
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(g.coupon_entrance, (ViewGroup) this, true);
            this.f9473e = (ImageView) findViewById(f.coupon_icon);
            this.f9476h = (TextView) findViewById(f.coupon_text);
            this.f9474f = (TextView) findViewById(f.coupon_title);
            this.f9475g = (TextView) findViewById(f.coupon_subtitle);
            this.f9477i = findViewById(f.icon_more);
        }
    }

    public void d() {
        String str;
        List<a.C0585a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = null;
            a aVar = this.j;
            if (!((aVar == null || (list = aVar.f42182b) == null || list.size() <= 0) ? false : true)) {
                setVisibility(8);
                return;
            }
            Iterator<a.C0585a> it = this.j.f42182b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a.C0585a next = it.next();
                if (next.f42189g == 1) {
                    this.k = next;
                    break;
                }
            }
            if (this.k == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            b.c().b(this.f9473e, this.k.f42187e);
            this.f9474f.setText(this.k.f42184b);
            a.C0585a c0585a = this.k;
            if (c0585a.f42183a == -1) {
                str = c0585a.f42185c;
                this.f9475g.setVisibility(8);
            } else {
                str = "-" + a(this.k.f42188f.longValue()) + "元";
                this.f9475g.setVisibility(0);
                this.f9475g.setText(this.k.f42185c);
            }
            this.f9476h.setText(str);
            if (this.j.f42181a) {
                this.f9476h.setTextColor(getResources().getColor(c.coupon_description));
                this.f9477i.setVisibility(0);
                setEnabled(true);
                return;
            }
            this.f9476h.setTextColor(getResources().getColor(c.black));
            this.f9477i.setVisibility(8);
            setEnabled(false);
        }
    }

    public a.C0585a getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (a.C0585a) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CouponEntranceView(Context context, AttributeSet attributeSet) {
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
    public CouponEntranceView(Context context, AttributeSet attributeSet, int i2) {
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
        c(context);
    }
}
