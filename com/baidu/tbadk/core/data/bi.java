package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.switchs.EcommSwitchStatic;
import com.baidu.tieba.card.an;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.LiveCoverStatus;
import tbclient.Media;
import tbclient.NoticeInfo;
import tbclient.PbContent;
import tbclient.PollInfo;
import tbclient.SkinInfo;
import tbclient.ThreadInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class bi extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.al {
    public TwZhiBoUser RF;
    public List<TwAnchorProfitItem> RG;
    private SpannableStringBuilder TL;
    public int TQ;
    private int TR;
    private int TT;
    private String TW;
    private int TX;
    private String TY;
    private bl UB;
    private SkinInfo UE;
    private boolean UG;
    public DealInfoData UH;
    private String UI;
    private boolean UN;
    public String UO;
    public String UQ;
    public String UR;
    public long US;
    public boolean UT;
    public String UU;
    private int Ua;
    private VideoInfo Uc;
    private long Ud;
    private m Uk;
    private LiveCoverStatus Uq;
    private int Ur;
    private String address;
    private String authorId;
    public boolean isDeal;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Tq = BdUniqueId.gen();
    public static final BdUniqueId Tr = BdUniqueId.gen();
    public static final BdUniqueId Ts = BdUniqueId.gen();
    public static final BdUniqueId Tt = BdUniqueId.gen();
    public static final BdUniqueId Tu = BdUniqueId.gen();
    public static final BdUniqueId Tv = BdUniqueId.gen();
    public static AtomicBoolean Tw = new AtomicBoolean(false);
    public static final BdUniqueId Tx = BdUniqueId.gen();
    public static final BdUniqueId Ty = BdUniqueId.gen();
    public static final BdUniqueId Tz = BdUniqueId.gen();
    private static HashMap<Point, Integer> Ul = new HashMap<>();
    private static HashMap<Integer, Integer> Um = new HashMap<>();
    public static final BdUniqueId Ux = BdUniqueId.gen();
    public static final BdUniqueId Uy = BdUniqueId.gen();
    public static final BdUniqueId UF = BdUniqueId.gen();
    private static HashMap<Point, Integer> UV = new HashMap<>();
    private static SparseArray<an.a> UW = new SparseArray<>(3);
    public int TA = 1;
    private String TS = null;
    private int Qg = 0;
    public int Ue = 0;
    private String Uf = "";
    private String Un = "";
    private String id = null;
    private String TB = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int TC = 0;
    private int TD = 0;
    private String last_time = null;
    private long TE = 0;
    private int TF = 0;
    private int TG = 0;
    private int TH = 0;
    private bo TI = new bo();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> TO = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> TP = new ArrayList<>();
    private int TJ = 0;
    private int TK = 0;
    private String ad_url = null;
    private String TM = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData TU = new PraiseData();
    private AnchorInfoData TV = new AnchorInfoData();
    private long time = 0;
    private int TZ = 0;
    private ArrayList<a> Uh = new ArrayList<>();
    private bs Ui = null;
    private c Uj = null;
    private int Uo = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Ub = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Up = null;
    private int Ug = 0;
    private PollInfo Us = null;
    private boolean Ut = false;
    private boolean Uu = false;
    private int Uv = 0;
    private boolean Uw = false;
    private int anchorLevel = 0;
    public int UJ = 0;
    public j UK = new j();
    private List<PbContent> UL = new ArrayList();
    private List<PbContent> UM = new ArrayList();
    private String category_name = null;
    private bg Uz = new bg();
    private ArrayList<com.baidu.tbadk.data.b> UC = new ArrayList<>();
    private PushStatusData UD = new PushStatusData();

    static {
        Ul.put(new Point(1, 1), Integer.valueOf(r.f.label_frs_lottery_ing));
        Ul.put(new Point(1, 2), Integer.valueOf(r.f.label_frs_lottery_over));
        Ul.put(new Point(1, 3), Integer.valueOf(r.f.label_frs_lottery_off));
        Ul.put(new Point(1, 4), Integer.valueOf(r.f.label_frs_lottery_d));
        Ul.put(new Point(2, 1), Integer.valueOf(r.f.label_frs_activity_shaiing));
        Ul.put(new Point(2, 2), Integer.valueOf(r.f.label_frs_activity_shai_over));
        Ul.put(new Point(2, 3), Integer.valueOf(r.f.label_frs_activity_shai_off));
        Ul.put(new Point(2, 4), Integer.valueOf(r.f.label_frs_activity_shai_d));
        UV.put(new Point(1, 1), Integer.valueOf(r.j.lottery_status_ing));
        UV.put(new Point(1, 2), Integer.valueOf(r.j.lottery_status_over));
        UV.put(new Point(1, 3), Integer.valueOf(r.j.lottery_status_off));
        UV.put(new Point(1, 4), Integer.valueOf(r.j.lottery_status_not_start));
        UV.put(new Point(2, 1), Integer.valueOf(r.j.share_picture_status_ing));
        UV.put(new Point(2, 2), Integer.valueOf(r.j.share_picture_status_over));
        UV.put(new Point(2, 3), Integer.valueOf(r.j.share_picture_status_off));
        UV.put(new Point(2, 4), Integer.valueOf(r.j.share_picture_status_not_start));
        Um.put(1, Integer.valueOf(r.f.label_interview_no));
        Um.put(2, Integer.valueOf(r.f.label_interview_live));
        Um.put(3, Integer.valueOf(r.f.label_interview_off));
        UW.put(1, new an.a(r.j.interview_live_status_not_start, r.d.cp_other_b, r.f.pic_dot_title_red));
        UW.put(2, new an.a(r.j.interview_live_status_ing, r.d.cp_other_c, r.f.pic_dot_title_green));
        UW.put(3, new an.a(r.j.interview_live_status_over, r.d.cp_other_d, r.f.pic_dot_title_blue));
    }

    public bi() {
        this.TR = 0;
        this.Ua = 0;
        this.Ur = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Ur = 0;
        this.Ua = 0;
        this.TR = 0;
    }

    public boolean rw() {
        return this.TR == 1;
    }

    public bg rx() {
        return this.Uz;
    }

    public bl ry() {
        return this.UB;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int rz() {
        return this.Ua;
    }

    public boolean rA() {
        return this.Uw;
    }

    public boolean rB() {
        return this.Ut;
    }

    public boolean rC() {
        return this.Uu;
    }

    public void bT(int i) {
        this.Uv = i;
    }

    public int rD() {
        return this.Uv;
    }

    public PollInfo rE() {
        return this.Us;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Ud;
    }

    public PraiseData rF() {
        return this.TU;
    }

    public void a(PraiseData praiseData) {
        this.TU = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void cu(String str) {
        this.TB = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.TB) || "0".equals(this.TB)) ? this.id : this.TB;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String rG() {
        return this.category_name;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void bU(int i) {
        this.reply_num = i;
    }

    public int rH() {
        return this.reply_num;
    }

    public long rI() {
        return this.TE;
    }

    public void p(long j) {
        this.TE = j;
    }

    public int rJ() {
        return this.TF;
    }

    public void bV(int i) {
        this.TF = i;
    }

    public int rK() {
        return this.TG;
    }

    public void bW(int i) {
        this.TG = i;
    }

    public int rL() {
        return this.TH;
    }

    public List<PbContent> rM() {
        return this.UL;
    }

    public bo rN() {
        return this.TI;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rO() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rP() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean rQ() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean rR() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return true;
        }
        return (this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String getForum_name() {
        return this.forum_name;
    }

    public void setForum_name(String str) {
        this.forum_name = str;
    }

    public int rS() {
        return this.TK;
    }

    public String rT() {
        return this.ad_url;
    }

    public String rU() {
        return this.TM;
    }

    public void cv(String str) {
        this.TM = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.UM == null || this.UM.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.UM.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.UM.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.UL == null || (size = this.UL.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.UL.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cw(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.UM != null && (size = this.UM.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.UM.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (!TextUtils.isEmpty(pbContent.text)) {
                    if (pbContent.text.length() + i3 > spannableString.length()) {
                        break;
                    }
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bj(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
                    }
                    i = pbContent.text.length() + i3;
                } else {
                    i = i3;
                }
                i2++;
                i3 = i;
            }
        }
        return spannableString;
    }

    public int getIsMarked() {
        return this.isMarked;
    }

    public void setIsMarked(int i) {
        this.isMarked = i;
    }

    public String rV() {
        return this.TS;
    }

    public void cx(String str) {
        this.TS = str;
    }

    public ArrayList<MediaData> rW() {
        return this.TO;
    }

    public ArrayList<a> rX() {
        return this.Uh;
    }

    public void i(ArrayList<a> arrayList) {
        this.Uh = arrayList;
    }

    public bs rY() {
        return this.Ui;
    }

    public c rZ() {
        return this.Uj;
    }

    public ArrayList<VoiceData.VoiceModel> sa() {
        return this.TP;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int sb() {
        return this.TX;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String sc() {
        return this.Uf;
    }

    public VideoInfo sd() {
        return this.Uc;
    }

    public String getPhotoLiveCover() {
        return this.Un;
    }

    public void setPhotoLiveCover(String str) {
        this.Un = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> se() {
        return this.Ub;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Ub.clear();
        this.Ub.addAll(arrayList);
    }

    public String getNotice() {
        return this.Up;
    }

    public PushStatusData sf() {
        return this.UD;
    }

    public SkinInfo sg() {
        return this.UE;
    }

    public long sh() {
        return this.US;
    }

    public boolean si() {
        return this.UT;
    }

    public String sj() {
        return this.UU;
    }

    public boolean sk() {
        return "9090".equals(this.UO);
    }

    public boolean sl() {
        return "9020".equals(this.UO);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x002a: IGET  (r3v2 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x003b: IGET  (r3v3 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00f1: IGET  (r3v10 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0102: IGET  (r3v11 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.TY = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.TR = threadInfo.is_tbread_dispatch.intValue();
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.TB = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Ud = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.TC = threadInfo.repost_num.intValue();
                this.TD = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.TE = threadInfo.last_time_int.intValue();
                this.TF = threadInfo.is_top.intValue();
                this.TG = threadInfo.is_good.intValue();
                this.TH = threadInfo.is_livepost.intValue();
                this.TI.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.TJ = threadInfo.has_commented.intValue();
                this.TK = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Uc = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.TS = threadInfo.collect_mark_pid;
                this.TT = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.TW = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Uf = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.TX = threadInfo.is_ntitle.intValue();
                this.TZ = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Ua = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.UN = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.UL = threadInfo.rich_title;
                this.UM = threadInfo.rich_abstract;
                this.TQ = threadInfo.is_godthread_recommend.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (EcommSwitchStatic.GK()) {
                    this.isDeal = threadInfo.is_deal.intValue() == 1;
                    if (threadInfo.deal_info != null) {
                        this.UH = new DealInfoData();
                        this.UH.parserProtobuf(threadInfo.deal_info);
                    }
                }
                StringBuilder sb = new StringBuilder();
                List<Abstract> list = threadInfo._abstract;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) != null) {
                            if (list.get(i).type.intValue() == 0) {
                                sb.append(list.get(i).text);
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.TM = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.TO.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Uc = threadInfo.video_info;
                }
                List<Voice> list3 = threadInfo.voice_info;
                if (list3 != null) {
                    int size = list3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        Voice voice = list3.get(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = voice.voice_md5;
                        voiceModel.duration = voice.during_time.intValue() / 1000;
                        this.TP.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Uh.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Ui = new bs();
                    this.Ui.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Uj = new c();
                    this.Uj.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Uk = new m();
                    this.Uk.a(threadInfo.cartoon_info);
                }
                this.TU.setUserMap(this.userMap);
                this.TU.parserProtobuf(threadInfo.zan);
                this.TV.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.TU.setTitle(this.title);
                } else {
                    this.TU.setTitle(this.TM);
                }
                this.Un = threadInfo.livecover_src;
                this.Uo = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Ug = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.ef(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Ub.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Up = noticeInfo.notice;
                    }
                    this.Uv = zhiBoInfoTW.copythread_remind.intValue();
                    this.Ut = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Uu = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Un)) {
                        this.Un = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.RF = zhiBoInfoTW.user.tw_anchor_info;
                        this.RG = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Uq = threadInfo.twzhibo_info.livecover_status;
                    this.Ur = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Us = threadInfo.poll_info;
                this.Uw = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Uz.a(threadInfo.task_info);
                }
                if (threadInfo.high_together != null) {
                    this.UB = new bl();
                    this.UB.a(threadInfo.high_together);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.UC.add(bVar);
                    }
                }
                this.UD.parserProtobuf(threadInfo.push_status);
                this.UI = threadInfo.lego_card;
                this.UE = threadInfo.skin_info;
                this.UJ = threadInfo.is_book_chapter.intValue();
                this.UK.a(threadInfo.book_chapter);
                this.UO = threadInfo.recom_source;
                this.UQ = threadInfo.recom_weight;
                this.UR = threadInfo.ab_tag;
                this.US = threadInfo.last_read_pid.longValue();
                this.UT = threadInfo.cheak_repeat.intValue() == 1;
                this.UU = threadInfo.recom_reason;
            } catch (Exception e) {
                Log.e("threadData", "ex: " + e.getMessage());
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.TB = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.Ud = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.TC = jSONObject.optInt("repost_num", 0);
                this.TD = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.TE = jSONObject.optLong("last_time_int", 0L);
                this.TF = jSONObject.optInt("is_top", 0);
                this.TG = jSONObject.optInt("is_good", 0);
                this.TH = jSONObject.optInt("is_livepost", 0);
                this.TI.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.TJ = jSONObject.optInt("has_commented", 0);
                this.TK = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.TS = jSONObject.optString("collect_mark_pid");
                this.TT = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.TW = jSONObject.optString("first_post_id", "0");
                this.Uf = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.TX = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (optJSONArray.getJSONObject(i) != null) {
                            if (optJSONArray.getJSONObject(i).optInt("type") == 0) {
                                sb.append(optJSONArray.getJSONObject(i).optString("text"));
                            }
                        } else {
                            return;
                        }
                    }
                }
                this.TM = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.TO.add(mediaData);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject2 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = jSONObject2.optString("voice_md5");
                        voiceModel.duration = jSONObject2.optInt("during_time") / 1000;
                        this.TP.add(voiceModel);
                    }
                }
                if (EcommSwitchStatic.GK() && jSONObject != null) {
                    this.UH = new DealInfoData();
                    this.UH.parserJson(jSONObject);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Uh.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Ui = new bs();
                    this.Ui.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Uj = new c();
                    this.Uj.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.Uk = new m();
                    this.Uk.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.TU.setUserMap(this.userMap);
                this.TU.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.TV.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.TU.setTitle(this.title);
                } else {
                    this.TU.setTitle(this.TM);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
                if (optJSONObject != null) {
                    this.Uz.parserJson(optJSONObject);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.UC.add(bVar);
                    }
                }
                this.UJ = jSONObject.optInt("is_book_chapter", 0);
                this.UK.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.UO = jSONObject.optString("recom_source");
                this.US = jSONObject.optLong("last_read_pid");
                this.UT = jSONObject.optInt("cheak_repeat") == 1;
                this.UU = jSONObject.optString("recom_reason");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sm() {
        return this.TL;
    }

    public boolean sn() {
        return rJ() != 0;
    }

    public int so() {
        if (this.Uz != null) {
            long rq = this.Uz.rq();
            long rr = this.Uz.rr();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rq) {
                return 1;
            }
            if (currentTimeMillis > rr) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sp() {
        if (sr() && this.Uh.size() >= 1) {
            a aVar = this.Uh.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int oZ = aVar.oZ();
            int pa = aVar.pa();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < oZ) {
                return 4;
            }
            return currentTimeMillis > pa ? 2 : 1;
        }
        return -1;
    }

    public int sq() {
        if (!sr() || this.Uh.size() < 1 || this.Uh.get(0) == null) {
            return -1;
        }
        return this.Uh.get(0).oY();
    }

    public boolean sr() {
        return this.TZ == 1;
    }

    public String ss() {
        return (!sr() || this.Uh.size() < 1 || this.Uh.get(0) == null) ? "" : this.Uh.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cy(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m9getInst().getApplicationContext()).inflate(r.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(r.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m9getInst().getApplicationContext().getResources().getColor(r.d.cp_cont_f_1));
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            inflate.layout(0, 0, inflate.getWidth(), inflate.getHeight());
            textView.setDrawingCacheEnabled(true);
            textView.buildDrawingCache();
            Bitmap drawingCache = textView.getDrawingCache();
            if (drawingCache != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(drawingCache);
                bitmapDrawable.setBounds(0, 0, drawingCache.getWidth(), drawingCache.getHeight());
                dVar = new com.baidu.adp.widget.d(bitmapDrawable, 1);
            } else {
                dVar = null;
            }
            return dVar;
        }
        return null;
    }

    private void d(boolean z, boolean z2) {
        SpannableString spannableString;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        com.baidu.adp.widget.d dVar = null;
        if (!z2) {
            if (getThreadType() == 42 && st()) {
                arrayList.add(Integer.valueOf(r.f.icon_convene));
            }
            if (rJ() == 1) {
                arrayList.add(Integer.valueOf(r.f.icon_top));
            } else if (rJ() == 2) {
                arrayList.add(Integer.valueOf(r.f.icon_notice));
            }
            if (rL() == 1 || this.TI.sZ() != 0) {
                if (rx() != null && getThreadType() == 41) {
                    if (so() == 2) {
                        arrayList.add(Integer.valueOf(r.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(r.f.icon_zhibo));
                }
            }
            if (z && sE()) {
                Integer num = Um.get(Integer.valueOf(so()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rK() == 1 && !sn() && Tt != getType() && Tu != getType()) {
                arrayList.add(Integer.valueOf(r.f.icon_elite));
            }
            if (getType() == Tx || getType() == Ty) {
                arrayList.add(Integer.valueOf(r.f.icon_vote_blue));
            }
            if (this.TV != null && this.TV.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(r.f.icon_live_on));
            }
            if (rS() == 1) {
                arrayList.add(Integer.valueOf(r.f.frs_post_ding));
            }
            if (!z && sq() == 2) {
                arrayList.add(Integer.valueOf(r.f.label_frs_activity_shai));
            } else {
                Integer num2 = Ul.get(new Point(sq(), sp()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rY() != null) {
                arrayList.add(Integer.valueOf(r.f.tag_act));
            }
            if (rZ() != null) {
                arrayList.add(Integer.valueOf(r.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cy(this.category_name);
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append("1 ");
            }
            String sb2 = sb.toString();
            if (dVar != null) {
                spannableString = new SpannableString(String.valueOf(sb2) + this.category_name + " ");
            } else {
                spannableString = new SpannableString(sb2);
            }
            int i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bitmap cN = com.baidu.tbadk.core.util.av.cN(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                if (cN != null) {
                    bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
                }
                com.baidu.tbadk.core.view.ag agVar = new com.baidu.tbadk.core.view.ag(bitmapDrawable);
                agVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.TA));
                spannableString.setSpan(agVar, i2, i2 + 1, 33);
                i2 += 2;
            }
            if (dVar != null) {
                spannableString.setSpan(dVar, i2, this.category_name.length() + i2, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(String.valueOf(g) + " "), z);
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        }
        this.TL = spannableStringBuilder;
    }

    private boolean st() {
        return com.baidu.adp.lib.c.e.dN().ac("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        if (z2) {
            if (z) {
                if (rL() == 1 || getThreadType() == 33 || (rN() != null && rN().sZ() != 0)) {
                    if (rx() != null && sE()) {
                        if (so() == 2) {
                            arrayList.add(new an.a(r.j.interview_live));
                        }
                    } else {
                        arrayList.add(new an.a(r.j.kn_zhibo));
                    }
                }
                if (rJ() == 1) {
                    arrayList.add(new an.a(r.j.commit_top));
                }
                if (rK() == 1) {
                    arrayList.add(new an.a(r.j.good));
                }
                if (sE()) {
                    arrayList.add(UW.get(so()));
                }
                if (sr()) {
                    Integer num = UV.get(new Point(sq(), sp()));
                    if (num != null) {
                        arrayList.add(new an.a(num.intValue(), r.d.cp_other_b, r.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new an.a(r.j.card_promotion_text));
                    }
                }
                if (sy()) {
                    arrayList.add(new an.a(r.j.vote));
                }
                if (sF()) {
                    arrayList.add(new an.a(r.j.evaluation));
                }
                if (rY() != null) {
                    arrayList.add(new an.a(r.j.card_promotion_text, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.az.isEmpty(rG())) {
                    arrayList.add(new an.a(rG()));
                }
            } else {
                if (rL() == 1 && !sE()) {
                    arrayList.add(new an.a(r.j.kn_zhibo));
                }
                if (rK() == 1) {
                    arrayList.add(new an.a(r.j.good));
                }
                if (rJ() == 1) {
                    arrayList.add(new an.a(r.j.commit_top));
                }
                if (sE() && rx() != null && so() == 2) {
                    arrayList.add(new an.a(r.j.interview_live));
                }
                if (sr()) {
                    Integer num2 = UV.get(new Point(sq(), sp()));
                    if (num2 != null) {
                        arrayList.add(new an.a(num2.intValue(), r.d.cp_other_b, r.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new an.a(r.j.card_promotion_text));
                    }
                }
                if (this.UJ == 1) {
                    arrayList.add(new an.a(r.j.card_tbread_text));
                }
                if (rZ() != null) {
                    arrayList.add(new an.a(r.j.send_app_code_gift, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (rY() != null) {
                    arrayList.add(new an.a(r.j.card_promotion_text, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (sF()) {
                    arrayList.add(new an.a(r.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.az.isEmpty(rG())) {
                    arrayList.add(new an.a(rG()));
                }
            }
        }
        if (arrayList.size() > 0) {
            spannableStringBuilder = com.baidu.tieba.card.an.a((Context) TbadkCoreApplication.m9getInst(), g, (ArrayList<an.a>) arrayList, false);
            if (spannableStringBuilder == null) {
                spannableStringBuilder = new SpannableStringBuilder();
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
        }
        SpannableString a = a(new SpannableString(String.valueOf(g) + " "), z);
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        } else if (arrayList.size() > 0 || spannableStringBuilder.length() == 0) {
            spannableStringBuilder.append((CharSequence) g);
        }
        this.TL = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.UL != null && this.UL.size() > 0) {
            int size = this.UL.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.UL.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bk(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
                    }
                    i = pbContent.text.length() + i3;
                } else {
                    return spannableString;
                }
                i2++;
                i3 = i;
            }
            return spannableString;
        }
        return spannableString;
    }

    public void su() {
        d(false, false);
    }

    public void sv() {
        d(true, false);
    }

    public void sw() {
        d(false, true);
    }

    public AnchorInfoData sx() {
        return this.TV;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sy() {
        return this.threadType == 36;
    }

    public boolean sz() {
        return this.threadType == 40;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sA() {
        return this.Ug;
    }

    public void bX(int i) {
        this.Ug = i;
    }

    public int sB() {
        return this.Ur;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<com.baidu.tbadk.core.util.ak> getImages() {
        ArrayList<MediaData> rW = rW();
        if (rW == null || sn()) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.ak> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rW.size() || i2 >= 3) {
                break;
            }
            if (rW.get(i2) != null && rW.get(i2).getType() == 3) {
                com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak();
                if (!StringUtils.isNull(rW.get(i2).getThumbnails_url())) {
                    akVar.imgUrl = rW.get(i2).getThumbnails_url();
                } else {
                    akVar.imgUrl = rW.get(i2).getPicUrl();
                }
                akVar.abe = 13;
                arrayList.add(akVar);
            }
            i = i2 + 1;
        }
        if (this.Uc != null && !StringUtils.isNull(this.Uc.thumbnail_url)) {
            com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak();
            akVar2.imgUrl = this.Uc.thumbnail_url;
            akVar2.abe = 13;
            arrayList.add(akVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.ak akVar3 = new com.baidu.tbadk.core.util.ak();
            akVar3.imgUrl = this.author.getPortrait();
            akVar3.abe = 28;
            arrayList.add(akVar3);
        }
        return arrayList;
    }

    public boolean sC() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int rJ = rJ();
        if (rJ == 2 || rJ == 1) {
            return Tq;
        }
        if (this.isDeal && this.UH != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            return Tv;
        }
        if (this.Uc != null) {
            if (rP()) {
                return Tu;
            }
            return Tt;
        } else if (rE() != null && getThreadType() == 36 && rE().type.intValue() == 2) {
            return Tx;
        } else {
            if (rE() != null && getThreadType() == 36 && rE().type.intValue() == 1) {
                return Ty;
            }
            if (rx() != null && getThreadType() == 41 && rL() == 1 && so() == 2) {
                return Tw.get() ? Uy : Tr;
            } else if (sr() && sq() == 1) {
                return Tw.get() ? UF : Tr;
            } else if (ry() != null && !TextUtils.isEmpty(ry().getActivityName())) {
                return Tz;
            } else {
                if (sr() && sq() == 2) {
                    return Tw.get() ? Ux : Tr;
                } else if (rP()) {
                    return Ts;
                } else {
                    return Tr;
                }
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sD() {
        return this.Uq;
    }

    public List<TwAnchorProfitItem> qn() {
        return this.RG;
    }

    public void j(ArrayList<n> arrayList) {
        if (this.TX == 1) {
            this.Qg = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Qg = 0;
        } else {
            this.Qg = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.pu() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pu().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Qg = next.pv();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sE() {
        return this.threadType == 41;
    }

    public boolean sF() {
        return this.threadType == 48;
    }

    public boolean sG() {
        return this.UG;
    }

    public void ap(boolean z) {
        this.UG = z;
    }

    public String sH() {
        return this.UI;
    }

    public m sI() {
        return this.Uk;
    }

    public boolean sJ() {
        return rL() == 1 || rK() == 1 || rJ() == 1 || sr() || this.UJ == 1 || rZ() != null || rY() != null || !com.baidu.adp.lib.util.j.isEmpty(rG()) || sF();
    }

    public DealInfoData sK() {
        return this.UH;
    }

    public void sL() {
        if (this.Ue == 0) {
            this.Ue = 1;
        }
    }

    public boolean sM() {
        return this.UN;
    }
}
