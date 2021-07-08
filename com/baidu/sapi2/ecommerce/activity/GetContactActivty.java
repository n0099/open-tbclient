package com.baidu.sapi2.ecommerce.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.ContactUtil;
import com.baidu.pass.ecommerce.result.GetContactResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class GetContactActivty extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_CODE_CONTACT = 4002;
    public transient /* synthetic */ FieldHolder $fh;

    public GetContactActivty() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String[] getPhoneContacts(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, uri)) == null) {
            String[] strArr = new String[2];
            Cursor query = getContentResolver().query(uri, null, null, null, null);
            if (query != null && query.moveToFirst()) {
                strArr[0] = query.getString(query.getColumnIndex("display_name"));
                strArr[1] = query.getString(query.getColumnIndex("data1"));
                query.close();
            }
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 4002) {
                GetContactResult getContactResult = new GetContactResult();
                if (i3 == -1 && intent != null) {
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
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 4002);
        }
    }
}
