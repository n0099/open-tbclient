package com.baidu.poly.widget.coupon;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.qc1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CouponEntranceView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;
    public TextView b;
    public View c;
    public qc1 d;
    public qc1.a e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CouponEntranceView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01fc, (ViewGroup) this, true);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090711);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090710);
            this.c = findViewById(R.id.obfuscated_res_0x7f090e2d);
        }
    }

    public void c() {
        List<qc1.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = null;
            qc1 qc1Var = this.d;
            if (!((qc1Var == null || (list = qc1Var.b) == null || list.size() <= 0) ? false : true)) {
                setVisibility(8);
                return;
            }
            Iterator<qc1.a> it = this.d.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                qc1.a next = it.next();
                if (next.h == 1) {
                    this.e = next;
                    break;
                }
            }
            if (this.e == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            this.a.setText(this.e.c);
            qc1.a aVar = this.e;
            if (aVar.b == -1) {
                String str = aVar.d;
                this.b.setVisibility(8);
            } else {
                String str2 = "-" + a(this.e.g.longValue()) + "元";
                this.b.setVisibility(0);
                this.b.setText(this.e.d);
            }
            if (this.d.a) {
                this.c.setVisibility(0);
                setEnabled(true);
                return;
            }
            this.c.setVisibility(8);
            setEnabled(false);
        }
    }

    public qc1.a getSelectedItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (qc1.a) invokeV.objValue;
    }

    public void update(qc1 qc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qc1Var) == null) {
            this.d = qc1Var;
            c();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponEntranceView(Context context, AttributeSet attributeSet, int i) {
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
        b(context);
    }
}
