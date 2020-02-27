package com.baidu.poly.a.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.baidu.poly.b;
import com.baidu.poly.widget.PayWebActivity;
import com.baidu.poly.widget.l;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    private final String EXTRA_DATA = CashierData.EXT_DATA;
    private final String aRF = "actionType";
    private final String aRG = "payUrl";
    private final String aRH = "H5";
    private b aRI;

    /* loaded from: classes11.dex */
    class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ String aRD;
        final /* synthetic */ l aRm;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.poly.a.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC0160a implements Runnable {
            final /* synthetic */ com.baidu.poly.widget.c aRA;
            final /* synthetic */ String aRB;

            RunnableC0160a(com.baidu.poly.widget.c cVar, String str) {
                this.aRA = cVar;
                this.aRB = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.poly.widget.c cVar = this.aRA;
                if (cVar != null && cVar.isShowing()) {
                    this.aRA.dismiss();
                }
                a.this.aRm.a(0, this.aRB);
            }
        }

        a(String str, l lVar) {
            this.aRD = str;
            this.aRm = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            com.baidu.poly.a.g.c.aRi = map.get(CashierData.ORDERID);
            if (!map.containsKey("parentType")) {
                c.this.c(map, this.aRD, this.aRm);
                return;
            }
            String str = map.get("parentType");
            if (TextUtils.isEmpty(str)) {
                c.this.c(map, this.aRD, this.aRm);
            } else if (4 != Integer.parseInt(str)) {
                c.this.c(map, this.aRD, this.aRm);
            } else {
                String a = com.baidu.poly.util.a.a(0, map.get(CashierData.ORDERID), "Successful payment");
                com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(View.inflate(this.aRm.getContext(), b.f.pay_success, null), -1, -1, true);
                cVar.setClippingEnabled(false);
                cVar.setFocusable(false);
                cVar.setOutsideTouchable(false);
                cVar.showAtLocation(this.aRm, 0, 0, 0);
                new Handler().postDelayed(new RunnableC0160a(cVar, a), 2000L);
                com.baidu.poly.util.c.info("WalletList->pay() 命中0单元");
            }
        }

        @Override // com.baidu.poly.a.a.a
        public void a(Throwable th, String str) {
            String message;
            if (str != null) {
                message = str;
            } else {
                message = th != null ? th.getMessage() : null;
            }
            this.aRm.a("launchpayment error msg is " + message);
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("1").eQ(new com.baidu.poly.a.h.a("launchpayment error --> " + str, th).B()));
        }
    }

    public c(b bVar) {
        this.aRI = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, String> map, String str, l lVar) {
        String str2 = map.get(CashierData.EXT_DATA);
        if (!TextUtils.isEmpty(str2)) {
            try {
                if (TextUtils.equals(new JSONObject(str2).optString("actionType"), "H5")) {
                    String str3 = map.get("payUrl");
                    if (!TextUtils.isEmpty(str3)) {
                        if (d(lVar.getContext())) {
                            lVar.setWechatH5Pay(true);
                            lVar.setIsPreparePaying(false);
                            a((Activity) lVar.getContext(), str3, map);
                        } else {
                            Toast.makeText(lVar.getContext(), "您没有安装微信，请选择其他支付方式", 0).show();
                            lVar.a(3, "wx_not_installed");
                        }
                    } else {
                        lVar.a("H5 no corresponding url ");
                    }
                }
            } catch (Exception e) {
                lVar.a("launchpayment extData analyze failed ");
                return;
            }
        }
        this.aRI.a(map, str, lVar);
    }

    private boolean d(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mm")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void b(Bundle bundle, String str, l lVar) {
        com.baidu.poly.a.b.a.Ey().a(bundle, new a(str, lVar), str);
    }

    private void a(Activity activity, String str, Map<String, String> map) {
        if (activity == null || TextUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent(activity, PayWebActivity.class);
        intent.putExtra("load_url", str);
        Bundle bundle = new Bundle();
        for (String str2 : map.keySet()) {
            bundle.putString(str2, map.get(str2));
        }
        intent.putExtra("launch_payment_data", bundle);
        activity.startActivityForResult(intent, 200);
    }
}
