package com.baidu.poly.wallet.paychannel;

import android.app.Activity;
import com.baidu.tieba.fh1;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface IChannelAuth extends Serializable {
    void aLiAuth(Activity activity, String str, fh1<JSONObject> fh1Var);
}
