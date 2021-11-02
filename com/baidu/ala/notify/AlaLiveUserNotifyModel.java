package com.baidu.ala.notify;

import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes6.dex */
public class AlaLiveUserNotifyModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AlaLiveNotifyCallBack mCallBack;
    public BdUniqueId mCurTag;
    public HttpMessageListener mGetUserNotifyListener;
    public boolean mIsNeedShowDialog;
    public TbPageContext mTbPageContext;

    /* loaded from: classes6.dex */
    public interface AlaLiveNotifyCallBack {
        void onCallBack(AlaLiveUserNotifyData alaLiveUserNotifyData);
    }

    public AlaLiveUserNotifyModel(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mGetUserNotifyListener = new HttpMessageListener(this, AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY) { // from class: com.baidu.ala.notify.AlaLiveUserNotifyModel.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaLiveUserNotifyModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
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
                    int count = ListUtils.getCount(alaLiveGetUserNotifyResponsedMessage.getDataList());
                    if (count > 0) {
                        if (this.this$0.mIsNeedShowDialog) {
                            this.this$0.showNextNotifyDialog(0, alaLiveGetUserNotifyResponsedMessage.getDataList());
                            return;
                        }
                        for (int i4 = 0; i4 < count; i4++) {
                            this.this$0.addNotifyToImList(alaLiveGetUserNotifyResponsedMessage.getDataList().get(i4));
                        }
                    }
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mIsNeedShowDialog = z;
        BdUniqueId gen = BdUniqueId.gen();
        this.mCurTag = gen;
        this.mGetUserNotifyListener.setTag(gen);
        MessageManager.getInstance().registerListener(this.mGetUserNotifyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNotifyToImList(AlaLiveUserNotifyData alaLiveUserNotifyData) {
        AlaLiveNotifyCallBack alaLiveNotifyCallBack;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, alaLiveUserNotifyData) == null) || (alaLiveNotifyCallBack = this.mCallBack) == null) {
            return;
        }
        alaLiveNotifyCallBack.onCallBack(alaLiveUserNotifyData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNextNotifyDialog(int i2, ArrayList<AlaLiveUserNotifyData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, this, i2, arrayList) == null) || i2 >= ListUtils.getCount(arrayList)) {
            return;
        }
        int i3 = i2;
        while (true) {
            if (i3 >= ListUtils.getCount(arrayList)) {
                break;
            } else if (arrayList.get(i3).isSuperGuardian()) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        AlaLiveUserNotifyData alaLiveUserNotifyData = arrayList.get(i2);
        if (alaLiveUserNotifyData.isSuperGuardian()) {
            showNotifyDialog(i2, alaLiveUserNotifyData, arrayList);
        }
    }

    private void showNotifyDialog(int i2, AlaLiveUserNotifyData alaLiveUserNotifyData, ArrayList<AlaLiveUserNotifyData> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65543, this, i2, alaLiveUserNotifyData, arrayList) == null) || this.mTbPageContext == null) {
            return;
        }
        AlaLiveUserNotifyDialog alaLiveUserNotifyDialog = new AlaLiveUserNotifyDialog(this.mTbPageContext.getPageActivity());
        alaLiveUserNotifyDialog.setOnDismissListener(new DialogInterface.OnDismissListener(this, i2, arrayList) { // from class: com.baidu.ala.notify.AlaLiveUserNotifyModel.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaLiveUserNotifyModel this$0;
            public final /* synthetic */ ArrayList val$dataList;
            public final /* synthetic */ int val$index;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(i2), arrayList};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$index = i2;
                this.val$dataList = arrayList;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) {
                    this.this$0.showNextNotifyDialog(this.val$index + 1, this.val$dataList);
                }
            }
        });
        alaLiveUserNotifyDialog.show(alaLiveUserNotifyData);
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTbPageContext = null;
            MessageManager.getInstance().unRegisterListener(this.mGetUserNotifyListener);
        }
    }

    public void sendGetUserNotifyRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
            httpMessage.addParam("num", 10);
            httpMessage.setTag(this.mCurTag);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void setNotifyCallBack(AlaLiveNotifyCallBack alaLiveNotifyCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, alaLiveNotifyCallBack) == null) {
            this.mCallBack = alaLiveNotifyCallBack;
        }
    }
}
