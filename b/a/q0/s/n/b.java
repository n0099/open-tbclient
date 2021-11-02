package b.a.q0.s.n;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.d.l;
import b.a.e.e.l.d;
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
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static b f13169h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b.a.q0.s.n.a f13170a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.q0.s.n.a f13171b;

    /* renamed from: c  reason: collision with root package name */
    public SparseArray<Long> f13172c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<b.a.q0.s.n.a> f13173d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f13174e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13175f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.e.c.g.a f13176g;

    /* loaded from: classes4.dex */
    public class a extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f13177a;

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
            this.f13177a = bVar;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null || responsedMessage.hasError()) {
                return;
            }
            this.f13177a.f13175f = true;
            ArrayList<b.a.q0.s.n.a> arrayList = null;
            if (responsedMessage instanceof GetBigdayInfoSocketResMessage) {
                arrayList = ((GetBigdayInfoSocketResMessage) responsedMessage).bigdayInfos;
            } else if (responsedMessage instanceof GetBigdayInfoHttpResMessage) {
                arrayList = ((GetBigdayInfoHttpResMessage) responsedMessage).bigdayInfos;
            }
            this.f13177a.m(arrayList);
        }
    }

    /* renamed from: b.a.q0.s.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0688b extends BdAsyncTask<Void, Void, ArrayList<b.a.q0.s.n.a>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f13178a;

        public C0688b(b bVar) {
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
            this.f13178a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ArrayList<b.a.q0.s.n.a> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                ArrayList<b.a.q0.s.n.a> arrayList = new ArrayList<>();
                b.a.q0.s.r.a.f();
                l<byte[]> d2 = b.a.q0.s.r.a.d("tb.bigday_datas");
                if (d2 == null || (bArr = d2.get("tb.bigday_datas")) == null) {
                    return arrayList;
                }
                try {
                    GetBigdayResIdl getBigdayResIdl = (GetBigdayResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBigdayResIdl.class);
                    if (getBigdayResIdl.data != null) {
                        for (BigdayInfo bigdayInfo : getBigdayResIdl.data.bigday_list) {
                            if (bigdayInfo != null) {
                                b.a.q0.s.n.a aVar = new b.a.q0.s.n.a();
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
        public void onPostExecute(ArrayList<b.a.q0.s.n.a> arrayList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
                super.onPostExecute(arrayList);
                if (arrayList != null) {
                    this.f13178a.l(arrayList);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends DiskFileOperate implements b.a.e.e.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<String> f13179a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, String str2, DiskFileOperate.Action action, ArrayList<b.a.q0.s.n.a> arrayList) {
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
            this.f13179a = new ArrayList<>();
            Iterator<b.a.q0.s.n.a> it = arrayList.iterator();
            while (it.hasNext()) {
                b.a.q0.s.n.a next = it.next();
                if (next != null) {
                    String g2 = d.h().g(next.f13162a, 41);
                    if (!StringUtils.isNULL(g2)) {
                        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(g2);
                        if (!StringUtils.isNULL(nameMd5FromUrl)) {
                            this.f13179a.add(nameMd5FromUrl);
                        }
                    }
                }
            }
        }

        @Override // b.a.e.e.a.a
        public boolean compare(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? (file == null || StringUtils.isNULL(file.getName()) || this.f13179a.contains(file.getName())) ? false : true : invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1937366143, "Lb/a/q0/s/n/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1937366143, "Lb/a/q0/s/n/b;");
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
        this.f13175f = false;
        this.f13176g = new a(this, CmdConfigHttp.CMD_GET_BIGDAY_INFO, 309609);
        b.a.r0.l3.f0.a.h(309609, GetBigdayInfoSocketResMessage.class, false, false);
        b.a.r0.l3.f0.a.c(309609, CmdConfigHttp.CMD_GET_BIGDAY_INFO, "c/s/getBigday", GetBigdayInfoHttpResMessage.class, false, false, true, false);
        MessageManager.getInstance().registerListener(this.f13176g);
        this.f13172c = new SparseArray<>();
    }

    public static b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f13169h == null) {
                f13169h = new b();
            }
            return f13169h;
        }
        return (b) invokeV.objValue;
    }

    public final void d(ArrayList<b.a.q0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            ArrayList arrayList2 = new ArrayList();
            ListUtils.addAll(arrayList2, 0, arrayList);
            ListUtils.add(arrayList2, this.f13170a);
            ListUtils.add(arrayList2, this.f13171b);
            c cVar = new c(TbConfig.BIGDAY_IMAGE_CACHE_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES, arrayList2);
            cVar.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            cVar.setSdCard(false);
            cVar.setSavedCache(true);
            b.a.e.e.a.d.f().a(cVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f13176g);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.f13173d)) {
            return;
        }
        Iterator<b.a.q0.s.n.a> it = this.f13173d.iterator();
        while (it.hasNext()) {
            b.a.q0.s.n.a next = it.next();
            if (!BigdayImageLoaderProc.isImageFileExist(next.f13162a)) {
                d.h().m(next.f13162a, 41, null, this.f13174e);
            }
        }
    }

    public final b.a.q0.s.n.a g(List<b.a.q0.s.n.a> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, list, i2)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            for (b.a.q0.s.n.a aVar : list) {
                if (aVar.a() && aVar.f13166e == i2) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j = aVar.f13167f;
                    if (j > currentTimeMillis) {
                        this.f13172c.put(i2, Long.valueOf(j));
                        return null;
                    } else if (aVar.f13168g >= currentTimeMillis) {
                        return aVar;
                    }
                }
            }
            return null;
        }
        return (b.a.q0.s.n.a) invokeLI.objValue;
    }

    public b.a.q0.s.n.a h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (i2 == 1) {
                if (this.f13170a == null && this.f13172c.get(i2, 0L).longValue() != 0 && this.f13172c.get(i2, 0L).longValue() < currentTimeMillis) {
                    this.f13170a = g(this.f13173d, 1);
                }
                b.a.q0.s.n.a aVar = this.f13170a;
                if (aVar != null && (currentTimeMillis < aVar.f13167f || currentTimeMillis > aVar.f13168g)) {
                    this.f13170a = g(this.f13173d, 1);
                }
                b.a.q0.s.n.a aVar2 = this.f13170a;
                if (aVar2 != null && BigdayImageLoaderProc.isImageFileExist(aVar2.f13162a)) {
                    return this.f13170a;
                }
            } else if (i2 == 3) {
                if (this.f13171b == null && this.f13172c.get(i2, 0L).longValue() != 0 && this.f13172c.get(i2, 0L).longValue() < currentTimeMillis) {
                    this.f13170a = g(this.f13173d, 3);
                }
                b.a.q0.s.n.a aVar3 = this.f13171b;
                if (aVar3 != null && (currentTimeMillis < aVar3.f13167f || currentTimeMillis > aVar3.f13168g)) {
                    this.f13171b = g(this.f13173d, 3);
                }
                b.a.q0.s.n.a aVar4 = this.f13171b;
                if (aVar4 != null && BigdayImageLoaderProc.isImageFileExist(aVar4.f13162a)) {
                    return this.f13171b;
                }
            }
            return null;
        }
        return (b.a.q0.s.n.a) invokeI.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            new C0688b(this).execute(new Void[0]);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f13175f = false;
            GetBigdayInfoReqMessage getBigdayInfoReqMessage = new GetBigdayInfoReqMessage();
            getBigdayInfoReqMessage.setTag(this.f13174e);
            MessageManager.getInstance().sendMessage(getBigdayInfoReqMessage);
        }
    }

    public final void l(ArrayList<b.a.q0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || ListUtils.isEmpty(arrayList) || this.f13175f) {
            return;
        }
        this.f13170a = g(arrayList, 1);
        this.f13171b = g(arrayList, 3);
        this.f13173d = arrayList;
        f();
        b.a.q0.s.n.a aVar = this.f13170a;
        if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f13162a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= b.a.q0.s.e0.b.j().l("key_bigday_next_showtime_home", 0L)) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f13170a));
    }

    public final void m(ArrayList<b.a.q0.s.n.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            b.a.q0.s.n.a g2 = g(arrayList, 1);
            b.a.q0.s.n.a g3 = g(arrayList, 3);
            d(arrayList);
            this.f13173d = arrayList;
            if (g2 != null && g2.a()) {
                this.f13170a = g2;
            }
            if (g3 != null && g3.a()) {
                this.f13171b = g3;
            }
            f();
            b.a.q0.s.n.a aVar = this.f13170a;
            if (aVar == null || !BigdayImageLoaderProc.isImageFileExist(aVar.f13162a) || SwitchManager.getInstance().findType(BigdaySwitch.BIGDAY_KEY) != 1 || System.currentTimeMillis() <= b.a.q0.s.e0.b.j().l("key_bigday_next_showtime_home", 0L)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, this.f13170a));
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
            this.f13174e = bdUniqueId;
        }
    }
}
