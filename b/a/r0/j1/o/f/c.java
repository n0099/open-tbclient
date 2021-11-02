package b.a.r0.j1.o.f;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.m.d;
import b.a.r0.j1.e;
import b.a.r0.j1.f;
import b.a.r0.j1.l.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Animation f18565a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f18566b;

    /* renamed from: c  reason: collision with root package name */
    public View f18567c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f18568d;

    /* renamed from: e  reason: collision with root package name */
    public View f18569e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC0940c f18570f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.j1.o.f.b f18571g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18572h;

    /* renamed from: i  reason: collision with root package name */
    public int f18573i;

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f18574e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f18575f;

        public a(c cVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18575f = cVar;
            this.f18574e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, this.f18575f.f18571g.getItem(i2)));
                this.f18575f.f(this.f18574e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18576a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18576a = cVar;
        }

        @Override // b.a.e.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f18576a.f18572h = false;
                if (this.f18576a.f18570f != null) {
                    this.f18576a.f18570f.a();
                }
                this.f18576a.f18568d.removeView(this.f18576a.f18567c);
            }
        }
    }

    /* renamed from: b.a.r0.j1.o.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0940c {
        void a();
    }

    public c(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18572h = false;
        this.f18568d = viewGroup;
    }

    public void f(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.f18567c) == null) {
            return;
        }
        view.startAnimation(i(context));
    }

    public final View g(Context context, List<p> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, i2)) == null) {
            View inflate = LayoutInflater.from(context).inflate(f.topic_scroll_fragment_more, (ViewGroup) null);
            this.f18569e = inflate.findViewById(e.topic_more_top_view);
            k(this.f18573i);
            GridView gridView = (GridView) inflate.findViewById(e.topic_scroll_fragment_more_content);
            gridView.setSelector(new ColorDrawable(17170445));
            b.a.r0.j1.o.f.b bVar = new b.a.r0.j1.o.f.b(context, i2);
            this.f18571g = bVar;
            bVar.b(list);
            gridView.setAdapter((ListAdapter) this.f18571g);
            gridView.setOnItemClickListener(new a(this, context));
            return inflate;
        }
        return (View) invokeLLI.objValue;
    }

    public final Animation h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f18565a == null) {
                this.f18565a = AnimationUtils.loadAnimation(context, b.a.r0.j1.a.dialog_ani_t2b_enter);
            }
            return this.f18565a;
        }
        return (Animation) invokeL.objValue;
    }

    public final Animation i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f18566b == null) {
                this.f18566b = AnimationUtils.loadAnimation(context, b.a.r0.j1.a.dialog_ani_t2b_exit);
            }
            this.f18566b.setAnimationListener(new b(this));
            return this.f18566b;
        }
        return (Animation) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18572h : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f18569e.getLayoutParams();
            layoutParams.height = i2;
            this.f18569e.setLayoutParams(layoutParams);
        }
    }

    public void l(InterfaceC0940c interfaceC0940c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0940c) == null) {
            this.f18570f = interfaceC0940c;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f18573i = i2;
        }
    }

    public void n(Context context, List<p> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, list, i2) == null) || this.f18572h) {
            return;
        }
        this.f18572h = true;
        View g2 = g(context, list, i2);
        this.f18567c = g2;
        this.f18568d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f18567c;
            view.setBackgroundColor(view.getContext().getResources().getColor(b.a.r0.j1.b.topic_more_background));
        } else {
            View view2 = this.f18567c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(b.a.r0.j1.b.topic_more_background_1));
        }
        this.f18567c.startAnimation(h(context));
    }
}
