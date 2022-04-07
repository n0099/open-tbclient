package com.baidu.ala.refresh;

import android.os.Bundle;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusRequestMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wa;
import java.util.List;
/* loaded from: classes.dex */
public abstract class AlaAutoRefreshFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int GET_CLOSE_ONSCROLL_STOP_DELAY_MILLIS = 2000;
    public transient /* synthetic */ FieldHolder $fh;
    public wa mLiveStatusMsgListener;
    public ISquareRefreshHandler mSquareRefreshHandler;

    public AlaAutoRefreshFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLiveStatusMsgListener = new wa(this, AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.ala.refresh.AlaAutoRefreshFragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AlaAutoRefreshFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r9, r10);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this, Integer.valueOf(r9), Integer.valueOf(r10)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        Object[] objArr2 = newInitContext2.callArgs;
                        super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.repackage.wa
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == this.this$0.getUniqueId()) {
                    List<Long> list = null;
                    if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                        list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                    } else if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                        list = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                    }
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    this.this$0.processCloseLives(list);
                }
            }
        };
    }

    public abstract List<Long> getCurrentLiveIds();

    public void markHasReaded() {
        ISquareRefreshHandler iSquareRefreshHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (iSquareRefreshHandler = this.mSquareRefreshHandler) == null) {
            return;
        }
        iSquareRefreshHandler.markHasReaded();
    }

    public void markLoadedData(int i) {
        ISquareRefreshHandler iSquareRefreshHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (iSquareRefreshHandler = this.mSquareRefreshHandler) == null) {
            return;
        }
        iSquareRefreshHandler.markDataLoaded(i);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.mLiveStatusMsgListener);
        }
    }

    public abstract void processCloseLives(List<Long> list);

    public void refreshCurrentPage() {
        List<Long> currentLiveIds;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (currentLiveIds = getCurrentLiveIds()) == null || currentLiveIds.isEmpty()) {
            return;
        }
        AlaMGetLiveStatusRequestMessage alaMGetLiveStatusRequestMessage = new AlaMGetLiveStatusRequestMessage();
        alaMGetLiveStatusRequestMessage.setTag(getUniqueId());
        alaMGetLiveStatusRequestMessage.setListIds(currentLiveIds);
        sendMessage(alaMGetLiveStatusRequestMessage);
    }

    public void setSquareRefreshHandler(ISquareRefreshHandler iSquareRefreshHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, iSquareRefreshHandler) == null) {
            this.mSquareRefreshHandler = iSquareRefreshHandler;
        }
    }
}
