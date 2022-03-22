package c.a.p0.r0.c;

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

    /* renamed from: b  reason: collision with root package name */
    public final DownloadManagerNetModel f17917b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.r0.d.a f17918c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.r0.d.b f17919d;

    /* renamed from: e  reason: collision with root package name */
    public List<String> f17920e;

    /* renamed from: f  reason: collision with root package name */
    public d f17921f;

    /* renamed from: g  reason: collision with root package name */
    public final List<c.a.p0.r0.a.b> f17922g;

    /* renamed from: h  reason: collision with root package name */
    public int f17923h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BaseFragment baseFragment, int i) {
        super(baseFragment, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragment) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17919d = new c.a.p0.r0.d.b();
        this.f17920e = new ArrayList();
        this.f17922g = new ArrayList();
        this.f17923h = 0;
        this.f17918c = new c.a.p0.r0.d.a(1, i);
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), this.f17918c);
        this.f17917b = downloadManagerNetModel;
        downloadManagerNetModel.a0(this);
        this.f17917b.setUniqueId(baseFragment.getUniqueId());
    }

    @Override // c.a.p0.r0.c.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            this.f17918c.c();
            this.f17917b.loadData();
        }
    }

    @Override // c.a.p0.r0.c.a
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
            this.f17919d.a.clear();
            this.f17920e.clear();
            this.f17918c.b();
            this.f17917b.loadData();
        }
    }

    @Override // c.a.p0.r0.c.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f17921f = dVar;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f17922g.clear();
            this.f17923h = 0;
        }
    }

    public final void f(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) || i == 0) {
            return;
        }
        this.f17921f.a(i, str);
    }

    public void g(List<c.a.p0.r0.a.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            for (c.a.p0.r0.a.b bVar : list) {
                PackageInfo a = c.a.p0.f1.r2.c.a(bVar.a.pkgName);
                if (a != null) {
                    if (a.versionCode < bVar.a.apkDetail.version_code.intValue()) {
                        List<c.a.p0.r0.a.b> list2 = this.f17922g;
                        int i = this.f17923h;
                        this.f17923h = i + 1;
                        list2.add(i, bVar);
                    } else {
                        this.f17922g.add(bVar);
                    }
                    this.f17920e.add(bVar.a.pkgName);
                }
            }
            if (ListUtils.getCount(this.f17922g) < 15 && this.f17919d.f17930c.intValue() != 0) {
                this.f17918c.c();
                this.f17917b.loadData();
                return;
            }
            this.f17919d.a.addAll(this.f17922g);
            if (ListUtils.getCount(this.f17919d.a) <= 4) {
                this.f17921f.b(this.f17919d.a, h(), this.f17919d.f17930c.intValue());
                return;
            }
            d dVar = this.f17921f;
            c.a.p0.r0.d.b bVar2 = this.f17919d;
            dVar.b(bVar2.a, null, bVar2.f17930c.intValue());
        }
    }

    public List<c.a.p0.r0.a.b> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.p0.r0.a.b bVar : this.f17919d.f17929b) {
                if (!this.f17920e.contains(bVar.a.pkgName)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean i(c.a.p0.r0.d.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            c.a.p0.r0.d.b bVar2 = this.f17919d;
            bVar2.f17930c = bVar.f17930c;
            bVar2.f17929b = bVar.f17929b;
            g(bVar.a);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        c.a.p0.r0.d.b bVar = null;
        if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
            bVar = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
        }
        if (bVar == null || !i(bVar)) {
            f(mvcSocketResponsedMessage.getError(), mvcSocketResponsedMessage.getErrorString());
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        c.a.p0.r0.d.b bVar = null;
        if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
            bVar = (c.a.p0.r0.d.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
        }
        if (bVar == null || !i(bVar)) {
            f(mvcHttpResponsedMessage.getError(), mvcHttpResponsedMessage.getErrorString());
        }
    }
}
