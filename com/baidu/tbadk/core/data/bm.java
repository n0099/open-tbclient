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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
public class bm extends com.baidu.tieba.card.data.b implements com.baidu.adp.widget.ListView.v, com.baidu.tbadk.core.util.aj {
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
    private SkinInfo YD;
    private boolean YF;
    private String YG;
    private boolean YL;
    private boolean YM;
    public String YN;
    public String YO;
    public String YP;
    public long YQ;
    public String YS;
    private List<ReportInfo> YV;
    private VideoInfo Ya;
    private bt Yb;
    private c Yc;
    private long Ye;
    private o Yl;
    private LiveCoverStatus Yr;
    private long Ys;
    private q Zb;
    private boolean Zc;
    private int Ze;
    private ak Zg;
    public d Zi;
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
    private static HashMap<Point, Integer> Ym = new HashMap<>();
    private static HashMap<Integer, Integer> Yn = new HashMap<>();
    public static final BdUniqueId Yy = BdUniqueId.gen();
    public static final BdUniqueId Yz = BdUniqueId.gen();
    public static final BdUniqueId YE = BdUniqueId.gen();
    private static HashMap<Point, Integer> YW = new HashMap<>();
    private static SparseArray<at.a> YX = new SparseArray<>(3);
    public int XB = 1;
    private String XQ = null;
    private int Ug = 0;
    public int Yf = 0;
    private String Yg = "";
    private String Yo = "";
    public boolean YR = true;
    public boolean YY = false;
    public boolean YZ = false;
    private int Za = -1;
    private SparseArray<String> Wh = null;
    public boolean Zh = false;
    private String id = null;
    private String Wg = null;
    private long fid = 0;
    private String title = null;
    private int Yd = 0;
    private int reply_num = 0;
    private int XC = 0;
    private int view_num = 0;
    private String last_time = null;
    private long XD = 0;
    private int XE = 0;
    private int XF = 0;
    private int XG = 0;
    private br XH = new br();
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
    private ArrayList<a> Yi = new ArrayList<>();
    private bw Yj = null;
    private e Yk = null;
    private int Yp = 0;
    private ArrayList<com.baidu.tbadk.coreExtra.view.n> XZ = new ArrayList<>();
    private boolean isHeadLive = false;
    private String Yq = null;
    private int Yh = 0;
    private PollInfo Yt = null;
    private boolean Yu = false;
    private boolean Yv = false;
    private int Yw = 0;
    private boolean Yx = false;
    private int anchorLevel = 0;
    public int YH = 0;
    public l YI = new l();
    private List<PbContent> YJ = new ArrayList();
    private List<PbContent> YK = new ArrayList();
    private String category_name = null;
    private bk YA = new bk();
    private ArrayList<com.baidu.tbadk.data.b> YB = new ArrayList<>();
    private PushStatusData YC = new PushStatusData();
    public boolean YT = false;
    public int YU = -1;
    private int Zd = 0;
    private PostData Zf = new PostData();

    static {
        Ym.put(new Point(1, 1), Integer.valueOf(w.g.label_frs_lottery_ing));
        Ym.put(new Point(1, 2), Integer.valueOf(w.g.label_frs_lottery_over));
        Ym.put(new Point(1, 3), Integer.valueOf(w.g.label_frs_lottery_off));
        Ym.put(new Point(1, 4), Integer.valueOf(w.g.label_frs_lottery_d));
        Ym.put(new Point(2, 1), Integer.valueOf(w.g.label_frs_activity_shaiing));
        Ym.put(new Point(2, 2), Integer.valueOf(w.g.label_frs_activity_shai_over));
        Ym.put(new Point(2, 3), Integer.valueOf(w.g.label_frs_activity_shai_off));
        Ym.put(new Point(2, 4), Integer.valueOf(w.g.label_frs_activity_shai_d));
        YW.put(new Point(1, 1), Integer.valueOf(w.l.lottery_status_ing));
        YW.put(new Point(1, 2), Integer.valueOf(w.l.lottery_status_over));
        YW.put(new Point(1, 3), Integer.valueOf(w.l.lottery_status_off));
        YW.put(new Point(1, 4), Integer.valueOf(w.l.lottery_status_not_start));
        YW.put(new Point(2, 1), Integer.valueOf(w.l.share_picture_status_ing));
        YW.put(new Point(2, 2), Integer.valueOf(w.l.share_picture_status_over));
        YW.put(new Point(2, 3), Integer.valueOf(w.l.share_picture_status_off));
        YW.put(new Point(2, 4), Integer.valueOf(w.l.share_picture_status_not_start));
        Yn.put(1, Integer.valueOf(w.g.label_interview_no));
        Yn.put(2, Integer.valueOf(w.g.label_interview_live));
        Yn.put(3, Integer.valueOf(w.g.label_interview_off));
        YX.put(1, new at.a(w.l.interview_live_status_not_start, w.e.cp_other_b, w.g.pic_dot_title_red));
        YX.put(2, new at.a(w.l.interview_live_status_ing, w.e.cp_other_c, w.g.pic_dot_title_green));
        YX.put(3, new at.a(w.l.interview_live_status_over, w.e.cp_other_d, w.g.pic_dot_title_blue));
    }

    public bm() {
        this.XP = 0;
        this.XY = 0;
        this.Ys = 0L;
        this.post_num = 0;
        this.post_num = 0;
        this.Ys = 0L;
        this.XY = 0;
        this.XP = 0;
    }

    public boolean qZ() {
        return this.XP == 1;
    }

    public bk ra() {
        return this.YA;
    }

    public int getAnchorLevel() {
        return this.anchorLevel;
    }

    public void bO(int i) {
        this.anchorLevel = i;
    }

    public int rb() {
        return this.XY;
    }

    public boolean rc() {
        return this.Yx;
    }

    public boolean rd() {
        return this.Yu;
    }

    public boolean re() {
        return this.Yv;
    }

    public void bP(int i) {
        this.Yw = i;
    }

    public int rf() {
        return this.Yw;
    }

    public PollInfo rg() {
        return this.Yt;
    }

    public HashMap<String, MetaData> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(HashMap<String, MetaData> hashMap) {
        this.userMap = hashMap;
    }

    public long getCreateTime() {
        return this.Ye;
    }

    public PraiseData rh() {
        return this.XS;
    }

    public void a(PraiseData praiseData) {
        this.XS = praiseData;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String ri() {
        return this.mFromType;
    }

    public void setFromType(String str) {
        this.mFromType = str;
    }

    public String getId() {
        return this.id;
    }

    public void cu(String str) {
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

    public String getCategory() {
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

    public int rj() {
        return this.reply_num;
    }

    public int rk() {
        return this.view_num;
    }

    public void bR(int i) {
        this.view_num = i;
    }

    public long rl() {
        return this.XD;
    }

    public void m(long j) {
        this.XD = j;
    }

    public int rm() {
        return this.XE;
    }

    public void bS(int i) {
        this.XE = i;
    }

    public int rn() {
        return this.XF;
    }

    public void bT(int i) {
        this.XF = i;
    }

    public int ro() {
        return this.XG;
    }

    public List<PbContent> rp() {
        return this.YJ;
    }

    public br rq() {
        return this.XH;
    }

    public MetaData getAuthor() {
        return this.author;
    }

    public UserTbVipInfoData rr() {
        if (this.author == null) {
            return null;
        }
        return this.author.getUserTbVipInfoData();
    }

    public boolean rs() {
        return this.Yd != 0;
    }

    public boolean rt() {
        return this.Yd == 1;
    }

    public boolean ru() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 2) ? false : true;
    }

    public boolean isLinkThread() {
        return this.isLinkThread;
    }

    public boolean rv() {
        return (this.author == null || this.author.getGodUserData() == null || this.author.getGodUserData().getType() != 3) ? false : true;
    }

    public void setAuthor(MetaData metaData) {
        this.author = metaData;
    }

    public String rw() {
        return this.forum_name;
    }

    public void cy(String str) {
        this.forum_name = str;
    }

    public int rx() {
        return this.XJ;
    }

    public String ry() {
        return this.ad_url;
    }

    public String rz() {
        return this.XL;
    }

    public void cz(String str) {
        this.XL = str;
    }

    public String g(String str, boolean z) {
        String str2;
        int size;
        if (z) {
            if (this.YK == null || this.YK.size() == 0) {
                str2 = str;
            } else {
                int size2 = this.YK.size();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < size2; i++) {
                    PbContent pbContent = this.YK.get(i);
                    if (pbContent != null) {
                        sb.append(pbContent.text);
                    }
                }
                str2 = sb.toString();
            }
        } else if (this.YJ == null || (size = this.YJ.size()) == 0) {
            str2 = str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            for (int i2 = 0; i2 < size; i2++) {
                PbContent pbContent2 = this.YJ.get(i2);
                if (pbContent2 != null) {
                    sb2.append(pbContent2.text);
                }
            }
            str2 = sb2.toString();
        }
        return str2 != null ? str2 : "";
    }

    public SpannableString cA(String str) {
        int size;
        int i;
        SpannableString spannableString = new SpannableString(g(str, true));
        if (this.YK != null && (size = this.YK.size()) > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.YK.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (!TextUtils.isEmpty(pbContent.text)) {
                    if (pbContent.text.length() + i3 > spannableString.length()) {
                        break;
                    }
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bn(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    public String rA() {
        return this.XQ;
    }

    public void cB(String str) {
        this.XQ = str;
    }

    public ArrayList<MediaData> rB() {
        return this.XM;
    }

    public ArrayList<a> rC() {
        return this.Yi;
    }

    public void h(ArrayList<a> arrayList) {
        this.Yi = arrayList;
    }

    public bw rD() {
        return this.Yj;
    }

    public e rE() {
        return this.Yk;
    }

    public ArrayList<VoiceData.VoiceModel> rF() {
        return this.XN;
    }

    public int getThreadType() {
        return this.threadType;
    }

    public void setThreadType(int i) {
        this.threadType = i;
    }

    public int rG() {
        return this.XV;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public String rH() {
        return this.Yg;
    }

    public VideoInfo rI() {
        return this.Ya;
    }

    public c rJ() {
        return this.Yc;
    }

    public String getPhotoLiveCover() {
        return this.Yo;
    }

    public void setPhotoLiveCover(String str) {
        this.Yo = str;
    }

    public ArrayList<com.baidu.tbadk.coreExtra.view.n> rK() {
        return this.XZ;
    }

    public void setExpressionDatas(ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList) {
        this.XZ.clear();
        this.XZ.addAll(arrayList);
    }

    public String getNotice() {
        return this.Yq;
    }

    public PushStatusData rL() {
        return this.YC;
    }

    public SkinInfo rM() {
        return this.YD;
    }

    public long rN() {
        return this.YQ;
    }

    public boolean rO() {
        return this.YR;
    }

    public String rP() {
        return this.YS;
    }

    public q rQ() {
        return this.Zb;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x002a: IGET  (r3v0 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x003b: IGET  (r3v1 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.tid java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0107: IGET  (r3v9 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.first_post_id java.lang.Long)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Long : 0x0118: IGET  (r3v10 java.lang.Long A[REMOVE]) = (r9v0 tbclient.ThreadInfo) tbclient.ThreadInfo.post_id java.lang.Long)] */
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
                this.Yd = threadInfo.is_god.intValue();
                this.Ye = threadInfo.create_time.intValue() * 1000;
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
                this.Yg = new StringBuilder().append(threadInfo.post_id).toString();
                this.time = threadInfo.time.intValue() * 1000;
                this.XV = threadInfo.is_ntitle.intValue();
                this.XX = threadInfo.is_activity.intValue();
                this.Zd = threadInfo.agree_num.intValue();
                if (threadInfo.agree != null) {
                    this.Ze = threadInfo.agree.has_agree.intValue();
                }
                this.category_name = threadInfo.category_name;
                this.XY = threadInfo.operator_flag.intValue();
                if (threadInfo.is_operate_thread != null) {
                    this.YL = threadInfo.is_operate_thread.intValue() == 1;
                }
                this.YJ = threadInfo.rich_title;
                this.YK = threadInfo.rich_abstract;
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
                    this.Yb = new bt();
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
                        this.Yi.add(aVar);
                    }
                }
                if (threadInfo.yule_post_activity != null) {
                    this.Yj = new bw();
                    this.Yj.a(threadInfo.yule_post_activity);
                }
                if (threadInfo.app_code != null) {
                    this.Yk = new e();
                    this.Yk.a(threadInfo.app_code);
                }
                if (threadInfo.cartoon_info != null) {
                    this.Yl = new o();
                    this.Yl.a(threadInfo.cartoon_info);
                }
                this.XS.setUserMap(this.userMap);
                this.XS.parserProtobuf(threadInfo.zan);
                this.XT.parserProtobuf(threadInfo.anchor_info);
                if (!com.baidu.adp.lib.util.j.isEmpty(this.title)) {
                    this.XS.setTitle(this.title);
                } else {
                    this.XS.setTitle(this.XL);
                }
                this.Yo = threadInfo.livecover_src;
                this.Yp = threadInfo.storecount.intValue();
                this.post_num = threadInfo.post_num.intValue();
                this.Yh = threadInfo.post_num.intValue();
                this.Ys = threadInfo.freq_num.longValue();
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
                                this.XZ.add(nVar);
                            }
                        }
                    }
                    NoticeInfo noticeInfo = zhiBoInfoTW.notice_info;
                    if (noticeInfo != null) {
                        this.Yq = noticeInfo.notice;
                    }
                    this.Yw = zhiBoInfoTW.copythread_remind.intValue();
                    this.Yu = zhiBoInfoTW.is_copytwzhibo.intValue() > 0;
                    this.Yv = zhiBoInfoTW.is_copytwzhibo.intValue() == 3;
                    if (StringUtils.isNull(this.Yo)) {
                        this.Yo = zhiBoInfoTW.livecover_src;
                    }
                    if (zhiBoInfoTW.user != null) {
                        this.VN = zhiBoInfoTW.user.tw_anchor_info;
                        this.VO = zhiBoInfoTW.user.profit_list;
                    }
                }
                if (threadInfo.twzhibo_info != null) {
                    this.isHeadLive = threadInfo.twzhibo_info.is_headline.intValue() == 1;
                    this.Yr = threadInfo.twzhibo_info.livecover_status;
                    this.Ys = threadInfo.twzhibo_info.freq_num.intValue();
                    if (threadInfo.twzhibo_info.user != null && threadInfo.twzhibo_info.user.tw_anchor_info != null) {
                        this.anchorLevel = threadInfo.twzhibo_info.user.tw_anchor_info.anchor_level.intValue();
                    }
                }
                this.Yt = threadInfo.poll_info;
                this.Yx = threadInfo.is_copythread.intValue() == 1;
                if (threadInfo.task_info != null) {
                    this.YA.a(threadInfo.task_info);
                }
                if (threadInfo.ext_tails != null) {
                    for (int i6 = 0; i6 != threadInfo.ext_tails.size(); i6++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.a(threadInfo.ext_tails.get(i6));
                        this.YB.add(bVar);
                    }
                }
                this.YC.parserProtobuf(threadInfo.push_status);
                this.YG = threadInfo.lego_card;
                this.YD = threadInfo.skin_info;
                this.YH = threadInfo.is_book_chapter.intValue();
                this.YI.a(threadInfo.book_chapter);
                this.YN = threadInfo.recom_source;
                this.YS = threadInfo.recom_reason;
                this.YO = threadInfo.recom_weight;
                this.YP = threadInfo.ab_tag;
                this.YQ = threadInfo.last_read_pid.longValue();
                this.YR = threadInfo.cheak_repeat.intValue() == 1;
                this.YV = threadInfo.report_info;
                if (threadInfo.top_agree_post != null) {
                    this.Zf.a(threadInfo.top_agree_post, TbadkCoreApplication.m9getInst().getApplicationContext());
                }
                List<DislikeInfo> list5 = threadInfo.dislike_info;
                if (com.baidu.tbadk.core.util.z.s(list5) > 0) {
                    SparseArray<String> sparseArray = new SparseArray<>();
                    for (DislikeInfo dislikeInfo : list5) {
                        if (dislikeInfo != null) {
                            sparseArray.put(dislikeInfo.dislike_id.intValue(), dislikeInfo.dislike_reason);
                        }
                    }
                    this.Wh = sparseArray;
                }
                if (!com.baidu.tbadk.core.util.z.t(threadInfo.declare_list)) {
                    this.Zb = new q();
                    this.Zb.a(threadInfo);
                }
                this.Zc = threadInfo.is_multiforum_thread.intValue() == 1;
                this.isLinkThread = threadInfo.is_link_thread.intValue() == 1;
                if (this.isLinkThread && threadInfo.link_info != null) {
                    this.Zg = new ak();
                    this.Zg.a(threadInfo.link_info);
                }
                this.Zh = threadInfo.is_partial_visible.intValue() == 1;
                if (threadInfo.activity_info != null) {
                    this.Zi = new d();
                    this.Zi.a(threadInfo.activity_info);
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
                this.Wg = jSONObject.optString("tid");
                this.title = jSONObject.optString(VrPlayerActivityConfig.TITLE);
                this.Yd = jSONObject.optInt("is_god");
                this.Ye = jSONObject.optLong("create_time", 0L) * 1000;
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
                this.Yg = jSONObject.optString("post_id", "0");
                this.time = jSONObject.optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, 0L) * 1000;
                this.XV = jSONObject.optInt("is_ntitle");
                this.category_name = jSONObject.optString(MangaCategoryActivityConfig.CATEGORY_NAME);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("top_agree_post");
                if (optJSONObject2 != null) {
                    this.YA.parserJson(optJSONObject2);
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
                        this.Yi.add(aVar);
                    }
                }
                if (jSONObject.optJSONObject("yule_post_activity") != null) {
                    this.Yj = new bw();
                    this.Yj.parserJson(jSONObject.optJSONObject("yule_post_activity"));
                }
                if (jSONObject.optJSONObject("app_code") != null) {
                    this.Yk = new e();
                    this.Yk.parserJson(jSONObject.optJSONObject("app_code"));
                }
                if (jSONObject.optJSONObject("cartoon_info") != null) {
                    this.Yl = new o();
                    this.Yl.parserJson(jSONObject.optJSONObject("cartoon_info"));
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
                    this.YA.parserJson(optJSONObject4);
                }
                JSONArray optJSONArray5 = jSONObject.optJSONArray("ext_tails");
                if (optJSONArray5 != null) {
                    for (int i5 = 0; i5 < optJSONArray5.length(); i5++) {
                        com.baidu.tbadk.data.b bVar = new com.baidu.tbadk.data.b();
                        bVar.parserJson(optJSONArray5.getJSONObject(i5));
                        this.YB.add(bVar);
                    }
                }
                this.YH = jSONObject.optInt("is_book_chapter", 0);
                this.YI.parserJson(jSONObject.optJSONObject("book_chapter"));
                this.YN = jSONObject.optString("recom_source");
                this.YS = jSONObject.optString("recom_reason");
                this.YO = jSONObject.optString("recom_weight");
                this.YQ = jSONObject.optLong("last_read_pid");
                this.YR = jSONObject.optInt("cheak_repeat") == 1;
                if (jSONObject.optJSONObject("video_channel_info") != null) {
                    this.Yb = new bt();
                    this.Yb.i(jSONObject.optJSONObject("video_channel_info"));
                }
                this.Zc = jSONObject.optInt("is_multiforum_thread") == 1;
                this.isLinkThread = jSONObject.optBoolean("is_link_thread");
                if (this.isLinkThread && jSONObject.optJSONObject("link_info") != null) {
                    this.Zg = new ak();
                    this.Zg.parserJson(jSONObject.optJSONObject("link_info"));
                }
                this.Zh = jSONObject.optInt("is_partial_visible") == 1;
                if (jSONObject.optJSONObject("activity_info") != null) {
                    this.Zi = new d();
                    this.Zi.parserJson(jSONObject.optJSONObject("activity_info"));
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public SpannableStringBuilder rR() {
        return this.XK;
    }

    public boolean rS() {
        return rm() != 0;
    }

    public int rT() {
        if (this.YA != null) {
            long qT = this.YA.qT();
            long qU = this.YA.qU();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < qT) {
                return 1;
            }
            if (currentTimeMillis > qU) {
                return 3;
            }
            return 2;
        }
        return -1;
    }

    public int rU() {
        if (rW() && this.Yi.size() >= 1) {
            a aVar = this.Yi.get(0);
            int status = aVar.getStatus();
            if (status == 3) {
                return status;
            }
            int pc = aVar.pc();
            int pd = aVar.pd();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis < pc) {
                return 4;
            }
            return currentTimeMillis > pd ? 2 : 1;
        }
        return -1;
    }

    public int rV() {
        if (!rW() || this.Yi.size() < 1 || this.Yi.get(0) == null) {
            return -1;
        }
        return this.Yi.get(0).pb();
    }

    public boolean rW() {
        return this.XX == 1;
    }

    public String rX() {
        return (!rW() || this.Yi.size() < 1 || this.Yi.get(0) == null) ? "" : this.Yi.get(0).getUrl();
    }

    private com.baidu.adp.widget.d cC(String str) {
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
            if (getThreadType() == 42 && rY()) {
                arrayList.add(Integer.valueOf(w.g.icon_convene));
            }
            if (rm() == 1) {
                arrayList.add(Integer.valueOf(w.g.icon_top));
            } else if (rm() == 2) {
                arrayList.add(Integer.valueOf(w.g.icon_notice));
            }
            if (ro() == 1 || this.XH.sN() != 0) {
                if (ra() != null && getThreadType() == 41) {
                    if (rT() == 2) {
                        arrayList.add(Integer.valueOf(w.g.label_interview));
                    }
                } else {
                    arrayList.add(Integer.valueOf(w.g.icon_zhibo));
                }
            }
            if (z && sj()) {
                Integer num = Yn.get(Integer.valueOf(rT()));
                if (num != null) {
                    arrayList.add(num);
                }
            }
            if (rn() == 1 && !rS() && Xr != getType() && Xu != getType()) {
                arrayList.add(Integer.valueOf(w.g.icon_elite));
            }
            if (getType() == Xy || getType() == Xz) {
                arrayList.add(Integer.valueOf(w.g.icon_vote_blue));
            }
            if (this.XT != null && this.XT.getGroup_id() != 0) {
                arrayList.add(Integer.valueOf(w.g.icon_live_on));
            }
            if (rx() == 1) {
                arrayList.add(Integer.valueOf(w.g.frs_post_ding));
            }
            if (!z && rV() == 2) {
                arrayList.add(Integer.valueOf(w.g.label_frs_activity_shai));
            } else {
                Integer num2 = Ym.get(new Point(rV(), rU()));
                if (num2 != null) {
                    arrayList.add(num2);
                }
            }
            if (rD() != null) {
                arrayList.add(Integer.valueOf(w.g.tag_act));
            }
            if (rE() != null) {
                arrayList.add(Integer.valueOf(w.g.icon_tag_giftsend));
            }
            if (!com.baidu.adp.lib.util.j.isEmpty(this.category_name)) {
                dVar = cC(this.category_name);
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
                Bitmap cO = com.baidu.tbadk.core.util.as.cO(((Integer) arrayList.get(i4)).intValue());
                BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
                if (cO != null) {
                    bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
                }
                com.baidu.tbadk.core.view.as asVar = new com.baidu.tbadk.core.view.as(bitmapDrawable);
                asVar.setOffset(com.baidu.adp.lib.util.k.dip2px(TbadkCoreApplication.m9getInst().getApplicationContext(), this.XB));
                spannableString.setSpan(asVar, i3, i3 + 1, 33);
                i3 += 2;
                i2 = i4 + 1;
            }
            if (dVar != null) {
                spannableString.setSpan(dVar, i3, this.category_name.length() + i3, 33);
            }
            spannableStringBuilder.append((CharSequence) spannableString);
        }
        SpannableString a = a(new SpannableString(String.valueOf(g) + " "));
        if (a != null) {
            SpannableStringBuilder c = !z && rm() == 1 ? null : c(a.toString(), null);
            if (c == null) {
                spannableStringBuilder.append((CharSequence) a);
            } else {
                spannableStringBuilder.append((CharSequence) c);
            }
        }
        this.XK = spannableStringBuilder;
    }

    private SpannableStringBuilder c(String str, ArrayList<at.a> arrayList) {
        if (se() || !rs() || com.baidu.adp.lib.util.j.isEmpty(str)) {
            return null;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            arrayList = new ArrayList<>();
            arrayList.add(new at.a(w.l.god_title));
        }
        return com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), str, arrayList, true);
    }

    private boolean rY() {
        return com.baidu.adp.lib.b.e.eY().ad("isConveneThreadOpen") == 1;
    }

    public void e(boolean z, boolean z2) {
        if (com.baidu.tbadk.core.util.z.s(f(z, z2)) > 0) {
            ar(z);
            return;
        }
        String g = g(this.title, false);
        this.XK = a(g, a(new SpannableString(String.valueOf(g) + " ")), z, z2);
    }

    private SpannableStringBuilder a(String str, SpannableString spannableString, boolean z, boolean z2) {
        ArrayList<at.a> f = f(z, z2);
        if (f == null) {
            return new SpannableStringBuilder();
        }
        SpannableStringBuilder a = com.baidu.tieba.card.at.a((Context) TbadkCoreApplication.m9getInst(), str, f, false);
        if (f.size() > 0) {
            if (a == null) {
                a = new SpannableStringBuilder();
            }
            if (this.XV == 1) {
                this.XK = a;
                return a;
            }
        } else if (this.XV == 1) {
            this.XK = new SpannableStringBuilder();
            return a;
        }
        if (spannableString != null) {
            a.append((CharSequence) spannableString);
            return a;
        } else if (f.size() > 0 || a.length() == 0) {
            a.append((CharSequence) str);
            return a;
        } else {
            return a;
        }
    }

    public SpannableString a(SpannableString spannableString) {
        int i;
        if (spannableString == null) {
            return new SpannableString("");
        }
        if (this.YJ != null && this.YJ.size() > 0) {
            int size = this.YJ.size();
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                PbContent pbContent = this.YJ.get(i2);
                if (pbContent == null) {
                    i = i3;
                } else if (TextUtils.isEmpty(pbContent.text)) {
                    i = i3;
                } else if (pbContent.text.length() + i3 <= spannableString.length()) {
                    if (18 == pbContent.type.intValue()) {
                        spannableString.setSpan(new bo(this, 2, pbContent.link, pbContent), i3, pbContent.text.length() + i3, 33);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(String str) {
        if (!TextUtils.isEmpty(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, str));
        }
    }

    public void rZ() {
        d(false, false);
    }

    public void sa() {
        d(true, false);
    }

    public void sb() {
        d(false, true);
    }

    public AnchorInfoData sc() {
        return this.XT;
    }

    public boolean isPhotoLiveThread() {
        return this.threadType == 33;
    }

    public boolean sd() {
        return this.threadType == 36;
    }

    public boolean se() {
        return this.threadType == 40 || this.threadType == 50;
    }

    public int getPost_num() {
        return this.post_num;
    }

    public void setPost_num(int i) {
        this.post_num = i;
    }

    public int sf() {
        return this.Yh;
    }

    public void bU(int i) {
        this.Yh = i;
    }

    public long sg() {
        return this.Ys;
    }

    @Override // com.baidu.tbadk.core.util.aj
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<MediaData> rB = rB();
        if (rB == null || rS()) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= rB.size() || i2 >= 3) {
                break;
            }
            if (rB.get(i2) != null && rB.get(i2).getType() == 3) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                if (!StringUtils.isNull(rB.get(i2).getThumbnails_url())) {
                    preLoadImageInfo.imgUrl = rB.get(i2).getThumbnails_url();
                } else {
                    preLoadImageInfo.imgUrl = rB.get(i2).getPicUrl();
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

    public boolean sh() {
        String userId;
        return this.author == null || (userId = this.author.getUserId()) == null || userId.equals("0");
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        int rm = rm();
        if (this.Yc != null && this.threadType == 49) {
            return Xs;
        }
        if (this.threadType == 51) {
            return Xt;
        }
        if (rm == 2 || rm == 1) {
            return Xn;
        }
        if (this.Ya != null && sr()) {
            return XA;
        }
        if (this.Ya != null) {
            if (ru()) {
                return Xu;
            }
            return Xr;
        } else if (rg() != null && getThreadType() == 36 && rg().type.intValue() == 2) {
            return Xy;
        } else {
            if (rg() != null && getThreadType() == 36 && rg().type.intValue() == 1) {
                return Xz;
            }
            if (ra() != null && getThreadType() == 41 && ro() == 1 && rT() == 2) {
                return Xv.get() ? Yz : Xo;
            } else if (rW() && rV() == 1) {
                return Xv.get() ? YE : Xo;
            } else if (rW() && rV() == 2) {
                return Xv.get() ? Yy : Xo;
            } else if (isLinkThread()) {
                return Xp;
            } else {
                if (ru()) {
                    return Xq;
                }
                return Xo;
            }
        }
    }

    public boolean isHeadLive() {
        return this.isHeadLive;
    }

    public LiveCoverStatus si() {
        return this.Yr;
    }

    public List<TwAnchorProfitItem> pW() {
        return this.VO;
    }

    public void i(ArrayList<p> arrayList) {
        if (this.XV == 1) {
            this.Ug = 0;
        } else if (arrayList == null || arrayList.size() <= 0) {
            this.Ug = 0;
        } else {
            this.Ug = 0;
            Iterator<p> it = arrayList.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (next != null && next.pv() != null && !StringUtils.isNull(this.title)) {
                    Iterator<String> it2 = next.pv().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            String next2 = it2.next();
                            if (!StringUtils.isNull(next2) && this.title.contains(next2)) {
                                this.Ug = next.pw();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean sj() {
        return this.threadType == 41;
    }

    public boolean sk() {
        return this.threadType == 48;
    }

    public boolean sl() {
        return this.YF;
    }

    public void ao(boolean z) {
        this.YF = z;
    }

    public String sm() {
        return this.YG;
    }

    public o sn() {
        return this.Yl;
    }

    public boolean so() {
        return ro() == 1 || rn() == 1 || rm() == 1 || rW() || this.YH == 1 || ru() || rE() != null || rD() != null || !com.baidu.adp.lib.util.j.isEmpty(getCategory()) || sk() || rt();
    }

    public void sp() {
        if (this.Yf == 0) {
            this.Yf = 1;
        }
    }

    public boolean sq() {
        return this.YL;
    }

    public void ap(boolean z) {
        this.YT = z;
    }

    public boolean sr() {
        return this.YT;
    }

    public void bV(int i) {
        this.YU = i + 1;
    }

    public int ss() {
        return this.YU;
    }

    public List<ReportInfo> st() {
        return this.YV;
    }

    public boolean su() {
        return this.YM;
    }

    public void aq(boolean z) {
        this.YM = z;
    }

    public bt sv() {
        return this.Yb;
    }

    public void a(bt btVar) {
        this.Yb = btVar;
    }

    public void bW(int i) {
        if (this.Yb != null) {
            this.Yb.mCurrentPage = i;
        }
    }

    public boolean sw() {
        return getThreadType() == 49;
    }

    public boolean sx() {
        return getThreadType() == 40;
    }

    public boolean sy() {
        return getThreadType() == 50;
    }

    public boolean sz() {
        return getThreadType() == 40 && sv() != null && sv().channelId > 0;
    }

    public int sA() {
        return this.Za;
    }

    public void setSmartFrsPosition(int i) {
        this.Za = i;
    }

    public SparseArray<String> qj() {
        return this.Wh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SparseArray<String> sparseArray) {
        this.Wh = sparseArray;
    }

    public String sB() {
        return this.YN;
    }

    public boolean sC() {
        return this.Zc;
    }

    public int sD() {
        return this.Zd;
    }

    public PostData sE() {
        return this.Zf;
    }

    public ak sF() {
        return this.Zg;
    }

    public SpannableStringBuilder ar(boolean z) {
        String g;
        SpannableString a;
        if (this.XV == 1) {
            g = g(this.XL, false);
            a = cA(this.XL);
        } else {
            g = g(this.title, false);
            a = a(new SpannableString(String.valueOf(g) + " "));
        }
        SpannableStringBuilder a2 = a(g, a, z, true);
        this.XK = a2;
        return a2;
    }

    private ArrayList<at.a> f(boolean z, boolean z2) {
        ArrayList<at.a> arrayList = new ArrayList<>();
        boolean rs = rs();
        if (z2) {
            if (z) {
                if (rs && !se()) {
                    arrayList.add(new at.a(w.l.god_title));
                }
                if (ro() == 1 || getThreadType() == 33 || (rq() != null && rq().sN() != 0)) {
                    if (ra() != null && sj()) {
                        if (rT() == 2) {
                            arrayList.add(new at.a(w.l.interview_live));
                        }
                    } else if (!rs) {
                        arrayList.add(new at.a(w.l.photo_live_tips));
                    }
                }
                if (rm() == 1) {
                    arrayList.add(new at.a(w.l.commit_top));
                }
                if (rn() == 1) {
                    arrayList.add(new at.a(w.l.good));
                }
                if (sj()) {
                    arrayList.add(YX.get(rT()));
                }
                if (rW()) {
                    Integer num = YW.get(new Point(rV(), rU()));
                    if (num != null) {
                        arrayList.add(new at.a(num.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(w.l.card_promotion_text));
                    }
                }
                if (sk()) {
                    arrayList.add(new at.a(w.l.evaluation));
                }
                if (rD() != null) {
                    arrayList.add(new at.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (!com.baidu.tbadk.core.util.aw.isEmpty(getCategory())) {
                    arrayList.add(new at.a(getCategory()));
                }
            } else {
                if (rs && rm() != 1 && !se()) {
                    arrayList.add(new at.a(w.l.god_title));
                }
                if ((ro() == 1 || getThreadType() == 33) && !sj() && !rs) {
                    arrayList.add(new at.a(w.l.photo_live_tips));
                }
                if (rn() == 1) {
                    arrayList.add(new at.a(w.l.good));
                }
                if (rm() == 1) {
                    arrayList.add(new at.a(w.l.commit_top));
                }
                if (sj() && ra() != null && rT() == 2) {
                    arrayList.add(new at.a(w.l.interview_live));
                }
                if (rW()) {
                    Integer num2 = YW.get(new Point(rV(), rU()));
                    if (num2 != null) {
                        arrayList.add(new at.a(num2.intValue(), w.e.cp_other_b, w.g.pic_dot_title_red));
                    } else {
                        arrayList.add(new at.a(w.l.card_promotion_text));
                    }
                }
                if (this.YH == 1) {
                    arrayList.add(new at.a(w.l.card_tbread_text));
                }
                if (rE() != null) {
                    arrayList.add(new at.a(w.l.send_app_code_gift, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (rD() != null) {
                    arrayList.add(new at.a(w.l.card_promotion_text, w.e.cp_other_b, w.g.pic_dot_title_red));
                }
                if (sk()) {
                    arrayList.add(new at.a(w.l.evaluation));
                }
                if (!com.baidu.tbadk.core.util.aw.isEmpty(getCategory())) {
                    arrayList.add(new at.a(getCategory()));
                }
                if (sw()) {
                    arrayList.add(new at.a(w.l.frs_ala_live_title_prefix));
                }
                if (sz()) {
                    arrayList.add(new at.a(w.l.frs_channel_tip));
                } else if (sy()) {
                    arrayList.add(new at.a(w.l.frs_ala_record_title_prefix));
                } else if (sx()) {
                    arrayList.add(new at.a(w.l.frs_video_title_prefix));
                }
            }
        }
        return arrayList;
    }
}
