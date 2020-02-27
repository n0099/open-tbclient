package com.baidu.ala.notify;

import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class AlaLiveUserNotifyModel {
    private AlaLiveNotifyCallBack mCallBack;
    private boolean mIsNeedShowDialog;
    private TbPageContext mTbPageContext;
    private HttpMessageListener mGetUserNotifyListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY) { // from class: com.baidu.ala.notify.AlaLiveUserNotifyModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof AlaLiveGetUserNotifyResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveUserNotifyModel.this.mCurTag) {
                AlaLiveGetUserNotifyResponsedMessage alaLiveGetUserNotifyResponsedMessage = (AlaLiveGetUserNotifyResponsedMessage) httpResponsedMessage;
                int count = v.getCount(alaLiveGetUserNotifyResponsedMessage.getDataList());
                if (count > 0) {
                    if (AlaLiveUserNotifyModel.this.mIsNeedShowDialog) {
                        AlaLiveUserNotifyModel.this.showNextNotifyDialog(0, alaLiveGetUserNotifyResponsedMessage.getDataList());
                        return;
                    }
                    for (int i = 0; i < count; i++) {
                        AlaLiveUserNotifyModel.this.addNotifyToImList(alaLiveGetUserNotifyResponsedMessage.getDataList().get(i));
                    }
                }
            }
        }
    };
    private BdUniqueId mCurTag = BdUniqueId.gen();

    /* loaded from: classes3.dex */
    public interface AlaLiveNotifyCallBack {
        void onCallBack(AlaLiveUserNotifyData alaLiveUserNotifyData);
    }

    public AlaLiveUserNotifyModel(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsNeedShowDialog = z;
        this.mGetUserNotifyListener.setTag(this.mCurTag);
        MessageManager.getInstance().registerListener(this.mGetUserNotifyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNotifyToImList(AlaLiveUserNotifyData alaLiveUserNotifyData) {
        if (this.mCallBack != null) {
            this.mCallBack.onCallBack(alaLiveUserNotifyData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNextNotifyDialog(int i, ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (i < v.getCount(arrayList)) {
            int i2 = i;
            while (true) {
                if (i2 >= v.getCount(arrayList)) {
                    i2 = i;
                    break;
                } else if (arrayList.get(i2).isSuperGuardian()) {
                    break;
                } else {
                    i2++;
                }
            }
            AlaLiveUserNotifyData alaLiveUserNotifyData = arrayList.get(i2);
            if (alaLiveUserNotifyData.isSuperGuardian()) {
                showNotifyDialog(i2, alaLiveUserNotifyData, arrayList);
            }
        }
    }

    private void showNotifyDialog(final int i, AlaLiveUserNotifyData alaLiveUserNotifyData, final ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (this.mTbPageContext != null) {
            AlaLiveUserNotifyDialog alaLiveUserNotifyDialog = new AlaLiveUserNotifyDialog(this.mTbPageContext.getPageActivity());
            alaLiveUserNotifyDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.ala.notify.AlaLiveUserNotifyModel.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    AlaLiveUserNotifyModel.this.showNextNotifyDialog(i + 1, arrayList);
                }
            });
            alaLiveUserNotifyDialog.show(alaLiveUserNotifyData);
        }
    }

    public void sendGetUserNotifyRequest() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
        httpMessage.addParam("num", 10);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void onDestroy() {
        this.mTbPageContext = null;
        MessageManager.getInstance().unRegisterListener(this.mGetUserNotifyListener);
    }

    public void setNotifyCallBack(AlaLiveNotifyCallBack alaLiveNotifyCallBack) {
        this.mCallBack = alaLiveNotifyCallBack;
    }
}
