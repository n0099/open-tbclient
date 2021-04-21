package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.AlaMasterLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.b.c.j.e.n;
import d.b.i0.r.q.a0;
import d.b.i0.r.q.c0;
import d.b.i0.r.q.c2;
import d.b.i0.r.q.d2;
import d.b.i0.r.q.f0;
import d.b.i0.r.q.f2;
import d.b.i0.r.q.k;
import d.b.i0.r.q.l0;
import d.b.i0.r.q.l2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.DeletedReasonInfo;
import tbclient.FrsPage.AcrossForumIcon;
import tbclient.FrsPage.AnchorPower;
import tbclient.FrsPage.Badges;
import tbclient.FrsPage.Classify;
import tbclient.FrsPage.ForumInfo;
import tbclient.FrsPage.Manager;
import tbclient.FrsPage.MemberShowIcon;
import tbclient.FrsPage.RankInfo;
import tbclient.FrsPage.RecommendForum;
import tbclient.FrsPage.SignForum;
import tbclient.FrsPage.SignInfo;
import tbclient.FrsPage.SignUser;
import tbclient.FrsPage.TagInfo;
import tbclient.FrsPage.TipInfo;
import tbclient.FrsPage.Yule;
import tbclient.SimpleForum;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public class ForumData implements Serializable, PreLoadImageProvider, n {
    public static BdUniqueId FORUM_FLOOR_TYPE = BdUniqueId.gen();
    public static final String FROM_PAGE_FRS = "frs";
    public static final long serialVersionUID = -5446966999595522426L;
    public String accelerate_cotent;
    public AnchorPower anchorPower;
    public boolean canAddPhotoLivePost;
    public int cur_score;
    public String fShareImage;
    public int favo_type;
    public String forumGameLabel;
    public String forum_share_link;
    public String image_url;
    public boolean isBrandForum;
    public int isShowAllTopThread;
    public boolean isShowBawuTask;
    public boolean isShowForumRule;
    public int is_local_effect;
    public int is_private_forum;
    public boolean is_sign;
    public int is_support_local;
    public a0 l;
    public String level_name;
    public int levelup_score;
    public int locate;
    public AcrossForumIcon mAcrossForumIcon;
    public final ArrayList<k> mBadgeData;
    public final BannerListData mBannerListData;
    public DeletedReasonInfo mDeletedReasonInfo;
    public String mFromPage;
    public final f0 mFrsBannerData;
    public int mIsLiveGameForum;
    public c0 mMemberShowIconData;
    public PostTopicData mPostTopicData;
    public final PostPrefixData mPrefixData;
    public ArrayList<RecommendForumData> mRecommendForumData;
    public ThemeColorInfo mThemeColorInfo;
    public List<TipInfo> mTipInfos;
    public f2 news_info;
    public String riskTipNotice;
    public String riskTipPop;
    public String riskTipPopTitle;
    public String slogan;
    public String special_forum_type;
    public String tag_color;
    public String tag_id;
    public String topIcon;
    public c2 top_code;
    public d2 top_notice_data;
    public String topic_special_icon;
    public String topic_special_icon_right;
    public String warning_msg;
    public l2 yuleData;
    public boolean isBlockBawuDelete = false;
    public String id = null;
    public String name = null;
    public String first_class = null;
    public String second_class = null;
    public int is_exists = 0;
    public int is_forbidden = 1;
    public int thread_num = 0;
    public int post_num = 0;
    public int member_num = 0;
    public int is_like = 0;
    public int user_level = 0;
    public int album_open_photo_frs = 0;
    public SignData mSignData = new SignData();
    public List<Manager> managers = new ArrayList();
    public ArrayList<l0> good_classify = new ArrayList<>();
    public String tag_name = null;

    public ForumData() {
        setTag_id(null);
        setTag_color(null);
        this.cur_score = 0;
        this.levelup_score = 0;
        this.is_support_local = 0;
        this.is_local_effect = 0;
        this.top_notice_data = new d2();
        this.mBadgeData = new ArrayList<>();
        this.mFrsBannerData = new f0();
        this.mBannerListData = new BannerListData();
        this.mRecommendForumData = new ArrayList<>();
        this.mPrefixData = new PostPrefixData();
        this.mPostTopicData = new PostTopicData();
        this.top_code = new c2();
        this.news_info = new f2();
        this.canAddPhotoLivePost = false;
        this.mMemberShowIconData = new c0();
        this.yuleData = new l2();
        this.mIsLiveGameForum = 0;
        this.warning_msg = null;
        this.special_forum_type = null;
        this.topic_special_icon = null;
        this.topic_special_icon_right = null;
        this.mThemeColorInfo = null;
        this.topIcon = null;
        this.is_private_forum = 0;
        this.isShowBawuTask = false;
        this.isShowForumRule = false;
        this.fShareImage = null;
        this.mTipInfos = new ArrayList();
    }

    public String getAccelerateContent() {
        return this.accelerate_cotent;
    }

    public AnchorPower getAnchorPower() {
        return this.anchorPower;
    }

    public ArrayList<k> getBadgeData() {
        return this.mBadgeData;
    }

    public BannerListData getBannerListData() {
        return this.mBannerListData;
    }

    public boolean getCanAddPhotoLivePost() {
        return this.canAddPhotoLivePost;
    }

    public int getCurScore() {
        return this.cur_score;
    }

    public DeletedReasonInfo getDeletedReasonInfo() {
        return this.mDeletedReasonInfo;
    }

    public int getFavo_type() {
        return this.favo_type;
    }

    public String getFirst_class() {
        return this.first_class;
    }

    public String getForumGameLabel() {
        return this.forumGameLabel;
    }

    public String getFromPage() {
        return this.mFromPage;
    }

    public f0 getFrsBannerData() {
        return this.mFrsBannerData;
    }

    public int getFrsImageOpen() {
        return this.album_open_photo_frs;
    }

    public ArrayList<l0> getGood_classify() {
        return this.good_classify;
    }

    public String getId() {
        return this.id;
    }

    public String getImage_url() {
        return this.image_url;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
        preLoadImageInfo.imgUrl = this.image_url;
        preLoadImageInfo.procType = 10;
        arrayList.add(preLoadImageInfo);
        return arrayList;
    }

    public int getIsPrivateForum() {
        return this.is_private_forum;
    }

    public boolean getIsShowBawuTask() {
        return this.isShowBawuTask;
    }

    public boolean getIsShowRule() {
        return this.isShowForumRule;
    }

    public String getLevelName() {
        return this.level_name;
    }

    public int getLevelupScore() {
        return this.levelup_score;
    }

    public List<Manager> getManagers() {
        return this.managers;
    }

    public c0 getMemberShowIconData() {
        return this.mMemberShowIconData;
    }

    public int getMember_num() {
        return this.member_num;
    }

    public String getName() {
        return this.name;
    }

    public f2 getNewsInfo() {
        return this.news_info;
    }

    public PostTopicData getPostTopicData() {
        return this.mPostTopicData;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public PostPrefixData getPrefixData() {
        return this.mPrefixData;
    }

    public ArrayList<RecommendForumData> getRecommendForumData() {
        return this.mRecommendForumData;
    }

    public String getRiskTipNotice() {
        return this.riskTipNotice;
    }

    public String getRiskTipPop() {
        return this.riskTipPop;
    }

    public String getRiskTipPopTitle() {
        return this.riskTipPopTitle;
    }

    public String getSecond_class() {
        return this.second_class;
    }

    public SignData getSignData() {
        return this.mSignData;
    }

    public boolean getSigned() {
        return this.is_sign || this.mSignData.is_signed == 1;
    }

    public String getSlogan() {
        return this.slogan;
    }

    public String getSpecialForumType() {
        return this.special_forum_type;
    }

    public String getTag_color() {
        return this.tag_color;
    }

    public String getTag_id() {
        return this.tag_id;
    }

    public String getTag_name() {
        return this.tag_name;
    }

    public ThemeColorInfo getThemeColorInfo() {
        return this.mThemeColorInfo;
    }

    public int getThread_num() {
        return this.thread_num;
    }

    public List<TipInfo> getTipInfos() {
        return this.mTipInfos;
    }

    public c2 getTopCode() {
        return this.top_code;
    }

    public String getTopIcon() {
        return this.topIcon;
    }

    public d2 getTop_notice_data() {
        return this.top_notice_data;
    }

    public String getTopic_special_icon() {
        return this.topic_special_icon;
    }

    public String getTopic_special_icon_right() {
        return this.topic_special_icon_right;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return FORUM_FLOOR_TYPE;
    }

    public int getUser_level() {
        return this.user_level;
    }

    public String getWarningMsg() {
        return this.warning_msg;
    }

    public l2 getYuleData() {
        return this.yuleData;
    }

    public String getfShareImage() {
        return this.fShareImage;
    }

    public boolean isGameForumType() {
        return this.mIsLiveGameForum == 1;
    }

    public int isIs_exists() {
        return this.is_exists;
    }

    public int isIs_forbidden() {
        return this.is_forbidden;
    }

    public int isLike() {
        return this.is_like;
    }

    public int isLocalEffect() {
        return this.is_local_effect;
    }

    public int isSupportLocal() {
        return this.is_support_local;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void parserProtobuf(ForumInfo forumInfo) {
        if (forumInfo == null) {
            return;
        }
        try {
            this.id = forumInfo.id + "";
            this.name = forumInfo.name;
            this.slogan = forumInfo.slogan;
            this.is_support_local = forumInfo.is_support_local.intValue();
            this.is_local_effect = forumInfo.is_local_effect.intValue();
            if (!TextUtils.isEmpty(forumInfo.accelerate_cotent)) {
                this.accelerate_cotent = forumInfo.accelerate_cotent;
            }
            this.top_notice_data.d(forumInfo.top_notice);
            TagInfo tagInfo = forumInfo.tag_info;
            if (tagInfo != null) {
                this.tag_name = tagInfo.tag_name;
                this.tag_id = tagInfo.tag_id + "";
                this.tag_color = tagInfo.color + "";
            }
            this.riskTipPop = forumInfo.risk_tip_pop;
            this.riskTipNotice = forumInfo.risk_tip_notice;
            this.riskTipPopTitle = forumInfo.risk_tip_pop_title;
            this.image_url = forumInfo.avatar;
            this.cur_score = forumInfo.cur_score.intValue();
            this.levelup_score = forumInfo.levelup_score.intValue();
            this.forum_share_link = forumInfo.forum_share_link;
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
            this.managers = forumInfo.managers;
            List<Classify> list = forumInfo.good_classify;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    l0 l0Var = new l0();
                    l0Var.d(list.get(i));
                    this.good_classify.add(l0Var);
                }
            }
            SignInfo signInfo = forumInfo.sign_in_info;
            if (signInfo != null) {
                SignUser signUser = signInfo.user_info;
                if (signUser != null) {
                    this.mSignData.is_signed = signUser.is_sign_in.intValue();
                    this.mSignData.user_sign_rank = signUser.user_sign_rank.intValue();
                    this.mSignData.count_sign_num = signUser.cont_sign_num.intValue();
                    this.mSignData.miss_sign_num = signUser.miss_sign_num.intValue();
                }
                SignForum signForum = signInfo.forum_info;
                if (signForum != null) {
                    if (signForum.is_on.intValue() == 0) {
                        this.mSignData.forum_rank = -2;
                    } else {
                        RankInfo rankInfo = signForum.current_rank_info;
                        if (rankInfo != null) {
                            this.mSignData.forum_rank = rankInfo.sign_rank.intValue();
                            this.mSignData.sign_count = rankInfo.sign_count.intValue();
                        }
                    }
                }
            }
            List<Badges> list2 = forumInfo.badges;
            if (list2 != null && list2.size() > 0) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    k kVar = new k();
                    kVar.b(list2.get(i2));
                    this.mBadgeData.add(kVar);
                }
            }
            List<RecommendForum> list3 = forumInfo.recommend_forum;
            if (list3 != null && list3.size() > 0) {
                for (int i3 = 0; i3 < list3.size(); i3++) {
                    RecommendForumData recommendForumData = new RecommendForumData();
                    recommendForumData.parserProtobuf(list3.get(i3));
                    this.mRecommendForumData.add(recommendForumData);
                }
            }
            List<TipInfo> list4 = forumInfo.tip_list;
            if (!ListUtils.isEmpty(list4)) {
                this.mTipInfos.addAll(list4);
            }
            MemberShowIcon memberShowIcon = forumInfo.forumvip_show_icon;
            if (memberShowIcon != null) {
                this.mMemberShowIconData.b(memberShowIcon);
            }
            Yule yule = forumInfo.yule;
            if (yule != null) {
                this.yuleData.d(yule);
            }
            this.mFrsBannerData.i(forumInfo.banner);
            this.mBannerListData.parserProtobuf(forumInfo.banner_list);
            this.mPrefixData.parserProtobuf(forumInfo.post_prefix);
            this.mPostTopicData.parserProtobuf(forumInfo.post_topic);
            AnchorPower anchorPower = forumInfo.anchor_power;
            this.anchorPower = anchorPower;
            if (anchorPower != null) {
                this.canAddPhotoLivePost = anchorPower.can_add_live_post.intValue() == 1;
            }
            this.top_code.j(forumInfo.top_code);
            this.news_info.F0(forumInfo.news_info);
            this.mAcrossForumIcon = forumInfo.across_forum_show;
            this.mIsLiveGameForum = forumInfo.is_live_game_forum.intValue();
            this.forumGameLabel = forumInfo.forum_game_label;
            this.warning_msg = forumInfo.warning_msg;
            this.special_forum_type = forumInfo.special_forum_type;
            this.topic_special_icon = forumInfo.topic_special_icon;
            this.topic_special_icon_right = forumInfo.topic_special_icon_right;
            this.isBrandForum = forumInfo.is_brand_forum.intValue() == 1;
            this.isShowAllTopThread = forumInfo.is_show_all_top_thread.intValue();
            this.mThemeColorInfo = forumInfo.theme_color;
            this.topIcon = forumInfo.is_top_img;
            this.is_private_forum = forumInfo.is_private_forum.intValue();
            this.isShowBawuTask = forumInfo.is_show_bawutask.intValue() == 1;
            this.fShareImage = forumInfo.f_share_img;
            this.isShowForumRule = forumInfo.is_show_forumrule.intValue() == 1;
            this.mDeletedReasonInfo = forumInfo.deleted_reason_info;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setAnchorPower(AnchorPower anchorPower) {
        this.anchorPower = anchorPower;
        if (anchorPower != null) {
            this.canAddPhotoLivePost = anchorPower.can_add_live_post.intValue() == 1;
        }
    }

    public void setCanAddPhotoLivePost(boolean z) {
        this.canAddPhotoLivePost = z;
    }

    public void setCurScore(int i) {
        this.cur_score = i;
    }

    public void setFavo_type(int i) {
        this.favo_type = i;
    }

    public void setFirst_class(String str) {
        this.first_class = str;
    }

    public void setFromPage(String str) {
        this.mFromPage = str;
    }

    public void setGood_classify(ArrayList<l0> arrayList) {
        this.good_classify = arrayList;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public void setIsLocalEffect(int i) {
        this.is_local_effect = i;
    }

    public void setIsSupportLocal(int i) {
        this.is_support_local = i;
    }

    public void setIs_exists(int i) {
        this.is_exists = i;
    }

    public void setIs_forbidden(int i) {
        this.is_forbidden = i;
    }

    public void setLevelName(String str) {
        this.level_name = str;
    }

    public void setLevelupScore(int i) {
        this.levelup_score = i;
    }

    public void setLike(int i) {
        this.is_like = i;
    }

    public void setMember_num(int i) {
        this.member_num = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNewsInfo(f2 f2Var) {
        this.news_info = f2Var;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public void setRiskTipNotice(String str) {
        this.riskTipNotice = str;
    }

    public void setRiskTipPop(String str) {
        this.riskTipPop = str;
    }

    public void setRiskTipPopTitle(String str) {
        this.riskTipPopTitle = str;
    }

    public void setSecond_class(String str) {
        this.second_class = str;
    }

    public void setSignData(SignData signData) {
        this.mSignData = signData;
    }

    public void setSlogan(String str) {
        this.slogan = str;
    }

    public void setTag_color(String str) {
        this.tag_color = str;
    }

    public void setTag_id(String str) {
        this.tag_id = str;
    }

    public void setTag_name(String str) {
        this.tag_name = str;
    }

    public void setThread_num(int i) {
        this.thread_num = i;
    }

    public void setTopCode(c2 c2Var) {
        this.top_code = c2Var;
    }

    public void setTop_notice_data(d2 d2Var) {
        this.top_notice_data = d2Var;
    }

    public void setUser_level(int i) {
        this.user_level = i;
    }

    public void setYuleData(l2 l2Var) {
        this.yuleData = l2Var;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.id = jSONObject.optString("id");
            this.name = jSONObject.optString("name");
            this.slogan = jSONObject.optString("slogan");
            this.is_support_local = jSONObject.optInt("is_support_local", 0);
            this.is_local_effect = jSONObject.optInt("is_local_effect", 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("top_notice");
            if (optJSONObject != null) {
                this.top_notice_data.c(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("tag_info");
            if (optJSONObject2 != null) {
                this.tag_name = optJSONObject2.optString("tag_name", null);
                this.tag_id = optJSONObject2.optString(TiebaStatic.Params.TAG_ID, null);
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
            this.mIsLiveGameForum = jSONObject.optInt("is_live_game_forum", 0);
            this.warning_msg = jSONObject.optString("warning_msg", null);
            setFavo_type(jSONObject.optInt("favo_type", 0));
            JSONArray optJSONArray = jSONObject.optJSONArray("managers");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Manager.Builder builder = new Manager.Builder();
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i);
                    builder.id = Long.valueOf(jSONObject2.getLong("id"));
                    builder.name = jSONObject2.getString("name");
                    builder.show_name = jSONObject2.getString("show_name");
                    builder.portrait = jSONObject2.getString("portrait");
                    this.managers.add(builder.build(false));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("good_classify");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    l0 l0Var = new l0();
                    l0Var.c(optJSONArray2.optJSONObject(i2));
                    this.good_classify.add(l0Var);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("sign_in_info");
            if (optJSONObject3 != null) {
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("user_info");
                if (optJSONObject4 != null) {
                    this.mSignData.is_signed = optJSONObject4.optInt("is_sign_in");
                    this.mSignData.user_sign_rank = optJSONObject4.optInt("user_sign_rank");
                    this.mSignData.count_sign_num = optJSONObject4.optInt("cont_sign_num");
                    this.mSignData.miss_sign_num = optJSONObject4.optInt("miss_sign_num", 0);
                }
                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("forum_info");
                if (optJSONObject5 != null) {
                    if (optJSONObject5.optInt("is_on") == 0) {
                        this.mSignData.forum_rank = -2;
                    } else {
                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject("current_rank_info");
                        if (optJSONObject6 != null) {
                            this.mSignData.forum_rank = optJSONObject6.optInt("sign_rank");
                            this.mSignData.sign_count = optJSONObject6.optInt("sign_count");
                        }
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("badges");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    k kVar = new k();
                    kVar.a(optJSONArray3.optJSONObject(i3));
                    this.mBadgeData.add(kVar);
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("recommend_forum");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    RecommendForumData recommendForumData = new RecommendForumData();
                    recommendForumData.parserJson(optJSONArray4.optJSONObject(i4));
                    this.mRecommendForumData.add(recommendForumData);
                }
            }
            try {
                this.mFrsBannerData.h(jSONObject.getJSONObject("banner"));
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            try {
                this.mBannerListData.parserJson(jSONObject.optJSONObject("banner_list"));
            } catch (Exception e3) {
                BdLog.e(e3.getMessage());
            }
            try {
                this.mPrefixData.parserJson(jSONObject.optJSONObject("post_prefix"));
            } catch (Exception e4) {
                BdLog.e(e4.getMessage());
            }
            try {
                this.mMemberShowIconData.a(jSONObject.optJSONObject("forumvip_show_icon"));
            } catch (Exception e5) {
                BdLog.e(e5.getMessage());
            }
            try {
                this.yuleData.c(jSONObject.optJSONObject("yule"));
            } catch (Exception e6) {
                BdLog.e(e6.getMessage());
            }
            try {
                this.top_code.i(jSONObject.optJSONObject("top_code"));
            } catch (Exception e7) {
                BdLog.e(e7.getMessage());
            }
            try {
                this.news_info.E0(jSONObject.optJSONObject("news_info"));
            } catch (Exception e8) {
                BdLog.e(e8.getMessage());
            }
            this.forumGameLabel = jSONObject.optString("forum_game_label");
            this.special_forum_type = jSONObject.optString(AlaMasterLiveRoomActivityConfig.SPECIAL_FORIM_TYPE);
            this.topic_special_icon = jSONObject.optString("topic_special_icon");
            this.topic_special_icon_right = jSONObject.optString("topic_special_icon_right");
            this.topIcon = jSONObject.optString("is_top_img");
            this.is_private_forum = jSONObject.optInt("is_private_forum");
            this.isShowBawuTask = jSONObject.optInt("is_show_bawutask") == 1;
            this.isShowForumRule = jSONObject.optInt("is_show_forumrule") == 1;
            this.fShareImage = jSONObject.optString("f_share_img");
        } catch (Exception e9) {
            BdLog.e(e9.getMessage());
        }
    }

    public void parserProtobuf(SimpleForum simpleForum) {
        if (simpleForum == null) {
            return;
        }
        try {
            this.id = String.valueOf(simpleForum.id);
            this.name = simpleForum.name;
            this.is_exists = simpleForum.is_exists.intValue();
            this.image_url = simpleForum.avatar;
            this.is_like = simpleForum.is_liked.intValue();
            boolean z = false;
            this.is_sign = simpleForum.is_signed.intValue() == 1;
            this.first_class = simpleForum.first_class;
            this.second_class = simpleForum.second_class;
            this.member_num = simpleForum.member_num.intValue();
            this.post_num = simpleForum.post_num.intValue();
            this.isBrandForum = simpleForum.is_brand_forum.intValue() == 1;
            if (simpleForum.multi_forum_perm != null && simpleForum.multi_forum_perm.is_block_bawu_delete.intValue() == 1) {
                z = true;
            }
            this.isBlockBawuDelete = z;
            this.mDeletedReasonInfo = simpleForum.deleted_reason_info;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
