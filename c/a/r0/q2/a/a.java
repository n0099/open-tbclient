package c.a.r0.q2.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pluginCenter.PluginConfigWrapper;
import com.baidu.tieba.pluginCenter.view.CircleProgressBar;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends c.a.q0.k0.f.a<PluginConfigWrapper, c.a.q0.k0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public CircleProgressBar p;

    /* renamed from: c.a.r0.q2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1126a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24211e;

        public View$OnClickListenerC1126a(a aVar) {
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
            this.f24211e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.k0.c.b bVar = new c.a.q0.k0.c.b(3, this.f24211e.c(), null, null);
                bVar.i(this.f24211e.j());
                this.f24211e.d().dispatchMvcEvent(bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f24212e;

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
            this.f24212e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.q0.k0.c.b bVar = new c.a.q0.k0.c.b(2, this.f24212e.c(), null, null);
                bVar.i(this.f24212e.j());
                this.f24212e.d().dispatchMvcEvent(bVar);
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
        this.k = (TbImageView) view.findViewById(R.id.icon);
        this.l = (TextView) view.findViewById(R.id.title);
        this.m = (TextView) view.findViewById(R.id.desc);
        TextView textView = (TextView) view.findViewById(R.id.status);
        this.n = textView;
        textView.setOnClickListener(new View$OnClickListenerC1126a(this));
        TextView textView2 = (TextView) view.findViewById(R.id.install);
        this.o = textView2;
        textView2.setOnClickListener(new b(this));
        this.p = (CircleProgressBar) view.findViewById(R.id.install_progress);
    }

    @Override // c.a.r0.j3.u
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2)) == null) {
            c.a.q0.w0.a.a(tbPageContext, g());
            this.p.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.p.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            return true;
        }
        return invokeLI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.k0.f.e
    /* renamed from: q */
    public void k(PluginConfigWrapper pluginConfigWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pluginConfigWrapper) == null) {
            super.k(pluginConfigWrapper);
            if (pluginConfigWrapper == null) {
                return;
            }
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.k.startLoad(pluginConfigWrapper.icon, 10, false);
            }
            this.l.setText(pluginConfigWrapper.display_name);
            this.m.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.O().y(pluginConfigWrapper.package_name)) {
                this.o.setVisibility(8);
                this.p.setVisibility(8);
                this.n.setVisibility(0);
                this.n.setText(R.string.view);
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
}
