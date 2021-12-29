package c.a.s0.s.n;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.l;
import c.a.d.f.l.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static b f13566h;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.s0.s.n.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.s0.s.n.a f13567b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f13568c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c.a.s0.s.n.a> f13569d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f13570e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13571f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.c.g.a f13572g;

    /* loaded from: classes6.dex */
    public class a extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

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
            this.a = bVar;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.hasError()) {
                return;
            }
            this.a.f13571f = true;
            ArrayList<c.a.s0.s.n.a> arrayList = null;
            if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
            } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
            }
            this.a.m(arrayList);
        }
    }

    /* renamed from: c.a.s0.s.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0866b extends BdAsyncTask<Void, Void, ArrayList<c.a.s0.s.n.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public C0866b(b bVar) {
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
            this.a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<c.a.s0.s.n.a> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                ArrayList<c.a.s0.s.n.a> arrayList = new ArrayList<>();
                c.a.s0.s.r.a.f();
                l<byte[]> d2 = c.a.s0.s.r.a.d("tb.bigday_datas");
                if (d2 == null || (bArr = d2.get("tb.bigday_datas")) == null) {
                    return arrayList;
                }
                try {
                    GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                    if (getBigdayResIdl.data != null) {
                        for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                            if (bigdayInfo != null) {
                                c.a.s0.s.n.a aVar = new c.a.s0.s.n.a();
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
        public void onPostExecute(ArrayList<c.a.s0.s.n.a> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    this.a.l(arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends DiskFileOperate implements c.a.d.f.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<String> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, ArrayList<c.a.s0.s.n.a> arrayList) {
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
            this.a = new ArrayList<>();
            Iterator<c.a.s0.s.n.a> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.s0.s.n.a next = it.next();
                if (next != null) {
                    String g2 = d.h().g(next.a, 41);
                    if (!StringUtils.isNULL(g2)) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g2);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.a.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // c.a.d.f.a.a
        public boolean compare(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? (file == null || StringUtils.isNULL(file.getName()) || this.a.contains(file.getName())) ? false : true : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1970945790, "Lc/a/s0/s/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1970945790, "Lc/a/s0/s/n/b;");
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
        this.f13571f = false;
        this.f13572g = new a(this, CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);
        c.a.t0.w3.f0.a.h(309609, GetBigdayInfoSocketResMessage.class, false, false);
        c.a.t0.w3.f0.a.c(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.f13572g);
        this.f13568c = new SparseArray<>();
    }

    public static b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (f13566h == null) {
                f13566h = new b();
            }
            return f13566h;
        }
        return (b) invokeV.objValue;
    }

    public final void d(ArrayList<c.a.s0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            ArrayList arrayList2 = new ArrayList();
            ListUtils.addAll(arrayList2, 0, arrayList);
            ListUtils.add(arrayList2, this.a);
            ListUtils.add(arrayList2, this.f13567b);
            c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            c.a.d.f.a.d.f().a(cVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f13572g);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.f13569d)) {
            return;
        }
        Iterator<c.a.s0.s.n.a> it = this.f13569d.iterator();
        while (it.hasNext()) {
            c.a.s0.s.n.a next = it.next();
            if (!BigdayImageLoaderProc.isImageFileExist(next.a)) {
                d.h().m(next.a, 41, null, this.f13570e);
            }
        }
    }

    public final c.a.s0.s.n.a g(List<c.a.s0.s.n.a> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, list, i2)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            for (c.a.s0.s.n.a aVar : list) {
                if (aVar.a() && aVar.f13563e == i2) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j2 = aVar.f13564f;
                    if (j2 > currentTimeMillis) {
                        this.f13568c.put(i2, Long.valueOf(j2));
                        return null;
                    } else if (aVar.f13565g >= currentTimeMillis) {
                        return aVar;
                    }
                }
            }
            return null;
        }
        return (c.a.s0.s.n.a) invokeLI.objValue;
    }

    public c.a.s0.s.n.a h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (i2 == 1) {
                if (this.a == null && this.f13568c.get(i2, 0L).longValue() != 0 && this.f13568c.get(i2, 0L).longValue() < currentTimeMillis) {
                    this.a = g(this.f13569d, 1);
                }
                c.a.s0.s.n.a aVar = this.a;
                if (aVar != null && (currentTimeMillis < aVar.f13564f || currentTimeMillis > aVar.f13565g)) {
                    this.a = g(this.f13569d, 1);
                }
                c.a.s0.s.n.a aVar2 = this.a;
                if (aVar2 != null && BigdayImageLoaderProc.isImageFileExist(aVar2.a)) {
                    return this.a;
                }
            } else if (i2 == 3) {
                if (this.f13567b == null && this.f13568c.get(i2, 0L).longValue() != 0 && this.f13568c.get(i2, 0L).longValue() < currentTimeMillis) {
                    this.a = g(this.f13569d, 3);
                }
                c.a.s0.s.n.a aVar3 = this.f13567b;
                if (aVar3 != null && (currentTimeMillis < aVar3.f13564f || currentTimeMillis > aVar3.f13565g)) {
                    this.f13567b = g(this.f13569d, 3);
                }
                c.a.s0.s.n.a aVar4 = this.f13567b;
                if (aVar4 != null && BigdayImageLoaderProc.isImageFileExist(aVar4.a)) {
                    return this.f13567b;
                }
            }
            return null;
        }
        return (c.a.s0.s.n.a) invokeI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            new C0866b(this).execute(new Void[0]);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f13571f = false;
            GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
            getBigdayInfoReqMessage.setTag(this.f13570e);
            MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
        }
    }

    public final void l(ArrayList<c.a.s0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || this.f13571f) {
            return;
        }
        this.a = g(arrayList, 1);
        this.f13567b = g(arrayList, 3);
        this.f13569d = arrayList;
        f();
        c.a.s0.s.n.a aVar = this.a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= c.a.s0.s.g0.b.j().l("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.a));
    }

    public final void m(ArrayList<c.a.s0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            c.a.s0.s.n.a g2 = g(arrayList, 1);
            c.a.s0.s.n.a g3 = g(arrayList, 3);
            d(arrayList);
            this.f13569d = arrayList;
            if (g2 != null && g2.a()) {
                this.a = g2;
            }
            if (g3 != null && g3.a()) {
                this.f13567b = g3;
            }
            f();
            c.a.s0.s.n.a aVar = this.a;
            if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= c.a.s0.s.g0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.a));
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
            this.f13570e = bdUniqueId;
        }
    }
}
