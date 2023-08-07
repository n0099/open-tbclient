package com.baidu.nadcore.webview.container;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.http.Headers;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.h81;
import com.baidu.tieba.ja1;
import com.baidu.tieba.ka1;
import com.baidu.tieba.ma1;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001ZB\u000f\u0012\u0006\u0010V\u001a\u00020U¢\u0006\u0004\bX\u0010YJ\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\bJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\bJ\u0017\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\bJ\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\bJ!\u0010(\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J!\u0010*\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b*\u0010)J)\u0010,\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u00182\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b.\u0010)J\u000f\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\b/\u0010\bJ\u0019\u00101\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u0010\bJ\u0019\u00106\u001a\u00020\u00062\b\u00105\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0006H\u0016¢\u0006\u0004\b8\u0010\bJ\u0019\u0010;\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b;\u0010<J/\u0010A\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u0002090=2\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0006H\u0016¢\u0006\u0004\bC\u0010\bJ\u000f\u0010D\u001a\u00020\u0006H\u0016¢\u0006\u0004\bD\u0010\bJ\u000f\u0010E\u001a\u00020\u0006H\u0016¢\u0006\u0004\bE\u0010\bJ\u000f\u0010F\u001a\u00020\u0006H&¢\u0006\u0004\bF\u0010\bJ\u000f\u0010G\u001a\u00020\u0006H&¢\u0006\u0004\bG\u0010\bJ\u0019\u0010J\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0017\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bN\u0010OR$\u0010P\u001a\u0004\u0018\u00010H8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010KR\u0016\u0010V\u001a\u00020U8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lcom/baidu/nadcore/webview/container/AbsBrowserContainer;", "Lcom/baidu/tieba/ma1;", "Landroid/content/ComponentCallbacks;", "android/view/KeyEvent$Callback", "androidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback", "Lcom/baidu/tieba/h81;", "", "closeFrame", "()V", "", "status", "delayInit", "(Z)V", "doFinish", "Lcom/baidu/nadcore/webview/container/AbsBrowserContainer$ISuperFinish;", "superFinish", "finish", "(Lcom/baidu/nadcore/webview/container/AbsBrowserContainer$ISuperFinish;)V", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onAttachedToWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onCreate", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onKeyLongPress", "count", "onKeyMultiple", "(IILandroid/view/KeyEvent;)Z", "onKeyUp", "onLowMemory", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "Landroid/os/Bundle;", "savedInstanceState", "onPostCreate", "(Landroid/os/Bundle;)V", "onPreCreate", "", "monitorTag", "onPreInit", "(Ljava/lang/String;)V", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onStart", MissionEvent.MESSAGE_STOP, "pageBack", Headers.REFRESH, "Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCloseListener", "(Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;)V", "Landroid/view/View;", "view", "setContentView", "(Landroid/view/View;)V", "closeWindowListener", "Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", "getCloseWindowListener", "()Lcom/baidu/nadcore/webview/interfaces/ICloseWindowListener;", "setCloseWindowListener", "Lcom/baidu/nadcore/webview/interfaces/IFrameContext;", "frameContext", "Lcom/baidu/nadcore/webview/interfaces/IFrameContext;", "<init>", "(Lcom/baidu/nadcore/webview/interfaces/IFrameContext;)V", "ISuperFinish", "lib-webview_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class AbsBrowserContainer implements ma1, ComponentCallbacks, KeyEvent.Callback, ActivityCompat.OnRequestPermissionsResultCallback, h81 {
    public ja1 a;
    public final ka1 b;

    @Override // com.baidu.tieba.h81
    public abstract void i();

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // com.baidu.tieba.ma1
    public void onDestroy() {
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.baidu.tieba.ma1
    public void onPause() {
    }

    @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
    }

    public void r(int i, int i2, Intent intent) {
    }

    public void t() {
    }

    public void u() {
    }

    public void v(Intent intent) {
    }

    public void w() {
    }

    public void x() {
    }

    public void y() {
    }

    public AbsBrowserContainer(ka1 frameContext) {
        Intrinsics.checkNotNullParameter(frameContext, "frameContext");
        this.b = frameContext;
    }

    public void A(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        if (this.b.F()) {
            return;
        }
        getActivity().setContentView(view2);
    }

    public void z(ja1 ja1Var) {
        this.a = ja1Var;
    }

    public final Activity getActivity() {
        return this.b.getActivity();
    }

    @Override // com.baidu.tieba.h81
    public void k() {
        o();
    }

    public void o() {
        this.b.m();
    }

    public final ja1 p() {
        return this.a;
    }

    public final Intent q() {
        return this.b.getIntent();
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            i();
            return true;
        }
        return false;
    }
}
