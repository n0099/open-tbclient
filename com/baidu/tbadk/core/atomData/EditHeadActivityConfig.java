package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.a;
/* loaded from: classes.dex */
public class EditHeadActivityConfig extends a {
    public static final String ACCOUNTDATA = "account_data";
    public static final String EDITTYPE = "edit_type";
    public static final String FROMCODE = "request";
    public static final int GROUP_PHOTO_WALL = 2;
    public static final int GROUP_TYPE = 1;
    public static final int PERSON_TYPE = 0;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String FILE_NAME = "file_name";

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, int i3, String str) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(FILE_NAME, str);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, int i3) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", i3);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", 0);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
