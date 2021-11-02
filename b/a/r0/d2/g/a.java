package b.a.r0.d2.g;

import androidx.core.view.InputDeviceCompat;
import b.a.e.e.d.l;
import b.a.r0.d2.d;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f15665a;

    /* renamed from: b  reason: collision with root package name */
    public c f15666b;

    /* renamed from: c  reason: collision with root package name */
    public C0795a f15667c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f15668d;

    /* renamed from: e  reason: collision with root package name */
    public int f15669e;

    /* renamed from: f  reason: collision with root package name */
    public int f15670f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15671g;

    /* renamed from: h  reason: collision with root package name */
    public d f15672h;

    /* renamed from: b.a.r0.d2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0795a extends BdAsyncTask<Boolean, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15673a;

        /* renamed from: b  reason: collision with root package name */
        public String f15674b;

        /* renamed from: c  reason: collision with root package name */
        public String f15675c;

        /* renamed from: d  reason: collision with root package name */
        public int f15676d;

        /* renamed from: e  reason: collision with root package name */
        public b.a.r0.d2.g.c f15677e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15678f;

        public C0795a(a aVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15678f = aVar;
            this.f15673a = null;
            this.f15674b = null;
            this.f15675c = null;
            this.f15676d = 0;
            this.f15677e = null;
            this.f15674b = str;
            this.f15676d = i2;
            this.f15675c = str2;
            this.f15677e = new b.a.r0.d2.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f15673a = netWork;
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f15673a.addPostData("tid", this.f15674b);
                this.f15673a.addPostData("fid", this.f15675c);
                this.f15677e.c(this.f15673a.postNetData());
                if (this.f15673a.getNetContext().getResponse().isRequestSuccess() && this.f15677e.a() == 0) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f15673a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f15678f.f15667c = null;
                d dVar = this.f15678f.f15672h;
                if (dVar != null) {
                    dVar.a(2, Boolean.FALSE, null);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bool) == null) {
                String str = null;
                this.f15678f.f15667c = null;
                if (bool.booleanValue()) {
                    if (this.f15676d < this.f15678f.f15668d.size()) {
                        this.f15678f.f15668d.remove(this.f15676d);
                        a.i(this.f15678f);
                    }
                } else if (this.f15673a.getNetContext().getResponse().isRequestSuccess()) {
                    str = this.f15677e.b();
                } else {
                    str = this.f15673a.getErrorString();
                }
                d dVar = this.f15678f.f15672h;
                if (dVar != null) {
                    dVar.a(2, bool, str);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15679a;

        /* renamed from: b  reason: collision with root package name */
        public String f15680b;

        /* renamed from: c  reason: collision with root package name */
        public int f15681c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.r0.d2.g.c f15682d;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f15683e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15684f;

        public b(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15684f = aVar;
            this.f15679a = null;
            this.f15680b = null;
            this.f15681c = 0;
            this.f15682d = null;
            this.f15683e = Boolean.FALSE;
            this.f15681c = i2;
            this.f15682d = new b.a.r0.d2.g.c();
        }

        public final void b(String str) {
            String currentAccount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (currentAccount = TbadkCoreApplication.getCurrentAccount()) == null) {
                return;
            }
            b.a.q0.s.r.a.f();
            l<String> g2 = b.a.q0.s.r.a.g("tb.my_bookmarks");
            if (g2 != null) {
                g2.e(currentAccount, str, 604800000L);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public a doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, boolArr)) == null) {
                this.f15683e = boolArr[0];
                boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
                a aVar = new a();
                if (this.f15683e.booleanValue() && booleanValue) {
                    b.a.q0.s.r.a.f();
                    l<String> g2 = b.a.q0.s.r.a.g("tb.my_bookmarks");
                    if (g2 != null) {
                        publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                    }
                    if (this.f15684f.f15668d == null) {
                        this.f15684f.f15668d = new ArrayList();
                    } else {
                        this.f15684f.f15668d.clear();
                    }
                    this.f15684f.f15669e = 0;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
                this.f15679a = netWork;
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                if (this.f15684f.f15671g) {
                    this.f15679a.addPostData("offset", String.valueOf(0));
                } else {
                    this.f15679a.addPostData("offset", String.valueOf(this.f15681c));
                }
                this.f15679a.addPostData("rn", String.valueOf(20));
                String postNetData = this.f15679a.postNetData();
                this.f15680b = postNetData;
                this.f15682d.c(postNetData);
                if (this.f15679a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.u(this.f15680b);
                    if (this.f15681c == 0) {
                        if (this.f15684f.f15668d == null) {
                            this.f15684f.f15668d = new ArrayList();
                        } else {
                            this.f15684f.f15668d.clear();
                        }
                        this.f15684f.f15669e = 0;
                        if (this.f15683e.booleanValue()) {
                            b(this.f15680b);
                        }
                    }
                }
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f15679a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f15684f.f15665a = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
                if (aVar == null) {
                    aVar = new a();
                }
                b.a.r0.d2.g.c cVar = this.f15682d;
                if (cVar != null) {
                    b.a.q0.s.a0.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f15682d.b(), new Object[0]);
                }
                this.f15684f.f15669e = aVar.m();
                ArrayList<MarkData> n = aVar.n();
                if (this.f15683e.booleanValue()) {
                    if (n != null && n.size() != 0) {
                        this.f15684f.B(n);
                    }
                } else {
                    this.f15684f.k(n);
                }
                Iterator<MarkData> it = n.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (it.next().getNewCounts() > 0) {
                        i2++;
                        this.f15684f.C(i2);
                    }
                }
                if (this.f15684f.f15672h != null) {
                    if (this.f15679a.getNetContext().getResponse().isRequestSuccess()) {
                        this.f15684f.f15672h.a(0, this.f15682d.a() != 0 ? this.f15682d.b() : null, Boolean.FALSE);
                    } else {
                        this.f15684f.f15672h.a(3, this.f15679a.getErrorString());
                    }
                }
                this.f15684f.f15671g = false;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onProgressUpdate(String... strArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr) == null) {
                super.onProgressUpdate((Object[]) strArr);
                String str = strArr[0];
                ArrayList<MarkData> arrayList = new ArrayList<>();
                if (str != null) {
                    arrayList = this.f15684f.t(str);
                    if (this.f15683e.booleanValue()) {
                        this.f15684f.B(arrayList);
                    } else {
                        this.f15684f.k(arrayList);
                    }
                } else {
                    this.f15684f.B(arrayList);
                }
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                this.f15684f.f15672h.a(0, null, Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<a, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15665a = null;
        this.f15666b = null;
        this.f15667c = null;
        this.f15669e = 0;
        this.f15670f = 0;
        this.f15671g = false;
        this.f15672h = null;
        this.f15668d = new ArrayList<>();
        this.f15671g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i2 = aVar.f15670f;
        aVar.f15670f = i2 - 1;
        return i2;
    }

    public void A(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f15672h = dVar;
        }
    }

    public void B(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f15668d = arrayList;
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f15670f = i2;
        }
    }

    public boolean D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            C0795a c0795a = this.f15667c;
            if (c0795a != null) {
                c0795a.cancel();
            }
            if (i2 >= this.f15668d.size() || this.f15668d.get(i2) == null || this.f15668d.get(i2).getId() == null) {
                return false;
            }
            C0795a c0795a2 = new C0795a(this, this.f15668d.get(i2).getId(), i2, this.f15668d.get(i2).getForumId());
            this.f15667c = c0795a2;
            c0795a2.setPriority(2);
            this.f15667c.execute(new Boolean[0]);
            return true;
        }
        return invokeI.booleanValue;
    }

    public String E(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            ArrayList<MarkData> arrayList = this.f15668d;
            if (arrayList == null) {
                return null;
            }
            if (i2 >= arrayList.size()) {
                i3 -= (i2 - this.f15668d.size()) - 1;
                i2 = this.f15668d.size() - 1;
            }
            JSONArray jSONArray = new JSONArray();
            int i4 = 0;
            for (int i5 = i2; i5 >= 0 && i5 > i2 - i3; i5--) {
                try {
                    JSONObject json = this.f15668d.get(i5).toJson();
                    if (json != null && i4 >= 0) {
                        int i6 = i4 + 1;
                        jSONArray.put(i4, json);
                        i4 = i6;
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.toString());
                    jSONArray = null;
                }
            }
            if (jSONArray == null) {
                return null;
            }
            return jSONArray.toString();
        }
        return (String) invokeII.objValue;
    }

    public void j(MarkData markData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, markData) == null) {
            this.f15668d.add(markData);
        }
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || (arrayList2 = this.f15668d) == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i2) {
        ArrayList<MarkData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || (arrayList = this.f15668d) == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f15668d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            if (next != null && next.getId().equals(str)) {
                next.setReplyNum(i2);
            }
        }
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ArrayList<MarkData> arrayList = this.f15668d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public ArrayList<MarkData> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f15668d : (ArrayList) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f15670f : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f15669e : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<MarkData> arrayList = this.f15668d;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f15669e > 0 : invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b bVar = this.f15665a;
            if (bVar != null) {
                bVar.cancel();
            }
            c cVar = this.f15666b;
            if (cVar != null) {
                cVar.cancel();
            }
            C0795a c0795a = this.f15667c;
            if (c0795a != null) {
                c0795a.cancel();
            }
        }
    }

    public final ArrayList<MarkData> t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            ArrayList<MarkData> arrayList = new ArrayList<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        MarkData markData = new MarkData();
                        markData.paserJson(optJSONArray.getJSONObject(i2));
                        arrayList.add(markData);
                    }
                    return arrayList;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.toString());
                return null;
            }
        }
        return (ArrayList) invokeL.objValue;
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            try {
                v(new JSONObject(str));
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public void v(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jSONObject) == null) {
            try {
                if (jSONObject.optJSONObject("error").optString("errno").equals("0")) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("store_thread");
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        MarkData markData = new MarkData();
                        markData.paserJson(optJSONArray.getJSONObject(i2));
                        this.f15668d.add(markData);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public void w(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bool) == null) {
            x(bool, true);
        }
    }

    public void x(Boolean bool, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048595, this, bool, z) == null) {
            b bVar = this.f15665a;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, q());
            this.f15665a = bVar2;
            bVar2.setPriority(3);
            this.f15665a.execute(bool, Boolean.valueOf(z));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.f15668d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f15668d.iterator();
        while (it.hasNext()) {
            MarkData next = it.next();
            String id = next.getId();
            int replyNum = next.getReplyNum();
            if (!hashSet.add(id)) {
                l(id, replyNum);
                it.remove();
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.f15670f = 0;
            this.f15669e = 0;
            this.f15671g = true;
        }
    }
}
