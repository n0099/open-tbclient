package c.a.p0.r0.c;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
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
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends c.a.p0.r0.c.a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f17909b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17910c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<c.a.p0.r0.a.b> f17911d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<c.a.p0.r0.a.b> f17912e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList<String> f17913f;

    /* renamed from: g  reason: collision with root package name */
    public d f17914g;

    /* renamed from: h  reason: collision with root package name */
    public DownloadManagerNetModel f17915h;

    /* loaded from: classes2.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.r0.a.b)) {
                c.a.p0.r0.a.b bVar = (c.a.p0.r0.a.b) customResponsedMessage.getData();
                c cVar = this.a;
                if (cVar.p(cVar.f17911d, bVar)) {
                    return;
                }
                this.a.f17911d.add(0, bVar);
                c.h(this.a);
                if (this.a.f17914g != null) {
                    this.a.f17914g.b(this.a.f17911d, this.a.f17912e, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BaseFragment baseFragment, int i) {
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
        this.f17909b = 0;
        this.f17911d = new ArrayList<>();
        this.f17912e = new ArrayList<>();
        this.f17913f = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new c.a.p0.r0.d.a(1, i));
        this.f17915h = downloadManagerNetModel;
        downloadManagerNetModel.a0(this);
        this.f17915h.setUniqueId(baseFragment.getUniqueId());
        q(baseFragment);
    }

    public static /* synthetic */ int h(c cVar) {
        int i = cVar.f17909b;
        cVar.f17909b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(c cVar) {
        int i = cVar.f17909b;
        cVar.f17909b = i - 1;
        return i;
    }

    @Override // c.a.p0.r0.c.a
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17910c) {
            return;
        }
        o();
    }

    @Override // c.a.p0.r0.c.a
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f17910c) {
            return;
        }
        this.f17909b = 0;
        this.f17911d.clear();
        this.f17912e.clear();
        o();
    }

    @Override // c.a.p0.r0.c.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f17914g = dVar;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void m(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.f17910c = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            c.a.p0.r0.d.b bVar = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                bVar = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (bVar == null || !u(bVar)) {
                t();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f17910c = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final boolean p(ArrayList<c.a.p0.r0.a.b> arrayList, c.a.p0.r0.a.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, bVar)) == null) {
            Iterator<c.a.p0.r0.a.b> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f(bVar)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, baseFragment) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(baseFragment.getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void r(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.f17910c = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            c.a.p0.r0.d.b bVar = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                bVar = (c.a.p0.r0.d.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (bVar == null || !u(bVar)) {
                t();
            }
        }
    }

    public final void s(List<c.a.o0.t.e> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.o0.t.e eVar : list) {
                if (eVar != null && eVar.f11447b != null) {
                    arrayList.add(c.a.p0.r0.a.b.b(eVar));
                }
            }
            this.f17911d.addAll(arrayList);
            if (ListUtils.getCount(this.f17911d) <= 4) {
                this.f17915h.loadData();
                return;
            }
            this.f17910c = false;
            d dVar = this.f17914g;
            if (dVar != null) {
                dVar.b(this.f17911d, null, z ? 1 : 0);
            }
        }
    }

    public final void t() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (dVar = this.f17914g) == null) {
            return;
        }
        dVar.b(this.f17911d, null, 0);
    }

    public final boolean u(c.a.p0.r0.d.b bVar) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (!ListUtils.isEmpty(bVar.f17929b)) {
                for (c.a.p0.r0.a.b bVar2 : bVar.f17929b) {
                    if (bVar2 != null && (itemData = bVar2.a) != null && !this.f17913f.contains(itemData.pkgName) && c.a.o0.d0.a.e(bVar2.a.pkgName) == null) {
                        this.f17912e.add(bVar2);
                    }
                }
            }
            d dVar = this.f17914g;
            if (dVar != null) {
                dVar.b(this.f17911d, this.f17912e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes2.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<c.a.o0.t.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f17916b;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17916b = cVar;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<c.a.o0.t.e> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<c.a.o0.t.e> d2 = c.a.p0.r0.b.a.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.f17916b.f17909b >= d2.size()) {
                    return arrayList;
                }
                int i = this.f17916b.f17909b;
                while (i < d2.size()) {
                    c.h(this.f17916b);
                    c.a.o0.t.e eVar = d2.get(i);
                    if (eVar != null && !m.isEmpty(eVar.a) && !m.isEmpty(eVar.f11448c)) {
                        ItemData d3 = d(eVar.f11448c);
                        eVar.f11447b = d3;
                        if (d3 != null && d3.apkDetail != null) {
                            PackageInfo e2 = c.a.o0.d0.a.e(eVar.a);
                            if (e2 != null && e2.versionCode >= eVar.f11447b.apkDetail.version_code.intValue()) {
                                c.a.p0.r0.b.a.e().c(eVar.a);
                                c.i(this.f17916b);
                            } else {
                                DownloadData j = c.a.o0.d0.a.j(eVar.f11447b);
                                if (c.a.o0.d0.a.c(j) == 6 && !c.a.o0.d0.a.b(j.getId()) && eVar.f11449d != 2) {
                                    c.a.p0.r0.b.a.e().c(eVar.a);
                                    c.i(this.f17916b);
                                } else if (eVar.f11449d == 2 && !c.a.o0.v.c.q().s(eVar.a) && c.a.o0.d0.a.d(eVar.a, eVar.f11447b.appId) == 6) {
                                    c.a.p0.r0.b.a.e().c(eVar.a);
                                    c.i(this.f17916b);
                                } else {
                                    arrayList.add(eVar);
                                    this.f17916b.f17913f.add(eVar.a);
                                    if (arrayList.size() >= 15) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            c.a.p0.r0.b.a.e().c(eVar.a);
                            c.i(this.f17916b);
                        }
                    }
                    i++;
                }
                if (arrayList.size() >= 15 && i < d2.size()) {
                    this.a = true;
                } else {
                    this.a = false;
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<c.a.o0.t.e> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f17916b.s(list, this.a);
            }
        }

        public final ItemData d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                ItemData itemData = new ItemData();
                itemData.parseJson(str);
                return itemData;
            }
            return (ItemData) invokeL.objValue;
        }

        public /* synthetic */ b(c cVar, a aVar) {
            this(cVar);
        }
    }
}
