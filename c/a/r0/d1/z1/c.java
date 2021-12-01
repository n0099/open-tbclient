package c.a.r0.d1.z1;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.q0.t.c.m0;
import c.a.r0.d1.i1;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ForumWriteData a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f16433b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f16434c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f16435d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f16436e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f16437f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.g0.a f16438g;

    /* renamed from: h  reason: collision with root package name */
    public b f16439h;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f16440i;

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                this.a.c();
                if (postWriteCallBackData == null) {
                    return;
                }
                if (!z) {
                    this.a.f16435d.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", this.a.a.forumId).param("fname", this.a.a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.a.f16435d.setResult(-1, intent);
                this.a.f16435d.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16434c = null;
        this.f16438g = null;
        this.f16440i = new a(this);
        this.f16435d = baseFragmentActivity;
        this.a = forumWriteData;
        this.f16433b = serializableItemInfo;
        this.f16434c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16438g.h(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f16436e = new NewWriteModel();
            this.f16437f = new WriteData();
            this.f16436e.j0(this.f16440i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f16438g = new c.a.q0.s.g0.a(this.f16435d);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f16436e.setWriteData(this.f16437f);
            this.f16436e.n0();
            i();
        }
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, forumWriteData) == null) {
            if (!j.z()) {
                l.L(this.f16435d, i1.neterror);
            }
            SerializableItemInfo serializableItemInfo = this.f16433b;
            if (serializableItemInfo != null) {
                this.f16437f.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.f16437f.setForumName(forumWriteData.forumName);
            this.f16437f.setContent(str);
            this.f16437f.setComment_head(str2);
            this.f16437f.setForumId(forumWriteData.forumId);
            this.f16437f.setTitle("");
            this.f16437f.setIsNoTitle(true);
            b bVar = this.f16439h;
            if (bVar != null) {
                bVar.a(this.f16434c);
            }
            f();
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f16439h = bVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f16438g.e(null);
            this.f16438g.i(i1.sending);
            this.f16438g.h(true);
        }
    }
}
