package com.baidu.fsg.base.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.tieba.pushdialog.PushDialogActivity;
/* loaded from: classes2.dex */
public class HomeWatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5453a = "HomeWatcher";

    /* renamed from: b  reason: collision with root package name */
    public final Context f5454b;

    /* renamed from: c  reason: collision with root package name */
    public final IntentFilter f5455c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");

    /* renamed from: d  reason: collision with root package name */
    public OnHomePressedListener f5456d;

    /* renamed from: e  reason: collision with root package name */
    public InnerRecevier f5457e;

    /* loaded from: classes2.dex */
    public class InnerRecevier extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final String f5458a = "reason";

        /* renamed from: b  reason: collision with root package name */
        public final String f5459b = "globalactions";

        /* renamed from: c  reason: collision with root package name */
        public final String f5460c = PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS;

        /* renamed from: d  reason: collision with root package name */
        public final String f5461d = "homekey";

        public InnerRecevier() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (!intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || HomeWatcher.this.f5456d == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                HomeWatcher.this.f5456d.onHomePressed();
            } else if (stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                HomeWatcher.this.f5456d.onHomeLongPressed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    public HomeWatcher(Context context) {
        this.f5454b = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.f5456d = onHomePressedListener;
        this.f5457e = new InnerRecevier();
    }

    public void startWatch() {
        InnerRecevier innerRecevier = this.f5457e;
        if (innerRecevier != null) {
            this.f5454b.registerReceiver(innerRecevier, this.f5455c);
        }
    }

    public void stopWatch() {
        InnerRecevier innerRecevier = this.f5457e;
        if (innerRecevier != null) {
            this.f5454b.unregisterReceiver(innerRecevier);
        }
    }
}
