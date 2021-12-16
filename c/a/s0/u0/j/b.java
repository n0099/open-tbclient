package c.a.s0.u0.j;

import c.a.d.f.p.k;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.HttpsConnSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                if (TbadkCoreApplication.getInst().checkInterrupt()) {
                    return null;
                }
                NetWork netWork = new NetWork("http://tiebac.baidu.com/empty.gif");
                netWork.getNetData();
                boolean isNetSuccess = netWork.isNetSuccess();
                NetWork netWork2 = new NetWork("https://tiebac.baidu.com/empty.gif");
                netWork2.getNetData();
                boolean isNetSuccess2 = netWork2.isNetSuccess();
                NetWork netWork3 = new NetWork("http://c.tieba.baidu.com/c/s/recordHttpsConnectivity");
                netWork3.addPostData("is_success_http", String.valueOf(isNetSuccess ? 1 : 0));
                netWork3.addPostData("is_success_https", String.valueOf(isNetSuccess2 ? 1 : 0));
                netWork3.postNetData();
                TiebaStatic.log(new StatisticItem("c13734").param("obj_locate", 1).param("obj_type", isNetSuccess ? 1 : 0));
                TiebaStatic.log(new StatisticItem("c13734").param("obj_locate", 2).param("obj_type", isNetSuccess2 ? 1 : 0));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            a aVar = new a();
            aVar.setPriority(1);
            aVar.execute(new Void[0]);
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? k.z() && SwitchManager.getInstance().findType(HttpsConnSwitch.KEY) == 1 : invokeV.booleanValue;
    }
}
