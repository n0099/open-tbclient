package com.baidu.ala.notify;

import android.content.DialogInterface;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class AlaLiveUserNotifyModel {
    public AlaLiveNotifyCallBack mCallBack;
    public BdUniqueId mCurTag;
    public HttpMessageListener mGetUserNotifyListener = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY) { // from class: com.baidu.ala.notify.AlaLiveUserNotifyModel.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if ((httpResponsedMessage instanceof AlaLiveGetUserNotifyResponsedMessage) && httpResponsedMessage.getOrginalMessage().getTag() == AlaLiveUserNotifyModel.this.mCurTag) {
                AlaLiveGetUserNotifyResponsedMessage alaLiveGetUserNotifyResponsedMessage = (AlaLiveGetUserNotifyResponsedMessage) httpResponsedMessage;
                int count = ListUtils.getCount(alaLiveGetUserNotifyResponsedMessage.getDataList());
                if (count > 0) {
                    if (AlaLiveUserNotifyModel.this.mIsNeedShowDialog) {
                        AlaLiveUserNotifyModel.this.showNextNotifyDialog(0, alaLiveGetUserNotifyResponsedMessage.getDataList());
                        return;
                    }
                    for (int i2 = 0; i2 < count; i2++) {
                        AlaLiveUserNotifyModel.this.addNotifyToImList(alaLiveGetUserNotifyResponsedMessage.getDataList().get(i2));
                    }
                }
            }
        }
    };
    public boolean mIsNeedShowDialog;
    public TbPageContext mTbPageContext;

    /* loaded from: classes.dex */
    public interface AlaLiveNotifyCallBack {
        void onCallBack(AlaLiveUserNotifyData alaLiveUserNotifyData);
    }

    public AlaLiveUserNotifyModel(TbPageContext tbPageContext, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mIsNeedShowDialog = z;
        BdUniqueId gen = BdUniqueId.gen();
        this.mCurTag = gen;
        this.mGetUserNotifyListener.setTag(gen);
        MessageManager.getInstance().registerListener(this.mGetUserNotifyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addNotifyToImList(AlaLiveUserNotifyData alaLiveUserNotifyData) {
        AlaLiveNotifyCallBack alaLiveNotifyCallBack = this.mCallBack;
        if (alaLiveNotifyCallBack != null) {
            alaLiveNotifyCallBack.onCallBack(alaLiveUserNotifyData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNextNotifyDialog(int i2, ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (i2 < ListUtils.getCount(arrayList)) {
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
    }

    private void showNotifyDialog(final int i2, AlaLiveUserNotifyData alaLiveUserNotifyData, final ArrayList<AlaLiveUserNotifyData> arrayList) {
        if (this.mTbPageContext == null) {
            return;
        }
        AlaLiveUserNotifyDialog alaLiveUserNotifyDialog = new AlaLiveUserNotifyDialog(this.mTbPageContext.getPageActivity());
        alaLiveUserNotifyDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.ala.notify.AlaLiveUserNotifyModel.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AlaLiveUserNotifyModel.this.showNextNotifyDialog(i2 + 1, arrayList);
            }
        });
        alaLiveUserNotifyDialog.show(alaLiveUserNotifyData);
    }

    public void onDestroy() {
        this.mTbPageContext = null;
        MessageManager.getInstance().unRegisterListener(this.mGetUserNotifyListener);
    }

    public void sendGetUserNotifyRequest() {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_GET_USER_NOTIFY);
        httpMessage.addParam("num", 10);
        httpMessage.setTag(this.mCurTag);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void setNotifyCallBack(AlaLiveNotifyCallBack alaLiveNotifyCallBack) {
        this.mCallBack = alaLiveNotifyCallBack;
    }
}
