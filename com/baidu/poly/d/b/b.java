package com.baidu.poly.d.b;

import android.content.Context;
import com.baidu.poly.bean.PayChannel;
import com.baidu.searchbox.plugin.api.InvokeCallback;
import com.baidu.searchbox.plugin.api.InvokeListener;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation;
/* loaded from: classes2.dex */
public class b extends PluginBaseDelegation {
    @Override // com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation
    public String getPluginPackageName() {
        return "com.baidu.wallet";
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    protected boolean onExec() {
        String string = this.mParams.getString("params");
        String string2 = this.mParams.getString("channel");
        InvokeCallback invokeCallback = new InvokeCallback() { // from class: com.baidu.poly.d.b.b.1
        };
        if (PayChannel.WECHAT.equalsIgnoreCase(string2)) {
            try {
                PluginInvoker.class.getDeclaredMethod("invokePlugin", Context.class, String.class, String.class, String.class, String.class, InvokeCallback.class, InvokeListener[].class).invoke(null, getAgent(), "com.baidu.wallet", "doDirectCallThirdPay", "searchbox:", string, invokeCallback, null);
            } catch (Throwable th) {
                throw new RuntimeException("call PluginInvoker.invokePlugin error", th);
            }
        } else {
            PluginInvoker.invokePluginBySwan(getAgent(), "com.baidu.wallet", "doDirectCallThirdPay", "searchbox:", string, invokeCallback, (InvokeListener[]) null);
        }
        return false;
    }
}
