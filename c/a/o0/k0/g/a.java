package c.a.o0.k0.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.o.e.b;
import c.a.p0.a4.v;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a extends b implements v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContextSupport f10388b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f10389c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressBar f10390d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f10391e;

    /* renamed from: f  reason: collision with root package name */
    public View f10392f;

    /* renamed from: g  reason: collision with root package name */
    public View f10393g;

    /* renamed from: h  reason: collision with root package name */
    public int f10394h;
    public ViewGroup i;
    public int j;

    public a(TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10388b = null;
        this.f10389c = null;
        this.f10390d = null;
        this.f10391e = null;
        this.f10392f = null;
        this.f10388b = tbPageContextSupport;
        this.f10394h = tbPageContextSupport.getPageContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
    }

    @Override // c.a.d.o.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.i == null) {
                this.f10392f = LayoutInflater.from(this.f10388b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fe, (ViewGroup) null);
            } else {
                this.f10392f = LayoutInflater.from(this.f10388b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05fe, this.i, false);
            }
            View view = this.f10392f;
            int i = this.f10394h;
            view.setPadding(0, i, 0, i);
            if (this.j != 0) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f10392f.getLayoutParams());
                layoutParams.height = this.j;
                this.f10392f.setLayoutParams(layoutParams);
            }
            this.f10389c = (TextView) this.f10392f.findViewById(R.id.obfuscated_res_0x7f0916ed);
            View findViewById = this.f10392f.findViewById(R.id.obfuscated_res_0x7f0916f0);
            this.f10393g = findViewById;
            findViewById.setVisibility(8);
            this.f10390d = (ProgressBar) this.f10392f.findViewById(R.id.obfuscated_res_0x7f091929);
            onChangeSkinType(this.f10388b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f10393g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.f10392f;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.o.e.b
    public void c() {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f10391e) == null) {
            return;
        }
        onClickListener.onClick(this.f10392f);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f10393g.setVisibility(0);
            View view = this.f10392f;
            int i = this.f10394h;
            view.setPadding(0, i, 0, i);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f10393g.setVisibility(8);
            this.f10392f.setPadding(0, 0, 0, 0);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f10390d.setVisibility(0);
            this.f10389c.setText(i);
            this.f10393g.setVisibility(0);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.f10390d.setVisibility(8);
            this.f10389c.setText(i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.j = i;
        }
    }

    @Override // c.a.p0.a4.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, tbPageContext, i)) == null) {
            this.f10388b.getPageContext().getLayoutMode().j(this.f10393g);
            return true;
        }
        return invokeLI.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(TbPageContextSupport tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport, viewGroup};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((TbPageContextSupport) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = viewGroup;
    }
}
