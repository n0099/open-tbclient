package com.baidu.swan.bdprivate.invoice.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class InvoiceInfo implements Parcelable, c {
    public static final int COMPANY = 0;
    public static final Parcelable.Creator<InvoiceInfo> CREATOR = new Parcelable.Creator<InvoiceInfo>() { // from class: com.baidu.swan.bdprivate.invoice.model.InvoiceInfo.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: D */
        public InvoiceInfo createFromParcel(Parcel parcel) {
            return new InvoiceInfo(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: hu */
        public InvoiceInfo[] newArray(int i) {
            return new InvoiceInfo[i];
        }
    };
    public static final int DEFAULT = 1;
    public static final String KEY_BANK_ACCOUNT = "bank_account";
    public static final String KEY_BANK_NAME = "bank_name";
    public static final String KEY_COMPANY_ADDRESS = "company_address";
    private static final String KEY_ID = "id";
    private static final String KEY_IS_DEFAULT = "is_default";
    public static final String KEY_TAX_NUMBER = "tax_number";
    public static final String KEY_TELEPHONE = "telephone";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TYPE = "type";
    public static final int NOT_DEFAULT = 0;
    public static final int PERSONAL = 1;
    public static final String REG_NON_EMPTY = "\\S+$";
    public String mBankAccount;
    public String mBankName;
    public String mCompanyAddress;
    public long mId;
    public int mIsDefault;
    public String mTaxNumber;
    public String mTelephone;
    public String mTitle;
    public int mType;

    public InvoiceInfo() {
    }

    public InvoiceInfo(int i, String str, String str2, String str3, String str4, String str5, String str6) {
        this.mType = i;
        this.mTitle = str;
        this.mTaxNumber = str2;
        this.mCompanyAddress = str3;
        this.mTelephone = str4;
        this.mBankName = str5;
        this.mBankAccount = str6;
    }

    public InvoiceInfo(int i, String str, String str2) {
        this.mType = i;
        this.mTitle = str;
        this.mTelephone = str2;
    }

    private InvoiceInfo(Parcel parcel) {
        this.mId = parcel.readLong();
        this.mType = parcel.readInt();
        this.mTitle = parcel.readString();
        this.mTaxNumber = parcel.readString();
        this.mCompanyAddress = parcel.readString();
        this.mTelephone = parcel.readString();
        this.mBankName = parcel.readString();
        this.mBankAccount = parcel.readString();
        this.mIsDefault = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mId);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mTaxNumber);
        parcel.writeString(this.mCompanyAddress);
        parcel.writeString(this.mTelephone);
        parcel.writeString(this.mBankName);
        parcel.writeString(this.mBankAccount);
        parcel.writeInt(this.mIsDefault);
    }

    public InvoiceInfo c(InvoiceInfo invoiceInfo) {
        if (invoiceInfo != null) {
            this.mId = invoiceInfo.mId;
            this.mIsDefault = invoiceInfo.mIsDefault;
        }
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof InvoiceInfo) && ((InvoiceInfo) obj).mId == this.mId;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.mId);
            jSONObject.put("type", this.mType);
            jSONObject.put("title", this.mTitle);
            jSONObject.put(KEY_TAX_NUMBER, this.mTaxNumber);
            jSONObject.put(KEY_COMPANY_ADDRESS, this.mCompanyAddress);
            jSONObject.put(KEY_TELEPHONE, this.mTelephone);
            jSONObject.put(KEY_BANK_NAME, this.mBankName);
            jSONObject.put(KEY_BANK_ACCOUNT, this.mBankAccount);
            jSONObject.put(KEY_IS_DEFAULT, this.mIsDefault);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.swan.bdprivate.invoice.model.c
    public void bg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mId = jSONObject.optLong("id");
            this.mType = jSONObject.optInt("type");
            this.mTitle = jSONObject.optString("title");
            this.mTaxNumber = jSONObject.optString(KEY_TAX_NUMBER);
            this.mCompanyAddress = jSONObject.optString(KEY_COMPANY_ADDRESS);
            this.mTelephone = jSONObject.optString(KEY_TELEPHONE);
            this.mBankName = jSONObject.optString(KEY_BANK_NAME);
            this.mBankAccount = jSONObject.optString(KEY_BANK_ACCOUNT);
            this.mIsDefault = jSONObject.optInt(KEY_IS_DEFAULT);
        }
    }
}
