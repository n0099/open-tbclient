package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.e0.g;
import b.a.e0.h;
import b.a.e0.t.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class CouponEntranceView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f43046e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f43047f;

    /* renamed from: g  reason: collision with root package name */
    public View f43048g;

    /* renamed from: h  reason: collision with root package name */
    public a f43049h;

    /* renamed from: i  reason: collision with root package name */
    public a.C0060a f43050i;

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

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(h.coupon_entrance, (ViewGroup) this, true);
            this.f43046e = (TextView) findViewById(g.coupon_title);
            this.f43047f = (TextView) findViewById(g.coupon_subtitle);
            this.f43048g = findViewById(g.icon_more);
        }
    }

    public a.C0060a getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f43050i : (a.C0060a) invokeV.objValue;
    }

    public void refreshUI() {
        List<a.C0060a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f43050i = null;
            a aVar = this.f43049h;
            if (!((aVar == null || (list = aVar.f2773b) == null || list.size() <= 0) ? false : true)) {
                setVisibility(8);
                return;
            }
            Iterator<a.C0060a> it = this.f43049h.f2773b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a.C0060a next = it.next();
                if (next.f2781h == 1) {
                    this.f43050i = next;
                    break;
                }
            }
            if (this.f43050i == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f43046e.setText(this.f43050i.f2776c);
            a.C0060a c0060a = this.f43050i;
            if (c0060a.f2775b == -1) {
                String str = c0060a.f2777d;
                this.f43047f.setVisibility(8);
            } else {
                String str2 = "-" + a(this.f43050i.f2780g.longValue()) + "元";
                this.f43047f.setVisibility(0);
                this.f43047f.setText(this.f43050i.f2777d);
            }
            if (this.f43049h.f2772a) {
                this.f43048g.setVisibility(0);
                setEnabled(true);
                return;
            }
            this.f43048g.setVisibility(8);
            setEnabled(false);
        }
    }

    public void update(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f43049h = aVar;
            refreshUI();
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
}
