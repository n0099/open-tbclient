package c.a.r0.q1.q;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import c.a.e.e.m.d;
import c.a.r0.q1.p.e;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
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
    public Animation f23873a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f23874b;

    /* renamed from: c  reason: collision with root package name */
    public View f23875c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f23876d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1111c f23877e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.r0.q1.q.b f23878f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23879g;

    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f23880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f23881f;

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
            this.f23881f = cVar;
            this.f23880e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                e item = this.f23881f.f23878f.getItem(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
                this.f23881f.f(this.f23880e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f23882a;

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
            this.f23882a = cVar;
        }

        @Override // c.a.e.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f23882a.f23879g = false;
                if (this.f23882a.f23877e != null) {
                    this.f23882a.f23877e.a();
                }
                this.f23882a.f23876d.removeView(this.f23882a.f23875c);
            }
        }
    }

    /* renamed from: c.a.r0.q1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1111c {
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
        this.f23879g = false;
        this.f23876d = viewGroup;
    }

    public void f(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.f23875c) == null) {
            return;
        }
        view.startAnimation(i(context));
    }

    public final View g(Context context, List<e> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, i2)) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.lego_scroll_fragment_more, (ViewGroup) null);
            GridView gridView = (GridView) inflate.findViewById(R.id.scroll_fragment_more_content);
            gridView.setSelector(new ColorDrawable(context.getResources().getColor(17170445)));
            c.a.r0.q1.q.b bVar = new c.a.r0.q1.q.b(context, i2);
            this.f23878f = bVar;
            bVar.b(list);
            gridView.setAdapter((ListAdapter) this.f23878f);
            gridView.setOnItemClickListener(new a(this, context));
            return inflate;
        }
        return (View) invokeLLI.objValue;
    }

    public final Animation h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f23873a == null) {
                this.f23873a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
            }
            return this.f23873a;
        }
        return (Animation) invokeL.objValue;
    }

    public final Animation i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f23874b == null) {
                this.f23874b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
            }
            this.f23874b.setAnimationListener(new b(this));
            return this.f23874b;
        }
        return (Animation) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23879g : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f23875c, R.color.CAM_X0111);
            c.a.r0.q1.q.b bVar = this.f23878f;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
        }
    }

    public void l(InterfaceC1111c interfaceC1111c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1111c) == null) {
            this.f23877e = interfaceC1111c;
        }
    }

    public void m(Context context, List<e> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, context, list, i2) == null) || this.f23879g) {
            return;
        }
        this.f23879g = true;
        View g2 = g(context, list, i2);
        this.f23875c = g2;
        this.f23876d.addView(g2);
        SkinManager.setBackgroundColor(this.f23875c, R.color.CAM_X0111);
        this.f23875c.startAnimation(h(context));
    }
}
