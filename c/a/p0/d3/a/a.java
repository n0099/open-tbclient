package c.a.p0.d3.a;

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
/* loaded from: classes2.dex */
public class a extends c.a.o0.k0.f.a<PluginConfigWrapper, c.a.o0.k0.d.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f13660g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f13661h;
    public TextView i;
    public TextView j;
    public TextView k;
    public CircleProgressBar l;

    /* renamed from: c.a.p0.d3.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1032a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1032a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.k0.c.b bVar = new c.a.o0.k0.c.b(3, this.a.b(), null, null);
                bVar.i(this.a.h());
                this.a.c().dispatchMvcEvent(bVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.o0.k0.c.b bVar = new c.a.o0.k0.c.b(2, this.a.b(), null, null);
                bVar.i(this.a.h());
                this.a.c().dispatchMvcEvent(bVar);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f13660g = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f090e06);
        this.f13661h = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09202b);
        this.i = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090777);
        TextView textView = (TextView) view.findViewById(R.id.obfuscated_res_0x7f091da7);
        this.j = textView;
        textView.setOnClickListener(new View$OnClickListenerC1032a(this));
        TextView textView2 = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090f07);
        this.k = textView2;
        textView2.setOnClickListener(new b(this));
        this.l = (CircleProgressBar) view.findViewById(R.id.obfuscated_res_0x7f090f0e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.o0.k0.f.e
    /* renamed from: o */
    public void i(PluginConfigWrapper pluginConfigWrapper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pluginConfigWrapper) == null) {
            super.i(pluginConfigWrapper);
            if (pluginConfigWrapper == null) {
                return;
            }
            if (!StringUtils.isNull(pluginConfigWrapper.icon)) {
                this.f13660g.J(pluginConfigWrapper.icon, 10, false);
            }
            this.f13661h.setText(pluginConfigWrapper.display_name);
            this.i.setText(pluginConfigWrapper.verbose);
            if (PluginPackageManager.u().l(pluginConfigWrapper.package_name)) {
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                this.j.setVisibility(0);
                this.j.setText(R.string.obfuscated_res_0x7f0f14fc);
            } else if (pluginConfigWrapper.getDownLoadStatus() == 3) {
                this.l.setProgress(pluginConfigWrapper.getDownLoadPercent());
                this.j.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(0);
            } else {
                this.j.setVisibility(8);
                this.k.setVisibility(0);
                this.l.setVisibility(8);
            }
        }
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            c.a.o0.w0.a.a(tbPageContext, e());
            this.l.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.l.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            return true;
        }
        return invokeLI.booleanValue;
    }
}
