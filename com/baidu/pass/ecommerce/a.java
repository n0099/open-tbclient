package com.baidu.pass.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.ecommerce.activity.GetContactActivty;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes6.dex */
public class a {
    private static a b;
    private com.baidu.pass.ecommerce.b.a a;

    /* renamed from: com.baidu.pass.ecommerce.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0233a implements com.baidu.pass.ecommerce.b.a {
        final /* synthetic */ com.baidu.pass.ecommerce.b.a a;

        C0233a(com.baidu.pass.ecommerce.b.a aVar) {
            this.a = aVar;
        }

        @Override // com.baidu.pass.ecommerce.b.a
        public void onCall(com.baidu.pass.ecommerce.c.a aVar) {
            this.a.onCall(aVar);
            a.this.b();
        }
    }

    /* loaded from: classes6.dex */
    class b extends PermissionsCallback {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // com.baidu.pass.permissions.PermissionsCallback
        public void onFailure(int i) {
            com.baidu.pass.ecommerce.c.a aVar = new com.baidu.pass.ecommerce.c.a();
            aVar.setResultCode(-901);
            a.this.a.onCall(aVar);
        }

        @Override // com.baidu.pass.permissions.PermissionsCallback
        public void onSuccess() {
            Intent intent = new Intent(this.a, GetContactActivty.class);
            Context context = this.a;
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.a.startActivity(intent);
        }
    }

    private a() {
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public void b() {
        this.a = null;
        b = null;
    }

    public void a(Context context, com.baidu.pass.ecommerce.b.a aVar) {
        this.a = new C0233a(aVar);
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = context;
        permissionsDTO.permissions = new String[]{"android.permission.READ_CONTACTS"};
        permissionsDTO.dialogTitle = "通讯录权限";
        permissionsDTO.dialogMsg = "如你选择通过通讯录添加收货人信息，则请允许" + SapiUtils.getAppName(context) + "使用通讯录权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new b(context));
    }

    public com.baidu.pass.ecommerce.b.a a() {
        return this.a;
    }
}
