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
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.Abstract;
import tbclient.ActInfo;
import tbclient.DislikeInfo;
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
public class bj extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.ah {
    public static final BdUniqueId XJ = BdUniqueId.gen();
    public static final BdUniqueId XK = BdUniqueId.gen();
    public static final BdUniqueId XL = BdUniqueId.gen();
    public static final BdUniqueId XM = BdUniqueId.gen();
    public static final BdUniqueId XN = BdUniqueId.gen();
    public static final BdUniqueId XO = BdUniqueId.gen();
    public static final BdUniqueId XP = BdUniqueId.gen();
    public static AtomicBoolean XQ = new AtomicBoolean(false);
    public static AtomicBoolean XR = new AtomicBoolean(false);
    public static AtomicBoolean XS = new AtomicBoolean(false);
    public static final BdUniqueId XT = BdUniqueId.gen();
    public static final BdUniqueId XU = BdUniqueId.gen();
    public static final BdUniqueId XV = BdUniqueId.gen();
    private static HashMap<Point, Integer> YG = new HashMap<>();
    private static HashMap<Integer, Integer> YH = new HashMap<>();
    public static final BdUniqueId YS = BdUniqueId.gen();
    public static final BdUniqueId YT = BdUniqueId.gen();
    public static final BdUniqueId YY = BdUniqueId.gen();
    private static HashMap<Point, Integer> Zq = new HashMap<>();
    private static SparseArray<at.a> Zr = new SparseArray<>(3);
    public TwZhiBoUser Ws;
    public List<TwAnchorProfitItem> Wt;
    private n YF;
    private LiveCoverStatus YL;
    private int YM;
    private SkinInfo YX;
    private boolean YZ;
    private SpannableStringBuilder Yf;
    public int Yj;
    private int Yk;
    private int Ym;
    private String Yp;
    private int Yq;
    private String Yr;
    private int Yt;
    private VideoInfo Yv;
    private bq Yw;
    private c Yx;
    private long Yy;
    private String Za;
    private boolean Zf;
    private boolean Zg;
    public String Zh;
    public String Zi;
    public String Zj;
    public long Zk;
    public String Zm;
    private List<ReportInfo> Zp;
    private p Zv;
    private String address;
    private String authorId;
    private String latitude;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public int XW = 1;
    private String Yl = null;
    private int UH = 0;
    public int Yz = 0;
    private String YA = "";
    private String YI = "";
    public boolean Zl = true;
    public boolean Zs = false;
    public boolean Zt = false;
    private int Zu = -1;
    private SparseArray<String> WE = null;
    private String id = null;
    private String WD = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int XX = 0;
    private int view_num = 0;
    private String last_time = null;
    private long XY = 0;
    private int XZ = 0;
    private int Ya = 0;
    private int Yb = 0;
    private bo Yc = new bo();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> Yh = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> Yi = new ArrayList<>();
    private int Yd = 0;
    private int Ye = 0;
    private String ad_url = null;
    private String Yg = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData Yn = new PraiseData();
    private AnchorInfoData Yo = new AnchorInfoData();
    private long time = 0;
    private int Ys = 0;
    private ArrayList<a> YC = new ArrayList<>();
    private bt YD = null;
    private d YE = null;
    private int YJ = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Yu = new ArrayList<>();
    private boolean isHeadLive = false;
    private String YK = null;
    private int YB = 0;
    private PollInfo YN = null;
    private boolean YO = false;
    private boolean YP = false;
    private int YQ = 0;
    private boolean YR = false;
    private int anchorLevel = 0;
    public int Zb = 0;
    public k Zc = new k();
    private List<PbContent> Zd = new ArrayList();
    private List<PbContent> Ze = new ArrayList();
    private String category_name = null;
    private bh YU = new bh();
    private ArrayList<com.baidu.tbadk.data.b> YV = new ArrayList<>();
    private PushStatusData YW = new PushStatusData();
    public boolean Zn = false;
    public int Zo = -1;

    static {
        YG.put(new Point(1, 1), Integer.valueOf(w.g.label_frs_lottery_ing));
        YG.put(new Point(1, 2), Integer.valueOf(w.g.label_frs_lottery_over));
        YG.put(new Point(1, 3), Integer.valueOf(w.g.label_frs_lottery_off));
        YG.put(new Point(1, 4), Integer.valueOf(w.g.label_frs_lottery_d));
        YG.put(new Point(2, 1), Integer.valueOf(w.g.label_frs_activity_shaiing));
        YG.put(new Point(2, 2), Integer.valueOf(w.g.label_frs_activity_shai_over));
        YG.put(new Point(2, 3), Integer.valueOf(w.g.label_frs_activity_shai_off));
        YG.put(new Point(2, 4), Integer.valueOf(w.g.label_frs_activity_shai_d));
        Zq.put(new Point(1, 1), Integer.valueOf(w.l.lottery_status_ing));
        Zq.put(new Point(1, 2), Integer.valueOf(w.l.lottery_status_over));
        Zq.put(new Point(1, 3), Integer.valueOf(w.l.lottery_status_off));
        Zq.put(new Point(1, 4), Integer.valueOf(w.l.lottery_status_not_start));
        Zq.put(new Point(2, 1), Integer.valueOf(w.l.share_picture_status_ing));
        Zq.put(new Point(2, 2), Integer.valueOf(w.l.share_picture_status_over));
        Zq.put(new Point(2, 3), Integer.valueOf(w.l.share_picture_status_off));
        Zq.put(new Point(2, 4), Integer.valueOf(w.l.share_picture_status_not_start));
        YH.put(1, Integer.valueOf(w.g.label_interview_no));
        YH.put(2, Integer.valueOf(w.g.label_interview_live));
        YH.put(3, Integer.valueOf(w.g.label_interview_off));
        Zr.put(1, new at.a(w.l.interview_live_status_not_start, w.e.cp_other_b, w.g.pic_dot_title_red));
        Zr.put(2, new at.a(w.l.interview_live_status_ing, w.e.cp_other_c, w.g.pic_dot_title_green));
        Zr.put(3, new at.a(w.l.interview_live_status_over, w.e.cp_other_d, w.g.pic_dot_title_blue));
    }

    public bj() {
        this.Yk = 0;
        this.Yt = 0;
        this.YM = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.YM = 0;
        this.Yt = 0;
        this.Yk = 0;
    }

    public boolean ry() {
        return this.Yk == 1;
    }

    public bh rz() {
        return this.YU;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bN(int i) {
        this.anchorLevel = i;
    }

    public int rA() {
        return this.Yt;
    }

    public boolean rB() {
        return this.YR;
    }

    public boolean rC() {
        return this.YO;
    }

    public boolean rD() {
        return this.YP;
    }

    public void bO(int i) {
        this.YQ = i;
    }

    public int rE() {
        return this.YQ;
    }

    public PollInfo rF() {
        return this.YN;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Yy;
    }

    public PraiseData rG() {
        return this.Yn;
    }

    public void a(PraiseData praiseData) {
        this.Yn = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rH() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void ci(String str) {
        this.WD = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.WD) || "0".equals(this.WD)) ? this.id : this.WD;
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

    public void bP(int i) {
        this.reply_num = i;
    }

    public int rJ() {
        return this.reply_num;
    }

    public int rK() {
        return this.view_num;
    }

    public long rL() {
        return this.XY;
    }

    public void m(long j) {
        this.XY = j;
    }

    public int rM() {
        return this.XZ;
    }

    public void bQ(int i) {
        this.XZ = i;
    }

    public int rN() {
        return this.Ya;
    }

    public void bR(int i) {
        this.Ya = i;
    }

    public int rO() {
        return this.Yb;
    }

    public List<PbContent> rP() {
        return this.Zd;
    }

    public bo rQ() {
        return this.Yc;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rR() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rS() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return false;
        }
        return this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3 || this.author.getGodUserData().getType() == 1;
    }

    public boolean rT() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean rU() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rV() {
        return this.forum_name;
    }

    public void co(String str) {
        this.forum_name = str;
    }

    public int rW() {
        return this.Ye;
    }

    public String rX() {
        return this.ad_url;
    }

    public String rY() {
        return this.Yg;
    }

    public void cp(String str) {
        this.Yg = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.Ze == null || this.Ze.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.Ze.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.Ze.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.Zd == null || (size = this.Zd.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.Zd.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cq(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.Ze != null && (size = this.Ze.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.Ze.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (!TextUtils.isEmpty(pbContent.text)) {
                    if (pbContent.text.length() + i3 > spannableString.length()) {
                        break;
                    }
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bk(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public String rZ() {
        return this.Yl;
    }

    public void cr(String str) {
        this.Yl = str;
    }

    public ArrayList<MediaData> sa() {
        return this.Yh;
    }

    public ArrayList<a> sb() {
        return this.YC;
    }

    public void h(ArrayList<a> arrayList) {
        this.YC = arrayList;
    }

    public bt sc() {
        return this.YD;
    }

    public d sd() {
        return this.YE;
    }

    public ArrayList<VoiceData.VoiceModel> se() {
        return this.Yi;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int sf() {
        return this.Yq;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String sg() {
        return this.YA;
    }

    public VideoInfo sh() {
        return this.Yv;
    }

    public c si() {
        return this.Yx;
    }

    public String getPhotoLiveCover() {
        return this.YI;
    }

    public void setPhotoLiveCover(String str) {
        this.YI = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> sj() {
        return this.Yu;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Yu.clear();
        this.Yu.addAll(arrayList);
    }

    public String getNotice() {
        return this.YK;
    }

    public PushStatusData sk() {
        return this.YW;
    }

    public SkinInfo sl() {
        return this.YX;
    }

    public long sm() {
        return this.Zk;
    }

    public boolean sn() {
        return this.Zl;
    }

    public String so() {
        return this.Zm;
    }

    public p sp() {
        return this.Zv;
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
                    this.Yr = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.Yk = threadInfo.is_tbread_dispatch.intValue();
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.WD = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Yy = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.XX = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.XY = threadInfo.last_time_int.intValue();
                this.XZ = threadInfo.is_top.intValue();
                this.Ya = threadInfo.is_good.intValue();
                this.Yb = threadInfo.is_livepost.intValue();
                this.Yc.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.Yd = threadInfo.has_commented.intValue();
                this.Ye = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Yv = threadInfo.video_info;
                this.Yx = new c();
                this.Yx.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.Yl = threadInfo.collect_mark_pid;
                this.Ym = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.Yp = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.YA = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.Yq = threadInfo.is_ntitle.intValue();
                this.Ys = threadInfo.is_activity.intValue();
                this.category_name = threadInfo.category_name;
                this.Yt = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.Zf = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.Zd = threadInfo.rich_title;
                this.Ze = threadInfo.rich_abstract;
                this.Yj = threadInfo.is_godthread_recommend.intValue();
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
                this.Yg = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.Yh.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Yv = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.Yw = new bq();
                    this.Yw.a(threadInfo.video_channel_info);
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
                        this.Yi.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.YC.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.YD = new bt();
                    this.YD.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.YE = new d();
                    this.YE.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.YF = new n();
                    this.YF.a(threadInfo.cartoon_info);
                }
                this.Yn.setUserMap(this.userMap);
                this.Yn.parserProtobuf(threadInfo.zan);
                this.Yo.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Yn.setTitle(this.title);
                } else {
                    this.Yn.setTitle(this.Yg);
                }
                this.YI = threadInfo.livecover_src;
                this.YJ = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.YB = threadInfo.post_num.intValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.ee(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.Yu.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.YK = noticeInfo.notice;
                    }
                    this.YQ = zhiBoInfoTW.copythread_remind.intValue();
                    this.YO = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.YP = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.YI)) {
                        this.YI = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.Ws = zhiBoInfoTW.user.tw_anchor_info;
                        this.Wt = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.YL = threadInfo.twzhibo_info.livecover_status;
                    this.YM = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.YN = threadInfo.poll_info;
                this.YR = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.YU.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.YV.add(bVar);
                    }
                }
                this.YW.parserProtobuf(threadInfo.push_status);
                this.Za = threadInfo.lego_card;
                this.YX = threadInfo.skin_info;
                this.Zb = threadInfo.is_book_chapter.intValue();
                this.Zc.a(threadInfo.book_chapter);
                this.Zh = threadInfo.recom_source;
                this.Zm = threadInfo.recom_reason;
                this.Zi = threadInfo.recom_weight;
                this.Zj = threadInfo.ab_tag;
                this.Zk = threadInfo.last_read_pid.longValue();
                this.Zl = threadInfo.cheak_repeat.intValue() == 1;
                this.Zp = threadInfo.report_info;
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.x.p(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.WE = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.x.q(threadInfo.declare_list)) {
                    this.Zv = new p();
                    this.Zv.a(threadInfo);
                }
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
                this.WD = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.Yy = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.XX = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.XY = jSONObject.optLong("last_time_int", 0L);
                this.XZ = jSONObject.optInt("is_top", 0);
                this.Ya = jSONObject.optInt("is_good", 0);
                this.Yb = jSONObject.optInt("is_livepost", 0);
                this.Yc.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.Yd = jSONObject.optInt("has_commented", 0);
                this.Ye = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.Yl = jSONObject.optString("collect_mark_pid");
                this.Ym = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.Yp = jSONObject.optString("first_post_id", "0");
                this.YA = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.Yq = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("author");
                if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.Yx = new c();
                this.Yx.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.Yg = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.Yh.add(mediaData);
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
                        this.Yi.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.YC.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.YD = new bt();
                    this.YD.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.YE = new d();
                    this.YE.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.YF = new n();
                    this.YF.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.Yn.setUserMap(this.userMap);
                this.Yn.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.Yo.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.Yn.setTitle(this.title);
                } else {
                    this.Yn.setTitle(this.Yg);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("task_info");
                if (optJSONObject3 != null) {
                    this.YU.parserJson(optJSONObject3);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.YV.add(bVar);
                    }
                }
                this.Zb = jSONObject.optInt("is_book_chapter", 0);
                this.Zc.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.Zh = jSONObject.optString("recom_source");
                this.Zm = jSONObject.optString("recom_reason");
                this.Zi = jSONObject.optString("recom_weight");
                this.Zk = jSONObject.optLong("last_read_pid");
                this.Zl = jSONObject.optInt("cheak_repeat") == 1;
                if (jSONObject.optJSONObject("video_channel_info") != null) {
                    this.Yw = new bq();
                    this.Yw.i(jSONObject.optJSONObject("video_channel_info"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder sq() {
        return this.Yf;
    }

    public boolean sr() {
        return rM() != 0;
    }

    public int ss() {
        if (this.YU != null) {
            long rs = this.YU.rs();
            long rt = this.YU.rt();
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

    public int st() {
        if (sv() && this.YC.size() >= 1) {
            a aVar = this.YC.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pi = aVar.pi();
            int pj = aVar.pj();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pi) {
                return 4;
            }
            return currentTimeMillis > pj ? 2 : 1;
        }
        return -1;
    }

    public int su() {
        if (!sv() || this.YC.size() < 1 || this.YC.get(0) == null) {
            return -1;
        }
        return this.YC.get(0).ph();
    }

    public boolean sv() {
        return this.Ys == 1;
    }

    public String sw() {
        return (!sv() || this.YC.size() < 1 || this.YC.get(0) == null) ? "" : this.YC.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cs(String str) {
        com.baidu.adp.widget.d dVar;
        if (str == null) {
            return null;
        }
        if (str.length() > 4) {
            str = str.substring(0, 4);
        }
        View inflate = LayoutInflater.from(TbadkCoreApplication.m9getInst().getApplicationContext()).inflate(w.j.thread_category, (ViewGroup) null);
        if (inflate != null) {
            TextView textView = (TextView) inflate.findViewById(w.h.thread_category);
            textView.setText(str);
            textView.setTextColor(TbadkCoreApplication.m9getInst().getApplicationContext().getResources().getColor(w.e.cp_cont_f_1));
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
            if (getThreadType() == 42 && sx()) {
                arrayList.add(Integer.valueOf(w.g.icon_convene));
            }
            if (rM() == 1) {
                arrayList.add(Integer.valueOf(w.g.icon_top));
            } else if (rM() == 2) {
                arrayList.add(Integer.valueOf(w.g.icon_notice));
            }
            if (rO() == 1 || this.Yc.tf() != 0) {
                if (rz() != null && getThreadType() == 41) {
                    if (ss() == 2) {
                        arrayList.add(Integer.valueOf(w.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(w.g.icon_zhibo));
                }
            }
            if (z && sI()) {
                Integer num = YH.get(Integer.valueOf(ss()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rN() == 1 && !sr() && XM != getType() && XP != getType()) {
                arrayList.add(Integer.valueOf(w.g.icon_elite));
            }
            if (getType() == XT || getType() == XU) {
                arrayList.add(Integer.valueOf(w.g.icon_vote_blue));
            }
            if (this.Yo != null && this.Yo.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(w.g.icon_live_on));
            }
            if (rW() == 1) {
                arrayList.add(Integer.valueOf(w.g.frs_post_ding));
            }
            if (!z && su() == 2) {
                arrayList.add(Integer.valueOf(w.g.label_frs_activity_shai));
            } else {
                Integer num2 = YG.get(new Point(su(), st()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (sc() != null) {
                arrayList.add(Integer.valueOf(w.g.tag_act));
            }
            if (sd() != null) {
                arrayList.add(Integer.valueOf(w.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cs(this.category_name);
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
                Bitmap cL = com.baidu.tbadk.core.util.aq.cL(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cL);
                if (cL != null) {
                    bitmapDrawable.setBounds(0, 0, cL.getWidth(), cL.getHeight());
                }
                com.baidu.tbadk.core.view.al alVar = new com.baidu.tbadk.core.view.al(bitmapDrawable);
                alVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.XW));
                spannableString.setSpan(alVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder c = !z && rM() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.Yf = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<at.a> arrayList) {
        if (sD() || !rS() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new at.a(w.l.god_title));
        }
        return com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), str, arrayList, true);
    }

    private boolean sx() {
        return com.baidu.adp.lib.b.e.eT().ab("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        boolean rS = rS();
        if (z2) {
            if (z) {
                if (rS && !sD()) {
                    arrayList.add(new at.a(w.l.god_title));
                }
                if (rO() == 1 || getThreadType() == 33 || (rQ() != null && rQ().tf() != 0)) {
                    if (rz() != null && sI()) {
                        if (ss() == 2) {
                            arrayList.add(new at.a(w.l.interview_live));
                        }
                    } else if (!rS) {
                        arrayList.add(new at.a(w.l.kn_zhibo));
                    }
                }
                if (rM() == 1) {
                    arrayList.add(new at.a(w.l.commit_top));
                }
                if (rN() == 1) {
                    arrayList.add(new at.a(w.l.good));
                }
                if (sI()) {
                    arrayList.add(Zr.get(ss()));
                }
                if (sv()) {
                    Integer num = Zq.get(new Point(su(), st()));
                    if (num != null) {
                        arrayList.add(new at.a(num.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(w.l.card_promotion_text));
                    }
                }
                if (sJ()) {
                    arrayList.add(new at.a(w.l.evaluation));
                }
                if (sc() != null) {
                    arrayList.add(new at.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(rI())) {
                    arrayList.add(new at.a(rI()));
                }
            } else {
                if (rS && rM() != 1 && !sD()) {
                    arrayList.add(new at.a(w.l.god_title));
                }
                if ((rO() == 1 || getThreadType() == 33) && !sI() && !rS) {
                    arrayList.add(new at.a(w.l.kn_zhibo));
                }
                if (rN() == 1) {
                    arrayList.add(new at.a(w.l.good));
                }
                if (rM() == 1) {
                    arrayList.add(new at.a(w.l.commit_top));
                }
                if (sI() && rz() != null && ss() == 2) {
                    arrayList.add(new at.a(w.l.interview_live));
                }
                if (sv()) {
                    Integer num2 = Zq.get(new Point(su(), st()));
                    if (num2 != null) {
                        arrayList.add(new at.a(num2.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(w.l.card_promotion_text));
                    }
                }
                if (this.Zb == 1) {
                    arrayList.add(new at.a(w.l.card_tbread_text));
                }
                if (sd() != null) {
                    arrayList.add(new at.a(w.l.send_app_code_gift, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (sc() != null) {
                    arrayList.add(new at.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (sJ()) {
                    arrayList.add(new at.a(w.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(rI())) {
                    arrayList.add(new at.a(rI()));
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
        this.Yf = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.Zd != null && this.Zd.size() > 0) {
            int size = this.Zd.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.Zd.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bl(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public void sy() {
        d(false, false);
    }

    public void sz() {
        d(true, false);
    }

    public void sA() {
        d(false, true);
    }

    public AnchorInfoData sB() {
        return this.Yo;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sC() {
        return this.threadType == 36;
    }

    public boolean sD() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sE() {
        return this.YB;
    }

    public void bS(int i) {
        this.YB = i;
    }

    public int sF() {
        return this.YM;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> sa = sa();
        if (sa == null || sr()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sa.size() || i2 >= 3) {
                break;
            }
            if (sa.get(i2) != null && sa.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(sa.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = sa.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = sa.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.Yv != null && !StringUtils.isNull(this.Yv.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.Yv.thumbnail_url;
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

    public boolean sG() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int rM = rM();
        if (this.Yx != null && this.threadType == 49) {
            return XN;
        }
        if (this.threadType == 51) {
            return XO;
        }
        if (rM == 2 || rM == 1) {
            return XJ;
        }
        if (this.Yv != null && sQ()) {
            return XV;
        }
        if (this.Yv != null) {
            if (rT()) {
                return XP;
            }
            return XM;
        } else if (rF() != null && getThreadType() == 36 && rF().type.intValue() == 2) {
            return XT;
        } else {
            if (rF() != null && getThreadType() == 36 && rF().type.intValue() == 1) {
                return XU;
            }
            if (rz() != null && getThreadType() == 41 && rO() == 1 && ss() == 2) {
                return XQ.get() ? YT : XK;
            } else if (sv() && su() == 1) {
                return XQ.get() ? YY : XK;
            } else if (sv() && su() == 2) {
                return XQ.get() ? YS : XK;
            } else if (rT()) {
                return XL;
            } else {
                return XK;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sH() {
        return this.YL;
    }

    public List<TwAnchorProfitItem> qB() {
        return this.Wt;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.Yq == 1) {
            this.UH = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.UH = 0;
        } else {
            this.UH = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.pE() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pE().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.UH = next.pF();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sI() {
        return this.threadType == 41;
    }

    public boolean sJ() {
        return this.threadType == 48;
    }

    public boolean sK() {
        return this.YZ;
    }

    public void aq(boolean z) {
        this.YZ = z;
    }

    public String sL() {
        return this.Za;
    }

    public n sM() {
        return this.YF;
    }

    public boolean sN() {
        return rO() == 1 || rN() == 1 || rM() == 1 || sv() || this.Zb == 1 || rT() || sd() != null || sc() != null || !com.baidu.adp.lib.util.j.isEmpty(rI()) || sJ();
    }

    public void sO() {
        if (this.Yz == 0) {
            this.Yz = 1;
        }
    }

    public boolean sP() {
        return this.Zf;
    }

    public void ar(boolean z) {
        this.Zn = z;
    }

    public boolean sQ() {
        return this.Zn;
    }

    public void bT(int i) {
        this.Zo = i + 1;
    }

    public int sR() {
        return this.Zo;
    }

    public List<ReportInfo> sS() {
        return this.Zp;
    }

    public boolean sT() {
        return this.Zg;
    }

    public void as(boolean z) {
        this.Zg = z;
    }

    public bq sU() {
        return this.Yw;
    }

    public void a(bq bqVar) {
        this.Yw = bqVar;
    }

    public void bU(int i) {
        if (this.Yw != null) {
            this.Yw.mCurrentPage = i;
        }
    }

    public boolean sV() {
        return getThreadType() == 49;
    }

    public int sW() {
        return this.Zu;
    }

    public void setSmartFrsPosition(int i) {
        this.Zu = i;
    }

    public SparseArray<String> qJ() {
        return this.WE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.WE = sparseArray;
    }

    public String sX() {
        return this.Zh;
    }
}
