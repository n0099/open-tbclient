package com.baidu.apollon.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.tieba.pushdialog.PushDialogActivity;
/* loaded from: classes.dex */
public class HomeWatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final String f4155a = "HomeWatcher";

    /* renamed from: b  reason: collision with root package name */
    public final Context f4156b;

    /* renamed from: c  reason: collision with root package name */
    public final IntentFilter f4157c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");

    /* renamed from: d  reason: collision with root package name */
    public OnHomePressedListener f4158d;

    /* renamed from: e  reason: collision with root package name */
    public a f4159e;

    /* loaded from: classes.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final String f4160a = "reason";

        /* renamed from: b  reason: collision with root package name */
        public final String f4161b = "globalactions";

        /* renamed from: c  reason: collision with root package name */
        public final String f4162c = PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS;

        /* renamed from: d  reason: collision with root package name */
        public final String f4163d = "homekey";

        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (!intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || HomeWatcher.this.f4158d == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                HomeWatcher.this.f4158d.onHomePressed();
            } else if (stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                HomeWatcher.this.f4158d.onHomeLongPressed();
            }
        }
    }

    public HomeWatcher(Context context) {
        this.f4156b = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.f4158d = onHomePressedListener;
        this.f4159e = new a();
    }

    public void startWatch() {
        a aVar = this.f4159e;
        if (aVar != null) {
            this.f4156b.registerReceiver(aVar, this.f4157c);
        }
    }

    public void stopWatch() {
        a aVar = this.f4159e;
        if (aVar != null) {
            this.f4156b.unregisterReceiver(aVar);
        }
    }
}
