package c.a.r0.x0.o1;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.t.c.l0;
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
    public final ForumWriteData f27539a;

    /* renamed from: b  reason: collision with root package name */
    public final SerializableItemInfo f27540b;

    /* renamed from: c  reason: collision with root package name */
    public InputMethodManager f27541c;

    /* renamed from: d  reason: collision with root package name */
    public final BaseFragmentActivity f27542d;

    /* renamed from: e  reason: collision with root package name */
    public NewWriteModel f27543e;

    /* renamed from: f  reason: collision with root package name */
    public WriteData f27544f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.s.f0.a f27545g;

    /* renamed from: h  reason: collision with root package name */
    public b f27546h;

    /* renamed from: i  reason: collision with root package name */
    public final NewWriteModel.g f27547i;

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f27548a;

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
            this.f27548a = cVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, l0 l0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                this.f27548a.c();
                if (postWriteCallBackData == null) {
                    return;
                }
                if (!z) {
                    this.f27548a.f27542d.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new StatisticItem("c13723").param("tid", postWriteCallBackData.getThreadId()).param("fid", this.f27548a.f27539a.forumId).param("fname", this.f27548a.f27539a.forumName).param("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                this.f27548a.f27542d.setResult(-1, intent);
                this.f27548a.f27542d.finish();
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
        this.f27541c = null;
        this.f27545g = null;
        this.f27547i = new a(this);
        this.f27542d = baseFragmentActivity;
        this.f27539a = forumWriteData;
        this.f27540b = serializableItemInfo;
        this.f27541c = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        e();
        d();
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f27545g.h(false);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f27543e = new NewWriteModel();
            this.f27544f = new WriteData();
            this.f27543e.h0(this.f27547i);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f27545g = new c.a.q0.s.f0.a(this.f27542d);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f27543e.setWriteData(this.f27544f);
            this.f27543e.l0();
            i();
        }
    }

    public void g(String str, String str2, ForumWriteData forumWriteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, forumWriteData) == null) {
            if (!j.z()) {
                l.L(this.f27542d, R.string.neterror);
            }
            SerializableItemInfo serializableItemInfo = this.f27540b;
            if (serializableItemInfo != null) {
                this.f27544f.setItem_id(String.valueOf(serializableItemInfo.id));
            }
            this.f27544f.setForumName(forumWriteData.forumName);
            this.f27544f.setContent(str);
            this.f27544f.setComment_head(str2);
            this.f27544f.setForumId(forumWriteData.forumId);
            this.f27544f.setTitle("");
            this.f27544f.setIsNoTitle(true);
            b bVar = this.f27546h;
            if (bVar != null) {
                bVar.a(this.f27541c);
            }
            f();
        }
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f27546h = bVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f27545g.e(null);
            this.f27545g.i(R.string.sending);
            this.f27545g.h(true);
        }
    }
}
