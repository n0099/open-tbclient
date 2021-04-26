package com.baidu.android.imsdk.pubaccount;

import com.baidu.android.imsdk.IMSliceListener;
import com.baidu.android.imsdk.internal.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GetPaInfoSliceListener implements IMSliceListener<PaInfo> {
    public int errorCode;
    public String errorMsg;
    public int maxCount;
    public IGetPaInfosListener paListener;
    public int count = 0;
    public List<PaInfo> result = new ArrayList();

    public GetPaInfoSliceListener(IGetPaInfosListener iGetPaInfosListener, int i2) {
        this.paListener = iGetPaInfosListener;
        this.maxCount = i2;
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public List<PaInfo> getResult() {
        return this.result;
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public boolean isComplete() {
        return this.count == this.maxCount;
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public void mergeErrorCode(int i2) {
        List<PaInfo> list = this.result;
        if (list != null && !list.isEmpty()) {
            this.errorCode = 0;
        } else {
            this.errorCode = i2;
        }
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public void mergeErrorMsg(String str) {
        if (this.errorCode == 0) {
            this.errorMsg = Constants.ERROR_MSG_SUCCESS;
        } else {
            this.errorMsg = str;
        }
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public void mergeSliceData(List<PaInfo> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.result.addAll(list);
    }

    @Override // com.baidu.android.imsdk.IMSliceListener
    public synchronized void onResult(int i2, String str, List<PaInfo> list) {
        if (isComplete()) {
            return;
        }
        this.count++;
        mergeSliceData(list);
        mergeErrorCode(i2);
        mergeErrorMsg(str);
        if (isComplete() && this.paListener != null) {
            this.paListener.onResult(this.errorCode, this.errorMsg, new ArrayList<>(this.result));
        }
    }
}
