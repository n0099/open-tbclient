package c.a.r0.q2.x;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.q2.j;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public BaseFragmentActivity f22368b;

    /* renamed from: c  reason: collision with root package name */
    public int f22369c;

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
        this.f22369c = 3;
        this.f22368b = baseFragmentActivity;
    }

    public final void a(c.a.r0.q2.r.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, fVar, str) == null) || fVar == null) {
            return;
        }
        if (this.a == null) {
            this.a = new c(LayoutInflater.from(this.f22368b.getPageContext().getPageActivity()).inflate(j.pb_header_video_abstract_layout, (ViewGroup) null));
        }
        this.a.m(fVar, str);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            c cVar = this.a;
            if (cVar == null) {
                return null;
            }
            return cVar.a;
        }
        return (View) invokeV.objValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || this.f22369c == i2) {
            return;
        }
        c cVar = this.a;
        if (cVar != null) {
            cVar.o();
        }
        this.f22369c = i2;
    }

    public void d(c.a.r0.q2.r.f fVar, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, fVar, str) == null) || fVar == null || fVar.O() == null) {
            return;
        }
        a(fVar, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeListView) == null) || (cVar = this.a) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(cVar.a);
    }
}
