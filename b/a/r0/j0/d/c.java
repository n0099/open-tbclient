package b.a.r0.j0.d;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.p.k;
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
/* loaded from: classes4.dex */
public class c extends b.a.r0.j0.d.a implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f19636f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19637g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<b.a.r0.j0.b.b> f19638h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<b.a.r0.j0.b.b> f19639i;
    public final ArrayList<String> j;
    public d k;
    public DownloadManagerNetModel l;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19640a;

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
            this.f19640a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.j0.b.b)) {
                b.a.r0.j0.b.b bVar = (b.a.r0.j0.b.b) customResponsedMessage.getData();
                c cVar = this.f19640a;
                if (cVar.q(cVar.f19638h, bVar)) {
                    return;
                }
                this.f19640a.f19638h.add(0, bVar);
                c.h(this.f19640a);
                if (this.f19640a.k != null) {
                    this.f19640a.k.b(this.f19640a.f19638h, this.f19640a.f19639i, 0);
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
        this.f19636f = 0;
        this.f19638h = new ArrayList<>();
        this.f19639i = new ArrayList<>();
        this.j = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new b.a.r0.j0.e.a(1, i2));
        this.l = downloadManagerNetModel;
        downloadManagerNetModel.Y(this);
        this.l.setUniqueId(baseFragment.getUniqueId());
        r(baseFragment);
    }

    public static /* synthetic */ int h(c cVar) {
        int i2 = cVar.f19636f;
        cVar.f19636f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int i(c cVar) {
        int i2 = cVar.f19636f;
        cVar.f19636f = i2 - 1;
        return i2;
    }

    @Override // b.a.r0.j0.d.a
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19637g) {
            return;
        }
        o();
    }

    @Override // b.a.r0.j0.d.a
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f19637g) {
            return;
        }
        this.f19636f = 0;
        this.f19638h.clear();
        this.f19639i.clear();
        o();
    }

    @Override // b.a.r0.j0.d.a
    public void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.k = dVar;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.f19637g = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            b.a.r0.j0.e.b bVar = null;
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
            this.f19637g = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.f19637g = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            b.a.r0.j0.e.b bVar = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                bVar = (b.a.r0.j0.e.b) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (bVar == null || !u(bVar)) {
                t();
            }
        }
    }

    public final boolean q(ArrayList<b.a.r0.j0.b.b> arrayList, b.a.r0.j0.b.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, bVar)) == null) {
            Iterator<b.a.r0.j0.b.b> it = arrayList.iterator();
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

    public final void s(List<b.a.q0.u.e> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (b.a.q0.u.e eVar : list) {
                if (eVar != null && eVar.f14896b != null) {
                    arrayList.add(b.a.r0.j0.b.b.d(eVar));
                }
            }
            this.f19638h.addAll(arrayList);
            if (ListUtils.getCount(this.f19638h) <= 4) {
                this.l.loadData();
                return;
            }
            this.f19637g = false;
            d dVar = this.k;
            if (dVar != null) {
                dVar.b(this.f19638h, null, z ? 1 : 0);
            }
        }
    }

    public final void t() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (dVar = this.k) == null) {
            return;
        }
        dVar.b(this.f19638h, null, 0);
    }

    public final boolean u(b.a.r0.j0.e.b bVar) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (!ListUtils.isEmpty(bVar.f19654f)) {
                for (b.a.r0.j0.b.b bVar2 : bVar.f19654f) {
                    if (bVar2 != null && (itemData = bVar2.f19630e) != null && !this.j.contains(itemData.pkgName) && b.a.q0.e0.a.e(bVar2.f19630e.pkgName) == null) {
                        this.f19639i.add(bVar2);
                    }
                }
            }
            d dVar = this.k;
            if (dVar != null) {
                dVar.b(this.f19638h, this.f19639i, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<b.a.q0.u.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f19641a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f19642b;

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
            this.f19642b = cVar;
            this.f19641a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<b.a.q0.u.e> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<b.a.q0.u.e> d2 = b.a.r0.j0.c.a.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.f19642b.f19636f >= d2.size()) {
                    return arrayList;
                }
                int i2 = this.f19642b.f19636f;
                while (i2 < d2.size()) {
                    c.h(this.f19642b);
                    b.a.q0.u.e eVar = d2.get(i2);
                    if (eVar != null && !k.isEmpty(eVar.f14895a) && !k.isEmpty(eVar.f14897c)) {
                        ItemData d3 = d(eVar.f14897c);
                        eVar.f14896b = d3;
                        if (d3 != null && d3.apkDetail != null) {
                            PackageInfo e2 = b.a.q0.e0.a.e(eVar.f14895a);
                            if (e2 != null && e2.versionCode >= eVar.f14896b.apkDetail.version_code.intValue()) {
                                b.a.r0.j0.c.a.e().c(eVar.f14895a);
                                c.i(this.f19642b);
                            } else {
                                DownloadData j = b.a.q0.e0.a.j(eVar.f14896b);
                                if (b.a.q0.e0.a.c(j) == 6 && !b.a.q0.e0.a.b(j.getId()) && eVar.f14898d != 2) {
                                    b.a.r0.j0.c.a.e().c(eVar.f14895a);
                                    c.i(this.f19642b);
                                } else if (eVar.f14898d == 2 && !b.a.q0.w.c.q().s(eVar.f14895a) && b.a.q0.e0.a.d(eVar.f14895a, eVar.f14896b.appId) == 6) {
                                    b.a.r0.j0.c.a.e().c(eVar.f14895a);
                                    c.i(this.f19642b);
                                } else {
                                    arrayList.add(eVar);
                                    this.f19642b.j.add(eVar.f14895a);
                                    if (arrayList.size() >= 15) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            b.a.r0.j0.c.a.e().c(eVar.f14895a);
                            c.i(this.f19642b);
                        }
                    }
                    i2++;
                }
                if (arrayList.size() >= 15 && i2 < d2.size()) {
                    this.f19641a = true;
                } else {
                    this.f19641a = false;
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<b.a.q0.u.e> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.f19642b.s(list, this.f19641a);
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
