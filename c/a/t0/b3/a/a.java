package c.a.t0.b3.a;

import android.view.View;
import android.widget.TextView;
import c.a.t0.c3.d;
import c.a.t0.c3.f;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
import com.baidu.tieba.pluginCenter.view.CircleProgressBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends c.a.s0.l0.f.a<PluginConfigWrapper, c.a.s0.l0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public CircleProgressBar p;

    /* renamed from: c.a.t0.b3.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC0983a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15396e;

        public View$OnClickListenerC0983a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15396e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.s0.l0.c.b bVar = new c.a.s0.l0.c.b(3, this.f15396e.a(), null, null);
                bVar.i(this.f15396e.g());
                this.f15396e.b().dispatchMvcEvent(bVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f15397e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15397e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.s0.l0.c.b bVar = new c.a.s0.l0.c.b(2, this.f15397e.a(), null, null);
                bVar.i(this.f15397e.g());
                this.f15397e.b().dispatchMvcEvent(bVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, viewEventCenter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = (TbImageView) view.findViewById(d.icon);
        this.l = (TextView) view.findViewById(d.title);
        this.m = (TextView) view.findViewById(d.desc);
        TextView textView = (TextView) view.findViewById(d.status);
        this.n = textView;
        textView.setOnClickListener(new View$OnClickListenerC0983a(this));
        TextView textView2 = (TextView) view.findViewById(d.install);
        this.o = textView2;
        textView2.setOnClickListener(new b(this));
        this.p = (CircleProgressBar) view.findViewById(d.install_progress);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.l0.f.e
    /* renamed from: n */
    public void h(PluginConfigWrapper pluginConfigWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pluginConfigWrapper) == null) {
            super.h(pluginConfigWrapper);
            if (pluginConfigWrapper == null) {
                return;
            }
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.k.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.l.setText(pluginConfigWrapper.display_name);
            this.m.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.u().l(pluginConfigWrapper.package_name)) {
                this.o.setVisibility(8);
                this.p.setVisibility(8);
                this.n.setVisibility(0);
                this.n.setText(f.view);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.p.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.p.setVisibility(0);
            } else {
                this.n.setVisibility(8);
                this.o.setVisibility(0);
                this.p.setVisibility(8);
            }
        }
    }

    @Override // c.a.t0.x3.u
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2)) == null) {
            c.a.s0.x0.a.a(tbPageContext, d());
            this.p.setCircleForegroundColor(SkinManager.getColor(c.a.t0.c3.a.CAM_X0302));
            this.p.setCircleBackgroundColor(SkinManager.getColor(c.a.t0.c3.a.CAM_X0109));
            return true;
        }
        return invokeLI.booleanValue;
    }
}
