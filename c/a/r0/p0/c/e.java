package c.a.r0.p0.c;

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
/* loaded from: classes2.dex */
public class e extends a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final DownloadManagerNetModel f20692f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.r0.p0.d.a f20693g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.p0.d.b f20694h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f20695i;

    /* renamed from: j  reason: collision with root package name */
    public d f20696j;
    public final List<c.a.r0.p0.a.b> k;
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
        this.f20694h = new c.a.r0.p0.d.b();
        this.f20695i = new ArrayList();
        this.k = new ArrayList();
        this.l = 0;
        this.f20693g = new c.a.r0.p0.d.a(1, i2);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.f20693g);
        this.f20692f = downloadManagerNetModel;
        downloadManagerNetModel.Y(this);
        this.f20692f.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // c.a.r0.p0.c.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            this.f20693g.c();
            this.f20692f.loadData();
        }
    }

    @Override // c.a.r0.p0.c.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.f20694h.f20703e.clear();
            this.f20695i.clear();
            this.f20693g.b();
            this.f20692f.loadData();
        }
    }

    @Override // c.a.r0.p0.c.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f20696j = dVar;
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
        this.f20696j.a(i2, str);
    }

    public void g(List<c.a.r0.p0.a.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (c.a.r0.p0.a.b bVar : list) {
                PackageInfo a = c.a.r0.d1.r2.c.a(bVar.f20681e.pkgName);
                if (a != null) {
                    if (a.versionCode < bVar.f20681e.apkDetail.version_code.intValue()) {
                        List<c.a.r0.p0.a.b> list2 = this.k;
                        int i2 = this.l;
                        this.l = i2 + 1;
                        list2.add(i2, bVar);
                    } else {
                        this.k.add(bVar);
                    }
                    this.f20695i.add(bVar.f20681e.pkgName);
                }
            }
            if (ListUtils.getCount(this.k) < 15 && this.f20694h.f20705g.intValue() != 0) {
                this.f20693g.c();
                this.f20692f.loadData();
                return;
            }
            this.f20694h.f20703e.addAll(this.k);
            if (ListUtils.getCount(this.f20694h.f20703e) <= 4) {
                this.f20696j.b(this.f20694h.f20703e, h(), this.f20694h.f20705g.intValue());
                return;
            }
            d dVar = this.f20696j;
            c.a.r0.p0.d.b bVar2 = this.f20694h;
            dVar.b(bVar2.f20703e, null, bVar2.f20705g.intValue());
        }
    }

    public List<c.a.r0.p0.a.b> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.r0.p0.a.b bVar : this.f20694h.f20704f) {
                if (!this.f20695i.contains(bVar.f20681e.pkgName)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean i(c.a.r0.p0.d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            c.a.r0.p0.d.b bVar2 = this.f20694h;
            bVar2.f20705g = bVar.f20705g;
            bVar2.f20704f = bVar.f20704f;
            g(bVar.f20703e);
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
        c.a.r0.p0.d.b bVar = null;
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
        c.a.r0.p0.d.b bVar = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            bVar = (c.a.r0.p0.d.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (bVar == null || !i(bVar)) {
            f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
