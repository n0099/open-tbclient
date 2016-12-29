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
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tieba.card.ap;
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
public class bg extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.ai {
    public TwZhiBoUser RX;
    public List<TwAnchorProfitItem> RY;
    private SpannableStringBuilder TH;
    public int TL;
    private int TM;
    private int TP;
    private String TS;
    private int TT;
    private String TU;
    private int TW;
    private VideoInfo TY;
    private long TZ;
    private boolean UB;
    private String UC;
    private boolean UH;
    private boolean UI;
    public String UJ;
    public String UK;
    public String UL;
    public long UM;
    public boolean UN;
    public String UO;
    private List<ReportInfo> US;
    private n Ug;
    private LiveCoverStatus Um;
    private int Un;
    private SkinInfo Uy;
    private String address;
    private String authorId;
    private String latitude;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Tm = BdUniqueId.gen();
    public static final BdUniqueId Tn = BdUniqueId.gen();
    public static final BdUniqueId To = BdUniqueId.gen();
    public static final BdUniqueId Tp = BdUniqueId.gen();
    public static final BdUniqueId Tq = BdUniqueId.gen();
    public static AtomicBoolean Tr = new AtomicBoolean(false);
    public static AtomicBoolean Ts = new AtomicBoolean(false);
    public static AtomicBoolean Tt = new AtomicBoolean(false);
    public static final BdUniqueId Tu = BdUniqueId.gen();
    public static final BdUniqueId Tv = BdUniqueId.gen();
    public static final BdUniqueId Tw = BdUniqueId.gen();
    private static HashMap<Point, Integer> Uh = new HashMap<>();
    private static HashMap<Integer, Integer> Ui = new HashMap<>();
    public static final BdUniqueId Ut = BdUniqueId.gen();
    public static final BdUniqueId Uu = BdUniqueId.gen();
    public static final BdUniqueId Uz = BdUniqueId.gen();
    private static HashMap<Point, Integer> UT = new HashMap<>();
    private static SparseArray<ap.a> UU = new SparseArray<>(3);
    public int Tx = 1;
    private String TO = null;
    private int Qv = 0;
    public int Ua = 0;
    private String Ub = "";
    private String Uj = "";
    private String id = null;
    private String Ty = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int Tz = 0;
    private int view_num = 0;
    private String last_time = null;
    private long TA = 0;
    private int TB = 0;
    private int TC = 0;
    private int TD = 0;
    private bl TE = new bl();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> TJ = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> TK = new ArrayList<>();
    private int TF = 0;
    private int TG = 0;
    private String ad_url = null;
    private String TI = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData TQ = new PraiseData();
    private AnchorInfoData TR = new AnchorInfoData();
    private long time = 0;
    private int TV = 0;
    private ArrayList<a> Ud = new ArrayList<>();
    private bp Ue = null;
    private d Uf = null;
    private int Uk = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> TX = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Ul = null;
    private int Uc = 0;
    private PollInfo Uo = null;
    private boolean Up = false;
    private boolean Uq = false;
    private int Ur = 0;
    private boolean Us = false;
    private int anchorLevel = 0;
    public int UD = 0;
    public k UE = new k();
    private List<PbContent> UF = new ArrayList();
    private List<PbContent> UG = new ArrayList();
    private String category_name = null;
    private be Uv = new be();
    private ArrayList<com.baidu.tbadk.data.b> Uw = new ArrayList<>();
    private PushStatusData Ux = new PushStatusData();
    public boolean UQ = false;
    public int UR = -1;

    static {
        Uh.put(new Point(1, 1), Integer.valueOf(r.f.label_frs_lottery_ing));
        Uh.put(new Point(1, 2), Integer.valueOf(r.f.label_frs_lottery_over));
        Uh.put(new Point(1, 3), Integer.valueOf(r.f.label_frs_lottery_off));
        Uh.put(new Point(1, 4), Integer.valueOf(r.f.label_frs_lottery_d));
        Uh.put(new Point(2, 1), Integer.valueOf(r.f.label_frs_activity_shaiing));
        Uh.put(new Point(2, 2), Integer.valueOf(r.f.label_frs_activity_shai_over));
        Uh.put(new Point(2, 3), Integer.valueOf(r.f.label_frs_activity_shai_off));
        Uh.put(new Point(2, 4), Integer.valueOf(r.f.label_frs_activity_shai_d));
        UT.put(new Point(1, 1), Integer.valueOf(r.j.lottery_status_ing));
        UT.put(new Point(1, 2), Integer.valueOf(r.j.lottery_status_over));
        UT.put(new Point(1, 3), Integer.valueOf(r.j.lottery_status_off));
        UT.put(new Point(1, 4), Integer.valueOf(r.j.lottery_status_not_start));
        UT.put(new Point(2, 1), Integer.valueOf(r.j.share_picture_status_ing));
        UT.put(new Point(2, 2), Integer.valueOf(r.j.share_picture_status_over));
        UT.put(new Point(2, 3), Integer.valueOf(r.j.share_picture_status_off));
        UT.put(new Point(2, 4), Integer.valueOf(r.j.share_picture_status_not_start));
        Ui.put(1, Integer.valueOf(r.f.label_interview_no));
        Ui.put(2, Integer.valueOf(r.f.label_interview_live));
        Ui.put(3, Integer.valueOf(r.f.label_interview_off));
        UU.put(1, new ap.a(r.j.interview_live_status_not_start, r.d.cp_other_b, r.f.pic_dot_title_red));
        UU.put(2, new ap.a(r.j.interview_live_status_ing, r.d.cp_other_c, r.f.pic_dot_title_green));
        UU.put(3, new ap.a(r.j.interview_live_status_over, r.d.cp_other_d, r.f.pic_dot_title_blue));
    }

    public bg() {
        this.TM = 0;
        this.TW = 0;
        this.Un = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Un = 0;
        this.TW = 0;
        this.TM = 0;
    }

    public boolean rn() {
        return this.TM == 1;
    }

    public be ro() {
        return this.Uv;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bT(int i) {
        this.anchorLevel = i;
    }

    public int rp() {
        return this.TW;
    }

    public boolean rq() {
        return this.Us;
    }

    public boolean rr() {
        return this.Up;
    }

    public boolean rs() {
        return this.Uq;
    }

    public void bU(int i) {
        this.Ur = i;
    }

    public int rt() {
        return this.Ur;
    }

    public PollInfo ru() {
        return this.Uo;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.TZ;
    }

    public PraiseData rv() {
        return this.TQ;
    }

    public void a(PraiseData praiseData) {
        this.TQ = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    public void cw(String str) {
        this.Ty = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.Ty) || "0".equals(this.Ty)) ? this.id : this.Ty;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String rw() {
        return this.category_name;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void bV(int i) {
        this.reply_num = i;
    }

    public int rx() {
        return this.reply_num;
    }

    public int ry() {
        return this.view_num;
    }

    public long rz() {
        return this.TA;
    }

    public void o(long j) {
        this.TA = j;
    }

    public int rA() {
        return this.TB;
    }

    public void bW(int i) {
        this.TB = i;
    }

    public int rB() {
        return this.TC;
    }

    public void bX(int i) {
        this.TC = i;
    }

    public int rC() {
        return this.TD;
    }

    public List<PbContent> rD() {
        return this.UF;
    }

    public bl rE() {
        return this.TE;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rF() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rG() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return false;
        }
        return this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3 || this.author.getGodUserData().getType() == 1;
    }

    public boolean rH() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean rI() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public boolean rJ() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return true;
        }
        return (this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rK() {
        return this.forum_name;
    }

    public void cx(String str) {
        this.forum_name = str;
    }

    public int rL() {
        return this.TG;
    }

    public String rM() {
        return this.ad_url;
    }

    public String rN() {
        return this.TI;
    }

    public void cy(String str) {
        this.TI = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.UG == null || this.UG.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.UG.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.UG.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.UF == null || (size = this.UF.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.UF.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cz(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.UG != null && (size = this.UG.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.UG.get(i2);
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

    public String rO() {
        return this.TO;
    }

    public void cA(String str) {
        this.TO = str;
    }

    public ArrayList<MediaData> rP() {
        return this.TJ;
    }

    public ArrayList<a> rQ() {
        return this.Ud;
    }

    public void i(ArrayList<a> arrayList) {
        this.Ud = arrayList;
    }

    public bp rR() {
        return this.Ue;
    }

    public d rS() {
        return this.Uf;
    }

    public ArrayList<VoiceData.VoiceModel> rT() {
        return this.TK;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rU() {
        return this.TT;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rV() {
        return this.Ub;
    }

    public VideoInfo rW() {
        return this.TY;
    }

    public String getPhotoLiveCover() {
        return this.Uj;
    }

    public void setPhotoLiveCover(String str) {
        this.Uj = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> rX() {
        return this.TX;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.TX.clear();
        this.TX.addAll(arrayList);
    }

    public String getNotice() {
        return this.Ul;
    }

    public PushStatusData rY() {
        return this.Ux;
    }

    public SkinInfo rZ() {
        return this.Uy;
    }

    public long sa() {
        return this.UM;
    }

    public boolean sb() {
        return this.UN;
    }

    public String sc() {
        return this.UO;
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
                    this.TU = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.TM = threadInfo.is_tbread_dispatch.intValue();
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.Ty = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.TZ = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.Tz = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.TA = threadInfo.last_time_int.intValue();
                this.TB = threadInfo.is_top.intValue();
                this.TC = threadInfo.is_good.intValue();
                this.TD = threadInfo.is_livepost.intValue();
                this.TE.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.TF = threadInfo.has_commented.intValue();
                this.TG = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.TY = threadInfo.video_info;
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.TO = threadInfo.collect_mark_pid;
                this.TP = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.TS = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Ub = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.TT = threadInfo.is_ntitle.intValue();
                this.TV = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.TW = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.UH = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.UF = threadInfo.rich_title;
                this.UG = threadInfo.rich_abstract;
                this.TL = threadInfo.is_godthread_recommend.intValue();
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
                this.TI = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.TJ.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.TY = threadInfo.video_info;
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
                        this.TK.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Ud.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Ue = new bp();
                    this.Ue.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Uf = new d();
                    this.Uf.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Ug = new n();
                    this.Ug.a(threadInfo.cartoon_info);
                }
                this.TQ.setUserMap(this.userMap);
                this.TQ.parserProtobuf(threadInfo.zan);
                this.TR.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.TQ.setTitle(this.title);
                } else {
                    this.TQ.setTitle(this.TI);
                }
                this.Uj = threadInfo.livecover_src;
                this.Uk = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Uc = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.ei(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.TX.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Ul = noticeInfo.notice;
                    }
                    this.Ur = zhiBoInfoTW.copythread_remind.intValue();
                    this.Up = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Uq = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Uj)) {
                        this.Uj = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.RX = zhiBoInfoTW.user.tw_anchor_info;
                        this.RY = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Um = threadInfo.twzhibo_info.livecover_status;
                    this.Un = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Uo = threadInfo.poll_info;
                this.Us = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Uv.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.Uw.add(bVar);
                    }
                }
                this.Ux.parserProtobuf(threadInfo.push_status);
                this.UC = threadInfo.lego_card;
                this.Uy = threadInfo.skin_info;
                this.UD = threadInfo.is_book_chapter.intValue();
                this.UE.a(threadInfo.book_chapter);
                this.UJ = threadInfo.recom_source;
                this.UO = threadInfo.recom_reason;
                this.UK = threadInfo.recom_weight;
                this.UL = threadInfo.ab_tag;
                this.UM = threadInfo.last_read_pid.longValue();
                this.UN = threadInfo.cheak_repeat.intValue() == 1;
                this.US = threadInfo.report_info;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.id = jSONObject.optString("id");
                this.Ty = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.TZ = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.Tz = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.TA = jSONObject.optLong("last_time_int", 0L);
                this.TB = jSONObject.optInt("is_top", 0);
                this.TC = jSONObject.optInt("is_good", 0);
                this.TD = jSONObject.optInt("is_livepost", 0);
                this.TE.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.TF = jSONObject.optInt("has_commented", 0);
                this.TG = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.TO = jSONObject.optString("collect_mark_pid");
                this.TP = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.TS = jSONObject.optString("first_post_id", "0");
                this.Ub = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.TT = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
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
                this.TI = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.TJ.add(mediaData);
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
                        this.TK.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Ud.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Ue = new bp();
                    this.Ue.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Uf = new d();
                    this.Uf.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.Ug = new n();
                    this.Ug.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.TQ.setUserMap(this.userMap);
                this.TQ.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.TR.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.TQ.setTitle(this.title);
                } else {
                    this.TQ.setTitle(this.TI);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("task_info");
                if (optJSONObject != null) {
                    this.Uv.parserJson(optJSONObject);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.Uw.add(bVar);
                    }
                }
                this.UD = jSONObject.optInt("is_book_chapter", 0);
                this.UE.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.UJ = jSONObject.optString("recom_source");
                this.UO = jSONObject.optString("recom_reason");
                this.UK = jSONObject.optString("recom_weight");
                this.UM = jSONObject.optLong("last_read_pid");
                this.UN = jSONObject.optInt("cheak_repeat") == 1;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sd() {
        return this.TH;
    }

    public boolean se() {
        return rA() != 0;
    }

    public int sf() {
        if (this.Uv != null) {
            long rh = this.Uv.rh();
            long ri = this.Uv.ri();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < rh) {
                return 1;
            }
            if (currentTimeMillis > ri) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sg() {
        if (si() && this.Ud.size() >= 1) {
            a aVar = this.Ud.get(0);
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

    public int sh() {
        if (!si() || this.Ud.size() < 1 || this.Ud.get(0) == null) {
            return -1;
        }
        return this.Ud.get(0).pa();
    }

    public boolean si() {
        return this.TV == 1;
    }

    public String sj() {
        return (!si() || this.Ud.size() < 1 || this.Ud.get(0) == null) ? "" : this.Ud.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cB(String str) {
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
            if (getThreadType() == 42 && sk()) {
                arrayList.add(Integer.valueOf(r.f.icon_convene));
            }
            if (rA() == 1) {
                arrayList.add(Integer.valueOf(r.f.icon_top));
            } else if (rA() == 2) {
                arrayList.add(Integer.valueOf(r.f.icon_notice));
            }
            if (rC() == 1 || this.TE.sO() != 0) {
                if (ro() != null && getThreadType() == 41) {
                    if (sf() == 2) {
                        arrayList.add(Integer.valueOf(r.f.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(r.f.icon_zhibo));
                }
            }
            if (z && sv()) {
                Integer num = Ui.get(Integer.valueOf(sf()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rB() == 1 && !se() && Tp != getType() && Tq != getType()) {
                arrayList.add(Integer.valueOf(r.f.icon_elite));
            }
            if (getType() == Tu || getType() == Tv) {
                arrayList.add(Integer.valueOf(r.f.icon_vote_blue));
            }
            if (this.TR != null && this.TR.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(r.f.icon_live_on));
            }
            if (rL() == 1) {
                arrayList.add(Integer.valueOf(r.f.frs_post_ding));
            }
            if (!z && sh() == 2) {
                arrayList.add(Integer.valueOf(r.f.label_frs_activity_shai));
            } else {
                Integer num2 = Uh.get(new Point(sh(), sg()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rR() != null) {
                arrayList.add(Integer.valueOf(r.f.tag_act));
            }
            if (rS() != null) {
                arrayList.add(Integer.valueOf(r.f.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cB(this.category_name);
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
                Bitmap cQ = com.baidu.tbadk.core.util.ar.cQ(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cQ);
                if (cQ != null) {
                    bitmapDrawable.setBounds(0, 0, cQ.getWidth(), cQ.getHeight());
                }
                com.baidu.tbadk.core.view.aj ajVar = new com.baidu.tbadk.core.view.aj(bitmapDrawable);
                ajVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.Tx));
                spannableString.setSpan(ajVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder c = !z && rA() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.TH = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<ap.a> arrayList) {
        if (sq() || !rG() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new ap.a(r.j.god_title));
        }
        return com.baidu.tieba.card.ap.a((Context) TbadkCoreApplication.m9getInst(), str, arrayList, true);
    }

    private boolean sk() {
        return com.baidu.adp.lib.c.e.dN().ac("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        boolean rG = rG();
        if (z2) {
            if (z) {
                if (rG && !sq()) {
                    arrayList.add(new ap.a(r.j.god_title));
                }
                if (rC() == 1 || getThreadType() == 33 || (rE() != null && rE().sO() != 0)) {
                    if (ro() != null && sv()) {
                        if (sf() == 2) {
                            arrayList.add(new ap.a(r.j.interview_live));
                        }
                    } else if (!rG) {
                        arrayList.add(new ap.a(r.j.kn_zhibo));
                    }
                }
                if (rA() == 1) {
                    arrayList.add(new ap.a(r.j.commit_top));
                }
                if (rB() == 1) {
                    arrayList.add(new ap.a(r.j.good));
                }
                if (sv()) {
                    arrayList.add(UU.get(sf()));
                }
                if (si()) {
                    Integer num = UT.get(new Point(sh(), sg()));
                    if (num != null) {
                        arrayList.add(new ap.a(num.intValue(), r.d.cp_other_b, r.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new ap.a(r.j.card_promotion_text));
                    }
                }
                if (sw()) {
                    arrayList.add(new ap.a(r.j.evaluation));
                }
                if (rR() != null) {
                    arrayList.add(new ap.a(r.j.card_promotion_text, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.av.isEmpty(rw())) {
                    arrayList.add(new ap.a(rw()));
                }
            } else {
                if (rG && rA() != 1 && !sq()) {
                    arrayList.add(new ap.a(r.j.god_title));
                }
                if ((rC() == 1 || getThreadType() == 33) && !sv() && !rG) {
                    arrayList.add(new ap.a(r.j.kn_zhibo));
                }
                if (rB() == 1) {
                    arrayList.add(new ap.a(r.j.good));
                }
                if (rA() == 1) {
                    arrayList.add(new ap.a(r.j.commit_top));
                }
                if (sv() && ro() != null && sf() == 2) {
                    arrayList.add(new ap.a(r.j.interview_live));
                }
                if (si()) {
                    Integer num2 = UT.get(new Point(sh(), sg()));
                    if (num2 != null) {
                        arrayList.add(new ap.a(num2.intValue(), r.d.cp_other_b, r.f.pic_dot_title_red));
                    } else {
                        arrayList.add(new ap.a(r.j.card_promotion_text));
                    }
                }
                if (this.UD == 1) {
                    arrayList.add(new ap.a(r.j.card_tbread_text));
                }
                if (rS() != null) {
                    arrayList.add(new ap.a(r.j.send_app_code_gift, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (rR() != null) {
                    arrayList.add(new ap.a(r.j.card_promotion_text, r.d.cp_other_b, r.f.pic_dot_title_red));
                }
                if (sw()) {
                    arrayList.add(new ap.a(r.j.evaluation));
                }
                if (!com.baidu.tbadk.core.util.av.isEmpty(rw())) {
                    arrayList.add(new ap.a(rw()));
                }
            }
        }
        if (arrayList.size() > 0) {
            spannableStringBuilder = com.baidu.tieba.card.ap.a((Context) TbadkCoreApplication.m9getInst(), g, (ArrayList<ap.a>) arrayList, false);
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
        this.TH = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.UF != null && this.UF.size() > 0) {
            int size = this.UF.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.UF.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bi(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public void sl() {
        d(false, false);
    }

    public void sm() {
        d(true, false);
    }

    public void sn() {
        d(false, true);
    }

    public AnchorInfoData so() {
        return this.TR;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sp() {
        return this.threadType == 36;
    }

    public boolean sq() {
        return this.threadType == 40;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sr() {
        return this.Uc;
    }

    public void bY(int i) {
        this.Uc = i;
    }

    public int ss() {
        return this.Un;
    }

    @Override // com.baidu.tbadk.core.util.ai
    public ArrayList<com.baidu.tbadk.core.util.ah> getImages() {
        ArrayList<MediaData> rP = rP();
        if (rP == null || se()) {
            return null;
        }
        ArrayList<com.baidu.tbadk.core.util.ah> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rP.size() || i2 >= 3) {
                break;
            }
            if (rP.get(i2) != null && rP.get(i2).getType() == 3) {
                com.baidu.tbadk.core.util.ah ahVar = new com.baidu.tbadk.core.util.ah();
                if (!StringUtils.isNull(rP.get(i2).getThumbnails_url())) {
                    ahVar.imgUrl = rP.get(i2).getThumbnails_url();
                } else {
                    ahVar.imgUrl = rP.get(i2).getPicUrl();
                }
                ahVar.aaU = 13;
                arrayList.add(ahVar);
            }
            i = i2 + 1;
        }
        if (this.TY != null && !StringUtils.isNull(this.TY.thumbnail_url)) {
            com.baidu.tbadk.core.util.ah ahVar2 = new com.baidu.tbadk.core.util.ah();
            ahVar2.imgUrl = this.TY.thumbnail_url;
            ahVar2.aaU = 13;
            arrayList.add(ahVar2);
        }
        if (this.author != null) {
            com.baidu.tbadk.core.util.ah ahVar3 = new com.baidu.tbadk.core.util.ah();
            ahVar3.imgUrl = this.author.getPortrait();
            ahVar3.aaU = 28;
            arrayList.add(ahVar3);
        }
        return arrayList;
    }

    public boolean st() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int rA = rA();
        if (rA == 2 || rA == 1) {
            return Tm;
        }
        if (this.TY != null && sD()) {
            return Tw;
        }
        if (this.TY != null) {
            if (rH()) {
                return Tq;
            }
            return Tp;
        } else if (ru() != null && getThreadType() == 36 && ru().type.intValue() == 2) {
            return Tu;
        } else {
            if (ru() != null && getThreadType() == 36 && ru().type.intValue() == 1) {
                return Tv;
            }
            if (ro() != null && getThreadType() == 41 && rC() == 1 && sf() == 2) {
                return Tr.get() ? Uu : Tn;
            } else if (si() && sh() == 1) {
                return Tr.get() ? Uz : Tn;
            } else if (si() && sh() == 2) {
                return Tr.get() ? Ut : Tn;
            } else if (rH()) {
                return To;
            } else {
                return Tn;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus su() {
        return this.Um;
    }

    public List<TwAnchorProfitItem> qq() {
        return this.RY;
    }

    public void j(ArrayList<o> arrayList) {
        if (this.TT == 1) {
            this.Qv = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Qv = 0;
        } else {
            this.Qv = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.px() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.px().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Qv = next.py();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sv() {
        return this.threadType == 41;
    }

    public boolean sw() {
        return this.threadType == 48;
    }

    public boolean sx() {
        return this.UB;
    }

    public void ar(boolean z) {
        this.UB = z;
    }

    public String sy() {
        return this.UC;
    }

    public n sz() {
        return this.Ug;
    }

    public boolean sA() {
        return rC() == 1 || rB() == 1 || rA() == 1 || si() || this.UD == 1 || rH() || rS() != null || rR() != null || !com.baidu.adp.lib.util.j.isEmpty(rw()) || sw();
    }

    public void sB() {
        if (this.Ua == 0) {
            this.Ua = 1;
        }
    }

    public boolean sC() {
        return this.UH;
    }

    public void as(boolean z) {
        this.UQ = z;
    }

    public boolean sD() {
        return this.UQ;
    }

    public void bZ(int i) {
        this.UR = i + 1;
    }

    public int sE() {
        return this.UR;
    }

    public List<ReportInfo> sF() {
        return this.US;
    }

    public boolean sG() {
        return this.UI;
    }

    public void at(boolean z) {
        this.UI = z;
    }
}
