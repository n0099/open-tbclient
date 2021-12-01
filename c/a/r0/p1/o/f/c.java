package c.a.r0.p1.o.f;

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
import c.a.d.f.m.d;
import c.a.r0.p1.e;
import c.a.r0.p1.f;
import c.a.r0.p1.l.p;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Animation a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f21267b;

    /* renamed from: c  reason: collision with root package name */
    public View f21268c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f21269d;

    /* renamed from: e  reason: collision with root package name */
    public View f21270e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC1253c f21271f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.p1.o.f.b f21272g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21273h;

    /* renamed from: i  reason: collision with root package name */
    public int f21274i;

    /* loaded from: classes6.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f21275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f21276f;

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
            this.f21276f = cVar;
            this.f21275e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, this.f21276f.f21272g.getItem(i2)));
                this.f21276f.f(this.f21275e);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

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
            this.a = cVar;
        }

        @Override // c.a.d.f.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.f21273h = false;
                if (this.a.f21271f != null) {
                    this.a.f21271f.a();
                }
                this.a.f21269d.removeView(this.a.f21268c);
            }
        }
    }

    /* renamed from: c.a.r0.p1.o.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1253c {
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
        this.f21273h = false;
        this.f21269d = viewGroup;
    }

    public void f(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.f21268c) == null) {
            return;
        }
        view.startAnimation(i(context));
    }

    public final View g(Context context, List<p> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, i2)) == null) {
            View inflate = LayoutInflater.from(context).inflate(f.topic_scroll_fragment_more, (ViewGroup) null);
            this.f21270e = inflate.findViewById(e.topic_more_top_view);
            k(this.f21274i);
            GridView gridView = (GridView) inflate.findViewById(e.topic_scroll_fragment_more_content);
            gridView.setSelector(new ColorDrawable(17170445));
            c.a.r0.p1.o.f.b bVar = new c.a.r0.p1.o.f.b(context, i2);
            this.f21272g = bVar;
            bVar.b(list);
            gridView.setAdapter((ListAdapter) this.f21272g);
            gridView.setOnItemClickListener(new a(this, context));
            return inflate;
        }
        return (View) invokeLLI.objValue;
    }

    public final Animation h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.a == null) {
                this.a = AnimationUtils.loadAnimation(context, c.a.r0.p1.a.dialog_ani_t2b_enter);
            }
            return this.a;
        }
        return (Animation) invokeL.objValue;
    }

    public final Animation i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f21267b == null) {
                this.f21267b = AnimationUtils.loadAnimation(context, c.a.r0.p1.a.dialog_ani_t2b_exit);
            }
            this.f21267b.setAnimationListener(new b(this));
            return this.f21267b;
        }
        return (Animation) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21273h : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f21270e.getLayoutParams();
            layoutParams.height = i2;
            this.f21270e.setLayoutParams(layoutParams);
        }
    }

    public void l(InterfaceC1253c interfaceC1253c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1253c) == null) {
            this.f21271f = interfaceC1253c;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f21274i = i2;
        }
    }

    public void n(Context context, List<p> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, list, i2) == null) || this.f21273h) {
            return;
        }
        this.f21273h = true;
        View g2 = g(context, list, i2);
        this.f21268c = g2;
        this.f21269d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f21268c;
            view.setBackgroundColor(view.getContext().getResources().getColor(c.a.r0.p1.b.topic_more_background));
        } else {
            View view2 = this.f21268c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(c.a.r0.p1.b.topic_more_background_1));
        }
        this.f21268c.startAnimation(h(context));
    }
}
