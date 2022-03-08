package c.a.q0.k0.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.o.e.b;
import c.a.r0.y3.v;
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

    /* renamed from: f  reason: collision with root package name */
    public TbPageContextSupport f12695f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f12696g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f12697h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f12698i;

    /* renamed from: j  reason: collision with root package name */
    public View f12699j;
    public View k;
    public int l;
    public ViewGroup m;
    public int n;

    public a(TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f12695f = null;
        this.f12696g = null;
        this.f12697h = null;
        this.f12698i = null;
        this.f12699j = null;
        this.f12695f = tbPageContextSupport;
        this.l = tbPageContextSupport.getPageContext().getResources().getDimensionPixelSize(R.dimen.ds16);
    }

    @Override // c.a.d.o.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.m == null) {
                this.f12699j = LayoutInflater.from(this.f12695f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            } else {
                this.f12699j = LayoutInflater.from(this.f12695f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, this.m, false);
            }
            View view = this.f12699j;
            int i2 = this.l;
            view.setPadding(0, i2, 0, i2);
            if (this.n != 0) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f12699j.getLayoutParams());
                layoutParams.height = this.n;
                this.f12699j.setLayoutParams(layoutParams);
            }
            this.f12696g = (TextView) this.f12699j.findViewById(R.id.pb_more_text);
            View findViewById = this.f12699j.findViewById(R.id.pb_more_view);
            this.k = findViewById;
            findViewById.setVisibility(8);
            this.f12697h = (ProgressBar) this.f12699j.findViewById(R.id.progress);
            onChangeSkinType(this.f12695f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.k.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.f12699j;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.o.e.b
    public void c() {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f12698i) == null) {
            return;
        }
        onClickListener.onClick(this.f12699j);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.k.setVisibility(0);
            View view = this.f12699j;
            int i2 = this.l;
            view.setPadding(0, i2, 0, i2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.setVisibility(8);
            this.f12699j.setPadding(0, 0, 0, 0);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f12697h.setVisibility(0);
            this.f12696g.setText(i2);
            this.k.setVisibility(0);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f12697h.setVisibility(8);
            this.f12696g.setText(i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.n = i2;
        }
    }

    @Override // c.a.r0.y3.v
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, tbPageContext, i2)) == null) {
            this.f12695f.getPageContext().getLayoutMode().j(this.k);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((TbPageContextSupport) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = viewGroup;
    }
}
