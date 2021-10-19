package c.a.r0.t1.l.a;

import android.text.TextUtils;
import c.a.r0.f0.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f24950a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f24951b;

    /* renamed from: c  reason: collision with root package name */
    public final CustomMessageListener f24952c;

    /* renamed from: c.a.r0.t1.l.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1153a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f24953a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1153a(a aVar, int i2) {
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
            this.f24953a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ArrayList)) {
                return;
            }
            this.f24953a.f24951b.clear();
            this.f24953a.f24951b.addAll((ArrayList) customResponsedMessage.getData());
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
        this.f24951b = new ArrayList<>();
        this.f24952c = new C1153a(this, 2016563);
        this.f24950a = tbPageContext;
        MessageManager.getInstance().registerListener(this.f24952c);
    }

    public List<TransmitForumData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f24951b : (List) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f.b().h();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f24952c);
        }
    }

    public void e(long j2, String str, ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j2), str, shareItem}) == null) {
            if (j2 > 0 || !TextUtils.isEmpty(str)) {
                SelectForumActivityConfig selectForumActivityConfig = new SelectForumActivityConfig(this.f24950a.getPageActivity(), 24007);
                CustomMessage customMessage = new CustomMessage(2002001, selectForumActivityConfig);
                selectForumActivityConfig.setFrom(1);
                selectForumActivityConfig.setForumList(this.f24951b);
                selectForumActivityConfig.setLiveId(j2);
                selectForumActivityConfig.setYyAnchorBdUid(str);
                shareItem.j(true);
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }
}
