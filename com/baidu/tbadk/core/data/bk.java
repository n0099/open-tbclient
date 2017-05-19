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
import com.baidu.tieba.card.ap;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import com.baidu.tieba.tbadkCore.data.PostData;
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
public class bk extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.ah {
    public TwZhiBoUser VZ;
    public List<TwAnchorProfitItem> Wa;
    private SpannableStringBuilder XO;
    public int XS;
    private int XT;
    private int XV;
    private String XY;
    private int XZ;
    private SkinInfo YG;
    private boolean YI;
    private String YJ;
    private boolean YO;
    private boolean YP;
    public String YQ;
    public String YR;
    public String YS;
    public long YT;
    public String YV;
    private List<ReportInfo> YY;
    private String Ya;
    private int Yc;
    private VideoInfo Ye;
    private br Yf;
    private c Yg;
    private long Yh;
    private n Yo;
    private LiveCoverStatus Yu;
    private int Yv;
    private p Ze;
    private boolean Zf;
    private String address;
    private String authorId;
    private String latitude;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Xs = BdUniqueId.gen();
    public static final BdUniqueId Xt = BdUniqueId.gen();
    public static final BdUniqueId Xu = BdUniqueId.gen();
    public static final BdUniqueId Xv = BdUniqueId.gen();
    public static final BdUniqueId Xw = BdUniqueId.gen();
    public static final BdUniqueId Xx = BdUniqueId.gen();
    public static final BdUniqueId Xy = BdUniqueId.gen();
    public static AtomicBoolean Xz = new AtomicBoolean(false);
    public static AtomicBoolean XA = new AtomicBoolean(false);
    public static AtomicBoolean XB = new AtomicBoolean(false);
    public static final BdUniqueId XC = BdUniqueId.gen();
    public static final BdUniqueId XD = BdUniqueId.gen();
    public static final BdUniqueId XE = BdUniqueId.gen();
    private static HashMap<Point, Integer> Yp = new HashMap<>();
    private static HashMap<Integer, Integer> Yq = new HashMap<>();
    public static final BdUniqueId YB = BdUniqueId.gen();
    public static final BdUniqueId YC = BdUniqueId.gen();
    public static final BdUniqueId YH = BdUniqueId.gen();
    private static HashMap<Point, Integer> YZ = new HashMap<>();
    private static SparseArray<ap.a> Za = new SparseArray<>(3);
    public int XF = 1;
    private String XU = null;
    private int Uu = 0;
    public int Yi = 0;
    private String Yj = "";
    private String Yr = "";
    public boolean YU = true;
    public boolean Zb = false;
    public boolean Zc = false;
    private int Zd = -1;
    private SparseArray<String> Wm = null;
    private String id = null;
    private String Wl = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int XG = 0;
    private int view_num = 0;
    private String last_time = null;
    private long XH = 0;
    private int XI = 0;
    private int XJ = 0;
    private int XK = 0;
    private bp XL = new bp();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> XQ = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> XR = new ArrayList<>();
    private int XM = 0;
    private int XN = 0;
    private String ad_url = null;
    private String XP = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData XW = new PraiseData();
    private AnchorInfoData XX = new AnchorInfoData();
    private long time = 0;
    private int Yb = 0;
    private ArrayList<a> Yl = new ArrayList<>();
    private bu Ym = null;
    private d Yn = null;
    private int Ys = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> Yd = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Yt = null;
    private int Yk = 0;
    private PollInfo Yw = null;
    private boolean Yx = false;
    private boolean Yy = false;
    private int Yz = 0;
    private boolean YA = false;
    private int anchorLevel = 0;
    public int YK = 0;
    public k YL = new k();
    private List<PbContent> YM = new ArrayList();
    private List<PbContent> YN = new ArrayList();
    private String category_name = null;
    private bi YD = new bi();
    private ArrayList<com.baidu.tbadk.data.b> YE = new ArrayList<>();
    private PushStatusData YF = new PushStatusData();
    public boolean YW = false;
    public int YX = -1;
    private int Zg = 0;
    private PostData Zh = new PostData();

    static {
        Yp.put(new Point(1, 1), Integer.valueOf(w.g.label_frs_lottery_ing));
        Yp.put(new Point(1, 2), Integer.valueOf(w.g.label_frs_lottery_over));
        Yp.put(new Point(1, 3), Integer.valueOf(w.g.label_frs_lottery_off));
        Yp.put(new Point(1, 4), Integer.valueOf(w.g.label_frs_lottery_d));
        Yp.put(new Point(2, 1), Integer.valueOf(w.g.label_frs_activity_shaiing));
        Yp.put(new Point(2, 2), Integer.valueOf(w.g.label_frs_activity_shai_over));
        Yp.put(new Point(2, 3), Integer.valueOf(w.g.label_frs_activity_shai_off));
        Yp.put(new Point(2, 4), Integer.valueOf(w.g.label_frs_activity_shai_d));
        YZ.put(new Point(1, 1), Integer.valueOf(w.l.lottery_status_ing));
        YZ.put(new Point(1, 2), Integer.valueOf(w.l.lottery_status_over));
        YZ.put(new Point(1, 3), Integer.valueOf(w.l.lottery_status_off));
        YZ.put(new Point(1, 4), Integer.valueOf(w.l.lottery_status_not_start));
        YZ.put(new Point(2, 1), Integer.valueOf(w.l.share_picture_status_ing));
        YZ.put(new Point(2, 2), Integer.valueOf(w.l.share_picture_status_over));
        YZ.put(new Point(2, 3), Integer.valueOf(w.l.share_picture_status_off));
        YZ.put(new Point(2, 4), Integer.valueOf(w.l.share_picture_status_not_start));
        Yq.put(1, Integer.valueOf(w.g.label_interview_no));
        Yq.put(2, Integer.valueOf(w.g.label_interview_live));
        Yq.put(3, Integer.valueOf(w.g.label_interview_off));
        Za.put(1, new ap.a(w.l.interview_live_status_not_start, w.e.cp_other_b, w.g.pic_dot_title_red));
        Za.put(2, new ap.a(w.l.interview_live_status_ing, w.e.cp_other_c, w.g.pic_dot_title_green));
        Za.put(3, new ap.a(w.l.interview_live_status_over, w.e.cp_other_d, w.g.pic_dot_title_blue));
    }

    public bk() {
        this.XT = 0;
        this.Yc = 0;
        this.Yv = 0;
        this.post_num = 0;
        this.post_num = 0;
        this.Yv = 0;
        this.Yc = 0;
        this.XT = 0;
    }

    public boolean rg() {
        return this.XT == 1;
    }

    public bi rh() {
        return this.YD;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bN(int i) {
        this.anchorLevel = i;
    }

    public int ri() {
        return this.Yc;
    }

    public boolean rj() {
        return this.YA;
    }

    public boolean rk() {
        return this.Yx;
    }

    public boolean rl() {
        return this.Yy;
    }

    public void bO(int i) {
        this.Yz = i;
    }

    public int rm() {
        return this.Yz;
    }

    public PollInfo rn() {
        return this.Yw;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Yh;
    }

    public PraiseData ro() {
        return this.XW;
    }

    public void a(PraiseData praiseData) {
        this.XW = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rp() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cp(String str) {
        this.Wl = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.Wl) || "0".equals(this.Wl)) ? this.id : this.Wl;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String rq() {
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

    public int rr() {
        return this.reply_num;
    }

    public int rs() {
        return this.view_num;
    }

    public void bQ(int i) {
        this.view_num = i;
    }

    public long rt() {
        return this.XH;
    }

    public void m(long j) {
        this.XH = j;
    }

    public int ru() {
        return this.XI;
    }

    public void bR(int i) {
        this.XI = i;
    }

    public int rv() {
        return this.XJ;
    }

    public void bS(int i) {
        this.XJ = i;
    }

    public int rw() {
        return this.XK;
    }

    public List<PbContent> rx() {
        return this.YM;
    }

    public bp ry() {
        return this.XL;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rz() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rA() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return false;
        }
        return this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3 || this.author.getGodUserData().getType() == 1;
    }

    public boolean rB() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean rC() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rD() {
        return this.forum_name;
    }

    public void ct(String str) {
        this.forum_name = str;
    }

    public int rE() {
        return this.XN;
    }

    public String rF() {
        return this.ad_url;
    }

    public String rG() {
        return this.XP;
    }

    public void cu(String str) {
        this.XP = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.YN == null || this.YN.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.YN.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.YN.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.YM == null || (size = this.YM.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.YM.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cv(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.YN != null && (size = this.YN.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.YN.get(i2);
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

    public String rH() {
        return this.XU;
    }

    public void cw(String str) {
        this.XU = str;
    }

    public ArrayList<MediaData> rI() {
        return this.XQ;
    }

    public ArrayList<a> rJ() {
        return this.Yl;
    }

    public void h(ArrayList<a> arrayList) {
        this.Yl = arrayList;
    }

    public bu rK() {
        return this.Ym;
    }

    public d rL() {
        return this.Yn;
    }

    public ArrayList<VoiceData.VoiceModel> rM() {
        return this.XR;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rN() {
        return this.XZ;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rO() {
        return this.Yj;
    }

    public VideoInfo rP() {
        return this.Ye;
    }

    public c rQ() {
        return this.Yg;
    }

    public String getPhotoLiveCover() {
        return this.Yr;
    }

    public void setPhotoLiveCover(String str) {
        this.Yr = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> rR() {
        return this.Yd;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.Yd.clear();
        this.Yd.addAll(arrayList);
    }

    public String getNotice() {
        return this.Yt;
    }

    public PushStatusData rS() {
        return this.YF;
    }

    public SkinInfo rT() {
        return this.YG;
    }

    public long rU() {
        return this.YT;
    }

    public boolean rV() {
        return this.YU;
    }

    public String rW() {
        return this.YV;
    }

    public p rX() {
        return this.Ze;
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
                    this.Ya = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.XT = threadInfo.is_tbread_dispatch.intValue();
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.Wl = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Yh = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.XG = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.XH = threadInfo.last_time_int.intValue();
                this.XI = threadInfo.is_top.intValue();
                this.XJ = threadInfo.is_good.intValue();
                this.XK = threadInfo.is_livepost.intValue();
                this.XL.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.XM = threadInfo.has_commented.intValue();
                this.XN = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Ye = threadInfo.video_info;
                this.Yg = new c();
                this.Yg.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.XU = threadInfo.collect_mark_pid;
                this.XV = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.XY = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Yj = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.XZ = threadInfo.is_ntitle.intValue();
                this.Yb = threadInfo.is_activity.intValue();
                this.Zg = threadInfo.agree_num.intValue();
                this.category_name = threadInfo.category_name;
                this.Yc = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.YO = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.YM = threadInfo.rich_title;
                this.YN = threadInfo.rich_abstract;
                this.XS = threadInfo.is_godthread_recommend.intValue();
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
                this.XP = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.XQ.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Ye = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.Yf = new br();
                    this.Yf.a(threadInfo.video_channel_info);
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
                        this.XR.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Yl.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Ym = new bu();
                    this.Ym.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Yn = new d();
                    this.Yn.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Yo = new n();
                    this.Yo.a(threadInfo.cartoon_info);
                }
                this.XW.setUserMap(this.userMap);
                this.XW.parserProtobuf(threadInfo.zan);
                this.XX.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.XW.setTitle(this.title);
                } else {
                    this.XW.setTitle(this.XP);
                }
                this.Yr = threadInfo.livecover_src;
                this.Ys = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Yk = threadInfo.post_num.intValue();
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
                                this.Yd.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Yt = noticeInfo.notice;
                    }
                    this.Yz = zhiBoInfoTW.copythread_remind.intValue();
                    this.Yx = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Yy = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Yr)) {
                        this.Yr = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.VZ = zhiBoInfoTW.user.tw_anchor_info;
                        this.Wa = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Yu = threadInfo.twzhibo_info.livecover_status;
                    this.Yv = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Yw = threadInfo.poll_info;
                this.YA = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.YD.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.YE.add(bVar);
                    }
                }
                this.YF.parserProtobuf(threadInfo.push_status);
                this.YJ = threadInfo.lego_card;
                this.YG = threadInfo.skin_info;
                this.YK = threadInfo.is_book_chapter.intValue();
                this.YL.a(threadInfo.book_chapter);
                this.YQ = threadInfo.recom_source;
                this.YV = threadInfo.recom_reason;
                this.YR = threadInfo.recom_weight;
                this.YS = threadInfo.ab_tag;
                this.YT = threadInfo.last_read_pid.longValue();
                this.YU = threadInfo.cheak_repeat.intValue() == 1;
                this.YY = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.Zh.a(threadInfo.top_agree_post, TbadkCoreApplication.m9getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.x.q(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.Wm = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.x.r(threadInfo.declare_list)) {
                    this.Ze = new p();
                    this.Ze.a(threadInfo);
                }
                this.Zf = threadInfo.is_multiforum_thread.intValue() == 1;
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
                this.Wl = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.Yh = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.XG = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.XH = jSONObject.optLong("last_time_int", 0L);
                this.XI = jSONObject.optInt("is_top", 0);
                this.XJ = jSONObject.optInt("is_good", 0);
                this.XK = jSONObject.optInt("is_livepost", 0);
                this.XL.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.XM = jSONObject.optInt("has_commented", 0);
                this.XN = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.XU = jSONObject.optString("collect_mark_pid");
                this.XV = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.XY = jSONObject.optString("first_post_id", "0");
                this.Yj = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.XZ = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.YD.parserJson(optJSONObject2);
                }
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.Yg = new c();
                this.Yg.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.XP = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.XQ.add(mediaData);
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
                        this.XR.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Yl.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Ym = new bu();
                    this.Ym.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Yn = new d();
                    this.Yn.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.Yo = new n();
                    this.Yo.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.XW.setUserMap(this.userMap);
                this.XW.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.XX.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.XW.setTitle(this.title);
                } else {
                    this.XW.setTitle(this.XP);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("task_info");
                if (optJSONObject4 != null) {
                    this.YD.parserJson(optJSONObject4);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.YE.add(bVar);
                    }
                }
                this.YK = jSONObject.optInt("is_book_chapter", 0);
                this.YL.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.YQ = jSONObject.optString("recom_source");
                this.YV = jSONObject.optString("recom_reason");
                this.YR = jSONObject.optString("recom_weight");
                this.YT = jSONObject.optLong("last_read_pid");
                this.YU = jSONObject.optInt("cheak_repeat") == 1;
                if (jSONObject.optJSONObject("video_channel_info") != null) {
                    this.Yf = new br();
                    this.Yf.i(jSONObject.optJSONObject("video_channel_info"));
                }
                this.Zf = jSONObject.optInt("is_multiforum_thread") == 1;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rY() {
        return this.XO;
    }

    public boolean rZ() {
        return ru() != 0;
    }

    public int sa() {
        if (this.YD != null) {
            long ra = this.YD.ra();
            long rb = this.YD.rb();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < ra) {
                return 1;
            }
            if (currentTimeMillis > rb) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int sb() {
        if (sd() && this.Yl.size() >= 1) {
            a aVar = this.Yl.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pn = aVar.pn();
            int po = aVar.po();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pn) {
                return 4;
            }
            return currentTimeMillis > po ? 2 : 1;
        }
        return -1;
    }

    public int sc() {
        if (!sd() || this.Yl.size() < 1 || this.Yl.get(0) == null) {
            return -1;
        }
        return this.Yl.get(0).pm();
    }

    public boolean sd() {
        return this.Yb == 1;
    }

    public String se() {
        return (!sd() || this.Yl.size() < 1 || this.Yl.get(0) == null) ? "" : this.Yl.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cx(String str) {
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
            if (getThreadType() == 42 && sf()) {
                arrayList.add(Integer.valueOf(w.g.icon_convene));
            }
            if (ru() == 1) {
                arrayList.add(Integer.valueOf(w.g.icon_top));
            } else if (ru() == 2) {
                arrayList.add(Integer.valueOf(w.g.icon_notice));
            }
            if (rw() == 1 || this.XL.sQ() != 0) {
                if (rh() != null && getThreadType() == 41) {
                    if (sa() == 2) {
                        arrayList.add(Integer.valueOf(w.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(w.g.icon_zhibo));
                }
            }
            if (z && sq()) {
                Integer num = Yq.get(Integer.valueOf(sa()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rv() == 1 && !rZ() && Xv != getType() && Xy != getType()) {
                arrayList.add(Integer.valueOf(w.g.icon_elite));
            }
            if (getType() == XC || getType() == XD) {
                arrayList.add(Integer.valueOf(w.g.icon_vote_blue));
            }
            if (this.XX != null && this.XX.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(w.g.icon_live_on));
            }
            if (rE() == 1) {
                arrayList.add(Integer.valueOf(w.g.frs_post_ding));
            }
            if (!z && sc() == 2) {
                arrayList.add(Integer.valueOf(w.g.label_frs_activity_shai));
            } else {
                Integer num2 = Yp.get(new Point(sc(), sb()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rK() != null) {
                arrayList.add(Integer.valueOf(w.g.tag_act));
            }
            if (rL() != null) {
                arrayList.add(Integer.valueOf(w.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cx(this.category_name);
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
                com.baidu.tbadk.core.view.ar arVar = new com.baidu.tbadk.core.view.ar(bitmapDrawable);
                arVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.XF));
                spannableString.setSpan(arVar, i3, i3 + 1, 33);
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
            SpannableStringBuilder c = !z && ru() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.XO = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<ap.a> arrayList) {
        if (sl() || !rA() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new ap.a(w.l.god_title));
        }
        return com.baidu.tieba.card.ap.a((Context) TbadkCoreApplication.m9getInst(), str, arrayList, true);
    }

    private boolean sf() {
        return com.baidu.adp.lib.b.e.eZ().Y("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        boolean rA = rA();
        if (z2) {
            if (z) {
                if (rA && !sl()) {
                    arrayList.add(new ap.a(w.l.god_title));
                }
                if (rw() == 1 || getThreadType() == 33 || (ry() != null && ry().sQ() != 0)) {
                    if (rh() != null && sq()) {
                        if (sa() == 2) {
                            arrayList.add(new ap.a(w.l.interview_live));
                        }
                    } else if (!rA) {
                        arrayList.add(new ap.a(w.l.photo_live_tips));
                    }
                }
                if (ru() == 1) {
                    arrayList.add(new ap.a(w.l.commit_top));
                }
                if (rv() == 1) {
                    arrayList.add(new ap.a(w.l.good));
                }
                if (sq()) {
                    arrayList.add(Za.get(sa()));
                }
                if (sd()) {
                    Integer num = YZ.get(new Point(sc(), sb()));
                    if (num != null) {
                        arrayList.add(new ap.a(num.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new ap.a(w.l.card_promotion_text));
                    }
                }
                if (sr()) {
                    arrayList.add(new ap.a(w.l.evaluation));
                }
                if (rK() != null) {
                    arrayList.add(new ap.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(rq())) {
                    arrayList.add(new ap.a(rq()));
                }
            } else {
                if (rA && ru() != 1 && !sl()) {
                    arrayList.add(new ap.a(w.l.god_title));
                }
                if ((rw() == 1 || getThreadType() == 33) && !sq() && !rA) {
                    arrayList.add(new ap.a(w.l.photo_live_tips));
                }
                if (rv() == 1) {
                    arrayList.add(new ap.a(w.l.good));
                }
                if (ru() == 1) {
                    arrayList.add(new ap.a(w.l.commit_top));
                }
                if (sq() && rh() != null && sa() == 2) {
                    arrayList.add(new ap.a(w.l.interview_live));
                }
                if (sd()) {
                    Integer num2 = YZ.get(new Point(sc(), sb()));
                    if (num2 != null) {
                        arrayList.add(new ap.a(num2.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new ap.a(w.l.card_promotion_text));
                    }
                }
                if (this.YK == 1) {
                    arrayList.add(new ap.a(w.l.card_tbread_text));
                }
                if (rL() != null) {
                    arrayList.add(new ap.a(w.l.send_app_code_gift, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (rK() != null) {
                    arrayList.add(new ap.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (sr()) {
                    arrayList.add(new ap.a(w.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(rq())) {
                    arrayList.add(new ap.a(rq()));
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
        this.XO = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.YM != null && this.YM.size() > 0) {
            int size = this.YM.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.YM.get(i2);
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

    public void sg() {
        d(false, false);
    }

    public void sh() {
        d(true, false);
    }

    public void si() {
        d(false, true);
    }

    public AnchorInfoData sj() {
        return this.XX;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sk() {
        return this.threadType == 36;
    }

    public boolean sl() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sm() {
        return this.Yk;
    }

    public void bT(int i) {
        this.Yk = i;
    }

    public int sn() {
        return this.Yv;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rI = rI();
        if (rI == null || rZ()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rI.size() || i2 >= 3) {
                break;
            }
            if (rI.get(i2) != null && rI.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rI.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rI.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rI.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.Ye != null && !StringUtils.isNull(this.Ye.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.Ye.thumbnail_url;
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

    public boolean so() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int ru = ru();
        if (this.Yg != null && this.threadType == 49) {
            return Xw;
        }
        if (this.threadType == 51) {
            return Xx;
        }
        if (ru == 2 || ru == 1) {
            return Xs;
        }
        if (this.Ye != null && sy()) {
            return XE;
        }
        if (this.Ye != null) {
            if (rB()) {
                return Xy;
            }
            return Xv;
        } else if (rn() != null && getThreadType() == 36 && rn().type.intValue() == 2) {
            return XC;
        } else {
            if (rn() != null && getThreadType() == 36 && rn().type.intValue() == 1) {
                return XD;
            }
            if (rh() != null && getThreadType() == 41 && rw() == 1 && sa() == 2) {
                return Xz.get() ? YC : Xt;
            } else if (sd() && sc() == 1) {
                return Xz.get() ? YH : Xt;
            } else if (sd() && sc() == 2) {
                return Xz.get() ? YB : Xt;
            } else if (rB()) {
                return Xu;
            } else {
                return Xt;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sp() {
        return this.Yu;
    }

    public List<TwAnchorProfitItem> qi() {
        return this.Wa;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.XZ == 1) {
            this.Uu = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Uu = 0;
        } else {
            this.Uu = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.pG() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pG().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Uu = next.pH();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sq() {
        return this.threadType == 41;
    }

    public boolean sr() {
        return this.threadType == 48;
    }

    public boolean ss() {
        return this.YI;
    }

    public void ap(boolean z) {
        this.YI = z;
    }

    public String st() {
        return this.YJ;
    }

    public n su() {
        return this.Yo;
    }

    public boolean sv() {
        return rw() == 1 || rv() == 1 || ru() == 1 || sd() || this.YK == 1 || rB() || rL() != null || rK() != null || !com.baidu.adp.lib.util.j.isEmpty(rq()) || sr();
    }

    public void sw() {
        if (this.Yi == 0) {
            this.Yi = 1;
        }
    }

    public boolean sx() {
        return this.YO;
    }

    public void aq(boolean z) {
        this.YW = z;
    }

    public boolean sy() {
        return this.YW;
    }

    public void bU(int i) {
        this.YX = i + 1;
    }

    public int sz() {
        return this.YX;
    }

    public List<ReportInfo> sA() {
        return this.YY;
    }

    public boolean sB() {
        return this.YP;
    }

    public void ar(boolean z) {
        this.YP = z;
    }

    public br sC() {
        return this.Yf;
    }

    public void a(br brVar) {
        this.Yf = brVar;
    }

    public void bV(int i) {
        if (this.Yf != null) {
            this.Yf.mCurrentPage = i;
        }
    }

    public boolean sD() {
        return getThreadType() == 49;
    }

    public int sE() {
        return this.Zd;
    }

    public void setSmartFrsPosition(int i) {
        this.Zd = i;
    }

    public SparseArray<String> qq() {
        return this.Wm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.Wm = sparseArray;
    }

    public String sF() {
        return this.YQ;
    }

    public boolean sG() {
        return this.Zf;
    }

    public int sH() {
        return this.Zg;
    }

    public PostData sI() {
        return this.Zh;
    }
}
