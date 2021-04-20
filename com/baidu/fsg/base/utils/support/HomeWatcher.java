package com.baidu.fsg.base.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.tieba.pushdialog.PushDialogActivity;
/* loaded from: classes2.dex */
public class HomeWatcher {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5489a = "HomeWatcher";

    /* renamed from: b  reason: collision with root package name */
    public final Context f5490b;

    /* renamed from: c  reason: collision with root package name */
    public final IntentFilter f5491c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");

    /* renamed from: d  reason: collision with root package name */
    public OnHomePressedListener f5492d;

    /* renamed from: e  reason: collision with root package name */
    public InnerRecevier f5493e;

    /* loaded from: classes2.dex */
    public class InnerRecevier extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        public final String f5494a = "reason";

        /* renamed from: b  reason: collision with root package name */
        public final String f5495b = "globalactions";

        /* renamed from: c  reason: collision with root package name */
        public final String f5496c = PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS;

        /* renamed from: d  reason: collision with root package name */
        public final String f5497d = "homekey";

        public InnerRecevier() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (!intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") || (stringExtra = intent.getStringExtra("reason")) == null || HomeWatcher.this.f5492d == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                HomeWatcher.this.f5492d.onHomePressed();
            } else if (stringExtra.equals(PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_RECENT_APPS)) {
                HomeWatcher.this.f5492d.onHomeLongPressed();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    public HomeWatcher(Context context) {
        this.f5490b = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.f5492d = onHomePressedListener;
        this.f5493e = new InnerRecevier();
    }

    public void startWatch() {
        InnerRecevier innerRecevier = this.f5493e;
        if (innerRecevier != null) {
            this.f5490b.registerReceiver(innerRecevier, this.f5491c);
        }
    }

    public void stopWatch() {
        InnerRecevier innerRecevier = this.f5493e;
        if (innerRecevier != null) {
            this.f5490b.unregisterReceiver(innerRecevier);
        }
    }
}
