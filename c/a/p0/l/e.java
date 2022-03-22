package c.a.p0.l;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.r.r.v0;
import c.a.p0.l.g;
import c.a.p0.l.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.DeleteThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f16001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f16002c;

        public a(TbPageContext tbPageContext, h hVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.f16001b = hVar;
            this.f16002c = z;
        }

        @Override // c.a.p0.l.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (l.A()) {
                    e.e(jSONArray, this.f16001b.a(), this.f16001b.b(), this.f16002c);
                } else {
                    n.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c15);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements g.InterfaceC1200g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f16003b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f16004c;

        public b(TbPageContext tbPageContext, h hVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.f16003b = hVar;
            this.f16004c = z;
        }

        @Override // c.a.p0.l.g.InterfaceC1200g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (l.A()) {
                    e.e(jSONArray, this.f16003b.a(), this.f16003b.b(), this.f16004c);
                } else {
                    n.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f0c15);
                }
            }
        }
    }

    public static void b(TbPageContext tbPageContext, h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, tbPageContext, hVar) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = hVar.getType() == 3;
        g gVar = new g(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView());
        if (hVar != null) {
            gVar.w(z);
        }
        AntiData c2 = c.a.p0.f1.b.f().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i = 0; i < delThreadInfoList.size(); i++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<ThreadData> g2 = c.a.p0.f1.b.f().g();
        for (int i2 = 0; i2 < g2.size(); i2++) {
            if (g2.get(i2) != null) {
                jSONArray.put(g2.get(i2).getTid());
                if (z) {
                    jSONArray2.put("1");
                } else if (!g2.get(i2).isScoreThread() && !g2.get(i2).isWorksInfo()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        if (hVar != null) {
            v0Var.i(hVar.getType());
        }
        v0Var.p(jSONArray);
        v0Var.m(jSONArray2);
        v0Var.l(c.a.p0.f1.b.f().d());
        gVar.x(v0Var);
        gVar.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a2), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a3), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a4), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a5), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a6)});
        gVar.A("1");
        gVar.z(new b(tbPageContext, hVar, z));
    }

    public static void c(TbPageContext tbPageContext, h hVar, i iVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65538, null, tbPageContext, hVar, iVar, userData) == null) || tbPageContext == null || tbPageContext.getPageActivity() == null || tbPageContext.getPageActivity().getWindow() == null) {
            return;
        }
        boolean z = hVar.getType() == 3;
        j jVar = new j(tbPageContext, tbPageContext.getPageActivity().getWindow().getDecorView(), iVar, userData);
        if (hVar != null) {
            jVar.C(z);
        }
        AntiData c2 = c.a.p0.f1.b.f().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i = 0; i < delThreadInfoList.size(); i++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<ThreadData> g2 = c.a.p0.f1.b.f().g();
        for (int i2 = 0; i2 < g2.size(); i2++) {
            if (g2.get(i2) != null) {
                jSONArray.put(g2.get(i2).getTid());
                if (z) {
                    jSONArray2.put("1");
                } else if (!g2.get(i2).isScoreThread() && !g2.get(i2).isWorksInfo()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        if (hVar != null) {
            v0Var.i(hVar.getType());
        }
        v0Var.p(jSONArray);
        v0Var.m(jSONArray2);
        v0Var.l(c.a.p0.f1.b.f().d());
        jVar.D(v0Var);
        jVar.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049d), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049e), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f049f), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a0), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04a1)});
        jVar.G("1");
        jVar.F(new a(tbPageContext, hVar, z));
    }

    public static void d(int i, TbPageContext tbPageContext, h hVar, i iVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), tbPageContext, hVar, iVar, userData}) == null) {
            if (1 == i) {
                c(tbPageContext, hVar, iVar, userData);
            } else {
                b(tbPageContext, hVar);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, forumManageModel, threadData, Boolean.valueOf(z)}) == null) || forumManageModel == null || threadData == null || threadData.getAuthor() == null) {
            return;
        }
        String userId = threadData.getAuthor().getUserId();
        String id = threadData.getId();
        String forum_name = threadData.getForum_name();
        String valueOf = String.valueOf(threadData.getFid());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            forumManageModel.T(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.U(valueOf, forum_name, id, null, 0, 1, isCurrentAccount, threadData.getBaijiahaoData(), z);
    }
}
