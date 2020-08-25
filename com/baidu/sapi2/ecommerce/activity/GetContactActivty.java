package com.baidu.sapi2.ecommerce.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.pass.ecommerce.c.a;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes4.dex */
public class GetContactActivty extends Activity {
    private static final int REQUEST_CODE_CONTACT = 4002;

    private String[] getPhoneContacts(Uri uri) {
        String[] strArr = new String[2];
        Cursor query = getContentResolver().query(uri, null, null, null, null);
        if (query != null && query.moveToFirst()) {
            strArr[0] = query.getString(query.getColumnIndex("display_name"));
            strArr[1] = query.getString(query.getColumnIndex("data1"));
            query.close();
        }
        return strArr;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4002) {
            a aVar = new a();
            if (i2 == -1 && intent != null) {
                String[] phoneContacts = getPhoneContacts(intent.getData());
                aVar.a = phoneContacts[0];
                aVar.b = phoneContacts[1];
                if (TextUtils.isEmpty(aVar.a) && TextUtils.isEmpty(aVar.b)) {
                    Toast.makeText(this, String.format("读取手机联系人失败，可能%1$s已被禁止该权限或手机号为空", SapiUtils.getAppName(this)), 0).show();
                    aVar.setResultCode(-901);
                } else {
                    aVar.setResultCode(0);
                }
            } else {
                aVar.setResultCode(-301);
            }
            com.baidu.pass.ecommerce.a.c().a().onCall(aVar);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 4002);
    }
}
