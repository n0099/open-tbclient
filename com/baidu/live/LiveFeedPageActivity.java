package com.baidu.live;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.baidu.live.feedpage.interfaces.ILiveFeedPageInvoke;
import com.baidu.tieba.ab0;
import com.baidu.tieba.gb0;
import com.baidu.tieba.ld0;
import com.baidu.tieba.mb0;
import com.baidu.tieba.nd0;
/* loaded from: classes3.dex */
public class LiveFeedPageActivity extends AppCompatActivity {
    public ab0 a;
    public final int b = ld0.a().b();
    public Handler c;
    public int d;
    public float e;
    public float f;
    public float g;
    public float h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ab0 ab0Var = this.a;
        if (ab0Var != null) {
            ab0Var.T();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ab0 ab0Var = this.a;
        if (ab0Var != null) {
            ab0Var.a0();
            this.a.e0(false);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ab0 ab0Var = this.a;
        if (ab0Var != null) {
            ab0Var.b0();
            this.a.e0(true);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        if (motionEvent.getAction() == 0) {
            this.e = motionEvent.getX();
            this.f = motionEvent.getY();
            boolean z4 = false;
            if (mb0.g(this.a.z(), (int) this.e, (int) this.f) && !this.a.z().canScrollHorizontally(-1)) {
                z = true;
            } else {
                z = false;
            }
            this.i = z;
            if (mb0.g(this.a.C(), (int) this.e, (int) this.f) && !this.a.C().canScrollHorizontally(-1)) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.k = z2;
            if (mb0.g(this.a.B(), (int) this.e, (int) this.f) && !this.a.B().canScrollHorizontally(-1)) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.l = z3;
            if (mb0.g(this.a.D(), (int) this.e, (int) this.f) && this.a.P()) {
                z4 = true;
            }
            this.j = z4;
        }
        if (motionEvent.getAction() == 1) {
            this.g = motionEvent.getX();
            float y = motionEvent.getY();
            this.h = y;
            float f = this.g - this.e;
            float abs = Math.abs(y - this.f);
            if (f > this.d && f * 0.5d > abs) {
                if (this.i && !this.a.z().canScrollHorizontally(-1)) {
                    finish();
                } else if (this.j && this.a.P()) {
                    finish();
                } else if (this.k && !this.a.C().canScrollHorizontally(-1)) {
                    finish();
                } else if (this.l && !this.a.B().canScrollHorizontally(-1)) {
                    finish();
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String str;
        String str2;
        String str3;
        boolean z;
        nd0.g(this);
        super.onCreate(bundle);
        this.d = ViewConfiguration.get(this).getScaledTouchSlop();
        if (bundle != null) {
            finish();
        }
        final String str4 = null;
        if (getIntent() == null) {
            str = "";
            str2 = str;
            str3 = str2;
            z = false;
        } else {
            String stringExtra = getIntent().getStringExtra("source");
            str4 = getIntent().getStringExtra("scheme_next");
            String stringExtra2 = getIntent().getStringExtra("tab_extend_subtype");
            String stringExtra3 = getIntent().getStringExtra("tab_extend_thirdtype");
            str = stringExtra2;
            z = getIntent().getBooleanExtra("tab_extend_scroll_to_tab", false);
            str3 = stringExtra;
            str2 = stringExtra3;
        }
        ab0 ab0Var = new ab0(this, this.b, getSupportFragmentManager(), LiveFeedPageSdk.IMMERSION, str3, false, str, str2, z);
        this.a = ab0Var;
        setContentView(ab0Var.A());
        this.a.Q();
        gb0.u(this, str3, "chenjinshi");
        if (!TextUtils.isEmpty(str4)) {
            if (this.c == null) {
                this.c = new Handler();
            }
            this.c.postDelayed(new Runnable() { // from class: com.baidu.live.LiveFeedPageActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    ILiveFeedPageInvoke invoker = LiveFeedPageSdk.getInstance().getInvoker();
                    if (invoker != null) {
                        invoker.invokeScheme(LiveFeedPageActivity.this, str4);
                    }
                }
            }, 350L);
        }
    }
}
