package com.baidu.pass.ecommerce;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.pass.ecommerce.callback.GetContactCallback;
import com.baidu.pass.ecommerce.result.GetContactResult;
import com.baidu.pass.permissions.PassPermissions;
import com.baidu.pass.permissions.PermissionsCallback;
import com.baidu.pass.permissions.PermissionsDTO;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.ecommerce.activity.GetContactActivty;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.data.SmallTailInfo;
/* loaded from: classes3.dex */
public class ContactUtil {
    public static ContactUtil instance;
    public GetContactCallback getContactCallback;

    public static synchronized ContactUtil getInstance() {
        ContactUtil contactUtil;
        synchronized (ContactUtil.class) {
            if (instance == null) {
                instance = new ContactUtil();
            }
            contactUtil = instance;
        }
        return contactUtil;
    }

    public GetContactCallback getGetContactCallback() {
        return this.getContactCallback;
    }

    public void release() {
        this.getContactCallback = null;
        instance = null;
    }

    public static String hidePhoneNumber(String str) {
        if (str.length() <= 0) {
            return "";
        }
        if (str.length() == 11 && str.startsWith("1")) {
            return new StringBuilder(str).replace(3, 9, "******").toString();
        }
        if (str.length() == 14 && str.startsWith("+861")) {
            return new StringBuilder(str).replace(6, 12, "******").toString();
        }
        if (str.length() < 7) {
            return str;
        }
        int indexOf = str.indexOf(SmallTailInfo.EMOTION_SUFFIX);
        if (indexOf != -1 && ((str.length() - indexOf) + 1 == 8 || (str.length() - indexOf) + 1 == 7)) {
            return new StringBuilder(str).replace(indexOf, str.length() - 3, "*****").toString();
        }
        return new StringBuilder(str).replace(0, str.length() - 3, "*****").toString();
    }

    public void requestContact(final Context context, final GetContactCallback getContactCallback) {
        boolean z;
        this.getContactCallback = new GetContactCallback() { // from class: com.baidu.pass.ecommerce.ContactUtil.1
            @Override // com.baidu.pass.ecommerce.callback.GetContactCallback
            public void onCall(GetContactResult getContactResult) {
                getContactCallback.onCall(getContactResult);
                ContactUtil.this.release();
            }
        };
        if (!SapiAccountManager.getInstance().getConfignation().isNightMode && !SapiAccountManager.getInstance().getConfignation().isDarkMode) {
            z = false;
        } else {
            z = true;
        }
        PermissionsDTO permissionsDTO = new PermissionsDTO();
        permissionsDTO.isDarkMode = z;
        permissionsDTO.context = context.getApplicationContext();
        permissionsDTO.permissions = new String[]{"android.permission.READ_CONTACTS"};
        permissionsDTO.dialogTitle = "通讯录权限";
        permissionsDTO.dialogMsg = "如你选择通过通讯录添加联系人信息，则请允许" + SapiUtils.getAppName(context) + "使用通讯录权限。你可以通过系统\"设置\"进行权限的管理";
        PassPermissions.getInstance().requestPermissions(permissionsDTO, new PermissionsCallback() { // from class: com.baidu.pass.ecommerce.ContactUtil.2
            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onFailure(int i) {
                GetContactResult getContactResult = new GetContactResult();
                getContactResult.setResultCode(-901);
                ContactUtil.this.getContactCallback.onCall(getContactResult);
            }

            @Override // com.baidu.pass.permissions.PermissionsCallback
            public void onSuccess() {
                Intent intent = new Intent(context, GetContactActivty.class);
                Context context2 = context;
                if (context2 instanceof Activity) {
                    context2.startActivity(intent);
                    return;
                }
                intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                context.startActivity(intent);
            }
        });
    }
}
