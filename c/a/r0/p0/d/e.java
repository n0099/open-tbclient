package c.a.r0.p0.d;

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
/* loaded from: classes6.dex */
public class e extends a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final DownloadManagerNetModel f21018f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.p0.e.a f21019g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.p0.e.b f21020h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f21021i;

    /* renamed from: j  reason: collision with root package name */
    public d f21022j;

    /* renamed from: k  reason: collision with root package name */
    public final List<c.a.r0.p0.b.b> f21023k;
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
        this.f21020h = new c.a.r0.p0.e.b();
        this.f21021i = new ArrayList();
        this.f21023k = new ArrayList();
        this.l = 0;
        this.f21019g = new c.a.r0.p0.e.a(1, i2);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.f21019g);
        this.f21018f = downloadManagerNetModel;
        downloadManagerNetModel.Y(this);
        this.f21018f.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // c.a.r0.p0.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            this.f21019g.c();
            this.f21018f.loadData();
        }
    }

    @Override // c.a.r0.p0.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.f21020h.f21030e.clear();
            this.f21021i.clear();
            this.f21019g.b();
            this.f21018f.loadData();
        }
    }

    @Override // c.a.r0.p0.d.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f21022j = dVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21023k.clear();
            this.l = 0;
        }
    }

    public final void f(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || i2 == 0) {
            return;
        }
        this.f21022j.a(i2, str);
    }

    public void g(List<c.a.r0.p0.b.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            Map<String, Integer> a = c.a.r0.p0.a.a();
            if (a == null) {
                this.f21023k.addAll(list);
            } else {
                for (c.a.r0.p0.b.b bVar : list) {
                    Integer num = a.get(bVar.f21006e.pkgName);
                    if (num != null) {
                        if (num.intValue() < bVar.f21006e.apkDetail.version_code.intValue()) {
                            List<c.a.r0.p0.b.b> list2 = this.f21023k;
                            int i2 = this.l;
                            this.l = i2 + 1;
                            list2.add(i2, bVar);
                        } else {
                            this.f21023k.add(bVar);
                        }
                        this.f21021i.add(bVar.f21006e.pkgName);
                    }
                }
            }
            if (ListUtils.getCount(this.f21023k) < 15 && this.f21020h.f21032g.intValue() != 0) {
                this.f21019g.c();
                this.f21018f.loadData();
                return;
            }
            this.f21020h.f21030e.addAll(this.f21023k);
            if (ListUtils.getCount(this.f21020h.f21030e) <= 4) {
                this.f21022j.b(this.f21020h.f21030e, h(), this.f21020h.f21032g.intValue());
                return;
            }
            d dVar = this.f21022j;
            c.a.r0.p0.e.b bVar2 = this.f21020h;
            dVar.b(bVar2.f21030e, null, bVar2.f21032g.intValue());
        }
    }

    public List<c.a.r0.p0.b.b> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.r0.p0.b.b bVar : this.f21020h.f21031f) {
                if (!this.f21021i.contains(bVar.f21006e.pkgName)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean i(c.a.r0.p0.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            c.a.r0.p0.e.b bVar2 = this.f21020h;
            bVar2.f21032g = bVar.f21032g;
            bVar2.f21031f = bVar.f21031f;
            g(bVar.f21030e);
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
        c.a.r0.p0.e.b bVar = null;
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
        c.a.r0.p0.e.b bVar = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            bVar = (c.a.r0.p0.e.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (bVar == null || !i(bVar)) {
            f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
