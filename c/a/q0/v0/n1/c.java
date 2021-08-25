package c.a.q0.v0.n1;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.p0.t.c.k0;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f26674a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f26675b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f26676c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f26677d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f26678e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f26679f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.p0.s.f0.a f26680g;

    /* renamed from: h  reason: collision with root package name */
    public b f26681h;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f26682i;

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f26683a;

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
            this.f26683a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, k0 k0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, k0Var, writeData, antiData}) == null) {
                this.f26683a.c();
                if (postWriteCallBackData == null) {
                    return;
                }
                if (!z) {
                    this.f26683a.f26677d.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", this.f26683a.f26674a.forumId).param("fname", this.f26683a.f26674a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.f26683a.f26677d.setResult(-1, intent);
                this.f26683a.f26677d.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f26676c = null;
        this.f26680g = null;
        this.f26682i = new a(this);
        this.f26677d = baseFragmentActivity;
        this.f26674a = forumWriteData;
        this.f26675b = serializableItemInfo;
        this.f26676c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f26680g.h(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f26678e = new NewWriteModel();
            this.f26679f = new WriteData();
            this.f26678e.h0(this.f26682i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f26680g = new c.a.p0.s.f0.a(this.f26677d);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f26678e.setWriteData(this.f26679f);
            this.f26678e.l0();
            i();
        }
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, forumWriteData) == null) {
            if (!j.z()) {
                l.L(this.f26677d, R.string.neterror);
            }
            SerializableItemInfo serializableItemInfo = this.f26675b;
            if (serializableItemInfo != null) {
                this.f26679f.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.f26679f.setForumName(forumWriteData.forumName);
            this.f26679f.setContent(str);
            this.f26679f.setComment_head(str2);
            this.f26679f.setForumId(forumWriteData.forumId);
            this.f26679f.setTitle("");
            this.f26679f.setIsNoTitle(true);
            b bVar = this.f26681h;
            if (bVar != null) {
                bVar.a(this.f26676c);
            }
            f();
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f26681h = bVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f26680g.e(null);
            this.f26680g.i(R.string.sending);
            this.f26680g.h(true);
        }
    }
}
