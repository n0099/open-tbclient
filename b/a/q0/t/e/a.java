package b.a.q0.t.e;

import android.app.Activity;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f13934a;

    /* renamed from: b  reason: collision with root package name */
    public b f13935b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.e.a.e f13936c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13937d;

    /* renamed from: b.a.q0.t.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C0699a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f13938a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f13939b;

        /* renamed from: c  reason: collision with root package name */
        public String f13940c;

        /* renamed from: d  reason: collision with root package name */
        public String f13941d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f13942e;

        /* renamed from: f  reason: collision with root package name */
        public String f13943f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f13944g;

        /* renamed from: h  reason: collision with root package name */
        public String f13945h;

        /* renamed from: i  reason: collision with root package name */
        public String f13946i;
        public boolean j;
        public String k;
        public final /* synthetic */ a l;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = aVar;
            this.f13938a = null;
            this.f13942e = false;
            this.f13943f = "0";
            this.f13945h = "0";
            this.f13946i = null;
            this.j = false;
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f13939b = z;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f13946i = str;
                if (str != null) {
                    this.j = true;
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f13938a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f13938a = null;
                }
                if (this.l.f13935b != null) {
                    this.l.f13935b.cancel();
                    this.l.f13935b = null;
                }
                if (this.l.f13936c != null) {
                    this.l.f13936c.c(Boolean.FALSE);
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f13943f = str;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.f13945h = str;
            }
        }

        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.f13942e = z;
            }
        }

        public void g(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
                this.f13944g = bdUniqueId;
            }
        }

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.f13940c = str;
            }
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.f13941d = str;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, numArr)) == null) {
                try {
                    if (this.f13940c != null) {
                        NetWork netWork = new NetWork();
                        this.f13938a = netWork;
                        if (this.f13939b) {
                            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                            this.f13938a.setNeedSig(true);
                        } else {
                            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                        }
                        this.f13938a.addPostData("portrait", this.f13940c);
                        if (!StringUtils.isNull(this.f13943f)) {
                            this.f13938a.addPostData("from_type", this.f13943f);
                        }
                        if (!StringUtils.isNull(this.f13946i)) {
                            this.f13938a.addPostData("forum_id", this.f13946i);
                        }
                        this.f13938a.addPostData("in_live", this.f13945h);
                        this.f13938a.addPostData("authsid", this.k);
                        this.f13938a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.f13938a.postNetData();
                        AuthTokenData.parse(postNetData);
                        return postNetData;
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                super.onPostExecute((b) str);
                this.l.f13935b = null;
                if (this.f13938a != null) {
                    UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                    aVar.f45667a = this.f13938a.getNetContext().getResponse().isRequestSuccess();
                    aVar.f45668b = this.f13938a.getErrorString();
                    aVar.f45670d = this.f13939b;
                    aVar.f45669c = this.f13941d;
                    aVar.f45672f = this.f13942e;
                    aVar.j = this.l.f13937d;
                    aVar.b(str, this.j);
                    if (this.f13938a.getNetContext().getResponse().isRequestSuccess()) {
                        aVar.l = null;
                    }
                    int serverErrorCode = this.f13938a.getServerErrorCode();
                    if (AntiHelper.a(this.l.getContext(), serverErrorCode, aVar.k) || b.a.r0.v3.a.a(this.l.getContext(), serverErrorCode, this.f13938a.getErrorString())) {
                        return;
                    }
                    UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                    updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f13944g));
                    MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                    if (this.f13939b && serverErrorCode == 0) {
                        a aVar2 = this.l;
                        boolean[] h2 = aVar2.h(aVar2.f13934a);
                        if (h2 != null) {
                            if (h2[0] || h2[1]) {
                                b.a.q0.t.h.a.f(this.l.f13934a, h2, 1);
                            }
                        }
                    }
                }
            }
        }

        public /* synthetic */ b(a aVar, C0699a c0699a) {
            this(aVar);
        }
    }

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
        this.f13934a = tbPageContext;
    }

    public void g() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f13935b) == null) {
            return;
        }
        bVar.cancel();
    }

    public Activity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            TbPageContext tbPageContext = this.f13934a;
            if (tbPageContext != null) {
                return tbPageContext.getPageActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            boolean[] zArr = null;
            String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
            if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && b.a.q0.s.e0.b.j().g("first_call_attention", true)) {
                b.a.q0.s.e0.b.j().t("first_call_attention", false);
                zArr = new boolean[]{!NotificationManagerCompat.from(this.f13934a.getPageActivity()).areNotificationsEnabled(), !b.a.q0.t.d.d.d().s()};
                if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f13937d) {
                    tbPageContext.showToast(R.string.attention_success);
                }
            } else if (tbPageContext != null && !this.f13937d) {
                tbPageContext.showToast(R.string.attention_success);
            }
            return zArr;
        }
        return (boolean[]) invokeL.objValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f13937d = z;
        }
    }

    public void j(b.a.e.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f13936c = eVar;
        }
    }

    public void k(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, str2, bdUniqueId}) == null) {
            l(z, str, str2, false, "0", bdUniqueId, null, "0");
        }
    }

    public void l(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, bdUniqueId, str4, str5}) == null) && this.f13935b == null) {
            b bVar = new b(this, null);
            this.f13935b = bVar;
            bVar.setPriority(2);
            this.f13935b.b(z);
            this.f13935b.h(str);
            this.f13935b.i(str2);
            this.f13935b.f(z2);
            this.f13935b.d(str3);
            this.f13935b.g(bdUniqueId);
            this.f13935b.c(str4);
            this.f13935b.e(str5);
            this.f13935b.execute(new Integer[0]);
        }
    }
}
