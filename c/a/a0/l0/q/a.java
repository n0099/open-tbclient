package c.a.a0.l0.q;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.a0.l0.q.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends c.a.a0.l0.q.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f1456b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f1457c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f1458d;

    /* renamed from: e  reason: collision with root package name */
    public Context f1459e;

    /* renamed from: f  reason: collision with root package name */
    public View f1460f;

    /* renamed from: g  reason: collision with root package name */
    public List<C0060a> f1461g;

    /* renamed from: h  reason: collision with root package name */
    public int f1462h;

    /* renamed from: c.a.a0.l0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0060a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f1463b;

        /* renamed from: c  reason: collision with root package name */
        public int f1464c;

        /* renamed from: d  reason: collision with root package name */
        public int f1465d;

        /* renamed from: e  reason: collision with root package name */
        public c f1466e;

        public C0060a(CharSequence charSequence, int i, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {charSequence, Integer.valueOf(i), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1464c = -1;
            this.f1465d = -1;
            this.a = charSequence;
            this.f1464c = i;
            this.f1466e = cVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public List<C0060a> f1467f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
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
            this.f1467f = new ArrayList();
            g(false);
            h(false);
        }

        @Override // c.a.a0.l0.q.c.a
        public c.a.a0.l0.q.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a aVar = (a) super.a();
                aVar.l(this.f1467f);
                return aVar;
            }
            return (c.a.a0.l0.q.c) invokeV.objValue;
        }

        public b t(C0060a c0060a) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c0060a)) == null) {
                if (c0060a != null) {
                    c.a.a0.x.a.b(this.f1467f, c0060a);
                }
                return this;
            }
            return (b) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(View view);
    }

    /* loaded from: classes.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f1468b;

        /* renamed from: c  reason: collision with root package name */
        public LinearLayout f1469c;

        /* renamed from: d  reason: collision with root package name */
        public a f1470d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1471e;

        /* renamed from: c.a.a0.l0.q.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class View$OnClickListenerC0061a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ C0060a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f1472b;

            public View$OnClickListenerC0061a(d dVar, C0060a c0060a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, c0060a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f1472b = dVar;
                this.a = c0060a;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    this.f1472b.f1470d.dismiss();
                    c cVar = this.a.f1466e;
                    if (cVar != null) {
                        cVar.a(view);
                    }
                }
            }
        }

        public d(a aVar, View view, a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, view, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1471e = aVar;
            if (view != null) {
                this.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090dff);
                this.f1468b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090dfe);
                this.f1469c = (LinearLayout) view;
                this.f1470d = aVar2;
            }
        }

        public void a(C0060a c0060a) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, c0060a) == null) || c0060a == null) {
                return;
            }
            this.a.setText(c0060a.a);
            if (c0060a.f1464c > 0) {
                this.a.setTextColor(this.f1471e.f1457c.getResources().getColor(c0060a.f1464c));
            }
            if (!TextUtils.isEmpty(c0060a.f1463b)) {
                this.f1468b.setVisibility(0);
                this.f1468b.setText(c0060a.f1463b);
            } else {
                this.f1468b.setVisibility(8);
            }
            if (c0060a.f1465d > 0) {
                this.f1468b.setTextColor(this.f1471e.f1457c.getResources().getColor(c0060a.f1465d));
            }
            this.f1469c.setOnClickListener(new View$OnClickListenerC0061a(this, c0060a));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, R.style.obfuscated_res_0x7f100132);
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
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1461g = new ArrayList();
        this.f1462h = 2;
    }

    public final LinearLayout g(C0060a c0060a, LinearLayout linearLayout, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, c0060a, linearLayout, i)) == null) {
            LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.f1459e).inflate(R.layout.obfuscated_res_0x7f0d05b6, (ViewGroup) linearLayout, false);
            linearLayout2.setBackground(getContext().getResources().getDrawable(i));
            new d(this, linearLayout2, this).a(c0060a);
            return linearLayout2;
        }
        return (LinearLayout) invokeLLI.objValue;
    }

    public final void h(List<C0060a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(this.f1459e);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        int size = list.size();
        if (size == 0) {
            return;
        }
        if (size == 1) {
            linearLayout.setOrientation(0);
            linearLayout.addView(g(list.get(0), linearLayout, R.drawable.obfuscated_res_0x7f080d75));
        } else if (size == this.f1462h) {
            linearLayout.setOrientation(0);
            linearLayout.addView(g(list.get(0), linearLayout, R.drawable.obfuscated_res_0x7f080d73));
            linearLayout.addView(j(0));
            linearLayout.addView(g(list.get(1), linearLayout, R.drawable.obfuscated_res_0x7f080d77));
        } else {
            linearLayout.setOrientation(1);
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    linearLayout.addView(g(list.get(i), linearLayout, R.drawable.obfuscated_res_0x7f080d71));
                    linearLayout.addView(j(1));
                } else if (i == list.size() - 1) {
                    linearLayout.addView(g(list.get(i), linearLayout, R.drawable.obfuscated_res_0x7f080d75));
                }
            }
        }
        this.f1458d.removeAllViews();
        this.f1458d.addView(linearLayout);
    }

    public View i(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return null;
        }
        return (View) invokeL.objValue;
    }

    public final View j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            View view = new View(this.f1459e);
            view.setBackgroundColor(this.f1457c.getResources().getColor(R.color.obfuscated_res_0x7f0607fd));
            if (i == 1) {
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
            } else {
                view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
            }
            return view;
        }
        return (View) invokeI.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Context context = getContext();
            this.f1459e = context;
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05dc, a().c(), false);
            this.f1456b = viewGroup;
            this.f1457c = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f090e00);
            this.f1460f = this.f1456b.findViewById(R.id.obfuscated_res_0x7f090e01);
            this.f1458d = (FrameLayout) this.f1456b.findViewById(R.id.obfuscated_res_0x7f090dfd);
            View i = i(this.f1457c);
            if (i != null) {
                this.f1457c.addView(i);
            }
            m();
            h(this.f1461g);
        }
    }

    public final void l(List<C0060a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f1461g.clear();
            if (list != null) {
                c.a.a0.x.a.c(this.f1461g, list);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f1460f.setBackgroundColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0607fd));
        }
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            k();
            a().q(this.f1456b);
        }
    }
}
