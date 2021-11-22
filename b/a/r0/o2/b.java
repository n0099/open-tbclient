package b.a.r0.o2;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.q.b1;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ForumData> f23501a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ForumData> f23502b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumData> f23503c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ForumData> f23504d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ForumData> f23505e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ForumData> f23506f;

    /* renamed from: g  reason: collision with root package name */
    public b1 f23507g;

    /* renamed from: h  reason: collision with root package name */
    public int f23508h;

    /* renamed from: i  reason: collision with root package name */
    public int f23509i;
    public int j;

    public b() {
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
        this.f23509i = 0;
        this.j = 0;
        this.f23501a = new ArrayList<>();
        this.f23502b = new ArrayList<>();
        this.f23503c = new ArrayList<>();
        this.f23504d = new ArrayList<>();
        this.f23506f = new ArrayList<>();
        this.f23505e = new ArrayList<>();
        this.f23507g = new b1();
        s(false);
    }

    public void a(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, arrayList, arrayList2) == null) {
            if (this.f23504d == null) {
                this.f23504d = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f23505e;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f23506f;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.addAll(arrayList2);
            }
            if (this.f23505e == null && this.f23506f == null) {
                return;
            }
            this.f23504d.clear();
            ArrayList<ForumData> arrayList5 = this.f23505e;
            if (arrayList5 != null) {
                this.f23504d.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f23506f;
            if (arrayList6 != null) {
                this.f23504d.addAll(arrayList6);
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.j += i2;
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, arrayList, arrayList2) == null) {
            if (this.f23501a == null) {
                this.f23501a = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f23502b;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f23503c;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.addAll(arrayList2);
            }
            if (this.f23502b == null && this.f23503c == null) {
                return;
            }
            this.f23501a.clear();
            ArrayList<ForumData> arrayList5 = this.f23502b;
            if (arrayList5 != null) {
                this.f23501a.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f23503c;
            if (arrayList6 != null) {
                this.f23501a.addAll(arrayList6);
            }
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f23509i += i2;
        }
    }

    public ArrayList<ForumData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23504d : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23506f : (ArrayList) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.intValue;
    }

    public ArrayList<ForumData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f23505e : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f23501a : (ArrayList) invokeV.objValue;
    }

    public ArrayList<ForumData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f23503c : (ArrayList) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f23509i : invokeV.intValue;
    }

    public ArrayList<ForumData> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f23502b : (ArrayList) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f23508h == 1 : invokeV.booleanValue;
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null) {
            return;
        }
        try {
            o(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void o(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, jSONObject) == null) {
            try {
                this.f23507g.i(jSONObject.optJSONObject("page"));
                this.f23508h = jSONObject.optInt("has_more", 1);
                long optLong = jSONObject.optLong("ctime", 0L);
                if (optLong > 0) {
                    new Date(optLong);
                } else {
                    new Date();
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
                if (optJSONObject == null) {
                    return;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.f23509i = optJSONArray.length();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i2));
                        this.f23502b.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i3));
                        this.f23503c.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 == null) {
                    return;
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                if (optJSONArray3 != null) {
                    this.j = optJSONArray3.length();
                    for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                        ForumData forumData3 = new ForumData();
                        forumData3.parserJson(optJSONArray3.getJSONObject(i4));
                        this.f23505e.add(forumData3);
                    }
                }
                JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                if (optJSONArray4 != null) {
                    for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                        ForumData forumData4 = new ForumData();
                        forumData4.parserJson(optJSONArray4.getJSONObject(i5));
                        this.f23506f.add(forumData4);
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void p(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, arrayList, arrayList2) == null) {
            if (this.f23504d == null) {
                this.f23504d = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f23505e;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.clear();
                this.f23505e.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f23506f;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.clear();
                this.f23506f.addAll(arrayList2);
            }
            if (this.f23505e == null && this.f23506f == null) {
                return;
            }
            this.f23504d.clear();
            ArrayList<ForumData> arrayList5 = this.f23505e;
            if (arrayList5 != null) {
                this.f23504d.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f23506f;
            if (arrayList6 != null) {
                this.f23504d.addAll(arrayList6);
            }
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.j = i2;
        }
    }

    public void r(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, arrayList, arrayList2) == null) {
            if (this.f23501a == null) {
                this.f23501a = new ArrayList<>();
            }
            ArrayList<ForumData> arrayList3 = this.f23502b;
            if (arrayList3 != null && arrayList != null) {
                arrayList3.clear();
                this.f23502b.addAll(arrayList);
            }
            ArrayList<ForumData> arrayList4 = this.f23503c;
            if (arrayList4 != null && arrayList2 != null) {
                arrayList4.clear();
                this.f23503c.addAll(arrayList2);
            }
            if (this.f23502b == null && this.f23503c == null) {
                return;
            }
            this.f23501a.clear();
            ArrayList<ForumData> arrayList5 = this.f23502b;
            if (arrayList5 != null) {
                this.f23501a.addAll(arrayList5);
            }
            ArrayList<ForumData> arrayList6 = this.f23503c;
            if (arrayList6 != null) {
                this.f23501a.addAll(arrayList6);
            }
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f23508h = z ? 1 : 0;
        }
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f23509i = i2;
        }
    }
}
