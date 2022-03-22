package c.a.o0.e1.q.a.f;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class b extends c.a.o0.e1.q.a.f.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d q;

    /* loaded from: classes2.dex */
    public class a implements c.a.o0.e1.q.a.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // c.a.o0.e1.q.a.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.f10223e.f10207b.a(d.y.parse(this.a.q.o()));
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.o0.e1.q.a.c.a aVar) {
        super(aVar.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
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
        this.f10223e = aVar;
        y(aVar.A);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f10223e.a == null) {
            return;
        }
        try {
            this.f10223e.a.a(d.y.parse(this.q.o()), this.m);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d dVar = this.q;
            c.a.o0.e1.q.a.c.a aVar = this.f10223e;
            dVar.E(aVar.f10211f, aVar.f10212g);
            x();
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q.I(this.f10223e.f10213h);
            this.q.x(this.f10223e.i);
        }
    }

    public final void D() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = this.f10223e.f10210e;
            if (calendar2 == null) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                i = calendar.get(1);
                i2 = calendar.get(2);
                i3 = calendar.get(5);
                i4 = calendar.get(11);
                i5 = calendar.get(12);
                i6 = calendar.get(13);
            } else {
                i = calendar2.get(1);
                i2 = this.f10223e.f10210e.get(2);
                i3 = this.f10223e.f10210e.get(5);
                i4 = this.f10223e.f10210e.get(11);
                i5 = this.f10223e.f10210e.get(12);
                i6 = this.f10223e.f10210e.get(13);
            }
            int i7 = i4;
            int i8 = i3;
            int i9 = i2;
            d dVar = this.q;
            dVar.D(i, i9, i8, i7, i5, i6);
        }
    }

    @Override // c.a.o0.e1.q.a.f.a
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f10223e.R : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (((String) view.getTag()).equals("submit")) {
                A();
            }
            f();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.o0.e1.q.a.c.a aVar = this.f10223e;
            if (aVar.f10211f != null && aVar.f10212g != null) {
                Calendar calendar = aVar.f10210e;
                if (calendar == null || calendar.getTimeInMillis() < this.f10223e.f10211f.getTimeInMillis() || this.f10223e.f10210e.getTimeInMillis() > this.f10223e.f10212g.getTimeInMillis()) {
                    c.a.o0.e1.q.a.c.a aVar2 = this.f10223e;
                    aVar2.f10210e = aVar2.f10211f;
                    return;
                }
                return;
            }
            c.a.o0.e1.q.a.c.a aVar3 = this.f10223e;
            Calendar calendar2 = aVar3.f10211f;
            if (calendar2 != null) {
                aVar3.f10210e = calendar2;
                return;
            }
            Calendar calendar3 = aVar3.f10212g;
            if (calendar3 != null) {
                aVar3.f10210e = calendar3;
            }
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            r();
            n();
            m();
            c.a.o0.e1.q.a.d.a aVar = this.f10223e.f10208c;
            if (aVar == null) {
                LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d06e9, this.f10220b);
                TextView textView = (TextView) i(R.id.obfuscated_res_0x7f092176);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.obfuscated_res_0x7f091b0c);
                Button button = (Button) i(R.id.obfuscated_res_0x7f0903fe);
                Button button2 = (Button) i(R.id.obfuscated_res_0x7f0903fa);
                button.setTag("submit");
                button2.setTag("cancel");
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                button.setText(TextUtils.isEmpty(this.f10223e.B) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e45) : this.f10223e.B);
                button2.setText(TextUtils.isEmpty(this.f10223e.C) ? context.getResources().getString(R.string.obfuscated_res_0x7f0f0e3f) : this.f10223e.C);
                textView.setText(TextUtils.isEmpty(this.f10223e.D) ? "" : this.f10223e.D);
                button.setTextColor(this.f10223e.E);
                button2.setTextColor(this.f10223e.F);
                textView.setTextColor(this.f10223e.G);
                relativeLayout.setBackgroundColor(this.f10223e.I);
                button.setTextSize(this.f10223e.J);
                button2.setTextSize(this.f10223e.J);
                textView.setTextSize(this.f10223e.K);
            } else {
                aVar.a(LayoutInflater.from(context).inflate(this.f10223e.x, this.f10220b));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.obfuscated_res_0x7f092000);
            linearLayout.setBackgroundColor(this.f10223e.H);
            z(linearLayout);
        }
    }

    public final void z(LinearLayout linearLayout) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linearLayout) == null) {
            c.a.o0.e1.q.a.c.a aVar = this.f10223e;
            d dVar = new d(linearLayout, aVar.f10209d, aVar.z, aVar.L);
            this.q = dVar;
            if (this.f10223e.f10207b != null) {
                dVar.G(new a(this));
            }
            this.q.C(this.f10223e.k);
            c.a.o0.e1.q.a.c.a aVar2 = this.f10223e;
            int i2 = aVar2.f10213h;
            if (i2 != 0 && (i = aVar2.i) != 0 && i2 <= i) {
                C();
            }
            c.a.o0.e1.q.a.c.a aVar3 = this.f10223e;
            Calendar calendar = aVar3.f10211f;
            if (calendar != null && aVar3.f10212g != null) {
                if (calendar.getTimeInMillis() <= this.f10223e.f10212g.getTimeInMillis()) {
                    B();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                c.a.o0.e1.q.a.c.a aVar4 = this.f10223e;
                Calendar calendar2 = aVar4.f10211f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        B();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = aVar4.f10212g;
                    if (calendar3 != null) {
                        if (calendar3.get(1) <= 2100) {
                            B();
                        } else {
                            throw new IllegalArgumentException("The endDate should not be later than 2100");
                        }
                    } else {
                        B();
                    }
                }
            }
            D();
            d dVar2 = this.q;
            c.a.o0.e1.q.a.c.a aVar5 = this.f10223e;
            dVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
            d dVar3 = this.q;
            c.a.o0.e1.q.a.c.a aVar6 = this.f10223e;
            dVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
            t(this.f10223e.S);
            this.q.s(this.f10223e.j);
            this.q.u(this.f10223e.O);
            this.q.w(this.f10223e.U);
            this.q.A(this.f10223e.Q);
            this.q.M(this.f10223e.M);
            this.q.K(this.f10223e.N);
            this.q.p(this.f10223e.T);
        }
    }
}
