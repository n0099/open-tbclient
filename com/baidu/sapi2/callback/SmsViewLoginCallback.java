package com.baidu.sapi2.callback;

import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
/* loaded from: classes2.dex */
public abstract class SmsViewLoginCallback extends WebAuthListener {
    public abstract void onCheckCodeViewHide();

    public abstract void onCheckCodeViewShow();

    public abstract void onNeedBack(WebAuthResult webAuthResult);
}
