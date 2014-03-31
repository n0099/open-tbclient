package com.baidu.tbadk.core.data;

import com.baidu.tieba.person.PersonInfoActivity;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ForumData implements Serializable {
    private static final long serialVersionUID = -5446966999595522426L;
    private int cur_score;
    private int favo_type;
    private String image_url;
    private int is_local_effect;
    private int is_support_local;
    private String level_name;
    private int levelup_score;
    private final ArrayList<a> mBadgeData;
    private final c mBannerListData;
    private final f mFrsBannerData;
    private final PostPrefixData mPrefixData;
    private ArrayList<m> mRecommendForumData;
    private String slogan;
    private String tag_color;
    private String tag_id;
    private p top_notice_data;
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
    private ArrayList<g> good_classify = new ArrayList<>();
    private String tag_name = null;

    public ForumData() {
        setTag_id(null);
        setTag_color(null);
        this.cur_score = 0;
        this.levelup_score = 0;
        this.is_support_local = 0;
        this.is_local_effect = 0;
        this.top_notice_data = new p();
        this.mBadgeData = new ArrayList<>();
        this.mFrsBannerData = new f();
        this.mBannerListData = new c();
        this.mRecommendForumData = new ArrayList<>();
        this.mPrefixData = new PostPrefixData();
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

    public p getTop_notice_data() {
        return this.top_notice_data;
    }

    public void setTop_notice_data(p pVar) {
        this.top_notice_data = pVar;
    }

    public void setManagers(ArrayList<String> arrayList) {
        this.managers = arrayList;
    }

    public ArrayList<String> getManagers() {
        return this.managers;
    }

    public void setGood_classify(ArrayList<g> arrayList) {
        this.good_classify = arrayList;
    }

    public ArrayList<g> getGood_classify() {
        return this.good_classify;
    }

    public String getLevelName() {
        return this.level_name;
    }

    public void setLevelName(String str) {
        this.level_name = str;
    }

    public ArrayList<a> getBadgeData() {
        return this.mBadgeData;
    }

    public f getFrsBannerData() {
        return this.mFrsBannerData;
    }

    public c getBannerListData() {
        return this.mBannerListData;
    }

    public ArrayList<m> getRecommendForumData() {
        return this.mRecommendForumData;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("ForumData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.name = jSONObject.optString(PersonInfoActivity.TAG_NAME);
                this.slogan = jSONObject.optString("slogan");
                this.is_support_local = jSONObject.optInt("is_support_local", 0);
                this.is_local_effect = jSONObject.optInt("is_local_effect", 0);
                JSONObject optJSONObject = jSONObject.optJSONObject("top_notice");
                if (optJSONObject != null) {
                    this.top_notice_data.a(optJSONObject);
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
                        this.managers.add(((JSONObject) optJSONArray.opt(i)).optString(PersonInfoActivity.TAG_NAME));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("good_classify");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        g gVar = new g();
                        gVar.a(optJSONArray2.optJSONObject(i2));
                        this.good_classify.add(gVar);
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
                        a aVar = new a();
                        aVar.a(optJSONArray3.optJSONObject(i3));
                        this.mBadgeData.add(aVar);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("recommend_forum");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        m mVar = new m();
                        JSONObject optJSONObject7 = optJSONArray4.optJSONObject(i4);
                        if (optJSONObject7 != null) {
                            mVar.a = optJSONObject7.optString(PersonInfoActivity.TAG_NAME);
                            mVar.b = optJSONObject7.optString("avatar");
                            mVar.c = optJSONObject7.optString("link");
                            mVar.d = optJSONObject7.optString("st_param");
                            com.baidu.adp.lib.util.f.e("Recommend:name:" + mVar.a + " link:" + mVar.c + "imageurl:" + mVar.b + "st_param" + mVar.d);
                        }
                        this.mRecommendForumData.add(mVar);
                    }
                }
                try {
                    this.mFrsBannerData.a(jSONObject.getJSONObject("banner"));
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("ForumData", "banner parserJson", "error = " + e.getMessage());
                }
                try {
                    this.mBannerListData.a(jSONObject.optJSONObject("banner_list"));
                } catch (Exception e2) {
                    com.baidu.adp.lib.util.f.b("ForumData", "banner_list parserJson", "error = " + e2.getMessage());
                }
                try {
                    this.mPrefixData.parserJson(jSONObject.optJSONObject("post_prefix"));
                } catch (Exception e3) {
                    com.baidu.adp.lib.util.f.b("ForumData", "banner_list parserJson", "error = " + e3.getMessage());
                }
            } catch (Exception e4) {
                com.baidu.adp.lib.util.f.b("ForumData", "parserJson", "error = " + e4.getMessage());
            }
        }
    }

    public void logPrint() {
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "id = " + this.id);
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "name = " + this.name);
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "first_class = " + this.first_class);
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "second_class = " + this.second_class);
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "is_exists = " + String.valueOf(this.is_exists));
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "is_forbidden = " + String.valueOf(this.is_forbidden));
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "thread_num = " + String.valueOf(this.thread_num));
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "post_num = " + String.valueOf(this.post_num));
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "member_num = " + String.valueOf(this.member_num));
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "is_like = " + String.valueOf(this.is_like));
        com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "user_level = " + String.valueOf(this.user_level));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.managers.size()) {
                com.baidu.adp.lib.util.f.d("ForumData", "logPrint", "managers" + String.valueOf(i2) + " = " + this.managers.get(i2));
                this.managers.get(i2);
                i = i2 + 1;
            } else {
                return;
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
}
