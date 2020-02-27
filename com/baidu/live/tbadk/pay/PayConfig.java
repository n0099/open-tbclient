package com.baidu.live.tbadk.pay;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.util.PageDialogHelper;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PayConfig {
    public static final int PAYTYPE_MEMBER = 1;
    public static final int PAYTYPE_PAY_DIRECT = 3;
    public static final int PAYTYPE_TDOU = 2;
    public static final int PAYTYPE_TYPE_CARDBOX = 4;
    public String from;
    private int isAutoPay;
    public String mClickZone;
    private int mFrom;
    private String mIsLeft;
    private boolean mIsPay;
    private boolean mIsPayDialog;
    private String mMoney;
    public String mOrderInfo;
    private String mOrderName;
    private PageDialogHelper.PayForm mPayForm;
    private int mPayType;
    private String mPropsId;
    private String mPropsMon;
    public String mReferPage;
    private String mTitle;
    public String paymentPosKey;
    private int tBeanNum;

    public boolean getIsPayDialog() {
        return this.mIsPayDialog;
    }

    public PayConfig() {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
    }

    public PayConfig(int i, String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, PageDialogHelper.PayForm payForm, String str6, String str7, String str8) {
        this.mOrderName = "";
        this.mTitle = "";
        this.mOrderInfo = "";
        this.paymentPosKey = "";
        this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
        this.mPayType = i;
        this.mIsLeft = str;
        this.mPropsId = str2;
        this.mMoney = str3;
        this.mPropsMon = str4;
        this.mIsPay = z;
        this.mOrderName = str5;
        this.mReferPage = str6;
        this.mClickZone = str7;
        this.from = str8;
        this.tBeanNum = Integer.parseInt(str5);
        payForm = payForm == null ? PageDialogHelper.PayForm.NOT_SET : payForm;
        if (payForm == PageDialogHelper.PayForm.NOT_SET) {
            this.mIsPayDialog = z2;
        } else if (payForm == PageDialogHelper.PayForm.NORMAL) {
            this.mIsPayDialog = false;
        } else if (payForm == PageDialogHelper.PayForm.DIALOG) {
            this.mIsPayDialog = true;
        }
    }

    public String getCompileToJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mPayType", this.mPayType);
            jSONObject.put("mFrom", this.mFrom);
            jSONObject.put("mPropsId", this.mPropsId);
            jSONObject.put("mMoney", this.mMoney);
            jSONObject.put("mIsLeft", this.mIsLeft);
            jSONObject.put("mPropsMon", this.mPropsMon);
            jSONObject.put("mIsPay", this.mIsPay);
            jSONObject.put("mOrderName", this.mOrderName);
            jSONObject.put("mTitle", this.mTitle);
            jSONObject.put("tBeanNum", this.tBeanNum);
            jSONObject.put("mOrderInfo", this.mOrderInfo);
            jSONObject.put("mIsPayDialog", this.mIsPayDialog);
            jSONObject.put("isAutoPay", this.isAutoPay);
            jSONObject.put("paymentPosKey", this.paymentPosKey);
            if (this.mPayForm != null) {
                jSONObject.put("mPayForm_name", this.mPayForm.name());
            }
            jSONObject.put("mReferPage", this.mReferPage);
            jSONObject.put("mClickZone", this.mClickZone);
            jSONObject.put("from", this.from);
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void parseJson(String str) {
        if (!StringUtils.isNull(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mPayType = jSONObject.optInt("mPayType");
                this.mFrom = jSONObject.optInt("mFrom");
                this.mPropsId = jSONObject.optString("mPropsId");
                this.mMoney = jSONObject.optString("mMoney");
                this.mIsLeft = jSONObject.optString("mIsLeft");
                this.mPropsMon = jSONObject.optString("mPropsMon");
                this.mIsPay = jSONObject.optBoolean("mIsPay");
                this.mOrderName = jSONObject.optString("mOrderName");
                this.mTitle = jSONObject.optString("mTitle");
                this.tBeanNum = jSONObject.optInt("tBeanNum");
                this.mOrderInfo = jSONObject.optString("mOrderInfo");
                this.mIsPayDialog = jSONObject.optBoolean("mIsPayDialog");
                this.isAutoPay = jSONObject.optInt("isAutoPay");
                this.paymentPosKey = jSONObject.optString("paymentPosKey");
                this.mPayForm = PageDialogHelper.PayForm.NOT_SET;
                String optString = jSONObject.optString("mPayForm_name");
                if (!StringUtils.isNull(optString)) {
                    this.mPayForm = PageDialogHelper.PayForm.valueOf(optString);
                }
                this.mReferPage = jSONObject.optString("mReferPage");
                this.mClickZone = jSONObject.optString("mClickZone");
                this.from = jSONObject.optString("from");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getPayType() {
        return this.mPayType;
    }

    public void setPayType(int i) {
        this.mPayType = i;
    }

    public String getPropsId() {
        return this.mPropsId;
    }

    public void setPropsId(String str) {
        this.mPropsId = str;
    }

    public String getMoney() {
        return this.mMoney;
    }

    public void setMoney(String str) {
        this.mMoney = str;
    }

    public String getIsLeft() {
        return this.mIsLeft;
    }

    public void setIsLeft(String str) {
        this.mIsLeft = str;
    }

    public String getPropsMon() {
        return this.mPropsMon;
    }

    public void setPropsMon(String str) {
        this.mPropsMon = str;
    }

    public boolean isIsPay() {
        return this.mIsPay;
    }

    public void setIsPay(boolean z) {
        this.mIsPay = z;
    }

    public String getOrderName() {
        return this.mOrderName;
    }

    public void setOrderName(String str) {
        this.mOrderName = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public int getTBeanNum() {
        return this.tBeanNum;
    }

    public void setTBeanNum(int i) {
        this.tBeanNum = i;
    }

    public int isAutoPay() {
        return this.isAutoPay;
    }

    public void setAutoPay(int i) {
        this.isAutoPay = i;
    }
}
