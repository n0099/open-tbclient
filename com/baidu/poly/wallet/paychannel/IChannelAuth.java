package com.baidu.poly.wallet.paychannel;

import android.app.Activity;
import com.baidu.tieba.jh1;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IChannelAuth extends Serializable {
    void aLiAuth(Activity activity, String str, jh1<JSONObject> jh1Var);
}
