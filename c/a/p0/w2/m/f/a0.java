package c.a.p0.w2.m.f;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeListView f19982b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f19983c;

    /* renamed from: d  reason: collision with root package name */
    public int f19984d;

    /* renamed from: e  reason: collision with root package name */
    public int f19985e;

    /* renamed from: f  reason: collision with root package name */
    public a f19986f;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    public a0(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = UtilHelper.getDimenPixelSize(R.dimen.tbds144);
        this.f19984d = -1;
        this.f19985e = -1;
        this.f19982b = bdTypeListView;
    }

    public final int a(List<c.a.d.o.e.n> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, list, i)) == null) {
            if (!ListUtils.isEmpty(list) && i != -1) {
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if ((list.get(i3) instanceof PostData) && ((PostData) list.get(i3)).getType() == PostData.w0 && (i2 = i2 + 1) == i) {
                        return i3;
                    }
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f19985e = a(this.f19982b.getData(), c.a.p0.w2.e.b().c());
        }
    }

    public void c(int i, int i2) {
        View childAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || this.f19982b == null || this.f19983c || !c.a.p0.w2.e.b().e() || c.a.p0.w2.e.b().c() == -1 || this.f19985e < 0 || (childAt = this.f19982b.getChildAt(i2 - 1)) == null) {
            return;
        }
        if (this.f19984d <= 0) {
            this.f19984d = this.f19982b.getHeight() - this.a;
        }
        if (this.f19984d <= 0) {
            return;
        }
        int headerViewsCount = this.f19985e + this.f19982b.getHeaderViewsCount();
        int i3 = (i + i2) - 1;
        if (i3 > headerViewsCount) {
            if (i3 - 1 != headerViewsCount || childAt.getTop() <= this.f19984d) {
                a aVar = this.f19986f;
                if (aVar != null) {
                    aVar.a();
                }
                this.f19983c = true;
            }
        }
    }

    public void d(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f19986f = aVar;
        }
    }
}
