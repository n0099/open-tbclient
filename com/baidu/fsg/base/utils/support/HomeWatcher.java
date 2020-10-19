package com.baidu.fsg.base.utils.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
/* loaded from: classes16.dex */
public class HomeWatcher {

    /* renamed from: a  reason: collision with root package name */
    static final String f1536a = "HomeWatcher";
    private final Context b;
    private final IntentFilter c = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    private OnHomePressedListener d;
    private InnerRecevier e;

    /* loaded from: classes16.dex */
    public interface OnHomePressedListener {
        void onHomeLongPressed();

        void onHomePressed();
    }

    public HomeWatcher(Context context) {
        this.b = context;
    }

    public void setOnHomePressedListener(OnHomePressedListener onHomePressedListener) {
        this.d = onHomePressedListener;
        this.e = new InnerRecevier();
    }

    public void startWatch() {
        if (this.e != null) {
            this.b.registerReceiver(this.e, this.c);
        }
    }

    public void stopWatch() {
        if (this.e != null) {
            this.b.unregisterReceiver(this.e);
        }
    }

    /* loaded from: classes16.dex */
    class InnerRecevier extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final String f1537a = TiebaInitialize.LogFields.REASON;
        final String b = "globalactions";
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
