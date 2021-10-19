package c.a.r0.j0.d;

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
/* loaded from: classes3.dex */
public class e extends a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final DownloadManagerNetModel f19323f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.j0.e.a f19324g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.j0.e.b f19325h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f19326i;

    /* renamed from: j  reason: collision with root package name */
    public d f19327j;
    public final List<c.a.r0.j0.b.b> k;
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
        this.f19325h = new c.a.r0.j0.e.b();
        this.f19326i = new ArrayList();
        this.k = new ArrayList();
        this.l = 0;
        this.f19324g = new c.a.r0.j0.e.a(1, i2);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.f19324g);
        this.f19323f = downloadManagerNetModel;
        downloadManagerNetModel.Y(this);
        this.f19323f.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // c.a.r0.j0.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            this.f19324g.d();
            this.f19323f.loadData();
        }
    }

    @Override // c.a.r0.j0.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.f19325h.f19334e.clear();
            this.f19326i.clear();
            this.f19324g.b();
            this.f19323f.loadData();
        }
    }

    @Override // c.a.r0.j0.d.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f19327j = dVar;
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
        this.f19327j.a(i2, str);
    }

    public void g(List<c.a.r0.j0.b.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            Map<String, Integer> a2 = c.a.r0.j0.a.a();
            if (a2 == null) {
                this.k.addAll(list);
            } else {
                for (c.a.r0.j0.b.b bVar : list) {
                    Integer num = a2.get(bVar.f19309e.pkgName);
                    if (num != null) {
                        if (num.intValue() < bVar.f19309e.apkDetail.version_code.intValue()) {
                            List<c.a.r0.j0.b.b> list2 = this.k;
                            int i2 = this.l;
                            this.l = i2 + 1;
                            list2.add(i2, bVar);
                        } else {
                            this.k.add(bVar);
                        }
                        this.f19326i.add(bVar.f19309e.pkgName);
                    }
                }
            }
            if (ListUtils.getCount(this.k) < 15 && this.f19325h.f19336g.intValue() != 0) {
                this.f19324g.d();
                this.f19323f.loadData();
                return;
            }
            this.f19325h.f19334e.addAll(this.k);
            if (ListUtils.getCount(this.f19325h.f19334e) <= 4) {
                this.f19327j.b(this.f19325h.f19334e, h(), this.f19325h.f19336g.intValue());
                return;
            }
            d dVar = this.f19327j;
            c.a.r0.j0.e.b bVar2 = this.f19325h;
            dVar.b(bVar2.f19334e, null, bVar2.f19336g.intValue());
        }
    }

    public List<c.a.r0.j0.b.b> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.r0.j0.b.b bVar : this.f19325h.f19335f) {
                if (!this.f19326i.contains(bVar.f19309e.pkgName)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean i(c.a.r0.j0.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            c.a.r0.j0.e.b bVar2 = this.f19325h;
            bVar2.f19336g = bVar.f19336g;
            bVar2.f19335f = bVar.f19335f;
            g(bVar.f19334e);
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
        c.a.r0.j0.e.b bVar = null;
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
        c.a.r0.j0.e.b bVar = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            bVar = (c.a.r0.j0.e.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (bVar == null || !i(bVar)) {
            f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
