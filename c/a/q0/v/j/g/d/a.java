package c.a.q0.v.j.g.d;

import c.a.e.l.e.n;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.downloader.ResourceDownloader;
import com.baidu.ala.gift.AlaDynamicGift;
import com.baidu.ala.gift.AlaDynamicGiftLocalInfoConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaGetEnterEffectResponsedMessage;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.data.AlaEnterEffectData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25746a;

    /* renamed from: b  reason: collision with root package name */
    public b f25747b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTask f25748c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f25749d;

    /* renamed from: c.a.q0.v.j.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1201a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25750a;

        /* renamed from: c.a.q0.v.j.g.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1202a extends BdAsyncTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f25751a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HttpResponsedMessage f25752b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C1201a f25753c;

            public C1202a(C1201a c1201a, List list, HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1201a, list, httpResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25753c = c1201a;
                this.f25751a = list;
                this.f25752b = httpResponsedMessage;
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Object doInBackground(Object[] objArr) {
                InterceptResult invokeL;
                AlaDynamicGift alaDynamicGift;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                    for (n nVar : this.f25751a) {
                        if (nVar instanceof AlaEnterEffectData) {
                            AlaEnterEffectData alaEnterEffectData = (AlaEnterEffectData) nVar;
                            if (alaEnterEffectData.type == 1 && (alaDynamicGift = alaEnterEffectData.gift) != null && alaDynamicGift.giftZip != null) {
                                if (ResourceDownloader.checkDirNeedToDownload(AlaDynamicGiftLocalInfoConfig.DIR_PATH + alaEnterEffectData.gift.giftZip.zipName, AlaDynamicGiftLocalInfoConfig.PIC_MD5_PREFIX + alaEnterEffectData.gift.giftName)) {
                                    alaEnterEffectData.downLoadStatus = 100;
                                } else {
                                    alaEnterEffectData.downLoadStatus = 101;
                                }
                            }
                        }
                    }
                    return null;
                }
                return invokeL.objValue;
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onCancelled() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.onCancelled();
                    this.f25753c.f25750a.f25747b.a((AlaGetEnterEffectResponsedMessage) this.f25752b);
                }
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    super.onPostExecute(obj);
                    this.f25753c.f25750a.f25747b.a((AlaGetEnterEffectResponsedMessage) this.f25752b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1201a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25750a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof AlaGetEnterEffectResponsedMessage)) {
                AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage = (AlaGetEnterEffectResponsedMessage) httpResponsedMessage;
                List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
                if (ListUtils.isEmpty(effectList)) {
                    this.f25750a.f25747b.a(alaGetEnterEffectResponsedMessage);
                    return;
                }
                this.f25750a.f25748c = new C1202a(this, effectList, httpResponsedMessage).execute(new Object[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        C1201a c1201a = new C1201a(this, AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        this.f25749d = c1201a;
        this.f25746a = tbPageContext;
        this.f25747b = bVar;
        tbPageContext.registerListener(c1201a);
    }

    public void c() {
        BdAsyncTask bdAsyncTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdAsyncTask = this.f25748c) == null) {
            return;
        }
        bdAsyncTask.cancel();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            this.f25746a.sendMessage(httpMessage);
        }
    }
}
