package com.alipay.sdk.widget;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.alibaba.fastjson.asm.Label;
/* loaded from: classes.dex */
public class i implements DownloadListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f2027a;

    public i(h hVar) {
        this.f2027a = hVar;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            this.f2027a.f2024a.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
