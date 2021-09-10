package c.a.q0.f1.p.a.f;

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
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import java.text.ParseException;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class b extends c.a.q0.f1.p.a.f.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d u;

    /* loaded from: classes3.dex */
    public class a implements c.a.q0.f1.p.a.d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f13320a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13320a = bVar;
        }

        @Override // c.a.q0.f1.p.a.d.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f13320a.f13312i.f13291b.a(d.y.parse(this.f13320a.u.o()));
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c.a.q0.f1.p.a.c.a aVar) {
        super(aVar.A);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
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
        this.f13312i = aVar;
        y(aVar.A);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13312i.f13290a == null) {
            return;
        }
        try {
            this.f13312i.f13290a.a(d.y.parse(this.u.o()), this.q);
        } catch (ParseException e2) {
            e2.printStackTrace();
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d dVar = this.u;
            c.a.q0.f1.p.a.c.a aVar = this.f13312i;
            dVar.E(aVar.f13295f, aVar.f13296g);
            x();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.u.I(this.f13312i.f13297h);
            this.u.x(this.f13312i.f13298i);
        }
    }

    public final void J() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = this.f13312i.f13294e;
            if (calendar2 == null) {
                calendar.setTimeInMillis(System.currentTimeMillis());
                i2 = calendar.get(1);
                i3 = calendar.get(2);
                i4 = calendar.get(5);
                i5 = calendar.get(11);
                i6 = calendar.get(12);
                i7 = calendar.get(13);
            } else {
                i2 = calendar2.get(1);
                i3 = this.f13312i.f13294e.get(2);
                i4 = this.f13312i.f13294e.get(5);
                i5 = this.f13312i.f13294e.get(11);
                i6 = this.f13312i.f13294e.get(12);
                i7 = this.f13312i.f13294e.get(13);
            }
            int i8 = i5;
            int i9 = i4;
            int i10 = i3;
            d dVar = this.u;
            dVar.D(i2, i10, i9, i8, i6, i7);
        }
    }

    @Override // c.a.q0.f1.p.a.f.a
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13312i.R : invokeV.booleanValue;
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
            c.a.q0.f1.p.a.c.a aVar = this.f13312i;
            if (aVar.f13295f != null && aVar.f13296g != null) {
                Calendar calendar = aVar.f13294e;
                if (calendar == null || calendar.getTimeInMillis() < this.f13312i.f13295f.getTimeInMillis() || this.f13312i.f13294e.getTimeInMillis() > this.f13312i.f13296g.getTimeInMillis()) {
                    c.a.q0.f1.p.a.c.a aVar2 = this.f13312i;
                    aVar2.f13294e = aVar2.f13295f;
                    return;
                }
                return;
            }
            c.a.q0.f1.p.a.c.a aVar3 = this.f13312i;
            Calendar calendar2 = aVar3.f13295f;
            if (calendar2 != null) {
                aVar3.f13294e = calendar2;
                return;
            }
            Calendar calendar3 = aVar3.f13296g;
            if (calendar3 != null) {
                aVar3.f13294e = calendar3;
            }
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            r();
            n();
            m();
            c.a.q0.f1.p.a.d.a aVar = this.f13312i.f13292c;
            if (aVar == null) {
                LayoutInflater.from(context).inflate(R.layout.pickerview_time, this.f13309f);
                TextView textView = (TextView) i(R.id.tvTitle);
                RelativeLayout relativeLayout = (RelativeLayout) i(R.id.rv_topbar);
                Button button = (Button) i(R.id.btnSubmit);
                Button button2 = (Button) i(R.id.btnCancel);
                button.setTag("submit");
                button2.setTag(QueryResponse.Options.CANCEL);
                button.setOnClickListener(this);
                button2.setOnClickListener(this);
                button.setText(TextUtils.isEmpty(this.f13312i.B) ? context.getResources().getString(R.string.pickerview_submit) : this.f13312i.B);
                button2.setText(TextUtils.isEmpty(this.f13312i.C) ? context.getResources().getString(R.string.pickerview_cancel) : this.f13312i.C);
                textView.setText(TextUtils.isEmpty(this.f13312i.D) ? "" : this.f13312i.D);
                button.setTextColor(this.f13312i.E);
                button2.setTextColor(this.f13312i.F);
                textView.setTextColor(this.f13312i.G);
                relativeLayout.setBackgroundColor(this.f13312i.I);
                button.setTextSize(this.f13312i.J);
                button2.setTextSize(this.f13312i.J);
                textView.setTextSize(this.f13312i.K);
            } else {
                aVar.a(LayoutInflater.from(context).inflate(this.f13312i.x, this.f13309f));
            }
            LinearLayout linearLayout = (LinearLayout) i(R.id.timepicker);
            linearLayout.setBackgroundColor(this.f13312i.H);
            z(linearLayout);
        }
    }

    public final void z(LinearLayout linearLayout) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, linearLayout) == null) {
            c.a.q0.f1.p.a.c.a aVar = this.f13312i;
            d dVar = new d(linearLayout, aVar.f13293d, aVar.z, aVar.L);
            this.u = dVar;
            if (this.f13312i.f13291b != null) {
                dVar.G(new a(this));
            }
            this.u.C(this.f13312i.k);
            c.a.q0.f1.p.a.c.a aVar2 = this.f13312i;
            int i3 = aVar2.f13297h;
            if (i3 != 0 && (i2 = aVar2.f13298i) != 0 && i3 <= i2) {
                D();
            }
            c.a.q0.f1.p.a.c.a aVar3 = this.f13312i;
            Calendar calendar = aVar3.f13295f;
            if (calendar != null && aVar3.f13296g != null) {
                if (calendar.getTimeInMillis() <= this.f13312i.f13296g.getTimeInMillis()) {
                    B();
                } else {
                    throw new IllegalArgumentException("startDate can't be later than endDate");
                }
            } else {
                c.a.q0.f1.p.a.c.a aVar4 = this.f13312i;
                Calendar calendar2 = aVar4.f13295f;
                if (calendar2 != null) {
                    if (calendar2.get(1) >= 1900) {
                        B();
                    } else {
                        throw new IllegalArgumentException("The startDate can not as early as 1900");
                    }
                } else {
                    Calendar calendar3 = aVar4.f13296g;
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
            J();
            d dVar2 = this.u;
            c.a.q0.f1.p.a.c.a aVar5 = this.f13312i;
            dVar2.y(aVar5.l, aVar5.m, aVar5.n, aVar5.o, aVar5.p, aVar5.q);
            d dVar3 = this.u;
            c.a.q0.f1.p.a.c.a aVar6 = this.f13312i;
            dVar3.N(aVar6.r, aVar6.s, aVar6.t, aVar6.u, aVar6.v, aVar6.w);
            t(this.f13312i.S);
            this.u.s(this.f13312i.f13299j);
            this.u.u(this.f13312i.O);
            this.u.w(this.f13312i.U);
            this.u.A(this.f13312i.Q);
            this.u.M(this.f13312i.M);
            this.u.K(this.f13312i.N);
            this.u.p(this.f13312i.T);
        }
    }
}
