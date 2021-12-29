package c.a.s0.l0.g;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.n.e.b;
import c.a.t0.w3.u;
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
/* loaded from: classes6.dex */
public class a extends b implements u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContextSupport f13197f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f13198g;

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f13199h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f13200i;

    /* renamed from: j  reason: collision with root package name */
    public View f13201j;

    /* renamed from: k  reason: collision with root package name */
    public View f13202k;
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
        this.f13197f = null;
        this.f13198g = null;
        this.f13199h = null;
        this.f13200i = null;
        this.f13201j = null;
        this.f13197f = tbPageContextSupport;
        this.l = tbPageContextSupport.getPageContext().getResources().getDimensionPixelSize(R.dimen.ds16);
    }

    @Override // c.a.d.n.e.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.m == null) {
                this.f13201j = LayoutInflater.from(this.f13197f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
            } else {
                this.f13201j = LayoutInflater.from(this.f13197f.getPageContext().getPageActivity()).inflate(R.layout.new_pb_list_more, this.m, false);
            }
            View view = this.f13201j;
            int i2 = this.l;
            view.setPadding(0, i2, 0, i2);
            if (this.n != 0) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f13201j.getLayoutParams());
                layoutParams.height = this.n;
                this.f13201j.setLayoutParams(layoutParams);
            }
            this.f13198g = (TextView) this.f13201j.findViewById(R.id.pb_more_text);
            View findViewById = this.f13201j.findViewById(R.id.pb_more_view);
            this.f13202k = findViewById;
            findViewById.setVisibility(8);
            this.f13199h = (ProgressBar) this.f13201j.findViewById(R.id.progress);
            onChangeSkinType(this.f13197f.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.f13202k.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.f13201j;
        }
        return (View) invokeV.objValue;
    }

    @Override // c.a.d.n.e.b
    public void c() {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.f13200i) == null) {
            return;
        }
        onClickListener.onClick(this.f13201j);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f13202k.setVisibility(0);
            View view = this.f13201j;
            int i2 = this.l;
            view.setPadding(0, i2, 0, i2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f13202k.setVisibility(8);
            this.f13201j.setPadding(0, 0, 0, 0);
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f13199h.setVisibility(0);
            this.f13198g.setText(i2);
            this.f13202k.setVisibility(0);
        }
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f13199h.setVisibility(8);
            this.f13198g.setText(i2);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.n = i2;
        }
    }

    @Override // c.a.t0.w3.u
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, tbPageContext, i2)) == null) {
            this.f13197f.getPageContext().getLayoutMode().j(this.f13202k);
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
