package c.a.o0.w.v;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import c.a.o0.w.n;
import c.a.o0.w.v.h.f;
import c.a.o0.w.x.d.b;
import c.a.p0.a4.b0;
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
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;

    /* renamed from: b  reason: collision with root package name */
    public Context f11522b;

    /* renamed from: c  reason: collision with root package name */
    public View f11523c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.w.v.f.a f11524d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.w.v.g.b f11525e;

    public e(Context context, View view, c.a.o0.w.v.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (k(context, view, aVar)) {
            this.f11522b = context;
            this.f11523c = view;
            this.f11524d = aVar;
            c();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f11523c instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.f11523c).addView(this.a, layoutParams);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            l();
            this.a.o();
            if (this.f11523c == null || this.a.getParent() == null) {
                return;
            }
            View view = this.f11523c;
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
            EditorTools a = ((c.a.o0.w.v.h.e) new f(this.f11524d).a(this.f11522b)).a();
            this.a = a;
            a.setId(R.id.obfuscated_res_0x7f091323);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: c.a.o0.w.v.c
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
            Context context = this.f11522b;
            if (context instanceof Activity) {
                c.a.o0.w.x.d.b.b((Activity) context, this.a.f30482b, new b.InterfaceC0867b() { // from class: c.a.o0.w.v.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // c.a.o0.w.x.d.b.InterfaceC0867b
                    public final void a(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            e.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.n(36).k).setSendBtnClickListener(new LocalInputContainer.c() { // from class: c.a.o0.w.v.d
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(c.a.o0.w.v.f.a aVar, String str) {
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
            this.f11525e = new c.a.o0.w.v.g.b(this.f11524d);
        }
    }

    public /* synthetic */ void f(View view) {
        b();
    }

    public /* synthetic */ void g(boolean z) {
        if (z) {
            this.a.f30482b.setVisibility(0);
            this.a.f30482b.setBackgroundColorId(R.color.CAM_X0207);
            return;
        }
        this.a.f30482b.o();
    }

    public /* synthetic */ void h(c.a.o0.w.v.f.a aVar, String str) {
        c.a.o0.w.v.g.b bVar = this.f11525e;
        if (bVar != null) {
            bVar.f(aVar, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", aVar.a().a);
            TiebaStatic.log(statisticItem);
        }
    }

    public /* synthetic */ void i(String str) {
        this.a.A(new c.a.o0.w.a(6, 36, str));
    }

    public final void j() {
        c.a.o0.w.v.g.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (bVar = this.f11525e) == null) {
            return;
        }
        bVar.d(new b0.g() { // from class: c.a.o0.w.v.a
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // c.a.p0.a4.b0.g
            public final void a(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                    e.this.i(str);
                }
            }
        });
    }

    public final boolean k(Context context, View view, c.a.o0.w.v.f.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, view, aVar)) == null) ? (!(context instanceof Activity) || view == null || aVar == null) ? false : true : invokeLLL.booleanValue;
    }

    public final void l() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (editorTools = this.a) == null || editorTools.n(36) == null) {
            return;
        }
        n nVar = this.a.n(36).k;
        if (nVar instanceof LocalInputContainer) {
            String inputContentDraft = ((LocalInputContainer) nVar).getInputContentDraft();
            c.a.o0.w.v.g.b bVar = this.f11525e;
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
        this.a.j();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SHOW);
        statisticItem.addParam("obj_id", this.f11524d.a().a);
        TiebaStatic.log(statisticItem);
    }
}
