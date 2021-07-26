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
import d.a.e0.c;
import d.a.e0.f;
import d.a.e0.g;
import d.a.e0.k.d.b;
import d.a.e0.p.a.a;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CouponEntranceView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f9499e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f9500f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f9501g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f9502h;

    /* renamed from: i  reason: collision with root package name */
    public View f9503i;
    public a j;
    public a.C0594a k;

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
            this.f9499e = (ImageView) findViewById(f.coupon_icon);
            this.f9502h = (TextView) findViewById(f.coupon_text);
            this.f9500f = (TextView) findViewById(f.coupon_title);
            this.f9501g = (TextView) findViewById(f.coupon_subtitle);
            this.f9503i = findViewById(f.icon_more);
        }
    }

    public void d() {
        String str;
        List<a.C0594a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k = null;
            a aVar = this.j;
            if (!((aVar == null || (list = aVar.f42686b) == null || list.size() <= 0) ? false : true)) {
                setVisibility(8);
                return;
            }
            Iterator<a.C0594a> it = this.j.f42686b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a.C0594a next = it.next();
                if (next.f42693g == 1) {
                    this.k = next;
                    break;
                }
            }
            if (this.k == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            b.c().b(this.f9499e, this.k.f42691e);
            this.f9500f.setText(this.k.f42688b);
            a.C0594a c0594a = this.k;
            if (c0594a.f42687a == -1) {
                str = c0594a.f42689c;
                this.f9501g.setVisibility(8);
            } else {
                str = "-" + a(this.k.f42692f.longValue()) + "元";
                this.f9501g.setVisibility(0);
                this.f9501g.setText(this.k.f42689c);
            }
            this.f9502h.setText(str);
            if (this.j.f42685a) {
                this.f9502h.setTextColor(getResources().getColor(c.coupon_description));
                this.f9503i.setVisibility(0);
                setEnabled(true);
                return;
            }
            this.f9502h.setTextColor(getResources().getColor(c.black));
            this.f9503i.setVisibility(8);
            setEnabled(false);
        }
    }

    public a.C0594a getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (a.C0594a) invokeV.objValue;
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
