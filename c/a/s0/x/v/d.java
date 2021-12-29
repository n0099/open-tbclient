package c.a.s0.x.v;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.x.v.g.e;
import c.a.s0.x.x.d.b;
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
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;

    /* renamed from: b  reason: collision with root package name */
    public Context f14548b;

    /* renamed from: c  reason: collision with root package name */
    public View f14549c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.x.v.e.a f14550d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.s0.x.v.f.b f14551e;

    public d(Context context, View view, c.a.s0.x.v.e.a aVar) {
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
        if (i(context, view, aVar)) {
            this.f14548b = context;
            this.f14549c = view;
            this.f14550d = aVar;
            c();
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (this.f14549c instanceof RelativeLayout)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.f14549c).addView(this.a, layoutParams);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a.hide();
            if (this.f14549c == null || this.a.getParent() == null) {
                return;
            }
            View view = this.f14549c;
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
            EditorTools a = ((c.a.s0.x.v.g.d) new e(this.f14550d).a(this.f14548b)).a();
            this.a = a;
            a.setId(R.id.local_input_tool);
            this.a.setOnCancelClickListener(new View.OnClickListener() { // from class: c.a.s0.x.v.b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        d.this.f(view);
                    }
                }
            });
            Context context = this.f14548b;
            if (context instanceof Activity) {
                c.a.s0.x.x.d.b.b((Activity) context, this.a.mED, new b.InterfaceC0895b() { // from class: c.a.s0.x.v.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // c.a.s0.x.x.d.b.InterfaceC0895b
                    public final void onKeyboardShowing(boolean z) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z) == null) {
                            d.this.g(z);
                        }
                    }
                });
            }
            ((LocalInputContainer) this.a.findToolById(36).f14538k).setSendBtnClickListener(new LocalInputContainer.c() { // from class: c.a.s0.x.v.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tbadk.editortools.local.view.LocalInputContainer.c
                public final void a(c.a.s0.x.v.e.a aVar, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar, str) == null) {
                        d.this.h(aVar, str);
                    }
                }
            });
            a();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f14551e = new c.a.s0.x.v.f.b(this.f14550d);
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

    public /* synthetic */ void h(c.a.s0.x.v.e.a aVar, String str) {
        c.a.s0.x.v.f.b bVar = this.f14551e;
        if (bVar != null) {
            bVar.d(aVar, str);
            b();
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SEND_BTN_CLICK);
            statisticItem.addParam("obj_id", aVar.a().f14469e);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean i(Context context, View view, c.a.s0.x.v.e.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, view, aVar)) == null) ? (!(context instanceof Activity) || view == null || aVar == null) ? false : true : invokeLLL.booleanValue;
    }

    public void j() {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.display();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCAL_INOUT_SHOW);
        statisticItem.addParam("obj_id", this.f14550d.a().f14469e);
        TiebaStatic.log(statisticItem);
    }
}
