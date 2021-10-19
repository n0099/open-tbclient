package c.a.q0.t.e;

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
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f14844a;

    /* renamed from: b  reason: collision with root package name */
    public b f14845b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.a.e f14846c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14847d;

    /* renamed from: c.a.q0.t.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0703a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f14848a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f14849b;

        /* renamed from: c  reason: collision with root package name */
        public String f14850c;

        /* renamed from: d  reason: collision with root package name */
        public String f14851d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14852e;

        /* renamed from: f  reason: collision with root package name */
        public String f14853f;

        /* renamed from: g  reason: collision with root package name */
        public BdUniqueId f14854g;

        /* renamed from: h  reason: collision with root package name */
        public String f14855h;

        /* renamed from: i  reason: collision with root package name */
        public String f14856i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f14857j;
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
            this.f14848a = null;
            this.f14852e = false;
            this.f14853f = "0";
            this.f14855h = "0";
            this.f14856i = null;
            this.f14857j = false;
        }

        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f14849b = z;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f14856i = str;
                if (str != null) {
                    this.f14857j = true;
                }
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.cancel(true);
                NetWork netWork = this.f14848a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.f14848a = null;
                }
                if (this.l.f14845b != null) {
                    this.l.f14845b.cancel();
                    this.l.f14845b = null;
                }
                if (this.l.f14846c != null) {
                    this.l.f14846c.c(Boolean.FALSE);
                }
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f14853f = str;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.f14855h = str;
            }
        }

        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
                this.f14852e = z;
            }
        }

        public void g(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
                this.f14854g = bdUniqueId;
            }
        }

        public void h(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.f14850c = str;
            }
        }

        public void i(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
                this.f14851d = str;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, numArr)) == null) {
                try {
                    if (this.f14850c != null) {
                        NetWork netWork = new NetWork();
                        this.f14848a = netWork;
                        if (this.f14849b) {
                            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.FOLLOW_ADDRESS);
                            this.f14848a.setNeedSig(true);
                        } else {
                            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.UNFOLLOW_ADDRESS);
                        }
                        this.f14848a.addPostData("portrait", this.f14850c);
                        if (!StringUtils.isNull(this.f14853f)) {
                            this.f14848a.addPostData("from_type", this.f14853f);
                        }
                        if (!StringUtils.isNull(this.f14856i)) {
                            this.f14848a.addPostData("forum_id", this.f14856i);
                        }
                        this.f14848a.addPostData("in_live", this.f14855h);
                        this.f14848a.addPostData("authsid", this.k);
                        this.f14848a.getNetContext().getRequest().mIsNeedTbs = true;
                        String postNetData = this.f14848a.postNetData();
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
                this.l.f14845b = null;
                if (this.f14848a != null) {
                    UpdateAttentionMessage.a aVar = new UpdateAttentionMessage.a();
                    aVar.f48111a = this.f14848a.getNetContext().getResponse().isRequestSuccess();
                    aVar.f48112b = this.f14848a.getErrorString();
                    aVar.f48114d = this.f14849b;
                    aVar.f48113c = this.f14851d;
                    aVar.f48116f = this.f14852e;
                    aVar.f48120j = this.l.f14847d;
                    aVar.b(str, this.f14857j);
                    if (this.f14848a.getNetContext().getResponse().isRequestSuccess()) {
                        aVar.l = null;
                    }
                    int serverErrorCode = this.f14848a.getServerErrorCode();
                    if (AntiHelper.a(this.l.i(), serverErrorCode, aVar.k) || c.a.r0.u3.a.a(this.l.i(), serverErrorCode, this.f14848a.getErrorString())) {
                        return;
                    }
                    UpdateAttentionMessage updateAttentionMessage = new UpdateAttentionMessage(aVar);
                    updateAttentionMessage.setOrginalMessage(new CustomMessage(2001000, this.f14854g));
                    MessageManager.getInstance().dispatchResponsedMessageToUI(updateAttentionMessage);
                    if (this.f14849b && serverErrorCode == 0) {
                        a aVar2 = this.l;
                        boolean[] h2 = aVar2.h(aVar2.f14844a);
                        if (h2 != null) {
                            if (h2[0] || h2[1]) {
                                c.a.q0.t.h.a.f(this.l.f14844a, h2, 1);
                            }
                        }
                    }
                }
            }
        }

        public /* synthetic */ b(a aVar, C0703a c0703a) {
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
        this.f14844a = tbPageContext;
    }

    public void g() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f14845b) == null) {
            return;
        }
        bVar.cancel();
    }

    public final boolean[] h(TbPageContext tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext)) == null) {
            boolean[] zArr = null;
            String localClassName = (tbPageContext == null || tbPageContext.getPageActivity() == null) ? null : tbPageContext.getPageActivity().getLocalClassName();
            if (("pb.pb.main.PbActivity".equals(localClassName) || "personPolymeric.PersonPolymericActivity".equals(localClassName) || "enterForum.hotuserrank.HotUserRankActivity".equals(localClassName)) && c.a.q0.s.d0.b.j().g("first_call_attention", true)) {
                c.a.q0.s.d0.b.j().t("first_call_attention", false);
                zArr = new boolean[]{!NotificationManagerCompat.from(this.f14844a.getPageActivity()).areNotificationsEnabled(), !c.a.q0.t.d.d.d().s()};
                if (!zArr[0] && !zArr[1] && tbPageContext != null && !this.f14847d) {
                    tbPageContext.showToast(R.string.attention_success);
                }
            } else if (tbPageContext != null && !this.f14847d) {
                tbPageContext.showToast(R.string.attention_success);
            }
            return zArr;
        }
        return (boolean[]) invokeL.objValue;
    }

    public Activity i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbPageContext tbPageContext = this.f14844a;
            if (tbPageContext != null) {
                return tbPageContext.getPageActivity();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f14847d = z;
        }
    }

    public void k(c.a.e.a.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, eVar) == null) {
            this.f14846c = eVar;
        }
    }

    public void l(boolean z, String str, String str2, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), str, str2, bdUniqueId}) == null) {
            m(z, str, str2, false, "0", bdUniqueId, null, "0");
        }
    }

    public void m(boolean z, String str, String str2, boolean z2, String str3, BdUniqueId bdUniqueId, String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, bdUniqueId, str4, str5}) == null) && this.f14845b == null) {
            b bVar = new b(this, null);
            this.f14845b = bVar;
            bVar.setPriority(2);
            this.f14845b.b(z);
            this.f14845b.h(str);
            this.f14845b.i(str2);
            this.f14845b.f(z2);
            this.f14845b.d(str3);
            this.f14845b.g(bdUniqueId);
            this.f14845b.c(str4);
            this.f14845b.e(str5);
            this.f14845b.execute(new Integer[0]);
        }
    }
}
