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
    private final String boc = "actionType";
    private final String bod = "payUrl";
    private final String boe = "H5";
    private b bof;

    /* loaded from: classes11.dex */
    class a extends com.baidu.poly.a.a.a<Map<String, String>> {
        final /* synthetic */ l bnJ;
        final /* synthetic */ String boa;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.baidu.poly.a.i.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC0206a implements Runnable {
            final /* synthetic */ com.baidu.poly.widget.c bnX;
            final /* synthetic */ String bnY;

            RunnableC0206a(com.baidu.poly.widget.c cVar, String str) {
                this.bnX = cVar;
                this.bnY = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.baidu.poly.widget.c cVar = this.bnX;
                if (cVar != null && cVar.isShowing()) {
                    this.bnX.dismiss();
                }
                a.this.bnJ.a(0, this.bnY);
            }
        }

        a(String str, l lVar) {
            this.boa = str;
            this.bnJ = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.poly.a.a.a
        public void a(Map<String, String> map) {
            com.baidu.poly.a.g.c.bnF = map.get(CashierData.ORDERID);
            if (!map.containsKey("parentType")) {
                c.this.c(map, this.boa, this.bnJ);
                return;
            }
            String str = map.get("parentType");
            if (TextUtils.isEmpty(str)) {
                c.this.c(map, this.boa, this.bnJ);
            } else if (4 != Integer.parseInt(str)) {
                c.this.c(map, this.boa, this.bnJ);
            } else {
                String a = com.baidu.poly.util.a.a(0, map.get(CashierData.ORDERID), "Successful payment");
                com.baidu.poly.widget.c cVar = new com.baidu.poly.widget.c(View.inflate(this.bnJ.getContext(), b.f.pay_success, null), -1, -1, true);
                cVar.setClippingEnabled(false);
                cVar.setFocusable(false);
                cVar.setOutsideTouchable(false);
                cVar.showAtLocation(this.bnJ, 0, 0, 0);
                new Handler().postDelayed(new RunnableC0206a(cVar, a), 2000L);
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
            this.bnJ.a("launchpayment error msg is " + message);
            com.baidu.poly.a.g.c.a(new com.baidu.poly.a.g.a("1").fK(new com.baidu.poly.a.h.a("launchpayment error --> " + str, th).B()));
        }
    }

    public c(b bVar) {
        this.bof = bVar;
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
        this.bof.a(map, str, lVar);
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
        com.baidu.poly.a.b.a.KQ().a(bundle, new a(str, lVar), str);
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
