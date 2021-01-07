package com.baidu.fsg.base.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes6.dex */
public class HomeWatcher {

    /* renamed from: a  reason: collision with root package name */
    static final String f2068a = "HomeWatcher";

    /* renamed from: b  reason: collision with root package name */
    private final Context f2069b;
    private final IntentFilter c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    private OnHomePressedListener d;
    private InnerRecevier e;

    /* loaded from: classes6.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    public HomeWatcher(Context context) {
        this.f2069b = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.d = onHomePressedListener;
        this.e = new InnerRecevier();
    }

    public void startWatch() {
        if (this.e != null) {
            this.f2069b.registerReceiver(this.e, this.c);
        }
    }

    public void stopWatch() {
        if (this.e != null) {
            this.f2069b.unregisterReceiver(this.e);
        }
    }

    /* loaded from: classes6.dex */
    class InnerRecevier extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final String f2070a = TiebaInitialize.LogFields.REASON;

        /* renamed from: b  reason: collision with root package name */
        final String f2071b = "globalactions";
        final String c = "recentapps";
        final String d = "homekey";

        InnerRecevier() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra(TiebaInitialize.LogFields.REASON)) != null && HomeWatcher.this.d != null) {
                if (stringExtra.equals("homekey")) {
                    HomeWatcher.this.d.onHomePressed();
                } else if (stringExtra.equals("recentapps")) {
                    HomeWatcher.this.d.onHomeLongPressed();
                }
            }
        }
    }
}
