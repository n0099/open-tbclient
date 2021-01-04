package com.baidu.searchbox.account.data;

import com.baidu.sapi2.SapiAccountManager;
import com.baidu.searchbox.account.contants.AccountConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class BoxAccount {
    private boolean addressSwitch;
    private int age;
    private boolean baijiahao;
    @Deprecated
    public String bduss;
    private String birthday;
    private String city;
    private String cityCode;
    @Deprecated
    public long deadline;
    @Deprecated
    public String displayname;
    private ErrorBean errorBean = new ErrorBean();
    @Deprecated
    public int expiryTime;
    private HashMap<String, String> extFields;
    private int gender;
    private String horoscope;
    @Deprecated
    public boolean incompleteUser;
    @Deprecated
    public boolean isInitialPortrait;
    @Deprecated
    public String isLay;
    private int level;
    @Deprecated
    public String nickname;
    @Deprecated
    public String portrait;
    @Deprecated
    public String portraitSign;
    private String province;
    private String provinceCode;
    @Deprecated
    public String ptoken;
    private boolean searchByInterestSwitch;
    private boolean searchByTelSwitch;
    private String signature;
    @Deprecated
    public String uid;
    private String uk;
    private int vip;

    public HashMap<String, String> getExtFields() {
        if (this.extFields == null) {
            this.extFields = new HashMap<>();
        }
        return this.extFields;
    }

    public void setExtFields(HashMap<String, String> hashMap) {
        this.extFields = hashMap;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String getUk() {
        return this.uk;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public String getDisplayname() {
        return this.displayname;
    }

    public void setDisplayname(String str) {
        this.displayname = str;
    }

    public String getBduss() {
        return this.bduss;
    }

    public void setBduss(String str) {
        this.bduss = str;
    }

    public String getPtoken() {
        return this.ptoken;
    }

    public void setPtoken(String str) {
        this.ptoken = str;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public String getPortraitSign() {
        return this.portraitSign;
    }

    public void setPortraitSign(String str) {
        this.portraitSign = str;
    }

    public boolean isInitialPortrait() {
        return this.isInitialPortrait;
    }

    public void setInitialPortrait(boolean z) {
        this.isInitialPortrait = z;
    }

    public boolean isIncompleteUser() {
        return this.incompleteUser;
    }

    public void setIncompleteUser(boolean z) {
        this.incompleteUser = z;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public long getDeadline() {
        return this.deadline;
    }

    public void setDeadline(long j) {
        this.deadline = j;
    }

    public String getIsLay() {
        return this.isLay;
    }

    public void setIsLay(String str) {
        this.isLay = str;
    }

    public int getExpiryTime() {
        return this.expiryTime;
    }

    public void setExpiryTime(int i) {
        this.expiryTime = i;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public int getVip() {
        return this.vip;
    }

    public void setVip(int i) {
        this.vip = i;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public boolean getBaijiahao() {
        return this.baijiahao;
    }

    public void setBaijiahao(boolean z) {
        this.baijiahao = z;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public String getHoroscope() {
        return this.horoscope;
    }

    public void setHoroscope(String str) {
        this.horoscope = str;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public boolean getSearchByTelSwitch() {
        return this.searchByTelSwitch;
    }

    public void setSearchByTelSwitch(boolean z) {
        this.searchByTelSwitch = z;
    }

    public boolean getSearchByInterestSwitch() {
        return this.searchByInterestSwitch;
    }

    public void setSearchByInterestSwitch(boolean z) {
        this.searchByInterestSwitch = z;
    }

    public boolean getAddressSwitch() {
        return this.addressSwitch;
    }

    public void setAddressSwitch(boolean z) {
        this.addressSwitch = z;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public void setProvinceCode(String str) {
        this.provinceCode = str;
    }

    public ErrorBean getErrorBean() {
        return this.errorBean;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BoxAccount boxAccount = (BoxAccount) obj;
        if (this.uid != null) {
            if (this.uid.equals(boxAccount.uid)) {
                return true;
            }
        } else if (boxAccount.uid == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.uid != null) {
            return this.uid.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "BoxAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', portrait='" + this.portrait + "', nickname='" + this.nickname + "'}";
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.uid);
            jSONObject.put(SapiAccountManager.SESSION_DISPLAYNAME, this.displayname);
            jSONObject.put("bduss", this.bduss);
            jSONObject.put("portrait", this.portrait);
            jSONObject.put("nickname", this.nickname);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getGenderText() {
        if (this.gender == 1) {
            return AccountConstants.MALE_TEXT;
        }
        if (this.gender == 0) {
            return AccountConstants.FEMALE_TEXT;
        }
        return null;
    }

    /* loaded from: classes15.dex */
    public class ErrorBean {
        private int errorCode;
        private String errorMsg;
        private String renickname;

        public ErrorBean() {
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(int i) {
            this.errorCode = i;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }

        public void setErrorMsg(String str) {
            this.errorMsg = str;
        }

        public String getRenickname() {
            return this.renickname;
        }

        public void setRenickname(String str) {
            this.renickname = str;
        }
    }
}
