package com.baidu.tbadk.core.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
public class bk extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.aj {
    public static final BdUniqueId TL = BdUniqueId.gen();
    public static final BdUniqueId TM = BdUniqueId.gen();
    public static final BdUniqueId TO = BdUniqueId.gen();
    public static final BdUniqueId TP = BdUniqueId.gen();
    public static final BdUniqueId TQ = BdUniqueId.gen();
    public static final BdUniqueId TR = BdUniqueId.gen();
    public static AtomicBoolean TS = new AtomicBoolean(false);
    public static final BdUniqueId TT = BdUniqueId.gen();
    public static final BdUniqueId TU = BdUniqueId.gen();
    public static final BdUniqueId TV = BdUniqueId.gen();
    public static final BdUniqueId TW = BdUniqueId.gen();
    private static HashMap<Point, Integer> UI = new HashMap<>();
    private static HashMap<Integer, Integer> UJ = new HashMap<>();
    public static final BdUniqueId UV = BdUniqueId.gen();
    public static final BdUniqueId UW = BdUniqueId.gen();
    public static final BdUniqueId Vc = BdUniqueId.gen();
    private static HashMap<Point, Integer> Vt = new HashMap<>();
    private static SparseArray<an.a> Vu = new SparseArray<>(3);
    public TwZhiBoUser Sc;
    public List<TwAnchorProfitItem> Sd;
    private n UH;
    private LiveCoverStatus UN;
    private int UO;
    private bn UY;
    private SpannableStringBuilder Ui;
    public int Um;
    private int Un;
    private int Up;
    private String Us;
    private int Ut;
    private String Uu;
    private int Uw;
    private VideoInfo Uy;
    private long Uz;
    private SkinInfo Vb;
    private boolean Vd;
    public DealInfoData Ve;
    private String Vf;
    private boolean Vk;
    public String Vl;
    public String Vm;
    public String Vn;
    public long Vo;
    public boolean Vp;
    public String Vq;
    private String address;
    private String authorId;
    public boolean isDeal;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public int TX = 1;
    private String Uo = null;
    private int Qy = 0;
    public int UB = 0;
    private String UC = "";
    private String UK = "";
    private String id = null;
    private String TY = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int TZ = 0;
    private int Ua = 0;
    private String last_time = null;
    private long Ub = 0;
    private int Uc = 0;
    private int Ud = 0;
    private int Ue = 0;
    private bq Uf = new bq();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Uk = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Ul = new ArrayList<>();
    private int Ug = 0;
    private int Uh = 0;
    private String ad_url = null;
    private String Uj = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData Uq = new PraiseData();
    private AnchorInfoData Ur = new AnchorInfoData();
    private long time = 0;
    private int Uv = 0;
    private ArrayList<a> UE = new ArrayList<>();
    private bu UF = null;
    private d UG = null;
    private int UL = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Ux = new ArrayList<>();
    private boolean isHeadLive = false;
    private String UM = null;
    private int UD = 0;
    private PollInfo UQ = null;
    private boolean UR = false;
    private boolean US = false;
    private int UT = 0;
    private boolean UU = false;
    private int anchorLevel = 0;
    public int Vg = 0;
    public k Vh = new k();
    private List<PbContent> Vi = new ArrayList();
    private List<PbContent> Vj = new ArrayList();
    private String category_name = null;
    private bi UX = new bi();
    private ArrayList<com.baidu.tbadk.data.b> UZ = new ArrayList<>();
    private PushStatusData Va = new PushStatusData();
    public boolean Vr = false;
    public int Vs = -1;

    static {
        UI.put(new Point(1, 1), Integer.valueOf(r.f.label_frs_lottery_ing));
        UI.put(new Point(1, 2), Integer.valueOf(r.f.label_frs_lottery_over));
        UI.put(new Point(1, 3), Integer.valueOf(r.f.label_frs_lottery_off));
        UI.put(new Point(1, 4), Integer.valueOf(r.f.label_frs_lottery_d));
        UI.put(new Point(2, 1), Integer.valueOf(r.f.label_frs_activity_shaiing));
        UI.put(new Point(2, 2), Integer.valueOf(r.f.label_frs_activity_shai_over));
        UI.put(new Point(2, 3), Integer.valueOf(r.f.label_frs_activity_shai_off));
        UI.put(new Point(2, 4), Integer.valueOf(r.f.label_frs_activity_shai_d));
        Vt.put(new Point(1, 1), Integer.valueOf(r.j.lottery_status_ing));
        Vt.put(new Point(1, 2), Integer.valueOf(r.j.lottery_status_over));
        Vt.put(new Point(1, 3), Integer.valueOf(r.j.lottery_status_off));
        Vt.put(new Point(1, 4), Integer.valueOf(r.j.lottery_status_not_start));
        Vt.put(new Point(2, 1), Integer.valueOf(r.j.share_picture_status_ing));
        Vt.put(new Point(2, 2), Integer.valueOf(r.j.share_picture_status_over));
        Vt.put(new Point(2, 3), Integer.valueOf(r.j.share_picture_status_off));
        Vt.put(new Point(2, 4), Integer.valueOf(r.j.share_picture_status_not_start));
        UJ.put(1, Integer.valueOf(r.f.label_interview_no));
        UJ.put(2, Integer.valueOf(r.f.label_interview_live));
        UJ.put(3, Integer.valueOf(r.f.label_interview_off));
        Vu.put(1, new an.a(r.j.interview_live_status_not_start, r.d.cp_other_b, r.f.pic_dot_title_red));
        Vu.put(2, new an.a(r.j.interview_live_status_ing, r.d.cp_other_c, r.f.pic_dot_title_green));
        Vu.put(3, new an.a(r.j.interview_live_status_over, r.d.cp_other_d, r.f.pic_dot_title_blue));
    }

    public bk() {
        this.Un = 0;
        this.Uw = 0;
        this.UO = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.UO = 0;
        this.Uw = 0;
        this.Un = 0;
    }

    public boolean ry() {
        return this.Un == 1;
    }

    public bi rz() {
        return this.UX;
    }

    public bn rA() {
        return this.UY;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int rB() {
        return this.Uw;
    }

    public boolean rC() {
        return this.UU;
    }

    public boolean rD() {
        return this.UR;
    }

    public boolean rE() {
        return this.US;
    }

    public void bT(int i) {
        this.UT = i;
    }

    public int rF() {
        return this.UT;
    }

    public PollInfo rG() {
        return this.UQ;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Uz;
    }

    public PraiseData rH() {
        return this.Uq;
    }

    public void a(PraiseData praiseData) {
        this.Uq = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void cw(String str) {
        this.TY = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.TY) || "0".equals(this.TY)) ? this.id : this.TY;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String rI() {
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

    public int rJ() {
        return this.reply_num;
    }

    public long rK() {
        return this.Ub;
    }

    public void o(long j) {
        this.Ub = j;
    }

    public int rL() {
        return this.Uc;
    }

    public void bV(int i) {
        this.Uc = i;
    }

    public int rM() {
        return this.Ud;
    }

    public void bW(int i) {
        this.Ud = i;
    }

    public int rN() {
        return this.Ue;
    }

    public List<PbContent> rO() {
        return this.Vi;
    }

    public bq rP() {
        return this.Uf;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rQ() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rR() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean rS() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean rT() {
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

    public int rU() {
        return this.Uh;
    }

    public String rV() {
        return this.ad_url;
    }

    public String rW() {
        return this.Uj;
    }

    public void cx(String str) {
        this.Uj = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.Vj == null || this.Vj.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.Vj.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.Vj.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.Vi == null || (size = this.Vi.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.Vi.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cy(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.Vj != null && (size = this.Vj.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.Vj.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (!TextUtils.isEmpty(pbContent.text)) {
                    if (pbContent.text.length() + i3 > spannableString.length()) {
                        break;
                    }
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bl(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public String rX() {
        return this.Uo;
    }

    public void cz(String str) {
        this.Uo = str;
    }

    public ArrayList<MediaData> rY() {
        return this.Uk;
    }

    public ArrayList<a> rZ() {
        return this.UE;
    }

    public void i(ArrayList<a> arrayList) {
        this.UE = arrayList;
    }

    public bu sa() {
        return this.UF;
    }

    public d sb() {
        return this.UG;
    }

    public ArrayList<VoiceData.VoiceModel> sc() {
        return this.Ul;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int sd() {
        return this.Ut;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String se() {
        return this.UC;
    }

    public VideoInfo sf() {
        return this.Uy;
    }

    public String getPhotoLiveCover() {
        return this.UK;
    }

    public void setPhotoLiveCover(String str) {
        this.UK = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> sg() {
        return this.Ux;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Ux.clear();
        this.Ux.addAll(arrayList);
    }

    public String getNotice() {
        return this.UM;
    }

    public PushStatusData sh() {
        return this.Va;
    }

    public SkinInfo si() {
        return this.Vb;
    }

    public long sj() {
        return this.Vo;
    }

    public boolean sk() {
        return this.Vp;
    }

    public String sl() {
        return this.Vq;
    }

    public boolean sm() {
        return "9090".equals(this.Vl);
    }

    public boolean sn() {
        return "9020".equals(this.Vl);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x002a: IGET  (r3v0 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x003b: IGET  (r3v1 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00f1: IGET  (r3v8 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0102: IGET  (r3v9 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.Uu = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.Un = threadInfo.is_tbread_dispatch.intValue();
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.TY = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Uz = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.TZ = threadInfo.repost_num.intValue();
                this.Ua = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.Ub = threadInfo.last_time_int.intValue();
                this.Uc = threadInfo.is_top.intValue();
                this.Ud = threadInfo.is_good.intValue();
                this.Ue = threadInfo.is_livepost.intValue();
                this.Uf.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Ug = threadInfo.has_commented.intValue();
                this.Uh = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Uy = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.Uo = threadInfo.collect_mark_pid;
                this.Up = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.Us = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.UC = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.Ut = threadInfo.is_ntitle.intValue();
                this.Uv = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Uw = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.Vk = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.Vi = threadInfo.rich_title;
                this.Vj = threadInfo.rich_abstract;
                this.Um = threadInfo.is_godthread_recommend.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (EcommSwitchStatic.GN()) {
                    this.isDeal = threadInfo.is_deal.intValue() == 1;
                    if (threadInfo.deal_info != null) {
                        this.Ve = new DealInfoData();
                        this.Ve.parserProtobuf(threadInfo.deal_info);
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
                this.Uj = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Uk.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Uy = threadInfo.video_info;
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
                        this.Ul.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.UE.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.UF = new bu();
                    this.UF.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.UG = new d();
                    this.UG.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.UH = new n();
                    this.UH.a(threadInfo.cartoon_info);
                }
                this.Uq.setUserMap(this.userMap);
                this.Uq.parserProtobuf(threadInfo.zan);
                this.Ur.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Uq.setTitle(this.title);
                } else {
                    this.Uq.setTitle(this.Uj);
                }
                this.UK = threadInfo.livecover_src;
                this.UL = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.UD = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.eh(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Ux.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.UM = noticeInfo.notice;
                    }
                    this.UT = zhiBoInfoTW.copythread_remind.intValue();
                    this.UR = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.US = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.UK)) {
                        this.UK = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.Sc = zhiBoInfoTW.user.tw_anchor_info;
                        this.Sd = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.UN = threadInfo.twzhibo_info.livecover_status;
                    this.UO = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.UQ = threadInfo.poll_info;
                this.UU = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.UX.a(threadInfo.task_info);
                }
                if (threadInfo.high_together != null) {
                    this.UY = new bn();
                    this.UY.a(threadInfo.high_together);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.UZ.add(bVar);
                    }
                }
                this.Va.parserProtobuf(threadInfo.push_status);
                this.Vf = threadInfo.lego_card;
                this.Vb = threadInfo.skin_info;
                this.Vg = threadInfo.is_book_chapter.intValue();
                this.Vh.a(threadInfo.book_chapter);
                this.Vl = threadInfo.recom_source;
                this.Vm = threadInfo.recom_weight;
                this.Vn = threadInfo.ab_tag;
                this.Vo = threadInfo.last_read_pid.longValue();
                this.Vp = threadInfo.cheak_repeat.intValue() == 1;
                this.Vq = threadInfo.recom_reason;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.TY = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.Uz = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.TZ = jSONObject.optInt("repost_num", 0);
                this.Ua = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.Ub = jSONObject.optLong("last_time_int", 0L);
                this.Uc = jSONObject.optInt("is_top", 0);
                this.Ud = jSONObject.optInt("is_good", 0);
                this.Ue = jSONObject.optInt("is_livepost", 0);
                this.Uf.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Ug = jSONObject.optInt("has_commented", 0);
                this.Uh = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.Uo = jSONObject.optString("collect_mark_pid");
                this.Up = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.Us = jSONObject.optString("first_post_id", "0");
                this.UC = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Ut = jSONObject.optInt("is_ntitle");
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
                this.Uj = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Uk.add(mediaData);
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
                        this.Ul.add(voiceModel);
                    }
                }
                if (EcommSwitchStatic.GN() && jSONObject != null) {
                    this.Ve = new DealInfoData();
                    this.Ve.parserJson(jSONObject);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.UE.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.UF = new bu();
                    this.UF.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.UG = new d();
                    this.UG.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.UH = new n();
                    this.UH.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.Uq.setUserMap(this.userMap);
                this.Uq.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.Ur.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Uq.setTitle(this.title);
                } else {
                    this.Uq.setTitle(this.Uj);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
                if (optJSONObject != null) {
                    this.UX.parserJson(optJSONObject);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.UZ.add(bVar);
                    }
                }
                this.Vg = jSONObject.optInt("is_book_chapter", 0);
                this.Vh.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.Vl = jSONObject.optString("recom_source");
                this.Vo = jSONObject.optLong("last_read_pid");
                this.Vp = jSONObject.optInt("cheak_repeat") == 1;
                this.Vq = jSONObject.optString("recom_reason");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder so() {
        return this.Ui;
    }

    public boolean sp() {
        return rL() != 0;
    }

    public int sq() {
        if (this.UX != null) {
            long rs = this.UX.rs();
            long rt = this.UX.rt();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rs) {
                return 1;
            }
            if (currentTimeMillis > rt) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sr() {
        if (st() && this.UE.size() >= 1) {
            a aVar = this.UE.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pb = aVar.pb();
            int pc = aVar.pc();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pb) {
                return 4;
            }
            return currentTimeMillis > pc ? 2 : 1;
        }
        return -1;
    }

    public int ss() {
        if (!st() || this.UE.size() < 1 || this.UE.get(0) == null) {
            return -1;
        }
        return this.UE.get(0).pa();
    }

    public boolean st() {
        return this.Uv == 1;
    }

    public String su() {
        return (!st() || this.UE.size() < 1 || this.UE.get(0) == null) ? "" : this.UE.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cA(String str) {
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
            if (getThreadType() == 42 && sv()) {
                arrayList.add(Integer.valueOf(r.f.icon_convene));
            }
            if (rL() == 1) {
                arrayList.add(Integer.valueOf(r.f.icon_top));
            } else if (rL() == 2) {
                arrayList.add(Integer.valueOf(r.f.icon_notice));
            }
            if (rN() == 1 || this.Uf.td() != 0) {
                if (rz() != null && getThreadType() == 41) {
                    if (sq() == 2) {
                        arrayList.add(Integer.valueOf(r.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(r.f.icon_zhibo));
                }
            }
            if (z && sG()) {
                Integer num = UJ.get(Integer.valueOf(sq()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rM() == 1 && !sp() && TP != getType() && TQ != getType()) {
                arrayList.add(Integer.valueOf(r.f.icon_elite));
            }
            if (getType() == TT || getType() == TU) {
                arrayList.add(Integer.valueOf(r.f.icon_vote_blue));
            }
            if (this.Ur != null && this.Ur.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(r.f.icon_live_on));
            }
            if (rU() == 1) {
                arrayList.add(Integer.valueOf(r.f.frs_post_ding));
            }
            if (!z && ss() == 2) {
                arrayList.add(Integer.valueOf(r.f.label_frs_activity_shai));
            } else {
                Integer num2 = UI.get(new Point(ss(), sr()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (sa() != null) {
                arrayList.add(Integer.valueOf(r.f.tag_act));
            }
            if (sb() != null) {
                arrayList.add(Integer.valueOf(r.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cA(this.category_name);
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
                Bitmap cO = com.baidu.tbadk.core.util.at.cO(((Integer) arrayList.get(i3)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                }
                com.baidu.tbadk.core.view.ah ahVar = new com.baidu.tbadk.core.view.ah(bitmapDrawable);
                ahVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.TX));
                spannableString.setSpan(ahVar, i2, i2 + 1, 33);
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
        this.Ui = spannableStringBuilder;
    }

    private boolean sv() {
        return com.baidu.adp.lib.c.e.dN().ac("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        if (z2) {
            if (z) {
                if (rN() == 1 || getThreadType() == 33 || (rP() != null && rP().td() != 0)) {
                    if (rz() != null && sG()) {
                        if (sq() == 2) {
                            arrayList.add(new an.a(r.j.interview_live));
                        }
                    } else {
                        arrayList.add(new an.a(r.j.kn_zhibo));
                    }
                }
                if (rL() == 1) {
                    arrayList.add(new an.a(r.j.commit_top));
                }
                if (rM() == 1) {
                    arrayList.add(new an.a(r.j.good));
                }
                if (sG()) {
                    arrayList.add(Vu.get(sq()));
                }
                if (st()) {
                    Integer num = Vt.get(new Point(ss(), sr()));
                    if (num != null) {
                        arrayList.add(new an.a(num.intValue(), r.d.cp_other_b, r.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new an.a(r.j.card_promotion_text));
                    }
                }
                if (sH()) {
                    arrayList.add(new an.a(r.j.evaluation));
                }
                if (sa() != null) {
                    arrayList.add(new an.a(r.j.card_promotion_text, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ax.isEmpty(rI())) {
                    arrayList.add(new an.a(rI()));
                }
            } else {
                if (rN() == 1 && !sG()) {
                    arrayList.add(new an.a(r.j.kn_zhibo));
                }
                if (rM() == 1) {
                    arrayList.add(new an.a(r.j.good));
                }
                if (rL() == 1) {
                    arrayList.add(new an.a(r.j.commit_top));
                }
                if (sG() && rz() != null && sq() == 2) {
                    arrayList.add(new an.a(r.j.interview_live));
                }
                if (st()) {
                    Integer num2 = Vt.get(new Point(ss(), sr()));
                    if (num2 != null) {
                        arrayList.add(new an.a(num2.intValue(), r.d.cp_other_b, r.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new an.a(r.j.card_promotion_text));
                    }
                }
                if (this.Vg == 1) {
                    arrayList.add(new an.a(r.j.card_tbread_text));
                }
                if (sb() != null) {
                    arrayList.add(new an.a(r.j.send_app_code_gift, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (sa() != null) {
                    arrayList.add(new an.a(r.j.card_promotion_text, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (sH()) {
                    arrayList.add(new an.a(r.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.ax.isEmpty(rI())) {
                    arrayList.add(new an.a(rI()));
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
        this.Ui = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.Vi != null && this.Vi.size() > 0) {
            int size = this.Vi.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.Vi.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bm(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public void sw() {
        d(false, false);
    }

    public void sx() {
        d(true, false);
    }

    public void sy() {
        d(false, true);
    }

    public AnchorInfoData sz() {
        return this.Ur;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sA() {
        return this.threadType == 36;
    }

    public boolean sB() {
        return this.threadType == 40;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sC() {
        return this.UD;
    }

    public void bX(int i) {
        this.UD = i;
    }

    public int sD() {
        return this.UO;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<com.baidu.tbadk.core.util.ai> getImages() {
        ArrayList<MediaData> rY = rY();
        if (rY == null || sp()) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.ai> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rY.size() || i2 >= 3) {
                break;
            }
            if (rY.get(i2) != null && rY.get(i2).getType() == 3) {
                com.baidu.tbadk.core.util.ai aiVar = new com.baidu.tbadk.core.util.ai();
                if (!StringUtils.isNull(rY.get(i2).getThumbnails_url())) {
                    aiVar.imgUrl = rY.get(i2).getThumbnails_url();
                } else {
                    aiVar.imgUrl = rY.get(i2).getPicUrl();
                }
                aiVar.abD = 13;
                arrayList.add(aiVar);
            }
            i = i2 + 1;
        }
        if (this.Uy != null && !StringUtils.isNull(this.Uy.thumbnail_url)) {
            com.baidu.tbadk.core.util.ai aiVar2 = new com.baidu.tbadk.core.util.ai();
            aiVar2.imgUrl = this.Uy.thumbnail_url;
            aiVar2.abD = 13;
            arrayList.add(aiVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.ai aiVar3 = new com.baidu.tbadk.core.util.ai();
            aiVar3.imgUrl = this.author.getPortrait();
            aiVar3.abD = 28;
            arrayList.add(aiVar3);
        }
        return arrayList;
    }

    public boolean sE() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int rL = rL();
        if (rL == 2 || rL == 1) {
            return TL;
        }
        if (this.isDeal && this.Ve != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            return TR;
        }
        if (this.Uy != null && sP()) {
            return TW;
        }
        if (this.Uy != null) {
            if (rR()) {
                return TQ;
            }
            return TP;
        } else if (rG() != null && getThreadType() == 36 && rG().type.intValue() == 2) {
            return TT;
        } else {
            if (rG() != null && getThreadType() == 36 && rG().type.intValue() == 1) {
                return TU;
            }
            if (rz() != null && getThreadType() == 41 && rN() == 1 && sq() == 2) {
                return TS.get() ? UW : TM;
            } else if (st() && ss() == 1) {
                return TS.get() ? Vc : TM;
            } else if (rA() != null && !TextUtils.isEmpty(rA().getActivityName())) {
                return TV;
            } else {
                if (st() && ss() == 2) {
                    return TS.get() ? UV : TM;
                } else if (rR()) {
                    return TO;
                } else {
                    return TM;
                }
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sF() {
        return this.UN;
    }

    public List<TwAnchorProfitItem> qp() {
        return this.Sd;
    }

    public void j(ArrayList<o> arrayList) {
        if (this.Ut == 1) {
            this.Qy = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Qy = 0;
        } else {
            this.Qy = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.px() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.px().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Qy = next.py();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sG() {
        return this.threadType == 41;
    }

    public boolean sH() {
        return this.threadType == 48;
    }

    public boolean sI() {
        return this.Vd;
    }

    public void ar(boolean z) {
        this.Vd = z;
    }

    public String sJ() {
        return this.Vf;
    }

    public n sK() {
        return this.UH;
    }

    public boolean sL() {
        return rN() == 1 || rM() == 1 || rL() == 1 || st() || this.Vg == 1 || sb() != null || sa() != null || !com.baidu.adp.lib.util.j.isEmpty(rI()) || sH();
    }

    public DealInfoData sM() {
        return this.Ve;
    }

    public void sN() {
        if (this.UB == 0) {
            this.UB = 1;
        }
    }

    public boolean sO() {
        return this.Vk;
    }

    public void as(boolean z) {
        this.Vr = z;
    }

    public boolean sP() {
        return this.Vr;
    }

    public void bY(int i) {
        this.Vs = i + 1;
    }

    public int sQ() {
        return this.Vs;
    }
}
