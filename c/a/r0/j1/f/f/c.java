package c.a.r0.j1.f.f;

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
import c.a.e.e.m.d;
import c.a.r0.j1.c.p;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Animation f19592a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f19593b;

    /* renamed from: c  reason: collision with root package name */
    public View f19594c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f19595d;

    /* renamed from: e  reason: collision with root package name */
    public View f19596e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC0942c f19597f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.j1.f.f.b f19598g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f19599h;

    /* renamed from: i  reason: collision with root package name */
    public int f19600i;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f19601e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f19602f;

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
            this.f19602f = cVar;
            this.f19601e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, this.f19602f.f19598g.getItem(i2)));
                this.f19602f.f(this.f19601e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19603a;

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
            this.f19603a = cVar;
        }

        @Override // c.a.e.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f19603a.f19599h = false;
                if (this.f19603a.f19597f != null) {
                    this.f19603a.f19597f.a();
                }
                this.f19603a.f19595d.removeView(this.f19603a.f19594c);
            }
        }
    }

    /* renamed from: c.a.r0.j1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0942c {
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
        this.f19599h = false;
        this.f19595d = viewGroup;
    }

    public void f(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.f19594c) == null) {
            return;
        }
        view.startAnimation(i(context));
    }

    public final View g(Context context, List<p> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, i2)) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
            this.f19596e = inflate.findViewById(R.id.topic_more_top_view);
            k(this.f19600i);
            GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
            gridView.setSelector(new ColorDrawable(17170445));
            c.a.r0.j1.f.f.b bVar = new c.a.r0.j1.f.f.b(context, i2);
            this.f19598g = bVar;
            bVar.b(list);
            gridView.setAdapter((ListAdapter) this.f19598g);
            gridView.setOnItemClickListener(new a(this, context));
            return inflate;
        }
        return (View) invokeLLI.objValue;
    }

    public final Animation h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f19592a == null) {
                this.f19592a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
            }
            return this.f19592a;
        }
        return (Animation) invokeL.objValue;
    }

    public final Animation i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f19593b == null) {
                this.f19593b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
            }
            this.f19593b.setAnimationListener(new b(this));
            return this.f19593b;
        }
        return (Animation) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19599h : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19596e.getLayoutParams();
            layoutParams.height = i2;
            this.f19596e.setLayoutParams(layoutParams);
        }
    }

    public void l(InterfaceC0942c interfaceC0942c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0942c) == null) {
            this.f19597f = interfaceC0942c;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f19600i = i2;
        }
    }

    public void n(Context context, List<p> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, list, i2) == null) || this.f19599h) {
            return;
        }
        this.f19599h = true;
        View g2 = g(context, list, i2);
        this.f19594c = g2;
        this.f19595d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f19594c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f19594c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f19594c.startAnimation(h(context));
    }
}
