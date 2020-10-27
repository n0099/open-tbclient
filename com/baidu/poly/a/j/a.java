package com.baidu.poly.a.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.poly.b;
import com.baidu.poly.widget.c;
import com.baidu.poly.widget.m;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static volatile a bXk;
    private long bXl;
    private com.baidu.poly.a.l.c bXm;
    private com.baidu.poly.widget.c bXn;
    private com.baidu.poly.widget.c bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0294a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ m bXf;
        final /* synthetic */ boolean bXg;
        final /* synthetic */ Context bXh;
        final /* synthetic */ Bundle bXi;

        C0294a(m mVar, boolean z, Context context, Bundle bundle) {
            this.bXf = mVar;
            this.bXg = z;
            this.bXh = context;
            this.bXi = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.c("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.bXf.a(0, com.baidu.poly.util.b.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.bXg) {
                a.this.a(this.bXh, this.bXi, this.bXf);
            } else {
                a.this.a(this.bXh, this.bXf);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.c("2", str);
            this.bXf.a("get trade state failed : " + str, (String) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ m bXf;

        b(m mVar) {
            this.bXf = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bXn.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).jn("1"));
            this.bXf.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ m bXf;
        final /* synthetic */ Context bXh;
        final /* synthetic */ Bundle bXi;

        c(Context context, Bundle bundle, m mVar) {
            this.bXh = context;
            this.bXi = bundle;
            this.bXf = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bXn.dismiss();
            com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).jn("2"));
            a.this.a(this.bXh, this.bXi, this.bXf, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bXo == null || !a.this.bXo.isShowing()) {
                return;
            }
            a.this.bXo.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements c.b {
        final /* synthetic */ m bXf;

        e(m mVar) {
            this.bXf = mVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.bXf.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a YM() {
        if (bXk == null) {
            synchronized (a.class) {
                if (bXk == null) {
                    bXk = new a();
                }
            }
        }
        return bXk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        com.baidu.poly.a.l.a.a(this.bXm);
        try {
            if (this.bXl != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.bXl);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).an(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.d.bXT) {
                e2.printStackTrace();
            }
        } finally {
            this.bXl = 0L;
        }
    }

    public void a(Context context, Bundle bundle, m mVar, boolean z) {
        if (context != null && bundle != null && mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bXm = com.baidu.poly.a.l.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.bXl = System.currentTimeMillis();
            com.baidu.poly.a.b.b.Yt().c(bundle, new C0294a(mVar, z, context, bundle));
        }
    }

    private View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Bundle bundle, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.pay_confirm, null);
        this.bXn = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bXn.setClippingEnabled(false);
        this.bXn.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(mVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, mVar));
        this.bXn.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.h.d.a(new com.baidu.poly.a.h.b(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, m mVar) {
        View inflate = View.inflate(mVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.bXo = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bXo.setClippingEnabled(false);
        this.bXo.setOutsideTouchable(false);
        this.bXo.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.bXo.a(new e(mVar));
        this.bXo.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
