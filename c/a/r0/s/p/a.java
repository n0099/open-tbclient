package c.a.r0.s.p;

import android.text.format.DateUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.k;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static a f13197b;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<c.a.r0.a.d0.a> a;

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
        this.a = new ArrayList<>();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f13197b == null) {
                synchronized (a.class) {
                    if (f13197b == null) {
                        f13197b = new a();
                    }
                }
            }
            return f13197b;
        }
        return (a) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).edit().clear();
        }
    }

    public int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).getInt(str, 0) : invokeL.intValue;
    }

    public long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).getLong(str, 0L) : invokeL.longValue;
    }

    public final ArrayList<c.a.r0.a.d0.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public void f(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jSONArray) == null) || jSONArray == null) {
            return;
        }
        h(jSONArray);
    }

    public boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).contains(str) : invokeL.booleanValue;
    }

    public final void h(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jSONArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount) || jSONArray == null) {
                return;
            }
            this.a.clear();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = null;
                try {
                    jSONObject = jSONArray.getJSONObject(i2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (jSONObject != null) {
                    c.a.r0.a.d0.a aVar = new c.a.r0.a.d0.a();
                    aVar.a = jSONObject.optInt("active_id");
                    aVar.f11914b = jSONObject.optInt("mission_id");
                    aVar.f11915c = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE);
                    long d2 = d("business_update_time" + currentAccount + aVar.a);
                    if (g("business_count_hint" + currentAccount + aVar.a) && DateUtils.isToday(d2)) {
                        aVar.s = c("business_count_hint" + currentAccount + aVar.a);
                    } else {
                        aVar.s = jSONObject.optInt("show_num");
                        a();
                        i("business_count_hint" + currentAccount + aVar.a, aVar.s);
                        j("business_update_time" + currentAccount + aVar.a, System.currentTimeMillis());
                    }
                    aVar.t = jSONObject.optInt("show_time_begin");
                    aVar.u = jSONObject.optInt("show_time_end");
                    JSONArray optJSONArray = jSONObject.optJSONArray("forumIds");
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        try {
                            aVar.w.add((String) optJSONArray.get(i3));
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("show_page");
                    for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        try {
                            aVar.v.add((String) optJSONArray2.get(i4));
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    }
                    this.a.add(aVar);
                }
            }
        }
    }

    public void i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) {
            EditorHelper.putInt(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, i2);
        }
    }

    public void j(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, j2) == null) {
            EditorHelper.putLong(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, j2);
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
            completeTaskReqMsg.completeId = str;
            MessageManager.getInstance().sendMessage(completeTaskReqMsg);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:33|(5:35|(4:38|(2:40|41)(1:43)|42|36)|44|45|(2:56|52))(1:57)|47|48|49|50|51|52) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00eb, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(String str, String str2) {
        ArrayList<c.a.r0.a.d0.a> e2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) && (e2 = e()) != null && k.z()) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            while (i2 < e2.size()) {
                int i3 = e2.get(i2).a;
                int i4 = e2.get(i2).f11914b;
                int i5 = e2.get(i2).f11915c;
                int c2 = c("business_count_hint" + currentAccount + i3);
                long j2 = e2.get(i2).t;
                long j3 = e2.get(i2).u;
                ArrayList<String> arrayList = e2.get(i2).v;
                ArrayList<String> arrayList2 = e2.get(i2).w;
                if (c2 != 0 && System.currentTimeMillis() / 1000 > j2 && System.currentTimeMillis() / 1000 < j3) {
                    boolean z = false;
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        if (arrayList.get(i6).equals(str)) {
                            z = true;
                        }
                    }
                    if (z) {
                        if (str.equals("2")) {
                            boolean z2 = false;
                            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                                if (arrayList2.get(i7).equals(str2)) {
                                    z2 = true;
                                }
                            }
                            i2 = z2 ? 0 : i2 + 1;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(i3), String.valueOf(i4));
                        k(jSONObject.toString());
                    }
                }
            }
        }
    }
}
