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
public class bl extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.ah {
    public TwZhiBoUser VN;
    public List<TwAnchorProfitItem> VO;
    private SpannableStringBuilder XK;
    public int XO;
    private int XP;
    private int XR;
    private String XU;
    private int XV;
    private String XW;
    private int XY;
    private SkinInfo YC;
    private boolean YE;
    private String YF;
    private boolean YK;
    private boolean YL;
    public String YM;
    public String YN;
    public String YO;
    public long YP;
    public String YR;
    private List<ReportInfo> YU;
    private VideoInfo Ya;
    private bs Yb;
    private c Yc;
    private long Yd;
    private n Yk;
    private LiveCoverStatus Yq;
    private long Yr;
    private p Za;
    private boolean Zb;
    private int Zd;
    private aj Zf;
    private String address;
    private String authorId;
    private boolean isLinkThread;
    private String latitude;
    private String mFromType;
    private int post_num;
    private int threadType;
    private HashMap<String, MetaData> userMap;
    public static final BdUniqueId Xn = BdUniqueId.gen();
    public static final BdUniqueId Xo = BdUniqueId.gen();
    public static final BdUniqueId Xp = BdUniqueId.gen();
    public static final BdUniqueId Xq = BdUniqueId.gen();
    public static final BdUniqueId Xr = BdUniqueId.gen();
    public static final BdUniqueId Xs = BdUniqueId.gen();
    public static final BdUniqueId Xt = BdUniqueId.gen();
    public static final BdUniqueId Xu = BdUniqueId.gen();
    public static AtomicBoolean Xv = new AtomicBoolean(false);
    public static AtomicBoolean Xw = new AtomicBoolean(false);
    public static AtomicBoolean Xx = new AtomicBoolean(false);
    public static final BdUniqueId Xy = BdUniqueId.gen();
    public static final BdUniqueId Xz = BdUniqueId.gen();
    public static final BdUniqueId XA = BdUniqueId.gen();
    private static HashMap<Point, Integer> Yl = new HashMap<>();
    private static HashMap<Integer, Integer> Ym = new HashMap<>();
    public static final BdUniqueId Yx = BdUniqueId.gen();
    public static final BdUniqueId Yy = BdUniqueId.gen();
    public static final BdUniqueId YD = BdUniqueId.gen();
    private static HashMap<Point, Integer> YV = new HashMap<>();
    private static SparseArray<at.a> YW = new SparseArray<>(3);
    public int XB = 1;
    private String XQ = null;
    private int Uh = 0;
    public int Ye = 0;
    private String Yf = "";
    private String Yn = "";
    public boolean YQ = true;
    public boolean YX = false;
    public boolean YY = false;
    private int YZ = -1;
    private SparseArray<String> Wh = null;
    public boolean Zg = false;
    private String id = null;
    private String Wg = null;
    private long fid = 0;
    private String title = null;
    private int reply_num = 0;
    private int XC = 0;
    private int view_num = 0;
    private String last_time = null;
    private long XD = 0;
    private int XE = 0;
    private int XF = 0;
    private int XG = 0;
    private bq XH = new bq();
    private MetaData author = new MetaData();
    private String forum_name = null;
    ArrayList<MediaData> XM = new ArrayList<>();
    ArrayList<VoiceData.VoiceModel> XN = new ArrayList<>();
    private int XI = 0;
    private int XJ = 0;
    private String ad_url = null;
    private String XL = null;
    private String from = null;
    private int isMarked = 0;
    private PraiseData XS = new PraiseData();
    private AnchorInfoData XT = new AnchorInfoData();
    private long time = 0;
    private int XX = 0;
    private ArrayList<a> Yh = new ArrayList<>();
    private bv Yi = null;
    private d Yj = null;
    private int Yo = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> XZ = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Yp = null;
    private int Yg = 0;
    private PollInfo Ys = null;
    private boolean Yt = false;
    private boolean Yu = false;
    private int Yv = 0;
    private boolean Yw = false;
    private int anchorLevel = 0;
    public int YG = 0;
    public k YH = new k();
    private List<PbContent> YI = new ArrayList();
    private List<PbContent> YJ = new ArrayList();
    private String category_name = null;
    private bj Yz = new bj();
    private ArrayList<com.baidu.tbadk.data.b> YA = new ArrayList<>();
    private PushStatusData YB = new PushStatusData();
    public boolean YS = false;
    public int YT = -1;
    private int Zc = 0;
    private PostData Ze = new PostData();

    static {
        Yl.put(new Point(1, 1), Integer.valueOf(w.g.label_frs_lottery_ing));
        Yl.put(new Point(1, 2), Integer.valueOf(w.g.label_frs_lottery_over));
        Yl.put(new Point(1, 3), Integer.valueOf(w.g.label_frs_lottery_off));
        Yl.put(new Point(1, 4), Integer.valueOf(w.g.label_frs_lottery_d));
        Yl.put(new Point(2, 1), Integer.valueOf(w.g.label_frs_activity_shaiing));
        Yl.put(new Point(2, 2), Integer.valueOf(w.g.label_frs_activity_shai_over));
        Yl.put(new Point(2, 3), Integer.valueOf(w.g.label_frs_activity_shai_off));
        Yl.put(new Point(2, 4), Integer.valueOf(w.g.label_frs_activity_shai_d));
        YV.put(new Point(1, 1), Integer.valueOf(w.l.lottery_status_ing));
        YV.put(new Point(1, 2), Integer.valueOf(w.l.lottery_status_over));
        YV.put(new Point(1, 3), Integer.valueOf(w.l.lottery_status_off));
        YV.put(new Point(1, 4), Integer.valueOf(w.l.lottery_status_not_start));
        YV.put(new Point(2, 1), Integer.valueOf(w.l.share_picture_status_ing));
        YV.put(new Point(2, 2), Integer.valueOf(w.l.share_picture_status_over));
        YV.put(new Point(2, 3), Integer.valueOf(w.l.share_picture_status_off));
        YV.put(new Point(2, 4), Integer.valueOf(w.l.share_picture_status_not_start));
        Ym.put(1, Integer.valueOf(w.g.label_interview_no));
        Ym.put(2, Integer.valueOf(w.g.label_interview_live));
        Ym.put(3, Integer.valueOf(w.g.label_interview_off));
        YW.put(1, new at.a(w.l.interview_live_status_not_start, w.e.cp_other_b, w.g.pic_dot_title_red));
        YW.put(2, new at.a(w.l.interview_live_status_ing, w.e.cp_other_c, w.g.pic_dot_title_green));
        YW.put(3, new at.a(w.l.interview_live_status_over, w.e.cp_other_d, w.g.pic_dot_title_blue));
    }

    public bl() {
        this.XP = 0;
        this.XY = 0;
        this.Yr = 0L;
        this.post_num = 0;
        this.post_num = 0;
        this.Yr = 0L;
        this.XY = 0;
        this.XP = 0;
    }

    public boolean rc() {
        return this.XP == 1;
    }

    public bj rd() {
        return this.Yz;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bO(int i) {
        this.anchorLevel = i;
    }

    public int re() {
        return this.XY;
    }

    public boolean rf() {
        return this.Yw;
    }

    public boolean rg() {
        return this.Yt;
    }

    public boolean rh() {
        return this.Yu;
    }

    public void bP(int i) {
        this.Yv = i;
    }

    public int ri() {
        return this.Yv;
    }

    public PollInfo rj() {
        return this.Ys;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Yd;
    }

    public PraiseData rk() {
        return this.XS;
    }

    public void a(PraiseData praiseData) {
        this.XS = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String rl() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void co(String str) {
        this.Wg = str;
    }

    public String getTid() {
        return (StringUtils.isNull(this.Wg) || "0".equals(this.Wg)) ? this.id : this.Wg;
    }

    public void setFid(long j) {
        this.fid = j;
    }

    public long getFid() {
        return this.fid;
    }

    public String rm() {
        return this.category_name;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void bQ(int i) {
        this.reply_num = i;
    }

    public int rn() {
        return this.reply_num;
    }

    public int ro() {
        return this.view_num;
    }

    public void bR(int i) {
        this.view_num = i;
    }

    public long rp() {
        return this.XD;
    }

    public void m(long j) {
        this.XD = j;
    }

    public int rq() {
        return this.XE;
    }

    public void bS(int i) {
        this.XE = i;
    }

    public int rr() {
        return this.XF;
    }

    public void bT(int i) {
        this.XF = i;
    }

    public int rs() {
        return this.XG;
    }

    public List<PbContent> rt() {
        return this.YI;
    }

    public bq ru() {
        return this.XH;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rv() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rw() {
        if (this.author == null || this.author.getGodUserData() == null) {
            return false;
        }
        return this.author.getGodUserData().getType() == 2 || this.author.getGodUserData().getType() == 3 || this.author.getGodUserData().getType() == 1;
    }

    public boolean rx() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean ry() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rz() {
        return this.forum_name;
    }

    public void cs(String str) {
        this.forum_name = str;
    }

    public int rA() {
        return this.XJ;
    }

    public String rB() {
        return this.ad_url;
    }

    public String rC() {
        return this.XL;
    }

    public void ct(String str) {
        this.XL = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.YJ == null || this.YJ.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.YJ.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.YJ.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.YI == null || (size = this.YI.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.YI.get(i2);
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
        if (this.YJ != null && (size = this.YJ.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.YJ.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (!TextUtils.isEmpty(pbContent.text)) {
                    if (pbContent.text.length() + i3 > spannableString.length()) {
                        break;
                    }
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bm(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public String rD() {
        return this.XQ;
    }

    public void cv(String str) {
        this.XQ = str;
    }

    public ArrayList<MediaData> rE() {
        return this.XM;
    }

    public ArrayList<a> rF() {
        return this.Yh;
    }

    public void h(ArrayList<a> arrayList) {
        this.Yh = arrayList;
    }

    public bv rG() {
        return this.Yi;
    }

    public d rH() {
        return this.Yj;
    }

    public ArrayList<VoiceData.VoiceModel> rI() {
        return this.XN;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rJ() {
        return this.XV;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rK() {
        return this.Yf;
    }

    public VideoInfo rL() {
        return this.Ya;
    }

    public c rM() {
        return this.Yc;
    }

    public String getPhotoLiveCover() {
        return this.Yn;
    }

    public void setPhotoLiveCover(String str) {
        this.Yn = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> rN() {
        return this.XZ;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.XZ.clear();
        this.XZ.addAll(arrayList);
    }

    public String getNotice() {
        return this.Yp;
    }

    public PushStatusData rO() {
        return this.YB;
    }

    public SkinInfo rP() {
        return this.YC;
    }

    public long rQ() {
        return this.YP;
    }

    public boolean rR() {
        return this.YQ;
    }

    public String rS() {
        return this.YR;
    }

    public p rT() {
        return this.Za;
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
                    this.XW = threadInfo.location.lng;
                    this.address = threadInfo.location.name;
                }
                this.XP = threadInfo.is_tbread_dispatch.intValue();
                this.id = new StringBuilder().append(threadInfo.id).toString();
                this.Wg = new StringBuilder().append(threadInfo.tid).toString();
                this.fid = threadInfo.fid.longValue();
                this.title = threadInfo.title;
                this.Yd = threadInfo.create_time.intValue() * 1000;
                this.reply_num = threadInfo.reply_num.intValue();
                this.XC = threadInfo.repost_num.intValue();
                this.view_num = threadInfo.view_num.intValue();
                this.last_time = threadInfo.last_time;
                this.XD = threadInfo.last_time_int.intValue();
                this.XE = threadInfo.is_top.intValue();
                this.XF = threadInfo.is_good.intValue();
                this.XG = threadInfo.is_livepost.intValue();
                this.XH.a(threadInfo.topic);
                this.author.parserProtobuf(threadInfo.author);
                this.authorId = threadInfo.author_id.toString();
                this.forum_name = threadInfo.fname;
                this.XI = threadInfo.has_commented.intValue();
                this.XJ = threadInfo.show_commented.intValue();
                this.ad_url = threadInfo.click_url;
                this.Ya = threadInfo.video_info;
                this.Yc = new c();
                this.Yc.a(threadInfo.ala_info);
                this.from = threadInfo.from;
                this.isMarked = threadInfo.collect_status.intValue();
                this.XQ = threadInfo.collect_mark_pid;
                this.XR = threadInfo.is_voice_thread.intValue();
                this.threadType = threadInfo.thread_type.intValue();
                this.XU = new StringBuilder().append(threadInfo.first_post_id).toString();
                this.Yf = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.XV = threadInfo.is_ntitle.intValue();
                this.XX = threadInfo.is_activity.intValue();
                this.Zc = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.Zd = threadInfo.agree.has_agree.intValue();
                }
                this.category_name = threadInfo.category_name;
                this.XY = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.YK = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.YI = threadInfo.rich_title;
                this.YJ = threadInfo.rich_abstract;
                this.XO = threadInfo.is_godthread_recommend.intValue();
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
                this.XL = sb.toString();
                List<Media> list2 = threadInfo.media;
                if (list2 != null) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list2.get(i2));
                        this.XM.add(mediaData);
                    }
                }
                if (threadInfo.video_info != null && !StringUtils.isNull(threadInfo.video_info.video_url)) {
                    this.Ya = threadInfo.video_info;
                }
                if (threadInfo.video_channel_info != null && threadInfo.video_channel_info.channel_id.longValue() > 0) {
                    this.Yb = new bs();
                    this.Yb.a(threadInfo.video_channel_info);
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
                        this.XN.add(voiceModel);
                    }
                }
                List<ActInfo> list4 = threadInfo.act_info;
                if (list4 != null) {
                    int size2 = list4.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar = new a();
                        aVar.a(list4.get(i4));
                        this.Yh.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Yi = new bv();
                    this.Yi.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Yj = new d();
                    this.Yj.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Yk = new n();
                    this.Yk.a(threadInfo.cartoon_info);
                }
                this.XS.setUserMap(this.userMap);
                this.XS.parserProtobuf(threadInfo.zan);
                this.XT.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.XS.setTitle(this.title);
                } else {
                    this.XS.setTitle(this.XL);
                }
                this.Yn = threadInfo.livecover_src;
                this.Yo = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Yg = threadInfo.post_num.intValue();
                this.Yr = threadInfo.freq_num.longValue();
                ZhiBoInfoTW zhiBoInfoTW = threadInfo.twzhibo_info;
                if (zhiBoInfoTW != null) {
                    if (zhiBoInfoTW.labelInfo != null) {
                        int size3 = zhiBoInfoTW.labelInfo.size();
                        for (int i5 = 0; i5 < size3; i5++) {
                            if (zhiBoInfoTW.labelInfo.get(i5) != null) {
                                com.baidu.tbadk.coreExtra.view.n nVar = new com.baidu.tbadk.coreExtra.view.n();
                                nVar.eg(zhiBoInfoTW.labelInfo.get(i5).labelHot.intValue());
                                nVar.setLabelId(zhiBoInfoTW.labelInfo.get(i5).labelId);
                                nVar.setLabelName(zhiBoInfoTW.labelInfo.get(i5).labelContent);
                                this.XZ.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Yp = noticeInfo.notice;
                    }
                    this.Yv = zhiBoInfoTW.copythread_remind.intValue();
                    this.Yt = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Yu = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Yn)) {
                        this.Yn = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.VN = zhiBoInfoTW.user.tw_anchor_info;
                        this.VO = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Yq = threadInfo.twzhibo_info.livecover_status;
                    this.Yr = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Ys = threadInfo.poll_info;
                this.Yw = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.Yz.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.YA.add(bVar);
                    }
                }
                this.YB.parserProtobuf(threadInfo.push_status);
                this.YF = threadInfo.lego_card;
                this.YC = threadInfo.skin_info;
                this.YG = threadInfo.is_book_chapter.intValue();
                this.YH.a(threadInfo.book_chapter);
                this.YM = threadInfo.recom_source;
                this.YR = threadInfo.recom_reason;
                this.YN = threadInfo.recom_weight;
                this.YO = threadInfo.ab_tag;
                this.YP = threadInfo.last_read_pid.longValue();
                this.YQ = threadInfo.cheak_repeat.intValue() == 1;
                this.YU = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.Ze.a(threadInfo.top_agree_post, TbadkCoreApplication.m9getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.x.q(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.Wh = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.x.r(threadInfo.declare_list)) {
                    this.Za = new p();
                    this.Za.a(threadInfo);
                }
                this.Zb = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.Zf = new aj();
                    this.Zf.a(threadInfo.link_info);
                }
                this.Zg = threadInfo.is_partial_visible.intValue() == 1;
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
                this.Wg = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.Yd = jSONObject.optLong("create_time", 0L) * 1000;
                this.reply_num = jSONObject.optInt("reply_num", 0);
                this.XC = jSONObject.optInt("repost_num", 0);
                this.view_num = jSONObject.optInt("view_num", 0);
                this.last_time = jSONObject.optString("last_time");
                this.XD = jSONObject.optLong("last_time_int", 0L);
                this.XE = jSONObject.optInt("is_top", 0);
                this.XF = jSONObject.optInt("is_good", 0);
                this.XG = jSONObject.optInt("is_livepost", 0);
                this.XH.parserJson(jSONObject.optJSONObject("topic"));
                this.authorId = jSONObject.optString("author_id");
                this.author.parserJson(jSONObject.optJSONObject("author"));
                this.forum_name = jSONObject.optString(ImageViewerConfig.FORUM_NAME);
                this.XI = jSONObject.optInt("has_commented", 0);
                this.XJ = jSONObject.optInt("show_commented", 0);
                this.ad_url = jSONObject.optString("click_url");
                this.from = jSONObject.optString("from");
                this.isMarked = jSONObject.optInt("collect_status");
                this.XQ = jSONObject.optString("collect_mark_pid");
                this.XR = jSONObject.optInt("is_voice_thread");
                this.threadType = jSONObject.optInt("thread_type");
                this.XU = jSONObject.optString("first_post_id", "0");
                this.Yf = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.XV = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.Yz.parserJson(optJSONObject2);
                }
                if (this.author == null || this.author.getUserId() == null) {
                    this.author = this.userMap.get(this.authorId);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("author");
                if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject("ala_info")) != null) {
                    this.address = optJSONObject.optString("location");
                }
                this.Yc = new c();
                this.Yc.parserJson(jSONObject.optJSONObject("ala_info"));
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
                this.XL = sb.toString();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("media");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        MediaData mediaData = new MediaData();
                        mediaData.parserJson(optJSONArray2.getJSONObject(i2));
                        this.XM.add(mediaData);
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
                        this.XN.add(voiceModel);
                    }
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("act_info");
                if (optJSONArray4 != null) {
                    for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                        a aVar = new a();
                        aVar.parserJson(optJSONArray4.getJSONObject(i4));
                        this.Yh.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Yi = new bv();
                    this.Yi.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Yj = new d();
                    this.Yj.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.Yk = new n();
                    this.Yk.parserJson(jSONObject.optJSONObject("cartoon_info"));
                }
                this.XS.setUserMap(this.userMap);
                this.XS.parserJson(jSONObject.optJSONObject(FeedData.TYPE_ZAN));
                this.XT.parserJson(jSONObject.optJSONObject("anchor_info"));
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.XS.setTitle(this.title);
                } else {
                    this.XS.setTitle(this.XL);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("task_info");
                if (optJSONObject4 != null) {
                    this.Yz.parserJson(optJSONObject4);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.YA.add(bVar);
                    }
                }
                this.YG = jSONObject.optInt("is_book_chapter", 0);
                this.YH.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.YM = jSONObject.optString("recom_source");
                this.YR = jSONObject.optString("recom_reason");
                this.YN = jSONObject.optString("recom_weight");
                this.YP = jSONObject.optLong("last_read_pid");
                this.YQ = jSONObject.optInt("cheak_repeat") == 1;
                if (jSONObject.optJSONObject("video_channel_info") != null) {
                    this.Yb = new bs();
                    this.Yb.i(jSONObject.optJSONObject("video_channel_info"));
                }
                this.Zb = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                if (this.isLinkThread && jSONObject.optJSONObject("link_info") != null) {
                    this.Zf = new aj();
                    this.Zf.parserJson(jSONObject.optJSONObject("link_info"));
                }
                this.Zg = jSONObject.optInt("is_partial_visible") == 1;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rU() {
        return this.XK;
    }

    public boolean rV() {
        return rq() != 0;
    }

    public int rW() {
        if (this.Yz != null) {
            long qW = this.Yz.qW();
            long qX = this.Yz.qX();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qW) {
                return 1;
            }
            if (currentTimeMillis > qX) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rX() {
        if (rZ() && this.Yh.size() >= 1) {
            a aVar = this.Yh.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pf = aVar.pf();
            int pg = aVar.pg();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pf) {
                return 4;
            }
            return currentTimeMillis > pg ? 2 : 1;
        }
        return -1;
    }

    public int rY() {
        if (!rZ() || this.Yh.size() < 1 || this.Yh.get(0) == null) {
            return -1;
        }
        return this.Yh.get(0).pe();
    }

    public boolean rZ() {
        return this.XX == 1;
    }

    public String sa() {
        return (!rZ() || this.Yh.size() < 1 || this.Yh.get(0) == null) ? "" : this.Yh.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cw(String str) {
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
            if (getThreadType() == 42 && sb()) {
                arrayList.add(Integer.valueOf(w.g.icon_convene));
            }
            if (rq() == 1) {
                arrayList.add(Integer.valueOf(w.g.icon_top));
            } else if (rq() == 2) {
                arrayList.add(Integer.valueOf(w.g.icon_notice));
            }
            if (rs() == 1 || this.XH.sP() != 0) {
                if (rd() != null && getThreadType() == 41) {
                    if (rW() == 2) {
                        arrayList.add(Integer.valueOf(w.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(w.g.icon_zhibo));
                }
            }
            if (z && sm()) {
                Integer num = Ym.get(Integer.valueOf(rW()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rr() == 1 && !rV() && Xr != getType() && Xu != getType()) {
                arrayList.add(Integer.valueOf(w.g.icon_elite));
            }
            if (getType() == Xy || getType() == Xz) {
                arrayList.add(Integer.valueOf(w.g.icon_vote_blue));
            }
            if (this.XT != null && this.XT.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(w.g.icon_live_on));
            }
            if (rA() == 1) {
                arrayList.add(Integer.valueOf(w.g.frs_post_ding));
            }
            if (!z && rY() == 2) {
                arrayList.add(Integer.valueOf(w.g.label_frs_activity_shai));
            } else {
                Integer num2 = Yl.get(new Point(rY(), rX()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rG() != null) {
                arrayList.add(Integer.valueOf(w.g.tag_act));
            }
            if (rH() != null) {
                arrayList.add(Integer.valueOf(w.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cw(this.category_name);
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
                Bitmap cM = com.baidu.tbadk.core.util.aq.cM(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cM);
                if (cM != null) {
                    bitmapDrawable.setBounds(0, 0, cM.getWidth(), cM.getHeight());
                }
                com.baidu.tbadk.core.view.ar arVar = new com.baidu.tbadk.core.view.ar(bitmapDrawable);
                arVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.XB));
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
            SpannableStringBuilder c = !z && rq() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.XK = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<at.a> arrayList) {
        if (sh() || !rw() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new at.a(w.l.god_title));
        }
        return com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), str, arrayList, true);
    }

    private boolean sb() {
        return com.baidu.adp.lib.b.e.eZ().Y("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        SpannableStringBuilder spannableStringBuilder;
        String g = g(this.title, false);
        ArrayList arrayList = new ArrayList();
        boolean rw = rw();
        if (z2) {
            if (z) {
                if (rw && !sh()) {
                    arrayList.add(new at.a(w.l.god_title));
                }
                if (rs() == 1 || getThreadType() == 33 || (ru() != null && ru().sP() != 0)) {
                    if (rd() != null && sm()) {
                        if (rW() == 2) {
                            arrayList.add(new at.a(w.l.interview_live));
                        }
                    } else if (!rw) {
                        arrayList.add(new at.a(w.l.photo_live_tips));
                    }
                }
                if (rq() == 1) {
                    arrayList.add(new at.a(w.l.commit_top));
                }
                if (rr() == 1) {
                    arrayList.add(new at.a(w.l.good));
                }
                if (sm()) {
                    arrayList.add(YW.get(rW()));
                }
                if (rZ()) {
                    Integer num = YV.get(new Point(rY(), rX()));
                    if (num != null) {
                        arrayList.add(new at.a(num.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(w.l.card_promotion_text));
                    }
                }
                if (sn()) {
                    arrayList.add(new at.a(w.l.evaluation));
                }
                if (rG() != null) {
                    arrayList.add(new at.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(rm())) {
                    arrayList.add(new at.a(rm()));
                }
            } else {
                if (rw && rq() != 1 && !sh()) {
                    arrayList.add(new at.a(w.l.god_title));
                }
                if ((rs() == 1 || getThreadType() == 33) && !sm() && !rw) {
                    arrayList.add(new at.a(w.l.photo_live_tips));
                }
                if (rr() == 1) {
                    arrayList.add(new at.a(w.l.good));
                }
                if (rq() == 1) {
                    arrayList.add(new at.a(w.l.commit_top));
                }
                if (sm() && rd() != null && rW() == 2) {
                    arrayList.add(new at.a(w.l.interview_live));
                }
                if (rZ()) {
                    Integer num2 = YV.get(new Point(rY(), rX()));
                    if (num2 != null) {
                        arrayList.add(new at.a(num2.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(w.l.card_promotion_text));
                    }
                }
                if (this.YG == 1) {
                    arrayList.add(new at.a(w.l.card_tbread_text));
                }
                if (rH() != null) {
                    arrayList.add(new at.a(w.l.send_app_code_gift, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (rG() != null) {
                    arrayList.add(new at.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (sn()) {
                    arrayList.add(new at.a(w.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.au.isEmpty(rm())) {
                    arrayList.add(new at.a(rm()));
                }
                if (sy()) {
                    arrayList.add(new at.a(w.l.frs_ala_live_title_prefix));
                }
                if (sB()) {
                    arrayList.add(new at.a(w.l.frs_channel_tip));
                } else if (sA()) {
                    arrayList.add(new at.a(w.l.frs_ala_record_title_prefix));
                } else if (sz()) {
                    arrayList.add(new at.a(w.l.frs_video_title_prefix));
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
        this.XK = spannableStringBuilder;
    }

    public SpannableString a(SpannableString spannableString, boolean z) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.YI != null && this.YI.size() > 0) {
            int size = this.YI.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.YI.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bn(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public void sc() {
        d(false, false);
    }

    public void sd() {
        d(true, false);
    }

    public void se() {
        d(false, true);
    }

    public AnchorInfoData sf() {
        return this.XT;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sg() {
        return this.threadType == 36;
    }

    public boolean sh() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int si() {
        return this.Yg;
    }

    public void bU(int i) {
        this.Yg = i;
    }

    public long sj() {
        return this.Yr;
    }

    @Override // com.baidu.tbadk.core.util.ah
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rE = rE();
        if (rE == null || rV()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rE.size() || i2 >= 3) {
                break;
            }
            if (rE.get(i2) != null && rE.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rE.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rE.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rE.get(i2).getPicUrl();
                }
                preLoadImageInfo.procType = 13;
                arrayList.add(preLoadImageInfo);
            }
            i = i2 + 1;
        }
        if (this.Ya != null && !StringUtils.isNull(this.Ya.thumbnail_url)) {
            PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
            preLoadImageInfo2.imgUrl = this.Ya.thumbnail_url;
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

    public boolean sk() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int rq = rq();
        if (this.Yc != null && this.threadType == 49) {
            return Xs;
        }
        if (this.threadType == 51) {
            return Xt;
        }
        if (rq == 2 || rq == 1) {
            return Xn;
        }
        if (this.Ya != null && st()) {
            return XA;
        }
        if (this.Ya != null) {
            if (rx()) {
                return Xu;
            }
            return Xr;
        } else if (rj() != null && getThreadType() == 36 && rj().type.intValue() == 2) {
            return Xy;
        } else {
            if (rj() != null && getThreadType() == 36 && rj().type.intValue() == 1) {
                return Xz;
            }
            if (rd() != null && getThreadType() == 41 && rs() == 1 && rW() == 2) {
                return Xv.get() ? Yy : Xo;
            } else if (rZ() && rY() == 1) {
                return Xv.get() ? YD : Xo;
            } else if (rZ() && rY() == 2) {
                return Xv.get() ? Yx : Xo;
            } else if (isLinkThread()) {
                return Xp;
            } else {
                if (rx()) {
                    return Xq;
                }
                return Xo;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus sl() {
        return this.Yq;
    }

    public List<TwAnchorProfitItem> pZ() {
        return this.VO;
    }

    public void i(ArrayList<o> arrayList) {
        if (this.XV == 1) {
            this.Uh = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Uh = 0;
        } else {
            this.Uh = 0;
            Iterator<o> it = arrayList.iterator();
            while (it.hasNext()) {
                o next = it.next();
                if (next != null && next.py() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.py().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Uh = next.pz();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sm() {
        return this.threadType == 41;
    }

    public boolean sn() {
        return this.threadType == 48;
    }

    public boolean so() {
        return this.YE;
    }

    public void ao(boolean z) {
        this.YE = z;
    }

    public String sp() {
        return this.YF;
    }

    public n sq() {
        return this.Yk;
    }

    public boolean sr() {
        return rs() == 1 || rr() == 1 || rq() == 1 || rZ() || this.YG == 1 || rx() || rH() != null || rG() != null || !com.baidu.adp.lib.util.j.isEmpty(rm()) || sn();
    }

    public void ss() {
        if (this.Ye == 0) {
            this.Ye = 1;
        }
    }

    public void ap(boolean z) {
        this.YS = z;
    }

    public boolean st() {
        return this.YS;
    }

    public void bV(int i) {
        this.YT = i + 1;
    }

    public int su() {
        return this.YT;
    }

    public List<ReportInfo> sv() {
        return this.YU;
    }

    public boolean sw() {
        return this.YL;
    }

    public void aq(boolean z) {
        this.YL = z;
    }

    public bs sx() {
        return this.Yb;
    }

    public void a(bs bsVar) {
        this.Yb = bsVar;
    }

    public void bW(int i) {
        if (this.Yb != null) {
            this.Yb.mCurrentPage = i;
        }
    }

    public boolean sy() {
        return getThreadType() == 49;
    }

    public boolean sz() {
        return getThreadType() == 40;
    }

    public boolean sA() {
        return getThreadType() == 50;
    }

    public boolean sB() {
        return getThreadType() == 40 && sx() != null && sx().channelId > 0;
    }

    public int sC() {
        return this.YZ;
    }

    public void setSmartFrsPosition(int i) {
        this.YZ = i;
    }

    public SparseArray<String> qm() {
        return this.Wh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.Wh = sparseArray;
    }

    public String sD() {
        return this.YM;
    }

    public boolean sE() {
        return this.Zb;
    }

    public int sF() {
        return this.Zc;
    }

    public PostData sG() {
        return this.Ze;
    }

    public aj sH() {
        return this.Zf;
    }
}
