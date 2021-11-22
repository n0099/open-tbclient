package b.a.r0.k2.u.f;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f20522a;

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f20522a = tbPageContext;
    }

    public final void a(PbModel pbModel, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, pbModel, i2) == null) || pbModel == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13719");
        statisticItem.param("fid", pbModel.J.m());
        statisticItem.param("tid", pbModel.J.Q());
        statisticItem.param("obj_type", i2);
        if (pbModel.O0() == 5) {
            statisticItem.param("obj_source", 1);
        } else if (pbModel.O0() == 7) {
            statisticItem.param("obj_source", 2);
        } else {
            statisticItem.param("obj_source", 3);
        }
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }

    public boolean b(PbModel pbModel) {
        InterceptResult invokeL;
        b.a.r0.k2.r.f fVar;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbModel)) == null) {
            int i2 = 0;
            if (this.f20522a.getPageActivity() != null && pbModel != null && (fVar = pbModel.J) != null) {
                if ("3".equals(fVar.g0)) {
                    MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(this.f20522a.getPageActivity()).createNormalCfg(2);
                    createNormalCfg.setSubTabName(this.f20522a.getString(b.a.r0.k2.l.tab_name_topic_rank));
                    this.f20522a.sendMessage(new CustomMessage(2015002, createNormalCfg));
                    return true;
                }
                String p = b.a.q0.s.e0.b.j().p("key_pb_back_sid1", "");
                String p2 = b.a.q0.s.e0.b.j().p("key_pb_back_sid2", "");
                if (TextUtils.isEmpty(p) || b.a.q0.b.c.d().b(p) == null) {
                    str = (TextUtils.isEmpty(p2) || b.a.q0.b.c.d().b(p2) == null) ? null : "2";
                } else {
                    str = "1";
                }
                if (str == null && (str2 = pbModel.J.f0) != null) {
                    str = str2;
                }
                if (str == null) {
                    return false;
                }
                if (str.equals("1")) {
                    MainTabActivityConfig createNormalCfg2 = new MainTabActivityConfig(this.f20522a.getPageActivity()).createNormalCfg(2);
                    createNormalCfg2.setSubTab(1, null);
                    this.f20522a.sendMessage(new CustomMessage(2015002, createNormalCfg2));
                    a(pbModel, 1);
                    return true;
                } else if (str.equals("2")) {
                    MainTabActivityConfig createNormalCfg3 = new MainTabActivityConfig(this.f20522a.getPageActivity()).createNormalCfg(1);
                    createNormalCfg3.setSubTab(0, pbModel.J.g0);
                    this.f20522a.sendMessage(new CustomMessage(2015002, createNormalCfg3));
                    if ("游戏".equals(pbModel.J.g0)) {
                        i2 = 2;
                    } else if ("数码".equals(pbModel.J.g0)) {
                        i2 = 3;
                    }
                    a(pbModel, i2);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
