package com.baidu.poly.a.i;

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
import com.baidu.poly.widget.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bnJ;
    private long bnK;
    private com.baidu.poly.a.k.c bnL;
    private com.baidu.poly.widget.c bnM;
    private com.baidu.poly.widget.c bnN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0182a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ l bnE;
        final /* synthetic */ boolean bnF;
        final /* synthetic */ Context bnG;
        final /* synthetic */ Bundle bnH;

        C0182a(l lVar, boolean z, Context context, Bundle bundle) {
            this.bnE = lVar;
            this.bnF = z;
            this.bnG = context;
            this.bnH = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.b("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.bnE.a(0, com.baidu.poly.util.a.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.bnF) {
                a.this.a(this.bnG, this.bnH, this.bnE);
            } else {
                a.this.a(this.bnG, this.bnE);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.b("2", str);
            this.bnE.a("get trade state failed : " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ l bnE;

        b(l lVar) {
            this.bnE = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bnM.dismiss();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).fK("1"));
            this.bnE.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ l bnE;
        final /* synthetic */ Context bnG;
        final /* synthetic */ Bundle bnH;

        c(Context context, Bundle bundle, l lVar) {
            this.bnG = context;
            this.bnH = bundle;
            this.bnE = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.bnM.dismiss();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).fK("2"));
            a.this.a(this.bnG, this.bnH, this.bnE, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.bnN == null || !a.this.bnN.isShowing()) {
                return;
            }
            a.this.bnN.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements c.b {
        final /* synthetic */ l bnE;

        e(l lVar) {
            this.bnE = lVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.bnE.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a KZ() {
        if (bnJ == null) {
            synchronized (a.class) {
                if (bnJ == null) {
                    bnJ = new a();
                }
            }
        }
        return bnJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        com.baidu.poly.a.k.a.a(this.bnL);
        try {
            if (this.bnK != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.bnK);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).P(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.c.bos) {
                e2.printStackTrace();
            }
        } finally {
            this.bnK = 0L;
        }
    }

    public void a(Context context, Bundle bundle, l lVar, boolean z) {
        if (context != null && bundle != null && lVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.bnL = com.baidu.poly.a.k.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.bnK = System.currentTimeMillis();
            com.baidu.poly.a.b.a.KR().c(bundle, new C0182a(lVar, z, context, bundle));
        }
    }

    private View a(Activity activity) {
        if (activity == null || activity.getWindow() == null) {
            return null;
        }
        return activity.getWindow().getDecorView().findViewById(16908290);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Bundle bundle, l lVar) {
        View inflate = View.inflate(lVar.getContext(), b.f.pay_confirm, null);
        this.bnM = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bnM.setClippingEnabled(false);
        this.bnM.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(lVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, lVar));
        this.bnM.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, l lVar) {
        View inflate = View.inflate(lVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.bnN = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.bnN.setClippingEnabled(false);
        this.bnN.setOutsideTouchable(false);
        this.bnN.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.bnN.a(new e(lVar));
        this.bnN.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
