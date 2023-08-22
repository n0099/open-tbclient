package com.baidu.tbadk.core.dialog.yun;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.log.YunDialogLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.data.DialogStrategiesData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.bx5;
import com.baidu.tieba.fx5;
import com.baidu.tieba.gw5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.ne;
import com.baidu.tieba.r45;
import com.baidu.tieba.z65;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YunDialogDataManager {
    public static /* synthetic */ Interceptable $ic;
    public static final List<DialogStrategiesData> d;
    public static volatile YunDialogDataManager e;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Map<String, List<DialogStrategiesData>> a;
    public int b;
    public final Set<String> c;

    /* loaded from: classes4.dex */
    public interface d {
        void a(List<DialogStrategiesData> list);
    }

    /* loaded from: classes4.dex */
    public static class ConfigData extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("queue_max_size")
        public int maxSize;

        public ConfigData() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int getMaxSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.maxSize;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ YunDialogDataManager b;

        public a(YunDialogDataManager yunDialogDataManager, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yunDialogDataManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yunDialogDataManager;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.q(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends bx5<List<DialogStrategiesData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YunDialogDataManager a;

        public b(YunDialogDataManager yunDialogDataManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yunDialogDataManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yunDialogDataManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bx5
        public List<DialogStrategiesData> doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.n();
            }
            return (List) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements gw5<List<DialogStrategiesData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;
        public final /* synthetic */ YunDialogDataManager c;

        public c(YunDialogDataManager yunDialogDataManager, d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yunDialogDataManager, dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yunDialogDataManager;
            this.a = dVar;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gw5
        /* renamed from: a */
        public void onReturnDataInUI(List<DialogStrategiesData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                this.c.q(list);
                if (this.a != null) {
                    List<DialogStrategiesData> list2 = (List) this.c.a.get(this.b);
                    d dVar = this.a;
                    if (ListUtils.isEmpty(list2)) {
                        list2 = YunDialogDataManager.d;
                    }
                    dVar.a(list2);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(794660859, "Lcom/baidu/tbadk/core/dialog/yun/YunDialogDataManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(794660859, "Lcom/baidu/tbadk/core/dialog/yun/YunDialogDataManager;");
                return;
            }
        }
        d = Collections.emptyList();
    }

    public YunDialogDataManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 2;
        this.c = new LinkedHashSet();
    }

    public static YunDialogDataManager j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (e == null) {
                synchronized (YunDialogDataManager.class) {
                    if (e == null) {
                        e = new YunDialogDataManager();
                    }
                }
            }
            return e;
        }
        return (YunDialogDataManager) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return "key_yun_dialog_strategies@" + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public void f(@NonNull String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, dVar) == null) {
            e(h(str), dVar);
        }
    }

    public void g(@NonNull String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, dVar) == null) {
            e(i(str), dVar);
        }
    }

    public final String h(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return "dialog_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final String i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return "time_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final void e(@NonNull String str, @Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            if (this.a == null) {
                this.a = new LinkedHashMap();
            }
            List<DialogStrategiesData> list = this.a.get(str);
            if (list == null && this.a.isEmpty()) {
                fx5.b(new b(this), new c(this, dVar, str));
            } else if (dVar != null) {
                if (ListUtils.isEmpty(list)) {
                    list = d;
                }
                dVar.a(list);
            }
        }
    }

    public final void m(Map<String, List<DialogStrategiesData>> map, List<DialogStrategiesData> list, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, map, list, str) != null) || map == null) {
            return;
        }
        for (DialogStrategiesData dialogStrategiesData : list) {
            if (map.containsKey(i(str))) {
                if (dialogStrategiesData.getDialogTime().contains(str)) {
                    map.get(i(str)).add(dialogStrategiesData);
                }
            } else if (dialogStrategiesData.getDialogTime().contains(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(dialogStrategiesData);
                map.put(i(str), arrayList);
            }
        }
    }

    public final List<DialogStrategiesData> n() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ne<String> n = r45.n("tb.dialog_strategies_data", TbadkCoreApplication.getCurrentAccount(), k());
            if (n != null) {
                str = n.get(k());
            } else {
                str = null;
            }
            if (StringUtils.isNull(str)) {
                return d;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                TbLog yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.i(YunDialogManager.LOG_KEY, "加载本地云弹窗配置: " + jSONArray);
                return DataExt.toEntityList(jSONArray.toString(), DialogStrategiesData.class);
            } catch (Exception e2) {
                BdLog.e(e2);
                return d;
            }
        }
        return (List) invokeV.objValue;
    }

    public void o(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONArray) == null) {
            TbLog yunDialogLog = YunDialogLog.getInstance();
            yunDialogLog.i(YunDialogManager.LOG_KEY, "sync更新本地云弹窗配置，配置为：" + jSONArray);
            ne<String> n = r45.n("tb.dialog_strategies_data", TbadkCoreApplication.getCurrentAccount(), k());
            if (n == null) {
                YunDialogLog.getInstance().i(YunDialogManager.LOG_KEY, "读取数据库失败，写入云弹窗配置失败！");
            } else if (jSONArray != null && jSONArray.length() > 0) {
                z65.a.a(jSONArray.toString());
                try {
                    q(DataExt.toEntityList(jSONArray.toString(), DialogStrategiesData.class));
                } catch (Exception e2) {
                    TbLog yunDialogLog2 = YunDialogLog.getInstance();
                    yunDialogLog2.i(YunDialogManager.LOG_KEY, "云弹窗配置解析失败，更新失败！下发配置：" + jSONArray);
                    BdLog.e(e2);
                }
            } else {
                YunDialogLog.getInstance().i(YunDialogManager.LOG_KEY, "sync下发配置为空，清理本地云弹窗配置");
                n.remove(k());
                q(Collections.emptyList());
            }
        }
    }

    public final void q(List<DialogStrategiesData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            if (!BdUtilHelper.isMainThread()) {
                SafeHandler.getInst().postAtFrontOfQueue(new a(this, list));
                return;
            }
            try {
                if (!ListUtils.isEmpty(list)) {
                    if (this.a == null) {
                        this.a = new LinkedHashMap();
                    }
                    this.a.clear();
                    for (DialogStrategiesData dialogStrategiesData : list) {
                        List<String> dialogTime = dialogStrategiesData.getDialogTime();
                        if (!ListUtils.isEmpty(dialogTime)) {
                            this.c.addAll(dialogTime);
                        }
                        this.a.put(h(dialogStrategiesData.getDialogName()), Collections.singletonList(dialogStrategiesData));
                    }
                    for (String str : this.c) {
                        m(this.a, list, str);
                    }
                    return;
                }
                if (this.a != null) {
                    this.a.clear();
                }
                this.c.clear();
            } catch (Exception e2) {
                YunDialogLog.getInstance().i(YunDialogManager.LOG_KEY, "更新本地云弹窗配置失败！");
                BdLog.e(e2);
            }
        }
    }

    public void p(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jSONObject) == null) {
            try {
                TbLog yunDialogLog = YunDialogLog.getInstance();
                yunDialogLog.i(YunDialogManager.LOG_KEY, "updateManagerConfig:" + jSONObject);
                this.b = ((ConfigData) DataExt.toEntity(jSONObject.toString(), ConfigData.class)).getMaxSize();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }
}
