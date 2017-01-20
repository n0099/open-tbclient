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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tieba.card.at;
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
import tbclient.ReportInfo;
import tbclient.SkinInfo;
import tbclient.ThreadInfo;
import tbclient.TwAnchorProfitItem;
import tbclient.TwZhiBoUser;
import tbclient.VideoInfo;
import tbclient.Voice;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class bh extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.ag {
    public TwZhiBoUser Rg;
    public List<TwAnchorProfitItem> Rh;
    private SpannableStringBuilder ST;
    public int SX;
    private int SY;
    private int TA;
    private SkinInfo TL;
    private boolean TO;
    private String TP;
    private boolean TU;
    private boolean TV;
    public String TW;
    public String TX;
    public String TY;
    public long TZ;
    private int Ta;
    private String Td;
    private int Te;
    private String Tf;
    private int Th;
    private VideoInfo Tj;
    private bo Tk;
    private d Tl;
    private long Tm;
    private o Tt;
    private LiveCoverStatus Tz;
    public boolean Ua;
    public String Ub;
    private List<ReportInfo> Ue;
    private String address;
    private String authorId;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Sw = BdUniqueId.gen();
    public static final BdUniqueId Sx = BdUniqueId.gen();
    public static final BdUniqueId Sy = BdUniqueId.gen();
    public static final BdUniqueId Sz = BdUniqueId.gen();
    public static final BdUniqueId SA = BdUniqueId.gen();
    public static final BdUniqueId SB = BdUniqueId.gen();
    public static final BdUniqueId SC = BdUniqueId.gen();
    public static AtomicBoolean SD = new AtomicBoolean(false);
    public static AtomicBoolean SE = new AtomicBoolean(false);
    public static AtomicBoolean SF = new AtomicBoolean(false);
    public static final BdUniqueId SG = BdUniqueId.gen();
    public static final BdUniqueId SH = BdUniqueId.gen();
    public static final BdUniqueId SI = BdUniqueId.gen();
    private static HashMap<Point, Integer> Tu = new HashMap<>();
    private static HashMap<Integer, Integer> Tv = new HashMap<>();
    public static final BdUniqueId TG = BdUniqueId.gen();
    public static final BdUniqueId TH = BdUniqueId.gen();
    public static final BdUniqueId TM = BdUniqueId.gen();
    private static HashMap<Point, Integer> Uf = new HashMap<>();
    private static SparseArray<at.a> Ug = new SparseArray<>(3);
    public int SJ = 1;
    private String SZ = null;
    private int PF = 0;
    public int Tn = 0;
    private String To = "";
    private String Tw = "";
    public boolean Uh = false;
    public boolean Ui = false;
    private String id = null;
    private String SK = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int SL = 0;
    private int view_num = 0;
    private String last_time = null;
    private long SM = 0;
    private int SN = 0;
    private int SO = 0;
    private int SP = 0;
    private bm SQ = new bm();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> SV = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> SW = new ArrayList<>();
    private int SR = 0;
    private int SS = 0;
    private String ad_url = null;
    private String SU = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData Tb = new PraiseData();
    private AnchorInfoData Tc = new AnchorInfoData();
    private long time = 0;
    private int Tg = 0;
    private ArrayList<a> Tq = new ArrayList<>();
    private br Tr = null;
    private e Ts = null;
    private int Tx = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Ti = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Ty = null;
    private int Tp = 0;
    private PollInfo TB = null;
    private boolean TC = false;
    private boolean TD = false;
    private int TE = 0;
    private boolean TF = false;
    private int anchorLevel = 0;
    public int TQ = 0;
    public l TR = new l();
    private List<PbContent> TS = new ArrayList();
    private List<PbContent> TT = new ArrayList();
    private String category_name = null;
    private bf TI = new bf();
    private ArrayList<com.baidu.tbadk.data.b> TJ = new ArrayList<>();
    private PushStatusData TK = new PushStatusData();
    public boolean Uc = false;
    public int Ud = -1;

    static {
        Tu.put(new Point(1, 1), Integer.valueOf(r.g.label_frs_lottery_ing));
        Tu.put(new Point(1, 2), Integer.valueOf(r.g.label_frs_lottery_over));
        Tu.put(new Point(1, 3), Integer.valueOf(r.g.label_frs_lottery_off));
        Tu.put(new Point(1, 4), Integer.valueOf(r.g.label_frs_lottery_d));
        Tu.put(new Point(2, 1), Integer.valueOf(r.g.label_frs_activity_shaiing));
        Tu.put(new Point(2, 2), Integer.valueOf(r.g.label_frs_activity_shai_over));
        Tu.put(new Point(2, 3), Integer.valueOf(r.g.label_frs_activity_shai_off));
        Tu.put(new Point(2, 4), Integer.valueOf(r.g.label_frs_activity_shai_d));
        Uf.put(new Point(1, 1), Integer.valueOf(r.l.lottery_status_ing));
        Uf.put(new Point(1, 2), Integer.valueOf(r.l.lottery_status_over));
        Uf.put(new Point(1, 3), Integer.valueOf(r.l.lottery_status_off));
        Uf.put(new Point(1, 4), Integer.valueOf(r.l.lottery_status_not_start));
        Uf.put(new Point(2, 1), Integer.valueOf(r.l.share_picture_status_ing));
        Uf.put(new Point(2, 2), Integer.valueOf(r.l.share_picture_status_over));
        Uf.put(new Point(2, 3), Integer.valueOf(r.l.share_picture_status_off));
        Uf.put(new Point(2, 4), Integer.valueOf(r.l.share_picture_status_not_start));
        Tv.put(1, Integer.valueOf(r.g.label_interview_no));
        Tv.put(2, Integer.valueOf(r.g.label_interview_live));
        Tv.put(3, Integer.valueOf(r.g.label_interview_off));
        Ug.put(1, new at.a(r.l.interview_live_status_not_start, r.e.cp_other_b, r.g.pic_dot_title_red));
        Ug.put(2, new at.a(r.l.interview_live_status_ing, r.e.cp_other_c, r.g.pic_dot_title_green));
        Ug.put(3, new at.a(r.l.interview_live_status_over, r.e.cp_other_d, r.g.pic_dot_title_blue));
    }

    public bh() {
        this.SY = 0;
        this.Th = 0;
        this.TA = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.TA = 0;
        this.Th = 0;
        this.SY = 0;
    }

    public boolean rf() {
        return this.SY == 1;
    }

    public bf rg() {
        return this.TI;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bS(int i) {
        this.anchorLevel = i;
    }

    public int rh() {
        return this.Th;
    }

    public boolean ri() {
        return this.TF;
    }

    public boolean rj() {
        return this.TC;
    }

    public boolean rk() {
        return this.TD;
    }

    public void bT(int i) {
        this.TE = i;
    }

    public int rl() {
        return this.TE;
    }

    public PollInfo rm() {
        return this.TB;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Tm;
    }

    public PraiseData rn() {
        return this.Tb;
    }

    public void a(PraiseData praiseData) {
        this.Tb = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void cu(String str) {
        this.SK = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.SK) || "0".equals(this.SK)) ? this.id : this.SK;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String ro() {
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

    public int rp() {
        return this.reply_num;
    }

    public int rq() {
        return this.view_num;
    }

    public long rr() {
        return this.SM;
    }

    public void n(long j) {
        this.SM = j;
    }

    public int rs() {
        return this.SN;
    }

    public void bV(int i) {
        this.SN = i;
    }

    public int rt() {
        return this.SO;
    }

    public void bW(int i) {
        this.SO = i;
    }

    public int ru() {
        return this.SP;
    }

    public List<PbContent> rv() {
        return this.TS;
    }

    public bm rw() {
        return this.SQ;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rx() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean ry() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return false;
        }
        return this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3 || this.author.getGodUserData().getType() == 1;
    }

    public boolean rz() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean rA() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rB() {
        return this.forum_name;
    }

    public void cv(String str) {
        this.forum_name = str;
    }

    public int rC() {
        return this.SS;
    }

    public String rD() {
        return this.ad_url;
    }

    public String rE() {
        return this.SU;
    }

    public void cw(String str) {
        this.SU = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.TT == null || this.TT.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.TT.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.TT.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.TS == null || (size = this.TS.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.TS.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cx(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.TT != null && (size = this.TT.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.TT.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (!TextUtils.isEmpty(pbContent.text)) {
                    if (pbContent.text.length() + i3 > spannableString.length()) {
                        break;
                    }
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bi(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public String rF() {
        return this.SZ;
    }

    public void cy(String str) {
        this.SZ = str;
    }

    public ArrayList<MediaData> rG() {
        return this.SV;
    }

    public ArrayList<a> rH() {
        return this.Tq;
    }

    public void i(ArrayList<a> arrayList) {
        this.Tq = arrayList;
    }

    public br rI() {
        return this.Tr;
    }

    public e rJ() {
        return this.Ts;
    }

    public ArrayList<VoiceData.VoiceModel> rK() {
        return this.SW;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rL() {
        return this.Te;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rM() {
        return this.To;
    }

    public VideoInfo rN() {
        return this.Tj;
    }

    public d rO() {
        return this.Tl;
    }

    public String getPhotoLiveCover() {
        return this.Tw;
    }

    public void setPhotoLiveCover(String str) {
        this.Tw = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> rP() {
        return this.Ti;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Ti.clear();
        this.Ti.addAll(arrayList);
    }

    public String getNotice() {
        return this.Ty;
    }

    public PushStatusData rQ() {
        return this.TK;
    }

    public SkinInfo rR() {
        return this.TL;
    }

    public long rS() {
        return this.TZ;
    }

    public boolean rT() {
        return this.Ua;
    }

    public String rU() {
        return this.Ub;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x002a: IGET  (r3v0 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x003b: IGET  (r3v1 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x00ff: IGET  (r3v9 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0110: IGET  (r3v10 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
    public void a(ThreadInfo threadInfo) {
        MetaData metaData;
        if (threadInfo != null) {
            try {
                if (threadInfo.location != null) {
                    this.latitude = threadInfo.location.lat;
                    this.Tf = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.SY = threadInfo.is_tbread_dispatch.intValue();
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.SK = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Tm = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.SL = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.SM = threadInfo.last_time_int.intValue();
                this.SN = threadInfo.is_top.intValue();
                this.SO = threadInfo.is_good.intValue();
                this.SP = threadInfo.is_livepost.intValue();
                this.SQ.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.SR = threadInfo.has_commented.intValue();
                this.SS = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Tj = threadInfo.video_info;
                this.Tl = new d();
                this.Tl.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.SZ = threadInfo.collect_mark_pid;
                this.Ta = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.Td = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.To = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.Te = threadInfo.is_ntitle.intValue();
                this.Tg = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Th = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.TU = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.TS = threadInfo.rich_title;
                this.TT = threadInfo.rich_abstract;
                this.SX = threadInfo.is_godthread_recommend.intValue();
                if ((this.author == null || this.author.getUserId() == null || this.author.getUserId().equals("0")) && this.authorId != null && !this.authorId.equals("0") && this.userMap != null && (metaData = this.userMap.get(this.authorId)) != null) {
                    this.author = metaData;
                }
                StringBuilder sb = new StringBuilder();
                List<Abstract> list = threadInfo._abstract;
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i) != null && list.get(i).type.intValue() == 0) {
                            sb.append(list.get(i).text);
                        }
                    }
                }
                this.SU = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.SV.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Tj = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.Tk = new bo();
                    this.Tk.a(threadInfo.video_channel_info);
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
                        this.SW.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Tq.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Tr = new br();
                    this.Tr.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Ts = new e();
                    this.Ts.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Tt = new o();
                    this.Tt.a(threadInfo.cartoon_info);
                }
                this.Tb.setUserMap(this.userMap);
                this.Tb.parserProtobuf(threadInfo.zan);
                this.Tc.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Tb.setTitle(this.title);
                } else {
                    this.Tb.setTitle(this.SU);
                }
                this.Tw = threadInfo.livecover_src;
                this.Tx = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Tp = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.ej(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Ti.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Ty = noticeInfo.notice;
                    }
                    this.TE = zhiBoInfoTW.copythread_remind.intValue();
                    this.TC = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.TD = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Tw)) {
                        this.Tw = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.Rg = zhiBoInfoTW.user.tw_anchor_info;
                        this.Rh = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Tz = threadInfo.twzhibo_info.livecover_status;
                    this.TA = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.TB = threadInfo.poll_info;
                this.TF = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.TI.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.TJ.add(bVar);
                    }
                }
                this.TK.parserProtobuf(threadInfo.push_status);
                this.TP = threadInfo.lego_card;
                this.TL = threadInfo.skin_info;
                this.TQ = threadInfo.is_book_chapter.intValue();
                this.TR.a(threadInfo.book_chapter);
                this.TW = threadInfo.recom_source;
                this.Ub = threadInfo.recom_reason;
                this.TX = threadInfo.recom_weight;
                this.TY = threadInfo.ab_tag;
                this.TZ = threadInfo.last_read_pid.longValue();
                this.Ua = threadInfo.cheak_repeat.intValue() == 1;
                this.Ue = threadInfo.report_info;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.SK = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.Tm = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.SL = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.SM = jSONObject.optLong("last_time_int", 0L);
                this.SN = jSONObject.optInt("is_top", 0);
                this.SO = jSONObject.optInt("is_good", 0);
                this.SP = jSONObject.optInt("is_livepost", 0);
                this.SQ.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.SR = jSONObject.optInt("has_commented", 0);
                this.SS = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.SZ = jSONObject.optString("collect_mark_pid");
                this.Ta = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.Td = jSONObject.optString("first_post_id", "0");
                this.To = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Te = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("author");
                if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.Tl = new d();
                this.Tl.parserJson(jSONObject.optJSONObject("ala_info"));
                StringBuilder sb = new StringBuilder();
                JSONArray optJSONArray = jSONObject.optJSONArray("abstract");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        if (jSONObject2 != null && jSONObject2.optInt("type") == 0) {
                            sb.append(optJSONArray.getJSONObject(i).optString("text"));
                        }
                    }
                }
                this.SU = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.SV.add(mediaData);
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("voice_info");
                if (optJSONArray3 != null) {
                    int length = optJSONArray3.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
                        JSONObject jSONObject3 = optJSONArray3.getJSONObject(i3);
                        voiceModel.from = "frs_voice_play";
                        voiceModel.voiceId = jSONObject3.optString("voice_md5");
                        voiceModel.duration = jSONObject3.optInt("during_time") / 1000;
                        this.SW.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Tq.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Tr = new br();
                    this.Tr.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Ts = new e();
                    this.Ts.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.Tt = new o();
                    this.Tt.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.Tb.setUserMap(this.userMap);
                this.Tb.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.Tc.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Tb.setTitle(this.title);
                } else {
                    this.Tb.setTitle(this.SU);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("task_info");
                if (optJSONObject3 != null) {
                    this.TI.parserJson(optJSONObject3);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.TJ.add(bVar);
                    }
                }
                this.TQ = jSONObject.optInt("is_book_chapter", 0);
                this.TR.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.TW = jSONObject.optString("recom_source");
                this.Ub = jSONObject.optString("recom_reason");
                this.TX = jSONObject.optString("recom_weight");
                this.TZ = jSONObject.optLong("last_read_pid");
                this.Ua = jSONObject.optInt("cheak_repeat") == 1;
                if (jSONObject.optJSONObject("video_channel_info") != null) {
                    this.Tk = new bo();
                    this.Tk.j(jSONObject.optJSONObject("video_channel_info"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rV() {
        return this.ST;
    }

    public boolean rW() {
        return rs() != 0;
    }

    public int rX() {
        if (this.TI != null) {
            long qZ = this.TI.qZ();
            long ra = this.TI.ra();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qZ) {
                return 1;
            }
            if (currentTimeMillis > ra) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rY() {
        if (sa() && this.Tq.size() >= 1) {
            a aVar = this.Tq.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int oU = aVar.oU();
            int oV = aVar.oV();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < oU) {
                return 4;
            }
            return currentTimeMillis > oV ? 2 : 1;
        }
        return -1;
    }

    public int rZ() {
        if (!sa() || this.Tq.size() < 1 || this.Tq.get(0) == null) {
            return -1;
        }
        return this.Tq.get(0).oT();
    }

    public boolean sa() {
        return this.Tg == 1;
    }

    public String sb() {
        return (!sa() || this.Tq.size() < 1 || this.Tq.get(0) == null) ? "" : this.Tq.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cz(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m9getInst().getApplicationContext()).inflate(r.j.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(r.h.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m9getInst().getApplicationContext().getResources().getColor(r.e.cp_cont_f_1));
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
            if (getThreadType() == 42 && sc()) {
                arrayList.add(Integer.valueOf(r.g.icon_convene));
            }
            if (rs() == 1) {
                arrayList.add(Integer.valueOf(r.g.icon_top));
            } else if (rs() == 2) {
                arrayList.add(Integer.valueOf(r.g.icon_notice));
            }
            if (ru() == 1 || this.SQ.sI() != 0) {
                if (rg() != null && getThreadType() == 41) {
                    if (rX() == 2) {
                        arrayList.add(Integer.valueOf(r.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(r.g.icon_zhibo));
                }
            }
            if (z && sn()) {
                Integer num = Tv.get(Integer.valueOf(rX()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rt() == 1 && !rW() && Sz != getType() && SC != getType()) {
                arrayList.add(Integer.valueOf(r.g.icon_elite));
            }
            if (getType() == SG || getType() == SH) {
                arrayList.add(Integer.valueOf(r.g.icon_vote_blue));
            }
            if (this.Tc != null && this.Tc.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(r.g.icon_live_on));
            }
            if (rC() == 1) {
                arrayList.add(Integer.valueOf(r.g.frs_post_ding));
            }
            if (!z && rZ() == 2) {
                arrayList.add(Integer.valueOf(r.g.label_frs_activity_shai));
            } else {
                Integer num2 = Tu.get(new Point(rZ(), rY()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rI() != null) {
                arrayList.add(Integer.valueOf(r.g.tag_act));
            }
            if (rJ() != null) {
                arrayList.add(Integer.valueOf(r.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cz(this.category_name);
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
            int i3 = 0;
            while (true) {
                int i4 = i2;
                if (i4 >= arrayList.size()) {
                    break;
                }
                Bitmap cP = com.baidu.tbadk.core.util.ap.cP(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cP);
                if (cP != null) {
                    bitmapDrawable.setBounds(0, 0, cP.getWidth(), cP.getHeight());
                }
                com.baidu.tbadk.core.view.ak akVar = new com.baidu.tbadk.core.view.ak(bitmapDrawable);
                akVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.SJ));
                spannableString.setSpan(akVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (dVar != null) {
                spannableString.setSpan(dVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(String.valueOf(g) + " "), z);
        if (a != null) {
            SpannableStringBuilder c = !z && rs() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.ST = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<at.a> arrayList) {
        if (si() || !ry() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new at.a(r.l.god_title));
        }
        return com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), str, arrayList, true);
    }

    private boolean sc() {
        return com.baidu.adp.lib.b.e.dL().ac("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        boolean ry = ry();
        if (z2) {
            if (z) {
                if (ry && !si()) {
                    arrayList.add(new at.a(r.l.god_title));
                }
                if (ru() == 1 || getThreadType() == 33 || (rw() != null && rw().sI() != 0)) {
                    if (rg() != null && sn()) {
                        if (rX() == 2) {
                            arrayList.add(new at.a(r.l.interview_live));
                        }
                    } else if (!ry) {
                        arrayList.add(new at.a(r.l.kn_zhibo));
                    }
                }
                if (rs() == 1) {
                    arrayList.add(new at.a(r.l.commit_top));
                }
                if (rt() == 1) {
                    arrayList.add(new at.a(r.l.good));
                }
                if (sn()) {
                    arrayList.add(Ug.get(rX()));
                }
                if (sa()) {
                    Integer num = Uf.get(new Point(rZ(), rY()));
                    if (num != null) {
                        arrayList.add(new at.a(num.intValue(), r.e.cp_other_b, r.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(r.l.card_promotion_text));
                    }
                }
                if (so()) {
                    arrayList.add(new at.a(r.l.evaluation));
                }
                if (rI() != null) {
                    arrayList.add(new at.a(r.l.card_promotion_text, r.e.cp_other_b, r.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(ro())) {
                    arrayList.add(new at.a(ro()));
                }
            } else {
                if (ry && rs() != 1 && !si()) {
                    arrayList.add(new at.a(r.l.god_title));
                }
                if ((ru() == 1 || getThreadType() == 33) && !sn() && !ry) {
                    arrayList.add(new at.a(r.l.kn_zhibo));
                }
                if (rt() == 1) {
                    arrayList.add(new at.a(r.l.good));
                }
                if (rs() == 1) {
                    arrayList.add(new at.a(r.l.commit_top));
                }
                if (sn() && rg() != null && rX() == 2) {
                    arrayList.add(new at.a(r.l.interview_live));
                }
                if (sa()) {
                    Integer num2 = Uf.get(new Point(rZ(), rY()));
                    if (num2 != null) {
                        arrayList.add(new at.a(num2.intValue(), r.e.cp_other_b, r.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(r.l.card_promotion_text));
                    }
                }
                if (this.TQ == 1) {
                    arrayList.add(new at.a(r.l.card_tbread_text));
                }
                if (rJ() != null) {
                    arrayList.add(new at.a(r.l.send_app_code_gift, r.e.cp_other_b, r.g.pic_dot_title_red));
                }
                if (rI() != null) {
                    arrayList.add(new at.a(r.l.card_promotion_text, r.e.cp_other_b, r.g.pic_dot_title_red));
                }
                if (so()) {
                    arrayList.add(new at.a(r.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.at.isEmpty(ro())) {
                    arrayList.add(new at.a(ro()));
                }
            }
        }
        if (arrayList.size() > 0) {
            spannableStringBuilder = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), g, (ArrayList<at.a>) arrayList, false);
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
        this.ST = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.TS != null && this.TS.size() > 0) {
            int size = this.TS.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.TS.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bj(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public void sd() {
        d(false, false);
    }

    public void se() {
        d(true, false);
    }

    public void sf() {
        d(false, true);
    }

    public AnchorInfoData sg() {
        return this.Tc;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sh() {
        return this.threadType == 36;
    }

    public boolean si() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sj() {
        return this.Tp;
    }

    public void bX(int i) {
        this.Tp = i;
    }

    public int sk() {
        return this.TA;
    }

    @Override // com.baidu.tbadk.core.util.ag
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rG = rG();
        if (rG == null || rW()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rG.size() || i2 >= 3) {
                break;
            }
            if (rG.get(i2) != null && rG.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rG.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rG.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rG.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.Tj != null && !StringUtils.isNull(this.Tj.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.Tj.thumbnail_url;
            preLoadImageInfo2.procType = 13;
            arrayList.add(preLoadImageInfo2);
        }
        if (this.author != null) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.author.getPortrait();
            preLoadImageInfo3.procType = 28;
            arrayList.add(preLoadImageInfo3);
        }
        return arrayList;
    }

    public boolean sl() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int rs = rs();
        if (this.Tl != null && this.threadType == 49) {
            return SA;
        }
        if (this.threadType == 51) {
            return SB;
        }
        if (rs == 2 || rs == 1) {
            return Sw;
        }
        if (this.Tj != null && sv()) {
            return SI;
        }
        if (this.Tj != null) {
            if (rz()) {
                return SC;
            }
            return Sz;
        } else if (rm() != null && getThreadType() == 36 && rm().type.intValue() == 2) {
            return SG;
        } else {
            if (rm() != null && getThreadType() == 36 && rm().type.intValue() == 1) {
                return SH;
            }
            if (rg() != null && getThreadType() == 41 && ru() == 1 && rX() == 2) {
                return SD.get() ? TH : Sx;
            } else if (sa() && rZ() == 1) {
                return SD.get() ? TM : Sx;
            } else if (sa() && rZ() == 2) {
                return SD.get() ? TG : Sx;
            } else if (rz()) {
                return Sy;
            } else {
                return Sx;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sm() {
        return this.Tz;
    }

    public List<TwAnchorProfitItem> qj() {
        return this.Rh;
    }

    public void j(ArrayList<p> arrayList) {
        if (this.Te == 1) {
            this.PF = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.PF = 0;
        } else {
            this.PF = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.pq() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pq().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.PF = next.pr();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sn() {
        return this.threadType == 41;
    }

    public boolean so() {
        return this.threadType == 48;
    }

    public boolean sp() {
        return this.TO;
    }

    public void ar(boolean z) {
        this.TO = z;
    }

    public String sq() {
        return this.TP;
    }

    public o sr() {
        return this.Tt;
    }

    public boolean ss() {
        return ru() == 1 || rt() == 1 || rs() == 1 || sa() || this.TQ == 1 || rz() || rJ() != null || rI() != null || !com.baidu.adp.lib.util.j.isEmpty(ro()) || so();
    }

    public void st() {
        if (this.Tn == 0) {
            this.Tn = 1;
        }
    }

    public boolean su() {
        return this.TU;
    }

    public void as(boolean z) {
        this.Uc = z;
    }

    public boolean sv() {
        return this.Uc;
    }

    public void bY(int i) {
        this.Ud = i + 1;
    }

    public int sw() {
        return this.Ud;
    }

    public List<ReportInfo> sx() {
        return this.Ue;
    }

    public boolean sy() {
        return this.TV;
    }

    public void at(boolean z) {
        this.TV = z;
    }

    public bo sz() {
        return this.Tk;
    }

    public void a(bo boVar) {
        this.Tk = boVar;
    }

    public void aW(int i) {
        if (this.Tk != null) {
            this.Tk.mCurrentPage = i;
        }
    }

    public boolean sA() {
        return getThreadType() == 49;
    }
}
