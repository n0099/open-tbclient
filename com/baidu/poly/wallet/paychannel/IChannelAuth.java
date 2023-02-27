package com.baidu.poly.wallet.paychannel;

import android.app.Activity;
import com.baidu.tieba.mg1;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IChannelAuth extends Serializable {
    void aLiAuth(Activity activity, String str, mg1<JSONObject> mg1Var);
}
