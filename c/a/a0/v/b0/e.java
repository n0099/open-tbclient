package c.a.a0.v.b0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.bubble.BubbleManager;
import com.baidu.nadcore.widget.bubble.BubblePosition;
import com.baidu.searchbox.player.event.PlayerEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class e extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f1658b;
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public c.a.a0.l0.p.d.d f1659c;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public boolean f1660d;

    /* loaded from: classes.dex */
    public static final class a implements BubbleManager.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.f1658b = null;
            }
        }

        @Override // com.baidu.nadcore.widget.bubble.BubbleManager.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // c.a.a0.v.b0.a
    public void k(c.a.a0.v.c0.p event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (Intrinsics.areEqual(event.c(), PlayerEvent.ACTION_ON_INFO)) {
                int g2 = event.g(1);
                if ((g2 == 904 || g2 == 956) && w() != null) {
                    y();
                }
            }
        }
    }

    @Override // c.a.a0.v.b0.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.m();
            this.f1658b = null;
            c.a.a0.l0.p.d.d dVar = this.f1659c;
            if (dVar != null) {
                dVar.k();
            }
        }
    }

    public void v() {
        c.a.a0.l0.p.d.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (dVar = this.f1659c) == null) {
            return;
        }
        dVar.c();
    }

    public View w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f0b47);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…eo_switch_fullscreen_tip)");
            return string;
        }
        return (String) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f1660d && this.f1658b != null) {
            if (!q().V0()) {
                r().W(true, true);
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int color = context.getResources().getColor(R.color.obfuscated_res_0x7f06083b);
            c.a.a0.l0.p.c.c cVar = (c.a.a0.l0.p.c.c) BubbleManager.t(c.a.a0.l0.p.c.c.class);
            cVar.j(w(), this.f1658b);
            cVar.q(x());
            cVar.r(-1, -1);
            cVar.l(color, color);
            cVar.m(1, 12.0f);
            cVar.p(-2.0f);
            cVar.n(BubblePosition.DOWN);
            cVar.k(5000);
            cVar.i(true);
            cVar.o(new a(this));
            c.a.a0.l0.p.d.d h2 = cVar.h();
            this.f1659c = h2;
            if (h2 != null) {
                h2.p();
            }
            this.f1660d = false;
            r().T(5000);
        }
    }
}
