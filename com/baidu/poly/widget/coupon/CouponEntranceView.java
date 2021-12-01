package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import c.a.f0.g;
import c.a.f0.h;
import c.a.f0.t.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class CouponEntranceView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f38485e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f38486f;

    /* renamed from: g  reason: collision with root package name */
    public View f38487g;

    /* renamed from: h  reason: collision with root package name */
    public a f38488h;

    /* renamed from: i  reason: collision with root package name */
    public a.C0119a f38489i;

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

    public final String a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? new DecimalFormat("0.00").format((j2 * 1.0d) / 100.0d) : (String) invokeJ.objValue;
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LayoutInflater.from(context).inflate(h.coupon_entrance, (ViewGroup) this, true);
            this.f38485e = (TextView) findViewById(g.coupon_title);
            this.f38486f = (TextView) findViewById(g.coupon_subtitle);
            this.f38487g = findViewById(g.icon_more);
        }
    }

    public a.C0119a getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38489i : (a.C0119a) invokeV.objValue;
    }

    public void refreshUI() {
        List<a.C0119a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f38489i = null;
            a aVar = this.f38488h;
            if (!((aVar == null || (list = aVar.f3259b) == null || list.size() <= 0) ? false : true)) {
                setVisibility(8);
                return;
            }
            Iterator<a.C0119a> it = this.f38488h.f3259b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a.C0119a next = it.next();
                if (next.f3266h == 1) {
                    this.f38489i = next;
                    break;
                }
            }
            if (this.f38489i == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.f38485e.setText(this.f38489i.f3261c);
            a.C0119a c0119a = this.f38489i;
            if (c0119a.f3260b == -1) {
                String str = c0119a.f3262d;
                this.f38486f.setVisibility(8);
            } else {
                String str2 = "-" + a(this.f38489i.f3265g.longValue()) + "元";
                this.f38486f.setVisibility(0);
                this.f38486f.setText(this.f38489i.f3262d);
            }
            if (this.f38488h.a) {
                this.f38487g.setVisibility(0);
                setEnabled(true);
                return;
            }
            this.f38487g.setVisibility(8);
            setEnabled(false);
        }
    }

    public void update(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f38488h = aVar;
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
