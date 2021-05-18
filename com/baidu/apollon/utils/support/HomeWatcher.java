package com.baidu.apollon.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.tieba.pushdialog.PushDialogActivity;
/* loaded from: classes.dex */
public class HomeWatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4133a = "HomeWatcher";

    /* renamed from: b  reason: collision with root package name */
    public final Context f4134b;

    /* renamed from: c  reason: collision with root package name */
    public final IntentFilter f4135c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");

    /* renamed from: d  reason: collision with root package name */
    public OnHomePressedListener f4136d;

    /* renamed from: e  reason: collision with root package name */
    public a f4137e;

    /* loaded from: classes.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final String f4138a = "reason";

        /* renamed from: b  reason: collision with root package name */
        public final String f4139b = "globalactions";

        /* renamed from: c  reason: collision with root package name */
        public final String f4140c = PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS;

        /* renamed from: d  reason: collision with root package name */
        public final String f4141d = "homekey";

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (!intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || HomeWatcher.this.f4136d == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                HomeWatcher.this.f4136d.onHomePressed();
            } else if (stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                HomeWatcher.this.f4136d.onHomeLongPressed();
            }
        }
    }

    public HomeWatcher(Context context) {
        this.f4134b = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.f4136d = onHomePressedListener;
        this.f4137e = new a();
    }

    public void startWatch() {
        a aVar = this.f4137e;
        if (aVar != null) {
            this.f4134b.registerReceiver(aVar, this.f4135c);
        }
    }

    public void stopWatch() {
        a aVar = this.f4137e;
        if (aVar != null) {
            this.f4134b.unregisterReceiver(aVar);
        }
    }
}
