package c.a.r0.w.l.g.d;

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
    public TbPageContext f26422a;

    /* renamed from: b  reason: collision with root package name */
    public b f26423b;

    /* renamed from: c  reason: collision with root package name */
    public BdAsyncTask f26424c;

    /* renamed from: d  reason: collision with root package name */
    public HttpMessageListener f26425d;

    /* renamed from: c.a.r0.w.l.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1232a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26426a;

        /* renamed from: c.a.r0.w.l.g.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1233a extends BdAsyncTask {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f26427a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HttpResponsedMessage f26428b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ C1232a f26429c;

            public C1233a(C1232a c1232a, List list, HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c1232a, list, httpResponsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f26429c = c1232a;
                this.f26427a = list;
                this.f26428b = httpResponsedMessage;
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Object doInBackground(Object[] objArr) {
                InterceptResult invokeL;
                AlaDynamicGift alaDynamicGift;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) {
                    for (n nVar : this.f26427a) {
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
                    this.f26429c.f26426a.f26423b.a((AlaGetEnterEffectResponsedMessage) this.f26428b);
                }
            }

            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                    super.onPostExecute(obj);
                    this.f26429c.f26426a.f26423b.a((AlaGetEnterEffectResponsedMessage) this.f26428b);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1232a(a aVar, int i2) {
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
            this.f26426a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof AlaGetEnterEffectResponsedMessage)) {
                AlaGetEnterEffectResponsedMessage alaGetEnterEffectResponsedMessage = (AlaGetEnterEffectResponsedMessage) httpResponsedMessage;
                List<n> effectList = alaGetEnterEffectResponsedMessage.getEffectList();
                if (ListUtils.isEmpty(effectList)) {
                    this.f26426a.f26423b.a(alaGetEnterEffectResponsedMessage);
                    return;
                }
                this.f26426a.f26424c = new C1233a(this, effectList, httpResponsedMessage).execute(new Object[0]);
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
        C1232a c1232a = new C1232a(this, AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
        this.f26425d = c1232a;
        this.f26422a = tbPageContext;
        this.f26423b = bVar;
        tbPageContext.registerListener(c1232a);
    }

    public void c() {
        BdAsyncTask bdAsyncTask;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bdAsyncTask = this.f26424c) == null) {
            return;
        }
        bdAsyncTask.cancel();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT);
            httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
            this.f26422a.sendMessage(httpMessage);
        }
    }
}
