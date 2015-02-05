package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.Badges;
import tbclient.FrsPage.Classify;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.Manager;
import tbclient.FrsPage.RankInfo;
import tbclient.FrsPage.RecommendForum;
import tbclient.FrsPage.SignForum;
import tbclient.FrsPage.SignInfo;
import tbclient.FrsPage.SignUser;
import tbclient.FrsPage.TagInfo;
import tbclient.SimpleForum;
/* loaded from: classes.dex */
public class ForumData implements au, Serializable {
    public static final int ANCHOR_HAVE_POWER = 1;
    public static final int ANCHOR_NOT_SHOW = 0;
    public static final int ANCHOR_SHOW_BUT_NO_POWER = 2;
    public static final int FORUM_LIKE = 1;
    public static final int FORUM_UNLIKE = 0;
    private static final long serialVersionUID = -5446966999595522426L;
    private String accelerate_cotent;
    private AnchorPower anchorPower;
    private int cur_score;
    private int favo_type;
    private String image_url;
    private int is_local_effect;
    private int is_support_local;
    private String level_name;
    private int levelup_score;
    private final ArrayList<e> mBadgeData;
    private final f mBannerListData;
    private final j mFrsBannerData;
    private final PostPrefixData mPrefixData;
    private ArrayList<s> mRecommendForumData;
    private final t mRecommendLikeUser;
    private ab news_info;
    private String slogan;
    private String tag_color;
    private String tag_id;
    private y top_code;
    private z top_notice_data;
    private String id = null;
    private String name = null;
    private String first_class = null;
    private String second_class = null;
    private int is_exists = 0;
    private int is_forbidden = 1;
    private int thread_num = 0;
    private int post_num = 0;
    private int member_num = 0;
    private int is_like = 0;
    private int user_level = 0;
    private int album_open_photo_frs = 0;
    private SignData mSignData = new SignData();
    private ArrayList<String> managers = new ArrayList<>();
    private ArrayList<k> good_classify = new ArrayList<>();
    private String tag_name = null;

    public ForumData() {
        setTag_id(null);
        setTag_color(null);
        this.cur_score = 0;
        this.levelup_score = 0;
        this.is_support_local = 0;
        this.is_local_effect = 0;
        this.top_notice_data = new z();
        this.mBadgeData = new ArrayList<>();
        this.mFrsBannerData = new j();
        this.mBannerListData = new f();
        this.mRecommendForumData = new ArrayList<>();
        this.mPrefixData = new PostPrefixData();
        this.mRecommendLikeUser = new t();
        this.top_code = new y();
        this.news_info = new ab();
    }

    public AnchorPower getAnchorPower() {
        return this.anchorPower;
    }

    public void setAnchorPower(AnchorPower anchorPower) {
        this.anchorPower = anchorPower;
    }

    public void setId(String str) {
        this.id = str;
    }

    public int getFrsImageOpen() {
        return this.album_open_photo_frs;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public void setFirst_class(String str) {
        this.first_class = str;
    }

    public String getFirst_class() {
        return this.first_class;
    }

    public void setSecond_class(String str) {
        this.second_class = str;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public void setSlogan(String str) {
        this.slogan = str;
    }

    public String getSecond_class() {
        return this.second_class;
    }

    public void setIs_exists(int i) {
        this.is_exists = i;
    }

    public int isIs_exists() {
        return this.is_exists;
    }

    public void setIs_forbidden(int i) {
        this.is_forbidden = i;
    }

    public int isIs_forbidden() {
        return this.is_forbidden;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public int getThread_num() {
        return this.thread_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setMember_num(int i) {
        this.member_num = i;
    }

    public int getMember_num() {
        return this.member_num;
    }

    public void setLike(int i) {
        this.is_like = i;
    }

    public int isLike() {
        return this.is_like;
    }

    public void setIsSupportLocal(int i) {
        this.is_support_local = i;
    }

    public int isSupportLocal() {
        return this.is_support_local;
    }

    public void setIsLocalEffect(int i) {
        this.is_local_effect = i;
    }

    public int isLocalEffect() {
        return this.is_local_effect;
    }

    public void setUser_level(int i) {
        this.user_level = i;
    }

    public int getUser_level() {
        return this.user_level;
    }

    public SignData getSignData() {
        return this.mSignData;
    }

    public void setSignData(SignData signData) {
        this.mSignData = signData;
    }

    public z getTop_notice_data() {
        return this.top_notice_data;
    }

    public void setTop_notice_data(z zVar) {
        this.top_notice_data = zVar;
    }

    public void setManagers(ArrayList<String> arrayList) {
        this.managers = arrayList;
    }

    public ArrayList<String> getManagers() {
        return this.managers;
    }

    public void setGood_classify(ArrayList<k> arrayList) {
        this.good_classify = arrayList;
    }

    public ArrayList<k> getGood_classify() {
        return this.good_classify;
    }

    public String getLevelName() {
        return this.level_name;
    }

    public void setLevelName(String str) {
        this.level_name = str;
    }

    public ArrayList<e> getBadgeData() {
        return this.mBadgeData;
    }

    public j getFrsBannerData() {
        return this.mFrsBannerData;
    }

    public f getBannerListData() {
        return this.mBannerListData;
    }

    public t getRecommendLikeUser() {
        return this.mRecommendLikeUser;
    }

    public ArrayList<s> getRecommendForumData() {
        return this.mRecommendForumData;
    }

    public String getAccelerateContent() {
        return this.accelerate_cotent;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0055: IGET  (r3v10 java.lang.Integer A[REMOVE]) = (r0v14 tbclient.FrsPage.TagInfo) tbclient.FrsPage.TagInfo.tag_id java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0066: IGET  (r0v76 java.lang.Integer A[REMOVE]) = (r0v14 tbclient.FrsPage.TagInfo) tbclient.FrsPage.TagInfo.color java.lang.Integer)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0009: IGET  (r2v0 java.lang.Long A[REMOVE]) = (r6v0 tbclient.FrsPage.ForumInfo) tbclient.FrsPage.ForumInfo.id java.lang.Long)] */
    public void parserProtobuf(ForumInfo forumInfo) {
        if (forumInfo != null) {
            try {
                this.id = new StringBuilder().append(forumInfo.id).toString();
                this.name = forumInfo.name;
                this.slogan = forumInfo.slogan;
                this.is_support_local = forumInfo.is_support_local.intValue();
                this.is_local_effect = forumInfo.is_local_effect.intValue();
                if (!TextUtils.isEmpty(forumInfo.accelerate_cotent) && !TextUtils.isEmpty(forumInfo.accelerate_cotent)) {
                    this.accelerate_cotent = forumInfo.accelerate_cotent;
                }
                this.top_notice_data.a(forumInfo.top_notice);
                TagInfo tagInfo = forumInfo.tag_info;
                if (tagInfo != null) {
                    this.tag_name = tagInfo.tag_name;
                    this.tag_id = new StringBuilder().append(tagInfo.tag_id).toString();
                    this.tag_color = new StringBuilder().append(tagInfo.color).toString();
                }
                this.image_url = forumInfo.avatar;
                this.cur_score = forumInfo.cur_score.intValue();
                this.levelup_score = forumInfo.levelup_score.intValue();
                this.first_class = forumInfo.first_class;
                this.second_class = forumInfo.second_class;
                this.is_exists = forumInfo.is_exists.intValue();
                this.is_forbidden = forumInfo.is_forbidden.intValue();
                this.thread_num = forumInfo.thread_num.intValue();
                this.post_num = forumInfo.post_num.intValue();
                this.member_num = forumInfo.member_num.intValue();
                this.is_like = forumInfo.is_like.intValue();
                this.user_level = forumInfo.user_level.intValue();
                this.level_name = forumInfo.level_name;
                this.album_open_photo_frs = forumInfo.album_open_photo_frs.intValue();
                setFavo_type(forumInfo.favo_type.intValue());
                List<Manager> list = forumInfo.managers;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        this.managers.add(list.get(i).name);
                    }
                }
                List<Classify> list2 = forumInfo.good_classify;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        k kVar = new k();
                        kVar.a(list2.get(i2));
                        this.good_classify.add(kVar);
                    }
                }
                SignInfo signInfo = forumInfo.sign_in_info;
                if (signInfo != null) {
                    SignUser signUser = signInfo.user_info;
                    if (signUser != null) {
                        this.mSignData.setIsSigned(signUser.is_sign_in.intValue());
                        this.mSignData.setUserSignRank(signUser.user_sign_rank.intValue());
                        this.mSignData.setCountSignNum(signUser.cont_sign_num.intValue());
                    }
                    SignForum signForum = signInfo.forum_info;
                    if (signForum != null) {
                        if (signForum.is_on.intValue() == 0) {
                            this.mSignData.setForumRank(-2);
                        } else {
                            RankInfo rankInfo = signForum.current_rank_info;
                            if (rankInfo != null) {
                                this.mSignData.setForumRank(rankInfo.sign_rank.intValue());
                                this.mSignData.setSignCount(rankInfo.sign_count.intValue());
                            }
                        }
                    }
                }
                List<Badges> list3 = forumInfo.badges;
                if (list3 != null && list3.size() > 0) {
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        e eVar = new e();
                        eVar.a(list3.get(i3));
                        this.mBadgeData.add(eVar);
                    }
                }
                List<RecommendForum> list4 = forumInfo.recommend_forum;
                if (list4 != null && list4.size() > 0) {
                    for (int i4 = 0; i4 < list4.size(); i4++) {
                        s sVar = new s();
                        sVar.a(list4.get(i4));
                        this.mRecommendForumData.add(sVar);
                    }
                }
                this.mFrsBannerData.a(forumInfo.banner);
                this.mBannerListData.a(forumInfo.banner_list);
                this.mRecommendLikeUser.a(forumInfo.recommend_user_info);
                this.mPrefixData.parserProtobuf(forumInfo.post_prefix);
                this.anchorPower = forumInfo.anchor_power;
                this.top_code.a(forumInfo.top_code);
                this.news_info.a(forumInfo.news_info);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum != null) {
            try {
                this.id = String.valueOf(simpleForum.id);
                this.name = simpleForum.name;
                this.is_exists = simpleForum.is_exists.intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString("name");
                this.slogan = jSONObject.optString("slogan");
                this.is_support_local = jSONObject.optInt("is_support_local", 0);
                this.is_local_effect = jSONObject.optInt("is_local_effect", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("top_notice");
                if (optJSONObject != null) {
                    this.top_notice_data.parserJson(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("tag_info");
                if (optJSONObject2 != null) {
                    this.tag_name = optJSONObject2.optString("tag_name", null);
                    this.tag_id = optJSONObject2.optString("tag_id", null);
                    this.tag_color = optJSONObject2.optString("color", null);
                }
                this.image_url = jSONObject.optString("avatar", null);
                this.cur_score = jSONObject.optInt("cur_score", 0);
                this.levelup_score = jSONObject.optInt("levelup_score", 0);
                this.first_class = jSONObject.optString("first_class");
                this.second_class = jSONObject.optString("second_class");
                this.is_exists = jSONObject.optInt("is_exists", 0);
                this.is_forbidden = jSONObject.optInt("is_forbidden", 1);
                this.thread_num = jSONObject.optInt("thread_num", 0);
                this.post_num = jSONObject.optInt("post_num", 0);
                this.member_num = jSONObject.optInt("member_num", 0);
                this.is_like = jSONObject.optInt("is_like", 0);
                this.user_level = jSONObject.optInt("level_id", 0);
                this.level_name = jSONObject.optString("level_name", null);
                this.album_open_photo_frs = jSONObject.optInt("album_open_photo_frs", 0);
                setFavo_type(jSONObject.optInt("favo_type", 0));
                JSONArray optJSONArray = jSONObject.optJSONArray("managers");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.managers.add(((JSONObject) optJSONArray.opt(i)).optString("name"));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("good_classify");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        k kVar = new k();
                        kVar.parserJson(optJSONArray2.optJSONObject(i2));
                        this.good_classify.add(kVar);
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("sign_in_info");
                if (optJSONObject3 != null) {
                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("user_info");
                    if (optJSONObject4 != null) {
                        this.mSignData.setIsSigned(optJSONObject4.optInt("is_sign_in"));
                        this.mSignData.setUserSignRank(optJSONObject4.optInt("user_sign_rank"));
                        this.mSignData.setCountSignNum(optJSONObject4.optInt("cont_sign_num"));
                    }
                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("forum_info");
                    if (optJSONObject5 != null) {
                        if (optJSONObject5.optInt("is_on") == 0) {
                            this.mSignData.setForumRank(-2);
                        } else {
                            JSONObject optJSONObject6 = optJSONObject5.optJSONObject("current_rank_info");
                            if (optJSONObject6 != null) {
                                this.mSignData.setForumRank(optJSONObject6.optInt("sign_rank"));
                                this.mSignData.setSignCount(optJSONObject6.optInt("sign_count"));
                            }
                        }
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("badges");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                        e eVar = new e();
                        eVar.parserJson(optJSONArray3.optJSONObject(i3));
                        this.mBadgeData.add(eVar);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("recommend_forum");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        s sVar = new s();
                        sVar.parserJson(optJSONArray4.optJSONObject(i4));
                        this.mRecommendForumData.add(sVar);
                    }
                }
                try {
                    this.mFrsBannerData.parserJson(jSONObject.getJSONObject("banner"));
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
                try {
                    this.mBannerListData.parserJson(jSONObject.optJSONObject("banner_list"));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                try {
                    this.mRecommendLikeUser.f(jSONObject.optJSONObject("recommend_user_info"));
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
                try {
                    this.mPrefixData.parserJson(jSONObject.optJSONObject("post_prefix"));
                } catch (Exception e4) {
                    BdLog.e(e4.getMessage());
                }
                try {
                    this.top_code.parseJson(jSONObject.optJSONObject("top_code"));
                } catch (Exception e5) {
                    BdLog.e(e5.getMessage());
                }
                try {
                    this.news_info.parseJson(jSONObject.optJSONObject("news_info"));
                } catch (Exception e6) {
                    BdLog.e(e6.getMessage());
                }
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
        }
    }

    public void setFavo_type(int i) {
        this.favo_type = i;
    }

    public int getFavo_type() {
        return this.favo_type;
    }

    public void setTag_name(String str) {
        this.tag_name = str;
    }

    public String getTag_name() {
        return this.tag_name;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setTag_color(String str) {
        this.tag_color = str;
    }

    public String getTag_color() {
        return this.tag_color;
    }

    public void setTag_id(String str) {
        this.tag_id = str;
    }

    public String getTag_id() {
        return this.tag_id;
    }

    public void setCurScore(int i) {
        this.cur_score = i;
    }

    public int getCurScore() {
        return this.cur_score;
    }

    public void setLevelupScore(int i) {
        this.levelup_score = i;
    }

    public int getLevelupScore() {
        return this.levelup_score;
    }

    public PostPrefixData getPrefixData() {
        return this.mPrefixData;
    }

    public void setTopCode(y yVar) {
        this.top_code = yVar;
    }

    public void setNewsInfo(ab abVar) {
        this.news_info = abVar;
    }

    public y getTopCode() {
        return this.top_code;
    }

    public ab getNewsInfo() {
        return this.news_info;
    }

    @Override // com.baidu.tbadk.core.util.au
    public ArrayList<at> getImages() {
        ArrayList<at> arrayList = new ArrayList<>();
        at atVar = new at();
        atVar.EX = this.image_url;
        atVar.Jk = 10;
        arrayList.add(atVar);
        return arrayList;
    }
}
