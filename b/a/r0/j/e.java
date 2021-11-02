package b.a.r0.j;

import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.j.g;
import b.a.r0.j.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
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
import tbclient.DeleteThreadInfo;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f18240a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f18241b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f18242c;

        public a(TbPageContext tbPageContext, h hVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18240a = tbPageContext;
            this.f18241b = hVar;
            this.f18242c = z;
        }

        @Override // b.a.r0.j.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (b.a.e.e.p.j.A()) {
                    e.e(jSONArray, this.f18241b.a(), this.f18241b.b(), this.f18242c);
                } else {
                    l.L(this.f18240a.getContext(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements g.InterfaceC0930g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f18243a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f18244b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f18245c;

        public b(TbPageContext tbPageContext, h hVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, hVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18243a = tbPageContext;
            this.f18244b = hVar;
            this.f18245c = z;
        }

        @Override // b.a.r0.j.g.InterfaceC0930g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                if (b.a.e.e.p.j.A()) {
                    e.e(jSONArray, this.f18244b.a(), this.f18244b.b(), this.f18245c);
                } else {
                    l.L(this.f18243a.getContext(), R.string.neterror);
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
        AntiData c2 = b.a.r0.x0.b.f().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<d2> g2 = b.a.r0.x0.b.f().g();
        for (int i3 = 0; i3 < g2.size(); i3++) {
            if (g2.get(i3) != null) {
                jSONArray.put(g2.get(i3).s1());
                if (z) {
                    jSONArray2.put("1");
                } else if (!g2.get(i3).s2() && !g2.get(i3).I2()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.j(sparseArray);
        if (hVar != null) {
            x0Var.i(hVar.getType());
        }
        x0Var.p(jSONArray);
        x0Var.m(jSONArray2);
        x0Var.l(b.a.r0.x0.b.f().d());
        gVar.x(x0Var);
        gVar.y(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_reason_5)});
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
        AntiData c2 = b.a.r0.x0.b.f().c();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (c2 != null && c2.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = c2.getDelThreadInfoList();
            for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                }
            }
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        List<d2> g2 = b.a.r0.x0.b.f().g();
        for (int i3 = 0; i3 < g2.size(); i3++) {
            if (g2.get(i3) != null) {
                jSONArray.put(g2.get(i3).s1());
                if (z) {
                    jSONArray2.put("1");
                } else if (!g2.get(i3).s2() && !g2.get(i3).I2()) {
                    jSONArray2.put("0");
                } else {
                    jSONArray2.put("1");
                }
            }
        }
        x0 x0Var = new x0();
        x0Var.j(sparseArray);
        if (hVar != null) {
            x0Var.i(hVar.getType());
        }
        x0Var.p(jSONArray);
        x0Var.m(jSONArray2);
        x0Var.l(b.a.r0.x0.b.f().d());
        jVar.D(x0Var);
        jVar.E(new String[]{TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_1), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_2), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_3), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_4), TbadkCoreApplication.getInst().getString(R.string.delete_thread_new_reason_5)});
        jVar.G("1");
        jVar.F(new a(tbPageContext, hVar, z));
    }

    public static void d(int i2, TbPageContext tbPageContext, h hVar, i iVar, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), tbPageContext, hVar, iVar, userData}) == null) {
            if (1 == i2) {
                c(tbPageContext, hVar, iVar, userData);
            } else {
                b(tbPageContext, hVar);
            }
        }
    }

    public static void e(JSONArray jSONArray, ForumManageModel forumManageModel, d2 d2Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{jSONArray, forumManageModel, d2Var, Boolean.valueOf(z)}) == null) || forumManageModel == null || d2Var == null || d2Var.J() == null) {
            return;
        }
        String userId = d2Var.J().getUserId();
        String f0 = d2Var.f0();
        String Z = d2Var.Z();
        String valueOf = String.valueOf(d2Var.T());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            forumManageModel.R(StringHelper.JsonArrayToString(jSONArray));
        }
        forumManageModel.S(valueOf, Z, f0, null, 0, 1, isCurrentAccount, d2Var.L(), z);
    }
}
