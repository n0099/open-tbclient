package com.baidu.ala.notify;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class AlaLiveUserNotifyManager {
    public static /* synthetic */ Interceptable $ic;
    public static AlaLiveUserNotifyManager mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<AlaLiveUserNotifyData> dataList;
    public ArrayList<AlaLiveNotifyListener> listeners;
    public BdUniqueId mCurTag;
    public HttpMessageListener mGetUserNotifyListener;

    /* loaded from: classes.dex */
    public interface AlaLiveNotifyListener {
        void onCallBack();
    }

    public AlaLiveUserNotifyManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGetUserNotifyListener = new HttpMessageListener(this, AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY) { // from class: com.baidu.ala.notify.AlaLiveUserNotifyManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaLiveUserNotifyManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof AlaLiveGetUserNotifyResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.this$0.mCurTag) {
                    AlaLiveGetUserNotifyResponsedMessage alaLiveGetUserNotifyResponsedMessage = (AlaLiveGetUserNotifyResponsedMessage) httpResponsedMessage;
                    if (ListUtils.getCount(alaLiveGetUserNotifyResponsedMessage.getDataList()) > 0) {
                        if (this.this$0.dataList == null) {
                            this.this$0.dataList = new ArrayList();
                        }
                        this.this$0.dataList.addAll(alaLiveGetUserNotifyResponsedMessage.getDataList());
                        this.this$0.notifyMsg();
                    } else if (ListUtils.isEmpty(this.this$0.dataList)) {
                    } else {
                        this.this$0.notifyMsg();
                    }
                }
            }
        };
        registerGetUserNotifyTask();
        this.mCurTag = BdUniqueId.gen();
        MessageManager.getInstance().registerListener(this.mGetUserNotifyListener);
    }

    public static AlaLiveUserNotifyManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (mInstance == null) {
                synchronized (AlaLiveUserNotifyManager.class) {
                    if (mInstance == null) {
                        mInstance = new AlaLiveUserNotifyManager();
                    }
                }
            }
            return mInstance;
        }
        return (AlaLiveUserNotifyManager) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyMsg() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || ListUtils.isEmpty(this.listeners)) {
            return;
        }
        Iterator<AlaLiveNotifyListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            AlaLiveNotifyListener next = it.next();
            if (next != null) {
                next.onCallBack();
            }
        }
    }

    public static void registerGetUserNotifyTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_USER_NOTIFY_URL);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaLiveGetUserNotifyResponsedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void addNotifyListener(AlaLiveNotifyListener alaLiveNotifyListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, alaLiveNotifyListener) == null) {
            if (this.listeners == null) {
                this.listeners = new ArrayList<>();
            }
            if (this.listeners.contains(alaLiveNotifyListener)) {
                return;
            }
            this.listeners.add(alaLiveNotifyListener);
        }
    }

    public ArrayList<AlaLiveUserNotifyData> getNotifyDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<AlaLiveUserNotifyData> arrayList = new ArrayList<>(this.dataList);
            this.dataList.clear();
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void removeNotifyListener(AlaLiveNotifyListener alaLiveNotifyListener) {
        ArrayList<AlaLiveNotifyListener> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaLiveNotifyListener) == null) || (arrayList = this.listeners) == null) {
            return;
        }
        arrayList.remove(alaLiveNotifyListener);
    }

    public void sendGetUserNotifyRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
            httpMessage.addParam("num", 10);
            httpMessage.setTag(this.mCurTag);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
