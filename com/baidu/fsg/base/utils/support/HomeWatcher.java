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
/* loaded from: classes2.dex */
public class HomeWatcher {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f5503a = "HomeWatcher";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f5504b;

    /* renamed from: c  reason: collision with root package name */
    public final IntentFilter f5505c;

    /* renamed from: d  reason: collision with root package name */
    public OnHomePressedListener f5506d;

    /* renamed from: e  reason: collision with root package name */
    public InnerRecevier f5507e;

    /* loaded from: classes2.dex */
    public class InnerRecevier extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f5508a;

        /* renamed from: b  reason: collision with root package name */
        public final String f5509b;

        /* renamed from: c  reason: collision with root package name */
        public final String f5510c;

        /* renamed from: d  reason: collision with root package name */
        public final String f5511d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeWatcher f5512e;

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
            this.f5512e = homeWatcher;
            this.f5508a = "reason";
            this.f5509b = "globalactions";
            this.f5510c = PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS;
            this.f5511d = "homekey";
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || !intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || this.f5512e.f5506d == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                this.f5512e.f5506d.onHomePressed();
            } else if (stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                this.f5512e.f5506d.onHomeLongPressed();
            }
        }
    }

    /* loaded from: classes2.dex */
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
        this.f5504b = context;
        this.f5505c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onHomePressedListener) == null) {
            this.f5506d = onHomePressedListener;
            this.f5507e = new InnerRecevier(this);
        }
    }

    public void startWatch() {
        InnerRecevier innerRecevier;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (innerRecevier = this.f5507e) == null) {
            return;
        }
        this.f5504b.registerReceiver(innerRecevier, this.f5505c);
    }

    public void stopWatch() {
        InnerRecevier innerRecevier;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (innerRecevier = this.f5507e) == null) {
            return;
        }
        this.f5504b.unregisterReceiver(innerRecevier);
    }
}
