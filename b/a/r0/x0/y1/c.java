package b.a.r0.x0.y1;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import b.a.e.e.p.j;
import b.a.e.e.p.l;
import b.a.q0.t.c.m0;
import b.a.r0.x0.h1;
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

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f26801a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f26802b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f26803c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f26804d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f26805e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f26806f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.g0.a f26807g;

    /* renamed from: h  reason: collision with root package name */
    public b f26808h;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f26809i;

    /* loaded from: classes5.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f26810a;

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
            this.f26810a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                this.f26810a.c();
                if (postWriteCallBackData == null) {
                    return;
                }
                if (!z) {
                    this.f26810a.f26804d.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", this.f26810a.f26801a.forumId).param("fname", this.f26810a.f26801a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.f26810a.f26804d.setResult(-1, intent);
                this.f26810a.f26804d.finish();
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
        this.f26803c = null;
        this.f26807g = null;
        this.f26809i = new a(this);
        this.f26804d = baseFragmentActivity;
        this.f26801a = forumWriteData;
        this.f26802b = serializableItemInfo;
        this.f26803c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26807g.h(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26805e = new NewWriteModel();
            this.f26806f = new WriteData();
            this.f26805e.h0(this.f26809i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26807g = new b.a.q0.s.g0.a(this.f26804d);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f26805e.setWriteData(this.f26806f);
            this.f26805e.l0();
            i();
        }
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, forumWriteData) == null) {
            if (!j.z()) {
                l.L(this.f26804d, h1.neterror);
            }
            SerializableItemInfo serializableItemInfo = this.f26802b;
            if (serializableItemInfo != null) {
                this.f26806f.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.f26806f.setForumName(forumWriteData.forumName);
            this.f26806f.setContent(str);
            this.f26806f.setComment_head(str2);
            this.f26806f.setForumId(forumWriteData.forumId);
            this.f26806f.setTitle("");
            this.f26806f.setIsNoTitle(true);
            b bVar = this.f26808h;
            if (bVar != null) {
                bVar.a(this.f26803c);
            }
            f();
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f26808h = bVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f26807g.e(null);
            this.f26807g.i(h1.sending);
            this.f26807g.h(true);
        }
    }
}
