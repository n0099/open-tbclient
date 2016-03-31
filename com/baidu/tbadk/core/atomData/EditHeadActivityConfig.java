package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.net.Uri;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.IntentAction;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes.dex */
public class EditHeadActivityConfig extends IntentConfig {
    public static final String ACCOUNTDATA = "account_data";
    public static final String CUT_IMAGE_HEIGHT_SCALE = "cut_image_height_scale";
    public static final String EDITTYPE = "edit_type";
    public static final String FROMCODE = "request";
    public static final String FROM_MISSON_SET_COVER = "from_misson_set_cover";
    public static final String FROM_PHOTO_LIVE = "from_photo_live";
    public static final String FROM_WHERE = "from_where";
    public static final int GROUP_PHOTO_WALL = 2;
    public static final int GROUP_TYPE = 1;
    public static final String NEED_UPLOAD = "need_upload";
    public static final int PERSON_TYPE = 0;
    public static final String UPLOAD_IMAGE_TYPE = "upload_image_type";
    public static final int UPLOAD_TYPE_NO = 0;
    public static final int UPLOAD_TYPE_RESET_PORTRAIT = 1;
    public static final int UPLOAD_TYPE_UPLOAD_ONLY = 2;
    public static String PHOTO_RESOURCE = "resourceid";
    public static String PIC_INFO = "pic_info";
    public static String FILE_NAME = "file_name";
    public static String ACTION_UPLOAD_SUCCESS = "upload.image.success";

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, int i3, String str, float f) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(FILE_NAME, str);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, int i3, String str, float f, boolean z) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(FILE_NAME, str);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f);
        getIntent().putExtra("need_upload", z);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, int i3, float f) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, float f) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", 0);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, float f, boolean z) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", 0);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f);
        getIntent().putExtra("need_upload", z);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, int i3, float f, String str) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f);
        getIntent().putExtra(FROM_WHERE, str);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }

    public EditHeadActivityConfig(Context context, int i, int i2, Uri uri, AccountData accountData, int i3, String str, float f, String str2) {
        super(context);
        getIntent().putExtra("request", i);
        getIntent().putExtra(ACCOUNTDATA, accountData);
        getIntent().putExtra("edit_type", i3);
        getIntent().putExtra(FILE_NAME, str);
        getIntent().putExtra(CUT_IMAGE_HEIGHT_SCALE, f);
        getIntent().putExtra(FROM_WHERE, str2);
        getIntent().setData(uri);
        setRequestCode(i2);
        setIntentAction(IntentAction.ActivityForResult);
    }
}
