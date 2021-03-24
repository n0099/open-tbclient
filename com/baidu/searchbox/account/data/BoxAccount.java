package com.baidu.searchbox.account.data;

import com.baidu.searchbox.account.contants.AccountConstants;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class BoxAccount {
    public boolean addressSwitch;
    public int age;
    public boolean baijiahao;
    @Deprecated
    public String bduss;
    public String birthday;
    public String city;
    public String cityCode;
    @Deprecated
    public long deadline;
    @Deprecated
    public String displayname;
    public ErrorBean errorBean = new ErrorBean();
    @Deprecated
    public int expiryTime;
    public HashMap<String, String> extFields;
    public int gender;
    public String horoscope;
    @Deprecated
    public boolean incompleteUser;
    @Deprecated
    public boolean isInitialPortrait;
    @Deprecated
    public String isLay;
    public int level;
    @Deprecated
    public String nickname;
    @Deprecated
    public String portrait;
    @Deprecated
    public String portraitSign;
    public String province;
    public String provinceCode;
    @Deprecated
    public String ptoken;
    public boolean searchByInterestSwitch;
    public boolean searchByTelSwitch;
    public String signature;
    @Deprecated
    public String uid;
    public String uk;
    public int vip;

    /* loaded from: classes2.dex */
    public class ErrorBean {
        public int errorCode;
        public String errorMsg;
        public String renickname;

        public ErrorBean() {
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMsg() {
            return this.errorMsg;
        }

        public String getRenickname() {
            return this.renickname;
        }

        public void setErrorCode(int i) {
            this.errorCode = i;
        }

        public void setErrorMsg(String str) {
            this.errorMsg = str;
        }

        public void setRenickname(String str) {
            this.renickname = str;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BoxAccount.class != obj.getClass()) {
            return false;
        }
        String str = this.uid;
        String str2 = ((BoxAccount) obj).uid;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public boolean getAddressSwitch() {
        return this.addressSwitch;
    }

    public int getAge() {
        return this.age;
    }

    public boolean getBaijiahao() {
        return this.baijiahao;
    }

    public String getBduss() {
        return this.bduss;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getCity() {
        return this.city;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public long getDeadline() {
        return this.deadline;
    }

    public String getDisplayname() {
        return this.displayname;
    }

    public ErrorBean getErrorBean() {
        return this.errorBean;
    }

    public int getExpiryTime() {
        return this.expiryTime;
    }

    public HashMap<String, String> getExtFields() {
        if (this.extFields == null) {
            this.extFields = new HashMap<>();
        }
        return this.extFields;
    }

    public int getGender() {
        return this.gender;
    }

    public String getGenderText() {
        int i = this.gender;
        if (i == 1) {
            return AccountConstants.MALE_TEXT;
        }
        if (i == 0) {
            return AccountConstants.FEMALE_TEXT;
        }
        return null;
    }

    public String getHoroscope() {
        return this.horoscope;
    }

    public String getIsLay() {
        return this.isLay;
    }

    public int getLevel() {
        return this.level;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String getPortraitSign() {
        return this.portraitSign;
    }

    public String getProvince() {
        return this.province;
    }

    public String getProvinceCode() {
        return this.provinceCode;
    }

    public String getPtoken() {
        return this.ptoken;
    }

    public boolean getSearchByInterestSwitch() {
        return this.searchByInterestSwitch;
    }

    public boolean getSearchByTelSwitch() {
        return this.searchByTelSwitch;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUk() {
        return this.uk;
    }

    public int getVip() {
        return this.vip;
    }

    public int hashCode() {
        String str = this.uid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isIncompleteUser() {
        return this.incompleteUser;
    }

    public boolean isInitialPortrait() {
        return this.isInitialPortrait;
    }

    public void setAddressSwitch(boolean z) {
        this.addressSwitch = z;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void setBaijiahao(boolean z) {
        this.baijiahao = z;
    }

    public void setBduss(String str) {
        this.bduss = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setDeadline(long j) {
        this.deadline = j;
    }

    public void setDisplayname(String str) {
        this.displayname = str;
    }

    public void setErrorBean(ErrorBean errorBean) {
        this.errorBean = errorBean;
    }

    public void setExpiryTime(int i) {
        this.expiryTime = i;
    }

    public void setExtFields(HashMap<String, String> hashMap) {
        this.extFields = hashMap;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setHoroscope(String str) {
        this.horoscope = str;
    }

    public void setIncompleteUser(boolean z) {
        this.incompleteUser = z;
    }

    public void setInitialPortrait(boolean z) {
        this.isInitialPortrait = z;
    }

    public void setIsLay(String str) {
        this.isLay = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setPortrait(String str) {
        this.portrait = str;
    }

    public void setPortraitSign(String str) {
        this.portraitSign = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setProvinceCode(String str) {
        this.provinceCode = str;
    }

    public void setPtoken(String str) {
        this.ptoken = str;
    }

    public void setSearchByInterestSwitch(boolean z) {
        this.searchByInterestSwitch = z;
    }

    public void setSearchByTelSwitch(boolean z) {
        this.searchByTelSwitch = z;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setVip(int i) {
        this.vip = i;
    }

    public JSONObject toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.uid);
            jSONObject.put("displayname", this.displayname);
            jSONObject.put("bduss", this.bduss);
            jSONObject.put("portrait", this.portrait);
            jSONObject.put("nickname", this.nickname);
            return jSONObject;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return "BoxAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', portrait='" + this.portrait + "', nickname='" + this.nickname + "'}";
    }
}
