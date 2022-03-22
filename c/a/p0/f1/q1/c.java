package c.a.p0.f1.q1;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.o0.s.c.l0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ForumWriteData a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f14425b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f14426c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f14427d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f14428e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f14429f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.o0.r.l0.a f14430g;

    /* renamed from: h  reason: collision with root package name */
    public b f14431h;
    public final NewWriteModel.g i;

    /* loaded from: classes2.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                this.a.c();
                if (postWriteCallBackData == null) {
                    return;
                }
                if (!z) {
                    this.a.f14427d.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", this.a.a.forumId).param("fname", this.a.a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.a.f14427d.setResult(-1, intent);
                this.a.f14427d.finish();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId, forumWriteData, serializableItemInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14426c = null;
        this.f14430g = null;
        this.i = new a(this);
        this.f14427d = baseFragmentActivity;
        this.a = forumWriteData;
        this.f14425b = serializableItemInfo;
        this.f14426c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f14430g.h(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14428e = new NewWriteModel();
            this.f14429f = new WriteData();
            this.f14428e.n0(this.i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14430g = new c.a.o0.r.l0.a(this.f14427d);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f14428e.setWriteData(this.f14429f);
            this.f14428e.r0();
            i();
        }
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, forumWriteData) == null) {
            if (!l.z()) {
                n.M(this.f14427d, R.string.obfuscated_res_0x7f0f0c15);
            }
            SerializableItemInfo serializableItemInfo = this.f14425b;
            if (serializableItemInfo != null) {
                this.f14429f.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.f14429f.setForumName(forumWriteData.forumName);
            this.f14429f.setContent(str);
            this.f14429f.setComment_head(str2);
            this.f14429f.setForumId(forumWriteData.forumId);
            this.f14429f.setTitle("");
            this.f14429f.setIsNoTitle(true);
            b bVar = this.f14431h;
            if (bVar != null) {
                bVar.a(this.f14426c);
            }
            f();
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f14431h = bVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f14430g.e(null);
            this.f14430g.i(R.string.obfuscated_res_0x7f0f10e8);
            this.f14430g.h(true);
        }
    }
}
