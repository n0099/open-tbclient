package com.baidu.pass.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.ecommerce.activity.GetContactActivty;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f4062b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.pass.ecommerce.b.a f4063a;

    /* renamed from: com.baidu.pass.ecommerce.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0275a implements com.baidu.pass.ecommerce.b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.ecommerce.b.a f4064a;

        C0275a(com.baidu.pass.ecommerce.b.a aVar) {
            this.f4064a = aVar;
        }

        @Override // com.baidu.pass.ecommerce.b.a
        public void onCall(com.baidu.pass.ecommerce.c.a aVar) {
            this.f4064a.onCall(aVar);
            a.this.b();
        }
    }

    /* loaded from: classes5.dex */
    class b extends PermissionsCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f4066a;

        b(Context context) {
            this.f4066a = context;
        }

        @Override // com.baidu.pass.permissions.PermissionsCallback
        public void onFailure(int i) {
            com.baidu.pass.ecommerce.c.a aVar = new com.baidu.pass.ecommerce.c.a();
            aVar.setResultCode(-901);
            a.this.f4063a.onCall(aVar);
        }

        @Override // com.baidu.pass.permissions.PermissionsCallback
        public void onSuccess() {
            Intent intent = new Intent(this.f4066a, GetContactActivty.class);
            Context context = this.f4066a;
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.f4066a.startActivity(intent);
        }
    }

    private a() {
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f4062b == null) {
                f4062b = new a();
            }
            aVar = f4062b;
        }
        return aVar;
    }

    public void b() {
        this.f4063a = null;
        f4062b = null;
    }

    public void a(Context context, com.baidu.pass.ecommerce.b.a aVar) {
        this.f4063a = new C0275a(aVar);
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = context;
        permissionsDTO.permissions = new String[]{"android.permission.READ_CONTACTS"};
        permissionsDTO.dialogTitle = "通讯录权限";
        permissionsDTO.dialogMsg = "如你选择通过通讯录添加收货人信息，则请允许" + SapiUtils.getAppName(context) + "使用通讯录权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new b(context));
    }

    public com.baidu.pass.ecommerce.b.a a() {
        return this.f4063a;
    }
}
