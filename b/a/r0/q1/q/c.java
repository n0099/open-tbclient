package b.a.r0.q1.q;

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
import b.a.e.e.m.d;
import b.a.r0.q1.p.e;
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
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Animation f22758a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f22759b;

    /* renamed from: c  reason: collision with root package name */
    public View f22760c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f22761d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1111c f22762e;

    /* renamed from: f  reason: collision with root package name */
    public b.a.r0.q1.q.b f22763f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f22764g;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f22765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f22766f;

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
            this.f22766f = cVar;
            this.f22765e = context;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                e item = this.f22766f.f22763f.getItem(i2);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016448));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, item));
                this.f22766f.f(this.f22765e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f22767a;

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
            this.f22767a = cVar;
        }

        @Override // b.a.e.e.m.d, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.f22767a.f22764g = false;
                if (this.f22767a.f22762e != null) {
                    this.f22767a.f22762e.a();
                }
                this.f22767a.f22761d.removeView(this.f22767a.f22760c);
            }
        }
    }

    /* renamed from: b.a.r0.q1.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
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
        this.f22764g = false;
        this.f22761d = viewGroup;
    }

    public void f(Context context) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, context) == null) || (view = this.f22760c) == null) {
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
            b.a.r0.q1.q.b bVar = new b.a.r0.q1.q.b(context, i2);
            this.f22763f = bVar;
            bVar.b(list);
            gridView.setAdapter((ListAdapter) this.f22763f);
            gridView.setOnItemClickListener(new a(this, context));
            return inflate;
        }
        return (View) invokeLLI.objValue;
    }

    public final Animation h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f22758a == null) {
                this.f22758a = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_enter);
            }
            return this.f22758a;
        }
        return (Animation) invokeL.objValue;
    }

    public final Animation i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (this.f22759b == null) {
                this.f22759b = AnimationUtils.loadAnimation(context, R.anim.dialog_ani_t2b_exit);
            }
            this.f22759b.setAnimationListener(new b(this));
            return this.f22759b;
        }
        return (Animation) invokeL.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f22764g : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f22760c, R.color.CAM_X0111);
            b.a.r0.q1.q.b bVar = this.f22763f;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
        }
    }

    public void l(InterfaceC1111c interfaceC1111c) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1111c) == null) {
            this.f22762e = interfaceC1111c;
        }
    }

    public void m(Context context, List<e> list, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048583, this, context, list, i2) == null) || this.f22764g) {
            return;
        }
        this.f22764g = true;
        View g2 = g(context, list, i2);
        this.f22760c = g2;
        this.f22761d.addView(g2);
        SkinManager.setBackgroundColor(this.f22760c, R.color.CAM_X0111);
        this.f22760c.startAnimation(h(context));
    }
}
