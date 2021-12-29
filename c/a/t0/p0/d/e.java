package c.a.t0.p0.d;

import android.content.pm.PackageInfo;
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
/* loaded from: classes8.dex */
public class e extends a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final DownloadManagerNetModel f21953f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.t0.p0.e.a f21954g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.p0.e.b f21955h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f21956i;

    /* renamed from: j  reason: collision with root package name */
    public d f21957j;

    /* renamed from: k  reason: collision with root package name */
    public final List<c.a.t0.p0.b.b> f21958k;
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
        this.f21955h = new c.a.t0.p0.e.b();
        this.f21956i = new ArrayList();
        this.f21958k = new ArrayList();
        this.l = 0;
        this.f21954g = new c.a.t0.p0.e.a(1, i2);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.f21954g);
        this.f21953f = downloadManagerNetModel;
        downloadManagerNetModel.Y(this);
        this.f21953f.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // c.a.t0.p0.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            this.f21954g.c();
            this.f21953f.loadData();
        }
    }

    @Override // c.a.t0.p0.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.f21955h.f21965e.clear();
            this.f21956i.clear();
            this.f21954g.b();
            this.f21953f.loadData();
        }
    }

    @Override // c.a.t0.p0.d.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f21957j = dVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f21958k.clear();
            this.l = 0;
        }
    }

    public final void f(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, str) == null) || i2 == 0) {
            return;
        }
        this.f21957j.a(i2, str);
    }

    public void g(List<c.a.t0.p0.b.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (c.a.t0.p0.b.b bVar : list) {
                PackageInfo a = c.a.t0.p0.a.a(bVar.f21941e.pkgName);
                if (a != null) {
                    if (a.versionCode < bVar.f21941e.apkDetail.version_code.intValue()) {
                        List<c.a.t0.p0.b.b> list2 = this.f21958k;
                        int i2 = this.l;
                        this.l = i2 + 1;
                        list2.add(i2, bVar);
                    } else {
                        this.f21958k.add(bVar);
                    }
                    this.f21956i.add(bVar.f21941e.pkgName);
                }
            }
            if (ListUtils.getCount(this.f21958k) < 15 && this.f21955h.f21967g.intValue() != 0) {
                this.f21954g.c();
                this.f21953f.loadData();
                return;
            }
            this.f21955h.f21965e.addAll(this.f21958k);
            if (ListUtils.getCount(this.f21955h.f21965e) <= 4) {
                this.f21957j.b(this.f21955h.f21965e, h(), this.f21955h.f21967g.intValue());
                return;
            }
            d dVar = this.f21957j;
            c.a.t0.p0.e.b bVar2 = this.f21955h;
            dVar.b(bVar2.f21965e, null, bVar2.f21967g.intValue());
        }
    }

    public List<c.a.t0.p0.b.b> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.t0.p0.b.b bVar : this.f21955h.f21966f) {
                if (!this.f21956i.contains(bVar.f21941e.pkgName)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean i(c.a.t0.p0.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            c.a.t0.p0.e.b bVar2 = this.f21955h;
            bVar2.f21967g = bVar.f21967g;
            bVar2.f21966f = bVar.f21966f;
            g(bVar.f21965e);
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
        c.a.t0.p0.e.b bVar = null;
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
        c.a.t0.p0.e.b bVar = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            bVar = (c.a.t0.p0.e.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (bVar == null || !i(bVar)) {
            f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
