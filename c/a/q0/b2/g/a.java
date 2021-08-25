package c.a.q0.b2.g;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.d.l;
import c.a.q0.b2.d;
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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f15970a;

    /* renamed from: b  reason: collision with root package name */
    public c f15971b;

    /* renamed from: c  reason: collision with root package name */
    public C0758a f15972c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<MarkData> f15973d;

    /* renamed from: e  reason: collision with root package name */
    public int f15974e;

    /* renamed from: f  reason: collision with root package name */
    public int f15975f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f15976g;

    /* renamed from: h  reason: collision with root package name */
    public d f15977h;

    /* renamed from: c.a.q0.b2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0758a extends BdAsyncTask<Boolean, Integer, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15978a;

        /* renamed from: b  reason: collision with root package name */
        public String f15979b;

        /* renamed from: c  reason: collision with root package name */
        public String f15980c;

        /* renamed from: d  reason: collision with root package name */
        public int f15981d;

        /* renamed from: e  reason: collision with root package name */
        public c.a.q0.b2.g.c f15982e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15983f;

        public C0758a(a aVar, String str, int i2, String str2) {
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
            this.f15983f = aVar;
            this.f15978a = null;
            this.f15979b = null;
            this.f15980c = null;
            this.f15981d = 0;
            this.f15982e = null;
            this.f15979b = str;
            this.f15981d = i2;
            this.f15980c = str2;
            this.f15982e = new c.a.q0.b2.g.c();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Boolean doInBackground(Boolean... boolArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_DELSTORE);
                this.f15978a = netWork;
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                this.f15978a.addPostData("tid", this.f15979b);
                this.f15978a.addPostData("fid", this.f15980c);
                this.f15982e.c(this.f15978a.postNetData());
                if (this.f15978a.getNetContext().getResponse().isRequestSuccess() && this.f15982e.a() == 0) {
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
                NetWork netWork = this.f15978a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f15983f.f15972c = null;
                d dVar = this.f15983f.f15977h;
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
                this.f15983f.f15972c = null;
                if (bool.booleanValue()) {
                    if (this.f15981d < this.f15983f.f15973d.size()) {
                        this.f15983f.f15973d.remove(this.f15981d);
                        a.i(this.f15983f);
                    }
                } else if (this.f15978a.getNetContext().getResponse().isRequestSuccess()) {
                    str = this.f15982e.b();
                } else {
                    str = this.f15978a.getErrorString();
                }
                d dVar = this.f15983f.f15977h;
                if (dVar != null) {
                    dVar.a(2, bool, str);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Boolean, String, a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f15984a;

        /* renamed from: b  reason: collision with root package name */
        public String f15985b;

        /* renamed from: c  reason: collision with root package name */
        public int f15986c;

        /* renamed from: d  reason: collision with root package name */
        public c.a.q0.b2.g.c f15987d;

        /* renamed from: e  reason: collision with root package name */
        public Boolean f15988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15989f;

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
            this.f15989f = aVar;
            this.f15984a = null;
            this.f15985b = null;
            this.f15986c = 0;
            this.f15987d = null;
            this.f15988e = Boolean.FALSE;
            this.f15986c = i2;
            this.f15987d = new c.a.q0.b2.g.c();
        }

        public final void b(String str) {
            String currentAccount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (currentAccount = TbadkCoreApplication.getCurrentAccount()) == null) {
                return;
            }
            c.a.p0.s.r.a.f();
            l<String> g2 = c.a.p0.s.r.a.g("tb.my_bookmarks");
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
                this.f15988e = boolArr[0];
                boolean booleanValue = (boolArr.length < 2 || boolArr[1] == null) ? true : boolArr[1].booleanValue();
                a aVar = new a();
                if (this.f15988e.booleanValue() && booleanValue) {
                    c.a.p0.s.r.a.f();
                    l<String> g2 = c.a.p0.s.r.a.g("tb.my_bookmarks");
                    if (g2 != null) {
                        publishProgress(g2.get(TbadkCoreApplication.getCurrentAccount()));
                    }
                    if (this.f15989f.f15973d == null) {
                        this.f15989f.f15973d = new ArrayList();
                    } else {
                        this.f15989f.f15973d.clear();
                    }
                    this.f15989f.f15974e = 0;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.MARK_GETSTORE);
                this.f15984a = netWork;
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                if (this.f15989f.f15976g) {
                    this.f15984a.addPostData("offset", String.valueOf(0));
                } else {
                    this.f15984a.addPostData("offset", String.valueOf(this.f15986c));
                }
                this.f15984a.addPostData("rn", String.valueOf(20));
                String postNetData = this.f15984a.postNetData();
                this.f15985b = postNetData;
                this.f15987d.c(postNetData);
                if (this.f15984a.getNetContext().getResponse().isRequestSuccess()) {
                    aVar.u(this.f15985b);
                    if (this.f15986c == 0) {
                        if (this.f15989f.f15973d == null) {
                            this.f15989f.f15973d = new ArrayList();
                        } else {
                            this.f15989f.f15973d.clear();
                        }
                        this.f15989f.f15974e = 0;
                        if (this.f15988e.booleanValue()) {
                            b(this.f15985b);
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
                NetWork netWork = this.f15984a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                this.f15989f.f15970a = null;
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
                c.a.q0.b2.g.c cVar = this.f15987d;
                if (cVar != null) {
                    c.a.p0.s.z.a.a("collection", 0L, 0, "collection_thread_list_result", cVar.a(), this.f15987d.b(), new Object[0]);
                }
                this.f15989f.f15974e = aVar.m();
                ArrayList<MarkData> n = aVar.n();
                if (this.f15988e.booleanValue()) {
                    if (n != null && n.size() != 0) {
                        this.f15989f.B(n);
                    }
                } else {
                    this.f15989f.k(n);
                }
                Iterator<MarkData> it = n.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (it.next().getNewCounts() > 0) {
                        i2++;
                        this.f15989f.C(i2);
                    }
                }
                if (this.f15989f.f15977h != null) {
                    if (this.f15984a.getNetContext().getResponse().isRequestSuccess()) {
                        this.f15989f.f15977h.a(0, this.f15987d.a() != 0 ? this.f15987d.b() : null, Boolean.FALSE);
                    } else {
                        this.f15989f.f15977h.a(3, this.f15984a.getErrorString());
                    }
                }
                this.f15989f.f15976g = false;
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
                    arrayList = this.f15989f.t(str);
                    if (this.f15988e.booleanValue()) {
                        this.f15989f.B(arrayList);
                    } else {
                        this.f15989f.k(arrayList);
                    }
                } else {
                    this.f15989f.B(arrayList);
                }
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                this.f15989f.f15977h.a(0, null, Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        this.f15970a = null;
        this.f15971b = null;
        this.f15972c = null;
        this.f15974e = 0;
        this.f15975f = 0;
        this.f15976g = false;
        this.f15977h = null;
        this.f15973d = new ArrayList<>();
        this.f15976g = true;
    }

    public static /* synthetic */ int i(a aVar) {
        int i2 = aVar.f15975f;
        aVar.f15975f = i2 - 1;
        return i2;
    }

    public void A(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f15977h = dVar;
        }
    }

    public void B(ArrayList<MarkData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
            this.f15973d = arrayList;
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.f15975f = i2;
        }
    }

    public boolean D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            C0758a c0758a = this.f15972c;
            if (c0758a != null) {
                c0758a.cancel();
            }
            if (i2 >= this.f15973d.size() || this.f15973d.get(i2) == null || this.f15973d.get(i2).getId() == null) {
                return false;
            }
            C0758a c0758a2 = new C0758a(this, this.f15973d.get(i2).getId(), i2, this.f15973d.get(i2).getForumId());
            this.f15972c = c0758a2;
            c0758a2.setPriority(2);
            this.f15972c.execute(new Boolean[0]);
            return true;
        }
        return invokeI.booleanValue;
    }

    public String E(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i2, i3)) == null) {
            ArrayList<MarkData> arrayList = this.f15973d;
            if (arrayList == null) {
                return null;
            }
            if (i2 >= arrayList.size()) {
                i3 -= (i2 - this.f15973d.size()) - 1;
                i2 = this.f15973d.size() - 1;
            }
            JSONArray jSONArray = new JSONArray();
            int i4 = 0;
            for (int i5 = i2; i5 >= 0 && i5 > i2 - i3; i5--) {
                try {
                    JSONObject json = this.f15973d.get(i5).toJson();
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
            this.f15973d.add(markData);
        }
    }

    public void k(ArrayList<MarkData> arrayList) {
        ArrayList<MarkData> arrayList2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, arrayList) == null) || (arrayList2 = this.f15973d) == null || arrayList == null) {
            return;
        }
        arrayList2.addAll(arrayList);
        y();
    }

    public final void l(String str, int i2) {
        ArrayList<MarkData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) || (arrayList = this.f15973d) == null || ListUtils.getCount(arrayList) <= 0) {
            return;
        }
        Iterator<MarkData> it = this.f15973d.iterator();
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
            ArrayList<MarkData> arrayList = this.f15973d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f15973d : (ArrayList) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f15975f : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f15974e : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<MarkData> arrayList = this.f15973d;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f15974e > 0 : invokeV.booleanValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            b bVar = this.f15970a;
            if (bVar != null) {
                bVar.cancel();
            }
            c cVar = this.f15971b;
            if (cVar != null) {
                cVar.cancel();
            }
            C0758a c0758a = this.f15972c;
            if (c0758a != null) {
                c0758a.cancel();
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
                        this.f15973d.add(markData);
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
            b bVar = this.f15970a;
            if (bVar != null) {
                bVar.cancel();
            }
            b bVar2 = new b(this, q());
            this.f15970a = bVar2;
            bVar2.setPriority(3);
            this.f15970a.execute(bool, Boolean.valueOf(z));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.f15973d == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<MarkData> it = this.f15973d.iterator();
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
            this.f15975f = 0;
            this.f15974e = 0;
            this.f15976g = true;
        }
    }
}
