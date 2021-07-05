package com.baidu.fsg.base.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HomeWatcher {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5460a = "HomeWatcher";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f5461b;

    /* renamed from: c  reason: collision with root package name */
    public final IntentFilter f5462c;

    /* renamed from: d  reason: collision with root package name */
    public OnHomePressedListener f5463d;

    /* renamed from: e  reason: collision with root package name */
    public InnerRecevier f5464e;

    /* loaded from: classes3.dex */
    public class InnerRecevier extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f5465a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5466b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5467c;

        /* renamed from: d  reason: collision with root package name */
        public final String f5468d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeWatcher f5469e;

        public InnerRecevier(HomeWatcher homeWatcher) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeWatcher};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5469e = homeWatcher;
            this.f5465a = "reason";
            this.f5466b = "globalactions";
            this.f5467c = PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS;
            this.f5468d = "homekey";
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || !intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || this.f5469e.f5463d == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                this.f5469e.f5463d.onHomePressed();
            } else if (stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                this.f5469e.f5463d.onHomeLongPressed();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    public HomeWatcher(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5461b = context;
        this.f5462c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onHomePressedListener) == null) {
            this.f5463d = onHomePressedListener;
            this.f5464e = new InnerRecevier(this);
        }
    }

    public void startWatch() {
        InnerRecevier innerRecevier;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (innerRecevier = this.f5464e) == null) {
            return;
        }
        this.f5461b.registerReceiver(innerRecevier, this.f5462c);
    }

    public void stopWatch() {
        InnerRecevier innerRecevier;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (innerRecevier = this.f5464e) == null) {
            return;
        }
        this.f5461b.unregisterReceiver(innerRecevier);
    }
}
