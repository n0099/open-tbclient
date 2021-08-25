package c.a.q0.h1.f.f;

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
import c.a.q0.h1.c.p;
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
    public Animation f18750a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f18751b;

    /* renamed from: c  reason: collision with root package name */
    public View f18752c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f18753d;

    /* renamed from: e  reason: collision with root package name */
    public View f18754e;

    /* renamed from: f  reason: collision with root package name */
    public InterfaceC0898c f18755f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.h1.f.f.b f18756g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f18757h;

    /* renamed from: i  reason: collision with root package name */
    public int f18758i;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f18759e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f18760f;

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
            this.f18760f = cVar;
            this.f18759e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001433, this.f18760f.f18756g.getItem(i2)));
                this.f18760f.f(this.f18759e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f18761a;

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
            this.f18761a = cVar;
        }

        @Override // c.a.e.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f18761a.f18757h = false;
                if (this.f18761a.f18755f != null) {
                    this.f18761a.f18755f.a();
                }
                this.f18761a.f18753d.removeView(this.f18761a.f18752c);
            }
        }
    }

    /* renamed from: c.a.q0.h1.f.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0898c {
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
        this.f18757h = false;
        this.f18753d = viewGroup;
    }

    public void f(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.f18752c) == null) {
            return;
        }
        view.startAnimation(i(context));
    }

    public final View g(Context context, List<p> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, i2)) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.topic_scroll_fragment_more, (ViewGroup) null);
            this.f18754e = inflate.findViewById(R.id.topic_more_top_view);
            k(this.f18758i);
            GridView gridView = (GridView) inflate.findViewById(R.id.topic_scroll_fragment_more_content);
            gridView.setSelector(new ColorDrawable(17170445));
            c.a.q0.h1.f.f.b bVar = new c.a.q0.h1.f.f.b(context, i2);
            this.f18756g = bVar;
            bVar.b(list);
            gridView.setAdapter((ListAdapter) this.f18756g);
            gridView.setOnItemClickListener(new a(this, context));
            return inflate;
        }
        return (View) invokeLLI.objValue;
    }

    public final Animation h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f18750a == null) {
                this.f18750a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
            }
            return this.f18750a;
        }
        return (Animation) invokeL.objValue;
    }

    public final Animation i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f18751b == null) {
                this.f18751b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
            }
            this.f18751b.setAnimationListener(new b(this));
            return this.f18751b;
        }
        return (Animation) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f18757h : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f18754e.getLayoutParams();
            layoutParams.height = i2;
            this.f18754e.setLayoutParams(layoutParams);
        }
    }

    public void l(InterfaceC0898c interfaceC0898c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC0898c) == null) {
            this.f18755f = interfaceC0898c;
        }
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f18758i = i2;
        }
    }

    public void n(Context context, List<p> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, list, i2) == null) || this.f18757h) {
            return;
        }
        this.f18757h = true;
        View g2 = g(context, list, i2);
        this.f18752c = g2;
        this.f18753d.addView(g2);
        if (1 != TbadkCoreApplication.getInst().getSkinType() && 4 != TbadkCoreApplication.getInst().getSkinType()) {
            View view = this.f18752c;
            view.setBackgroundColor(view.getContext().getResources().getColor(R.color.topic_more_background));
        } else {
            View view2 = this.f18752c;
            view2.setBackgroundColor(view2.getContext().getResources().getColor(R.color.topic_more_background_1));
        }
        this.f18752c.startAnimation(h(context));
    }
}
