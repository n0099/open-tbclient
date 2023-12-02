package com.baidu.poly.wallet.paychannel;

import android.app.Activity;
import com.baidu.tieba.sb1;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IChannelAuth extends Serializable {
    void aLiAuth(Activity activity, String str, sb1<JSONObject> sb1Var);
}
