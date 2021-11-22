package b.a.r0.x0.z1;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import b.a.e.f.p.j;
import b.a.e.f.p.l;
import b.a.q0.t.c.m0;
import b.a.r0.x0.i1;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final ForumWriteData f28396a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f28397b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f28398c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f28399d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f28400e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f28401f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.g0.a f28402g;

    /* renamed from: h  reason: collision with root package name */
    public b f28403h;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f28404i;

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f28405a;

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
            this.f28405a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, m0 m0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                this.f28405a.c();
                if (postWriteCallBackData == null) {
                    return;
                }
                if (!z) {
                    this.f28405a.f28399d.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", this.f28405a.f28396a.forumId).param("fname", this.f28405a.f28396a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.f28405a.f28399d.setResult(-1, intent);
                this.f28405a.f28399d.finish();
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.f28398c = null;
        this.f28402g = null;
        this.f28404i = new a(this);
        this.f28399d = baseFragmentActivity;
        this.f28396a = forumWriteData;
        this.f28397b = serializableItemInfo;
        this.f28398c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f28402g.h(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f28400e = new NewWriteModel();
            this.f28401f = new WriteData();
            this.f28400e.h0(this.f28404i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f28402g = new b.a.q0.s.g0.a(this.f28399d);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f28400e.setWriteData(this.f28401f);
            this.f28400e.l0();
            i();
        }
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, forumWriteData) == null) {
            if (!j.z()) {
                l.L(this.f28399d, i1.neterror);
            }
            SerializableItemInfo serializableItemInfo = this.f28397b;
            if (serializableItemInfo != null) {
                this.f28401f.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.f28401f.setForumName(forumWriteData.forumName);
            this.f28401f.setContent(str);
            this.f28401f.setComment_head(str2);
            this.f28401f.setForumId(forumWriteData.forumId);
            this.f28401f.setTitle("");
            this.f28401f.setIsNoTitle(true);
            b bVar = this.f28403h;
            if (bVar != null) {
                bVar.a(this.f28398c);
            }
            f();
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f28403h = bVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f28402g.e(null);
            this.f28402g.i(i1.sending);
            this.f28402g.h(true);
        }
    }
}
