package com.baidu.poly.wallet.paychannel;

import android.app.Activity;
import com.baidu.tieba.xa1;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IChannelAuth extends Serializable {
    void aLiAuth(Activity activity, String str, xa1<JSONObject> xa1Var);
}
