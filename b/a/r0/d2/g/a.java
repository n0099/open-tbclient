package b.a.r0.d2.g;

import androidx.core.view.InputDeviceCompat;
import b.a.e.f.d.l;
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
    public b f16780a;

    /* renamed from: b  reason: collision with root package name */
    public c f16781b;

    /* renamed from: c  reason: collision with root package name */
    public C0841a f16782c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f16783d;

    /* renamed from: e  reason: collision with root package name */
    public int f16784e;

    /* renamed from: f  reason: collision with root package name */
    public int f16785f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16786g;

    /* renamed from: h  reason: collision with root package name */
    public d f16787h;

    /* renamed from: b.a.r0.d2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0841a extends BdAsyncTask<Boolean, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f16788a;

        /* renamed from: b  reason: collision with root package name */
        public String f16789b;

        /* renamed from: c  reason: collision with root package name */
        public String f16790c;

        /* renamed from: d  reason: collision with root package name */
        public int f16791d;

        /* renamed from: e  reason: collision with root package name */
        public b.a.r0.d2.g.c f16792e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16793f;

        public C0841a(a aVar, String str, int i2, String str2) {
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
            this.f16793f = aVar;
            this.f16788a = null;
            this.f16789b = null;
            this.f16790c = null;
            this.f16791d = 0;
            this.f16792e = null;
            this.f16789b = str;
            this.f16791d = i2;
            this.f16790c = str2;
            this.f16792e = new b.a.r0.d2.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f16788a = netWork;
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f16788a.addPostData("tid", this.f16789b);
                this.f16788a.addPostData("fid", this.f16790c);
                this.f16792e.c(this.f16788a.postNetData());
                if (this.f16788a.getNetContext().getResponse().isRequestSuccess() && this.f16792e.a() == 0) {
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
                NetWork netWork = this.f16788a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f16793f.f16782c = null;
                d dVar = this.f16793f.f16787h;
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
                this.f16793f.f16782c = null;
                if (bool.booleanValue()) {
                    if (this.f16791d < this.f16793f.f16783d.size()) {
                        this.f16793f.f16783d.remove(this.f16791d);
                        a.i(this.f16793f);
                    }
                } else if (this.f16788a.getNetContext().getResponse().isRequestSuccess()) {
                    str = this.f16792e.b();
                } else {
                    str = this.f16788a.getErrorString();
                }
                d dVar = this.f16793f.f16787h;
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
        public NetWork f16794a;

        /* renamed from: b  reason: collision with root package name */
        public String f16795b;

        /* renamed from: c  reason: collision with root package name */
        public int f16796c;

        /* renamed from: d  reason: collision with root package name */
        public b.a.r0.d2.g.c f16797d;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f16798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f16799f;

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
            this.f16799f = aVar;
            this.f16794a = null;
            this.f16795b = null;
            this.f16796c = 0;
            this.f16797d = null;
            this.f16798e = Boolean.FALSE;
            this.f16796c = i2;
            this.f16797d = new b.a.r0.d2.g.c();
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
                this.f16798e = boolArr[0];
                boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
                a aVar = new a();
                if (this.f16798e.booleanValue() && booleanValue) {
                    b.a.q0.s.r.a.f();
                    l<String> g2 = b.a.q0.s.r.a.g("tb.my_bookmarks");
                    if (g2 != null) {
                        publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                    }
                    if (this.f16799f.f16783d == null) {
                        this.f16799f.f16783d = new ArrayList();
                    } else {
                        this.f16799f.f16783d.clear();
                    }
                    this.f16799f.f16784e = 0;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
                this.f16794a = netWork;
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                if (this.f16799f.f16786g) {
                    this.f16794a.addPostData("offset", String.valueOf(0));
                } else {
                    this.f16794a.addPostData("offset", String.valueOf(this.f16796c));
                }
                this.f16794a.addPostData("rn", String.valueOf(20));
                String postNetData = this.f16794a.postNetData();
                this.f16795b = postNetData;
                this.f16797d.c(postNetData);
                if (this.f16794a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.u(this.f16795b);
                    if (this.f16796c == 0) {
                        if (this.f16799f.f16783d == null) {
                            this.f16799f.f16783d = new ArrayList();
                        } else {
                            this.f16799f.f16783d.clear();
                        }
                        this.f16799f.f16784e = 0;
                        if (this.f16798e.booleanValue()) {
                            b(this.f16795b);
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
                NetWork netWork = this.f16794a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f16799f.f16780a = null;
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
                b.a.r0.d2.g.c cVar = this.f16797d;
                if (cVar != null) {
                    b.a.q0.s.a0.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f16797d.b(), new Object[0]);
                }
                this.f16799f.f16784e = aVar.m();
                ArrayList<MarkData> n = aVar.n();
                if (this.f16798e.booleanValue()) {
                    if (n != null && n.size() != 0) {
                        this.f16799f.B(n);
                    }
                } else {
                    this.f16799f.k(n);
                }
                Iterator<MarkData> it = n.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (it.next().getNewCounts() > 0) {
                        i2++;
                        this.f16799f.C(i2);
                    }
                }
                if (this.f16799f.f16787h != null) {
                    if (this.f16794a.getNetContext().getResponse().isRequestSuccess()) {
                        this.f16799f.f16787h.a(0, this.f16797d.a() != 0 ? this.f16797d.b() : null, Boolean.FALSE);
                    } else {
                        this.f16799f.f16787h.a(3, this.f16794a.getErrorString());
                    }
                }
                this.f16799f.f16786g = false;
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
                    arrayList = this.f16799f.t(str);
                    if (this.f16798e.booleanValue()) {
                        this.f16799f.B(arrayList);
                    } else {
                        this.f16799f.k(arrayList);
                    }
                } else {
                    this.f16799f.B(arrayList);
                }
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                this.f16799f.f16787h.a(0, null, Boolean.TRUE);
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
        this.f16780a = null;
        this.f16781b = null;
        this.f16782c = null;
        this.f16784e = 0;
        this.f16785f = 0;
        this.f16786g = false;
        this.f16787h = null;
        this.f16783d = new ArrayList<>();
        this.f16786g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i2 = aVar.f16785f;
        aVar.f16785f = i2 - 1;
        return i2;
    }

    public void A(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f16787h = dVar;
        }
    }

    public void B(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f16783d = arrayList;
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f16785f = i2;
        }
    }

    public boolean D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            C0841a c0841a = this.f16782c;
            if (c0841a != null) {
                c0841a.cancel();
            }
            if (i2 >= this.f16783d.size() || this.f16783d.get(i2) == null || this.f16783d.get(i2).getId() == null) {
                return false;
            }
            C0841a c0841a2 = new C0841a(this, this.f16783d.get(i2).getId(), i2, this.f16783d.get(i2).getForumId());
            this.f16782c = c0841a2;
            c0841a2.setPriority(2);
            this.f16782c.execute(new Boolean[0]);
            return true;
        }
        return invokeI.booleanValue;
    }

    public String E(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            ArrayList<MarkData> arrayList = this.f16783d;
            if (arrayList == null) {
                return null;
            }
            if (i2 >= arrayList.size()) {
                i3 -= (i2 - this.f16783d.size()) - 1;
                i2 = this.f16783d.size() - 1;
            }
            JSONArray jSONArray = new JSONArray();
            int i4 = 0;
            for (int i5 = i2; i5 >= 0 && i5 > i2 - i3; i5--) {
                try {
                    JSONObject json = this.f16783d.get(i5).toJson();
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
            this.f16783d.add(markData);
        }
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || (arrayList2 = this.f16783d) == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i2) {
        ArrayList<MarkData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || (arrayList = this.f16783d) == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f16783d.iterator();
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
            ArrayList<MarkData> arrayList = this.f16783d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f16783d : (ArrayList) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f16785f : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f16784e : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<MarkData> arrayList = this.f16783d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f16784e > 0 : invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b bVar = this.f16780a;
            if (bVar != null) {
                bVar.cancel();
            }
            c cVar = this.f16781b;
            if (cVar != null) {
                cVar.cancel();
            }
            C0841a c0841a = this.f16782c;
            if (c0841a != null) {
                c0841a.cancel();
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
                        this.f16783d.add(markData);
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
            b bVar = this.f16780a;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, q());
            this.f16780a = bVar2;
            bVar2.setPriority(3);
            this.f16780a.execute(bool, Boolean.valueOf(z));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.f16783d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f16783d.iterator();
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
            this.f16785f = 0;
            this.f16784e = 0;
            this.f16786g = true;
        }
    }
}
