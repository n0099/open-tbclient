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
import com.baidu.tieba.card.ap;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.t;
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
public class bg extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.al {
    public List<TwAnchorProfitItem> RA;
    public TwZhiBoUser Rz;
    private SpannableStringBuilder TD;
    public int TH;
    private int TJ;
    private String TM;
    private int TO;
    private String TP;
    private int TR;
    private VideoInfo TT;
    private long TU;
    public String UD;
    public String UE;
    public String UF;
    public long UG;
    public boolean UH;
    public String UI;
    private m Ua;
    private LiveCoverStatus Ug;
    private int Uh;
    private bj Uq;
    private SkinInfo Ut;
    private boolean Uv;
    public DealInfoData Uw;
    private String Ux;
    private String address;
    private String authorId;
    public boolean isDeal;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Tj = BdUniqueId.gen();
    public static final BdUniqueId TYPE_NORMAL = BdUniqueId.gen();
    public static final BdUniqueId Tk = BdUniqueId.gen();
    public static final BdUniqueId Tl = BdUniqueId.gen();
    public static final BdUniqueId Tm = BdUniqueId.gen();
    public static final BdUniqueId Tn = BdUniqueId.gen();
    public static AtomicBoolean To = new AtomicBoolean(false);
    public static final BdUniqueId Tp = BdUniqueId.gen();
    public static final BdUniqueId Tq = BdUniqueId.gen();
    public static final BdUniqueId Tr = BdUniqueId.gen();
    private static HashMap<Point, Integer> Ub = new HashMap<>();
    private static HashMap<Integer, Integer> Uc = new HashMap<>();
    public static final BdUniqueId Un = BdUniqueId.gen();
    public static final BdUniqueId Uo = BdUniqueId.gen();
    public static final BdUniqueId Uu = BdUniqueId.gen();
    private static HashMap<Point, Integer> UJ = new HashMap<>();
    private static SparseArray<ap.a> UK = new SparseArray<>(3);
    public int Ts = 1;
    private String TI = null;
    private int Qi = 0;
    private String TV = "";
    private String Ud = "";
    private String id = null;
    private String Tt = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int Tu = 0;
    private int Tv = 0;
    private String last_time = null;
    private long Tw = 0;
    private int Tx = 0;
    private int Ty = 0;
    private int Tz = 0;
    private bm TA = new bm();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> TF = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> TG = new ArrayList<>();
    private int TB = 0;
    private int TC = 0;
    private String ad_url = null;
    private String TE = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData TK = new PraiseData();
    private AnchorInfoData TL = new AnchorInfoData();
    private long time = 0;
    private int TQ = 0;
    private ArrayList<a> TX = new ArrayList<>();
    private bq TY = null;
    private c TZ = null;
    private int Ue = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> TS = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Uf = null;
    private int TW = 0;
    private PollInfo Ui = null;
    private boolean Uj = false;
    private boolean Uk = false;
    private int Ul = 0;
    private boolean Um = false;
    private int anchorLevel = 0;
    public int Uy = 0;
    public j Uz = new j();
    private List<PbContent> UB = new ArrayList();
    private List<PbContent> UC = new ArrayList();
    private String category_name = null;
    private be Up = new be();
    private ArrayList<com.baidu.tbadk.data.b> Ur = new ArrayList<>();
    private PushStatusData Us = new PushStatusData();

    static {
        Ub.put(new Point(1, 1), Integer.valueOf(t.f.label_frs_lottery_ing));
        Ub.put(new Point(1, 2), Integer.valueOf(t.f.label_frs_lottery_over));
        Ub.put(new Point(1, 3), Integer.valueOf(t.f.label_frs_lottery_off));
        Ub.put(new Point(1, 4), Integer.valueOf(t.f.label_frs_lottery_d));
        Ub.put(new Point(2, 1), Integer.valueOf(t.f.label_frs_activity_shaiing));
        Ub.put(new Point(2, 2), Integer.valueOf(t.f.label_frs_activity_shai_over));
        Ub.put(new Point(2, 3), Integer.valueOf(t.f.label_frs_activity_shai_off));
        Ub.put(new Point(2, 4), Integer.valueOf(t.f.label_frs_activity_shai_d));
        UJ.put(new Point(1, 1), Integer.valueOf(t.j.lottery_status_ing));
        UJ.put(new Point(1, 2), Integer.valueOf(t.j.lottery_status_over));
        UJ.put(new Point(1, 3), Integer.valueOf(t.j.lottery_status_off));
        UJ.put(new Point(1, 4), Integer.valueOf(t.j.lottery_status_not_start));
        UJ.put(new Point(2, 1), Integer.valueOf(t.j.share_picture_status_ing));
        UJ.put(new Point(2, 2), Integer.valueOf(t.j.share_picture_status_over));
        UJ.put(new Point(2, 3), Integer.valueOf(t.j.share_picture_status_off));
        UJ.put(new Point(2, 4), Integer.valueOf(t.j.share_picture_status_not_start));
        Uc.put(1, Integer.valueOf(t.f.label_interview_no));
        Uc.put(2, Integer.valueOf(t.f.label_interview_live));
        Uc.put(3, Integer.valueOf(t.f.label_interview_off));
        UK.put(1, new ap.a(t.j.interview_live_status_not_start, t.d.cp_other_b, t.f.pic_dot_title_red));
        UK.put(2, new ap.a(t.j.interview_live_status_ing, t.d.cp_other_c, t.f.pic_dot_title_green));
        UK.put(3, new ap.a(t.j.interview_live_status_over, t.d.cp_other_d, t.f.pic_dot_title_blue));
    }

    public bg() {
        this.TR = 0;
        this.Uh = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Uh = 0;
        this.TR = 0;
    }

    public be rl() {
        return this.Up;
    }

    public bj rm() {
        return this.Uq;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void setAnchorLevel(int i) {
        this.anchorLevel = i;
    }

    public int rn() {
        return this.TR;
    }

    public boolean ro() {
        return this.Um;
    }

    public boolean rp() {
        return this.Uj;
    }

    public boolean rq() {
        return this.Uk;
    }

    public void bT(int i) {
        this.Ul = i;
    }

    public int rr() {
        return this.Ul;
    }

    public PollInfo rs() {
        return this.Ui;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.TU;
    }

    public PraiseData rt() {
        return this.TK;
    }

    public void a(PraiseData praiseData) {
        this.TK = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void cs(String str) {
        this.Tt = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.Tt) || "0".equals(this.Tt)) ? this.id : this.Tt;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String ru() {
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

    public int rv() {
        return this.reply_num;
    }

    public long rw() {
        return this.Tw;
    }

    public void p(long j) {
        this.Tw = j;
    }

    public int rx() {
        return this.Tx;
    }

    public void bV(int i) {
        this.Tx = i;
    }

    public int ry() {
        return this.Ty;
    }

    public void bW(int i) {
        this.Ty = i;
    }

    public int rz() {
        return this.Tz;
    }

    public List<PbContent> rA() {
        return this.UB;
    }

    public bm rB() {
        return this.TA;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rC() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rD() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean rE() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean rF() {
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

    public int rG() {
        return this.TC;
    }

    public String rH() {
        return this.ad_url;
    }

    public String rI() {
        return this.TE;
    }

    public void ct(String str) {
        this.TE = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.UC == null || this.UC.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.UC.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.UC.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.UB == null || (size = this.UB.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.UB.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cu(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.UC != null && (size = this.UC.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.UC.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (!TextUtils.isEmpty(pbContent.text)) {
                    if (pbContent.text.length() + i3 > spannableString.length()) {
                        break;
                    }
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bh(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public String rJ() {
        return this.TI;
    }

    public void cv(String str) {
        this.TI = str;
    }

    public ArrayList<MediaData> rK() {
        return this.TF;
    }

    public ArrayList<a> rL() {
        return this.TX;
    }

    public void i(ArrayList<a> arrayList) {
        this.TX = arrayList;
    }

    public bq rM() {
        return this.TY;
    }

    public c rN() {
        return this.TZ;
    }

    public ArrayList<VoiceData.VoiceModel> rO() {
        return this.TG;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rP() {
        return this.TO;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rQ() {
        return this.TV;
    }

    public VideoInfo rR() {
        return this.TT;
    }

    public String getPhotoLiveCover() {
        return this.Ud;
    }

    public void setPhotoLiveCover(String str) {
        this.Ud = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> rS() {
        return this.TS;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.TS.clear();
        this.TS.addAll(arrayList);
    }

    public String getNotice() {
        return this.Uf;
    }

    public PushStatusData rT() {
        return this.Us;
    }

    public SkinInfo rU() {
        return this.Ut;
    }

    public long rV() {
        return this.UG;
    }

    public boolean rW() {
        return this.UH;
    }

    public String rX() {
        return this.UI;
    }

    public boolean rY() {
        return "9090".equals(this.UD);
    }

    public boolean rZ() {
        return "9020".equals(this.UD);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0022: IGET  (r3v2 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0033: IGET  (r3v3 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00e9: IGET  (r3v10 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00fa: IGET  (r3v11 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.TP = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.Tt = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.TU = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Tu = threadInfo.repost_num.intValue();
                this.Tv = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.Tw = threadInfo.last_time_int.intValue();
                this.Tx = threadInfo.is_top.intValue();
                this.Ty = threadInfo.is_good.intValue();
                this.Tz = threadInfo.is_livepost.intValue();
                this.TA.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.TB = threadInfo.has_commented.intValue();
                this.TC = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.TT = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.TI = threadInfo.collect_mark_pid;
                this.TJ = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.TM = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.TV = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.TO = threadInfo.is_ntitle.intValue();
                this.TQ = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.TR = threadInfo.operator_flag.intValue();
                this.UB = threadInfo.rich_title;
                this.UC = threadInfo.rich_abstract;
                this.TH = threadInfo.is_godthread_recommend.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                if (EcommSwitchStatic.GL()) {
                    this.isDeal = threadInfo.is_deal.intValue() == 1;
                    if (threadInfo.deal_info != null) {
                        this.Uw = new DealInfoData();
                        this.Uw.parserProtobuf(threadInfo.deal_info);
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
                this.TE = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.TF.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.TT = threadInfo.video_info;
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
                        this.TG.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.TX.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.TY = new bq();
                    this.TY.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.TZ = new c();
                    this.TZ.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Ua = new m();
                    this.Ua.a(threadInfo.cartoon_info);
                }
                this.TK.setUserMap(this.userMap);
                this.TK.parserProtobuf(threadInfo.zan);
                this.TL.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.TK.setTitle(this.title);
                } else {
                    this.TK.setTitle(this.TE);
                }
                this.Ud = threadInfo.livecover_src;
                this.Ue = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.TW = threadInfo.post_num.intValue();
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
                                this.TS.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Uf = noticeInfo.notice;
                    }
                    this.Ul = zhiBoInfoTW.copythread_remind.intValue();
                    this.Uj = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Uk = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Ud)) {
                        this.Ud = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.Rz = zhiBoInfoTW.user.tw_anchor_info;
                        this.RA = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Ug = threadInfo.twzhibo_info.livecover_status;
                    this.Uh = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Ui = threadInfo.poll_info;
                this.Um = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Up.a(threadInfo.task_info);
                }
                if (threadInfo.high_together != null) {
                    this.Uq = new bj();
                    this.Uq.a(threadInfo.high_together);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.Ur.add(bVar);
                    }
                }
                this.Us.parserProtobuf(threadInfo.push_status);
                this.Ux = threadInfo.lego_card;
                this.Ut = threadInfo.skin_info;
                this.Uy = threadInfo.is_book_chapter.intValue();
                this.Uz.a(threadInfo.book_chapter);
                this.UD = threadInfo.recom_source;
                this.UE = threadInfo.recom_weight;
                this.UF = threadInfo.ab_tag;
                this.UG = threadInfo.last_read_pid.longValue();
                this.UH = threadInfo.cheak_repeat.intValue() == 1;
                this.UI = threadInfo.recom_reason;
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
                this.Tt = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.TU = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Tu = jSONObject.optInt("repost_num", 0);
                this.Tv = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.Tw = jSONObject.optLong("last_time_int", 0L);
                this.Tx = jSONObject.optInt("is_top", 0);
                this.Ty = jSONObject.optInt("is_good", 0);
                this.Tz = jSONObject.optInt("is_livepost", 0);
                this.TA.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.TB = jSONObject.optInt("has_commented", 0);
                this.TC = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.TI = jSONObject.optString("collect_mark_pid");
                this.TJ = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.TM = jSONObject.optString("first_post_id", "0");
                this.TV = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.TO = jSONObject.optInt("is_ntitle");
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
                this.TE = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.TF.add(mediaData);
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
                        this.TG.add(voiceModel);
                    }
                }
                if (EcommSwitchStatic.GL() && jSONObject != null) {
                    this.Uw = new DealInfoData();
                    this.Uw.parserJson(jSONObject);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.TX.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.TY = new bq();
                    this.TY.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.TZ = new c();
                    this.TZ.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.Ua = new m();
                    this.Ua.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.TK.setUserMap(this.userMap);
                this.TK.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.TL.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.TK.setTitle(this.title);
                } else {
                    this.TK.setTitle(this.TE);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
                if (optJSONObject != null) {
                    this.Up.parserJson(optJSONObject);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.Ur.add(bVar);
                    }
                }
                this.Uy = jSONObject.optInt("is_book_chapter", 0);
                this.Uz.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.UD = jSONObject.optString("recom_source");
                this.UG = jSONObject.optLong("last_read_pid");
                this.UH = jSONObject.optInt("cheak_repeat") == 1;
                this.UI = jSONObject.optString("recom_reason");
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sa() {
        return this.TD;
    }

    public boolean sb() {
        return rx() != 0;
    }

    public int sc() {
        if (this.Up != null) {
            long rf = this.Up.rf();
            long rg = this.Up.rg();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rf) {
                return 1;
            }
            if (currentTimeMillis > rg) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sd() {
        if (sf() && this.TX.size() >= 1) {
            a aVar = this.TX.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int oY = aVar.oY();
            int oZ = aVar.oZ();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < oY) {
                return 4;
            }
            return currentTimeMillis > oZ ? 2 : 1;
        }
        return -1;
    }

    public int se() {
        if (!sf() || this.TX.size() < 1 || this.TX.get(0) == null) {
            return -1;
        }
        return this.TX.get(0).oX();
    }

    public boolean sf() {
        return this.TQ == 1;
    }

    public String sg() {
        return (!sf() || this.TX.size() < 1 || this.TX.get(0) == null) ? "" : this.TX.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cw(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m9getInst().getApplicationContext()).inflate(t.h.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(t.g.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m9getInst().getApplicationContext().getResources().getColor(t.d.cp_cont_f_1));
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
            if (getThreadType() == 42 && sh()) {
                arrayList.add(Integer.valueOf(t.f.icon_convene));
            }
            if (rx() == 1) {
                arrayList.add(Integer.valueOf(t.f.icon_top));
            } else if (rx() == 2) {
                arrayList.add(Integer.valueOf(t.f.icon_notice));
            }
            if (rz() == 1 || this.TA.sK() != 0) {
                if (rl() != null && getThreadType() == 41) {
                    if (sc() == 2) {
                        arrayList.add(Integer.valueOf(t.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(t.f.icon_zhibo));
                }
            }
            if (z && ss()) {
                Integer num = Uc.get(Integer.valueOf(sc()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (ry() == 1 && !sb() && Tl != getType() && Tm != getType()) {
                arrayList.add(Integer.valueOf(t.f.icon_elite));
            }
            if (getType() == Tp || getType() == Tq) {
                arrayList.add(Integer.valueOf(t.f.icon_vote_blue));
            }
            if (this.TL != null && this.TL.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(t.f.icon_live_on));
            }
            if (rG() == 1) {
                arrayList.add(Integer.valueOf(t.f.frs_post_ding));
            }
            if (!z && se() == 2) {
                arrayList.add(Integer.valueOf(t.f.label_frs_activity_shai));
            } else {
                Integer num2 = Ub.get(new Point(se(), sd()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rM() != null) {
                arrayList.add(Integer.valueOf(t.f.tag_act));
            }
            if (rN() != null) {
                arrayList.add(Integer.valueOf(t.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cw(this.category_name);
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i = 31;
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append("1 ");
            }
            String sb2 = sb.toString();
            if (dVar != null) {
                spannableString = new SpannableString(String.valueOf(sb2) + this.category_name + " ");
            } else {
                spannableString = new SpannableString(sb2);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                Bitmap cN = com.baidu.tbadk.core.util.av.cN(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
                if (cN != null) {
                    bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
                }
                com.baidu.tbadk.core.view.ai aiVar = new com.baidu.tbadk.core.view.ai(bitmapDrawable);
                aiVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.Ts));
                spannableString.setSpan(aiVar, i3, i3 + 1, 33);
                i3 += 2;
            }
            if (dVar != null) {
                spannableString.setSpan(dVar, i3, this.category_name.length() + i3, 33);
                i = (31 - arrayList.size()) - this.category_name.length();
            } else {
                i = 31 - arrayList.size();
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        String str = String.valueOf(g) + " ";
        SpannableString a = a(new SpannableString(i < str.length() ? str.substring(0, i - 1) : str), z);
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        }
        this.TD = spannableStringBuilder;
    }

    private boolean sh() {
        return com.baidu.adp.lib.c.e.dN().ac("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        if (z2) {
            if (z) {
                if (rz() == 1 || getThreadType() == 33 || (rB() != null && rB().sK() != 0)) {
                    if (rl() != null && ss()) {
                        if (sc() == 2) {
                            arrayList.add(new ap.a(t.j.interview_live));
                        }
                    } else {
                        arrayList.add(new ap.a(t.j.kn_zhibo));
                    }
                }
                if (rx() == 1) {
                    arrayList.add(new ap.a(t.j.commit_top));
                }
                if (ry() == 1) {
                    arrayList.add(new ap.a(t.j.good));
                }
                if (ss()) {
                    arrayList.add(UK.get(sc()));
                }
                if (sf()) {
                    Integer num = UJ.get(new Point(se(), sd()));
                    if (num != null) {
                        arrayList.add(new ap.a(num.intValue(), t.d.cp_other_b, t.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new ap.a(t.j.card_promotion_text));
                    }
                }
                if (sm()) {
                    arrayList.add(new ap.a(t.j.vote));
                }
                if (st()) {
                    arrayList.add(new ap.a(t.j.evaluation));
                }
                if (rM() != null) {
                    arrayList.add(new ap.a(t.j.card_promotion_text, t.d.cp_other_b, t.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.ba.isEmpty(ru())) {
                    arrayList.add(new ap.a(ru()));
                }
            } else {
                if (rz() == 1 && !ss()) {
                    arrayList.add(new ap.a(t.j.kn_zhibo));
                }
                if (ry() == 1) {
                    arrayList.add(new ap.a(t.j.good));
                }
                if (rx() == 1) {
                    arrayList.add(new ap.a(t.j.commit_top));
                }
                if (ss() && rl() != null && sc() == 2) {
                    arrayList.add(new ap.a(t.j.interview_live));
                }
                if (sf()) {
                    Integer num2 = UJ.get(new Point(se(), sd()));
                    if (num2 != null) {
                        arrayList.add(new ap.a(num2.intValue(), t.d.cp_other_b, t.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new ap.a(t.j.card_promotion_text));
                    }
                }
                if (this.Uy == 1) {
                    arrayList.add(new ap.a(t.j.card_tbread_text));
                }
                if (rN() != null) {
                    arrayList.add(new ap.a(t.j.send_app_code_gift, t.d.cp_other_b, t.f.pic_dot_title_red));
                }
                if (rM() != null) {
                    arrayList.add(new ap.a(t.j.card_promotion_text, t.d.cp_other_b, t.f.pic_dot_title_red));
                }
                if (st()) {
                    arrayList.add(new ap.a(t.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.ba.isEmpty(ru())) {
                    arrayList.add(new ap.a(ru()));
                }
            }
        }
        int i = 31;
        if (arrayList.size() > 0) {
            spannableStringBuilder = com.baidu.tieba.card.ap.a((Context) TbadkCoreApplication.m9getInst(), g, (ArrayList<ap.a>) arrayList, false);
            i = 31 - arrayList.size();
        } else {
            spannableStringBuilder = new SpannableStringBuilder();
        }
        String str = String.valueOf(g) + " ";
        SpannableString a = a(new SpannableString(i < str.length() ? str.substring(0, i - 1) : str), z);
        if (a != null) {
            spannableStringBuilder.append((CharSequence) a);
        } else if (arrayList.size() > 0 || spannableStringBuilder.length() == 0) {
            spannableStringBuilder.append((CharSequence) g);
        }
        this.TD = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        int i2;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.UB != null && this.UB.size() > 0) {
            int i3 = 31;
            int size = this.UB.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size) {
                PbContent pbContent = this.UB.get(i4);
                if (pbContent == null) {
                    i = i5;
                    i2 = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i5;
                    i2 = i3;
                } else if (pbContent.text.length() <= i3 && pbContent.text.length() + i5 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bi(this, 2, pbContent.link, pbContent, z), i5, pbContent.text.length() + i5, 33);
                    }
                    i = pbContent.text.length() + i5;
                    i2 = i3 - pbContent.text.length();
                } else {
                    return spannableString;
                }
                i4++;
                i5 = i;
                i3 = i2;
            }
            return spannableString;
        }
        return spannableString;
    }

    public void si() {
        d(false, false);
    }

    public void sj() {
        d(true, false);
    }

    public void sk() {
        d(false, true);
    }

    public AnchorInfoData sl() {
        return this.TL;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sm() {
        return this.threadType == 36;
    }

    public boolean sn() {
        return this.threadType == 40;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int so() {
        return this.TW;
    }

    public void bX(int i) {
        this.TW = i;
    }

    public int sp() {
        return this.Uh;
    }

    @Override // com.baidu.tbadk.core.util.al
    public ArrayList<com.baidu.tbadk.core.util.ak> getImages() {
        ArrayList<MediaData> rK = rK();
        if (rK == null || sb()) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.ak> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rK.size() || i2 >= 3) {
                break;
            }
            if (rK.get(i2) != null && rK.get(i2).getType() == 3) {
                com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak();
                if (!StringUtils.isNull(rK.get(i2).getThumbnails_url())) {
                    akVar.imgUrl = rK.get(i2).getThumbnails_url();
                } else {
                    akVar.imgUrl = rK.get(i2).getPicUrl();
                }
                akVar.aaR = 13;
                arrayList.add(akVar);
            }
            i = i2 + 1;
        }
        if (this.TT != null && !StringUtils.isNull(this.TT.thumbnail_url)) {
            com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak();
            akVar2.imgUrl = this.TT.thumbnail_url;
            akVar2.aaR = 13;
            arrayList.add(akVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.ak akVar3 = new com.baidu.tbadk.core.util.ak();
            akVar3.imgUrl = this.author.getPortrait();
            akVar3.aaR = 28;
            arrayList.add(akVar3);
        }
        return arrayList;
    }

    public boolean sq() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int rx = rx();
        if (rx == 2 || rx == 1) {
            return Tj;
        }
        if (this.isDeal && this.Uw != null && MessageManager.getInstance().findTask(CmdConfigCustom.CMD_FRS_EXTRA_LOADED) != null) {
            return Tn;
        }
        if (this.TT != null) {
            if (rD()) {
                return Tm;
            }
            return Tl;
        } else if (rs() != null && getThreadType() == 36 && rs().type.intValue() == 2) {
            return Tp;
        } else {
            if (rs() != null && getThreadType() == 36 && rs().type.intValue() == 1) {
                return Tq;
            }
            if (rl() != null && getThreadType() == 41 && rz() == 1 && sc() == 2) {
                return To.get() ? Uo : TYPE_NORMAL;
            } else if (sf() && se() == 1) {
                return To.get() ? Uu : TYPE_NORMAL;
            } else if (rm() != null && !TextUtils.isEmpty(rm().getActivityName())) {
                return Tr;
            } else {
                if (sf() && se() == 2) {
                    return To.get() ? Un : TYPE_NORMAL;
                } else if (rD()) {
                    return Tk;
                } else {
                    return TYPE_NORMAL;
                }
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sr() {
        return this.Ug;
    }

    public List<TwAnchorProfitItem> qc() {
        return this.RA;
    }

    public void j(ArrayList<n> arrayList) {
        if (this.TO == 1) {
            this.Qi = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Qi = 0;
        } else {
            this.Qi = 0;
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next != null && next.pt() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pt().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Qi = next.pu();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean ss() {
        return this.threadType == 41;
    }

    public boolean st() {
        return this.threadType == 48;
    }

    public boolean su() {
        return this.Uv;
    }

    public void ap(boolean z) {
        this.Uv = z;
    }

    public String sv() {
        return this.Ux;
    }

    public m sw() {
        return this.Ua;
    }

    public DealInfoData sx() {
        return this.Uw;
    }
}
