package c.a.p0.s.n;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.d.l;
import c.a.e.e.l.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.bigday.GetBigdayInfoHttpResMessage;
import com.baidu.tbadk.core.bigday.GetBigdayInfoReqMessage;
import com.baidu.tbadk.core.bigday.GetBigdayInfoSocketResMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigdayImageLoaderProc;
import com.baidu.tbadk.switchs.BigdaySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.GetBigday.BigdayInfo;
import tbclient.GetBigday.GetBigdayResIdl;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static b f14080h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.s.n.a f14081a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.s.n.a f14082b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f14083c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c.a.p0.s.n.a> f14084d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f14085e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14086f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.c.g.a f14087g;

    /* loaded from: classes3.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f14088a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14088a = bVar;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.hasError()) {
                return;
            }
            this.f14088a.f14086f = true;
            ArrayList<c.a.p0.s.n.a> arrayList = null;
            if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
            } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
            }
            this.f14088a.m(arrayList);
        }
    }

    /* renamed from: c.a.p0.s.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0693b extends BdAsyncTask<Void, Void, ArrayList<c.a.p0.s.n.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f14089a;

        public C0693b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14089a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<c.a.p0.s.n.a> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                ArrayList<c.a.p0.s.n.a> arrayList = new ArrayList<>();
                c.a.p0.s.r.a.f();
                l<byte[]> d2 = c.a.p0.s.r.a.d("tb.bigday_datas");
                if (d2 == null || (bArr = d2.get("tb.bigday_datas")) == null) {
                    return arrayList;
                }
                try {
                    GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                    if (getBigdayResIdl.data != null) {
                        for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                            if (bigdayInfo != null) {
                                c.a.p0.s.n.a aVar = new c.a.p0.s.n.a();
                                aVar.b(bigdayInfo);
                                if (aVar.a()) {
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        return arrayList;
                    }
                    return arrayList;
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ArrayList) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ArrayList<c.a.p0.s.n.a> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    this.f14089a.l(arrayList);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends DiskFileOperate implements c.a.e.e.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f14090a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, ArrayList<c.a.p0.s.n.a> arrayList) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action, arrayList};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14090a = new ArrayList<>();
            Iterator<c.a.p0.s.n.a> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.p0.s.n.a next = it.next();
                if (next != null) {
                    String g2 = d.h().g(next.f14073a, 41);
                    if (!StringUtils.isNULL(g2)) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g2);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.f14090a.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // c.a.e.e.a.a
        public boolean compare(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? (file == null || StringUtils.isNULL(file.getName()) || this.f14090a.contains(file.getName())) ? false : true : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-843549697, "Lc/a/p0/s/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-843549697, "Lc/a/p0/s/n/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14086f = false;
        this.f14087g = new a(this, CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);
        c.a.q0.i3.d0.a.h(309609, GetBigdayInfoSocketResMessage.class, false, false);
        c.a.q0.i3.d0.a.c(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.f14087g);
        this.f14083c = new SparseArray<>();
    }

    public static b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f14080h == null) {
                f14080h = new b();
            }
            return f14080h;
        }
        return (b) invokeV.objValue;
    }

    public final void d(ArrayList<c.a.p0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            ArrayList arrayList2 = new ArrayList();
            ListUtils.addAll(arrayList2, 0, arrayList);
            ListUtils.add(arrayList2, this.f14081a);
            ListUtils.add(arrayList2, this.f14082b);
            c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            c.a.e.e.a.d.g().a(cVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f14087g);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.f14084d)) {
            return;
        }
        Iterator<c.a.p0.s.n.a> it = this.f14084d.iterator();
        while (it.hasNext()) {
            c.a.p0.s.n.a next = it.next();
            if (!BigdayImageLoaderProc.isImageFileExist(next.f14073a)) {
                d.h().m(next.f14073a, 41, null, this.f14085e);
            }
        }
    }

    public final c.a.p0.s.n.a g(List<c.a.p0.s.n.a> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, list, i2)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            for (c.a.p0.s.n.a aVar : list) {
                if (aVar.a() && aVar.f14077e == i2) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j2 = aVar.f14078f;
                    if (j2 > currentTimeMillis) {
                        this.f14083c.put(i2, Long.valueOf(j2));
                        return null;
                    } else if (aVar.f14079g >= currentTimeMillis) {
                        return aVar;
                    }
                }
            }
            return null;
        }
        return (c.a.p0.s.n.a) invokeLI.objValue;
    }

    public c.a.p0.s.n.a h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (i2 == 1) {
                if (this.f14081a == null && this.f14083c.get(i2, 0L).longValue() != 0 && this.f14083c.get(i2, 0L).longValue() < currentTimeMillis) {
                    this.f14081a = g(this.f14084d, 1);
                }
                c.a.p0.s.n.a aVar = this.f14081a;
                if (aVar != null && (currentTimeMillis < aVar.f14078f || currentTimeMillis > aVar.f14079g)) {
                    this.f14081a = g(this.f14084d, 1);
                }
                c.a.p0.s.n.a aVar2 = this.f14081a;
                if (aVar2 != null && BigdayImageLoaderProc.isImageFileExist(aVar2.f14073a)) {
                    return this.f14081a;
                }
            } else if (i2 == 3) {
                if (this.f14082b == null && this.f14083c.get(i2, 0L).longValue() != 0 && this.f14083c.get(i2, 0L).longValue() < currentTimeMillis) {
                    this.f14081a = g(this.f14084d, 3);
                }
                c.a.p0.s.n.a aVar3 = this.f14082b;
                if (aVar3 != null && (currentTimeMillis < aVar3.f14078f || currentTimeMillis > aVar3.f14079g)) {
                    this.f14082b = g(this.f14084d, 3);
                }
                c.a.p0.s.n.a aVar4 = this.f14082b;
                if (aVar4 != null && BigdayImageLoaderProc.isImageFileExist(aVar4.f14073a)) {
                    return this.f14082b;
                }
            }
            return null;
        }
        return (c.a.p0.s.n.a) invokeI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            new C0693b(this).execute(new Void[0]);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f14086f = false;
            GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
            getBigdayInfoReqMessage.setTag(this.f14085e);
            MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
        }
    }

    public final void l(ArrayList<c.a.p0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || this.f14086f) {
            return;
        }
        this.f14081a = g(arrayList, 1);
        this.f14082b = g(arrayList, 3);
        this.f14084d = arrayList;
        f();
        c.a.p0.s.n.a aVar = this.f14081a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f14073a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= c.a.p0.s.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f14081a));
    }

    public final void m(ArrayList<c.a.p0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            c.a.p0.s.n.a g2 = g(arrayList, 1);
            c.a.p0.s.n.a g3 = g(arrayList, 3);
            d(arrayList);
            this.f14084d = arrayList;
            if (g2 != null && g2.a()) {
                this.f14081a = g2;
            }
            if (g3 != null && g3.a()) {
                this.f14082b = g3;
            }
            f();
            c.a.p0.s.n.a aVar = this.f14081a;
            if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f14073a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= c.a.p0.s.d0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f14081a));
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.f14085e = bdUniqueId;
        }
    }
}
