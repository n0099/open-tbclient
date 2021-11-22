package b.a.r0.j0.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerHttpResponseMessage;
import com.baidu.tieba.downloadmanager.net.DownloadManagerNetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class e extends a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final DownloadManagerNetModel f19643f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.j0.e.a f19644g;

    /* renamed from: h  reason: collision with root package name */
    public b.a.r0.j0.e.b f19645h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f19646i;
    public d j;
    public final List<b.a.r0.j0.b.b> k;
    public int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BaseFragment baseFragment, int i2) {
        super(baseFragment, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragment) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19645h = new b.a.r0.j0.e.b();
        this.f19646i = new ArrayList();
        this.k = new ArrayList();
        this.l = 0;
        this.f19644g = new b.a.r0.j0.e.a(1, i2);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.f19644g);
        this.f19643f = downloadManagerNetModel;
        downloadManagerNetModel.Y(this);
        this.f19643f.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // b.a.r0.j0.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            this.f19644g.c();
            this.f19643f.loadData();
        }
    }

    @Override // b.a.r0.j0.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.f19645h.f19653e.clear();
            this.f19646i.clear();
            this.f19644g.b();
            this.f19643f.loadData();
        }
    }

    @Override // b.a.r0.j0.d.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.j = dVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.k.clear();
            this.l = 0;
        }
    }

    public final void f(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || i2 == 0) {
            return;
        }
        this.j.a(i2, str);
    }

    public void g(List<b.a.r0.j0.b.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            Map<String, Integer> a2 = b.a.r0.j0.a.a();
            if (a2 == null) {
                this.k.addAll(list);
            } else {
                for (b.a.r0.j0.b.b bVar : list) {
                    Integer num = a2.get(bVar.f19630e.pkgName);
                    if (num != null) {
                        if (num.intValue() < bVar.f19630e.apkDetail.version_code.intValue()) {
                            List<b.a.r0.j0.b.b> list2 = this.k;
                            int i2 = this.l;
                            this.l = i2 + 1;
                            list2.add(i2, bVar);
                        } else {
                            this.k.add(bVar);
                        }
                        this.f19646i.add(bVar.f19630e.pkgName);
                    }
                }
            }
            if (ListUtils.getCount(this.k) < 15 && this.f19645h.f19655g.intValue() != 0) {
                this.f19644g.c();
                this.f19643f.loadData();
                return;
            }
            this.f19645h.f19653e.addAll(this.k);
            if (ListUtils.getCount(this.f19645h.f19653e) <= 4) {
                this.j.b(this.f19645h.f19653e, h(), this.f19645h.f19655g.intValue());
                return;
            }
            d dVar = this.j;
            b.a.r0.j0.e.b bVar2 = this.f19645h;
            dVar.b(bVar2.f19653e, null, bVar2.f19655g.intValue());
        }
    }

    public List<b.a.r0.j0.b.b> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (b.a.r0.j0.b.b bVar : this.f19645h.f19654f) {
                if (!this.f19646i.contains(bVar.f19630e.pkgName)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean i(b.a.r0.j0.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            b.a.r0.j0.e.b bVar2 = this.f19645h;
            bVar2.f19655g = bVar.f19655g;
            bVar2.f19654f = bVar.f19654f;
            g(bVar.f19653e);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        b.a.r0.j0.e.b bVar = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            bVar = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (bVar == null || !i(bVar)) {
            f(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        b.a.r0.j0.e.b bVar = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            bVar = (b.a.r0.j0.e.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (bVar == null || !i(bVar)) {
            f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
