package c.a.s0.x.v;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import c.a.s0.x.n;
import c.a.s0.x.v.h.f;
import c.a.s0.x.x.d.b;
import c.a.t0.w3.a0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.local.view.LocalInputContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14207b;

    /* renamed from: c  reason: collision with root package name */
    public View f14208c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.x.v.f.a f14209d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.x.v.g.b f14210e;

    public e(Context context, View view, c.a.s0.x.v.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (k(context, view, aVar)) {
            this.f14207b = context;
            this.f14208c = view;
            this.f14209d = aVar;
            c();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f14208c instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.f14208c).addView(this.a, layoutParams);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            this.a.hide();
            if (this.f14208c == null || this.a.getParent() == null) {
                return;
            }
            View view = this.f14208c;
            if (view instanceof RelativeLayout) {
                ((RelativeLayout) view).removeView(this.a);
            }
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d();
            e();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            EditorTools a = ((c.a.s0.x.v.h.e) new f(this.f14209d).a(this.f14207b)).a();
            this.a = a;
            a.setId(R.id.local_input_tool);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: c.a.s0.x.v.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        e.this.f(view);
                    }
                }
            });
            Context context = this.f14207b;
            if (context instanceof Activity) {
                c.a.s0.x.x.d.b.b((Activity) context, this.a.mED, new b.InterfaceC0908b() { // from class: c.a.s0.x.v.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // c.a.s0.x.x.d.b.InterfaceC0908b
                    public final void onKeyboardShowing(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            e.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.findToolById(36).k).setSendBtnClickListener(new LocalInputContainer.c() { // from class: c.a.s0.x.v.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(c.a.s0.x.v.f.a aVar, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar, str) == null) {
                        e.this.h(aVar, str);
                    }
                }
            });
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14210e = new c.a.s0.x.v.g.b(this.f14209d);
        }
    }

    public /* synthetic */ void f(View view) {
        b();
    }

    public /* synthetic */ void g(boolean z) {
        if (z) {
            this.a.mED.setVisibility(0);
        } else {
            this.a.mED.hideWhenKeyboardNotShow();
        }
    }

    public /* synthetic */ void h(c.a.s0.x.v.f.a aVar, String str) {
        c.a.s0.x.v.g.b bVar = this.f14210e;
        if (bVar != null) {
            bVar.f(aVar, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", aVar.a().f14132e);
            TiebaStatic.log(statisticItem);
        }
    }

    public /* synthetic */ void i(String str) {
        this.a.sendAction(new c.a.s0.x.a(6, 36, str));
    }

    public final void j() {
        c.a.s0.x.v.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f14210e) == null) {
            return;
        }
        bVar.d(new a0.g() { // from class: c.a.s0.x.v.b
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.t0.w3.a0.g
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    e.this.i(str);
                }
            }
        });
    }

    public final boolean k(Context context, View view, c.a.s0.x.v.f.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view, aVar)) == null) ? (!(context instanceof Activity) || view == null || aVar == null) ? false : true : invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.a) == null || editorTools.findToolById(36) == null) {
            return;
        }
        n nVar = this.a.findToolById(36).k;
        if (nVar instanceof LocalInputContainer) {
            String inputContentDraft = ((LocalInputContainer) nVar).getInputContentDraft();
            c.a.s0.x.v.g.b bVar = this.f14210e;
            if (bVar != null) {
                bVar.e(inputContentDraft);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.a == null) {
            return;
        }
        j();
        this.a.display();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SHOW);
        statisticItem.addParam("obj_id", this.f14209d.a().f14132e);
        TiebaStatic.log(statisticItem);
    }
}
