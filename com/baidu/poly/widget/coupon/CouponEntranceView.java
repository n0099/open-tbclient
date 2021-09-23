package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.e0.c;
import c.a.e0.f;
import c.a.e0.g;
import c.a.e0.k.d.b;
import c.a.e0.p.a.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class CouponEntranceView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f44434e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44435f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44436g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44437h;

    /* renamed from: i  reason: collision with root package name */
    public View f44438i;

    /* renamed from: j  reason: collision with root package name */
    public a f44439j;
    public a.C0065a k;

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

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f44439j = aVar;
            h();
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(g.coupon_entrance, (ViewGroup) this, true);
            this.f44434e = (ImageView) findViewById(f.coupon_icon);
            this.f44437h = (TextView) findViewById(f.coupon_text);
            this.f44435f = (TextView) findViewById(f.coupon_title);
            this.f44436g = (TextView) findViewById(f.coupon_subtitle);
            this.f44438i = findViewById(f.icon_more);
        }
    }

    public a.C0065a getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (a.C0065a) invokeV.objValue;
    }

    public void h() {
        String str;
        List<a.C0065a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.k = null;
            a aVar = this.f44439j;
            if (!((aVar == null || (list = aVar.f3244b) == null || list.size() <= 0) ? false : true)) {
                setVisibility(8);
                return;
            }
            Iterator<a.C0065a> it = this.f44439j.f3244b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a.C0065a next = it.next();
                if (next.f3251g == 1) {
                    this.k = next;
                    break;
                }
            }
            if (this.k == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            b.c().b(this.f44434e, this.k.f3249e);
            this.f44435f.setText(this.k.f3246b);
            a.C0065a c0065a = this.k;
            if (c0065a.f3245a == -1) {
                str = c0065a.f3247c;
                this.f44436g.setVisibility(8);
            } else {
                str = "-" + a(this.k.f3250f.longValue()) + "元";
                this.f44436g.setVisibility(0);
                this.f44436g.setText(this.k.f3247c);
            }
            this.f44437h.setText(str);
            if (this.f44439j.f3243a) {
                this.f44437h.setTextColor(getResources().getColor(c.coupon_description));
                this.f44438i.setVisibility(0);
                setEnabled(true);
                return;
            }
            this.f44437h.setTextColor(getResources().getColor(c.black));
            this.f44438i.setVisibility(8);
            setEnabled(false);
        }
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
        b(context);
    }

    public final String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }
}
