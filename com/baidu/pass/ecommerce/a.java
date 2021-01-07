package com.baidu.pass.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.ecommerce.activity.GetContactActivty;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes15.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static a f4097b;

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.pass.ecommerce.b.a f4098a;

    /* renamed from: com.baidu.pass.ecommerce.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C0283a implements com.baidu.pass.ecommerce.b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.baidu.pass.ecommerce.b.a f4099a;

        C0283a(com.baidu.pass.ecommerce.b.a aVar) {
            this.f4099a = aVar;
        }

        @Override // com.baidu.pass.ecommerce.b.a
        public void onCall(com.baidu.pass.ecommerce.c.a aVar) {
            this.f4099a.onCall(aVar);
            a.this.b();
        }
    }

    /* loaded from: classes15.dex */
    class b extends PermissionsCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f4101a;

        b(Context context) {
            this.f4101a = context;
        }

        @Override // com.baidu.pass.permissions.PermissionsCallback
        public void onFailure(int i) {
            com.baidu.pass.ecommerce.c.a aVar = new com.baidu.pass.ecommerce.c.a();
            aVar.setResultCode(-901);
            a.this.f4098a.onCall(aVar);
        }

        @Override // com.baidu.pass.permissions.PermissionsCallback
        public void onSuccess() {
            Intent intent = new Intent(this.f4101a, GetContactActivty.class);
            Context context = this.f4101a;
            if (context instanceof Activity) {
                context.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.f4101a.startActivity(intent);
        }
    }

    private a() {
    }

    public static synchronized a c() {
        a aVar;
        synchronized (a.class) {
            if (f4097b == null) {
                f4097b = new a();
            }
            aVar = f4097b;
        }
        return aVar;
    }

    public void b() {
        this.f4098a = null;
        f4097b = null;
    }

    public void a(Context context, com.baidu.pass.ecommerce.b.a aVar) {
        this.f4098a = new C0283a(aVar);
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.context = context;
        permissionsDTO.permissions = new String[]{"android.permission.READ_CONTACTS"};
        permissionsDTO.dialogTitle = "通讯录权限";
        permissionsDTO.dialogMsg = "如你选择通过通讯录添加收货人信息，则请允许" + SapiUtils.getAppName(context) + "使用通讯录权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new b(context));
    }

    public com.baidu.pass.ecommerce.b.a a() {
        return this.f4098a;
    }
}
