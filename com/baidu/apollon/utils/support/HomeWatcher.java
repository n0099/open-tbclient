package com.baidu.apollon.utils.support;

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
/* loaded from: classes6.dex */
public class HomeWatcher {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f37223a = "HomeWatcher";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Context f37224b;

    /* renamed from: c  reason: collision with root package name */
    public final IntentFilter f37225c;

    /* renamed from: d  reason: collision with root package name */
    public OnHomePressedListener f37226d;

    /* renamed from: e  reason: collision with root package name */
    public a f37227e;

    /* loaded from: classes6.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    /* loaded from: classes6.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f37228a;

        /* renamed from: b  reason: collision with root package name */
        public final String f37229b;

        /* renamed from: c  reason: collision with root package name */
        public final String f37230c;

        /* renamed from: d  reason: collision with root package name */
        public final String f37231d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeWatcher f37232e;

        public a(HomeWatcher homeWatcher) {
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
            this.f37232e = homeWatcher;
            this.f37228a = "reason";
            this.f37229b = "globalactions";
            this.f37230c = PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS;
            this.f37231d = "homekey";
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || !intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || this.f37232e.f37226d == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                this.f37232e.f37226d.onHomePressed();
            } else if (stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                this.f37232e.f37226d.onHomeLongPressed();
            }
        }
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
        this.f37224b = context;
        this.f37225c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onHomePressedListener) == null) {
            this.f37226d = onHomePressedListener;
            this.f37227e = new a(this);
        }
    }

    public void startWatch() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f37227e) == null) {
            return;
        }
        this.f37224b.registerReceiver(aVar, this.f37225c);
    }

    public void stopWatch() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f37227e) == null) {
            return;
        }
        this.f37224b.unregisterReceiver(aVar);
    }
}
