package com.baidu.searchbox.account;

import android.app.Activity;
import com.baidu.searchbox.account.result.BoxGetContactResult;
/* loaded from: classes3.dex */
public interface IGetContactsCallback extends ISapiCallback<BoxGetContactResult> {
    void getDialog(Activity activity);
}
