package c.a.s0.p0.d;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
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
/* loaded from: classes8.dex */
public class c extends c.a.s0.p0.d.a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f21430f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f21431g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<c.a.s0.p0.b.b> f21432h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<c.a.s0.p0.b.b> f21433i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList<String> f21434j;

    /* renamed from: k  reason: collision with root package name */
    public d f21435k;
    public DownloadManagerNetModel l;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.s0.p0.b.b)) {
                c.a.s0.p0.b.b bVar = (c.a.s0.p0.b.b) customResponsedMessage.getData();
                c cVar = this.a;
                if (cVar.q(cVar.f21432h, bVar)) {
                    return;
                }
                this.a.f21432h.add(0, bVar);
                c.h(this.a);
                if (this.a.f21435k != null) {
                    this.a.f21435k.b(this.a.f21432h, this.a.f21433i, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BaseFragment baseFragment, int i2) {
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
        this.f21430f = 0;
        this.f21432h = new ArrayList<>();
        this.f21433i = new ArrayList<>();
        this.f21434j = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new c.a.s0.p0.e.a(1, i2));
        this.l = downloadManagerNetModel;
        downloadManagerNetModel.Y(this);
        this.l.setUniqueId(baseFragment.getUniqueId());
        r(baseFragment);
    }

    public static /* synthetic */ int h(c cVar) {
        int i2 = cVar.f21430f;
        cVar.f21430f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int i(c cVar) {
        int i2 = cVar.f21430f;
        cVar.f21430f = i2 - 1;
        return i2;
    }

    @Override // c.a.s0.p0.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21431g) {
            return;
        }
        o();
    }

    @Override // c.a.s0.p0.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f21431g) {
            return;
        }
        this.f21430f = 0;
        this.f21432h.clear();
        this.f21433i.clear();
        o();
    }

    @Override // c.a.s0.p0.d.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f21435k = dVar;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.f21431g = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            c.a.s0.p0.e.b bVar = null;
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
            this.f21431g = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.f21431g = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            c.a.s0.p0.e.b bVar = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                bVar = (c.a.s0.p0.e.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (bVar == null || !u(bVar)) {
                t();
            }
        }
    }

    public final boolean q(ArrayList<c.a.s0.p0.b.b> arrayList, c.a.s0.p0.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, bVar)) == null) {
            Iterator<c.a.s0.p0.b.b> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().g(bVar)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void r(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, baseFragment) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(baseFragment.getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public final void s(List<c.a.r0.u.e> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (c.a.r0.u.e eVar : list) {
                if (eVar != null && eVar.f13977b != null) {
                    arrayList.add(c.a.s0.p0.b.b.d(eVar));
                }
            }
            this.f21432h.addAll(arrayList);
            if (ListUtils.getCount(this.f21432h) <= 4) {
                this.l.loadData();
                return;
            }
            this.f21431g = false;
            d dVar = this.f21435k;
            if (dVar != null) {
                dVar.b(this.f21432h, null, z ? 1 : 0);
            }
        }
    }

    public final void t() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (dVar = this.f21435k) == null) {
            return;
        }
        dVar.b(this.f21432h, null, 0);
    }

    public final boolean u(c.a.s0.p0.e.b bVar) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (!ListUtils.isEmpty(bVar.f21450f)) {
                for (c.a.s0.p0.b.b bVar2 : bVar.f21450f) {
                    if (bVar2 != null && (itemData = bVar2.f21425e) != null && !this.f21434j.contains(itemData.pkgName) && c.a.r0.e0.a.e(bVar2.f21425e.pkgName) == null) {
                        this.f21433i.add(bVar2);
                    }
                }
            }
            d dVar = this.f21435k;
            if (dVar != null) {
                dVar.b(this.f21432h, this.f21433i, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<c.a.r0.u.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f21436b;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21436b = cVar;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<c.a.r0.u.e> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<c.a.r0.u.e> d2 = c.a.s0.p0.c.a.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.f21436b.f21430f >= d2.size()) {
                    return arrayList;
                }
                int i2 = this.f21436b.f21430f;
                while (i2 < d2.size()) {
                    c.h(this.f21436b);
                    c.a.r0.u.e eVar = d2.get(i2);
                    if (eVar != null && !l.isEmpty(eVar.a) && !l.isEmpty(eVar.f13978c)) {
                        ItemData d3 = d(eVar.f13978c);
                        eVar.f13977b = d3;
                        if (d3 != null && d3.apkDetail != null) {
                            PackageInfo e2 = c.a.r0.e0.a.e(eVar.a);
                            if (e2 != null && e2.versionCode >= eVar.f13977b.apkDetail.version_code.intValue()) {
                                c.a.s0.p0.c.a.e().c(eVar.a);
                                c.i(this.f21436b);
                            } else {
                                DownloadData j2 = c.a.r0.e0.a.j(eVar.f13977b);
                                if (c.a.r0.e0.a.c(j2) == 6 && !c.a.r0.e0.a.b(j2.getId()) && eVar.f13979d != 2) {
                                    c.a.s0.p0.c.a.e().c(eVar.a);
                                    c.i(this.f21436b);
                                } else if (eVar.f13979d == 2 && !c.a.r0.w.c.q().s(eVar.a) && c.a.r0.e0.a.d(eVar.a, eVar.f13977b.appId) == 6) {
                                    c.a.s0.p0.c.a.e().c(eVar.a);
                                    c.i(this.f21436b);
                                } else {
                                    arrayList.add(eVar);
                                    this.f21436b.f21434j.add(eVar.a);
                                    if (arrayList.size() >= 15) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            c.a.s0.p0.c.a.e().c(eVar.a);
                            c.i(this.f21436b);
                        }
                    }
                    i2++;
                }
                if (arrayList.size() >= 15 && i2 < d2.size()) {
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
        public void onPostExecute(List<c.a.r0.u.e> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f21436b.s(list, this.a);
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
