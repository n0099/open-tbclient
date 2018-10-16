package com.baidu.searchbox.ng.ai.apps.contact;

import android.content.ContentValues;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.R;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ContactParams {
    public static final String KEY_ADDRESS_CITY = "addressCity";
    public static final String KEY_ADDRESS_COUNTRY = "addressCountry";
    public static final String KEY_ADDRESS_POSTAL_CODE = "addressPostalCode";
    public static final String KEY_ADDRESS_STATE = "addressState";
    public static final String KEY_ADDRESS_STREET = "addressStreet";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_FIRST_NAME = "firstName";
    public static final String KEY_HOME_ADDRESS_CITY = "homeAddressCity";
    public static final String KEY_HOME_ADDRESS_COUNTRY = "homeAddressCountry";
    public static final String KEY_HOME_ADDRESS_POSTAL_CODE = "homeAddressPostalCode";
    public static final String KEY_HOME_ADDRESS_STATE = "homeAddressState";
    public static final String KEY_HOME_ADDRESS_STREET = "homeAddressStreet";
    public static final String KEY_HOME_FAX_NUMBER = "homeFaxNumber";
    public static final String KEY_HOME_PHONE_NUMBER = "homePhoneNumber";
    public static final String KEY_HOST_NUMBER = "hostNumber";
    public static final String KEY_LAST_NAME = "lastName";
    public static final String KEY_MIDDLE_NAME = "middleName";
    public static final String KEY_MOBILE_PHONE_NUMBER = "mobilePhoneNumber";
    public static final String KEY_NICK_NAME = "nickName";
    public static final String KEY_ORGANIZATION = "organization";
    public static final String KEY_PHOTO_FILE_PATH = "photoFilePath";
    public static final String KEY_REMARK = "remark";
    public static final String KEY_TITLE = "title";
    public static final String KEY_URL = "url";
    public static final String KEY_WECHAT_NUMBER = "weChatNumber";
    public static final String KEY_WORK_ADDRESS_CITY = "workAddressCity";
    public static final String KEY_WORK_ADDRESS_COUNTRY = "workAddressCountry";
    public static final String KEY_WORK_ADDRESS_POSTAL_CODE = "workAddressPostalCode";
    public static final String KEY_WORK_ADDRESS_STATE = "workAddressState";
    public static final String KEY_WORK_ADDRESS_STREET = "workAddressStreet";
    public static final String KEY_WORK_FAX_NUMBER = "workFaxNumber";
    public static final String KEY_WORK_PHONE_NUMBER = "workPhoneNumber";
    public String addressCity;
    public String addressCountry;
    public String addressPostalCode;
    public String addressState;
    public String addressStreet;
    public String email;
    public String firstName;
    public String homeAddressCity;
    public String homeAddressCountry;
    public String homeAddressPostalCode;
    public String homeAddressState;
    public String homeAddressStreet;
    public String homeFaxNumber;
    public String homePhoneNumber;
    public String hostNumber;
    public String lastName;
    public String middleName;
    public String mobilePhoneNumber;
    public String nickName;
    public String organization;
    public String photoFilePath;
    public String remark;
    public String title;
    public String url;
    public String weChatNumber;
    public String workAddressCity;
    public String workAddressCountry;
    public String workAddressPostalCode;
    public String workAddressState;
    public String workAddressStreet;
    public String workFaxNumber;
    public String workPhoneNumber;

    public boolean isValid() {
        return !TextUtils.isEmpty(this.firstName);
    }

    public static ContactParams createFromJSON(JSONObject jSONObject) {
        ContactParams contactParams = new ContactParams();
        if (jSONObject != null) {
            contactParams.photoFilePath = jSONObject.optString(KEY_PHOTO_FILE_PATH);
            contactParams.nickName = jSONObject.optString(KEY_NICK_NAME);
            contactParams.lastName = jSONObject.optString(KEY_LAST_NAME);
            contactParams.middleName = jSONObject.optString(KEY_MIDDLE_NAME);
            contactParams.firstName = jSONObject.optString(KEY_FIRST_NAME);
            contactParams.remark = jSONObject.optString(KEY_REMARK);
            contactParams.mobilePhoneNumber = jSONObject.optString(KEY_MOBILE_PHONE_NUMBER);
            contactParams.weChatNumber = jSONObject.optString(KEY_WECHAT_NUMBER);
            contactParams.addressCountry = jSONObject.optString(KEY_ADDRESS_COUNTRY);
            contactParams.addressState = jSONObject.optString(KEY_ADDRESS_STATE);
            contactParams.addressCity = jSONObject.optString(KEY_ADDRESS_CITY);
            contactParams.addressStreet = jSONObject.optString(KEY_ADDRESS_STREET);
            contactParams.addressPostalCode = jSONObject.optString(KEY_ADDRESS_POSTAL_CODE);
            contactParams.organization = jSONObject.optString(KEY_ORGANIZATION);
            contactParams.title = jSONObject.optString("title");
            contactParams.workFaxNumber = jSONObject.optString(KEY_WORK_FAX_NUMBER);
            contactParams.workPhoneNumber = jSONObject.optString(KEY_WORK_PHONE_NUMBER);
            contactParams.hostNumber = jSONObject.optString(KEY_HOST_NUMBER);
            contactParams.email = jSONObject.optString("email");
            contactParams.url = jSONObject.optString("url");
            contactParams.workAddressCountry = jSONObject.optString(KEY_WORK_ADDRESS_COUNTRY);
            contactParams.workAddressState = jSONObject.optString(KEY_WORK_ADDRESS_STATE);
            contactParams.workAddressCity = jSONObject.optString(KEY_WORK_ADDRESS_CITY);
            contactParams.workAddressStreet = jSONObject.optString(KEY_WORK_ADDRESS_STREET);
            contactParams.workAddressPostalCode = jSONObject.optString(KEY_WORK_ADDRESS_POSTAL_CODE);
            contactParams.homeFaxNumber = jSONObject.optString(KEY_HOME_FAX_NUMBER);
            contactParams.homePhoneNumber = jSONObject.optString(KEY_HOME_PHONE_NUMBER);
            contactParams.homeAddressCountry = jSONObject.optString(KEY_HOME_ADDRESS_COUNTRY);
            contactParams.homeAddressState = jSONObject.optString(KEY_HOME_ADDRESS_STATE);
            contactParams.homeAddressCity = jSONObject.optString(KEY_HOME_ADDRESS_CITY);
            contactParams.homeAddressStreet = jSONObject.optString(KEY_HOME_ADDRESS_STREET);
            contactParams.homeAddressPostalCode = jSONObject.optString(KEY_HOME_ADDRESS_POSTAL_CODE);
        }
        return contactParams;
    }

    public String getDisplayName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.lastName)) {
            sb.append(this.lastName);
        }
        if (!TextUtils.isEmpty(this.middleName)) {
            sb.append(this.middleName);
        }
        if (!TextUtils.isEmpty(this.firstName)) {
            sb.append(this.firstName);
        }
        return sb.toString();
    }

    public ContentValues getNickNameData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.nickName);
        return contentValues;
    }

    public ContentValues getRemarkData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/note");
        contentValues.put("data1", this.remark);
        return contentValues;
    }

    public ContentValues getMobilePhoneNumberData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", this.mobilePhoneNumber);
        return contentValues;
    }

    public ContentValues getHomePhoneNumberData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.homePhoneNumber);
        return contentValues;
    }

    public ContentValues getWorkPhoneNumberData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", this.workPhoneNumber);
        return contentValues;
    }

    public ContentValues getHostNumberData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 10);
        contentValues.put("data1", this.hostNumber);
        return contentValues;
    }

    public ContentValues getHomeFaxNumberData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 5);
        contentValues.put("data1", this.homeFaxNumber);
        return contentValues;
    }

    public ContentValues getWorkFaxNumberData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data2", (Integer) 4);
        contentValues.put("data1", this.workFaxNumber);
        return contentValues;
    }

    public ContentValues getWeChatNumberData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/im");
        contentValues.put("data5", (Integer) (-1));
        contentValues.put("data6", AppRuntime.getAppContext().getString(R.string.aiapps_cantact_wechat_lable));
        contentValues.put("data1", this.weChatNumber);
        return contentValues;
    }

    public ContentValues getOrganizationData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/organization");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.organization);
        contentValues.put("data4", this.title);
        return contentValues;
    }

    public ContentValues getUrlData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/website");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", this.url);
        return contentValues;
    }

    public ContentValues getAddressData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 3);
        contentValues.put("data1", getAddressName());
        contentValues.put("data9", this.addressPostalCode);
        return contentValues;
    }

    public ContentValues getWorkAddressData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 2);
        contentValues.put("data1", getWorkAddressName());
        contentValues.put("data9", this.workAddressPostalCode);
        return contentValues;
    }

    public ContentValues getHomeAddressData() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
        contentValues.put("data2", (Integer) 1);
        contentValues.put("data1", getHomeAddressName());
        contentValues.put("data9", this.homeAddressPostalCode);
        return contentValues;
    }

    public String getHomeAddressName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.homeAddressCountry)) {
            sb.append(this.homeAddressCountry);
        }
        if (!TextUtils.isEmpty(this.homeAddressState)) {
            sb.append(this.homeAddressState);
        }
        if (!TextUtils.isEmpty(this.homeAddressCity)) {
            sb.append(this.homeAddressCity);
        }
        if (!TextUtils.isEmpty(this.homeAddressStreet)) {
            sb.append(this.homeAddressStreet);
        }
        if (!TextUtils.isEmpty(this.homeAddressPostalCode)) {
            sb.append(" ").append(this.homeAddressPostalCode);
        }
        return sb.toString();
    }

    public String getWorkAddressName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.workAddressCountry)) {
            sb.append(this.workAddressCountry);
        }
        if (!TextUtils.isEmpty(this.workAddressState)) {
            sb.append(this.workAddressState);
        }
        if (!TextUtils.isEmpty(this.workAddressCity)) {
            sb.append(this.workAddressCity);
        }
        if (!TextUtils.isEmpty(this.workAddressStreet)) {
            sb.append(this.workAddressStreet);
        }
        if (!TextUtils.isEmpty(this.workAddressPostalCode)) {
            sb.append(" ").append(this.workAddressPostalCode);
        }
        return sb.toString();
    }

    public String getAddressName() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.addressCountry)) {
            sb.append(this.addressCountry);
        }
        if (!TextUtils.isEmpty(this.addressState)) {
            sb.append(this.addressState);
        }
        if (!TextUtils.isEmpty(this.addressCity)) {
            sb.append(this.addressCity);
        }
        if (!TextUtils.isEmpty(this.addressStreet)) {
            sb.append(this.addressStreet);
        }
        if (!TextUtils.isEmpty(this.addressPostalCode)) {
            sb.append(" ").append(this.addressPostalCode);
        }
        return sb.toString();
    }
}
