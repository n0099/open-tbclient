package com.baidu.sapi2.ecommerce.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.pass.ecommerce.ContactUtil;
import com.baidu.pass.ecommerce.result.GetContactResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.ToastUtil;
/* loaded from: classes2.dex */
public class GetContactActivty extends Activity {
    public static final int REQUEST_CODE_CONTACT = 4002;

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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 4002) {
            GetContactResult getContactResult = new GetContactResult();
            if (i2 == -1 && intent != null) {
                String[] phoneContacts = getPhoneContacts(intent.getData());
                String str = phoneContacts[0];
                getContactResult.name = str;
                getContactResult.phone = phoneContacts[1];
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(getContactResult.phone)) {
                    Toast.makeText(this, String.format("读取手机联系人失败，可能%1$s已被禁止该权限或手机号为空", SapiUtils.getAppName(this)), 0).show();
                    getContactResult.setResultCode(-901);
                } else {
                    getContactResult.setResultCode(0);
                }
            } else {
                getContactResult.setResultCode(-301);
            }
            ContactUtil.getInstance().getGetContactCallback().onCall(getContactResult);
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 4002);
        } catch (Exception unused) {
            ToastUtil.show("当前设备暂不支持");
            finish();
        }
    }
}
