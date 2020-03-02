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
    private static volatile a aRs;
    private long aRt;
    private com.baidu.poly.a.k.c aRu;
    private com.baidu.poly.widget.c aRv;
    private com.baidu.poly.widget.c aRw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0158a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ l aRn;
        final /* synthetic */ boolean aRo;
        final /* synthetic */ Context aRp;
        final /* synthetic */ Bundle aRq;

        C0158a(l lVar, boolean z, Context context, Bundle bundle) {
            this.aRn = lVar;
            this.aRo = z;
            this.aRp = context;
            this.aRq = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.b("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.aRn.a(0, com.baidu.poly.util.a.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.aRo) {
                a.this.a(this.aRp, this.aRq, this.aRn);
            } else {
                a.this.a(this.aRp, this.aRn);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.b("2", str);
            this.aRn.a("get trade state failed : " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ l aRn;

        b(l lVar) {
            this.aRn = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.aRv.dismiss();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).eQ("1"));
            this.aRn.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ l aRn;
        final /* synthetic */ Context aRp;
        final /* synthetic */ Bundle aRq;

        c(Context context, Bundle bundle, l lVar) {
            this.aRp = context;
            this.aRq = bundle;
            this.aRn = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.aRv.dismiss();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).eQ("2"));
            a.this.a(this.aRp, this.aRq, this.aRn, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aRw == null || !a.this.aRw.isShowing()) {
                return;
            }
            a.this.aRw.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements c.b {
        final /* synthetic */ l aRn;

        e(l lVar) {
            this.aRn = lVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.aRn.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a EJ() {
        if (aRs == null) {
            synchronized (a.class) {
                if (aRs == null) {
                    aRs = new a();
                }
            }
        }
        return aRs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        com.baidu.poly.a.k.a.a(this.aRu);
        try {
            if (this.aRt != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.aRt);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).J(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.c.aSc) {
                e2.printStackTrace();
            }
        } finally {
            this.aRt = 0L;
        }
    }

    public void a(Context context, Bundle bundle, l lVar, boolean z) {
        if (context != null && bundle != null && lVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.aRu = com.baidu.poly.a.k.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.aRt = System.currentTimeMillis();
            com.baidu.poly.a.b.a.EA().c(bundle, new C0158a(lVar, z, context, bundle));
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
        this.aRv = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.aRv.setClippingEnabled(false);
        this.aRv.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(lVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, lVar));
        this.aRv.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, l lVar) {
        View inflate = View.inflate(lVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.aRw = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.aRw.setClippingEnabled(false);
        this.aRw.setOutsideTouchable(false);
        this.aRw.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.aRw.a(new e(lVar));
        this.aRw.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
