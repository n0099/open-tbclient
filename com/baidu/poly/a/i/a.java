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
    private static volatile a aRt;
    private long aRu;
    private com.baidu.poly.a.k.c aRv;
    private com.baidu.poly.widget.c aRw;
    private com.baidu.poly.widget.c aRx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.poly.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0158a extends com.baidu.poly.a.a.a<JSONObject> {
        final /* synthetic */ l aRo;
        final /* synthetic */ boolean aRp;
        final /* synthetic */ Context aRq;
        final /* synthetic */ Bundle aRr;

        C0158a(l lVar, boolean z, Context context, Bundle bundle) {
            this.aRo = lVar;
            this.aRp = z;
            this.aRq = context;
            this.aRr = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(JSONObject jSONObject) {
            int optInt = jSONObject.optInt("payStatus", 3);
            a.this.b("1", String.valueOf(optInt));
            if (optInt == 2) {
                this.aRo.a(0, com.baidu.poly.util.a.a(0, jSONObject.optString("payOrderNo"), jSONObject.optString("msg")));
            } else if (this.aRp) {
                a.this.a(this.aRq, this.aRr, this.aRo);
            } else {
                a.this.a(this.aRq, this.aRo);
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            a.this.b("2", str);
            this.aRo.a("get trade state failed : " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        final /* synthetic */ l aRo;

        b(l lVar) {
            this.aRo = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.aRw.dismiss();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).eQ("1"));
            this.aRo.a(3, "pay failed , click choose window");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements View.OnClickListener {
        final /* synthetic */ l aRo;
        final /* synthetic */ Context aRq;
        final /* synthetic */ Bundle aRr;

        c(Context context, Bundle bundle, l lVar) {
            this.aRq = context;
            this.aRr = bundle;
            this.aRo = lVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.aRw.dismiss();
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY).eQ("2"));
            a.this.a(this.aRq, this.aRr, this.aRo, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.aRx == null || !a.this.aRx.isShowing()) {
                return;
            }
            a.this.aRx.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class e implements c.b {
        final /* synthetic */ l aRo;

        e(l lVar) {
            this.aRo = lVar;
        }

        @Override // com.baidu.poly.widget.c.b
        public void onDismiss() {
            this.aRo.a(3, "pay failed , click error window");
        }
    }

    private a() {
    }

    public static a EJ() {
        if (aRt == null) {
            synchronized (a.class) {
                if (aRt == null) {
                    aRt = new a();
                }
            }
        }
        return aRt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        com.baidu.poly.a.k.a.a(this.aRv);
        try {
            if (this.aRu != 0) {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("rt", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("msg", str2);
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis() - this.aRu);
                if (valueOf.longValue() >= 0) {
                    jSONObject.put("du", String.valueOf(valueOf));
                }
                com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN).J(jSONObject));
            }
        } catch (JSONException e2) {
            if (com.baidu.poly.util.c.aSd) {
                e2.printStackTrace();
            }
        } finally {
            this.aRu = 0L;
        }
    }

    public void a(Context context, Bundle bundle, l lVar, boolean z) {
        if (context != null && bundle != null && lVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.aRv = com.baidu.poly.a.k.a.a((ViewGroup) a((Activity) context), layoutParams, (String) null, -1L);
            this.aRu = System.currentTimeMillis();
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
        this.aRw = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.aRw.setClippingEnabled(false);
        this.aRw.setOutsideTouchable(false);
        ((TextView) inflate.findViewById(b.e.bt_pay_meet_problems)).setOnClickListener(new b(lVar));
        ((TextView) inflate.findViewById(b.e.bt_pay_already_finish)).setOnClickListener(new c(context, bundle, lVar));
        this.aRw.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
        com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a(TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, l lVar) {
        View inflate = View.inflate(lVar.getContext(), b.f.default_pop_window, null);
        ((TextView) inflate.findViewById(b.e.pop_title)).setText(b.g.pay_failed);
        ((TextView) inflate.findViewById(b.e.pop_tips)).setText(b.g.pay_failed_sub_text);
        this.aRx = new com.baidu.poly.widget.c(inflate, -1, -1, true);
        this.aRx.setClippingEnabled(false);
        this.aRx.setOutsideTouchable(false);
        this.aRx.setBackgroundDrawable(new ColorDrawable(0));
        ((TextView) inflate.findViewById(b.e.pop_button)).setOnClickListener(new d());
        this.aRx.a(new e(lVar));
        this.aRx.showAtLocation(((Activity) context).getWindow().getDecorView(), 0, 0, 0);
    }
}
