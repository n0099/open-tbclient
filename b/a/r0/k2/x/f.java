package b.a.r0.k2.x;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.k2.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f21224a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f21225b;

    /* renamed from: c  reason: collision with root package name */
    public int f21226c;

    public f(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21226c = 3;
        this.f21225b = baseFragmentActivity;
    }

    public final void a(b.a.r0.k2.r.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, str) == null) || fVar == null) {
            return;
        }
        if (this.f21224a == null) {
            this.f21224a = new c(LayoutInflater.from(this.f21225b.getPageContext().getPageActivity()).inflate(j.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.f21224a.m(fVar, str);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.f21224a;
            if (cVar == null) {
                return null;
            }
            return cVar.f21203a;
        }
        return (View) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f21226c == i2) {
            return;
        }
        c cVar = this.f21224a;
        if (cVar != null) {
            cVar.o();
        }
        this.f21226c = i2;
    }

    public void d(b.a.r0.k2.r.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, fVar, str) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        a(fVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeListView) == null) || (cVar = this.f21224a) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(cVar.f21203a);
    }
}
