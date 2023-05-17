package com.baidu.searchbox.account.data;

import android.text.TextUtils;
import com.baidu.searchbox.account.contants.AccountConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class BoxAccount {
    public static final String ARTICLE_TRUE = "1";
    public static final String MEMBER_VIP_TRUE = "1";
    public static Map<String, List<String>> stokenMapping;
    public boolean addressSwitch;
    public int age;
    public boolean attentionFansSwitch;
    public String avatarBig;
    public String bcArticle;
    @Deprecated
    public String bduss;
    public String birthday;
    public String city;
    public String cityCode;
    @Deprecated
    public long deadline;
    @Deprecated
    public String displayname;
    @Deprecated
    public String dynamicPortrait;
    @Deprecated
    public int expiryTime;
    public HashMap<String, String> extFields;
    public String firstDistributeNickname;
    public int firstPopType;
    public int gender;
    public String guideNickDialogInterval;
    public String headTag;
    public String horoscope;
    @Deprecated
    public boolean incompleteUser;
    public boolean isChildAccount;
    public boolean isDefaultNick;
    @Deprecated
    public boolean isInitialPortrait;
    @Deprecated
    public String isLay;
    public boolean isShowAge;
    public boolean isShowCity;
    public boolean isShowGender;
    public boolean isShowStar;
    public int level;
    public long memberEndTime;
    public String memberVip;
    public boolean newFlag;
    public long nickModifyDuration;
    public int nickModifyTimes;
    @Deprecated
    public String nickname;
    public int operateWidgetNum;
    public String ornament;
    public String ornamentId;
    public String popType;
    @Deprecated
    public String portrait;
    @Deprecated
    public String portraitSign;
    public String province;
    public String provinceCode;
    @Deprecated
    public String ptoken;
    public String recommendNick;
    public boolean searchByInterestSwitch;
    public boolean searchByTelSwitch;
    public boolean showComment;
    public int showType;
    public String signature;
    @Deprecated
    public String uid;
    public String uk;
    public String userType;
    public int userWidgetNum;
    public int vip;
    public int widgetNum;
    public Audit nickNameAudit = new Audit();
    public Audit signatureAudit = new Audit();
    public ErrorBean errorBean = new ErrorBean();

    /* loaded from: classes3.dex */
    public class Audit {
        public String data;
        public int status;

        public Audit() {
        }

        public Audit parse(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.status = jSONObject.optInt("status");
                this.data = jSONObject.optString("data");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return this;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setStatus(int i) {
            this.status = i;
        }

        public String getData() {
            return this.data;
        }

        public int getStatus() {
            return this.status;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", this.data);
                jSONObject.put("status", this.status);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }
    }

    /* loaded from: classes3.dex */
    public class ErrorBean {
        public String currentVocation;
        public int errorCode;
        public String errorMsg;
        public String renickname;
        public String vocation;
        public String vocationUrl;

        public ErrorBean() {
        }

        public void setCurrentVocation(String str) {
            this.currentVocation = str;
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

        public void setVocation(String str) {
            this.vocation = str;
        }

        public void setVocationUrl(String str) {
            this.vocationUrl = str;
        }

        public String getCurrentVocation() {
            return this.currentVocation;
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

        public String getVocation() {
            return this.vocation;
        }

        public String getVocationUrl() {
            return this.vocationUrl;
        }
    }

    public boolean getAddressSwitch() {
        return this.addressSwitch;
    }

    public int getAge() {
        return this.age;
    }

    public boolean getAttentionFansSwitch() {
        return this.attentionFansSwitch;
    }

    public String getAvatarBig() {
        return this.avatarBig;
    }

    public String getBCArticle() {
        return this.bcArticle;
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

    public String getDynamicPortrait() {
        return this.dynamicPortrait;
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

    public String getFirstDistributeNickname() {
        return this.firstDistributeNickname;
    }

    public int getFirstPopType() {
        return this.firstPopType;
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

    public long getGuideNickDialogInterval() {
        try {
            return Long.parseLong(this.guideNickDialogInterval);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getHeadTag() {
        return this.headTag;
    }

    public String getHoroscope() {
        return this.horoscope;
    }

    public boolean getIsChildAccount() {
        return this.isChildAccount;
    }

    public String getIsLay() {
        return this.isLay;
    }

    public int getLevel() {
        return this.level;
    }

    public long getMemberEndTime() {
        return this.memberEndTime;
    }

    public String getMemberVip() {
        return this.memberVip;
    }

    public boolean getNewFlag() {
        return this.newFlag;
    }

    public long getNickModifyDuration() {
        return this.nickModifyDuration;
    }

    public long getNickModifyDurationOfDay() {
        return (this.nickModifyDuration * 1000) / 86400000;
    }

    public int getNickModifyTimes() {
        return this.nickModifyTimes;
    }

    public Audit getNickNameAudit() {
        return this.nickNameAudit;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getOperateWidgetNum() {
        return this.operateWidgetNum;
    }

    public String getOrnament() {
        return this.ornament;
    }

    public String getOrnamentId() {
        return this.ornamentId;
    }

    public String getPopType() {
        return this.popType;
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

    public String getRecommendNick() {
        return this.recommendNick;
    }

    public boolean getSearchByInterestSwitch() {
        return this.searchByInterestSwitch;
    }

    public boolean getSearchByTelSwitch() {
        return this.searchByTelSwitch;
    }

    public int getShowType() {
        return this.showType;
    }

    public String getSignature() {
        return this.signature;
    }

    public Audit getSignatureAudit() {
        return this.signatureAudit;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUk() {
        return this.uk;
    }

    public String getUserType() {
        return this.userType;
    }

    public int getUserWidgetNum() {
        return this.userWidgetNum;
    }

    public int getVip() {
        return this.vip;
    }

    public String getVipIconUrl() {
        if (this.vip != 0) {
            return AccountConstants.ACCOUNT_VIP_URL_PREFIX + this.vip + AccountConstants.ACCOUNT_VIP_URL_SUFFIX;
        }
        return null;
    }

    public int getWidgetNum() {
        return this.widgetNum;
    }

    public int hashCode() {
        String str = this.uid;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isDefaultNick() {
        return this.isDefaultNick;
    }

    public boolean isDefaultPortriat() {
        if (TextUtils.isEmpty(this.headTag)) {
            return false;
        }
        if (!this.headTag.equals("1") && !this.headTag.equals("2")) {
            return false;
        }
        return true;
    }

    public boolean isIncompleteUser() {
        return this.incompleteUser;
    }

    public boolean isInitialPortrait() {
        return this.isInitialPortrait;
    }

    public boolean isShowAge() {
        return this.isShowAge;
    }

    public boolean isShowCity() {
        return this.isShowCity;
    }

    public boolean isShowComment() {
        return this.showComment;
    }

    public boolean isShowGender() {
        return this.isShowGender;
    }

    public boolean isShowStar() {
        return this.isShowStar;
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
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
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

    public String getAvatar(boolean z) {
        if (z) {
            return this.avatarBig;
        }
        return this.portrait;
    }

    @Deprecated
    public String getHeadTag(String str) {
        return this.headTag;
    }

    public void setAddressSwitch(boolean z) {
        this.addressSwitch = z;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void setAttentionFansSwitch(boolean z) {
        this.attentionFansSwitch = z;
    }

    public void setAvatarBig(String str) {
        this.avatarBig = str;
    }

    public void setBCArticle(String str) {
        this.bcArticle = str;
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

    public void setDynamicPortrait(String str) {
        this.dynamicPortrait = str;
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

    public void setFirstDistributeNickname(String str) {
        this.firstDistributeNickname = str;
    }

    public void setFirstPopType(int i) {
        this.firstPopType = i;
    }

    public void setGender(int i) {
        this.gender = i;
    }

    public void setGuideNickDialogInterval(String str) {
        this.guideNickDialogInterval = str;
    }

    public void setHeadTag(String str) {
        this.headTag = str;
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

    public void setIsChildAccount(boolean z) {
        this.isChildAccount = z;
    }

    public void setIsDefaultNick(boolean z) {
        this.isDefaultNick = z;
    }

    public void setIsLay(String str) {
        this.isLay = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setMemberEndTime(long j) {
        this.memberEndTime = j;
    }

    public void setMemberVip(String str) {
        this.memberVip = str;
    }

    public void setNewFlag(boolean z) {
        this.newFlag = z;
    }

    public void setNickModifyDuration(long j) {
        this.nickModifyDuration = j;
    }

    public void setNickModifyTimes(int i) {
        this.nickModifyTimes = i;
    }

    public void setNickNameAudit(Audit audit) {
        this.nickNameAudit = audit;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOperateWidgetNum(int i) {
        this.operateWidgetNum = i;
    }

    public void setOrnament(String str) {
        this.ornament = str;
    }

    public void setOrnamentId(String str) {
        this.ornamentId = str;
    }

    public void setPopType(String str) {
        this.popType = str;
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

    public void setRecommendNick(String str) {
        this.recommendNick = str;
    }

    public void setSearchByInterestSwitch(boolean z) {
        this.searchByInterestSwitch = z;
    }

    public void setSearchByTelSwitch(boolean z) {
        this.searchByTelSwitch = z;
    }

    public void setShowAge(boolean z) {
        this.isShowAge = z;
    }

    public void setShowCity(boolean z) {
        this.isShowCity = z;
    }

    public void setShowComment(boolean z) {
        this.showComment = z;
    }

    public void setShowGender(boolean z) {
        this.isShowGender = z;
    }

    public void setShowStar(boolean z) {
        this.isShowStar = z;
    }

    public void setShowType(int i) {
        this.showType = i;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setSignatureAudit(Audit audit) {
        this.signatureAudit = audit;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUk(String str) {
        this.uk = str;
    }

    public void setUserType(String str) {
        this.userType = str;
    }

    public void setUserWidgetNum(int i) {
        this.userWidgetNum = i;
    }

    public void setVip(int i) {
        this.vip = i;
    }

    public void setWidgetNum(int i) {
        this.widgetNum = i;
    }

    public String toString() {
        return "BoxAccount{uid='" + this.uid + "', displayname='" + this.displayname + "', portrait='" + this.portrait + "', nickname='" + this.nickname + "'}";
    }
}
