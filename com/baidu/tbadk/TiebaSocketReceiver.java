package com.baidu.tbadk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ki5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class TiebaSocketReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public TiebaSocketReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
            if (NetworkMonitor.NET_CHANGE_ACTION.equals(intent.getAction())) {
                if (Build.VERSION.SDK_INT < 24 && BdNetTypeUtil.isNetWorkAvailable()) {
                    ki5.b(0, 0, 0, 1, 6);
                    BdSocketLinkService.setAvailable(true);
                    BdSocketLinkService.startService(false, "net succ");
                }
            } else if ("com.baidu.android.pushservice.action.BIND_SYNC".equals(intent.getAction())) {
                if (BdNetTypeUtil.isNetWorkAvailable() && !BdSocketLinkService.isOpen()) {
                    ki5.b(0, 0, 0, 1, 7);
                    BdSocketLinkService.startService(false, "frombaidupushservice");
                    TiebaStatic.eventStat(context, "baidupushservice_activate_tieba", "socket", 1, "iscon", 1);
                    return;
                }
                TiebaStatic.eventStat(context, "baidupushservice_activate_tieba", "socket", 1, "iscon", 0);
            } else {
                BdSocketLinkService.startService(false, "calling or boot ");
            }
        }
    }
}
